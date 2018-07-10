package com.andrius.java.homework;

import java.util.*;
import java.util.stream.Collectors;

public class FrequencyCounter {
	static List<Integer> listOfUserInput = new ArrayList<Integer>();

	static void printToTerminal(int minValue, int maxValue, ArrayList<Integer> numbersFreq) {   //
		System.out.print("frequency:");
		int indent = findDigitsAmmount(minValue, maxValue);

		for (int i = minValue; i <= maxValue; i++) {
			int freq = Collections.frequency(listOfUserInput, i);
			numbersFreq.add(freq);
			System.out.printf("%" + indent + "d ", freq);
		}

		System.out.print("\nnumber   :");

		for (int i = minValue; i <= maxValue; i++) {
			System.out.printf("%" + indent + "d ", i);
		}

	}

	static int findDigitsAmmount(int minValue, int maxValue) { // method for determing

		int maxValueLength = Integer.toString(maxValue).length();
		int minValueLength = Integer.toString(minValue).length();

		return (maxValueLength > minValueLength ? maxValueLength : minValueLength);

	}

	public static void main(String[] args) {

		listOfUserInput = Arrays.asList(args).stream().mapToInt(num -> Integer.parseInt(num)).boxed()
				.collect(Collectors.toList());

		int maxValue = Collections.max(listOfUserInput); // max value of input
		int minValue = Collections.min(listOfUserInput); // min value of input

		ArrayList<Integer> numbersFreq = new ArrayList<Integer>(); // array list for frequency

		printToTerminal(minValue, maxValue, numbersFreq);

	}

}
