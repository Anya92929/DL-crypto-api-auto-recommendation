package com.google.android.gms.internal;

import android.net.LocalSocket;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.games.multiplayer.realtime.RealTimeSocket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.google.android.gms.internal.et */
final class C0500et implements RealTimeSocket {

    /* renamed from: jN */
    private ParcelFileDescriptor f1274jN;

    /* renamed from: nd */
    private final String f1275nd;

    /* renamed from: nt */
    private final LocalSocket f1276nt;

    C0500et(LocalSocket localSocket, String str) {
        this.f1276nt = localSocket;
        this.f1275nd = str;
    }

    public void close() throws IOException {
        this.f1276nt.close();
    }

    public InputStream getInputStream() throws IOException {
        return this.f1276nt.getInputStream();
    }

    public OutputStream getOutputStream() throws IOException {
        return this.f1276nt.getOutputStream();
    }

    public ParcelFileDescriptor getParcelFileDescriptor() throws IOException {
        if (this.f1274jN == null && !isClosed()) {
            Parcel obtain = Parcel.obtain();
            obtain.writeFileDescriptor(this.f1276nt.getFileDescriptor());
            obtain.setDataPosition(0);
            this.f1274jN = obtain.readFileDescriptor();
        }
        return this.f1274jN;
    }

    public boolean isClosed() {
        return !this.f1276nt.isConnected() && !this.f1276nt.isBound();
    }
}
