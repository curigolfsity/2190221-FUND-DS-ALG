import static org.junit.Assert.*;

import java.io.FileWriter;

import org.junit.Test;

public class TestMaxHeap {

	@Test
	public void test() throws Exception {
		int[] x = {20,40,10,5,100,79,26,30};
		Heap h = new MaxIntHeap();
		for(int i=0;i<x.length;i++) 
			h.add(x[i]);
		assertEquals(100,h.pop());
		assertEquals(79,h.pop());
		assertEquals(40,h.pop());
		
		
        FileWriter writer = new FileWriter("./count.txt");
        int[] Size = {100,10000,1000000};
        for(int size:Size) {
        int[] data = new int[size];
        for(int i=0;i<data.length;i++) {
            data[i] = (int) (Math.random()*10e6);   
        }
        Heap check = new Heap();
        long a =0;
        long b =0;
        long start = System.currentTimeMillis();
        for (int i:data) {
        	check.add(i);   		
        }
        long time = System.currentTimeMillis()- start;
        a+= time;
        long start2 = System.currentTimeMillis();
        for (int i=0;i<data.length-1;i++) {
        	check.pop();   		
        }
        long time2 = System.currentTimeMillis()- start2;
        b+= time2;
         
        writer.write(size+ "," + a + "," + b + "\n");
        }
        writer.close();
	}
	

}
