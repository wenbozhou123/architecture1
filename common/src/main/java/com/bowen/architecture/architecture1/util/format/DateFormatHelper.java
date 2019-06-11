package com.bowen.architecture.architecture1.util.format;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatHelper {
     private DateFormatHelper(){};
     private final static String FORMAT_STR= "yyyy-MM-dd HH:mm:ss";
     public static String long2str(long time){
        Date d = new Date();
        DateFormat df = new SimpleDateFormat(FORMAT_STR);
        return df.format(df);
     }

/*     public static long str2long(String str){
         DateFormat df = new SimpleDateFormat(FORMAT_STR);
         return df.parse(str).getTime();
     }*/
}
