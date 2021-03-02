package org.joda.time.format;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class PeriodFormat {
    private static final String BUNDLE_NAME = "org.joda.time.format.messages";
    private static final ConcurrentMap<Locale, PeriodFormatter> FORMATTERS = new ConcurrentHashMap();

    protected PeriodFormat() {
    }

    public static PeriodFormatter getDefault() {
        return wordBased(Locale.ENGLISH);
    }

    public static PeriodFormatter wordBased() {
        return wordBased(Locale.getDefault());
    }

    public static PeriodFormatter wordBased(Locale locale) {
        PeriodFormatter periodFormatter = (PeriodFormatter) FORMATTERS.get(locale);
        if (periodFormatter != null) {
            return periodFormatter;
        }
        ResourceBundle bundle = ResourceBundle.getBundle(BUNDLE_NAME, locale);
        String[] strArr = {bundle.getString("PeriodFormat.space"), bundle.getString("PeriodFormat.comma"), bundle.getString("PeriodFormat.commandand"), bundle.getString("PeriodFormat.commaspaceand")};
        PeriodFormatter formatter = new PeriodFormatterBuilder().appendYears().appendSuffix(bundle.getString("PeriodFormat.year"), bundle.getString("PeriodFormat.years")).appendSeparator(bundle.getString("PeriodFormat.commaspace"), bundle.getString("PeriodFormat.spaceandspace"), strArr).appendMonths().appendSuffix(bundle.getString("PeriodFormat.month"), bundle.getString("PeriodFormat.months")).appendSeparator(bundle.getString("PeriodFormat.commaspace"), bundle.getString("PeriodFormat.spaceandspace"), strArr).appendWeeks().appendSuffix(bundle.getString("PeriodFormat.week"), bundle.getString("PeriodFormat.weeks")).appendSeparator(bundle.getString("PeriodFormat.commaspace"), bundle.getString("PeriodFormat.spaceandspace"), strArr).appendDays().appendSuffix(bundle.getString("PeriodFormat.day"), bundle.getString("PeriodFormat.days")).appendSeparator(bundle.getString("PeriodFormat.commaspace"), bundle.getString("PeriodFormat.spaceandspace"), strArr).appendHours().appendSuffix(bundle.getString("PeriodFormat.hour"), bundle.getString("PeriodFormat.hours")).appendSeparator(bundle.getString("PeriodFormat.commaspace"), bundle.getString("PeriodFormat.spaceandspace"), strArr).appendMinutes().appendSuffix(bundle.getString("PeriodFormat.minute"), bundle.getString("PeriodFormat.minutes")).appendSeparator(bundle.getString("PeriodFormat.commaspace"), bundle.getString("PeriodFormat.spaceandspace"), strArr).appendSeconds().appendSuffix(bundle.getString("PeriodFormat.second"), bundle.getString("PeriodFormat.seconds")).appendSeparator(bundle.getString("PeriodFormat.commaspace"), bundle.getString("PeriodFormat.spaceandspace"), strArr).appendMillis().appendSuffix(bundle.getString("PeriodFormat.millisecond"), bundle.getString("PeriodFormat.milliseconds")).toFormatter();
        FORMATTERS.putIfAbsent(locale, formatter);
        return formatter;
    }
}
