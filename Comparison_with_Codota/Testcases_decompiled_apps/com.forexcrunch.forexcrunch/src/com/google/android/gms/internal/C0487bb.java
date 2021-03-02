package com.google.android.gms.internal;

import android.net.LocalSocket;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.games.RealTimeSocket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.google.android.gms.internal.bb */
final class C0487bb implements RealTimeSocket {

    /* renamed from: aB */
    private ParcelFileDescriptor f1105aB;

    /* renamed from: dX */
    private final String f1106dX;

    /* renamed from: en */
    private final LocalSocket f1107en;

    C0487bb(LocalSocket localSocket, String str) {
        this.f1107en = localSocket;
        this.f1106dX = str;
    }

    public void close() throws IOException {
        this.f1107en.close();
    }

    public InputStream getInputStream() throws IOException {
        return this.f1107en.getInputStream();
    }

    public OutputStream getOutputStream() throws IOException {
        return this.f1107en.getOutputStream();
    }

    public ParcelFileDescriptor getParcelFileDescriptor() throws IOException {
        if (this.f1105aB == null && !isClosed()) {
            Parcel obtain = Parcel.obtain();
            obtain.writeFileDescriptor(this.f1107en.getFileDescriptor());
            obtain.setDataPosition(0);
            this.f1105aB = obtain.readFileDescriptor();
        }
        return this.f1105aB;
    }

    public boolean isClosed() {
        return !this.f1107en.isConnected() && !this.f1107en.isBound();
    }
}
