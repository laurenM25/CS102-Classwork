
public class  OurList<E> {
      private   E[] arr;
      private   int n=0; //n is the number of elements in the array
      
	public OurList(int capacity) {
		arr = (E[]) new Object[capacity];
	}
	public void Add( E element  ) {
		 this.Add(element,n);
		}
	public void Add( E element, int index ) {
	if (index > n) {System.out.println("Index error: " + index); return;}
	for (int k=n-1; k >= index; k--)        
	    arr[k+1] = arr[k];
	    arr[index] = element;                            
	    n++;
	}
	public   void printList() {
	    	System.out.println();
	    	 for (int i = 0; i<n; i++) {   	 
	         System.out.print(arr[i].toString() + " ");
	         }
	    }
}
