package org.huijingyuan.ults;

public class StringUtil {
	
	
	//ÅÐ¶Ï×Ö·û´®ÊÇ²»ÊÇ¿Õ×Ö·û´®
	public static boolean isEmpty(String str) {
		
		if(str==null||"".equals(str.trim())) {
			
			return true;
		}else {
			
			return false;
		}
		
	}
	
	
	public static boolean  isNotEmpty(String str) {
		if(str !=null && !"".equals(str.trim())) {
			return true;
								
		}else {
			return false;
		}
		
	}
	
	
}
