
public class TernaryHeap extends Heap{
	int size=0;
	int[] mData;
	public TernaryHeap() {
		// TODO Auto-generated constructor stub
		final int DEFAULT_CAPACITY = 31;
		mData = new int[DEFAULT_CAPACITY];
	}
	public void add(int element) {
		if (++size == mData.length) {
			int[] newHeap = new int[2 * mData.length];
			System.arraycopy(mData, 0, newHeap, 0, size);
			mData = newHeap;
		}
		mData[size - 1] = element;
		percolateUp();
		
	}

	protected void percolateUp() {
		int parent;
		int child = size - 1;
		int temp;
		while (child > 0) {
			parent = (child - 1) / 3;
			if (mData[parent] <= mData[child])
				break;
			temp = mData[parent];
			mData[parent] = mData[child];
			mData[child] = temp;
			child = parent;
		}
	}

	public int top() throws Exception {
		if (size == 0)
			throw new Exception("Empty");
		return mData[0];
	}

	public int pop() throws Exception {
		if (size == 0)
			throw new Exception("Priority queue empty.");
		int minElem = mData[0];
		mData[0] = mData[size - 1];
		size--;
		percolateDown(0);
		return minElem;
	}

	protected void percolateDown(int start) {
		int parent = start;
		int child = 3 * parent + 1;
		int temp;
		while (child < size) {
			if (child < size - 1) {
				int index = 0;
				int min=99999;
				for (int i=0;i<3;i++) {
					if(mData[child+i]<min) {
						index=i;
						min=mData[child+i];
					}
				}
				child=child+index;
			}
			if (mData[parent] <= mData[child])
				break;
			temp = mData[child];
			mData[child] = mData[parent];
			mData[parent] = temp;
			parent = child;
			child = 3 * parent + 1;
		}
	}

	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
	
	

}
