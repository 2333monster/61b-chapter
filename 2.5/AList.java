/** Array based list.
 * @john tito
 */

public class AList {
    int[] items;
    int size;

    /** creates an empty list.*/
    public AList(){
        items = new int[100];
        size = 0;
    }

    /** Insert X into the back of the list. */
    public void addLast(int x){
        if(size == items.length){
            int[] a = new int[size + 1];
            System.arraycopy(items,0,a,0,size);
            items = a;
        }
        items[size] = x;
        size += 1;
    }

    /** returns the item from the back of the list. */
    public int getLast(){
        return items[size-1];
    }

    /** gets the ith item in the list. */
    public int get(int i){
        return items[i-1];
    }

    /** returns the number of item in the list. */
    public int size(){
        return size;
    }

    /** deletes item from back of the list
     * and return the item. */
    public int removeLast(){
        int returnItem = getLast();
        size -= 1;
        return returnItem;
    }
}
