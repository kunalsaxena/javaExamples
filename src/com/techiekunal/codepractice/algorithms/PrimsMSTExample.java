package com.techiekunal.codepractice.algorithms;

import java.util.*;

public class PrimsMSTExample {

    private boolean isDirected = false;

    private static class GraphNode {

        public int val;
        public int weight;
        public List<Edge> edges;

        public GraphNode() {}

        public GraphNode(int val) {
            this(val, 0, new ArrayList<>());
        }

        public GraphNode(int val, int weight, List<Edge> edges) {
            this.val = val;
            this.weight = weight;
            this.edges = edges;
        }
    }

    private static class Edge implements Comparable<Edge> {

        public int source;
        public int destination;
        public int weight;

        public Edge() {
            this(0,0,0);
        }

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) {
        // best to take input as list of edges with weight | example - [[S,d,w]] => [[1,2,5], [2,3,3], [2,4,2], [3,4,6], [4,1,4]]
        GraphNode n1 = new GraphNode(1);
        GraphNode n2 = new GraphNode(2);
        GraphNode n3 = new GraphNode(3);
        GraphNode n4 = new GraphNode(4);

        n1.edges.add(new Edge(1,2,5));
        n1.edges.add(new Edge(1,4,4));

        n2.edges.add(new Edge(2,1,5));
        n2.edges.add(new Edge(2,4,2));
        n2.edges.add(new Edge(2,3,3));

        n3.edges.add(new Edge(3,2,3));
        n3.edges.add(new Edge(3,4,6));

        n4.edges.add(new Edge(4,3,6));
        n4.edges.add(new Edge(4,2,2));
        n4.edges.add(new Edge(4,1,4));

        // populated Adj - better alternate
        adj.put(n1.val, n1.edges);
        adj.put(n2.val, n2.edges);
        adj.put(n3.val, n3.edges);
        adj.put(n4.val, n4.edges);

        vertexMap.put(n1.val, n1);
        vertexMap.put(n2.val, n2);
        vertexMap.put(n3.val, n3);
        vertexMap.put(n4.val, n4);

        PrimsMSTExample example = new PrimsMSTExample();
        List<Edge> mst = example.findPrimsMST(vertexMap.size()-1);
        for(Edge e : mst) {
            System.out.println("source - " + e.source + " | destination - " + e.destination + " | weight - " + e.weight);
        }

    }

    // ?? thinking should we have
    private static HashMap<Integer, List<Edge>> adj = new HashMap<>();
    private static HashMap<Integer, GraphNode> vertexMap = new HashMap<>();

    private List<Edge> findPrimsMST(int n) {

        Set<Integer> visited = new LinkedHashSet<>();
        List<Edge> mst = new ArrayList<>();
        while(n > 0) {
            Edge e = nextMinEdge(visited);
            mst.add(e);
            visited.add(e.source);
            visited.add(e.destination);
            n--;
        }
        return mst;
    }

    private Edge nextMinEdge(Set<Integer> visited) {

        if(visited.isEmpty()) {
            Edge edge = adj.values().stream().flatMap(Collection::stream).sorted().findFirst().get();
            return edge;
        } else {
            List<Edge> allEdges = new ArrayList<>();
            for(Integer i : visited) {
                GraphNode node = vertexMap.get(i);
                node.edges .stream().filter(e -> !visited.contains(e.destination)).forEach(x -> allEdges.add(x));
            }
            Collections.sort(allEdges);
            return allEdges.get(0);
        }
    }

}
/** Complexity Analysis
 *  pre-processing - O(E)
 *  nextMinEdge - O(V*E) or O(n^2) | min heap/priority queue version will take O(E logE) - visit node and put connecting nodes in queue
 *  total - O(V*VE) -> O(V^2 E)
 *  with priority queue - O(E log V)
**/