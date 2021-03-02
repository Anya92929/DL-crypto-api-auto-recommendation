package com.tapcrowd.app.modules.speakers;

import android.content.Context;
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
import com.tapcrowd.app.modules.sessions.SessionDetailFragment;
import com.tapcrowd.app.modules.sessions.SessionViewTypeFragment;
import com.tapcrowd.app.utils.Actions;
import com.tapcrowd.app.utils.AdHelper;
import com.tapcrowd.app.utils.App;
import com.tapcrowd.app.utils.C1199DB;
import com.tapcrowd.app.utils.C1216LO;
import com.tapcrowd.app.utils.C1232UI;
import com.tapcrowd.app.utils.DetailImageViewpagerAdapter;
import com.tapcrowd.app.utils.Fragments;
import com.tapcrowd.app.utils.TCObject;
import com.tapcrowd.tcanalytics.TCAnalytics;
import java.util.ArrayList;
import java.util.List;

public class SpeakerDetailFragment extends TCFragment implements MenuFragment.MenuItemListener {
    private final int NOTES = 5341;

    /* renamed from: id */
    String f2117id;

    /* renamed from: v */
    View f2118v;

    public static SpeakerDetailFragment newInstance(String id) {
        SpeakerDetailFragment fragment = new SpeakerDetailFragment();
        fragment.f2117id = id;
        return fragment;
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(DBFavorites.KEY_EVENT_ID, this.f2117id);
    }

    public void onResume() {
        super.onResume();
        TCObject tco = C1199DB.getFirstObject("speakers", DBFavorites.KEY_EVENT_ID, this.f2117id);
        if (tco.has("loggingpath")) {
            TCAnalytics.log(getActivity(), tco.get("loggingpath"), "");
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.f2118v = inflater.inflate(C0846R.layout.speaker_detail, container, false);
        AdHelper.showAds(this, AdHelper.buildPath("40", "detail", this.f2117id));
        if (savedInstanceState != null && this.f2117id == null) {
            this.f2117id = savedInstanceState.getString(DBFavorites.KEY_EVENT_ID);
        }
        final TCObject speaker = C1199DB.getFirstObject("speakers", DBFavorites.KEY_EVENT_ID, this.f2117id);
        setupMenu();
        TextView name = (TextView) this.f2118v.findViewById(C0846R.C0847id.name);
        TextView company = (TextView) this.f2118v.findViewById(C0846R.C0847id.company);
        TextView description = (TextView) this.f2118v.findViewById(C0846R.C0847id.description);
        this.f2118v.findViewById(C0846R.C0847id.header).setBackgroundColor(C1216LO.getLo(C1216LO.titleBackgroundColor));
        ((TextView) this.f2118v.findViewById(C0846R.C0847id.name)).setTextColor(C1216LO.getLo(C1216LO.titleFontColor));
        ((TextView) this.f2118v.findViewById(C0846R.C0847id.company)).setTextColor(C1216LO.getLo(C1216LO.titleFontColor));
        List<String> images = new ArrayList<>();
        if (speaker.has("imageurl")) {
            images.add(speaker.get("imageurl"));
        }
        for (TCObject meta : C1199DB.getQueryFromDb("SELECT value FROM metavalues WHERE type == 'image' AND  parentType == 'speaker' AND parentId == '" + this.f2117id + "'")) {
            images.add(meta.get("value"));
        }
        ViewPager vp = (ViewPager) this.f2118v.findViewById(C0846R.C0847id.viewerpager);
        vp.setAdapter(new DetailImageViewpagerAdapter((Context) getActivity(), images, (LinearLayout) this.f2118v.findViewById(C0846R.C0847id.pager), ImageView.ScaleType.FIT_CENTER));
        if (images.size() == 0) {
            vp.setVisibility(8);
        }
        if (speaker.get(DBFavorites.KEY_NAME) != null) {
            name.setText(speaker.get(DBFavorites.KEY_NAME));
        }
        if (speaker.get("company") != null) {
            company.setText(speaker.get("company"));
        }
        if (speaker.get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION) != null) {
            description.setText(speaker.get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION));
        } else {
            description.setVisibility(8);
        }
        if (speaker.has("function")) {
            C1232UI.addCell(this.f2118v, speaker.get("function"), (View.OnClickListener) null, C1232UI.getColorOverlay((int) C0846R.drawable.icon_function, C1216LO.getLo(C1216LO.actionImageOverlayColor))).setBackgroundDrawable(C1232UI.getBackground());
        }
        if (speaker.get("telephone") != null) {
            C1232UI.addCell(this.f2118v, speaker.get("telephone"), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View v) {
                    Actions.doCall(speaker.get("telephone"));
                }
            }, C1232UI.getColorOverlay((int) C0846R.drawable.icon_tel, C1216LO.getLo(C1216LO.actionImageOverlayColor))).setBackgroundDrawable(C1232UI.getBackground());
        }
        if (speaker.get("email") != null) {
            C1232UI.addCell(this.f2118v, speaker.get("email"), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View v) {
                    Actions.doMail(speaker.get("email"));
                }
            }, C1232UI.getColorOverlay((int) C0846R.drawable.icon_email, C1216LO.getLo(C1216LO.actionImageOverlayColor))).setBackgroundDrawable(C1232UI.getBackground());
        }
        final List<TCObject> sessions = C1199DB.getQueryFromDb("SELECT * FROM speaker_session INNER JOIN sessions ON sessions.id == speaker_session.sessionid WHERE speaker_session.speakerid == '" + this.f2117id + "'");
        if (sessions.size() > 0) {
            C1232UI.addCell(this.f2118v, getResourceString(C0846R.string.showsessions), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View v) {
                    if (sessions.size() > 1) {
                        Fragments.add(SpeakerDetailFragment.this, SessionViewTypeFragment.newInstance(speaker.get("eventid"), SpeakerDetailFragment.this.f2117id), speaker.get(DBFavorites.KEY_NAME));
                    } else {
                        Fragments.add(SpeakerDetailFragment.this, SessionDetailFragment.newInstance(((TCObject) sessions.get(0)).get(DBFavorites.KEY_EVENT_ID)), SpeakerDetailFragment.this.getResourceString(C0846R.string.detail));
                    }
                }
            }, C1232UI.getColorOverlay((int) C0846R.drawable.icon_session, C1216LO.getLo(C1216LO.actionImageOverlayColor))).setBackgroundDrawable(C1232UI.getBackground());
        }
        if (C1199DB.getSize("launchers", "eventid == '" + App.curEventId + "' AND moduletypeid", "60") > 0) {
            final TCObject rating = C1199DB.getFirstObject("launchers", "eventid == '" + App.curEventId + "' AND moduletypeid", "60");
            C1232UI.addCell(this.f2118v, rating.get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, ""), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View v) {
                    Actions.openForm(SpeakerDetailFragment.this, String.valueOf(rating.get("mobileurl", "")) + "&rateobject=speaker&rateobjectid=" + SpeakerDetailFragment.this.f2117id + "&nonavbar=1");
                }
            }, C1232UI.getColorOverlay((int) C0846R.drawable.icon_rating, C1216LO.getLo(C1216LO.actionImageOverlayColor))).setBackgroundDrawable(C1232UI.getBackground());
        }
        if (C1199DB.getSize("launchers", "eventid == '" + App.curEventId + "' AND moduletypeid", "61") > 0) {
            final TCObject rating2 = C1199DB.getFirstObject("launchers", "eventid == '" + App.curEventId + "' AND moduletypeid", "61");
            C1232UI.addCell(this.f2118v, rating2.get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, ""), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View v) {
                    Actions.openForm(SpeakerDetailFragment.this, String.valueOf(rating2.get("mobileurl", "")) + "&datasource=speaker&datasourceparent=speaker&datasourceparentid=" + SpeakerDetailFragment.this.f2117id + "&nonavbar=1");
                }
            }, C1232UI.getColorOverlay((int) C0846R.drawable.icon_question, C1216LO.getLo(C1216LO.actionImageOverlayColor))).setBackgroundDrawable(C1232UI.getBackground());
        }
        if (C1199DB.getSize("launchers", "moduletypeid", "35") > 0) {
            C1232UI.addCell(this.f2118v, getString(C0846R.string.notes), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View v) {
                    Fragments.add(SpeakerDetailFragment.this, NotesFragment.newInstance("speakers", SpeakerDetailFragment.this.f2117id), speaker.get(DBFavorites.KEY_NAME));
                }
            }, C1232UI.getColorOverlay((int) C0846R.drawable.icon_notes, C1216LO.getLo(C1216LO.actionImageOverlayColor))).setBackgroundDrawable(C1232UI.getBackground());
        }
        C1232UI.AddMetaData(this, "speaker", this.f2117id, this.f2118v);
        return this.f2118v;
    }

    public void setupMenu() {
        ArrayList<MenuFragment.MenuItemContainer> menuitems = new ArrayList<>();
        if (C1199DB.getSize("launchers", "moduletypeid", "35") > 0) {
            menuitems.add(new MenuFragment.MenuItemContainer(C1232UI.getColorOverlay((int) C0846R.drawable.icon_notes_nav, C1216LO.getLo(C1216LO.navigationColor)), 5341));
        }
        Fragments.addMenu(this, MenuFragment.newInstance(menuitems, this));
    }

    public void click(MenuItem item) {
        switch (item.getItemId()) {
            case 5341:
                TCObject firstObject = C1199DB.getFirstObject("speakers", DBFavorites.KEY_EVENT_ID, this.f2117id);
                Fragments.add(this, AddNoteFragment.newInstance("speakers", this.f2117id), "");
                return;
            default:
                return;
        }
    }
}
