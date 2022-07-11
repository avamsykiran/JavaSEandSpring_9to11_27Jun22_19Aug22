package com.cts.spring.iocdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cts.spring.iocdemo.ui.HomeUI;

public class IocDemoApplication {

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
		
		System.out.println(context.getBean("today"));
		
		HomeUI ui = (HomeUI) context.getBean("homeUI");
		ui.run();
	}

}
