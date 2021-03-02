package org.apache.commons.lang3.math;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.apache.commons.lang3.StringUtils;

public class NumberUtils {
    public static final Byte BYTE_MINUS_ONE = (byte) -1;
    public static final Byte BYTE_ONE = (byte) 1;
    public static final Byte BYTE_ZERO = (byte) 0;
    public static final Double DOUBLE_MINUS_ONE = new Double(-1.0d);
    public static final Double DOUBLE_ONE = new Double(1.0d);
    public static final Double DOUBLE_ZERO = new Double(0.0d);
    public static final Float FLOAT_MINUS_ONE = new Float(-1.0f);
    public static final Float FLOAT_ONE = new Float(1.0f);
    public static final Float FLOAT_ZERO = new Float(BitmapDescriptorFactory.HUE_RED);
    public static final Integer INTEGER_MINUS_ONE = new Integer(-1);
    public static final Integer INTEGER_ONE = new Integer(1);
    public static final Integer INTEGER_ZERO = new Integer(0);
    public static final Long LONG_MINUS_ONE = new Long(-1);
    public static final Long LONG_ONE = new Long(1);
    public static final Long LONG_ZERO = new Long(0);
    public static final Short SHORT_MINUS_ONE = new Short(-1);
    public static final Short SHORT_ONE = new Short(1);
    public static final Short SHORT_ZERO = new Short(0);

    public static int toInt(String str) {
        return toInt(str, 0);
    }

    public static int toInt(String str, int i) {
        if (str == null) {
            return i;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return i;
        }
    }

    public static long toLong(String str) {
        return toLong(str, 0);
    }

    public static long toLong(String str, long j) {
        if (str == null) {
            return j;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e) {
            return j;
        }
    }

    public static float toFloat(String str) {
        return toFloat(str, BitmapDescriptorFactory.HUE_RED);
    }

    public static float toFloat(String str, float f) {
        if (str == null) {
            return f;
        }
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException e) {
            return f;
        }
    }

    public static double toDouble(String str) {
        return toDouble(str, 0.0d);
    }

    public static double toDouble(String str, double d) {
        if (str == null) {
            return d;
        }
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException e) {
            return d;
        }
    }

    public static byte toByte(String str) {
        return toByte(str, (byte) 0);
    }

    public static byte toByte(String str, byte b) {
        if (str == null) {
            return b;
        }
        try {
            return Byte.parseByte(str);
        } catch (NumberFormatException e) {
            return b;
        }
    }

    public static short toShort(String str) {
        return toShort(str, 0);
    }

    public static short toShort(String str, short s) {
        if (str == null) {
            return s;
        }
        try {
            return Short.parseShort(str);
        } catch (NumberFormatException e) {
            return s;
        }
    }

    public static Number createNumber(String str) throws NumberFormatException {
        String str2;
        String str3;
        String str4;
        String str5 = null;
        if (str == null) {
            return null;
        }
        if (StringUtils.isBlank(str)) {
            throw new NumberFormatException("A blank string is not a valid number");
        } else if (str.startsWith("--")) {
            return null;
        } else {
            if (str.startsWith("0x") || str.startsWith("-0x")) {
                return createInteger(str);
            }
            char charAt = str.charAt(str.length() - 1);
            int indexOf = str.indexOf(46);
            int indexOf2 = str.indexOf(101) + str.indexOf(69) + 1;
            if (indexOf > -1) {
                if (indexOf2 <= -1) {
                    str4 = str.substring(indexOf + 1);
                } else if (indexOf2 < indexOf || indexOf2 > str.length()) {
                    throw new NumberFormatException(str + " is not a valid number.");
                } else {
                    str4 = str.substring(indexOf + 1, indexOf2);
                }
                str3 = str.substring(0, indexOf);
            } else {
                if (indexOf2 <= -1) {
                    str2 = str;
                } else if (indexOf2 > str.length()) {
                    throw new NumberFormatException(str + " is not a valid number.");
                } else {
                    str2 = str.substring(0, indexOf2);
                }
                str3 = str2;
                str4 = null;
            }
            if (Character.isDigit(charAt) || charAt == '.') {
                if (indexOf2 > -1 && indexOf2 < str.length() - 1) {
                    str5 = str.substring(indexOf2 + 1, str.length());
                }
                if (str4 == null && str5 == null) {
                    try {
                        return createInteger(str);
                    } catch (NumberFormatException e) {
                        try {
                            return createLong(str);
                        } catch (NumberFormatException e2) {
                            return createBigInteger(str);
                        }
                    }
                } else {
                    boolean z = m7421a(str3) && m7421a(str5);
                    try {
                        Float createFloat = createFloat(str);
                        if (!createFloat.isInfinite() && (createFloat.floatValue() != BitmapDescriptorFactory.HUE_RED || z)) {
                            return createFloat;
                        }
                    } catch (NumberFormatException e3) {
                    }
                    try {
                        Double createDouble = createDouble(str);
                        if (!createDouble.isInfinite() && (createDouble.doubleValue() != 0.0d || z)) {
                            return createDouble;
                        }
                    } catch (NumberFormatException e4) {
                    }
                    return createBigDecimal(str);
                }
            } else {
                if (indexOf2 > -1 && indexOf2 < str.length() - 1) {
                    str5 = str.substring(indexOf2 + 1, str.length() - 1);
                }
                String substring = str.substring(0, str.length() - 1);
                boolean z2 = m7421a(str3) && m7421a(str5);
                switch (charAt) {
                    case 'D':
                    case 'd':
                        break;
                    case 'F':
                    case 'f':
                        try {
                            Float createFloat2 = createFloat(substring);
                            if (!createFloat2.isInfinite() && (createFloat2.floatValue() != BitmapDescriptorFactory.HUE_RED || z2)) {
                                return createFloat2;
                            }
                        } catch (NumberFormatException e5) {
                            break;
                        }
                    case 'L':
                    case 'l':
                        if (str4 == null && str5 == null && ((substring.charAt(0) == '-' && isDigits(substring.substring(1))) || isDigits(substring))) {
                            try {
                                return createLong(substring);
                            } catch (NumberFormatException e6) {
                                return createBigInteger(substring);
                            }
                        } else {
                            throw new NumberFormatException(str + " is not a valid number.");
                        }
                }
                try {
                    Double createDouble2 = createDouble(substring);
                    if (!createDouble2.isInfinite() && (((double) createDouble2.floatValue()) != 0.0d || z2)) {
                        return createDouble2;
                    }
                } catch (NumberFormatException e7) {
                }
                try {
                    return createBigDecimal(substring);
                } catch (NumberFormatException e8) {
                }
            }
        }
        throw new NumberFormatException(str + " is not a valid number.");
    }

    /* renamed from: a */
    private static boolean m7421a(String str) {
        if (str == null) {
            return true;
        }
        for (int length = str.length() - 1; length >= 0; length--) {
            if (str.charAt(length) != '0') {
                return false;
            }
        }
        if (str.length() <= 0) {
            return false;
        }
        return true;
    }

    public static Float createFloat(String str) {
        if (str == null) {
            return null;
        }
        return Float.valueOf(str);
    }

    public static Double createDouble(String str) {
        if (str == null) {
            return null;
        }
        return Double.valueOf(str);
    }

    public static Integer createInteger(String str) {
        if (str == null) {
            return null;
        }
        return Integer.decode(str);
    }

    public static Long createLong(String str) {
        if (str == null) {
            return null;
        }
        return Long.valueOf(str);
    }

    public static BigInteger createBigInteger(String str) {
        if (str == null) {
            return null;
        }
        return new BigInteger(str);
    }

    public static BigDecimal createBigDecimal(String str) {
        if (str == null) {
            return null;
        }
        if (!StringUtils.isBlank(str)) {
            return new BigDecimal(str);
        }
        throw new NumberFormatException("A blank string is not a valid number");
    }

    public static long min(long[] jArr) {
        if (jArr == null) {
            throw new IllegalArgumentException("The Array must not be null");
        } else if (jArr.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty.");
        } else {
            long j = jArr[0];
            for (int i = 1; i < jArr.length; i++) {
                if (jArr[i] < j) {
                    j = jArr[i];
                }
            }
            return j;
        }
    }

    public static int min(int[] iArr) {
        if (iArr == null) {
            throw new IllegalArgumentException("The Array must not be null");
        } else if (iArr.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty.");
        } else {
            int i = iArr[0];
            for (int i2 = 1; i2 < iArr.length; i2++) {
                if (iArr[i2] < i) {
                    i = iArr[i2];
                }
            }
            return i;
        }
    }

    public static short min(short[] sArr) {
        if (sArr == null) {
            throw new IllegalArgumentException("The Array must not be null");
        } else if (sArr.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty.");
        } else {
            short s = sArr[0];
            for (int i = 1; i < sArr.length; i++) {
                if (sArr[i] < s) {
                    s = sArr[i];
                }
            }
            return s;
        }
    }

    public static byte min(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("The Array must not be null");
        } else if (bArr.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty.");
        } else {
            byte b = bArr[0];
            for (int i = 1; i < bArr.length; i++) {
                if (bArr[i] < b) {
                    b = bArr[i];
                }
            }
            return b;
        }
    }

    public static double min(double[] dArr) {
        if (dArr == null) {
            throw new IllegalArgumentException("The Array must not be null");
        } else if (dArr.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty.");
        } else {
            double d = dArr[0];
            for (int i = 1; i < dArr.length; i++) {
                if (Double.isNaN(dArr[i])) {
                    return Double.NaN;
                }
                if (dArr[i] < d) {
                    d = dArr[i];
                }
            }
            return d;
        }
    }

    public static float min(float[] fArr) {
        if (fArr == null) {
            throw new IllegalArgumentException("The Array must not be null");
        } else if (fArr.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty.");
        } else {
            float f = fArr[0];
            for (int i = 1; i < fArr.length; i++) {
                if (Float.isNaN(fArr[i])) {
                    return Float.NaN;
                }
                if (fArr[i] < f) {
                    f = fArr[i];
                }
            }
            return f;
        }
    }

    public static long max(long[] jArr) {
        if (jArr == null) {
            throw new IllegalArgumentException("The Array must not be null");
        } else if (jArr.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty.");
        } else {
            long j = jArr[0];
            for (int i = 1; i < jArr.length; i++) {
                if (jArr[i] > j) {
                    j = jArr[i];
                }
            }
            return j;
        }
    }

    public static int max(int[] iArr) {
        if (iArr == null) {
            throw new IllegalArgumentException("The Array must not be null");
        } else if (iArr.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty.");
        } else {
            int i = iArr[0];
            for (int i2 = 1; i2 < iArr.length; i2++) {
                if (iArr[i2] > i) {
                    i = iArr[i2];
                }
            }
            return i;
        }
    }

    public static short max(short[] sArr) {
        if (sArr == null) {
            throw new IllegalArgumentException("The Array must not be null");
        } else if (sArr.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty.");
        } else {
            short s = sArr[0];
            for (int i = 1; i < sArr.length; i++) {
                if (sArr[i] > s) {
                    s = sArr[i];
                }
            }
            return s;
        }
    }

    public static byte max(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("The Array must not be null");
        } else if (bArr.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty.");
        } else {
            byte b = bArr[0];
            for (int i = 1; i < bArr.length; i++) {
                if (bArr[i] > b) {
                    b = bArr[i];
                }
            }
            return b;
        }
    }

    public static double max(double[] dArr) {
        if (dArr == null) {
            throw new IllegalArgumentException("The Array must not be null");
        } else if (dArr.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty.");
        } else {
            double d = dArr[0];
            for (int i = 1; i < dArr.length; i++) {
                if (Double.isNaN(dArr[i])) {
                    return Double.NaN;
                }
                if (dArr[i] > d) {
                    d = dArr[i];
                }
            }
            return d;
        }
    }

    public static float max(float[] fArr) {
        if (fArr == null) {
            throw new IllegalArgumentException("The Array must not be null");
        } else if (fArr.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty.");
        } else {
            float f = fArr[0];
            for (int i = 1; i < fArr.length; i++) {
                if (Float.isNaN(fArr[i])) {
                    return Float.NaN;
                }
                if (fArr[i] > f) {
                    f = fArr[i];
                }
            }
            return f;
        }
    }

    public static long min(long j, long j2, long j3) {
        long j4;
        if (j2 < j) {
            j4 = j2;
        } else {
            j4 = j;
        }
        return j3 < j4 ? j3 : j4;
    }

    public static int min(int i, int i2, int i3) {
        int i4;
        if (i2 < i) {
            i4 = i2;
        } else {
            i4 = i;
        }
        return i3 < i4 ? i3 : i4;
    }

    public static short min(short s, short s2, short s3) {
        short s4;
        if (s2 < s) {
            s4 = s2;
        } else {
            s4 = s;
        }
        return s3 < s4 ? s3 : s4;
    }

    public static byte min(byte b, byte b2, byte b3) {
        byte b4;
        if (b2 < b) {
            b4 = b2;
        } else {
            b4 = b;
        }
        return b3 < b4 ? b3 : b4;
    }

    public static double min(double d, double d2, double d3) {
        return Math.min(Math.min(d, d2), d3);
    }

    public static float min(float f, float f2, float f3) {
        return Math.min(Math.min(f, f2), f3);
    }

    public static long max(long j, long j2, long j3) {
        long j4;
        if (j2 > j) {
            j4 = j2;
        } else {
            j4 = j;
        }
        return j3 > j4 ? j3 : j4;
    }

    public static int max(int i, int i2, int i3) {
        int i4;
        if (i2 > i) {
            i4 = i2;
        } else {
            i4 = i;
        }
        return i3 > i4 ? i3 : i4;
    }

    public static short max(short s, short s2, short s3) {
        short s4;
        if (s2 > s) {
            s4 = s2;
        } else {
            s4 = s;
        }
        return s3 > s4 ? s3 : s4;
    }

    public static byte max(byte b, byte b2, byte b3) {
        byte b4;
        if (b2 > b) {
            b4 = b2;
        } else {
            b4 = b;
        }
        return b3 > b4 ? b3 : b4;
    }

    public static double max(double d, double d2, double d3) {
        return Math.max(Math.max(d, d2), d3);
    }

    public static float max(float f, float f2, float f3) {
        return Math.max(Math.max(f, f2), f3);
    }

    public static boolean isDigits(String str) {
        if (StringUtils.isEmpty(str)) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNumber(String str) {
        boolean z = true;
        if (StringUtils.isEmpty(str)) {
            return false;
        }
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        int i = charArray[0] == '-' ? 1 : 0;
        if (length > i + 1 && charArray[i] == '0' && charArray[i + 1] == 'x') {
            int i2 = i + 2;
            if (i2 == length) {
                return false;
            }
            while (i2 < charArray.length) {
                if ((charArray[i2] < '0' || charArray[i2] > '9') && ((charArray[i2] < 'a' || charArray[i2] > 'f') && (charArray[i2] < 'A' || charArray[i2] > 'F'))) {
                    return false;
                }
                i2++;
            }
            return true;
        }
        int i3 = length - 1;
        int i4 = i;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        while (true) {
            if (i4 < i3 || (i4 < i3 + 1 && z2 && !z5)) {
                if (charArray[i4] >= '0' && charArray[i4] <= '9') {
                    z5 = true;
                    z2 = false;
                } else if (charArray[i4] == '.') {
                    if (z3 || z4) {
                        return false;
                    }
                    z3 = true;
                } else if (charArray[i4] == 'e' || charArray[i4] == 'E') {
                    if (z4 || !z5) {
                        return false;
                    }
                    z2 = true;
                    z4 = true;
                } else if ((charArray[i4] != '+' && charArray[i4] != '-') || !z2) {
                    return false;
                } else {
                    z5 = false;
                    z2 = false;
                }
                i4++;
            }
        }
        if (i4 >= charArray.length) {
            if (z2 || !z5) {
                z = false;
            }
            return z;
        } else if (charArray[i4] >= '0' && charArray[i4] <= '9') {
            return true;
        } else {
            if (charArray[i4] == 'e' || charArray[i4] == 'E') {
                return false;
            }
            if (charArray[i4] == '.') {
                if (z3 || z4) {
                    return false;
                }
                return z5;
            } else if (!z2 && (charArray[i4] == 'd' || charArray[i4] == 'D' || charArray[i4] == 'f' || charArray[i4] == 'F')) {
                return z5;
            } else {
                if (charArray[i4] != 'l' && charArray[i4] != 'L') {
                    return false;
                }
                if (!z5 || z4 || z3) {
                    z = false;
                }
                return z;
            }
        }
    }
}
