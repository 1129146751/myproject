package com.newtouch.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

/**
 * Created with IDEA
 *
 * @author:fengxu Date:2019/5/7
 * Time:14:46
 **/
public class Uuid {
    public static String getUUid() {
        SimpleDateFormat sp = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date();
        return sp.format(date);
    }
}
