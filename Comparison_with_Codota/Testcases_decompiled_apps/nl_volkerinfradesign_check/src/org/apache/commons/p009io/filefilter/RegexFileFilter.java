package org.apache.commons.p009io.filefilter;

import java.io.File;
import java.io.Serializable;
import java.util.regex.Pattern;
import org.apache.commons.p009io.IOCase;

/* renamed from: org.apache.commons.io.filefilter.RegexFileFilter */
public class RegexFileFilter extends AbstractFileFilter implements Serializable {

    /* renamed from: a */
    private final Pattern f6872a;

    public RegexFileFilter(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Pattern is missing");
        }
        this.f6872a = Pattern.compile(str);
    }

    public RegexFileFilter(String str, IOCase iOCase) {
        if (str == null) {
            throw new IllegalArgumentException("Pattern is missing");
        }
        int i = 0;
        if (iOCase != null && !iOCase.isCaseSensitive()) {
            i = 2;
        }
        this.f6872a = Pattern.compile(str, i);
    }

    public RegexFileFilter(String str, int i) {
        if (str == null) {
            throw new IllegalArgumentException("Pattern is missing");
        }
        this.f6872a = Pattern.compile(str, i);
    }

    public RegexFileFilter(Pattern pattern) {
        if (pattern == null) {
            throw new IllegalArgumentException("Pattern is missing");
        }
        this.f6872a = pattern;
    }

    public boolean accept(File file, String str) {
        return this.f6872a.matcher(str).matches();
    }
}
