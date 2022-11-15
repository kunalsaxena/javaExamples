package com.techiekunal.codepractice.algorithms;

import java.util.*;
import java.util.stream.Collectors;

public class KruskalMSTExample {

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

    private static void preProcessGraph(int[][] graph) {
        int n = graph.length;
        for(int i =0; i<n; i++) {
            int[] edge = graph[i];
            int s = edge[0];
            int d = edge[1];
            int w = edge[2];
            GraphNode sNode = new GraphNode(s);
            GraphNode dNode = new GraphNode(d);
            sNode.edges.add(new Edge(s,d,w));
            dNode.edges.add(new Edge(d,s,w));
            adj.put(s, sNode.edges);
            adj.put(d, dNode.edges);
        }
    }

    public static void main(String[] args) {
        // best to take input as list of edges with weight | example - [[S,d,w]] => [[1,2,5], [2,3,3], [2,4,2], [3,4,6], [4,1,4]]
        int[][] graph = {{1,2,5}, {2,3,3}, {2,4,2}, {3,4,6}, {4,1,4}};

        preProcessGraph(graph);

        /*GraphNode n1 = new GraphNode(1);
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
        vertexMap.put(n4.val, n4);*/

        KruskalMSTExample example = new KruskalMSTExample();
        List<Edge> mst = example.findKruskalMST();
        for(Edge e : mst) {
            System.out.println("source - " + e.source + " | destination - " + e.destination + " | weight - " + e.weight);
        }

    }

    // ?? thinking should we have
    private static HashMap<Integer, List<Edge>> adj = new HashMap<>();
    private static HashMap<Integer, GraphNode> vertexMap = new HashMap<>();
    private static PriorityQueue<Edge> queue = new PriorityQueue<>();

    private List<Edge> findKruskalMST() {

        populatePriorityQueue(); // O(E logE)

        Set<Integer> visited = new LinkedHashSet<>();
        List<Edge> mst = new ArrayList<>();
        while(!queue.isEmpty()) { // O(V)

            Edge e = queue.poll(); // O(logE)
            if(!(visited.contains(e.source) && visited.contains(e.destination))) { // checking if edge can form cycle
                mst.add(e);
                visited.add(e.source);
                visited.add(e.destination);
            }
        }
        return mst;
    }

    private void populatePriorityQueue() { // E LogE
        List<Edge> allEdges = adj.values().stream().flatMap(Collection::stream).collect(Collectors.toList());
        queue.addAll(allEdges);
    }

}
/** ## Complexity Analysis ##
 *  pre-processing - O(E)
 *  populatePriorityQueue - O(E logE)
 *  --> Kruskal is O(E log E) - You could also say O(E log V) because E <= V * V, so log(E) <= 2 log(V)
 *  total - O(E logE + V LogE) -> O(2E logV + 2V LogV) ==> O(E log V)
**/