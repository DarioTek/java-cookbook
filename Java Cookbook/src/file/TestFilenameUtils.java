package file;
import org.apache.commons.io.FilenameUtils;

public class TestFilenameUtils {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filename = "C:\\temp\\dev\\logs\\nexis.log";
		
		String ext1 = FilenameUtils.getExtension(filename);
		System.out.println("ext1 = " + ext1); 
		
		String path = FilenameUtils.getPath(filename);
		System.out.println("path = " + path);
	}

}
