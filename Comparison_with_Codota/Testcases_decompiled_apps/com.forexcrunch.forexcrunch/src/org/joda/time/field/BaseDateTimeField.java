package org.joda.time.field;

import java.util.Locale;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;
import org.joda.time.IllegalFieldValueException;
import org.joda.time.ReadablePartial;

public abstract class BaseDateTimeField extends DateTimeField {
    private final DateTimeFieldType iType;

    public abstract int get(long j);

    public abstract DurationField getDurationField();

    public abstract int getMaximumValue();

    public abstract int getMinimumValue();

    public abstract DurationField getRangeDurationField();

    public abstract long roundFloor(long j);

    public abstract long set(long j, int i);

    protected BaseDateTimeField(DateTimeFieldType dateTimeFieldType) {
        if (dateTimeFieldType == null) {
            throw new IllegalArgumentException("The type must not be null");
        }
        this.iType = dateTimeFieldType;
    }

    public final DateTimeFieldType getType() {
        return this.iType;
    }

    public final String getName() {
        return this.iType.getName();
    }

    public final boolean isSupported() {
        return true;
    }

    public String getAsText(long j, Locale locale) {
        return getAsText(get(j), locale);
    }

    public final String getAsText(long j) {
        return getAsText(j, (Locale) null);
    }

    public String getAsText(ReadablePartial readablePartial, int i, Locale locale) {
        return getAsText(i, locale);
    }

    public final String getAsText(ReadablePartial readablePartial, Locale locale) {
        return getAsText(readablePartial, readablePartial.get(getType()), locale);
    }

    public String getAsText(int i, Locale locale) {
        return Integer.toString(i);
    }

    public String getAsShortText(long j, Locale locale) {
        return getAsShortText(get(j), locale);
    }

    public final String getAsShortText(long j) {
        return getAsShortText(j, (Locale) null);
    }

    public String getAsShortText(ReadablePartial readablePartial, int i, Locale locale) {
        return getAsShortText(i, locale);
    }

    public final String getAsShortText(ReadablePartial readablePartial, Locale locale) {
        return getAsShortText(readablePartial, readablePartial.get(getType()), locale);
    }

    public String getAsShortText(int i, Locale locale) {
        return getAsText(i, locale);
    }

    public long add(long j, int i) {
        return getDurationField().add(j, i);
    }

    public long add(long j, long j2) {
        return getDurationField().add(j, j2);
    }

    public int[] add(ReadablePartial readablePartial, int i, int[] iArr, int i2) {
        if (i2 == 0) {
            return iArr;
        }
        DateTimeField dateTimeField = null;
        int i3 = i2;
        int[] iArr2 = iArr;
        while (true) {
            if (i3 <= 0) {
                break;
            }
            int maximumValue = getMaximumValue(readablePartial, iArr2);
            long j = (long) (iArr2[i] + i3);
            if (j <= ((long) maximumValue)) {
                iArr2[i] = (int) j;
                break;
            }
            if (dateTimeField == null) {
                if (i == 0) {
                    throw new IllegalArgumentException("Maximum value exceeded for add");
                }
                dateTimeField = readablePartial.getField(i - 1);
                if (getRangeDurationField().getType() != dateTimeField.getDurationField().getType()) {
                    throw new IllegalArgumentException("Fields invalid for add");
                }
            }
            i3 -= (maximumValue + 1) - iArr2[i];
            iArr2 = dateTimeField.add(readablePartial, i - 1, iArr2, 1);
            iArr2[i] = getMinimumValue(readablePartial, iArr2);
        }
        while (true) {
            if (i3 >= 0) {
                break;
            }
            int minimumValue = getMinimumValue(readablePartial, iArr2);
            long j2 = (long) (iArr2[i] + i3);
            if (j2 >= ((long) minimumValue)) {
                iArr2[i] = (int) j2;
                break;
            }
            if (dateTimeField == null) {
                if (i == 0) {
                    throw new IllegalArgumentException("Maximum value exceeded for add");
                }
                dateTimeField = readablePartial.getField(i - 1);
                if (getRangeDurationField().getType() != dateTimeField.getDurationField().getType()) {
                    throw new IllegalArgumentException("Fields invalid for add");
                }
            }
            i3 -= (minimumValue - 1) - iArr2[i];
            iArr2 = dateTimeField.add(readablePartial, i - 1, iArr2, -1);
            iArr2[i] = getMaximumValue(readablePartial, iArr2);
        }
        return set(readablePartial, i, iArr2, iArr2[i]);
    }

    public int[] addWrapPartial(ReadablePartial readablePartial, int i, int[] iArr, int i2) {
        int i3;
        if (i2 == 0) {
            return iArr;
        }
        DateTimeField dateTimeField = null;
        int i4 = i2;
        int[] iArr2 = iArr;
        while (true) {
            if (i4 <= 0) {
                break;
            }
            int maximumValue = getMaximumValue(readablePartial, iArr2);
            long j = (long) (iArr2[i] + i4);
            if (j <= ((long) maximumValue)) {
                iArr2[i] = (int) j;
                break;
            }
            if (dateTimeField == null) {
                if (i == 0) {
                    i4 -= (maximumValue + 1) - iArr2[i];
                    iArr2[i] = getMinimumValue(readablePartial, iArr2);
                } else {
                    dateTimeField = readablePartial.getField(i - 1);
                    if (getRangeDurationField().getType() != dateTimeField.getDurationField().getType()) {
                        throw new IllegalArgumentException("Fields invalid for add");
                    }
                }
            }
            i4 -= (maximumValue + 1) - iArr2[i];
            iArr2 = dateTimeField.addWrapPartial(readablePartial, i - 1, iArr2, 1);
            iArr2[i] = getMinimumValue(readablePartial, iArr2);
        }
        while (true) {
            if (i4 >= 0) {
                break;
            }
            int minimumValue = getMinimumValue(readablePartial, iArr2);
            long j2 = (long) (iArr2[i] + i4);
            if (j2 >= ((long) minimumValue)) {
                iArr2[i] = (int) j2;
                break;
            }
            if (dateTimeField == null) {
                if (i == 0) {
                    i3 = i4 - ((minimumValue - 1) - iArr2[i]);
                    iArr2[i] = getMaximumValue(readablePartial, iArr2);
                } else {
                    dateTimeField = readablePartial.getField(i - 1);
                    if (getRangeDurationField().getType() != dateTimeField.getDurationField().getType()) {
                        throw new IllegalArgumentException("Fields invalid for add");
                    }
                }
            }
            i3 = i4 - ((minimumValue - 1) - iArr2[i]);
            iArr2 = dateTimeField.addWrapPartial(readablePartial, i - 1, iArr2, -1);
            iArr2[i] = getMaximumValue(readablePartial, iArr2);
        }
        return set(readablePartial, i, iArr2, iArr2[i]);
    }

    public long addWrapField(long j, int i) {
        return set(j, FieldUtils.getWrappedValue(get(j), i, getMinimumValue(j), getMaximumValue(j)));
    }

    public int[] addWrapField(ReadablePartial readablePartial, int i, int[] iArr, int i2) {
        return set(readablePartial, i, iArr, FieldUtils.getWrappedValue(iArr[i], i2, getMinimumValue(readablePartial), getMaximumValue(readablePartial)));
    }

    public int getDifference(long j, long j2) {
        return getDurationField().getDifference(j, j2);
    }

    public long getDifferenceAsLong(long j, long j2) {
        return getDurationField().getDifferenceAsLong(j, j2);
    }

    public int[] set(ReadablePartial readablePartial, int i, int[] iArr, int i2) {
        FieldUtils.verifyValueBounds((DateTimeField) this, i2, getMinimumValue(readablePartial, iArr), getMaximumValue(readablePartial, iArr));
        iArr[i] = i2;
        for (int i3 = i + 1; i3 < readablePartial.size(); i3++) {
            DateTimeField field = readablePartial.getField(i3);
            if (iArr[i3] > field.getMaximumValue(readablePartial, iArr)) {
                iArr[i3] = field.getMaximumValue(readablePartial, iArr);
            }
            if (iArr[i3] < field.getMinimumValue(readablePartial, iArr)) {
                iArr[i3] = field.getMinimumValue(readablePartial, iArr);
            }
        }
        return iArr;
    }

    public long set(long j, String str, Locale locale) {
        return set(j, convertText(str, locale));
    }

    public final long set(long j, String str) {
        return set(j, str, (Locale) null);
    }

    public int[] set(ReadablePartial readablePartial, int i, int[] iArr, String str, Locale locale) {
        return set(readablePartial, i, iArr, convertText(str, locale));
    }

    /* access modifiers changed from: protected */
    public int convertText(String str, Locale locale) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalFieldValueException(getType(), str);
        }
    }

    public boolean isLeap(long j) {
        return false;
    }

    public int getLeapAmount(long j) {
        return 0;
    }

    public DurationField getLeapDurationField() {
        return null;
    }

    public int getMinimumValue(long j) {
        return getMinimumValue();
    }

    public int getMinimumValue(ReadablePartial readablePartial) {
        return getMinimumValue();
    }

    public int getMinimumValue(ReadablePartial readablePartial, int[] iArr) {
        return getMinimumValue(readablePartial);
    }

    public int getMaximumValue(long j) {
        return getMaximumValue();
    }

    public int getMaximumValue(ReadablePartial readablePartial) {
        return getMaximumValue();
    }

    public int getMaximumValue(ReadablePartial readablePartial, int[] iArr) {
        return getMaximumValue(readablePartial);
    }

    public int getMaximumTextLength(Locale locale) {
        int maximumValue = getMaximumValue();
        if (maximumValue >= 0) {
            if (maximumValue < 10) {
                return 1;
            }
            if (maximumValue < 100) {
                return 2;
            }
            if (maximumValue < 1000) {
                return 3;
            }
        }
        return Integer.toString(maximumValue).length();
    }

    public int getMaximumShortTextLength(Locale locale) {
        return getMaximumTextLength(locale);
    }

    public long roundCeiling(long j) {
        long roundFloor = roundFloor(j);
        if (roundFloor != j) {
            return add(roundFloor, 1);
        }
        return j;
    }

    public long roundHalfFloor(long j) {
        long roundFloor = roundFloor(j);
        long roundCeiling = roundCeiling(j);
        return j - roundFloor <= roundCeiling - j ? roundFloor : roundCeiling;
    }

    public long roundHalfCeiling(long j) {
        long roundFloor = roundFloor(j);
        long roundCeiling = roundCeiling(j);
        return roundCeiling - j <= j - roundFloor ? roundCeiling : roundFloor;
    }

    public long roundHalfEven(long j) {
        long roundFloor = roundFloor(j);
        long roundCeiling = roundCeiling(j);
        long j2 = j - roundFloor;
        long j3 = roundCeiling - j;
        if (j2 < j3) {
            return roundFloor;
        }
        if (j3 < j2) {
            return roundCeiling;
        }
        if ((get(roundCeiling) & 1) == 0) {
            return roundCeiling;
        }
        return roundFloor;
    }

    public long remainder(long j) {
        return j - roundFloor(j);
    }

    public String toString() {
        return "DateTimeField[" + getName() + ']';
    }
}
