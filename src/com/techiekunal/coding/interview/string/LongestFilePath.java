package com.techiekunal.coding.interview.string;

import java.util.Stack;

public class LongestFilePath {

    public static void main(String[] args) {
        String s = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
        System.out.println(s);
        LongestFilePath lfp = new LongestFilePath();
        System.out.println("Result - " + lfp.lengthLongestPath(s));
    }
    // Assumptions ::
    // 1 - longest absolute file path will have '/' extra in start
    public int lengthLongestPath(String input) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int level = 0;
        int maxLength = 0;

        for(int i=0; i<input.length(); i++) {
            // process directary
            level++;
            String fileOrDir = readFileOrDir(input, i);
            stack.push(stack.peek() + 1 + fileOrDir.length());
            if(fileOrDir.indexOf('.') > 0) { // file
                maxLength = Math.max(stack.peek(), maxLength);
            }
            i += fileOrDir.length();

            // process path
            if(i < input.length()) {
                String path = getPathLevel(input, i);
                // pop untill you reach same level
                while (!stack.empty() && level >= path.length()) {
                    stack.pop();
                    level--;
                }
                i += path.length() - 1;
            }
        }
        return maxLength -1;
    }

    private String getPathLevel(String input, int index) {
        StringBuilder sb = new StringBuilder();
        for(int i=index; i<input.length(); i++) {
            if(input.charAt(i) == '\n' || input.charAt(i) == '\t') {
                sb.append(input.charAt(i) + "");
            } else {
                break;
            }
        }
        return sb.toString();
    }

    private String readFileOrDir(String input, int index) {
        StringBuilder sb = new StringBuilder();
        for(int i=index; i<input.length() && input.charAt(i) != '\n'; i++) {
            sb.append(input.charAt(i) + "");
        }
        return sb.toString();
    }
}
