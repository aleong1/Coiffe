/*
Coiffe -- Alexia Leong, Lynne Wang, Lily Yan
APCS2 pd1
HW49 -- Sink || Swim
2018-05-14
*/

/*****************************************************
* class ALHeap
* SKELETON
* Implements a min heap using an ArrayList as underlying container
*****************************************************/

import java.util.ArrayList;

public class ALHeap
{

  //instance vars
  private ArrayList<Integer> _heap;

  /*****************************************************
  * default constructor  ---  inits empty heap
  *****************************************************/
  public ALHeap()
  {
    _heap = new ArrayList<Integer>();
  }

    /*****************************************************
     * toString()  ---  overrides inherited method
     * Returns either
     * a) a level-order traversal of the tree (simple version)
     * b) ASCII representation of the tree (more complicated, more fun)
     *****************************************************/
    public String toString()
    {
	String s = "";
	/*
	int numBranches = 1;

        for (int start = 0; start < _heap.size(); start = 2*start+1) {
	    s += "\n";
	    for (int ctr = start; ctr < _heap.size() && ctr < 2*start+1; ctr ++) {
		s += _heap.get(ctr) + " ";
	    }
	    if (2*start+1 < _heap.size()) {
		s += "\n" + multiplyStrings(numBranches, "/\\");
		numBranches *= 2;
	    }
	}
	*/

	for (Integer i: _heap) s += i + " ";
	return s;
    }//O(?)

    //toString() helper
    private String multiplyStrings(int n, String s) {
	String ans = "";
	for (int ctr = 0; ctr < n; ctr ++) ans += s;
	return ans;
    }

    /*****************************************************
     * boolean isEmpty()
     * Returns true if no meaningful elements in heap, false otherwise
     *****************************************************/
    public boolean isEmpty()
    {
	return _heap.size() == 0;
    }//O(1)


    /*****************************************************
     * Integer peekMin()
     * Returns min value in heap
     * Postcondition: Heap remains unchanged.
     *****************************************************/
    public Integer peekMin()  //return the root
    {
        return _heap.get(0);
    }//O(1)


    /*****************************************************
     * add(Integer)
     * Inserts an element in the heap
     * Postcondition: Tree exhibits heap property.
     *****************************************************/
    public void add( Integer addVal )
    {
	_heap.add(addVal); //adding new leaf such that heap is still complete
	int currentIndex = _heap.size()-1;

	while (currentIndex > 0) { //rearranging tree until new node is at legal position
	    int parentIndex = (currentIndex-1)/2;
	    if (_heap.get(parentIndex).compareTo(_heap.get(currentIndex)) > 0) swap(currentIndex, parentIndex);
	    currentIndex = parentIndex;
	}
    }//O(logn)


    /*****************************************************
     * removeMin()  ---  means of removing an element from heap
     * Removes and returns least element in heap.
     * Postcondition: Tree maintains heap property.
     *****************************************************/
    public Integer removeMin()   //remove the root
    {
	if (_heap.size() == 0) return null; //if size of heap is 0

	Integer min = new Integer(_heap.remove(0)); //storing val to be removed

	if (_heap.size() == 0) return min; //if size was 1, no need to rearrange anything in the heap

	_heap.add(0, _heap.remove(_heap.size()-1)); //putting last leaf as root
	int currentIndex = 0;
	int childIndex = minChildPos(0);

	//rearranging tree until new root is at legal position
	while (childIndex != -1) { //while current node still has children
	    if (_heap.get(childIndex).compareTo(_heap.get(currentIndex)) < 0) swap(currentIndex, childIndex);
	    currentIndex = childIndex;
	    childIndex = minChildPos(currentIndex);
	}
	return min;

    }//O(logn)


    /*****************************************************
     * minChildPos(int)  ---  helper fxn for removeMin()
     * Returns index of least child, or
     * -1 if no children, or if input pos is not in ArrayList
     * Postcondition: Tree unchanged
     *****************************************************/
    private int minChildPos( int pos )
    {
        int leftChild = 2*pos + 1;
	int rightChild = 2*pos + 2;
	if (pos >= _heap.size() || rightChild >= _heap.size()) return -1;
	if (minOf(_heap.get(leftChild), _heap.get(rightChild)).equals(_heap.get(leftChild))) return leftChild;
	return rightChild;
    }//O(1)


    //************ aux helper fxns ***************
    private Integer minOf( Integer a, Integer b )
    {
	if ( a.compareTo(b) < 0 )
	    return a;
	else
	    return b;
    }
=======

  /*****************************************************
  * removeMin()  ---  means of removing an element from heap
  * Removes and returns least element in heap.
  * Postcondition: Tree maintains heap property.
  *****************************************************/
  public Integer removeMin()   //remove the root
  {
    if (_heap.size() == 0) return null; //if heap is empty

    Integer min = _heap.remove(0);

    if (_heap.size() == 0) return min; //if heap had only one element

    swap(0, _heap.size()-1);
    int currentIndex = 0;
    int childIndex = minChildPos(currentIndex);
    System.out.println(childIndex);

    while (childIndex != -1) {
      if (_heap.get(childIndex).compareTo(_heap.get(currentIndex)) < 0) swap(currentIndex, childIndex);
      currentIndex = childIndex;
      childIndex = minChildPos(currentIndex);
    }
    //********************************************



    //main method for testing
    public static void main( String[] args )
    {
	ALHeap pile = new ALHeap();

	pile.add(2);
	System.out.println(pile);
	pile.add(4);
	System.out.println(pile);
	pile.add(6);
	System.out.println(pile);
	pile.add(8);
	System.out.println(pile);
	pile.add(10);
	System.out.println(pile);
	pile.add(1);
	System.out.println(pile);
	pile.add(3);
	System.out.println(pile);
	pile.add(5);
	System.out.println(pile);
	pile.add(7);
	System.out.println(pile);
	pile.add(9);
	System.out.println(pile);

	System.out.println("\nremoving " + pile.removeMin() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMin() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMin() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMin() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMin() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMin() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMin() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMin() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMin() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMin() + "...");
	System.out.println(pile);
	System.out.println("removing " + pile.removeMin() + "...");
	System.out.println(pile);
	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

	System.out.println("      1\n     /\\\n    4 2\n   /\\ /\\\n  5 7 6 3\n /\\/\n8 7 10");
    }//end main()
=======
    return min;
  }//O(?)


  /*****************************************************
  * minChildPos(int)  ---  helper fxn for removeMin()
  * Returns index of least child, or
  * -1 if no children, or if input pos is not in ArrayList
  * Postcondition: Tree unchanged
  *****************************************************/
  private int minChildPos( int pos )
  {
    int leftChild = 2*pos + 1;
    int rightChild = 2*pos + 2;
    if (pos >= _heap.size() ||
    (leftChild >= _heap.size() && rightChild >= _heap.size())) return -1;
    if (_heap.get(leftChild).compareTo(_heap.get(rightChild)) <= 0) return leftChild;
    return rightChild;
  }//O(?)


  //************ aux helper fxns ***************
  private Integer minOf( Integer a, Integer b )
  {
    if ( a.compareTo(b) < 0 )
    return a;
    else
    return b;
  }

  //swap for an ArrayList
  private void swap( int pos1, int pos2 )
  {
    _heap.set( pos1, _heap.set( pos2, _heap.get(pos1) ) );
  }
  //********************************************



  //main method for testing
  public static void main( String[] args )
  {
    ALHeap pile = new ALHeap();

    pile.add(2);
    System.out.println(pile);
    pile.add(4);
    System.out.println(pile);
    pile.add(6);
    System.out.println(pile);
    pile.add(8);
    System.out.println(pile);
    pile.add(10);
    System.out.println(pile);
    pile.add(1);
    System.out.println(pile);
    pile.add(3);
    System.out.println(pile);
    pile.add(5);
    System.out.println(pile);
    pile.add(7);
    System.out.println(pile);
    pile.add(9);
    System.out.println(pile);

    System.out.println("removing " + pile.removeMin() + "...");
    System.out.println(pile);
    System.out.println("removing " + pile.removeMin() + "...");
    System.out.println(pile);
    System.out.println("removing " + pile.removeMin() + "...");
    System.out.println(pile);
    System.out.println("removing " + pile.removeMin() + "...");
    System.out.println(pile);
    System.out.println("removing " + pile.removeMin() + "...");
    System.out.println(pile);
    System.out.println("removing " + pile.removeMin() + "...");
    System.out.println(pile);
    System.out.println("removing " + pile.removeMin() + "...");
    System.out.println(pile);
    System.out.println("removing " + pile.removeMin() + "...");
    System.out.println(pile);
    System.out.println("removing " + pile.removeMin() + "...");
    System.out.println(pile);
    System.out.println("removing " + pile.removeMin() + "...");
    System.out.println(pile);
    System.out.println("removing " + pile.removeMin() + "...");
    System.out.println(pile);
    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }//end main()

}//end class ALHeap
