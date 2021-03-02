package com.google.android.gms.internal;

import android.os.Process;
import android.util.SparseArray;
import java.lang.ref.ReferenceQueue;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.google.android.gms.internal.ph */
final class C1821ph extends Thread {

    /* renamed from: a */
    private final ReferenceQueue f5479a;

    /* renamed from: b */
    private final SparseArray f5480b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final AtomicBoolean f5481c = new AtomicBoolean();

    public C1821ph(ReferenceQueue referenceQueue, SparseArray sparseArray) {
        super("GoogleApiCleanup");
        this.f5479a = referenceQueue;
        this.f5480b = sparseArray;
    }

    public void run() {
        this.f5481c.set(true);
        Process.setThreadPriority(10);
        while (this.f5481c.get()) {
            try {
                C1820pg pgVar = (C1820pg) this.f5479a.remove();
                this.f5480b.remove(pgVar.f5478b);
                pgVar.mo7634a();
            } catch (InterruptedException e) {
                return;
            } finally {
                this.f5481c.set(false);
            }
        }
    }
}
