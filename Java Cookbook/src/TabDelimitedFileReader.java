import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TabDelimitedFileReader {

	public TabDelimitedFileReader(){
		super();
	}
	
	public ArrayList<String> readLine(String fileName) throws IOException{
		ArrayList<String> list = new ArrayList();
		String lineJustFetched = null;
        BufferedReader buf = new BufferedReader(new FileReader(fileName));              

        int count = 0;
        while(true){
            lineJustFetched = buf.readLine();                               
            
            if(lineJustFetched == null){  
                break; 
            }else{
            	count++;
            	list.add(lineJustFetched);
            	System.out.println("line# " + count + " = " + lineJustFetched);            	
            }
        }
        
        buf.close();
        
		return list;
	}
	
	/*
	 * 1. read file line by line
	 * 2. split the line between the header and footer into multiple columns
	 * 3. construct the object using the splitted words
	 */
	public static void main(String args[]){
		
		String fileName = "TSTFIELDGLASS_US_FIELDGLASS-SG_20150219_02_INV_FLAT.TXT";
		TabDelimitedFileReader reader = new TabDelimitedFileReader();
		try{
			ArrayList list = reader.readLine(fileName);			
			for (int i = 0; i < list.size(); i++){
				String line = (String)list.get(i);
				String[] items = line.split("\t");
				for (int j = 0; j < items.length; j++){
					System.out.println(items[j]);
				}
				System.out.println("********************");
			}
			
		}catch(IOException e){
			e.printStackTrace();
		}
		
		
		/*
		String fileName = "TSTFIELDGLASS_US_FIELDGLASS-SG_20150219_02_INV_FLAT.TXT";
        try{
            //BufferedReader buf = new BufferedReader(new FileReader("TSTFIELDGLASS_US_FIELDGLASS-SG_20150219_02_INV_FLAT.TXT"));
        	BufferedReader buf = new BufferedReader(new FileReader(fileName));
            ArrayList<String> words = new ArrayList<>();
            String lineJustFetched = null;
            String[] wordsArray;

            int count = 0;
            while(true){
                lineJustFetched = buf.readLine();                               
                
                if(lineJustFetched == null){  
                    break; 
                }else{
                	count++;
                	System.out.println("line# " + count + " = " + lineJustFetched);
                    wordsArray = lineJustFetched.split("\t");
                                        
                    
                    for(String each : wordsArray){
                        if(!"".equals(each)){
                            words.add(each);
                        }
                    }
                }
            }

            for(String each : words){
                System.out.println(each);
            }

            buf.close();

        }catch(Exception e){
            e.printStackTrace();
        }
        */
   	}
	
}
