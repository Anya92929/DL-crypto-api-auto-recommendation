package org.apache.commons.lang3.builder;

import org.apache.commons.lang3.ObjectUtils;

public class ToStringBuilder implements Builder<String> {

    /* renamed from: a */
    private static volatile ToStringStyle f7063a = ToStringStyle.DEFAULT_STYLE;

    /* renamed from: b */
    private final StringBuffer f7064b;

    /* renamed from: c */
    private final Object f7065c;

    /* renamed from: d */
    private final ToStringStyle f7066d;

    public static ToStringStyle getDefaultStyle() {
        return f7063a;
    }

    public static void setDefaultStyle(ToStringStyle toStringStyle) {
        if (toStringStyle == null) {
            throw new IllegalArgumentException("The style must not be null");
        }
        f7063a = toStringStyle;
    }

    public static String reflectionToString(Object obj) {
        return ReflectionToStringBuilder.toString(obj);
    }

    public static String reflectionToString(Object obj, ToStringStyle toStringStyle) {
        return ReflectionToStringBuilder.toString(obj, toStringStyle);
    }

    public static String reflectionToString(Object obj, ToStringStyle toStringStyle, boolean z) {
        return ReflectionToStringBuilder.toString(obj, toStringStyle, z, false, (Class) null);
    }

    public static <T> String reflectionToString(T t, ToStringStyle toStringStyle, boolean z, Class<? super T> cls) {
        return ReflectionToStringBuilder.toString(t, toStringStyle, z, false, cls);
    }

    public ToStringBuilder(Object obj) {
        this(obj, (ToStringStyle) null, (StringBuffer) null);
    }

    public ToStringBuilder(Object obj, ToStringStyle toStringStyle) {
        this(obj, toStringStyle, (StringBuffer) null);
    }

    public ToStringBuilder(Object obj, ToStringStyle toStringStyle, StringBuffer stringBuffer) {
        toStringStyle = toStringStyle == null ? getDefaultStyle() : toStringStyle;
        stringBuffer = stringBuffer == null ? new StringBuffer(512) : stringBuffer;
        this.f7064b = stringBuffer;
        this.f7066d = toStringStyle;
        this.f7065c = obj;
        toStringStyle.appendStart(stringBuffer, obj);
    }

    public ToStringBuilder append(boolean z) {
        this.f7066d.append(this.f7064b, (String) null, z);
        return this;
    }

    public ToStringBuilder append(boolean[] zArr) {
        this.f7066d.append(this.f7064b, (String) null, zArr, (Boolean) null);
        return this;
    }

    public ToStringBuilder append(byte b) {
        this.f7066d.append(this.f7064b, (String) null, b);
        return this;
    }

    public ToStringBuilder append(byte[] bArr) {
        this.f7066d.append(this.f7064b, (String) null, bArr, (Boolean) null);
        return this;
    }

    public ToStringBuilder append(char c) {
        this.f7066d.append(this.f7064b, (String) null, c);
        return this;
    }

    public ToStringBuilder append(char[] cArr) {
        this.f7066d.append(this.f7064b, (String) null, cArr, (Boolean) null);
        return this;
    }

    public ToStringBuilder append(double d) {
        this.f7066d.append(this.f7064b, (String) null, d);
        return this;
    }

    public ToStringBuilder append(double[] dArr) {
        this.f7066d.append(this.f7064b, (String) null, dArr, (Boolean) null);
        return this;
    }

    public ToStringBuilder append(float f) {
        this.f7066d.append(this.f7064b, (String) null, f);
        return this;
    }

    public ToStringBuilder append(float[] fArr) {
        this.f7066d.append(this.f7064b, (String) null, fArr, (Boolean) null);
        return this;
    }

    public ToStringBuilder append(int i) {
        this.f7066d.append(this.f7064b, (String) null, i);
        return this;
    }

    public ToStringBuilder append(int[] iArr) {
        this.f7066d.append(this.f7064b, (String) null, iArr, (Boolean) null);
        return this;
    }

    public ToStringBuilder append(long j) {
        this.f7066d.append(this.f7064b, (String) null, j);
        return this;
    }

    public ToStringBuilder append(long[] jArr) {
        this.f7066d.append(this.f7064b, (String) null, jArr, (Boolean) null);
        return this;
    }

    public ToStringBuilder append(Object obj) {
        this.f7066d.append(this.f7064b, (String) null, obj, (Boolean) null);
        return this;
    }

    public ToStringBuilder append(Object[] objArr) {
        this.f7066d.append(this.f7064b, (String) null, objArr, (Boolean) null);
        return this;
    }

    public ToStringBuilder append(short s) {
        this.f7066d.append(this.f7064b, (String) null, s);
        return this;
    }

    public ToStringBuilder append(short[] sArr) {
        this.f7066d.append(this.f7064b, (String) null, sArr, (Boolean) null);
        return this;
    }

    public ToStringBuilder append(String str, boolean z) {
        this.f7066d.append(this.f7064b, str, z);
        return this;
    }

    public ToStringBuilder append(String str, boolean[] zArr) {
        this.f7066d.append(this.f7064b, str, zArr, (Boolean) null);
        return this;
    }

    public ToStringBuilder append(String str, boolean[] zArr, boolean z) {
        this.f7066d.append(this.f7064b, str, zArr, Boolean.valueOf(z));
        return this;
    }

    public ToStringBuilder append(String str, byte b) {
        this.f7066d.append(this.f7064b, str, b);
        return this;
    }

    public ToStringBuilder append(String str, byte[] bArr) {
        this.f7066d.append(this.f7064b, str, bArr, (Boolean) null);
        return this;
    }

    public ToStringBuilder append(String str, byte[] bArr, boolean z) {
        this.f7066d.append(this.f7064b, str, bArr, Boolean.valueOf(z));
        return this;
    }

    public ToStringBuilder append(String str, char c) {
        this.f7066d.append(this.f7064b, str, c);
        return this;
    }

    public ToStringBuilder append(String str, char[] cArr) {
        this.f7066d.append(this.f7064b, str, cArr, (Boolean) null);
        return this;
    }

    public ToStringBuilder append(String str, char[] cArr, boolean z) {
        this.f7066d.append(this.f7064b, str, cArr, Boolean.valueOf(z));
        return this;
    }

    public ToStringBuilder append(String str, double d) {
        this.f7066d.append(this.f7064b, str, d);
        return this;
    }

    public ToStringBuilder append(String str, double[] dArr) {
        this.f7066d.append(this.f7064b, str, dArr, (Boolean) null);
        return this;
    }

    public ToStringBuilder append(String str, double[] dArr, boolean z) {
        this.f7066d.append(this.f7064b, str, dArr, Boolean.valueOf(z));
        return this;
    }

    public ToStringBuilder append(String str, float f) {
        this.f7066d.append(this.f7064b, str, f);
        return this;
    }

    public ToStringBuilder append(String str, float[] fArr) {
        this.f7066d.append(this.f7064b, str, fArr, (Boolean) null);
        return this;
    }

    public ToStringBuilder append(String str, float[] fArr, boolean z) {
        this.f7066d.append(this.f7064b, str, fArr, Boolean.valueOf(z));
        return this;
    }

    public ToStringBuilder append(String str, int i) {
        this.f7066d.append(this.f7064b, str, i);
        return this;
    }

    public ToStringBuilder append(String str, int[] iArr) {
        this.f7066d.append(this.f7064b, str, iArr, (Boolean) null);
        return this;
    }

    public ToStringBuilder append(String str, int[] iArr, boolean z) {
        this.f7066d.append(this.f7064b, str, iArr, Boolean.valueOf(z));
        return this;
    }

    public ToStringBuilder append(String str, long j) {
        this.f7066d.append(this.f7064b, str, j);
        return this;
    }

    public ToStringBuilder append(String str, long[] jArr) {
        this.f7066d.append(this.f7064b, str, jArr, (Boolean) null);
        return this;
    }

    public ToStringBuilder append(String str, long[] jArr, boolean z) {
        this.f7066d.append(this.f7064b, str, jArr, Boolean.valueOf(z));
        return this;
    }

    public ToStringBuilder append(String str, Object obj) {
        this.f7066d.append(this.f7064b, str, obj, (Boolean) null);
        return this;
    }

    public ToStringBuilder append(String str, Object obj, boolean z) {
        this.f7066d.append(this.f7064b, str, obj, Boolean.valueOf(z));
        return this;
    }

    public ToStringBuilder append(String str, Object[] objArr) {
        this.f7066d.append(this.f7064b, str, objArr, (Boolean) null);
        return this;
    }

    public ToStringBuilder append(String str, Object[] objArr, boolean z) {
        this.f7066d.append(this.f7064b, str, objArr, Boolean.valueOf(z));
        return this;
    }

    public ToStringBuilder append(String str, short s) {
        this.f7066d.append(this.f7064b, str, s);
        return this;
    }

    public ToStringBuilder append(String str, short[] sArr) {
        this.f7066d.append(this.f7064b, str, sArr, (Boolean) null);
        return this;
    }

    public ToStringBuilder append(String str, short[] sArr, boolean z) {
        this.f7066d.append(this.f7064b, str, sArr, Boolean.valueOf(z));
        return this;
    }

    public ToStringBuilder appendAsObjectToString(Object obj) {
        ObjectUtils.identityToString(getStringBuffer(), obj);
        return this;
    }

    public ToStringBuilder appendSuper(String str) {
        if (str != null) {
            this.f7066d.appendSuper(this.f7064b, str);
        }
        return this;
    }

    public ToStringBuilder appendToString(String str) {
        if (str != null) {
            this.f7066d.appendToString(this.f7064b, str);
        }
        return this;
    }

    public Object getObject() {
        return this.f7065c;
    }

    public StringBuffer getStringBuffer() {
        return this.f7064b;
    }

    public ToStringStyle getStyle() {
        return this.f7066d;
    }

    public String toString() {
        if (getObject() == null) {
            getStringBuffer().append(getStyle().getNullText());
        } else {
            this.f7066d.appendEnd(getStringBuffer(), getObject());
        }
        return getStringBuffer().toString();
    }

    public String build() {
        return toString();
    }
}
