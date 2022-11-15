package com.techiekunal.coding.interview.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Reference - https://www.youtube.com/watch?v=MLFe8srYeEY&ab_channel=MartySteppCS106CS193StanfordArchive
 *
 */
public class NQueenProblem {

    private List<List<String>> result = new ArrayList<>();
    private List<List<Integer>> queenIndexes = new ArrayList();

    public static void main(String[] args) {
        NQueenProblem problem = new NQueenProblem();
        List<List<String>> res = problem.solveNQueens(4);
        System.out.println(res);
    }

    public List<List<String>> solveNQueens(int n) {
        char[][] board = initBoard(n);
        placeQueenDFS(board, n, 0);
        return result;
    }

    private void placeQueenDFS(char[][] board, int n, int col) {

        if(col == n) {
            populateResult(n, board); // add to result
            return;
        }

        for(int r = 0; r < n; r++) {
            if(!isAttack(r, col)) {
                queenIndexes.add(Arrays.asList(r, col));
                board[r][col] = 'Q';
                placeQueenDFS(board, n, col+1); // all positions attack - loop over
                board[r][col] = '.';
                queenIndexes.remove(queenIndexes.size()-1); // remove last queen places :: backtrack
            }
        }
    }

    private boolean isAttack(int i, int j) {
        for(List<Integer> indexes : queenIndexes) {
            if(indexes.get(0) == i || indexes.get(1) == j || Math.abs((indexes.get(0) - i)) == Math.abs((indexes.get(1) - j))) {
                return true;
            } //same row || same colmn || diagonal
        }
        return false;
    }


    private char[][] initBoard(int n) {

        char[][] board = new char[n][n];
        for(int i=0; i < n; i++) {
            for(int j=0; j<n; j++) {
                board[i][j] = '.';
            }
        }
        return board;
    }

    private List<List<String>> populateResult(int n, char[][] board) {
        List<String> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            String str = new String(board[i]);
            list.add(str);
        }
        result.add(list);
        return result;
    }


}
