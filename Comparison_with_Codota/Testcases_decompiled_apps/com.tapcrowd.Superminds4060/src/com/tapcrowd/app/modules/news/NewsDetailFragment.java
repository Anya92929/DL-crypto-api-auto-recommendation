package com.tapcrowd.app.modules.news;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.p000v4.view.ViewPager;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.actionbarsherlock.view.MenuItem;
import com.google.android.gcm.GCMConstants;
import com.google.android.gms.plus.PlusShare;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.TCFragment;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import com.tapcrowd.app.modules.menuitems.MenuFragment;
import com.tapcrowd.app.utils.Actions;
import com.tapcrowd.app.utils.AdHelper;
import com.tapcrowd.app.utils.App;
import com.tapcrowd.app.utils.C1199DB;
import com.tapcrowd.app.utils.C1216LO;
import com.tapcrowd.app.utils.C1232UI;
import com.tapcrowd.app.utils.DetailImageViewpagerAdapter;
import com.tapcrowd.app.utils.Fragments;
import com.tapcrowd.app.utils.TCObject;
import com.tapcrowd.app.utils.images.FastImageLoader;
import com.tapcrowd.tcanalytics.TCAnalytics;
import java.util.ArrayList;
import java.util.List;

public class NewsDetailFragment extends TCFragment implements MenuFragment.MenuItemListener {
    private final int SHARE = 434;
    TCObject tco;

    public static NewsDetailFragment newInstance(String id) {
        NewsDetailFragment detail = new NewsDetailFragment();
        detail.tco = C1199DB.getObject("news", DBFavorites.KEY_EVENT_ID, id);
        return detail;
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(DBFavorites.KEY_EVENT_ID, this.tco.get(DBFavorites.KEY_EVENT_ID));
    }

    public void onResume() {
        super.onResume();
        if (this.tco.has("loggingpath")) {
            TCAnalytics.log(getActivity(), this.tco.get("loggingpath"), "");
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(C0846R.layout.bus_newsdetail, container, false);
        if (savedInstanceState != null && this.tco == null) {
            this.tco = C1199DB.getObject("news", DBFavorites.KEY_EVENT_ID, savedInstanceState.getString(DBFavorites.KEY_EVENT_ID));
        }
        AdHelper.showAds(this, AdHelper.buildPath("1", "detail", this.tco.get(DBFavorites.KEY_EVENT_ID)));
        setupMenu();
        C1232UI.setText((int) C0846R.C0847id.name, this.tco.get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, "").toString(), v);
        if (this.tco.has("image")) {
            new FastImageLoader().DisplayImage(this.tco.get("image"), (ImageView) v.findViewById(C0846R.C0847id.icon));
        } else {
            C1232UI.hide(C0846R.C0847id.icon, v);
        }
        List<String> images = new ArrayList<>();
        if (this.tco.has("image")) {
            images.add(this.tco.get("image"));
        }
        for (TCObject meta : C1199DB.getQueryFromDb("SELECT value FROM metavalues WHERE type == 'image' AND  parentType == 'newsitem' AND parentId == '" + this.tco.get(DBFavorites.KEY_EVENT_ID) + "'")) {
            images.add(meta.get("value"));
        }
        ViewPager vp = (ViewPager) v.findViewById(C0846R.C0847id.viewerpager);
        vp.setAdapter(new DetailImageViewpagerAdapter((Context) getActivity(), images, (LinearLayout) v.findViewById(C0846R.C0847id.pager), ImageView.ScaleType.FIT_CENTER));
        if (images.size() == 0) {
            vp.setVisibility(8);
        }
        ((TextView) v.findViewById(C0846R.C0847id.text)).setText(this.tco.get("txt", ""));
        ((TextView) v.findViewById(C0846R.C0847id.text)).setTextColor(C1216LO.getLo(C1216LO.textcolor));
        TextView n = (TextView) v.findViewById(C0846R.C0847id.name);
        n.setBackgroundColor(C1216LO.getLo(C1216LO.titleBackgroundColor));
        n.setTextColor(C1216LO.getLo(C1216LO.titleFontColor));
        if (this.tco.has(PlusShare.KEY_CALL_TO_ACTION_URL)) {
            TextView tv = (TextView) v.findViewById(C0846R.C0847id.action);
            tv.setVisibility(0);
            tv.setBackgroundColor(C1216LO.getLo(C1216LO.seperatorBackgroundColor));
            tv.setTextColor(C1216LO.getLo(C1216LO.separatorTextColor));
            tv.setText(getResourceString(C0846R.string.readmore).toString().toUpperCase());
            tv.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Actions.openWebview(NewsDetailFragment.this, NewsDetailFragment.this.tco.get(PlusShare.KEY_CALL_TO_ACTION_URL));
                }
            });
        }
        C1232UI.AddMetaData(this, "newsitem", this.tco.get(DBFavorites.KEY_EVENT_ID), v);
        return v;
    }

    public void setupMenu() {
        ArrayList<MenuFragment.MenuItemContainer> menuitems = new ArrayList<>();
        if (C1199DB.getSize("socialshare", "launcherid", C1199DB.getFirstObject("launchers", "moduletypeid", "1").get(DBFavorites.KEY_EVENT_ID)) > 0) {
            menuitems.add(new MenuFragment.MenuItemContainer(C1232UI.getColorOverlay((int) C0846R.drawable.icon_share, C1216LO.getLo(C1216LO.navigationColor)), 434));
        }
        Fragments.addMenu(this, MenuFragment.newInstance(menuitems, this));
    }

    public void click(MenuItem item) {
        switch (item.getItemId()) {
            case 434:
                share();
                return;
            default:
                return;
        }
    }

    public void share() {
        String link = Html.fromHtml(String.valueOf(this.tco.get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE)) + "<br />" + "http://" + C1199DB.getFirstObject(GCMConstants.EXTRA_APPLICATION_PENDING_INTENT, DBFavorites.KEY_EVENT_ID, App.f2123id).get("subdomain", "") + ".m.tap.cr ").toString();
        Intent shareIntent = new Intent("android.intent.action.SEND");
        shareIntent.setType("text/plain");
        shareIntent.putExtra("android.intent.extra.SUBJECT", getResourceString(C0846R.string.app_name));
        shareIntent.putExtra("android.intent.extra.TEXT", link);
        startActivity(Intent.createChooser(shareIntent, "Share"));
    }
}
