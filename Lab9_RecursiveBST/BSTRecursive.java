import java.security.DomainCombiner;
import java.util.Arrays;

public class BSTRecursive {

	BSTNode root;
	int size;

	public BSTRecursive(BSTNode root, int size) {
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

	public Iterator findMin() {
		return findMin(root);
	}

	public Iterator findMin(BSTNode n) {
		if (n == null)
			return null;
		if (n.left == null) {
			Iterator itr = new TreeIterator(n);
			return itr;
		}
		return findMin(n.left);
	}

	public Iterator findMax() {
		return findMax(root);
	}

	public Iterator findMax(BSTNode n) {
		if (n == null)
			return null;
		if (n.right == null) {
			Iterator itr = new TreeIterator(n);
			return itr;
		}
		return findMax(n.right);
	}

	public Iterator find(int v) {
		return find(v, root);
	}

	public Iterator find(int v, BSTNode n) {
		if (n == null)
			return null;
		if (v == n.data)
			return new TreeIterator(n);
		if (v < n.data)
			return find(v, n.left);
		else
			return find(v, n.right);
	}

	public BSTNode insert(int v) {
		return insert(v, root, null);
	}

	// return the node n after v was added into the tree
	public BSTNode insert(int v, BSTNode n, BSTNode parent) {
		if (n == null) {
			n = new BSTNode(v, null, null, parent);
			size++;
		} else if (v < n.data) {
			n.left = insert(v, n.left, n);
		} else if (v > n.data) {
			n.right = insert(v, n.right, n);
		}
		return n;
	}

	public BSTNode remove(int v) {
		return remove(v, root, null);
	}

	// return the node n after v was removed from the tree
	public BSTNode remove(int v, BSTNode n, BSTNode parent) {
		if (n == null)
			; // do nothing, there is nothing to be removed
		else if (v < n.data) {
			n.left = remove(v, n.left, n);
		} else if (v > n.data) {
			n.right = remove(v, n.right, n);
		} else {
			if (n.left == null && n.right == null) {
				n.parent = null; // disconnect from above
				n = null; // disconnect from below
				size--;
			} else if (n.left != null && n.right == null) {
				BSTNode n2 = n.left;
				n2.parent = parent;
				n.parent = null; // disconnect from above
				n.left = null; // disconnect from below
				n = n2; // change to the node below
						// to prepare for connection from parent
				size--;
			} else if (n.right != null && n.left == null) {
				BSTNode n2 = n.right;
				n2.parent = parent;
				n.parent = null; // disconnect from above
				n.right = null; // disconnect from below
				n = n2; // change to the node below
						// to prepare for connection from parent
				size--;
			} else {
				TreeIterator i = (TreeIterator) findMin(n.right);
				int minInRightSubtree = i.currentNode.data;
				n.data = minInRightSubtree;
				n.right = remove(minInRightSubtree, n.right, n);
			}
		}
		return n;
	}

	private int height(BSTNode n) {
		if (n == null)
			return -1;
		return 1 + Math.max(height(n.left), height(n.right));
	}

	/**************************************************************************************************/
	// Edit only the following methods.
	/**************************************************************************************************/

	/**
	 * Internal method to find the number of nodes in a given subtree using a
	 * recursive method.
	 * 
	 * @param n
	 *            the root of a given subtree
	 * @param v
	 *            the threshold 
	 * @return the number of nodes in which the data is less than v in the subtree 
	 */
	public int numNodesLessThan(BSTNode n,int v) {
		if(n == null) {                                            //if node is empty return 0
			return 0;
		}
		int numInLeft = numNodesLessThan(n.left,v);                //calculate the number of the node that is less than v on the left child of n
		int numInRight = numNodesLessThan(n.right,v);              //calculate number of node that is less than v on right child of n
		
		if(n.data < v) {                                           //return the number of less than node by adding the number of less than node on the left child
			return 1 + numInLeft + numInRight;                     //of n with the number of less than node on the right child
		} else {                                                   //if n is also less than v then add 1
			return numInLeft + numInRight;
		}
		
	}

	/**
	 * Internal method to count the number of leaves in a given subtree
	 * (recursively).
	 * 
	 * @param n
	 *            root node of a given subtree
	 * @param v
	 *            the threshold
	 * @return number of leaves in which the data is less than v in the subtree, 
	 */
	public int numLeavesLessThan(BSTNode n, int v) {
		if(n == null) {                                           //if node is empty return 0 
			return 0;
		}
		int numInLeft = numLeavesLessThan(n.left,v);              //calculate number of leaves that is less than v on the left child of n
		int numInRight = numLeavesLessThan(n.right,v);            //calculate number of leaves that is less than v on the right child of n
		
		if(n.left == null && n.right == null && n.data < v) {     //check if n is a leaves
			return 1;                                             //if it is a leaves and is less than v then return 1;
		} else {                                                  //if n is not a leaves then return the sum of number of leaves that is
			return numInLeft + numInRight;                        //less than v on the left child and right child of n
		}                                                         //if n is a leaves but more than v then it will be 0 + 0 since
		                                                          //n.left and n.right is null
		
	}

	/**
	 * In order insert all nodes from a BST that has n as the root node. 
	 * 
	 * @param n
	 *            the node that roots the subtree.
	 * 
	 */
	public void insertInOrder(BSTNode n) {
		if(n == null) {                                          //return if nothing to insert
			return;
		}
		insert(n.data);                                          //insert the data of n into the tree using insert() function
		insertInOrder(n.left);                                   //recursive to repeatedly insert the left and right child of n
		insertInOrder(n.right);                                  //tldr; it will keep insert the left/right child of left/right child of n until no child left
	}
	
	/**
	 * Find the next data of v in the subtree which has n as the root node
	 * 
	 * @param n
	 *            root node of a given subtree
	 * @param v
	 *            the value v
	 * @return next data of v in the given subtree 
	 */
	public int nextOf(BSTNode n,int v) {
				if (n == null) {
					return v;
				}
				
				if (n.data > v) {                               //check if n is a potential candidate for nextOf
					int left = nextOf(n.left, v);               //check to the left until there is no left child left
					
					if (left == v) {                            //if there are no other candidate then return the candidate
						return n.data;
					} else {
						return left;                            //if there are other candidate then return that candidate
					}
				} else {
					return nextOf(n.right, v);                  //if there are no candidate to the left then add the right child as candidate
				}
	}
	
	public int sumOf(BSTNode n) {
		if(n == null) {         
			return 0;
		}
		
		int sumLeft = sumOf(n.left);                            //find the sum of the left child of n
		int sumRight = sumOf(n.right);                          //find the sum of the right child of n
		
		return n.data + sumLeft + sumRight;                     //add the value of n and the sum of its left and right child
	}
	
	public static void main(String[] args) {
		BSTNode r = new BSTNode(7);
        BSTRecursive t = new BSTRecursive(r, 1);
        t.insert(3);
        t.insert(1);
        t.insert(11);
        t.insert(2);
        t.insert(5);
        t.insert(9);
        t.insert(6);
        BTreePrinter.printNode(r);
	}

}
