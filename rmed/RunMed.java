/*
  Coiffe -- Alexia Leong, Lynne Wang, Lily Yan
  APCS2 pd1
  HW50 -- Run Run Run
  2018-05-17
*/

/*****************************************************
 * class RunMed
 * calculates running median of input stream of Integers, 
 * by using min heap and max heap 

 * ADDING NEW VALUE ALGO
 1. If both heaps empty, make new value root of max heap.
 2. If new val is greater than root of max heap, add to min heap. 
    Else, add to max heap.
 3. If size difference of the two heaps >= 2, add root of max heap to min heap. 
    Repeat until size difference <= 1.
 
 * CALCULATING MEDIAN ALGO (precond: heaps are balanced)
 1. If size of heaps are equal, return mean of its roots.
 2. Else, return root of max heap.
 *****************************************************/

import java.util.ArrayList;
import java.util.*;

public class RunMed {

    //instance vars
    ALHeapMin bigVals;
    ALHeapMax lilVals;
    //note: they were named this way against the HW page's directions because it makes more sense.
    //If a value is bigger than the max heap's roots, it is added to the min heap, so the ALHeapMin variable is storing all the "big values." Thus, it should be called bigVals.
    //The same logic applies to naming the ALHeapMax variable lilVals.

    /*****************************************************
     * default constructor  ---  inits empty heaps
     *****************************************************/
    public RunMed() {
	bigVals = new ALHeapMin();
	lilVals = new ALHeapMax();
    }

    /*****************************************************
     * Integer getMedian()
     * Returns median of current values in both heaps
     * throws NoSuchElementException() if heaps are empty
     * Postcondition: heaps remain unchanged
     *****************************************************/
    public Integer getMedian() {
	if (lilVals.isEmpty()) throw new NoSuchElementException("No values to find median of!");
	if (lilVals.getSize() == bigVals.getSize()) return ((lilVals.peekMax() + bigVals.peekMin())/2); //if sizes of heaps are the same, return mean of their roots
	//else, return root of bigger heap
        if (lilVals.getSize() > bigVals.getSize()) return lilVals.peekMax();
	return bigVals.peekMin(); 
    }

    /*****************************************************
     * void add(Integer newVal)
     * adds newVal to appropriate heap
     * balances heaps if they have a size difference >= 2
     *****************************************************/
    public void add(Integer newVal) {
	//adding
	if (lilVals.getSize() == 0 || newVal.compareTo(lilVals.peekMax()) <= 0) lilVals.add(newVal); //if max heap is empty OR newVal is less than root of max heap, add to max heap
	else if (newVal.compareTo(lilVals.peekMax()) > 0) bigVals.add(newVal); //else, add to min heap

	//balancing
	int sizeDif = lilVals.getSize() - bigVals.getSize();
        while (Math.abs(sizeDif) >= 2) { //while heaps are unbalanced
	    Integer extra; //variable to store what value will be switched from one heap to the other
	    if (sizeDif > 0) { //if lilVals heap has greater size
		extra = lilVals.peekMax();
		bigVals.add(extra);
		sizeDif -= 1;
	    }
	    else { //if bigVals heap has greater size
		extra = bigVals.peekMin();
		lilVals.add(extra);
		sizeDif += 1;
	    }
	}
    }

    //main method
    public static void main(String[] args) {
         RunMed aiexl = new RunMed();
         System.out.println("\nHere we go!");

         for (int ctr = 0; ctr < 15; ctr ++) {
             int newVal = (int)(Math.random() * 100);

             System.out.println("\nValue being added: " + newVal);
             aiexl.add(newVal);

             System.out.println("Current median: " + aiexl.getMedian());
	/**************** MOVE ME DOWN **********************
	 **************** HIP HIP HOORAY ********************/
         } 

    }//end of main method
    
}//end of RunMed class
