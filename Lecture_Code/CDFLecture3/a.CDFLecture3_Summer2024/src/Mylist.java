
public class Mylist<E> extends SinglyLinkedList {

	public void checkit() throws Exception{ // this method >might< throw an exception
		Node<E> next;
		next = super.head;

		// 5/30 added below statement during class >>
		if(true){ // perhaps there's not enough heap left! we don't care about specifying the condition rn
			throw new Exception();
		}

		System.out.println("checkit:" + next.getElement().toString()); // MY added method (well Professor's)
	}
}
