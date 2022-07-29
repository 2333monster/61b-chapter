import java.util.Iterator;
import java.util.stream.StreamSupport;

public class ArraySet<T> implements Iterable<T> {
    private T[] items;
    private int size; // the next item to be added will be at position size

    public ArraySet() {
        items = (T[]) new Object[100];
        size = 0;
    }

    /* Returns true if this map contains a mapping for the specified key.
     */
    public boolean contains(T x) {
        for (int i = 0; i < size; i += 1) {
            if (items[i].equals(x)) {
                return true;
            }
        }
        return false;
    }

    /* Associates the specified value with the specified key in this map.
       Throws an IllegalArgumentException if the key is null. */
    public void add(T x) {
        if (x == null) {
            throw new IllegalArgumentException("can't add null");
        }
        if (contains(x)) {
            return;
        }
        items[size] = x;
        size += 1;
    }

    /* Returns the number of key-value mappings in this map. */
    public int size() {
        return size;
    }

    /**
     * returns an iterator (a.k.a. seer) into ME
     */
    public Iterator<T> iterator() {
        return new ArraySetIterator();
    }

    private class ArraySetIterator implements Iterator<T> {
        private int wizPos;

        public ArraySetIterator() {
            wizPos = 0;
        }

        public boolean hasNext() {
            return wizPos < size;
        }

        public T next() {
            T returnItem = items[wizPos];
            wizPos += 1;
            return returnItem;
        }
    }


    @Override
    public String toString(){
        StringBuilder returnsb =  new StringBuilder("{");
        for(int i = 0; i < size; i += 1){
            returnsb.append(items[i].toString());
            returnsb.append(",");
        }
        returnsb.append("}");
        return returnsb.toString();
    }

    @Override
    public boolean equals(Object B){
        if(this == B){
            return true;
        }
        if(this.getClass() != B.getClass()){
            return false;
        }
        ArraySet<T> o = (ArraySet<T>) B;
        if(o.size() != this.size()){
            return false;
        }
        for(T item : o){
            if(!this.contains(item)){
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        ArraySet<Integer> aset = new ArraySet<>();
        aset.add(5);
        aset.add(23);
        aset.add(42);

        //iteration
        for (int i : aset) {
            System.out.println(i);
        }

        //toString
        System.out.println(aset);
    }
}
