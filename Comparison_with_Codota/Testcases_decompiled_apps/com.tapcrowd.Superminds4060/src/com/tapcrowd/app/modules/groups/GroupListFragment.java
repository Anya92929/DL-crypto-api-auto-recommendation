package com.tapcrowd.app.modules.groups;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.p000v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.actionbarsherlock.view.MenuItem;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.android.gms.plus.PlusShare;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.TCListFragment;
import com.tapcrowd.app.modules.attendees.AttendeeDetailFragment;
import com.tapcrowd.app.modules.business.CatalogDetailFragment;
import com.tapcrowd.app.modules.business.CatalogDropDownDetail;
import com.tapcrowd.app.modules.exhibitors.ExhibitorDetailFragment;
import com.tapcrowd.app.modules.exhibitors.ExhibitorListFragment;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import com.tapcrowd.app.modules.map.MapFragment;
import com.tapcrowd.app.modules.map.MapListFragment;
import com.tapcrowd.app.modules.menuitems.MenuFragment;
import com.tapcrowd.app.modules.places.PlaceDetailFragment;
import com.tapcrowd.app.modules.speakers.SpeakerDetailFragment;
import com.tapcrowd.app.utils.AdHelper;
import com.tapcrowd.app.utils.C1199DB;
import com.tapcrowd.app.utils.C1216LO;
import com.tapcrowd.app.utils.C1232UI;
import com.tapcrowd.app.utils.Fragments;
import com.tapcrowd.app.utils.LinkedObjects;
import com.tapcrowd.app.utils.TCListObject;
import com.tapcrowd.app.utils.TCListSeparator;
import com.tapcrowd.app.utils.TCObject;
import com.tapcrowd.app.views.SearchBar;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.apache.cordova.Globalization;

public class GroupListFragment extends TCListFragment implements MenuFragment.MenuItemListener {
    private final int EXHI = 3231;
    Comparator<Object> alfaSort = new Comparator<Object>() {
        public int compare(Object object1, Object object2) {
            try {
                if (object1.getClass() != TCListObject.class && object1.getClass() != String.class) {
                    return -1;
                }
                if (object2.getClass() != TCListObject.class && object2.getClass() != String.class) {
                    return 1;
                }
                String s1 = "";
                String s2 = "";
                if (object1.getClass() == TCListObject.class) {
                    s1 = ((TCListObject) object1).getText();
                }
                if (object2.getClass() == TCListObject.class) {
                    s2 = ((TCListObject) object2).getText();
                }
                if (object1.getClass() == String.class) {
                    s1 = (String) object1;
                }
                if (object2.getClass() == String.class) {
                    s2 = (String) object2;
                }
                return s1.toLowerCase().compareTo(s2.toLowerCase());
            } catch (Exception e) {
                e.printStackTrace();
                return 0;
            }
        }
    };
    /* access modifiers changed from: private */
    public boolean hascoordinates;
    boolean hasimg = false;
    List<Object> listitems;
    String mapid;
    MenuFragment menu;
    private boolean multiplemaps;
    Comparator<Object> orderSort = new Comparator<Object>() {
        public int compare(Object object1, Object object2) {
            try {
                if (object1.getClass() != TCListObject.class) {
                    return -1;
                }
                if (object2.getClass() != TCListObject.class) {
                    return 1;
                }
                int o1 = 0;
                int o2 = 0;
                if (object1.getClass() == TCListObject.class) {
                    o1 = Integer.valueOf(((TCListObject) object1).getOrder()).intValue();
                }
                if (object2.getClass() == TCListObject.class) {
                    o2 = Integer.valueOf(((TCListObject) object2).getOrder()).intValue();
                }
                if (o1 == o2) {
                    return 0;
                }
                if (o1 <= o2) {
                    return 1;
                }
                return -1;
            } catch (Exception e) {
                e.printStackTrace();
                return 0;
            }
        }
    };
    boolean ordered = false;
    List<Object> premiumitems;
    boolean retained;
    private boolean showExhiMenu;
    /* access modifiers changed from: private */
    public boolean showSeparators = true;
    String type;
    String typeid = "0";

    /* renamed from: v */
    View f2044v;

    public static GroupListFragment newInstance() {
        GroupListFragment list = new GroupListFragment();
        list.type = "parentid";
        list.typeid = "0";
        return list;
    }

    public static GroupListFragment newInstance(String type2, String typeid2) {
        GroupListFragment list = new GroupListFragment();
        list.type = type2;
        list.typeid = typeid2;
        return list;
    }

    public static GroupListFragment newInstance(String type2, String typeid2, boolean showExhiMenu2) {
        GroupListFragment list = new GroupListFragment();
        list.type = type2;
        list.typeid = typeid2;
        list.showExhiMenu = showExhiMenu2;
        return list;
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(Globalization.TYPE, this.type);
        outState.putString("typeid", this.typeid);
        outState.putBoolean("showExhiMenu", this.showExhiMenu);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (savedInstanceState != null && this.type == null) {
            this.type = savedInstanceState.getString(Globalization.TYPE);
            this.typeid = savedInstanceState.getString("typeid");
            this.showExhiMenu = savedInstanceState.getBoolean("showExhiMenu");
        }
        if (this.f2044v == null) {
            this.f2044v = inflater.inflate(C0846R.layout.listview, container, false);
        } else {
            ((ViewGroup) this.f2044v.getParent()).removeView(this.f2044v);
            this.retained = true;
        }
        return this.f2044v;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        AdHelper.showAds(this, AdHelper.buildPath("2", "list", (String) null));
        if (!this.retained) {
            ArrayList<MenuFragment.MenuItemContainer> menuitems = new ArrayList<>();
            if (this.showExhiMenu) {
                menuitems.add(new MenuFragment.MenuItemContainer(C1232UI.getColorOverlay((int) C0846R.drawable.icon_exhibitors, C1216LO.getLo(C1216LO.navigationColor)), 3231));
            }
            this.menu = MenuFragment.newInstance(menuitems, this);
            Fragments.addMenu(this, this.menu);
            new LoadListTask(this, (LoadListTask) null).execute(new Void[0]);
        }
    }

    public List<Object> clean(List<Object> list) {
        List<Object> newList = new ArrayList<>();
        for (Object o : list) {
            if (!(o instanceof String)) {
                newList.add(o);
            }
        }
        return newList;
    }

    public void onListItemClick(ListView l, View v, int position, long idd) {
        super.onListItemClick(l, v, position, idd);
        try {
            if (l.getAdapter().getItem(position).getClass() == TCListObject.class) {
                TCListObject tlo = (TCListObject) l.getAdapter().getItem(position);
                if (tlo.showArrow()) {
                    String id = tlo.getId();
                    if (id.startsWith("#")) {
                        Fragments.add(this, newInstance("parentid", id.replace("#", "")), tlo.getText());
                        return;
                    }
                    String[] temp = id.split("%");
                    String type2 = temp[0];
                    String id2 = temp[1];
                    if (type2.equals(LinkedObjects.TABLE_EXHI)) {
                        Fragments.add(this, ExhibitorDetailFragment.newInstance(id2), getResourceString(C0846R.string.detail));
                    } else if (type2.equals(LinkedObjects.TABLE_CAT)) {
                        if (C1199DB.getFirstObject("groupitems", "itemid", id2).get("displaytype", "").equals("dropdown")) {
                            Fragments.add(this, CatalogDropDownDetail.newInstance(id2, 0), getResourceString(C0846R.string.detail));
                        } else {
                            Fragments.add(this, CatalogDetailFragment.newInstance(id2, 0), getResourceString(C0846R.string.detail));
                        }
                    } else if (type2.equals("speaker")) {
                        Fragments.add(this, SpeakerDetailFragment.newInstance(id2), getResourceString(C0846R.string.detail));
                    } else if (type2.equals("places")) {
                        Fragments.add(this, PlaceDetailFragment.newInstance(id2), getResourceString(C0846R.string.detail));
                    } else if (type2.equals(LinkedObjects.TABLE_ATT)) {
                        Fragments.add(this, AttendeeDetailFragment.newInstance(id2), getResourceString(C0846R.string.detail));
                    }
                }
            } else if (this.multiplemaps) {
                Fragments.add(this, MapListFragment.newInstance(this.typeid), this.title);
            } else {
                List<String> list = new ArrayList<>();
                list.add(this.typeid);
                Fragments.add(this, MapFragment.newInstance(this.mapid, list), this.title);
            }
        } catch (Exception e) {
        }
    }

    private class LoadListTask extends AsyncTask<Void, Void, Void> {
        private LoadListTask() {
        }

        /* synthetic */ LoadListTask(GroupListFragment groupListFragment, LoadListTask loadListTask) {
            this();
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            GroupListFragment.this.listitems = new ArrayList();
            GroupListFragment.this.premiumitems = new ArrayList();
            super.onPreExecute();
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(Void... params) {
            List<TCObject> groups = new ArrayList<>();
            if (GroupListFragment.this.type.equals("parentid")) {
                groups = C1199DB.getQueryFromDb("SELECT g.id, g.name, g.imageurl, g.order_value, count(gi.id) + count(gc.id) AS children FROM groups g LEFT JOIN groups gc ON gc.parentid = g.id LEFT JOIN groupitems gi ON gi.groupid = g.id WHERE g.parentid = " + GroupListFragment.this.typeid + " GROUP BY g.id ORDER BY g.order_value +0 DESC, g.name COLLATE NOCASE");
            }
            if (GroupListFragment.this.type.equals("groupitemsid")) {
                groups = C1199DB.getQueryFromDb("SELECT g.id, g.name, g.imageurl, g.order_value FROM groups g LEFT JOIN groupitems ON groupitems.groupid= g.id WHERE groupitems.itemid = " + GroupListFragment.this.typeid + " ORDER BY g.order_value +0 DESC, g.name COLLATE NOCASE");
            }
            if (GroupListFragment.this.type.equals("parentid")) {
                if (!C1199DB.getQueryFromDb(String.format("SELECT SUM(num) AS total FROM (SELECT COUNT(groups.imageurl) AS num FROM groups WHERE parentid = '%1$s' AND imageurl IS NOT NULL AND imageurl != '' UNION SELECT COUNT(catalog.imagethumb) AS num FROM catalog INNER JOIN groupitems ON catalog.id = groupitems.itemid WHERE  groupitems.groupid = '%1$s' AND imageurl IS NOT NULL AND imageurl != '' UNION SELECT COUNT(exhibitors.imageurl) AS num FROM exhibitors INNER JOIN groupitems ON exhibitors.id = groupitems.itemid WHERE  groupitems.groupid = '%1$s' AND imageurl IS NOT NULL AND imageurl != '')", new Object[]{GroupListFragment.this.typeid})).get(0).get("total").equals("0")) {
                    GroupListFragment.this.hasimg = true;
                }
            }
            if (groups.size() < 20) {
                GroupListFragment.this.showSeparators = false;
            }
            if (groups.size() > 0 && !groups.get(0).get("order_value", "0").equals("0")) {
                GroupListFragment.this.ordered = true;
            }
            for (TCObject group : groups) {
                boolean arrow = true;
                if (group.has("children") && group.get("children").equals("0")) {
                    arrow = false;
                }
                if (group.has(DBFavorites.KEY_NAME)) {
                    String newsep = group.get(DBFavorites.KEY_NAME, "").substring(0, 1).toUpperCase();
                    if (group.has("order_value") && !group.get("order_value").equals("0")) {
                        GroupListFragment.this.showSeparators = false;
                    }
                    if (!GroupListFragment.this.listitems.contains(newsep) && GroupListFragment.this.showSeparators) {
                        GroupListFragment.this.listitems.add(newsep);
                    }
                }
                GroupListFragment.this.listitems.add(new TCListObject("#" + group.get(DBFavorites.KEY_EVENT_ID), group.get(DBFavorites.KEY_NAME), (String) null, (String) null, group.get("imageurl", ""), Boolean.valueOf(arrow)).setOrder(group.get("order_value", "0")));
            }
            List<TCObject> items = C1199DB.getListFromDb("groupitems", "groupid", GroupListFragment.this.typeid);
            if (groups.size() + items.size() < 20) {
                GroupListFragment.this.showSeparators = false;
            }
            for (TCObject item : items) {
                try {
                    GroupListFragment.this.addListObject(item);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Void result) {
            int i;
            GroupListFragment.this.getListView().setFastScrollEnabled(true);
            List<Object> temp = new ArrayList<>();
            if (GroupListFragment.this.hascoordinates) {
                temp.add(0, new Object());
            }
            temp.addAll(GroupListFragment.this.premiumitems);
            if (!GroupListFragment.this.ordered) {
                Collections.sort(GroupListFragment.this.listitems, GroupListFragment.this.alfaSort);
            } else {
                Collections.sort(GroupListFragment.this.listitems, GroupListFragment.this.orderSort);
            }
            if (!GroupListFragment.this.showSeparators) {
                GroupListFragment.this.listitems = clean(GroupListFragment.this.listitems);
            }
            temp.addAll(GroupListFragment.this.listitems);
            if (GroupListFragment.this.isAdded()) {
                ((ListView) GroupListFragment.this.f2044v.findViewById(16908298)).addHeaderView(new SearchBar((Context) GroupListFragment.this.getActivity(), (ListFragment) GroupListFragment.this));
                if (GroupListFragment.this.hasimg) {
                    i = C0846R.drawable.l_def_exhibitors;
                } else {
                    i = 0;
                }
                TCListObject.TCListObjectAdapter adapter = new TCListObject.TCListObjectAdapter(temp, i);
                adapter.setLayout(C0846R.layout.cell_tcobject_two_lines);
                GroupListFragment.this.setListAdapter(adapter);
            }
            GroupListFragment.this.menu.stopLoader();
        }

        public List<Object> clean(List<Object> list) {
            List<Object> newList = new ArrayList<>();
            for (Object o : list) {
                if (!(o instanceof String) && !(o instanceof TCListSeparator)) {
                    newList.add(o);
                }
            }
            return newList;
        }
    }

    public ListView getListView() {
        return (ListView) this.f2044v.findViewById(16908298);
    }

    /* access modifiers changed from: private */
    public void addListObject(TCObject item) {
        String table = item.get("itemtable");
        String id = item.get("itemid");
        String baseurl = String.valueOf(getString(C0846R.string.baseimgurl)) + "upload/android/";
        if (table.equalsIgnoreCase(LinkedObjects.TABLE_EXHI)) {
            TCObject tco = C1199DB.getObject(DBFavorites.TABLE_EXHIBITORS, DBFavorites.KEY_EVENT_ID, id);
            if (!tco.get("order_value", "0").equals("0")) {
                this.ordered = true;
            }
            TCObject premium = C1199DB.getObject("premium", "tablename == 'exhibitor' AND tableId", id);
            String booth = null;
            if (tco.has("booth")) {
                booth = String.valueOf(getString(C0846R.string.location)) + (getString(C0846R.string.location).length() == 0 ? "" : MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR) + tco.get("booth", "");
            }
            if (!tco.get("x1", "0").equals("0") && !tco.get("y1", "0").equals("0")) {
                this.hascoordinates = true;
                if (this.mapid != null && !this.mapid.equals(tco.get("mapid"))) {
                    this.multiplemaps = true;
                }
                this.mapid = tco.get("mapid");
            }
            TCListObject temp = new TCListObject("exhibitor%" + id, tco.get(DBFavorites.KEY_NAME, ""), booth, premium.get("extraline"), tco.get("imageurl", ""), (Boolean) true);
            if (premium.has("ispremium")) {
                temp.ispremium = true;
                this.premiumitems.add(temp);
                String sep = C1199DB.getFirstObject("premium", "tableId", id).get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, "*");
                this.showSeparators = true;
                if (!this.premiumitems.contains(sep)) {
                    this.premiumitems.add(0, sep);
                }
            }
            if (tco.has(DBFavorites.KEY_NAME)) {
                String newsep = tco.get(DBFavorites.KEY_NAME, "").substring(0, 1).toUpperCase();
                if (!this.listitems.contains(newsep)) {
                    this.listitems.add(newsep);
                }
                this.listitems.add(temp.setOrder(tco.get("order_value", "0")));
            }
        } else if (table.equalsIgnoreCase(LinkedObjects.TABLE_CAT)) {
            TCObject tco2 = C1199DB.getObject(LinkedObjects.TABLE_CAT, DBFavorites.KEY_EVENT_ID, id);
            if (!tco2.has(Globalization.TYPE)) {
                if (!tco2.get("order_value", "0").equals("0")) {
                    this.ordered = true;
                }
                TCObject premium2 = C1199DB.getObject("premium", "tablename == 'catalog' AND tableId", id);
                String img = "";
                if (tco2.has("imageurl")) {
                    this.hasimg = true;
                    img = tco2.get("imageurl");
                }
                if (tco2.has(DBFavorites.KEY_NAME)) {
                    String newsep2 = tco2.get(DBFavorites.KEY_NAME, "").substring(0, 1).toUpperCase();
                    if (!this.listitems.contains(newsep2)) {
                        this.listitems.add(newsep2);
                    }
                }
                if (premium2.get("ispremium", "0").equalsIgnoreCase("1")) {
                    TCListSeparator tCListSeparator = new TCListSeparator(C1199DB.getFirstObject("premium", "tableId", id).get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, "*"), true);
                    this.showSeparators = true;
                    if (!this.premiumitems.contains(tCListSeparator)) {
                        this.premiumitems.add(0, tCListSeparator);
                    }
                    this.premiumitems.add(new TCListObject("catalog%" + id, premium2.get("ispremium", "0").equalsIgnoreCase("1"), tco2.get(DBFavorites.KEY_NAME, ""), premium2.get("extraline"), (String) null, img));
                }
                this.listitems.add(new TCListObject("catalog%" + id, premium2.get("ispremium", "0").equalsIgnoreCase("1"), tco2.get(DBFavorites.KEY_NAME, ""), (String) null, (String) null, img).setOrder(tco2.get("order_value", "0")));
            }
        } else if (table.equals("event")) {
            TCObject tco3 = C1199DB.getObject("events", DBFavorites.KEY_EVENT_ID, id);
            String img2 = String.valueOf(baseurl) + "i_event.png";
            if (tco3.has("thumblogo")) {
                img2 = tco3.get("thumblogo");
            }
            this.listitems.add(new TCListObject("events%" + id, tco3.get(DBFavorites.KEY_NAME), "", "", img2));
        } else if (table.equals("newsitem")) {
            TCObject tco4 = C1199DB.getObject("news", DBFavorites.KEY_EVENT_ID, id);
            String img3 = String.valueOf(baseurl) + "i_tag.png";
            if (tco4.has("image")) {
                img3 = tco4.get("image");
            }
            this.listitems.add(new TCListObject("news%" + id, tco4.get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE), "", "", img3));
        } else if (table.equals("session")) {
            TCObject tco5 = C1199DB.getObject("sessions", DBFavorites.KEY_EVENT_ID, id);
            String img4 = String.valueOf(baseurl) + "i_tag.png";
            if (tco5.has("imagethumb")) {
                img4 = tco5.get("imagethumb");
            }
            this.listitems.add(new TCListObject("sessions%" + id, tco5.get(DBFavorites.KEY_NAME), "", "", img4));
        } else if (table.equals(LinkedObjects.TABLE_ATT)) {
            TCObject tco6 = C1199DB.getObject(LinkedObjects.TABLE_ATT, DBFavorites.KEY_EVENT_ID, id);
            this.listitems.add(new TCListObject("attendees%" + id, String.valueOf(tco6.get("firstname")) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + tco6.get(DBFavorites.KEY_NAME), tco6.get("company"), (String) null, "", (int) C0846R.drawable.icon_attendee));
        } else if (table.equals("sponsor")) {
            TCObject tco7 = C1199DB.getObject("sponsors", DBFavorites.KEY_EVENT_ID, id);
            String img5 = String.valueOf(baseurl) + "i_sponsor.png";
            if (tco7.has("image")) {
                img5 = tco7.get("image");
            }
            this.listitems.add(new TCListObject("sponsors%=" + id, tco7.get(DBFavorites.KEY_NAME), "", "", img5));
        } else if (table.equals("venue")) {
            TCObject tco8 = C1199DB.getObject("venues", DBFavorites.KEY_EVENT_ID, id);
            String img6 = String.valueOf(baseurl) + "i_venue.png";
            if (tco8.has("image1")) {
                img6 = tco8.get("image1");
            }
            this.listitems.add(new TCListObject("venues%" + id, tco8.get(DBFavorites.KEY_NAME), "", "", img6));
        } else if (table.equals("speaker")) {
            TCObject tco9 = C1199DB.getObject("speakers", DBFavorites.KEY_EVENT_ID, id);
            if (tco9.has(DBFavorites.KEY_NAME)) {
                this.listitems.add(new TCListObject("speaker%" + id, tco9.get(DBFavorites.KEY_NAME), tco9.get("company"), (String) null, tco9.get("imagethumb")));
            }
        } else if (table.equals("tc_places")) {
            this.listitems.add(new TCListObject("places%" + id, C1199DB.getObject("places", DBFavorites.KEY_EVENT_ID, id).get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE), (String) null, (String) null, (String) null));
        }
    }

    public void click(MenuItem item) {
        TCObject launcher = C1199DB.getFirstObject("launchers", "moduletypeid", "2");
        if (item.getItemId() == 3231) {
            Fragments.add(this, ExhibitorListFragment.newInstance(launcher.get("eventid")), launcher.get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE));
        }
    }
}
