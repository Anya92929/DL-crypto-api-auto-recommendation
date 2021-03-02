package com.google.android.gms.internal;

import android.os.ParcelFileDescriptor;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.google.android.gms.internal.jy */
public final class C1389jy {
    /* renamed from: a */
    public static long m5219a(InputStream inputStream, OutputStream outputStream, boolean z) throws IOException {
        return m5220a(inputStream, outputStream, z, 1024);
    }

    /* renamed from: a */
    public static long m5220a(InputStream inputStream, OutputStream outputStream, boolean z, int i) throws IOException {
        byte[] bArr = new byte[i];
        long j = 0;
        while (true) {
            try {
                int read = inputStream.read(bArr, 0, bArr.length);
                if (read == -1) {
                    break;
                }
                j += (long) read;
                outputStream.write(bArr, 0, read);
            } finally {
                if (z) {
                    m5223b(inputStream);
                    m5223b(outputStream);
                }
            }
        }
        return j;
    }

    /* renamed from: a */
    public static void m5221a(ParcelFileDescriptor parcelFileDescriptor) {
        if (parcelFileDescriptor != null) {
            try {
                parcelFileDescriptor.close();
            } catch (IOException e) {
            }
        }
    }

    /* renamed from: a */
    public static byte[] m5222a(InputStream inputStream, boolean z) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        m5219a(inputStream, byteArrayOutputStream, z);
        return byteArrayOutputStream.toByteArray();
    }

    /* renamed from: b */
    public static void m5223b(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }

    /* renamed from: d */
    public static byte[] m5224d(InputStream inputStream) throws IOException {
        return m5222a(inputStream, true);
    }
}
