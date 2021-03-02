package com.tapcrowd.app.modules.info;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
import com.tapcrowd.app.utils.images.FastImageLoader;
import com.tapcrowd.tcanalytics.TCAnalytics;

public class ShopRestoInfoFragment extends TCFragment {

    /* renamed from: id */
    String f2052id;

    /* renamed from: o */
    TCObject f2053o;

    public static ShopRestoInfoFragment newInstance(String id) {
        ShopRestoInfoFragment detail = new ShopRestoInfoFragment();
        detail.f2052id = id;
        return detail;
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(DBFavorites.KEY_EVENT_ID, this.f2052id);
    }

    public void onResume() {
        super.onResume();
        if (this.f2053o.has("loggingpath")) {
            TCAnalytics.log(getActivity(), this.f2053o.get("loggingpath"), "");
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.f2005v = inflater.inflate(C0846R.layout.infovenue, container, false);
        AdHelper.showAds(this, AdHelper.buildPath("21", "detail", this.f2052id));
        if (savedInstanceState != null && this.f2052id == null) {
            this.f2052id = savedInstanceState.getString(DBFavorites.KEY_EVENT_ID);
        }
        this.f2053o = C1199DB.getObject("venues", DBFavorites.KEY_EVENT_ID, this.f2052id);
        C1232UI.setText((int) C0846R.C0847id.naamEvent, this.f2053o.get(DBFavorites.KEY_NAME), this.f2005v);
        C1232UI.setText((int) C0846R.C0847id.descriptiontop, this.f2053o.get("info"), this.f2005v);
        C1232UI.show(C0846R.C0847id.descriptiontop, this.f2005v);
        C1232UI.hide(C0846R.C0847id.description, this.f2005v);
        C1232UI.hide(C0846R.C0847id.address, this.f2005v);
        C1232UI.hide(C0846R.C0847id.map, this.f2005v);
        ((TextView) this.f2005v.findViewById(C0846R.C0847id.naamEvent)).setTextSize(1, 22.0f);
        C1232UI.hide(C0846R.C0847id.icon, this.f2005v);
        if (this.f2053o.has("image1")) {
            C1232UI.show(C0846R.C0847id.subicon, this.f2005v);
            this.f2005v.findViewById(C0846R.C0847id.subicon).post(new Runnable() {
                public void run() {
                    FastImageLoader fil = new FastImageLoader();
                    ImageView icon = (ImageView) ShopRestoInfoFragment.this.f2005v.findViewById(C0846R.C0847id.subicon);
                    fil.DisplayImage(ShopRestoInfoFragment.this.f2053o.get("image1"), icon, icon.getHeight(), icon.getWidth());
                }
            });
        } else {
            C1232UI.hide(C0846R.C0847id.subicon, this.f2005v);
        }
        this.f2005v.findViewById(C0846R.C0847id.header).setBackgroundColor(C1216LO.getLo(C1216LO.titleBackgroundColor));
        ((TextView) this.f2005v.findViewById(C0846R.C0847id.naamEvent)).setTextColor(C1216LO.getLo(C1216LO.titleFontColor));
        ((TextView) this.f2005v.findViewById(C0846R.C0847id.address)).setTextColor(C1216LO.getLo(C1216LO.titleFontColor));
        C1232UI.addCell(this.f2005v, getResourceString(C0846R.string.website), (View.OnClickListener) new View.OnClickListener() {
            public void onClick(View v) {
                Actions.openWebview(ShopRestoInfoFragment.this, ShopRestoInfoFragment.this.f2053o.get("website"));
            }
        }, C1232UI.getColorOverlay((int) C0846R.drawable.icon_website_black, C1216LO.getLo(C1216LO.actionImageOverlayColor))).setBackgroundDrawable(C1232UI.getBackground());
        C1232UI.addCell(this.f2005v, this.f2053o.get("telephone"), (View.OnClickListener) new View.OnClickListener() {
            public void onClick(View v) {
                Actions.doCall(ShopRestoInfoFragment.this.f2053o.get("telephone"));
            }
        }, C1232UI.getColorOverlay((int) C0846R.drawable.icon_tel, C1216LO.getLo(C1216LO.actionImageOverlayColor))).setBackgroundDrawable(C1232UI.getBackground());
        C1232UI.addCell(this.f2005v, this.f2053o.get("email"), (View.OnClickListener) new View.OnClickListener() {
            public void onClick(View v) {
                Actions.doMail(ShopRestoInfoFragment.this.f2053o.get("email"));
            }
        }, C1232UI.getColorOverlay((int) C0846R.drawable.icon_email_black, C1216LO.getLo(C1216LO.actionImageOverlayColor))).setBackgroundDrawable(C1232UI.getBackground());
        C1232UI.addCell(this.f2005v, this.f2053o.get("address"), (View.OnClickListener) new View.OnClickListener() {
            public void onClick(View v) {
                Actions.doNavigate(ShopRestoInfoFragment.this.f2053o.get("address"));
            }
        }, C1232UI.getColorOverlay((int) C0846R.drawable.icon_navigate_white, C1216LO.getLo(C1216LO.actionImageOverlayColor))).setBackgroundDrawable(C1232UI.getBackground());
        C1232UI.addCell(this.f2005v, this.f2053o.get("fax"), (View.OnClickListener) null, C1232UI.getColorOverlay((int) C0846R.drawable.icon_fax, C1216LO.getLo(C1216LO.actionImageOverlayColor))).setBackgroundDrawable(C1232UI.getBackground());
        if (this.f2053o.has("facebookurl")) {
            C1232UI.addCell(this.f2005v, "Facebook", (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View v) {
                }
            }, C1232UI.getColorOverlay((int) C0846R.drawable.sesfb, C1216LO.getLo(C1216LO.actionImageOverlayColor))).setBackgroundDrawable(C1232UI.getBackground());
        }
        if (this.f2053o.has("twitterurl")) {
            C1232UI.addCell(this.f2005v, getResourceString(C0846R.string.showmorepics), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View v) {
                }
            }, C1232UI.getColorOverlay((int) C0846R.drawable.sestwit, C1216LO.getLo(C1216LO.actionImageOverlayColor))).setBackgroundDrawable(C1232UI.getBackground());
        }
        C1232UI.AddMetaData(this, "venue", this.f2053o.get(DBFavorites.KEY_EVENT_ID), this.f2005v);
        return this.f2005v;
    }
}
