package org.joda.time.chrono;

import java.util.HashMap;
import java.util.Locale;
import org.joda.time.Chronology;
import org.joda.time.DateTime;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeZone;
import org.joda.time.DurationField;
import org.joda.time.MutableDateTime;
import org.joda.time.ReadableDateTime;
import org.joda.time.chrono.AssembledChronology;
import org.joda.time.field.DecoratedDateTimeField;
import org.joda.time.field.DecoratedDurationField;
import org.joda.time.field.FieldUtils;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

public final class LimitChronology extends AssembledChronology {
    private static final long serialVersionUID = 7670866536893052522L;
    final DateTime iLowerLimit;
    final DateTime iUpperLimit;
    private transient LimitChronology iWithUTC;

    public static LimitChronology getInstance(Chronology chronology, ReadableDateTime readableDateTime, ReadableDateTime readableDateTime2) {
        DateTime dateTime = null;
        if (chronology == null) {
            throw new IllegalArgumentException("Must supply a chronology");
        }
        DateTime dateTime2 = readableDateTime == null ? null : readableDateTime.toDateTime();
        if (readableDateTime2 != null) {
            dateTime = readableDateTime2.toDateTime();
        }
        if (dateTime2 == null || dateTime == null || dateTime2.isBefore(dateTime)) {
            return new LimitChronology(chronology, dateTime2, dateTime);
        }
        throw new IllegalArgumentException("The lower limit must be come before than the upper limit");
    }

    private LimitChronology(Chronology chronology, DateTime dateTime, DateTime dateTime2) {
        super(chronology, (Object) null);
        this.iLowerLimit = dateTime;
        this.iUpperLimit = dateTime2;
    }

    public DateTime getLowerLimit() {
        return this.iLowerLimit;
    }

    public DateTime getUpperLimit() {
        return this.iUpperLimit;
    }

    public Chronology withUTC() {
        return withZone(DateTimeZone.UTC);
    }

    public Chronology withZone(DateTimeZone dateTimeZone) {
        if (dateTimeZone == null) {
            dateTimeZone = DateTimeZone.getDefault();
        }
        if (dateTimeZone == getZone()) {
            return this;
        }
        if (dateTimeZone == DateTimeZone.UTC && this.iWithUTC != null) {
            return this.iWithUTC;
        }
        DateTime dateTime = this.iLowerLimit;
        if (dateTime != null) {
            MutableDateTime mutableDateTime = dateTime.toMutableDateTime();
            mutableDateTime.setZoneRetainFields(dateTimeZone);
            dateTime = mutableDateTime.toDateTime();
        }
        DateTime dateTime2 = this.iUpperLimit;
        if (dateTime2 != null) {
            MutableDateTime mutableDateTime2 = dateTime2.toMutableDateTime();
            mutableDateTime2.setZoneRetainFields(dateTimeZone);
            dateTime2 = mutableDateTime2.toDateTime();
        }
        LimitChronology instance = getInstance(getBase().withZone(dateTimeZone), dateTime, dateTime2);
        if (dateTimeZone == DateTimeZone.UTC) {
            this.iWithUTC = instance;
        }
        return instance;
    }

    public long getDateTimeMillis(int i, int i2, int i3, int i4) throws IllegalArgumentException {
        long dateTimeMillis = getBase().getDateTimeMillis(i, i2, i3, i4);
        checkLimits(dateTimeMillis, "resulting");
        return dateTimeMillis;
    }

    public long getDateTimeMillis(int i, int i2, int i3, int i4, int i5, int i6, int i7) throws IllegalArgumentException {
        long dateTimeMillis = getBase().getDateTimeMillis(i, i2, i3, i4, i5, i6, i7);
        checkLimits(dateTimeMillis, "resulting");
        return dateTimeMillis;
    }

    public long getDateTimeMillis(long j, int i, int i2, int i3, int i4) throws IllegalArgumentException {
        checkLimits(j, (String) null);
        long dateTimeMillis = getBase().getDateTimeMillis(j, i, i2, i3, i4);
        checkLimits(dateTimeMillis, "resulting");
        return dateTimeMillis;
    }

    /* access modifiers changed from: protected */
    public void assemble(AssembledChronology.Fields fields) {
        HashMap hashMap = new HashMap();
        fields.eras = convertField(fields.eras, (HashMap<Object, Object>) hashMap);
        fields.centuries = convertField(fields.centuries, (HashMap<Object, Object>) hashMap);
        fields.years = convertField(fields.years, (HashMap<Object, Object>) hashMap);
        fields.months = convertField(fields.months, (HashMap<Object, Object>) hashMap);
        fields.weekyears = convertField(fields.weekyears, (HashMap<Object, Object>) hashMap);
        fields.weeks = convertField(fields.weeks, (HashMap<Object, Object>) hashMap);
        fields.days = convertField(fields.days, (HashMap<Object, Object>) hashMap);
        fields.halfdays = convertField(fields.halfdays, (HashMap<Object, Object>) hashMap);
        fields.hours = convertField(fields.hours, (HashMap<Object, Object>) hashMap);
        fields.minutes = convertField(fields.minutes, (HashMap<Object, Object>) hashMap);
        fields.seconds = convertField(fields.seconds, (HashMap<Object, Object>) hashMap);
        fields.millis = convertField(fields.millis, (HashMap<Object, Object>) hashMap);
        fields.year = convertField(fields.year, (HashMap<Object, Object>) hashMap);
        fields.yearOfEra = convertField(fields.yearOfEra, (HashMap<Object, Object>) hashMap);
        fields.yearOfCentury = convertField(fields.yearOfCentury, (HashMap<Object, Object>) hashMap);
        fields.centuryOfEra = convertField(fields.centuryOfEra, (HashMap<Object, Object>) hashMap);
        fields.era = convertField(fields.era, (HashMap<Object, Object>) hashMap);
        fields.dayOfWeek = convertField(fields.dayOfWeek, (HashMap<Object, Object>) hashMap);
        fields.dayOfMonth = convertField(fields.dayOfMonth, (HashMap<Object, Object>) hashMap);
        fields.dayOfYear = convertField(fields.dayOfYear, (HashMap<Object, Object>) hashMap);
        fields.monthOfYear = convertField(fields.monthOfYear, (HashMap<Object, Object>) hashMap);
        fields.weekOfWeekyear = convertField(fields.weekOfWeekyear, (HashMap<Object, Object>) hashMap);
        fields.weekyear = convertField(fields.weekyear, (HashMap<Object, Object>) hashMap);
        fields.weekyearOfCentury = convertField(fields.weekyearOfCentury, (HashMap<Object, Object>) hashMap);
        fields.millisOfSecond = convertField(fields.millisOfSecond, (HashMap<Object, Object>) hashMap);
        fields.millisOfDay = convertField(fields.millisOfDay, (HashMap<Object, Object>) hashMap);
        fields.secondOfMinute = convertField(fields.secondOfMinute, (HashMap<Object, Object>) hashMap);
        fields.secondOfDay = convertField(fields.secondOfDay, (HashMap<Object, Object>) hashMap);
        fields.minuteOfHour = convertField(fields.minuteOfHour, (HashMap<Object, Object>) hashMap);
        fields.minuteOfDay = convertField(fields.minuteOfDay, (HashMap<Object, Object>) hashMap);
        fields.hourOfDay = convertField(fields.hourOfDay, (HashMap<Object, Object>) hashMap);
        fields.hourOfHalfday = convertField(fields.hourOfHalfday, (HashMap<Object, Object>) hashMap);
        fields.clockhourOfDay = convertField(fields.clockhourOfDay, (HashMap<Object, Object>) hashMap);
        fields.clockhourOfHalfday = convertField(fields.clockhourOfHalfday, (HashMap<Object, Object>) hashMap);
        fields.halfdayOfDay = convertField(fields.halfdayOfDay, (HashMap<Object, Object>) hashMap);
    }

    private DurationField convertField(DurationField durationField, HashMap<Object, Object> hashMap) {
        if (durationField == null || !durationField.isSupported()) {
            return durationField;
        }
        if (hashMap.containsKey(durationField)) {
            return (DurationField) hashMap.get(durationField);
        }
        LimitDurationField limitDurationField = new LimitDurationField(durationField);
        hashMap.put(durationField, limitDurationField);
        return limitDurationField;
    }

    private DateTimeField convertField(DateTimeField dateTimeField, HashMap<Object, Object> hashMap) {
        if (dateTimeField == null || !dateTimeField.isSupported()) {
            return dateTimeField;
        }
        if (hashMap.containsKey(dateTimeField)) {
            return (DateTimeField) hashMap.get(dateTimeField);
        }
        LimitDateTimeField limitDateTimeField = new LimitDateTimeField(dateTimeField, convertField(dateTimeField.getDurationField(), hashMap), convertField(dateTimeField.getRangeDurationField(), hashMap), convertField(dateTimeField.getLeapDurationField(), hashMap));
        hashMap.put(dateTimeField, limitDateTimeField);
        return limitDateTimeField;
    }

    /* access modifiers changed from: package-private */
    public void checkLimits(long j, String str) {
        DateTime dateTime = this.iLowerLimit;
        if (dateTime == null || j >= dateTime.getMillis()) {
            DateTime dateTime2 = this.iUpperLimit;
            if (dateTime2 != null && j >= dateTime2.getMillis()) {
                throw new LimitException(str, false);
            }
            return;
        }
        throw new LimitException(str, true);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LimitChronology)) {
            return false;
        }
        LimitChronology limitChronology = (LimitChronology) obj;
        if (!getBase().equals(limitChronology.getBase()) || !FieldUtils.equals(getLowerLimit(), limitChronology.getLowerLimit()) || !FieldUtils.equals(getUpperLimit(), limitChronology.getUpperLimit())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i;
        int i2 = 0;
        if (getLowerLimit() != null) {
            i = getLowerLimit().hashCode();
        } else {
            i = 0;
        }
        int i3 = i + 317351877;
        if (getUpperLimit() != null) {
            i2 = getUpperLimit().hashCode();
        }
        return i3 + i2 + (getBase().hashCode() * 7);
    }

    public String toString() {
        return "LimitChronology[" + getBase().toString() + ", " + (getLowerLimit() == null ? "NoLimit" : getLowerLimit().toString()) + ", " + (getUpperLimit() == null ? "NoLimit" : getUpperLimit().toString()) + ']';
    }

    private class LimitException extends IllegalArgumentException {
        private static final long serialVersionUID = -5924689995607498581L;
        private final boolean iIsLow;

        LimitException(String str, boolean z) {
            super(str);
            this.iIsLow = z;
        }

        public String getMessage() {
            StringBuffer stringBuffer = new StringBuffer(85);
            stringBuffer.append("The");
            String message = super.getMessage();
            if (message != null) {
                stringBuffer.append(' ');
                stringBuffer.append(message);
            }
            stringBuffer.append(" instant is ");
            DateTimeFormatter withChronology = ISODateTimeFormat.dateTime().withChronology(LimitChronology.this.getBase());
            if (this.iIsLow) {
                stringBuffer.append("below the supported minimum of ");
                withChronology.printTo(stringBuffer, LimitChronology.this.getLowerLimit().getMillis());
            } else {
                stringBuffer.append("above the supported maximum of ");
                withChronology.printTo(stringBuffer, LimitChronology.this.getUpperLimit().getMillis());
            }
            stringBuffer.append(" (");
            stringBuffer.append(LimitChronology.this.getBase());
            stringBuffer.append(')');
            return stringBuffer.toString();
        }

        public String toString() {
            return "IllegalArgumentException: " + getMessage();
        }
    }

    private class LimitDurationField extends DecoratedDurationField {
        private static final long serialVersionUID = 8049297699408782284L;

        LimitDurationField(DurationField durationField) {
            super(durationField, durationField.getType());
        }

        public int getValue(long j, long j2) {
            LimitChronology.this.checkLimits(j2, (String) null);
            return getWrappedField().getValue(j, j2);
        }

        public long getValueAsLong(long j, long j2) {
            LimitChronology.this.checkLimits(j2, (String) null);
            return getWrappedField().getValueAsLong(j, j2);
        }

        public long getMillis(int i, long j) {
            LimitChronology.this.checkLimits(j, (String) null);
            return getWrappedField().getMillis(i, j);
        }

        public long getMillis(long j, long j2) {
            LimitChronology.this.checkLimits(j2, (String) null);
            return getWrappedField().getMillis(j, j2);
        }

        public long add(long j, int i) {
            LimitChronology.this.checkLimits(j, (String) null);
            long add = getWrappedField().add(j, i);
            LimitChronology.this.checkLimits(add, "resulting");
            return add;
        }

        public long add(long j, long j2) {
            LimitChronology.this.checkLimits(j, (String) null);
            long add = getWrappedField().add(j, j2);
            LimitChronology.this.checkLimits(add, "resulting");
            return add;
        }

        public int getDifference(long j, long j2) {
            LimitChronology.this.checkLimits(j, "minuend");
            LimitChronology.this.checkLimits(j2, "subtrahend");
            return getWrappedField().getDifference(j, j2);
        }

        public long getDifferenceAsLong(long j, long j2) {
            LimitChronology.this.checkLimits(j, "minuend");
            LimitChronology.this.checkLimits(j2, "subtrahend");
            return getWrappedField().getDifferenceAsLong(j, j2);
        }
    }

    private class LimitDateTimeField extends DecoratedDateTimeField {
        private static final long serialVersionUID = -2435306746995699312L;
        private final DurationField iDurationField;
        private final DurationField iLeapDurationField;
        private final DurationField iRangeDurationField;

        LimitDateTimeField(DateTimeField dateTimeField, DurationField durationField, DurationField durationField2, DurationField durationField3) {
            super(dateTimeField, dateTimeField.getType());
            this.iDurationField = durationField;
            this.iRangeDurationField = durationField2;
            this.iLeapDurationField = durationField3;
        }

        public int get(long j) {
            LimitChronology.this.checkLimits(j, (String) null);
            return getWrappedField().get(j);
        }

        public String getAsText(long j, Locale locale) {
            LimitChronology.this.checkLimits(j, (String) null);
            return getWrappedField().getAsText(j, locale);
        }

        public String getAsShortText(long j, Locale locale) {
            LimitChronology.this.checkLimits(j, (String) null);
            return getWrappedField().getAsShortText(j, locale);
        }

        public long add(long j, int i) {
            LimitChronology.this.checkLimits(j, (String) null);
            long add = getWrappedField().add(j, i);
            LimitChronology.this.checkLimits(add, "resulting");
            return add;
        }

        public long add(long j, long j2) {
            LimitChronology.this.checkLimits(j, (String) null);
            long add = getWrappedField().add(j, j2);
            LimitChronology.this.checkLimits(add, "resulting");
            return add;
        }

        public long addWrapField(long j, int i) {
            LimitChronology.this.checkLimits(j, (String) null);
            long addWrapField = getWrappedField().addWrapField(j, i);
            LimitChronology.this.checkLimits(addWrapField, "resulting");
            return addWrapField;
        }

        public int getDifference(long j, long j2) {
            LimitChronology.this.checkLimits(j, "minuend");
            LimitChronology.this.checkLimits(j2, "subtrahend");
            return getWrappedField().getDifference(j, j2);
        }

        public long getDifferenceAsLong(long j, long j2) {
            LimitChronology.this.checkLimits(j, "minuend");
            LimitChronology.this.checkLimits(j2, "subtrahend");
            return getWrappedField().getDifferenceAsLong(j, j2);
        }

        public long set(long j, int i) {
            LimitChronology.this.checkLimits(j, (String) null);
            long j2 = getWrappedField().set(j, i);
            LimitChronology.this.checkLimits(j2, "resulting");
            return j2;
        }

        public long set(long j, String str, Locale locale) {
            LimitChronology.this.checkLimits(j, (String) null);
            long j2 = getWrappedField().set(j, str, locale);
            LimitChronology.this.checkLimits(j2, "resulting");
            return j2;
        }

        public final DurationField getDurationField() {
            return this.iDurationField;
        }

        public final DurationField getRangeDurationField() {
            return this.iRangeDurationField;
        }

        public boolean isLeap(long j) {
            LimitChronology.this.checkLimits(j, (String) null);
            return getWrappedField().isLeap(j);
        }

        public int getLeapAmount(long j) {
            LimitChronology.this.checkLimits(j, (String) null);
            return getWrappedField().getLeapAmount(j);
        }

        public final DurationField getLeapDurationField() {
            return this.iLeapDurationField;
        }

        public long roundFloor(long j) {
            LimitChronology.this.checkLimits(j, (String) null);
            long roundFloor = getWrappedField().roundFloor(j);
            LimitChronology.this.checkLimits(roundFloor, "resulting");
            return roundFloor;
        }

        public long roundCeiling(long j) {
            LimitChronology.this.checkLimits(j, (String) null);
            long roundCeiling = getWrappedField().roundCeiling(j);
            LimitChronology.this.checkLimits(roundCeiling, "resulting");
            return roundCeiling;
        }

        public long roundHalfFloor(long j) {
            LimitChronology.this.checkLimits(j, (String) null);
            long roundHalfFloor = getWrappedField().roundHalfFloor(j);
            LimitChronology.this.checkLimits(roundHalfFloor, "resulting");
            return roundHalfFloor;
        }

        public long roundHalfCeiling(long j) {
            LimitChronology.this.checkLimits(j, (String) null);
            long roundHalfCeiling = getWrappedField().roundHalfCeiling(j);
            LimitChronology.this.checkLimits(roundHalfCeiling, "resulting");
            return roundHalfCeiling;
        }

        public long roundHalfEven(long j) {
            LimitChronology.this.checkLimits(j, (String) null);
            long roundHalfEven = getWrappedField().roundHalfEven(j);
            LimitChronology.this.checkLimits(roundHalfEven, "resulting");
            return roundHalfEven;
        }

        public long remainder(long j) {
            LimitChronology.this.checkLimits(j, (String) null);
            long remainder = getWrappedField().remainder(j);
            LimitChronology.this.checkLimits(remainder, "resulting");
            return remainder;
        }

        public int getMinimumValue(long j) {
            LimitChronology.this.checkLimits(j, (String) null);
            return getWrappedField().getMinimumValue(j);
        }

        public int getMaximumValue(long j) {
            LimitChronology.this.checkLimits(j, (String) null);
            return getWrappedField().getMaximumValue(j);
        }

        public int getMaximumTextLength(Locale locale) {
            return getWrappedField().getMaximumTextLength(locale);
        }

        public int getMaximumShortTextLength(Locale locale) {
            return getWrappedField().getMaximumShortTextLength(locale);
        }
    }
}
