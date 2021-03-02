package com.jackhenry.godough.core.locations;

import com.jackhenry.godough.core.C1593j;
import com.jackhenry.godough.core.model.LocationSearchCriteria;

/* renamed from: com.jackhenry.godough.core.locations.b */
class C1603b implements C1593j {

    /* renamed from: a */
    final /* synthetic */ LocationSearchCriteria f6234a;

    /* renamed from: b */
    final /* synthetic */ AbstractLocationActivity f6235b;

    C1603b(AbstractLocationActivity abstractLocationActivity, LocationSearchCriteria locationSearchCriteria) {
        this.f6235b = abstractLocationActivity;
        this.f6234a = locationSearchCriteria;
    }

    public void run() {
        this.f6235b.mo9823a(this.f6234a);
    }
}
