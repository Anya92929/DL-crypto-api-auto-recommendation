package org.apache.commons.p009io.filefilter;

import java.io.File;

/* renamed from: org.apache.commons.io.filefilter.AbstractFileFilter */
public abstract class AbstractFileFilter implements IOFileFilter {
    public boolean accept(File file) {
        return accept(file.getParentFile(), file.getName());
    }

    public boolean accept(File file, String str) {
        return accept(new File(file, str));
    }

    public String toString() {
        return getClass().getSimpleName();
    }
}
