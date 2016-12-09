package com.pms.kirillbaranov.premierleague.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by KirillBaranov on 04.12.16.
 */

public class DateFormatter {
    private String mPattern;
    private Locale mLocale;
    private TimeZone mTimeZone;

    private ThreadLocal<SimpleDateFormat> mThreadLocalDateFormat = new ThreadLocal<SimpleDateFormat>() {
        protected SimpleDateFormat initialValue() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(mPattern, mLocale != null ? mLocale : Locale.getDefault());
            simpleDateFormat.setTimeZone(mTimeZone !=null ? mTimeZone : TimeZone.getDefault());
            return simpleDateFormat;
        }
    };

    public DateFormatter(String pattern) {
        this(pattern, null);
    }

    public DateFormatter(String pattern, Locale locale) {
        this(pattern, locale, null);
    }

    public DateFormatter(String pattern, Locale locale, TimeZone timeZone) {
        mPattern = pattern;
        mLocale = locale;
        mTimeZone = timeZone;
    }

    public String format(Date date) {
        if(date == null) return null;

        return mThreadLocalDateFormat.get().format(date);
    }

    public Date parse(String string) throws ParseException {
        return mThreadLocalDateFormat.get().parse(string);
    }

    public void setTimeZone(TimeZone timeZone){
        mThreadLocalDateFormat.get().setTimeZone(timeZone);
    }
}
