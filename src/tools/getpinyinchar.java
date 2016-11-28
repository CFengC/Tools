package tools;

import net.sourceforge.pinyin4j.PinyinHelper;

public class getpinyinchar {

	public static void main(String[] args) {
		System.out.println(getPinYinHeadChar(" 南方航空").toUpperCase());
	}
	
	public static String getPinYinHeadChar(String str)  
    {  
        String convert = "";  
        for (int j = 0; j < str.length(); j++)  
        {  
            char word = str.charAt(j);  
            String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word);  
            if (pinyinArray != null)  
            {  
                convert += pinyinArray[0].charAt(0);  
            } else  
            {  
                convert += word;  
            }  
        }  
        return convert;  
    }  
	
}
