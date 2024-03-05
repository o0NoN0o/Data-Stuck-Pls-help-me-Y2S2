import java.util.ArrayList;

public class BSTList {
	BSTNodeList root;
	int size;
	
	public BSTList() {
		root = null;
		size = 0;
	}
	
	public BSTList(BSTNodeList root, int size) {
		this.root = root;
		this.size = size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}

	public void makeEmpty() {
		root = null;
		size = 0;
	}
	
	public BSTNodeList find(Comparable v) { 
		BSTNodeList temp = root;
		while(temp != null && temp.dataList.get(0).compareTo(v) != 0) {     //find if the first value of pairdata exist
			if(temp.dataList.get(0).compareTo(v) > 0) {
				temp = temp.left;
			} else {
				temp = temp.right;
			}
		}
		if(temp == null) {  //return if the first value of pairdata doesnt exist
			return null;
		}
		for(int i = 0; i < temp.dataList.size(); i++) {     //run through every pairdata in the node
			if(v.equals(temp.dataList.get(i))) {            //return if found the pair
				return temp;
			}
		}
		return null;
	}
	
	public BSTNodeList insert(Comparable v) {
		BSTNodeList temp = root;
		BSTNodeList b4End = root;
		while(temp != null && temp.dataList.get(0).compareTo(v) != 0) {           //find if the first value of the pairdata exist
			if(temp.dataList.get(0).compareTo(v) > 0) {
				b4End = temp;                                                   //b4End will be the last nodebefore terminate
				temp = temp.left;
			} else {
				b4End = temp;
				temp = temp.right;
			}
		}
		if(temp == null) {
			ArrayList<Pairdata> d = new ArrayList<Pairdata>();                   //create new arraylist if the first value of v doesnt exist
			d.add((Pairdata) v);                                                 //add the pairdata into the arraylist
			BSTNodeList n = new BSTNodeList();                                   //create new node and assign the arraylist as data
			n.dataList = d;
			if(b4End.dataList.get(0).compareTo(v) < 0) {                         //check if the first value of v is greater than or less than the closest value
				//goright
				b4End.right = n;                                                 //add the node to tree
				size ++;
			} else {
				b4End.left = n;
				size++;
			}
			return n;                                                            
		}
		for(int i = 0; i < temp.dataList.size(); i++) {                          //if there is a node with the same first value as v continue here
			if(v.equals(temp.dataList.get(i))) {                                 //run through the arraylist of the node to check for dupe
				return temp;
			}
		}
		temp.dataList.add((Pairdata) v);                                         //if no dupe then add the pairdata v to the existing node                       
		size++;
		return temp;

	}
	
	public BSTNodeList findMin(BSTNodeList n) {
		BSTNodeList temp = n;
		if (temp == null)
			return null;
		while (temp.left != null) {
			temp = temp.left;
		}
		return temp;
	}

	

	
}
