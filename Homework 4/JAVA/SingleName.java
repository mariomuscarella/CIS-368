/*
 * Objective: Creates SingleName object and formats it to "Aaaa" style
 * 						inherits from AlphaString and overrides Object's toString() method
 */

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
       
		char[] sa = s.get().toCharArray();

		for (int i = 0; i < sa.length; i++) {
			sa[i] = Character.toLowerCase(sa[i]);
		}
		sa[0] = Character.toUpperCase(sa[0]);
		s.set(String.valueOf(sa));

	}
	
    @Override
    public String toString()
    {
        return s.get();
    }
}
