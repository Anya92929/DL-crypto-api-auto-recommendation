package com.jackhenry.godough.core.locations;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C0702a;
import com.google.android.gms.common.api.C0740e;
import com.google.android.gms.common.api.C0749n;
import com.google.android.gms.common.api.C0750o;
import com.google.android.gms.common.api.C0752q;
import com.google.android.gms.common.api.C0753r;
import com.google.android.gms.location.C1119h;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.core.model.GoDoughLocation;
import com.jackhenry.godough.core.model.LocationSearchCriteria;
import java.util.Collections;
import java.util.List;

public class LocationsFragmentActivity extends AbstractLocationActivity implements C0752q, C0753r, C1624w {
    public static final int ACTIVITY_GPS_REQ = 5003;
    public static final int DIALOG_NO_GPS = 5027;

    /* renamed from: n */
    protected C0749n f6223n;

    /* renamed from: o */
    private C1623v f6224o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public LocationsFragmentActivity f6225p;

    /* renamed from: q */
    private boolean f6226q = false;

    /* renamed from: r */
    private boolean f6227r = false;

    /* renamed from: a */
    private void m6261a(Location location) {
        List<GoDoughLocation> locations = GoDoughApp.getLocations();
        this.f6225p.f6224o = null;
        if (locations != null) {
            Location location2 = new Location("");
            for (GoDoughLocation next : locations) {
                location2.setLatitude(next.getLatitude());
                location2.setLongitude(next.getLongitude());
                float distanceTo = location2.distanceTo(location) * 6.2137E-4f;
                next.setMilesToLocation((double) distanceTo);
                if (distanceTo <= 10.0f && !this.f6227r) {
                    this.f6226q = true;
                }
            }
            Collections.sort(locations);
        }
    }

    /* renamed from: a */
    private void m6262a(Class<?> cls, LocationSearchCriteria locationSearchCriteria) {
        Intent intent = new Intent(GoDoughApp.getApp(), cls);
        intent.putExtra(AbstractLocationActivity.PARAM_LOGGED_IN, this.f6171m);
        if (locationSearchCriteria != null) {
            intent.putExtra(LocationSearchCriteria.KEY_LOCATION_SEARCH_CRITERIA, locationSearchCriteria);
        }
        if (this.f6226q) {
            intent.putExtra(LocationResultsFragmentActivity.PARAM_MAP_MODE, this.f6226q);
        }
        if (this.f6227r) {
            intent.putExtra(LocationResultsFragmentActivity.PARAM_SHOW_ALL, this.f6227r);
        }
        startActivity(intent);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public Fragment mo9485d() {
        return getSupportFragmentManager().findFragmentById(C1494ai.locations);
    }

    public void loadData() {
        mo9483a(getString(C1506am.ellipse_requesting_locations));
        C1598ab abVar = new C1598ab(this, mo9485d(), new C1625x(this));
        if (getSupportLoaderManager().getLoader(0) == null) {
            getSupportLoaderManager().initLoader(0, (Bundle) null, abVar);
        } else {
            getSupportLoaderManager().restartLoader(0, (Bundle) null, abVar);
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (5003 == i && this.f6224o != null) {
            onFragementNavigate(this.f6224o);
        }
    }

    public void onConnected(Bundle bundle) {
        Location a = C1119h.f4934b.mo7794a(this.f6223n);
        if (a == null) {
            showDialog(getString(C1506am.error), getString(C1506am.no_gps));
        }
        dismissLoadingDialog();
        m6261a(a);
        this.f6223n.mo7380b();
        LocationSearchCriteria locationSearchCriteria = new LocationSearchCriteria();
        locationSearchCriteria.setLatLng(a.getLatitude(), a.getLongitude());
        m6262a(LocationResultsFragmentActivity.class, locationSearchCriteria);
    }

    public void onConnectionFailed(ConnectionResult connectionResult) {
    }

    public void onConnectionSuspended(int i) {
        this.f6223n.mo7372a();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        this.f6223n = new C0750o(this).mo7446a((C0752q) this).mo7447a((C0753r) this).mo7445a((C0702a<? extends C0740e>) C1119h.f4933a).mo7449b();
        if (GoDoughApp.getUserSettings() == null) {
            setShowArrowOnToolbar(true);
        }
        super.onCreate(bundle);
        this.f6225p = this;
        setContentView(C1496ak.locations_activity);
        if (GoDoughApp.getUserSettings() == null || GoDoughApp.getUserSettings().getUserMenu() == null) {
            setShowArrowOnToolbar(true);
        } else {
            getSupportActionBar().setTitle((CharSequence) GoDoughApp.getUserSettings().getUserMenu().getLocations().getText());
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onFragementNavigate(com.jackhenry.godough.core.locations.C1623v r10) {
        /*
            r9 = this;
            r8 = 0
            r2 = 1
            r3 = 0
            java.lang.Class<com.jackhenry.godough.core.locations.LocationResultsFragmentActivity> r1 = com.jackhenry.godough.core.locations.LocationResultsFragmentActivity.class
            r9.f6227r = r3
            r9.f6226q = r3
            com.jackhenry.godough.core.locations.LocationsFragmentActivity r0 = r9.f6225p
            java.lang.String r4 = "location"
            java.lang.Object r0 = r0.getSystemService(r4)
            android.location.LocationManager r0 = (android.location.LocationManager) r0
            java.util.List r4 = com.jackhenry.godough.core.GoDoughApp.getLocations()
            int[] r5 = com.jackhenry.godough.core.locations.C1597aa.f6229a
            int r6 = r10.ordinal()
            r5 = r5[r6]
            switch(r5) {
                case 1: goto L_0x0033;
                case 2: goto L_0x005b;
                case 3: goto L_0x00cc;
                case 4: goto L_0x00d0;
                default: goto L_0x0022;
            }
        L_0x0022:
            r0 = r1
        L_0x0023:
            com.jackhenry.godough.core.locations.v r1 = com.jackhenry.godough.core.locations.C1623v.NEAR_ME
            if (r10 == r1) goto L_0x00d4
            r1 = r2
        L_0x0028:
            com.jackhenry.godough.core.locations.v r4 = com.jackhenry.godough.core.locations.C1623v.SHOW_ALL
            if (r10 == r4) goto L_0x00d7
        L_0x002c:
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0032
            r9.m6262a(r0, r8)
        L_0x0032:
            return
        L_0x0033:
            r9.f6227r = r2
            if (r4 == 0) goto L_0x005b
            java.util.List r0 = com.jackhenry.godough.core.GoDoughApp.getLocations()
            if (r0 == 0) goto L_0x0056
            java.util.Iterator r5 = r4.iterator()
        L_0x0041:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L_0x0053
            java.lang.Object r0 = r5.next()
            com.jackhenry.godough.core.model.GoDoughLocation r0 = (com.jackhenry.godough.core.model.GoDoughLocation) r0
            r6 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            r0.setMilesToLocation(r6)
            goto L_0x0041
        L_0x0053:
            java.util.Collections.sort(r4)
        L_0x0056:
            r9.m6262a(r1, r8)
            r0 = r1
            goto L_0x0023
        L_0x005b:
            if (r4 == 0) goto L_0x0022
            java.lang.String r4 = "gps"
            boolean r4 = r0.isProviderEnabled(r4)
            if (r4 != 0) goto L_0x00bb
            java.lang.String r4 = "network"
            boolean r0 = r0.isProviderEnabled(r4)
            if (r0 != 0) goto L_0x00bb
            com.jackhenry.godough.core.locations.LocationsFragmentActivity r0 = r9.f6225p
            r0.f6224o = r10
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            com.jackhenry.godough.core.e.c r0 = new com.jackhenry.godough.core.e.c
            r1 = -1
            int r2 = com.jackhenry.godough.core.C1506am.btn_ok
            java.lang.String r2 = r9.getString(r2)
            r0.<init>(r1, r2)
            r5.add(r0)
            com.jackhenry.godough.core.e.c r0 = new com.jackhenry.godough.core.e.c
            r1 = -2
            int r2 = com.jackhenry.godough.core.C1506am.no_connectivity_settings
            java.lang.String r2 = r9.getString(r2)
            r0.<init>(r1, r2)
            r5.add(r0)
            com.jackhenry.godough.core.e.e r0 = new com.jackhenry.godough.core.e.e
            com.jackhenry.godough.core.e.f r1 = com.jackhenry.godough.core.p038e.C1577f.ERROR
            r2 = 5027(0x13a3, float:7.044E-42)
            int r3 = com.jackhenry.godough.core.C1506am.no_gps_title
            java.lang.String r3 = r9.getString(r3)
            int r4 = com.jackhenry.godough.core.C1506am.no_gps
            java.lang.String r4 = r9.getString(r4)
            r0.<init>((com.jackhenry.godough.core.p038e.C1577f) r1, (int) r2, (java.lang.String) r3, (java.lang.String) r4, (java.util.List<com.jackhenry.godough.core.p038e.C1574c>) r5)
            com.jackhenry.godough.core.locations.z r1 = new com.jackhenry.godough.core.locations.z
            r1.<init>(r9)
            r0.mo9791a((com.jackhenry.godough.core.p038e.C1578g) r1)
            r9.showDialog(r0)
            goto L_0x0032
        L_0x00bb:
            int r0 = com.jackhenry.godough.core.C1506am.ellipse_requesting_obtaining
            java.lang.String r0 = r9.getString(r0)
            r9.mo9483a((java.lang.String) r0)
            com.google.android.gms.common.api.n r0 = r9.f6223n
            r0.mo7372a()
            r0 = r1
            goto L_0x0023
        L_0x00cc:
            java.lang.Class<com.jackhenry.godough.core.locations.LocationZipFragmentActivity> r0 = com.jackhenry.godough.core.locations.LocationZipFragmentActivity.class
            goto L_0x0023
        L_0x00d0:
            java.lang.Class<com.jackhenry.godough.core.locations.LocationCityFragmentActivity> r0 = com.jackhenry.godough.core.locations.LocationCityFragmentActivity.class
            goto L_0x0023
        L_0x00d4:
            r1 = r3
            goto L_0x0028
        L_0x00d7:
            r2 = r3
            goto L_0x002c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jackhenry.godough.core.locations.LocationsFragmentActivity.onFragementNavigate(com.jackhenry.godough.core.locations.v):void");
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (iArr[0] == 0 && strArr[0].equals("android.permission.WRITE_EXTERNAL_STORAGE") && GoDoughApp.getLocations() == null) {
            loadData();
        }
    }
}
