package android.support.p000v4.p002os;

import android.os.CancellationSignal;

/* renamed from: android.support.v4.os.CancellationSignalCompatJellybean */
class CancellationSignalCompatJellybean {
    CancellationSignalCompatJellybean() {
    }

    public static Object create() {
        return new CancellationSignal();
    }

    public static void cancel(Object cancellationSignalObj) {
        ((CancellationSignal) cancellationSignalObj).cancel();
    }
}
