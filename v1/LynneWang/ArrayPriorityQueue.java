//QokoNeuts (Lynne Wang, Kendrick Liang)
//APCS2 pd1
//HW #46: Arrr, There Be Priorities Here Matey
//2018-05-10

import java.util.ArrayList;

public class ArrayPriorityQueue implements PriorityQueue {

    //Instance variables
    private ArrayList<String> _queue;
    
    //Constructor
    public ArrayPriorityQueue() {
	_queue = new ArrayList<String>();
    }
    
    //Methods
    //adds String to end of ArrayList
    public void add( String str ) {
	_queue.add(str);
    } //O(1)

    //removes miminum String (priority)
    public String removeMin() {
	if (isEmpty())
	    return null;
	int minInd = 0;
        for(int i = 0; i < _queue.size(); i++)
	    if ((_queue.get(i)).compareTo(_queue.get(minInd)) < 0) 
		minInd = i;
	return _queue.remove(minInd);
    } //O(n)

    //returns minimum String (priority)
    public String peekMin() {
	if (isEmpty())
	    return null;
	int minInd = 0;
        for(int i = 0; i < _queue.size(); i++)
	    if ((_queue.get(i)).compareTo(_queue.get(minInd)) < 0) 
		minInd = i;
	return _queue.get(minInd);
    } //O(n)

    //returns true if empty, false if not
    public boolean isEmpty() {
	return _queue.size() == 0;
    } //O(1)

    //Main
    public static void main( String[] args ) {
	ArrayPriorityQueue queue = new ArrayPriorityQueue();
	queue.add("b");
	queue.add("a");
	queue.add("d");
	queue.add("c");
	System.out.println(queue.peekMin()); //a
	queue.removeMin();
	System.out.println(queue.peekMin()); //b
	queue.removeMin();
	System.out.println(queue.peekMin()); //c
	queue.removeMin();
	System.out.println(queue.peekMin()); //d
	queue.removeMin();
	System.out.println(queue.peekMin()); //null
	queue.removeMin();
    }
}
