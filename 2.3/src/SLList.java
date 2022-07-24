public class SLList<BleepBlorp>{
    private class intnode{
        public BleepBlorp item;
        public intnode next;

        public intnode(BleepBlorp i, intnode n){
            item = i;
            next = n;
        }
    }
    private intnode sentinel;
    public int size;


    /** instanitate a empty sslist*/
//    public SLList(){
//        sentinel = new intnode(,null);
//        size = 0;
//    }


    public SLList(BleepBlorp x){
        sentinel = new intnode(x,null);
        sentinel.next = new intnode(x,null);
        size = 1;
    }

    /** Adds an item to the front of the sllist*/
    public void addFirst(BleepBlorp x){
        sentinel.next = new intnode(x,sentinel.next);
        size += 1;
    }

    /** Retrieves the front item from the list. */
    public BleepBlorp getFirst() {
        return sentinel.next.item;
    }

    /** Adds an iterm to the last of the list*/
    public void addLast(BleepBlorp x){
        intnode p = sentinel;
        size += 1;
        // if(p == null){
        // 	p = new intnode(x,null);
        // 	return ;
        // }

        while(p.next != null){
            p = p.next;
        }

        p.next =  new intnode(x,null);
    }

    /** Retrieves the last of the list*/
    public BleepBlorp getLast(){
        intnode p = sentinel;

        while(p.next != null){
            p = p.next;
        }

        return p.item;
    }

    // /** return the length of the list*/
    // private static int size(intnode p){
    // 	if(p.next == null){
    // 		return 1;
    // 	}else{
    // 		return 1 + SLList.size(p.next);
    // 	}
    // }


    public int size(){
        return size;
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