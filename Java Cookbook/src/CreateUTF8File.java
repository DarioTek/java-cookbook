import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class CreateUTF8File {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  try {
		        //FileInputStream fis = new FileInputStream("C:/temp/utf8.txt");
			  FileInputStream fis = new FileInputStream("C:\\temp\\utf8.txt");
		        BufferedReader r = new BufferedReader(new InputStreamReader(fis,
		                "UTF8"));
		        for (String s = ""; (s = r.readLine()) != null;) {
		            System.out.println(s);
		        }
		        r.close();
		        System.exit(0);
		    }

		    catch (Exception e) {
		        e.printStackTrace();
		        System.exit(1);
		    }

	}

}
