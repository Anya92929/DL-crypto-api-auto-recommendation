package org.apache.commons.p009io.filefilter;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.Serializable;

/* renamed from: org.apache.commons.io.filefilter.DelegateFileFilter */
public class DelegateFileFilter extends AbstractFileFilter implements Serializable {

    /* renamed from: a */
    private final FilenameFilter f6860a;

    /* renamed from: b */
    private final FileFilter f6861b;

    public DelegateFileFilter(FilenameFilter filenameFilter) {
        if (filenameFilter == null) {
            throw new IllegalArgumentException("The FilenameFilter must not be null");
        }
        this.f6860a = filenameFilter;
        this.f6861b = null;
    }

    public DelegateFileFilter(FileFilter fileFilter) {
        if (fileFilter == null) {
            throw new IllegalArgumentException("The FileFilter must not be null");
        }
        this.f6861b = fileFilter;
        this.f6860a = null;
    }

    public boolean accept(File file) {
        if (this.f6861b != null) {
            return this.f6861b.accept(file);
        }
        return super.accept(file);
    }

    public boolean accept(File file, String str) {
        if (this.f6860a != null) {
            return this.f6860a.accept(file, str);
        }
        return super.accept(file, str);
    }

    public String toString() {
        return super.toString() + "(" + (this.f6861b != null ? this.f6861b.toString() : this.f6860a.toString()) + ")";
    }
}
