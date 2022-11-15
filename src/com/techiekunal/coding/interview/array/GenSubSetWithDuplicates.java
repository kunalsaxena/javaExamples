package com.techiekunal.coding.interview.array;

import java.util.*;

public class GenSubSetWithDuplicates {

    public static void main(String[] args) {
        int[] input = {1,2,2};
        GenSubSetWithDuplicates obj = new GenSubSetWithDuplicates();
        System.out.println(obj.subsetsWithDup(input));
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Set<String> set = new LinkedHashSet<>();

        Arrays.sort(nums); // we are sorting input so that it doesn't generate permutations --> 4,4,1,4 and 4,4,4,1

        //dfs(nums, new StringBuilder(), 0, set);

        backtrack(nums, new StringBuilder(), 0, set);

        return formatResponse(set);
    }

    private void backtrack(int[] nums, StringBuilder sb, int index, Set<String> set) {
        set.add(sb.toString());

        for(int i = index; i < nums.length; i++) {

            int n = sb.length();
            sb.append(nums[i]).append(":");

            backtrack(nums, sb, i + 1, set);
//            System.out.println(set);
            sb.delete(n,  sb.length()); // starts with 0 and end is excluded
            // System.out.println(sb.toString());
        }
    }

    private void dfs(int[] nums, StringBuilder sb, int index, Set<String> set) {
        if(index == nums.length) {
            set.add(sb.toString());
            return;
        }

        StringBuilder newsb = new StringBuilder(sb.toString());
        newsb.append(nums[index]).append(":");
        dfs(nums, newsb, index + 1, set);
        dfs(nums, sb, index+1, set);
    }

    private List<List<Integer>> formatResponse(Set<String> set) {
        List<List<Integer>> subsetList = new ArrayList<>();
        for(String str : set) {
            String[] arr = str.split(":");
            List<Integer> list = new ArrayList<>();
            for(String s : arr) {
                if(!s.isEmpty()) {
                    list.add(Integer.parseInt(s));
                }
            }
            subsetList.add(list);
        }
        return subsetList;
    }
}
