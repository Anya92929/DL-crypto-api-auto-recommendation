package org.apache.commons.p009io.filefilter;

import java.io.File;
import java.io.Serializable;
import java.util.List;
import org.apache.commons.p009io.IOCase;

/* renamed from: org.apache.commons.io.filefilter.SuffixFileFilter */
public class SuffixFileFilter extends AbstractFileFilter implements Serializable {

    /* renamed from: a */
    private final String[] f6875a;

    /* renamed from: b */
    private final IOCase f6876b;

    public SuffixFileFilter(String str) {
        this(str, IOCase.SENSITIVE);
    }

    public SuffixFileFilter(String str, IOCase iOCase) {
        if (str == null) {
            throw new IllegalArgumentException("The suffix must not be null");
        }
        this.f6875a = new String[]{str};
        this.f6876b = iOCase == null ? IOCase.SENSITIVE : iOCase;
    }

    public SuffixFileFilter(String[] strArr) {
        this(strArr, IOCase.SENSITIVE);
    }

    public SuffixFileFilter(String[] strArr, IOCase iOCase) {
        if (strArr == null) {
            throw new IllegalArgumentException("The array of suffixes must not be null");
        }
        this.f6875a = new String[strArr.length];
        System.arraycopy(strArr, 0, this.f6875a, 0, strArr.length);
        this.f6876b = iOCase == null ? IOCase.SENSITIVE : iOCase;
    }

    public SuffixFileFilter(List<String> list) {
        this(list, IOCase.SENSITIVE);
    }

    public SuffixFileFilter(List<String> list, IOCase iOCase) {
        if (list == null) {
            throw new IllegalArgumentException("The list of suffixes must not be null");
        }
        this.f6875a = (String[]) list.toArray(new String[list.size()]);
        this.f6876b = iOCase == null ? IOCase.SENSITIVE : iOCase;
    }

    public boolean accept(File file) {
        String name = file.getName();
        for (String checkEndsWith : this.f6875a) {
            if (this.f6876b.checkEndsWith(name, checkEndsWith)) {
                return true;
            }
        }
        return false;
    }

    public boolean accept(File file, String str) {
        for (String checkEndsWith : this.f6875a) {
            if (this.f6876b.checkEndsWith(str, checkEndsWith)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("(");
        if (this.f6875a != null) {
            for (int i = 0; i < this.f6875a.length; i++) {
                if (i > 0) {
                    sb.append(",");
                }
                sb.append(this.f6875a[i]);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
