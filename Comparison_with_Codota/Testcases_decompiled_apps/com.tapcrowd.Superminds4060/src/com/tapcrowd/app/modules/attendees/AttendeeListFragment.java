package com.tapcrowd.app.modules.attendees;

import android.content.Context;
import android.os.Bundle;
import android.support.p000v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.actionbarsherlock.view.MenuItem;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.TCListFragment;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import com.tapcrowd.app.modules.groups.GroupListFragment;
import com.tapcrowd.app.modules.menuitems.MenuFragment;
import com.tapcrowd.app.utils.AdHelper;
import com.tapcrowd.app.utils.C1199DB;
import com.tapcrowd.app.utils.C1216LO;
import com.tapcrowd.app.utils.C1232UI;
import com.tapcrowd.app.utils.Fragments;
import com.tapcrowd.app.utils.TCDBHelper;
import com.tapcrowd.app.utils.TCListObject;
import com.tapcrowd.app.views.SearchBar;
import java.util.ArrayList;

public class AttendeeListFragment extends TCListFragment implements MenuFragment.MenuItemListener {
    final int GROUPS = 0;
    String eventid;
    MenuFragment menu;
    boolean retained;

    /* renamed from: v */
    View f2012v;

    public static AttendeeListFragment newInstance(String eventid2) {
        AttendeeListFragment fragment = new AttendeeListFragment();
        fragment.eventid = eventid2;
        return fragment;
    }

    public void onResume() {
        super.onResume();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (this.f2012v == null) {
            this.f2012v = inflater.inflate(C0846R.layout.listview, container, false);
        } else {
            ((ViewGroup) this.f2012v.getParent()).removeView(this.f2012v);
            this.retained = true;
        }
        return this.f2012v;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayList<MenuFragment.MenuItemContainer> menuitems = new ArrayList<>();
        if (C1199DB.getSize("groups", "parentid", C1199DB.getObject("groups", "eventid == " + this.eventid + " AND name", "attendeecategories").get(DBFavorites.KEY_EVENT_ID)) > 0) {
            menuitems.add(new MenuFragment.MenuItemContainer(C1232UI.getColorOverlay((int) C0846R.drawable.icon_categories, C1216LO.getLo(C1216LO.navigationColor)), 0));
        }
        this.menu = MenuFragment.newInstance(menuitems, this);
        Fragments.addMenu(this, this.menu);
        AdHelper.showAds(this, AdHelper.buildPath("14", "list", (String) null));
        if (!this.retained) {
            setupList();
        }
    }

    public void setupList() {
        SearchBar searchbar = new SearchBar((Context) getActivity(), (ListFragment) this);
        ListView lv = (ListView) this.f2012v.findViewById(16908298);
        lv.setFastScrollEnabled(true);
        if (lv.getHeaderViewsCount() == 0) {
            lv.addHeaderView(searchbar);
        }
        setListAdapter(new TCListObject.TCListObjectAdapter(TCDBHelper.getTCListFromDb(String.format("SELECT attendees.id, attendees.firstname || ' ' || attendees.name AS name, attendees.company, attendees.imageurl, attendees.order_value, attendees.company || ' ' || attendees.country || ' ' || IFNULL(GROUP_CONCAT(tagsv2.tag, ' '), '') AS tag FROM attendees LEFT OUTER JOIN tagsv2 ON tagsv2.itemid == attendees.id AND tagsv2.itemtype == 'attendees' WHERE attendees.eventid == '%1$s' GROUP BY attendees.id ORDER BY attendees.firstname COLLATE LOCALIZED, attendees.name COLLATE LOCALIZED", new Object[]{this.eventid}), new TCDBHelper.TCListHelperObject(DBFavorites.KEY_NAME, "company", "imageurl", true)), C0846R.drawable.icon_attendee));
    }

    public void onListItemClick(ListView l, View v, int position, long id) {
        Object o = l.getItemAtPosition(position);
        if (o.getClass() == TCListObject.class) {
            Fragments.add(this, AttendeeDetailFragment.newInstance(((TCListObject) o).getId()), getResourceString(C0846R.string.detail));
        }
    }

    public void click(MenuItem item) {
        switch (item.getItemId()) {
            case 0:
                Fragments.add(this, GroupListFragment.newInstance("parentid", C1199DB.getObject("groups", "eventid == " + this.eventid + " AND name", "attendeecategories").get(DBFavorites.KEY_EVENT_ID)), getString(C0846R.string.categorieen));
                return;
            default:
                return;
        }
    }
}
