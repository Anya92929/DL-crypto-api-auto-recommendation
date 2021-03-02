package com.tapcrowd.app.modules.groups;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.p000v4.view.PagerAdapter;
import android.support.p000v4.view.ViewPager;
import android.text.Html;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.TCFragment;
import com.tapcrowd.app.modules.business.CatalogDetailFragment;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import com.tapcrowd.app.utils.AdHelper;
import com.tapcrowd.app.utils.C1199DB;
import com.tapcrowd.app.utils.C1232UI;
import com.tapcrowd.app.utils.Fragments;
import com.tapcrowd.app.utils.LinkedObjects;
import com.tapcrowd.app.utils.TCListObject;
import com.tapcrowd.app.utils.TCObject;
import com.tapcrowd.app.utils.images.FastImageLoader;
import com.tapcrowd.app.views.SearchBar;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GroupListRestoFragment extends TCFragment implements ViewPager.OnPageChangeListener {
    List<TCObject> content;
    String module;
    Comparator<Object> orderSort = new Comparator<Object>() {
        public int compare(Object object1, Object object2) {
            try {
                if (object1.getClass() != TCObject.class) {
                    return -1;
                }
                if (object2.getClass() != TCObject.class) {
                    return 1;
                }
                int o1 = 0;
                int o2 = 0;
                if (object1.getClass() == TCObject.class) {
                    o1 = Integer.valueOf(((TCObject) object1).get("order_value")).intValue();
                }
                if (object2.getClass() == TCObject.class) {
                    o2 = Integer.valueOf(((TCObject) object2).get("order_value")).intValue();
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
    TCObject parent;
    SearchBar search;
    String type;

    public static GroupListRestoFragment newInstance() {
        GroupListRestoFragment fr = new GroupListRestoFragment();
        fr.parent = C1199DB.getObject("groups", "parentid", "0");
        return fr;
    }

    public static GroupListRestoFragment newInstance(String parentid) {
        GroupListRestoFragment fr = new GroupListRestoFragment();
        fr.parent = C1199DB.getObject("groups", DBFavorites.KEY_EVENT_ID, parentid);
        return fr;
    }

    public static GroupListRestoFragment newInstance(String type2, String module2) {
        GroupListRestoFragment fr = new GroupListRestoFragment();
        fr.type = type2;
        fr.module = module2;
        return fr;
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(DBFavorites.KEY_EVENT_ID, this.parent.get(DBFavorites.KEY_EVENT_ID));
    }

    public void onResume() {
        super.onResume();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (this.f2005v == null) {
            this.f2005v = inflater.inflate(C0846R.layout.resto_catalog, container, false);
        } else {
            ((ViewGroup) this.f2005v.getParent()).removeView(this.f2005v);
            this.retained = true;
        }
        if (savedInstanceState != null && this.parent == null) {
            this.parent = C1199DB.getObject("groups", DBFavorites.KEY_EVENT_ID, savedInstanceState.getString(DBFavorites.KEY_EVENT_ID));
        }
        return this.f2005v;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        AdHelper.showAds(this, AdHelper.buildPath("52", "list", (String) null));
        if (!this.retained) {
            if (this.parent != null) {
                this.type = this.parent.get("displaytype", "list");
                String parentid = this.parent.get(DBFavorites.KEY_EVENT_ID);
                boolean order = false;
                this.content = C1199DB.getListFromDb("groups", "parentid", parentid, "order_value +0 DESC, name");
                int len = this.content.size();
                for (int i = 0; i < len; i++) {
                    this.content.get(i).vars.put("table", "group");
                    if (!order && !this.content.get(i).get("order_value", "0").equals("0")) {
                        order = true;
                    }
                }
                for (TCObject groupitem : C1199DB.getListFromDb("groupitems", "groupid", parentid)) {
                    TCObject item = C1199DB.getObject(groupitem.get("itemtable"), DBFavorites.KEY_EVENT_ID, groupitem.get("itemid"));
                    item.vars.put("table", groupitem.get("itemtable"));
                    this.content.add(item);
                    if (!order && !item.get("order_value", "0").equals("0")) {
                        order = true;
                    }
                }
                if (order) {
                    Collections.sort(this.content, this.orderSort);
                }
            } else if (this.module != null) {
                this.content = C1199DB.getListFromDb(LinkedObjects.TABLE_CAT, "LOWER(type)", this.module.toLowerCase(), "order_value +0, name COLLATE NOCASE");
                int len2 = this.content.size();
                for (int i2 = 0; i2 < len2; i2++) {
                    this.content.get(i2).vars.put("table", LinkedObjects.TABLE_CAT);
                }
            }
            if (this.type.equals("menu") || this.type.equals("slider") || this.type.equals("team")) {
                showSlider();
            } else if (this.type.equals("list")) {
                showMenu();
            } else if (this.type.equals("thumbs")) {
                showThumbs();
            }
        }
    }

    public void showSlider() {
        findViewById(C0846R.C0847id.vpcontainer).setVisibility(0);
        ViewPager vp = (ViewPager) findViewById(C0846R.C0847id.f1996vp);
        vp.setAdapter(new CatalogViewpageAdapter(this.content));
        vp.setOnPageChangeListener(this);
        LinearLayout markers = (LinearLayout) findViewById(C0846R.C0847id.markers);
        int i = 0;
        int len = this.content.size();
        while (i < len) {
            ImageView iv = new ImageView(getActivity());
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(-2, -2);
            lp.leftMargin = 2;
            lp.rightMargin = 2;
            iv.setLayoutParams(lp);
            iv.setBackgroundDrawable(getResources().getDrawable(i == 0 ? C0846R.drawable.viewpager_marker_active : C0846R.drawable.viewpager_marker_inactive));
            markers.addView(iv);
            i++;
        }
    }

    @SuppressLint({"UseSparseArrays"})
    public void showMenu() {
        int i;
        List<Object> tclo = new ArrayList<>();
        boolean hasImg = false;
        for (TCObject item : this.content) {
            String name = "";
            if (item.has("prefix")) {
                name = String.valueOf(name) + item.get("prefix") + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
            }
            if (item.has(DBFavorites.KEY_NAME)) {
                name = String.valueOf(name) + item.get(DBFavorites.KEY_NAME);
            }
            if (!item.get("price", "null").equals("null") && !item.get("price", "").equals("0.00")) {
                name = String.valueOf(name) + item.get("price") + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
            }
            if (item.has("unit")) {
                name = String.valueOf(name) + item.get("unit");
            }
            if (item.has("imagethumb") || item.has("imageurl")) {
                hasImg = true;
            }
            tclo.add(new TCListObject(String.valueOf(item.get(DBFavorites.KEY_EVENT_ID)) + ":" + item.get("table"), name, (String) null, (String) null, item.get("imageurl", item.get("imagethumb", ""))));
        }
        if (hasImg) {
            i = C0846R.drawable.icon_categories_black;
        } else {
            i = 0;
        }
        final TCListObject.TCListObjectAdapter adapter = new TCListObject.TCListObjectAdapter(tclo, i);
        ListView lv = (ListView) findViewById(C0846R.C0847id.list);
        if (this.search == null) {
            this.search = new SearchBar((Context) getActivity(), (SearchBar.TextChangedListener) new SearchBar.TextChangedListener() {
                public void textChanged(CharSequence s, int count) {
                    adapter.getFilter().filter(s);
                }
            });
            lv.addHeaderView(this.search);
        }
        lv.setAdapter(adapter);
        lv.setVisibility(0);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                TCListObject to = (TCListObject) arg0.getItemAtPosition(arg2);
                String table = to.getId().split(":")[1];
                String id = to.getId().split(":")[0];
                if (table.equalsIgnoreCase(LinkedObjects.TABLE_CAT)) {
                    GroupListRestoFragment groupListRestoFragment = GroupListRestoFragment.this;
                    groupListRestoFragment.analytics = String.valueOf(groupListRestoFragment.analytics) + "/group/" + GroupListRestoFragment.this.parent.get(DBFavorites.KEY_EVENT_ID);
                    Fragments.add(GroupListRestoFragment.this, CatalogDetailFragment.newInstance(id, (String) null), GroupListRestoFragment.this.getResourceString(C0846R.string.detail));
                } else if (C1199DB.getSize("groupitems", "groupid", id) + C1199DB.getSize("groups", "parentid", id) != 0) {
                    GroupListRestoFragment groupListRestoFragment2 = GroupListRestoFragment.this;
                    groupListRestoFragment2.analytics = String.valueOf(groupListRestoFragment2.analytics) + "/group/" + GroupListRestoFragment.this.parent.get(DBFavorites.KEY_EVENT_ID);
                    Fragments.add(GroupListRestoFragment.this, GroupListRestoFragment.newInstance(id), to.getText());
                }
            }
        });
    }

    public void showThumbs() {
        if (this.content.size() == 0) {
            C1232UI.show(C0846R.C0847id.empty);
            ((ImageView) findViewById(C0846R.C0847id.emptyicon)).setImageResource(C0846R.drawable.photo_default);
            ((TextView) findViewById(C0846R.C0847id.emptytitle)).setText("No Photos");
            ((TextView) findViewById(C0846R.C0847id.emptysub)).setText("This photo set contains no photos.");
            return;
        }
        GridView grid = (GridView) findViewById(C0846R.C0847id.grid);
        grid.setVisibility(0);
        grid.setAdapter(new ThumbsAdapter(this.content));
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                TCObject to = (TCObject) arg0.getAdapter().getItem(arg2);
                if (to.get("table").equalsIgnoreCase(LinkedObjects.TABLE_CAT)) {
                    GroupListRestoFragment groupListRestoFragment = GroupListRestoFragment.this;
                    groupListRestoFragment.analytics = String.valueOf(groupListRestoFragment.analytics) + "/group/" + GroupListRestoFragment.this.parent.get(DBFavorites.KEY_EVENT_ID);
                    Fragments.add(GroupListRestoFragment.this, CatalogDetailFragment.newInstance(to.get(DBFavorites.KEY_EVENT_ID), (String) null), GroupListRestoFragment.this.getResourceString(C0846R.string.detail));
                } else if (C1199DB.getSize("groupitems", "groupid", to.get(DBFavorites.KEY_EVENT_ID)) + C1199DB.getSize("groups", "parentid", to.get(DBFavorites.KEY_EVENT_ID)) != 0) {
                    GroupListRestoFragment groupListRestoFragment2 = GroupListRestoFragment.this;
                    groupListRestoFragment2.analytics = String.valueOf(groupListRestoFragment2.analytics) + "/group/" + GroupListRestoFragment.this.parent.get(DBFavorites.KEY_EVENT_ID);
                    Fragments.add(GroupListRestoFragment.this, GroupListRestoFragment.newInstance(to.get(DBFavorites.KEY_EVENT_ID)), to.get(DBFavorites.KEY_NAME));
                }
            }
        });
    }

    private class CatalogViewpageAdapter extends PagerAdapter {

        /* renamed from: il */
        FastImageLoader f2045il = new FastImageLoader();

        /* renamed from: li */
        LayoutInflater f2046li;
        List<TCObject> tco;

        public CatalogViewpageAdapter(List<TCObject> tco2) {
            this.tco = tco2;
            this.f2046li = GroupListRestoFragment.this.getActivity().getLayoutInflater();
        }

        public CharSequence getPageTitle(int position) {
            return this.tco.get(position).get(DBFavorites.KEY_NAME);
        }

        public int getCount() {
            return this.tco.size();
        }

        public Object instantiateItem(ViewGroup collection, int position) {
            final String img;
            View view = this.f2046li.inflate(C0846R.layout.cell_catalog_viepager, (ViewGroup) null);
            final TCObject to = this.tco.get(position);
            TextView tv = (TextView) view.findViewById(C0846R.C0847id.text);
            String name = "";
            if (to.has("prefix")) {
                name = String.valueOf(name) + to.get("prefix") + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
            }
            if (to.has(DBFavorites.KEY_NAME)) {
                name = String.valueOf(name) + to.get(DBFavorites.KEY_NAME);
            }
            if (!to.get("price", "0.00").equals("0.00")) {
                name = String.valueOf(name) + to.get("price") + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
            }
            if (to.has("unit")) {
                name = String.valueOf(name) + to.get("unit");
            }
            tv.setText(Html.fromHtml(name).toString());
            final ImageView iv = (ImageView) view.findViewById(C0846R.C0847id.image);
            if (!to.get("imageurl", "").startsWith("http")) {
                img = String.valueOf(GroupListRestoFragment.this.getResourceString(C0846R.string.baseimgurl)) + to.get("imageurl", "");
            } else {
                img = to.get("imageurl", "");
            }
            iv.post(new Runnable() {
                public void run() {
                    CatalogViewpageAdapter.this.f2045il.DisplayImage(img, iv, iv.getHeight(), iv.getWidth());
                }
            });
            view.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if (to.get("table").equalsIgnoreCase(LinkedObjects.TABLE_CAT)) {
                        if (GroupListRestoFragment.this.parent != null) {
                            GroupListRestoFragment access$0 = GroupListRestoFragment.this;
                            access$0.analytics = String.valueOf(access$0.analytics) + "/group/" + GroupListRestoFragment.this.parent.get(DBFavorites.KEY_EVENT_ID);
                        }
                        Fragments.add(GroupListRestoFragment.this, CatalogDetailFragment.newInstance(to.get(DBFavorites.KEY_EVENT_ID), (String) null), GroupListRestoFragment.this.getResourceString(C0846R.string.detail));
                    } else if (C1199DB.getSize("groupitems", "groupid", to.get(DBFavorites.KEY_EVENT_ID)) + C1199DB.getSize("groups", "parentid", to.get(DBFavorites.KEY_EVENT_ID)) != 0) {
                        if (GroupListRestoFragment.this.parent != null) {
                            GroupListRestoFragment access$02 = GroupListRestoFragment.this;
                            access$02.analytics = String.valueOf(access$02.analytics) + "/group/" + GroupListRestoFragment.this.parent.get(DBFavorites.KEY_EVENT_ID);
                        }
                        Fragments.add(GroupListRestoFragment.this, GroupListRestoFragment.newInstance(to.get(DBFavorites.KEY_EVENT_ID)), to.get(DBFavorites.KEY_NAME));
                    }
                }
            });
            collection.addView(view);
            return view;
        }

        public void destroyItem(View collection, int position, Object view) {
            ((ViewPager) collection).removeView((View) view);
        }

        public boolean isViewFromObject(View view, Object object) {
            return view == ((View) object);
        }

        public void finishUpdate(View arg0) {
        }

        public void restoreState(Parcelable arg0, ClassLoader arg1) {
        }

        public Parcelable saveState() {
            return null;
        }

        public void startUpdate(View arg0) {
        }
    }

    private class ThumbsAdapter extends BaseAdapter {

        /* renamed from: il */
        FastImageLoader f2047il = new FastImageLoader();
        List<TCObject> list;
        int width;

        public ThumbsAdapter(List<TCObject> list2) {
            DisplayMetrics metrics = new DisplayMetrics();
            GroupListRestoFragment.this.getActivity().getWindowManager().getDefaultDisplay().getMetrics(metrics);
            this.width = (metrics.widthPixels / 4) - 12;
            List<TCObject> newList = new ArrayList<>();
            for (TCObject item : list2) {
                newList.add(item);
            }
            this.list = newList;
        }

        public int getCount() {
            return this.list.size();
        }

        public Object getItem(int arg0) {
            return this.list.get(arg0);
        }

        public long getItemId(int arg0) {
            return Long.parseLong(this.list.get(arg0).get(DBFavorites.KEY_EVENT_ID));
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            LinearLayout linearLayout;
            ImageView view;
            if (convertView == null) {
                linearLayout = new LinearLayout(GroupListRestoFragment.this.getActivity());
                linearLayout.setLayoutParams(new AbsListView.LayoutParams(-2, -2));
                linearLayout.setBackgroundResource(C0846R.drawable.resto_stroke_thumbs);
                linearLayout.setPadding(3, 3, 3, 3);
                view = new ImageView(GroupListRestoFragment.this.getActivity());
                linearLayout.addView(view);
                view.setLayoutParams(new LinearLayout.LayoutParams(this.width, this.width));
            } else {
                linearLayout = (LinearLayout) convertView;
                view = (ImageView) linearLayout.getChildAt(0);
            }
            TCObject item = this.list.get(position);
            this.f2047il.DisplayImage(item.get("imagethumb", item.get("imageurl", "")), view, this.width - 6, this.width - 6);
            return linearLayout;
        }
    }

    public View findViewById(int id) {
        return getView().findViewById(id);
    }

    public void onPageScrollStateChanged(int arg0) {
    }

    public void onPageScrolled(int arg0, float arg1, int arg2) {
    }

    public void onPageSelected(int position) {
        LinearLayout markers = (LinearLayout) findViewById(C0846R.C0847id.markers);
        int i = 0;
        int len = markers.getChildCount();
        while (i < len) {
            ((ImageView) markers.getChildAt(i)).setBackgroundDrawable(getResources().getDrawable(i == position ? C0846R.drawable.viewpager_marker_active : C0846R.drawable.viewpager_marker_inactive));
            i++;
        }
    }
}
