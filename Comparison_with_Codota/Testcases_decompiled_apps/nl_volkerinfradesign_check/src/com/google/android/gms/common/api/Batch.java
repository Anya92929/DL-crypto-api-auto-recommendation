package com.google.android.gms.common.api;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.internal.zzb;
import java.util.ArrayList;
import java.util.List;

public final class Batch extends zzb<BatchResult> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public int f2611a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public boolean f2612b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f2613c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final PendingResult<?>[] f2614d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final Object f2615e;

    public static final class Builder {

        /* renamed from: a */
        private List<PendingResult<?>> f2617a = new ArrayList();

        /* renamed from: b */
        private GoogleApiClient f2618b;

        public Builder(GoogleApiClient googleApiClient) {
            this.f2618b = googleApiClient;
        }

        public <R extends Result> BatchResultToken<R> add(PendingResult<R> pendingResult) {
            BatchResultToken<R> batchResultToken = new BatchResultToken<>(this.f2617a.size());
            this.f2617a.add(pendingResult);
            return batchResultToken;
        }

        public Batch build() {
            return new Batch(this.f2617a, this.f2618b);
        }
    }

    private Batch(List<PendingResult<?>> list, GoogleApiClient googleApiClient) {
        super(googleApiClient);
        this.f2615e = new Object();
        this.f2611a = list.size();
        this.f2614d = new PendingResult[this.f2611a];
        if (list.isEmpty()) {
            zza(new BatchResult(Status.zzagC, this.f2614d));
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                PendingResult<?> pendingResult = list.get(i2);
                this.f2614d[i2] = pendingResult;
                pendingResult.zza(new PendingResult.zza() {
                    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
                        return;
                     */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public void zzu(com.google.android.gms.common.api.Status r6) {
                        /*
                            r5 = this;
                            com.google.android.gms.common.api.Batch r0 = com.google.android.gms.common.api.Batch.this
                            java.lang.Object r1 = r0.f2615e
                            monitor-enter(r1)
                            com.google.android.gms.common.api.Batch r0 = com.google.android.gms.common.api.Batch.this     // Catch:{ all -> 0x0039 }
                            boolean r0 = r0.isCanceled()     // Catch:{ all -> 0x0039 }
                            if (r0 == 0) goto L_0x0011
                            monitor-exit(r1)     // Catch:{ all -> 0x0039 }
                        L_0x0010:
                            return
                        L_0x0011:
                            boolean r0 = r6.isCanceled()     // Catch:{ all -> 0x0039 }
                            if (r0 == 0) goto L_0x003c
                            com.google.android.gms.common.api.Batch r0 = com.google.android.gms.common.api.Batch.this     // Catch:{ all -> 0x0039 }
                            r2 = 1
                            boolean unused = r0.f2613c = r2     // Catch:{ all -> 0x0039 }
                        L_0x001d:
                            com.google.android.gms.common.api.Batch r0 = com.google.android.gms.common.api.Batch.this     // Catch:{ all -> 0x0039 }
                            com.google.android.gms.common.api.Batch.m3694b(r0)     // Catch:{ all -> 0x0039 }
                            com.google.android.gms.common.api.Batch r0 = com.google.android.gms.common.api.Batch.this     // Catch:{ all -> 0x0039 }
                            int r0 = r0.f2611a     // Catch:{ all -> 0x0039 }
                            if (r0 != 0) goto L_0x0037
                            com.google.android.gms.common.api.Batch r0 = com.google.android.gms.common.api.Batch.this     // Catch:{ all -> 0x0039 }
                            boolean r0 = r0.f2613c     // Catch:{ all -> 0x0039 }
                            if (r0 == 0) goto L_0x0049
                            com.google.android.gms.common.api.Batch r0 = com.google.android.gms.common.api.Batch.this     // Catch:{ all -> 0x0039 }
                            com.google.android.gms.common.api.Batch.super.cancel()     // Catch:{ all -> 0x0039 }
                        L_0x0037:
                            monitor-exit(r1)     // Catch:{ all -> 0x0039 }
                            goto L_0x0010
                        L_0x0039:
                            r0 = move-exception
                            monitor-exit(r1)     // Catch:{ all -> 0x0039 }
                            throw r0
                        L_0x003c:
                            boolean r0 = r6.isSuccess()     // Catch:{ all -> 0x0039 }
                            if (r0 != 0) goto L_0x001d
                            com.google.android.gms.common.api.Batch r0 = com.google.android.gms.common.api.Batch.this     // Catch:{ all -> 0x0039 }
                            r2 = 1
                            boolean unused = r0.f2612b = r2     // Catch:{ all -> 0x0039 }
                            goto L_0x001d
                        L_0x0049:
                            com.google.android.gms.common.api.Batch r0 = com.google.android.gms.common.api.Batch.this     // Catch:{ all -> 0x0039 }
                            boolean r0 = r0.f2612b     // Catch:{ all -> 0x0039 }
                            if (r0 == 0) goto L_0x0069
                            com.google.android.gms.common.api.Status r0 = new com.google.android.gms.common.api.Status     // Catch:{ all -> 0x0039 }
                            r2 = 13
                            r0.<init>(r2)     // Catch:{ all -> 0x0039 }
                        L_0x0058:
                            com.google.android.gms.common.api.Batch r2 = com.google.android.gms.common.api.Batch.this     // Catch:{ all -> 0x0039 }
                            com.google.android.gms.common.api.BatchResult r3 = new com.google.android.gms.common.api.BatchResult     // Catch:{ all -> 0x0039 }
                            com.google.android.gms.common.api.Batch r4 = com.google.android.gms.common.api.Batch.this     // Catch:{ all -> 0x0039 }
                            com.google.android.gms.common.api.PendingResult[] r4 = r4.f2614d     // Catch:{ all -> 0x0039 }
                            r3.<init>(r0, r4)     // Catch:{ all -> 0x0039 }
                            r2.zza(r3)     // Catch:{ all -> 0x0039 }
                            goto L_0x0037
                        L_0x0069:
                            com.google.android.gms.common.api.Status r0 = com.google.android.gms.common.api.Status.zzagC     // Catch:{ all -> 0x0039 }
                            goto L_0x0058
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.Batch.C06811.zzu(com.google.android.gms.common.api.Status):void");
                    }
                });
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* renamed from: b */
    static /* synthetic */ int m3694b(Batch batch) {
        int i = batch.f2611a;
        batch.f2611a = i - 1;
        return i;
    }

    public void cancel() {
        super.cancel();
        for (PendingResult<?> cancel : this.f2614d) {
            cancel.cancel();
        }
    }

    /* renamed from: createFailedResult */
    public BatchResult zzc(Status status) {
        return new BatchResult(status, this.f2614d);
    }
}
