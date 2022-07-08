package com.cts.jpahibernatedemo.ui;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.cts.jpahibernatedemo.entity.Trainee;
import com.cts.jpahibernatedemo.entity.Trainer;

public class App04 {

	public static void main(String[] args) {
		
		EntityManager em = Persistence.createEntityManagerFactory("mysqlPU").createEntityManager();
		
		EntityTransaction t = em.getTransaction();

		System.out.println(em.find(Trainer.class, 123L));
		
		TypedQuery<Trainer> qry1 = em.createQuery("SELECT t FROM Trainer t", Trainer.class);
		qry1.getResultStream().forEach(System.out::println);
		
		TypedQuery<String> qry2 = em.createQuery("SELECT t.fullName FROM Trainer t", String.class);
		qry2.getResultStream().forEach(System.out::println);
		
		Query qry3 = em.createQuery("SELECT t.traienrId,t.fullName FROM Trainer t");
		for(Object row : qry3.getResultList()) {
			Object[] record = (Object[])row;
			System.out.println(record[0] + "\t" + record[1]);
		}
		
		//TypedQuery<Trainee> qry4 = em.createQuery("SELECT t FROM Trainee t WHERE t.address.city='VSP'", Trainee.class);
		//qry4.getResultStream().forEach(System.out::println);
		
		TypedQuery<Trainee> qry4 = em.createQuery("SELECT t FROM Trainee t WHERE t.address.city=:city", Trainee.class);
		qry4.setParameter("city", "VSP");
		qry4.getResultStream().forEach(System.out::println);
		
		Query qry5 = em.createQuery("SELECT t.fullName,c.crName FROM Trainee t INNER JOIN Course c ON t.course=c");
		for(Object row : qry5.getResultList()) {
			Object[] record = (Object[])row;
			System.out.println(record[0] + "\t" + record[1]);
		}
		
		Query qry6 = em.createQuery("SELECT t.fullName,t.course.crName FROM Trainee t");
		for(Object row : qry6.getResultList()) {
			Object[] record = (Object[])row;
			System.out.println(record[0] + "\t" + record[1]);
		}
		
		em.clear();
	}

}
