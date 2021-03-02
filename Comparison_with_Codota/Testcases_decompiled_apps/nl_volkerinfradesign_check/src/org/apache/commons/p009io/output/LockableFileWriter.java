package org.apache.commons.p009io.output;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.Charset;
import org.apache.commons.p009io.Charsets;
import org.apache.commons.p009io.FileUtils;

/* renamed from: org.apache.commons.io.output.LockableFileWriter */
public class LockableFileWriter extends Writer {

    /* renamed from: a */
    private final Writer f6996a;

    /* renamed from: b */
    private final File f6997b;

    public LockableFileWriter(String str) throws IOException {
        this(str, false, (String) null);
    }

    public LockableFileWriter(String str, boolean z) throws IOException {
        this(str, z, (String) null);
    }

    public LockableFileWriter(String str, boolean z, String str2) throws IOException {
        this(new File(str), z, str2);
    }

    public LockableFileWriter(File file) throws IOException {
        this(file, false, (String) null);
    }

    public LockableFileWriter(File file, boolean z) throws IOException {
        this(file, z, (String) null);
    }

    public LockableFileWriter(File file, boolean z, String str) throws IOException {
        this(file, Charset.defaultCharset(), z, str);
    }

    public LockableFileWriter(File file, Charset charset) throws IOException {
        this(file, charset, false, (String) null);
    }

    public LockableFileWriter(File file, String str) throws IOException {
        this(file, str, false, (String) null);
    }

    public LockableFileWriter(File file, Charset charset, boolean z, String str) throws IOException {
        File absoluteFile = file.getAbsoluteFile();
        if (absoluteFile.getParentFile() != null) {
            FileUtils.forceMkdir(absoluteFile.getParentFile());
        }
        if (absoluteFile.isDirectory()) {
            throw new IOException("File specified is a directory");
        }
        File file2 = new File(str == null ? System.getProperty("java.io.tmpdir") : str);
        FileUtils.forceMkdir(file2);
        m7330a(file2);
        this.f6997b = new File(file2, absoluteFile.getName() + ".lck");
        m7329a();
        this.f6996a = m7328a(absoluteFile, charset, z);
    }

    public LockableFileWriter(File file, String str, boolean z, String str2) throws IOException {
        this(file, Charsets.toCharset(str), z, str2);
    }

    /* renamed from: a */
    private void m7330a(File file) throws IOException {
        if (!file.exists()) {
            throw new IOException("Could not find lockDir: " + file.getAbsolutePath());
        } else if (!file.canWrite()) {
            throw new IOException("Could not write to lockDir: " + file.getAbsolutePath());
        }
    }

    /* renamed from: a */
    private void m7329a() throws IOException {
        synchronized (LockableFileWriter.class) {
            if (!this.f6997b.createNewFile()) {
                throw new IOException("Can't write file, lock " + this.f6997b.getAbsolutePath() + " exists");
            }
            this.f6997b.deleteOnExit();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x003a  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.io.Writer m7328a(java.io.File r6, java.nio.charset.Charset r7, boolean r8) throws java.io.IOException {
        /*
            r5 = this;
            r2 = 0
            boolean r3 = r6.exists()
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0018, RuntimeException -> 0x002b }
            java.lang.String r0 = r6.getAbsolutePath()     // Catch:{ IOException -> 0x0018, RuntimeException -> 0x002b }
            r1.<init>(r0, r8)     // Catch:{ IOException -> 0x0018, RuntimeException -> 0x002b }
            java.io.OutputStreamWriter r0 = new java.io.OutputStreamWriter     // Catch:{ IOException -> 0x0040, RuntimeException -> 0x003e }
            java.nio.charset.Charset r4 = org.apache.commons.p009io.Charsets.toCharset((java.nio.charset.Charset) r7)     // Catch:{ IOException -> 0x0040, RuntimeException -> 0x003e }
            r0.<init>(r1, r4)     // Catch:{ IOException -> 0x0040, RuntimeException -> 0x003e }
            return r0
        L_0x0018:
            r0 = move-exception
            r1 = r2
        L_0x001a:
            org.apache.commons.p009io.IOUtils.closeQuietly((java.io.Writer) r2)
            org.apache.commons.p009io.IOUtils.closeQuietly((java.io.OutputStream) r1)
            java.io.File r1 = r5.f6997b
            org.apache.commons.p009io.FileUtils.deleteQuietly(r1)
            if (r3 != 0) goto L_0x002a
            org.apache.commons.p009io.FileUtils.deleteQuietly(r6)
        L_0x002a:
            throw r0
        L_0x002b:
            r0 = move-exception
            r1 = r2
        L_0x002d:
            org.apache.commons.p009io.IOUtils.closeQuietly((java.io.Writer) r2)
            org.apache.commons.p009io.IOUtils.closeQuietly((java.io.OutputStream) r1)
            java.io.File r1 = r5.f6997b
            org.apache.commons.p009io.FileUtils.deleteQuietly(r1)
            if (r3 != 0) goto L_0x003d
            org.apache.commons.p009io.FileUtils.deleteQuietly(r6)
        L_0x003d:
            throw r0
        L_0x003e:
            r0 = move-exception
            goto L_0x002d
        L_0x0040:
            r0 = move-exception
            goto L_0x001a
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.p009io.output.LockableFileWriter.m7328a(java.io.File, java.nio.charset.Charset, boolean):java.io.Writer");
    }

    public void close() throws IOException {
        try {
            this.f6996a.close();
        } finally {
            this.f6997b.delete();
        }
    }

    public void write(int i) throws IOException {
        this.f6996a.write(i);
    }

    public void write(char[] cArr) throws IOException {
        this.f6996a.write(cArr);
    }

    public void write(char[] cArr, int i, int i2) throws IOException {
        this.f6996a.write(cArr, i, i2);
    }

    public void write(String str) throws IOException {
        this.f6996a.write(str);
    }

    public void write(String str, int i, int i2) throws IOException {
        this.f6996a.write(str, i, i2);
    }

    public void flush() throws IOException {
        this.f6996a.flush();
    }
}
