package org.apache.commons.p009io.filefilter;

import java.io.File;
import java.io.Serializable;
import java.util.Date;
import org.apache.commons.p009io.FileUtils;

/* renamed from: org.apache.commons.io.filefilter.AgeFileFilter */
public class AgeFileFilter extends AbstractFileFilter implements Serializable {

    /* renamed from: a */
    private final long f6857a;

    /* renamed from: b */
    private final boolean f6858b;

    public AgeFileFilter(long j) {
        this(j, true);
    }

    public AgeFileFilter(long j, boolean z) {
        this.f6858b = z;
        this.f6857a = j;
    }

    public AgeFileFilter(Date date) {
        this(date, true);
    }

    public AgeFileFilter(Date date, boolean z) {
        this(date.getTime(), z);
    }

    public AgeFileFilter(File file) {
        this(file, true);
    }

    public AgeFileFilter(File file, boolean z) {
        this(file.lastModified(), z);
    }

    public boolean accept(File file) {
        boolean isFileNewer = FileUtils.isFileNewer(file, this.f6857a);
        if (this.f6858b) {
            return !isFileNewer;
        }
        return isFileNewer;
    }

    public String toString() {
        return super.toString() + "(" + (this.f6858b ? "<=" : ">") + this.f6857a + ")";
    }
}
