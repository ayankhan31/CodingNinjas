import java.util.*;
public class Graphs {

    public static void dftraversal(int adjMatrix[][], int currentVertex, boolean visited[]){
        visited[currentVertex] = true;
        System.out.println(currentVertex+" ");
        for(int i=0;i<adjMatrix.length;i++){
            if(adjMatrix[currentVertex][i]==1 && visited[i] == false){
                //i is neighbor of currentVertex
                dftraversal(adjMatrix,i,visited);
            }
        }
    }

    public static void dftraversal(int adjMatrix[][]) {
        boolean visited[] = new boolean[adjMatrix.length];
        for(int i=0;i<adjMatrix.length;i++){ //this for loop is to go through all the vertices in the
                                            // graph, i.e., non-connected components as well!
            if(!visited[i]) {
                dftraversal(adjMatrix, 0, visited);
            }
        }
    }

    public static void bftraversal(int adjMatrix[][]){
        Queue<Integer> pendingVertices = new LinkedList<>();
        boolean visited[] = new boolean[adjMatrix.length];
        visited[0] = true;
        pendingVertices.add(0);
        while(!pendingVertices.isEmpty()){
            int currentVertex = pendingVertices.poll();
            System.out.println(currentVertex+" ");
            for(int i=0;i<adjMatrix.length;i++){
                if(adjMatrix[currentVertex][i] == 1 && !visited[i]){
                    //i is unvisited neighbor of currentVertex
                    pendingVertices.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        int adjMatrix[][] = new int[n][n];
        for(int i=0;i<e;i++){
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            adjMatrix[v1][v2] = 1;
            adjMatrix[v2][v1] = 1;
        }
//        dftraversal(adjMatrix);
    }
}
