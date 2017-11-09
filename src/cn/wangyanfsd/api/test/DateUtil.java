package cn.wangyanfsd.api.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
/**
 * ���ڱȽ�
 * @param DATE1 > DATE2 1
 * @param DATE2 < DATE1 -1
 * @return
 */
public static int compare_date(String DATE1, String DATE2) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        try {
            Date dt1 = df.parse(DATE1);
            Date dt2 = df.parse(DATE2);
            if (dt1.getTime() > dt2.getTime()) {
                System.out.println("dt1 ��dt2ǰ");
                return 1;
            } else if (dt1.getTime() < dt2.getTime()) {
                System.out.println("dt1��dt2��");
                return -1;
            } else {
                return 0;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }
}
