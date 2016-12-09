package adventofcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day4 {

	private static final Pattern PATTERN_ENCRYPTED_NAME = Pattern.compile("^[a-z-]*");
	private static final Pattern PATTERN_ID = Pattern.compile("\\d+");
	private static final Pattern PATTERN_CHECKSUM = Pattern.compile("\\[[a-z]*\\]$");
	
	private static final Map<String, Integer> charToIndex = new HashMap<String, Integer>();
	private static final Map<Integer, String> indexToChar = new HashMap<Integer, String>();
	
	public static void main(String[] args) throws Exception {
		
		System.out.println("First Star :");
		firstStar(args);
		
		System.out.println("Second Star :");
		secondStar(args);
	}
	
	private static void firstStar(String[] args) throws Exception {
		
		int idSum = 0;
		
		for (String line : args) {

			String encryptedName = extractPattern(PATTERN_ENCRYPTED_NAME, line).replaceAll("-", "");

			String id = extractPattern(PATTERN_ID, line);
			
			String checksum = extractPattern(PATTERN_CHECKSUM, line).replace("[", "").replace("]", "");

			Map<String, Integer> countChar = new HashMap<>();
			List<String> distinctChars = new ArrayList<String>();
			
			for (int i = 0; i < encryptedName.length(); i++) {
				
				String currentChar = String.valueOf(encryptedName.charAt(i));
				
				if (countChar.get(currentChar) == null) {
					countChar.put(currentChar, 1);
				} else {
					countChar.put(currentChar, countChar.get(currentChar) + 1);
				}
				
				if (!distinctChars.contains(currentChar)) {
					distinctChars.add(currentChar);
				}
			}

			Map<String, Integer> sortedCountChar = sortByValue(countChar); 

			String expectedChecksum = "";
			int cpt = 0;
			for (Map.Entry<String, Integer> entry : sortedCountChar.entrySet()) {
				expectedChecksum += entry.getKey();
				cpt++;
				if (cpt == 5) {
					break;
				}
			}
			
			if (expectedChecksum.equals(checksum)) {
				idSum += Integer.parseInt(id);
			}
			
			
		}
		
		System.out.println(idSum);
		
	}

	private static void secondStar(String[] args) throws Exception {
		
		initMapsCharIndex();
		
		for (String line : args) {
			
			String encryptedName = extractPattern(PATTERN_ENCRYPTED_NAME, line);
			
			String id = extractPattern(PATTERN_ID, line);
			int moves = Integer.parseInt(id) % 26;
			
			String decryptedName = "";
			
			for (int i = 0; i < encryptedName.length(); i++) {
				
				String currentChar = String.valueOf(encryptedName.charAt(i));
				
				decryptedName += decodeChar(currentChar, moves);
				
			}
			
			System.out.println(encryptedName + " => " + decryptedName + " / id = " + id);
			
		}
		
	}

	private static String extractPattern(Pattern pattern, String line) throws Exception {
		Matcher matcher = pattern.matcher(line);
		if (matcher.find()) {
			return matcher.group(0);
		}
		else {
			throw new Exception(pattern.toString() + " not found for line : " + line);
		}
		
	}
	
	private static Map<String, Integer> sortByValue(Map<String, Integer> map )
	{
		List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(map.entrySet());
		
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				int compare = o2.getValue().compareTo(o1.getValue());
				if (compare == 0) {
					compare = o1.getKey().compareTo(o2.getKey());
				}
				return compare;
			}
		});

		Map<String, Integer>  result = new LinkedHashMap<String, Integer> ();
		for (Map.Entry<String, Integer>  entry : list) {
			result.put(entry.getKey(), entry.getValue());
		}
		return result;
	}

	private static void initMapsCharIndex() {
		
		String[] alphabet = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z" };
		
		for (int i = 0; i < 26; i++) {
			charToIndex.put(alphabet[i], i);
			indexToChar.put(i, alphabet[i]);
		}
		
	}
	
	private static String decodeChar(String charact, int moves) {
		
		if ("-".equals(charact)) {
			return " ";
		} else {
			int index = charToIndex.get(charact);
			return indexToChar.get((index + moves) % 26);
		}
	}
	
}

