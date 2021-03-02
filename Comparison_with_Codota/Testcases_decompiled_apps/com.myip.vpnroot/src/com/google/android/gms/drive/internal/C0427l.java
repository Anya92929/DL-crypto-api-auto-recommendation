package com.google.android.gms.drive.internal;

import com.google.android.gms.drive.Metadata;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

/* renamed from: com.google.android.gms.drive.internal.l */
public final class C0427l extends Metadata {

    /* renamed from: Oj */
    private final MetadataBundle f995Oj;

    public C0427l(MetadataBundle metadataBundle) {
        this.f995Oj = metadataBundle;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public <T> T mo4645a(MetadataField<T> metadataField) {
        return this.f995Oj.mo5134a(metadataField);
    }

    /* renamed from: hR */
    public Metadata freeze() {
        return new C0427l(MetadataBundle.m1385a(this.f995Oj));
    }

    public boolean isDataValid() {
        return this.f995Oj != null;
    }

    public String toString() {
        return "Metadata [mImpl=" + this.f995Oj + "]";
    }
}
