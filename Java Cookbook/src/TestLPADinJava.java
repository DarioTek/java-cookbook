
public class TestLPADinJava {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(TestLPADinJava.lpad("104051", 10));
	}
	
	public static String lpad(String string, int n){
		return String.format("%1$" + n + "s" , string).replace(' ', '0');
	}

}
