package com.cts.jsedemo.util;

import java.util.Comparator;

import com.cts.jsedemo.model.Employee;

public class EmployeeComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getFullName().compareTo(o2.getFullName());
	}

}
