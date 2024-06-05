import java.util.ArrayList;

public class GenericExample_ReverseArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       ArrayList<NYUFaculty>  sarray= new ArrayList<NYUFaculty>();
       sarray.add(new NYUFaculty("abc","123"));
       sarray.add(new NYUFaculty("def","456"));
       sarray.add(new NYUFaculty("ghi","789"));
        printarray(sarray);
        sarray=reverse(sarray);
        printarray(sarray);
	}
	
	public static   <ABB> ArrayList<ABB> reverse( ArrayList<ABB>   inarray) {
		ArrayList<ABB>  outarray;
		outarray = new  ArrayList<ABB>();
		for (int i =inarray.size()-1; i>=0;i--) {
			outarray.add(inarray.get(i));
		}		
		return  outarray;
	}
	public  static <R> void printarray(ArrayList<R> inarray) {
		R element;
		for (int i =0; i < inarray.size() ; i++) {
		    element = inarray.get(i);
			System.out.println(element.toString());;
		}
	}

}
