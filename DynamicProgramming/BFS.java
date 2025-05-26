import java.util.*;
import java.io.*;

public class BFS {
    public static void main(String[] args) throws Exception {
        //find if path exists in an undirected bidirectional graph
        int[][] edges = {{0,1}, {1,2}, {2,0}};
        int n = 3;
        int source = 0;
        int destination = 2;
        int[][] adj = new int[n][n]; //adj matrix
        for(int i=0; i<edges.length; i++){
            int node1 = edges[i][0];
            int node2 = edges[i][1];
            adj[node1][node2] = 1;
            adj[node2][node1] = 1;
        }
        boolean isPath = false;
        boolean[] vis = new boolean[n];
        Queue<Integer> q = new LinkedList<>(); //Queue for BFS
        q.offer(source);
        while(!q.isEmpty()){
            int currnode = q.poll();
            if(currnode==destination){ //reached destination
                isPath = true;
                break;
            }
            vis[currnode] = true;
            for (int i = 0; i < adj[currnode].length; i++) {
                if(!vis[i] && adj[i][currnode]==1){
                    q.offer(i);
                }
            }
        }
        System.out.println(isPath); //returns true
        /*
        Notes:
        - better for finding the shortest path
        - basis for Dijkstra's Algo
        - visits everything once
        - O(V+E)
         */

    }
}
