/*
 * Objective: Creates a full name object that includes first middle last  
 * 					and formats with spaces "Bob T Smith" or last, first middle "Smith, Bob T".
 * 					Overrides clone and equals.
 */

public class FullName implements Cloneable {

	private SingleName first, middle, last;
	private String spacedName, commaName;

	public FullName(SingleName first, SingleName middle, SingleName last) {

		this.first = first;
		this.middle = middle;
		this.last = last;
	}

	public FullName() {
	}

	// copy constructor
	FullName(FullName name) {
		first = name.first;
		middle = name.middle;
		last = name.last;
	}

	public SingleName getFirst() {
		return first;
	}

	public void setFirst(SingleName first) {
		this.first = first;
	}

	public SingleName getMiddle() {
		return middle;
	}

	public void setMiddle(SingleName middle) {
		this.middle = middle;
	}

	public SingleName getLast() {
		return last;
	}

	public void setLast(SingleName last) {
		this.last = last;
	}

	public void setAll(SingleName first, SingleName middle, SingleName last) {
		this.first = first;
		this.middle = middle;
		this.last = last;
	}

	public String getFullNameSpaces() {
		spacedName = first.get() + " " + middle.get() + " " + last.get();
		return spacedName;
	}

	public String getLastCommaFirst() {
		commaName = last.get() + ", " + first.get() + " " + middle.get();
		return commaName;
	}

	@Override
	public FullName clone() {
		FullName obj;
		try {
			obj = (FullName) super.clone();
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
		if (!FullName.class.isAssignableFrom(obj.getClass())) {
			return false;
		}
		final FullName other = (FullName) obj;

		if (!this.first.equals(other.first)) {
			return false;
		}
		if (!this.middle.equals(other.middle)) {
			return false;
		}
		if (!this.last.equals(other.last)) {
			return false;
		}

		return true;
	}
}
