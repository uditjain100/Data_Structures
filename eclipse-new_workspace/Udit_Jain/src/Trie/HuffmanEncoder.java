package Trie;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import DataStructures._23_HeapGeneric;

public class HuffmanEncoder {

	private class Node implements Comparable<Node> {

		Character data;
		int cost;
		Node left;
		Node right;

		public Node(Character data, int cost) {
			this.data = data;
			this.cost = cost;
			this.left = null;
			this.right = null;
		}

		public Node(Node right, Node left) {
			this.left = left;
			this.right = right;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}

	}

	HashMap<Character, String> encoder;
	HashMap<String, Character> decoder;

	public HuffmanEncoder(String feeder) {

		HashMap<Character, Integer> fmap = new HashMap<>();
		for (int i = 0; i < feeder.length(); i++) {
			char cc = feeder.charAt(i);
			if (fmap.containsKey(cc)) {
				int ov = fmap.get(cc);
				ov++;
				fmap.put(cc, ov);
			} else {
				fmap.put(cc, 1);
			}
		}

		_23_HeapGeneric<Node> minHeap = new _23_HeapGeneric<HuffmanEncoder.Node>();
		Set<Map.Entry<Character, Integer>> entries = fmap.entrySet();
		for (Map.Entry<Character, Integer> entry : entries) {
			Node node = new Node(entry.getKey(), entry.getValue());
			minHeap.add(node);
		}

		while (minHeap.size() != 1) {
			Node minone = minHeap.remove();
			Node mintwo = minHeap.remove();

			Node combined = new Node(minone, mintwo);
			combined.cost = minone.cost + mintwo.cost;
			combined.data = '\0';
			minHeap.add(combined);

		}

		Node ft = minHeap.remove();
		this.encoder = new HashMap();
		this.decoder = new HashMap();

		initEncoderDecoder(ft, "");
	}

	private void initEncoderDecoder(Node node, String osf) {

		if (node == null) {
			return;
		}

		if (node.left == null && node.right == null) {
			this.encoder.put(node.data, osf);
			this.decoder.put(osf, node.data);
		}

		initEncoderDecoder(node.left, osf + "0");
		initEncoderDecoder(node.right, osf + "1");
	}

	public String encode(String source) {

		String rv = "";
		for (int i = 0; i < source.length(); i++) {
			rv += this.encoder.get(source.charAt(i));
		}
		return rv;

	}

	public String decode(String codedString) {

		String rv = "";
		String key = "";
		for (int i = 0; i < codedString.length(); i++) {
			key += codedString.charAt(i);
			if (this.decoder.containsKey(key)) {
				rv += this.decoder.get(key);
				key = "";
			}
		}
		return rv;

	}

}
