package com.eneselibol.projectlibrary.Service;

import com.eneselibol.projectlibrary.Model.Author;
import com.eneselibol.projectlibrary.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService{

    @Autowired
    AuthorRepository authorRepository;

    @Override
    public List<Author> getAllAuthor() {
        return authorRepository.findAll();
    }

    @Override
    public void saveAuthor(Author author) {
        this.authorRepository.save(author);
    }

    @Override
    public Author getAuthorById(Long id) {
        return authorRepository.getById(id);
    }

    @Override
    public void deleteAuthorById(Long id) {
        this.authorRepository.deleteById(id);
    }
}
