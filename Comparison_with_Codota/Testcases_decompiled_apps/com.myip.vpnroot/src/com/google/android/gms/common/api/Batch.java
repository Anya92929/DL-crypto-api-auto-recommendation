package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.PendingResult;
import java.util.ArrayList;
import java.util.List;

public final class Batch extends BaseImplementation.AbstractPendingResult<BatchResult> {
    /* access modifiers changed from: private */

    /* renamed from: Iv */
    public int f568Iv;
    /* access modifiers changed from: private */

    /* renamed from: Iw */
    public boolean f569Iw;
    /* access modifiers changed from: private */

    /* renamed from: Ix */
    public boolean f570Ix;
    /* access modifiers changed from: private */

    /* renamed from: Iy */
    public final PendingResult<?>[] f571Iy;
    /* access modifiers changed from: private */

    /* renamed from: mw */
    public final Object f572mw;

    public static final class Builder {

        /* renamed from: IA */
        private List<PendingResult<?>> f574IA = new ArrayList();

        /* renamed from: IB */
        private Looper f575IB;

        public Builder(GoogleApiClient googleApiClient) {
            this.f575IB = googleApiClient.getLooper();
        }

        public <R extends Result> BatchResultToken<R> add(PendingResult<R> pendingResult) {
            BatchResultToken<R> batchResultToken = new BatchResultToken<>(this.f574IA.size());
            this.f574IA.add(pendingResult);
            return batchResultToken;
        }

        public Batch build() {
            return new Batch(this.f574IA, this.f575IB);
        }
    }

    private Batch(List<PendingResult<?>> pendingResultList, Looper looper) {
        super(new BaseImplementation.CallbackHandler(looper));
        this.f572mw = new Object();
        this.f568Iv = pendingResultList.size();
        this.f571Iy = new PendingResult[this.f568Iv];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < pendingResultList.size()) {
                PendingResult<?> pendingResult = pendingResultList.get(i2);
                this.f571Iy[i2] = pendingResult;
                pendingResult.mo4191a(new PendingResult.C0272a() {
                    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
                        return;
                     */
                    /* renamed from: n */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public void mo4214n(com.google.android.gms.common.api.Status r6) {
                        /*
                            r5 = this;
                            com.google.android.gms.common.api.Batch r0 = com.google.android.gms.common.api.Batch.this
                            java.lang.Object r1 = r0.f572mw
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
                            boolean unused = r0.f570Ix = r2     // Catch:{ all -> 0x0039 }
                        L_0x001d:
                            com.google.android.gms.common.api.Batch r0 = com.google.android.gms.common.api.Batch.this     // Catch:{ all -> 0x0039 }
                            com.google.android.gms.common.api.Batch.m509b(r0)     // Catch:{ all -> 0x0039 }
                            com.google.android.gms.common.api.Batch r0 = com.google.android.gms.common.api.Batch.this     // Catch:{ all -> 0x0039 }
                            int r0 = r0.f568Iv     // Catch:{ all -> 0x0039 }
                            if (r0 != 0) goto L_0x0037
                            com.google.android.gms.common.api.Batch r0 = com.google.android.gms.common.api.Batch.this     // Catch:{ all -> 0x0039 }
                            boolean r0 = r0.f570Ix     // Catch:{ all -> 0x0039 }
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
                            boolean unused = r0.f569Iw = r2     // Catch:{ all -> 0x0039 }
                            goto L_0x001d
                        L_0x0049:
                            com.google.android.gms.common.api.Batch r0 = com.google.android.gms.common.api.Batch.this     // Catch:{ all -> 0x0039 }
                            boolean r0 = r0.f569Iw     // Catch:{ all -> 0x0039 }
                            if (r0 == 0) goto L_0x0069
                            com.google.android.gms.common.api.Status r0 = new com.google.android.gms.common.api.Status     // Catch:{ all -> 0x0039 }
                            r2 = 13
                            r0.<init>(r2)     // Catch:{ all -> 0x0039 }
                        L_0x0058:
                            com.google.android.gms.common.api.Batch r2 = com.google.android.gms.common.api.Batch.this     // Catch:{ all -> 0x0039 }
                            com.google.android.gms.common.api.BatchResult r3 = new com.google.android.gms.common.api.BatchResult     // Catch:{ all -> 0x0039 }
                            com.google.android.gms.common.api.Batch r4 = com.google.android.gms.common.api.Batch.this     // Catch:{ all -> 0x0039 }
                            com.google.android.gms.common.api.PendingResult[] r4 = r4.f571Iy     // Catch:{ all -> 0x0039 }
                            r3.<init>(r0, r4)     // Catch:{ all -> 0x0039 }
                            r2.mo4196b(r3)     // Catch:{ all -> 0x0039 }
                            goto L_0x0037
                        L_0x0069:
                            com.google.android.gms.common.api.Status r0 = com.google.android.gms.common.api.Status.f591Jo     // Catch:{ all -> 0x0039 }
                            goto L_0x0058
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.Batch.C02711.mo4214n(com.google.android.gms.common.api.Status):void");
                    }
                });
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* renamed from: b */
    static /* synthetic */ int m509b(Batch batch) {
        int i = batch.f568Iv;
        batch.f568Iv = i - 1;
        return i;
    }

    public void cancel() {
        super.cancel();
        for (PendingResult<?> cancel : this.f571Iy) {
            cancel.cancel();
        }
    }

    /* renamed from: createFailedResult */
    public BatchResult mo3773c(Status status) {
        return new BatchResult(status, this.f571Iy);
    }
}
