package org.joda.time.p007tz;

import android.support.p000v4.view.MotionEventCompat;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import org.joda.time.Chronology;
import org.joda.time.DateTime;
import org.joda.time.DateTimeUtils;
import org.joda.time.DateTimeZone;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.joda.time.chrono.ISOChronology;

/* renamed from: org.joda.time.tz.DateTimeZoneBuilder */
public class DateTimeZoneBuilder {
    private final ArrayList<RuleSet> iRuleSets = new ArrayList<>(10);

    public static DateTimeZone readFrom(InputStream inputStream, String str) throws IOException {
        if (inputStream instanceof DataInput) {
            return readFrom((DataInput) inputStream, str);
        }
        return readFrom((DataInput) new DataInputStream(inputStream), str);
    }

    public static DateTimeZone readFrom(DataInput dataInput, String str) throws IOException {
        switch (dataInput.readUnsignedByte()) {
            case 67:
                return CachedDateTimeZone.forZone(PrecalculatedZone.readFrom(dataInput, str));
            case 70:
                FixedDateTimeZone fixedDateTimeZone = new FixedDateTimeZone(str, dataInput.readUTF(), (int) readMillis(dataInput), (int) readMillis(dataInput));
                if (fixedDateTimeZone.equals(DateTimeZone.UTC)) {
                    return DateTimeZone.UTC;
                }
                return fixedDateTimeZone;
            case 80:
                return PrecalculatedZone.readFrom(dataInput, str);
            default:
                throw new IOException("Invalid encoding");
        }
    }

    static void writeMillis(DataOutput dataOutput, long j) throws IOException {
        if (j % 1800000 == 0) {
            long j2 = j / 1800000;
            if (((j2 << 58) >> 58) == j2) {
                dataOutput.writeByte((int) (j2 & 63));
                return;
            }
        }
        if (j % 60000 == 0) {
            long j3 = j / 60000;
            if (((j3 << 34) >> 34) == j3) {
                dataOutput.writeInt(((int) (j3 & 1073741823)) | 1073741824);
                return;
            }
        }
        if (j % 1000 == 0) {
            long j4 = j / 1000;
            if (((j4 << 26) >> 26) == j4) {
                dataOutput.writeByte(((int) ((j4 >> 32) & 63)) | 128);
                dataOutput.writeInt((int) (j4 & -1));
                return;
            }
        }
        dataOutput.writeByte(j < 0 ? MotionEventCompat.ACTION_MASK : 192);
        dataOutput.writeLong(j);
    }

    static long readMillis(DataInput dataInput) throws IOException {
        int readUnsignedByte = dataInput.readUnsignedByte();
        switch (readUnsignedByte >> 6) {
            case 1:
                return ((long) (((readUnsignedByte << 26) >> 2) | (dataInput.readUnsignedByte() << 16) | (dataInput.readUnsignedByte() << 8) | dataInput.readUnsignedByte())) * 60000;
            case 2:
                return (((((long) readUnsignedByte) << 58) >> 26) | ((long) (dataInput.readUnsignedByte() << 24)) | ((long) (dataInput.readUnsignedByte() << 16)) | ((long) (dataInput.readUnsignedByte() << 8)) | ((long) dataInput.readUnsignedByte())) * 1000;
            case 3:
                return dataInput.readLong();
            default:
                return ((long) ((readUnsignedByte << 26) >> 26)) * 1800000;
        }
    }

    private static DateTimeZone buildFixedZone(String str, String str2, int i, int i2) {
        if (!"UTC".equals(str) || !str.equals(str2) || i != 0 || i2 != 0) {
            return new FixedDateTimeZone(str, str2, i, i2);
        }
        return DateTimeZone.UTC;
    }

    public DateTimeZoneBuilder addCutover(int i, char c, int i2, int i3, int i4, boolean z, int i5) {
        if (this.iRuleSets.size() > 0) {
            this.iRuleSets.get(this.iRuleSets.size() - 1).setUpperLimit(i, new OfYear(c, i2, i3, i4, z, i5));
        }
        this.iRuleSets.add(new RuleSet());
        return this;
    }

    public DateTimeZoneBuilder setStandardOffset(int i) {
        getLastRuleSet().setStandardOffset(i);
        return this;
    }

    public DateTimeZoneBuilder setFixedSavings(String str, int i) {
        getLastRuleSet().setFixedSavings(str, i);
        return this;
    }

    public DateTimeZoneBuilder addRecurringSavings(String str, int i, int i2, int i3, char c, int i4, int i5, int i6, boolean z, int i7) {
        if (i2 <= i3) {
            getLastRuleSet().addRule(new Rule(new Recurrence(new OfYear(c, i4, i5, i6, z, i7), str, i), i2, i3));
        }
        return this;
    }

    private RuleSet getLastRuleSet() {
        if (this.iRuleSets.size() == 0) {
            addCutover(Integer.MIN_VALUE, 'w', 1, 1, 0, false, 0);
        }
        return this.iRuleSets.get(this.iRuleSets.size() - 1);
    }

    public DateTimeZone toDateTimeZone(String str, boolean z) {
        long upperLimit;
        if (str == null) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList();
        DSTZone dSTZone = null;
        long j = Long.MIN_VALUE;
        int size = this.iRuleSets.size();
        int i = 0;
        while (i < size) {
            RuleSet ruleSet = this.iRuleSets.get(i);
            Transition firstTransition = ruleSet.firstTransition(j);
            if (firstTransition == null) {
                upperLimit = j;
            } else {
                addTransition(arrayList, firstTransition);
                long millis = firstTransition.getMillis();
                int saveMillis = firstTransition.getSaveMillis();
                RuleSet ruleSet2 = new RuleSet(ruleSet);
                int i2 = saveMillis;
                long j2 = millis;
                DSTZone dSTZone2 = dSTZone;
                while (true) {
                    Transition nextTransition = ruleSet2.nextTransition(j2, i2);
                    if (nextTransition == null || (addTransition(arrayList, nextTransition) && dSTZone2 != null)) {
                        upperLimit = ruleSet2.getUpperLimit(i2);
                        dSTZone = dSTZone2;
                    } else {
                        j2 = nextTransition.getMillis();
                        i2 = nextTransition.getSaveMillis();
                        if (dSTZone2 == null && i == size - 1) {
                            dSTZone2 = ruleSet2.buildTailZone(str);
                        }
                    }
                }
                upperLimit = ruleSet2.getUpperLimit(i2);
                dSTZone = dSTZone2;
            }
            i++;
            j = upperLimit;
        }
        if (arrayList.size() == 0) {
            if (dSTZone != null) {
                return dSTZone;
            }
            return buildFixedZone(str, "UTC", 0, 0);
        } else if (arrayList.size() == 1 && dSTZone == null) {
            Transition transition = (Transition) arrayList.get(0);
            return buildFixedZone(str, transition.getNameKey(), transition.getWallOffset(), transition.getStandardOffset());
        } else {
            PrecalculatedZone create = PrecalculatedZone.create(str, z, arrayList, dSTZone);
            if (create.isCachable()) {
                return CachedDateTimeZone.forZone(create);
            }
            return create;
        }
    }

    private boolean addTransition(ArrayList<Transition> arrayList, Transition transition) {
        int i = 0;
        int size = arrayList.size();
        if (size == 0) {
            arrayList.add(transition);
            return true;
        }
        Transition transition2 = arrayList.get(size - 1);
        if (!transition.isTransitionFrom(transition2)) {
            return false;
        }
        if (size >= 2) {
            i = arrayList.get(size - 2).getWallOffset();
        }
        int wallOffset = transition2.getWallOffset();
        if (transition.getMillis() + ((long) wallOffset) != ((long) i) + transition2.getMillis()) {
            arrayList.add(transition);
            return true;
        }
        arrayList.remove(size - 1);
        return addTransition(arrayList, transition);
    }

    public void writeTo(String str, OutputStream outputStream) throws IOException {
        if (outputStream instanceof DataOutput) {
            writeTo(str, (DataOutput) outputStream);
        } else {
            writeTo(str, (DataOutput) new DataOutputStream(outputStream));
        }
    }

    public void writeTo(String str, DataOutput dataOutput) throws IOException {
        DateTimeZone dateTimeZone = toDateTimeZone(str, false);
        if (dateTimeZone instanceof FixedDateTimeZone) {
            dataOutput.writeByte(70);
            dataOutput.writeUTF(dateTimeZone.getNameKey(0));
            writeMillis(dataOutput, (long) dateTimeZone.getOffset(0));
            writeMillis(dataOutput, (long) dateTimeZone.getStandardOffset(0));
            return;
        }
        if (dateTimeZone instanceof CachedDateTimeZone) {
            dataOutput.writeByte(67);
            dateTimeZone = ((CachedDateTimeZone) dateTimeZone).getUncachedZone();
        } else {
            dataOutput.writeByte(80);
        }
        ((PrecalculatedZone) dateTimeZone).writeTo(dataOutput);
    }

    /* renamed from: org.joda.time.tz.DateTimeZoneBuilder$OfYear */
    private static final class OfYear {
        final boolean iAdvance;
        final int iDayOfMonth;
        final int iDayOfWeek;
        final int iMillisOfDay;
        final char iMode;
        final int iMonthOfYear;

        static OfYear readFrom(DataInput dataInput) throws IOException {
            return new OfYear((char) dataInput.readUnsignedByte(), dataInput.readUnsignedByte(), dataInput.readByte(), dataInput.readUnsignedByte(), dataInput.readBoolean(), (int) DateTimeZoneBuilder.readMillis(dataInput));
        }

        OfYear(char c, int i, int i2, int i3, boolean z, int i4) {
            if (c == 'u' || c == 'w' || c == 's') {
                this.iMode = c;
                this.iMonthOfYear = i;
                this.iDayOfMonth = i2;
                this.iDayOfWeek = i3;
                this.iAdvance = z;
                this.iMillisOfDay = i4;
                return;
            }
            throw new IllegalArgumentException("Unknown mode: " + c);
        }

        public long setInstant(int i, int i2, int i3) {
            if (this.iMode == 'w') {
                i2 += i3;
            } else if (this.iMode != 's') {
                i2 = 0;
            }
            ISOChronology instanceUTC = ISOChronology.getInstanceUTC();
            long dayOfMonth = setDayOfMonth(instanceUTC, instanceUTC.millisOfDay().set(instanceUTC.monthOfYear().set(instanceUTC.year().set(0, i), this.iMonthOfYear), this.iMillisOfDay));
            if (this.iDayOfWeek != 0) {
                dayOfMonth = setDayOfWeek(instanceUTC, dayOfMonth);
            }
            return dayOfMonth - ((long) i2);
        }

        public long next(long j, int i, int i2) {
            if (this.iMode == 'w') {
                i += i2;
            } else if (this.iMode != 's') {
                i = 0;
            }
            long j2 = j + ((long) i);
            ISOChronology instanceUTC = ISOChronology.getInstanceUTC();
            long dayOfMonthNext = setDayOfMonthNext(instanceUTC, instanceUTC.millisOfDay().add(instanceUTC.millisOfDay().set(instanceUTC.monthOfYear().set(j2, this.iMonthOfYear), 0), this.iMillisOfDay));
            if (this.iDayOfWeek != 0) {
                dayOfMonthNext = setDayOfWeek(instanceUTC, dayOfMonthNext);
                if (dayOfMonthNext <= j2) {
                    dayOfMonthNext = setDayOfWeek(instanceUTC, setDayOfMonthNext(instanceUTC, instanceUTC.monthOfYear().set(instanceUTC.year().add(dayOfMonthNext, 1), this.iMonthOfYear)));
                }
            } else if (dayOfMonthNext <= j2) {
                dayOfMonthNext = setDayOfMonthNext(instanceUTC, instanceUTC.year().add(dayOfMonthNext, 1));
            }
            return dayOfMonthNext - ((long) i);
        }

        public long previous(long j, int i, int i2) {
            if (this.iMode == 'w') {
                i += i2;
            } else if (this.iMode != 's') {
                i = 0;
            }
            long j2 = j + ((long) i);
            ISOChronology instanceUTC = ISOChronology.getInstanceUTC();
            long dayOfMonthPrevious = setDayOfMonthPrevious(instanceUTC, instanceUTC.millisOfDay().add(instanceUTC.millisOfDay().set(instanceUTC.monthOfYear().set(j2, this.iMonthOfYear), 0), this.iMillisOfDay));
            if (this.iDayOfWeek != 0) {
                dayOfMonthPrevious = setDayOfWeek(instanceUTC, dayOfMonthPrevious);
                if (dayOfMonthPrevious >= j2) {
                    dayOfMonthPrevious = setDayOfWeek(instanceUTC, setDayOfMonthPrevious(instanceUTC, instanceUTC.monthOfYear().set(instanceUTC.year().add(dayOfMonthPrevious, -1), this.iMonthOfYear)));
                }
            } else if (dayOfMonthPrevious >= j2) {
                dayOfMonthPrevious = setDayOfMonthPrevious(instanceUTC, instanceUTC.year().add(dayOfMonthPrevious, -1));
            }
            return dayOfMonthPrevious - ((long) i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OfYear)) {
                return false;
            }
            OfYear ofYear = (OfYear) obj;
            if (this.iMode == ofYear.iMode && this.iMonthOfYear == ofYear.iMonthOfYear && this.iDayOfMonth == ofYear.iDayOfMonth && this.iDayOfWeek == ofYear.iDayOfWeek && this.iAdvance == ofYear.iAdvance && this.iMillisOfDay == ofYear.iMillisOfDay) {
                return true;
            }
            return false;
        }

        public void writeTo(DataOutput dataOutput) throws IOException {
            dataOutput.writeByte(this.iMode);
            dataOutput.writeByte(this.iMonthOfYear);
            dataOutput.writeByte(this.iDayOfMonth);
            dataOutput.writeByte(this.iDayOfWeek);
            dataOutput.writeBoolean(this.iAdvance);
            DateTimeZoneBuilder.writeMillis(dataOutput, (long) this.iMillisOfDay);
        }

        private long setDayOfMonthNext(Chronology chronology, long j) {
            try {
                return setDayOfMonth(chronology, j);
            } catch (IllegalArgumentException e) {
                if (this.iMonthOfYear == 2 && this.iDayOfMonth == 29) {
                    while (!chronology.year().isLeap(j)) {
                        j = chronology.year().add(j, 1);
                    }
                    return setDayOfMonth(chronology, j);
                }
                throw e;
            }
        }

        private long setDayOfMonthPrevious(Chronology chronology, long j) {
            try {
                return setDayOfMonth(chronology, j);
            } catch (IllegalArgumentException e) {
                if (this.iMonthOfYear == 2 && this.iDayOfMonth == 29) {
                    while (!chronology.year().isLeap(j)) {
                        j = chronology.year().add(j, -1);
                    }
                    return setDayOfMonth(chronology, j);
                }
                throw e;
            }
        }

        private long setDayOfMonth(Chronology chronology, long j) {
            if (this.iDayOfMonth >= 0) {
                return chronology.dayOfMonth().set(j, this.iDayOfMonth);
            }
            return chronology.dayOfMonth().add(chronology.monthOfYear().add(chronology.dayOfMonth().set(j, 1), 1), this.iDayOfMonth);
        }

        private long setDayOfWeek(Chronology chronology, long j) {
            int i = this.iDayOfWeek - chronology.dayOfWeek().get(j);
            if (i == 0) {
                return j;
            }
            if (this.iAdvance) {
                if (i < 0) {
                    i += 7;
                }
            } else if (i > 0) {
                i -= 7;
            }
            return chronology.dayOfWeek().add(j, i);
        }
    }

    /* renamed from: org.joda.time.tz.DateTimeZoneBuilder$Recurrence */
    private static final class Recurrence {
        final String iNameKey;
        final OfYear iOfYear;
        final int iSaveMillis;

        static Recurrence readFrom(DataInput dataInput) throws IOException {
            return new Recurrence(OfYear.readFrom(dataInput), dataInput.readUTF(), (int) DateTimeZoneBuilder.readMillis(dataInput));
        }

        Recurrence(OfYear ofYear, String str, int i) {
            this.iOfYear = ofYear;
            this.iNameKey = str;
            this.iSaveMillis = i;
        }

        public OfYear getOfYear() {
            return this.iOfYear;
        }

        public long next(long j, int i, int i2) {
            return this.iOfYear.next(j, i, i2);
        }

        public long previous(long j, int i, int i2) {
            return this.iOfYear.previous(j, i, i2);
        }

        public String getNameKey() {
            return this.iNameKey;
        }

        public int getSaveMillis() {
            return this.iSaveMillis;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Recurrence)) {
                return false;
            }
            Recurrence recurrence = (Recurrence) obj;
            if (this.iSaveMillis != recurrence.iSaveMillis || !this.iNameKey.equals(recurrence.iNameKey) || !this.iOfYear.equals(recurrence.iOfYear)) {
                return false;
            }
            return true;
        }

        public void writeTo(DataOutput dataOutput) throws IOException {
            this.iOfYear.writeTo(dataOutput);
            dataOutput.writeUTF(this.iNameKey);
            DateTimeZoneBuilder.writeMillis(dataOutput, (long) this.iSaveMillis);
        }

        /* access modifiers changed from: package-private */
        public Recurrence rename(String str) {
            return new Recurrence(this.iOfYear, str, this.iSaveMillis);
        }

        /* access modifiers changed from: package-private */
        public Recurrence renameAppend(String str) {
            return rename((this.iNameKey + str).intern());
        }
    }

    /* renamed from: org.joda.time.tz.DateTimeZoneBuilder$Rule */
    private static final class Rule {
        final int iFromYear;
        final Recurrence iRecurrence;
        final int iToYear;

        Rule(Recurrence recurrence, int i, int i2) {
            this.iRecurrence = recurrence;
            this.iFromYear = i;
            this.iToYear = i2;
        }

        public int getFromYear() {
            return this.iFromYear;
        }

        public int getToYear() {
            return this.iToYear;
        }

        public OfYear getOfYear() {
            return this.iRecurrence.getOfYear();
        }

        public String getNameKey() {
            return this.iRecurrence.getNameKey();
        }

        public int getSaveMillis() {
            return this.iRecurrence.getSaveMillis();
        }

        public long next(long j, int i, int i2) {
            int i3;
            long j2;
            ISOChronology instanceUTC = ISOChronology.getInstanceUTC();
            int i4 = i + i2;
            if (j == Long.MIN_VALUE) {
                i3 = Integer.MIN_VALUE;
            } else {
                i3 = instanceUTC.year().get(((long) i4) + j);
            }
            if (i3 < this.iFromYear) {
                j2 = (instanceUTC.year().set(0, this.iFromYear) - ((long) i4)) - 1;
            } else {
                j2 = j;
            }
            long next = this.iRecurrence.next(j2, i, i2);
            if (next <= j || instanceUTC.year().get(((long) i4) + next) <= this.iToYear) {
                return next;
            }
            return j;
        }
    }

    /* renamed from: org.joda.time.tz.DateTimeZoneBuilder$Transition */
    private static final class Transition {
        private final long iMillis;
        private final String iNameKey;
        private final int iStandardOffset;
        private final int iWallOffset;

        Transition(long j, Transition transition) {
            this.iMillis = j;
            this.iNameKey = transition.iNameKey;
            this.iWallOffset = transition.iWallOffset;
            this.iStandardOffset = transition.iStandardOffset;
        }

        Transition(long j, Rule rule, int i) {
            this.iMillis = j;
            this.iNameKey = rule.getNameKey();
            this.iWallOffset = rule.getSaveMillis() + i;
            this.iStandardOffset = i;
        }

        Transition(long j, String str, int i, int i2) {
            this.iMillis = j;
            this.iNameKey = str;
            this.iWallOffset = i;
            this.iStandardOffset = i2;
        }

        public long getMillis() {
            return this.iMillis;
        }

        public String getNameKey() {
            return this.iNameKey;
        }

        public int getWallOffset() {
            return this.iWallOffset;
        }

        public int getStandardOffset() {
            return this.iStandardOffset;
        }

        public int getSaveMillis() {
            return this.iWallOffset - this.iStandardOffset;
        }

        public boolean isTransitionFrom(Transition transition) {
            if (transition == null) {
                return true;
            }
            if (this.iMillis <= transition.iMillis || (this.iWallOffset == transition.iWallOffset && this.iNameKey.equals(transition.iNameKey))) {
                return false;
            }
            return true;
        }
    }

    /* renamed from: org.joda.time.tz.DateTimeZoneBuilder$RuleSet */
    private static final class RuleSet {
        private static final int YEAR_LIMIT = (ISOChronology.getInstanceUTC().year().get(DateTimeUtils.currentTimeMillis()) + 100);
        private String iInitialNameKey;
        private int iInitialSaveMillis;
        private ArrayList<Rule> iRules;
        private int iStandardOffset;
        private OfYear iUpperOfYear;
        private int iUpperYear;

        RuleSet() {
            this.iRules = new ArrayList<>(10);
            this.iUpperYear = Integer.MAX_VALUE;
        }

        RuleSet(RuleSet ruleSet) {
            this.iStandardOffset = ruleSet.iStandardOffset;
            this.iRules = new ArrayList<>(ruleSet.iRules);
            this.iInitialNameKey = ruleSet.iInitialNameKey;
            this.iInitialSaveMillis = ruleSet.iInitialSaveMillis;
            this.iUpperYear = ruleSet.iUpperYear;
            this.iUpperOfYear = ruleSet.iUpperOfYear;
        }

        public int getStandardOffset() {
            return this.iStandardOffset;
        }

        public void setStandardOffset(int i) {
            this.iStandardOffset = i;
        }

        public void setFixedSavings(String str, int i) {
            this.iInitialNameKey = str;
            this.iInitialSaveMillis = i;
        }

        public void addRule(Rule rule) {
            if (!this.iRules.contains(rule)) {
                this.iRules.add(rule);
            }
        }

        public void setUpperLimit(int i, OfYear ofYear) {
            this.iUpperYear = i;
            this.iUpperOfYear = ofYear;
        }

        public Transition firstTransition(long j) {
            Transition transition;
            if (this.iInitialNameKey != null) {
                return new Transition(j, this.iInitialNameKey, this.iStandardOffset + this.iInitialSaveMillis, this.iStandardOffset);
            }
            ArrayList<Rule> arrayList = new ArrayList<>(this.iRules);
            long j2 = Long.MIN_VALUE;
            int i = 0;
            Transition transition2 = null;
            while (true) {
                Transition transition3 = transition2;
                int i2 = i;
                Transition transition4 = transition3;
                Transition nextTransition = nextTransition(j2, i2);
                if (nextTransition == null) {
                    transition = transition4;
                    break;
                }
                j2 = nextTransition.getMillis();
                if (j2 == j) {
                    transition = new Transition(j, nextTransition);
                    break;
                } else if (j2 > j) {
                    if (transition4 == null) {
                        Iterator<Rule> it = arrayList.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            Rule next = it.next();
                            if (next.getSaveMillis() == 0) {
                                transition = new Transition(j, next, this.iStandardOffset);
                                break;
                            }
                        }
                    }
                    transition = transition4;
                    if (transition == null) {
                        transition = new Transition(j, nextTransition.getNameKey(), this.iStandardOffset, this.iStandardOffset);
                    }
                } else {
                    transition2 = new Transition(j, nextTransition);
                    i = nextTransition.getSaveMillis();
                }
            }
            this.iRules = arrayList;
            return transition;
        }

        public Transition nextTransition(long j, int i) {
            long j2;
            Rule rule;
            ISOChronology instanceUTC = ISOChronology.getInstanceUTC();
            long j3 = Long.MAX_VALUE;
            Iterator<Rule> it = this.iRules.iterator();
            Rule rule2 = null;
            while (it.hasNext()) {
                Rule next = it.next();
                long next2 = next.next(j, this.iStandardOffset, i);
                if (next2 <= j) {
                    it.remove();
                } else {
                    if (next2 <= j3) {
                        rule = next;
                        j2 = next2;
                    } else {
                        j2 = j3;
                        rule = rule2;
                    }
                    j3 = j2;
                    rule2 = rule;
                }
            }
            if (rule2 == null || instanceUTC.year().get(j3) >= YEAR_LIMIT) {
                return null;
            }
            if (this.iUpperYear >= Integer.MAX_VALUE || j3 < this.iUpperOfYear.setInstant(this.iUpperYear, this.iStandardOffset, i)) {
                return new Transition(j3, rule2, this.iStandardOffset);
            }
            return null;
        }

        public long getUpperLimit(int i) {
            if (this.iUpperYear == Integer.MAX_VALUE) {
                return Long.MAX_VALUE;
            }
            return this.iUpperOfYear.setInstant(this.iUpperYear, this.iStandardOffset, i);
        }

        public DSTZone buildTailZone(String str) {
            if (this.iRules.size() == 2) {
                Rule rule = this.iRules.get(0);
                Rule rule2 = this.iRules.get(1);
                if (rule.getToYear() == Integer.MAX_VALUE && rule2.getToYear() == Integer.MAX_VALUE) {
                    return new DSTZone(str, this.iStandardOffset, rule.iRecurrence, rule2.iRecurrence);
                }
            }
            return null;
        }
    }

    /* renamed from: org.joda.time.tz.DateTimeZoneBuilder$DSTZone */
    private static final class DSTZone extends DateTimeZone {
        private static final long serialVersionUID = 6941492635554961361L;
        final Recurrence iEndRecurrence;
        final int iStandardOffset;
        final Recurrence iStartRecurrence;

        static DSTZone readFrom(DataInput dataInput, String str) throws IOException {
            return new DSTZone(str, (int) DateTimeZoneBuilder.readMillis(dataInput), Recurrence.readFrom(dataInput), Recurrence.readFrom(dataInput));
        }

        DSTZone(String str, int i, Recurrence recurrence, Recurrence recurrence2) {
            super(str);
            this.iStandardOffset = i;
            this.iStartRecurrence = recurrence;
            this.iEndRecurrence = recurrence2;
        }

        public String getNameKey(long j) {
            return findMatchingRecurrence(j).getNameKey();
        }

        public int getOffset(long j) {
            return this.iStandardOffset + findMatchingRecurrence(j).getSaveMillis();
        }

        public int getStandardOffset(long j) {
            return this.iStandardOffset;
        }

        public boolean isFixed() {
            return false;
        }

        public long nextTransition(long j) {
            long j2;
            long j3;
            int i = this.iStandardOffset;
            Recurrence recurrence = this.iStartRecurrence;
            Recurrence recurrence2 = this.iEndRecurrence;
            try {
                long next = recurrence.next(j, i, recurrence2.getSaveMillis());
                if (j > 0 && next < 0) {
                    next = j;
                }
                j2 = next;
            } catch (IllegalArgumentException e) {
                j2 = j;
            } catch (ArithmeticException e2) {
                j2 = j;
            }
            try {
                long next2 = recurrence2.next(j, i, recurrence.getSaveMillis());
                if (j <= 0 || next2 >= 0) {
                    j = next2;
                }
                j3 = j;
            } catch (IllegalArgumentException e3) {
                j3 = j;
            } catch (ArithmeticException e4) {
                j3 = j;
            }
            if (j2 > j3) {
                return j3;
            }
            return j2;
        }

        public long previousTransition(long j) {
            long j2;
            long j3;
            long j4 = j + 1;
            int i = this.iStandardOffset;
            Recurrence recurrence = this.iStartRecurrence;
            Recurrence recurrence2 = this.iEndRecurrence;
            try {
                long previous = recurrence.previous(j4, i, recurrence2.getSaveMillis());
                if (j4 < 0 && previous > 0) {
                    previous = j4;
                }
                j2 = previous;
            } catch (IllegalArgumentException e) {
                j2 = j4;
            } catch (ArithmeticException e2) {
                j2 = j4;
            }
            try {
                long previous2 = recurrence2.previous(j4, i, recurrence.getSaveMillis());
                if (j4 >= 0 || previous2 <= 0) {
                    j4 = previous2;
                }
                j3 = j4;
            } catch (IllegalArgumentException e3) {
                j3 = j4;
            } catch (ArithmeticException e4) {
                j3 = j4;
            }
            if (j2 > j3) {
                j3 = j2;
            }
            return j3 - 1;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DSTZone)) {
                return false;
            }
            DSTZone dSTZone = (DSTZone) obj;
            if (!getID().equals(dSTZone.getID()) || this.iStandardOffset != dSTZone.iStandardOffset || !this.iStartRecurrence.equals(dSTZone.iStartRecurrence) || !this.iEndRecurrence.equals(dSTZone.iEndRecurrence)) {
                return false;
            }
            return true;
        }

        public void writeTo(DataOutput dataOutput) throws IOException {
            DateTimeZoneBuilder.writeMillis(dataOutput, (long) this.iStandardOffset);
            this.iStartRecurrence.writeTo(dataOutput);
            this.iEndRecurrence.writeTo(dataOutput);
        }

        private Recurrence findMatchingRecurrence(long j) {
            long j2;
            int i = this.iStandardOffset;
            Recurrence recurrence = this.iStartRecurrence;
            Recurrence recurrence2 = this.iEndRecurrence;
            try {
                j2 = recurrence.next(j, i, recurrence2.getSaveMillis());
            } catch (IllegalArgumentException e) {
                j2 = j;
            } catch (ArithmeticException e2) {
                j2 = j;
            }
            try {
                j = recurrence2.next(j, i, recurrence.getSaveMillis());
            } catch (ArithmeticException | IllegalArgumentException e3) {
            }
            if (j2 > j) {
                return recurrence;
            }
            return recurrence2;
        }
    }

    /* renamed from: org.joda.time.tz.DateTimeZoneBuilder$PrecalculatedZone */
    private static final class PrecalculatedZone extends DateTimeZone {
        private static final long serialVersionUID = 7811976468055766265L;
        private final String[] iNameKeys;
        private final int[] iStandardOffsets;
        private final DSTZone iTailZone;
        private final long[] iTransitions;
        private final int[] iWallOffsets;

        static PrecalculatedZone readFrom(DataInput dataInput, String str) throws IOException {
            int readUnsignedShort;
            int readUnsignedShort2 = dataInput.readUnsignedShort();
            String[] strArr = new String[readUnsignedShort2];
            for (int i = 0; i < readUnsignedShort2; i++) {
                strArr[i] = dataInput.readUTF();
            }
            int readInt = dataInput.readInt();
            long[] jArr = new long[readInt];
            int[] iArr = new int[readInt];
            int[] iArr2 = new int[readInt];
            String[] strArr2 = new String[readInt];
            for (int i2 = 0; i2 < readInt; i2++) {
                jArr[i2] = DateTimeZoneBuilder.readMillis(dataInput);
                iArr[i2] = (int) DateTimeZoneBuilder.readMillis(dataInput);
                iArr2[i2] = (int) DateTimeZoneBuilder.readMillis(dataInput);
                if (readUnsignedShort2 < 256) {
                    try {
                        readUnsignedShort = dataInput.readUnsignedByte();
                    } catch (ArrayIndexOutOfBoundsException e) {
                        throw new IOException("Invalid encoding");
                    }
                } else {
                    readUnsignedShort = dataInput.readUnsignedShort();
                }
                strArr2[i2] = strArr[readUnsignedShort];
            }
            DSTZone dSTZone = null;
            if (dataInput.readBoolean()) {
                dSTZone = DSTZone.readFrom(dataInput, str);
            }
            return new PrecalculatedZone(str, jArr, iArr, iArr2, strArr2, dSTZone);
        }

        static PrecalculatedZone create(String str, boolean z, ArrayList<Transition> arrayList, DSTZone dSTZone) {
            String[] strArr;
            DSTZone dSTZone2;
            String str2;
            int size = arrayList.size();
            if (size == 0) {
                throw new IllegalArgumentException();
            }
            long[] jArr = new long[size];
            int[] iArr = new int[size];
            int[] iArr2 = new int[size];
            String[] strArr2 = new String[size];
            Transition transition = null;
            int i = 0;
            while (i < size) {
                Transition transition2 = arrayList.get(i);
                if (!transition2.isTransitionFrom(transition)) {
                    throw new IllegalArgumentException(str);
                }
                jArr[i] = transition2.getMillis();
                iArr[i] = transition2.getWallOffset();
                iArr2[i] = transition2.getStandardOffset();
                strArr2[i] = transition2.getNameKey();
                i++;
                transition = transition2;
            }
            String[] strArr3 = new String[5];
            String[][] zoneStrings = new DateFormatSymbols(Locale.ENGLISH).getZoneStrings();
            int i2 = 0;
            while (true) {
                strArr = strArr3;
                if (i2 >= zoneStrings.length) {
                    break;
                }
                strArr3 = zoneStrings[i2];
                if (strArr3 != null && strArr3.length == 5) {
                    if (str.equals(strArr3[0])) {
                        i2++;
                    }
                }
                strArr3 = strArr;
                i2++;
            }
            ISOChronology instanceUTC = ISOChronology.getInstanceUTC();
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= strArr2.length - 1) {
                    break;
                }
                String str3 = strArr2[i4];
                String str4 = strArr2[i4 + 1];
                long j = (long) iArr[i4];
                long j2 = (long) iArr[i4 + 1];
                long j3 = (long) iArr2[i4];
                long j4 = (long) iArr2[i4 + 1];
                Period period = new Period(jArr[i4], jArr[i4 + 1], PeriodType.yearMonthDay(), (Chronology) instanceUTC);
                if (j != j2 && j3 == j4 && str3.equals(str4) && period.getYears() == 0 && period.getMonths() > 4 && period.getMonths() < 8 && str3.equals(strArr[2]) && str3.equals(strArr[4])) {
                    if (ZoneInfoCompiler.verbose()) {
                        System.out.println("Fixing duplicate name key - " + str4);
                        System.out.println("     - " + new DateTime(jArr[i4], (Chronology) instanceUTC) + " - " + new DateTime(jArr[i4 + 1], (Chronology) instanceUTC));
                    }
                    if (j > j2) {
                        strArr2[i4] = (str3 + "-Summer").intern();
                    } else if (j < j2) {
                        strArr2[i4 + 1] = (str4 + "-Summer").intern();
                        i4++;
                    }
                }
                i3 = i4 + 1;
            }
            if (dSTZone == null || !dSTZone.iStartRecurrence.getNameKey().equals(dSTZone.iEndRecurrence.getNameKey())) {
                dSTZone2 = dSTZone;
            } else {
                if (ZoneInfoCompiler.verbose()) {
                    System.out.println("Fixing duplicate recurrent name key - " + dSTZone.iStartRecurrence.getNameKey());
                }
                dSTZone2 = dSTZone.iStartRecurrence.getSaveMillis() > 0 ? new DSTZone(dSTZone.getID(), dSTZone.iStandardOffset, dSTZone.iStartRecurrence.renameAppend("-Summer"), dSTZone.iEndRecurrence) : new DSTZone(dSTZone.getID(), dSTZone.iStandardOffset, dSTZone.iStartRecurrence, dSTZone.iEndRecurrence.renameAppend("-Summer"));
            }
            if (z) {
                str2 = str;
            } else {
                str2 = "";
            }
            return new PrecalculatedZone(str2, jArr, iArr, iArr2, strArr2, dSTZone2);
        }

        private PrecalculatedZone(String str, long[] jArr, int[] iArr, int[] iArr2, String[] strArr, DSTZone dSTZone) {
            super(str);
            this.iTransitions = jArr;
            this.iWallOffsets = iArr;
            this.iStandardOffsets = iArr2;
            this.iNameKeys = strArr;
            this.iTailZone = dSTZone;
        }

        public String getNameKey(long j) {
            long[] jArr = this.iTransitions;
            int binarySearch = Arrays.binarySearch(jArr, j);
            if (binarySearch >= 0) {
                return this.iNameKeys[binarySearch];
            }
            int i = binarySearch ^ -1;
            if (i < jArr.length) {
                if (i > 0) {
                    return this.iNameKeys[i - 1];
                }
                return "UTC";
            } else if (this.iTailZone == null) {
                return this.iNameKeys[i - 1];
            } else {
                return this.iTailZone.getNameKey(j);
            }
        }

        public int getOffset(long j) {
            long[] jArr = this.iTransitions;
            int binarySearch = Arrays.binarySearch(jArr, j);
            if (binarySearch >= 0) {
                return this.iWallOffsets[binarySearch];
            }
            int i = binarySearch ^ -1;
            if (i < jArr.length) {
                if (i > 0) {
                    return this.iWallOffsets[i - 1];
                }
                return 0;
            } else if (this.iTailZone == null) {
                return this.iWallOffsets[i - 1];
            } else {
                return this.iTailZone.getOffset(j);
            }
        }

        public int getStandardOffset(long j) {
            long[] jArr = this.iTransitions;
            int binarySearch = Arrays.binarySearch(jArr, j);
            if (binarySearch >= 0) {
                return this.iStandardOffsets[binarySearch];
            }
            int i = binarySearch ^ -1;
            if (i < jArr.length) {
                if (i > 0) {
                    return this.iStandardOffsets[i - 1];
                }
                return 0;
            } else if (this.iTailZone == null) {
                return this.iStandardOffsets[i - 1];
            } else {
                return this.iTailZone.getStandardOffset(j);
            }
        }

        public boolean isFixed() {
            return false;
        }

        public long nextTransition(long j) {
            long[] jArr = this.iTransitions;
            int binarySearch = Arrays.binarySearch(jArr, j);
            int i = binarySearch >= 0 ? binarySearch + 1 : binarySearch ^ -1;
            if (i < jArr.length) {
                return jArr[i];
            }
            if (this.iTailZone == null) {
                return j;
            }
            long j2 = jArr[jArr.length - 1];
            if (j < j2) {
                j = j2;
            }
            return this.iTailZone.nextTransition(j);
        }

        public long previousTransition(long j) {
            long[] jArr = this.iTransitions;
            int binarySearch = Arrays.binarySearch(jArr, j);
            if (binarySearch < 0) {
                int i = binarySearch ^ -1;
                if (i >= jArr.length) {
                    if (this.iTailZone != null) {
                        long previousTransition = this.iTailZone.previousTransition(j);
                        if (previousTransition < j) {
                            return previousTransition;
                        }
                    }
                    long j2 = jArr[i - 1];
                    if (j2 > Long.MIN_VALUE) {
                        return j2 - 1;
                    }
                    return j;
                } else if (i <= 0) {
                    return j;
                } else {
                    long j3 = jArr[i - 1];
                    if (j3 > Long.MIN_VALUE) {
                        return j3 - 1;
                    }
                    return j;
                }
            } else if (j > Long.MIN_VALUE) {
                return j - 1;
            } else {
                return j;
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PrecalculatedZone)) {
                return false;
            }
            PrecalculatedZone precalculatedZone = (PrecalculatedZone) obj;
            if (getID().equals(precalculatedZone.getID()) && Arrays.equals(this.iTransitions, precalculatedZone.iTransitions) && Arrays.equals(this.iNameKeys, precalculatedZone.iNameKeys) && Arrays.equals(this.iWallOffsets, precalculatedZone.iWallOffsets) && Arrays.equals(this.iStandardOffsets, precalculatedZone.iStandardOffsets)) {
                if (this.iTailZone == null) {
                    if (precalculatedZone.iTailZone == null) {
                        return true;
                    }
                } else if (this.iTailZone.equals(precalculatedZone.iTailZone)) {
                    return true;
                }
            }
            return false;
        }

        public void writeTo(DataOutput dataOutput) throws IOException {
            boolean z = false;
            int length = this.iTransitions.length;
            HashSet<String> hashSet = new HashSet<>();
            for (int i = 0; i < length; i++) {
                hashSet.add(this.iNameKeys[i]);
            }
            int size = hashSet.size();
            if (size > 65535) {
                throw new UnsupportedOperationException("String pool is too large");
            }
            String[] strArr = new String[size];
            int i2 = 0;
            for (String str : hashSet) {
                strArr[i2] = str;
                i2++;
            }
            dataOutput.writeShort(size);
            for (int i3 = 0; i3 < size; i3++) {
                dataOutput.writeUTF(strArr[i3]);
            }
            dataOutput.writeInt(length);
            for (int i4 = 0; i4 < length; i4++) {
                DateTimeZoneBuilder.writeMillis(dataOutput, this.iTransitions[i4]);
                DateTimeZoneBuilder.writeMillis(dataOutput, (long) this.iWallOffsets[i4]);
                DateTimeZoneBuilder.writeMillis(dataOutput, (long) this.iStandardOffsets[i4]);
                String str2 = this.iNameKeys[i4];
                int i5 = 0;
                while (true) {
                    if (i5 >= size) {
                        break;
                    } else if (!strArr[i5].equals(str2)) {
                        i5++;
                    } else if (size < 256) {
                        dataOutput.writeByte(i5);
                    } else {
                        dataOutput.writeShort(i5);
                    }
                }
            }
            if (this.iTailZone != null) {
                z = true;
            }
            dataOutput.writeBoolean(z);
            if (this.iTailZone != null) {
                this.iTailZone.writeTo(dataOutput);
            }
        }

        public boolean isCachable() {
            if (this.iTailZone != null) {
                return true;
            }
            long[] jArr = this.iTransitions;
            if (jArr.length <= 1) {
                return false;
            }
            double d = 0.0d;
            int i = 0;
            for (int i2 = 1; i2 < jArr.length; i2++) {
                long j = jArr[i2] - jArr[i2 - 1];
                if (j < 63158400000L) {
                    d += (double) j;
                    i++;
                }
            }
            if (i <= 0 || (d / ((double) i)) / 8.64E7d < 25.0d) {
                return false;
            }
            return true;
        }
    }
}
