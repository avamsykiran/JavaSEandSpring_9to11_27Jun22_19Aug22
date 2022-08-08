package com.cts.jpahibernatedemo.ui;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cts.jpahibernatedemo.entity.Course;

public class App01 {

	public static void main(String[] args) {

		Course[] courses = new Course[] { 
				new Course(null, "JavaSE"),
				new Course(null, "Hibernate JPA"),
				new Course(null, "Spring Core"),
				new Course(null, "Spring Web"),
				new Course(null, "Spring REST")
			};

		EntityManager em = Persistence.createEntityManagerFactory("mysqlPU").createEntityManager();
		
		EntityTransaction t = em.getTransaction();
		t.begin();
		for(Course c : courses) {
			em.persist(c);
		}
		t.commit();
		em.clear();
	}

}
