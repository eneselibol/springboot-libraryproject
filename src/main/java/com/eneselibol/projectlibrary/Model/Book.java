package com.eneselibol.projectlibrary.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_id")
    private long bookId;

    @Column(name = "book_name")
    private String bookName;

    @Column(name = "book_subname")
    private String bookSubName;

    @Column(name = "book_serialname")
    private String bookSerialName;

    @Column(name = "book_isbn")
    private long bookIsbn;

    @Column(name = "book_explanation")
    private String bookExplanation;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

}
