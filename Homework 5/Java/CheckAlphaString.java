/*
 * Objective: check to see if alphabetic or numeric, return false if numeric 
*/

public class CheckAlphaString {

	public static boolean check(String input) {
		int i;
		char[] inputArray = input.toCharArray();
		for (i = 0; i < input.length(); i++) {
			if (!(Character.isLetter(inputArray[i]))) 
				return false;

		}
		return true;

	}
}
