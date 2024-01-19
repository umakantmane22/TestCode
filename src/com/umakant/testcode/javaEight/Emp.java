package com.umakant.testcode.javaEight;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.Set;
import java.util.stream.Collectors;

public class Emp {

	int id;
	String name;
	int age;
	String gender;
	String department;
	int yearOfJoining;
	double salary;

	private Emp() {
		super();
		// TODO Auto-generated constructor stub
	}

	private Emp(int id, String name, int age, String gender, String department, int yearOfJoining, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.department = department;
		this.yearOfJoining = yearOfJoining;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getYearOfJoining() {
		return yearOfJoining;
	}

	public void setYearOfJoining(int yearOfJoining) {
		this.yearOfJoining = yearOfJoining;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "EmpPractice [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", department="
				+ department + ", yearOfJoining=" + yearOfJoining + ", salary=" + salary + "]";
	}

	public static void main(String[] args) {

		List<Emp> empList = new ArrayList<Emp>();

		empList.add(new Emp(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
		empList.add(new Emp(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
		empList.add(new Emp(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
		empList.add(new Emp(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
		empList.add(new Emp(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
		empList.add(new Emp(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
		empList.add(new Emp(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
		empList.add(new Emp(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
		empList.add(new Emp(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
		empList.add(new Emp(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
		empList.add(new Emp(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
		empList.add(new Emp(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
		empList.add(new Emp(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
		empList.add(new Emp(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
		empList.add(new Emp(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
		empList.add(new Emp(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
		empList.add(new Emp(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));

		// 1: How many male and female employees are there in the organization?

		// 2: Print the name of all departments in the organization?

		// 3 : What is the average age of male and female employees?

		// 4 : Get the details of highest paid employee in the organization?

		// 5 : Get the names of all employees who have joined after 2015?

		// 6 : Count the number of employees in each department?

		// 7 : What is the average salary of each department?

		// 8 : Get the details of youngest male employee in the product development
		// department?

		// 9 : Who has the most working experience in the organization?

		// 10 : How many male and female employees are there in the sales and marketing
		// team?

		// 11 : What is the average salary of male and female employees?

		// 12 : List down the names of all employees in each department?

		// 13 : What is the average salary and total salary of the whole organization?

		// 14 : Separate the employees who are younger or equal to 25 years from those
		// employees who are older than 25 years.

		// 15 : Who is the oldest employee in the organization? What is his age and
		// which department he belongs to?

		// 16 find the smallest record based on age

		// 17: find the highest age of a employee details?

		// 18: find the largest record based on Salary

		// 19: find the second largest record based on Salary

		// 20: ascending sort based on age

		// 21: descending sort based on age

		// 22: ascending sort based on salary

		// 23: descending sort based on salary

		// 24: ascendingSortBasedOnName

		// 25: descendingSortBasedOnName

		// 26 ascending sort based on age and name

		// 27 ascending sort based on age and name and salary

		// 28 descending sort based on age and name and salary

		// 29 Find first ascending record based on age and name and salary

		// 30 Find Second ascending record based on age and name and salary

		// 31 Find first descending record based on age and name and salary

		// 32 Find Second descending record based on age and name and salary

		// 33 Find the average salary of employee

		// 34 find all the employee whose age is greater than 30

		// 35 count number of employees with age 30?

		// 36 find the employee with name “Manu”.

		// 37 find maximum age of employee?
		

		// 38 Join the all employee names with “,”


		// 39 group them by employee name

	
	}

}
