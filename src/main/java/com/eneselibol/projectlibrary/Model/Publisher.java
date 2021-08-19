package com.eneselibol.projectlibrary.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "publisher")
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "publisher_id")
    private long publisherId;

    @Column(name = "publisher_name")
    private String publisherName;

    @Column(name = "publisher_explanation")
    private String publisherExplanation;

    @OneToMany(mappedBy = "publisher",cascade = CascadeType.MERGE)
    private List<Book> books;
}
