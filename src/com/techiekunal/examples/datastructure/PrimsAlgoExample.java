package com.techiekunal.examples.datastructure;

import java.util.*;
import java.util.Map.Entry;

/**
 * Implementation of Prims Algorithm
 * 
 * 1) Create a set mstSet that keeps track of vertices already included in MST. 
 * 2) Assign a key value to all vertices in the input graph. Initialize all key values as INFINITE. Assign key value as 0 for the first vertex so that it is picked first. 
 * 3) While mstSet doesn’t include all vertices 
 * ….a) Pick a vertex u which is not there in mstSet and has minimum key value. 
 * ….b) Include u to mstSet. 
 * ….c) Update key value of all adjacent vertices of u. To update the key values, iterate through all adjacent
 * vertices. For every adjacent vertex v, if weight of edge u-v is less than the previous key value of v, update the key value as weight of u-v
 * 
 * @author kunalsaxena
 *
 */
public class PrimsAlgoExample {

	// To store graph information
	HashMap<Integer, Node> graphStorage = new HashMap<>();

	/**
	 * Node is graph vertex, storing :- id : name of node key : it will help in
	 * Prim's minimum cost adjacentNodes : map of adjacent nodes and weight of
	 * connecting edge
	 * 
	 * The idea of using key values is to pick the minimum weight edge from cut.
	 */
	private static class Node {
		private int id;
		private int key;
		private Map<Node, Integer> adjacentNodes = new LinkedHashMap<>();

		public Node(int id) {
			this.id = id;
			this.key = Integer.MAX_VALUE; // Max value is like infinite
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append(id + " Adjacent Nodes {");
			Iterator<Node> itr = adjacentNodes.keySet().iterator();
			while (itr.hasNext()) {
				sb.append(itr.next().id);
				if (itr.hasNext()) {
					sb.append(", ");
				}
			}
			sb.append("} key=" + key);
			sb.append(" || ");
			return sb.toString();
		}

		@Override
		public boolean equals(Object obj) {
			if (obj == null) {
				return false;
			}
			if (this.getClass() != obj.getClass()) {
				return false;
			}
			Node node = (Node) obj;
			if (this.id == node.id) {
				return true;
			}
			return false;
		}

		@Override
		public int hashCode() {
			return super.hashCode();
		}

	}

	// get node from HashMap
	private Node getNode(int id) {
		return graphStorage.get(id);
	}

	// Add Edge : make source and destination adjacent & vice Versa
	public void addEdge(int source, int destination, int weight) {
		Node s = getNode(source);
		Node d = getNode(destination);

		// Adding edge : creating adjacent relation both sides
		s.adjacentNodes.put(d, weight);
		d.adjacentNodes.put(s, weight);
	}

	// Create Example Graph
	private void createGraph() {
		this.graphStorage.put(1, new Node(1));
		this.graphStorage.put(2, new Node(2));
		this.graphStorage.put(3, new Node(3));
		this.graphStorage.put(4, new Node(4));
		this.graphStorage.put(5, new Node(5));
		this.graphStorage.put(6, new Node(6));
		this.graphStorage.put(7, new Node(7));
		this.graphStorage.put(8, new Node(8));

		addEdge(1, 2, 5);
		addEdge(1, 3, 6);
		addEdge(1, 4, 14);
		addEdge(1, 5, 8);
		addEdge(2, 3, 12);
		addEdge(2, 7, 9);
		addEdge(2, 6, 7);
		addEdge(4, 5, 3);
		addEdge(5, 6, 10);
		addEdge(6, 8, 15);
	}

	
	
	// Priority queue or min-heap to find connecting edge with min cost
	private final PriorityQueue<Node> queue = new PriorityQueue<>(8,new Comparator<Node>() {
		@Override
		public int compare(Node o1, Node o2) {
			return o1.key - o2.key; // natural order : ascending : minimum first
		}
	});

	// store minimum spanning tree vertex
	private final Set<Node> mst = new HashSet<>();

	// Add all vertices to queue :: later keep picking minimum
	private void initQueue() {
		Iterator<Node> itr = graphStorage.values().iterator();
		while (itr.hasNext()) {
			queue.add(itr.next());
		}
	}

	// Update key info in queue(min heap) : set edge weight for next minimum cut
	private void updateQueue(Node current) {

		/**
		 * Loop through all adjacent of currently removed vertex u and update in queue
		 * if adjacent should not be in mst set current adjacent is v and weight(u,v) < v.key 
		 * v.key initialized with infinite(max value of Integer)
		 * Make greedy choice locally
		 */
		Iterator<Entry<Node, Integer>> itr = current.adjacentNodes.entrySet().iterator();
		while (itr.hasNext()) {
			Entry<Node, Integer> next = itr.next();
			Node v = next.getKey();
			if (!mst.contains(v)) {
				int weight = next.getValue();
				if (weight < v.key) {
					v.key = weight;
					// update this in queue
					queue.remove(new Node(v.id));
					queue.add(v);
				}
			}
		}

	}

	private void findMSTPrims() {

		// Loop for all vertices : until queue is empty
		while (!queue.isEmpty()) {
			Node u = queue.remove();

			// Add this to mst set : this now is part of minimum spanning tree
			mst.add(u);

			// Update adjacent keys in queue
			updateQueue(u);
		}
	}

	public static void main(String[] args) {

		PrimsAlgoExample pae = new PrimsAlgoExample();
		pae.createGraph();

		// Print Graph
		System.out.println(pae.graphStorage);

		// Initialize queue
		pae.initQueue();

		// Apply Prims Algo
		pae.findMSTPrims();

		// Print mst path
		System.out.println("");
		System.out.println(pae.mst);
	}

}
