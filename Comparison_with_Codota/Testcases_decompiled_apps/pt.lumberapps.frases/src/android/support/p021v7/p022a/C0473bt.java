package android.support.p021v7.p022a;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.support.p009v4.p010a.C0053s;
import android.util.Log;
import java.util.Calendar;

/* renamed from: android.support.v7.a.bt */
class C0473bt {

    /* renamed from: a */
    private static final C0475bv f701a = new C0475bv();

    /* renamed from: b */
    private final Context f702b;

    /* renamed from: c */
    private final LocationManager f703c;

    C0473bt(Context context) {
        this.f702b = context;
        this.f703c = (LocationManager) context.getSystemService("location");
    }

    /* renamed from: a */
    private Location m2010a(String str) {
        if (this.f703c != null) {
            try {
                if (this.f703c.isProviderEnabled(str)) {
                    return this.f703c.getLastKnownLocation(str);
                }
            } catch (Exception e) {
                Log.d("TwilightManager", "Failed to get last known location", e);
            }
        }
        return null;
    }

    /* renamed from: a */
    private void m2011a(Location location) {
        long j;
        C0475bv bvVar = f701a;
        long currentTimeMillis = System.currentTimeMillis();
        C0472bs a = C0472bs.m2008a();
        a.mo2073a(currentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        long j2 = a.f698a;
        a.mo2073a(currentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z = a.f700c == 1;
        long j3 = a.f699b;
        long j4 = a.f698a;
        a.mo2073a(86400000 + currentTimeMillis, location.getLatitude(), location.getLongitude());
        long j5 = a.f699b;
        if (j3 == -1 || j4 == -1) {
            j = 43200000 + currentTimeMillis;
        } else {
            j = (currentTimeMillis > j4 ? 0 + j5 : currentTimeMillis > j3 ? 0 + j4 : 0 + j3) + 60000;
        }
        bvVar.f704a = z;
        bvVar.f705b = j2;
        bvVar.f706c = j3;
        bvVar.f707d = j4;
        bvVar.f708e = j5;
        bvVar.f709f = j;
    }

    /* renamed from: a */
    private boolean m2012a(C0475bv bvVar) {
        return bvVar != null && bvVar.f709f > System.currentTimeMillis();
    }

    /* renamed from: b */
    private Location m2013b() {
        Location location = null;
        Location a = C0053s.m181a(this.f702b, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? m2010a("network") : null;
        if (C0053s.m181a(this.f702b, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            location = m2010a("gps");
        }
        if (location != null && a != null) {
            return location.getTime() > a.getTime() ? location : a;
        }
        if (location == null) {
            location = a;
        }
        return location;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo2074a() {
        C0475bv bvVar = f701a;
        if (m2012a(bvVar)) {
            return bvVar.f704a;
        }
        Location b = m2013b();
        if (b != null) {
            m2011a(b);
            return bvVar.f704a;
        }
        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int i = Calendar.getInstance().get(11);
        return i < 6 || i >= 22;
    }
}
