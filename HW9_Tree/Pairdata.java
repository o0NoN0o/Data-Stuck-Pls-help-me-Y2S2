import java.util.Objects;

public class Pairdata implements Comparable {
	int first;
	int second;
	
	public Pairdata(int first, int second) {
		super();
		this.first = first;
		this.second = second;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		Pairdata p = (Pairdata)o;
		if(this.first < p.first) {
			return -1;
		} else if(this.first > p.first) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(first, second);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pairdata other = (Pairdata) obj;
		return first == other.first && second == other.second;
	}
	
	
	
	
	
}
