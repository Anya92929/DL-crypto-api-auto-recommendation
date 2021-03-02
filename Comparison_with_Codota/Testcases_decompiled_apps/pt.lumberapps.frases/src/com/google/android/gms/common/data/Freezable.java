package com.google.android.gms.common.data;

public interface Freezable {
    Object freeze();

    boolean isDataValid();
}
