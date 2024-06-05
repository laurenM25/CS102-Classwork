import net.datastructures.*;
import java.util.Random;

public class ArrayListExamplle {
	static ArrayList<String> alist = new ArrayList<String>();
	public static void main(String[] args) {
	
	alist.add(0,"a");
	alist.add(1,"b");
	alist.add(1,"c");
	alist.add(3,"c");
	alist.add(1,"d");
	alist.add(5,"d");
	alist.add(6,"e");
	printList("Before");
	for (int i = 0; i<alist.size(); i++) {
		if (alist.get(i).equals("c")) { alist.remove(i);}
	}
	printList("After");
	}
	public static void printList(String title) {
		System.out.println(title);
		for (int i = 0; i<alist.size(); i++) {
			System.out.println(alist.get(i));
		}
	}

}
