package string;

/*
 * Updated location in git repository
 */
public class TestSubstring {
	
	public static void main(String args[]){
		String name = "Dario Montecastro";
		System.out.println(name.substring(0, 10));
		
		String name2 = "DarioTek Montecastro";
		//System.out.println(name2.substring(0, 10)); // Throws a java.lang.StringIndexOutOfBoundsException
		System.out.println(name2.length() > 10 ? name2.substring(0, 10) : name2);
		
		String[] costCenter = "Dario.Montecastro".split("\\.");
		String str = (costCenter[0].length() > 5 ? costCenter[0].substring(0, 5) : costCenter[0]) + // Cost Center number before the "." 
				"." +  
				lpad("104051", 11, '0') +
				"." +
				(costCenter[1].length() > 10 ? costCenter[1].substring(0, 10) : costCenter[1]) + // Cost Center number after the "."
				"." +
				"0000000000" + // 10 zeros
				"." +
				"00000" + // 5 zeros
				"." +
				"00000"// 5 zeros
				;
		
		System.out.println("str = " + str);
	}

	public static String lpad(String string, int n, char c){
		return String.format("%1$" + n + "s" , string).replace(' ', c);
	}
	
	
}
