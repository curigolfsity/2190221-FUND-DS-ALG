
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
		super.insert(value,p);
		DListNode inserted=((DListIterator) p).currentNode.nextNode;
		DListIterator left=new DListIterator(inserted.previousNode);
		DListIterator right=new DListIterator(inserted.nextNode);
		
		int foundNode=1;
		int checkValue=value;
		
		while(true) {
			while(left.currentNode.data==checkValue) {
				foundNode++;
				left.previous();
			}
			while(right.currentNode.data==checkValue) {
				foundNode++;
				right.next();
			}
			if (foundNode < 3) break;
			else {
				this.removeBetween(left,right,foundNode);
				score+=foundNode;
				if (left.currentNode.data == right.currentNode.data) {
					checkValue = left.currentNode.data;
					foundNode = 0;
				} else break;
			}
		}
		
	}

	
	public void removeBetween(DListIterator left, DListIterator right, int inc) {
		//fill code
		DListIterator p1=(DListIterator) left;
		DListIterator p2=(DListIterator) right;
		if(p1.currentNode.nextNode==p2.currentNode || p1.currentNode==p2.currentNode)
			return;
		left.currentNode.nextNode = p2.currentNode;
		right.currentNode.previousNode = p1.currentNode;
		size-=inc;
	}

}
