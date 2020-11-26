package com.jiuye.sona.function;

import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: xinjian.hu
 * @Date: 2020/11/18 13:35
 * @Email: huxinjian@jiuyescm.com
 */
public class MyDemo {

    public static void main(String[] args) throws ParseException {
        String value = "2020/11/06 00:00:00";

        String format = "yyyy/MM/dd HH:mm:ss";
        String a = format.substring(0, value.length());
        System.out.println(a);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        Date date = simpleDateFormat.parse(value);
        System.out.println(date);


        Date date1;
        String value1 = "2020/11/06 00:00";
        String formatPatterns = "yyyy-MM-dd HH:mm:ss,yyyy/MM/dd HH:mm:ss,yyyy-MM-dd HH:mm,yyyy/MM/dd HH:mm,yyyy-MM-dd,yyyy/MM/dd";
        if(org.apache.commons.lang3.StringUtils.isNotEmpty(formatPatterns)) {
            String[] formatPatternArray  = org.apache.commons.lang3.StringUtils.split(formatPatterns, ",");
            date1 = DateUtils.parseDate(value, formatPatternArray);
        }else {
            date1= DateUtils.parseDate(value1,"yyyy-MM-dd");
        }
            System.out.println(date1);
    }
}
