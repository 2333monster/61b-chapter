/**
 * typical Graph implement
 * @author JohnTitor
 */


import edu.princeton.cs.algs4.Bag;

public class Graph {
    private int V;
    private int E;
    private Bag<Integer>[] adj;
    
    public Graph(int V){
        this.V = V;
        adj = (Bag<Integer>[]) new Object[V];
        for(int v = 0; v < V; v ++){
            adj[V] = new Bag<Integer>();
        }
    }
    public Graph(In in)
    {
        this(in.readInt()); // 读取V并将图初始化
        int E = in.readInt(); // 读取E
        for (int i = 0; i < E; i++)
        { // 添加一条边
            int v = in.readInt(); // 读取一个顶点
            int w = in.readInt(); // 读取另一个顶点
            addEdge(v, w); // 添加一条连接它们的边
        }
    }


        public int V(){
        return V;
    }
    public int E(){
        return E;
    }

    public void addEdge(int v, int w){
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }
    public Iterable<Integer> adj(int v){
        return adj[v];
    }

}
