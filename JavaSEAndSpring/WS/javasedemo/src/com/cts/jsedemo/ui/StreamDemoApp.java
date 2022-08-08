package com.cts.jsedemo.ui;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.cts.jsedemo.model.Employee;

public class StreamDemoApp {

	public static void main(String[] args) {
		List<Employee> emps = new ArrayList<>();

		emps.add(new Employee(112, "Vamsy", LocalDate.of(2022, Month.MARCH, 1), 56000));
		emps.add(new Employee(101, "Zinath", LocalDate.of(2021, Month.MARCH, 1), 60000));
		emps.add(new Employee(115, "Abhishek", LocalDate.of(2020, Month.MARCH, 1), 58000));
		emps.add(new Employee(106, "Komal", LocalDate.of(2002, Month.MARCH, 1), 86000));
		emps.add(new Employee(103, "Shyam", LocalDate.of(2022, Month.MARCH, 1), 96000));
		emps.add(new Employee(109, "Prasad", LocalDate.of(2012, Month.MARCH, 1), 46000));
		emps.add(new Employee(111, "Lalitha", LocalDate.of(2012, Month.MARCH, 1), 96000));
		emps.add(new Employee(167, "Prema", LocalDate.of(2022, Month.MARCH, 1), 26000));
		emps.add(new Employee(132, "Preethi", LocalDate.of(2021, Month.MARCH, 1), 76000));
		emps.add(new Employee(122, "Varun", LocalDate.of(2021, Month.MARCH, 1), 56000));
		
		emps.stream().forEach(e -> { System.out.println(e); });
		System.out.println("---------------------------------------------------------------------------");
		emps.stream().forEach(e -> { e.setSalary(e.getSalary() +(e.getSalary()*0.05)); });
		emps.stream().forEach(System.out::println);
		
		System.out.println("---------------------------------------------------------------------------");
		Employee seniorMost = emps.stream().reduce( (e1,e2) -> e1.getJoinDate().isBefore(e2.getJoinDate())?e1:e2 ).get();
		System.out.println(seniorMost);
		
		System.out.println("---------------------------------------------------------------------------");
		emps.stream().map(e -> e.getFullName()).forEach(System.out::println);
		
		System.out.println("---------------------------------------------------------------------------");
		Set<String> names = emps.stream().map(Employee::getFullName).collect(Collectors.toSet());
		//Set<String> names = emps.stream().map(e -> e.getFullName()).collect(Collectors.toSet());
		System.out.println(names);
		
		System.out.println("---------------------------------------------------------------------------");
		List<Employee> joinedIn2012 = emps.stream().filter(e -> e.getJoinDate().getYear()==2012).collect(Collectors.toList());
		System.out.println(joinedIn2012);
	}
}
