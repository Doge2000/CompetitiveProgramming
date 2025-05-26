import java.util.*;
import java.io.*;
public class LCS {
    static int [][] memo;
    public static void main(String[] args) {
        String s1 = "bob";
        String s2 = "billyb";
        memo = new int[s1.length()][s2.length()];
        for(int[] arr: memo){
            Arrays.fill(arr, -1);
        }
        System.out.println(recur(0,0,s1,s2)); //returns 2


    }
    public static int recur(int i, int j, String s1, String s2){
        if(i>=s1.length()) return 0;
        if(j>=s2.length()) return 0;
        if(memo[i][j]!=-1) return memo[i][j];
        int result;
        if(s1.charAt(i)==s2.charAt(j)){ //if the characters are equals add to the length
            result = recur(i+1, j+1, s1, s2)+1;
        }
        else{
            int res1 = recur(i+1, j, s1, s2);
            int res2 = recur(i, j+1, s1, s2);
            result = Math.max(res1, res2);
        }
        return memo[i][j] = result;
    }
}
