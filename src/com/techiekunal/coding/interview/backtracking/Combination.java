package com.techiekunal.coding.interview.backtracking;

import java.util.*;

public class Combination {

    public void combination(char input[]){
        Map<Character, Integer> countMap = new TreeMap<>();
        for (char ch : input) {
            countMap.compute(ch, (key, val) -> {
                if (val == null) {
                    return 1;
                } else {
                    return val + 1;
                }
            });
        }
        char str[] = new char[countMap.size()];
        int count[] = new int[countMap.size()];
        int index = 0;
        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            str[index] = entry.getKey();
            count[index] = entry.getValue();
            index++;
        }
        char[] output = new char[input.length];
        combination(str, count, 0, output, 0);
    }

    private void combination(char input[],int count[],int pos, char output[],int len){
        print(output, len);
        for(int i=pos; i < input.length; i++){
            if (count[i] == 0) {
                continue;
            }
            output[len] = input[i];
            count[i]--;
            combination(input, count, i, output, len + 1);
            count[i]++;
        }
    }

    private void print(char result[],int pos){
        for(int i=0; i < pos; i++){
            System.out.print(result[i] + " ");
        }
        System.out.println();
    }

    public void combinationEasy(char[] input) {
        List<Character> r = new ArrayList<>();
        Arrays.sort(input);
        combinationEasy(input, 0, r);
    }

    private void combinationEasy(char[] input, int pos, List<Character> r) {

        r.forEach(r1 -> System.out.print(r1 + " "));
        System.out.println();
        for (int i = pos; i < input.length; i++) {
            if (i != pos && input[i] == input[i-1]) {
                continue;
            }
            r.add(input[i]);
            combinationEasy(input, i + 1, r);
            r.remove(r.size() - 1);
        }
    }

    public static void main(String args[]){
        Combination c = new Combination();
//        c.combination("aab".toCharArray());
//        c.combinationEasy("aab".toCharArray());
        int count = c.numTilePossibilities("AAB");
        System.out.println("No of sequences are - " + count);
    }

    public int numTilePossibilities(String tiles) {
        if (tiles == null || tiles.isEmpty())
            return 0;

        Set<String> set = new HashSet<>();
        boolean[] used = new boolean[tiles.length()];

        //O(n)
        for (int i = 0; i < tiles.length(); i++) {

            dfs(tiles, set, new StringBuilder(), used);
        }
        return set.size();

    }

    //O(n!)
    private void dfs(String tiles, Set<String> set, StringBuilder str, boolean[] used) {
        for (int i = 0; i < tiles.length(); i++) {

            if (!used[i]) {
                str.append(tiles.charAt(i));
                set.add(str.toString());

                used[i] = true;
                dfs(tiles, set, str, used);
                used[i] = false;
                str.setLength(str.length() - 1);
            }
        }
    }

}