package com.google.android.gms.games.snapshot;

import android.os.Parcel;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;
import java.io.IOException;

public final class SnapshotEntity implements SafeParcelable, Snapshot {
    public static final SnapshotEntityCreator CREATOR = new SnapshotEntityCreator();

    /* renamed from: BR */
    private final int f2389BR;
    private final SnapshotMetadataEntity acW;
    private final SnapshotContents acX;

    SnapshotEntity(int versionCode, SnapshotMetadata metadata, SnapshotContents contents) {
        this.f2389BR = versionCode;
        this.acW = new SnapshotMetadataEntity(metadata);
        this.acX = contents;
    }

    public SnapshotEntity(SnapshotMetadata metadata, SnapshotContents contents) {
        this(2, metadata, contents);
    }

    /* renamed from: a */
    static boolean m3761a(Snapshot snapshot, Object obj) {
        if (!(obj instanceof Snapshot)) {
            return false;
        }
        if (snapshot == obj) {
            return true;
        }
        Snapshot snapshot2 = (Snapshot) obj;
        return C0345m.equal(snapshot2.getMetadata(), snapshot.getMetadata()) && C0345m.equal(snapshot2.getSnapshotContents(), snapshot.getSnapshotContents());
    }

    /* renamed from: b */
    static int m3762b(Snapshot snapshot) {
        return C0345m.hashCode(snapshot.getMetadata(), snapshot.getSnapshotContents());
    }

    /* renamed from: c */
    static String m3763c(Snapshot snapshot) {
        return C0345m.m848h(snapshot).mo4549a("Metadata", snapshot.getMetadata()).mo4549a("HasContents", Boolean.valueOf(snapshot.getSnapshotContents() != null)).toString();
    }

    private boolean isClosed() {
        return this.acX.isClosed();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return m3761a(this, obj);
    }

    public Snapshot freeze() {
        return this;
    }

    public Contents getContents() {
        if (isClosed()) {
            return null;
        }
        return this.acX.getContents();
    }

    public SnapshotMetadata getMetadata() {
        return this.acW;
    }

    public SnapshotContents getSnapshotContents() {
        if (isClosed()) {
            return null;
        }
        return this.acX;
    }

    public int getVersionCode() {
        return this.f2389BR;
    }

    public int hashCode() {
        return m3762b(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public boolean modifyBytes(int dstOffset, byte[] content, int srcOffset, int count) {
        return this.acX.modifyBytes(dstOffset, content, srcOffset, count);
    }

    public byte[] readFully() {
        try {
            return this.acX.readFully();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String toString() {
        return m3763c(this);
    }

    public boolean writeBytes(byte[] content) {
        return this.acX.writeBytes(content);
    }

    public void writeToParcel(Parcel out, int flags) {
        SnapshotEntityCreator.m3764a(this, out, flags);
    }
}
