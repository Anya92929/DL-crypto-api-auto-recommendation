package com.jackhenry.godough.core.locations;

import android.app.Activity;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import com.jackhenry.android.p022a.C1362i;
import com.jackhenry.android.p022a.C1364k;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.C1758o;
import com.jackhenry.godough.core.C1759p;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.core.model.GoDoughLocation;
import com.jackhenry.godough.core.model.LocationSearchCriteria;
import com.jackhenry.godough.p027b.C1389d;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/* renamed from: com.jackhenry.godough.core.locations.af */
public class C1602af extends C1758o<Void, LocationSearchCriteria> {

    /* renamed from: e */
    private Activity f6232e;

    /* renamed from: f */
    private LocationSearchCriteria f6233f;

    public C1602af(Activity activity, LocationSearchCriteria locationSearchCriteria, C1759p<LocationSearchCriteria> pVar) {
        super(pVar);
        this.f6232e = activity;
        this.f6233f = locationSearchCriteria;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public LocationSearchCriteria mo9592a(Void... voidArr) {
        List<Address> list;
        boolean z;
        List<GoDoughLocation> locations = GoDoughApp.getLocations();
        Geocoder geocoder = new Geocoder(this.f6232e);
        try {
            String zipcode = C1364k.m5591b(this.f6233f.getZipcode()) ? this.f6233f.getZipcode() : C1364k.m5591b(this.f6233f.getCity()) ? this.f6233f.getCity() + ", " + this.f6233f.getState() : C1364k.m5591b(this.f6233f.getState()) ? this.f6233f.getState() : "";
            if (C1364k.m5591b(zipcode)) {
                list = geocoder.getFromLocationName(zipcode, 1);
                if (list == null || list.size() <= 0 || list.get(0).getAdminArea() == null || (this.f6233f.getState() != null && !list.get(0).getAdminArea().equals(C1362i.m5581a(this.f6233f.getState()).mo9284a()))) {
                    throw new C1389d(this.f6232e.getString(C1506am.dg_no_results_near, new Object[]{zipcode}), 0);
                }
            } else {
                list = null;
            }
            if (locations != null) {
                Location location = new Location("");
                double latitude = list.get(0).getLatitude();
                double longitude = list.get(0).getLongitude();
                this.f6233f.setLatLng(latitude, longitude);
                float[] fArr = new float[2];
                for (GoDoughLocation next : locations) {
                    location.setLatitude(next.getLatitude());
                    location.setLongitude(next.getLongitude());
                    Location.distanceBetween(latitude, longitude, next.getLatitude(), next.getLongitude(), fArr);
                    next.setMilesToLocation((double) (fArr[0] * 6.2137E-4f));
                }
                Collections.sort(locations);
                z = false;
            } else {
                z = true;
            }
            if (z && locations != null) {
                for (GoDoughLocation milesToLocation : locations) {
                    milesToLocation.setMilesToLocation(-1.0d);
                }
                Collections.sort(locations);
            }
            return this.f6233f;
        } catch (IOException e) {
            e.printStackTrace();
            throw new C1389d(this.f6232e.getString(C1506am.dg_search_error, new Object[]{e.getMessage()}), 1);
        }
    }
}
