package com.google.android.gms.appstate;

public interface OnStateLoadedListener {
    void onStateConflict(int i, String str, byte[] bArr, byte[] bArr2);

    void onStateLoaded(int i, int i2, byte[] bArr);
}
