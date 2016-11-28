package tools;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/***********************************************
 ** 创建人: 黎荣恒 
 ** 日 期 : 2015-9-30 下午7:20:48
 ** 描述 : 获取中文拼音、中文首字母缩写和中文首字母
 ** 
 ** 版 本 : 1.0 修改人: 日 期 : 修改记录：
 ************************************************/
public class GetPinyin
{
	public static void main(String[] args)
	{
		String cnStr = "广东省行";
		System.out.println("广东省-->" + getPingYin(cnStr));
		String s = getPinYinHeadChar("广东省行");
		System.out.println("广东省-->" + s);
		StringBuffer sb = new StringBuffer(s);
		if (sb.length() > 1)
		{
			String ss = sb.delete(1, sb.length()).toString();
			System.out.println("广东省-->"
					+ Character.toUpperCase(ss.toCharArray()[0]) + "");
		}
	}

	/**
	 * 得到中文全拼
	 * @param src 需要转化的中文字符串
	 * @return
	 */
	public static String getPingYin(String src)
	{
		char[] t1 = null;
		t1 = src.toCharArray();
		String[] t2 = new String[t1.length];
		HanyuPinyinOutputFormat t3 = new HanyuPinyinOutputFormat();
		t3.setCaseType(HanyuPinyinCaseType.LOWERCASE);
		t3.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		t3.setVCharType(HanyuPinyinVCharType.WITH_V);
		String t4 = "";
		int t0 = t1.length;
		try
		{
			for (int i = 0; i < t0; i++)
			{
				// 判断是否为汉字字符
				if (java.lang.Character.toString(t1[i]).matches("[\\u4E00-\\u9FA5]+"))
				{
					t2 = PinyinHelper.toHanyuPinyinStringArray(t1[i], t3);
					t4 += t2[0];
				} else
				{
					t4 += java.lang.Character.toString(t1[i]);
				}
			}
			return t4;
		} catch (BadHanyuPinyinOutputFormatCombination e1)
		{
			e1.printStackTrace();
		}
		return t4;
	}

	/**
	 * 得到中文首字母
	 * @param str
	 * @return
	 */
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

	/**
	 * 将字符串转移为ASCII码
	 * @param cnStr
	 * @return
	 */
	public static String getCnASCII(String cnStr)
	{
		StringBuffer strBuf = new StringBuffer();
		byte[] bGBK = cnStr.getBytes();
		for (int i = 0; i < bGBK.length; i++)
		{
			strBuf.append(Integer.toHexString(bGBK[i] & 0xff));
		}
		return strBuf.toString();
	}
}
