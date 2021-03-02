package com.google.android.gms.games.snapshot;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.internal.GamesLog;
import com.google.android.gms.internal.C1389jy;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public final class SnapshotContents implements SafeParcelable {
    public static final SnapshotContentsCreator CREATOR = new SnapshotContentsCreator();
    private static final Object acV = new Object();

    /* renamed from: BR */
    private final int f2387BR;

    /* renamed from: Op */
    private Contents f2388Op;

    SnapshotContents(int versionCode, Contents contents) {
        this.f2387BR = versionCode;
        this.f2388Op = contents;
    }

    public SnapshotContents(Contents contents) {
        this(1, contents);
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m3759a(int r8, byte[] r9, int r10, int r11, boolean r12) {
        /*
            r7 = this;
            r1 = 1
            r2 = 0
            boolean r0 = r7.isClosed()
            if (r0 != 0) goto L_0x003c
            r0 = r1
        L_0x0009:
            java.lang.String r3 = "Must provide a previously opened SnapshotContents"
            com.google.android.gms.common.internal.C0348n.m852a(r0, r3)
            java.lang.Object r3 = acV
            monitor-enter(r3)
            com.google.android.gms.drive.Contents r0 = r7.f2388Op     // Catch:{ all -> 0x0049 }
            android.os.ParcelFileDescriptor r0 = r0.getParcelFileDescriptor()     // Catch:{ all -> 0x0049 }
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ all -> 0x0049 }
            java.io.FileDescriptor r0 = r0.getFileDescriptor()     // Catch:{ all -> 0x0049 }
            r4.<init>(r0)     // Catch:{ all -> 0x0049 }
            java.io.BufferedOutputStream r0 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x0049 }
            r0.<init>(r4)     // Catch:{ all -> 0x0049 }
            java.nio.channels.FileChannel r4 = r4.getChannel()     // Catch:{ IOException -> 0x003e }
            long r5 = (long) r8     // Catch:{ IOException -> 0x003e }
            r4.position(r5)     // Catch:{ IOException -> 0x003e }
            r0.write(r9, r10, r11)     // Catch:{ IOException -> 0x003e }
            if (r12 == 0) goto L_0x0037
            int r5 = r9.length     // Catch:{ IOException -> 0x003e }
            long r5 = (long) r5     // Catch:{ IOException -> 0x003e }
            r4.truncate(r5)     // Catch:{ IOException -> 0x003e }
        L_0x0037:
            r0.flush()     // Catch:{ IOException -> 0x003e }
            monitor-exit(r3)     // Catch:{ all -> 0x0049 }
        L_0x003b:
            return r1
        L_0x003c:
            r0 = r2
            goto L_0x0009
        L_0x003e:
            r0 = move-exception
            java.lang.String r1 = "SnapshotContents"
            java.lang.String r4 = "Failed to write snapshot data"
            com.google.android.gms.games.internal.GamesLog.m2549a(r1, r4, r0)     // Catch:{ all -> 0x0049 }
            monitor-exit(r3)     // Catch:{ all -> 0x0049 }
            r1 = r2
            goto L_0x003b
        L_0x0049:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0049 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.games.snapshot.SnapshotContents.m3759a(int, byte[], int, int, boolean):boolean");
    }

    public void close() {
        this.f2388Op.mo4561hJ();
        this.f2388Op = null;
    }

    public int describeContents() {
        return 0;
    }

    public Contents getContents() {
        return this.f2388Op;
    }

    public ParcelFileDescriptor getParcelFileDescriptor() {
        C0348n.m852a(!isClosed(), "Cannot mutate closed contents!");
        return this.f2388Op.getParcelFileDescriptor();
    }

    public int getVersionCode() {
        return this.f2387BR;
    }

    public boolean isClosed() {
        return this.f2388Op == null;
    }

    public boolean modifyBytes(int dstOffset, byte[] content, int srcOffset, int count) {
        return m3759a(dstOffset, content, srcOffset, content.length, false);
    }

    public byte[] readFully() throws IOException {
        byte[] a;
        boolean z = false;
        if (!isClosed()) {
            z = true;
        }
        C0348n.m852a(z, "Must provide a previously opened Snapshot");
        synchronized (acV) {
            FileInputStream fileInputStream = new FileInputStream(this.f2388Op.getParcelFileDescriptor().getFileDescriptor());
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            try {
                fileInputStream.getChannel().position(0);
                a = C1389jy.m5222a(bufferedInputStream, false);
                fileInputStream.getChannel().position(0);
            } catch (IOException e) {
                GamesLog.m2550b("SnapshotContents", "Failed to read snapshot data", e);
                throw e;
            }
        }
        return a;
    }

    public boolean writeBytes(byte[] content) {
        return m3759a(0, content, 0, content.length, true);
    }

    public void writeToParcel(Parcel out, int flags) {
        SnapshotContentsCreator.m3760a(this, out, flags);
    }
}
