package string;

public class TestSubtringAfterAWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String str = "PAY_GROUP_IRL_DEP";
		String str = "PAY_GROUP_IRL";
		
		System.out.println("length = " + str.length());
		
		System.out.println("lastIndexOf = " + str.lastIndexOf("PAY_GROUP_"));
		System.out.println("indexOf = " + str.indexOf("PAY_GROUP_"));
		
		System.out.println("lastIndexOf = " + str.lastIndexOf("_"));
		System.out.println("indexOf = " + str.indexOf("_"));
		
		System.out.println("last word = " + str.substring(str.lastIndexOf("_"), str.length()));
		System.out.println("last word = " + str.substring(str.lastIndexOf("_") + 1, str.length()));
	}

}
