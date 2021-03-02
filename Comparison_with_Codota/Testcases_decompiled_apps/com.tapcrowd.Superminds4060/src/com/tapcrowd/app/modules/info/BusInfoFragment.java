package com.tapcrowd.app.modules.info;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.TCFragment;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import com.tapcrowd.app.utils.Actions;
import com.tapcrowd.app.utils.AdHelper;
import com.tapcrowd.app.utils.C1199DB;
import com.tapcrowd.app.utils.C1216LO;
import com.tapcrowd.app.utils.C1232UI;
import com.tapcrowd.app.utils.TCObject;
import com.tapcrowd.app.utils.images.FastImageLoader;
import com.tapcrowd.tcanalytics.TCAnalytics;

public class BusInfoFragment extends TCFragment {

    /* renamed from: id */
    String f2048id;

    public static BusInfoFragment newInstance(String id) {
        BusInfoFragment detail = new BusInfoFragment();
        detail.f2048id = id;
        return detail;
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(DBFavorites.KEY_EVENT_ID, this.f2048id);
    }

    public void onResume() {
        super.onResume();
        TCObject venue = C1199DB.getFirstObject("venues", DBFavorites.KEY_EVENT_ID, this.f2048id);
        if (venue.has("loggingpath")) {
            TCAnalytics.log(getActivity(), venue.get("loggingpath"), "");
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(C0846R.layout.bus_info, container, false);
        AdHelper.showAds(this, AdHelper.buildPath("21", "detail", this.f2048id));
        if (savedInstanceState != null && this.f2048id == null) {
            this.f2048id = savedInstanceState.getString(DBFavorites.KEY_EVENT_ID);
        }
        final TCObject o = C1199DB.getObject("venues", DBFavorites.KEY_EVENT_ID, this.f2048id);
        C1232UI.setTitle("img");
        if (o.has("image1")) {
            new FastImageLoader().DisplayImage(o.get("image1"), (ImageView) v.findViewById(C0846R.C0847id.icon));
        } else {
            v.findViewById(C0846R.C0847id.icon).setVisibility(8);
        }
        C1232UI.setText((int) C0846R.C0847id.text, o.get("info"), v);
        if (o.has("website")) {
            View.OnClickListener click = new View.OnClickListener() {
                public void onClick(View v) {
                    Actions.openWebview(BusInfoFragment.this, o.get("website"));
                }
            };
            C1232UI.getColorOverlay((int) C0846R.drawable.icon_website, C1216LO.getLo(C1216LO.actionImageOverlayColor));
            C1232UI.addCell(v, getString(C0846R.string.website), click, (int) C0846R.drawable.icon_website).setBackgroundDrawable(C1232UI.getBackground());
        }
        if (o.has("email")) {
            C1232UI.addCell(v, o.get("email"), new View.OnClickListener() {
                public void onClick(View v) {
                    Actions.doMail(o.get("email"));
                }
            }, C1232UI.getColorOverlay((int) C0846R.drawable.icon_email, C1216LO.getLo(C1216LO.actionImageOverlayColor))).setBackgroundDrawable(C1232UI.getBackground());
        }
        C1232UI.AddMetaData(this, "venue", this.f2048id, v);
        return v;
    }
}
