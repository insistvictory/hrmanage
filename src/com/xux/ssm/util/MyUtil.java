package com.xux.ssm.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2018/10/23.
 */

/**
 * ·Ö¸î×Ö·û´®Ê±¼ä
 */
public class MyUtil {
     public static String[] transferTime(Date date){
         SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
         String s=simpleDateFormat.format(date);
         return s.split("-");
     }
}
