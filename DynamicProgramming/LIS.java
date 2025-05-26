import java.util.*;
import java.io.*;
public class LIS {
    static int[][] memo;
    public static void main(String[] args) {
        int[] arr = {0,1,0,-1,2,3,4};
        memo = new int[arr.length][arr.length];
        for(int[] ar: memo){
            Arrays.fill(ar, -1);
        }
        System.out.println(recur(0, -1, arr)); //returns 5

    }
    public static int recur(int ind, int prev, int[] arr){
        if(ind>=arr.length) return 0;
        if(memo[ind][prev+1]!=-1) return memo[ind][prev+1];
        int result = recur(ind+1, prev, arr); //skip
        if(prev==-1 || arr[ind]>arr[prev]){
            result = Math.max(result, recur(ind+1, ind, arr)+1); //take
        }
        return memo[ind][prev+1] = result;
    }
}
