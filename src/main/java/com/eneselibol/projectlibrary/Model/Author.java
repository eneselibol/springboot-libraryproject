package com.eneselibol.projectlibrary.Model;

import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "author_id")
    private long authorId;

    @Column(name = "author_name")
    private String authorName;

    @Column(name = "author_explanation")
    private String authorExplanation;

    @OneToMany(mappedBy = "author",cascade = CascadeType.MERGE)
    private List<Book> books;
}
