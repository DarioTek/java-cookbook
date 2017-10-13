import java.io.File;
import java.io.FilenameFilter;

public class FilenameFilterUtility {

	public static void main(String args[]){
		String directory = "C:\\temp\\p2p_exception\\";
		String extension = ".txt";
		
		FilenameFilterUtility utility = new FilenameFilterUtility();
		utility.findFiles(directory, extension);		
	}
	
	public void findFiles(String directory, String extension){
		File file = new File(directory);
		if (!file.exists()){
			System.out.println(directory + " does not exist!");
		}
		
		File[] listFiles = file.listFiles(new MyFilenameFilter(extension));
		if (listFiles.length == 0){
			System.out.println(directory + " does not have filenames with extension " + extension);
		}else{
			for (File f : listFiles){
				System.out.println("File: " + directory + File.separator + f.getName());
			}
		}
	}
	
	//FileNameFilter Implementation
	public class MyFilenameFilter implements FilenameFilter{
		private String extension;
		
		MyFilenameFilter(String extension){
			this.extension = extension.toLowerCase();
		}
		
		@Override
		public boolean accept(File file, String name){
			return name.toLowerCase().endsWith(extension);
		}
	}
	
}
