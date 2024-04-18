
public class test {
	public static void main(String[] args) {
		int tableSize = 10000;
		for (int n = 100; n <= 9900; n += 100) {
			OpenAddressHashing linearHashing = new OpenAddressHashing(tableSize);
			OpenAddressHashing quadraticHashing = new OpenAddressHashing(tableSize);
			int[] data = new int[n];
			int linear = 0;
			int quadratic = 0;
			for (int i = 0; i < data.length; i++) {
				data[i] = (int) (Math.random() * 10e6);
			}
			for (int j : data) {
				linear += linearHashing.insertLinear(j);
				quadratic += quadraticHashing.insertQuadratic(j);
			}
			System.out.println(n + "," + linear + "," + quadratic);
		}
	}
}
