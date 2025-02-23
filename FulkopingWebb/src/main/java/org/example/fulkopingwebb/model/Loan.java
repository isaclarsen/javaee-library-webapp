package org.example.fulkopingwebb.model;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;
import java.util.Date;

//Skapar tabellen loan med kolumner
@Entity
@Table(name = "Loan")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    //Skapar kolumner för foreign key
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "bookId")
    private Book book;

    //Skapar kolumner för foreign key
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId")
    private User user;

    @Column(name = "loanDate")
    @Temporal(TemporalType.DATE)
    private Date loanDate;


    @Column(name = "returnDate")
    @Temporal(TemporalType.DATE)
    private Date returnDate;

    @Column(name = "returned")
    @ColumnDefault("false")
    private boolean returned;

    public Loan(){
        LocalDate loanDate = LocalDate.now();
        LocalDate returnDate = LocalDate.now().plusDays(30);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(Date loanDate) {
        this.loanDate = loanDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public boolean isReturned() {
        return returned;
    }

    public void setReturned(boolean returned) {
        this.returned = returned;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "id=" + id +
                ", book=" + book +
                ", user=" + user +
                ", loanDate=" + loanDate +
                ", returnDate=" + returnDate +
                '}';
    }
}
