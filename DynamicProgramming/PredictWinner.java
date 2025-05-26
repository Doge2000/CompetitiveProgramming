import java.util.*;
import java.io.*;

public class PredictWinner {
    static int[][] memo;
    public static void main(String[] args) throws Exception {
        //Find if player1 can win if they go first
        int[] arr = {1,5,2}; //should return player2 wins with 5 points
        int sum = 0;
        for(int n: arr){
            sum+=n;
        }
        memo = new int[arr.length][arr.length];
        for(int[] ar: memo){
            Arrays.fill(ar, -1);
        }
        int optimalp1 = recur(0, arr.length-1, arr);
        int optimalp2 = sum - optimalp1;
        if(optimalp1>optimalp2) System.out.println("Player 1 Wins with "+ optimalp1+" points");
        else System.out.println("Player 2 Wins with "+ optimalp2+" points");

    }
    public static int recur(int i, int j, int[] arr){
        if(i>j) return 0;
        if(memo[i][j]!=-1) return memo[i][j];
        int result1 = Math.min(recur(i+2, j, arr), recur(i+1,j-1, arr))+arr[i];
        int result2 = Math.min(recur(j+2, i, arr), recur(i+1, j-1, arr))+arr[j];
        return memo[i][j] = Math.max(result1, result2);
    }
}
