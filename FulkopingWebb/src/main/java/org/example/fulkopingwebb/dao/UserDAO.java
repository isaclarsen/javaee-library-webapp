package org.example.fulkopingwebb.dao;

import org.example.fulkopingwebb.model.User;
import org.example.fulkopingwebb.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserDAO {
    //Skapa User
    public void saveUser(User user) {
        Transaction tx = null;
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.persist(user);
            tx.commit();
            session.close();
        }catch(Throwable e){
            if(tx != null){
                tx.rollback();
                throw e;
            }
        }
    }

    //Redigera User
    public void updateUser(User user) {
        Transaction tx = null;
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.merge(user);
            tx.commit();
            session.close();
        }catch(Throwable e){
            if(tx != null){
                tx.rollback();
                throw e;
            }
        }
    }

    //Ta bort User
    public void deleteBook(User user) {
        Transaction tx = null;
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.delete(user);
            tx.commit();
            session.close();
        }catch(Throwable e){
            if(tx != null){
                tx.rollback();
                throw e;
            }
        }
    }

    //Se User med ID
    public User getUserById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        User user = session.get(User.class, id);
        return user;
    }

    //Se alla Users
    public static List<User> getAllUsers() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<User> users = session.createQuery("from User").list();
        return users;
    }
}
