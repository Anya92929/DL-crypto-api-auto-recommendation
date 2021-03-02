package org.joda.time;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import org.joda.time.base.AbstractPartial;
import org.joda.time.field.AbstractPartialFieldProperty;
import org.joda.time.field.FieldUtils;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

public final class Partial extends AbstractPartial implements ReadablePartial, Serializable {
    private static final long serialVersionUID = 12324121189002L;
    private final Chronology iChronology;
    private transient DateTimeFormatter[] iFormatter;
    private final DateTimeFieldType[] iTypes;
    private final int[] iValues;

    public Partial() {
        this((Chronology) null);
    }

    public Partial(Chronology chronology) {
        this.iChronology = DateTimeUtils.getChronology(chronology).withUTC();
        this.iTypes = new DateTimeFieldType[0];
        this.iValues = new int[0];
    }

    public Partial(DateTimeFieldType dateTimeFieldType, int i) {
        this(dateTimeFieldType, i, (Chronology) null);
    }

    public Partial(DateTimeFieldType dateTimeFieldType, int i, Chronology chronology) {
        Chronology withUTC = DateTimeUtils.getChronology(chronology).withUTC();
        this.iChronology = withUTC;
        if (dateTimeFieldType == null) {
            throw new IllegalArgumentException("The field type must not be null");
        }
        this.iTypes = new DateTimeFieldType[]{dateTimeFieldType};
        this.iValues = new int[]{i};
        withUTC.validate(this, this.iValues);
    }

    public Partial(DateTimeFieldType[] dateTimeFieldTypeArr, int[] iArr) {
        this(dateTimeFieldTypeArr, iArr, (Chronology) null);
    }

    public Partial(DateTimeFieldType[] dateTimeFieldTypeArr, int[] iArr, Chronology chronology) {
        int i = 0;
        Chronology withUTC = DateTimeUtils.getChronology(chronology).withUTC();
        this.iChronology = withUTC;
        if (dateTimeFieldTypeArr == null) {
            throw new IllegalArgumentException("Types array must not be null");
        } else if (iArr == null) {
            throw new IllegalArgumentException("Values array must not be null");
        } else if (iArr.length != dateTimeFieldTypeArr.length) {
            throw new IllegalArgumentException("Values array must be the same length as the types array");
        } else if (dateTimeFieldTypeArr.length == 0) {
            this.iTypes = dateTimeFieldTypeArr;
            this.iValues = iArr;
        } else {
            for (int i2 = 0; i2 < dateTimeFieldTypeArr.length; i2++) {
                if (dateTimeFieldTypeArr[i2] == null) {
                    throw new IllegalArgumentException("Types array must not contain null: index " + i2);
                }
            }
            DurationField durationField = null;
            while (i < dateTimeFieldTypeArr.length) {
                DateTimeFieldType dateTimeFieldType = dateTimeFieldTypeArr[i];
                DurationField field = dateTimeFieldType.getDurationType().getField(this.iChronology);
                if (i > 0) {
                    int compareTo = durationField.compareTo(field);
                    if (compareTo < 0 || (compareTo != 0 && !field.isSupported())) {
                        throw new IllegalArgumentException("Types array must be in order largest-smallest: " + dateTimeFieldTypeArr[i - 1].getName() + " < " + dateTimeFieldType.getName());
                    } else if (compareTo != 0) {
                        continue;
                    } else if (dateTimeFieldTypeArr[i - 1].getRangeDurationType() == null) {
                        if (dateTimeFieldType.getRangeDurationType() == null) {
                            throw new IllegalArgumentException("Types array must not contain duplicate: " + dateTimeFieldType.getName());
                        }
                    } else if (dateTimeFieldType.getRangeDurationType() == null) {
                        throw new IllegalArgumentException("Types array must be in order largest-smallest: " + dateTimeFieldTypeArr[i - 1].getName() + " < " + dateTimeFieldType.getName());
                    } else {
                        DurationField field2 = dateTimeFieldTypeArr[i - 1].getRangeDurationType().getField(this.iChronology);
                        DurationField field3 = dateTimeFieldType.getRangeDurationType().getField(this.iChronology);
                        if (field2.compareTo(field3) < 0) {
                            throw new IllegalArgumentException("Types array must be in order largest-smallest: " + dateTimeFieldTypeArr[i - 1].getName() + " < " + dateTimeFieldType.getName());
                        } else if (field2.compareTo(field3) == 0) {
                            throw new IllegalArgumentException("Types array must not contain duplicate: " + dateTimeFieldType.getName());
                        }
                    }
                }
                i++;
                durationField = field;
            }
            this.iTypes = (DateTimeFieldType[]) dateTimeFieldTypeArr.clone();
            withUTC.validate(this, iArr);
            this.iValues = (int[]) iArr.clone();
        }
    }

    public Partial(ReadablePartial readablePartial) {
        if (readablePartial == null) {
            throw new IllegalArgumentException("The partial must not be null");
        }
        this.iChronology = DateTimeUtils.getChronology(readablePartial.getChronology()).withUTC();
        this.iTypes = new DateTimeFieldType[readablePartial.size()];
        this.iValues = new int[readablePartial.size()];
        for (int i = 0; i < readablePartial.size(); i++) {
            this.iTypes[i] = readablePartial.getFieldType(i);
            this.iValues[i] = readablePartial.getValue(i);
        }
    }

    Partial(Partial partial, int[] iArr) {
        this.iChronology = partial.iChronology;
        this.iTypes = partial.iTypes;
        this.iValues = iArr;
    }

    Partial(Chronology chronology, DateTimeFieldType[] dateTimeFieldTypeArr, int[] iArr) {
        this.iChronology = chronology;
        this.iTypes = dateTimeFieldTypeArr;
        this.iValues = iArr;
    }

    public int size() {
        return this.iTypes.length;
    }

    public Chronology getChronology() {
        return this.iChronology;
    }

    /* access modifiers changed from: protected */
    public DateTimeField getField(int i, Chronology chronology) {
        return this.iTypes[i].getField(chronology);
    }

    public DateTimeFieldType getFieldType(int i) {
        return this.iTypes[i];
    }

    public DateTimeFieldType[] getFieldTypes() {
        return (DateTimeFieldType[]) this.iTypes.clone();
    }

    public int getValue(int i) {
        return this.iValues[i];
    }

    public int[] getValues() {
        return (int[]) this.iValues.clone();
    }

    public Partial withChronologyRetainFields(Chronology chronology) {
        Chronology withUTC = DateTimeUtils.getChronology(chronology).withUTC();
        if (withUTC == getChronology()) {
            return this;
        }
        Partial partial = new Partial(withUTC, this.iTypes, this.iValues);
        withUTC.validate(partial, this.iValues);
        return partial;
    }

    public Partial with(DateTimeFieldType dateTimeFieldType, int i) {
        int i2;
        int compareTo;
        if (dateTimeFieldType == null) {
            throw new IllegalArgumentException("The field type must not be null");
        }
        int indexOf = indexOf(dateTimeFieldType);
        if (indexOf == -1) {
            DateTimeFieldType[] dateTimeFieldTypeArr = new DateTimeFieldType[(this.iTypes.length + 1)];
            int[] iArr = new int[dateTimeFieldTypeArr.length];
            DurationField field = dateTimeFieldType.getDurationType().getField(this.iChronology);
            if (field.isSupported()) {
                i2 = 0;
                while (i2 < this.iTypes.length) {
                    DateTimeFieldType dateTimeFieldType2 = this.iTypes[i2];
                    DurationField field2 = dateTimeFieldType2.getDurationType().getField(this.iChronology);
                    if (field2.isSupported() && ((compareTo = field.compareTo(field2)) > 0 || (compareTo == 0 && dateTimeFieldType.getRangeDurationType().getField(this.iChronology).compareTo(dateTimeFieldType2.getRangeDurationType().getField(this.iChronology)) > 0))) {
                        break;
                    }
                    i2++;
                }
            } else {
                i2 = 0;
            }
            System.arraycopy(this.iTypes, 0, dateTimeFieldTypeArr, 0, i2);
            System.arraycopy(this.iValues, 0, iArr, 0, i2);
            dateTimeFieldTypeArr[i2] = dateTimeFieldType;
            iArr[i2] = i;
            System.arraycopy(this.iTypes, i2, dateTimeFieldTypeArr, i2 + 1, (dateTimeFieldTypeArr.length - i2) - 1);
            System.arraycopy(this.iValues, i2, iArr, i2 + 1, (iArr.length - i2) - 1);
            Partial partial = new Partial(this.iChronology, dateTimeFieldTypeArr, iArr);
            this.iChronology.validate(partial, iArr);
            return partial;
        } else if (i == getValue(indexOf)) {
            return this;
        } else {
            return new Partial(this, getField(indexOf).set(this, indexOf, getValues(), i));
        }
    }

    public Partial without(DateTimeFieldType dateTimeFieldType) {
        int indexOf = indexOf(dateTimeFieldType);
        if (indexOf == -1) {
            return this;
        }
        DateTimeFieldType[] dateTimeFieldTypeArr = new DateTimeFieldType[(size() - 1)];
        int[] iArr = new int[(size() - 1)];
        System.arraycopy(this.iTypes, 0, dateTimeFieldTypeArr, 0, indexOf);
        System.arraycopy(this.iTypes, indexOf + 1, dateTimeFieldTypeArr, indexOf, dateTimeFieldTypeArr.length - indexOf);
        System.arraycopy(this.iValues, 0, iArr, 0, indexOf);
        System.arraycopy(this.iValues, indexOf + 1, iArr, indexOf, iArr.length - indexOf);
        Partial partial = new Partial(this.iChronology, dateTimeFieldTypeArr, iArr);
        this.iChronology.validate(partial, iArr);
        return partial;
    }

    public Partial withField(DateTimeFieldType dateTimeFieldType, int i) {
        int indexOfSupported = indexOfSupported(dateTimeFieldType);
        if (i == getValue(indexOfSupported)) {
            return this;
        }
        return new Partial(this, getField(indexOfSupported).set(this, indexOfSupported, getValues(), i));
    }

    public Partial withFieldAdded(DurationFieldType durationFieldType, int i) {
        int indexOfSupported = indexOfSupported(durationFieldType);
        if (i == 0) {
            return this;
        }
        return new Partial(this, getField(indexOfSupported).add(this, indexOfSupported, getValues(), i));
    }

    public Partial withFieldAddWrapped(DurationFieldType durationFieldType, int i) {
        int indexOfSupported = indexOfSupported(durationFieldType);
        if (i == 0) {
            return this;
        }
        return new Partial(this, getField(indexOfSupported).addWrapPartial(this, indexOfSupported, getValues(), i));
    }

    public Partial withPeriodAdded(ReadablePeriod readablePeriod, int i) {
        if (readablePeriod == null || i == 0) {
            return this;
        }
        int[] values = getValues();
        for (int i2 = 0; i2 < readablePeriod.size(); i2++) {
            int indexOf = indexOf(readablePeriod.getFieldType(i2));
            if (indexOf >= 0) {
                values = getField(indexOf).add(this, indexOf, values, FieldUtils.safeMultiply(readablePeriod.getValue(i2), i));
            }
        }
        return new Partial(this, values);
    }

    public Partial plus(ReadablePeriod readablePeriod) {
        return withPeriodAdded(readablePeriod, 1);
    }

    public Partial minus(ReadablePeriod readablePeriod) {
        return withPeriodAdded(readablePeriod, -1);
    }

    public Property property(DateTimeFieldType dateTimeFieldType) {
        return new Property(this, indexOfSupported(dateTimeFieldType));
    }

    public boolean isMatch(ReadableInstant readableInstant) {
        long instantMillis = DateTimeUtils.getInstantMillis(readableInstant);
        Chronology instantChronology = DateTimeUtils.getInstantChronology(readableInstant);
        for (int i = 0; i < this.iTypes.length; i++) {
            if (this.iTypes[i].getField(instantChronology).get(instantMillis) != this.iValues[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean isMatch(ReadablePartial readablePartial) {
        if (readablePartial == null) {
            throw new IllegalArgumentException("The partial must not be null");
        }
        for (int i = 0; i < this.iTypes.length; i++) {
            if (readablePartial.get(this.iTypes[i]) != this.iValues[i]) {
                return false;
            }
        }
        return true;
    }

    public DateTimeFormatter getFormatter() {
        DateTimeFormatter[] dateTimeFormatterArr = this.iFormatter;
        if (dateTimeFormatterArr == null) {
            if (size() == 0) {
                return null;
            }
            dateTimeFormatterArr = new DateTimeFormatter[2];
            try {
                ArrayList arrayList = new ArrayList(Arrays.asList(this.iTypes));
                dateTimeFormatterArr[0] = ISODateTimeFormat.forFields(arrayList, true, false);
                if (arrayList.size() == 0) {
                    dateTimeFormatterArr[1] = dateTimeFormatterArr[0];
                }
            } catch (IllegalArgumentException e) {
            }
            this.iFormatter = dateTimeFormatterArr;
        }
        return dateTimeFormatterArr[0];
    }

    public String toString() {
        DateTimeFormatter[] dateTimeFormatterArr = this.iFormatter;
        if (dateTimeFormatterArr == null) {
            getFormatter();
            dateTimeFormatterArr = this.iFormatter;
            if (dateTimeFormatterArr == null) {
                return toStringList();
            }
        }
        DateTimeFormatter dateTimeFormatter = dateTimeFormatterArr[1];
        if (dateTimeFormatter == null) {
            return toStringList();
        }
        return dateTimeFormatter.print((ReadablePartial) this);
    }

    public String toStringList() {
        int size = size();
        StringBuilder sb = new StringBuilder(size * 20);
        sb.append('[');
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append(',').append(' ');
            }
            sb.append(this.iTypes[i].getName());
            sb.append('=');
            sb.append(this.iValues[i]);
        }
        sb.append(']');
        return sb.toString();
    }

    public String toString(String str) {
        if (str == null) {
            return toString();
        }
        return DateTimeFormat.forPattern(str).print((ReadablePartial) this);
    }

    public String toString(String str, Locale locale) {
        if (str == null) {
            return toString();
        }
        return DateTimeFormat.forPattern(str).withLocale(locale).print((ReadablePartial) this);
    }

    public static class Property extends AbstractPartialFieldProperty implements Serializable {
        private static final long serialVersionUID = 53278362873888L;
        private final int iFieldIndex;
        private final Partial iPartial;

        Property(Partial partial, int i) {
            this.iPartial = partial;
            this.iFieldIndex = i;
        }

        public DateTimeField getField() {
            return this.iPartial.getField(this.iFieldIndex);
        }

        /* access modifiers changed from: protected */
        public ReadablePartial getReadablePartial() {
            return this.iPartial;
        }

        public Partial getPartial() {
            return this.iPartial;
        }

        public int get() {
            return this.iPartial.getValue(this.iFieldIndex);
        }

        public Partial addToCopy(int i) {
            return new Partial(this.iPartial, getField().add(this.iPartial, this.iFieldIndex, this.iPartial.getValues(), i));
        }

        public Partial addWrapFieldToCopy(int i) {
            return new Partial(this.iPartial, getField().addWrapField(this.iPartial, this.iFieldIndex, this.iPartial.getValues(), i));
        }

        public Partial setCopy(int i) {
            return new Partial(this.iPartial, getField().set(this.iPartial, this.iFieldIndex, this.iPartial.getValues(), i));
        }

        public Partial setCopy(String str, Locale locale) {
            return new Partial(this.iPartial, getField().set(this.iPartial, this.iFieldIndex, this.iPartial.getValues(), str, locale));
        }

        public Partial setCopy(String str) {
            return setCopy(str, (Locale) null);
        }

        public Partial withMaximumValue() {
            return setCopy(getMaximumValue());
        }

        public Partial withMinimumValue() {
            return setCopy(getMinimumValue());
        }
    }
}
