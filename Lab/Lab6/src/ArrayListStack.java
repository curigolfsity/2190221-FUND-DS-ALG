import java.util.ArrayList;

public class ArrayListStack implements Stack {
	private ArrayList<Integer> a;
	// implement a default constructor and all methods from interface Stack.
	// Additional methods maybe required in order to run tests.
	public ArrayListStack() {
		a = new ArrayList<Integer>();
	}

	public ArrayList<Integer> getA() {
		return a;
	}

	@Override
	public boolean isEmpty() {
		return (a.size() == 0);
	}

	@Override
	public boolean isFull() {
		return a.size() >= 100000;
	}

	@Override
	public void makeEmpty() {
		a = new ArrayList<Integer>();
		
	}

	@Override
	public int top() throws Exception {
		if(isEmpty()) throw new EmptyStackException();
		return a.get(a.size()-1);
	}

	@Override
	public void pop() throws Exception {
		if(isEmpty()) throw new EmptyStackException();
		int last = a.size()-1;
		a.remove(last);
	}

	@Override
	public void push(int data) throws Exception {
		a.add(data);
	}

}
