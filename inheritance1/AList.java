/** Array based list.
 * @johntito
 */

public class AList<T> implements List61B<T> {
    T[] items;
    int size;

    /** creates an empty list.*/
    public AList(){
        items = (T[]) new Object[100];
        size = 0;
    }

    @Override
    public void insert(T x, int position){
        T[] newItems = (T[]) new Object[items.length + 1];

        System.arraycopy(items,0,newItems,0,position);
        newItems[position] = x;

        System.arraycopy(items,position,newItems,position+1,items.length-position);
        items = newItems;
    }


    /** Resize the capacity of the list. */
    private void resize(int capacity){
            T[] a = (T[]) new Object[capacity];
            System.arraycopy(items,0,a,0,size);
            items = a;
    }

    @Override
    public void addFirst(T x) {
        insert(x, 0);
    }


    @Override
    /** Insert X into the back of the list. */
    public void addLast(T x){
        if(size == items.length){
            resize(size*2);
        }
        items[size] = x;
        size += 1;
    }


    @Override
    public T getFirst() {
        return get(0);
    }



    /** returns the item from the back of the list. */
    @Override
    public T getLast(){
        return items[size-1];
    }

    /** gets the ith item in the list. */
    @Override
    public T get(int i){
        return items[i];
    }

    /** returns the number of item in the list. */
    @Override
    public int size(){
        return size;
    }

    /** deletes item from back of the list
     * and return the item. */
    @Override
    public T removeLast(){
        T returnItem = getLast();
        items[size - 1] = null;
        size -= 1;
        return returnItem;
    }
}
