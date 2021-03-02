package org.apache.commons.lang3.text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.apache.commons.lang3.ArrayUtils;

public class StrTokenizer implements Cloneable, ListIterator<String> {

    /* renamed from: a */
    private static final StrTokenizer f7182a = new StrTokenizer();

    /* renamed from: b */
    private static final StrTokenizer f7183b = new StrTokenizer();

    /* renamed from: c */
    private char[] f7184c;

    /* renamed from: d */
    private String[] f7185d;

    /* renamed from: e */
    private int f7186e;

    /* renamed from: f */
    private StrMatcher f7187f;

    /* renamed from: g */
    private StrMatcher f7188g;

    /* renamed from: h */
    private StrMatcher f7189h;

    /* renamed from: i */
    private StrMatcher f7190i;

    /* renamed from: j */
    private boolean f7191j;

    /* renamed from: k */
    private boolean f7192k;

    static {
        f7182a.setDelimiterMatcher(StrMatcher.commaMatcher());
        f7182a.setQuoteMatcher(StrMatcher.doubleQuoteMatcher());
        f7182a.setIgnoredMatcher(StrMatcher.noneMatcher());
        f7182a.setTrimmerMatcher(StrMatcher.trimMatcher());
        f7182a.setEmptyTokenAsNull(false);
        f7182a.setIgnoreEmptyTokens(false);
        f7183b.setDelimiterMatcher(StrMatcher.tabMatcher());
        f7183b.setQuoteMatcher(StrMatcher.doubleQuoteMatcher());
        f7183b.setIgnoredMatcher(StrMatcher.noneMatcher());
        f7183b.setTrimmerMatcher(StrMatcher.trimMatcher());
        f7183b.setEmptyTokenAsNull(false);
        f7183b.setIgnoreEmptyTokens(false);
    }

    /* renamed from: b */
    private static StrTokenizer m7455b() {
        return (StrTokenizer) f7182a.clone();
    }

    public static StrTokenizer getCSVInstance() {
        return m7455b();
    }

    public static StrTokenizer getCSVInstance(String str) {
        StrTokenizer b = m7455b();
        b.reset(str);
        return b;
    }

    public static StrTokenizer getCSVInstance(char[] cArr) {
        StrTokenizer b = m7455b();
        b.reset(cArr);
        return b;
    }

    /* renamed from: c */
    private static StrTokenizer m7456c() {
        return (StrTokenizer) f7183b.clone();
    }

    public static StrTokenizer getTSVInstance() {
        return m7456c();
    }

    public static StrTokenizer getTSVInstance(String str) {
        StrTokenizer c = m7456c();
        c.reset(str);
        return c;
    }

    public static StrTokenizer getTSVInstance(char[] cArr) {
        StrTokenizer c = m7456c();
        c.reset(cArr);
        return c;
    }

    public StrTokenizer() {
        this.f7187f = StrMatcher.splitMatcher();
        this.f7188g = StrMatcher.noneMatcher();
        this.f7189h = StrMatcher.noneMatcher();
        this.f7190i = StrMatcher.noneMatcher();
        this.f7191j = false;
        this.f7192k = true;
        this.f7184c = null;
    }

    public StrTokenizer(String str) {
        this.f7187f = StrMatcher.splitMatcher();
        this.f7188g = StrMatcher.noneMatcher();
        this.f7189h = StrMatcher.noneMatcher();
        this.f7190i = StrMatcher.noneMatcher();
        this.f7191j = false;
        this.f7192k = true;
        if (str != null) {
            this.f7184c = str.toCharArray();
        } else {
            this.f7184c = null;
        }
    }

    public StrTokenizer(String str, char c) {
        this(str);
        setDelimiterChar(c);
    }

    public StrTokenizer(String str, String str2) {
        this(str);
        setDelimiterString(str2);
    }

    public StrTokenizer(String str, StrMatcher strMatcher) {
        this(str);
        setDelimiterMatcher(strMatcher);
    }

    public StrTokenizer(String str, char c, char c2) {
        this(str, c);
        setQuoteChar(c2);
    }

    public StrTokenizer(String str, StrMatcher strMatcher, StrMatcher strMatcher2) {
        this(str, strMatcher);
        setQuoteMatcher(strMatcher2);
    }

    public StrTokenizer(char[] cArr) {
        this.f7187f = StrMatcher.splitMatcher();
        this.f7188g = StrMatcher.noneMatcher();
        this.f7189h = StrMatcher.noneMatcher();
        this.f7190i = StrMatcher.noneMatcher();
        this.f7191j = false;
        this.f7192k = true;
        this.f7184c = ArrayUtils.clone(cArr);
    }

    public StrTokenizer(char[] cArr, char c) {
        this(cArr);
        setDelimiterChar(c);
    }

    public StrTokenizer(char[] cArr, String str) {
        this(cArr);
        setDelimiterString(str);
    }

    public StrTokenizer(char[] cArr, StrMatcher strMatcher) {
        this(cArr);
        setDelimiterMatcher(strMatcher);
    }

    public StrTokenizer(char[] cArr, char c, char c2) {
        this(cArr, c);
        setQuoteChar(c2);
    }

    public StrTokenizer(char[] cArr, StrMatcher strMatcher, StrMatcher strMatcher2) {
        this(cArr, strMatcher);
        setQuoteMatcher(strMatcher2);
    }

    public int size() {
        m7457d();
        return this.f7185d.length;
    }

    public String nextToken() {
        if (!hasNext()) {
            return null;
        }
        String[] strArr = this.f7185d;
        int i = this.f7186e;
        this.f7186e = i + 1;
        return strArr[i];
    }

    public String previousToken() {
        if (!hasPrevious()) {
            return null;
        }
        String[] strArr = this.f7185d;
        int i = this.f7186e - 1;
        this.f7186e = i;
        return strArr[i];
    }

    public String[] getTokenArray() {
        m7457d();
        return (String[]) this.f7185d.clone();
    }

    public List<String> getTokenList() {
        m7457d();
        ArrayList arrayList = new ArrayList(this.f7185d.length);
        for (String add : this.f7185d) {
            arrayList.add(add);
        }
        return arrayList;
    }

    public StrTokenizer reset() {
        this.f7186e = 0;
        this.f7185d = null;
        return this;
    }

    public StrTokenizer reset(String str) {
        reset();
        if (str != null) {
            this.f7184c = str.toCharArray();
        } else {
            this.f7184c = null;
        }
        return this;
    }

    public StrTokenizer reset(char[] cArr) {
        reset();
        this.f7184c = ArrayUtils.clone(cArr);
        return this;
    }

    public boolean hasNext() {
        m7457d();
        return this.f7186e < this.f7185d.length;
    }

    public String next() {
        if (hasNext()) {
            String[] strArr = this.f7185d;
            int i = this.f7186e;
            this.f7186e = i + 1;
            return strArr[i];
        }
        throw new NoSuchElementException();
    }

    public int nextIndex() {
        return this.f7186e;
    }

    public boolean hasPrevious() {
        m7457d();
        return this.f7186e > 0;
    }

    public String previous() {
        if (hasPrevious()) {
            String[] strArr = this.f7185d;
            int i = this.f7186e - 1;
            this.f7186e = i;
            return strArr[i];
        }
        throw new NoSuchElementException();
    }

    public int previousIndex() {
        return this.f7186e - 1;
    }

    public void remove() {
        throw new UnsupportedOperationException("remove() is unsupported");
    }

    public void set(String str) {
        throw new UnsupportedOperationException("set() is unsupported");
    }

    public void add(String str) {
        throw new UnsupportedOperationException("add() is unsupported");
    }

    /* renamed from: d */
    private void m7457d() {
        if (this.f7185d != null) {
            return;
        }
        if (this.f7184c == null) {
            List<String> list = tokenize((char[]) null, 0, 0);
            this.f7185d = (String[]) list.toArray(new String[list.size()]);
            return;
        }
        List<String> list2 = tokenize(this.f7184c, 0, this.f7184c.length);
        this.f7185d = (String[]) list2.toArray(new String[list2.size()]);
    }

    /* access modifiers changed from: protected */
    public List<String> tokenize(char[] cArr, int i, int i2) {
        if (cArr == null || i2 == 0) {
            return Collections.emptyList();
        }
        StrBuilder strBuilder = new StrBuilder();
        ArrayList arrayList = new ArrayList();
        int i3 = i;
        while (i3 >= 0 && i3 < i2) {
            i3 = m7451a(cArr, i3, i2, strBuilder, (List<String>) arrayList);
            if (i3 >= i2) {
                m7453a(arrayList, "");
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private void m7453a(List<String> list, String str) {
        if (str == null || str.length() == 0) {
            if (!isIgnoreEmptyTokens()) {
                if (isEmptyTokenAsNull()) {
                    str = null;
                }
            } else {
                return;
            }
        }
        list.add(str);
    }

    /* renamed from: a */
    private int m7451a(char[] cArr, int i, int i2, StrBuilder strBuilder, List<String> list) {
        int max;
        int i3 = i;
        while (i3 < i2 && (max = Math.max(getIgnoredMatcher().isMatch(cArr, i3, i3, i2), getTrimmerMatcher().isMatch(cArr, i3, i3, i2))) != 0 && getDelimiterMatcher().isMatch(cArr, i3, i3, i2) <= 0 && getQuoteMatcher().isMatch(cArr, i3, i3, i2) <= 0) {
            i3 += max;
        }
        if (i3 >= i2) {
            m7453a(list, "");
            return -1;
        }
        int isMatch = getDelimiterMatcher().isMatch(cArr, i3, i3, i2);
        if (isMatch > 0) {
            m7453a(list, "");
            return isMatch + i3;
        }
        int isMatch2 = getQuoteMatcher().isMatch(cArr, i3, i3, i2);
        if (isMatch2 <= 0) {
            return m7452a(cArr, i3, i2, strBuilder, list, 0, 0);
        }
        return m7452a(cArr, i3 + isMatch2, i2, strBuilder, list, i3, isMatch2);
    }

    /* renamed from: a */
    private int m7452a(char[] cArr, int i, int i2, StrBuilder strBuilder, List<String> list, int i3, int i4) {
        strBuilder.clear();
        int i5 = 0;
        boolean z = i4 > 0;
        int i6 = i;
        while (i6 < i2) {
            if (!z) {
                int isMatch = getDelimiterMatcher().isMatch(cArr, i6, i, i2);
                if (isMatch > 0) {
                    m7453a(list, strBuilder.substring(0, i5));
                    return isMatch + i6;
                } else if (i4 <= 0 || !m7454a(cArr, i6, i2, i3, i4)) {
                    int isMatch2 = getIgnoredMatcher().isMatch(cArr, i6, i, i2);
                    if (isMatch2 > 0) {
                        i6 += isMatch2;
                    } else {
                        int isMatch3 = getTrimmerMatcher().isMatch(cArr, i6, i, i2);
                        if (isMatch3 > 0) {
                            strBuilder.append(cArr, i6, isMatch3);
                            i6 += isMatch3;
                        } else {
                            strBuilder.append(cArr[i6]);
                            i5 = strBuilder.size();
                            i6++;
                        }
                    }
                } else {
                    i6 += i4;
                    z = true;
                }
            } else if (m7454a(cArr, i6, i2, i3, i4)) {
                if (m7454a(cArr, i6 + i4, i2, i3, i4)) {
                    strBuilder.append(cArr, i6, i4);
                    i6 += i4 * 2;
                    i5 = strBuilder.size();
                } else {
                    i6 += i4;
                    z = false;
                }
            } else {
                strBuilder.append(cArr[i6]);
                i5 = strBuilder.size();
                i6++;
            }
        }
        m7453a(list, strBuilder.substring(0, i5));
        return -1;
    }

    /* renamed from: a */
    private boolean m7454a(char[] cArr, int i, int i2, int i3, int i4) {
        for (int i5 = 0; i5 < i4; i5++) {
            if (i + i5 >= i2 || cArr[i + i5] != cArr[i3 + i5]) {
                return false;
            }
        }
        return true;
    }

    public StrMatcher getDelimiterMatcher() {
        return this.f7187f;
    }

    public StrTokenizer setDelimiterMatcher(StrMatcher strMatcher) {
        if (strMatcher == null) {
            this.f7187f = StrMatcher.noneMatcher();
        } else {
            this.f7187f = strMatcher;
        }
        return this;
    }

    public StrTokenizer setDelimiterChar(char c) {
        return setDelimiterMatcher(StrMatcher.charMatcher(c));
    }

    public StrTokenizer setDelimiterString(String str) {
        return setDelimiterMatcher(StrMatcher.stringMatcher(str));
    }

    public StrMatcher getQuoteMatcher() {
        return this.f7188g;
    }

    public StrTokenizer setQuoteMatcher(StrMatcher strMatcher) {
        if (strMatcher != null) {
            this.f7188g = strMatcher;
        }
        return this;
    }

    public StrTokenizer setQuoteChar(char c) {
        return setQuoteMatcher(StrMatcher.charMatcher(c));
    }

    public StrMatcher getIgnoredMatcher() {
        return this.f7189h;
    }

    public StrTokenizer setIgnoredMatcher(StrMatcher strMatcher) {
        if (strMatcher != null) {
            this.f7189h = strMatcher;
        }
        return this;
    }

    public StrTokenizer setIgnoredChar(char c) {
        return setIgnoredMatcher(StrMatcher.charMatcher(c));
    }

    public StrMatcher getTrimmerMatcher() {
        return this.f7190i;
    }

    public StrTokenizer setTrimmerMatcher(StrMatcher strMatcher) {
        if (strMatcher != null) {
            this.f7190i = strMatcher;
        }
        return this;
    }

    public boolean isEmptyTokenAsNull() {
        return this.f7191j;
    }

    public StrTokenizer setEmptyTokenAsNull(boolean z) {
        this.f7191j = z;
        return this;
    }

    public boolean isIgnoreEmptyTokens() {
        return this.f7192k;
    }

    public StrTokenizer setIgnoreEmptyTokens(boolean z) {
        this.f7192k = z;
        return this;
    }

    public String getContent() {
        if (this.f7184c == null) {
            return null;
        }
        return new String(this.f7184c);
    }

    public Object clone() {
        try {
            return mo13542a();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Object mo13542a() throws CloneNotSupportedException {
        StrTokenizer strTokenizer = (StrTokenizer) super.clone();
        if (strTokenizer.f7184c != null) {
            strTokenizer.f7184c = (char[]) strTokenizer.f7184c.clone();
        }
        strTokenizer.reset();
        return strTokenizer;
    }

    public String toString() {
        if (this.f7185d == null) {
            return "StrTokenizer[not tokenized yet]";
        }
        return "StrTokenizer" + getTokenList();
    }
}
