package com.jackhenry.godough.core.rda;

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

public class RDAFragment extends C1884s {

    /* renamed from: aj */
    private C1350b<ImageTextArrowRow> f6642aj;

    /* renamed from: ak */
    private C1916u f6643ak;

    /* renamed from: i */
    View f6644i;

    /* renamed from: l */
    public void mo11010l() {
        this.f6644i.setVisibility(0);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ImageTextArrowRow(C1806ab.DEPOSIT.ordinal(), GoDoughApp.getApp().getString(C1506am.menu_deposit_check), C1493ah.ic_deposit_check));
        arrayList.add(new ImageTextArrowRow(C1806ab.REVIEW.ordinal(), GoDoughApp.getApp().getString(C1506am.menu_review_deposits), C1493ah.ic_deposits_review));
        this.f6642aj = new C1350b<>(getActivity(), new C1944z());
        this.f6642aj.mo9265a(arrayList);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f6644i = layoutInflater.inflate(C1496ak.rda_list_fragment, viewGroup);
        setListAdapter(this.f6642aj);
        this.f6644i.setVisibility(4);
        return this.f6644i;
    }

    public void onListItemClick(ListView listView, View view, int i, long j) {
        C1806ab abVar = C1806ab.values()[((ImageTextArrowRow) this.f6642aj.getItem(i)).getId()];
        if (abVar.ordinal() == C1806ab.DEPOSIT.ordinal()) {
            this.f6643ak = new C1916u(new C1410ab(this));
            if (!this.f6643ak.mo11157a((String) null, "android.permission.CAMERA", (int) ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION)) {
                return;
            }
        }
        ((C1807ac) getActivity()).onFragementNavigate(abVar);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        switch (i) {
            case ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION:
                if (strArr[0].equals("android.permission.CAMERA")) {
                    if (this.f6643ak.mo11156a(iArr[0], getString(C1506am.camera_permission_needed, getString(C1506am.menu_deposit_check)), false)) {
                        ((C1807ac) getActivity()).onFragementNavigate(C1806ab.DEPOSIT);
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }
}
