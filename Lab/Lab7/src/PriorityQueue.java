
public class PriorityQueue {
	MyQueue q;
	

	public PriorityQueue(MyQueue q) {
		super();
		this.q = q;
	}

	// implement this.
	public void push(int x) throws Exception {
		if(q.isEmpty()) {
			q.insertLast(x);
			return;
		}
		
		if(q.size()==1) {
			if (q.front()<=x) q.insertLast(x);
			else {
				q.insertLast(x);
				q.insertLast(q.removeFirst());
			}
		}
		else {
			int min = x<q.front() ? x : q.front();
			while(true) {
				if (q.front()<x) q.insertLast(q.removeFirst());
				else {
					q.insertLast(x);
					while(q.front()!=min) {
						q.insertLast(q.removeFirst());
					}
					return;
				}
			}
		}
	}

	// implement this.
	public void pop() throws Exception {
		q.removeFirst();

	}

	// implement this
	public int top() throws Exception {
		return q.front();
		
	}

}
