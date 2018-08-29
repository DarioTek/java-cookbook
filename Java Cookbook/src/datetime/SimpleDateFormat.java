package datetime;

import java.util.Date;

public class SimpleDateFormat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Date dNow = new Date( );
	     SimpleDateFormat ft = new SimpleDateFormat ();

	     //System.out.println("Current Date: " + ft.format(dNow));
	     
	     String str = String.format("Current Date/Time : %tc", dNow );
	     System.out.println(str);
	     
	     /*
	      * https://www.tutorialspoint.com/java/java_date_time.htm
	      */
	     System.out.printf("%s %tB %<te, %<tY", "Due date:", dNow);


	}

}
