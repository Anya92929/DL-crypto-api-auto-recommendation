package org.apache.commons.p009io.filefilter;

import java.io.File;
import java.io.Serializable;

/* renamed from: org.apache.commons.io.filefilter.TrueFileFilter */
public class TrueFileFilter implements Serializable, IOFileFilter {
    public static final IOFileFilter INSTANCE = TRUE;
    public static final IOFileFilter TRUE = new TrueFileFilter();

    protected TrueFileFilter() {
    }

    public boolean accept(File file) {
        return true;
    }

    public boolean accept(File file, String str) {
        return true;
    }
}
