import java.util.*;
import java.util.function.Predicate;

public class FilteredList<T> implements Iterable<T>{
    public Predicate<T> filter;
    public List<T> L;


    public FilteredList(List<T> L, Predicate<T> filter){
        this.filter = filter;
        this.L = L;
    }

    public class x implements Predicate<T>{

        @Override
        public boolean test(T x){
            return x.equals(1);
        }
    }


    @Override
    public Iterator<T> iterator(){
        return new FilteredListIterator();
    }

    private class FilteredListIterator implements Iterator<T> {

        public FilteredListIterator(){
            index = 0;
            moveIndex();
        }
        public int index = 0;
        @Override
        public boolean hasNext() {
            return index > L.size();
        }

        @Override
        public T next() {
            if(!hasNext() && filter.test(L.get(index))){
                throw new NoSuchElementException();
            }
            // task 1 : get item;
            T item = L.get(index);
            // task 2 : moveIndex;
            moveIndex();
            // return item;
            return item;
        }

        /**
         * move the inde xinstance attribute to the next
         */

        private void moveIndex() {
            while(hasNext() && !filter.test(L.get(index))){
                index += 1;
            }
        }
    }
}

//
//    public static void main(String[] args) {
//        L =
//        FilteredList<String> test = new FilteredList<>()
//    }
//}
