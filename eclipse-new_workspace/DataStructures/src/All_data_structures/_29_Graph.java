package All_data_structures;

import java.util.ArrayList;
import java.util.HashMap;

import All_data_structures._29_Graph.Pair;

public class _29_Graph {

	private class Vertex {
		HashMap<String, Integer> neighbours = new HashMap<String, Integer>();
	}

	HashMap<String, Vertex> vertices;

	public _29_Graph() {
		this.vertices = new HashMap<String, _29_Graph.Vertex>();
	}

	public int no_of_vertices() {
		return this.vertices.size();
	}

	public boolean contains_vertex(String vertex_name) {
		return this.vertices.containsKey(vertex_name);
	}

	public void add_vertex(String vertex_name) {
		Vertex vtx = new Vertex();
		this.vertices.put(vertex_name, vtx);
	}

	public void remove_vertex(String vertex_name) {

		Vertex vtx = this.vertices.get(vertex_name);
		ArrayList<String> keys = new ArrayList<String>(vtx.neighbours.keySet());

		for (String key : keys) {
			Vertex nbr_vtx = this.vertices.get(key);
			nbr_vtx.neighbours.remove(vertex_name);
		}

		this.vertices.remove(vertex_name);

	}

	public int no_of_edges() {

		int count = 0;

		ArrayList<String> keys = new ArrayList<String>(this.vertices.keySet());

		for (String key : keys) {
			count += this.vertices.get(key).neighbours.size();
		}

		return count / 2;

	}

	public boolean contains_edge(String vertex_name_1, String vertex_name_2) {

		Vertex vtx_1 = this.vertices.get(vertex_name_1);
		Vertex vtx_2 = this.vertices.get(vertex_name_2);

		if (vtx_1 == null || vtx_2 == null || !vtx_1.neighbours.containsKey(vertex_name_2)) {
			return false;
		}

		return true;

	}

	public void add_edge(String vertex_name_1, String vertex_name_2, int cost) {

		Vertex vtx_1 = this.vertices.get(vertex_name_1);
		Vertex vtx_2 = this.vertices.get(vertex_name_2);

		if (vtx_1 == null || vtx_2 == null || vtx_1.neighbours.containsKey(vertex_name_2)) {
			return;
		}

		vtx_1.neighbours.put(vertex_name_2, cost);
		vtx_2.neighbours.put(vertex_name_1, cost);

	}

	public void remove_edge(String vertex_name_1, String vertex_name_2) {

		Vertex vtx_1 = this.vertices.get(vertex_name_1);
		Vertex vtx_2 = this.vertices.get(vertex_name_2);

		if (vtx_1 == null || vtx_2 == null || !vtx_1.neighbours.containsKey(vertex_name_2)) {
			return;
		}

		vtx_1.neighbours.remove(vertex_name_2);
		vtx_2.neighbours.remove(vertex_name_1);

	}

	public void display() {

		ArrayList<String> keys = new ArrayList<String>(this.vertices.keySet());

		System.out.println("***************************");

		for (String key : keys) {
			Vertex vtx = this.vertices.get(key);
			System.out.println(key + " : " + vtx.neighbours);
		}

		System.out.println("***************************");

	}

	public boolean hasPath(String vertex_1, String vertex_2, HashMap<String, Boolean> processed) {

		if (vertex_1 == null || vertex_2 == null) {
			return false;
		}

		processed.put(vertex_1, true);

		if (this.contains_edge(vertex_1, vertex_2)) {
			return true;
		}

		Vertex vtx = this.vertices.get(vertex_1);
		ArrayList<String> keys = new ArrayList<String>(vtx.neighbours.keySet());

		for (String key : keys) {
			if (!processed.containsKey(key) && this.hasPath(key, vertex_2, processed)) {
				return true;
			}
		}

		return false;
	}

	public class Pair {

		String vertex_name;
		String psf;

	}

	public boolean bfs(String src, String dst) throws Exception {

		HashMap<String, Boolean> processed = new HashMap<String, Boolean>();
		_12_LinkedListGeneric<Pair> queue = new _12_LinkedListGeneric<_29_Graph.Pair>();
		Pair sp = new Pair();

		sp.vertex_name = src;
		sp.psf = src;
		queue.addLast(sp);

		while (!queue.isEmpty()) {

			Pair rp = queue.removeFirst();

			if (processed.containsKey(rp.vertex_name)) {
				continue;
			}

			processed.put(rp.vertex_name, true);

			if (this.contains_edge(rp.vertex_name, dst)) {
				System.out.println(rp.vertex_name + dst);
				return true;
			}

			Vertex vtx = this.vertices.get(rp.vertex_name);
			ArrayList<String> nbrs = new ArrayList<String>(vtx.neighbours.keySet());

			for (String nbr : nbrs) {
				if (!processed.containsKey(nbr)) {
					Pair np = new Pair();
					np.vertex_name = nbr;
					np.psf = rp.psf + nbr;
					queue.addLast(np);
				}
			}

		}

		return false;

	}

	public boolean dfs(String src, String dst) throws Exception {

		HashMap<String, Boolean> processed = new HashMap<String, Boolean>();
		_12_LinkedListGeneric<Pair> stack = new _12_LinkedListGeneric<_29_Graph.Pair>();
		Pair sp = new Pair();

		sp.vertex_name = src;
		sp.psf = src;
		stack.addFirst(sp);

		while (!stack.isEmpty()) {

			Pair rp = stack.removeFirst();

			if (processed.containsKey(rp.vertex_name)) {
				continue;
			}

			processed.put(rp.vertex_name, true);

			if (this.contains_edge(rp.vertex_name, dst)) {
				System.out.println(rp.vertex_name + dst);
				return true;
			}

			Vertex vtx = this.vertices.get(rp.vertex_name);
			ArrayList<String> nbrs = new ArrayList<String>(vtx.neighbours.keySet());

			for (String nbr : nbrs) {
				if (!processed.containsKey(nbr)) {
					Pair np = new Pair();
					np.vertex_name = nbr;
					np.psf = rp.psf + nbr;
					stack.addFirst(np);
				}
			}

		}

		return false;

	}

	public void bft(String src, String dst) throws Exception {

		HashMap<String, Boolean> processed = new HashMap<String, Boolean>();
		_12_LinkedListGeneric<Pair> queue = new _12_LinkedListGeneric<_29_Graph.Pair>();
		ArrayList<String> keys = new ArrayList<String>(this.vertices.keySet());

		for (String key : keys) {

			if (processed.containsKey(key)) {
				continue;
			}

			Pair sp = new Pair();
			sp.vertex_name = src;
			sp.psf = src;
			queue.addLast(sp);

			while (!queue.isEmpty()) {

				Pair rp = queue.removeFirst();

				if (processed.containsKey(rp.vertex_name)) {
					continue;
				}

				processed.put(rp.vertex_name, true);

				System.out.println(rp.vertex_name + " via " + rp.psf);

				Vertex vtx = this.vertices.get(rp.vertex_name);
				ArrayList<String> nbrs = new ArrayList<String>(vtx.neighbours.keySet());

				for (String nbr : nbrs) {
					if (!processed.containsKey(nbr)) {
						Pair np = new Pair();
						np.vertex_name = nbr;
						np.psf = rp.psf + nbr;
						queue.addLast(np);
					}
				}

			}
		}

	}

	public void dft(String src, String dst) throws Exception {

		HashMap<String, Boolean> processed = new HashMap<String, Boolean>();
		_12_LinkedListGeneric<Pair> stack = new _12_LinkedListGeneric<_29_Graph.Pair>();
		ArrayList<String> keys = new ArrayList<String>(this.vertices.keySet());

		for (String key : keys) {

			if (processed.containsKey(key)) {
				continue;
			}

			Pair sp = new Pair();
			sp.vertex_name = src;
			sp.psf = src;
			stack.addFirst(sp);

			while (!stack.isEmpty()) {

				Pair rp = stack.removeFirst();

				if (processed.containsKey(rp.vertex_name)) {
					continue;
				}

				processed.put(rp.vertex_name, true);

				System.out.println(rp.vertex_name + " via " + rp.psf);

				Vertex vtx = this.vertices.get(rp.vertex_name);
				ArrayList<String> nbrs = new ArrayList<String>(vtx.neighbours.keySet());

				for (String nbr : nbrs) {
					if (!processed.containsKey(nbr)) {
						Pair np = new Pair();
						np.vertex_name = nbr;
						np.psf = rp.psf + nbr;
						stack.addFirst(np);
					}
				}

			}
		}

	}

	public boolean isConnected() throws Exception {

		int count = 0;

		HashMap<String, Boolean> processed = new HashMap<String, Boolean>();
		_12_LinkedListGeneric<Pair> queue = new _12_LinkedListGeneric<_29_Graph.Pair>();
		ArrayList<String> keys = new ArrayList<String>(this.vertices.keySet());

		for (String key : keys) {

			if (processed.containsKey(key)) {
				continue;
			}

			count++;

			Pair sp = new Pair();
			sp.vertex_name = key;
			sp.psf = key;
			queue.addLast(sp);

			while (!queue.isEmpty()) {

				Pair rp = queue.removeFirst();

				if (processed.containsKey(rp.vertex_name)) {
					continue;
				}

				processed.put(rp.vertex_name, true);

				Vertex vtx = this.vertices.get(rp.vertex_name);
				ArrayList<String> nbrs = new ArrayList<String>(vtx.neighbours.keySet());

				for (String nbr : nbrs) {
					if (!processed.containsKey(nbr)) {
						Pair np = new Pair();
						np.vertex_name = nbr;
						np.psf = rp.psf + nbr;
						queue.addLast(np);
					}
				}

			}
		}

		if (count >= 2) {
			return false;
		}

		return true;

	}

	public boolean isCyclic() throws Exception {

		HashMap<String, Boolean> processed = new HashMap<String, Boolean>();
		_12_LinkedListGeneric<Pair> queue = new _12_LinkedListGeneric<_29_Graph.Pair>();
		ArrayList<String> keys = new ArrayList<String>(this.vertices.keySet());

		for (String key : keys) {

			if (processed.containsKey(key)) {
				continue;
			}

			Pair sp = new Pair();
			sp.vertex_name = key;
			sp.psf = key;
			queue.addLast(sp);

			while (!queue.isEmpty()) {

				Pair rp = queue.removeFirst();

				if (processed.containsKey(rp.vertex_name)) {
					return true;
				}

				processed.put(rp.vertex_name, true);

				Vertex vtx = this.vertices.get(rp.vertex_name);
				ArrayList<String> nbrs = new ArrayList<String>(vtx.neighbours.keySet());

				for (String nbr : nbrs) {
					if (!processed.containsKey(nbr)) {
						Pair np = new Pair();
						np.vertex_name = nbr;
						np.psf = rp.psf + nbr;
						queue.addLast(np);
					}
				}

			}
		}
		return false;
	}

	public boolean isTree() throws Exception {
		return !this.isCyclic() && this.isConnected();
	}

	public ArrayList<ArrayList<String>> connected_components() throws Exception {

		ArrayList<ArrayList<String>> ans = new ArrayList<>();
		HashMap<String, Boolean> processed = new HashMap<String, Boolean>();
		_12_LinkedListGeneric<Pair> queue = new _12_LinkedListGeneric<>();
		ArrayList<String> keys = new ArrayList<String>(this.vertices.keySet());

		for (String key : keys) {

			if (!processed.containsKey(key)) {
				continue;
			}

			ArrayList<String> sub_ans = new ArrayList<String>();

			Pair sp = new Pair();
			sp.vertex_name = key;
			sp.psf = key;

			queue.addLast(sp);

			while (!queue.isEmpty()) {
				Pair rp = queue.removeFirst();
				if (processed.containsKey(rp.vertex_name)) {
					continue;
				}

				processed.put(rp.vertex_name, true);

				sub_ans.add(rp.vertex_name);

				Vertex nbr_vtx = this.vertices.get(rp.vertex_name);
				ArrayList<String> nbr = new ArrayList<String>(nbr_vtx.neighbours.keySet());
				for (String nb : nbr) {
					if (!processed.containsKey(rp.vertex_name)) {
						Pair np = new Pair();
						np.vertex_name = nb;
						np.psf = rp.psf + nb;
						queue.addLast(np);
					}
				}
			}
			ans.add(sub_ans);
		}
		return ans;
	}

	public class PrimsPair implements Comparable<PrimsPair> {

		String vertex_name;
		String acqire_name;
		int cost;

		@Override
		public int compareTo(PrimsPair o) {
			return o.cost - this.cost;
		}
	}

	public _29_Graph Prims() {

		_29_Graph mst = new _29_Graph();
		HashMap<String, PrimsPair> map = new HashMap<String, _29_Graph.PrimsPair>();
		_23_HeapGeneric<PrimsPair> heap = new _23_HeapGeneric<_29_Graph.PrimsPair>();

		for (String key : this.vertices.keySet()) {
			PrimsPair np = new PrimsPair();
			np.vertex_name = key;
			np.acqire_name = null;
			np.cost = Integer.MAX_VALUE;

			heap.add(np);
			map.put(key, np);
		}

		while (!heap.isEmpty()) {
			PrimsPair rp = heap.remove();
			map.remove(rp.vertex_name);

			if (rp.acqire_name == null) {
				mst.add_vertex(rp.vertex_name);
			} else {
				mst.add_vertex(rp.acqire_name);
				mst.add_edge(rp.vertex_name, rp.acqire_name, rp.cost);
			}

			for (String nbr : this.vertices.get(rp.vertex_name).neighbours.keySet()) {
				if (map.containsKey(nbr)) {
					int old_cost = map.get(nbr).cost;
					int new_cost = this.vertices.get(rp.vertex_name).neighbours.get(nbr);

					if (new_cost < old_cost) {
						PrimsPair gp = new PrimsPair();
						gp.acqire_name = rp.vertex_name;
						gp.cost = new_cost;

						heap.update_priority(gp);
					}

				}

			}
		}

		return mst;

	}

	public class DijkstraPair implements Comparable<DijkstraPair> {

		String vertex_name;
		String psf;
		int cost;

		@Override
		public int compareTo(DijkstraPair o) {
			return o.cost - this.cost;
		}
	}

	public HashMap<String, Integer> Dijkstra(String src) {

		HashMap<String, Integer> ans = new HashMap<String, Integer>();
		HashMap<String, DijkstraPair> map = new HashMap<String, _29_Graph.DijkstraPair>();
		_23_HeapGeneric<DijkstraPair> heap = new _23_HeapGeneric<_29_Graph.DijkstraPair>();

		for (String key : this.vertices.keySet()) {
			DijkstraPair np = new DijkstraPair();
			np.vertex_name = key;
			np.psf = "";
			np.cost = Integer.MAX_VALUE;

			if (key.equals(src)) {
				np.cost = 0;
				np.psf = key;
			}

			heap.add(np);
			map.put(key, np);
		}

		while (!heap.isEmpty()) {
			DijkstraPair rp = heap.remove();
			map.remove(rp.vertex_name);

			ans.put(rp.vertex_name, rp.cost);

			for (String nbr : this.vertices.get(rp.vertex_name).neighbours.keySet()) {
				if (map.containsKey(nbr)) {
					int old_cost = map.get(nbr).cost;
					int new_cost = rp.cost + this.vertices.get(rp.vertex_name).neighbours.get(nbr);

					if (new_cost < old_cost) {
						DijkstraPair gp = new DijkstraPair();
						gp.psf = rp.psf + nbr;
						gp.cost = new_cost;

						heap.update_priority(gp);
					}

				}

			}
		}

		return ans;

	}

}
