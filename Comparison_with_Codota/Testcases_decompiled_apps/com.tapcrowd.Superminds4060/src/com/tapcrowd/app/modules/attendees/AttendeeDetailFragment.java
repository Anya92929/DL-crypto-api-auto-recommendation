package com.tapcrowd.app.modules.attendees;

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
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.android.gcm.GCMConstants;
import com.google.android.gms.plus.PlusShare;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.TCFragment;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import com.tapcrowd.app.modules.menuitems.MenuFragment;
import com.tapcrowd.app.modules.notes.AddNoteFragment;
import com.tapcrowd.app.modules.notes.NotesFragment;
import com.tapcrowd.app.modules.notifications.RequestMeetingFragment;
import com.tapcrowd.app.modules.notifications.SendMessageFragment;
import com.tapcrowd.app.utils.Actions;
import com.tapcrowd.app.utils.AdHelper;
import com.tapcrowd.app.utils.App;
import com.tapcrowd.app.utils.C1199DB;
import com.tapcrowd.app.utils.C1216LO;
import com.tapcrowd.app.utils.C1232UI;
import com.tapcrowd.app.utils.ConferenceBagUtil;
import com.tapcrowd.app.utils.DetailImageViewpagerAdapter;
import com.tapcrowd.app.utils.Fragments;
import com.tapcrowd.app.utils.LinkedObjects;
import com.tapcrowd.app.utils.TCObject;
import com.tapcrowd.app.utils.UserModule;
import com.tapcrowd.app.views.Cell;
import com.tapcrowd.tcanalytics.TCAnalytics;
import java.util.ArrayList;
import java.util.List;

public class AttendeeDetailFragment extends TCFragment implements MenuFragment.MenuItemListener {
    private final int NOTES = 5333;
    private final int SHARE = 5346;
    /* access modifiers changed from: private */

    /* renamed from: id */
    public String f2010id;
    TCObject tco;

    /* renamed from: v */
    View f2011v;

    public static AttendeeDetailFragment newInstance(String id) {
        AttendeeDetailFragment detail = new AttendeeDetailFragment();
        detail.tco = C1199DB.getObject(LinkedObjects.TABLE_ATT, DBFavorites.KEY_EVENT_ID, id);
        detail.f2010id = id;
        return detail;
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(DBFavorites.KEY_EVENT_ID, this.f2010id);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.f2011v = inflater.inflate(C0846R.layout.exhibitordetail, container, false);
        setupMenu();
        if (savedInstanceState != null && this.f2010id == null) {
            this.f2010id = savedInstanceState.getString(DBFavorites.KEY_EVENT_ID);
            this.tco = C1199DB.getObject(LinkedObjects.TABLE_ATT, DBFavorites.KEY_EVENT_ID, this.f2010id);
        }
        AdHelper.showAds(this, AdHelper.buildPath("14", "detail", this.f2010id));
        this.f2011v.findViewById(C0846R.C0847id.LinearLayout2).setBackgroundColor(C1216LO.getLo(C1216LO.titleBackgroundColor));
        ((TextView) this.f2011v.findViewById(C0846R.C0847id.name)).setTextColor(C1216LO.getLo(C1216LO.titleFontColor));
        ((TextView) this.f2011v.findViewById(C0846R.C0847id.location)).setTextColor(C1216LO.getLo(C1216LO.titleFontColor));
        ((TextView) this.f2011v.findViewById(C0846R.C0847id.country)).setTextColor(C1216LO.getLo(C1216LO.titleFontColor));
        TextView name = (TextView) this.f2011v.findViewById(C0846R.C0847id.name);
        name.setText(String.valueOf(this.tco.get("firstname", "")) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.tco.get(DBFavorites.KEY_NAME));
        name.setTextSize(17.0f);
        C1232UI.hide(C0846R.C0847id.location, this.f2011v);
        ((TextView) this.f2011v.findViewById(C0846R.C0847id.location)).setTextSize(15.0f);
        C1232UI.hide(C0846R.C0847id.sepInfo, this.f2011v);
        C1232UI.hide(C0846R.C0847id.when, this.f2011v);
        if (this.tco.has(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION)) {
            C1232UI.setText((int) C0846R.C0847id.info, this.tco.get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION), this.f2011v);
        } else {
            C1232UI.hide(C0846R.C0847id.info, this.f2011v);
            C1232UI.hide(C0846R.C0847id.sepInfo, this.f2011v);
        }
        if (this.tco.has("country")) {
            C1232UI.show(C0846R.C0847id.country, this.f2011v);
        }
        ((TextView) this.f2011v.findViewById(C0846R.C0847id.country)).setText(this.tco.get("country", ""));
        List<String> images = new ArrayList<>();
        if (this.tco.has("imageurl")) {
            images.add(this.tco.get("imageurl"));
        }
        for (TCObject meta : C1199DB.getQueryFromDb("SELECT value FROM metavalues WHERE type == 'image' AND  parentType == 'attendees' AND parentId == '" + this.f2010id + "'")) {
            images.add(meta.get("value"));
        }
        ViewPager vp = (ViewPager) this.f2011v.findViewById(C0846R.C0847id.viewerpager);
        vp.setAdapter(new DetailImageViewpagerAdapter((Context) getActivity(), images, (LinearLayout) this.f2011v.findViewById(C0846R.C0847id.pager), ImageView.ScaleType.FIT_CENTER));
        if (images.size() == 0) {
            vp.setVisibility(8);
        }
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(-1, -2);
        C1232UI.addCell(this.f2011v, this.tco.get("company"), (View.OnClickListener) null, C1232UI.getColorOverlay((int) C0846R.drawable.icon_company, C1216LO.getLo(C1216LO.actionImageOverlayColor)));
        C1232UI.addCell(this.f2011v, this.tco.get("function"), (View.OnClickListener) null, C1232UI.getColorOverlay((int) C0846R.drawable.icon_function, C1216LO.getLo(C1216LO.actionImageOverlayColor)));
        Cell c = C1232UI.addCell(this.f2011v, this.tco.get("email"), (View.OnClickListener) new View.OnClickListener() {
            public void onClick(View v) {
                Actions.doMail(AttendeeDetailFragment.this.tco.get("email"));
            }
        }, C1232UI.getColorOverlay((int) C0846R.drawable.icon_email, C1216LO.getLo(C1216LO.actionImageOverlayColor)));
        c.setBackgroundDrawable(C1232UI.getBackground());
        c.setLayoutParams(lp);
        if (this.tco.has("phonenr")) {
            Cell c2 = C1232UI.addCell(this.f2011v, this.tco.get("phonenr"), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View v) {
                    Actions.doCall(AttendeeDetailFragment.this.tco.get("phonenr"));
                }
            }, C1232UI.getColorOverlay((int) C0846R.drawable.icon_tel, C1216LO.getLo(C1216LO.actionImageOverlayColor)));
            c2.setBackgroundDrawable(C1232UI.getBackground());
            c2.setLayoutParams(lp);
        }
        if (this.tco.has("linkedin")) {
            Cell c3 = C1232UI.addCell(this.f2011v, getResourceString(C0846R.string.linkedinprofile), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View v) {
                    Actions.openWebview(AttendeeDetailFragment.this, AttendeeDetailFragment.this.tco.get("linkedin"));
                }
            }, C1232UI.getColorOverlay((int) C0846R.drawable.icon_linkedin, C1216LO.getLo(C1216LO.actionImageOverlayColor)));
            c3.setBackgroundDrawable(C1232UI.getBackground());
            c3.setLayoutParams(lp);
        }
        if (this.tco.has("facebook")) {
            Cell c4 = C1232UI.addCell(this.f2011v, "Facebook", (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View v) {
                    Actions.openWebview(AttendeeDetailFragment.this, AttendeeDetailFragment.this.tco.get("facebook"));
                }
            }, C1232UI.getColorOverlay((int) C0846R.drawable.sesfb, C1216LO.getLo(C1216LO.actionImageOverlayColor)));
            c4.setBackgroundDrawable(C1232UI.getBackground());
            c4.setLayoutParams(lp);
        }
        if (this.tco.has("twitter")) {
            Cell c5 = C1232UI.addCell(this.f2011v, "Twitter", (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View v) {
                    Actions.openWebview(AttendeeDetailFragment.this, AttendeeDetailFragment.this.tco.get("twitter"));
                }
            }, C1232UI.getColorOverlay((int) C0846R.drawable.sestwit, C1216LO.getLo(C1216LO.actionImageOverlayColor)));
            c5.setBackgroundDrawable(C1232UI.getBackground());
            c5.setLayoutParams(lp);
        }
        if (this.tco.has("phonenr") || this.tco.has("email")) {
            Cell c6 = C1232UI.addCell(this.f2011v, getString(C0846R.string.add_to_contacts), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View v) {
                    Actions.addToContacts(String.valueOf(AttendeeDetailFragment.this.tco.get("firstname")) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + AttendeeDetailFragment.this.tco.get(DBFavorites.KEY_NAME), AttendeeDetailFragment.this.tco.get("phonenr"), AttendeeDetailFragment.this.tco.get("email", ""), AttendeeDetailFragment.this.tco.get("address", ""));
                }
            }, C1232UI.getColorOverlay((int) C0846R.drawable.icon_contacts, C1216LO.getLo(C1216LO.actionImageOverlayColor)));
            c6.setBackgroundDrawable(C1232UI.getBackground());
            c6.setLayoutParams(lp);
        }
        if (this.tco.has("address")) {
            Cell c7 = C1232UI.addCell(this.f2011v, this.tco.get("address"), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View v) {
                    Actions.doNavigate(AttendeeDetailFragment.this.tco.get("address"));
                }
            }, C1232UI.getColorOverlay((int) C0846R.drawable.icon_navigate_white, C1216LO.getLo(C1216LO.actionImageOverlayColor)));
            c7.setBackgroundDrawable(C1232UI.getBackground());
            c7.setLayoutParams(lp);
        }
        if (C1199DB.getSize("launchers", "moduletypeid", "64") > 0 && UserModule.isLoggedIn(getActivity()) && this.tco.get("allowmessaging", "0").equals("1")) {
            String title = C1199DB.getFirstObject("launchers", "moduletypeid", "65").get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, "Messages");
            final String str = title;
            C1232UI.addCell(this.f2011v, title, (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View v) {
                    Fragments.add(AttendeeDetailFragment.this, SendMessageFragment.newInstance(AttendeeDetailFragment.this.tco.get(DBFavorites.KEY_EVENT_ID)), str);
                }
            }, C1232UI.getColorOverlay((int) C0846R.drawable.icon_chat, C1216LO.getLo(C1216LO.actionImageOverlayColor))).setBackgroundDrawable(C1232UI.getBackground());
        }
        if (C1199DB.getSize("launchers", "moduletypeid", "78") > 0 && UserModule.isLoggedIn(getActivity()) && this.tco.get("allowmessaging", "0").equals("1")) {
            String title2 = C1199DB.getFirstObject("launchers", "moduletypeid", "78").get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, "Messages");
            final String str2 = title2;
            C1232UI.addCell(this.f2011v, title2, (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View v) {
                    Fragments.add(AttendeeDetailFragment.this, RequestMeetingFragment.newInstance(AttendeeDetailFragment.this.tco.get(DBFavorites.KEY_EVENT_ID)), str2);
                }
            }, C1232UI.getColorOverlay((int) C0846R.drawable.icon_meet_request, C1216LO.getLo(C1216LO.actionImageOverlayColor))).setBackgroundDrawable(C1232UI.getBackground());
        }
        new ConferenceBagUtil(this, this.f2011v, ConferenceBagUtil.Type.attendee, this.tco.get(DBFavorites.KEY_EVENT_ID), this.tco.get("eventid"), (String) null, this.analytics).addCell();
        C1232UI.addCell(this.f2011v, getString(C0846R.string.notes), (View.OnClickListener) new View.OnClickListener() {
            public void onClick(View v) {
                Fragments.add(AttendeeDetailFragment.this, NotesFragment.newInstance(LinkedObjects.TABLE_ATT, AttendeeDetailFragment.this.f2010id), AttendeeDetailFragment.this.tco.get(DBFavorites.KEY_NAME, ""));
            }
        }, C1232UI.getColorOverlay((int) C0846R.drawable.icon_notes, C1216LO.getLo(C1216LO.actionImageOverlayColor))).setBackgroundDrawable(C1232UI.getBackground());
        C1232UI.AddMetaData(this, LinkedObjects.TABLE_ATT, this.f2010id, this.f2011v);
        LinkedObjects.add(this, this.f2011v, LinkedObjects.TABLE_ATT, this.tco.get(DBFavorites.KEY_EVENT_ID));
        return this.f2011v;
    }

    public void setupMenu() {
        ArrayList<MenuFragment.MenuItemContainer> menuitems = new ArrayList<>();
        menuitems.add(new MenuFragment.MenuItemContainer(C1232UI.getColorOverlay((int) C0846R.drawable.icon_notes_nav, C1216LO.getLo(C1216LO.navigationColor)), 5333));
        if (C1199DB.getSize("socialshare", "launcherid", C1199DB.getFirstObject("launchers", "moduletypeid", "14").get(DBFavorites.KEY_EVENT_ID)) > 0) {
            menuitems.add(new MenuFragment.MenuItemContainer(C1232UI.getColorOverlay((int) C0846R.drawable.icon_share, C1216LO.getLo(C1216LO.navigationColor)), 5346));
        }
        Fragments.addMenu(this, MenuFragment.newInstance(menuitems, this));
    }

    public void onResume() {
        super.onResume();
        if (this.tco.has("loggingpath")) {
            TCAnalytics.log(getActivity(), this.tco.get("loggingpath"), "");
        }
    }

    public void click(MenuItem item) {
        switch (item.getItemId()) {
            case 5333:
                Fragments.add(this, AddNoteFragment.newInstance(LinkedObjects.TABLE_ATT, this.tco.get(DBFavorites.KEY_EVENT_ID)), "");
                return;
            case 5346:
                share();
                return;
            default:
                return;
        }
    }

    public void share() {
        String link = Html.fromHtml(String.valueOf(this.tco.get("firstname")) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.tco.get(DBFavorites.KEY_NAME) + "<br />" + "http://" + C1199DB.getFirstObject(GCMConstants.EXTRA_APPLICATION_PENDING_INTENT, DBFavorites.KEY_EVENT_ID, App.f2123id).get("subdomain", "") + ".m.tap.cr ").toString();
        Intent shareIntent = new Intent("android.intent.action.SEND");
        shareIntent.setType("text/plain");
        shareIntent.putExtra("android.intent.extra.SUBJECT", getResourceString(C0846R.string.app_name));
        shareIntent.putExtra("android.intent.extra.TEXT", link);
        startActivity(Intent.createChooser(shareIntent, "Share"));
    }
}
