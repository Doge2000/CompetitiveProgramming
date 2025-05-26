import java.util.*;
import java.io.*;

public class JumpGame {
    static boolean[] memo;
    static int[] vis;
    public static void main(String[] args) throws Exception {
        // You are given an integer array nums.
        // You are initially positioned at the array's first index
        // and each element in the array represents your maximum jump length at that position.
        // Return true if you can reach the last index, or false otherwise.
        int[] nums = {2,3,1,1,4};
        int n = nums.length;
        memo = new boolean[n];
        vis = new int[n];
        Arrays.fill(vis, -1);
        System.out.println(recur(0, nums)); //returns true

    }
    public static boolean recur(int ind, int[] arr){
        if(ind>=arr.length-1) return true; //reached the end
        if(arr[ind]==0) return false; //no more jumps can be made
        else if(vis[ind]==-1){ //curr position not memoized yet
            boolean result = false;
            for (int i = 1; i <= arr[ind]; i++) { //jumping from ranges 1 to maximum amt jumped
                result = recur(ind+i, arr);
                if(result) break; //found a path
            }
            memo[ind] = result;
            vis[ind] = 1;
            return result;
        }
        return memo[ind]; //return memoized result
    }
}
