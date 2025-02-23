package org.example.fulkopingwebb.dao;

import org.example.fulkopingwebb.model.Loan;
import org.example.fulkopingwebb.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class LoanDAO {

    //Skapa loan
    public static void saveLoan(Loan loan) {
        Transaction tx = null;
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.persist(loan);
            tx.commit();
            session.close();
        }catch(Throwable e){
            if(tx != null){
                tx.rollback();
            }
            throw e;
        }
    }

    //Redigera loan
    public static void updateLoan(Loan loan) {
        Transaction tx = null;
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.merge(loan);
            tx.commit();
            session.close();
        }catch(Throwable e){
            if(tx != null){
                tx.rollback();
                throw e;
            }
        }
    }

    //Ta bort loan
    public void deleteLoan(Loan loan) {
        Transaction tx = null;
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.delete(loan);
            tx.commit();
            session.close();
        }catch(Throwable e){
            if(tx != null){
                tx.rollback();
                throw e;
            }
        }
    }

    //Se loans med ID
    public Loan getLoanById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Loan loan = session.get(Loan.class, id);
        return loan;
    }

    //Se alla loans
    public static List<Loan> getAllLoans() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Loan> loans = session.createQuery("from Loan").list();
        return loans;
    }

    //Get aktiva lån från en bok
    public static Loan getActiveLoan(int bookId) {
        Loan loan = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            loan = session.createQuery(
                            "SELECT l FROM Loan l " +
                                    "JOIN FETCH l.book " +
                                    "WHERE l.book.id = :bookId AND l.returned = false", Loan.class)
                    .setParameter("bookId", bookId)
                    .uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return loan;
    }


    public static List<Loan> getActiveLoansForUser(int userId) {
        List<Loan> loans = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Loan> query = session.createQuery(
                    "SELECT l FROM Loan l " +
                            "LEFT JOIN FETCH l.book " +  // Hämtar boken i samma fråga
                            "LEFT JOIN FETCH l.user " +  // Hämtar användaren i samma fråga
                            "WHERE l.user.id = :userId AND l.returned = false", Loan.class
            );

            query.setParameter("userId", userId);
            loans = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return loans;
    }




}
