package com.eneselibol.projectlibrary.Service;

import com.eneselibol.projectlibrary.Model.Author;

import java.util.List;

public interface AuthorService {
    List<Author> getAllAuthor();
    void saveAuthor(Author author);
    Author getAuthorById(Long id);
    void deleteAuthorById(Long id);
}
