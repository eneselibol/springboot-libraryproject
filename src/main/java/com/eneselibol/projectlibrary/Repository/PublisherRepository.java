package com.eneselibol.projectlibrary.Repository;

import com.eneselibol.projectlibrary.Model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher,Long> {
    @Query("SELECT u FROM Publisher u WHERE u.publisherName = :publisherName")
    public Publisher getPublisherByPublisherName(@Param("publisherName") String publisherName);
}
