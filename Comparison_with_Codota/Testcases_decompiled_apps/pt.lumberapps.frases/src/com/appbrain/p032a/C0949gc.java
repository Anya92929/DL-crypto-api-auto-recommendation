package com.appbrain.p032a;

import android.os.Handler;
import android.os.HandlerThread;

/* renamed from: com.appbrain.a.gc */
public final class C0949gc {

    /* renamed from: a */
    private static Handler f2506a;

    /* renamed from: a */
    public static synchronized Handler m4031a() {
        Handler handler;
        synchronized (C0949gc.class) {
            if (f2506a == null) {
                HandlerThread handlerThread = new HandlerThread("appbrain_background");
                handlerThread.start();
                f2506a = new Handler(handlerThread.getLooper());
            }
            handler = f2506a;
        }
        return handler;
    }
}
