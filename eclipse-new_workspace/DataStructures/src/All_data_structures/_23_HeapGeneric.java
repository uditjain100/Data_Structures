package All_data_structures;

import java.util.ArrayList;
import java.util.HashMap;

//MAX HEAP

public class _23_HeapGeneric<T extends Comparable<T>> {

	ArrayList<T> data = new ArrayList<>();

	HashMap<T, Integer> map = new HashMap<T, Integer>();

	public void add(T item) {

		this.data.add(item);
		map.put(item, this.data.size() - 1);
		this.upheapify(this.data.size() - 1);
	}

	public void upheapify(int ci) {

		int pi = (ci - 1) / 2;
		if (this.isLarger(this.data.get(ci), this.data.get(pi)) > 0) {
			this.swap(pi, ci);
			this.upheapify(pi);
		}

	}

	public T remove() {

		this.swap(0, this.data.size() - 1);
		T rv = this.data.remove(this.data.size() - 1);
		this.downheapify(0);

		map.remove(rv);
		return rv;
	}

	public void downheapify(int pi) {

		int lci = 2 * pi + 1;
		int rci = 2 * pi + 2;

		int mini = pi;
		if (lci < this.data.size() - 1 && this.isLarger(this.data.get(lci), this.data.get(mini)) > 0) {
			mini = lci;
		}

		if (rci < this.data.size() - 1 && this.isLarger(this.data.get(rci), this.data.get(mini)) > 0) {
			mini = rci;
		}

		if (mini != rci) {
			this.swap(mini, pi);
			this.downheapify(mini);
		}

	}

	public void display() {
		System.out.println(this.data);
	}

	public int size() {
		return this.data.size();
	}

	public boolean isEmpty() {
		return this.data.size() == 0;
	}

	public T get() {
		return this.data.get(0);
	}

	public void swap(int i, int j) {

		T ith_data = this.data.get(i);
		T jth_data = this.data.get(j);

		this.data.set(i, jth_data);
		this.data.set(j, ith_data);

		map.put(jth_data, i);
		map.put(ith_data, j);

	}

	public int isLarger(T o, T p) {
		return o.compareTo(p);
	}

	public void update_priority(T pair) {

		int index = map.get(pair);
		this.upheapify(index);

	}

}
