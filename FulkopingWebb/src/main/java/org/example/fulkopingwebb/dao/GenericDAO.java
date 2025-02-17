package org.example.fulkopingwebb.dao;

import org.example.fulkopingwebb.model.Book;
import org.example.fulkopingwebb.model.Loan;
import org.example.fulkopingwebb.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.util.List;

//SKAPA SENARE
//public class GenericDAO<T, ID extends Serializable> {
//
//    private final Class<T> persistentClass;
//
//    public GenericDAO(Class<T> persistentClass) {
//        this.persistentClass = persistentClass;
//    }
//
//    public void save(T entity) {
//        Transaction tx = null;
//        try {
//            Session session = HibernateUtil.getSessionFactory().openSession();
//            tx = session.beginTransaction();
//            session.persist(entity);
//            tx.commit();
//        } catch (Throwable e) {
//            if (tx != null) {
//                tx.rollback();
//                throw e;
//            }
//        }
//    }
//
//    public void update(T entity) {
//        Transaction tx = null;
//        try {
//            Session session = HibernateUtil.getSessionFactory().openSession();
//            tx = session.beginTransaction();
//            session.merge(entity);
//            tx.commit();
//        } catch (Throwable e) {
//            if (tx != null) tx.rollback();
//            throw e;
//        }
//    }
//
//    public void delete(T entity) {
//        Transaction tx = null;
//        try {
//            Session session = HibernateUtil.getSessionFactory().openSession();
//            tx = session.beginTransaction();
//            session.delete(entity);
//            tx.commit();
//        } catch (Throwable e) {
//            if (tx != null) tx.rollback();
//            throw e;
//        }
//    }
//
//    //READ
//    public List<T> findAll(ID id) {
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        Query<T> query = session.createQuery("FROM " + persistentClass.getSimpleName(), persistentClass);
//        return query.list();
//    }
//
//    public T findById(ID id, Loan owner) {
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        Query<T> query = session.createQuery("FROM "+persistentClass.getSimpleName()+" pc WHERE pc.id = :id AND pc.user.id = :ownerId", persistentClass);
//        query.setParameter("ownerId", owner.getId());
//        query.setParameter("id", id);
//        List<T> results = query.list();
//        T o = null;
//        if(results.size() == 1) {
//            o = results.getFirst();
//        }
//        session.close();
//        return o;
//    }
//
//}
