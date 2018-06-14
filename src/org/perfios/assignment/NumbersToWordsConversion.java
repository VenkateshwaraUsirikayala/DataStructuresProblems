package org.perfios.assignment;

import java.util.Scanner;

public class NumbersToWordsConversion {

	String units[] = {"", "One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ", "Nine ", "Ten ", "Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ",
			"Eighteen ", "Nineteen "};

	String ten_multiples[] = {"", "", "twenty ", "thirty ", "forty ", "fifty ", "sixty ", "seventy ", "eighty ", "ninety "};

	String numbersToWords(long n) {
		String resultString = "";

		resultString += numberToWord((n / 10000000), "crore ");

		resultString += numberToWord(((n / 100000) % 100), "lakh ");

		resultString += numberToWord(((n / 1000) % 100), "thousand ");

		resultString += numberToWord(((n / 100) % 10), "hundred ");

		if (n > 100)
			resultString += "and ";

		resultString += numberToWord((n % 100), "");

		return resultString;
	}

	String numberToWord(long l, String s) {
		int n = (int) l;
		String str = "";
		if (n > 19)
			str += ten_multiples[n / 10] + units[n % 10];
		else
			str += units[n];

		if (n > 0)
			str += s;

		return str;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number");
		long number = input.nextLong();
		NumbersToWordsConversion wordsConversion = new NumbersToWordsConversion();
		String words = wordsConversion.numbersToWords(number);
		System.out.println(words);
	}
}
