package com.techiekunal.coding.interview.graph;

import java.util.*;

// source - https://www.youtube.com/watch?v=kXy0ABd1vwo&list=LL&index=1&t=422s&ab_channel=TECHDOSE
public class CourseSchedule {

    public static void main(String[] args) {
        CourseSchedule cs = new CourseSchedule();
        int n1 = 3;
        int[][] arr1 = {{0,1}, {0,2}, {1,0}};
        int n2 = 5;
        int[][] arr2 = {{1,4},{2,4},{3,1},{3,2}};
        int n3 = 3;
        int[][] arr3 = {{1,0}, {1,2}, {0,1}};
        int n4 = 4;
        int[][] arr4 = {{2,0},{1,0},{3,1},{3,2},{1,3}};
        int n5 = 8;
        int[][] arr5 = {{1,0},{2,6},{1,7},{6,4},{7,0},{0,5}};
        int n6 = 7;
        int[][] arr6 = {{1,0},{0,3},{0,2},{3,2},{2,5},{4,5},{5,6},{2,4}};

        System.out.println(cs.canFinish(n1, arr1) == false);
        System.out.println(cs.canFinish(n2, arr2) == true);
        System.out.println(cs.canFinish(n3, arr3) == false);
        System.out.println(cs.canFinish(n4, arr4) == false);
        System.out.println(cs.canFinish(n5, arr5) == true);
        System.out.println(cs.canFinish(n6, arr6) == true);
    }

    private boolean hasCycle(HashMap<Integer, List<Integer>> graph, int[] visited, int curr) {
        if(visited[curr] == 2) { // repeats under processing
            return true;
        }
        visited[curr] = 2;
        if(graph.containsKey(curr)) {
            for(int pr : graph.get(curr)) {
                if(visited[pr] != 1) {
                    if(hasCycle(graph, visited, pr)) {
                        return true;
                    }
                }
            }
        }
        visited[curr] = 1;
        return false;
    }

//    private boolean[] completed;

    // 0-unvisited | 1-processed | 2-processing
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        if(prerequisites.length == 0) {
            return true;
        }
        int[] visited = new int[numCourses];

        HashMap<Integer, List<Integer>> graph = preProcess(prerequisites);
        System.out.println("graph " + graph);

        for(int i = 0; i < numCourses; i++) {
            if(visited[i] == 0) {
                if(hasCycle(graph, visited, i)) {
                    return false;
                }
            }
        }

        return true;

        /*if(prerequisites.length == 0) {
            return true;
        }
        completed = new boolean[numCourses];

        HashMap<Integer, List<Integer>> graph = preProcess(prerequisites);
        System.out.println("graph " + graph);

        for(int i = 0; i < numCourses; i++) {
            if(!graph.containsKey(i)) {
                completed[i] = true;
            }
        }
//        System.out.println("init *******************--> " + Arrays.toString(completed));

        for(int i = 0; i < numCourses; i++) {
            if(completed[i]) {
                continue;
            }
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            if(bfs(graph, queue, new HashSet<>())) {
                completed[i] = true;
            } else {
                return false;
            }
//            System.out.println("completed *******************--> " + Arrays.toString(completed));
        }
        return true;*/
    }

    /*private boolean bfs(HashMap<Integer, List<Integer>> graph, Queue<Integer> queue, HashSet<Integer> visited) {

        int course = 0;
        while(!queue.isEmpty()) {
            course = queue.remove();
            System.out.println("course is - " + course);
            if(completed[course]) {
                continue;
            }
            visited.add(course);
            if(graph.containsKey(course)) { // independent
                for(int pr : graph.get(course)) {
                    if(visited.contains(pr)) {
                        return false;
                    } else {
                        queue.add(pr);
                    }
                }
            }
//            System.out.println("visited " + visited);
        }
        return completed[course];
    }*/

    private HashMap<Integer, List<Integer>> preProcess(int[][] prerequisites) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for(int i =0; i< prerequisites.length; i++) {
            List<Integer> list = graph.getOrDefault(prerequisites[i][0], new ArrayList<>());
            list.add(prerequisites[i][1]);
            graph.put(prerequisites[i][0], list);
        }
        return graph;
    }

}
