package com.cts.spring.ioc.boot.demo.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("gma2")
public class GreetServiceMultiLingualImpl2 implements GreetService {

	@Value("#{${greetings.list}}")
	private List<String> greetings;
	
	@Override
	public String greet(String userName) {
		return greetings==null ? "": 				
				greetings.stream().
				map(g -> String.format("\n%s %s\n", g,userName)).
				reduce("", (s1,s2) -> s1.concat(s2));
	}

}
