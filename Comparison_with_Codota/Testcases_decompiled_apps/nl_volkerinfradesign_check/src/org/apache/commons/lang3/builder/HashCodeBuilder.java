package org.apache.commons.lang3.builder;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.apache.commons.lang3.ArrayUtils;

public class HashCodeBuilder implements Builder<Integer> {

    /* renamed from: a */
    private static final ThreadLocal<Set<C1332jq>> f7057a = new ThreadLocal<>();

    /* renamed from: b */
    private final int f7058b;

    /* renamed from: c */
    private int f7059c;

    /* renamed from: a */
    static Set<C1332jq> m7383a() {
        return f7057a.get();
    }

    /* renamed from: a */
    static boolean m7385a(Object obj) {
        Set<C1332jq> a = m7383a();
        return a != null && a.contains(new C1332jq(obj));
    }

    /* renamed from: a */
    private static void m7384a(Object obj, Class<?> cls, HashCodeBuilder hashCodeBuilder, boolean z, String[] strArr) {
        if (!m7385a(obj)) {
            try {
                m7386b(obj);
                Field[] declaredFields = cls.getDeclaredFields();
                AccessibleObject.setAccessible(declaredFields, true);
                for (Field field : declaredFields) {
                    if (!ArrayUtils.contains((Object[]) strArr, (Object) field.getName()) && field.getName().indexOf(36) == -1 && ((z || !Modifier.isTransient(field.getModifiers())) && !Modifier.isStatic(field.getModifiers()))) {
                        hashCodeBuilder.append(field.get(obj));
                    }
                }
                m7387c(obj);
            } catch (IllegalAccessException e) {
                throw new InternalError("Unexpected IllegalAccessException");
            } catch (Throwable th) {
                m7387c(obj);
                throw th;
            }
        }
    }

    public static int reflectionHashCode(int i, int i2, Object obj) {
        return reflectionHashCode(i, i2, obj, false, (Class) null, new String[0]);
    }

    public static int reflectionHashCode(int i, int i2, Object obj, boolean z) {
        return reflectionHashCode(i, i2, obj, z, (Class) null, new String[0]);
    }

    public static <T> int reflectionHashCode(int i, int i2, T t, boolean z, Class<? super T> cls, String... strArr) {
        if (t == null) {
            throw new IllegalArgumentException("The object to build a hash code for must not be null");
        }
        HashCodeBuilder hashCodeBuilder = new HashCodeBuilder(i, i2);
        Class cls2 = t.getClass();
        m7384a(t, cls2, hashCodeBuilder, z, strArr);
        while (cls2.getSuperclass() != null && cls2 != cls) {
            cls2 = cls2.getSuperclass();
            m7384a(t, cls2, hashCodeBuilder, z, strArr);
        }
        return hashCodeBuilder.toHashCode();
    }

    public static int reflectionHashCode(Object obj, boolean z) {
        return reflectionHashCode(17, 37, obj, z, (Class) null, new String[0]);
    }

    public static int reflectionHashCode(Object obj, Collection<String> collection) {
        return reflectionHashCode(obj, ReflectionToStringBuilder.m7388a(collection));
    }

    public static int reflectionHashCode(Object obj, String... strArr) {
        return reflectionHashCode(17, 37, obj, false, (Class) null, strArr);
    }

    /* renamed from: b */
    static void m7386b(Object obj) {
        synchronized (HashCodeBuilder.class) {
            if (m7383a() == null) {
                f7057a.set(new HashSet());
            }
        }
        m7383a().add(new C1332jq(obj));
    }

    /* renamed from: c */
    static void m7387c(Object obj) {
        Set<C1332jq> a = m7383a();
        if (a != null) {
            a.remove(new C1332jq(obj));
            synchronized (HashCodeBuilder.class) {
                Set<C1332jq> a2 = m7383a();
                if (a2 != null && a2.isEmpty()) {
                    f7057a.remove();
                }
            }
        }
    }

    public HashCodeBuilder() {
        this.f7059c = 0;
        this.f7058b = 37;
        this.f7059c = 17;
    }

    public HashCodeBuilder(int i, int i2) {
        this.f7059c = 0;
        if (i == 0) {
            throw new IllegalArgumentException("HashCodeBuilder requires a non zero initial value");
        } else if (i % 2 == 0) {
            throw new IllegalArgumentException("HashCodeBuilder requires an odd initial value");
        } else if (i2 == 0) {
            throw new IllegalArgumentException("HashCodeBuilder requires a non zero multiplier");
        } else if (i2 % 2 == 0) {
            throw new IllegalArgumentException("HashCodeBuilder requires an odd multiplier");
        } else {
            this.f7058b = i2;
            this.f7059c = i;
        }
    }

    public HashCodeBuilder append(boolean z) {
        this.f7059c = (z ? 0 : 1) + (this.f7058b * this.f7059c);
        return this;
    }

    public HashCodeBuilder append(boolean[] zArr) {
        if (zArr == null) {
            this.f7059c *= this.f7058b;
        } else {
            for (boolean append : zArr) {
                append(append);
            }
        }
        return this;
    }

    public HashCodeBuilder append(byte b) {
        this.f7059c = (this.f7059c * this.f7058b) + b;
        return this;
    }

    public HashCodeBuilder append(byte[] bArr) {
        if (bArr == null) {
            this.f7059c *= this.f7058b;
        } else {
            for (byte append : bArr) {
                append(append);
            }
        }
        return this;
    }

    public HashCodeBuilder append(char c) {
        this.f7059c = (this.f7059c * this.f7058b) + c;
        return this;
    }

    public HashCodeBuilder append(char[] cArr) {
        if (cArr == null) {
            this.f7059c *= this.f7058b;
        } else {
            for (char append : cArr) {
                append(append);
            }
        }
        return this;
    }

    public HashCodeBuilder append(double d) {
        return append(Double.doubleToLongBits(d));
    }

    public HashCodeBuilder append(double[] dArr) {
        if (dArr == null) {
            this.f7059c *= this.f7058b;
        } else {
            for (double append : dArr) {
                append(append);
            }
        }
        return this;
    }

    public HashCodeBuilder append(float f) {
        this.f7059c = (this.f7059c * this.f7058b) + Float.floatToIntBits(f);
        return this;
    }

    public HashCodeBuilder append(float[] fArr) {
        if (fArr == null) {
            this.f7059c *= this.f7058b;
        } else {
            for (float append : fArr) {
                append(append);
            }
        }
        return this;
    }

    public HashCodeBuilder append(int i) {
        this.f7059c = (this.f7059c * this.f7058b) + i;
        return this;
    }

    public HashCodeBuilder append(int[] iArr) {
        if (iArr == null) {
            this.f7059c *= this.f7058b;
        } else {
            for (int append : iArr) {
                append(append);
            }
        }
        return this;
    }

    public HashCodeBuilder append(long j) {
        this.f7059c = (this.f7059c * this.f7058b) + ((int) ((j >> 32) ^ j));
        return this;
    }

    public HashCodeBuilder append(long[] jArr) {
        if (jArr == null) {
            this.f7059c *= this.f7058b;
        } else {
            for (long append : jArr) {
                append(append);
            }
        }
        return this;
    }

    public HashCodeBuilder append(Object obj) {
        if (obj == null) {
            this.f7059c *= this.f7058b;
        } else if (!obj.getClass().isArray()) {
            this.f7059c = (this.f7059c * this.f7058b) + obj.hashCode();
        } else if (obj instanceof long[]) {
            append((long[]) obj);
        } else if (obj instanceof int[]) {
            append((int[]) obj);
        } else if (obj instanceof short[]) {
            append((short[]) obj);
        } else if (obj instanceof char[]) {
            append((char[]) obj);
        } else if (obj instanceof byte[]) {
            append((byte[]) obj);
        } else if (obj instanceof double[]) {
            append((double[]) obj);
        } else if (obj instanceof float[]) {
            append((float[]) obj);
        } else if (obj instanceof boolean[]) {
            append((boolean[]) obj);
        } else {
            append((Object[]) obj);
        }
        return this;
    }

    public HashCodeBuilder append(Object[] objArr) {
        if (objArr == null) {
            this.f7059c *= this.f7058b;
        } else {
            for (Object append : objArr) {
                append(append);
            }
        }
        return this;
    }

    public HashCodeBuilder append(short s) {
        this.f7059c = (this.f7059c * this.f7058b) + s;
        return this;
    }

    public HashCodeBuilder append(short[] sArr) {
        if (sArr == null) {
            this.f7059c *= this.f7058b;
        } else {
            for (short append : sArr) {
                append(append);
            }
        }
        return this;
    }

    public HashCodeBuilder appendSuper(int i) {
        this.f7059c = (this.f7059c * this.f7058b) + i;
        return this;
    }

    public int toHashCode() {
        return this.f7059c;
    }

    public Integer build() {
        return Integer.valueOf(toHashCode());
    }

    public int hashCode() {
        return toHashCode();
    }
}
