import edu.princeton.cs.algs4.Stack;

import java.io.File;

public class DFS {
    private boolean[] marked;
    private int[] edgeTo;
    private int source;

    static File m = new File("midium.txt");
    public DFS(Graph G, int s){
        marked = new boolean[G.V()];
        edgeTo = new int[G.E()];
        source = s;
        dfs(G, source);
    }

    private void dfs(Graph G, int v){
        marked[v] = true;
        for(int i : G.adj(v)){
            if(!marked[i]){
                edgeTo[i] = v;
                dfs(G,i);
            }
        }
    }

    public boolean hasPathTo(int v){
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v){
        if(!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<>();
        for(int x =v; x != source; x = edgeTo[v]){
            path.push(x);
        }
        path.push(source);
        return path;
    }

    public static void main(String[] args) {
        Graph G = new Graph(m);
        int s  = Integer.parseInt(args[1]);
        DFS d = new DFS(G,s);
        for(int v=0; v < G.V(); v++){
            System.out.println(s + "to" + v + ":");
            if(d.hasPathTo(v)){
                for(int x: d.edgeTo){
                    if (x == s) System.out.print(x);
                    else System.out.print("-" + x);
                }

                System.out.println();
            }
        }
    }
}
