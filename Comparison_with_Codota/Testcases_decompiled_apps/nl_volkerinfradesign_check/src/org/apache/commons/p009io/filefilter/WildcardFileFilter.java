package org.apache.commons.p009io.filefilter;

import java.io.File;
import java.io.Serializable;
import java.util.List;
import org.apache.commons.p009io.FilenameUtils;
import org.apache.commons.p009io.IOCase;

/* renamed from: org.apache.commons.io.filefilter.WildcardFileFilter */
public class WildcardFileFilter extends AbstractFileFilter implements Serializable {

    /* renamed from: a */
    private final String[] f6877a;

    /* renamed from: b */
    private final IOCase f6878b;

    public WildcardFileFilter(String str) {
        this(str, (IOCase) null);
    }

    public WildcardFileFilter(String str, IOCase iOCase) {
        if (str == null) {
            throw new IllegalArgumentException("The wildcard must not be null");
        }
        this.f6877a = new String[]{str};
        this.f6878b = iOCase == null ? IOCase.SENSITIVE : iOCase;
    }

    public WildcardFileFilter(String[] strArr) {
        this(strArr, (IOCase) null);
    }

    public WildcardFileFilter(String[] strArr, IOCase iOCase) {
        if (strArr == null) {
            throw new IllegalArgumentException("The wildcard array must not be null");
        }
        this.f6877a = new String[strArr.length];
        System.arraycopy(strArr, 0, this.f6877a, 0, strArr.length);
        this.f6878b = iOCase == null ? IOCase.SENSITIVE : iOCase;
    }

    public WildcardFileFilter(List<String> list) {
        this(list, (IOCase) null);
    }

    public WildcardFileFilter(List<String> list, IOCase iOCase) {
        if (list == null) {
            throw new IllegalArgumentException("The wildcard list must not be null");
        }
        this.f6877a = (String[]) list.toArray(new String[list.size()]);
        this.f6878b = iOCase == null ? IOCase.SENSITIVE : iOCase;
    }

    public boolean accept(File file, String str) {
        for (String wildcardMatch : this.f6877a) {
            if (FilenameUtils.wildcardMatch(str, wildcardMatch, this.f6878b)) {
                return true;
            }
        }
        return false;
    }

    public boolean accept(File file) {
        String name = file.getName();
        for (String wildcardMatch : this.f6877a) {
            if (FilenameUtils.wildcardMatch(name, wildcardMatch, this.f6878b)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("(");
        if (this.f6877a != null) {
            for (int i = 0; i < this.f6877a.length; i++) {
                if (i > 0) {
                    sb.append(",");
                }
                sb.append(this.f6877a[i]);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
