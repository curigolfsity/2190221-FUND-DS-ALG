import java.util.Arrays;

class OpenAddressHashing {
	private final int[] table;
	private final int size;
	private final int EMPTY = -1;

	public OpenAddressHashing(int size) {
		this.size = size;
		table = new int[size];
		Arrays.fill(table, EMPTY);
	}

	// Hash function using linear probing
	private int linearProbe(int key, int i) {
		return (key + i) % size;
	}

	// Hash function using quadratic probing
	private int quadraticProbe(int key, int i) {
		return (key + i * i) % size;
	}

	// Insertion operation with linear probing
	public int insertLinear(int key) {
		int index = key % size;
		int i = 1;
		while (table[index] != EMPTY) {
			index = linearProbe(key, i);
			i++;
		}
		table[index] = key;
		return i - 1;
	}

	// Insertion operation with quadratic probing
	public int insertQuadratic(int key) {
		int index = key % size;
		int i = 1;
		while (table[index] != EMPTY) {
			index = quadraticProbe(key, i);
			i++;
		}
		table[index] = key;
		return i - 1;
	}

}
