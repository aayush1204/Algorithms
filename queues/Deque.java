
import java.util.NoSuchElementException;
import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {

    private Node first;
    private Node last;
    private int size;
    private class Node{
        Item item;
        Node next;
    }
    // construct an empty deque
    public Deque()
    {
        first = null;
        last = null;
        size = 0;
    }

    // is the deque empty?
    public boolean isEmpty()
    {
        return size == 0;
    }
    // return the number of items on the deque
    public int size()
    {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item)
    {
        if (null == item) throw new IllegalArgumentException("Can't add null item to the deque!");
        
        Node oldFirst;
        if(first !=null)
        {
        oldFirst = first;
        first = new Node();
        first.item = item ;
        first.next = oldFirst ;
        }
        else
        {
        first = new Node();
        first.item = item ;
        first.next = null ;
        }
        if (size == 0){ last = first;}
        size++;
    }
    // add the item to the back
    public void addLast(Item item)
    {
        if (null == item) throw new IllegalArgumentException("Can't add null item to the deque!");
        Node oldLast = last;
        last = new Node();
        last.item = item ;
        last.next = null;
        if (oldLast != null)
        {
            oldLast.next = last;
        }
        if (size == 0){first = last;}
        size++;
    }

    // remove and return the item from the front
    public Item removeFirst()
    {   
        if(first ==null)
        {
            throw new java.util.NoSuchElementException("Deque is empty"); 
        }
        Item item = first.item;
        Node oldfirst = first;
        
        if (size == 1)
        {
            first = null;
            last = null;
        }
        else{
        first = first.next;
        }
        size--;
        return item;
        
    }

    // remove and return the item from the back
    public Item removeLast()
    {   
        if(last == null)
        {
            throw new java.util.NoSuchElementException("Deque is empty"); 
        }
        Item item = last.item;
        Node oldfirst = first;
        if(size>1)
        {
        while(oldfirst.next.next != null)
        {
            oldfirst = oldfirst.next;
        }
        }

        if (first  == last)
        {
            first = null;
            last = null;
        }
        else
        {
        last = oldfirst;
        last.next = null;
        }
        size--;

        if (size == 0)
        {
            first = null;
            last = null;

        }
        return item;
    }
    // return an iterator over items in order from front to back
    public Iterator<Item> iterator(){ return new ListIterator(); }

    private class ListIterator implements Iterator<Item>
    {
        private Node current = first;

        public boolean hasNext(){ 
            if(current==null)
            {
                return false;
            } 
            else
            return current.next != null;}
        public Item next()
        {
            if (current==null) throw new NoSuchElementException("There is no more items!");
            
            Item item = current.item;
            current = current.next;
            return item;
        }

        public void remove() {
            throw new UnsupportedOperationException("Remove operator is unsupported!");
        }

    }

    // unit testing (required)
    public static void main(String[] args)
    {}

}