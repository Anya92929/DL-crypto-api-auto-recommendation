package com.jackhenry.godough.core.locations;

import android.os.Bundle;
import android.support.p003v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.jackhenry.android.p022a.p023a.C1350b;
import com.jackhenry.godough.core.C1410ab;
import com.jackhenry.godough.core.C1493ah;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.C1884s;
import com.jackhenry.godough.core.C1916u;
import com.jackhenry.godough.core.C1944z;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.core.model.ImageTextArrowRow;
import java.util.ArrayList;

public class LocationsFragment extends C1884s {

    /* renamed from: aj */
    private C1350b<ImageTextArrowRow> f6221aj;

    /* renamed from: i */
    private C1916u f6222i;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ImageTextArrowRow(C1623v.NEAR_ME.ordinal(), GoDoughApp.getApp().getString(C1506am.lbl_find_near_me), C1493ah.ic_loc_near_me));
        arrayList.add(new ImageTextArrowRow(C1623v.ZIP_SEARCH.ordinal(), GoDoughApp.getApp().getString(C1506am.lbl_search_by_zip), C1493ah.ic_loc_zip_code));
        arrayList.add(new ImageTextArrowRow(C1623v.CITY_SEARCH.ordinal(), GoDoughApp.getApp().getString(C1506am.lbl_search_by_city), C1493ah.ic_loc_city_state));
        arrayList.add(new ImageTextArrowRow(C1623v.SHOW_ALL.ordinal(), GoDoughApp.getApp().getString(C1506am.lbl_show_all_locations), C1493ah.ic_loc_show_all));
        this.f6221aj = new C1350b<>(getActivity(), new C1944z());
        this.f6221aj.mo9265a(arrayList);
        this.f6222i = new C1916u(new C1410ab(this));
        if (this.f6222i.mo11157a(getString(C1506am.location_write_explanation, GoDoughApp.getSettings().getLocationsMenuName()), "android.permission.WRITE_EXTERNAL_STORAGE", (int) ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION)) {
            ((LocationsFragmentActivity) getActivity()).loadData();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C1496ak.locations_fragment, viewGroup);
        setListAdapter(this.f6221aj);
        return inflate;
    }

    public void onListItemClick(ListView listView, View view, int i, long j) {
        C1623v vVar = C1623v.values()[((ImageTextArrowRow) this.f6221aj.getItem(i)).getId()];
        if (vVar == C1623v.NEAR_ME) {
            if (!this.f6222i.mo11158a((String) null, new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"}, (int) ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION)) {
                return;
            }
        }
        ((C1624w) getActivity()).onFragementNavigate(vVar);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        switch (i) {
            case ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION:
                int i2 = 0;
                for (int i3 = 0; i3 < iArr.length; i3++) {
                    if (iArr[i3] != 0) {
                        i2 = iArr[i3];
                    }
                }
                if (this.f6222i.mo11156a(i2, getString(C1506am.location_permission_needed, GoDoughApp.getSettings().getLocationsMenuName()), false)) {
                    ((C1624w) getActivity()).onFragementNavigate(C1623v.NEAR_ME);
                    return;
                }
                return;
            case ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION:
                this.f6222i.mo11156a(iArr[0], getString(C1506am.write_external_permission_needed, GoDoughApp.getSettings().getLocationsMenuName()), true);
                return;
            default:
                return;
        }
    }
}
