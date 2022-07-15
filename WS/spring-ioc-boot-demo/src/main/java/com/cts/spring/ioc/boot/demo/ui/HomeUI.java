package com.cts.spring.ioc.boot.demo.ui;

import java.util.Scanner;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.cts.spring.ioc.boot.demo.service.Counter;
import com.cts.spring.ioc.boot.demo.service.GreetService;

@Component
public class HomeUI implements CommandLineRunner {

	@Value("${app.title:My first spring app}")
	private String applkicationName;
	
	@Autowired
	private Scanner scan;

	@Autowired
	@Qualifier("gss")
	private GreetService greetService1;
	
	@Autowired
	@Qualifier("gsa")
	private GreetService greetService2;
	
	@Autowired
	@Qualifier("gma")
	private GreetService greetService3;
	
	@Autowired
	@Qualifier("gma2")
	private GreetService greetService4;
	
	@Autowired
	private Counter c1;
	
	@Autowired
	private Counter c2;
	
	@Autowired
	private Counter c3;
	
	@Autowired
	private Counter c4;
	
	public HomeUI() {
		System.out.println("the object of HomeUI is constructed");
		System.out.println(scan);
		System.out.println(greetService1);
		System.out.println(greetService2);
	}
	
	@PostConstruct
	public void afterIniting() {
		System.out.println("The homeUI bean is initialized");
		System.out.println(scan);
		System.out.println(greetService1);
		System.out.println(greetService2);
	}
	
	@PreDestroy
	public void beforeKilling() {
		System.out.println("The bean is going to be destroyed");
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(applkicationName);
		
		System.out.println("Your Name: ");
		String userName = scan.next();
		
		System.out.println(greetService1.greet(userName));
		System.out.println(greetService2.greet(userName));
		System.out.println(greetService3.greet(userName));
		System.out.println(greetService4.greet(userName));
		
		System.out.println(c1.next());
		System.out.println(c2.next());
		System.out.println(c3.next());
		System.out.println(c4.next());
	}

}
