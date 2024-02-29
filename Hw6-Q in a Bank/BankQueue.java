
public class BankQueue { // must work for any implementation of DeQ
	DeQ[] counters;
	DeQ special;

	public BankQueue(DeQ[] counters, DeQ special) {
		super();
		this.counters = counters;
		this.special = special;
	}

	//Write this method
	public void distribute() throws Exception {
		double qAmount = counters.length + 1;
		double cAmount = 0;
		for(int i = 0;i<counters.length;i++) {
			cAmount += counters[i].size();
		}
		int neededQLength = (int) Math.round(cAmount/qAmount);
		for(int i = 0;i<counters.length;i++) {
			int qNum = 0;
			int qSize = counters[i].size();
			for(int j = 0;j<qSize;j++) {
				counters[i].insertLast(counters[i].front());
				counters[i].removeFirst();
				qNum++;
				if(qNum > neededQLength && special.size() < neededQLength && counters[i].size() > neededQLength) {
					special.insertLast(counters[i].back());
					counters[i].removeLast();
				}
				
			}
		}
		if(special.size() == 0) {
			special.insertFirst(counters[counters.length-1].back());
			(counters[counters.length-1]).removeLast();
		}
	}

}
