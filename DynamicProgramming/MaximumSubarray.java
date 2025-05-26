import java.util.*;
import java.io.*;

public class MaximumSubarray {
    static int[] memo;
    public static void main(String[] args) throws Exception {
        //find the maximum sum of a subarray
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int n = nums.length;
        memo = new int[n];
        Arrays.fill(memo, Integer.MIN_VALUE);
        int ans = Integer.MIN_VALUE;
        recur(0, nums);
        for(int number: memo){
            ans = Math.max(ans, number);
        }
        System.out.println(ans); //returns 6 --> [4,-1,2,1]

    }
    public static int recur(int ind, int[] arr){
        if(ind>=arr.length) return 0;
        if(memo[ind]!=Integer.MIN_VALUE) return memo[ind]; //return memoized result
        int result = arr[ind]; //only consider the element as the sum
        result = Math.max(result, recur(ind+1, arr)+arr[ind]); //store the max between the element and the sum after recurring
        return memo[ind] = result; //store the result

    }

}
