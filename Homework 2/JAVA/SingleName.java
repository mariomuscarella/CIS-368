//set string makes a "Aaaa" format string
//inherits from alpha string

public class SingleName extends AlphaString {

	private AlphaString s;

	public SingleName(AlphaString s) {
		this.s = s;
		set(s);
	}

	public SingleName() {
	}
	
	public String get() {
		return s.get();
		}

	public void set(AlphaString s) {
		// change to "Aaaa" format
       
		char[] sa = s.get().toCharArray();

		for (int i = 0; i < sa.length; i++) {
			sa[i] = Character.toLowerCase(sa[i]);
		}
		sa[0] = Character.toUpperCase(sa[0]);
		s.set(String.valueOf(sa));

	}
}
