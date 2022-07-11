package com.cts.spring.iocdemo.ui;

import org.springframework.stereotype.Component;

@Component
public class HomeUI {

	private String applkicationName="My first spring app";
	
	public void run() {
		System.out.println(applkicationName);
	}
}
