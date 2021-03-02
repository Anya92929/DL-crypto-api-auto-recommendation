package com.tapcrowd.app.modules.sessions;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.support.p000v4.app.FragmentManager;
import android.support.p000v4.app.FragmentStatePagerAdapter;
import android.support.p000v4.view.ViewPager;
import android.text.format.DateFormat;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.TCFragment;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import com.tapcrowd.app.modules.groups.GroupListFragment;
import com.tapcrowd.app.modules.menuitems.MenuFragment;
import com.tapcrowd.app.modules.sessions.SessionListFragment;
import com.tapcrowd.app.modules.speakers.SpeakerListFragment;
import com.tapcrowd.app.utils.AdHelper;
import com.tapcrowd.app.utils.App;
import com.tapcrowd.app.utils.C1199DB;
import com.tapcrowd.app.utils.C1216LO;
import com.tapcrowd.app.utils.C1232UI;
import com.tapcrowd.app.utils.Fragments;
import com.tapcrowd.app.utils.TCObject;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.apache.cordova.Globalization;

public class SessionViewTypeFragment extends TCFragment implements MenuFragment.MenuItemListener, ViewPager.OnPageChangeListener {
    private final int FILTER = 3431;
    private final int SPEAKER = 963;
    private SessionFragmentPagerAdapter adapter;
    private String displaytype;
    private String eventid;
    private List<SessionListFragment> fragments;
    private MenuFragment menu;
    private int page = 0;
    private boolean retained;
    private String speakerid;

    /* renamed from: v */
    private View f2115v;
    private ViewPager viewpager;

    public static SessionViewTypeFragment newInstance(String eventid2) {
        SessionViewTypeFragment fr = new SessionViewTypeFragment();
        fr.eventid = eventid2;
        return fr;
    }

    public static SessionViewTypeFragment newInstance(String eventid2, String displaytype2, String nullcolumnhack) {
        SessionViewTypeFragment fr = new SessionViewTypeFragment();
        fr.eventid = eventid2;
        fr.displaytype = displaytype2;
        return fr;
    }

    public static SessionViewTypeFragment newInstance(String eventid2, String speakerid2) {
        SessionViewTypeFragment fr = new SessionViewTypeFragment();
        fr.eventid = eventid2;
        fr.speakerid = speakerid2;
        return fr;
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("eventid", this.eventid);
        outState.putString("speakerid", this.speakerid);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (this.f2115v == null) {
            this.f2115v = inflater.inflate(C0846R.layout.session_viewpager, container, false);
        } else {
            ((ViewGroup) this.f2115v.getParent()).removeView(this.f2115v);
            this.retained = true;
        }
        ArrayList<MenuFragment.MenuItemContainer> menuitems = new ArrayList<>();
        if (this.speakerid == null) {
            menuitems.add(new MenuFragment.MenuItemContainer(C1232UI.getColorOverlay((int) C0846R.drawable.icon_sessionfilter, C1216LO.getLo(C1216LO.navigationColor)), 3431));
        }
        if (C1199DB.getSize("speakers", "eventid", this.eventid) > 0 && this.speakerid == null) {
            menuitems.add(new MenuFragment.MenuItemContainer(C1232UI.getColorOverlay((int) C0846R.drawable.icon_speaker_small, C1216LO.getLo(C1216LO.navigationColor)), 963));
        }
        this.menu = MenuFragment.newInstance(menuitems, this);
        Fragments.addMenu(this, this.menu);
        return this.f2115v;
    }

    public void setGroupClick() {
        TextView group = (TextView) findViewById(C0846R.C0847id.group);
        registerForContextMenu(group);
        group.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SessionViewTypeFragment.this.getActivity().openContextMenu(v);
            }
        });
        group.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, getResources().getDrawable(C0846R.drawable.arrow_white_down));
    }

    public void unSetGroupClick() {
        TextView group = (TextView) findViewById(C0846R.C0847id.group);
        unregisterForContextMenu(group);
        group.setOnClickListener((View.OnClickListener) null);
        group.setCompoundDrawables((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        AdHelper.showAds(this, AdHelper.buildPath("10", "list", (String) null));
        if (!this.retained) {
            this.viewpager = (ViewPager) findViewById(C0846R.C0847id.pager);
            this.viewpager.setOnPageChangeListener(this);
            C1232UI.getColorOverlay((int) C0846R.drawable.icon_menu_back, C1216LO.getLo(C1216LO.separatorTextColor));
            C1232UI.getColorOverlay((int) C0846R.drawable.icon_menu_forward, C1216LO.getLo(C1216LO.separatorTextColor));
            ((ImageView) findViewById(C0846R.C0847id.prev)).setImageResource(C0846R.drawable.icon_menu_back);
            ((ImageView) findViewById(C0846R.C0847id.next)).setImageResource(C0846R.drawable.icon_menu_forward);
            ((TextView) findViewById(C0846R.C0847id.group)).setTextColor(C1216LO.getLo(C1216LO.separatorTextColor));
            findViewById(C0846R.C0847id.navigation).setBackgroundColor(C1216LO.getLo(C1216LO.seperatorBackgroundColor));
            if (savedInstanceState != null && this.eventid == null) {
                this.speakerid = savedInstanceState.getString("speakerid");
                this.eventid = savedInstanceState.getString("eventid");
            }
            ((ImageView) findViewById(C0846R.C0847id.prev)).setImageResource(C0846R.drawable.icon_menu_back);
            findViewById(C0846R.C0847id.prev).setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    SessionViewTypeFragment.this.prev();
                }
            });
            ((ImageView) findViewById(C0846R.C0847id.next)).setImageResource(C0846R.drawable.icon_menu_forward);
            findViewById(C0846R.C0847id.next).setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    SessionViewTypeFragment.this.next();
                }
            });
            if (this.displaytype == null) {
                showAlpha();
            } else if (this.displaytype.equals("location")) {
                showLocation();
            } else if (this.displaytype.equals("alfa")) {
                showAlpha();
            } else if (this.displaytype.equals(Globalization.TYPE)) {
                showType();
            } else {
                showDateTime();
            }
        }
    }

    public void onCreateContextMenu(ContextMenu menu2, View v, ContextMenu.ContextMenuInfo menuInfo) {
        if (v.equals(this.f2115v)) {
            menu2.add(0, 0, 0, getString(C0846R.string.type));
            if (C1199DB.getQueryFromDb("SELECT DISTINCT location FROM sessions WHERE eventid == '" + this.eventid + "'").size() > 1) {
                menu2.add(0, 1, 0, getString(C0846R.string.location_ses));
            }
            menu2.add(0, 2, 0, getString(C0846R.string.date_time));
            menu2.add(0, 3, 0, getString(C0846R.string.alphabetical));
        }
        super.onCreateContextMenu(menu2, v, menuInfo);
    }

    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 0:
                showType();
                this.page = 0;
                break;
            case 1:
                showLocation();
                this.page = 0;
                break;
            case 2:
                showDateTime();
                this.page = 0;
                break;
            case 3:
                showAlpha();
                this.page = 0;
                break;
        }
        return super.onContextItemSelected(item);
    }

    public void onCreateOptionsMenu(Menu menu2, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu2, inflater);
    }

    private void showType() {
        List<TCObject> groups;
        C1232UI.show(C0846R.C0847id.navigation, this.f2115v);
        if (this.speakerid == null) {
            groups = C1199DB.getListFromDb("sessiongroups", "eventid", this.eventid, "order_value +0 DESC, name COLLATE NOCASE");
        } else {
            groups = C1199DB.getQueryFromDb("SELECT sg.* FROM speaker_session ss LEFT JOIN sessions s ON ss.sessionid = s.id LEFT JOIN sessiongroups sg ON s.sessiongroupid = sg.id WHERE ss.speakerid == " + this.speakerid);
        }
        this.fragments = new ArrayList();
        for (TCObject group : groups) {
            SessionListFragment fr = SessionListFragment.newInstance(SessionListFragment.ViewType.Type, group.get(DBFavorites.KEY_EVENT_ID), this.speakerid, this.eventid);
            fr.title = group.get(DBFavorites.KEY_NAME);
            if (fr.getSize() > 0) {
                this.fragments.add(fr);
            }
        }
        if (this.fragments.size() > 0) {
            ((TextView) findViewById(C0846R.C0847id.group)).setText(this.fragments.get(0).title);
        }
        if (this.fragments.size() == 1 && groups.get(0).get(DBFavorites.KEY_NAME) == null) {
            C1232UI.hide(C0846R.C0847id.navigation, this.f2115v);
        }
        findViewById(C0846R.C0847id.prev).setVisibility(4);
        if (this.fragments.size() <= 1) {
            findViewById(C0846R.C0847id.next).setVisibility(4);
        } else {
            C1232UI.show(C0846R.C0847id.next, this.f2115v);
        }
        if (this.fragments.size() == 0) {
            C1232UI.hide(C0846R.C0847id.navigation, this.f2115v);
            this.fragments.add(SessionListFragment.newInstance(SessionListFragment.ViewType.Empty, (String) null, (String) null, (String) null));
        }
        this.adapter = new SessionFragmentPagerAdapter(getChildFragmentManager(), this.fragments);
        this.viewpager.setAdapter(this.adapter);
    }

    public void showLocation() {
        C1232UI.show(C0846R.C0847id.navigation, this.f2115v);
        List<TCObject> locations = C1199DB.getQueryFromDb("SELECT id, location FROM sessions WHERE eventid == '" + this.eventid + "' GROUP BY location ORDER BY location COLLATE NOCASE");
        this.fragments = new ArrayList();
        for (TCObject location : locations) {
            SessionListFragment fr = SessionListFragment.newInstance(SessionListFragment.ViewType.Location, location.get(DBFavorites.KEY_EVENT_ID, ""), this.speakerid, this.eventid);
            fr.title = location.get("location", "");
            if (fr.getSize() > 0) {
                this.fragments.add(fr);
            }
        }
        if (this.fragments.size() > 0) {
            ((TextView) findViewById(C0846R.C0847id.group)).setText(locations.get(0).get("location"));
        }
        findViewById(C0846R.C0847id.prev).setVisibility(4);
        if (this.fragments.size() <= 1) {
            findViewById(C0846R.C0847id.next).setVisibility(4);
        } else {
            C1232UI.show(C0846R.C0847id.next, this.f2115v);
        }
        this.adapter = new SessionFragmentPagerAdapter(getChildFragmentManager(), this.fragments);
        this.viewpager.setAdapter(this.adapter);
    }

    public void showDateTime() {
        C1232UI.show(C0846R.C0847id.navigation, this.f2115v);
        List<TCObject> dates = C1199DB.getQueryFromDb("SELECT DISTINCT date FROM sessions WHERE eventid == '" + this.eventid + "' ORDER BY startdate ASC");
        this.fragments = new ArrayList();
        for (TCObject date : dates) {
            SessionListFragment fr = SessionListFragment.newInstance(SessionListFragment.ViewType.DateTime, date.get(Globalization.DATE), this.speakerid, this.eventid);
            try {
                fr.title = DateFormat.getLongDateFormat(App.act).format(new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).parse(date.get(Globalization.DATE)));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (fr.getSize() > 0) {
                this.fragments.add(fr);
            }
        }
        if (this.fragments.size() > 0 && this.fragments.get(0).title != null) {
            ((TextView) findViewById(C0846R.C0847id.group)).setText(this.fragments.get(0).title);
        }
        findViewById(C0846R.C0847id.prev).setVisibility(4);
        if (this.fragments.size() <= 1) {
            findViewById(C0846R.C0847id.next).setVisibility(4);
        } else {
            C1232UI.show(C0846R.C0847id.next, this.f2115v);
        }
        if (this.fragments.size() == 0) {
            C1232UI.hide(C0846R.C0847id.navigation, this.f2115v);
            this.fragments.add(SessionListFragment.newInstance(SessionListFragment.ViewType.Empty, (String) null, (String) null, (String) null));
        }
        this.adapter = new SessionFragmentPagerAdapter(getChildFragmentManager(), this.fragments);
        this.viewpager.setAdapter(this.adapter);
    }

    public void showAlpha() {
        C1232UI.hide(C0846R.C0847id.navigation, this.f2115v);
        this.fragments = new ArrayList();
        this.fragments.add(SessionListFragment.newInstance(SessionListFragment.ViewType.Alpha, this.eventid, this.speakerid, this.eventid));
        this.adapter = new SessionFragmentPagerAdapter(getChildFragmentManager(), this.fragments);
        this.viewpager.setAdapter(this.adapter);
    }

    public void prev() {
        if (this.page != 0) {
            ViewPager viewPager = this.viewpager;
            int i = this.page - 1;
            this.page = i;
            viewPager.setCurrentItem(i);
        }
    }

    public void next() {
        if (this.page != this.adapter.getCount() - 1) {
            ViewPager viewPager = this.viewpager;
            int i = this.page + 1;
            this.page = i;
            viewPager.setCurrentItem(i);
        }
    }

    public View findViewById(int id) {
        return this.f2115v.findViewById(id);
    }

    public void click(com.actionbarsherlock.view.MenuItem item) {
        switch (item.getItemId()) {
            case 963:
                if (C1199DB.getFirstObject("launchers", "moduletypeid", "40").get("displaytype").equals("categories")) {
                    Fragments.add(this, GroupListFragment.newInstance("parentid", C1199DB.getObject("groups", "eventid == " + this.eventid + " AND name", "speakercategories").get(DBFavorites.KEY_EVENT_ID)), getString(C0846R.string.categorieen));
                    return;
                } else {
                    Fragments.add(this, SpeakerListFragment.newInstance(), getString(C0846R.string.speakers));
                    return;
                }
            case 3431:
                registerForContextMenu(this.f2115v);
                getActivity().openContextMenu(this.f2115v);
                unregisterForContextMenu(this.f2115v);
                return;
            default:
                return;
        }
    }

    private static class SessionFragmentPagerAdapter extends FragmentStatePagerAdapter {
        List<SessionListFragment> fragments;

        public SessionFragmentPagerAdapter(FragmentManager fm, List<SessionListFragment> fragments2) {
            super(fm);
            this.fragments = fragments2;
        }

        public Fragment getItem(int index) {
            return this.fragments.get(index);
        }

        public int getCount() {
            return this.fragments.size();
        }
    }

    public void onPageScrollStateChanged(int arg0) {
    }

    public void onPageScrolled(int arg0, float arg1, int arg2) {
    }

    public void onPageSelected(int position) {
        this.page = position;
        SessionListFragment fr = (SessionListFragment) this.adapter.getItem(position);
        if (fr.title != null) {
            ((TextView) findViewById(C0846R.C0847id.group)).setText(fr.title);
            if (position == 0) {
                findViewById(C0846R.C0847id.prev).setVisibility(4);
            } else {
                C1232UI.show(C0846R.C0847id.prev);
            }
            if (position == this.adapter.getCount() - 1) {
                findViewById(C0846R.C0847id.next).setVisibility(4);
            } else {
                C1232UI.show(C0846R.C0847id.next);
            }
        }
    }
}
