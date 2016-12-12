package adventofcode;

public class Day07 {
	public static void main(String[] args) {
		System.out.println("First star :");
		firstStar(args);

		System.out.println("Second star :");
		secondStar(args);

	}

	private static void firstStar(String[] args) {
		
		int lineNb = 1;
		int nbTlsIp = 0;
		
		for (String line : args) {
			
			System.out.println("line #" + lineNb + " : " + line);
			
			boolean isTlsIp = false;
			
			boolean isHypernetSeq = false;
			
			String[] firstSplit = line.split("\\[");
			
			for (String split : firstSplit) {
				
				String[] secondSplit = split.split("\\]");
				
				for (String subSplit : secondSplit) {
					
					if (isAbba(subSplit)) {
						
						if (isHypernetSeq) {
							
							System.out.println("isHypernetSeq => KO");
							
							isTlsIp = false;
							break;
							
						} else {
							
							isTlsIp = true;
							
						}
						
					}

					isHypernetSeq = !isHypernetSeq;
					
				}
				
			}
			
			if (isTlsIp) {
				
				nbTlsIp++;
				System.out.println("OK TLS : nbTlsIp = " + nbTlsIp);
			}
			
			lineNb++;
			
		}
		
		System.out.println(nbTlsIp);
	}

	private static void secondStar(String[] args) {}

	private static boolean isAbba(String str) {
		
		if (str.length() < 4) {
			return false;
		}
		
		for (int i = 0; i < str.length() - 3; i++) {
			
			if (str.charAt(i) == str.charAt(i + 3) 
					&& str.charAt(i + 1) == str.charAt(i + 2)
					&& str.charAt(i + 2) != str.charAt(i + 3)) {
				
				System.out.println("ABBA found in " + str + " => " + str.substring(i, i + 4));
				
				return true;
			}
			
		}
		
		return false;
	}
}
