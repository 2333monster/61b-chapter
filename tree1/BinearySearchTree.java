public class BinearySearchTree<Key extends Comparable<Key>,Value>{
    public Node root;

    private class Node{
        public Key key;             // 键
        public Value value;         // 值
        public Node left, right;    // 指向树的链接
        public int N;               // 以该节点为根的子树的节点总数

        public Node(Key key, Value value, int n){
            this.key = key; this.value = value; this.N = n;
        }
    }

    /**
     * initializes an empty symbol type;
     */
    public BinearySearchTree(){
        ;
    }

    /**
     * returns true if this symbol table is empty.
     * @return {@code true} if this symbol table is empty; {@code false} otherwise;
     */
    public boolean isEmpty(){
        return size() == 0;
    }

    /**
     * returns the number of key-value pairs in this symbol table
     * @return the number of key-value pairs in this symbol table
     */
    public int size(){return size(root); }

    /**
     * returns the number of key-value pairs in BST rooted at x;
     */
    private int size(Node x){
        if(x == null){
            return 0;
        }
        else{
            return x.N;
        }
    }

    /**
     * Does the symbol table contain the given key
     * @param key the key
     * @return  {@code ture} if the symbol table contains {@code key} and
     *          {@code false} otherwise
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public boolean contains(Key key){
        if(key == null) throw new IllegalArgumentException();
        return get(key) != null;
    }

    /**
     * returns the value associated with the given key
     * @param key the key
     * @return  the value associated with the given key if the key is in the symbol table
     *          and {@code null} if the key is not in the symbol table
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Value get(Key key){
        return get(root.key);
    }

    private Value get(Node x, Key key){
        if(key == null) throw new IllegalArgumentException("calls get() with a null key");
        if(x==null) return null;
        int cmp = key.compareTo(x.key);
        if(cmp<0) return get(x.left,key);
        else if (cmp > 0) return get(x.right,key);
        else return x.value;
    }




}
