
package com.example.goodreads.repository;

import com.example.goodreads.model.Book;
import java.util.*;

public interface BookRepository{
    ArrayList<Book> getPurchasedList();
    
    Book getPurchaseById(int id);

    Book addPurchasedItem(Book book);

    Book updatePurchasedItem(int id, Book book);

    void deletePurchasedItem(int id);
}
