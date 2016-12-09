package adventofcode;

public class Day2 {

	public static void main(String[] args) throws Exception {
		
		System.out.println("First Star :");
		firstStar(args);
		
		System.out.println("Second Star :");
		secondStar(args);
	}
	
	private static void firstStar(String[] args) {
		String current = "5";

		for (String line : args) {
			
			for (int i = 0; i < line.length(); i++) {
				
				char c = line.charAt(i);
				
				switch(c) {
					case 'U':
						switch (current) {
							case "4":
								current = "1";
								break;
							case "5":
								current = "2";
								break;
							case "6":
								current = "3";
								break;
							case "7":
								current = "4";
								break;
							case "8":
								current = "5";
								break;
							case "9":
								current = "6";
								break;
							default:
								break;
						}
						break;
						

					case 'D':
						switch (current) {
							case "1":
								current = "4";
								break;
							case "2":
								current = "5";
								break;
							case "3":
								current = "6";
								break;
							case "4":
								current = "7";
								break;
							case "5":
								current = "8";
								break;
							case "6":
								current = "9";
								break;
							default:
								break;
						}
						break;

					case 'L':
						switch (current) {
							case "2":
								current = "1";
								break;
							case "3":
								current = "2";
								break;
							case "5":
								current = "4";
								break;
							case "6":
								current = "5";
								break;
							case "8":
								current = "7";
								break;
							case "9":
								current = "8";
								break;
							default:
								break;
						}
						break;

					case 'R':
						switch (current) {
							case "1":
								current = "2";
								break;
							case "2":
								current = "3";
								break;
							case "4":
								current = "5";
								break;
							case "5":
								current = "6";
								break;
							case "7":
								current = "8";
								break;
							case "8":
								current = "9";
								break;
							default:
								break;
						}
						break;

					default:
						break;
				}
				
			}
			
			System.out.println(current);
		}
		
		
	}

	private static void secondStar(String[] args) {
		String current = "5";

		for (String line : args) {
			
			for (int i = 0; i < line.length(); i++) {
				
				char c = line.charAt(i);
				
				switch(c) {
					case 'U':
						switch (current) {
							case "3":
								current = "1";
								break;
							case "6":
								current = "2";
								break;
							case "7":
								current = "3";
								break;
							case "8":
								current = "4";
								break;
							case "A":
								current = "6";
								break;
							case "B":
								current = "7";
								break;
							case "C":
								current = "8";
								break;
							case "D":
								current = "B";
								break;
							default:
								break;
						}
						break;
						

					case 'D':
						switch (current) {
							case "1":
								current = "3";
								break;
							case "2":
								current = "6";
								break;
							case "3":
								current = "7";
								break;
							case "4":
								current = "8";
								break;
							case "6":
								current = "A";
								break;
							case "7":
								current = "B";
								break;
							case "8":
								current = "C";
								break;
							case "B":
								current = "D";
								break;
							default:
								break;
						}
						break;

					case 'L':
						switch (current) {
							case "3":
								current = "2";
								break;
							case "4":
								current = "3";
								break;
							case "6":
								current = "5";
								break;
							case "7":
								current = "6";
								break;
							case "8":
								current = "7";
								break;
							case "9":
								current = "8";
								break;
							case "B":
								current = "A";
								break;
							case "C":
								current = "B";
								break;	
							default:
								break;
						}
						break;

					case 'R':
						switch (current) {
							case "2":
								current = "3";
								break;
							case "3":
								current = "4";
								break;
							case "5":
								current = "6";
								break;
							case "6":
								current = "7";
								break;
							case "7":
								current = "8";
								break;
							case "8":
								current = "9";
								break;
							case "A":
								current = "B";
								break;
							case "B":
								current = "C";
								break;
							default:
								break;
						}
						break;

					default:
						break;
				}
				
			}
			
			System.out.println(current);
		}
		
		
	}

	
}

