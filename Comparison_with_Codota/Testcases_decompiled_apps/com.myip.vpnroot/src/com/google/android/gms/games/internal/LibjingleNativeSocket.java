package com.google.android.gms.games.internal;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.games.multiplayer.realtime.RealTimeSocket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class LibjingleNativeSocket implements RealTimeSocket {
    private static final String TAG = LibjingleNativeSocket.class.getSimpleName();

    /* renamed from: Kx */
    private final ParcelFileDescriptor f1942Kx;

    /* renamed from: XM */
    private final InputStream f1943XM;

    /* renamed from: XN */
    private final OutputStream f1944XN;

    LibjingleNativeSocket(ParcelFileDescriptor parcelFileDescriptor) {
        this.f1942Kx = parcelFileDescriptor;
        this.f1943XM = new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor);
        this.f1944XN = new ParcelFileDescriptor.AutoCloseOutputStream(parcelFileDescriptor);
    }

    public void close() throws IOException {
        this.f1942Kx.close();
    }

    public InputStream getInputStream() throws IOException {
        return this.f1943XM;
    }

    public OutputStream getOutputStream() throws IOException {
        return this.f1944XN;
    }

    public ParcelFileDescriptor getParcelFileDescriptor() throws IOException {
        return this.f1942Kx;
    }

    public boolean isClosed() {
        try {
            this.f1943XM.available();
            return false;
        } catch (IOException e) {
            return true;
        }
    }
}
