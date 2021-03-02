package com.google.android.gms.p018c;

import android.os.Process;

/* renamed from: com.google.android.gms.c.av */
class C0633av extends Thread {
    C0633av(Runnable runnable, String str) {
        super(runnable, str);
    }

    public void run() {
        Process.setThreadPriority(10);
        super.run();
    }
}
