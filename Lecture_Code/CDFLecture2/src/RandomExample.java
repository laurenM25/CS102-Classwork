import java.util.Random;

public class RandomExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    boolean flag = false;
    int currseed=2;
    while (!flag) {
     Random r = new Random(currseed);
     for (int i =1; i<=3; i++) {
    	 int num;
    	 num=r.nextInt(10)+1;
    	 if (num==  (r.nextInt(10)+1)){
    		 System.out.println(num);
    		 System.out.println(currseed);
    		 flag=true;
    	 };
     }
     currseed++;
    }
    
    
	}

}
