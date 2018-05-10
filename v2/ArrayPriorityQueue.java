/* 
   Coiffe -- Alexia Leong, Lynne Wang, Lily Yan
   APCS2 pd1
   HW46 -- Arrr, There Be Priorities Here Matey
   2018-05-10 
*/

import java.util.ArrayList;

public class ArrayPriorityQueue implements PriorityQueue{
    //instance vars
    private ArrayList<String> _arrPQ;

    public ArrayPriorityQueue(){
	_arrPQ = new ArrayList<String>();
    }

    public void add(String x){     //O(1)
	_arrPQ.add(x);   //adds to the end of ArrayList arrPQ
    }

    public boolean isEmpty(){    //O(1)
	return _arrPQ.size() == 0;
    }

    public String peekMin(){    //O(n)
	if (isEmpty()) return null;
	String min = _arrPQ.get(0);
	for(int i = 1; i < _arrPQ.size();i++){
	    if(_arrPQ.get(i).compareTo(min) < 0 ){
		min = _arrPQ.get(i);
	    }
	}
	return min;
    }

    public String removeMin(){     //O(n)
	if (isEmpty()) return null;
	String min = _arrPQ.get(0);
	for(int i = 1; i < _arrPQ.size();i++){
	    if(_arrPQ.get(i).compareTo(min) < 0 ){
		min = _arrPQ.get(i);
	    }
	}
	_arrPQ.remove(min);
	return min;
    }

    //toString
    public String toString() {
	String retStr = "FRONT-->";
	for (String s: _arrPQ) retStr += s + "-->";
	retStr += "END";
	return retStr;
    }

    public static void main(String args[]) {
	//Tests
	System.out.println("Initializing priority queue...");
	ArrayPriorityQueue test = new ArrayPriorityQueue();
	System.out.println("Is the queue empty?: " + test.isEmpty()); //TRUE

	System.out.println("\n\nFilling up queue...");
	
	test.add("hi");
	test.add("ahmed");
	test.add("can't");
	test.add("make");
	test.add("wordsearchpuzzles");
	
	System.out.println("\nQueue: " + test);
	System.out.println("Is the queue empty?: " + test.isEmpty()); //FALSE

	System.out.println("\n\nEmptying queue...");
	System.out.println("Current minimum: " + test.peekMin()); //ahmed
	System.out.println("Element removed: " + test.removeMin()); //removes ahmed
	System.out.println("State of queue: " + test);
	
	while(!test.isEmpty()){
	    System.out.println("\nElement removed: " + test.removeMin());
	    System.out.println("State of queue: " + test);
	}
	System.out.println("\nIs the queue empty?: " + test.isEmpty()); //TRUE
	System.out.println("Current minimum: " + test.peekMin());
	System.out.println("Element removed: " + test.removeMin());
    }
}
