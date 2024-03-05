
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
		double qAmount = counters.length + 1;                                                                             //find the number of counter
		double cAmount = 0;       
		for(int i = 0;i<counters.length;i++) { 
			cAmount += counters[i].size();                                                                                //find the number of customer
		}
		int neededQLength = (int) Math.round(cAmount/qAmount);                                                            //find max number of cus in each q
		for(int i = 0;i<counters.length;i++) {                                                                            //run the code for each counter
			int qNum = 0;                                                                                                 //indicate the position of a person in q
			int qSize = counters[i].size();
			for(int j = 0;j<qSize;j++) {                                                                                  //run the code for each person in q
				counters[i].insertLast(counters[i].front());                                                              //loop the first person to the back
				counters[i].removeFirst();                                                                                //(the position is of the person that got loop to the back)
				qNum++;                                                                                                   //add the qNum representing their position
				if(qNum > neededQLength && special.size() < neededQLength && counters[i].size() > neededQLength) {        //if the position of person that got loop exceed the max q num
					special.insertLast(counters[i].back());                                                               //and the special q is not full
					counters[i].removeLast();                                                                             //and that counter size is still larger than max q num
				}                                                                                                         //remove the last person then add to special q
				
			}
		}
		if(special.size() == 0) {                                                                                         //if special q is empty insert the last person of last q
			special.insertFirst(counters[counters.length-1].back());
			(counters[counters.length-1]).removeLast();
		}
	}

}
