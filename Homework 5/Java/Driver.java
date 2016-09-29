/*
 * Test program for group 9, assignment 4
* Yvonne Newman, Paul Durandt, Mario Muscarella and Andrew Yu
* 
* 
* Objective: Test the NameAddressID class by printing the full name, accompanying
* 						address (city, state, zip) and ID number.
*/
import java.util.Scanner; 

public class Driver {

	private static Scanner input;

	public static void main(String[] args) {

		Boolean test = false;
		String s = "";
		String hold;
		String street, city, state;
		int zip, id = 0;
		input = new Scanner(System.in);
		
		while (test == false) {
			System.out.println("Enter a full name without title (first middle last): ");
			s = input.nextLine();
			String[] sa = s.split(" ");
			hold = s;
			hold = hold.replaceAll("\\s+", "");
			// check for alphabetic and right number of words
			if (sa.length == 3 && CheckAlphaString.check(hold) == true && s != "") {
				test = true;
			}
		}

		String[] sa = s.split(" ");
		AlphaString word1 = new AlphaString(sa[0]);
		SingleName first = new SingleName(word1);
		AlphaString word2 = new AlphaString(sa[1]);
		SingleName middle = new SingleName(word2);
		AlphaString word3 = new AlphaString(sa[2]);
		SingleName last = new SingleName(word3);

			System.out.println("Enter a street address (number and name): ");
			street = input.nextLine();
			test = false;

		while (test == false) {
			System.out.println("Enter a city: ");
			s = input.nextLine();
			// check for alphabetic
			if (CheckAlphaString.check(s) == true && s != "") {
				test = true;
			}
		}
			city = s;
			test = false;
			
		while (test == false) {
			System.out.println("Enter a state: ");
			s = input.nextLine();
			// check for alphabetic
			if (CheckAlphaString.check(s) == true && s != "") {
				test = true;
			}
		}
		state = s;
		
			System.out.println("Enter a zipcode: ");
			zip = input.nextInt();
			
			System.out.println("Enter an ID number: ");
			id = input.nextInt();
		
		AlphaString cityAlpha = new AlphaString(city);
		SingleName cityName = new SingleName(cityAlpha);
		AlphaString stateAlpha = new AlphaString(state);
		SingleName stateName = new SingleName(stateAlpha);
		NameAddressID nameAddID = new NameAddressID(street, cityName, stateName, zip, 
				first, middle, last, id);
		
		System.out.printf("%nThe name, full address and ID are: %n" );
		System.out.println( nameAddID.getFullNameSpaces());
		System.out.printf( nameAddID.getStreet() + "%n" );
		System.out.printf( nameAddID.getCity() +  ", " +  nameAddID.getState() + " " + 
				nameAddID.getZip() + "%n");
		System.out.printf("ID: " + nameAddID.getID()  + "%n%n" );

	}
}