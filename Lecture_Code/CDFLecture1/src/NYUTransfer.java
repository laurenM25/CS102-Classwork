
public class NYUTransfer extends NYUStudent {
	
    public NYUTransfer(String inname, String inid) {
		super(inname, inid);
		// TODO Auto-generated constructor stub
	}

	String prev_school;
	public void sendemail(String message) {
		// send an email with above message with priority normal
		System.out.println("NYUTransfer class " + message);
	}
    public void sendemail(String message, int priority) {
		// send an email with above message with given priority
		System.out.println("NYUTransfer class " + message + " " + Integer.toString(priority) );
	}
}
