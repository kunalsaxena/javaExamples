package com.techiekunal.coding.interview.graph;

import java.util.*;
// source - https://www.youtube.com/watch?v=qe_pQCh09yU&ab_channel=TECHDOSE
public class CourseSchedule2 {

    public static void main(String[] args) {
        CourseSchedule2 cs2 = new CourseSchedule2();
        int n = 7;
        int[][] arr = {{1,0},{0,3},{0,2},{3,2},{2,5},{4,5},{5,6},{2,4}};
        System.out.println(Arrays.toString(cs2.findOrder(n, arr)));
    }

    // indegree - no of incoming edges
    // outdegree - no of outgoing edges
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = preProcess(prerequisites);

        // detect cycle
        if(detectCycle(graph, numCourses)) {
            return new int[0]; // empty array
        }

        //  find topo sort and store it in stack
        boolean[] visited = new boolean[numCourses];
        Stack<Integer> stack = new Stack<>();

        // apply dfs and topo sort
        for(int i =0; i< numCourses; i++) {
            if(!visited[i]) {
                dfs(graph, visited, stack, i);
            }
        }

        // pop stack and add it to array in reverse :: stack will have topo sort order in reverse
        int[] resp = new int[numCourses];
        int k = numCourses - 1;
        while(!stack.empty()) {
            resp[k--] = stack.pop();
        }
        return resp;
    }

    private void dfs(Map<Integer, List<Integer>> graph, boolean[] visited, Stack<Integer> stack, int i) {
        visited[i] = true;

        // connections
        if(graph.containsKey(i)) {
            for(int pr : graph.get(i)) {
                if(!visited[pr]) {
                    dfs(graph, visited, stack, pr);
                }
            }
        }
        stack.push(i);
    }

    // 0 - unvisited | 1 - processed | 2 - in processing
    private boolean detectCycle(Map<Integer, List<Integer>> graph, int numCourses) {
        int[] visited = new int[numCourses];
        for(int i = 0; i < numCourses; i++) {
            if(visited[i] == 0) {
                if(hasCycle(graph, visited, i)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean hasCycle(Map<Integer, List<Integer>> graph, int[] visited, int curr) {
        if(visited[curr] == 2) {
            return true;
        }

        visited[curr] = 2;
        // connections
        if(graph.containsKey(curr)) {
            for(int i : graph.get(curr)) {
                if(visited[i] != 1) {
                    if(hasCycle(graph, visited, i)) {
                        return true;
                    }
                }
            }
        }
        visited[curr] = 1;
        return false;
    }

    private Map<Integer, List<Integer>> preProcess(int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i = 0; i< prerequisites.length; i++) {
            List<Integer> connections = graph.getOrDefault(prerequisites[i][0], new ArrayList<>());
            connections.add(prerequisites[i][1]);
            graph.put(prerequisites[i][0], connections);
        }
        return graph;
    }

}
