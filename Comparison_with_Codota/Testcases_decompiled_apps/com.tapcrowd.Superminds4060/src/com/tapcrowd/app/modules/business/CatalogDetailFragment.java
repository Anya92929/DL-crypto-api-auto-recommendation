package com.tapcrowd.app.modules.business;

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
import com.actionbarsherlock.view.MenuItem;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.android.gcm.GCMConstants;
import com.google.android.gms.plus.PlusShare;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.TCFragment;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import com.tapcrowd.app.modules.menuitems.MenuFragment;
import com.tapcrowd.app.modules.notes.AddNoteFragment;
import com.tapcrowd.app.modules.notes.NotesFragment;
import com.tapcrowd.app.utils.Actions;
import com.tapcrowd.app.utils.App;
import com.tapcrowd.app.utils.C1199DB;
import com.tapcrowd.app.utils.C1216LO;
import com.tapcrowd.app.utils.C1232UI;
import com.tapcrowd.app.utils.ConferenceBagUtil;
import com.tapcrowd.app.utils.DetailImageViewpagerAdapter;
import com.tapcrowd.app.utils.Fragments;
import com.tapcrowd.app.utils.LinkedObjects;
import com.tapcrowd.app.utils.PdfUtil;
import com.tapcrowd.app.utils.TCObject;
import com.tapcrowd.tcanalytics.TCAnalytics;
import java.util.ArrayList;
import java.util.List;

public class CatalogDetailFragment extends TCFragment implements MenuFragment.MenuItemListener {
    private final int NOTES = 5345;
    private final int SHARE = 6415;

    /* renamed from: id */
    String f2018id;
    String module;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public TCObject f2019o;
    String text;

    public static CatalogDetailFragment newInstance(String id, String module2) {
        CatalogDetailFragment detail = new CatalogDetailFragment();
        detail.f2018id = id;
        detail.module = module2;
        return detail;
    }

    public static CatalogDetailFragment newInstance(String id, int nullcolumnhack) {
        CatalogDetailFragment detail = new CatalogDetailFragment();
        detail.f2018id = id;
        return detail;
    }

    public static CatalogDetailFragment newInstance(String text2) {
        CatalogDetailFragment detail = new CatalogDetailFragment();
        detail.text = text2;
        return detail;
    }

    public void onResume() {
        if (this.f2019o != null && this.f2019o.has("loggingpath")) {
            TCAnalytics.log(getActivity(), this.f2019o.get("loggingpath"), "");
        }
        super.onResume();
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(DBFavorites.KEY_EVENT_ID, this.f2018id);
        outState.putString("text", this.text);
        outState.putString(DBFavorites.KEY_MODULE, this.module);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(C0846R.layout.bus_detail, container, false);
        if (savedInstanceState != null && this.f2018id == null) {
            this.f2018id = savedInstanceState.getString(DBFavorites.KEY_EVENT_ID);
            this.text = savedInstanceState.getString("text");
            this.module = savedInstanceState.getString(DBFavorites.KEY_MODULE);
        }
        if (this.f2018id != null) {
            this.f2019o = C1199DB.getObject(LinkedObjects.TABLE_CAT, DBFavorites.KEY_EVENT_ID, this.f2018id);
            ArrayList<MenuFragment.MenuItemContainer> menuitems = new ArrayList<>();
            if (C1199DB.getSize("launchers", "moduletypeid", "35") > 0) {
                menuitems.add(new MenuFragment.MenuItemContainer(C1232UI.getColorOverlay((int) C0846R.drawable.icon_notes_nav, C1216LO.getLo(C1216LO.navigationColor)), 5345));
            }
            menuitems.add(new MenuFragment.MenuItemContainer(C1232UI.getColorOverlay((int) C0846R.drawable.icon_share, C1216LO.getLo(C1216LO.navigationColor)), 6415));
            Fragments.addMenu(this, MenuFragment.newInstance(menuitems, this));
            C1232UI.setText((int) C0846R.C0847id.name, this.f2019o.get(DBFavorites.KEY_NAME, ""), v);
            C1232UI.setTextColor(C0846R.C0847id.name, C1216LO.getLo(C1216LO.titleFontColor), v);
            v.findViewById(C0846R.C0847id.name).setBackgroundColor(C1216LO.getLo(C1216LO.titleBackgroundColor));
            C1232UI.hide(C0846R.C0847id.icon, v);
            List<String> images = new ArrayList<>();
            if (this.f2019o.has("imageurl")) {
                images.add(this.f2019o.get("imageurl"));
            }
            for (TCObject meta : C1199DB.getQueryFromDb("SELECT value FROM metavalues WHERE type == 'image' AND  parentType == 'catalog' AND parentId == '" + this.f2019o.get(DBFavorites.KEY_EVENT_ID) + "'")) {
                images.add(meta.get("value"));
            }
            ViewPager vp = (ViewPager) v.findViewById(C0846R.C0847id.viewerpager);
            vp.setAdapter(new DetailImageViewpagerAdapter((Context) getActivity(), images, (LinearLayout) v.findViewById(C0846R.C0847id.pager), ImageView.ScaleType.FIT_CENTER));
            if (images.size() == 0) {
                vp.setVisibility(8);
            }
            if (this.f2019o.has(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION)) {
                C1232UI.addCell(v, this.f2019o.get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION), (View.OnClickListener) null, 0);
            }
            if (this.f2019o.has(PlusShare.KEY_CALL_TO_ACTION_URL)) {
                View.OnClickListener click = new View.OnClickListener() {
                    public void onClick(View v) {
                        Actions.openWebview(CatalogDetailFragment.this, CatalogDetailFragment.this.f2019o.get(PlusShare.KEY_CALL_TO_ACTION_URL));
                    }
                };
                C1232UI.getColorOverlay((int) C0846R.drawable.icon_website, C1216LO.getLo(C1216LO.actionImageOverlayColor));
                C1232UI.addCell(v, this.f2019o.get("urltitle", getString(C0846R.string.website)), click, (int) C0846R.drawable.icon_website).setBackgroundDrawable(C1232UI.getBackground());
            }
            if (this.f2019o.has("pdf")) {
                String text2 = this.f2019o.get("pdf");
                String text3 = text2.substring(text2.lastIndexOf(47) + 1);
                String text4 = text3.substring(0, text3.lastIndexOf(".")).replace("_", MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR).replace("-", MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                View.OnClickListener click2 = new View.OnClickListener() {
                    public void onClick(View v) {
                        new PdfUtil(CatalogDetailFragment.this.getActivity(), (PdfUtil.PdfLoadFinishedListener) null).showPdf(CatalogDetailFragment.this.f2019o.get("pdf"));
                    }
                };
                C1232UI.getColorOverlay((int) C0846R.drawable.icon_attachment, C1216LO.getLo(C1216LO.actionImageOverlayColor));
                C1232UI.addCell(v, text4, click2, (int) C0846R.drawable.icon_attachment).setBackgroundDrawable(C1232UI.getBackground());
            }
            ConferenceBagUtil.Type type = ConferenceBagUtil.Type.catalog;
            if (this.module == null) {
                type = ConferenceBagUtil.Type.catalog;
            } else if (this.module.equals("projects")) {
                type = ConferenceBagUtil.Type.projects;
            } else if (this.module.equals("careers")) {
                type = ConferenceBagUtil.Type.careers;
            }
            new ConferenceBagUtil(this, v, type, this.f2018id, this.f2019o.get("eventid"), this.f2019o.get("venueid"), this.analytics).addCell();
            if (C1199DB.getSize("launchers", "moduletypeid", "35") > 0) {
                C1232UI.addCell(v, C1199DB.getFirstObject("launchers", "moduletypeid", "35").get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE), (View.OnClickListener) new View.OnClickListener() {
                    public void onClick(View v) {
                        Fragments.add(CatalogDetailFragment.this, NotesFragment.newInstance(LinkedObjects.TABLE_CAT, CatalogDetailFragment.this.f2019o.get(DBFavorites.KEY_EVENT_ID)), CatalogDetailFragment.this.f2019o.get(DBFavorites.KEY_NAME, ""));
                    }
                }, C1232UI.getColorOverlay((int) C0846R.drawable.icon_notes, C1216LO.getLo(C1216LO.actionImageOverlayColor))).setBackgroundDrawable(C1232UI.getBackground());
            }
            C1232UI.AddMetaData(this, LinkedObjects.TABLE_CAT, this.f2019o.get(DBFavorites.KEY_EVENT_ID), v);
            LinkedObjects.add(this, v, LinkedObjects.TABLE_CAT, this.f2018id);
        } else if (this.text != null) {
            C1232UI.setText((int) C0846R.C0847id.text, this.text, v);
            C1232UI.hide(C0846R.C0847id.separator, v);
        }
        return v;
    }

    public void click(MenuItem item) {
        switch (item.getItemId()) {
            case 5345:
                Fragments.add(this, AddNoteFragment.newInstance(LinkedObjects.TABLE_CAT, this.f2018id), "");
                return;
            case 6415:
                share();
                return;
            default:
                return;
        }
    }

    public void share() {
        String link = Html.fromHtml(String.valueOf(this.f2019o.get(DBFavorites.KEY_NAME)) + "<br />" + "http://" + C1199DB.getFirstObject(GCMConstants.EXTRA_APPLICATION_PENDING_INTENT, DBFavorites.KEY_EVENT_ID, App.f2123id).get("subdomain", "") + ".m.tap.cr ").toString();
        Intent shareIntent = new Intent("android.intent.action.SEND");
        shareIntent.setType("text/plain");
        shareIntent.putExtra("android.intent.extra.SUBJECT", getResourceString(C0846R.string.app_name));
        shareIntent.putExtra("android.intent.extra.TEXT", link);
        startActivity(Intent.createChooser(shareIntent, "Share"));
    }
}
