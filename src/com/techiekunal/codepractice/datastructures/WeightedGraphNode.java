package com.techiekunal.codepractice.datastructures;

import java.util.ArrayList;
import java.util.List;

public class WeightedGraphNode {

    public int val;
    public List<GraphEdge> connections;

    public WeightedGraphNode() {
        this(0, new ArrayList<>());
    }

    public WeightedGraphNode(int val, List<GraphEdge> connections) {
        this.val = val;
        this.connections = connections;
    }
}

class GraphEdge {

    int start;
    int end;
    int weight;

    public GraphEdge() {
        this(0,0,0);
    }

    public GraphEdge(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

}