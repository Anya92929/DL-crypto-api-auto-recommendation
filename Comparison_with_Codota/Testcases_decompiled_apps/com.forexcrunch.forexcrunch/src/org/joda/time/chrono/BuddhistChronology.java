package org.joda.time.chrono;

import com.forexcrunch.forexcrunch.gui.utils.Constants;
import java.util.HashMap;
import java.util.Map;
import org.joda.time.Chronology;
import org.joda.time.DateTime;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeZone;
import org.joda.time.ReadableDateTime;
import org.joda.time.ReadableInstant;
import org.joda.time.chrono.AssembledChronology;
import org.joda.time.field.DelegatedDateTimeField;
import org.joda.time.field.DividedDateTimeField;
import org.joda.time.field.OffsetDateTimeField;
import org.joda.time.field.RemainderDateTimeField;
import org.joda.time.field.SkipUndoDateTimeField;

public final class BuddhistChronology extends AssembledChronology {

    /* renamed from: BE */
    public static final int f1777BE = 1;
    private static final int BUDDHIST_OFFSET = 543;
    private static final DateTimeField ERA_FIELD = new BasicSingleEraDateTimeField(Constants.BELGIUM);
    private static final BuddhistChronology INSTANCE_UTC = getInstance(DateTimeZone.UTC);
    private static final Map<DateTimeZone, BuddhistChronology> cCache = new HashMap();
    private static final long serialVersionUID = -3474595157769370126L;

    public static BuddhistChronology getInstanceUTC() {
        return INSTANCE_UTC;
    }

    public static BuddhistChronology getInstance() {
        return getInstance(DateTimeZone.getDefault());
    }

    public static synchronized BuddhistChronology getInstance(DateTimeZone dateTimeZone) {
        BuddhistChronology buddhistChronology;
        synchronized (BuddhistChronology.class) {
            if (dateTimeZone == null) {
                dateTimeZone = DateTimeZone.getDefault();
            }
            buddhistChronology = cCache.get(dateTimeZone);
            if (buddhistChronology == null) {
                BuddhistChronology buddhistChronology2 = new BuddhistChronology(GJChronology.getInstance(dateTimeZone, (ReadableInstant) null), (Object) null);
                BuddhistChronology buddhistChronology3 = new BuddhistChronology(LimitChronology.getInstance(buddhistChronology2, new DateTime(1, 1, 1, 0, 0, 0, 0, (Chronology) buddhistChronology2), (ReadableDateTime) null), "");
                cCache.put(dateTimeZone, buddhistChronology3);
                buddhistChronology = buddhistChronology3;
            }
        }
        return buddhistChronology;
    }

    private BuddhistChronology(Chronology chronology, Object obj) {
        super(chronology, obj);
    }

    private Object readResolve() {
        Chronology base = getBase();
        return base == null ? getInstanceUTC() : getInstance(base.getZone());
    }

    public Chronology withUTC() {
        return INSTANCE_UTC;
    }

    public Chronology withZone(DateTimeZone dateTimeZone) {
        if (dateTimeZone == null) {
            dateTimeZone = DateTimeZone.getDefault();
        }
        return dateTimeZone == getZone() ? this : getInstance(dateTimeZone);
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public int hashCode() {
        return ("Buddhist".hashCode() * 11) + getZone().hashCode();
    }

    public String toString() {
        DateTimeZone zone = getZone();
        if (zone != null) {
            return "BuddhistChronology" + '[' + zone.getID() + ']';
        }
        return "BuddhistChronology";
    }

    /* access modifiers changed from: protected */
    public void assemble(AssembledChronology.Fields fields) {
        if (getParam() == null) {
            fields.year = new OffsetDateTimeField(new SkipUndoDateTimeField(this, fields.year), BUDDHIST_OFFSET);
            DateTimeField dateTimeField = fields.yearOfEra;
            fields.yearOfEra = new DelegatedDateTimeField(fields.year, DateTimeFieldType.yearOfEra());
            fields.weekyear = new OffsetDateTimeField(new SkipUndoDateTimeField(this, fields.weekyear), BUDDHIST_OFFSET);
            fields.centuryOfEra = new DividedDateTimeField(new OffsetDateTimeField(fields.yearOfEra, 99), DateTimeFieldType.centuryOfEra(), 100);
            fields.yearOfCentury = new OffsetDateTimeField(new RemainderDateTimeField((DividedDateTimeField) fields.centuryOfEra), DateTimeFieldType.yearOfCentury(), 1);
            fields.weekyearOfCentury = new OffsetDateTimeField(new RemainderDateTimeField(fields.weekyear, DateTimeFieldType.weekyearOfCentury(), 100), DateTimeFieldType.weekyearOfCentury(), 1);
            fields.era = ERA_FIELD;
        }
    }
}
