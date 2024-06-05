import java.util.Date;
import java.util.GregorianCalendar;

import sun.util.calendar.CalendarDate;

public class GenericClass_Invitation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     NYUFaculty f = new NYUFaculty("Prof. Jones", "2l3");
     NYUStudent s = new NYUStudent("Mary Smith", "321");
     Company c= new Company("IBM", "678");
     
     Invitation<NYUFaculty> inviteF = new Invitation<NYUFaculty>(f,232);
     System.out.println(inviteF.toString());
     
     Invitation<NYUStudent> inviteS = new Invitation<NYUStudent>(s,533);
     System.out.println(inviteS.toString());
     
     Invitation<Company> inviteC = new Invitation<Company>(c,569);
     System.out.println(inviteC.toString());
     
     Invitation<NYUPerson> inviteP = new Invitation<NYUPerson>(s,569);
     System.out.println(inviteP.toString());
	}

}
