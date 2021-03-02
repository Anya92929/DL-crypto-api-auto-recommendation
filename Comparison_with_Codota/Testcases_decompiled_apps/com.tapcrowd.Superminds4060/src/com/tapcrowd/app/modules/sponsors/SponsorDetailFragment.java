package com.tapcrowd.app.modules.sponsors;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.p000v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.actionbarsherlock.view.MenuItem;
import com.google.android.gms.plus.PlusShare;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.TCFragment;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import com.tapcrowd.app.modules.menuitems.MenuFragment;
import com.tapcrowd.app.modules.notes.AddNoteFragment;
import com.tapcrowd.app.modules.notes.NotesFragment;
import com.tapcrowd.app.modules.webview.WebViewFragment;
import com.tapcrowd.app.utils.AdHelper;
import com.tapcrowd.app.utils.C1199DB;
import com.tapcrowd.app.utils.C1216LO;
import com.tapcrowd.app.utils.C1232UI;
import com.tapcrowd.app.utils.DetailImageViewpagerAdapter;
import com.tapcrowd.app.utils.Fragments;
import com.tapcrowd.app.utils.TCObject;
import com.tapcrowd.tcanalytics.TCAnalytics;
import java.util.ArrayList;
import java.util.List;

public class SponsorDetailFragment extends TCFragment implements MenuFragment.MenuItemListener {
    private final int NOTES = 5346;
    private final int SHARE = 56;
    /* access modifiers changed from: private */

    /* renamed from: id */
    public String f2120id;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public TCObject f2121o;

    public static SponsorDetailFragment newInstance(String id) {
        SponsorDetailFragment detail = new SponsorDetailFragment();
        detail.f2120id = id;
        return detail;
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(DBFavorites.KEY_EVENT_ID, this.f2120id);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(C0846R.layout.sponsordetail, container, false);
        if (savedInstanceState != null && this.f2120id == null) {
            this.f2120id = savedInstanceState.getString(DBFavorites.KEY_EVENT_ID);
        }
        return v;
    }

    public void onResume() {
        super.onResume();
        if (this.f2121o.has("loggingpath")) {
            TCAnalytics.log(getActivity(), this.f2121o.get("loggingpath"), "");
        }
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.f2121o = C1199DB.getObject("sponsors", DBFavorites.KEY_EVENT_ID, this.f2120id);
        AdHelper.showAds(this, AdHelper.buildPath("19", "detail", this.f2120id));
        C1232UI.setText((int) C0846R.C0847id.name, this.f2121o.get(DBFavorites.KEY_NAME), getView());
        getView().findViewById(C0846R.C0847id.name).setBackgroundColor(C1216LO.getLo(C1216LO.titleBackgroundColor));
        ((TextView) getView().findViewById(C0846R.C0847id.name)).setTextColor(C1216LO.getLo(C1216LO.titleFontColor));
        C1232UI.hide(C0846R.C0847id.sub1, getView());
        C1232UI.hide(C0846R.C0847id.sub2, getView());
        C1232UI.hide(C0846R.C0847id.sub3, getView());
        C1232UI.setText((int) C0846R.C0847id.info, this.f2121o.get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION), getView());
        if (!this.f2121o.has(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION)) {
            C1232UI.hide(C0846R.C0847id.info, getView());
        }
        if (this.f2121o.has("website")) {
            getView().findViewById(C0846R.C0847id.sep).setBackgroundColor(C1216LO.getLo(C1216LO.seperatorBackgroundColor));
            C1232UI.addCell(getView(), getResourceString(C0846R.string.showwebsite), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View v) {
                    Fragments.add(SponsorDetailFragment.this, WebViewFragment.newInstance(SponsorDetailFragment.this.f2121o.get("website"), false), (String) null);
                }
            }, C1232UI.getColorOverlay((int) C0846R.drawable.icon_website, C1216LO.getLo(C1216LO.actionImageOverlayColor))).setBackgroundDrawable(C1232UI.getBackground());
        }
        C1232UI.hide(C0846R.C0847id.icon, getView());
        List<String> images = new ArrayList<>();
        if (this.f2121o.has("image")) {
            images.add(this.f2121o.get("image"));
        }
        for (TCObject meta : C1199DB.getQueryFromDb("SELECT value FROM metavalues WHERE type == 'image' AND  parentType == 'sponsor' AND parentId == '" + this.f2120id + "'")) {
            images.add(meta.get("value"));
        }
        ViewPager vp = (ViewPager) getView().findViewById(C0846R.C0847id.viewerpager);
        vp.setAdapter(new DetailImageViewpagerAdapter((Context) getActivity(), images, (LinearLayout) getView().findViewById(C0846R.C0847id.pager), ImageView.ScaleType.FIT_CENTER));
        if (images.size() == 0) {
            vp.setVisibility(8);
        }
        if (C1199DB.getSize("launchers", "moduletypeid", "35") > 0) {
            C1232UI.addCell(getView(), C1199DB.getFirstObject("launchers", "moduletypeid", "35").get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View v) {
                    Fragments.add(SponsorDetailFragment.this, NotesFragment.newInstance("sponsors", SponsorDetailFragment.this.f2120id), SponsorDetailFragment.this.f2121o.get(DBFavorites.KEY_NAME));
                }
            }, C1232UI.getColorOverlay((int) C0846R.drawable.icon_notes, C1216LO.getLo(C1216LO.actionImageOverlayColor))).setBackgroundDrawable(C1232UI.getBackground());
        }
        C1232UI.AddMetaData(this, "sponsor", this.f2120id, getView());
        ArrayList<MenuFragment.MenuItemContainer> menuitems = new ArrayList<>();
        if (C1199DB.getSize("launchers", "moduletypeid", "35") > 0) {
            menuitems.add(new MenuFragment.MenuItemContainer(C1232UI.getColorOverlay((int) C0846R.drawable.icon_notes_nav, C1216LO.getLo(C1216LO.navigationColor)), 5346));
        }
        if (C1199DB.getSize("socialshare", "launcherid", C1199DB.getFirstObject("launchers", "moduletypeid", "19").get(DBFavorites.KEY_EVENT_ID)) > 0) {
            menuitems.add(new MenuFragment.MenuItemContainer(C1232UI.getColorOverlay((int) C0846R.drawable.icon_share, C1216LO.getLo(C1216LO.navigationColor)), 56));
        }
        Fragments.addMenu(this, MenuFragment.newInstance(menuitems, this));
    }

    public void click(MenuItem item) {
        switch (item.getItemId()) {
            case 56:
                share();
                return;
            case 5346:
                Fragments.add(this, AddNoteFragment.newInstance("sponsors", this.f2120id), "");
                return;
            default:
                return;
        }
    }

    public void share() {
        Intent textIntent = new Intent("android.intent.action.SEND");
        Intent mailIntent = new Intent("android.intent.action.SEND");
        Intent imageIntent = new Intent("android.intent.action.SEND");
        textIntent.setType("text/plain");
        mailIntent.setType("message/rfc822");
        imageIntent.setType("image/*");
        textIntent.putExtra("android.intent.extra.SUBJECT", this.f2121o.get(DBFavorites.KEY_NAME));
        textIntent.putExtra("android.intent.extra.TEXT", this.f2121o.get(DBFavorites.KEY_NAME));
        mailIntent.putExtra("android.intent.extra.SUBJECT", this.f2121o.get(DBFavorites.KEY_NAME));
        mailIntent.putExtra("android.intent.extra.TEXT", this.f2121o.get(DBFavorites.KEY_NAME));
        imageIntent.putExtra("android.intent.extra.SUBJECT", this.f2121o.get(DBFavorites.KEY_NAME));
        imageIntent.putExtra("android.intent.extra.TEXT", this.f2121o.get(DBFavorites.KEY_NAME));
        Intent chooser = Intent.createChooser(imageIntent, "Share");
        chooser.putExtra("android.intent.extra.INITIAL_INTENTS", new Intent[]{mailIntent, textIntent});
        startActivity(chooser);
    }
}
