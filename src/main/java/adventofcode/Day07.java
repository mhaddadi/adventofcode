package adventofcode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Day07 {
	
	
	public static void main(String[] args) throws IOException {
		System.out.println("First star :");
		firstStar(args);

		System.out.println("Second star :");
		secondStar(args);

	}

	private static void firstStar(String[] args) throws IOException {

		int lineNb = 1;
		int nbTlsIp = 0;

		BufferedReader br = new BufferedReader(new FileReader("src/main/resources/Day7_puzzle.txt"));
		String line;

		while ((line = br.readLine()) != null) {

			System.out.println("line #" + lineNb + " : " + line);

			boolean isTlsIp = false;

			boolean isHypernetSeq = false;

			String[] firstSplit = line.split("\\[");

			for (String split : firstSplit) {

				boolean doBreak = false;
				String[] secondSplit = split.split("\\]");

				for (int j = 0; j < secondSplit.length && !doBreak; j++) {

					String subSplit = secondSplit[j];

					if (isAbba(subSplit)) {

						if (isHypernetSeq) {

							System.out.println("isHypernetSeq => KO");

							isTlsIp = false;
							doBreak = true;

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

		br.close();
	}

	private static void secondStar(String[] args) throws IOException {

		int lineNb = 1;
		int nbSslIp = 0;

		BufferedReader br = new BufferedReader(new FileReader("src/main/resources/Day7_puzzle.txt"));
		String line;

		List<String> listAba;
		List<String> listBab;
		
		while ((line = br.readLine()) != null) {

			System.out.println("line #" + lineNb + " : " + line);
			
			listAba = new ArrayList<>();
			listBab = new ArrayList<>();
			

			String[] firstSplit = line.split("\\[");

			boolean isHypernetSeq = false;
			
			for (String split : firstSplit) {

				String[] secondSplit = split.split("\\]");

				for (String subSplit : secondSplit) {
					
					if (isHypernetSeq) {
						listBab.addAll(getTriplets(subSplit)); 
					} else {
						listAba.addAll(getTriplets(subSplit));
					}
								
					isHypernetSeq = !isHypernetSeq;
				}
			}
			
			boolean isSslIp = false;
			
			for (Iterator<String> itAba = listAba.iterator(); itAba.hasNext() && !isSslIp; ) {
				
				String aba = itAba.next();
				
				for (Iterator<String> itBab = listBab.iterator(); itBab.hasNext() && !isSslIp; ) {
					
					String bab = itBab.next();
					
					isSslIp = bab.charAt(0) == aba.charAt(1) && bab.charAt(1) == aba.charAt(0);
					
				}
				
			}
			
			if (isSslIp) {

				nbSslIp++;
				System.out.println("OK SSL : line = " + line + "\n=> nbSslIp = " + nbSslIp);
			}

			lineNb++;

		}

		System.out.println(nbSslIp);

		br.close();

	}

	private static boolean isAbba(String str) {

		if (str.length() < 4) {
			return false;
		}

		for (int i = 0; i < str.length() - 3; i++) {

			if (str.charAt(i) == str.charAt(i + 3) && str.charAt(i + 1) == str.charAt(i + 2)
					&& str.charAt(i + 2) != str.charAt(i + 3)) {

				System.out.println("ABBA found in " + str + " => " + str.substring(i, i + 4));

				return true;
			}

		}

		return false;
	}
	
	private static List<String> getTriplets(String str) {
		
		List<String> triplets = new ArrayList<>();
		
		for (int i = 0; i < str.length() - 2; i++) {
			
			if (str.charAt(i) == str.charAt(i + 2) && str.charAt(i) != str.charAt(i + 1)) {
				triplets.add(String.valueOf(str.charAt(i)) + String.valueOf(str.charAt(i + 1)) + String.valueOf(str.charAt(i + 2)));
			}
			
		}
		
		return triplets;
		
	}
	
}
