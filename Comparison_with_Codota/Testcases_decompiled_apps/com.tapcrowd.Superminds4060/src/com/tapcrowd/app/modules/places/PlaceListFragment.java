package com.tapcrowd.app.modules.places;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.p000v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.ListView;
import com.actionbarsherlock.view.MenuItem;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.plus.PlusShare;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.TCListFragment;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import com.tapcrowd.app.modules.filter.FilterFragment;
import com.tapcrowd.app.modules.menuitems.MenuFragment;
import com.tapcrowd.app.utils.AdHelper;
import com.tapcrowd.app.utils.C1199DB;
import com.tapcrowd.app.utils.C1216LO;
import com.tapcrowd.app.utils.C1232UI;
import com.tapcrowd.app.utils.Converter;
import com.tapcrowd.app.utils.Fragments;
import com.tapcrowd.app.utils.IconProvider;
import com.tapcrowd.app.utils.OnFragmentResultListener;
import com.tapcrowd.app.utils.TCDBHelper;
import com.tapcrowd.app.utils.TCListObject;
import com.tapcrowd.app.utils.TCObject;
import com.tapcrowd.app.views.SearchBar;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p005pl.mg6.android.maps.extensions.ClusteringSettings;
import p005pl.mg6.android.maps.extensions.GoogleMap;
import p005pl.mg6.android.maps.extensions.Marker;
import p005pl.mg6.android.maps.extensions.SupportMapFragment;
import twitter4j.Query;

public class PlaceListFragment extends TCListFragment implements GoogleMap.OnInfoWindowClickListener, MenuFragment.MenuItemListener {
    private final int FILTER = 234;
    /* access modifiers changed from: private */
    public TCListObject.TCListObjectAdapter adapter;
    /* access modifiers changed from: private */
    public ArrayList<String> checkeditems;
    public Comparator<Object> distCatSort = new Comparator<Object>() {
        public int compare(Object object1obj, Object object2obj) {
            String type1;
            String type2;
            if (object1obj instanceof String) {
                type1 = (String) object1obj;
            } else {
                type1 = ((TCListObject) object1obj).getSub3();
            }
            if (object2obj instanceof String) {
                type2 = (String) object2obj;
            } else {
                type2 = ((TCListObject) object2obj).getSub3();
            }
            if (!type1.equals(type2)) {
                return type1.compareTo(type2);
            }
            if ((object1obj instanceof String) && (object2obj instanceof TCListObject)) {
                return -1;
            }
            if ((object1obj instanceof TCListObject) && (object2obj instanceof String)) {
                return 1;
            }
            TCListObject object1 = (TCListObject) object1obj;
            TCListObject object2 = (TCListObject) object2obj;
            if (object1.getSub2() == null || object2.getSub2() == null) {
                return 0;
            }
            if (!object1.getSub2().equals("") && !object2.getSub2().equals("")) {
                return Double.valueOf(object1.getSub2().split(Query.KILOMETERS)[0]).compareTo(Double.valueOf(object2.getSub2().split(Query.KILOMETERS)[0]));
            }
            if (object1.getSub2().equals(object2.getSub2())) {
                return object1.getText().compareTo(object2.getText());
            }
            return object2.getSub2().equals("") ? -1 : 1;
        }
    };
    public Comparator<Object> distsort = new Comparator<Object>() {
        public int compare(Object object1obj, Object object2obj) {
            if ((object1obj instanceof String) || (object2obj instanceof String)) {
                return 1;
            }
            TCListObject object1 = (TCListObject) object1obj;
            TCListObject object2 = (TCListObject) object2obj;
            if (object1.getSub2() == null || object2.getSub2() == null) {
                return 0;
            }
            if (!object1.getSub2().equals("") && !object2.getSub2().equals("")) {
                return Double.valueOf(object1.getSub2().split(Query.KILOMETERS)[0]).compareTo(Double.valueOf(object2.getSub2().split(Query.KILOMETERS)[0]));
            }
            if (object1.getSub2().equals(object2.getSub2())) {
                return object1.getText().compareTo(object2.getText());
            }
            if (object2.getSub2().equals("")) {
                return -1;
            }
            return 1;
        }
    };
    /* access modifiers changed from: private */
    public List<Object> listAlfa;
    /* access modifiers changed from: private */
    public List<Object> listDist;
    /* access modifiers changed from: private */
    public LoadList listTask;
    OnFragmentResultListener listener = new OnFragmentResultListener() {
        public void onFragmentResult(Intent data, int requestCode, int resultCode) {
            ArrayList<String> results = data.getStringArrayListExtra(FilterFragment.RESULTS);
            if (PlaceListFragment.this.checkeditems == null || results != null) {
                if (PlaceListFragment.this.checkeditems != null || results != null) {
                    PlaceListFragment.this.checkeditems = results;
                    Collections.sort(PlaceListFragment.this.checkeditems);
                    PlaceListFragment.this.findViewById(C0846R.C0847id.filteractive).setVisibility(0);
                    if (PlaceListFragment.this.listTask != null && PlaceListFragment.this.listTask.getStatus() == AsyncTask.Status.RUNNING) {
                        PlaceListFragment.this.listTask.cancel(true);
                    }
                    PlaceListFragment.this.listTask = new LoadList(PlaceListFragment.this, (LoadList) null);
                    PlaceListFragment.this.listTask.execute(new Void[0]);
                }
            } else if (results == null && PlaceListFragment.this.checkeditems != null) {
                PlaceListFragment.this.checkeditems = results;
                PlaceListFragment.this.findViewById(C0846R.C0847id.filteractive).setVisibility(8);
                if (PlaceListFragment.this.listTask != null && PlaceListFragment.this.listTask.getStatus() == AsyncTask.Status.RUNNING) {
                    PlaceListFragment.this.listTask.cancel(true);
                }
                PlaceListFragment.this.listTask = new LoadList(PlaceListFragment.this, (LoadList) null);
                PlaceListFragment.this.listTask.execute(new Void[0]);
            }
        }
    };
    /* access modifiers changed from: private */
    public ListView listview;
    AdapterView.OnItemClickListener listviewClickListener = new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView<?> adapter, View v, int position, long id) {
            Object obj = adapter.getItemAtPosition(position);
            if (obj instanceof TCListObject) {
                Fragments.add(PlaceListFragment.this, PlaceDetailFragment.newInstance(((TCListObject) obj).getId()), PlaceListFragment.this.getString(C0846R.string.detail));
            }
        }
    };
    /* access modifiers changed from: private */
    public Location location;
    LocationListener locationlistener = new LocationListener() {
        public void onStatusChanged(String provider, int status, Bundle extras) {
        }

        public void onProviderEnabled(String provider) {
        }

        public void onProviderDisabled(String provider) {
        }

        public void onLocationChanged(Location location) {
            PlaceListFragment.this.location = location;
            PlaceListFragment.this.searchingUpdates = false;
            PlaceListFragment.this.manager.removeUpdates(this);
            if (location != null) {
                PlaceListFragment.this.tryLocationTask();
            }
        }
    };
    /* access modifiers changed from: private */
    public LocationManager manager;
    /* access modifiers changed from: private */
    public GoogleMap map;
    private SupportMapFragment mapFragment;
    /* access modifiers changed from: private */
    public HashMap<Marker, String> markers = new HashMap<>();
    /* access modifiers changed from: private */
    public String parentid = "0";
    private boolean retained;
    SearchBar searchbar;
    /* access modifiers changed from: private */
    public boolean searchingUpdates;
    private Sort sort = Sort.Alpha;
    SearchBar.TextChangedListener textChanged = new SearchBar.TextChangedListener() {
        public void textChanged(CharSequence s, int count) {
            if (PlaceListFragment.this.adapter != null) {
                PlaceListFragment.this.adapter.getFilter().filter(s);
            }
        }
    };

    /* renamed from: v */
    private View f2103v;

    enum Sort {
        Alpha,
        Dist
    }

    public static PlaceListFragment newInstance() {
        return new PlaceListFragment();
    }

    public static PlaceListFragment newInstance(String parentid2) {
        PlaceListFragment fr = new PlaceListFragment();
        fr.parentid = parentid2;
        return fr;
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("parentId", this.parentid);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (this.f2103v == null) {
            this.f2103v = inflater.inflate(C0846R.layout.map_listview, container, false);
        } else {
            this.retained = true;
            ((ViewGroup) this.f2103v.getParent()).removeView(this.f2103v);
        }
        return this.f2103v;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupMenu();
        AdHelper.showAds(this, AdHelper.buildPath("54", "list", (String) null));
        this.mapFragment = (SupportMapFragment) getActivity().getSupportFragmentManager().findFragmentById(C0846R.C0847id.mapview);
        if (this.mapFragment == null) {
            this.mapFragment = new SupportMapFragment() {
                public void onActivityCreated(Bundle savedInstanceState) {
                    super.onActivityCreated(savedInstanceState);
                    PlaceListFragment.this.setupMap();
                }

                public void onDestroyView() {
                    super.onDestroyView();
                    PlaceListFragment.this.map = null;
                }
            };
            this.mapFragment.setRetainInstance(true);
            getChildFragmentManager().beginTransaction().replace(C0846R.C0847id.mapview, this.mapFragment).commit();
        }
        if (savedInstanceState != null) {
            this.map = this.mapFragment.getExtendedMap();
        }
        if (this.listview != null) {
            this.listview.setOnItemClickListener(this.listviewClickListener);
        }
        if (!this.retained) {
            findViewById(C0846R.C0847id.map_tab).setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    PlaceListFragment.this.switchTab(v);
                }
            });
            findViewById(C0846R.C0847id.list_tab).setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    PlaceListFragment.this.switchTab(v);
                }
            });
            setupSortButtons();
            this.listTask = new LoadList(this, (LoadList) null);
            this.listTask.execute(new Void[0]);
            setupLocation();
        }
    }

    public void switchTab(View v) {
        switch (v.getId()) {
            case C0846R.C0847id.list_tab:
                C1232UI.show(C0846R.C0847id.listcont, this.f2103v);
                findViewById(C0846R.C0847id.map_tab).setBackgroundResource(C0846R.drawable.tab2unsel);
                findViewById(C0846R.C0847id.list_tab).setBackgroundResource(C0846R.drawable.tab1sel);
                return;
            case C0846R.C0847id.map_tab:
                C1232UI.hide(C0846R.C0847id.listcont, this.f2103v);
                findViewById(C0846R.C0847id.map_tab).setBackgroundResource(C0846R.drawable.tab2sel);
                findViewById(C0846R.C0847id.list_tab).setBackgroundResource(C0846R.drawable.tab1unsel);
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: private */
    public void setupMap() {
        if (this.map == null) {
            this.map = this.mapFragment.getExtendedMap();
            if (this.map != null) {
                this.map.setMyLocationEnabled(true);
                this.map.setClustering(new ClusteringSettings().clusterSize(180.0d).addMarkersDynamically(true).iconDataProvider(new IconProvider(getActivity())));
                this.map.getUiSettings().setZoomControlsEnabled(true);
                this.map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(50.7225468336323d, 4.5263671875d), 7.0f));
                this.map.setOnInfoWindowClickListener(this);
                new LoadMap(this, (LoadMap) null).execute(new Void[0]);
            }
        }
    }

    public void onDestroy() {
        super.onDestroy();
        Log.e("places", "destroy");
        try {
            if (this.mapFragment != null) {
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.remove(this.mapFragment);
                ft.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class LoadMap extends AsyncTask<Void, Void, Void> {
        private LatLngBounds.Builder builder;
        private HashSet<String> ids;
        private List<Options> places;

        private LoadMap() {
            this.ids = new HashSet<>();
        }

        /* synthetic */ LoadMap(PlaceListFragment placeListFragment, LoadMap loadMap) {
            this();
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            for (Map.Entry<Marker, String> entry : PlaceListFragment.this.markers.entrySet()) {
                entry.getKey().remove();
            }
            PlaceListFragment.this.markers.clear();
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(Void... params) {
            while (PlaceListFragment.this.map == null) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (PlaceListFragment.this.checkeditems == null) {
                this.places = getOptions(C1199DB.getDatabase().rawQuery(String.format("SELECT id, lat, title AS name, lng AS lon FROM places WHERE parentId == '%1$s' AND lat != '0.000000' AND lon != '0.000000' ORDER BY title", new Object[]{PlaceListFragment.this.parentid}), (String[]) null));
            } else {
                this.places = new ArrayList();
                Iterator it = PlaceListFragment.this.checkeditems.iterator();
                while (it.hasNext()) {
                    this.places.addAll(getOptions(C1199DB.getDatabase().rawQuery(String.format("SELECT id, lat, title AS name, lng AS lon FROM places WHERE id IN (SELECT itemid FROM groupitems WHERE groupid IN (SELECT id FROM groups WHERE name == '%1$s')) AND lat != '0.000000' AND lon != '0.000000' ORDER BY title", new Object[]{(String) it.next()}), (String[]) null)));
                }
            }
            this.builder = new LatLngBounds.Builder();
            for (Options option : this.places) {
                this.builder.include(option.latLng);
            }
            return null;
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Void result) {
            super.onPostExecute(result);
            if (this.places.size() > 0) {
                CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(this.builder.build(), 70);
                if (PlaceListFragment.this.map != null) {
                    PlaceListFragment.this.map.animateCamera(cu);
                }
            }
            for (Options option : this.places) {
                if (PlaceListFragment.this.map != null) {
                    PlaceListFragment.this.markers.put(PlaceListFragment.this.map.addMarker(option.options), option.f2104id);
                }
            }
        }

        public class Options {

            /* renamed from: id */
            public String f2104id;
            public LatLng latLng;
            public MarkerOptions options;

            public Options(String id, MarkerOptions options2, LatLng latLng2) {
                this.f2104id = id;
                this.options = options2;
                this.latLng = latLng2;
            }
        }

        public List<Options> getOptions(Cursor c) {
            List<Options> options = new ArrayList<>();
            int idIndex = c.getColumnIndex(DBFavorites.KEY_EVENT_ID);
            int latIndex = c.getColumnIndex("lat");
            int lonIndex = c.getColumnIndex("lon");
            int nameIndex = c.getColumnIndex(DBFavorites.KEY_NAME);
            Bitmap marker = ((BitmapDrawable) PlaceListFragment.this.getResources().getDrawable(C0846R.drawable.marker_premium)).getBitmap();
            if (C1216LO.getLoDrawable(C1216LO.navigationMarker) != null) {
                marker = ((BitmapDrawable) C1216LO.getLoDrawable(C1216LO.navigationMarker)).getBitmap();
            }
            if (c.moveToFirst()) {
                do {
                    if (!this.ids.contains(c.getString(idIndex))) {
                        LatLng latLng = new LatLng(Double.parseDouble(c.getString(latIndex)), Double.parseDouble(c.getString(lonIndex)));
                        options.add(new Options(c.getString(idIndex), new MarkerOptions().icon(BitmapDescriptorFactory.fromBitmap(marker)).position(latLng).title(c.getString(nameIndex)), latLng));
                        this.ids.add(c.getString(idIndex));
                    }
                } while (c.moveToNext());
            }
            return options;
        }
    }

    public void setupMenu() {
        ArrayList<MenuFragment.MenuItemContainer> menuitems = new ArrayList<>();
        if (C1199DB.getQueryFromDb("SELECT name FROM groups WHERE parentid IN (SELECT id FROM groups WHERE name = 'placescategories') ORDER BY name").size() > 0) {
            menuitems.add(new MenuFragment.MenuItemContainer(C1232UI.getColorOverlay((int) C0846R.drawable.filter, C1216LO.getLo(C1216LO.navigationColor)), 234));
        }
        Fragments.addMenu(this, MenuFragment.newInstance(menuitems, this));
    }

    private class LoadList extends AsyncTask<Void, Void, Void> {
        private LoadList() {
        }

        /* synthetic */ LoadList(PlaceListFragment placeListFragment, LoadList loadList) {
            this();
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            PlaceListFragment.this.listview = (ListView) PlaceListFragment.this.findViewById(16908298);
            PlaceListFragment.this.listview.setDivider(new ColorDrawable(C1216LO.getLo(C1216LO.cellSeparator)));
            PlaceListFragment.this.listview.setDividerHeight((int) Converter.convertDpToPixel(1.0f, PlaceListFragment.this.getActivity()));
            PlaceListFragment.this.listview.setOnItemClickListener(PlaceListFragment.this.listviewClickListener);
            if (PlaceListFragment.this.searchbar == null) {
                PlaceListFragment.this.searchbar = new SearchBar(PlaceListFragment.this.getActivity(), PlaceListFragment.this, PlaceListFragment.this.textChanged);
                PlaceListFragment.this.listview.addHeaderView(PlaceListFragment.this.searchbar);
            }
            PlaceListFragment.this.searchbar.getSearch().setText("");
            super.onPreExecute();
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(Void... params) {
            if (PlaceListFragment.this.checkeditems == null) {
                PlaceListFragment.this.listAlfa = TCDBHelper.getTCListFromDb(String.format("SELECT id, title, imageurl, lat || ':' || lng AS tag, '' AS order_value FROM places WHERE parentId == '%1$s' ORDER BY title", new Object[]{PlaceListFragment.this.parentid}), new TCDBHelper.TCListHelperObject(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, (String) null, "imageurl", true), false);
            } else {
                PlaceListFragment.this.listAlfa = new ArrayList();
                Iterator it = PlaceListFragment.this.checkeditems.iterator();
                while (it.hasNext()) {
                    String checkeditem = (String) it.next();
                    ArrayList<Object> tCListFromDb = TCDBHelper.getTCListFromDb(String.format("SELECT '%1$s' AS sub3, id, title, imageurl, lat || ':' || lng AS tag, '' AS order_value FROM places WHERE id IN (SELECT itemid FROM groupitems WHERE groupid IN (SELECT id FROM groups WHERE name == '%1$s')) ORDER BY title", new Object[]{checkeditem}), new TCDBHelper.TCListHelperObject(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, (String) null, (String) null, "sub3", "imageurl", true), false);
                    if (tCListFromDb.size() > 0) {
                        PlaceListFragment.this.listAlfa.add(checkeditem);
                        PlaceListFragment.this.listAlfa.addAll(tCListFromDb);
                    }
                }
            }
            if (PlaceListFragment.this.location == null || PlaceListFragment.this.searchingUpdates) {
                return null;
            }
            PlaceListFragment.this.listDist = new ArrayList();
            for (Object obj : PlaceListFragment.this.listAlfa) {
                if (obj instanceof TCListObject) {
                    TCListObject tlo = (TCListObject) obj;
                    String distance = "";
                    double lat = Double.parseDouble(tlo.getSearch().split(":")[0]);
                    double lng = Double.parseDouble(tlo.getSearch().split(":")[1]);
                    if (!(lat == 0.0d || lng == 0.0d)) {
                        Location location = new Location((String) null);
                        location.setLongitude(lng);
                        location.setLatitude(lat);
                        distance = String.valueOf(((double) Math.round(PlaceListFragment.this.location.distanceTo(location) / 100.0f)) / 10.0d) + Query.KILOMETERS;
                    }
                    tlo.setSub2(distance);
                }
                PlaceListFragment.this.listDist.add(obj);
            }
            if (PlaceListFragment.this.checkeditems == null) {
                Collections.sort(PlaceListFragment.this.listDist, PlaceListFragment.this.distsort);
                return null;
            }
            Collections.sort(PlaceListFragment.this.listDist, PlaceListFragment.this.distCatSort);
            return null;
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Void result) {
            PlaceListFragment.this.adapter = new TCListObject.TCListObjectAdapter(PlaceListFragment.this.listAlfa, 0, false);
            PlaceListFragment.this.adapter.setLayout(C0846R.layout.cell_tcobject_two_lines);
            PlaceListFragment.this.listview.setAdapter(PlaceListFragment.this.adapter);
            super.onPostExecute(result);
        }
    }

    public void setupLocation() {
        this.searchingUpdates = true;
        this.manager = (LocationManager) getActivity().getSystemService("location");
        this.manager.requestLocationUpdates("network", 5000, 100.0f, this.locationlistener);
        this.manager.requestLocationUpdates("gps", 5000, 100.0f, this.locationlistener);
    }

    /* access modifiers changed from: private */
    public void tryLocationTask() {
        if (this.listTask == null || this.listTask.getStatus() == AsyncTask.Status.RUNNING) {
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    PlaceListFragment.this.tryLocationTask();
                }
            }, 200);
        } else {
            new LocationTask(this.location).execute(new Void[0]);
        }
    }

    private class LocationTask extends AsyncTask<Void, Void, Void> {
        private Location location;

        public LocationTask(Location location2) {
            this.location = location2;
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(Void... params) {
            PlaceListFragment.this.listDist = new ArrayList();
            for (Object obj : PlaceListFragment.this.listAlfa) {
                if (obj instanceof TCListObject) {
                    TCListObject tlo = (TCListObject) obj;
                    String distance = "";
                    double lat = Double.parseDouble(tlo.getSearch().split(":")[0]);
                    double lng = Double.parseDouble(tlo.getSearch().split(":")[1]);
                    if (!(lat == 0.0d || lng == 0.0d)) {
                        Location other = new Location((String) null);
                        other.setLongitude(lng);
                        other.setLatitude(lat);
                        distance = String.valueOf(((double) Math.round(this.location.distanceTo(other) / 100.0f)) / 10.0d) + Query.KILOMETERS;
                    }
                    tlo.setSub2(distance);
                }
                PlaceListFragment.this.listDist.add(obj);
            }
            Collections.sort(PlaceListFragment.this.listDist, PlaceListFragment.this.distsort);
            return null;
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Void result) {
            PlaceListFragment.this.adapter = new TCListObject.TCListObjectAdapter(PlaceListFragment.this.listAlfa, 0, false);
            PlaceListFragment.this.adapter.setLayout(C0846R.layout.cell_tcobject_two_lines);
            PlaceListFragment.this.listview.setAdapter(PlaceListFragment.this.adapter);
            PlaceListFragment.this.showSortButtons();
            super.onPostExecute(result);
        }
    }

    public void setupSortButtons() {
        findViewById(C0846R.C0847id.sorticons).setVisibility(8);
        findViewById(C0846R.C0847id.sorticons).setBackgroundColor(C1216LO.getLo(C1216LO.actionbarBackgroundColor));
        findViewById(C0846R.C0847id.alpha).setBackgroundDrawable(getSortIconBg());
        findViewById(C0846R.C0847id.dist).setBackgroundDrawable(getSortIconBg());
        findViewById(C0846R.C0847id.alpha).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                PlaceListFragment.this.alpha(v);
            }
        });
        findViewById(C0846R.C0847id.dist).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                PlaceListFragment.this.dist(v);
            }
        });
    }

    public StateListDrawable getSortIconBg() {
        GradientDrawable passive = new GradientDrawable(GradientDrawable.Orientation.BL_TR, new int[]{C1216LO.getLo(C1216LO.buttonBackgroundColor), C1216LO.getLo(C1216LO.buttonBackgroundColor)});
        passive.setCornerRadius(15.0f);
        passive.setStroke(4, C1216LO.getLo(C1216LO.actionbarContentColor));
        GradientDrawable active = new GradientDrawable(GradientDrawable.Orientation.BL_TR, new int[]{C1216LO.getLo(C1216LO.buttonBackgroundColor), C1216LO.getLo(C1216LO.buttonBackgroundColor)});
        active.setCornerRadius(15.0f);
        active.setStroke(4, C1216LO.getLo(C1216LO.actionbarContentColor));
        StateListDrawable states = new StateListDrawable();
        states.addState(new int[]{16842919}, active);
        states.addState(new int[]{16842913}, active);
        states.addState(new int[]{16842908}, active);
        states.addState(new int[0], passive);
        return states;
    }

    public void showSortButtons() {
        if (findViewById(C0846R.C0847id.sorticons).getVisibility() != 0) {
            TranslateAnimation tran = new TranslateAnimation(0, BitmapDescriptorFactory.HUE_RED, 0, BitmapDescriptorFactory.HUE_RED, 1, 1.0f, 1, BitmapDescriptorFactory.HUE_RED);
            tran.setDuration(250);
            findViewById(C0846R.C0847id.sorticons).setVisibility(0);
            findViewById(C0846R.C0847id.sorticons).startAnimation(tran);
        }
    }

    public void alpha(View v) {
        if (this.sort == Sort.Dist) {
            this.adapter = new TCListObject.TCListObjectAdapter((List) this.listAlfa, 0, false);
            this.adapter.setLayout(C0846R.layout.cell_tcobject_two_lines);
            this.listview.setAdapter(this.adapter);
            this.sort = Sort.Alpha;
        }
    }

    public void dist(View v) {
        if (this.sort == Sort.Alpha) {
            this.adapter = new TCListObject.TCListObjectAdapter((List) this.listDist, 0, false);
            this.adapter.setLayout(C0846R.layout.cell_tcobject_two_lines);
            this.listview.setAdapter(this.adapter);
            this.sort = Sort.Dist;
        }
    }

    public View findViewById(int id) {
        return this.f2103v.findViewById(id);
    }

    public void click(MenuItem item) {
        switch (item.getItemId()) {
            case 234:
                ArrayList<String> categories = new ArrayList<>();
                for (TCObject placeCat : C1199DB.getQueryFromDb("SELECT name FROM groups WHERE parentid IN (SELECT id FROM groups WHERE name = 'placescategories') ORDER BY name")) {
                    categories.add(placeCat.get(DBFavorites.KEY_NAME));
                }
                Intent intent = new Intent();
                intent.putStringArrayListExtra("null", categories);
                Fragments.add(this, FilterFragment.newInstance(intent, this.checkeditems, this.listener), getString(C0846R.string.filter));
                return;
            default:
                return;
        }
    }

    public void onInfoWindowClick(Marker marker) {
        Fragments.add(this, PlaceDetailFragment.newInstance(this.markers.get(marker)), getString(C0846R.string.detail));
    }
}
