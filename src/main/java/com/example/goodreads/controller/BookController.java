package com.example.goodreads.controller;

import org.springframework.web.bind.annotation.*;
import com.example.goodreads.model.Book;
import com.example.goodreads.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

@RestController
public class BookController{

    @Autowired
    private BookService bs;

    @GetMapping("/books")
    public ArrayList<Book> getPurchasedList(){
        return bs.getPurchasedList();
    }

    @GetMapping("/books/{bookId}")
    public Book getPurchaseById(@PathVariable("bookId") int bookId){
        return bs.getPurchaseById(bookId);
    }

    @PostMapping("/books")
    public Book addPurchasedItem(@RequestBody Book book){
        return bs.addPurchasedItem(book);
    }

    @PutMapping("/books/{bookId}")
    public Book updatePurchasedItem(@PathVariable("bookId") int bookId, @RequestBody Book book){
        return bs.updatePurchasedItem(bookId, book);
    }

    @DeleteMapping("/books/{bookId}")
    public void deletePurchasedItem(@PathVariable("bookId") int bookId){
        bs.deletePurchasedItem(bookId);
    }
}