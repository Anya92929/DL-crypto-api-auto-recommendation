package org.apache.commons.lang3.math;

import java.math.BigInteger;
import org.apache.commons.p009io.IOUtils;

public final class Fraction extends Number implements Comparable<Fraction> {
    public static final Fraction FOUR_FIFTHS = new Fraction(4, 5);
    public static final Fraction ONE = new Fraction(1, 1);
    public static final Fraction ONE_FIFTH = new Fraction(1, 5);
    public static final Fraction ONE_HALF = new Fraction(1, 2);
    public static final Fraction ONE_QUARTER = new Fraction(1, 4);
    public static final Fraction ONE_THIRD = new Fraction(1, 3);
    public static final Fraction THREE_FIFTHS = new Fraction(3, 5);
    public static final Fraction THREE_QUARTERS = new Fraction(3, 4);
    public static final Fraction TWO_FIFTHS = new Fraction(2, 5);
    public static final Fraction TWO_QUARTERS = new Fraction(2, 4);
    public static final Fraction TWO_THIRDS = new Fraction(2, 3);
    public static final Fraction ZERO = new Fraction(0, 1);
    private static final long serialVersionUID = 65382027393090L;

    /* renamed from: a */
    private final int f7138a;

    /* renamed from: b */
    private final int f7139b;

    /* renamed from: c */
    private transient int f7140c = 0;

    /* renamed from: d */
    private transient String f7141d = null;

    /* renamed from: e */
    private transient String f7142e = null;

    private Fraction(int i, int i2) {
        this.f7138a = i;
        this.f7139b = i2;
    }

    public static Fraction getFraction(int i, int i2) {
        if (i2 == 0) {
            throw new ArithmeticException("The denominator must not be zero");
        }
        if (i2 < 0) {
            if (i == Integer.MIN_VALUE || i2 == Integer.MIN_VALUE) {
                throw new ArithmeticException("overflow: can't negate");
            }
            i = -i;
            i2 = -i2;
        }
        return new Fraction(i, i2);
    }

    public static Fraction getFraction(int i, int i2, int i3) {
        long j;
        if (i3 == 0) {
            throw new ArithmeticException("The denominator must not be zero");
        } else if (i3 < 0) {
            throw new ArithmeticException("The denominator must not be negative");
        } else if (i2 < 0) {
            throw new ArithmeticException("The numerator must not be negative");
        } else {
            if (i < 0) {
                j = (((long) i) * ((long) i3)) - ((long) i2);
            } else {
                j = (((long) i) * ((long) i3)) + ((long) i2);
            }
            if (j >= -2147483648L && j <= 2147483647L) {
                return new Fraction((int) j, i3);
            }
            throw new ArithmeticException("Numerator too large to represent as an Integer.");
        }
    }

    public static Fraction getReducedFraction(int i, int i2) {
        int i3;
        int i4;
        if (i2 == 0) {
            throw new ArithmeticException("The denominator must not be zero");
        } else if (i == 0) {
            return ZERO;
        } else {
            if (i2 == Integer.MIN_VALUE && (i & 1) == 0) {
                i3 = i2 / 2;
                i4 = i / 2;
            } else {
                i3 = i2;
                i4 = i;
            }
            if (i3 < 0) {
                if (i4 == Integer.MIN_VALUE || i3 == Integer.MIN_VALUE) {
                    throw new ArithmeticException("overflow: can't negate");
                }
                i4 = -i4;
                i3 = -i3;
            }
            int a = m7415a(i4, i3);
            return new Fraction(i4 / a, i3 / a);
        }
    }

    public static Fraction getFraction(double d) {
        int i = d < 0.0d ? -1 : 1;
        double abs = Math.abs(d);
        if (abs > 2.147483647E9d || Double.isNaN(abs)) {
            throw new ArithmeticException("The value must not be greater than Integer.MAX_VALUE or NaN");
        }
        int i2 = (int) abs;
        double d2 = abs - ((double) i2);
        int i3 = (int) d2;
        double d3 = Double.MAX_VALUE;
        int i4 = 1;
        int i5 = 1;
        int i6 = 0;
        int i7 = 0;
        int i8 = 1;
        int i9 = i3;
        double d4 = 1.0d;
        double d5 = d2 - ((double) i3);
        while (true) {
            int i10 = (int) (d4 / d5);
            double d6 = d4 - (((double) i10) * d5);
            int i11 = i6 + (i9 * i8);
            int i12 = (i9 * i7) + i5;
            double abs2 = Math.abs(d2 - (((double) i11) / ((double) i12)));
            i4++;
            if (d3 > abs2 && i12 <= 10000 && i12 > 0 && i4 < 25) {
                d3 = abs2;
                i5 = i7;
                d4 = d5;
                i7 = i12;
                i9 = i10;
                d5 = d6;
                int i13 = i11;
                i6 = i8;
                i8 = i13;
            }
        }
        if (i4 != 25) {
            return getReducedFraction(i * ((i2 * i7) + i8), i7);
        }
        throw new ArithmeticException("Unable to convert double to fraction");
    }

    public static Fraction getFraction(String str) {
        if (str == null) {
            throw new IllegalArgumentException("The string must not be null");
        } else if (str.indexOf(46) >= 0) {
            return getFraction(Double.parseDouble(str));
        } else {
            int indexOf = str.indexOf(32);
            if (indexOf > 0) {
                int parseInt = Integer.parseInt(str.substring(0, indexOf));
                String substring = str.substring(indexOf + 1);
                int indexOf2 = substring.indexOf(47);
                if (indexOf2 >= 0) {
                    return getFraction(parseInt, Integer.parseInt(substring.substring(0, indexOf2)), Integer.parseInt(substring.substring(indexOf2 + 1)));
                }
                throw new NumberFormatException("The fraction could not be parsed as the format X Y/Z");
            }
            int indexOf3 = str.indexOf(47);
            if (indexOf3 < 0) {
                return getFraction(Integer.parseInt(str), 1);
            }
            return getFraction(Integer.parseInt(str.substring(0, indexOf3)), Integer.parseInt(str.substring(indexOf3 + 1)));
        }
    }

    public int getNumerator() {
        return this.f7138a;
    }

    public int getDenominator() {
        return this.f7139b;
    }

    public int getProperNumerator() {
        return Math.abs(this.f7138a % this.f7139b);
    }

    public int getProperWhole() {
        return this.f7138a / this.f7139b;
    }

    public int intValue() {
        return this.f7138a / this.f7139b;
    }

    public long longValue() {
        return ((long) this.f7138a) / ((long) this.f7139b);
    }

    public float floatValue() {
        return ((float) this.f7138a) / ((float) this.f7139b);
    }

    public double doubleValue() {
        return ((double) this.f7138a) / ((double) this.f7139b);
    }

    public Fraction reduce() {
        if (this.f7138a != 0) {
            int a = m7415a(Math.abs(this.f7138a), this.f7139b);
            return a != 1 ? getFraction(this.f7138a / a, this.f7139b / a) : this;
        } else if (equals(ZERO)) {
            return this;
        } else {
            return ZERO;
        }
    }

    public Fraction invert() {
        if (this.f7138a == 0) {
            throw new ArithmeticException("Unable to invert zero.");
        } else if (this.f7138a == Integer.MIN_VALUE) {
            throw new ArithmeticException("overflow: can't negate numerator");
        } else if (this.f7138a < 0) {
            return new Fraction(-this.f7139b, -this.f7138a);
        } else {
            return new Fraction(this.f7139b, this.f7138a);
        }
    }

    public Fraction negate() {
        if (this.f7138a != Integer.MIN_VALUE) {
            return new Fraction(-this.f7138a, this.f7139b);
        }
        throw new ArithmeticException("overflow: too large to negate");
    }

    public Fraction abs() {
        return this.f7138a >= 0 ? this : negate();
    }

    public Fraction pow(int i) {
        if (i == 1) {
            return this;
        }
        if (i == 0) {
            return ONE;
        }
        if (i >= 0) {
            Fraction multiplyBy = multiplyBy(this);
            if (i % 2 == 0) {
                return multiplyBy.pow(i / 2);
            }
            return multiplyBy.pow(i / 2).multiplyBy(this);
        } else if (i == Integer.MIN_VALUE) {
            return invert().pow(2).pow(-(i / 2));
        } else {
            return invert().pow(-i);
        }
    }

    /* renamed from: a */
    private static int m7415a(int i, int i2) {
        int i3;
        int i4;
        if (i == 0 || i2 == 0) {
            if (i != Integer.MIN_VALUE && i2 != Integer.MIN_VALUE) {
                return Math.abs(i) + Math.abs(i2);
            }
            throw new ArithmeticException("overflow: gcd is 2^31");
        } else if (Math.abs(i) == 1 || Math.abs(i2) == 1) {
            return 1;
        } else {
            if (i > 0) {
                i3 = -i;
            } else {
                i3 = i;
            }
            if (i2 > 0) {
                i2 = -i2;
            }
            int i5 = 0;
            int i6 = i2;
            while ((i3 & 1) == 0 && (i6 & 1) == 0 && i5 < 31) {
                i3 /= 2;
                i6 /= 2;
                i5++;
            }
            if (i5 == 31) {
                throw new ArithmeticException("overflow: gcd is 2^31");
            }
            int i7 = i6;
            int i8 = (i3 & 1) == 1 ? i6 : -(i3 / 2);
            while (true) {
                if ((i8 & 1) == 0) {
                    i8 /= 2;
                } else {
                    if (i8 > 0) {
                        i4 = -i8;
                    } else {
                        i7 = i8;
                        i4 = i3;
                    }
                    int i9 = (i7 - i4) / 2;
                    if (i9 == 0) {
                        return (-i4) * (1 << i5);
                    }
                    int i10 = i9;
                    i3 = i4;
                    i8 = i10;
                }
            }
        }
    }

    /* renamed from: b */
    private static int m7417b(int i, int i2) {
        long j = ((long) i) * ((long) i2);
        if (j >= -2147483648L && j <= 2147483647L) {
            return (int) j;
        }
        throw new ArithmeticException("overflow: mul");
    }

    /* renamed from: c */
    private static int m7418c(int i, int i2) {
        long j = ((long) i) * ((long) i2);
        if (j <= 2147483647L) {
            return (int) j;
        }
        throw new ArithmeticException("overflow: mulPos");
    }

    /* renamed from: d */
    private static int m7419d(int i, int i2) {
        long j = ((long) i) + ((long) i2);
        if (j >= -2147483648L && j <= 2147483647L) {
            return (int) j;
        }
        throw new ArithmeticException("overflow: add");
    }

    /* renamed from: e */
    private static int m7420e(int i, int i2) {
        long j = ((long) i) - ((long) i2);
        if (j >= -2147483648L && j <= 2147483647L) {
            return (int) j;
        }
        throw new ArithmeticException("overflow: add");
    }

    public Fraction add(Fraction fraction) {
        return m7416a(fraction, true);
    }

    public Fraction subtract(Fraction fraction) {
        return m7416a(fraction, false);
    }

    /* renamed from: a */
    private Fraction m7416a(Fraction fraction, boolean z) {
        if (fraction == null) {
            throw new IllegalArgumentException("The fraction must not be null");
        } else if (this.f7138a == 0) {
            if (z) {
                return fraction;
            }
            return fraction.negate();
        } else if (fraction.f7138a == 0) {
            return this;
        } else {
            int a = m7415a(this.f7139b, fraction.f7139b);
            if (a == 1) {
                int b = m7417b(this.f7138a, fraction.f7139b);
                int b2 = m7417b(fraction.f7138a, this.f7139b);
                return new Fraction(z ? m7419d(b, b2) : m7420e(b, b2), m7418c(this.f7139b, fraction.f7139b));
            }
            BigInteger multiply = BigInteger.valueOf((long) this.f7138a).multiply(BigInteger.valueOf((long) (fraction.f7139b / a)));
            BigInteger multiply2 = BigInteger.valueOf((long) fraction.f7138a).multiply(BigInteger.valueOf((long) (this.f7139b / a)));
            BigInteger add = z ? multiply.add(multiply2) : multiply.subtract(multiply2);
            int intValue = add.mod(BigInteger.valueOf((long) a)).intValue();
            int a2 = intValue == 0 ? a : m7415a(intValue, a);
            BigInteger divide = add.divide(BigInteger.valueOf((long) a2));
            if (divide.bitLength() <= 31) {
                return new Fraction(divide.intValue(), m7418c(this.f7139b / a, fraction.f7139b / a2));
            }
            throw new ArithmeticException("overflow: numerator too large after multiply");
        }
    }

    public Fraction multiplyBy(Fraction fraction) {
        if (fraction == null) {
            throw new IllegalArgumentException("The fraction must not be null");
        } else if (this.f7138a == 0 || fraction.f7138a == 0) {
            return ZERO;
        } else {
            int a = m7415a(this.f7138a, fraction.f7139b);
            int a2 = m7415a(fraction.f7138a, this.f7139b);
            return getReducedFraction(m7417b(this.f7138a / a, fraction.f7138a / a2), m7418c(this.f7139b / a2, fraction.f7139b / a));
        }
    }

    public Fraction divideBy(Fraction fraction) {
        if (fraction == null) {
            throw new IllegalArgumentException("The fraction must not be null");
        } else if (fraction.f7138a != 0) {
            return multiplyBy(fraction.invert());
        } else {
            throw new ArithmeticException("The fraction to divide by must not be zero");
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Fraction)) {
            return false;
        }
        Fraction fraction = (Fraction) obj;
        if (getNumerator() == fraction.getNumerator() && getDenominator() == fraction.getDenominator()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (this.f7140c == 0) {
            this.f7140c = ((getNumerator() + 629) * 37) + getDenominator();
        }
        return this.f7140c;
    }

    public int compareTo(Fraction fraction) {
        if (this == fraction) {
            return 0;
        }
        if (this.f7138a == fraction.f7138a && this.f7139b == fraction.f7139b) {
            return 0;
        }
        long j = ((long) this.f7138a) * ((long) fraction.f7139b);
        long j2 = ((long) fraction.f7138a) * ((long) this.f7139b);
        if (j == j2) {
            return 0;
        }
        if (j < j2) {
            return -1;
        }
        return 1;
    }

    public String toString() {
        if (this.f7141d == null) {
            this.f7141d = new StringBuilder(32).append(getNumerator()).append(IOUtils.DIR_SEPARATOR_UNIX).append(getDenominator()).toString();
        }
        return this.f7141d;
    }

    public String toProperString() {
        if (this.f7142e == null) {
            if (this.f7138a == 0) {
                this.f7142e = "0";
            } else if (this.f7138a == this.f7139b) {
                this.f7142e = "1";
            } else if (this.f7138a == this.f7139b * -1) {
                this.f7142e = "-1";
            } else {
                if ((this.f7138a > 0 ? -this.f7138a : this.f7138a) < (-this.f7139b)) {
                    int properNumerator = getProperNumerator();
                    if (properNumerator == 0) {
                        this.f7142e = Integer.toString(getProperWhole());
                    } else {
                        this.f7142e = new StringBuilder(32).append(getProperWhole()).append(' ').append(properNumerator).append(IOUtils.DIR_SEPARATOR_UNIX).append(getDenominator()).toString();
                    }
                } else {
                    this.f7142e = new StringBuilder(32).append(getNumerator()).append(IOUtils.DIR_SEPARATOR_UNIX).append(getDenominator()).toString();
                }
            }
        }
        return this.f7142e;
    }
}
