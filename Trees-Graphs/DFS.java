import java.util.*;
import java.io.*;

public class DFS {
    public static void main(String[] args) throws Exception {
        //find if path exists in an undirected bidirectional graph
        int[][] edges = {{0,1}, {1,2}, {2,0}};
        int n = 3;
        int source = 0;
        int destination = 2;
        HashSet<Integer> vis = new HashSet<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(); //adjacency list
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<edges.length; i++){
            int node1 = edges[i][0];
            int node2 = edges[i][1];
            adj.get(node2).add(node1);
            adj.get(node1).add(node2);
        }
        System.out.println(recur(source, destination, adj, vis)); //returns true

        /* Notes:
        - You can also do it iteratively with a Stack like BFS
        - Slightly worse for finding the shortest path
        - Definitely will need optimization
        - O(V+E)
         */

    }
    public static boolean recur(int currnode, int goal, ArrayList<ArrayList<Integer>> adj, HashSet<Integer> vis){
        if(currnode==goal) return true; //reached destination
        vis.add(currnode);
        for(int neighbor: adj.get(currnode)){
            if(!vis.contains(neighbor)){
                if(recur(neighbor, goal, adj, vis)){ //checking the path
                    return true;
                }
            }
        }
        return false;


    }
}
