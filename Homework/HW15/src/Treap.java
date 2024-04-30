
public class Treap {
	TreapNode root;
	int size;
	public Treap() {
		// TODO Auto-generated constructor stub
		root = null;
		size =0;
	}
	
	public TreapNode insert(int v,int h) {
		TreapNode n = insertNoBalance(v,h);
		checkHeap(find(v));
		return n;
	}
		
	public TreapNode insertNoBalance(int v,int h) {
			return insertNoBalance(v,h, root, null);
		}

	private TreapNode insertNoBalance(int v,int h, TreapNode n, TreapNode parent) {
			if (n == null) {
				n = new TreapNode(v,h, null, null, parent);
				size++;
				if(root==null) {
					root=n;
				}
				
			} else if (v < n.bstValue) {
				n.left = insertNoBalance(v,h, n.left, n);
			} else if (v > n.bstValue) {
				n.right = insertNoBalance(v,h, n.right, n);
			}
			return n;
	}
		
		//PART-BST FIN
			
		//PART-HEAP START
	private TreapNode checkHeap(TreapNode n) {
		if(n.parent == null) {
			return n;
		}
		else if(n.parent.heapValue<=n.heapValue) {
			return n;
		}
		else if(n==n.parent.left) {
			n=rotateLeftChild(n.parent);
			
		}
		else {
			n=rotateRightChild(n.parent);
		}
		return checkHeap(n);
	}
	
	public TreapNode find(int v) {
		TreapNode temp = root;

		while (temp != null && temp.bstValue != v) {
			if (v < temp.bstValue) {
				temp = temp.left;
			} else {
				temp = temp.right;
			}
		}
		if (temp == null) // not found
			return null;
		return temp;
	}

	public TreapNode rotateLeftChild(TreapNode n) {
		TreapNode l = n.left;
		TreapNode lr = n.left.right; // can be null
		TreapNode pp = n.parent;
		n.left = lr;
		if (lr != null) {
			lr.parent = n;
		}
		l.right = n;
		l.parent = n.parent;
		n.parent = l;
		if(pp!=null) {
			if(pp.right==n)
			pp.right=l;
			else pp.left=l;
		}
		if(l.parent==null) {
			root=l;
		}
		return l;
	}

	public TreapNode rotateRightChild(TreapNode n) {
		TreapNode r = n.right;
		TreapNode rl = n.right.left; // can be null
		TreapNode pp = n.parent;
		n.right = rl;
		if (rl != null) {
			rl.parent = n;
		}
		r.left = n;
		r.parent = n.parent;
		n.parent = r;
		if(pp!=null) {
			if(pp.left==n)
			pp.left=r;
			else pp.right=r;
		}
		if(r.parent==null) {
			root=r;
		}
		return r;
	}


}
