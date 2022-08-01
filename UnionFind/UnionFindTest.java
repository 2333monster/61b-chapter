import org.junit.Test;
import static org.junit.Assert.*;

public class UnionFindTest {
    @Test
    public void testUnion(){
        UnionFind id = new UnionFind(10);
        id.union(3,4);
        id.union(5,6);
        id.union(2,0);
        id.union(1,0);
        id.union(3,1);
        int[] idexpected = new int[]{0,0,0,4,0,6,6,7,8,9};
        int[] actual = new int[10];
        for(int i =0; i < 10; i++){
            actual[i] = id.id[i];
        }
        assertArrayEquals(idexpected,actual);
    }

    
}
