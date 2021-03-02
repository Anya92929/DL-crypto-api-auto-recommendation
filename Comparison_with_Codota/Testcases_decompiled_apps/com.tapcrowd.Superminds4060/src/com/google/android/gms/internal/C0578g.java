package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;

/* renamed from: com.google.android.gms.internal.g */
public class C0578g extends C0518f {

    /* renamed from: com.google.android.gms.internal.g$a */
    class C0579a {

        /* renamed from: dt */
        private String f1518dt;

        /* renamed from: du */
        private boolean f1519du;

        public C0579a(String str, boolean z) {
            this.f1518dt = str;
            this.f1519du = z;
        }

        public String getId() {
            return this.f1518dt;
        }

        public boolean isLimitAdTrackingEnabled() {
            return this.f1519du;
        }
    }

    private C0578g(Context context, C0601j jVar, C0602k kVar) {
        super(context, jVar, kVar);
    }

    /* renamed from: a */
    public static C0578g m1809a(String str, Context context) {
        C0197a aVar = new C0197a();
        m1532a(str, context, aVar);
        return new C0578g(context, aVar, new C0605m(239));
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo4484b(Context context) {
        long j = 1;
        super.mo4484b(context);
        try {
            C0579a f = mo5238f(context);
            try {
                if (!f.isLimitAdTrackingEnabled()) {
                    j = 0;
                }
                mo4481a(28, j);
                String id = f.getId();
                if (id != null) {
                    mo4482a(30, id);
                }
            } catch (IOException e) {
            }
        } catch (GooglePlayServicesNotAvailableException e2) {
        } catch (IOException e3) {
            mo4481a(28, 1);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public C0579a mo5238f(Context context) throws IOException, GooglePlayServicesNotAvailableException {
        String str;
        int i = 0;
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
            String id = advertisingIdInfo.getId();
            if (id == null || !id.matches("^[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}$")) {
                str = id;
            } else {
                byte[] bArr = new byte[16];
                int i2 = 0;
                while (i < id.length()) {
                    if (i == 8 || i == 13 || i == 18 || i == 23) {
                        i++;
                    }
                    bArr[i2] = (byte) ((Character.digit(id.charAt(i), 16) << 4) + Character.digit(id.charAt(i + 1), 16));
                    i2++;
                    i += 2;
                }
                str = this.f1173di.mo4005a(bArr, true);
            }
            return new C0579a(str, advertisingIdInfo.isLimitAdTrackingEnabled());
        } catch (GooglePlayServicesRepairableException e) {
            throw new IOException(e);
        }
    }
}
