package com.cts.jpahibernatedemo.ui;

import java.util.TreeSet;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cts.jpahibernatedemo.entity.AcademicHead;
import com.cts.jpahibernatedemo.entity.Address;
import com.cts.jpahibernatedemo.entity.ContractTrainer;
import com.cts.jpahibernatedemo.entity.Course;
import com.cts.jpahibernatedemo.entity.Gender;
import com.cts.jpahibernatedemo.entity.LabComputer;
import com.cts.jpahibernatedemo.entity.Trainee;
import com.cts.jpahibernatedemo.entity.Trainer;

public class App03 {

	public static void main(String[] args) {
		
		EntityManager em = Persistence.createEntityManagerFactory("mysqlPU").createEntityManager();
		
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(new Trainer(123L, "Srinivas", new Address("1234", "VSP", "AP"), "JAVA", 4567.0));
		em.persist(new ContractTrainer(234L, "Suseela", new Address("45", "VSP", "AP"),"Dot Net", 5678.0, 12.5));
		em.persist(new AcademicHead(456L, "Uma", new Address("44", "VSP", "AP"), "Mainframes", 12343.0, 345.0));
		t.commit();
		em.clear();
	}

}
