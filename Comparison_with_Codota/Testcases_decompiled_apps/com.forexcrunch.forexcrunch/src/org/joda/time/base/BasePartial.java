package org.joda.time.base;

import java.io.Serializable;
import java.util.Locale;
import org.joda.time.Chronology;
import org.joda.time.DateTimeUtils;
import org.joda.time.ReadablePartial;
import org.joda.time.convert.ConverterManager;
import org.joda.time.convert.PartialConverter;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public abstract class BasePartial extends AbstractPartial implements ReadablePartial, Serializable {
    private static final long serialVersionUID = 2353678632973660L;
    private final Chronology iChronology;
    private final int[] iValues;

    protected BasePartial() {
        this(DateTimeUtils.currentTimeMillis(), (Chronology) null);
    }

    protected BasePartial(Chronology chronology) {
        this(DateTimeUtils.currentTimeMillis(), chronology);
    }

    protected BasePartial(long j) {
        this(j, (Chronology) null);
    }

    protected BasePartial(long j, Chronology chronology) {
        Chronology chronology2 = DateTimeUtils.getChronology(chronology);
        this.iChronology = chronology2.withUTC();
        this.iValues = chronology2.get((ReadablePartial) this, j);
    }

    protected BasePartial(Object obj, Chronology chronology) {
        PartialConverter partialConverter = ConverterManager.getInstance().getPartialConverter(obj);
        Chronology chronology2 = DateTimeUtils.getChronology(partialConverter.getChronology(obj, chronology));
        this.iChronology = chronology2.withUTC();
        this.iValues = partialConverter.getPartialValues(this, obj, chronology2);
    }

    protected BasePartial(Object obj, Chronology chronology, DateTimeFormatter dateTimeFormatter) {
        PartialConverter partialConverter = ConverterManager.getInstance().getPartialConverter(obj);
        Chronology chronology2 = DateTimeUtils.getChronology(partialConverter.getChronology(obj, chronology));
        this.iChronology = chronology2.withUTC();
        this.iValues = partialConverter.getPartialValues(this, obj, chronology2, dateTimeFormatter);
    }

    protected BasePartial(int[] iArr, Chronology chronology) {
        Chronology chronology2 = DateTimeUtils.getChronology(chronology);
        this.iChronology = chronology2.withUTC();
        chronology2.validate(this, iArr);
        this.iValues = iArr;
    }

    protected BasePartial(BasePartial basePartial, int[] iArr) {
        this.iChronology = basePartial.iChronology;
        this.iValues = iArr;
    }

    protected BasePartial(BasePartial basePartial, Chronology chronology) {
        this.iChronology = chronology.withUTC();
        this.iValues = basePartial.iValues;
    }

    public int getValue(int i) {
        return this.iValues[i];
    }

    public int[] getValues() {
        return (int[]) this.iValues.clone();
    }

    public Chronology getChronology() {
        return this.iChronology;
    }

    /* access modifiers changed from: protected */
    public void setValue(int i, int i2) {
        System.arraycopy(getField(i).set(this, i, this.iValues, i2), 0, this.iValues, 0, this.iValues.length);
    }

    /* access modifiers changed from: protected */
    public void setValues(int[] iArr) {
        getChronology().validate(this, iArr);
        System.arraycopy(iArr, 0, this.iValues, 0, this.iValues.length);
    }

    public String toString(String str) {
        if (str == null) {
            return toString();
        }
        return DateTimeFormat.forPattern(str).print((ReadablePartial) this);
    }

    public String toString(String str, Locale locale) throws IllegalArgumentException {
        if (str == null) {
            return toString();
        }
        return DateTimeFormat.forPattern(str).withLocale(locale).print((ReadablePartial) this);
    }
}
