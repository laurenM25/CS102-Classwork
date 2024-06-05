
public class Company {
   private String corpname;
   private String compid;
   public Company(String inname  , String inid   ) {
		corpname = inname;
		compid=inid;
	}
	public String toString() {
		return " Company Name: " + corpname + " ID: " + compid;
	}
}
