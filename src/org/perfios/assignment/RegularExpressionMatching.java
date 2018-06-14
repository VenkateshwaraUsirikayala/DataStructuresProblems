package org.perfios.assignment;

import java.util.Scanner;

public class RegularExpressionMatching {
	public boolean isMatch(String text, String pattern) {
		if (pattern.isEmpty())
			return text.isEmpty();
		boolean first_match = (!text.isEmpty() && (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

		if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
			return (isMatch(text, pattern.substring(2)) || (first_match && isMatch(text.substring(1), pattern)));
		} else {
			return first_match && isMatch(text.substring(1), pattern.substring(1));
		}
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the text");
		String text = input.next();
		System.out.println("Enter the pattern");
		String pattern = input.next();
		RegularExpressionMatching expressionMatching = new RegularExpressionMatching();
		boolean match = expressionMatching.isMatch(text, pattern);
		System.out.println(match);

	}
}
