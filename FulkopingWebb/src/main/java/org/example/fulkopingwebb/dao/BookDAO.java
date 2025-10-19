package org.example.fulkopingwebb.dao;

import org.example.fulkopingwebb.model.Book;
import org.example.fulkopingwebb.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

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

    public List<Book> searchBooks(String query) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        //Om man söker tomt så ska man meddelas att man behöver söka efter något (FIXA)
        if (query == null || query.length() == 0) {
            return null;
        }
        try{
            Query<Book> hqlQuery = session.createQuery(
                    "FROM Book WHERE title LIKE :query OR genre LIKE :query OR author LIKE :query", Book.class
            );
            hqlQuery.setParameter("query", "%" + query + "%");
            return hqlQuery.getResultList();
        }finally{
            session.close();
        }
    }

    //Se alla böcker
    public static List<Book> getAllBooks() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Book> books = session.createQuery("SELECT b FROM Book b LEFT JOIN FETCH b.loans", Book.class).list();
        session.close();
        return books;
    }



    public Book getBookWithActiveLoan(int bookId) {
        Book book = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            book = session.createQuery(
                            "SELECT DISTINCT b FROM Book b " +
                                    "LEFT JOIN FETCH b.loans " +
                                    "WHERE b.id = :id", Book.class)
                    .setParameter("id", bookId)
                    .uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return book;
    }






}
