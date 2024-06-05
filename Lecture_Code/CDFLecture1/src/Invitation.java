import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import sun.util.calendar.CalendarDate;

public   class Invitation <A> {
	static int Ticketnumber = 100;
	  A Recipient;
	   int ticketnum;
	  public Invitation(A inrecipient, int innum) {                  // constructor
	   Recipient = inrecipient;
	   ticketnum = Ticketnumber ;
	   Ticketnumber +=50;
	  }
	  public A getRecipient() { return Recipient; }
	  public  int getTicketNumber() { return ticketnum;}
	  public String toString() {
	    return "[" + Recipient.toString() + ", Ticket#: " + Integer.toString(ticketnum) + "]";
	  }
}
