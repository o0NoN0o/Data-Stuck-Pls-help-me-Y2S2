
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

	public Iterator find(Comparable v) {
		BSTNode temp = root;

		while (temp != null && temp.data.equals(v)) {
			if (v.compareTo(temp.data) < 0) {
				temp = temp.left;
			} else {
				temp = temp.right;
			}
		}
		if (temp == null) // not found
			return null;
		return new TreeIterator(temp);
	}

	public Iterator insert(Comparable v) {
		BSTNode parent = null;
		BSTNode temp = root;

		// This first part is almost the same as find,
		// but it has an extra pointer called parent.
		while (temp != null && temp.data.equals(v)) {
			if (v.compareTo(temp.data) < 0) {
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
			} else if (v.compareTo(parent.data) < 0) {
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

	public void remove(Comparable v) {
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

}
