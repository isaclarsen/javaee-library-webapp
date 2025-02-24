package org.example.fulkopingwebb.model;


import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.List;

//Skapar tabellen book med kolumner
@Entity
@Table(name = "Book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name= "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name =  "genre")
    private String genre;

    @Column(name = "available")
    @ColumnDefault("true")
    private boolean available;

    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY)
    private List<Loan> loans;

    public Book(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }


    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public List<Loan> getLoans() {
        return loans;
    }

    public void setLoans(List<Loan> loans) {
        this.loans = loans;
    }
}
