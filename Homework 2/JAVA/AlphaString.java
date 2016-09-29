//set string makes a proper string using single name
//get returns fixed string

public class AlphaString {
	private String s;

	public AlphaString(String s){
		this.s = s;
	}
	public AlphaString(){}

	public String get() {
		return s;
	}

	public void set(String s) {
		this.s = s;

	}
}
