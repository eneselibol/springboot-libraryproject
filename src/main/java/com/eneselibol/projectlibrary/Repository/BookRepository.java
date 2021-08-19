package com.eneselibol.projectlibrary.Repository;

import com.eneselibol.projectlibrary.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("SELECT p FROM Book p WHERE "
            + "CONCAT(p.bookName, p.bookSerialName, p.bookIsbn, p.author.authorName, p.publisher.publisherName)"
            + " LIKE %?1%")
    public List<Book> findByKeyword(String keyword);
}
