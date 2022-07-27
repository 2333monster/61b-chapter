public class SLList<Blorp> implements List61B<Blorp>{
    private class   Node{
        public Blorp item;
        public  Node next;

        public  Node(Blorp i,    Node n){
            item = i;
            next = n;
        }
    }
    private Node sentinel;
    public int size;


    /** instanitate a empty sslist*/
//    public SLList(){
//        sentinel = new    Node(,null);
//        size = 0;
//    }


    public SLList(){
        sentinel = new Node(null,null);
        size = 0;
    }

    public SLList(Blorp x){
        sentinel = new  Node(null,null);
        sentinel.next = new Node(x,null);
        size = 1;
    }


    public void insert(Blorp item, int position){
        Node p = sentinel;
        while(position > 1 && p.next != null){
            position--;
            p = p.next;
        }
        Node newNode = new Node(item,p.next);
        p.next = newNode;
    }

    /** Adds an item to the front of the sllist*/
    public void addFirst(Blorp x){
        sentinel.next = new Node(x,sentinel.next);
        size += 1;
    }

    /** Retrieves the front item from the list. */
    public Blorp getFirst() {
        return sentinel.next.item;
    }

    /** Adds an iterm to the last of the list*/
    public void addLast(Blorp x){
        Node p = sentinel;
        size += 1;
        // if(p == null){
        //  p = new Node(x,null);
        //  return ;
        // }

        while(p.next != null){
            p = p.next;
        }

        p.next =  new   Node(x,null);
    }

    /** Retrieves the last of the list*/
    public Blorp getLast(){
        Node p = sentinel;

        while(p.next != null){
            p = p.next;
        }

        return p.item;
    }


    private Node getLastNode() {
         Node p = sentinel;

         /* Move p until it reaches the end. */
         while (p.next != null) {
             p = p.next;
         }
         return p;
     }

    // /** return the length of the list*/
    // private static int size  Node p){
    //  if(p.next == null){
    //      return 1;
    //  }else{
    //      return 1 + SLList.size(p.next);
    //  }
    // }

    public Blorp get(int i){
        return get(i, sentinel.next);
    }

    public Blorp get(int i, Node p){
        if(i == 0){
            return p.item;
        }
        return get(i-1,p.next);
    }

    public Blorp removeLast(){
        Node back = getLastNode();
        if(back == sentinel){
            return null;
        }

        Node p = sentinel;

        while(p.next != back){
            p = p.next;
        }
        p.next = null;
        return back.item;
    }

    public int size(){
        return size;
    }

    public void print() {
        System.out.println("THIS IS THE OVERRIDDEN VERSION.");
        Node p = sentinel.next;
        while (p != null) {
            System.out.print(p.item + " ");
            p = p.next;
        }
    }



    public static void main(String[] args) {
        SLList<Integer> L = new SLList<>();
        L.addFirst(10);
        L.addFirst(5);
        L.addLast(10);
        System.out.println(L.getLast());
        System.out.println(L.size());
    }
}