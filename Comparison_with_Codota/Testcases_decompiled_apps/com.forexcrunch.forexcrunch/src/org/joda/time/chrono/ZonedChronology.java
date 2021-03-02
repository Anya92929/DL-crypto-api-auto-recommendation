package org.joda.time.chrono;

import java.util.HashMap;
import java.util.Locale;
import org.joda.time.Chronology;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeZone;
import org.joda.time.DurationField;
import org.joda.time.IllegalFieldValueException;
import org.joda.time.IllegalInstantException;
import org.joda.time.ReadablePartial;
import org.joda.time.chrono.AssembledChronology;
import org.joda.time.field.BaseDateTimeField;
import org.joda.time.field.BaseDurationField;

public final class ZonedChronology extends AssembledChronology {
    private static final long serialVersionUID = -1079258847191166848L;

    public static ZonedChronology getInstance(Chronology chronology, DateTimeZone dateTimeZone) {
        if (chronology == null) {
            throw new IllegalArgumentException("Must supply a chronology");
        }
        Chronology withUTC = chronology.withUTC();
        if (withUTC == null) {
            throw new IllegalArgumentException("UTC chronology must not be null");
        } else if (dateTimeZone != null) {
            return new ZonedChronology(withUTC, dateTimeZone);
        } else {
            throw new IllegalArgumentException("DateTimeZone must not be null");
        }
    }

    static boolean useTimeArithmetic(DurationField durationField) {
        return durationField != null && durationField.getUnitMillis() < 43200000;
    }

    private ZonedChronology(Chronology chronology, DateTimeZone dateTimeZone) {
        super(chronology, dateTimeZone);
    }

    public DateTimeZone getZone() {
        return (DateTimeZone) getParam();
    }

    public Chronology withUTC() {
        return getBase();
    }

    public Chronology withZone(DateTimeZone dateTimeZone) {
        if (dateTimeZone == null) {
            dateTimeZone = DateTimeZone.getDefault();
        }
        if (dateTimeZone == getParam()) {
            return this;
        }
        if (dateTimeZone == DateTimeZone.UTC) {
            return getBase();
        }
        return new ZonedChronology(getBase(), dateTimeZone);
    }

    public long getDateTimeMillis(int i, int i2, int i3, int i4) throws IllegalArgumentException {
        return localToUTC(getBase().getDateTimeMillis(i, i2, i3, i4));
    }

    public long getDateTimeMillis(int i, int i2, int i3, int i4, int i5, int i6, int i7) throws IllegalArgumentException {
        return localToUTC(getBase().getDateTimeMillis(i, i2, i3, i4, i5, i6, i7));
    }

    public long getDateTimeMillis(long j, int i, int i2, int i3, int i4) throws IllegalArgumentException {
        return localToUTC(getBase().getDateTimeMillis(((long) getZone().getOffset(j)) + j, i, i2, i3, i4));
    }

    private long localToUTC(long j) {
        DateTimeZone zone = getZone();
        int offsetFromLocal = zone.getOffsetFromLocal(j);
        long j2 = j - ((long) offsetFromLocal);
        if (offsetFromLocal == zone.getOffset(j2)) {
            return j2;
        }
        throw new IllegalInstantException(j2, zone.getID());
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
        ZonedDurationField zonedDurationField = new ZonedDurationField(durationField, getZone());
        hashMap.put(durationField, zonedDurationField);
        return zonedDurationField;
    }

    private DateTimeField convertField(DateTimeField dateTimeField, HashMap<Object, Object> hashMap) {
        if (dateTimeField == null || !dateTimeField.isSupported()) {
            return dateTimeField;
        }
        if (hashMap.containsKey(dateTimeField)) {
            return (DateTimeField) hashMap.get(dateTimeField);
        }
        ZonedDateTimeField zonedDateTimeField = new ZonedDateTimeField(dateTimeField, getZone(), convertField(dateTimeField.getDurationField(), hashMap), convertField(dateTimeField.getRangeDurationField(), hashMap), convertField(dateTimeField.getLeapDurationField(), hashMap));
        hashMap.put(dateTimeField, zonedDateTimeField);
        return zonedDateTimeField;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ZonedChronology)) {
            return false;
        }
        ZonedChronology zonedChronology = (ZonedChronology) obj;
        if (!getBase().equals(zonedChronology.getBase()) || !getZone().equals(zonedChronology.getZone())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return 326565 + (getZone().hashCode() * 11) + (getBase().hashCode() * 7);
    }

    public String toString() {
        return "ZonedChronology[" + getBase() + ", " + getZone().getID() + ']';
    }

    static class ZonedDurationField extends BaseDurationField {
        private static final long serialVersionUID = -485345310999208286L;
        final DurationField iField;
        final boolean iTimeField;
        final DateTimeZone iZone;

        ZonedDurationField(DurationField durationField, DateTimeZone dateTimeZone) {
            super(durationField.getType());
            if (!durationField.isSupported()) {
                throw new IllegalArgumentException();
            }
            this.iField = durationField;
            this.iTimeField = ZonedChronology.useTimeArithmetic(durationField);
            this.iZone = dateTimeZone;
        }

        public boolean isPrecise() {
            if (this.iTimeField) {
                return this.iField.isPrecise();
            }
            return this.iField.isPrecise() && this.iZone.isFixed();
        }

        public long getUnitMillis() {
            return this.iField.getUnitMillis();
        }

        public int getValue(long j, long j2) {
            return this.iField.getValue(j, addOffset(j2));
        }

        public long getValueAsLong(long j, long j2) {
            return this.iField.getValueAsLong(j, addOffset(j2));
        }

        public long getMillis(int i, long j) {
            return this.iField.getMillis(i, addOffset(j));
        }

        public long getMillis(long j, long j2) {
            return this.iField.getMillis(j, addOffset(j2));
        }

        public long add(long j, int i) {
            int offsetToAdd = getOffsetToAdd(j);
            long add = this.iField.add(((long) offsetToAdd) + j, i);
            if (!this.iTimeField) {
                offsetToAdd = getOffsetFromLocalToSubtract(add);
            }
            return add - ((long) offsetToAdd);
        }

        public long add(long j, long j2) {
            int offsetToAdd = getOffsetToAdd(j);
            long add = this.iField.add(((long) offsetToAdd) + j, j2);
            if (!this.iTimeField) {
                offsetToAdd = getOffsetFromLocalToSubtract(add);
            }
            return add - ((long) offsetToAdd);
        }

        public int getDifference(long j, long j2) {
            int offsetToAdd = getOffsetToAdd(j2);
            return this.iField.getDifference(((long) (this.iTimeField ? offsetToAdd : getOffsetToAdd(j))) + j, ((long) offsetToAdd) + j2);
        }

        public long getDifferenceAsLong(long j, long j2) {
            int offsetToAdd = getOffsetToAdd(j2);
            return this.iField.getDifferenceAsLong(((long) (this.iTimeField ? offsetToAdd : getOffsetToAdd(j))) + j, ((long) offsetToAdd) + j2);
        }

        private int getOffsetToAdd(long j) {
            int offset = this.iZone.getOffset(j);
            if (((((long) offset) + j) ^ j) >= 0 || (((long) offset) ^ j) < 0) {
                return offset;
            }
            throw new ArithmeticException("Adding time zone offset caused overflow");
        }

        private int getOffsetFromLocalToSubtract(long j) {
            int offsetFromLocal = this.iZone.getOffsetFromLocal(j);
            if (((j - ((long) offsetFromLocal)) ^ j) >= 0 || (((long) offsetFromLocal) ^ j) >= 0) {
                return offsetFromLocal;
            }
            throw new ArithmeticException("Subtracting time zone offset caused overflow");
        }

        private long addOffset(long j) {
            return this.iZone.convertUTCToLocal(j);
        }
    }

    static final class ZonedDateTimeField extends BaseDateTimeField {
        private static final long serialVersionUID = -3968986277775529794L;
        final DurationField iDurationField;
        final DateTimeField iField;
        final DurationField iLeapDurationField;
        final DurationField iRangeDurationField;
        final boolean iTimeField;
        final DateTimeZone iZone;

        ZonedDateTimeField(DateTimeField dateTimeField, DateTimeZone dateTimeZone, DurationField durationField, DurationField durationField2, DurationField durationField3) {
            super(dateTimeField.getType());
            if (!dateTimeField.isSupported()) {
                throw new IllegalArgumentException();
            }
            this.iField = dateTimeField;
            this.iZone = dateTimeZone;
            this.iDurationField = durationField;
            this.iTimeField = ZonedChronology.useTimeArithmetic(durationField);
            this.iRangeDurationField = durationField2;
            this.iLeapDurationField = durationField3;
        }

        public boolean isLenient() {
            return this.iField.isLenient();
        }

        public int get(long j) {
            return this.iField.get(this.iZone.convertUTCToLocal(j));
        }

        public String getAsText(long j, Locale locale) {
            return this.iField.getAsText(this.iZone.convertUTCToLocal(j), locale);
        }

        public String getAsShortText(long j, Locale locale) {
            return this.iField.getAsShortText(this.iZone.convertUTCToLocal(j), locale);
        }

        public String getAsText(int i, Locale locale) {
            return this.iField.getAsText(i, locale);
        }

        public String getAsShortText(int i, Locale locale) {
            return this.iField.getAsShortText(i, locale);
        }

        public long add(long j, int i) {
            if (this.iTimeField) {
                int offsetToAdd = getOffsetToAdd(j);
                return this.iField.add(((long) offsetToAdd) + j, i) - ((long) offsetToAdd);
            }
            return this.iZone.convertLocalToUTC(this.iField.add(this.iZone.convertUTCToLocal(j), i), false, j);
        }

        public long add(long j, long j2) {
            if (this.iTimeField) {
                int offsetToAdd = getOffsetToAdd(j);
                return this.iField.add(((long) offsetToAdd) + j, j2) - ((long) offsetToAdd);
            }
            return this.iZone.convertLocalToUTC(this.iField.add(this.iZone.convertUTCToLocal(j), j2), false, j);
        }

        public long addWrapField(long j, int i) {
            if (this.iTimeField) {
                int offsetToAdd = getOffsetToAdd(j);
                return this.iField.addWrapField(((long) offsetToAdd) + j, i) - ((long) offsetToAdd);
            }
            return this.iZone.convertLocalToUTC(this.iField.addWrapField(this.iZone.convertUTCToLocal(j), i), false, j);
        }

        public long set(long j, int i) {
            long j2 = this.iField.set(this.iZone.convertUTCToLocal(j), i);
            long convertLocalToUTC = this.iZone.convertLocalToUTC(j2, false, j);
            if (get(convertLocalToUTC) == i) {
                return convertLocalToUTC;
            }
            IllegalInstantException illegalInstantException = new IllegalInstantException(j2, this.iZone.getID());
            IllegalFieldValueException illegalFieldValueException = new IllegalFieldValueException(this.iField.getType(), Integer.valueOf(i), illegalInstantException.getMessage());
            illegalFieldValueException.initCause(illegalInstantException);
            throw illegalFieldValueException;
        }

        public long set(long j, String str, Locale locale) {
            return this.iZone.convertLocalToUTC(this.iField.set(this.iZone.convertUTCToLocal(j), str, locale), false, j);
        }

        public int getDifference(long j, long j2) {
            int offsetToAdd = getOffsetToAdd(j2);
            return this.iField.getDifference(((long) (this.iTimeField ? offsetToAdd : getOffsetToAdd(j))) + j, ((long) offsetToAdd) + j2);
        }

        public long getDifferenceAsLong(long j, long j2) {
            int offsetToAdd = getOffsetToAdd(j2);
            return this.iField.getDifferenceAsLong(((long) (this.iTimeField ? offsetToAdd : getOffsetToAdd(j))) + j, ((long) offsetToAdd) + j2);
        }

        public final DurationField getDurationField() {
            return this.iDurationField;
        }

        public final DurationField getRangeDurationField() {
            return this.iRangeDurationField;
        }

        public boolean isLeap(long j) {
            return this.iField.isLeap(this.iZone.convertUTCToLocal(j));
        }

        public int getLeapAmount(long j) {
            return this.iField.getLeapAmount(this.iZone.convertUTCToLocal(j));
        }

        public final DurationField getLeapDurationField() {
            return this.iLeapDurationField;
        }

        public long roundFloor(long j) {
            if (this.iTimeField) {
                int offsetToAdd = getOffsetToAdd(j);
                return this.iField.roundFloor(((long) offsetToAdd) + j) - ((long) offsetToAdd);
            }
            return this.iZone.convertLocalToUTC(this.iField.roundFloor(this.iZone.convertUTCToLocal(j)), false, j);
        }

        public long roundCeiling(long j) {
            if (this.iTimeField) {
                int offsetToAdd = getOffsetToAdd(j);
                return this.iField.roundCeiling(((long) offsetToAdd) + j) - ((long) offsetToAdd);
            }
            return this.iZone.convertLocalToUTC(this.iField.roundCeiling(this.iZone.convertUTCToLocal(j)), false, j);
        }

        public long remainder(long j) {
            return this.iField.remainder(this.iZone.convertUTCToLocal(j));
        }

        public int getMinimumValue() {
            return this.iField.getMinimumValue();
        }

        public int getMinimumValue(long j) {
            return this.iField.getMinimumValue(this.iZone.convertUTCToLocal(j));
        }

        public int getMinimumValue(ReadablePartial readablePartial) {
            return this.iField.getMinimumValue(readablePartial);
        }

        public int getMinimumValue(ReadablePartial readablePartial, int[] iArr) {
            return this.iField.getMinimumValue(readablePartial, iArr);
        }

        public int getMaximumValue() {
            return this.iField.getMaximumValue();
        }

        public int getMaximumValue(long j) {
            return this.iField.getMaximumValue(this.iZone.convertUTCToLocal(j));
        }

        public int getMaximumValue(ReadablePartial readablePartial) {
            return this.iField.getMaximumValue(readablePartial);
        }

        public int getMaximumValue(ReadablePartial readablePartial, int[] iArr) {
            return this.iField.getMaximumValue(readablePartial, iArr);
        }

        public int getMaximumTextLength(Locale locale) {
            return this.iField.getMaximumTextLength(locale);
        }

        public int getMaximumShortTextLength(Locale locale) {
            return this.iField.getMaximumShortTextLength(locale);
        }

        private int getOffsetToAdd(long j) {
            int offset = this.iZone.getOffset(j);
            if (((((long) offset) + j) ^ j) >= 0 || (((long) offset) ^ j) < 0) {
                return offset;
            }
            throw new ArithmeticException("Adding time zone offset caused overflow");
        }
    }
}
