public class AVLTree {

	AVLNode root;

	int size;

	public AVLTree() {

		root = null;

		size = 0;

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

	public Iterator findMin(AVLNode n) {

		if (n == null)

			return null;

		if (n.left == null) {

			Iterator itr = new AVLTreeIterator(n);

			return itr;

		}

		return findMin(n.left);

	}

	public Iterator findMax() {

		return findMax(root);

	}

	public Iterator findMax(AVLNode n) {

		if (n == null)

			return null;

		if (n.right == null) {

			Iterator itr = new AVLTreeIterator(n);

			return itr;

		}

		return findMax(n.right);

	}

	public Iterator find(int v) {

		return find(v, root);

	}

	public Iterator find(int v, AVLNode n) {

		if (n == null)

			return null;

		if (v == n.data)

			return new AVLTreeIterator(n);

		if (v < n.data)

			return find(v, n.left);

		else

			return find(v, n.right);

	}

	public AVLNode insert(int v) {

		return insert(v, root, null);

	}

	// return the node n after v was added into the tree

	public AVLNode insert(int v, AVLNode n, AVLNode parent) {

		if (n == null) {

			n = new AVLNode(v, null, null, parent, 0);

			size++;

		} else if (v < n.data) {

			n.left = insert(v, n.left, n);

		} else if (v > n.data) {

			n.right = insert(v, n.right, n);

		}

		n = rebalance(n);

		return n;

	}

	public AVLNode insertNoBalance(int v) {

		return insertNoBalance(v, root, null);

	}

	private AVLNode insertNoBalance(int v, AVLNode n, AVLNode parent) {

		if (n == null) {

			n = new AVLNode(v, null, null, parent, 0);

			size++;

		} else if (v < n.data) {

			n.left = insertNoBalance(v, n.left, n);

		} else if (v > n.data) {

			n.right = insertNoBalance(v, n.right, n);

		}

		AVLNode.updateHeight(n);

		return n;

	}

	public AVLNode remove(int v) {

		return remove(v, root, null);

	}

	// return the node n after v was removed from the tree

	public AVLNode remove(int v, AVLNode n, AVLNode parent) {

		if (n == null)

			; // do nothing, there is nothing to be removed

		else if (v < n.data) {

			n.left = remove(v, n.left, n);

		} else if (v > n.data) {

			n.right = remove(v, n.right, n);

		} else {

			if (n.left == null && n.right == null) {

				n = null;

				size--;

			} else if (n.left != null && n.right == null) {

				n.left.parent = parent;

				n = n.left;

				size--;

			} else if (n.right != null && n.left == null) {

				n.right.parent = parent;

				n = n.right;

				size--;

			} else {

				AVLTreeIterator i = (AVLTreeIterator) findMin(n.right);

				int minInRightSubtree = i.currentNode.data;

				n.data = minInRightSubtree;

				n.right = remove(minInRightSubtree, n.right, n);

			}

		}

		n = rebalance(n);

		return n;

	}

	public AVLNode rebalance(AVLNode n) {

		if (n == null)

			return n;

		int balance = AVLNode.tiltDegree(n);

		if (balance >= 2) {

			if (AVLNode.tiltDegree(n.left) <= -1) // 3rd case

				n.left = rotateRightChild(n.left);

			n = rotateLeftChild(n); // 1st case

		} else if (balance <= -2) {

			if (AVLNode.tiltDegree(n.right) >= 1) // 4th case

				n.right = rotateLeftChild(n.right);

			n = rotateRightChild(n); // 2nd case

		}

		AVLNode.updateHeight(n);

		return n;

	}

	public AVLNode rotateLeftChild(AVLNode n) {

		AVLNode l = n.left;

		AVLNode lr = n.left.right; // can be null

		n.left = lr;

		if (lr != null) {

			lr.parent = n;

		}

		l.right = n;

		l.parent = n.parent;

		n.parent = l;

		AVLNode.updateHeight(n);

		AVLNode.updateHeight(l);

		return l;

	}

	public AVLNode rotateRightChild(AVLNode n) {

		AVLNode r = n.right;

		AVLNode rl = n.right.left; // can be null

		n.right = rl;

		if (rl != null) {

			rl.parent = n;

		}

		r.left = n;

		r.parent = n.parent;

		n.parent = r;

		AVLNode.updateHeight(n);

		AVLNode.updateHeight(r);

		return r;

	}

	

	public AVLNode subTreeAVL(AVLNode n) {

		if(n.height == 1)

			return n;

		if(n.left != null) {

			n.left = subTreeAVL(n.left);

		}

		if(n.right != null) {

			n.right = subTreeAVL(n.right);

		}

		return rebalance(n);

	}

	public void makeAVL() throws Exception {

		//code this method

//		this.root = subTreeAVL(this.root);

		this.root = rebalanceWithHigherDegree(this.root,AVLNode.tiltDegree(this.root));

	}

	public boolean isAVL(AVLNode n) {

		if(n == null) return true;

		if(Math.abs(AVLNode.tiltDegree(n)) <= 1) {

			return isAVL(n.left)&& isAVL(n.right);

		}

		return false;

	}

	public boolean isAVL() {

		// code this method

		return isAVL(this.root);

	}

	public AVLNode rebalanceWithHigherDegree(AVLNode n, int tiltDegree) {

		if(Math.abs(tiltDegree) <= 2)

			return this.rebalance(n);

		AVLNode newN=n;

		if(tiltDegree > 0) {

			for(int i=0;Math.abs(AVLNode.tiltDegree(newN)) > 1;i++) {

				newN = this.rotateLeftChild(newN);

				BTreePrinter.printNode(newN);

			}

		}

		else{

			for(int i=0;Math.abs(AVLNode.tiltDegree(newN)) > 1;i++) {

				newN = this.rotateRightChild(newN);

				BTreePrinter.printNode(newN);

			}			

		}

		return newN;

	}

	public static void main(String[] args) throws Exception {

		// example: print a tree

		AVLTree t = new AVLTree();

		t.root = t.insertNoBalance(33);

		t.root = t.insertNoBalance(70);

		t.root = t.insertNoBalance(66);

		t.root = t.insertNoBalance(10);

		t.root = t.insertNoBalance(8);

		t.root = t.insertNoBalance(4);

		t.root = t.insertNoBalance(1);

		t.root = t.insertNoBalance(2);

		t.root = t.insertNoBalance(6);

		t.root = t.insertNoBalance(3);

		System.out.println(AVLNode.tiltDegree(t.root));

		BTreePrinter.printNode(t.root);

		t.makeAVL();

		BTreePrinter.printNode(t.root);

	}

}

