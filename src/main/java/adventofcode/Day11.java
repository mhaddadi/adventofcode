package adventofcode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day11 {

	private static final Pattern PATTERN_GENERATOR = Pattern.compile("a ([a-z]*) generator");
	private static final Pattern PATTERN_MICROCHIP = Pattern.compile("a ([a-z]*)-compatible microchip");
	
	private static Map<Integer, List<Component>> puzzle = new HashMap<>();

//	private static final String PUZZLE_INPUT_FILE = "src/main/resources/Day11_test.txt";
	private static final String PUZZLE_INPUT_FILE = "src/main/resources/Day11.txt";

	public static void main(String[] args) throws IOException {

		System.out.println("First star :");
		firstStar();

		System.out.println("Second star :");
		secondStar();

	}

	private static void firstStar() throws IOException {

		initPuzzle();
		
		System.out.println(puzzle);

	}

	private static void secondStar() {}

	private static void initPuzzle() {

		try {
			
			int floor = 1;
			
			for (String line : Files.readAllLines(Paths.get(PUZZLE_INPUT_FILE))) {

				List<Component> floorComponents = new ArrayList<>();
				
				Matcher matcher = PATTERN_GENERATOR.matcher(line);
				while (matcher.find()) {
					
					floorComponents.add(new Component(matcher.group(1), ComponentType.GENERATOR));
					
				}

				matcher = PATTERN_MICROCHIP.matcher(line);
				while (matcher.find()) {
					
					floorComponents.add(new Component(matcher.group(1), ComponentType.MICROCHIP));
					
				}
				
				puzzle.put(floor, floorComponents);
				
				floor++;
				
			}
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}

	}

}
	
enum ComponentType { GENERATOR, MICROCHIP };

class Component {

	String element;

	ComponentType type;

	public Component(String element, ComponentType type) {

		super();
		this.element = element;
		this.type = type;
	}

	@Override
	public String toString() {
		return element + "-" + type;
	}
	
}

