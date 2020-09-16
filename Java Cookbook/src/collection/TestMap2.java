package collection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TestMap2 {

	public static void main(String[] args) {
		
		List list = new ArrayList();
		for (int i=0; i < 20; i++){
			list.add(new Integer(i));
		}
		
		Map map = new HashMap();
		
		for (int i = 0; i < list.size(); i++){
			if (i % 2 == 0){
				
			}
		}
		
		Iterator iterator = map.entrySet().iterator();
		while (iterator.hasNext()){
			Map.Entry keyValuePair = (Map.Entry) iterator.next();
			String key = (String) keyValuePair.getKey();			
			
		}


	}

}
