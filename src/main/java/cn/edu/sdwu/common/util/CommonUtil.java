package cn.edu.sdwu.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonUtil {
	
	/**
	 * 判断字符串是否由数字组成
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str){ 
	   Pattern pattern = Pattern.compile("[0-9]*"); 
	   Matcher isNum = pattern.matcher(str);
	   if( !isNum.matches() ){
	       return false; 
	   } 
	   return true; 
	}
	
	/**
	 * 判断字符串是否由16进制数0-9，a-f组成
	 * @param str
	 * @return
	 */
	public static boolean isHex(String str){ 
	   Pattern pattern = Pattern.compile("[0-9a-f]*"); 
	   Matcher isHex = pattern.matcher(str);
	   if( !isHex.matches() ){
	       return false; 
	   } 
	   return true; 
	}

}
