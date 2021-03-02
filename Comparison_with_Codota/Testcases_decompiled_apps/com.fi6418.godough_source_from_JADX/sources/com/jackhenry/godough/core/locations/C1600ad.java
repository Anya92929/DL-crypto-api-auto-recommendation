package com.jackhenry.godough.core.locations;

import com.jackhenry.godough.core.model.GoDoughLocation;
import com.jackhenry.godough.core.model.LocationsResponse;
import com.jackhenry.godough.core.session.C1885a;
import com.jackhenry.godough.p028c.p029a.C1396a;
import com.jackhenry.godough.p028c.p029a.p030a.C1400b;
import com.jackhenry.godough.p028c.p029a.p030a.C1401c;
import java.util.List;

/* renamed from: com.jackhenry.godough.core.locations.ad */
public class C1600ad extends C1396a {
    /* renamed from: a */
    public List<GoDoughLocation> mo9842a(boolean z) {
        if (z) {
            C1885a.m6860a();
        }
        return ((LocationsResponse) mo9442n().mo9452a("/Locations", (C1401c) new C1400b(LocationsResponse.class))).getLocations();
    }
}
