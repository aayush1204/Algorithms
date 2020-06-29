import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Iterator;

public class Permutation {
    public static void main(String[] args)
    {
        int  k = Integer.parseInt(args[0]);

        RandomizedQueue<String> obj1 = new RandomizedQueue<>();
        while (!StdIn.isEmpty()) {
            obj1.enqueue(StdIn.readString());
        }

        Iterator<String> iterator = obj1.iterator();

        Iterator<String> iterate = obj1.iterator();

        for (int i = 0 ; i < k ; i++ )
        {
            StdOut.println(iterator.next());
        }
    }
 }