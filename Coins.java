import java.util.*;
import java.io.*;

public class Coins {
    static int[] memo1;
    static int[][] memo2;
    public static void main(String[] args){
        //returning the minimum amount of coins needed to make target
        int[] arr = {1, 3, 4, 9};
        int target = 13;
        System.out.println(BottomUp(arr, target)); // return 2;
        memo2 = new int[arr.length][target+1];
        for(int[] ar: memo2){
            Arrays.fill(ar, -1);
        }
        System.out.println(recur(0, target, arr, 0));




    }
    public static int BottomUp(int[] arr, int target){
        memo1 = new int[target+1];
        Arrays.fill(memo1, Integer.MAX_VALUE);
        memo1[0] = 0;
        for (int i = 1; i < memo1.length; i++) {
            for(int coin: arr){
                int diff = i-coin;
                if(diff>=0 && memo1[diff]!=Integer.MAX_VALUE){
                    memo1[i] = Math.min(memo1[diff]+1, memo1[i]);
                }
            }
        }
        return memo1[target]==Integer.MAX_VALUE?-1:memo1[target];
    }
    public static int recur(int sum, int target, int[] arr, int ind){
        if(sum==target) return 0;
        if(ind>=arr.length || sum>target || sum<0) return Integer.MAX_VALUE;
        if(memo2[ind][sum]!=-1) return memo2[ind][sum];
        int skip = recur(sum, target, arr, ind+1);
        int take = recur(sum+arr[ind], target, arr, ind);
        if(take!=Integer.MAX_VALUE){
            take+=1;
        }
        return memo2[ind][sum] = Math.min(skip, take);
    }
}