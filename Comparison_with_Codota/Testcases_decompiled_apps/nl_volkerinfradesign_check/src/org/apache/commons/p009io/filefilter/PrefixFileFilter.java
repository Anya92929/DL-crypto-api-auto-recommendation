package org.apache.commons.p009io.filefilter;

import java.io.File;
import java.io.Serializable;
import java.util.List;
import org.apache.commons.p009io.IOCase;

/* renamed from: org.apache.commons.io.filefilter.PrefixFileFilter */
public class PrefixFileFilter extends AbstractFileFilter implements Serializable {

    /* renamed from: a */
    private final String[] f6870a;

    /* renamed from: b */
    private final IOCase f6871b;

    public PrefixFileFilter(String str) {
        this(str, IOCase.SENSITIVE);
    }

    public PrefixFileFilter(String str, IOCase iOCase) {
        if (str == null) {
            throw new IllegalArgumentException("The prefix must not be null");
        }
        this.f6870a = new String[]{str};
        this.f6871b = iOCase == null ? IOCase.SENSITIVE : iOCase;
    }

    public PrefixFileFilter(String[] strArr) {
        this(strArr, IOCase.SENSITIVE);
    }

    public PrefixFileFilter(String[] strArr, IOCase iOCase) {
        if (strArr == null) {
            throw new IllegalArgumentException("The array of prefixes must not be null");
        }
        this.f6870a = new String[strArr.length];
        System.arraycopy(strArr, 0, this.f6870a, 0, strArr.length);
        this.f6871b = iOCase == null ? IOCase.SENSITIVE : iOCase;
    }

    public PrefixFileFilter(List<String> list) {
        this(list, IOCase.SENSITIVE);
    }

    public PrefixFileFilter(List<String> list, IOCase iOCase) {
        if (list == null) {
            throw new IllegalArgumentException("The list of prefixes must not be null");
        }
        this.f6870a = (String[]) list.toArray(new String[list.size()]);
        this.f6871b = iOCase == null ? IOCase.SENSITIVE : iOCase;
    }

    public boolean accept(File file) {
        String name = file.getName();
        for (String checkStartsWith : this.f6870a) {
            if (this.f6871b.checkStartsWith(name, checkStartsWith)) {
                return true;
            }
        }
        return false;
    }

    public boolean accept(File file, String str) {
        for (String checkStartsWith : this.f6870a) {
            if (this.f6871b.checkStartsWith(str, checkStartsWith)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("(");
        if (this.f6870a != null) {
            for (int i = 0; i < this.f6870a.length; i++) {
                if (i > 0) {
                    sb.append(",");
                }
                sb.append(this.f6870a[i]);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
