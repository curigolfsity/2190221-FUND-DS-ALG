
public class StudentList extends CDLinkedList {
    // you can write additional methods.
	public StudentList() {
		super();
	}
	// implement this method
	public void swapNode(DListIterator i1, DListIterator i2) {
		DListIterator left1 = new DListIterator(((DListIterator) i1).currentNode.previousNode);
		DListIterator right1 = new DListIterator(((DListIterator) i1).currentNode.nextNode);
		DListIterator left2 = new DListIterator(((DListIterator) i2).currentNode.previousNode);
		DListIterator right2 = new DListIterator(((DListIterator) i2).currentNode.nextNode);
		
		left1.currentNode.nextNode = ((DListIterator) i2).currentNode;
		((DListIterator) i2).currentNode.previousNode = left1.currentNode;
		
		right1.currentNode.previousNode = ((DListIterator) i2).currentNode;
		((DListIterator) i2).currentNode.nextNode = right1.currentNode;
		
		left2.currentNode.nextNode = ((DListIterator) i1).currentNode;
		((DListIterator) i1).currentNode.previousNode = left2.currentNode;
		
		right2.currentNode.previousNode = ((DListIterator) i1).currentNode;
		((DListIterator) i1).currentNode.nextNode = right2.currentNode;
	}
	
	// implement this method
	public void insertList(DListIterator i1, CDLinkedList lst) {
		if (lst.isEmpty()) return;
		DListIterator p1 = new DListIterator(((DListIterator) i1).currentNode.nextNode);
		DListIterator first = new DListIterator(lst.header.nextNode);
		DListIterator last = new DListIterator(lst.header.previousNode);
		
		i1.currentNode.nextNode = first.currentNode;
		first.currentNode.previousNode = i1.currentNode;
		
		p1.currentNode.previousNode = last.currentNode;
		last.currentNode.nextNode = p1.currentNode;
	}

	// implement this method
	public void gender(String g) throws Exception {
		StudentList s1 = new StudentList();
		DListIterator itr1 = new DListIterator(s1.header);
		StudentList s2 = new StudentList();
		DListIterator itr2 = new DListIterator(s2.header);
		DListIterator itr = new DListIterator(header);
		while (true) {
			itr.next();
			if(itr.currentNode == header) break;
			
			if (((Student) itr.currentNode.data).getSex() == g) {
				s1.insert(itr.currentNode.data,itr1);
				itr1.next();

			}
			else {
				s2.insert(itr.currentNode.data,itr2);
				itr2.next();
			}
		}
		s1.insertList(itr1,s2);
		makeEmpty();
		DListIterator s1_first = new DListIterator(s1.header.nextNode);
		DListIterator s1_last = new DListIterator(s1.header.previousNode);
		header.nextNode = s1_first.currentNode;
		s1_first.currentNode.previousNode = header;
		header.previousNode = s1_last.currentNode;
		s1_last.currentNode.nextNode = header;



		
	}

}
