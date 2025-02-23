package org.example.fulkopingwebb.dao;

import org.example.fulkopingwebb.model.Loan;
import org.example.fulkopingwebb.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

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

    //Get aktiva lån från en anv
    public static Loan getActiveLoan( int bookId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Loan loan = (Loan) session.createQuery("from Loan where book.id = :bookId and returned = false")
                .setParameter("bookId", bookId)
                .uniqueResult();
        session.close();
        return loan;
    }

}
