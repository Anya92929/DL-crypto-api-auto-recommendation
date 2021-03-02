package org.apache.commons.lang3.builder;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.Comparator;
import org.apache.commons.lang3.ArrayUtils;

public class CompareToBuilder implements Builder<Integer> {

    /* renamed from: a */
    private int f7054a = 0;

    public static int reflectionCompare(Object obj, Object obj2) {
        return reflectionCompare(obj, obj2, false, (Class<?>) null, new String[0]);
    }

    public static int reflectionCompare(Object obj, Object obj2, boolean z) {
        return reflectionCompare(obj, obj2, z, (Class<?>) null, new String[0]);
    }

    public static int reflectionCompare(Object obj, Object obj2, Collection<String> collection) {
        return reflectionCompare(obj, obj2, ReflectionToStringBuilder.m7388a(collection));
    }

    public static int reflectionCompare(Object obj, Object obj2, String... strArr) {
        return reflectionCompare(obj, obj2, false, (Class<?>) null, strArr);
    }

    public static int reflectionCompare(Object obj, Object obj2, boolean z, Class<?> cls, String... strArr) {
        if (obj == obj2) {
            return 0;
        }
        if (obj == null || obj2 == null) {
            throw new NullPointerException();
        }
        Class cls2 = obj.getClass();
        if (!cls2.isInstance(obj2)) {
            throw new ClassCastException();
        }
        CompareToBuilder compareToBuilder = new CompareToBuilder();
        m7376a(obj, obj2, cls2, compareToBuilder, z, strArr);
        while (cls2.getSuperclass() != null && cls2 != cls) {
            cls2 = cls2.getSuperclass();
            m7376a(obj, obj2, cls2, compareToBuilder, z, strArr);
        }
        return compareToBuilder.toComparison();
    }

    /* renamed from: a */
    private static void m7376a(Object obj, Object obj2, Class<?> cls, CompareToBuilder compareToBuilder, boolean z, String[] strArr) {
        Field[] declaredFields = cls.getDeclaredFields();
        AccessibleObject.setAccessible(declaredFields, true);
        for (int i = 0; i < declaredFields.length && compareToBuilder.f7054a == 0; i++) {
            Field field = declaredFields[i];
            if (!ArrayUtils.contains((Object[]) strArr, (Object) field.getName()) && field.getName().indexOf(36) == -1 && ((z || !Modifier.isTransient(field.getModifiers())) && !Modifier.isStatic(field.getModifiers()))) {
                try {
                    compareToBuilder.append(field.get(obj), field.get(obj2));
                } catch (IllegalAccessException e) {
                    throw new InternalError("Unexpected IllegalAccessException");
                }
            }
        }
    }

    public CompareToBuilder appendSuper(int i) {
        if (this.f7054a == 0) {
            this.f7054a = i;
        }
        return this;
    }

    public CompareToBuilder append(Object obj, Object obj2) {
        return append(obj, obj2, (Comparator<?>) null);
    }

    public CompareToBuilder append(Object obj, Object obj2, Comparator<?> comparator) {
        if (this.f7054a == 0 && obj != obj2) {
            if (obj == null) {
                this.f7054a = -1;
            } else if (obj2 == null) {
                this.f7054a = 1;
            } else if (obj.getClass().isArray()) {
                if (obj instanceof long[]) {
                    append((long[]) obj, (long[]) obj2);
                } else if (obj instanceof int[]) {
                    append((int[]) obj, (int[]) obj2);
                } else if (obj instanceof short[]) {
                    append((short[]) obj, (short[]) obj2);
                } else if (obj instanceof char[]) {
                    append((char[]) obj, (char[]) obj2);
                } else if (obj instanceof byte[]) {
                    append((byte[]) obj, (byte[]) obj2);
                } else if (obj instanceof double[]) {
                    append((double[]) obj, (double[]) obj2);
                } else if (obj instanceof float[]) {
                    append((float[]) obj, (float[]) obj2);
                } else if (obj instanceof boolean[]) {
                    append((boolean[]) obj, (boolean[]) obj2);
                } else {
                    append((Object[]) obj, (Object[]) obj2, comparator);
                }
            } else if (comparator == null) {
                this.f7054a = ((Comparable) obj).compareTo(obj2);
            } else {
                this.f7054a = comparator.compare(obj, obj2);
            }
        }
        return this;
    }

    public CompareToBuilder append(long j, long j2) {
        if (this.f7054a == 0) {
            this.f7054a = j < j2 ? -1 : j > j2 ? 1 : 0;
        }
        return this;
    }

    public CompareToBuilder append(int i, int i2) {
        if (this.f7054a == 0) {
            this.f7054a = i < i2 ? -1 : i > i2 ? 1 : 0;
        }
        return this;
    }

    public CompareToBuilder append(short s, short s2) {
        if (this.f7054a == 0) {
            this.f7054a = s < s2 ? -1 : s > s2 ? 1 : 0;
        }
        return this;
    }

    public CompareToBuilder append(char c, char c2) {
        if (this.f7054a == 0) {
            this.f7054a = c < c2 ? -1 : c > c2 ? 1 : 0;
        }
        return this;
    }

    public CompareToBuilder append(byte b, byte b2) {
        if (this.f7054a == 0) {
            this.f7054a = b < b2 ? -1 : b > b2 ? 1 : 0;
        }
        return this;
    }

    public CompareToBuilder append(double d, double d2) {
        if (this.f7054a == 0) {
            this.f7054a = Double.compare(d, d2);
        }
        return this;
    }

    public CompareToBuilder append(float f, float f2) {
        if (this.f7054a == 0) {
            this.f7054a = Float.compare(f, f2);
        }
        return this;
    }

    public CompareToBuilder append(boolean z, boolean z2) {
        if (this.f7054a == 0 && z != z2) {
            if (!z) {
                this.f7054a = -1;
            } else {
                this.f7054a = 1;
            }
        }
        return this;
    }

    public CompareToBuilder append(Object[] objArr, Object[] objArr2) {
        return append(objArr, objArr2, (Comparator<?>) null);
    }

    public CompareToBuilder append(Object[] objArr, Object[] objArr2, Comparator<?> comparator) {
        int i = -1;
        if (this.f7054a == 0 && objArr != objArr2) {
            if (objArr == null) {
                this.f7054a = -1;
            } else if (objArr2 == null) {
                this.f7054a = 1;
            } else if (objArr.length != objArr2.length) {
                if (objArr.length >= objArr2.length) {
                    i = 1;
                }
                this.f7054a = i;
            } else {
                for (int i2 = 0; i2 < objArr.length && this.f7054a == 0; i2++) {
                    append(objArr[i2], objArr2[i2], comparator);
                }
            }
        }
        return this;
    }

    public CompareToBuilder append(long[] jArr, long[] jArr2) {
        int i = -1;
        if (this.f7054a == 0 && jArr != jArr2) {
            if (jArr == null) {
                this.f7054a = -1;
            } else if (jArr2 == null) {
                this.f7054a = 1;
            } else if (jArr.length != jArr2.length) {
                if (jArr.length >= jArr2.length) {
                    i = 1;
                }
                this.f7054a = i;
            } else {
                for (int i2 = 0; i2 < jArr.length && this.f7054a == 0; i2++) {
                    append(jArr[i2], jArr2[i2]);
                }
            }
        }
        return this;
    }

    public CompareToBuilder append(int[] iArr, int[] iArr2) {
        int i = -1;
        if (this.f7054a == 0 && iArr != iArr2) {
            if (iArr == null) {
                this.f7054a = -1;
            } else if (iArr2 == null) {
                this.f7054a = 1;
            } else if (iArr.length != iArr2.length) {
                if (iArr.length >= iArr2.length) {
                    i = 1;
                }
                this.f7054a = i;
            } else {
                for (int i2 = 0; i2 < iArr.length && this.f7054a == 0; i2++) {
                    append(iArr[i2], iArr2[i2]);
                }
            }
        }
        return this;
    }

    public CompareToBuilder append(short[] sArr, short[] sArr2) {
        int i = -1;
        if (this.f7054a == 0 && sArr != sArr2) {
            if (sArr == null) {
                this.f7054a = -1;
            } else if (sArr2 == null) {
                this.f7054a = 1;
            } else if (sArr.length != sArr2.length) {
                if (sArr.length >= sArr2.length) {
                    i = 1;
                }
                this.f7054a = i;
            } else {
                for (int i2 = 0; i2 < sArr.length && this.f7054a == 0; i2++) {
                    append(sArr[i2], sArr2[i2]);
                }
            }
        }
        return this;
    }

    public CompareToBuilder append(char[] cArr, char[] cArr2) {
        int i = -1;
        if (this.f7054a == 0 && cArr != cArr2) {
            if (cArr == null) {
                this.f7054a = -1;
            } else if (cArr2 == null) {
                this.f7054a = 1;
            } else if (cArr.length != cArr2.length) {
                if (cArr.length >= cArr2.length) {
                    i = 1;
                }
                this.f7054a = i;
            } else {
                for (int i2 = 0; i2 < cArr.length && this.f7054a == 0; i2++) {
                    append(cArr[i2], cArr2[i2]);
                }
            }
        }
        return this;
    }

    public CompareToBuilder append(byte[] bArr, byte[] bArr2) {
        int i = -1;
        if (this.f7054a == 0 && bArr != bArr2) {
            if (bArr == null) {
                this.f7054a = -1;
            } else if (bArr2 == null) {
                this.f7054a = 1;
            } else if (bArr.length != bArr2.length) {
                if (bArr.length >= bArr2.length) {
                    i = 1;
                }
                this.f7054a = i;
            } else {
                for (int i2 = 0; i2 < bArr.length && this.f7054a == 0; i2++) {
                    append(bArr[i2], bArr2[i2]);
                }
            }
        }
        return this;
    }

    public CompareToBuilder append(double[] dArr, double[] dArr2) {
        int i = -1;
        if (this.f7054a == 0 && dArr != dArr2) {
            if (dArr == null) {
                this.f7054a = -1;
            } else if (dArr2 == null) {
                this.f7054a = 1;
            } else if (dArr.length != dArr2.length) {
                if (dArr.length >= dArr2.length) {
                    i = 1;
                }
                this.f7054a = i;
            } else {
                for (int i2 = 0; i2 < dArr.length && this.f7054a == 0; i2++) {
                    append(dArr[i2], dArr2[i2]);
                }
            }
        }
        return this;
    }

    public CompareToBuilder append(float[] fArr, float[] fArr2) {
        int i = -1;
        if (this.f7054a == 0 && fArr != fArr2) {
            if (fArr == null) {
                this.f7054a = -1;
            } else if (fArr2 == null) {
                this.f7054a = 1;
            } else if (fArr.length != fArr2.length) {
                if (fArr.length >= fArr2.length) {
                    i = 1;
                }
                this.f7054a = i;
            } else {
                for (int i2 = 0; i2 < fArr.length && this.f7054a == 0; i2++) {
                    append(fArr[i2], fArr2[i2]);
                }
            }
        }
        return this;
    }

    public CompareToBuilder append(boolean[] zArr, boolean[] zArr2) {
        int i = -1;
        if (this.f7054a == 0 && zArr != zArr2) {
            if (zArr == null) {
                this.f7054a = -1;
            } else if (zArr2 == null) {
                this.f7054a = 1;
            } else if (zArr.length != zArr2.length) {
                if (zArr.length >= zArr2.length) {
                    i = 1;
                }
                this.f7054a = i;
            } else {
                for (int i2 = 0; i2 < zArr.length && this.f7054a == 0; i2++) {
                    append(zArr[i2], zArr2[i2]);
                }
            }
        }
        return this;
    }

    public int toComparison() {
        return this.f7054a;
    }

    public Integer build() {
        return Integer.valueOf(toComparison());
    }
}
