import java.util.Scanner;

public class Driver {
	
	private static Scanner input;
	
	public static void main(String[] args) {
		
		Boolean test = false;
		String s = "";
        input = new Scanner(System.in);
        
        while (test == false) {
		System.out.println("Enter a string to test: ");
		s = input.next();
		test = CheckAlphaString.check(s);
        }
        System.out.printf("%nYou entered:  " + s + "%n");
        AlphaString word = new AlphaString(s);
        SingleName name = new SingleName(word);
        System.out.printf("%nIt was adjusted to:  " +name.get() + "%n");      
	}
}