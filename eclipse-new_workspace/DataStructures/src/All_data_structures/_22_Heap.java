package All_data_structures;

import java.util.ArrayList;

//MIN HEAP

public class _22_Heap {

	ArrayList<Integer> data = new ArrayList<Integer>();

	public void add(int item) {

		this.data.add(item);
		this.upheapify(this.data.size() - 1);
	}

	public void upheapify(int ci) {

		int pi = (ci - 1) / 2;
		if (this.data.get(ci) < this.data.get(pi)) {
			this.swap(pi, ci);
			this.upheapify(pi);
		}

	}

	public int remove() {

		this.swap(0, this.data.size() - 1);
		int rv = this.data.remove(this.data.size() - 1);
		this.downheapify(0);
		return rv;
	}

	public void downheapify(int pi) {

		int lci = 2 * pi + 1;
		int rci = 2 * pi + 2;

		int mini = pi;
		if (lci < this.data.size() - 1 && this.data.get(lci) < this.data.get(mini)) {
			mini = lci;
		}

		if (rci < this.data.size() - 1 && this.data.get(rci) < this.data.get(mini)) {
			mini = rci;
		}

		if (mini != pi) {
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

	public int get() {
		return this.data.get(0);
	}

	public void swap(int i, int j) {

		int ith_data = this.data.get(i);
		int jth_data = this.data.get(j);

		this.data.set(i, jth_data);
		this.data.set(j, ith_data);
	}

}
