package cn.wangyanfsd.api.util;

import java.util.Random;

public class StrUtil {

	// ���ַ����Ƿ�Ϊ����
	public static boolean isNumeric(String str) {
		for (int i = 0; i < str.length(); i++) {
			System.out.println(str.charAt(i));
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}
	
	/*��ȡһ������ַ���*/
    public static String getRandomString(int length) { //length��ʾ�����ַ����ĳ���  
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";     
        Random random = new Random();     
        StringBuffer sb = new StringBuffer();     
        for (int i = 0; i < length; i++) {     
            int number = random.nextInt(base.length());     
            sb.append(base.charAt(number));     
        }     
        return sb.toString();     
     }    
}
