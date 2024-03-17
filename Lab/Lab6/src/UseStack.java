
public class UseStack {
	
	//implement this method.
	public static Stack sort(Stack s) throws Exception {
		ArrayListStack a = new ArrayListStack();
		ArrayListStack temp = new ArrayListStack();
		if (s.isEmpty()) return new ArrayListStack();
		a.push(s.top());
		s.pop();
		while (!s.isEmpty()) {
			if (!a.isEmpty()) {
				if (a.top() <= s.top()) {
				temp.push(a.top());
				a.pop();
				}
				else {
					a.push(s.top());
					s.pop();
					while(!temp.isEmpty()) {
						a.push(temp.top());
						temp.pop();
					}
				}
			}
			else {
				a.push(s.top());
				s.pop();
				while(!temp.isEmpty()) {
					a.push(temp.top());
					temp.pop();
				}
			} 

		}
		return a;
		
		
		
//		ArrayListStack temp = new ArrayListStack();
//		if (s==null) return null;
//		int max = s.top();
//		int max1 = s.top();
//		s.pop();
//		while(!s.isEmpty()) {
//			if(s.top()>max) {
//				temp.push(max);
//				max = s.top();
//				s.pop();
//			}
//			else {
//				temp.push(s.top());
//				s.pop();
//			}
//		}
//		if(max1 == max) {
//			return temp;
//		}
//		else {
//			return sort(temp);
//		}
	}
	
}

