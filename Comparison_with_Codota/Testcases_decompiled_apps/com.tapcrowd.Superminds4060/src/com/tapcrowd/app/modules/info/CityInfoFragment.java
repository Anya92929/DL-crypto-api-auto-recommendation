package com.tapcrowd.app.modules.info;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gcm.GCMConstants;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.TCFragment;
import com.tapcrowd.app.utils.Actions;
import com.tapcrowd.app.utils.C1199DB;
import com.tapcrowd.app.utils.C1216LO;
import com.tapcrowd.app.utils.C1232UI;
import com.tapcrowd.app.utils.TCObject;
import com.tapcrowd.tcanalytics.TCAnalytics;

public class CityInfoFragment extends TCFragment {

    /* renamed from: o */
    TCObject f2049o;

    public static CityInfoFragment newInstance() {
        return new CityInfoFragment();
    }

    public void onResume() {
        super.onResume();
        if (this.f2049o.has("loggingpath")) {
            TCAnalytics.log(getActivity(), this.f2049o.get("loggingpath"), "");
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(C0846R.layout.infoapp, container, false);
        this.f2049o = C1199DB.getFirstObject(GCMConstants.EXTRA_APPLICATION_PENDING_INTENT);
        C1232UI.addCell(v, this.f2049o.get("address"), (View.OnClickListener) new View.OnClickListener() {
            public void onClick(View v) {
                Actions.doNavigate(CityInfoFragment.this.f2049o.get("address"));
            }
        }, C1232UI.getColorOverlay((int) C0846R.drawable.icon_navigate_white, C1216LO.getLo(C1216LO.actionImageOverlayColor))).showSeparator();
        if (this.f2049o.has("info")) {
            C1232UI.addCell(v, this.f2049o.get("info"), (View.OnClickListener) null, C1232UI.getColorOverlay((int) C0846R.drawable.icon_attachment, C1216LO.getLo(C1216LO.actionImageOverlayColor))).showSeparator();
        }
        C1232UI.addCell(v, this.f2049o.get("telephone"), (View.OnClickListener) new View.OnClickListener() {
            public void onClick(View v) {
                Actions.doCall(CityInfoFragment.this.f2049o.get("telephone"));
            }
        }, C1232UI.getColorOverlay((int) C0846R.drawable.icon_tel, C1216LO.getLo(C1216LO.actionImageOverlayColor))).showSeparator();
        C1232UI.addCell(v, this.f2049o.get("website"), (View.OnClickListener) new View.OnClickListener() {
            public void onClick(View v) {
                Actions.openWebview(CityInfoFragment.this, CityInfoFragment.this.f2049o.get("website"));
            }
        }, C1232UI.getColorOverlay((int) C0846R.drawable.icon_website, C1216LO.getLo(C1216LO.actionImageOverlayColor))).showSeparator();
        C1232UI.addCell(v, this.f2049o.get("email"), (View.OnClickListener) new View.OnClickListener() {
            public void onClick(View v) {
                Actions.doMail(CityInfoFragment.this.f2049o.get("email"));
            }
        }, C1232UI.getColorOverlay((int) C0846R.drawable.icon_email, C1216LO.getLo(C1216LO.actionImageOverlayColor))).showSeparator();
        return v;
    }
}
