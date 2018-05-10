/* Find Design - Alexia Leong and Fiona Cai
APCS2 pd1
HW46 -- Arrr, There Be Priorities Here Matey
2018-05-10 */

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
    String min = _arrPQ.get(0);
    for(int i = 1; i < _arrPQ.size();i++){
      if(_arrPQ.get(i).compareTo(min) < 0 ){
        min = _arrPQ.get(i);
      }
    }
    return min;
  }

  public String removeMin(){     //O(n)
    String min = _arrPQ.get(0);
    for(int i = 1; i < _arrPQ.size();i++){
      if(_arrPQ.get(i).compareTo(min) < 0 ){
        min = _arrPQ.get(i);
      }
    }
    _arrPQ.remove(min);
    return min;
  }

  public static void main(String args[]) {
    //Tests
    ArrayPriorityQueue test = new ArrayPriorityQueue();
    System.out.println(test.isEmpty()); //TRUE
    test.add("hi");
    test.add("ahmed");
    test.add("can't");
    test.add("make");
    test.add("wordsearchpuzzles");

    System.out.println(test.isEmpty()); //FALSE
    System.out.println(test.peekMin()); //ahmed
    System.out.println(test.removeMin()); //removes ahmed
    while(!test.isEmpty()){
      System.out.println(test.removeMin());
    }
    System.out.println(test.isEmpty()); //TRUE
  }
}
