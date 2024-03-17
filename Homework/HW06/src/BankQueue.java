
public class BankQueue { // must work for any implementation of DeQ
	DeQ[] counters;
	DeQ special;

	public BankQueue(DeQ[] counters, DeQ special) {
		super();
		this.counters = counters;
		this.special = special;
	}

	//Write this method
	public void distribute() throws Exception {
		double total=0;
		for(int i=0;i<counters.length;i++) {
			total+=counters[i].size();
		}
		total=total/(counters.length+1);
		int needed = (int) ((total-Math.floor(total)<0.5) ? Math.floor(total) : Math.floor(total)+1);
		int i=0;
		while(true) {
			if (special.size()==needed) return;
			if (i==counters.length) {
				special.insertLast(counters[i-1].removeLast());
				break;
			}
			DeQArray temp = new DeQArray();
			while (counters[i].size()-needed!=0) {
				temp.insertLast(counters[i].removeLast());
			}
			while (temp.size()!=0 && special.size()!=needed) {
				special.insertLast(temp.removeLast());
			}
			if(temp.size()!=0) {
				counters[i].insertLast(temp.removeLast());
			}
			i++;
		}
	}

}
