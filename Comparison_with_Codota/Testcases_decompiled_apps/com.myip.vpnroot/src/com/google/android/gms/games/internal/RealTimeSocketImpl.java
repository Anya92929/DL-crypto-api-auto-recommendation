package com.google.android.gms.games.internal;

import android.net.LocalSocket;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.games.multiplayer.realtime.RealTimeSocket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

final class RealTimeSocketImpl implements RealTimeSocket {

    /* renamed from: Kx */
    private ParcelFileDescriptor f1951Kx;

    /* renamed from: XT */
    private final LocalSocket f1952XT;

    /* renamed from: Xg */
    private final String f1953Xg;

    RealTimeSocketImpl(LocalSocket localSocket, String participantId) {
        this.f1952XT = localSocket;
        this.f1953Xg = participantId;
    }

    public void close() throws IOException {
        this.f1952XT.close();
    }

    public InputStream getInputStream() throws IOException {
        return this.f1952XT.getInputStream();
    }

    public OutputStream getOutputStream() throws IOException {
        return this.f1952XT.getOutputStream();
    }

    public ParcelFileDescriptor getParcelFileDescriptor() throws IOException {
        if (this.f1951Kx == null && !isClosed()) {
            Parcel obtain = Parcel.obtain();
            obtain.writeFileDescriptor(this.f1952XT.getFileDescriptor());
            obtain.setDataPosition(0);
            this.f1951Kx = obtain.readFileDescriptor();
        }
        return this.f1951Kx;
    }

    public boolean isClosed() {
        return !this.f1952XT.isConnected() && !this.f1952XT.isBound();
    }
}
