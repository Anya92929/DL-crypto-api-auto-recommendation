package android.support.p000v4.p002os;

import android.os.Build;

/* renamed from: android.support.v4.os.CancellationSignal */
public final class CancellationSignal {

    /* renamed from: a */
    private boolean f1006a;

    /* renamed from: b */
    private OnCancelListener f1007b;

    /* renamed from: c */
    private Object f1008c;

    /* renamed from: d */
    private boolean f1009d;

    /* renamed from: android.support.v4.os.CancellationSignal$OnCancelListener */
    public interface OnCancelListener {
        void onCancel();
    }

    /* renamed from: a */
    private void m749a() {
        while (this.f1009d) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0017, code lost:
        if (r1 == null) goto L_0x001c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0019, code lost:
        android.support.p000v4.p002os.CancellationSignalCompatJellybean.cancel(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001c, code lost:
        monitor-enter(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        r2.f1009d = false;
        notifyAll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0023, code lost:
        monitor-exit(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x002b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x002c, code lost:
        monitor-enter(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        r2.f1009d = false;
        notifyAll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0034, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0012, code lost:
        if (r0 == null) goto L_0x0017;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
        r0.onCancel();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void cancel() {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.f1006a     // Catch:{ all -> 0x0028 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r2)     // Catch:{ all -> 0x0028 }
        L_0x0006:
            return
        L_0x0007:
            r0 = 1
            r2.f1006a = r0     // Catch:{ all -> 0x0028 }
            r0 = 1
            r2.f1009d = r0     // Catch:{ all -> 0x0028 }
            android.support.v4.os.CancellationSignal$OnCancelListener r0 = r2.f1007b     // Catch:{ all -> 0x0028 }
            java.lang.Object r1 = r2.f1008c     // Catch:{ all -> 0x0028 }
            monitor-exit(r2)     // Catch:{ all -> 0x0028 }
            if (r0 == 0) goto L_0x0017
            r0.onCancel()     // Catch:{ all -> 0x002b }
        L_0x0017:
            if (r1 == 0) goto L_0x001c
            android.support.p000v4.p002os.CancellationSignalCompatJellybean.cancel(r1)     // Catch:{ all -> 0x002b }
        L_0x001c:
            monitor-enter(r2)
            r0 = 0
            r2.f1009d = r0     // Catch:{ all -> 0x0025 }
            r2.notifyAll()     // Catch:{ all -> 0x0025 }
            monitor-exit(r2)     // Catch:{ all -> 0x0025 }
            goto L_0x0006
        L_0x0025:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0025 }
            throw r0
        L_0x0028:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0028 }
            throw r0
        L_0x002b:
            r0 = move-exception
            monitor-enter(r2)
            r1 = 0
            r2.f1009d = r1     // Catch:{ all -> 0x0035 }
            r2.notifyAll()     // Catch:{ all -> 0x0035 }
            monitor-exit(r2)     // Catch:{ all -> 0x0035 }
            throw r0
        L_0x0035:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0035 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p000v4.p002os.CancellationSignal.cancel():void");
    }

    public Object getCancellationSignalObject() {
        Object obj;
        if (Build.VERSION.SDK_INT < 16) {
            return null;
        }
        synchronized (this) {
            if (this.f1008c == null) {
                this.f1008c = CancellationSignalCompatJellybean.create();
                if (this.f1006a) {
                    CancellationSignalCompatJellybean.cancel(this.f1008c);
                }
            }
            obj = this.f1008c;
        }
        return obj;
    }

    public boolean isCanceled() {
        boolean z;
        synchronized (this) {
            z = this.f1006a;
        }
        return z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setOnCancelListener(android.support.p000v4.p002os.CancellationSignal.OnCancelListener r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            r1.m749a()     // Catch:{ all -> 0x0014 }
            android.support.v4.os.CancellationSignal$OnCancelListener r0 = r1.f1007b     // Catch:{ all -> 0x0014 }
            if (r0 != r2) goto L_0x000a
            monitor-exit(r1)     // Catch:{ all -> 0x0014 }
        L_0x0009:
            return
        L_0x000a:
            r1.f1007b = r2     // Catch:{ all -> 0x0014 }
            boolean r0 = r1.f1006a     // Catch:{ all -> 0x0014 }
            if (r0 == 0) goto L_0x0012
            if (r2 != 0) goto L_0x0017
        L_0x0012:
            monitor-exit(r1)     // Catch:{ all -> 0x0014 }
            goto L_0x0009
        L_0x0014:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0014 }
            throw r0
        L_0x0017:
            monitor-exit(r1)     // Catch:{ all -> 0x0014 }
            r2.onCancel()
            goto L_0x0009
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p000v4.p002os.CancellationSignal.setOnCancelListener(android.support.v4.os.CancellationSignal$OnCancelListener):void");
    }

    public void throwIfCanceled() {
        if (isCanceled()) {
            throw new OperationCanceledException();
        }
    }
}
