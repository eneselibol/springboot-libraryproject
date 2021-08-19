package com.eneselibol.projectlibrary.Repository;

import com.eneselibol.projectlibrary.Model.Author;
import com.eneselibol.projectlibrary.Model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {
    @Query("SELECT u FROM Author u WHERE u.authorName = :authorName")
    public Author getAuthorByAuthorName(@Param("authorName") String authorName);
}
