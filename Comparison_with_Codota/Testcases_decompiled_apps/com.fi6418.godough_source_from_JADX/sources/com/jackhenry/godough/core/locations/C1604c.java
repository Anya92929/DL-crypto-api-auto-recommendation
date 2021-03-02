package com.jackhenry.godough.core.locations;

import android.content.Intent;
import android.support.p000v4.app.Fragment;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.C1593j;
import com.jackhenry.godough.core.C1942x;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.core.model.GoDoughLocation;
import com.jackhenry.godough.core.model.LocationSearchCriteria;
import com.jackhenry.godough.core.p038e.C1576e;
import com.jackhenry.godough.core.p038e.C1577f;
import com.jackhenry.godough.p027b.C1389d;
import java.util.List;

/* renamed from: com.jackhenry.godough.core.locations.c */
class C1604c extends C1942x<LocationSearchCriteria> {

    /* renamed from: a */
    final /* synthetic */ AbstractLocationActivity f6236a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1604c(AbstractLocationActivity abstractLocationActivity, Fragment fragment, C1593j jVar) {
        super(fragment, jVar);
        this.f6236a = abstractLocationActivity;
    }

    /* renamed from: a */
    public void mo9588a(LocationSearchCriteria locationSearchCriteria) {
        this.f6236a.dismissLoadingDialog();
        Intent intent = new Intent(GoDoughApp.getApp(), LocationResultsFragmentActivity.class);
        intent.putExtra(AbstractLocationActivity.PARAM_LOGGED_IN, this.f6236a.f6171m);
        intent.putExtra(LocationSearchCriteria.KEY_LOCATION_SEARCH_CRITERIA, locationSearchCriteria);
        List<GoDoughLocation> locations = GoDoughApp.getLocations();
        if (locations != null && !locations.isEmpty()) {
            double milesToLocation = locations.get(0).getMilesToLocation();
            if (milesToLocation >= 0.0d && milesToLocation <= 10.0d) {
                intent.putExtra(LocationResultsFragmentActivity.PARAM_MAP_MODE, true);
            }
        }
        this.f6236a.startActivity(intent);
        C1602af unused = this.f6236a.f6173o = null;
    }

    /* renamed from: a */
    public void mo9587a(Integer num) {
    }

    /* renamed from: a */
    public boolean mo9589a(C1389d dVar) {
        this.f6236a.dismissLoadingDialog();
        if (!super.mo9589a(dVar)) {
            this.f6236a.showDialog(new C1576e(C1577f.ERROR, AbstractLocationActivity.DIALOG_LOCATION_SEARCH_FAILED, this.f6236a.getString(C1506am.title_location_no_search_results), dVar.getMessage()));
        }
        C1602af unused = this.f6236a.f6173o = null;
        return true;
    }
}
