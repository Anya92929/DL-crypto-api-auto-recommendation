package com.tapcrowd.app.modules.speakers;

import android.content.Context;
import android.os.Bundle;
import android.support.p000v4.app.ListFragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.actionbarsherlock.view.MenuItem;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.TCListFragment;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import com.tapcrowd.app.modules.menuitems.MenuFragment;
import com.tapcrowd.app.utils.AdHelper;
import com.tapcrowd.app.utils.App;
import com.tapcrowd.app.utils.C1199DB;
import com.tapcrowd.app.utils.C1216LO;
import com.tapcrowd.app.utils.C1232UI;
import com.tapcrowd.app.utils.Fragments;
import com.tapcrowd.app.utils.TCDBHelper;
import com.tapcrowd.app.utils.TCListObject;
import com.tapcrowd.app.utils.TCObject;
import com.tapcrowd.app.views.SearchBar;
import java.util.ArrayList;
import java.util.List;

public class SpeakerListFragment extends TCListFragment implements MenuFragment.MenuItemListener {
    final int VIEWTYPE = 1275;
    boolean retained;
    SearchBar search;
    String sessionid;
    List<MenuFragment.SubMenuContainer> submenu = new ArrayList();

    /* renamed from: v */
    View f2119v;

    public static SpeakerListFragment newInstance() {
        return new SpeakerListFragment();
    }

    public static SpeakerListFragment newInstance(String sessionid2) {
        SpeakerListFragment fragment = new SpeakerListFragment();
        fragment.sessionid = sessionid2;
        return fragment;
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("sessionid", this.sessionid);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (this.f2119v == null) {
            this.f2119v = inflater.inflate(C0846R.layout.listview, container, false);
        } else {
            ((ViewGroup) this.f2119v.getParent()).removeView(this.f2119v);
            this.retained = true;
        }
        return this.f2119v;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null && this.sessionid == null) {
            this.sessionid = savedInstanceState.getString("sessionid");
        }
        AdHelper.showAds(this, AdHelper.buildPath("40", "list", (String) null));
        setupMenu();
        if (!this.retained) {
            setupListView();
        }
    }

    public void setupListView() {
        setupListView(1);
    }

    public void setupListView(int groupid) {
        String imgquery;
        String query;
        if (!App.tablet) {
            String title = "";
            for (MenuFragment.SubMenuContainer sub : this.submenu) {
                if (sub.getId() == groupid) {
                    title = sub.getTitle();
                }
            }
            if (groupid == 1) {
                title = this.title;
            }
            String color = Integer.toHexString(C1216LO.getLo(C1216LO.navigationColor));
            if (color.length() == 8) {
                color = color.substring(2);
            }
            getSherlockActivity().getSupportActionBar().setTitle((CharSequence) Html.fromHtml("<font color='#" + color + "'>" + title + "</font>"));
        }
        String where = groupid == 1 ? "speakers.id LIKE '%'" : "speakers.id IN (SELECT itemid FROM groupitems WHERE itemtable == 'speaker' AND groupid == '" + groupid + "')";
        boolean img = false;
        if (this.sessionid != null) {
            imgquery = "SELECT count(*) AS num FROM speakers INNER JOIN speaker_session ON speakers.id == speaker_session.speakerid AND speaker_session.sessionid == '" + this.sessionid + "' " + "WHERE speakers.imageurl IS NOT NULL AND speakers.imageurl != '' AND " + where;
        } else {
            imgquery = "SELECT count(*) AS num FROM speakers WHERE eventid == '" + App.curEventId + "' AND imageurl IS NOT NULL AND imageurl != '' AND " + where;
        }
        List<TCObject> images = C1199DB.getQueryFromDb(imgquery);
        if (images.size() > 0) {
            img = !images.get(0).get("num").equals("0");
        }
        if (this.sessionid != null) {
            query = String.format("SELECT speakers.id, speakers.name, speakers.company, speakers.imageurl, speakers.order_value , GROUP_CONCAT(tagsv2.tag, ' ') AS tag FROM speakers INNER JOIN speaker_session ON speakers.id == speaker_session.speakerid AND speaker_session.sessionid == '%1$s' LEFT OUTER JOIN tagsv2 ON speakers.id == tagsv2.itemid AND tagsv2.itemtype == 'speaker' WHERE %2$s GROUP BY speakers.id ORDER BY speakers.order_value +0 DESC, speakers.name", new Object[]{this.sessionid, where});
        } else {
            query = String.format("SELECT speakers.id, speakers.name, speakers.company, speakers.imageurl, speakers.order_value , GROUP_CONCAT(tagsv2.tag, ' ') AS tag FROM speakers LEFT OUTER JOIN tagsv2 ON speakers.id == tagsv2.itemid AND tagsv2.itemtype == 'speaker' WHERE speakers.eventid == '%1$s' AND %2$s GROUP BY speakers.id ORDER BY order_value +0 DESC, name COLLATE NOCASE", new Object[]{App.curEventId, where});
        }
        List<Object> list = TCDBHelper.getTCListFromDb(query, new TCDBHelper.TCListHelperObject(DBFavorites.KEY_NAME, "company", "imageurl", true));
        C1232UI.getColorOverlay((int) C0846R.drawable.l_def_exhibitors, C1216LO.getLo(C1216LO.placeholderOverlayColor));
        setListAdapter((ListAdapter) null);
        if (this.search == null) {
            this.search = new SearchBar((Context) getActivity(), (ListFragment) this);
            getListView().addHeaderView(this.search);
        }
        this.search.getSearch().setText("");
        setListAdapter(new TCListObject.TCListObjectAdapter(list, img ? C0846R.drawable.l_def_exhibitors : 0));
        ((TCListObject.TCListObjectAdapter) getListAdapter()).notifyDataSetChanged();
    }

    public void onResume() {
        super.onResume();
    }

    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        if (l.getAdapter().getItem(position) instanceof TCListObject) {
            Fragments.add(this, SpeakerDetailFragment.newInstance(((TCListObject) l.getAdapter().getItem(position)).getId()), getString(C0846R.string.detail));
        }
    }

    public void setupMenu() {
        ArrayList<MenuFragment.MenuItemContainer> menuitems = new ArrayList<>();
        List<TCObject> categories = C1199DB.getQueryFromDb("SELECT id, name FROM groups WHERE parentid IN (SELECT id FROM groups WHERE name == 'speakercategories') ORDER BY name COLLATE NOCASE");
        if (categories.size() > 0) {
            this.submenu = new ArrayList();
            this.submenu.add(new MenuFragment.SubMenuContainer(1, 0, getResourceString(C0846R.string.all)));
            int len = categories.size();
            for (int i = 0; i < len; i++) {
                this.submenu.add(new MenuFragment.SubMenuContainer(Integer.parseInt(categories.get(i).get(DBFavorites.KEY_EVENT_ID)), i + 1, categories.get(i).get(DBFavorites.KEY_NAME)));
            }
            menuitems.add(new MenuFragment.MenuItemContainer(C1232UI.getColorOverlay((int) C0846R.drawable.icon_categories_navbar, C1216LO.getLo(C1216LO.navigationColor)), this.submenu));
        }
        Fragments.addMenu(this, MenuFragment.newInstance(menuitems, this));
    }

    public void click(MenuItem item) {
        int itemid = item.getItemId();
        if (this.submenu != null) {
            for (MenuFragment.SubMenuContainer sub : this.submenu) {
                if (sub.getId() == itemid) {
                    setupListView(itemid);
                }
            }
        }
    }
}
