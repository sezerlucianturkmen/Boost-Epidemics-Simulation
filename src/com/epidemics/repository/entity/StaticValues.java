package com.epidemics.repository.entity;

public abstract class StaticValues {

	private static long DAY = 0;

	public static void timePass() {
		DAY++;

	}

	public static void timePass(long dayNumber) {
		DAY = DAY + dayNumber;

	}

	public static long getTime() {
		return DAY;
	}

}
