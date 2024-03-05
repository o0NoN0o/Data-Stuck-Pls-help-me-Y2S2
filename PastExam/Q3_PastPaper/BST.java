
public class BST {
	BSTNode root;
	int size;

	public BST() {
		root = null;
		size = 0;
	}

	public BST(BSTNode root, int size) {
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

	public Iterator find(int v) {
		BSTNode temp = root;

		while (temp != null && temp.data != v) {
			if (v < temp.data) {
				temp = temp.left;
			} else {
				temp = temp.right;
			}
		}
		if (temp == null) // not found
			return null;
		return new TreeIterator(temp);
	}

	public Iterator insert(int v) {
		BSTNode parent = null;
		BSTNode temp = root;

		// This first part is almost the same as find,
		// but it has an extra pointer called parent.
		while (temp != null && temp.data != v) {
			if (v < temp.data) {
				parent = temp;
				temp = temp.left;

			} else {
				parent = temp;
				temp = temp.right;

			}
		}

		if (temp == null) {
			BSTNode n = new BSTNode(v, null, null, parent);
			if (parent == null) {
				root = n;
			} else if (v < parent.data) {
				parent.left = n;
			} else {
				parent.right = n;
			}
			size++;
			return new TreeIterator(n);
		} else {
			// we do nothing since
			// we don't want to add duplicated data.
			return null;
		}

	}

	public void remove(int v) {
		BSTNode parent = null;
		BSTNode temp = root;

		TreeIterator i = (TreeIterator) find(v);
		if (i == null) { // not found, we can not remove it
			return;
		}

		temp = i.currentNode;
		parent = temp.parent;

		// otherwise, we remove the value.
		size--;
		if (temp.left == null && temp.right == null) {// both subtrees are empty
			if (parent == null) {
				root = null;
			} else if (parent.left == temp) {
				parent.left = null;
			} else {
				parent.right = null;
			}
		} else if (temp.left == null && temp.right != null) {// only right child
			if (parent == null) {
				root = temp.right;
				root.parent = null;
			} else if (parent.right == temp) {
				BSTNode n = temp.right;
				n.parent = parent;
				parent.right = n;
				// temp.right = null;
				// temp.parent = null;
			} else {// parent.left == temp
				BSTNode n = temp.right;
				n.parent = parent;
				parent.left = n;
			}
		} else if (temp.right == null && temp.left != null) {
			if (parent == null) {
				root = temp.left;
				root.parent = null;
			} else if (parent.right == temp) {
				BSTNode n = temp.left;
				n.parent = parent;
				parent.right = n;
			} else {
				BSTNode n = temp.left;
				n.parent = parent;
				parent.left = n;

			}

		} else {// temp has two subtrees
			BSTNode n = temp.right;
			TreeIterator itr = (TreeIterator) (findMin(n));
			BSTNode minInSubtree = itr.currentNode;

			temp.data = minInSubtree.data;

			BSTNode parentOfMin = minInSubtree.parent;
			if (parentOfMin.left == minInSubtree) {
				parentOfMin.left = minInSubtree.right;

			} else { // parentOfMin.right == minInSubtree
				parentOfMin.right = minInSubtree.right;

			}

			if (minInSubtree.right != null) {
				minInSubtree.right.parent = parentOfMin;
			}

		}
	}

	public Iterator findMin() {
		BSTNode temp = root;
		if (temp == null)
			return null;
		while (temp.left != null) {
			temp = temp.left;
		}
		Iterator itr = new TreeIterator(temp);
		return itr;
	}

	public Iterator findMin(BSTNode n) {
		BSTNode temp = n;
		if (temp == null)
			return null;
		while (temp.left != null) {
			temp = temp.left;
		}
		Iterator itr = new TreeIterator(temp);
		return itr;
	}

	public Iterator findMax() {
		BSTNode temp = root;
		if (temp == null)
			return null;
		while (temp.right != null) {
			temp = temp.right;
		}
		Iterator itr = new TreeIterator(temp);
		return itr;
	}

	public Iterator findMax(BSTNode n) {
		BSTNode temp = n;
		if (temp == null)
			return null;
		while (temp.right != null) {
			temp = temp.right;
		}
		Iterator itr = new TreeIterator(temp);
		return itr;
	}

	public void addLeftSubTreeToNode(BST subtree, BSTNode n) {
		if (subtree.isEmpty())
			return;

		if (n == null) {
			root = subtree.root;
			size = subtree.size;
			return;
		}

		boolean ok1 = false;
		boolean ok2 = false;
		TreeIterator i = (TreeIterator) (subtree.findMax());
		int maxInSubtree = i.currentNode.data;
		if (maxInSubtree < n.data) {
			ok1 = true;
		}

		//FILL IN CODE BELOW //////////////////////////////////////////////
		TreeIterator t = (TreeIterator) (subtree.findMin());                 //find the min in subtree
		int minSub = t.currentNode.data;
		TreeIterator r = new TreeIterator(root);
		BSTNode temp = n;
		BSTNode temp2 = n;
		while(temp.data != r.currentNode.data) {                            //check until reach root if the min in subtree will be the right child
			temp2 = temp;
			temp = temp.parent;
			if(temp.right == temp2 && minSub < temp.data) {                 //if there is a node where the subtree will be the right child of that is
				return;                                                     //bigger than min of subtree then return
			}
		}
		ok2 = true;		
		

		//FILL IN CODE ABOVE ////////////////////////////////////////////
		
		if (ok1 && ok2) {
			subtree.root.parent = n;
			n.left = subtree.root;
			this.size += subtree.size;
		} else {
			return;
		}
	}

	public static void main(String[] args) throws Exception {
		// Printing example.
		// You can print how the tree looks to help with debugging.

		BST t0 = new BST();
		BST t1 = new BST();

		t0.insert(20);
		t0.insert(10);
		t0.insert(30);
		t0.insert(5);
		t0.insert(15);
		t0.insert(25);
		t0.insert(35);
	
		t1.insert(23);
		t1.insert(31);
		t1.insert(21);
		t1.insert(22);

		BTreePrinter.printNode(t0.root);
		BTreePrinter.printNode(t1.root);

	}

}
