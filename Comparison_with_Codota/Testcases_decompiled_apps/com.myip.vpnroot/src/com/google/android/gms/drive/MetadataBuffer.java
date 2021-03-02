package com.google.android.gms.drive;

import com.google.android.gms.common.data.C0294a;
import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.internal.C0427l;
import com.google.android.gms.drive.metadata.C0494b;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.C0503e;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.C1395kd;

public final class MetadataBuffer extends DataBuffer<Metadata> {

    /* renamed from: Ni */
    private final String f827Ni;

    /* renamed from: Nj */
    private C0361a f828Nj;

    /* renamed from: com.google.android.gms.drive.MetadataBuffer$a */
    private static class C0361a extends Metadata {

        /* renamed from: IC */
        private final DataHolder f829IC;

        /* renamed from: JR */
        private final int f830JR;
        /* access modifiers changed from: private */

        /* renamed from: Nk */
        public final int f831Nk;

        public C0361a(DataHolder dataHolder, int i) {
            this.f829IC = dataHolder;
            this.f831Nk = i;
            this.f830JR = dataHolder.mo4304ar(i);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public <T> T mo4645a(MetadataField<T> metadataField) {
            return metadataField.mo5113a(this.f829IC, this.f831Nk, this.f830JR);
        }

        /* renamed from: hR */
        public Metadata freeze() {
            MetadataBundle io = MetadataBundle.m1386io();
            for (MetadataField<C0294a> next : C0503e.m1410in()) {
                if (!(next instanceof C0494b) && next != C1395kd.f4169Qd) {
                    next.mo5114a(this.f829IC, io, this.f831Nk, this.f830JR);
                }
            }
            return new C0427l(io);
        }

        public boolean isDataValid() {
            return !this.f829IC.isClosed();
        }
    }

    public MetadataBuffer(DataHolder dataHolder, String nextPageToken) {
        super(dataHolder);
        this.f827Ni = nextPageToken;
        dataHolder.mo4321gz().setClassLoader(MetadataBuffer.class.getClassLoader());
    }

    public Metadata get(int row) {
        C0361a aVar = this.f828Nj;
        if (aVar != null && aVar.f831Nk == row) {
            return aVar;
        }
        C0361a aVar2 = new C0361a(this.f667IC, row);
        this.f828Nj = aVar2;
        return aVar2;
    }

    public String getNextPageToken() {
        return this.f827Ni;
    }
}
