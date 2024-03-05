import java.util.ArrayList;

public class BSTNodeList {
	ArrayList<Pairdata> dataList; // value stored in the node.
	BSTNodeList left; //pointer to lower left BSTNode.
	BSTNodeList right; //pointer to lower right BSTNode.
	BSTNodeList parent; //pointer to the BSTNode above.

	public BSTNodeList(){
		this(new ArrayList<Pairdata>(),null,null,null);
	}
	
	public BSTNodeList(ArrayList<Pairdata> data, BSTNodeList left, BSTNodeList right, BSTNodeList parent) {
		this.dataList = data;
		this.left = left;
		this.right = right;
		this.parent = parent;
	}
	
	
}
