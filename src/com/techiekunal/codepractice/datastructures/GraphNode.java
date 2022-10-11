package com.techiekunal.codepractice.datastructures;

import java.util.ArrayList;
import java.util.List;

/**
 * Adjacency list implementation
 *
 * In case of directed graph - GraphNode will only contain list of outgoing nodes
 */
public class GraphNode {

    public int val;
    public List<GraphNode> neighbors;

    public GraphNode() {
        this(0, new ArrayList<>());
    }
    public GraphNode(int val) {
        this(val, new ArrayList<>());
    }

    public GraphNode(int val, ArrayList<GraphNode> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }
}
