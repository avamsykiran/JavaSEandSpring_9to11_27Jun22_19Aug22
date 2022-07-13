package com.cts.spring.iocdemo.service;

import org.springframework.stereotype.Service;

@Service("gss")
public class GreetServiceSimpleImpl implements GreetService {

	@Override
	public String greet(String userName) {
		return String.format("Hai %s", userName);
	}

}
