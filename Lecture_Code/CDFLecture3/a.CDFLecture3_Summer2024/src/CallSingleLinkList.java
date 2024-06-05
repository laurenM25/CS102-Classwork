
public class CallSingleLinkList{

	public static void main(String[] args) throws CloneNotSupportedException { //throws Exception bc of Mylist method
		// TODO Auto-generated method stub
		NYUStudent s1, s2, s3, s4, s5;

		s1 = new NYUStudent("abc", "123");
		s2 = new NYUStudent("def", "456");
		s3 = new NYUStudent("ghi", "789");
		s4 = new NYUStudent("jkl", "012");
		s5 = new NYUStudent("mno", "345");
		Mylist<NYUStudent> mylist = new Mylist<NYUStudent>();

		mylist.addLast(s1);
		mylist.addLast(s2);
		mylist.addFirst(s3);
		mylist.addLast(s4);
		mylist.addFirst(s5);
		mylist.checkit(); // not very interesting, part of Mylist class
		System.out.println(mylist.toString());
		SinglyLinkedList<NYUStudent> clonelist = mylist.clone();

		System.out.println(mylist.toString());

	}

}
