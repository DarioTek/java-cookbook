package math;
import java.math.BigDecimal;

public class TestBigDecimalAddition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigDecimal b1 = new BigDecimal(0);
		
		for (int i=0; i < 10; i++){
			BigDecimal b2 = new BigDecimal(1);			
			System.out.println("b1 + b2 = " + b1.add(b2));
			
			b1 = b1.add(b2);
		}
		
		System.out.println("b1 = " + b1);
	}

}
