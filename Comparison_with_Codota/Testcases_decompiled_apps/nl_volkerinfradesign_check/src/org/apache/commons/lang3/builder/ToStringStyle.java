package org.apache.commons.lang3.builder;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;
import java.util.WeakHashMap;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.SystemUtils;

public abstract class ToStringStyle implements Serializable {
    public static final ToStringStyle DEFAULT_STYLE = new C1954a();
    public static final ToStringStyle MULTI_LINE_STYLE = new C1955b();
    public static final ToStringStyle NO_FIELD_NAMES_STYLE = new C1956c();
    public static final ToStringStyle SHORT_PREFIX_STYLE = new C1957d();
    public static final ToStringStyle SIMPLE_STYLE = new C1958e();

    /* renamed from: a */
    private static final ThreadLocal<WeakHashMap<Object, Object>> f7067a = new ThreadLocal<>();
    private static final long serialVersionUID = -2587890625525655916L;

    /* renamed from: b */
    private boolean f7068b = true;

    /* renamed from: c */
    private boolean f7069c = true;

    /* renamed from: d */
    private boolean f7070d = false;

    /* renamed from: e */
    private boolean f7071e = true;

    /* renamed from: f */
    private String f7072f = "[";

    /* renamed from: g */
    private String f7073g = "]";

    /* renamed from: h */
    private String f7074h = "=";

    /* renamed from: i */
    private boolean f7075i = false;

    /* renamed from: j */
    private boolean f7076j = false;

    /* renamed from: k */
    private String f7077k = ",";

    /* renamed from: l */
    private String f7078l = "{";

    /* renamed from: m */
    private String f7079m = ",";

    /* renamed from: n */
    private boolean f7080n = true;

    /* renamed from: o */
    private String f7081o = "}";

    /* renamed from: p */
    private boolean f7082p = true;

    /* renamed from: q */
    private String f7083q = "<null>";

    /* renamed from: r */
    private String f7084r = "<size=";

    /* renamed from: s */
    private String f7085s = ">";

    /* renamed from: t */
    private String f7086t = "<";

    /* renamed from: u */
    private String f7087u = ">";

    /* renamed from: a */
    static Map<Object, Object> m7390a() {
        return f7067a.get();
    }

    /* renamed from: a */
    static boolean m7391a(Object obj) {
        Map<Object, Object> a = m7390a();
        return a != null && a.containsKey(obj);
    }

    /* renamed from: b */
    static void m7392b(Object obj) {
        if (obj != null) {
            if (m7390a() == null) {
                f7067a.set(new WeakHashMap());
            }
            m7390a().put(obj, (Object) null);
        }
    }

    /* renamed from: c */
    static void m7393c(Object obj) {
        Map<Object, Object> a;
        if (obj != null && (a = m7390a()) != null) {
            a.remove(obj);
            if (a.isEmpty()) {
                f7067a.remove();
            }
        }
    }

    public void appendSuper(StringBuffer stringBuffer, String str) {
        appendToString(stringBuffer, str);
    }

    public void appendToString(StringBuffer stringBuffer, String str) {
        int indexOf;
        int lastIndexOf;
        if (str != null && (indexOf = str.indexOf(this.f7072f) + this.f7072f.length()) != (lastIndexOf = str.lastIndexOf(this.f7073g)) && indexOf >= 0 && lastIndexOf >= 0) {
            String substring = str.substring(indexOf, lastIndexOf);
            if (this.f7075i) {
                removeLastFieldSeparator(stringBuffer);
            }
            stringBuffer.append(substring);
            appendFieldSeparator(stringBuffer);
        }
    }

    public void appendStart(StringBuffer stringBuffer, Object obj) {
        if (obj != null) {
            appendClassName(stringBuffer, obj);
            appendIdentityHashCode(stringBuffer, obj);
            appendContentStart(stringBuffer);
            if (this.f7075i) {
                appendFieldSeparator(stringBuffer);
            }
        }
    }

    public void appendEnd(StringBuffer stringBuffer, Object obj) {
        if (!this.f7076j) {
            removeLastFieldSeparator(stringBuffer);
        }
        appendContentEnd(stringBuffer);
        m7393c(obj);
    }

    /* access modifiers changed from: protected */
    public void removeLastFieldSeparator(StringBuffer stringBuffer) {
        boolean z = false;
        int length = stringBuffer.length();
        int length2 = this.f7077k.length();
        if (length > 0 && length2 > 0 && length >= length2) {
            int i = 0;
            while (true) {
                if (i >= length2) {
                    z = true;
                    break;
                } else if (stringBuffer.charAt((length - 1) - i) != this.f7077k.charAt((length2 - 1) - i)) {
                    break;
                } else {
                    i++;
                }
            }
            if (z) {
                stringBuffer.setLength(length - length2);
            }
        }
    }

    public void append(StringBuffer stringBuffer, String str, Object obj, Boolean bool) {
        appendFieldStart(stringBuffer, str);
        if (obj == null) {
            appendNullText(stringBuffer, str);
        } else {
            appendInternal(stringBuffer, str, obj, isFullDetail(bool));
        }
        appendFieldEnd(stringBuffer, str);
    }

    /* access modifiers changed from: protected */
    public void appendInternal(StringBuffer stringBuffer, String str, Object obj, boolean z) {
        if (!m7391a(obj) || (obj instanceof Number) || (obj instanceof Boolean) || (obj instanceof Character)) {
            m7392b(obj);
            try {
                if (obj instanceof Collection) {
                    if (z) {
                        appendDetail(stringBuffer, str, (Collection<?>) (Collection) obj);
                    } else {
                        appendSummarySize(stringBuffer, str, ((Collection) obj).size());
                    }
                } else if (obj instanceof Map) {
                    if (z) {
                        appendDetail(stringBuffer, str, (Map<?, ?>) (Map) obj);
                    } else {
                        appendSummarySize(stringBuffer, str, ((Map) obj).size());
                    }
                } else if (obj instanceof long[]) {
                    if (z) {
                        appendDetail(stringBuffer, str, (long[]) obj);
                    } else {
                        appendSummary(stringBuffer, str, (long[]) obj);
                    }
                } else if (obj instanceof int[]) {
                    if (z) {
                        appendDetail(stringBuffer, str, (int[]) obj);
                    } else {
                        appendSummary(stringBuffer, str, (int[]) obj);
                    }
                } else if (obj instanceof short[]) {
                    if (z) {
                        appendDetail(stringBuffer, str, (short[]) obj);
                    } else {
                        appendSummary(stringBuffer, str, (short[]) obj);
                    }
                } else if (obj instanceof byte[]) {
                    if (z) {
                        appendDetail(stringBuffer, str, (byte[]) obj);
                    } else {
                        appendSummary(stringBuffer, str, (byte[]) obj);
                    }
                } else if (obj instanceof char[]) {
                    if (z) {
                        appendDetail(stringBuffer, str, (char[]) obj);
                    } else {
                        appendSummary(stringBuffer, str, (char[]) obj);
                    }
                } else if (obj instanceof double[]) {
                    if (z) {
                        appendDetail(stringBuffer, str, (double[]) obj);
                    } else {
                        appendSummary(stringBuffer, str, (double[]) obj);
                    }
                } else if (obj instanceof float[]) {
                    if (z) {
                        appendDetail(stringBuffer, str, (float[]) obj);
                    } else {
                        appendSummary(stringBuffer, str, (float[]) obj);
                    }
                } else if (obj instanceof boolean[]) {
                    if (z) {
                        appendDetail(stringBuffer, str, (boolean[]) obj);
                    } else {
                        appendSummary(stringBuffer, str, (boolean[]) obj);
                    }
                } else if (obj.getClass().isArray()) {
                    if (z) {
                        appendDetail(stringBuffer, str, (Object[]) obj);
                    } else {
                        appendSummary(stringBuffer, str, (Object[]) obj);
                    }
                } else if (z) {
                    appendDetail(stringBuffer, str, obj);
                } else {
                    appendSummary(stringBuffer, str, obj);
                }
            } finally {
                m7393c(obj);
            }
        } else {
            appendCyclicObject(stringBuffer, str, obj);
        }
    }

    /* access modifiers changed from: protected */
    public void appendCyclicObject(StringBuffer stringBuffer, String str, Object obj) {
        ObjectUtils.identityToString(stringBuffer, obj);
    }

    public void appendDetail(StringBuffer stringBuffer, String str, Object obj) {
        stringBuffer.append(obj);
    }

    /* access modifiers changed from: protected */
    public void appendDetail(StringBuffer stringBuffer, String str, Collection<?> collection) {
        stringBuffer.append(collection);
    }

    /* access modifiers changed from: protected */
    public void appendDetail(StringBuffer stringBuffer, String str, Map<?, ?> map) {
        stringBuffer.append(map);
    }

    /* access modifiers changed from: protected */
    public void appendSummary(StringBuffer stringBuffer, String str, Object obj) {
        stringBuffer.append(this.f7086t);
        stringBuffer.append(getShortClassName(obj.getClass()));
        stringBuffer.append(this.f7087u);
    }

    public void append(StringBuffer stringBuffer, String str, long j) {
        appendFieldStart(stringBuffer, str);
        appendDetail(stringBuffer, str, j);
        appendFieldEnd(stringBuffer, str);
    }

    /* access modifiers changed from: protected */
    public void appendDetail(StringBuffer stringBuffer, String str, long j) {
        stringBuffer.append(j);
    }

    public void append(StringBuffer stringBuffer, String str, int i) {
        appendFieldStart(stringBuffer, str);
        appendDetail(stringBuffer, str, i);
        appendFieldEnd(stringBuffer, str);
    }

    /* access modifiers changed from: protected */
    public void appendDetail(StringBuffer stringBuffer, String str, int i) {
        stringBuffer.append(i);
    }

    public void append(StringBuffer stringBuffer, String str, short s) {
        appendFieldStart(stringBuffer, str);
        appendDetail(stringBuffer, str, s);
        appendFieldEnd(stringBuffer, str);
    }

    /* access modifiers changed from: protected */
    public void appendDetail(StringBuffer stringBuffer, String str, short s) {
        stringBuffer.append(s);
    }

    public void append(StringBuffer stringBuffer, String str, byte b) {
        appendFieldStart(stringBuffer, str);
        appendDetail(stringBuffer, str, b);
        appendFieldEnd(stringBuffer, str);
    }

    /* access modifiers changed from: protected */
    public void appendDetail(StringBuffer stringBuffer, String str, byte b) {
        stringBuffer.append(b);
    }

    public void append(StringBuffer stringBuffer, String str, char c) {
        appendFieldStart(stringBuffer, str);
        appendDetail(stringBuffer, str, c);
        appendFieldEnd(stringBuffer, str);
    }

    /* access modifiers changed from: protected */
    public void appendDetail(StringBuffer stringBuffer, String str, char c) {
        stringBuffer.append(c);
    }

    public void append(StringBuffer stringBuffer, String str, double d) {
        appendFieldStart(stringBuffer, str);
        appendDetail(stringBuffer, str, d);
        appendFieldEnd(stringBuffer, str);
    }

    /* access modifiers changed from: protected */
    public void appendDetail(StringBuffer stringBuffer, String str, double d) {
        stringBuffer.append(d);
    }

    public void append(StringBuffer stringBuffer, String str, float f) {
        appendFieldStart(stringBuffer, str);
        appendDetail(stringBuffer, str, f);
        appendFieldEnd(stringBuffer, str);
    }

    /* access modifiers changed from: protected */
    public void appendDetail(StringBuffer stringBuffer, String str, float f) {
        stringBuffer.append(f);
    }

    public void append(StringBuffer stringBuffer, String str, boolean z) {
        appendFieldStart(stringBuffer, str);
        appendDetail(stringBuffer, str, z);
        appendFieldEnd(stringBuffer, str);
    }

    /* access modifiers changed from: protected */
    public void appendDetail(StringBuffer stringBuffer, String str, boolean z) {
        stringBuffer.append(z);
    }

    public void append(StringBuffer stringBuffer, String str, Object[] objArr, Boolean bool) {
        appendFieldStart(stringBuffer, str);
        if (objArr == null) {
            appendNullText(stringBuffer, str);
        } else if (isFullDetail(bool)) {
            appendDetail(stringBuffer, str, objArr);
        } else {
            appendSummary(stringBuffer, str, objArr);
        }
        appendFieldEnd(stringBuffer, str);
    }

    /* access modifiers changed from: protected */
    public void appendDetail(StringBuffer stringBuffer, String str, Object[] objArr) {
        stringBuffer.append(this.f7078l);
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            if (i > 0) {
                stringBuffer.append(this.f7079m);
            }
            if (obj == null) {
                appendNullText(stringBuffer, str);
            } else {
                appendInternal(stringBuffer, str, obj, this.f7080n);
            }
        }
        stringBuffer.append(this.f7081o);
    }

    /* access modifiers changed from: protected */
    public void reflectionAppendArrayDetail(StringBuffer stringBuffer, String str, Object obj) {
        stringBuffer.append(this.f7078l);
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            Object obj2 = Array.get(obj, i);
            if (i > 0) {
                stringBuffer.append(this.f7079m);
            }
            if (obj2 == null) {
                appendNullText(stringBuffer, str);
            } else {
                appendInternal(stringBuffer, str, obj2, this.f7080n);
            }
        }
        stringBuffer.append(this.f7081o);
    }

    /* access modifiers changed from: protected */
    public void appendSummary(StringBuffer stringBuffer, String str, Object[] objArr) {
        appendSummarySize(stringBuffer, str, objArr.length);
    }

    public void append(StringBuffer stringBuffer, String str, long[] jArr, Boolean bool) {
        appendFieldStart(stringBuffer, str);
        if (jArr == null) {
            appendNullText(stringBuffer, str);
        } else if (isFullDetail(bool)) {
            appendDetail(stringBuffer, str, jArr);
        } else {
            appendSummary(stringBuffer, str, jArr);
        }
        appendFieldEnd(stringBuffer, str);
    }

    /* access modifiers changed from: protected */
    public void appendDetail(StringBuffer stringBuffer, String str, long[] jArr) {
        stringBuffer.append(this.f7078l);
        for (int i = 0; i < jArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(this.f7079m);
            }
            appendDetail(stringBuffer, str, jArr[i]);
        }
        stringBuffer.append(this.f7081o);
    }

    /* access modifiers changed from: protected */
    public void appendSummary(StringBuffer stringBuffer, String str, long[] jArr) {
        appendSummarySize(stringBuffer, str, jArr.length);
    }

    public void append(StringBuffer stringBuffer, String str, int[] iArr, Boolean bool) {
        appendFieldStart(stringBuffer, str);
        if (iArr == null) {
            appendNullText(stringBuffer, str);
        } else if (isFullDetail(bool)) {
            appendDetail(stringBuffer, str, iArr);
        } else {
            appendSummary(stringBuffer, str, iArr);
        }
        appendFieldEnd(stringBuffer, str);
    }

    /* access modifiers changed from: protected */
    public void appendDetail(StringBuffer stringBuffer, String str, int[] iArr) {
        stringBuffer.append(this.f7078l);
        for (int i = 0; i < iArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(this.f7079m);
            }
            appendDetail(stringBuffer, str, iArr[i]);
        }
        stringBuffer.append(this.f7081o);
    }

    /* access modifiers changed from: protected */
    public void appendSummary(StringBuffer stringBuffer, String str, int[] iArr) {
        appendSummarySize(stringBuffer, str, iArr.length);
    }

    public void append(StringBuffer stringBuffer, String str, short[] sArr, Boolean bool) {
        appendFieldStart(stringBuffer, str);
        if (sArr == null) {
            appendNullText(stringBuffer, str);
        } else if (isFullDetail(bool)) {
            appendDetail(stringBuffer, str, sArr);
        } else {
            appendSummary(stringBuffer, str, sArr);
        }
        appendFieldEnd(stringBuffer, str);
    }

    /* access modifiers changed from: protected */
    public void appendDetail(StringBuffer stringBuffer, String str, short[] sArr) {
        stringBuffer.append(this.f7078l);
        for (int i = 0; i < sArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(this.f7079m);
            }
            appendDetail(stringBuffer, str, sArr[i]);
        }
        stringBuffer.append(this.f7081o);
    }

    /* access modifiers changed from: protected */
    public void appendSummary(StringBuffer stringBuffer, String str, short[] sArr) {
        appendSummarySize(stringBuffer, str, sArr.length);
    }

    public void append(StringBuffer stringBuffer, String str, byte[] bArr, Boolean bool) {
        appendFieldStart(stringBuffer, str);
        if (bArr == null) {
            appendNullText(stringBuffer, str);
        } else if (isFullDetail(bool)) {
            appendDetail(stringBuffer, str, bArr);
        } else {
            appendSummary(stringBuffer, str, bArr);
        }
        appendFieldEnd(stringBuffer, str);
    }

    /* access modifiers changed from: protected */
    public void appendDetail(StringBuffer stringBuffer, String str, byte[] bArr) {
        stringBuffer.append(this.f7078l);
        for (int i = 0; i < bArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(this.f7079m);
            }
            appendDetail(stringBuffer, str, bArr[i]);
        }
        stringBuffer.append(this.f7081o);
    }

    /* access modifiers changed from: protected */
    public void appendSummary(StringBuffer stringBuffer, String str, byte[] bArr) {
        appendSummarySize(stringBuffer, str, bArr.length);
    }

    public void append(StringBuffer stringBuffer, String str, char[] cArr, Boolean bool) {
        appendFieldStart(stringBuffer, str);
        if (cArr == null) {
            appendNullText(stringBuffer, str);
        } else if (isFullDetail(bool)) {
            appendDetail(stringBuffer, str, cArr);
        } else {
            appendSummary(stringBuffer, str, cArr);
        }
        appendFieldEnd(stringBuffer, str);
    }

    /* access modifiers changed from: protected */
    public void appendDetail(StringBuffer stringBuffer, String str, char[] cArr) {
        stringBuffer.append(this.f7078l);
        for (int i = 0; i < cArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(this.f7079m);
            }
            appendDetail(stringBuffer, str, cArr[i]);
        }
        stringBuffer.append(this.f7081o);
    }

    /* access modifiers changed from: protected */
    public void appendSummary(StringBuffer stringBuffer, String str, char[] cArr) {
        appendSummarySize(stringBuffer, str, cArr.length);
    }

    public void append(StringBuffer stringBuffer, String str, double[] dArr, Boolean bool) {
        appendFieldStart(stringBuffer, str);
        if (dArr == null) {
            appendNullText(stringBuffer, str);
        } else if (isFullDetail(bool)) {
            appendDetail(stringBuffer, str, dArr);
        } else {
            appendSummary(stringBuffer, str, dArr);
        }
        appendFieldEnd(stringBuffer, str);
    }

    /* access modifiers changed from: protected */
    public void appendDetail(StringBuffer stringBuffer, String str, double[] dArr) {
        stringBuffer.append(this.f7078l);
        for (int i = 0; i < dArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(this.f7079m);
            }
            appendDetail(stringBuffer, str, dArr[i]);
        }
        stringBuffer.append(this.f7081o);
    }

    /* access modifiers changed from: protected */
    public void appendSummary(StringBuffer stringBuffer, String str, double[] dArr) {
        appendSummarySize(stringBuffer, str, dArr.length);
    }

    public void append(StringBuffer stringBuffer, String str, float[] fArr, Boolean bool) {
        appendFieldStart(stringBuffer, str);
        if (fArr == null) {
            appendNullText(stringBuffer, str);
        } else if (isFullDetail(bool)) {
            appendDetail(stringBuffer, str, fArr);
        } else {
            appendSummary(stringBuffer, str, fArr);
        }
        appendFieldEnd(stringBuffer, str);
    }

    /* access modifiers changed from: protected */
    public void appendDetail(StringBuffer stringBuffer, String str, float[] fArr) {
        stringBuffer.append(this.f7078l);
        for (int i = 0; i < fArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(this.f7079m);
            }
            appendDetail(stringBuffer, str, fArr[i]);
        }
        stringBuffer.append(this.f7081o);
    }

    /* access modifiers changed from: protected */
    public void appendSummary(StringBuffer stringBuffer, String str, float[] fArr) {
        appendSummarySize(stringBuffer, str, fArr.length);
    }

    public void append(StringBuffer stringBuffer, String str, boolean[] zArr, Boolean bool) {
        appendFieldStart(stringBuffer, str);
        if (zArr == null) {
            appendNullText(stringBuffer, str);
        } else if (isFullDetail(bool)) {
            appendDetail(stringBuffer, str, zArr);
        } else {
            appendSummary(stringBuffer, str, zArr);
        }
        appendFieldEnd(stringBuffer, str);
    }

    /* access modifiers changed from: protected */
    public void appendDetail(StringBuffer stringBuffer, String str, boolean[] zArr) {
        stringBuffer.append(this.f7078l);
        for (int i = 0; i < zArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(this.f7079m);
            }
            appendDetail(stringBuffer, str, zArr[i]);
        }
        stringBuffer.append(this.f7081o);
    }

    /* access modifiers changed from: protected */
    public void appendSummary(StringBuffer stringBuffer, String str, boolean[] zArr) {
        appendSummarySize(stringBuffer, str, zArr.length);
    }

    /* access modifiers changed from: protected */
    public void appendClassName(StringBuffer stringBuffer, Object obj) {
        if (this.f7069c && obj != null) {
            m7392b(obj);
            if (this.f7070d) {
                stringBuffer.append(getShortClassName(obj.getClass()));
            } else {
                stringBuffer.append(obj.getClass().getName());
            }
        }
    }

    /* access modifiers changed from: protected */
    public void appendIdentityHashCode(StringBuffer stringBuffer, Object obj) {
        if (isUseIdentityHashCode() && obj != null) {
            m7392b(obj);
            stringBuffer.append('@');
            stringBuffer.append(Integer.toHexString(System.identityHashCode(obj)));
        }
    }

    /* access modifiers changed from: protected */
    public void appendContentStart(StringBuffer stringBuffer) {
        stringBuffer.append(this.f7072f);
    }

    /* access modifiers changed from: protected */
    public void appendContentEnd(StringBuffer stringBuffer) {
        stringBuffer.append(this.f7073g);
    }

    /* access modifiers changed from: protected */
    public void appendNullText(StringBuffer stringBuffer, String str) {
        stringBuffer.append(this.f7083q);
    }

    /* access modifiers changed from: protected */
    public void appendFieldSeparator(StringBuffer stringBuffer) {
        stringBuffer.append(this.f7077k);
    }

    /* access modifiers changed from: protected */
    public void appendFieldStart(StringBuffer stringBuffer, String str) {
        if (this.f7068b && str != null) {
            stringBuffer.append(str);
            stringBuffer.append(this.f7074h);
        }
    }

    /* access modifiers changed from: protected */
    public void appendFieldEnd(StringBuffer stringBuffer, String str) {
        appendFieldSeparator(stringBuffer);
    }

    /* access modifiers changed from: protected */
    public void appendSummarySize(StringBuffer stringBuffer, String str, int i) {
        stringBuffer.append(this.f7084r);
        stringBuffer.append(i);
        stringBuffer.append(this.f7085s);
    }

    /* access modifiers changed from: protected */
    public boolean isFullDetail(Boolean bool) {
        if (bool == null) {
            return this.f7082p;
        }
        return bool.booleanValue();
    }

    public String getShortClassName(Class<?> cls) {
        return ClassUtils.getShortClassName(cls);
    }

    /* access modifiers changed from: protected */
    public boolean isUseClassName() {
        return this.f7069c;
    }

    public void setUseClassName(boolean z) {
        this.f7069c = z;
    }

    /* access modifiers changed from: protected */
    public boolean isUseShortClassName() {
        return this.f7070d;
    }

    public void setUseShortClassName(boolean z) {
        this.f7070d = z;
    }

    /* access modifiers changed from: protected */
    public boolean isUseIdentityHashCode() {
        return this.f7071e;
    }

    public void setUseIdentityHashCode(boolean z) {
        this.f7071e = z;
    }

    /* access modifiers changed from: protected */
    public boolean isUseFieldNames() {
        return this.f7068b;
    }

    /* access modifiers changed from: protected */
    public void setUseFieldNames(boolean z) {
        this.f7068b = z;
    }

    /* access modifiers changed from: protected */
    public boolean isDefaultFullDetail() {
        return this.f7082p;
    }

    public void setDefaultFullDetail(boolean z) {
        this.f7082p = z;
    }

    /* access modifiers changed from: protected */
    public boolean isArrayContentDetail() {
        return this.f7080n;
    }

    public void setArrayContentDetail(boolean z) {
        this.f7080n = z;
    }

    /* access modifiers changed from: protected */
    public String getArrayStart() {
        return this.f7078l;
    }

    public void setArrayStart(String str) {
        if (str == null) {
            str = "";
        }
        this.f7078l = str;
    }

    /* access modifiers changed from: protected */
    public String getArrayEnd() {
        return this.f7081o;
    }

    public void setArrayEnd(String str) {
        if (str == null) {
            str = "";
        }
        this.f7081o = str;
    }

    /* access modifiers changed from: protected */
    public String getArraySeparator() {
        return this.f7079m;
    }

    /* access modifiers changed from: protected */
    public void setArraySeparator(String str) {
        if (str == null) {
            str = "";
        }
        this.f7079m = str;
    }

    /* access modifiers changed from: protected */
    public String getContentStart() {
        return this.f7072f;
    }

    public void setContentStart(String str) {
        if (str == null) {
            str = "";
        }
        this.f7072f = str;
    }

    /* access modifiers changed from: protected */
    public String getContentEnd() {
        return this.f7073g;
    }

    public void setContentEnd(String str) {
        if (str == null) {
            str = "";
        }
        this.f7073g = str;
    }

    /* access modifiers changed from: protected */
    public String getFieldNameValueSeparator() {
        return this.f7074h;
    }

    /* access modifiers changed from: protected */
    public void setFieldNameValueSeparator(String str) {
        if (str == null) {
            str = "";
        }
        this.f7074h = str;
    }

    /* access modifiers changed from: protected */
    public String getFieldSeparator() {
        return this.f7077k;
    }

    public void setFieldSeparator(String str) {
        if (str == null) {
            str = "";
        }
        this.f7077k = str;
    }

    /* access modifiers changed from: protected */
    public boolean isFieldSeparatorAtStart() {
        return this.f7075i;
    }

    /* access modifiers changed from: protected */
    public void setFieldSeparatorAtStart(boolean z) {
        this.f7075i = z;
    }

    /* access modifiers changed from: protected */
    public boolean isFieldSeparatorAtEnd() {
        return this.f7076j;
    }

    /* access modifiers changed from: protected */
    public void setFieldSeparatorAtEnd(boolean z) {
        this.f7076j = z;
    }

    /* access modifiers changed from: protected */
    public String getNullText() {
        return this.f7083q;
    }

    /* access modifiers changed from: protected */
    public void setNullText(String str) {
        if (str == null) {
            str = "";
        }
        this.f7083q = str;
    }

    /* access modifiers changed from: protected */
    public String getSizeStartText() {
        return this.f7084r;
    }

    /* access modifiers changed from: protected */
    public void setSizeStartText(String str) {
        if (str == null) {
            str = "";
        }
        this.f7084r = str;
    }

    /* access modifiers changed from: protected */
    public String getSizeEndText() {
        return this.f7085s;
    }

    /* access modifiers changed from: protected */
    public void setSizeEndText(String str) {
        if (str == null) {
            str = "";
        }
        this.f7085s = str;
    }

    /* access modifiers changed from: protected */
    public String getSummaryObjectStartText() {
        return this.f7086t;
    }

    /* access modifiers changed from: protected */
    public void setSummaryObjectStartText(String str) {
        if (str == null) {
            str = "";
        }
        this.f7086t = str;
    }

    /* access modifiers changed from: protected */
    public String getSummaryObjectEndText() {
        return this.f7087u;
    }

    /* access modifiers changed from: protected */
    public void setSummaryObjectEndText(String str) {
        if (str == null) {
            str = "";
        }
        this.f7087u = str;
    }

    /* renamed from: org.apache.commons.lang3.builder.ToStringStyle$a */
    static final class C1954a extends ToStringStyle {
        private static final long serialVersionUID = 1;

        C1954a() {
        }

        private Object readResolve() {
            return ToStringStyle.DEFAULT_STYLE;
        }
    }

    /* renamed from: org.apache.commons.lang3.builder.ToStringStyle$c */
    static final class C1956c extends ToStringStyle {
        private static final long serialVersionUID = 1;

        C1956c() {
            setUseFieldNames(false);
        }

        private Object readResolve() {
            return ToStringStyle.NO_FIELD_NAMES_STYLE;
        }
    }

    /* renamed from: org.apache.commons.lang3.builder.ToStringStyle$d */
    static final class C1957d extends ToStringStyle {
        private static final long serialVersionUID = 1;

        C1957d() {
            setUseShortClassName(true);
            setUseIdentityHashCode(false);
        }

        private Object readResolve() {
            return ToStringStyle.SHORT_PREFIX_STYLE;
        }
    }

    /* renamed from: org.apache.commons.lang3.builder.ToStringStyle$e */
    static final class C1958e extends ToStringStyle {
        private static final long serialVersionUID = 1;

        C1958e() {
            setUseClassName(false);
            setUseIdentityHashCode(false);
            setUseFieldNames(false);
            setContentStart("");
            setContentEnd("");
        }

        private Object readResolve() {
            return ToStringStyle.SIMPLE_STYLE;
        }
    }

    /* renamed from: org.apache.commons.lang3.builder.ToStringStyle$b */
    static final class C1955b extends ToStringStyle {
        private static final long serialVersionUID = 1;

        C1955b() {
            setContentStart("[");
            setFieldSeparator(SystemUtils.LINE_SEPARATOR + "  ");
            setFieldSeparatorAtStart(true);
            setContentEnd(SystemUtils.LINE_SEPARATOR + "]");
        }

        private Object readResolve() {
            return ToStringStyle.MULTI_LINE_STYLE;
        }
    }
}
