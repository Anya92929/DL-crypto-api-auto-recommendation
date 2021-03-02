package org.apache.commons.lang3;

public class BitField {

    /* renamed from: a */
    private final int f7015a;

    /* renamed from: b */
    private final int f7016b;

    public BitField(int i) {
        this.f7015a = i;
        int i2 = 0;
        if (i != 0) {
            while ((i & 1) == 0) {
                i2++;
                i >>= 1;
            }
        }
        this.f7016b = i2;
    }

    public int getValue(int i) {
        return getRawValue(i) >> this.f7016b;
    }

    public short getShortValue(short s) {
        return (short) getValue(s);
    }

    public int getRawValue(int i) {
        return this.f7015a & i;
    }

    public short getShortRawValue(short s) {
        return (short) getRawValue(s);
    }

    public boolean isSet(int i) {
        return (this.f7015a & i) != 0;
    }

    public boolean isAllSet(int i) {
        return (this.f7015a & i) == this.f7015a;
    }

    public int setValue(int i, int i2) {
        return ((this.f7015a ^ -1) & i) | ((i2 << this.f7016b) & this.f7015a);
    }

    public short setShortValue(short s, short s2) {
        return (short) setValue(s, s2);
    }

    public int clear(int i) {
        return (this.f7015a ^ -1) & i;
    }

    public short clearShort(short s) {
        return (short) clear(s);
    }

    public byte clearByte(byte b) {
        return (byte) clear(b);
    }

    public int set(int i) {
        return this.f7015a | i;
    }

    public short setShort(short s) {
        return (short) set(s);
    }

    public byte setByte(byte b) {
        return (byte) set(b);
    }

    public int setBoolean(int i, boolean z) {
        return z ? set(i) : clear(i);
    }

    public short setShortBoolean(short s, boolean z) {
        return z ? setShort(s) : clearShort(s);
    }

    public byte setByteBoolean(byte b, boolean z) {
        return z ? setByte(b) : clearByte(b);
    }
}
