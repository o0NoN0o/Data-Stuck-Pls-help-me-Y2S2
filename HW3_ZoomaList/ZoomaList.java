
public class ZoomaList extends CDLinkedList {
	int score = 0;

	public ZoomaList() {
		super();
	}

	public ZoomaList(CDLinkedList l) {
		header = l.header;
		size = l.size;
	}

	public void insert(int value, Iterator p) throws Exception {
		//fill code
		//
		if (p == null || !(p instanceof DListIterator))
			throw new Exception();
		DListIterator p2 = (DListIterator) p;
		if (p2.currentNode == null)
			throw new Exception();

		DListIterator p3 = new DListIterator(p2.currentNode.nextNode);
		DListNode n = new DListNode(value, p3.currentNode, p2.currentNode);                           //create new node representing a ball
		p2.currentNode.nextNode = n;                                                                  //adding it to a list
		p3.currentNode.previousNode = n;
		size++;
		//
		
		int count = 1;                                                                                //ball count
		DListIterator nt = new DListIterator(n);
		DListIterator pv = new DListIterator(n);
		DListIterator ph = new DListIterator(n);
		while(nt.hasNext()) {                                                                        //check for the next ball until the end
			nt.next();
			if((ph.currentNode.data == nt.currentNode.data)) {                                       //if the next ball is the same as the added ball add count
				count ++;
			}
			if(!(ph.currentNode.data == nt.currentNode.data)) {                                      //if not stop checking
				break;
			}
		}
		while(pv.hasPrevious()) {
			pv.previous();
			if((ph.currentNode.data == pv.currentNode.data)) {                                       //check the previous ball if same add count stop when not same
					count ++;
			}
			if(!(ph.currentNode.data == pv.currentNode.data)) {
				break;
			}
		}
		
		if(count  >= 3) {                                                                            //after checking if count >= 3 remove between then add score
			removeBetween(pv,nt,count);
			score += count;
		}
		
		while(pv.currentNode.data == nt.currentNode.data && pv.currentNode.nextNode.data == nt.currentNode.previousNode.data && size >= 3) {
			count = 2;                                                                               //if the linkedlist have 3 or more ball
			int nu = pv.currentNode.data;                                                            //and the two ball that meet if the same run the while loop
			while(pv.previous() == nu) {                                                             //start count at 2 since there will already be 2 ball
				count++;                                                                             //check if the previous ball is the same as the 2 connect ball
			}                                                                                        
			count -= 1;                                                                              //.previous()  return the value before the last one so need to
			pv.next();                                                                               //run 1 extra time and remove the extre count
			while(nt.next() == nu) {                                                                 //do the same with the right side ball
				count++;
			}
			if(count  >= 3) {                                                                       //if count over 3 then remove between
				removeBetween(pv,nt,count);
				score += count;
			}
			
		}
		
		
	}

	
	public void removeBetween(DListIterator left, DListIterator right, int inc) {
		//fill code no loop
		if(left.currentNode == right.currentNode || left.currentNode.nextNode == right.currentNode) {             //if there is nothing between then return
			return;
		}
		left.currentNode.nextNode = right.currentNode;                                                            //swap the pointer of left and right to point each other
		right.currentNode.previousNode = left.currentNode;                                                        //deleting every node between
		size -= inc;
	}

}
