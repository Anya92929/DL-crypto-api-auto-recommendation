package org.apache.commons.p009io;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Collection;
import org.apache.commons.p009io.filefilter.FileFilterUtils;
import org.apache.commons.p009io.filefilter.IOFileFilter;
import org.apache.commons.p009io.filefilter.TrueFileFilter;

/* renamed from: org.apache.commons.io.DirectoryWalker */
public abstract class DirectoryWalker<T> {

    /* renamed from: a */
    private final FileFilter f6821a;

    /* renamed from: b */
    private final int f6822b;

    protected DirectoryWalker() {
        this((FileFilter) null, -1);
    }

    protected DirectoryWalker(FileFilter fileFilter, int i) {
        this.f6821a = fileFilter;
        this.f6822b = i;
    }

    protected DirectoryWalker(IOFileFilter iOFileFilter, IOFileFilter iOFileFilter2, int i) {
        if (iOFileFilter == null && iOFileFilter2 == null) {
            this.f6821a = null;
        } else {
            this.f6821a = FileFilterUtils.m7287or(FileFilterUtils.makeDirectoryOnly(iOFileFilter == null ? TrueFileFilter.TRUE : iOFileFilter), FileFilterUtils.makeFileOnly(iOFileFilter2 == null ? TrueFileFilter.TRUE : iOFileFilter2));
        }
        this.f6822b = i;
    }

    /* access modifiers changed from: protected */
    public final void walk(File file, Collection<T> collection) throws IOException {
        if (file == null) {
            throw new NullPointerException("Start Directory is null");
        }
        try {
            handleStart(file, collection);
            m7254a(file, 0, collection);
            handleEnd(collection);
        } catch (CancelException e) {
            handleCancelled(file, collection, e);
        }
    }

    /* renamed from: a */
    private void m7254a(File file, int i, Collection<T> collection) throws IOException {
        checkIfCancelled(file, i, collection);
        if (handleDirectory(file, i, collection)) {
            handleDirectoryStart(file, i, collection);
            int i2 = i + 1;
            if (this.f6822b < 0 || i2 <= this.f6822b) {
                checkIfCancelled(file, i, collection);
                File[] filterDirectoryContents = filterDirectoryContents(file, i, this.f6821a == null ? file.listFiles() : file.listFiles(this.f6821a));
                if (filterDirectoryContents == null) {
                    handleRestricted(file, i2, collection);
                } else {
                    for (File file2 : filterDirectoryContents) {
                        if (file2.isDirectory()) {
                            m7254a(file2, i2, collection);
                        } else {
                            checkIfCancelled(file2, i2, collection);
                            handleFile(file2, i2, collection);
                            checkIfCancelled(file2, i2, collection);
                        }
                    }
                }
            }
            handleDirectoryEnd(file, i, collection);
        }
        checkIfCancelled(file, i, collection);
    }

    /* access modifiers changed from: protected */
    public final void checkIfCancelled(File file, int i, Collection<T> collection) throws IOException {
        if (handleIsCancelled(file, i, collection)) {
            throw new CancelException(file, i);
        }
    }

    /* access modifiers changed from: protected */
    public boolean handleIsCancelled(File file, int i, Collection<T> collection) throws IOException {
        return false;
    }

    /* access modifiers changed from: protected */
    public void handleCancelled(File file, Collection<T> collection, CancelException cancelException) throws IOException {
        throw cancelException;
    }

    /* access modifiers changed from: protected */
    public void handleStart(File file, Collection<T> collection) throws IOException {
    }

    /* access modifiers changed from: protected */
    public boolean handleDirectory(File file, int i, Collection<T> collection) throws IOException {
        return true;
    }

    /* access modifiers changed from: protected */
    public void handleDirectoryStart(File file, int i, Collection<T> collection) throws IOException {
    }

    /* access modifiers changed from: protected */
    public File[] filterDirectoryContents(File file, int i, File[] fileArr) throws IOException {
        return fileArr;
    }

    /* access modifiers changed from: protected */
    public void handleFile(File file, int i, Collection<T> collection) throws IOException {
    }

    /* access modifiers changed from: protected */
    public void handleRestricted(File file, int i, Collection<T> collection) throws IOException {
    }

    /* access modifiers changed from: protected */
    public void handleDirectoryEnd(File file, int i, Collection<T> collection) throws IOException {
    }

    /* access modifiers changed from: protected */
    public void handleEnd(Collection<T> collection) throws IOException {
    }

    /* renamed from: org.apache.commons.io.DirectoryWalker$CancelException */
    public static class CancelException extends IOException {
        private static final long serialVersionUID = 1347339620135041008L;

        /* renamed from: a */
        private final File f6823a;

        /* renamed from: b */
        private final int f6824b;

        public CancelException(File file, int i) {
            this("Operation Cancelled", file, i);
        }

        public CancelException(String str, File file, int i) {
            super(str);
            this.f6823a = file;
            this.f6824b = i;
        }

        public File getFile() {
            return this.f6823a;
        }

        public int getDepth() {
            return this.f6824b;
        }
    }
}
