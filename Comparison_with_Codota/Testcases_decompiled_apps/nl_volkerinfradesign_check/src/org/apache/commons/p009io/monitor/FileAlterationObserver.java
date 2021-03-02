package org.apache.commons.p009io.monitor;

import java.io.File;
import java.io.FileFilter;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.apache.commons.p009io.FileUtils;
import org.apache.commons.p009io.IOCase;
import org.apache.commons.p009io.comparator.NameFileComparator;

/* renamed from: org.apache.commons.io.monitor.FileAlterationObserver */
public class FileAlterationObserver implements Serializable {

    /* renamed from: a */
    private final List<FileAlterationListener> f6966a;

    /* renamed from: b */
    private final FileEntry f6967b;

    /* renamed from: c */
    private final FileFilter f6968c;

    /* renamed from: d */
    private final Comparator<File> f6969d;

    public FileAlterationObserver(String str) {
        this(new File(str));
    }

    public FileAlterationObserver(String str, FileFilter fileFilter) {
        this(new File(str), fileFilter);
    }

    public FileAlterationObserver(String str, FileFilter fileFilter, IOCase iOCase) {
        this(new File(str), fileFilter, iOCase);
    }

    public FileAlterationObserver(File file) {
        this(file, (FileFilter) null);
    }

    public FileAlterationObserver(File file, FileFilter fileFilter) {
        this(file, fileFilter, (IOCase) null);
    }

    public FileAlterationObserver(File file, FileFilter fileFilter, IOCase iOCase) {
        this(new FileEntry(file), fileFilter, iOCase);
    }

    protected FileAlterationObserver(FileEntry fileEntry, FileFilter fileFilter, IOCase iOCase) {
        this.f6966a = new CopyOnWriteArrayList();
        if (fileEntry == null) {
            throw new IllegalArgumentException("Root entry is missing");
        } else if (fileEntry.getFile() == null) {
            throw new IllegalArgumentException("Root directory is missing");
        } else {
            this.f6967b = fileEntry;
            this.f6968c = fileFilter;
            if (iOCase == null || iOCase.equals(IOCase.SYSTEM)) {
                this.f6969d = NameFileComparator.NAME_SYSTEM_COMPARATOR;
            } else if (iOCase.equals(IOCase.INSENSITIVE)) {
                this.f6969d = NameFileComparator.NAME_INSENSITIVE_COMPARATOR;
            } else {
                this.f6969d = NameFileComparator.NAME_COMPARATOR;
            }
        }
    }

    public File getDirectory() {
        return this.f6967b.getFile();
    }

    public FileFilter getFileFilter() {
        return this.f6968c;
    }

    public void addListener(FileAlterationListener fileAlterationListener) {
        if (fileAlterationListener != null) {
            this.f6966a.add(fileAlterationListener);
        }
    }

    public void removeListener(FileAlterationListener fileAlterationListener) {
        if (fileAlterationListener != null) {
            do {
            } while (this.f6966a.remove(fileAlterationListener));
        }
    }

    public Iterable<FileAlterationListener> getListeners() {
        return this.f6966a;
    }

    public void initialize() throws Exception {
        this.f6967b.refresh(this.f6967b.getFile());
        File[] a = m7322a(this.f6967b.getFile());
        FileEntry[] fileEntryArr = a.length > 0 ? new FileEntry[a.length] : FileEntry.f6970a;
        for (int i = 0; i < a.length; i++) {
            fileEntryArr[i] = m7319a(this.f6967b, a[i]);
        }
        this.f6967b.setChildren(fileEntryArr);
    }

    public void destroy() throws Exception {
    }

    public void checkAndNotify() {
        for (FileAlterationListener onStart : this.f6966a) {
            onStart.onStart(this);
        }
        File file = this.f6967b.getFile();
        if (file.exists()) {
            m7321a(this.f6967b, this.f6967b.getChildren(), m7322a(file));
        } else if (this.f6967b.isExists()) {
            m7321a(this.f6967b, this.f6967b.getChildren(), FileUtils.EMPTY_FILE_ARRAY);
        }
        for (FileAlterationListener onStop : this.f6966a) {
            onStop.onStop(this);
        }
    }

    /* renamed from: a */
    private void m7321a(FileEntry fileEntry, FileEntry[] fileEntryArr, File[] fileArr) {
        int i = 0;
        FileEntry[] fileEntryArr2 = fileArr.length > 0 ? new FileEntry[fileArr.length] : FileEntry.f6970a;
        int length = fileEntryArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            FileEntry fileEntry2 = fileEntryArr[i2];
            while (i < fileArr.length && this.f6969d.compare(fileEntry2.getFile(), fileArr[i]) > 0) {
                fileEntryArr2[i] = m7319a(fileEntry, fileArr[i]);
                m7320a(fileEntryArr2[i]);
                i++;
            }
            if (i >= fileArr.length || this.f6969d.compare(fileEntry2.getFile(), fileArr[i]) != 0) {
                m7321a(fileEntry2, fileEntry2.getChildren(), FileUtils.EMPTY_FILE_ARRAY);
                m7323b(fileEntry2);
            } else {
                m7324b(fileEntry2, fileArr[i]);
                m7321a(fileEntry2, fileEntry2.getChildren(), m7322a(fileArr[i]));
                fileEntryArr2[i] = fileEntry2;
                i++;
            }
        }
        while (i < fileArr.length) {
            fileEntryArr2[i] = m7319a(fileEntry, fileArr[i]);
            m7320a(fileEntryArr2[i]);
            i++;
        }
        fileEntry.setChildren(fileEntryArr2);
    }

    /* renamed from: a */
    private FileEntry m7319a(FileEntry fileEntry, File file) {
        FileEntry newChildInstance = fileEntry.newChildInstance(file);
        newChildInstance.refresh(file);
        File[] a = m7322a(file);
        FileEntry[] fileEntryArr = a.length > 0 ? new FileEntry[a.length] : FileEntry.f6970a;
        for (int i = 0; i < a.length; i++) {
            fileEntryArr[i] = m7319a(newChildInstance, a[i]);
        }
        newChildInstance.setChildren(fileEntryArr);
        return newChildInstance;
    }

    /* renamed from: a */
    private void m7320a(FileEntry fileEntry) {
        for (FileAlterationListener next : this.f6966a) {
            if (fileEntry.isDirectory()) {
                next.onDirectoryCreate(fileEntry.getFile());
            } else {
                next.onFileCreate(fileEntry.getFile());
            }
        }
        for (FileEntry a : fileEntry.getChildren()) {
            m7320a(a);
        }
    }

    /* renamed from: b */
    private void m7324b(FileEntry fileEntry, File file) {
        if (fileEntry.refresh(file)) {
            for (FileAlterationListener next : this.f6966a) {
                if (fileEntry.isDirectory()) {
                    next.onDirectoryChange(file);
                } else {
                    next.onFileChange(file);
                }
            }
        }
    }

    /* renamed from: b */
    private void m7323b(FileEntry fileEntry) {
        for (FileAlterationListener next : this.f6966a) {
            if (fileEntry.isDirectory()) {
                next.onDirectoryDelete(fileEntry.getFile());
            } else {
                next.onFileDelete(fileEntry.getFile());
            }
        }
    }

    /* renamed from: a */
    private File[] m7322a(File file) {
        File[] fileArr = null;
        if (file.isDirectory()) {
            fileArr = this.f6968c == null ? file.listFiles() : file.listFiles(this.f6968c);
        }
        if (fileArr == null) {
            fileArr = FileUtils.EMPTY_FILE_ARRAY;
        }
        if (this.f6969d != null && fileArr.length > 1) {
            Arrays.sort(fileArr, this.f6969d);
        }
        return fileArr;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[file='");
        sb.append(getDirectory().getPath());
        sb.append('\'');
        if (this.f6968c != null) {
            sb.append(", ");
            sb.append(this.f6968c.toString());
        }
        sb.append(", listeners=");
        sb.append(this.f6966a.size());
        sb.append("]");
        return sb.toString();
    }
}
