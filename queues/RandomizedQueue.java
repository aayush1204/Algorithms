
import java.util.NoSuchElementException;
import java.util.Iterator;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> 
{

    private Item[] s ;
    private int N ;
    // construct an empty randomized queue
    public RandomizedQueue()
    {
        N = 0;
        s = (Item[]) new Object[10] ;
    }

    // is the randomized queue empty?
    public boolean isEmpty()
    {
        return N == 0;
    }

    // return the number of items on the randomized queue
    public int size()
    {
        return N;
    }

    // add the item
    public void enqueue(Item item)
    {
        if (null == item) throw new IllegalArgumentException("Can't enqueue null value!");

        if (N == s.length) {
            resize(s.length * 2);
        }

        
        s[N++] = item;
    }

    private void resize(int x) 
    {
        Item[] copy = (Item[]) new Object[x];

        for (int i = 0; i < N; i++) {
            copy[i] = s[i];
        }

        s = copy;
    }

    // remove and return a random item
    public Item dequeue()
    {
        if (isEmpty()) throw new NoSuchElementException("The queue is empty!");

        if (N == s.length / 4) {
            resize(s.length / 2);
        }
        int x ;
        x = StdRandom.uniform(N);
        
        Item item = s[x];
        s[x] = s[--N];
        s[N] = null;

        return item;
    }

    // return a random item (but do not remove it)
    public Item sample()
    {
        if (isEmpty()) throw new NoSuchElementException("The queue is empty!");
        int x = StdRandom.uniform(N);
        return s[x];
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator()
    {
        return new RandomizedQueueIterator();
    }

    private class RandomizedQueueIterator implements Iterator<Item>
    {
        private int i;
        private Item[] copy ;
        public RandomizedQueueIterator()
        {
            i = N;
            Item[] copy = (Item[]) new Object[i];

            for (int j = 0; j < i; j++) {
                copy[j] = s[j];
            }
        }
        

        public boolean hasNext(){
            return i > 0 ;
        }
        
        public Item next()
        {
            if (i == 0) throw new NoSuchElementException("The queue is empty!");
            
            int x = StdRandom.uniform(i);

            Item item = copy[x];
            copy[x] = copy[--i];
            copy[i] = null;

            return item;
        }
        public void remove() {
            throw new UnsupportedOperationException("Remove operator is unsupported!");
        }
    }

    // unit testing (required)
    public static void main(String[] args)
    {

    }

}