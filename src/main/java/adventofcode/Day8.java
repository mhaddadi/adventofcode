package adventofcode;

public class Day8 {
	
	private static int SCREEN_WIDTH = 50;
	private static int SCREEN_HEIGHT = 6;
	
	
	public static void main(String[] args) {
		System.out.println("First star :");
		firstStar(args);

		System.out.println("Second star :");
		secondStar(args);

	}

	private static void firstStar(String[] args) {
		
		int[][] screen = new int[SCREEN_HEIGHT][SCREEN_WIDTH];
		
		String[] lines = args[0].split("\\n");
		
		for (String line : lines) {
			
			System.out.println(line);
			
			String[] sublines = line.split(" ");
			
			String instruction = sublines[0];
			
			switch(instruction) {
				
				case "rect" :
					
					int cols = Integer.parseInt((sublines[1].split("x"))[0]);
					int rows = Integer.parseInt((sublines[1].split("x"))[1]);
					doRect(screen, cols, rows);
					print(screen);
					break;
				
				case "rotate" :
					
					String subInstruction = sublines[1];
					int index = Integer.parseInt((sublines[2].split("="))[1]);
					int by = Integer.parseInt(sublines[4]);
					
					doRotate(screen, subInstruction, index, by);
					print(screen);
					break;

				default:
					break;
					
			}
		}
		System.out.println("Number of lit pixels = " + countOnes(screen));
	}

	private static void secondStar(String[] args) {}

	private static void print(int[][] screen) {
		
		for (int i = 0; i < SCREEN_HEIGHT; i++) {
			String line = "";
			for (int j = 0; j < SCREEN_WIDTH; j++) {
				line += screen[i][j] + " ";
			}
			System.out.println(line);
		}
		
	}
	
	private static void doRect(int[][] screen, int cols, int rows) {
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				screen[i][j] = 1;
			}
		}
		
	}
	
	
	private static void doRotate(int[][] screen, String subInstruction, int index, int by) {
		
		switch (subInstruction) {
			case "column" :
				doRotateCol(screen, index, by);
				break;
			
			case "row" :
				doRotateRow(screen, index, by);
				break;
			
			default :
				break;
		}
		
	}
	
	private static void doRotateCol(int[][] screen, int index, int by) {
		
		int[][] screenClone = copyScreen(screen);
		
		for (int i = 0; i < SCREEN_HEIGHT; i++) {
			
			int rowIndex = (i - by >= 0) ? (i - by) : (i - by + SCREEN_HEIGHT);
			
			screen[i][index] = screenClone[rowIndex][index];
			
		}
		
	}
		
	private static void doRotateRow(int[][] screen, int index, int by) {
		
		int[][] screenClone = copyScreen(screen);
		
		for (int j = 0; j < SCREEN_WIDTH; j++) {
			
			int colIndex = (j - by >= 0) ? (j - by) : (j - by + SCREEN_WIDTH);
			
			screen[index][j] = screenClone[index][colIndex];
			
		}
		
	}
	
	private static int[][] copyScreen(int[][] screen) {
		
		int[][] screenClone = new int[SCREEN_HEIGHT][SCREEN_WIDTH];
		for (int i = 0; i < SCREEN_HEIGHT; i++) {
			for (int j = 0; j < SCREEN_WIDTH; j++) {
				screenClone[i][j] = screen[i][j];
			}
		}
		return screenClone;
	}
	
	private static int countOnes(int[][] screen) {
		
		int nbOnes = 0;
		for (int i = 0; i < SCREEN_HEIGHT; i++) {
			for (int j = 0; j < SCREEN_WIDTH; j++) {
				if (screen[i][j] == 1) {
					nbOnes++;
				}
			}
		}
		return nbOnes;
	}
	
}
