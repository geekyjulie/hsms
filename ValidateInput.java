import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class ValidateInput {


	/**
	 * Method will check the string and will make sure that it doesn't contain any other character than a letter.
	 * If it does contain an invalid character, the method will cut it out and return the new and corrected string
	 * Capitalizes the first letter of the string and turns the remaining part of the string to lower case
	 * @param someName
	 * @return
	 */
	public static String validateName(String name) {
	    char[] chars = name.toCharArray();
	    
	    ArrayList<Character> myName = new ArrayList<Character>();
	    
	    boolean previousNotSpace = false;

	    // Removing all non-letters from the string 'name'
	    for (char c : chars) {
	        if(Character.isLetter(c)) {
	            myName.add(c);
	            previousNotSpace = true;
	        }else if( Character.isSpaceChar(c) && previousNotSpace){
	        	//Will allow for a space for people who have a space in their name
	        	// however, will only allow for one space between words in their name
	        	myName.add(c);
	        	previousNotSpace = false;
	        }
	    }
	    
	    
	    // Concatenating all valid chars together, capitalizing the first letter and lower casing all others
	    boolean foundSpace = false;
	    String validName = "";
	    for( char c : myName ){
	    	if(validName.length() == 0){
	    		validName += Character.toUpperCase(c);
	    	}else{
	    		if( Character.isSpaceChar(c)){
	    			foundSpace = true;
	    			validName += c;
	    		}else{
	    			if( foundSpace ){
	    				//Previous char was a space, so capitalizing
	    				validName += Character.toUpperCase(c);
	    				foundSpace = false;
	    			}else{
	    				//Previous char was not a space, so lowercase
	    				validName += Character.toLowerCase(c);
	    			}
	    		}
	    		
	    	}
	    	
	    }

	    return validName;
	}
	
	public static void printDate( GregorianCalendar date ){
		SimpleDateFormat df = new SimpleDateFormat();
        df.applyPattern("M/dd/yyyy");
        System.out.println(df.format(date.getTime()));
		
	}

}