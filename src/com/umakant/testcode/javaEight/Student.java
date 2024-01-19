package com.umakant.testcode.javaEight;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Student { 

	int id;
	String studentName;
	int age;
	Score score;

	private Student(int id, String studentName, int age, Score score) {
		super();
		this.id = id;
		this.studentName = studentName;
		this.age = age;
		this.score = score;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", studentName=" + studentName + ", age=" + age + ", score=" + score + "]";
	}

	public static void main(String args[]) {

		List<Student> studentList = new ArrayList<>();
		studentList.add(new Student(4, "Shinde", 35, new Score("SQL", 75)));
		studentList.add(new Student(1, "umesh", 30, new Score("Java", 80)));
		studentList.add(new Student(3, "Ramesh", 28, new Score("C++", 90)));
		studentList.add(new Student(2, "sane", 20, new Score("C", 60)));
		studentList.add(new Student(6, "umesh", 35, new Score("Java", 80)));
		studentList.add(new Student(5, "Ramesh", 29, new Score("C++", 90)));
		studentList.add(new Student(4, "Tanuja", 35, new Score("SQL", 75)));

		System.out.println("original studentList: " + studentList);
		System.out.println("**********************");

		List<Student> sortBasedOnId = studentList.stream().sorted(Comparator.comparing(Student::getId))
				.collect(Collectors.toList());

		System.out.println("sortBasedOnId: " + sortBasedOnId);
		System.out.println("*************");

		List<String> studentName = studentList.stream().map(e -> e.getStudentName()).collect(Collectors.toList());
		System.out.println("studentName: " + studentName);
		System.out.println("***********");
		/*
		 * Note: This comment code is working fine. Comparator<Student> stuComparator =
		 * 
		 * (o1, o2) -> (int) o2.getScore().getMarks() - (int) o1.getScore().getMarks();
		 * 
		 * studentList.stream().sorted(stuComparator).map(Student::getStudentName)
		 * .forEach(x -> System.out.println(x + "\t"));
		 * 
		 * System.out.println("**********************"); List<String> nameBasedOnMarks =
		 * studentList.stream().sorted(stuComparator).map(Student::getStudentName)
		 * .collect(Collectors.toList());
		 * 
		 * System.out.println("nameBasedOnMarks: " + nameBasedOnMarks);
		 */
		List<String> nameBasedOnMarks1 = studentList.stream()
				.sorted((o1, o2) -> (int) o2.getScore().getMarks() - (int) o1.getScore().getMarks())
				.map(Student::getStudentName).collect(Collectors.toList());

		System.out.println("nameBasedOnMarks1: " + nameBasedOnMarks1);

		List<String> nameBasedOnMarks2 = studentList.stream()
				.sorted((o1, o2) -> (int) (o2.getScore().getMarks() - o1.getScore().getMarks()))
				.map(Student::getStudentName).collect(Collectors.toList());

		System.out.println("nameBasedOnMarks2: " + nameBasedOnMarks2);

		List<String> nameBasedOnMarks3 = studentList.stream()
				.sorted((s1, s2) -> (int) (s2.getScore().getMarks() - s1.getScore().getMarks()))
				.map(s -> s.getStudentName()).collect(Collectors.toList());
		System.out.println("nameBasedOnMarks3: " + nameBasedOnMarks3);

		Comparator<Student> subNameComp = (o1, o2) -> o1.getScore().getSubName().compareTo(o2.getScore().getSubName());

		List<String> subNameBasedAscOrder = studentList.stream().sorted(subNameComp).map(s5 -> s5.getStudentName())
				.collect(Collectors.toList());
		System.out.println("subNameBasedAscOrder: " + subNameBasedAscOrder);

		List<String> subNameBasedAscOrder2 = studentList.stream()
				.sorted((s1, s2) -> s1.getScore().getSubName().compareTo(s2.getScore().getSubName()))
				.map(s5 -> s5.getStudentName()).collect(Collectors.toList());
		System.out.println("subNameBasedAscOrder2: " + subNameBasedAscOrder2);

		// sort based on Id and name

		Comparator<Student> byIdAscOrder = (e1, e2) -> e1.id - e2.id;
		Comparator<Student> byNameAscOrder = (e1, e2) -> e1.studentName.compareTo(e2.studentName);
		List<String> sortBasedOnIdName = studentList.stream().sorted(byIdAscOrder.thenComparing(byNameAscOrder))
				.map(s -> s.getStudentName()).collect(Collectors.toList());
		System.out.println("sortBasedOnIdName: " + sortBasedOnIdName);
		
	
	}
}
