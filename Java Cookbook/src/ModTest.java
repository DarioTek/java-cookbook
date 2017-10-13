
public class ModTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int size = 178516;
		int j = 0;
		for (int i = 0; i < size; i++){
			int test = i % 100;
			System.out.println("test = " + test);
			if (test == 0){
				j++;
				System.out.println(i + " % 100 = " + test + " ******** ");
			}else if (i == size - 1){
				j++;				
			}
		}
		
		System.out.println("# of commits = " + j);
	}

}
