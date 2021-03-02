package org.apache.commons.p009io.filefilter;

import java.io.File;
import java.io.Serializable;

/* renamed from: org.apache.commons.io.filefilter.FileFileFilter */
public class FileFileFilter extends AbstractFileFilter implements Serializable {
    public static final IOFileFilter FILE = new FileFileFilter();

    protected FileFileFilter() {
    }

    public boolean accept(File file) {
        return file.isFile();
    }
}
