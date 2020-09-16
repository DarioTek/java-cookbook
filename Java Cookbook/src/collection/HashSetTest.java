package collection;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest {

	public static void main(String[] args) {
		HashSet hashSet = new HashSet();
		ArrayList<String> list = new ArrayList();
		list.add("test1");
		list.add("test1");
		list.add("test2");
		list.add("test7");
		list.add("test2");
		list.add("test6");
		list.add("test2");
		list.add("test3");

		for (int i = 0; i < list.size(); i++){
			String string = (String)list.get(i);
			System.out.println(i + " : " + string);
			if (hashSet.contains(string)){
				System.out.println(string + " already in HashSet");
			}else{
				hashSet.add(string);
				System.out.println(string + " added to HashSet");
			}
		}
		
		System.out.println("HashSet size = " + hashSet.size());
		
		Iterator iterator = hashSet.iterator();
		int counter = 0;				
		while(iterator.hasNext()){
			String string = (String)iterator.next();			
			System.out.println(counter + " : " + string);
			counter++;
		}
	}

}
