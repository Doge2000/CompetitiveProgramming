import java.util.*;
import java.io.*;

public class UniquePaths {
    static int[][] memo;
    public static void main(String[] args) throws Exception {
        //find number of unique paths from top left to bottom right
        int m = 3;
        int n = 7;
        memo = new int[3][7];
        for(int[] arr: memo){
            Arrays.fill(arr, -1);
        }
        int[][] mat = new int[m][n];
        System.out.println(recur(0,0, mat)); //returns 28

    }
    public static int recur(int r, int c, int[][] mat){
        if(r==mat.length-1 && c==mat[0].length-1) return 1; //found a way to reach the bottom right
        if(r>=0 && c>=0 && r<mat.length && c<mat[r].length){
            if(memo[r][c]!=-1) return memo[r][c]; //return memoized result
            int result  = recur(r+1, c, mat)+recur(r, c+1, mat);
            return memo[r][c] =result;
        }
        return 0;
    }
}