package com.tapcrowd.app.modules.sessions;

import android.content.Intent;
import android.os.Bundle;
import android.support.p000v4.view.ViewPager;
import android.text.Html;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.actionbarsherlock.view.MenuItem;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.android.gcm.GCMConstants;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.plus.PlusShare;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.TCFragment;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import com.tapcrowd.app.modules.favorites_v2.FavoritesUtil;
import com.tapcrowd.app.modules.map.MapFragment;
import com.tapcrowd.app.modules.map.MapV2Fragment;
import com.tapcrowd.app.modules.menuitems.MenuFragment;
import com.tapcrowd.app.modules.notes.AddNoteFragment;
import com.tapcrowd.app.modules.notes.NotesFragment;
import com.tapcrowd.app.modules.speakers.SpeakerDetailFragment;
import com.tapcrowd.app.modules.speakers.SpeakerListFragment;
import com.tapcrowd.app.modules.webview.WebViewFragment;
import com.tapcrowd.app.utils.Actions;
import com.tapcrowd.app.utils.AdHelper;
import com.tapcrowd.app.utils.App;
import com.tapcrowd.app.utils.C1199DB;
import com.tapcrowd.app.utils.C1216LO;
import com.tapcrowd.app.utils.C1232UI;
import com.tapcrowd.app.utils.ConferenceBagUtil;
import com.tapcrowd.app.utils.Converter;
import com.tapcrowd.app.utils.DetailImageViewpagerAdapter;
import com.tapcrowd.app.utils.Fragments;
import com.tapcrowd.app.utils.LinkedObjects;
import com.tapcrowd.app.utils.PersonalProgramUtil;
import com.tapcrowd.app.utils.TCObject;
import com.tapcrowd.app.utils.images.FastImageLoader;
import com.tapcrowd.app.views.Cell;
import com.tapcrowd.tcanalytics.TCAnalytics;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.cordova.Globalization;

public class SessionDetailFragment extends TCFragment implements MenuFragment.MenuItemListener {
    public static final String PREFS_NAME = "MyPrefsFile";
    private final int NOTES = 5344;
    private final int SHARE = 498;
    int contentid;
    /* access modifiers changed from: private */

    /* renamed from: id */
    public String f2112id;
    TCObject tco;

    /* renamed from: v */
    View f2113v;

    public static SessionDetailFragment newInstance(String sessionid) {
        SessionDetailFragment detail = new SessionDetailFragment();
        detail.tco = C1199DB.getObject("sessions", DBFavorites.KEY_EVENT_ID, sessionid);
        detail.f2112id = sessionid;
        return detail;
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(DBFavorites.KEY_EVENT_ID, this.f2112id);
    }

    public void twitter(View v) {
        Actions.openWebview(this, "https://mobile.twitter.com/" + C1199DB.getObject("metadata", "key == 'twitter' AND table_value == 'session' AND identifier", this.tco.get(DBFavorites.KEY_EVENT_ID)).get("value", "").replace("#", ""));
    }

    public void facebook(View v) {
        Actions.openWebview(this, C1199DB.getObject("metadata", "key == 'facebookurl' AND table_value == 'session' AND identifier", this.tco.get(DBFavorites.KEY_EVENT_ID)).get("value", ""));
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Cell c;
        Date d;
        this.f2113v = inflater.inflate(C0846R.layout.sessiondetailrealty, container, false);
        AdHelper.showAds(this, AdHelper.buildPath("10", "detail", this.f2112id));
        if (savedInstanceState != null && this.f2112id == null) {
            this.f2112id = savedInstanceState.getString(DBFavorites.KEY_EVENT_ID);
            this.tco = C1199DB.getObject("sessions", DBFavorites.KEY_EVENT_ID, this.f2112id);
        }
        setupMenu();
        this.tco = C1199DB.getObject("sessions", DBFavorites.KEY_EVENT_ID, this.f2112id);
        C1232UI.setText((int) C0846R.C0847id.name, this.tco.get(DBFavorites.KEY_NAME, "").toUpperCase(), this.f2113v);
        C1232UI.setText((int) C0846R.C0847id.location, this.tco.get("location"), this.f2113v);
        List<String> images = new ArrayList<>();
        if (this.tco.has("imageurl")) {
            images.add(this.tco.get("imageurl"));
        }
        for (TCObject meta : C1199DB.getQueryFromDb("SELECT value FROM metavalues WHERE type == 'image' AND  parentType == 'session' AND parentId == '" + this.f2112id + "'")) {
            images.add(meta.get("value"));
        }
        ViewPager vp = (ViewPager) this.f2113v.findViewById(C0846R.C0847id.viewerpager);
        vp.setAdapter(new DetailImageViewpagerAdapter(getActivity(), images, (LinearLayout) this.f2113v.findViewById(C0846R.C0847id.pager)));
        if (images.size() == 0) {
            vp.setVisibility(8);
        }
        if (this.tco.has(Globalization.DATE)) {
            try {
                d = new SimpleDateFormat("dd/MM/yyyy").parse(this.tco.get(Globalization.DATE));
            } catch (ParseException e) {
                d = new Date();
                e.printStackTrace();
            }
            C1232UI.setText((int) C0846R.C0847id.date, DateFormat.getLongDateFormat(getActivity()).format(d), this.f2113v);
        }
        if (this.tco.get(DBFavorites.KEY_SESSION_STARTDATE, "").equals("1970-01-01 01:00:00") || this.tco.get("enddate", "").equals("1970-01-01 01:00:00")) {
            C1232UI.hide(C0846R.C0847id.time, this.f2113v);
            C1232UI.hide(C0846R.C0847id.date, this.f2113v);
        } else {
            C1232UI.setText((int) C0846R.C0847id.time, String.valueOf(this.tco.get("starttime", "")) + " - " + this.tco.get("endtime", ""), this.f2113v);
        }
        this.f2113v.findViewById(C0846R.C0847id.header).setBackgroundColor(C1216LO.getLo(C1216LO.titleBackgroundColor));
        ((TextView) this.f2113v.findViewById(C0846R.C0847id.name)).setTextColor(C1216LO.getLo(C1216LO.titleFontColor));
        ((TextView) this.f2113v.findViewById(C0846R.C0847id.date)).setTextColor(C1216LO.getLo(C1216LO.titleFontColor));
        ((TextView) this.f2113v.findViewById(C0846R.C0847id.time)).setTextColor(C1216LO.getLo(C1216LO.titleFontColor));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        if (this.tco.has(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION)) {
            Cell c2 = C1232UI.addCell(this.f2113v, Converter.unicodeToString(this.tco.get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, "")));
            c2.setBackgroundDrawable(C1232UI.getBackground());
            c2.setLayoutParams(layoutParams);
        }
        List<TCObject> speakers = C1199DB.getQueryFromDb("SELECT * FROM speakers INNER JOIN speaker_session ON speakers.id == speaker_session.speakerid WHERE speaker_session.sessionid == '" + this.f2112id + "' ORDER BY name");
        if (speakers.size() > 0) {
            String speakerlist = "";
            int len = speakers.size();
            for (int i = 0; i < len; i++) {
                speakerlist = String.valueOf(speakerlist) + speakers.get(i).get(DBFavorites.KEY_NAME);
                if (i != len - 1) {
                    speakerlist = String.valueOf(speakerlist) + ", ";
                }
            }
            final List<TCObject> list = speakers;
            Cell c3 = C1232UI.addCell(this.f2113v, speakerlist, (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View v) {
                    if (list.size() == 1) {
                        Fragments.add(SessionDetailFragment.this, SpeakerDetailFragment.newInstance(((TCObject) list.get(0)).get("speakerid")), SessionDetailFragment.this.getResourceString(C0846R.string.detail));
                    } else {
                        Fragments.add(SessionDetailFragment.this, SpeakerListFragment.newInstance(SessionDetailFragment.this.f2112id), SessionDetailFragment.this.getResourceString(C0846R.string.speakers));
                    }
                }
            }, C1232UI.getColorOverlay((int) C0846R.drawable.icon_speaker, C1216LO.getLo(C1216LO.actionImageOverlayColor)));
            c3.setBackgroundDrawable(C1232UI.getBackground());
            c3.setLayoutParams(layoutParams);
        }
        if (this.tco.has("location")) {
            if (!this.tco.has("xpos") || Float.parseFloat(this.tco.get("xpos")) == BitmapDescriptorFactory.HUE_RED) {
                c = C1232UI.addCell(this.f2113v, this.tco.get("location", ""), (View.OnClickListener) null, C1232UI.getColorOverlay((int) C0846R.drawable.icon_navigate_white, C1216LO.getLo(C1216LO.actionImageOverlayColor)));
            } else {
                c = C1232UI.addCell(this.f2113v, this.tco.get("location", ""), (View.OnClickListener) new View.OnClickListener() {
                    public void onClick(View v) {
                        if (C1199DB.getSize("launchers", "moduletypeid", "72") > 0) {
                            Fragments.add(SessionDetailFragment.this, MapV2Fragment.newInstance(SessionDetailFragment.this.tco.get("mapid"), Float.valueOf(SessionDetailFragment.this.tco.get("xpos")).floatValue(), Float.valueOf(SessionDetailFragment.this.tco.get("ypos")).floatValue()), SessionDetailFragment.this.tco.get("location"));
                        } else {
                            Fragments.add(SessionDetailFragment.this, MapFragment.newInstance(SessionDetailFragment.this.tco.get("mapid"), Float.valueOf(SessionDetailFragment.this.tco.get("xpos")).floatValue(), Float.valueOf(SessionDetailFragment.this.tco.get("ypos")).floatValue()), SessionDetailFragment.this.tco.get("location"));
                        }
                    }
                }, C1232UI.getColorOverlay((int) C0846R.drawable.icon_navigate_white, C1216LO.getLo(C1216LO.actionImageOverlayColor)));
            }
            c.setBackgroundDrawable(C1232UI.getBackground());
        }
        if (this.tco.has(PlusShare.KEY_CALL_TO_ACTION_URL)) {
            Cell c4 = C1232UI.addCell(this.f2113v, getResourceString(C0846R.string.website), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View v) {
                    Fragments.add(SessionDetailFragment.this, WebViewFragment.newInstance(SessionDetailFragment.this.tco.get(PlusShare.KEY_CALL_TO_ACTION_URL), SessionDetailFragment.this.tco.get(DBFavorites.KEY_NAME)), SessionDetailFragment.this.tco.get(DBFavorites.KEY_NAME));
                }
            }, C1232UI.getColorOverlay((int) C0846R.drawable.icon_website, C1216LO.getLo(C1216LO.actionImageOverlayColor)));
            c4.setBackgroundDrawable(C1232UI.getBackground());
            c4.setLayoutParams(layoutParams);
        }
        C1232UI.hide(C0846R.C0847id.confbag, this.f2113v);
        if (C1199DB.getSize("launchers", "moduletypeid", "35") > 0) {
            C1232UI.addCell(this.f2113v, C1199DB.getFirstObject("launchers", "moduletypeid", "35").get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View v) {
                    Fragments.add(SessionDetailFragment.this, NotesFragment.newInstance("sessions", SessionDetailFragment.this.f2112id), SessionDetailFragment.this.tco.get(DBFavorites.KEY_NAME, ""));
                }
            }, C1232UI.getColorOverlay((int) C0846R.drawable.icon_notes, C1216LO.getLo(C1216LO.actionImageOverlayColor))).setBackgroundDrawable(C1232UI.getBackground());
        }
        new ConferenceBagUtil(this, this.f2113v, ConferenceBagUtil.Type.session, this.tco.get(DBFavorites.KEY_EVENT_ID), this.tco.get("eventid"), (String) null, this.analytics).addCell();
        new PersonalProgramUtil(getActivity(), this.f2113v, PersonalProgramUtil.Type.session, this.f2112id, this.tco.get("eventid"), this.analytics).addCell();
        new FastImageLoader();
        if (C1199DB.getSize("launchers", "eventid == '" + App.curEventId + "' AND moduletypeid", "61") > 0) {
            TCObject rating = C1199DB.getFirstObject("launchers", "eventid == '" + App.curEventId + "' AND moduletypeid", "61");
            final TCObject tCObject = rating;
            C1232UI.addCell(this.f2113v, rating.get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, ""), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View v) {
                    Actions.openForm(SessionDetailFragment.this, String.valueOf(tCObject.get("mobileurl", "")) + "&datasource=speaker&datasourceparent=session&datasourceparentid=" + SessionDetailFragment.this.f2112id);
                }
            }, C1232UI.getColorOverlay((int) C0846R.drawable.icon_question, C1216LO.getLo(C1216LO.actionImageOverlayColor))).setBackgroundDrawable(C1232UI.getBackground());
        }
        if (C1199DB.getSize("launchers", "eventid == '" + App.curEventId + "' AND moduletypeid", "60") > 0) {
            TCObject rating2 = C1199DB.getFirstObject("launchers", "eventid == '" + App.curEventId + "' AND moduletypeid", "60");
            final TCObject tCObject2 = rating2;
            C1232UI.addCell(this.f2113v, rating2.get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, ""), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View v) {
                    Actions.openForm(SessionDetailFragment.this, String.format("http://%1$s.m.tap.cr/forms/event/%2$s/%3$s?nonavbar&rateobject=session&rateobjectid=%4$s&cordova=2__2__0", new Object[]{C1199DB.getFirstObject(GCMConstants.EXTRA_APPLICATION_PENDING_INTENT).get("subdomain"), SessionDetailFragment.this.tco.get("eventid"), tCObject2.get(DBFavorites.KEY_EVENT_ID), SessionDetailFragment.this.f2112id}));
                }
            }, C1232UI.getColorOverlay((int) C0846R.drawable.icon_rating, C1216LO.getLo(C1216LO.actionImageOverlayColor))).setBackgroundDrawable(C1232UI.getBackground());
        }
        new FavoritesUtil(this, getActivity(), this.f2113v, FavoritesUtil.Type.Sessions, this.tco.get(DBFavorites.KEY_EVENT_ID), this.tco.get("eventid"), this.tco.get(DBFavorites.KEY_NAME), this.tco.get(DBFavorites.KEY_SESSION_STARTDATE)).addCell();
        C1232UI.AddMetaData(this, "session", this.f2112id, this.f2113v);
        LinkedObjects.add(this, this.f2113v, LinkedObjects.TABLE_EXHI, this.tco.get(DBFavorites.KEY_EVENT_ID));
        List<TCObject> subsessions = C1199DB.getListFromDb("sessions", "parentid", this.f2112id, "starttime, endtime");
        if (subsessions.size() > 0) {
            C1232UI.addSep(getString(C0846R.string.subsessions), this.f2113v);
        }
        for (TCObject session : subsessions) {
            ((ViewGroup) this.f2113v.findViewById(C0846R.C0847id.container)).addView(getSubSession(session));
        }
        return this.f2113v;
    }

    public void setupMenu() {
        ArrayList<MenuFragment.MenuItemContainer> menuitems = new ArrayList<>();
        if (C1199DB.getSize("launchers", "moduletypeid", "35") > 0) {
            menuitems.add(new MenuFragment.MenuItemContainer(C1232UI.getColorOverlay((int) C0846R.drawable.icon_notes_nav, C1216LO.getLo(C1216LO.navigationColor)), 5344));
        }
        if (C1199DB.getSize("socialshare", "launcherid", C1199DB.getFirstObject("launchers", "moduletypeid", "10").get(DBFavorites.KEY_EVENT_ID)) > 0) {
            menuitems.add(new MenuFragment.MenuItemContainer(C1232UI.getColorOverlay((int) C0846R.drawable.icon_share, C1216LO.getLo(C1216LO.navigationColor)), 498));
        }
        Fragments.addMenu(this, MenuFragment.newInstance(menuitems, this));
    }

    public void click(MenuItem item) {
        switch (item.getItemId()) {
            case 498:
                share();
                return;
            case 5344:
                Fragments.add(this, AddNoteFragment.newInstance("sessions", this.f2112id), "");
                return;
            default:
                return;
        }
    }

    public void share() {
        String link = Html.fromHtml(String.valueOf(this.tco.get(DBFavorites.KEY_NAME)) + "<br />" + "http://" + C1199DB.getFirstObject(GCMConstants.EXTRA_APPLICATION_PENDING_INTENT, DBFavorites.KEY_EVENT_ID, App.f2123id).get("subdomain", "") + ".m.tap.cr ").toString();
        Intent shareIntent = new Intent("android.intent.action.SEND");
        shareIntent.setType("text/plain");
        shareIntent.putExtra("android.intent.extra.SUBJECT", getResourceString(C0846R.string.app_name));
        shareIntent.putExtra("android.intent.extra.TEXT", link);
        startActivity(Intent.createChooser(shareIntent, "Share"));
    }

    public View getSubSession(final TCObject session) {
        View v = LayoutInflater.from(getActivity()).inflate(C0846R.layout.cell_session_new, (ViewGroup) null);
        int textColor = C1216LO.getLo(C1216LO.textcolor);
        v.findViewById(C0846R.C0847id.sep).setBackgroundColor(C1216LO.getLo(C1216LO.cellSeparator));
        TextView text = (TextView) v.findViewById(C0846R.C0847id.text);
        TextView sub1 = (TextView) v.findViewById(C0846R.C0847id.sub1);
        TextView sub2 = (TextView) v.findViewById(C0846R.C0847id.sub2);
        text.setTextColor(textColor);
        sub1.setTextColor(textColor);
        sub2.setTextColor(textColor);
        String sub2str = "";
        List<TCObject> speakers = C1199DB.getQueryFromDb("SELECT name FROM speakers INNER JOIN speaker_session ON speakers.id == speaker_session.speakerid WHERE speaker_session.sessionid == '" + session.get(DBFavorites.KEY_EVENT_ID) + "' ORDER BY name;");
        if (speakers.size() > 0) {
            for (TCObject speaker : speakers) {
                sub2str = String.valueOf(sub2str) + speaker.get(DBFavorites.KEY_NAME);
                if (!speaker.equals(speakers.get(speakers.size() - 1))) {
                    sub2str = String.valueOf(sub2str) + ", ";
                }
            }
        }
        if (sub2str.equals("")) {
            sub2str = MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
        }
        text.setText(session.get(DBFavorites.KEY_NAME));
        sub1.setText(String.valueOf(session.get("starttime")) + " - " + session.get("endtime"));
        sub2.setText(sub2str);
        v.setBackgroundDrawable(C1232UI.getBackground());
        v.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Fragments.add(SessionDetailFragment.this, SessionDetailFragment.newInstance(session.get(DBFavorites.KEY_EVENT_ID)), SessionDetailFragment.this.getString(C0846R.string.detail));
            }
        });
        return v;
    }

    public void onResume() {
        super.onResume();
        if (this.tco.has("loggingpath")) {
            TCAnalytics.log(getActivity(), this.tco.get("loggingpath"), "");
        }
    }
}
