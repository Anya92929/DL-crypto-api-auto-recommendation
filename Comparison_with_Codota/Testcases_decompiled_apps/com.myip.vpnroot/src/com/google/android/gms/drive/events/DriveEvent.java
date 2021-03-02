package com.google.android.gms.drive.events;

import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public interface DriveEvent extends SafeParcelable {

    public interface Listener<E extends DriveEvent> extends C0372c {
        void onEvent(E e);
    }

    int getType();
}
