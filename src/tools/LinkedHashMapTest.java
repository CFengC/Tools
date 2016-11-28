package tools;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//LinkedHashmap 的特点是put进去的对象位置未发生变化,而HashMap会发生变化.
		 System.out.println("*************************LinkedHashMap*************");
		 LinkedHashMap<String,Object> map = new LinkedHashMap<String,Object>();
		   map.put("3", "10");
		   map.put("6", "12");
		   map.put("2","4");
		   System.out.println(map);
		   
	}

}
