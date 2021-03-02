package org.apache.commons.p009io.filefilter;

import java.io.File;
import java.io.Serializable;
import java.util.List;
import org.apache.commons.p009io.FilenameUtils;

@Deprecated
/* renamed from: org.apache.commons.io.filefilter.WildcardFilter */
public class WildcardFilter extends AbstractFileFilter implements Serializable {

    /* renamed from: a */
    private final String[] f6879a;

    public WildcardFilter(String str) {
        if (str == null) {
            throw new IllegalArgumentException("The wildcard must not be null");
        }
        this.f6879a = new String[]{str};
    }

    public WildcardFilter(String[] strArr) {
        if (strArr == null) {
            throw new IllegalArgumentException("The wildcard array must not be null");
        }
        this.f6879a = new String[strArr.length];
        System.arraycopy(strArr, 0, this.f6879a, 0, strArr.length);
    }

    public WildcardFilter(List<String> list) {
        if (list == null) {
            throw new IllegalArgumentException("The wildcard list must not be null");
        }
        this.f6879a = (String[]) list.toArray(new String[list.size()]);
    }

    public boolean accept(File file, String str) {
        if (file != null && new File(file, str).isDirectory()) {
            return false;
        }
        for (String wildcardMatch : this.f6879a) {
            if (FilenameUtils.wildcardMatch(str, wildcardMatch)) {
                return true;
            }
        }
        return false;
    }

    public boolean accept(File file) {
        if (file.isDirectory()) {
            return false;
        }
        for (String wildcardMatch : this.f6879a) {
            if (FilenameUtils.wildcardMatch(file.getName(), wildcardMatch)) {
                return true;
            }
        }
        return false;
    }
}
