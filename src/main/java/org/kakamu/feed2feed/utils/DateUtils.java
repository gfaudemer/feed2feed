package org.kakamu.feed2feed.utils;

import lombok.experimental.UtilityClass;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@UtilityClass
public class DateUtils {

    public static final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");

    public static long treatmentTime(Date startDate){
        Date date = new Date();
        return date.getTime() - startDate.getTime();
    }
}
