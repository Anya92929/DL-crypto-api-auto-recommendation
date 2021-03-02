package org.apache.commons.p009io.filefilter;

import java.io.File;
import java.io.Serializable;

/* renamed from: org.apache.commons.io.filefilter.SizeFileFilter */
public class SizeFileFilter extends AbstractFileFilter implements Serializable {

    /* renamed from: a */
    private final long f6873a;

    /* renamed from: b */
    private final boolean f6874b;

    public SizeFileFilter(long j) {
        this(j, true);
    }

    public SizeFileFilter(long j, boolean z) {
        if (j < 0) {
            throw new IllegalArgumentException("The size must be non-negative");
        }
        this.f6873a = j;
        this.f6874b = z;
    }

    public boolean accept(File file) {
        boolean z;
        if (file.length() < this.f6873a) {
            z = true;
        } else {
            z = false;
        }
        if (this.f6874b) {
            return !z;
        }
        return z;
    }

    public String toString() {
        return super.toString() + "(" + (this.f6874b ? ">=" : "<") + this.f6873a + ")";
    }
}
