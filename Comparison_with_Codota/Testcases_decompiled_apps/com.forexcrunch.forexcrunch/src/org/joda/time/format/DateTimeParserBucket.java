package org.joda.time.format;

import com.google.android.gms.appstate.AppStateClient;
import java.util.Arrays;
import java.util.Locale;
import org.joda.time.Chronology;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeUtils;
import org.joda.time.DateTimeZone;
import org.joda.time.DurationField;
import org.joda.time.DurationFieldType;
import org.joda.time.IllegalFieldValueException;
import org.joda.time.IllegalInstantException;

public class DateTimeParserBucket {
    private final Chronology iChrono;
    private int iDefaultYear;
    private Locale iLocale;
    private final long iMillis;
    /* access modifiers changed from: private */
    public Integer iOffset;
    private Integer iPivotYear;
    /* access modifiers changed from: private */
    public SavedField[] iSavedFields;
    /* access modifiers changed from: private */
    public int iSavedFieldsCount;
    /* access modifiers changed from: private */
    public boolean iSavedFieldsShared;
    private Object iSavedState;
    /* access modifiers changed from: private */
    public DateTimeZone iZone;

    @Deprecated
    public DateTimeParserBucket(long j, Chronology chronology, Locale locale) {
        this(j, chronology, locale, (Integer) null, AppStateClient.STATUS_WRITE_OUT_OF_DATE_VERSION);
    }

    @Deprecated
    public DateTimeParserBucket(long j, Chronology chronology, Locale locale, Integer num) {
        this(j, chronology, locale, num, AppStateClient.STATUS_WRITE_OUT_OF_DATE_VERSION);
    }

    public DateTimeParserBucket(long j, Chronology chronology, Locale locale, Integer num, int i) {
        this.iSavedFields = new SavedField[8];
        Chronology chronology2 = DateTimeUtils.getChronology(chronology);
        this.iMillis = j;
        this.iZone = chronology2.getZone();
        this.iChrono = chronology2.withUTC();
        this.iLocale = locale == null ? Locale.getDefault() : locale;
        this.iPivotYear = num;
        this.iDefaultYear = i;
    }

    public Chronology getChronology() {
        return this.iChrono;
    }

    public Locale getLocale() {
        return this.iLocale;
    }

    public DateTimeZone getZone() {
        return this.iZone;
    }

    public void setZone(DateTimeZone dateTimeZone) {
        this.iSavedState = null;
        this.iZone = dateTimeZone;
    }

    @Deprecated
    public int getOffset() {
        if (this.iOffset != null) {
            return this.iOffset.intValue();
        }
        return 0;
    }

    public Integer getOffsetInteger() {
        return this.iOffset;
    }

    @Deprecated
    public void setOffset(int i) {
        this.iSavedState = null;
        this.iOffset = Integer.valueOf(i);
    }

    public void setOffset(Integer num) {
        this.iSavedState = null;
        this.iOffset = num;
    }

    public Integer getPivotYear() {
        return this.iPivotYear;
    }

    public void setPivotYear(Integer num) {
        this.iPivotYear = num;
    }

    public void saveField(DateTimeField dateTimeField, int i) {
        saveField(new SavedField(dateTimeField, i));
    }

    public void saveField(DateTimeFieldType dateTimeFieldType, int i) {
        saveField(new SavedField(dateTimeFieldType.getField(this.iChrono), i));
    }

    public void saveField(DateTimeFieldType dateTimeFieldType, String str, Locale locale) {
        saveField(new SavedField(dateTimeFieldType.getField(this.iChrono), str, locale));
    }

    private void saveField(SavedField savedField) {
        SavedField[] savedFieldArr;
        SavedField[] savedFieldArr2 = this.iSavedFields;
        int i = this.iSavedFieldsCount;
        if (i == savedFieldArr2.length || this.iSavedFieldsShared) {
            savedFieldArr = new SavedField[(i == savedFieldArr2.length ? i * 2 : savedFieldArr2.length)];
            System.arraycopy(savedFieldArr2, 0, savedFieldArr, 0, i);
            this.iSavedFields = savedFieldArr;
            this.iSavedFieldsShared = false;
        } else {
            savedFieldArr = savedFieldArr2;
        }
        this.iSavedState = null;
        savedFieldArr[i] = savedField;
        this.iSavedFieldsCount = i + 1;
    }

    public Object saveState() {
        if (this.iSavedState == null) {
            this.iSavedState = new SavedState();
        }
        return this.iSavedState;
    }

    public boolean restoreState(Object obj) {
        if (!(obj instanceof SavedState) || !((SavedState) obj).restoreState(this)) {
            return false;
        }
        this.iSavedState = obj;
        return true;
    }

    public long computeMillis() {
        return computeMillis(false, (String) null);
    }

    public long computeMillis(boolean z) {
        return computeMillis(z, (String) null);
    }

    public long computeMillis(boolean z, String str) {
        boolean z2;
        SavedField[] savedFieldArr = this.iSavedFields;
        int i = this.iSavedFieldsCount;
        if (this.iSavedFieldsShared) {
            savedFieldArr = (SavedField[]) this.iSavedFields.clone();
            this.iSavedFields = savedFieldArr;
            this.iSavedFieldsShared = false;
        }
        sort(savedFieldArr, i);
        if (i > 0) {
            DurationField field = DurationFieldType.months().getField(this.iChrono);
            DurationField field2 = DurationFieldType.days().getField(this.iChrono);
            DurationField durationField = savedFieldArr[0].iField.getDurationField();
            if (compareReverse(durationField, field) >= 0 && compareReverse(durationField, field2) <= 0) {
                saveField(DateTimeFieldType.year(), this.iDefaultYear);
                return computeMillis(z, str);
            }
        }
        long j = this.iMillis;
        int i2 = 0;
        while (i2 < i) {
            try {
                long j2 = savedFieldArr[i2].set(j, z);
                i2++;
                j = j2;
            } catch (IllegalFieldValueException e) {
                if (str != null) {
                    e.prependMessage("Cannot parse \"" + str + '\"');
                }
                throw e;
            }
        }
        if (z) {
            int i3 = 0;
            while (i3 < i) {
                SavedField savedField = savedFieldArr[i3];
                if (i3 == i - 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                i3++;
                j = savedField.set(j, z2);
            }
        }
        long j3 = j;
        if (this.iOffset != null) {
            return j3 - ((long) this.iOffset.intValue());
        }
        if (this.iZone == null) {
            return j3;
        }
        int offsetFromLocal = this.iZone.getOffsetFromLocal(j3);
        long j4 = j3 - ((long) offsetFromLocal);
        if (offsetFromLocal == this.iZone.getOffset(j4)) {
            return j4;
        }
        String str2 = "Illegal instant due to time zone offset transition (" + this.iZone + ')';
        if (str != null) {
            str2 = "Cannot parse \"" + str + "\": " + str2;
        }
        throw new IllegalInstantException(str2);
    }

    private static void sort(SavedField[] savedFieldArr, int i) {
        if (i > 10) {
            Arrays.sort(savedFieldArr, 0, i);
            return;
        }
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = i2;
            while (i3 > 0 && savedFieldArr[i3 - 1].compareTo(savedFieldArr[i3]) > 0) {
                SavedField savedField = savedFieldArr[i3];
                savedFieldArr[i3] = savedFieldArr[i3 - 1];
                savedFieldArr[i3 - 1] = savedField;
                i3--;
            }
        }
    }

    class SavedState {
        final Integer iOffset;
        final SavedField[] iSavedFields;
        final int iSavedFieldsCount;
        final DateTimeZone iZone;

        SavedState() {
            this.iZone = DateTimeParserBucket.this.iZone;
            this.iOffset = DateTimeParserBucket.this.iOffset;
            this.iSavedFields = DateTimeParserBucket.this.iSavedFields;
            this.iSavedFieldsCount = DateTimeParserBucket.this.iSavedFieldsCount;
        }

        /* access modifiers changed from: package-private */
        public boolean restoreState(DateTimeParserBucket dateTimeParserBucket) {
            if (dateTimeParserBucket != DateTimeParserBucket.this) {
                return false;
            }
            DateTimeZone unused = dateTimeParserBucket.iZone = this.iZone;
            Integer unused2 = dateTimeParserBucket.iOffset = this.iOffset;
            SavedField[] unused3 = dateTimeParserBucket.iSavedFields = this.iSavedFields;
            if (this.iSavedFieldsCount < dateTimeParserBucket.iSavedFieldsCount) {
                boolean unused4 = dateTimeParserBucket.iSavedFieldsShared = true;
            }
            int unused5 = dateTimeParserBucket.iSavedFieldsCount = this.iSavedFieldsCount;
            return true;
        }
    }

    static class SavedField implements Comparable<SavedField> {
        final DateTimeField iField;
        final Locale iLocale;
        final String iText;
        final int iValue;

        SavedField(DateTimeField dateTimeField, int i) {
            this.iField = dateTimeField;
            this.iValue = i;
            this.iText = null;
            this.iLocale = null;
        }

        SavedField(DateTimeField dateTimeField, String str, Locale locale) {
            this.iField = dateTimeField;
            this.iValue = 0;
            this.iText = str;
            this.iLocale = locale;
        }

        /* access modifiers changed from: package-private */
        public long set(long j, boolean z) {
            long j2;
            if (this.iText == null) {
                j2 = this.iField.set(j, this.iValue);
            } else {
                j2 = this.iField.set(j, this.iText, this.iLocale);
            }
            if (z) {
                return this.iField.roundFloor(j2);
            }
            return j2;
        }

        public int compareTo(SavedField savedField) {
            DateTimeField dateTimeField = savedField.iField;
            int compareReverse = DateTimeParserBucket.compareReverse(this.iField.getRangeDurationField(), dateTimeField.getRangeDurationField());
            return compareReverse != 0 ? compareReverse : DateTimeParserBucket.compareReverse(this.iField.getDurationField(), dateTimeField.getDurationField());
        }
    }

    static int compareReverse(DurationField durationField, DurationField durationField2) {
        if (durationField == null || !durationField.isSupported()) {
            if (durationField2 == null || !durationField2.isSupported()) {
                return 0;
            }
            return -1;
        } else if (durationField2 == null || !durationField2.isSupported()) {
            return 1;
        } else {
            return -durationField.compareTo(durationField2);
        }
    }
}
