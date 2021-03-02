package org.apache.commons.p009io.filefilter;

import java.io.File;
import java.io.Serializable;

/* renamed from: org.apache.commons.io.filefilter.NotFileFilter */
public class NotFileFilter extends AbstractFileFilter implements Serializable {

    /* renamed from: a */
    private final IOFileFilter f6868a;

    public NotFileFilter(IOFileFilter iOFileFilter) {
        if (iOFileFilter == null) {
            throw new IllegalArgumentException("The filter must not be null");
        }
        this.f6868a = iOFileFilter;
    }

    public boolean accept(File file) {
        return !this.f6868a.accept(file);
    }

    public boolean accept(File file, String str) {
        return !this.f6868a.accept(file, str);
    }

    public String toString() {
        return super.toString() + "(" + this.f6868a.toString() + ")";
    }
}
