package com.umakant.testcode.javaEight;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.DoubleSummaryStatistics;

public class Employee {
	int id;
	String name;
	int age;
	String gender;
	String department;
	int yearOfJoining;
	double salary;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int id, String name, int age, String gender, String department, int yearOfJoining, double salary) {
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
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", department="
				+ department + ", yearOfJoining=" + yearOfJoining + ", salary=" + salary + "]";
	}

	public static void main(String[] args) {
		List<Employee> employeeList = new ArrayList<Employee>();

		employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
		employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
		employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
		employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
		employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
		employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
		employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
		employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
		employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
		employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
		employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
		employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
		employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
		employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
		employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
		employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
		employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));

//		System.out.println("Original employeeList :: " + employeeList);

		// 1: How many male and female employees are there in the organization?

		Map<String, Long> noOfMaleAndFemaleEmployees = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));

		System.out.println("noOfMaleAndFemaleEmployees: " + noOfMaleAndFemaleEmployees);

		// 2: Print the name of all departments in the organization?

		List<String> deptList1 = employeeList.stream().map(d -> d.department).distinct().collect(Collectors.toList());
		System.out.println("deptList1: " + deptList1);

		List<String> deptList2 = employeeList.stream().map(Employee::getDepartment).distinct()
				.collect(Collectors.toList());
//		System.out.println("deptList2: "+deptList2);
		// Or
//				employeeList.stream().map(Employee::getDepartment).distinct().forEach(System.out::println);

		// 3 : What is the average age of male and female employees?
		Map<String, Double> avgAgeOfMaleAndFemaleEmployees = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getAge)));
		System.out.println("avgAgeOfMaleAndFemaleEmployees: " + avgAgeOfMaleAndFemaleEmployees);

		// 4 : Get the details of highest paid employee in the organization?
		Optional<Employee> highestPaidEmployeeWrapper1 = employeeList.stream()
				.max(Comparator.comparing(Employee::getSalary));
		System.out.println("highestPaidEmployeeWrapper1: " + highestPaidEmployeeWrapper1.get());

		Optional<Employee> highestPaidEmployeeWrapper2 = employeeList.stream()
				.sorted(Comparator.comparing(Employee::getSalary).reversed()).findFirst();
		System.out.println("highestPaidEmployeeWrapper2: " + highestPaidEmployeeWrapper2);

		Optional<Employee> highestPaidEmployeeWrapper = employeeList.stream()
				.collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));
		System.out.println(highestPaidEmployeeWrapper);
		Employee highestPaidEmployee = highestPaidEmployeeWrapper.get();
		System.out.println("Id: " + highestPaidEmployee.getId() + " Name: " + highestPaidEmployee.getName() + " Age: "
				+ highestPaidEmployee.age + " Gender: " + highestPaidEmployee.gender + " Dep: "
				+ highestPaidEmployee.department + " Yr of joining: " + highestPaidEmployee.yearOfJoining + " Salary: "
				+ highestPaidEmployee.salary);

		// 5 : Get the names of all employees who have joined after 2015?

		List<String> joiningAfter2015Name = employeeList.stream().filter(e -> e.yearOfJoining > 2015)
				.map(Employee::getName).collect(Collectors.toList());
		System.out.println("joiningAfter2015Name: " + joiningAfter2015Name);

		// 6 : Count the number of employees in each department?
		Map<String, Long> employeeCountByDepartment = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
		System.out.println("employeeCountByDepartment: " + employeeCountByDepartment);

		// Or
//			 employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting())).entrySet().forEach(e->System.out.println(e.getKey()+" "+e.getValue()));

		// 7 : What is the average salary of each department?
		Map<String, Double> avgSalaryOfDepartments = employeeList.stream().collect(
				Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));

		System.out.println("avgSalaryOfDepartments: " + avgSalaryOfDepartments);
		// or
//		employeeList.stream()
//				.collect(
//						Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)))
//				.entrySet().forEach(System.out::println);
		// Or
//		employeeList.stream()
//				.collect(
//						Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)))
//				.entrySet().forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
		// 8 : Get the details of youngest male employee in the product development
		// department?

		Optional<Employee> youngestMaleEmployeeInProductDevelopmentWrapper1 = employeeList.stream()
				.filter(e -> e.getGender().equalsIgnoreCase("male")
						&& e.getDepartment().equalsIgnoreCase("Product Development"))
				.sorted((e1, e2) -> e1.age - e2.age).findFirst();
		System.out.println("youngestMaleEmployeeInProductDevelopmentWrapper1: "
				+ youngestMaleEmployeeInProductDevelopmentWrapper1);

		Optional<Employee> youngestMaleEmployeeInProductDevelopmentWrapper2 = employeeList.stream()
				.filter(e -> e.getGender().equalsIgnoreCase("male")
						&& e.getDepartment().equalsIgnoreCase("Product Development"))
				.min(Comparator.comparing(Employee::getAge));
		System.out.println("youngestMaleEmployeeInProductDevelopmentWrapper2: "
				+ youngestMaleEmployeeInProductDevelopmentWrapper2);

		Optional<Employee> youngestMaleEmployeeInProductDevelopmentWrapper = employeeList.stream()
				.filter(e -> e.getGender().equalsIgnoreCase("male")
						&& e.getDepartment().equalsIgnoreCase("Product Development"))
				.min(Comparator.comparing(Employee::getAge));

		System.out.println(youngestMaleEmployeeInProductDevelopmentWrapper.get());
		Employee youngestMaleEmployeeInProductDevelopment = youngestMaleEmployeeInProductDevelopmentWrapper.get();

		System.out.println("ID : " + youngestMaleEmployeeInProductDevelopment.getId());
		System.out.println("Name : " + youngestMaleEmployeeInProductDevelopment.getName());
		System.out.println("Age : " + youngestMaleEmployeeInProductDevelopment.getAge());
		System.out.println("Year Of Joinging : " + youngestMaleEmployeeInProductDevelopment.getYearOfJoining());
		System.out.println("Salary : " + youngestMaleEmployeeInProductDevelopment.getSalary());

		// 9 : Who has the most working experience in the organization?
		Optional<Employee> seniorMostEmployeeWrapperFindForst = employeeList.stream()
				.sorted(Comparator.comparingInt(Employee::getYearOfJoining)).findFirst();
		System.out.println("seniorMostEmployeeWrapperFindForst:" + seniorMostEmployeeWrapperFindForst);
		// Or
		Optional<Employee> seniorMostEmployeeWrapper = employeeList.stream()
				.min(Comparator.comparing(Employee::getYearOfJoining));
		System.out.println("seniorMostEmployeeWrapper: " + seniorMostEmployeeWrapper);

		Employee seniorMostEmployee = seniorMostEmployeeWrapper.get();
		System.out.println("ID : " + seniorMostEmployee.getId());
		System.out.println("Name : " + seniorMostEmployee.getName());
		System.out.println("Age : " + seniorMostEmployee.getAge());
		System.out.println("Gender : " + seniorMostEmployee.getGender());
		System.out.println("Age : " + seniorMostEmployee.getDepartment());
		System.out.println("Year Of Joinging : " + seniorMostEmployee.getYearOfJoining());
		System.out.println("Salary : " + seniorMostEmployee.getSalary());

		// 10 : How many male and female employees are there in the sales and marketing
		// team?
		Map<String, Long> countMaleFemaleEmployeesInSalesMarketing = employeeList.stream()
				// .filter(e -> e.getDepartment().equalsIgnoreCase("Sales And Marketing"))
				.filter(e -> e.getDepartment() == "Sales And Marketing")
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		System.out.println("countMaleFemaleEmployeesInSalesMarketing:" + countMaleFemaleEmployeesInSalesMarketing);

		// 11 : What is the average salary of male and female employees?
		Map<String, Double> avgSalaryOfMaleAndFemaleEmployees = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
		System.out.println("avgSalaryOfMaleAndFemaleEmployees: " + avgSalaryOfMaleAndFemaleEmployees);

		// 12 : List down the names of all employees in each department?

		Map<String, List<Employee>> sortBasedOnDepartment = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment));
		System.out.println("sortBasedOnDepartment: " + sortBasedOnDepartment);
		Map<String, List<Employee>> employeeListByDepartment = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment));

		Set<Entry<String, List<Employee>>> entrySet = employeeListByDepartment.entrySet();
		for (Entry<String, List<Employee>> entry : entrySet) {
			System.out.println("--------------------------------------");

			System.out.println("Employees In " + entry.getKey() + " : ");

			System.out.println("--------------------------------------");

			List<Employee> list = entry.getValue();

			for (Employee e : list) {
//				 System.out.println(e.getName());
			}
		}
//		System.out.println("____________________________________________");
		employeeListByDepartment.entrySet()
				// .forEach(System.out::println);
				// .forEach(e->System.out.println(e.getKey() ));
				.forEach(e -> System.out.println(e.getKey() + " " + e.getValue()));

		// 13 : What is the average salary and total salary of the whole organization?

		DoubleSummaryStatistics employeeSalaryStatistics = employeeList.stream()
				.collect(Collectors.summarizingDouble(Employee::getSalary));
		System.out.println("employeeSalaryStatistics: " + employeeSalaryStatistics);
		System.out.println("employeeSalaryStatistics count: " + employeeSalaryStatistics.getCount());
		System.out.println("employeeSalaryStatistics sum: " + employeeSalaryStatistics.getSum());
		System.out.println("employeeSalaryStatistics min: " + employeeSalaryStatistics.getMin());
		System.out.println("employeeSalaryStatistics average: " + employeeSalaryStatistics.getAverage());
		System.out.println("employeeSalaryStatistics max: " + employeeSalaryStatistics.getMax());

		// 14 : Separate the employees who are younger or equal to 25 years from those
		// employees who are older than 25 years.
		Map<Boolean, List<Employee>> partitionEmployeesByAge = employeeList.stream()
				.collect(Collectors.partitioningBy(e -> e.getAge() > 25));

		Set<Entry<Boolean, List<Employee>>> entrySet2 = partitionEmployeesByAge.entrySet();

		for (Entry<Boolean, List<Employee>> entry : entrySet2) {
			System.out.println("----------------------------");

			if (entry.getKey()) {
				System.out.println("Employees older than 25 years :");
			} else {
				System.out.println("Employees younger than or equal to 25 years :");
			}

			System.out.println("----------------------------");

			List<Employee> list = entry.getValue();

			for (Employee e : list) {
				System.out.println(e.getName());
			}
		}

		// 15 : Who is the oldest employee in the organization? What is his age and
		// which department he belongs to?
		Optional<Employee> oldestEmployeeWrapper = employeeList.stream().max(Comparator.comparingInt(Employee::getAge));
		Employee oldestEmployee = oldestEmployeeWrapper.get();
		System.out.println("Name : " + oldestEmployee.getName());
		System.out.println("Age : " + oldestEmployee.getAge());
		System.out.println("Department : " + oldestEmployee.getDepartment());

		// 16: find the smallest record based on age

		Optional<Employee> smallestRecordBasedOnAge1 = employeeList.stream()
				.sorted((e1, e2) -> e1.getAge() - e2.getAge()).findFirst();
		System.out.println("smallestRecordBasedOnAge1: " + smallestRecordBasedOnAge1);

		Optional<Employee> smallestRecordBasedOnAge2 = employeeList.stream().sorted((e1, e2) -> e1.age - e2.age)
				.findFirst();
		System.out.println("smallestRecordBasedOnAge2: " + smallestRecordBasedOnAge2);

		Optional<Employee> smallestRecordBasedOnAge3 = employeeList.stream()
				.sorted(Comparator.comparing(Employee::getAge)).findFirst();
		System.out.println("smallestRecordBasedOnAge3: " + smallestRecordBasedOnAge3);

		Optional<Employee> smallestRecordBasedOnAge4 = employeeList.stream()
				.min(Comparator.comparing(Employee::getAge));
		System.out.println("smallestRecordBasedOnAge4: " + smallestRecordBasedOnAge4);

		// 17: find the highest age of a employee details?

		Optional<Employee> highestAgedEmpDtlsUseOption = employeeList.stream()
				.sorted(Comparator.comparing(Employee::getAge).reversed()).findFirst();
		System.out.println("highestAgedEmpDtlsUseOption: " + highestAgedEmpDtlsUseOption.get());
		
		Optional<Employee> largestRecordBasedOnAge1=employeeList.stream()
				.max(Comparator.comparing(Employee::getAge));
		System.out.println("largestRecordBasedOnAge1: "+largestRecordBasedOnAge1);

		Optional<Employee> largestRecordBasedOnAge2=employeeList.stream()
		.sorted((e1,e2)->e2.getAge()-e1.getAge())
		.findFirst();
		System.out.println("largestRecordBasedOnAge2: "+largestRecordBasedOnAge2);

		

		// 18: find the largest record based on Salary
		// way 1:

		Optional<Employee> largestRecoedBasedOnSalary = employeeList.stream()
				.sorted(Comparator.comparing(Employee::getSalary).reversed()).findFirst();

		System.out.println("largestRecoedBasedOnSalary: " + largestRecoedBasedOnSalary);

		// way 2:
		Optional<Employee> highestSalAmountEmpDtls = employeeList.stream()

				.max(Comparator.comparing(Employee::getSalary));

		System.out.println("highestSalAmountEmpDtls=>" + highestSalAmountEmpDtls);

		// way 3:
		Optional<Employee> highestSalAmountEmpWrapper = employeeList.stream()
				.collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));
		System.out.println("highestSalAmountEmpWrapper: " + highestSalAmountEmpWrapper);

		// 19: find the SECOND largest record based on Salary
		Optional<Employee> secondLargestRecoedBasedOnSalary = employeeList.stream()
				.sorted(Comparator.comparing(Employee::getSalary).reversed()).skip(1).findFirst();
		System.out.println("secondLargestRecoedBasedOnSalary: " + secondLargestRecoedBasedOnSalary);

		// 20: ascending sort based on age
		// way 1
		List<Employee> ascSortBasedOnAge1 = employeeList.stream().sorted(Comparator.comparing(Employee::getAge))
				.collect(Collectors.toList());
		System.out.println("ascSortBasedOnAge1: " + ascSortBasedOnAge1);
		// way 2
		List<Employee> ascSortBasedOnAge2 = employeeList.stream().sorted((e1, e2) -> e1.age - e2.age)
				.collect(Collectors.toList());
//						System.out.println("ascSortBasedOnAge2: " + ascSortBasedOnAge2);
		// 21: descending sort based on age
		// way 1
		List<Employee> descSortBasedOnAge1 = employeeList.stream()
				.sorted(Comparator.comparing(Employee::getAge).reversed()).collect(Collectors.toList());
		System.out.println("descSortBasedOnAge1: " + descSortBasedOnAge1);
		// way 2
		List<Employee> descSortBasedOnAge2 = employeeList.stream().sorted((e1, e2) -> e2.age - e1.age)
				.collect(Collectors.toList());
		System.out.println("descSortBasedOnAge2: " + descSortBasedOnAge2);

		// 22: ascending sort based on salary
		// way 1
		List<Employee> ascSortBasedOnSalary1 = employeeList.stream().sorted(Comparator.comparing(Employee::getSalary))
				.collect(Collectors.toList());
		System.out.println("ascSortBasedOnSalary1: " + ascSortBasedOnSalary1);
		// way 2
		List<Employee> ascSortBasedOnSalary2 = employeeList.stream()
				.sorted((e1, e2) -> (int) (e1.getSalary() - e2.getSalary())).collect(Collectors.toList());
		System.out.println("ascSortBasedOnSalary2: " + ascSortBasedOnSalary2);

		// 23: descending sort based on salary
		// way 1
		List<Employee> descSortBasedOnSalary1 = employeeList.stream()
				.sorted(Comparator.comparing(Employee::getSalary).reversed()).collect(Collectors.toList());
		System.out.println("descSortBasedOnSalary1: " + descSortBasedOnSalary1);
		// way 2
		List<Employee> descSortBasedOnSalary2 = employeeList.stream()
				.sorted((e1, e2) -> (int) (e2.getSalary() - e1.getSalary())).collect(Collectors.toList());
		System.out.println("descSortBasedOnSalary2: " + descSortBasedOnSalary2);

//		 24: ascendingSortBasedOnName
		// way 1
		List<Employee> ascendingSortBasedOnName1 = employeeList.stream().sorted(Comparator.comparing(Employee::getName))
				.collect(Collectors.toList());
		System.out.println("ascendingSortBasedOnName1: " + ascendingSortBasedOnName1);
		// way 2
		List<Employee> ascendingSortBasedOnName2 = employeeList.stream().sorted((e1, e2) -> e1.name.compareTo(e2.name))
				.collect(Collectors.toList());
		System.out.println("ascendingSortBasedOnName2: " + ascendingSortBasedOnName2);

// 25: descendingSortBasedOnName
		// way 1
		List<Employee> descendingSortBasedOnName1 = employeeList.stream()
				.sorted(Comparator.comparing(Employee::getName).reversed()).collect(Collectors.toList());
		System.out.println("descendingSortBasedOnName1: " + descendingSortBasedOnName1);
		// way 2
		List<Employee> descendingSortBasedOnName2 = employeeList.stream().sorted((e1, e2) -> e2.name.compareTo(e1.name))
				.collect(Collectors.toList());
		System.out.println("descendingSortBasedOnName2: " + descendingSortBasedOnName2);

		// 26 ascending sort based on age and name

		// way1
		Comparator<Employee> byAgeAscOrder = (e1, e2) -> e1.age - e2.age;
		Comparator<Employee> byNameAscOrder = (e1, e2) -> e1.name.compareTo(e2.name);
		List<Employee> sortedAgeNameAscOrder1 = employeeList.stream()
				.sorted(byAgeAscOrder.thenComparing(byNameAscOrder)).collect(Collectors.toList());
		System.out.println("sortedAgeNameAscOrder1 " + sortedAgeNameAscOrder1);
		// way2
		List<Employee> sortedAgeNameAscOrder2 = employeeList.stream()
				.sorted(Comparator.comparing(Employee::getAge).thenComparing(Comparator.comparing(Employee::getName)))
				.collect(Collectors.toList());
		System.out.println("sortedAgeNameAscOrder2: " + sortedAgeNameAscOrder2);

		// 27 ascending sort based on age and name and salary
		// way1
		Comparator<Employee> bySalryAscOrder = (e1, e2) -> (int) (e1.salary - e2.salary);
		List<Employee> sortedAgeNameSalaryAscOrder1 = employeeList.stream()
				.sorted(byAgeAscOrder.thenComparing(byNameAscOrder.thenComparing(bySalryAscOrder)))
				.collect(Collectors.toList());
		System.out.println("sortedAgeNameSalaryAscOrder1 " + sortedAgeNameSalaryAscOrder1);
//		System.out.println("*****");
		// way2
		List<Employee> sortedAgeNameSalaryAscOrder2 = employeeList.stream()
				.sorted(Comparator.comparing(Employee::getAge)
						.thenComparing(Comparator.comparing(Employee::getName)
								.thenComparing(Comparator.comparing(Employee::getSalary))))
				.collect(Collectors.toList());
		System.out.println("sortedAgeNameSalaryAscOrder2 " + sortedAgeNameSalaryAscOrder2);

		// 28 descending sort based on age and name and salary
		// way1
		Comparator<Employee> byAgeDescOrder = (e1, e2) -> e2.age - e1.age;
		Comparator<Employee> byNameDescOrder = (e1, e2) -> (int) (e2.salary - e1.salary);
		Comparator<Employee> bySalryDescOrder = (e1, e2) -> e2.name.compareTo(e1.name);
		List<Employee> sortedAgeNameSalaryDescOrder1 = employeeList.stream()
				.sorted(byAgeDescOrder.thenComparing(byNameDescOrder.thenComparing(bySalryDescOrder)))
				.collect(Collectors.toList());
		System.out.println("sortedAgeNameSalaryDescOrder1 " + sortedAgeNameSalaryDescOrder1);
//		System.out.println("*****");
		// way2
		List<Employee> sortedAgeNameSalaryDescOrder2 = employeeList.stream()
				.sorted(Comparator.comparing(Employee::getAge)
						.thenComparing(Comparator.comparing(Employee::getName)
								.thenComparing(Comparator.comparing(Employee::getSalary)))
						.reversed())
				.collect(Collectors.toList());
		System.out.println("sortedAgeNameSalaryDescOrder2 " + sortedAgeNameSalaryDescOrder2);

		// 29 Find first ascending record based on age and name and salary
		Optional<Employee> firstAscRecordBasedOnAgeNameSalary = employeeList
				.stream().sorted(Comparator.comparing(Employee::getAge)
						.thenComparing(Comparator.comparing(Employee::getName)).thenComparing(Employee::getSalary))
				.findFirst();
		System.out.println("firstAscRecordBasedOnAgeNameSalary: " + firstAscRecordBasedOnAgeNameSalary);

		// 30 Find Second ascending record based on age and name and salary
		Optional<Employee> secondtAscRecordBasedOnAgeNameSalary = employeeList
				.stream().sorted(Comparator.comparing(Employee::getAge)
						.thenComparing(Comparator.comparing(Employee::getName)).thenComparing(Employee::getSalary))
				.skip(1).findFirst();
		System.out.println("secondtAscRecordBasedOnAgeNameSalary: " + secondtAscRecordBasedOnAgeNameSalary);

		// 31 Find first descending record based on age and name and salary
		Optional<Employee> firstDscRecordBasedOnAgeNameSalary = employeeList.stream()
				.sorted(Comparator.comparing(Employee::getAge).thenComparing(Comparator.comparing(Employee::getName))
						.thenComparing(Employee::getSalary).reversed())
				.findFirst();
		System.out.println("firstDscRecordBasedOnAgeNameSalary: " + firstDscRecordBasedOnAgeNameSalary);

		// 32 Find Second descending record based on age and name and salary
		Optional<Employee> secondtDescRecordBasedOnAgeNameSalary = employeeList.stream()
				.sorted(Comparator.comparing(Employee::getAge).thenComparing(Comparator.comparing(Employee::getName))
						.thenComparing(Employee::getSalary).reversed())
				.skip(1).findFirst();
		System.out.println("secondtDescRecordBasedOnAgeNameSalary: " + secondtDescRecordBasedOnAgeNameSalary);

		// 33 Find the average salary of employee

		OptionalDouble averageSalaryOfEmployee1 = employeeList.stream().mapToDouble(e -> e.salary).average();
		if (averageSalaryOfEmployee1.isPresent()) {
			System.out.println("averageSalaryOfEmployee1 " + averageSalaryOfEmployee1);
		}
		Double averageSalaryOfEmployee2 = employeeList.stream()
				.collect(Collectors.averagingDouble(Employee::getSalary));
		System.out.println("averageSalaryOfEmployee2 " + averageSalaryOfEmployee2);

		// 34 find all the employee whose age is greater than 30

		List<String> empAgeGreater30 = employeeList.stream().filter(e -> e.getAge() > 30).map(e -> e.getName())
				.collect(Collectors.toList());
		System.out.println("empAgeGreater30: " + empAgeGreater30);

		employeeList.stream().filter(e -> e.getAge() > 30).map(e -> e.getName()).forEach(System.out::println);

		// 35 count number of employees with age 30?

		long countEmpAgeGreater30 = employeeList.stream().filter(e -> e.getAge() > 30).count();
		System.out.println("countEmpAgeGreater30: " + countEmpAgeGreater30);

		// 36 find the employee with name “Manu”.
		List<Employee> nameStartWithManu = employeeList.stream().filter(e -> e.getName().startsWith("Manu"))
				.collect(Collectors.toList());
		System.out.println("nameStartWithManu: " + nameStartWithManu);

		// 37 find maximum age of employee?

		Optional<Employee> maxAgeEmp = employeeList.stream().max(Comparator.comparing(Employee::getAge));
		System.out.println("maxAgeEmp: " + maxAgeEmp);

		OptionalInt max = employeeList.stream().mapToInt(e -> e.getAge()).max();
		System.out.println("max age of employee=> " + max);

		// 38 Join the all employee names with “,”

		List<String> employeeNames = employeeList.stream().map(Employee::getName).collect(Collectors.toList());

		String employeeNamesStr = String.join(",", employeeNames);
		System.out.println("employeeNamesStr: " + employeeNamesStr);

		// 39 group them by employee name
		Map<String, List<Employee>> groupByName = employeeList.stream().collect(Collectors.groupingBy(Employee::getName));
		System.out.println("groupByName: " + groupByName);
	}

}
