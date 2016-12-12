package adventofcode;

public class Day03 {

	public static void main(String[] args) throws Exception {
		
		System.out.println("First Star :");
		firstStar(args);
		
		System.out.println("Second Star :");
		secondStar(args);
	}
	
	private static void firstStar(String[] args) {
		
		int nbPossible = 0;
		
		for (int i = 0; i < args.length; i = i + 3) {
			
			int l1 = Integer.parseInt(args[i]);
			int l2 = Integer.parseInt(args[i + 1]);
			int l3 = Integer.parseInt(args[i + 2]);
			
			if (isPossible(l1, l2, l3)) {
				nbPossible++;
			}
			
		}

		System.out.println("nbPossible = " + nbPossible + " / " + args.length);
		
	}

	private static void secondStar(String[] args) {
		
		int nbPossible = 0;
		
		for (int i = 0; i < args.length; i = i + 9) {
			
			int l11 = Integer.parseInt(args[i]);
			int l12 = Integer.parseInt(args[i + 3]);
			int l13 = Integer.parseInt(args[i + 6]);
			
			if (isPossible(l11, l12, l13)) {
				nbPossible++;
			}
			
			int l21 = Integer.parseInt(args[i + 1]);
			int l22 = Integer.parseInt(args[i + 4]);
			int l23 = Integer.parseInt(args[i + 7]);
			
			if (isPossible(l21, l22, l23)) {
				nbPossible++;
			}
			
			int l31 = Integer.parseInt(args[i + 2]);
			int l32 = Integer.parseInt(args[i + 5]);
			int l33 = Integer.parseInt(args[i + 8]);
			
			if (isPossible(l31, l32, l33)) {
				nbPossible++;
			}
			
		}

		System.out.println("nbPossible = " + nbPossible + " / " + args.length);
		
	}

	
	private static boolean isPossible(int l1, int l2, int l3) {
		return l1 + l2 > l3 && l2 + l3 > l1 && l1 + l3 > l2;
	}
	
}

