package com.techiekunal.examples.datastructure;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Graph Traversal for Directed graph
 * edge a -> b means there is path from a to b not vice versa
 * source : current node / starting node
 * destination : node you are looking for
 * 
 * @author Kunal.Saxena
 *
 */
public class DirectedGraphTraversal {

	// To store graph information
	HashMap<Integer, Node> graphStorage = new HashMap<>();

	// Graph Node logic
	private static class Node {

		private int id;
		private List<Node> adjacentNodes = new LinkedList<>();

		public Node(int id) {
			this.id = id;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append(" Adjacent Nodes ");
			Iterator<Node> itr = adjacentNodes.iterator();
			while (itr.hasNext()) {
				sb.append(itr.next().id);
				if (itr.hasNext()) {
					sb.append(", ");
				}
			}
			sb.append(" || ");
			return sb.toString();
		}
	}

	// Get Node from Hashmap
	private Node getNode(int id) {
		return graphStorage.get(id);
	}

	// Add Directed Edge : from source to destination
	private void addEdge(int source, int destination) {
		Node s = getNode(source);
		Node d = getNode(destination);

		// Directed Graph : adding edge from source to destination
		s.adjacentNodes.add(d);
	}

	// DFS Traversal of graph
	public boolean hasPathDFS(int source, int destination) {
		Node s = getNode(source);
		Node d = getNode(destination);
		List<Integer> visited = new LinkedList<>();
		return hasPathDFS(s, d, visited);
	}

	private boolean hasPathDFS(Node source, Node destination, List<Integer> visited) {
		if (visited.contains(source.id)) {
			return false;
		}
		visited.add(source.id);
		if (source.id == destination.id) {
			return true;
		}
		for (Node node : source.adjacentNodes) {
			if (hasPathDFS(node, destination, visited)) {
				return true;
			}
		}
		return false;
	}

	// BFS Traversal of graph
	private boolean hasPathBFS(int source, int destination) {
		Node s = getNode(source);
		Node d = getNode(destination);
		return hasPathBFS(s, d);
	}

	private boolean hasPathBFS(Node source, Node destination) {
		List<Integer> visited = new LinkedList<>();
		Queue<Node> nextToVisit = new LinkedList<>();
		nextToVisit.add(source);
		while (!nextToVisit.isEmpty()) {
			Node node = nextToVisit.remove();
			if (visited.contains(node.id)) {
				return false;
			}
			visited.add(node.id);
			if (node.id == destination.id) {
				return true;
			}
			nextToVisit.addAll(node.adjacentNodes);
		}
		return false;
	}

	// Creating example graph
	private void createGraph() {
		// Adding all vertices of graph
		this.graphStorage.put(1, new Node(1));
		this.graphStorage.put(2, new Node(2));
		this.graphStorage.put(3, new Node(3));
		this.graphStorage.put(4, new Node(4));
		this.graphStorage.put(5, new Node(5));

		// Adding edges now
		addEdge(1, 2);
		addEdge(1, 3);
		addEdge(2, 4);
		addEdge(3, 5);
		addEdge(4, 4);
		addEdge(5, 2);
	}

	public static void main(String[] args) {
		DirectedGraphTraversal dgt = new DirectedGraphTraversal();

		// Creating example graph
		dgt.createGraph();

		System.out.println("Printing graph..");
		System.out.println(dgt.graphStorage);

		// DFS Traversal
		boolean isPathExistDFS = dgt.hasPathDFS(2, 3);
		System.out.println(isPathExistDFS ? "Path Exists." : "Path does not exist.");

		// BFS Traversal
		boolean isPathExistBFS = dgt.hasPathBFS(2, 3);
		System.out.println(isPathExistBFS ? "Path Exists." : "Path does not exist.");
	}
}
