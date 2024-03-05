
public class DListNode {
	char data;
	DListNode nextNode, previousNode;

	DListNode(char data) {
		this(data, null, null);
	}

	DListNode(char theElement, DListNode n, DListNode p) {
		data = theElement;
		nextNode = n;
		previousNode = p;
	}

}
