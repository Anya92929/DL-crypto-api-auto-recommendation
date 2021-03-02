package android.support.p001v4.p003os;

import android.os.Build;

/* renamed from: android.support.v4.os.CancellationSignal */
public final class CancellationSignal {

    /* renamed from: a */
    private boolean f767a;

    /* renamed from: b */
    private OnCancelListener f768b;

    /* renamed from: c */
    private Object f769c;

    /* renamed from: d */
    private boolean f770d;

    /* renamed from: android.support.v4.os.CancellationSignal$OnCancelListener */
    public interface OnCancelListener {
        void onCancel();
    }

    public boolean isCanceled() {
        boolean z;
        synchronized (this) {
            z = this.f767a;
        }
        return z;
    }

    public void throwIfCanceled() {
        if (isCanceled()) {
            throw new OperationCanceledException();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0017, code lost:
        if (r1 == null) goto L_0x001c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0019, code lost:
        p000.C0656cf.m3581a(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001c, code lost:
        monitor-enter(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        r2.f770d = false;
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
        r2.f770d = false;
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
            boolean r0 = r2.f767a     // Catch:{ all -> 0x0028 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r2)     // Catch:{ all -> 0x0028 }
        L_0x0006:
            return
        L_0x0007:
            r0 = 1
            r2.f767a = r0     // Catch:{ all -> 0x0028 }
            r0 = 1
            r2.f770d = r0     // Catch:{ all -> 0x0028 }
            android.support.v4.os.CancellationSignal$OnCancelListener r0 = r2.f768b     // Catch:{ all -> 0x0028 }
            java.lang.Object r1 = r2.f769c     // Catch:{ all -> 0x0028 }
            monitor-exit(r2)     // Catch:{ all -> 0x0028 }
            if (r0 == 0) goto L_0x0017
            r0.onCancel()     // Catch:{ all -> 0x002b }
        L_0x0017:
            if (r1 == 0) goto L_0x001c
            p000.C0656cf.m3581a(r1)     // Catch:{ all -> 0x002b }
        L_0x001c:
            monitor-enter(r2)
            r0 = 0
            r2.f770d = r0     // Catch:{ all -> 0x0025 }
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
            r2.f770d = r1     // Catch:{ all -> 0x0035 }
            r2.notifyAll()     // Catch:{ all -> 0x0035 }
            monitor-exit(r2)     // Catch:{ all -> 0x0035 }
            throw r0
        L_0x0035:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0035 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p001v4.p003os.CancellationSignal.cancel():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setOnCancelListener(android.support.p001v4.p003os.CancellationSignal.OnCancelListener r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            r1.m882a()     // Catch:{ all -> 0x0014 }
            android.support.v4.os.CancellationSignal$OnCancelListener r0 = r1.f768b     // Catch:{ all -> 0x0014 }
            if (r0 != r2) goto L_0x000a
            monitor-exit(r1)     // Catch:{ all -> 0x0014 }
        L_0x0009:
            return
        L_0x000a:
            r1.f768b = r2     // Catch:{ all -> 0x0014 }
            boolean r0 = r1.f767a     // Catch:{ all -> 0x0014 }
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
        throw new UnsupportedOperationException("Method not decompiled: android.support.p001v4.p003os.CancellationSignal.setOnCancelListener(android.support.v4.os.CancellationSignal$OnCancelListener):void");
    }

    public Object getCancellationSignalObject() {
        Object obj;
        if (Build.VERSION.SDK_INT < 16) {
            return null;
        }
        synchronized (this) {
            if (this.f769c == null) {
                this.f769c = C0656cf.m3580a();
                if (this.f767a) {
                    C0656cf.m3581a(this.f769c);
                }
            }
            obj = this.f769c;
        }
        return obj;
    }

    /* renamed from: a */
    private void m882a() {
        while (this.f770d) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
    }
}
