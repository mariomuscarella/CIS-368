import java.util.Scanner; 

public class Driver {

	private static Scanner input;

	public static void main(String[] args) {

		Boolean test = false;
		String s = "";
		String street, city, state;
		int zip = 0;
		input = new Scanner(System.in);

			System.out.println("Enter a street address (number and name): ");
			street = input.nextLine();
		
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
		
		AlphaString cityAlpha = new AlphaString(city);
		SingleName cityName = new SingleName(cityAlpha);
		AlphaString stateAlpha = new AlphaString(state);
		SingleName stateName = new SingleName(stateAlpha);
		Address address = new Address(street, cityName, stateName, zip);
		
		System.out.printf("The full address is: %n" );
		System.out.printf( address.getStreet() + "%n" );
		System.out.printf( address.getCity() +  ", " +  address.getState() + " " + 
		address.getZip() + "%n");
		
	}
}