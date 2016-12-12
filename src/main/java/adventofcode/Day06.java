package adventofcode;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Day06 {
	public static void main(String[] args) {
		System.out.println("First star :");
		firstStar(args);

		System.out.println("Second star :");
		secondStar(args);

	}

	private static void firstStar(String[] args) {
		
		Map<Integer, Map<String, Integer>> mapDeMap = new HashMap<>();
		
		for (String line : args) {

			for (int i = 0; i < line.length(); i++) {
				
				Map<String, Integer> mapNbChar = mapDeMap.get(i);
				
				if (mapNbChar == null) {
					mapNbChar = new HashMap<String, Integer>();
				}
				
				String currentCar = String.valueOf(line.charAt(i));
				
				mapNbChar.put(currentCar, mapNbChar.get(currentCar) == null ? 1 : mapNbChar.get(currentCar) + 1);
				
				mapDeMap.put(i, mapNbChar);
				
			}
			
		}
		
		for (Map.Entry<Integer, Map<String, Integer>> entry : mapDeMap.entrySet()) {
			
			Map<String, Integer> mapTriee = sortByValue(entry.getValue());
			
			System.out.println(entry.getKey() + " : " + mapTriee.keySet());
			
		}
		
	}

	private static void secondStar(String[] args) {}

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

	
}
