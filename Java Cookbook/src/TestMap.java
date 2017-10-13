import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TestMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map map = new HashMap();
		String key1 = "Montecastro Family";
		
		List list = new ArrayList();
		Person p1 = new Person();
		p1.setFirstName("Dario");
		p1.setLastName("Montecastro");
		p1.setGeid(p1.getLastName() + "," + p1.getFirstName());
		list.add(p1);
		
		Person p2 = new Person();
		p2.setFirstName("Genalyn");
		p2.setLastName("Montecastro");
		p2.setGeid(p2.getLastName() + "," + p2.getFirstName());
		list.add(p2);

		Person p3 = new Person();
		p3.setFirstName("Darius");
		p3.setLastName("Montecastro");
		p3.setGeid(p3.getLastName() + "," + p3.getFirstName());
		list.add(p3);
		
		map.put(key1, list);

		
		String key2 = "Kurdy Family";
		
		list = new ArrayList();
		p1 = new Person();
		p1.setFirstName("Moe");
		p1.setLastName("Kurdy");
		p1.setGeid(p1.getLastName() + "," + p1.getFirstName());
		list.add(p1);
		
		p2 = new Person();
		p2.setFirstName("Edith");
		p2.setLastName("Kurdy");
		p2.setGeid(p2.getLastName() + "," + p2.getFirstName());
		list.add(p2);

		p3 = new Person();
		p3.setFirstName("Jessica");
		p3.setLastName("Kurdy");
		p3.setGeid(p3.getLastName() + "," + p3.getFirstName());
		list.add(p3);
		
		map.put(key2, list);
		
		
		String key3 = "Baretto Family";
		
		list = new ArrayList();
		p1 = new Person();
		p1.setFirstName("George");
		p1.setLastName("Baretto");
		p1.setGeid(p1.getLastName() + "," + p1.getFirstName());
		list.add(p1);
		
		p2 = new Person();
		p2.setFirstName("Anne");
		p2.setLastName("Baretto");
		p2.setGeid(p2.getLastName() + "," + p2.getFirstName());
		list.add(p2);

		p3 = new Person();
		p3.setFirstName("Daniel");
		p3.setLastName("Baretto");
		p3.setGeid(p3.getLastName() + "," + p3.getFirstName());
		list.add(p3);
		
		map.put(key3, list);
		
		
		/*
		 * Loop through the map
		 */
		Iterator iterator = map.entrySet().iterator();
		while (iterator.hasNext()){
			Map.Entry keyValuePair = (Map.Entry) iterator.next();
			String key = (String) keyValuePair.getKey();
			System.out.println("key = " + key);
			List listOfObjects = (List) keyValuePair.getValue();
			for (int i=0; i < listOfObjects.size(); i++){
				Person p = (Person)listOfObjects.get(i);
				System.out.println("Family member # " + i + " is " + p.getGeid());
			}
			System.out.println("**************************");
		}
		
		/*
		 * Add Jordan
		 */
		Person p4 = new Person();
		p4.setFirstName("Jordan");
		p4.setLastName("Kurdy");
		p4.setGeid(p4.getLastName() + "," + p4.getFirstName());

		iterator = map.entrySet().iterator();
		while (iterator.hasNext()){
			Map.Entry keyValuePair = (Map.Entry) iterator.next();
			String key = (String) keyValuePair.getKey();
			if (key.startsWith(p4.getLastName())){
				List listOfObjects = (List) keyValuePair.getValue();
				listOfObjects.add(p4);
				System.out.println(p4.getGeid() + " added to the " + key);
			}
		}

		/*
		 * Loop through the map
		 */
		iterator = map.entrySet().iterator();
		while (iterator.hasNext()){
			Map.Entry keyValuePair = (Map.Entry) iterator.next();
			String key = (String) keyValuePair.getKey();
			System.out.println("key = " + key);
			List listOfObjects = (List) keyValuePair.getValue();
			for (int i=0; i < listOfObjects.size(); i++){
				Person p = (Person)listOfObjects.get(i);
				System.out.println("Family member # " + i + " is " + p.getGeid());
			}
			System.out.println("**************************");
		}

		
	}

}
