package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.internal.C1295i;
import java.io.IOException;

/* renamed from: com.google.android.gms.internal.j */
public class C1358j extends C1295i {

    /* renamed from: com.google.android.gms.internal.j$a */
    class C1359a {

        /* renamed from: kO */
        private String f4090kO;

        /* renamed from: kP */
        private boolean f4091kP;

        public C1359a(String str, boolean z) {
            this.f4090kO = str;
            this.f4091kP = z;
        }

        public String getId() {
            return this.f4090kO;
        }

        public boolean isLimitAdTrackingEnabled() {
            return this.f4091kP;
        }
    }

    protected C1358j(Context context, C1551m mVar, C1582n nVar) {
        super(context, mVar, nVar);
    }

    /* renamed from: a */
    public static C1358j m5095a(String str, Context context) {
        C1084e eVar = new C1084e();
        m4848a(str, context, eVar);
        return new C1358j(context, eVar, new C1700p(239));
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo8692b(Context context) {
        super.mo8692b(context);
        try {
            C1359a h = mo8972h(context);
            mo8689a(28, h.isLimitAdTrackingEnabled() ? 1 : 0);
            String id = h.getId();
            if (id != null) {
                mo8689a(26, 5);
                mo8690a(24, id);
            }
        } catch (GooglePlayServicesNotAvailableException e) {
            try {
                mo8690a(24, m4851d(context));
            } catch (C1295i.C1296a | IOException e2) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public C1359a mo8972h(Context context) throws IOException, GooglePlayServicesNotAvailableException {
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
                str = this.f3822ky.mo8399a(bArr, true);
            }
            return new C1359a(str, advertisingIdInfo.isLimitAdTrackingEnabled());
        } catch (GooglePlayServicesRepairableException e) {
            throw new IOException(e);
        } catch (SecurityException e2) {
            throw new IOException(e2);
        }
    }
}
