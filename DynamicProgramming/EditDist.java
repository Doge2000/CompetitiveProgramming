import java.util.*;
import java.io.*;

public class EditDist {
    static int[][] memo;
    public static void main(String[] args) throws Exception {
        String s1 = "cow";
        String s2 = "bjw";
        memo = new int[s1.length()][s2.length()];
        for(int[] arr: memo){
            Arrays.fill(arr, -1);
        }
        System.out.println(recur(0,0,s1, s2)); //return 2
    }
    public static int recur(int i, int j, String s1, String s2){
        if(i>=s1.length()) return s2.length()-j; //leftover edits
        if(j>=s2.length()) return s1.length()-i;
        if(memo[i][j]!=-1) return memo[i][j];
        int result;
        if(s1.charAt(i)==s2.charAt(j)){
            result = recur(i+1, j+1, s1, s2); //same character means no edit
        }
        else{
            int result1 = recur(i+1, j+1, s1, s2)+1; //substitution
            int result2 = recur(i+1, j, s1, s2)+1; //insertion
            int result3 = recur(i, j+1, s1, s2)+1; //deletion
            result = Math.min(result1, Math.min(result2, result3));
        }
        return memo[i][j] = result;
    }
}
