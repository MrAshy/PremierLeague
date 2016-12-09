package com.pms.kirillbaranov.premierleague.utils;

import com.annimon.stream.Stream;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by KirillBaranov on 04.12.16.
 */

public class DateHelper {
    public static final DateFormatter DATE_FORMATTER = new DateFormatter("d MMM yyyy", Locale.US);
    public static final DateFormatter DATE_FORMATTER2 = new DateFormatter("d MMM '‘'yy", Locale.US);
    public static final DateFormatter TIME_24H_FORMATTER = new DateFormatter("HH:mm", Locale.US);
    public static final DateFormatter TIME_12H_FORMATTER = new DateFormatter("h:mm", Locale.US);
    public static final DateFormatter TIME_12H_AMPM_FORMATTER = new DateFormatter("h:mm a", Locale.US);
    public static final DateFormatter AM_PM = new DateFormatter("aa", Locale.US);
    public static final DateFormatter HOURS_H = new DateFormatter("h", Locale.US);
    public static final DateFormatter MINUTES_MM = new DateFormatter("mm", Locale.US);
    public static final DateFormatter DAY_MONTH = new DateFormatter("d MMM", Locale.US);
    public static final DateFormatter YEAR = new DateFormatter("yyyy", Locale.US);

    public static final DateFormatter ISO_UTC_DATE_TIME_FORMATTER = new DateFormatter("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US, TimeZone.getTimeZone("UTC"));
    public static final DateFormatter ISO_UTC_DATE_TIME_FORMATTER2 = new DateFormatter("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US, TimeZone.getTimeZone("UTC"));
    public static final DateFormatter ISO_DATE_TIME_FORMATTER2 = new DateFormatter("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
    public static final DateFormatter ISO_DATE_TIME_FORMATTER = new DateFormatter("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
    public static final DateFormatter YYYY_MM_DD = new DateFormatter("yyyy-MM-dd");
    public static final DateFormatter FILE_DATE_TIME_FORMATTER = new DateFormatter("yyyy-MM-dd_HH-mm-ss");
    public static final DateFormatter DATE_TIME_FORMATTER2 = new DateFormatter("d MMM '‘'yy, h:mm a", Locale.US);
    public static final DateFormatter DATE_TIME_FORMATTER3 = new DateFormatter("d MMM, h:mm a", Locale.US);
    public static final DateFormatter DATE_TIME_FORMATTER4 = new DateFormatter("d MMM, HH:mm", Locale.US);
    public static final DateFormatter TIME_DATE_FORMATTER = new DateFormatter("h:mm a, d MMM yyyy", Locale.US);
    // formatted in UTC_FILE_DATE_TIME_FORMATTER
    public static final String RELEASE_DATE_TIME = "2013-05-01_00-00-00";

    /**
     * This function is a wraper of {@link DateHelper}.{@link #isToday(Calendar compareDate)}
     * @param date {@link Date}
     * @return true if given Year & Moth & Date equal with current, false otherwise.
     */
    public static boolean isToday(Date date) {
        Calendar compareDate = Calendar.getInstance();
        compareDate.clear();
        compareDate.setTime(date);
        return isToday(compareDate);
    }
    /**
     * @param compareDate {@link Calendar}
     * @return true if given Year & Moth & Date equal with current, false otherwise.
     */
    public static boolean isToday(Calendar compareDate) {
        Calendar curDate = Calendar.getInstance();
        boolean isToday = compareDate.get(Calendar.YEAR) == curDate.get(Calendar.YEAR) &&
                compareDate.get(Calendar.MONTH) == curDate.get(Calendar.MONTH) &&
                compareDate.get(Calendar.DATE) == curDate.get(Calendar.DATE);
        return isToday;
    }

    /**
     * Compare given Calendar YEAR & MONTH & DATE with current.
     * @param compareDate {@link Calendar}
     * @return true if Calendar.YEAR || Calendar.MONTH || Calendar.DATE of compareDate < than current;
     */
    public static boolean isPast(Calendar compareDate) {
        Calendar curDate = Calendar.getInstance();
        boolean isPast = compareDate.get(Calendar.YEAR) < curDate.get(Calendar.YEAR) ||
                compareDate.get(Calendar.MONTH) < curDate.get(Calendar.MONTH) ||
                compareDate.get(Calendar.DATE) < curDate.get(Calendar.DATE);
        return isPast;
    }

    public static long getUtcTimeInMillis() {
        return new GregorianCalendar(TimeZone.getTimeZone("GMT+0")).getTimeInMillis();
    }

    /**
     *
     * @param isoString {@link String}  in format YYYY-MM-DDThh:mm:ssZ
     * @return {@link Date} date parsed from iso string.
     */
    public static Date parseUtcIso(String isoString) {
        return parse(isoString, YYYY_MM_DD);
    }
    public static Date parse(String string, DateFormatter dateFormatter) {
        if(string == null) return null;

        try {
            return dateFormatter.parse(string);
        } catch (ParseException e) {
//            LogX.w(e);
            return null;
        }
    }
    public static Date getUtcDate() {
        return new GregorianCalendar(TimeZone.getTimeZone("GMT+0")).getTime();
    }

    public static Date getDateFromUtcString(String utcDateStr) {
        return parse(utcDateStr, ISO_UTC_DATE_TIME_FORMATTER);
    }
    public static String getUtcTimeAsIsoString() {
        return ISO_UTC_DATE_TIME_FORMATTER.format(new Date());
    }

    public static String getUtcTimeAsIsoString(long currentTimeMillis) {
        return ISO_UTC_DATE_TIME_FORMATTER.format(new Date(currentTimeMillis));
    }

    public static String getHumanReadableTime() {
        return FILE_DATE_TIME_FORMATTER.format(new Date());
    }

    public static String getDateFromIsoString(String isoString) {
        if(isoString == null) return null;
        Date date = null;
        try {
            date = ISO_UTC_DATE_TIME_FORMATTER.parse(isoString);
            return DATE_FORMATTER.format(date);
        } catch (Exception e) {
//            LogX.w(e);
            return null;
        }
    }

    public static String getSimpleDateFromIsoString(String isoString) {
        if(isoString == null) return null;
        Date date = null;
        try {
            date = ISO_UTC_DATE_TIME_FORMATTER.parse(isoString);
            return DATE_FORMATTER2.format(date);
        } catch (Exception e) {
//            LogX.w(e);
            return null;
        }
    }

    public static String getSimpleDateTimeFromIsoString(String isoString) {
        if(isoString == null) return null;
        Date date = null;
        try {
            date = ISO_UTC_DATE_TIME_FORMATTER.parse(isoString);
            return DATE_TIME_FORMATTER2.format(date);
        } catch (Exception e) {
//            LogX.w(e);
            return null;
        }
    }
    public static String formatUtcIsoString(String utcIsoString, DateFormatter simpleDateFormat) {
        if(utcIsoString == null || simpleDateFormat == null) return null;
        Date date = null;
        try {
            date = ISO_UTC_DATE_TIME_FORMATTER.parse(utcIsoString);
            return simpleDateFormat.format(date);
        } catch (Exception e) {
//            LogX.w(e);
            return null;
        }
    }

    public static String getTimeFromIsoString(String isoString) {
        if(isoString == null) return null;
        Date date = null;
        try {
            date = ISO_UTC_DATE_TIME_FORMATTER.parse(isoString);
            return TIME_12H_AMPM_FORMATTER.format(date);
        } catch (Exception e) {
//            LogX.w(e);
            return null;
        }
    }

    public static String getBeautyPeriod(long summaryTime) {
        long secs = summaryTime / 1000;
        long hours = secs / 3600;

        secs = secs % 3600;
        long mins = secs / 60;

        secs = secs % 60;

        return String.format("%02d:%02d:%02d", hours, mins, secs);
    }

    public static CharSequence subtract(Date date1, Date date2) {
        long time = date1.getTime() - date2.getTime();

        float hours = ((float)time) / (1000 * 3600);

        return String.format("%.1fh", Math.abs(hours));
    }

    //TODO: s-a potential bug here. Symantic bug. Hard to catch !
    public static long formatIsoUtcStringToMilliseconds(String isoString) {
        if(isoString == null) return 0;
        Date date = null;
        try {
            date = ISO_UTC_DATE_TIME_FORMATTER.parse(isoString);
            return date.getTime();
        } catch (Exception e) {
//            LogX.w(e);
            return 0;
        }
    }

    /**
     *
     * @param date {@link Date}
     * @return Rounded date with HOUR_OF_DAY, MINUTE, SECOND, MILLISECOND equals to 0.
     */
    public static Date getRoundedDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public static boolean isCurrentYear(Date date){
        Calendar calendar = Calendar.getInstance();
        int curYear = calendar.get(Calendar.YEAR);
        calendar.clear();
        calendar.setTime(date);
        int comparedYear = calendar.get(Calendar.YEAR);
        return comparedYear == curYear;
    }

    public static Date getLastDate(Collection<Date> dates) {
        return Stream.of(dates).max(Date::compareTo).orElse(null);
    }
}
