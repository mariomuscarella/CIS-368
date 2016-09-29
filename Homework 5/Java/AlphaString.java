/*
 * Objective: creates an object containing a string. Overrides clone and equals.
 */

public class AlphaString implements Cloneable {
	private String s;

	public AlphaString(String s) {
		this.s = s;
	}

	public AlphaString() {
	}

	// copy constructor
	AlphaString(AlphaString as) {
		s = as.s;
	}

	public String get() {
		return s;
	}

	public void set(String s) {
		this.s = s;

	}

	@Override
	public AlphaString clone() {
		AlphaString obj;
		try {
			obj = (AlphaString) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new AssertionError(e);
		}
		return obj;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (AlphaString.class.isAssignableFrom(obj.getClass())) {
			return false;
		}
		final AlphaString other = (AlphaString) obj;

		if ( !this.s.equals(other.s)) {
			return false;
		}

		return true;
	}
}
