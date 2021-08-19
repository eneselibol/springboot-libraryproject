package com.eneselibol.projectlibrary.Service;

import com.eneselibol.projectlibrary.Model.Book;
import com.eneselibol.projectlibrary.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public void saveBook(Book book) {
        this.bookRepository.save(book);
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.getById(id);
    }

    @Override
    public void deleteBookById(Long id) {
        this.bookRepository.deleteById(id);
    }

    @Override
    public List<Book> getKeywordBooks(String keyword) {
        if(keyword!= null){
            return bookRepository.findByKeyword(keyword);
        }
        return bookRepository.findAll();
    }
}
