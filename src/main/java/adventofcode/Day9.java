package adventofcode;

import java.io.IOException;

public class Day9 {
	
	public static void main(String[] args) throws IOException {
		String input = args[0];
		
		System.out.println("First star :");
		firstStar(input);

		System.out.println("Second star :");
		System.out.println(secondStar(input));

	}

	private static void firstStar(String input) throws IOException {
		
		String firstStar = decompressString(input);
		
		System.out.println(firstStar);
		System.out.println(firstStar.length());
		
	}

	private static String decompressString(String input) {
		
		StringBuilder sb = new StringBuilder(2 * input.length());
		
		for (int i = 0; i < input.length(); i++) {
			
			char currentChar = input.charAt(i);
			
			if ('(' == currentChar) {
				i++;
				currentChar = input.charAt(i);

				String nbCharsToRepeat = "";
				while (currentChar != 'x') {
					nbCharsToRepeat += currentChar;
					i++;
					currentChar = input.charAt(i);
				}
				
				i++;
				currentChar = input.charAt(i);
				
				String nbTimesToRepeat = "";
				while (currentChar != ')') {
					nbTimesToRepeat += currentChar;
					i++;
					currentChar = input.charAt(i);
				}
				
				i++;

				String subStringToRepeat = input.substring(i, i + Integer.parseInt(nbCharsToRepeat));
				
				for (int repeat = 0; repeat < Integer.parseInt(nbTimesToRepeat); repeat++) {
					
					sb.append(subStringToRepeat);
					
				}
				
				i = i + Integer.parseInt(nbCharsToRepeat) - 1;
				
			} else {
				
				sb.append(currentChar);
				
			}
			
		}
		
		return sb.toString();
	}
	
	private static long secondStar(String input) {
		
		long nbChar = 0;
		
		for (int i = 0; i < input.length(); i++) {
			
			char currentChar = input.charAt(i);
			
			if ('(' == currentChar) {
				i++;
				currentChar = input.charAt(i);

				String nbCharsToRepeat = "";
				while (currentChar != 'x') {
					nbCharsToRepeat += currentChar;
					i++;
					currentChar = input.charAt(i);
				}
				
				i++;
				currentChar = input.charAt(i);
				
				String nbTimesToRepeat = "";
				while (currentChar != ')') {
					nbTimesToRepeat += currentChar;
					i++;
					currentChar = input.charAt(i);
				}
				
				i++;

				String subStringToRepeat = input.substring(i, i + Integer.parseInt(nbCharsToRepeat));
				
				if (subStringToRepeat.contains("(")) {
					
					nbChar += Integer.parseInt(nbTimesToRepeat) * secondStar(subStringToRepeat);
					
				} else {
				
					nbChar += Integer.parseInt(nbCharsToRepeat) * Integer.parseInt(nbTimesToRepeat);
					
				}

				i = i + Integer.parseInt(nbCharsToRepeat) - 1;
				
			} else {
				
				nbChar++;
				
			}
			
		}
		
		return nbChar;
		
	}
	
}
