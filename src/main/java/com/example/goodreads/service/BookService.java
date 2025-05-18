package com.example.goodreads.service;

import java.util.*;
import com.example.goodreads.model.*;
import com.example.goodreads.repository.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;


@Service
public class BookService implements BookRepository{  

    @Autowired
    private JdbcTemplate db;

    @Override
    public ArrayList<Book> getPurchasedList(){
        List<Book> bookList = db.query("select * from book", new BookRowMapper());
        ArrayList<Book> list = new ArrayList<>(bookList);

        return list;
    }

    @Override
    public Book getPurchaseById(int id){
        Book b = db.queryForObject("select * from book where id = ?",new BookRowMapper(), id);
        return b;
    }

    @Override
    public Book addPurchasedItem(Book book){
        db.update("insert into book(name, price, type, purchaseDate) values (?, ?, ?, ?)", book.getName(), book.getPrice(), book.getType(), book.getDate());
        Book b = db.queryForObject("select * from book where name=? and price =? and type=?", new BookRowMapper(), book.getName(), book.getPrice(), book.getType());
        return b;
    }

    @Override
    public Book updatePurchasedItem(int id, Book book){
        Book oldOne = db.queryForObject("select * from book where id=?", new BookRowMapper(), id);
        if(oldOne == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        if(book.getName() != null){
            db.update("update book set name=? where id=?", book.getName(), id);
        }
        if(book.getPrice() != 0){
            db.update("update book set price=? where id=?", book.getPrice(), id);
        }
        if(book.getType() != null){
            db.update("update book set type=? where id=?", book.getType(), id);
        }
        if(book.getDate() != null){
            db.update("update book set purchasedDate=? where id=?", book.getDate(), id);
        }
        return getPurchaseById(id);
    }

    @Override
    public void deletePurchasedItem(int id){
        db.update("delete from book where id=?", id);
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }

}