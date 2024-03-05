

public interface Iterator {

	public boolean hasNext();

	public boolean hasPrevious();

	public Comparable next() throws Exception; 
	                    // move iterator to the next position,
						// then returns the value at that position.

	public Comparable previous() throws Exception;
	                        // return the value at current position,
							// then move the iterator back one position.

	public void set(Comparable value);

}
