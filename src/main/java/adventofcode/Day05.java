package adventofcode;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class Day05 
{
    public static void main( String[] args ) throws NoSuchAlgorithmException
    {
    	System.out.println("First star :");
    	firstStar(args);
    	
    	System.out.println("Second star :");
    	secondStar(args);

    }

    private static void firstStar(String[] args) throws NoSuchAlgorithmException {
    	String puzzleInput = args[0];
    	
    	MessageDigest md = MessageDigest.getInstance("MD5");
    	
    	int index = 0;
    	
		int found = 0;
		
		while (found < 8) {
			
			byte[] digest = md.digest((puzzleInput + index).getBytes());
			
			if( "00".equals(String.format("%02X", digest[0]))
					&& "00".equals(String.format("%02X", digest[1]))
					&& String.format("%02X", digest[2]).startsWith("0")) {
				System.out.println(String.format("%02X", digest[2]).charAt(1));
				found++;
			}

			index++;
			
    	}
    }
    
    private static void secondStar(String[] args) throws NoSuchAlgorithmException {
    	String puzzleInput = args[0];
    	
    	MessageDigest md = MessageDigest.getInstance("MD5");
    	
    	int index = 0;
    	
		Map<Integer, String> mapPwd = new HashMap<Integer, String>();
		
		while (mapPwd.size() < 8) {
			
			byte[] digest = md.digest((puzzleInput + index).getBytes());
			
			if( "00".equals(String.format("%02X", digest[0]))
					&& "00".equals(String.format("%02X", digest[1]))
					&& String.format("%02X", digest[2]).startsWith("0")) {
				int pos = Character.getNumericValue((String.format("%02X", digest[2]).charAt(1)));
				char value =  (String.format("%02X", digest[3]).charAt(0));
				
				if (0 <= pos && pos <= 7 && mapPwd.get(pos) == null) {
					
					mapPwd.put(pos, String.valueOf(value));
					
				}
			}

			index++;
			
    	}
		
		System.out.println(mapPwd.values());
		
    }
    
}
