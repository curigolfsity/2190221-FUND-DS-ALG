
public class StackUtility {
	static String alphabets = "abcdefghijklmnopqrstuvwxyz";
	
	public static String operate(MyStack s1, MyStack s2) throws Exception {
		MyStack s3 = new StackArray();
		String word = new String();
		while(!s2.isEmpty() && !s1.isEmpty()) {
				int a=s1.top();
				s1.pop();
				if(s1.isEmpty()) break;
				int b=s1.top();
				s1.pop();
				int c = (s2.top()<0) ? a-b : a+b;
				s2.pop();
				s3.push(c);
		}
		while(!s3.isEmpty()) {
			word+=alphabets.charAt(s3.top());
			s3.pop();
		}
		return word;

	}
}
