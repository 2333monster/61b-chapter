/** Array based list.
 * @johntito
 */

public class AList<T> {
    T[] items;
    int size;

    /** creates an empty list.*/
    public AList(){
        items = (T[]) new Object[100];
        size = 0;
    }


    /** Resize the capacity of the list. */
    private void resize(int capacity){
            T[] a = (T[]) new Object[capacity];
            System.arraycopy(items,0,a,0,size);
            items = a;
    }

    /** Insert X into the back of the list. */
    public void addLast(T x){
        if(size == items.length){
            resize(size*2);
        }
        items[size] = x;
        size += 1;
    }

    public void insertLast(T x){
        if(size == items.length){
            resize(size*2);
        }
        items[size] = x;
        size += 1;
    }

    /** returns the item from the back of the list. */
    public T getLast(){
        return items[size-1];
    }

    /** gets the ith item in the list. */
    public T get(int i){
        return items[i-1];
    }

    /** returns the number of item in the list. */
    public int size(){
        return size;
    }

    /** deletes item from back of the list
     * and return the item. */
    public T removeLast(){
        T returnItem = getLast();
        size -= 1;
        return returnItem;
    }
}
