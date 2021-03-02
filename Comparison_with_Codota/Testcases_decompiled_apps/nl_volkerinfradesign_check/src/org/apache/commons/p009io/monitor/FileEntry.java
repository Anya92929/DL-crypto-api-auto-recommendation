package org.apache.commons.p009io.monitor;

import java.io.File;
import java.io.Serializable;

/* renamed from: org.apache.commons.io.monitor.FileEntry */
public class FileEntry implements Serializable {

    /* renamed from: a */
    static final FileEntry[] f6970a = new FileEntry[0];

    /* renamed from: b */
    private final FileEntry f6971b;

    /* renamed from: c */
    private FileEntry[] f6972c;

    /* renamed from: d */
    private final File f6973d;

    /* renamed from: e */
    private String f6974e;

    /* renamed from: f */
    private boolean f6975f;

    /* renamed from: g */
    private boolean f6976g;

    /* renamed from: h */
    private long f6977h;

    /* renamed from: i */
    private long f6978i;

    public FileEntry(File file) {
        this((FileEntry) null, file);
    }

    public FileEntry(FileEntry fileEntry, File file) {
        if (file == null) {
            throw new IllegalArgumentException("File is missing");
        }
        this.f6973d = file;
        this.f6971b = fileEntry;
        this.f6974e = file.getName();
    }

    public boolean refresh(File file) {
        long j;
        long j2 = 0;
        boolean z = this.f6975f;
        long j3 = this.f6977h;
        boolean z2 = this.f6976g;
        long j4 = this.f6978i;
        this.f6974e = file.getName();
        this.f6975f = file.exists();
        this.f6976g = this.f6975f ? file.isDirectory() : false;
        if (this.f6975f) {
            j = file.lastModified();
        } else {
            j = 0;
        }
        this.f6977h = j;
        if (this.f6975f && !this.f6976g) {
            j2 = file.length();
        }
        this.f6978i = j2;
        if (this.f6975f == z && this.f6977h == j3 && this.f6976g == z2 && this.f6978i == j4) {
            return false;
        }
        return true;
    }

    public FileEntry newChildInstance(File file) {
        return new FileEntry(this, file);
    }

    public FileEntry getParent() {
        return this.f6971b;
    }

    public int getLevel() {
        if (this.f6971b == null) {
            return 0;
        }
        return this.f6971b.getLevel() + 1;
    }

    public FileEntry[] getChildren() {
        return this.f6972c != null ? this.f6972c : f6970a;
    }

    public void setChildren(FileEntry[] fileEntryArr) {
        this.f6972c = fileEntryArr;
    }

    public File getFile() {
        return this.f6973d;
    }

    public String getName() {
        return this.f6974e;
    }

    public void setName(String str) {
        this.f6974e = str;
    }

    public long getLastModified() {
        return this.f6977h;
    }

    public void setLastModified(long j) {
        this.f6977h = j;
    }

    public long getLength() {
        return this.f6978i;
    }

    public void setLength(long j) {
        this.f6978i = j;
    }

    public boolean isExists() {
        return this.f6975f;
    }

    public void setExists(boolean z) {
        this.f6975f = z;
    }

    public boolean isDirectory() {
        return this.f6976g;
    }

    public void setDirectory(boolean z) {
        this.f6976g = z;
    }
}
