package org.joda.time.p007tz;

import org.joda.time.DateTimeZone;

/* renamed from: org.joda.time.tz.CachedDateTimeZone */
public class CachedDateTimeZone extends DateTimeZone {
    private static final int cInfoCacheMask;
    private static final long serialVersionUID = 5472298452022250685L;
    private final Info[] iInfoCache = new Info[(cInfoCacheMask + 1)];
    private final DateTimeZone iZone;

    static {
        Integer num;
        int i;
        try {
            num = Integer.getInteger("org.joda.time.tz.CachedDateTimeZone.size");
        } catch (SecurityException e) {
            num = null;
        }
        if (num == null) {
            i = 512;
        } else {
            int i2 = 0;
            for (int intValue = num.intValue() - 1; intValue > 0; intValue >>= 1) {
                i2++;
            }
            i = 1 << i2;
        }
        cInfoCacheMask = i - 1;
    }

    public static CachedDateTimeZone forZone(DateTimeZone dateTimeZone) {
        if (dateTimeZone instanceof CachedDateTimeZone) {
            return (CachedDateTimeZone) dateTimeZone;
        }
        return new CachedDateTimeZone(dateTimeZone);
    }

    private CachedDateTimeZone(DateTimeZone dateTimeZone) {
        super(dateTimeZone.getID());
        this.iZone = dateTimeZone;
    }

    public DateTimeZone getUncachedZone() {
        return this.iZone;
    }

    public String getNameKey(long j) {
        return getInfo(j).getNameKey(j);
    }

    public int getOffset(long j) {
        return getInfo(j).getOffset(j);
    }

    public int getStandardOffset(long j) {
        return getInfo(j).getStandardOffset(j);
    }

    public boolean isFixed() {
        return this.iZone.isFixed();
    }

    public long nextTransition(long j) {
        return this.iZone.nextTransition(j);
    }

    public long previousTransition(long j) {
        return this.iZone.previousTransition(j);
    }

    public int hashCode() {
        return this.iZone.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CachedDateTimeZone) {
            return this.iZone.equals(((CachedDateTimeZone) obj).iZone);
        }
        return false;
    }

    private Info getInfo(long j) {
        int i = (int) (j >> 32);
        Info[] infoArr = this.iInfoCache;
        int i2 = i & cInfoCacheMask;
        Info info = infoArr[i2];
        if (info != null && ((int) (info.iPeriodStart >> 32)) == i) {
            return info;
        }
        Info createInfo = createInfo(j);
        infoArr[i2] = createInfo;
        return createInfo;
    }

    private Info createInfo(long j) {
        long j2 = j & -4294967296L;
        Info info = new Info(this.iZone, j2);
        long j3 = j2 | 4294967295L;
        Info info2 = info;
        while (true) {
            long nextTransition = this.iZone.nextTransition(j2);
            if (nextTransition == j2 || nextTransition > j3) {
                return info;
            }
            Info info3 = new Info(this.iZone, nextTransition);
            info2.iNextInfo = info3;
            info2 = info3;
            j2 = nextTransition;
        }
        return info;
    }

    /* renamed from: org.joda.time.tz.CachedDateTimeZone$Info */
    private static final class Info {
        private String iNameKey;
        Info iNextInfo;
        private int iOffset = Integer.MIN_VALUE;
        public final long iPeriodStart;
        private int iStandardOffset = Integer.MIN_VALUE;
        public final DateTimeZone iZoneRef;

        Info(DateTimeZone dateTimeZone, long j) {
            this.iPeriodStart = j;
            this.iZoneRef = dateTimeZone;
        }

        public String getNameKey(long j) {
            if (this.iNextInfo != null && j >= this.iNextInfo.iPeriodStart) {
                return this.iNextInfo.getNameKey(j);
            }
            if (this.iNameKey == null) {
                this.iNameKey = this.iZoneRef.getNameKey(this.iPeriodStart);
            }
            return this.iNameKey;
        }

        public int getOffset(long j) {
            if (this.iNextInfo != null && j >= this.iNextInfo.iPeriodStart) {
                return this.iNextInfo.getOffset(j);
            }
            if (this.iOffset == Integer.MIN_VALUE) {
                this.iOffset = this.iZoneRef.getOffset(this.iPeriodStart);
            }
            return this.iOffset;
        }

        public int getStandardOffset(long j) {
            if (this.iNextInfo != null && j >= this.iNextInfo.iPeriodStart) {
                return this.iNextInfo.getStandardOffset(j);
            }
            if (this.iStandardOffset == Integer.MIN_VALUE) {
                this.iStandardOffset = this.iZoneRef.getStandardOffset(this.iPeriodStart);
            }
            return this.iStandardOffset;
        }
    }
}
