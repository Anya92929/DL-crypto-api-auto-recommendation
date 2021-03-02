package com.jackhenry.android.widget.calendar;

import java.util.Calendar;
import java.util.Comparator;

public class DateComparator implements Comparator<Calendar> {
    public int compare(Calendar calendar, Calendar calendar2) {
        if (calendar.after(calendar2)) {
            return 1;
        }
        return calendar.before(calendar2) ? -1 : 0;
    }
}
