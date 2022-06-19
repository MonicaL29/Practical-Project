package com.howtodoinjava.hibernate.test.dto;
import com.howtodoinjava.hibernate.test.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;

import java.util.List;
import java.util.Scanner;

    public class ClasaDAO {
        public void insertORUpdateClasa (Clasa clasa, Session session){
            session.beginTransaction();
            session.persist(clasa);
            session.getTransaction().commit();
        }

        public void deleteClasa( Clasa clasa,Session session){
            session.beginTransaction();
            session.delete(clasa);
            session.getTransaction().commit();
        }

        public List<Clasa> printClasa(Session session){
            session.beginTransaction();
            Query query = session.createQuery("from Clasa");
            session.getTransaction().commit();
            return query.getResultList();
        }

        public Clasa findByName(String numeClasa,Session session){
            session.beginTransaction();
            Query query = session.createQuery("from Clasa i where i.numeClasa=:x");
            query.setParameter("x",numeClasa);
            session.getTransaction().commit();
            return (Clasa) query.getResultList().get(0);
        }
    }


