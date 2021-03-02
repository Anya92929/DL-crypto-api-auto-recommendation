package org.joda.time.chrono;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import org.joda.time.Chronology;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeZone;
import org.joda.time.chrono.AssembledChronology;
import org.joda.time.field.DividedDateTimeField;
import org.joda.time.field.RemainderDateTimeField;

public final class ISOChronology extends AssembledChronology {
    private static final int FAST_CACHE_SIZE = 64;
    private static final ISOChronology INSTANCE_UTC = new ISOChronology(GregorianChronology.getInstanceUTC());
    private static final Map<DateTimeZone, ISOChronology> cCache = new HashMap();
    private static final ISOChronology[] cFastCache = new ISOChronology[64];
    private static final long serialVersionUID = -6212696554273812441L;

    static {
        cCache.put(DateTimeZone.UTC, INSTANCE_UTC);
    }

    public static ISOChronology getInstanceUTC() {
        return INSTANCE_UTC;
    }

    public static ISOChronology getInstance() {
        return getInstance(DateTimeZone.getDefault());
    }

    public static ISOChronology getInstance(DateTimeZone dateTimeZone) {
        if (dateTimeZone == null) {
            dateTimeZone = DateTimeZone.getDefault();
        }
        int identityHashCode = System.identityHashCode(dateTimeZone) & 63;
        ISOChronology iSOChronology = cFastCache[identityHashCode];
        if (iSOChronology == null || iSOChronology.getZone() != dateTimeZone) {
            synchronized (cCache) {
                iSOChronology = cCache.get(dateTimeZone);
                if (iSOChronology == null) {
                    iSOChronology = new ISOChronology(ZonedChronology.getInstance(INSTANCE_UTC, dateTimeZone));
                    cCache.put(dateTimeZone, iSOChronology);
                }
            }
            cFastCache[identityHashCode] = iSOChronology;
        }
        return iSOChronology;
    }

    private ISOChronology(Chronology chronology) {
        super(chronology, (Object) null);
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

    public String toString() {
        DateTimeZone zone = getZone();
        if (zone != null) {
            return "ISOChronology" + '[' + zone.getID() + ']';
        }
        return "ISOChronology";
    }

    /* access modifiers changed from: protected */
    public void assemble(AssembledChronology.Fields fields) {
        if (getBase().getZone() == DateTimeZone.UTC) {
            fields.centuryOfEra = new DividedDateTimeField(ISOYearOfEraDateTimeField.INSTANCE, DateTimeFieldType.centuryOfEra(), 100);
            fields.yearOfCentury = new RemainderDateTimeField((DividedDateTimeField) fields.centuryOfEra, DateTimeFieldType.yearOfCentury());
            fields.weekyearOfCentury = new RemainderDateTimeField((DividedDateTimeField) fields.centuryOfEra, DateTimeFieldType.weekyearOfCentury());
            fields.centuries = fields.centuryOfEra.getDurationField();
        }
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public int hashCode() {
        return ("ISO".hashCode() * 11) + getZone().hashCode();
    }

    private Object writeReplace() {
        return new Stub(getZone());
    }

    private static final class Stub implements Serializable {
        private static final long serialVersionUID = -6212696554273812441L;
        private transient DateTimeZone iZone;

        Stub(DateTimeZone dateTimeZone) {
            this.iZone = dateTimeZone;
        }

        private Object readResolve() {
            return ISOChronology.getInstance(this.iZone);
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.writeObject(this.iZone);
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            this.iZone = (DateTimeZone) objectInputStream.readObject();
        }
    }
}
