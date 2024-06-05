import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Game {
   Team visitor;
   Team home;
   GregorianCalendar gamedate;
   String Location;
   String Umpire;
   public Game( Team v, Team h, GregorianCalendar g) {
	   visitor = v;
	   home = h;
	   gamedate =g;
   }
  public String toString() {
	  SimpleDateFormat sdf = new SimpleDateFormat("MMM dd yyyy ");
	  String result;
	  result = visitor.Name + " visits " + home.Name + " at " + Location + 
			  "\nDateTime: " + sdf.format(gamedate.getTime())+ "Umpire: " + Umpire;
	  return result;
  }
}
