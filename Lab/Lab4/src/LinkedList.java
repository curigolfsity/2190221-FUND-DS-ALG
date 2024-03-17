class ListNode {
	// Constructors
	ListNode(Object theElement) {
		this(theElement, null);
	}

	ListNode(Object theElement, ListNode n) {
		data = theElement;
		nextNode = n;
	}

	// Friendly data; accessible by other package routines
	Object data;
	ListNode nextNode;
}

public class LinkedList {
	ListNode header;

	public LinkedList() {
		header = new ListNode(null);
	}
//

	/** make the list empty. */
	public void makeEmpty() {
		header.nextNode = null;
	}

	public void insert(Object value, Iterator p) throws Exception {
		if (p == null || !(p instanceof MyListIterator))
			throw new Exception();
		MyListIterator p2 = (MyListIterator) p;
		if (p2.currentNode == null)
			throw new Exception();
		ListNode n = new ListNode(value, p2.currentNode.nextNode);
		p2.currentNode.nextNode = n;
	}

	public int find(Object value) throws Exception {
		Iterator itr = new MyListIterator(header);
		int index = -1;
		while (itr.hasNext()) {
			Object v = itr.next();
			index++;
			if (v.equals(value))
				return index; // return the position of value.
		}
		return -1;
	}

	public Iterator findPrevious(Object value) throws Exception {
		Iterator itr1 = new MyListIterator(header);
		Iterator itr2 = new MyListIterator(header);
		if (!itr2.hasNext())
			return null;
		Object currentData = itr2.next();
		while (!currentData.equals(value) && itr2.hasNext()) {
			currentData = itr2.next();
			itr1.next();
		}
		if (currentData.equals(value))
			return itr1;
		return null;

	}
	
	public void remove(Iterator p) {
		if (p == null || !(p instanceof MyListIterator))
			return;
		MyListIterator p2 = (MyListIterator) p;
		if (p2.currentNode == null || p2.currentNode.nextNode == null)
			return;
		p2.currentNode.nextNode = p2.currentNode.nextNode.nextNode;
	}

	public void remove(Object value) throws Exception {
		Iterator p = findPrevious(value);
		if (p == null)
			return;
		remove(p);
	}

	// Returns the number of data stored in this list.
	// To be completed by students.
	public int size() throws Exception{
		Iterator itr = new MyListIterator(header);
		int index = 0;
		while (itr.hasNext()) {
			Object v = itr.next();
			index++;
			if (v == null)
				return index; // return the position of value.
		}
		return index;

	}
	
	// Print each contact out, one by one.
	// To be completed by students.
	public void printList() throws Exception{
		Iterator itr = new MyListIterator(header);
		while (itr.hasNext()) {
			Object v = itr.next();
			System.out.println(((Contact) v));
			
		}
	}

	//Return iterator pointing to value that stores a given name, or null otherwise.
	//To be completed by students.
	public Iterator findPosition(String name) throws Exception{
		Iterator itr = new MyListIterator(header);
		while (itr.hasNext()) {
			Object v = itr.next();
			if (((Contact) v).name.equals(name))
				return itr; // return the position of value.
		}
		return null;
	}
	
	//add a new contact to the list the contact must be added in such a way that each contact is sorted by name, in alphabetical order.	
	public void add(Object c) throws Exception{
		Iterator itr1 = new MyListIterator(header);
		Iterator itr2= new MyListIterator(header);
		if (!itr2.hasNext()) {
			insert(c,itr2);
			return;
		}
		while (itr2.hasNext()) {
			Object v = itr2.next();
			if ((((Contact) c).name.compareTo(((Contact) v).name)<=0)  ){
				itr2= itr1;
				insert(c,itr2);
				return;
			}
			if (!itr2.hasNext()){
				insert(c,itr2);
				return;
			}
			itr1.next();
		}
	}
	
	//Remove the contact pointed by the iterator, i, and then returns an iterator pointing to the next contact. 
	//If the removed contact is the last one, return the iterator pointing to the first contact 
	//   (if there is no first contact, make the iterator point to header). 
	//If i is marking an illegal position that cannot be removed, just return null. 
	//To be completed by students.
	public Iterator removeAt(Iterator i) throws Exception{
		MyListIterator i2 = (MyListIterator) i;
		if (i == null || !(i instanceof MyListIterator))
			return null;
		if (i2.currentNode==null|| i2.currentNode==header)
			return null;
		Iterator itr1 = new MyListIterator(header);
		Iterator itr2 = new MyListIterator(header);
		Iterator itr3 = new MyListIterator(header);
		if (!itr2.hasNext())
			return null;
		itr2.next();
		while (((MyListIterator) itr2).currentNode!=((MyListIterator) i).currentNode && itr2.hasNext()) {
			itr2.next();
			itr1.next();
		}
		if (((MyListIterator) itr2).currentNode==((MyListIterator) i).currentNode) {
			if (!itr2.hasNext()) {
				remove(itr1);
				if(!itr3.hasNext()){
					return itr3;
				}
				itr3.next();
				return itr3;
			}
			remove(itr1);
			itr2.next();
			return itr2;
		}
		return null;
	}
	

}