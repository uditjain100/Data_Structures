package All_data_structures;

public class _27_HashTable<K, V> {

	private class HTPair {
		K Key;
		V Value;

		public HTPair(K key, V value) {
			this.Key = key;
			this.Value = value;
		}

		public boolean equals(Object op) {
			@SuppressWarnings("unchecked")
			HTPair other = (HTPair) op;
			return this.Key.equals(other.Key);
		}

		public String toString() {
			return "{ " + this.Key + " - " + this.Value + " }";

		}

	}

	private _12_LinkedListGeneric<HTPair>[] bucketArray;
	private int size;
	private final static int DEFAULT_SIZE = 10;

	public _27_HashTable() {
		this(DEFAULT_SIZE);
	}

	@SuppressWarnings("unchecked")
	public _27_HashTable(int capacity) {
		this.bucketArray = (_12_LinkedListGeneric<_27_HashTable<K, V>.HTPair>[]) new _12_LinkedListGeneric[capacity];
		this.size = 0;
	}

	public int hashFuction(K key) {
		int hc = key.hashCode();
		hc = Math.abs(hc);
		hc = hc % this.bucketArray.length;
		return hc;
	}

	public void put(K key, V value) throws Exception {

		int bi = this.hashFuction(key);
		_12_LinkedListGeneric<HTPair> bucket = this.bucketArray[bi];
		HTPair pta = new HTPair(key, value);

		if (bucket == null) {
			bucket = new _12_LinkedListGeneric<_27_HashTable<K, V>.HTPair>();
			bucket.addLast(pta);
			this.bucketArray[bi] = bucket;
			this.size++;
		} else {
			int find_idx = bucket.find(pta);
			if (find_idx == -1) {
				bucket.addLast(pta);
				this.size++;
			} else {
				HTPair pair = bucket.getAt(find_idx);
				pair.Value = value;
			}
		}

		double lamda = (this.size * 1.0) / this.bucketArray.length;

		if (lamda > 0.75) {
			this.reHash();
		}
	}

	public V get(K key) throws Exception {

		int bi = this.hashFuction(key);
		_12_LinkedListGeneric<HTPair> bucket = this.bucketArray[bi];
		HTPair ptf = new HTPair(key, null);

		if (bucket == null) {
			return null;
		} else {
			int find_idx = bucket.find(ptf);
			if (find_idx == -1) {
				return null;
			} else {
				HTPair pair = bucket.getAt(find_idx);
				return pair.Value;
			}
		}
	}

	public V remove(K key) throws Exception {

		int bi = this.hashFuction(key);
		_12_LinkedListGeneric<HTPair> bucket = this.bucketArray[bi];
		HTPair ptf = new HTPair(key, null);

		if (bucket == null) {
			return null;
		} else {
			int find_idx = bucket.find(ptf);
			if (find_idx == -1) {
				return null;
			} else {
				HTPair pair = bucket.getAt(find_idx);
				bucket.removeAt(find_idx);
				this.size--;
				return pair.Value;
			}
		}
	}

	public void display() {

		for (_12_LinkedListGeneric<HTPair> bucket : this.bucketArray) {
			if (bucket != null && !bucket.isEmpty()) {
				bucket.display();
			} else {
				System.out.println("NULL!");
			}
		}

		System.out.println("*********************");
	}

	@SuppressWarnings("unchecked")
	public void reHash() throws Exception {
		_12_LinkedListGeneric<HTPair>[] oba = this.bucketArray;
		this.bucketArray = (_12_LinkedListGeneric<HTPair>[]) new _12_LinkedListGeneric[2 * oba.length];
		this.size = 0;
		for (_12_LinkedListGeneric<HTPair> bucket : oba) {
			if (bucket != null && !bucket.isEmpty()) {
				HTPair pair = bucket.removeLast();
				this.put(pair.Key, pair.Value);
			}
		}

	}

}
