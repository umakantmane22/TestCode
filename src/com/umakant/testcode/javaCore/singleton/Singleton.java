package com.umakant.testcode.javaCore.singleton;

public class Singleton {
	private volatile static Singleton instance;

	private Singleton() {
		super();
	}

	public static Singleton getInstance() {
		if (instance == null) {
			// instance=new Singleton();
			synchronized (Singleton.class) {
				if (instance == null) {
					instance = new Singleton();
				}
			}

		}
		return instance;
	}
}
