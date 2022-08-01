import edu.princeton.cs.introcs.StdRandom;
import org.junit.Test;
import edu.princeton.cs.algs4.Stopwatch;

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
        System.arraycopy(id.id, 0, actual, 0, 10);
        assertArrayEquals(idexpected,actual);
    }
    public static double timeTrial(int N){
        int Max = N/10;
        UnionFind test = new UnionFind(N);
        Stopwatch sw = new Stopwatch();
        double item1 = StdRandom.uniform(Max);
        double item2 = StdRandom.uniform(Max);
        for(int i = 0; i < N; i ++){
            test.union((int)item1,(int)item2);
        }
        return sw.elapsedTime();

    }

    public static void main(String[] args) {
        System.out.println(timeTrial(100000000));
    }




}
