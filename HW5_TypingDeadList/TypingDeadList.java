
public class TypingDeadList extends CDLinkedList {
	int score = 0;  //not used in this exam
	DListIterator start = null; // the first position of a word to remove
	DListIterator end = null; // last position of a word to remove

	public TypingDeadList() throws Exception {
		this("");
	}

	public TypingDeadList(String s) throws Exception {
		// initialize the list
		// each data comes from each character in s
		int n = s.length();
		DListIterator d = new DListIterator(header);
		for (int i = n - 1; i >= 0; i--) {
			insert(s.charAt(i), d);
		}

	}

	public void removeWord(String w) throws Exception {
		// remove the first occurrence of w
		// if w is not in the list, do nothing
		// reset start and end to null no matter what
		findWord(w);
		if (start == null)
			return;

		int dec = w.length();
		remove(dec);

	}

	public void findWord(String w) throws Exception {
		// update start and end to mark position of the first occurrence of w
		// The word cannot cross header node
		// If w is not in the list, do nothing.
		// w is assumed never to be an empty string.
		
		DListIterator p = new DListIterator(header.nextNode);                       //mark the first node after header will be use as iterator to find the start
		DListIterator s = new DListIterator(header);                                //will be use as start letter marker
		DListIterator e = new DListIterator(header);                                //will be use as end letter marker
		DListIterator t = new DListIterator(header);                                //will be use to check after the start is found if it is the whole word
		boolean fstart = false;                                                     //check if already found start char
		boolean fend = false;                                                       //check if already found end char
		char[] lett = w.toCharArray();                                              //change the letter in word to array
		while(p.hasNext() && p.currentNode.data != header.data) {                   //check if the 1st node(letter) is not null and has next node(letter)
			if(p.currentNode.data == lett[0]) {
				s.currentNode = p.currentNode;                                      //if found the first letter that is the same change s to mark the start letter
				t = p;                                                              //change t to be p to run t instead to check whether it is a whole word
				fstart = true;                                                      //mark found start
				for(int i = 1;i<= w.length()-1;i++) {                               //check with the same length as the input word
					t.next();
					if(lett[i] != t.currentNode.data) {                             //if the letter is not the same at one position mark found start false
						fstart = false;
					}
				}
				fend = true;                                                        //if every letter is same mark end true
				e.currentNode = t.currentNode;                                      //change the iterator e to point at the end of word
				break;
			}
			p.next();
		}
		
		if(fstart == true && fend == true) {                                       //if found both start and end then set the iterator
			start = s;
			end = e;
		}
		
		
		//fill code
	}

	public void remove(int dec) throws Exception { // this must be the last method in your code!
		// remove data from start to end, inclusive,
		// if start or end is at header, do nothing.
		// size to remove is one of the known parameter -> reduce the size parameter of
		// the list
		if(start == null || end == null) {                                        //if there is no start and end do nothing
			return; 
		}
		if(start.currentNode == header || end.currentNode == header) {
			return;
		}
		DListIterator bs = new DListIterator(header);
		DListIterator ae = new DListIterator(header);
		bs.currentNode = start.currentNode.previousNode;                         //mark the node before the start
		ae.currentNode = end.currentNode.nextNode;                               //mark node after end
		
		bs.currentNode.nextNode = ae.currentNode;                                //change the pointer
		ae.currentNode.previousNode = bs.currentNode;
		
		size -= dec;                                                            //- size
		
		
		//fill code
	}

}
