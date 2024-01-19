package com.umakant.testcode.javaEight;

import java.security.PublicKey;

public class Score {

	String subName;
	double marks;
	public Score(String subName, double marks) {
		super();
		this.subName = subName;
		this.marks = marks;
	}
	public String getSubName() {
		return subName;
	}
	public void setSubName(String subName) {
		this.subName = subName;
	}
	public double getMarks() {
		return marks;
	}
	public void setMarks(double marks) {
		this.marks = marks;
	}
	@Override
	public String toString() {
		return "Score [subName=" + subName + ", marks=" + marks + "]";
	}
	
	
	
	
}
