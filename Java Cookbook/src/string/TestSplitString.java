package string;

public class TestSplitString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String test = "dmontecastro@yahoo.com, dbmontecastro@gmail.com";
		String test = "dmontecastro@yahoo.com,dbmontecastro@gmail.com, dario.montecastro@citi.com";
		//String test = "dmontecastro@yahoo.com";
		
		String[] emails = test.split(",");
		
		for (int i = 0; i < emails.length; i++){
			System.out.println("email  #" + i + " : " + emails[i].trim());
		}
		
		String invoiceIdAndType = "NEMSIN04038963-S";
		String[] invoice = invoiceIdAndType.split("-");
		
		for (int i = 0; i < invoice.length; i++){
			System.out.println("invoice  #" + i + " : " + invoice[i].trim());
		}		
	}

}
