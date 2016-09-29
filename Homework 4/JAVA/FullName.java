/*
 * Objective: Creates a full name object that includes first middle last  
 * 					and formats with spaces "Bob T Smith" or last, first middle "Smith, Bob T"
*/

public class FullName {
	
	private SingleName first, middle, last;
	private String spacedName, commaName;

	public FullName(SingleName first, SingleName middle,
			SingleName last) {
		super();
		this.first = first;
		this.middle = middle;
		this.last = last;
	}
	
	public FullName() {}

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
}
