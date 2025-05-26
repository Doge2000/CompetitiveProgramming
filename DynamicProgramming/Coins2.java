import java.util.*;
import java.io.*;

public class Coins2 {
    static int[] memo1;
    static int[][] memo2;
    public static void main(String[] args) throws Exception {
        // return the number of ways to make target
        int[] ar = {1, 3};
        int target = 4;
        System.out.println(BottomUp(target, ar)); //returns 2
        memo2 = new int[ar.length][target+1];
        for(int[] arr: memo2){
            Arrays.fill(arr, -1);
        }
        System.out.println(recur(0,0,target, ar));

    }
    public static int BottomUp(int target, int[] arr){
        memo1 = new int[target+1];
        memo1[0] = 1;
        for (int coin: arr) {
            for (int i = coin; i < memo1.length; i++) {
                memo1[i] += memo1[i-coin];
            }
        }
        return memo1[target];
    }
    public static int recur(int ind, int sum, int target, int[] arr){
        if(sum==target) return 1; //sum==target means we found away
        if(ind>=arr.length || sum>target) return 0;
        if(memo2[ind][sum]!=-1) return memo2[ind][sum];
        int result1 = recur(ind, sum+arr[ind], target, arr); //take
        int result2 = recur(ind+1, sum, target, arr); //skip
        return memo2[ind][sum] = result1+result2;
    }
}
