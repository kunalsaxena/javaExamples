package com.techiekunal.coding.interview.array;

import java.util.ArrayList;
import java.util.List;

public class GenerateSubsets {

    private List<List<Integer>> subsetList = new ArrayList<>();

    public static void main(String[] args) {
        int[] input = {1,2,3};
        GenerateSubsets obj = new GenerateSubsets();
        System.out.println(obj.subsets(input));
    }

    public List<List<Integer>> subsets(int[] nums) {
        //dfs(nums, new StringBuilder(), 0);
        dfsBacktrack(nums, new ArrayList<Integer>(), 0);
        return subsetList;
    }

    private void dfs(int[] nums, StringBuilder sb, int index) {
        if(index == nums.length) {

            String subset = sb.toString();
            String[] arr = subset.split(":");
            List<Integer> list = new ArrayList<>();
            for(String s : arr) {
                if(!s.isEmpty()) {
                    list.add(Integer.parseInt(s));
                }
            }
            subsetList.add(list);
            return;
        }
        StringBuilder newsb = new StringBuilder(sb.toString());
        newsb.append(nums[index]).append(":");
        dfs(nums, newsb, index+1);
        dfs(nums, sb, index+1);
    }

    private void dfsBacktrack(int[] nums, List<Integer> subset, int index) {
        if(index == nums.length) {
            return;
        }

        for(int i=index; i<nums.length; i++) {
            subset.add(nums[i]);
            subsetList.add(new ArrayList<>(subset));
            dfsBacktrack(nums, new ArrayList<>(subset), i+1);
            subset.remove(subset.size()-1);
        }
    }
}
