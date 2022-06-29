package com.cts.jsedemo.ui;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.cts.jsedemo.model.Employee;
import com.cts.jsedemo.util.EmployeeComparator;

public class ListDemoApp {

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

		System.out.println(emps.size());

		for (Employee emp : emps)
			System.out.println(emp);

		System.out.println("-----------------------------------------------------------------------");

		Collections.sort(emps);
		for (Employee emp : emps)
			System.out.println(emp);

		System.out.println("-----------------------------------------------------------------------");

		Collections.sort(emps,new EmployeeComparator());
		for (Employee emp : emps)
			System.out.println(emp);

	}

}
