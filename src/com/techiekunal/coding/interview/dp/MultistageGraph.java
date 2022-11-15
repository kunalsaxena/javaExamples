package com.techiekunal.coding.interview.dp;

import java.util.Arrays;

/**
 * A Multistage graph is a directed, weighted graph in which the nodes can be divided into a set of stages such that all edges are from a stage to next stage only
 * (In other words there is no edge between vertices of same stage and from a vertex of current stage to previous stage).
 * TC - O(n^2)
 */
public class MultistageGraph {

    public static void main(String[] args) {
        int n = 13;
        MultistageGraph graph = new MultistageGraph();
        int[][] adj = graph.buildAdjMatrix();
        int[] cost = new int[n];
        int[] destination = new int[n];

        int minCost = graph.findMinCost(adj, cost, destination);
        System.out.println("Min cost is - " + minCost);
        System.out.println("Cost array is - " + Arrays.toString(cost));
        System.out.println("Destination array is - " + Arrays.toString(destination));
    }

    private int findMinCost(int[][] adj, int[] cost, int[] destination) {
        int n = adj.length;
        cost[n-1] = 0;
        destination[n-1] = n-1;

        for(int i = n-2; i > 0; i--) {
            //cost[i] = 99999; // hypothetical high number
            for(int j = i; j <= n-1; j++) {

                if(adj[i][j] != 0) {
                    if(cost[i] == 0) {
                        cost[i] = adj[i][j] + cost[j];
                        destination[i] = j;
                    } else {
                        cost[i] = Math.min(cost[i], adj[i][j] + cost[j]); // min will replace this in every iteration
                        if(adj[i][j] + cost[j] == cost[i]) {
                            destination[i] = j;
                        }
                    }
                }
            }
        }

        return cost[1];
    }

    private int[][] buildAdjMatrix() {

        int[][] adj = new int[][] {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 9, 7, 3, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 4, 2, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 2, 7, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 11, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 11, 8, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 5, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 3, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 6, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };
        return adj;
    }


}
