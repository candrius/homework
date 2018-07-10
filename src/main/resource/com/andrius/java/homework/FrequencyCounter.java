package com.andrius.java.homework;

import java.util.*;
import java.util.stream.Collectors;

public class FrequencyCounter {

	static void countFrequency(int minValue, int maxValue, ArrayList<Integer> numbersFreq, List<Integer> listOfUserInput) { // print method
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
		System.out.println();
	}

	static int findDigitsAmmount(int minValue, int maxValue) { // method to determine input length

		int maxValueLength = Integer.toString(maxValue).length();
		int minValueLength = Integer.toString(minValue).length();

		return (maxValueLength > minValueLength ? maxValueLength : minValueLength);

	}

	static void countFrequencyGraph(int minValue, int maxValue, ArrayList<Integer> numbersFreq) {
		int graphHight = Collections.max(numbersFreq);
		int graphWidth = maxValue - minValue + 1;
		int indent = findDigitsAmmount(minValue, maxValue);

		for (int i = graphHight; i > 0; i--) {
			for (int j = 0; j < graphWidth; j++) {
				if (numbersFreq.get(j).intValue() >= i)
					System.out.printf("%" + indent + "s ", "*");
				else
					System.out.printf("%" + indent + "s ", " ");
			}
			System.out.println();
		}

		for (int i = minValue; i <= maxValue; i++) {
			System.out.printf("%" + indent + "d ", i);
		}

	}


	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("No Input values");
			System.exit(1);
		}
		 
		 List<Integer> listOfUserInput = Arrays.asList(args).stream().mapToInt(num -> Integer.parseInt(num)).boxed()
				.collect(Collectors.toList());

		int maxValue = Collections.max(listOfUserInput); // max value of input
		int minValue = Collections.min(listOfUserInput); // min value of input

		ArrayList<Integer> numbersFreq = new ArrayList<Integer>(); // array list for frequency

		
		countFrequency(minValue, maxValue, numbersFreq, listOfUserInput);

		countFrequencyGraph(minValue, maxValue, numbersFreq);

	}

}
