package com.nutrix.common.utils;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

public final class DateUtils {

    public static final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    public static String toReadableDate(Date date) {
        return formatter.format(date);
    }

    public static Date addDays(Date date, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days);
        return cal.getTime();
    }

    public static boolean expired(Date date) {
        return new Date().after(date);
    }

    public static Instant parse(String date) {
        return Instant.parse(date);
    }

}
