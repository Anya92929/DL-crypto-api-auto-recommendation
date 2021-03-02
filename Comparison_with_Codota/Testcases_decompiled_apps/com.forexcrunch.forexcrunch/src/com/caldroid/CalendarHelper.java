package com.caldroid;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import org.joda.time.DateTime;
import org.joda.time.ReadableInstant;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class CalendarHelper {
    public static ArrayList<DateTime> getFullWeeks(int month, int year, int startDayOfWeek) {
        DateTime nextDay;
        ArrayList<DateTime> datetimeList = new ArrayList<>();
        DateTime firstDateOfMonth = new DateTime(year, month, 1, 0, 0);
        DateTime lastDateOfMonth = firstDateOfMonth.plusMonths(1).minusDays(1);
        int weekdayOfFirstDate = firstDateOfMonth.getDayOfWeek();
        if (weekdayOfFirstDate < startDayOfWeek) {
            weekdayOfFirstDate += 7;
        }
        while (weekdayOfFirstDate > 0) {
            DateTime dateTime = firstDateOfMonth.minusDays(weekdayOfFirstDate - startDayOfWeek);
            if (!dateTime.isBefore((ReadableInstant) firstDateOfMonth)) {
                break;
            }
            datetimeList.add(dateTime);
            weekdayOfFirstDate--;
        }
        for (int i = 0; i < lastDateOfMonth.getDayOfMonth(); i++) {
            datetimeList.add(firstDateOfMonth.plusDays(i));
        }
        int endDayOfWeek = startDayOfWeek - 1;
        if (endDayOfWeek == 0) {
            endDayOfWeek = 7;
        }
        if (lastDateOfMonth.getDayOfWeek() != endDayOfWeek) {
            int i2 = 1;
            do {
                nextDay = lastDateOfMonth.plusDays(i2);
                datetimeList.add(nextDay);
                i2++;
            } while (nextDay.getDayOfWeek() != endDayOfWeek);
        }
        return datetimeList;
    }

    public static DateTime convertDateToDateTime(Date date) {
        DateTime dateTime = new DateTime((Object) date);
        return new DateTime(dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(), 0, 0);
    }

    public static Date getDateFromString(String dateString, String dateFormat) throws ParseException {
        SimpleDateFormat formatter;
        if (dateFormat == null) {
            formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        } else {
            formatter = new SimpleDateFormat(dateFormat, Locale.ENGLISH);
        }
        return formatter.parse(dateString);
    }

    public static DateTime getDateTimeFromString(String dateString, String dateFormat) {
        DateTimeFormatter formatter;
        if (dateFormat == null) {
            formatter = DateTimeFormat.forPattern("yyyy-MM-dd");
        } else {
            formatter = DateTimeFormat.forPattern(dateFormat);
        }
        return formatter.parseDateTime(dateString);
    }

    public static ArrayList<String> convertToStringList(ArrayList<DateTime> dateTimes) {
        ArrayList<String> list = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd");
        Iterator<DateTime> it = dateTimes.iterator();
        while (it.hasNext()) {
            list.add(formatter.print((ReadableInstant) it.next()));
        }
        return list;
    }
}
