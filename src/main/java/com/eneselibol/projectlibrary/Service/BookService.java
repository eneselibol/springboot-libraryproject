package com.eneselibol.projectlibrary.Service;

import com.eneselibol.projectlibrary.Model.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();
    void saveBook(Book book);
    Book getBookById(Long id);
    void deleteBookById(Long id);
    List<Book> getKeywordBooks(String keyword);
}
