package org.apache.commons.p009io.output;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

/* renamed from: org.apache.commons.io.output.FileWriterWithEncoding */
public class FileWriterWithEncoding extends Writer {

    /* renamed from: a */
    private final Writer f6995a;

    public FileWriterWithEncoding(String str, String str2) throws IOException {
        this(new File(str), str2, false);
    }

    public FileWriterWithEncoding(String str, String str2, boolean z) throws IOException {
        this(new File(str), str2, z);
    }

    public FileWriterWithEncoding(String str, Charset charset) throws IOException {
        this(new File(str), charset, false);
    }

    public FileWriterWithEncoding(String str, Charset charset, boolean z) throws IOException {
        this(new File(str), charset, z);
    }

    public FileWriterWithEncoding(String str, CharsetEncoder charsetEncoder) throws IOException {
        this(new File(str), charsetEncoder, false);
    }

    public FileWriterWithEncoding(String str, CharsetEncoder charsetEncoder, boolean z) throws IOException {
        this(new File(str), charsetEncoder, z);
    }

    public FileWriterWithEncoding(File file, String str) throws IOException {
        this(file, str, false);
    }

    public FileWriterWithEncoding(File file, String str, boolean z) throws IOException {
        this.f6995a = m7327a(file, str, z);
    }

    public FileWriterWithEncoding(File file, Charset charset) throws IOException {
        this(file, charset, false);
    }

    public FileWriterWithEncoding(File file, Charset charset, boolean z) throws IOException {
        this.f6995a = m7327a(file, charset, z);
    }

    public FileWriterWithEncoding(File file, CharsetEncoder charsetEncoder) throws IOException {
        this(file, charsetEncoder, false);
    }

    public FileWriterWithEncoding(File file, CharsetEncoder charsetEncoder, boolean z) throws IOException {
        this.f6995a = m7327a(file, charsetEncoder, z);
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0054  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.io.Writer m7327a(java.io.File r4, java.lang.Object r5, boolean r6) throws java.io.IOException {
        /*
            r2 = 0
            if (r4 != 0) goto L_0x000b
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "File is missing"
            r0.<init>(r1)
            throw r0
        L_0x000b:
            if (r5 != 0) goto L_0x0015
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Encoding is missing"
            r0.<init>(r1)
            throw r0
        L_0x0015:
            boolean r3 = r4.exists()
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x005b, RuntimeException -> 0x0058 }
            r1.<init>(r4, r6)     // Catch:{ IOException -> 0x005b, RuntimeException -> 0x0058 }
            boolean r0 = r5 instanceof java.nio.charset.Charset     // Catch:{ IOException -> 0x0036, RuntimeException -> 0x004b }
            if (r0 == 0) goto L_0x002a
            java.io.OutputStreamWriter r0 = new java.io.OutputStreamWriter     // Catch:{ IOException -> 0x0036, RuntimeException -> 0x004b }
            java.nio.charset.Charset r5 = (java.nio.charset.Charset) r5     // Catch:{ IOException -> 0x0036, RuntimeException -> 0x004b }
            r0.<init>(r1, r5)     // Catch:{ IOException -> 0x0036, RuntimeException -> 0x004b }
        L_0x0029:
            return r0
        L_0x002a:
            boolean r0 = r5 instanceof java.nio.charset.CharsetEncoder     // Catch:{ IOException -> 0x0036, RuntimeException -> 0x004b }
            if (r0 == 0) goto L_0x0043
            java.io.OutputStreamWriter r0 = new java.io.OutputStreamWriter     // Catch:{ IOException -> 0x0036, RuntimeException -> 0x004b }
            java.nio.charset.CharsetEncoder r5 = (java.nio.charset.CharsetEncoder) r5     // Catch:{ IOException -> 0x0036, RuntimeException -> 0x004b }
            r0.<init>(r1, r5)     // Catch:{ IOException -> 0x0036, RuntimeException -> 0x004b }
            goto L_0x0029
        L_0x0036:
            r0 = move-exception
        L_0x0037:
            org.apache.commons.p009io.IOUtils.closeQuietly((java.io.Writer) r2)
            org.apache.commons.p009io.IOUtils.closeQuietly((java.io.OutputStream) r1)
            if (r3 != 0) goto L_0x0042
            org.apache.commons.p009io.FileUtils.deleteQuietly(r4)
        L_0x0042:
            throw r0
        L_0x0043:
            java.io.OutputStreamWriter r0 = new java.io.OutputStreamWriter     // Catch:{ IOException -> 0x0036, RuntimeException -> 0x004b }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ IOException -> 0x0036, RuntimeException -> 0x004b }
            r0.<init>(r1, r5)     // Catch:{ IOException -> 0x0036, RuntimeException -> 0x004b }
            goto L_0x0029
        L_0x004b:
            r0 = move-exception
        L_0x004c:
            org.apache.commons.p009io.IOUtils.closeQuietly((java.io.Writer) r2)
            org.apache.commons.p009io.IOUtils.closeQuietly((java.io.OutputStream) r1)
            if (r3 != 0) goto L_0x0057
            org.apache.commons.p009io.FileUtils.deleteQuietly(r4)
        L_0x0057:
            throw r0
        L_0x0058:
            r0 = move-exception
            r1 = r2
            goto L_0x004c
        L_0x005b:
            r0 = move-exception
            r1 = r2
            goto L_0x0037
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.p009io.output.FileWriterWithEncoding.m7327a(java.io.File, java.lang.Object, boolean):java.io.Writer");
    }

    public void write(int i) throws IOException {
        this.f6995a.write(i);
    }

    public void write(char[] cArr) throws IOException {
        this.f6995a.write(cArr);
    }

    public void write(char[] cArr, int i, int i2) throws IOException {
        this.f6995a.write(cArr, i, i2);
    }

    public void write(String str) throws IOException {
        this.f6995a.write(str);
    }

    public void write(String str, int i, int i2) throws IOException {
        this.f6995a.write(str, i, i2);
    }

    public void flush() throws IOException {
        this.f6995a.flush();
    }

    public void close() throws IOException {
        this.f6995a.close();
    }
}
