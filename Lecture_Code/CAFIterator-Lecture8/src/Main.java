import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class Main {

	public static void main(String[] args) {
	// populate an Arraylist with these array values
		
	int[] numbers = {1,2,3,3,2,1};
      ArrayList<Integer> a = new ArrayList<Integer>();
      for (int i = 0; i< numbers.length; i++) {
    	 a.add(numbers[i]) ;
      }
      
      
      // Show contents of an Arraylist using index
      System.out.println();
      for (int i =0; i<a.size();i++) {
    	  System.out.print (a.get(i));  System.out.print (" ");
      }
      System.out.print (" - Loop ");
      
      // Show contents of an Arraylist with an iterator
      System.out.println();
      Iterator<Integer> iter = a.iterator();
      while(iter.hasNext()) {
    	  System.out.print (iter.next());  System.out.print (" ");
         // a.add(4);
      }
      System.out.print (" - Iterator ");
      
        // Delete the elements equal to 3 with loop
       for (int i = 1; i<a.size(); i++) {
            if (a.get(i)==3) a.remove(i);
          
       } 
	   
       showArrayList(a);
       System.out.print (" - Delete 3 within a Loop - unsuccessful ");
       
    // Delete the elements equal to 3
         // reset numbers
       a = new ArrayList<Integer>();
       for (int i = 0; i< numbers.length; i++) {
     	 a.add(numbers[i]) ;
       }
       iter = a.iterator();
        while(iter.hasNext()) {
      	      int value = iter.next();
      		  if (value==3) {iter.remove();}
        }  
      	    showArrayList(a);
      	  System.out.print (" - Delete 3 with an Iterator - successful ");
       
       
      	// try to add contents with  iterator
     	 System.out.println();
     	iter = a.iterator();
         while(iter.hasNext()) {
          	  // iter.add(4);
       	  System.out.print (iter.next());  System.out.print (" ");  
         }   
      	  
      	  
      	  
	// add contents with listiterator, print only current values
	 System.out.println();
	 ListIterator<Integer> liter = a.listIterator();
    while(liter.hasNext()) {
     	 liter.add(4);
  	  System.out.print (liter.next());  System.out.print (" ");  
    } 
    
   showArrayList(a);
   
   
  	   
}
	public static void showArrayList(ArrayList a) {
		// Show contents of an Arraylist with an listiterator
		Iterator<Integer> iter = a.iterator();
	    System.out.println();
	    iter = a.iterator();
	    while(iter.hasNext()) {
	  	  System.out.print (iter.next());  System.out.print (" ");
	    } 
	}
	
}
