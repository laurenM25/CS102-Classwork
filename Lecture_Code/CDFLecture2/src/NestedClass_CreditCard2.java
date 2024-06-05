import java.util.Random;
public class NestedClass_CreditCard2 { 
    static int accountnumber;
    int creditlimit = 20;
    static CardInfo thiscard,backupcard;
    Random r =new Random();
    public NestedClass_CreditCard2(int acct) {
    	accountnumber = acct;
    	
    	 thiscard = new CardInfo(r.nextInt(100));
    	 backupcard = new CardInfo(r.nextInt(100));
    }
    
    public static void displayInfo() {
    	System.out.println(accountnumber);
    	System.out.println(thiscard.ccode + "-" +  backupcard.ccode);
    	thiscard.display();backupcard.display();
    }
   
      class   CardInfo
    {
	   private String materialtype="TypeA";
	   private    int ccode;
	    CardInfo(int incode) {
	    	ccode= incode;
	    }
        void display() {
        	System.out.println(materialtype + " - " + ccode);
        }
    }
}
 

