package com.google.android.gms.games.snapshot;

import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.drive.Contents;

public interface Snapshot extends Parcelable, Freezable<Snapshot> {
    @Deprecated
    Contents getContents();

    SnapshotMetadata getMetadata();

    SnapshotContents getSnapshotContents();

    @Deprecated
    boolean modifyBytes(int i, byte[] bArr, int i2, int i3);

    @Deprecated
    byte[] readFully();

    @Deprecated
    boolean writeBytes(byte[] bArr);
}
