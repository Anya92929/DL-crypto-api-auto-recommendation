package org.apache.commons.p009io.output;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.commons.p009io.IOUtils;

/* renamed from: org.apache.commons.io.output.DeferredFileOutputStream */
public class DeferredFileOutputStream extends ThresholdingOutputStream {

    /* renamed from: a */
    private ByteArrayOutputStream f6987a;

    /* renamed from: b */
    private OutputStream f6988b;

    /* renamed from: c */
    private File f6989c;

    /* renamed from: d */
    private final String f6990d;

    /* renamed from: e */
    private final String f6991e;

    /* renamed from: f */
    private final File f6992f;

    /* renamed from: g */
    private boolean f6993g;

    public DeferredFileOutputStream(int i, File file) {
        this(i, file, (String) null, (String) null, (File) null);
    }

    public DeferredFileOutputStream(int i, String str, String str2, File file) {
        this(i, (File) null, str, str2, file);
        if (str == null) {
            throw new IllegalArgumentException("Temporary file prefix is missing");
        }
    }

    private DeferredFileOutputStream(int i, File file, String str, String str2, File file2) {
        super(i);
        this.f6993g = false;
        this.f6989c = file;
        this.f6987a = new ByteArrayOutputStream();
        this.f6988b = this.f6987a;
        this.f6990d = str;
        this.f6991e = str2;
        this.f6992f = file2;
    }

    /* access modifiers changed from: protected */
    public OutputStream getStream() throws IOException {
        return this.f6988b;
    }

    /* access modifiers changed from: protected */
    public void thresholdReached() throws IOException {
        if (this.f6990d != null) {
            this.f6989c = File.createTempFile(this.f6990d, this.f6991e, this.f6992f);
        }
        FileOutputStream fileOutputStream = new FileOutputStream(this.f6989c);
        this.f6987a.writeTo(fileOutputStream);
        this.f6988b = fileOutputStream;
        this.f6987a = null;
    }

    public boolean isInMemory() {
        return !isThresholdExceeded();
    }

    public byte[] getData() {
        if (this.f6987a != null) {
            return this.f6987a.toByteArray();
        }
        return null;
    }

    public File getFile() {
        return this.f6989c;
    }

    public void close() throws IOException {
        super.close();
        this.f6993g = true;
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        if (!this.f6993g) {
            throw new IOException("Stream not closed");
        } else if (isInMemory()) {
            this.f6987a.writeTo(outputStream);
        } else {
            FileInputStream fileInputStream = new FileInputStream(this.f6989c);
            try {
                IOUtils.copy((InputStream) fileInputStream, outputStream);
            } finally {
                IOUtils.closeQuietly((InputStream) fileInputStream);
            }
        }
    }
}
