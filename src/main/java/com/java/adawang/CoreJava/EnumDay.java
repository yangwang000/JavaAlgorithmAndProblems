package com.java.adawang.CoreJava;

public class EnumDay {
	Day day;

	public EnumDay(Day day) {
		this.day = day;
	}

	public void tellItLikeItIs() {
		switch (day) {
			case MONDAY:
				System.out.println("Mondays are bad.");
				break;

			case FRIDAY:
				System.out.println("Fridays are better.");
				break;

			case SATURDAY: case SUNDAY:
				System.out.println("Weekends are best.");
				break;

			default:
				System.out.println("Midweek days are so-so.");
				break;
		}
	}

	public static void main(String[] args) {
		EnumDay firstDay = new EnumDay(Day.MONDAY);
		firstDay.tellItLikeItIs();
		EnumDay thirdDay = new EnumDay(Day.WEDNESDAY);
		thirdDay.tellItLikeItIs();
		EnumDay fifthDay = new EnumDay(Day.FRIDAY);
		fifthDay.tellItLikeItIs();
		EnumDay sixthDay = new EnumDay(Day.SATURDAY);
		sixthDay.tellItLikeItIs();
		EnumDay seventhDay = new EnumDay(Day.SUNDAY);
		seventhDay.tellItLikeItIs();
	}
}
