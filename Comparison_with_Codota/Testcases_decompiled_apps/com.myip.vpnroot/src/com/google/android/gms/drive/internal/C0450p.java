package com.google.android.gms.drive.internal;

import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.Drive;

/* renamed from: com.google.android.gms.drive.internal.p */
abstract class C0450p<R extends Result> extends BaseImplementation.C0269a<R, C0452q> {

    /* renamed from: com.google.android.gms.drive.internal.p$a */
    static abstract class C0451a extends C0450p<Status> {
        C0451a() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: d */
        public Status mo3773c(Status status) {
            return status;
        }
    }

    public C0450p() {
        super(Drive.f807CU);
    }
}
