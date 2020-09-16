package file;
import java.io.File;
import java.nio.file.*;

public class TestPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Path path = FileSystems.getDefault().getPath("C:\\test\\", "NexisErrorNotifcationAttachment.csv");
		System.out.println("path = " + path.toString());
		System.out.println("path exist? = " + Files.exists(path));
		
		if (!Files.exists(path)){
			new File("C:\\test").mkdir();
			System.out.println("directory created");
		}
		
		
	}

}
