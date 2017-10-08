package com.techiekunal.examples.datastructure;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Print all paths from a given source to a destination using BFS
 * 
 * @author Kunal.Saxena
 *
 */
public class PrintAllPathsBFS {

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
			sb.append(id + " : Adjacent Nodes ");
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

	// Get Node from HashMap
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

	// BFS Traversal of graph
	private void findAllPathBFS(int s, int d) {
		Node source = getNode(s);
		Node destination = getNode(d);
		
		List<Integer> visited = new LinkedList<>();
		Queue<List<Integer>> paths = new LinkedList<>();

		visited.add(source.id);
		paths.add(visited);
		
		while(!paths.isEmpty()) {
			
			List<Integer> path = paths.remove();
			Node last = getNode(path.get(path.size()-1));
			if(destination.id == last.id){
				System.out.println(path);
			}
			for(Node node : last.adjacentNodes) {
				if(!visited.contains(node.id)) {
					List<Integer> newPath = new LinkedList<>(path);
					newPath.add(node.id);
					paths.add(newPath);
				}
			}
		}
	}

	// Creating example graph
	private void createGraph() {
		// Adding all vertices of graph
		this.graphStorage.put(0, new Node(0));
		this.graphStorage.put(1, new Node(1));
		this.graphStorage.put(2, new Node(2));
		this.graphStorage.put(3, new Node(3));

		// Adding edges now
		addEdge(0, 1);
		addEdge(0, 2);
		addEdge(0, 3);
		addEdge(1, 3);
		addEdge(2, 0);
		addEdge(2, 1);
	}

	public static void main(String[] args) {
		PrintAllPathsBFS printAllPathsBFSObj = new PrintAllPathsBFS();

		// Creating example graph
		printAllPathsBFSObj.createGraph();

		System.out.println("Printing graph..");
		System.out.println(printAllPathsBFSObj.graphStorage);

		// BFS Traversal
		printAllPathsBFSObj.findAllPathBFS(2, 3);
	}
}
