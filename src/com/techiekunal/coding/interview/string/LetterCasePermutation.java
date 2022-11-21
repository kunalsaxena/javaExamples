package com.techiekunal.coding.interview.string;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class LetterCasePermutation {

    public static void main(String[] args) {
        LetterCasePermutation permutation = new LetterCasePermutation();
        System.out.println(permutation.letterCasePermutation("a1B"));
    }

    public List<String> letterCasePermutation(String s) {
        Set<String> list = new LinkedHashSet<>();
        backtrack(new StringBuilder(s), 0, list);
        return new ArrayList(list);
    }

    private void backtrack(StringBuilder s, int index, Set<String> list) {
        list.add(s.toString());

        // if(index == s.length()) {
        //     return;
        // }

        for(int i = index; i < s.length(); i++) {
            char ch = s.charAt(i);

            if(Character.isLetter(ch)) {

                s.setCharAt(i, flipCase(ch));

                backtrack(s, i + 1, list);

                s.setCharAt(i, ch);
            }
        }
    }

    private char flipCase(char ch) {
        return Character.isUpperCase(ch) ? Character.toLowerCase(ch) : Character.toUpperCase(ch);
    }

}
