package com.tapcrowd.app.modules.business;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.TCFragment;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import com.tapcrowd.app.utils.Actions;
import com.tapcrowd.app.utils.AdHelper;
import com.tapcrowd.app.utils.C1199DB;
import com.tapcrowd.app.utils.C1216LO;
import com.tapcrowd.app.utils.C1232UI;
import com.tapcrowd.app.utils.TCObject;
import com.tapcrowd.tcanalytics.TCAnalytics;

public class ContactFragment extends TCFragment {

    /* renamed from: id */
    String f2023id;

    public static ContactFragment newInstance(String id) {
        ContactFragment contact = new ContactFragment();
        contact.f2023id = id;
        return contact;
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(DBFavorites.KEY_EVENT_ID, this.f2023id);
    }

    public void onResume() {
        super.onResume();
        TCObject tco = C1199DB.getObject("venues", DBFavorites.KEY_EVENT_ID, this.f2023id);
        if (tco.has("loggingpath")) {
            TCAnalytics.log(getActivity(), tco.get("loggingpath"), "");
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(C0846R.layout.bus_contact, container, false);
        AdHelper.showAds(this, AdHelper.buildPath("21", "detail", this.f2023id));
        if (savedInstanceState != null && this.f2023id == null) {
            this.f2023id = savedInstanceState.getString(DBFavorites.KEY_EVENT_ID);
        }
        final TCObject o = C1199DB.getObject("venues", DBFavorites.KEY_EVENT_ID, this.f2023id);
        C1232UI.setTitle("img");
        String title = o.get(DBFavorites.KEY_NAME, "");
        C1232UI.setText((int) C0846R.C0847id.name, String.valueOf(title.substring(0, 1).toUpperCase()) + title.substring(1).toLowerCase(), v);
        TextView n = (TextView) v.findViewById(C0846R.C0847id.name);
        n.setBackgroundColor(C1216LO.getLo(C1216LO.titleBackgroundColor) - 301989888);
        n.setTextColor(C1216LO.getLo(C1216LO.titleFontColor));
        if (o.has("address")) {
            C1232UI.addCell(v, o.get("address"), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View v) {
                    Actions.doNavigate(o.get("address"));
                }
            }, C1232UI.getColorOverlay((int) C0846R.drawable.icon_navigate_white, C1216LO.getLo(C1216LO.actionImageOverlayColor)));
        }
        if (o.has("telephone")) {
            C1232UI.addCell(v, o.get("telephone"), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View v) {
                    Actions.doCall(o.get("telephone"));
                }
            }, C1232UI.getColorOverlay((int) C0846R.drawable.icon_phone_black, C1216LO.getLo(C1216LO.actionImageOverlayColor)));
        }
        if (o.has("fax")) {
            C1232UI.addCell(v, o.get("fax"), (View.OnClickListener) null, C1232UI.getColorOverlay((int) C0846R.drawable.icon_fax, C1216LO.getLo(C1216LO.actionImageOverlayColor)));
        }
        if (o.has("email")) {
            C1232UI.addCell(v, o.get("email"), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View v) {
                    Actions.doMail(o.get("email"));
                }
            }, C1232UI.getColorOverlay((int) C0846R.drawable.icon_email, C1216LO.getLo(C1216LO.actionImageOverlayColor)));
        }
        if (o.has("website")) {
            C1232UI.addCell(v, getResourceString(C0846R.string.showwebsite), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View v) {
                    Actions.openWebview(ContactFragment.this, o.get("website"));
                }
            }, C1232UI.getColorOverlay((int) C0846R.drawable.icon_website, C1216LO.getLo(C1216LO.actionImageOverlayColor)));
        }
        return v;
    }
}
