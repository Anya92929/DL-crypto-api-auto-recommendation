package org.apache.commons.p009io.filefilter;

import java.io.File;
import java.io.Serializable;
import java.util.List;
import org.apache.commons.p009io.IOCase;

/* renamed from: org.apache.commons.io.filefilter.NameFileFilter */
public class NameFileFilter extends AbstractFileFilter implements Serializable {

    /* renamed from: a */
    private final String[] f6866a;

    /* renamed from: b */
    private final IOCase f6867b;

    public NameFileFilter(String str) {
        this(str, (IOCase) null);
    }

    public NameFileFilter(String str, IOCase iOCase) {
        if (str == null) {
            throw new IllegalArgumentException("The wildcard must not be null");
        }
        this.f6866a = new String[]{str};
        this.f6867b = iOCase == null ? IOCase.SENSITIVE : iOCase;
    }

    public NameFileFilter(String[] strArr) {
        this(strArr, (IOCase) null);
    }

    public NameFileFilter(String[] strArr, IOCase iOCase) {
        if (strArr == null) {
            throw new IllegalArgumentException("The array of names must not be null");
        }
        this.f6866a = new String[strArr.length];
        System.arraycopy(strArr, 0, this.f6866a, 0, strArr.length);
        this.f6867b = iOCase == null ? IOCase.SENSITIVE : iOCase;
    }

    public NameFileFilter(List<String> list) {
        this(list, (IOCase) null);
    }

    public NameFileFilter(List<String> list, IOCase iOCase) {
        if (list == null) {
            throw new IllegalArgumentException("The list of names must not be null");
        }
        this.f6866a = (String[]) list.toArray(new String[list.size()]);
        this.f6867b = iOCase == null ? IOCase.SENSITIVE : iOCase;
    }

    public boolean accept(File file) {
        String name = file.getName();
        for (String checkEquals : this.f6866a) {
            if (this.f6867b.checkEquals(name, checkEquals)) {
                return true;
            }
        }
        return false;
    }

    public boolean accept(File file, String str) {
        for (String checkEquals : this.f6866a) {
            if (this.f6867b.checkEquals(str, checkEquals)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("(");
        if (this.f6866a != null) {
            for (int i = 0; i < this.f6866a.length; i++) {
                if (i > 0) {
                    sb.append(",");
                }
                sb.append(this.f6866a[i]);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
