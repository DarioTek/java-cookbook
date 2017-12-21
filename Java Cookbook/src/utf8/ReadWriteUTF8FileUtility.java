package utf8;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class ReadWriteUTF8FileUtility {

	private String UTF8_BOM_STRING = "\uFEFF";
	
	public void convertToUTF8(String inputFile, String outputFile){
		System.out.println("Start convertToUTF8");
		try {
		   
		   Reader reader = new InputStreamReader(new FileInputStream(inputFile),"UTF-8");
		   BufferedReader fin = new BufferedReader(reader);
		   			   			   
		   Writer writer = new OutputStreamWriter(new FileOutputStream(outputFile), "UTF-8");
		   BufferedWriter fout = new BufferedWriter(writer);
		   String s;
		   
		   fout.write(UTF8_BOM_STRING);
		   
		   while ((s=fin.readLine())!=null) {
		      fout.write(s);
		      fout.newLine();
		   }

		   //Remember to call close. 
		   //calling close on a BufferedReader/BufferedWriter 
		   // will automatically call close on its underlying stream
		   
		   fin.close();
		   fout.close();
		} catch (IOException e) {
		   e.printStackTrace();
		}
				
		System.out.println("Finish convertToUTF8");

	}
	
	public static void main(String[] args) {
		
		System.out.println("Start");
		ReadWriteUTF8FileUtility utility = new ReadWriteUTF8FileUtility();
		utility.convertToUTF8("C:\\Users\\DarioTek\\Downloads\\test", "C:\\Users\\DarioTek\\Downloads\\test2");
				
		System.out.println("Finish");
		
	}

}
