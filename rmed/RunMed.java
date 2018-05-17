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
 *****************************************************/

import java.util.ArrayList;

public class RunMed {

    //instance vars
    ALHeapMin lilVals;
    ALHeapMax bigVals;

    /*****************************************************
     * default constructor  ---  inits empty heaps
     *****************************************************/
    public RunMed() {
	lilVals = new ALHeapMin();
	maxVals = new ALHeapMax();
    }

    /*****************************************************
     * Integer getMedian()
     * Returns median of current values in both heaps
     * throws NoSuchElementException() if heaps are empty
     * Postcondition: heaps remain unchanged
     *****************************************************/
    public Integer getMedian() {
	return null;
    }

    /*****************************************************
     * void add(Integer newVal)
     * adds newVal to appropriate heap
     * balances heaps if they have a size difference >= 2
     *****************************************************/
    public void add(Integer newVal) {
    }

    //main method
    public static void main(String[] args) {
	/**************** MOVE ME DOWN **********************
         RunMed aiexl = new RunMed();
         System.out.println("\nHere we go!");

         for (int ctr = 0; ctr < 15; ctr ++) {
             int newVal = (int)(Math.random() * 100);

             System.out.println("\nValue being added: " + newVal);
             aiexl.add(newVal);

             System.out.println("Current medium: " + aiexl.getMedian());
         } 
	 **************** HIP HIP HOORAY ********************/

    }
    
}//end of RunMed class
