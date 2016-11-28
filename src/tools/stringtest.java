package tools;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class stringtest {

	public static void main(String[] args) {
		
		String a = "1:0.1,2:0.2,3:0.3,4,5,6";
		//String bString = "safe_level_low";
		String b[] = a.split(",");
		String dString = "";
		Map<String, String> map = new HashMap<String, String>();
		
		for (String c: b) {
			if (c.indexOf(":") == -1) {
				System.out.println(c);
				dString = dString+","+c;
				continue;
			}
			System.out.println(c.substring(0, c.indexOf(":")));
			dString =dString +","+c.substring(0, c.indexOf(":"));
			map.put(c.substring(0, c.indexOf(":")), c);
			System.out.println(map.get(c.substring(0, c.indexOf(":"))));
			
		}
		System.out.println(map.get("1"));
		System.out.println(dString+"++++++"+dString.length());
		System.out.println(dString.substring(1));
		System.out.println(dString.substring(0, dString.lastIndexOf(",")));
		//System.out.println(aString);
		//System.out.println(aString.getBytes().length);
		//System.out.println(aString.substring(0,12).equals("return_lavel"));
		//System.out.println(bString.substring(0,10));
		//string测试
		//String str = "ios|2.2.0|49E66EB0-BB34-4B13-BA76-545FE6ED08D8|iPhone 6 Plus|Official|9.2";
//		String str = "Android|2.1.0|%E7%AD%96%E7%95%A5%E7%82%92%E8%82%A1%E9%80%9A2.1.0+%7C+a000004ff4fb44+%7C+PE-CL00+%7C+Official";
//		if (str.indexOf("Android") != -1) {
//			System.out.println("String >>>>>>>>>>>>>>"+str.substring(str.indexOf("|")+1, str.indexOf("|")+6));
//		}
//		if (str.charAt(0) == 'A') {
//			System.out.println("String >>>>>>>>>>>>>>"+str.substring(str.lastIndexOf("+")+1)); 
//		}
//		String st = "Android+%7C+%E7%AD%96%E7%95%A5%E7%82%92%E8%82%A1%E9%80%9A2.1.0+%7C+a000004ff4fb44+%7C+PE-CL00+%7C+Official";
//		if(st.length()!=-1){
//			System.out.println("String Test>>>>>>>>>>>>>>"+(st.length()+1));
//		}
//		if (st.charAt(0) == 'A') {
//			int sp =  st.indexOf("+",st.length()-10); 
//			System.out.println("String >>>>>>>>>>>>>>"+sp );
//			System.out.println("String >>>>>>>>>>>>>>"+st.substring(st.lastIndexOf("+")+1)); 
//			System.out.println("String >>>>>>>>>>>>>>"+st.substring(st.length()-8));
//		}
		
	}	
}

//Android+%7C+%E7%AD%96%E7%95%A5%E7%82%92%E8%82%A1%E9%80%9A2.1.0+%7C+a000004ff4fb44+%7C+PE-CL00+%7C+Official
