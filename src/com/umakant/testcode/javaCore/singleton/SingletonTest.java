package com.umakant.testcode.javaCore.singleton;


public class SingletonTest {

	public static void main(String[] args) {
		//Singleton s1=new Singleton();
		Singleton instance1=Singleton.getInstance();
		System.out.println(instance1);
		
		Singleton instance2=Singleton.getInstance();
		System.out.println(instance2);
		
		Singleton instance3=Singleton.getInstance();
		System.out.println(instance3);

	}

}
