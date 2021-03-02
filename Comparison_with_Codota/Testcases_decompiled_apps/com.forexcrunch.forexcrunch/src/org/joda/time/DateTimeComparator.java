package org.joda.time;

import com.parse.ParseException;
import java.io.Serializable;
import java.util.Comparator;
import org.joda.time.convert.ConverterManager;
import org.joda.time.convert.InstantConverter;

public class DateTimeComparator implements Comparator<Object>, Serializable {
    private static final DateTimeComparator ALL_INSTANCE = new DateTimeComparator((DateTimeFieldType) null, (DateTimeFieldType) null);
    private static final DateTimeComparator DATE_INSTANCE = new DateTimeComparator(DateTimeFieldType.dayOfYear(), (DateTimeFieldType) null);
    private static final DateTimeComparator TIME_INSTANCE = new DateTimeComparator((DateTimeFieldType) null, DateTimeFieldType.dayOfYear());
    private static final long serialVersionUID = -6097339773320178364L;
    private final DateTimeFieldType iLowerLimit;
    private final DateTimeFieldType iUpperLimit;

    public static DateTimeComparator getInstance() {
        return ALL_INSTANCE;
    }

    public static DateTimeComparator getInstance(DateTimeFieldType dateTimeFieldType) {
        return getInstance(dateTimeFieldType, (DateTimeFieldType) null);
    }

    public static DateTimeComparator getInstance(DateTimeFieldType dateTimeFieldType, DateTimeFieldType dateTimeFieldType2) {
        if (dateTimeFieldType == null && dateTimeFieldType2 == null) {
            return ALL_INSTANCE;
        }
        if (dateTimeFieldType == DateTimeFieldType.dayOfYear() && dateTimeFieldType2 == null) {
            return DATE_INSTANCE;
        }
        if (dateTimeFieldType == null && dateTimeFieldType2 == DateTimeFieldType.dayOfYear()) {
            return TIME_INSTANCE;
        }
        return new DateTimeComparator(dateTimeFieldType, dateTimeFieldType2);
    }

    public static DateTimeComparator getDateOnlyInstance() {
        return DATE_INSTANCE;
    }

    public static DateTimeComparator getTimeOnlyInstance() {
        return TIME_INSTANCE;
    }

    protected DateTimeComparator(DateTimeFieldType dateTimeFieldType, DateTimeFieldType dateTimeFieldType2) {
        this.iLowerLimit = dateTimeFieldType;
        this.iUpperLimit = dateTimeFieldType2;
    }

    public DateTimeFieldType getLowerLimit() {
        return this.iLowerLimit;
    }

    public DateTimeFieldType getUpperLimit() {
        return this.iUpperLimit;
    }

    public int compare(Object obj, Object obj2) {
        InstantConverter instantConverter = ConverterManager.getInstance().getInstantConverter(obj);
        Chronology chronology = instantConverter.getChronology(obj, (Chronology) null);
        long instantMillis = instantConverter.getInstantMillis(obj, chronology);
        InstantConverter instantConverter2 = ConverterManager.getInstance().getInstantConverter(obj2);
        Chronology chronology2 = instantConverter2.getChronology(obj2, (Chronology) null);
        long instantMillis2 = instantConverter2.getInstantMillis(obj2, chronology2);
        if (this.iLowerLimit != null) {
            instantMillis = this.iLowerLimit.getField(chronology).roundFloor(instantMillis);
            instantMillis2 = this.iLowerLimit.getField(chronology2).roundFloor(instantMillis2);
        }
        if (this.iUpperLimit != null) {
            instantMillis = this.iUpperLimit.getField(chronology).remainder(instantMillis);
            instantMillis2 = this.iUpperLimit.getField(chronology2).remainder(instantMillis2);
        }
        if (instantMillis < instantMillis2) {
            return -1;
        }
        if (instantMillis > instantMillis2) {
            return 1;
        }
        return 0;
    }

    private Object readResolve() {
        return getInstance(this.iLowerLimit, this.iUpperLimit);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DateTimeComparator)) {
            return false;
        }
        DateTimeComparator dateTimeComparator = (DateTimeComparator) obj;
        if (this.iLowerLimit != dateTimeComparator.getLowerLimit() && (this.iLowerLimit == null || !this.iLowerLimit.equals(dateTimeComparator.getLowerLimit()))) {
            return false;
        }
        if (this.iUpperLimit == dateTimeComparator.getUpperLimit() || (this.iUpperLimit != null && this.iUpperLimit.equals(dateTimeComparator.getUpperLimit()))) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = this.iLowerLimit == null ? 0 : this.iLowerLimit.hashCode();
        if (this.iUpperLimit != null) {
            i = this.iUpperLimit.hashCode();
        }
        return hashCode + (i * ParseException.INVALID_ACL);
    }

    public String toString() {
        if (this.iLowerLimit == this.iUpperLimit) {
            return "DateTimeComparator[" + (this.iLowerLimit == null ? "" : this.iLowerLimit.getName()) + "]";
        }
        return "DateTimeComparator[" + (this.iLowerLimit == null ? "" : this.iLowerLimit.getName()) + "-" + (this.iUpperLimit == null ? "" : this.iUpperLimit.getName()) + "]";
    }
}
