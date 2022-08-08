package com.cts.jpahibernatedemo.ui;

import java.util.TreeSet;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cts.jpahibernatedemo.entity.Address;
import com.cts.jpahibernatedemo.entity.Course;
import com.cts.jpahibernatedemo.entity.Gender;
import com.cts.jpahibernatedemo.entity.LabComputer;
import com.cts.jpahibernatedemo.entity.Trainee;

public class App02 {

	public static void main(String[] args) {
		
		Course c1 = new Course(null, "Java FSD",new TreeSet<>());
		Course c2 = new Course(null, ".Net FSD",new TreeSet<>());

		Trainee t1 = new Trainee(null, "Vamsy", Gender.GENT,new Address("flat#9015","VSP","AP"), null, c1);
		t1.setComputer(new LabComputer(null,"P4,512GB,Windows",t1));
		
		Trainee t2 = new Trainee(null, "Lalitha", Gender.LADY,new Address("flat#9016","VSP","AP"), null, c1);
		t2.setComputer(new LabComputer(null,"P5,1TB,Windows",t2));
		
		Trainee t3 = new Trainee(null, "Sonum", Gender.LADY,new Address("flat#9016","VSP","AP"), null, c2);
		t3.setComputer(new LabComputer(null,"P4,512GB,Linux",t3));
		
		Trainee t4 = new Trainee(null, "Trupti", Gender.LADY,new Address("flat#9016","VSP","AP"), null, c2);
		t4.setComputer(new LabComputer(null,"P4,512GB,Linux",t4));
		
		c1.getTrainees().add(t1);
		c1.getTrainees().add(t2);
		c2.getTrainees().add(t3);
		c2.getTrainees().add(t4);
		
		EntityManager em = Persistence.createEntityManagerFactory("mysqlPU").createEntityManager();
		
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(c1);
		em.persist(c2);
		t.commit();
		em.clear();
	}

}
