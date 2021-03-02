package org.apache.commons.p009io.input;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import org.apache.commons.lang3.CharUtils;
import org.apache.commons.p009io.FileUtils;
import org.apache.commons.p009io.IOUtils;

/* renamed from: org.apache.commons.io.input.Tailer */
public class Tailer implements Runnable {

    /* renamed from: a */
    private final byte[] f6941a;

    /* renamed from: b */
    private final File f6942b;

    /* renamed from: c */
    private final long f6943c;

    /* renamed from: d */
    private final boolean f6944d;

    /* renamed from: e */
    private final TailerListener f6945e;

    /* renamed from: f */
    private final boolean f6946f;

    /* renamed from: g */
    private volatile boolean f6947g;

    public Tailer(File file, TailerListener tailerListener) {
        this(file, tailerListener, 1000);
    }

    public Tailer(File file, TailerListener tailerListener, long j) {
        this(file, tailerListener, j, false);
    }

    public Tailer(File file, TailerListener tailerListener, long j, boolean z) {
        this(file, tailerListener, j, z, 4096);
    }

    public Tailer(File file, TailerListener tailerListener, long j, boolean z, boolean z2) {
        this(file, tailerListener, j, z, z2, 4096);
    }

    public Tailer(File file, TailerListener tailerListener, long j, boolean z, int i) {
        this(file, tailerListener, j, z, false, i);
    }

    public Tailer(File file, TailerListener tailerListener, long j, boolean z, boolean z2, int i) {
        this.f6947g = true;
        this.f6942b = file;
        this.f6943c = j;
        this.f6944d = z;
        this.f6941a = new byte[i];
        this.f6945e = tailerListener;
        tailerListener.init(this);
        this.f6946f = z2;
    }

    public static Tailer create(File file, TailerListener tailerListener, long j, boolean z, int i) {
        Tailer tailer = new Tailer(file, tailerListener, j, z, i);
        Thread thread = new Thread(tailer);
        thread.setDaemon(true);
        thread.start();
        return tailer;
    }

    public static Tailer create(File file, TailerListener tailerListener, long j, boolean z, boolean z2, int i) {
        Tailer tailer = new Tailer(file, tailerListener, j, z, z2, i);
        Thread thread = new Thread(tailer);
        thread.setDaemon(true);
        thread.start();
        return tailer;
    }

    public static Tailer create(File file, TailerListener tailerListener, long j, boolean z) {
        return create(file, tailerListener, j, z, 4096);
    }

    public static Tailer create(File file, TailerListener tailerListener, long j, boolean z, boolean z2) {
        return create(file, tailerListener, j, z, z2, 4096);
    }

    public static Tailer create(File file, TailerListener tailerListener, long j) {
        return create(file, tailerListener, j, false);
    }

    public static Tailer create(File file, TailerListener tailerListener) {
        return create(file, tailerListener, 1000, false);
    }

    public File getFile() {
        return this.f6942b;
    }

    public long getDelay() {
        return this.f6943c;
    }

    public void run() {
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2;
        long j;
        RandomAccessFile randomAccessFile3 = null;
        long j2 = 0;
        long j3 = 0;
        while (this.f6947g && randomAccessFile3 == null) {
            try {
                try {
                    randomAccessFile3 = new RandomAccessFile(this.f6942b, "r");
                } catch (FileNotFoundException e) {
                    this.f6945e.fileNotFound();
                }
                if (randomAccessFile3 == null) {
                    try {
                        Thread.sleep(this.f6943c);
                    } catch (InterruptedException e2) {
                    }
                } else {
                    j2 = this.f6944d ? this.f6942b.length() : 0;
                    j3 = System.currentTimeMillis();
                    randomAccessFile3.seek(j2);
                }
            } catch (Exception e3) {
                e = e3;
            }
        }
        while (this.f6947g) {
            boolean isFileNewer = FileUtils.isFileNewer(this.f6942b, j3);
            long length = this.f6942b.length();
            if (length < j2) {
                this.f6945e.fileRotated();
                try {
                    RandomAccessFile randomAccessFile4 = new RandomAccessFile(this.f6942b, "r");
                    try {
                        IOUtils.closeQuietly((Closeable) randomAccessFile3);
                        j2 = 0;
                        randomAccessFile3 = randomAccessFile4;
                    } catch (FileNotFoundException e4) {
                        randomAccessFile2 = randomAccessFile4;
                        j = 0;
                        try {
                            this.f6945e.fileNotFound();
                            randomAccessFile3 = randomAccessFile2;
                            j2 = j;
                        } catch (Exception e5) {
                            e = e5;
                            randomAccessFile3 = randomAccessFile2;
                            try {
                                this.f6945e.handle(e);
                                IOUtils.closeQuietly((Closeable) randomAccessFile3);
                                return;
                            } catch (Throwable th) {
                                th = th;
                                IOUtils.closeQuietly((Closeable) randomAccessFile3);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            randomAccessFile3 = randomAccessFile2;
                            IOUtils.closeQuietly((Closeable) randomAccessFile3);
                            throw th;
                        }
                    } catch (Exception e6) {
                        Exception exc = e6;
                        randomAccessFile3 = randomAccessFile4;
                        e = exc;
                        this.f6945e.handle(e);
                        IOUtils.closeQuietly((Closeable) randomAccessFile3);
                        return;
                    } catch (Throwable th3) {
                        Throwable th4 = th3;
                        randomAccessFile3 = randomAccessFile4;
                        th = th4;
                        IOUtils.closeQuietly((Closeable) randomAccessFile3);
                        throw th;
                    }
                } catch (FileNotFoundException e7) {
                    long j4 = j2;
                    randomAccessFile2 = randomAccessFile3;
                    j = j4;
                    this.f6945e.fileNotFound();
                    randomAccessFile3 = randomAccessFile2;
                    j2 = j;
                }
            } else {
                if (length > j2) {
                    j2 = m7308a(randomAccessFile3);
                    j3 = System.currentTimeMillis();
                } else if (isFileNewer) {
                    randomAccessFile3.seek(0);
                    j2 = m7308a(randomAccessFile3);
                    j3 = System.currentTimeMillis();
                }
                if (this.f6946f) {
                    IOUtils.closeQuietly((Closeable) randomAccessFile3);
                }
                try {
                    Thread.sleep(this.f6943c);
                } catch (InterruptedException e8) {
                }
                if (!this.f6947g || !this.f6946f) {
                    randomAccessFile = randomAccessFile3;
                } else {
                    randomAccessFile = new RandomAccessFile(this.f6942b, "r");
                    try {
                        randomAccessFile.seek(j2);
                    } catch (Exception e9) {
                        Exception exc2 = e9;
                        randomAccessFile3 = randomAccessFile;
                        e = exc2;
                        this.f6945e.handle(e);
                        IOUtils.closeQuietly((Closeable) randomAccessFile3);
                        return;
                    } catch (Throwable th5) {
                        Throwable th6 = th5;
                        randomAccessFile3 = randomAccessFile;
                        th = th6;
                        IOUtils.closeQuietly((Closeable) randomAccessFile3);
                        throw th;
                    }
                }
                randomAccessFile3 = randomAccessFile;
            }
        }
        IOUtils.closeQuietly((Closeable) randomAccessFile3);
    }

    public void stop() {
        this.f6947g = false;
    }

    /* renamed from: a */
    private long m7308a(RandomAccessFile randomAccessFile) throws IOException {
        int read;
        StringBuilder sb = new StringBuilder();
        long filePointer = randomAccessFile.getFilePointer();
        boolean z = false;
        long j = filePointer;
        while (this.f6947g && (read = randomAccessFile.read(this.f6941a)) != -1) {
            for (int i = 0; i < read; i++) {
                byte b = this.f6941a[i];
                switch (b) {
                    case 10:
                        this.f6945e.handle(sb.toString());
                        sb.setLength(0);
                        filePointer = ((long) i) + j + 1;
                        z = false;
                        break;
                    case 13:
                        if (z) {
                            sb.append(CharUtils.f7018CR);
                        }
                        z = true;
                        break;
                    default:
                        if (z) {
                            this.f6945e.handle(sb.toString());
                            sb.setLength(0);
                            filePointer = ((long) i) + j + 1;
                            z = false;
                        }
                        sb.append((char) b);
                        break;
                }
            }
            j = randomAccessFile.getFilePointer();
        }
        randomAccessFile.seek(filePointer);
        return filePointer;
    }
}
