package com.cts.spring.ioc.boot.demo.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("gma")
public class GreetServiceMultiLingualImpl implements GreetService {

	@Value("${greetings.array}")
	private String[] greetings;
	
	@Override
	public String greet(String userName) {
		return greetings==null ? "": 				
				Arrays.stream(greetings).
				map(g -> String.format("\n%s %s\n", g,userName)).
				reduce("", (s1,s2) -> s1.concat(s2));
	}

}
