
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DoubleHeader {

	public static void main(String[] args) {
		Team t1,t2;
		t1=new Team("New York", "Yankees");
		t2=new Team("Boston", "RedSox");
		Game g1, g2;
		GregorianCalendar gamedate = new  GregorianCalendar();
		gamedate.set( 2018,9,1);
		g1 = new Game(t2,t1,gamedate);
		g1.gamedate.set(Calendar.HOUR,4);
		g1.Location = "Yankee Stadium";
		g1.Umpire = "Crew4";
	   // clone g1, then set the time to 8
		System.out.println(g1.toString());
	}

}
