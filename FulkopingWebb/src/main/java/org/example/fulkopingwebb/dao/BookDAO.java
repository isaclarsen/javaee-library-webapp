package org.example.fulkopingwebb.dao;

import org.example.fulkopingwebb.model.Book;
import org.example.fulkopingwebb.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class BookDAO {
    //Skapa bok
    public void saveBook(Book book) {
        Transaction tx = null;
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.persist(book);
            tx.commit();
            session.close();
        }catch(Throwable e){
            if(tx != null){
                tx.rollback();
                throw e;
            }
        }
    }

    //Redigera bok
    public void updateBook(Book book) {
        Transaction tx = null;
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.merge(book);
            tx.commit();
            session.close();
        }catch(Throwable e){
            if(tx != null){
                tx.rollback();
                throw e;
            }
        }
    }

    //Ta bort bok
    public void deleteBook(Book book) {
        Transaction tx = null;
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.delete(book);
            tx.commit();
            session.close();
        }catch(Throwable e){
            if(tx != null){
                tx.rollback();
                throw e;
            }
        }
    }

    //Se böcker med ID
    public Book getBookById(int id) {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Book book = session.get(Book.class, id);
            return book;
        }

    //Se alla böcker
    public static List<Book> getAllBooks() {
            Session session = HibernateUtil.getSessionFactory().openSession();
            List<Book> books = session.createQuery("from Book").list();
            return books;
        }
}
