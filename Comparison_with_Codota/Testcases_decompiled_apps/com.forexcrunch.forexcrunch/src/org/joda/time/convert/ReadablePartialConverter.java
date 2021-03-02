package org.joda.time.convert;

import org.joda.time.Chronology;
import org.joda.time.DateTimeUtils;
import org.joda.time.DateTimeZone;
import org.joda.time.ReadablePartial;

class ReadablePartialConverter extends AbstractConverter implements PartialConverter {
    static final ReadablePartialConverter INSTANCE = new ReadablePartialConverter();

    protected ReadablePartialConverter() {
    }

    public Chronology getChronology(Object obj, DateTimeZone dateTimeZone) {
        return getChronology(obj, (Chronology) null).withZone(dateTimeZone);
    }

    public Chronology getChronology(Object obj, Chronology chronology) {
        if (chronology == null) {
            return DateTimeUtils.getChronology(((ReadablePartial) obj).getChronology());
        }
        return chronology;
    }

    public int[] getPartialValues(ReadablePartial readablePartial, Object obj, Chronology chronology) {
        ReadablePartial readablePartial2 = (ReadablePartial) obj;
        int size = readablePartial.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = readablePartial2.get(readablePartial.getFieldType(i));
        }
        chronology.validate(readablePartial, iArr);
        return iArr;
    }

    public Class<?> getSupportedType() {
        return ReadablePartial.class;
    }
}
