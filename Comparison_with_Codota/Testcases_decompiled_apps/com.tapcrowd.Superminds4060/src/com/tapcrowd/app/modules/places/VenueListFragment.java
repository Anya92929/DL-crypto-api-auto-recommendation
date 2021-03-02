package com.tapcrowd.app.modules.places;

import android.app.ProgressDialog;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.p000v4.app.FragmentTransaction;
import android.support.p000v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.actionbarsherlock.view.MenuItem;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.android.gcm.GCMConstants;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.plus.PlusShare;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.TCListFragment;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import com.tapcrowd.app.modules.info.VenueInfoFragment;
import com.tapcrowd.app.modules.launcher.TCLauncherPhoneFragment;
import com.tapcrowd.app.modules.menuitems.MenuFragment;
import com.tapcrowd.app.utils.App;
import com.tapcrowd.app.utils.C1199DB;
import com.tapcrowd.app.utils.C1216LO;
import com.tapcrowd.app.utils.C1232UI;
import com.tapcrowd.app.utils.Fragments;
import com.tapcrowd.app.utils.IconProvider;
import com.tapcrowd.app.utils.Internet;
import com.tapcrowd.app.utils.LauncherUtil;
import com.tapcrowd.app.utils.TCDBHelper;
import com.tapcrowd.app.utils.TCListObject;
import com.tapcrowd.app.utils.TCObject;
import com.tapcrowd.app.views.SearchBar;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import p005pl.mg6.android.maps.extensions.ClusteringSettings;
import p005pl.mg6.android.maps.extensions.GoogleMap;
import p005pl.mg6.android.maps.extensions.Marker;
import p005pl.mg6.android.maps.extensions.SupportMapFragment;
import twitter4j.Query;

public class VenueListFragment extends TCListFragment implements MenuFragment.MenuItemListener, GoogleMap.OnInfoWindowClickListener {
    private final int LIST_TYPE = 3465;
    public Comparator<Object> alfasort = new Comparator<Object>() {
        public int compare(Object object1obj, Object object2obj) {
            return ((TCListObject) object1obj).toString().toLowerCase().compareTo(((TCListObject) object2obj).toString().toLowerCase());
        }
    };
    View.OnClickListener clickTab = new View.OnClickListener() {
        public void onClick(View v) {
            VenueListFragment.this.switchTab(v);
        }
    };
    public Comparator<Object> distsort = new Comparator<Object>() {
        public int compare(Object object1obj, Object object2obj) {
            TCListObject object1 = (TCListObject) object1obj;
            TCListObject object2 = (TCListObject) object2obj;
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
    public boolean img;
    /* access modifiers changed from: private */
    public List<Object> listAlfa;
    /* access modifiers changed from: private */
    public List<Object> listDist;
    private boolean listalfa = false;
    private LoadListTask loadListTask;
    /* access modifiers changed from: private */
    public boolean locationFound = false;
    LocationListener locationlistener = new LocationListener() {
        Location location;

        public void onStatusChanged(String provider, int status, Bundle extras) {
        }

        public void onProviderEnabled(String provider) {
        }

        public void onProviderDisabled(String provider) {
        }

        public void onLocationChanged(Location location2) {
            this.location = location2;
            VenueListFragment.this.manager.removeUpdates(this);
            new LoadListTask().execute(new Void[0]);
        }

        /* renamed from: com.tapcrowd.app.modules.places.VenueListFragment$2$LoadListTask */
        class LoadListTask extends AsyncTask<Void, Object, Void> {
            LoadListTask() {
            }

            /* access modifiers changed from: protected */
            public Void doInBackground(Void... params) {
                VenueListFragment.this.listDist = new ArrayList();
                for (TCListObject tlo : VenueListFragment.this.listAlfa) {
                    String distance = "";
                    TCObject t = C1199DB.getObject("venues", DBFavorites.KEY_EVENT_ID, tlo.getId());
                    if (!t.get("lat", "0").equals("0") && !t.get("lon", "0").equals("0")) {
                        try {
                            Location other = new Location((String) null);
                            other.setLongitude(Double.valueOf(t.get("lon")).doubleValue());
                            other.setLatitude(Double.valueOf(t.get("lat")).doubleValue());
                            distance = String.valueOf(((double) Math.round(C11282.this.location.distanceTo(other) / 100.0f)) / 10.0d) + Query.KILOMETERS;
                        } catch (Exception e) {
                            distance = "";
                        }
                    }
                    tlo.setSub2(distance);
                    VenueListFragment.this.listDist.add(tlo);
                }
                Collections.sort(VenueListFragment.this.listDist, VenueListFragment.this.distsort);
                return null;
            }

            /* access modifiers changed from: protected */
            public void onPostExecute(Void result) {
                VenueListFragment.this.menu.stopLoader();
                VenueListFragment.this.menu.addItem(new MenuFragment.MenuItemContainer(C1232UI.getColorOverlay((int) C0846R.drawable.icon_alfa, C1216LO.getLo(C1216LO.navigationColor)), 3465));
                ((TCListObject.TCListObjectAdapter) VenueListFragment.this.getListAdapter()).notifyDataSetChanged();
                VenueListFragment.this.locationFound = true;
                VenueListFragment.this.drawListDist();
                super.onPostExecute(result);
            }
        }
    };
    /* access modifiers changed from: private */
    public LocationManager manager;
    /* access modifiers changed from: private */
    public GoogleMap map;
    private SupportMapFragment mapFragment;
    private showMarkersTask markerTask;
    /* access modifiers changed from: private */
    public HashMap<Marker, String> markers = new HashMap<>();
    /* access modifiers changed from: private */
    public MenuFragment menu;
    /* access modifiers changed from: private */
    public SearchBar search;
    /* access modifiers changed from: private */
    public String tag;

    public static VenueListFragment newInstance() {
        return new VenueListFragment();
    }

    public static VenueListFragment newInstance(String tag2) {
        VenueListFragment fr = new VenueListFragment();
        fr.tag = tag2;
        return fr;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (this.f2007v == null) {
            this.f2007v = inflater.inflate(C0846R.layout.map_listview, container, false);
        } else {
            this.retained = true;
            ((ViewGroup) this.f2007v.getParent()).removeView(this.f2007v);
        }
        return this.f2007v;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.mapFragment = (SupportMapFragment) getActivity().getSupportFragmentManager().findFragmentById(C0846R.C0847id.mapview);
        if (this.mapFragment == null) {
            this.mapFragment = new SupportMapFragment() {
                public void onActivityCreated(Bundle savedInstanceState) {
                    super.onActivityCreated(savedInstanceState);
                    VenueListFragment.this.setupMap();
                }

                public void onDestroyView() {
                    super.onDestroyView();
                    VenueListFragment.this.map = null;
                }
            };
            this.mapFragment.setRetainInstance(true);
            getChildFragmentManager().beginTransaction().replace(C0846R.C0847id.mapview, this.mapFragment).commit();
        }
        findViewById(C0846R.C0847id.map_tab).setOnClickListener(this.clickTab);
        findViewById(C0846R.C0847id.list_tab).setOnClickListener(this.clickTab);
        findViewById(C0846R.C0847id.sorticons).setVisibility(8);
        if (savedInstanceState != null) {
            this.map = this.mapFragment.getExtendedMap();
        }
        this.menu = MenuFragment.newInstance(new ArrayList<>(), this);
        Fragments.addMenu(this, this.menu);
        if (this.locationFound) {
            this.menu.addItem(new MenuFragment.MenuItemContainer(C1232UI.getColorOverlay(this.listalfa ? C0846R.drawable.icon_radar : C0846R.drawable.icon_alfa, C1216LO.getLo(C1216LO.navigationColor)), 3465));
        } else {
            this.menu.startLoader();
        }
        if (!this.retained) {
            this.loadListTask = new LoadListTask(this, (LoadListTask) null);
            this.loadListTask.execute(new Void[0]);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        try {
            if (this.mapFragment != null) {
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.remove(this.mapFragment);
                ft.commit();
                if (this.manager != null) {
                    try {
                        this.manager.removeUpdates(this.locationlistener);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (this.markerTask != null && this.markerTask.getStatus() == AsyncTask.Status.RUNNING) {
                    this.markerTask.cancel(true);
                }
                if (this.loadListTask != null && this.loadListTask.getStatus() == AsyncTask.Status.RUNNING) {
                    this.loadListTask.cancel(true);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void switchTab(View v) {
        switch (v.getId()) {
            case C0846R.C0847id.list_tab:
                C1232UI.show(C0846R.C0847id.listcont, this.f2007v);
                findViewById(C0846R.C0847id.map_tab).setBackgroundResource(C0846R.drawable.tab2unsel);
                findViewById(C0846R.C0847id.list_tab).setBackgroundResource(C0846R.drawable.tab1sel);
                return;
            case C0846R.C0847id.map_tab:
                C1232UI.hide(C0846R.C0847id.listcont, this.f2007v);
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
                this.markerTask = new showMarkersTask(this, (showMarkersTask) null);
                this.markerTask.execute(new Void[0]);
            }
        }
    }

    private class showMarkersTask extends AsyncTask<Void, Void, Void> {
        private LatLngBounds.Builder builder;
        private HashSet<String> ids;
        private List<Options> places;

        private showMarkersTask() {
            this.ids = new HashSet<>();
        }

        /* synthetic */ showMarkersTask(VenueListFragment venueListFragment, showMarkersTask showmarkerstask) {
            this();
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            for (Map.Entry<Marker, String> entry : VenueListFragment.this.markers.entrySet()) {
                entry.getKey().remove();
            }
            VenueListFragment.this.markers.clear();
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(Void... params) {
            while (VenueListFragment.this.map == null) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.places = getOptions();
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
                if (VenueListFragment.this.map != null) {
                    VenueListFragment.this.map.animateCamera(cu);
                }
            }
            for (Options option : this.places) {
                if (VenueListFragment.this.map != null) {
                    VenueListFragment.this.markers.put(VenueListFragment.this.map.addMarker(option.options), option.f2105id);
                }
            }
        }

        public class Options {

            /* renamed from: id */
            public String f2105id;
            public LatLng latLng;
            public MarkerOptions options;

            public Options(String id, MarkerOptions options2, LatLng latLng2) {
                this.f2105id = id;
                this.options = options2;
                this.latLng = latLng2;
            }
        }

        public List<Options> getOptions() {
            String query;
            if (VenueListFragment.this.tag != null) {
                query = String.format("SELECT v.id, v.name, lat, lon FROM venues v INNER JOIN tags t ON v.id = t.venueid WHERE v.id IN (SELECT venueid FROM tags WHERE tag = %1$s COLLATE NOCASE) GROUP BY lat ORDER BY v.order_value +0 DESC", new Object[]{DatabaseUtils.sqlEscapeString(VenueListFragment.this.tag)});
            } else {
                query = "SELECT v.image1, v.image_thumb1, v.id, v.name, group_concat(tag) tags, lat, lon FROM venues v INNER JOIN tags t ON v.id = t.venueid WHERE v.appid == " + App.f2123id + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + "GROUP BY lat ORDER BY order_value +0 DESC";
            }
            Cursor c = C1199DB.getDatabase().rawQuery(query, (String[]) null);
            ArrayList arrayList = new ArrayList();
            int idIndex = c.getColumnIndex(DBFavorites.KEY_EVENT_ID);
            int latIndex = c.getColumnIndex("lat");
            int lonIndex = c.getColumnIndex("lon");
            int nameIndex = c.getColumnIndex(DBFavorites.KEY_NAME);
            Bitmap marker = ((BitmapDrawable) VenueListFragment.this.getResources().getDrawable(C0846R.drawable.marker_premium)).getBitmap();
            if (C1216LO.getLoDrawable(C1216LO.navigationMarker) != null) {
                marker = ((BitmapDrawable) C1216LO.getLoDrawable(C1216LO.navigationMarker)).getBitmap();
            }
            BitmapDescriptor descriptor = BitmapDescriptorFactory.fromBitmap(marker);
            if (c.moveToFirst()) {
                do {
                    if (!this.ids.contains(c.getString(idIndex))) {
                        String latStr = c.getString(latIndex);
                        String lonStr = c.getString(lonIndex);
                        if (latStr.equals("")) {
                            latStr = "0";
                        }
                        double lat = Double.parseDouble(latStr);
                        if (lonStr.equals("")) {
                            lonStr = "0";
                        }
                        double lon = Double.parseDouble(lonStr);
                        if (!(lat == 0.0d && lon == 0.0d)) {
                            LatLng latLng = new LatLng(lat, lon);
                            arrayList.add(new Options(c.getString(idIndex), new MarkerOptions().icon(descriptor).position(latLng).title(c.getString(nameIndex)), latLng));
                            this.ids.add(c.getString(idIndex));
                        }
                    }
                } while (c.moveToNext());
            }
            return arrayList;
        }
    }

    private class LoadListTask extends AsyncTask<Void, Object, Void> {
        private LoadListTask() {
        }

        /* synthetic */ LoadListTask(VenueListFragment venueListFragment, LoadListTask loadListTask) {
            this();
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            if (VenueListFragment.this.search == null) {
                VenueListFragment.this.search = new SearchBar((Context) VenueListFragment.this.getActivity(), (ListFragment) VenueListFragment.this);
                VenueListFragment.this.getListView().addHeaderView(VenueListFragment.this.search);
            }
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(Void... params) {
            String query;
            String query2;
            int i;
            VenueListFragment.this.listAlfa = new ArrayList();
            String where = "v.appid == " + App.f2123id;
            if (VenueListFragment.this.tag != null) {
                query = "SELECT COUNT(*) AS num FROM venues v INNER JOIN tags t ON v.id = t.venueid WHERE v.id IN (SELECT venueid FROM tags WHERE tag = " + DatabaseUtils.sqlEscapeString(VenueListFragment.this.tag) + " COLLATE NOCASE) " + "AND v.image1 IS NOT NULL AND v.image1 != '' " + "GROUP BY v.id ";
            } else {
                query = "SELECT COUNT(*) AS num FROM venues v INNER JOIN tags t ON v.id = t.venueid WHERE " + where + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + "AND v.image1 IS NOT NULL AND v.image1 != '' " + "GROUP BY v.id ";
            }
            List<TCObject> images = C1199DB.getQueryFromDb(query);
            if (images.size() > 0) {
                VenueListFragment.this.img = !images.get(0).get("num").equals("0");
            }
            if (VenueListFragment.this.tag != null) {
                query2 = "SELECT v.image1, v.id, v.name FROM venues v INNER JOIN tags t ON v.id = t.venueid WHERE v.id IN (SELECT venueid FROM tags WHERE tag = " + DatabaseUtils.sqlEscapeString(VenueListFragment.this.tag) + " COLLATE NOCASE) " + "GROUP BY v.id " + "ORDER BY v.name COLLATE NOCASE";
            } else {
                query2 = "SELECT v.image1, v.id, v.name FROM venues v INNER JOIN tags t ON v.id = t.venueid WHERE " + where + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + "GROUP BY v.id " + "ORDER BY v.name COLLATE NOCASE";
            }
            VenueListFragment venueListFragment = VenueListFragment.this;
            TCDBHelper.TCListHelperObject tCListHelperObject = new TCDBHelper.TCListHelperObject(DBFavorites.KEY_NAME, (String) null, "image1");
            if (VenueListFragment.this.img) {
                i = C0846R.drawable.l_def_venues;
            } else {
                i = 0;
            }
            venueListFragment.listAlfa = TCDBHelper.getTCListFromDb(query2, tCListHelperObject, false, i);
            return null;
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Void result) {
            super.onPostExecute(result);
            VenueListFragment.this.setListAdapter(new TCListObject.TCListObjectAdapter(VenueListFragment.this.listAlfa, VenueListFragment.this.img ? C0846R.drawable.l_def_venues : 0, false));
            if (VenueListFragment.this.getActivity() != null) {
                VenueListFragment.this.manager = (LocationManager) VenueListFragment.this.getActivity().getSystemService("location");
                VenueListFragment.this.manager.requestLocationUpdates("network", 5000, 100.0f, VenueListFragment.this.locationlistener);
                VenueListFragment.this.manager.requestLocationUpdates("gps", 5000, 100.0f, VenueListFragment.this.locationlistener);
            }
        }
    }

    public void onListItemClick(ListView l, View v, int position, long id) {
        Object obj = l.getItemAtPosition(position);
        if (obj instanceof TCListObject) {
            new LoadDataTask(((TCListObject) obj).getId()).execute(new Void[0]);
        }
        super.onListItemClick(l, v, position, id);
    }

    public View findViewById(int id) {
        return this.f2007v.findViewById(id);
    }

    public void onInfoWindowClick(Marker marker) {
        new LoadDataTask(this.markers.get(marker)).execute(new Void[0]);
    }

    public void click(MenuItem item) {
        switch (item.getItemId()) {
            case 3465:
                if (this.listalfa) {
                    drawListDist();
                    this.menu.editIcon(3465, C1232UI.getColorOverlay((int) C0846R.drawable.icon_alfa, C1216LO.getLo(C1216LO.navigationColor)));
                    return;
                }
                drawListAlfa();
                this.menu.editIcon(3465, C1232UI.getColorOverlay((int) C0846R.drawable.icon_radar, C1216LO.getLo(C1216LO.navigationColor)));
                return;
            default:
                return;
        }
    }

    public void drawListAlfa() {
        int i;
        List<Object> list = this.listAlfa;
        if (this.img) {
            i = C0846R.drawable.l_def_venues;
        } else {
            i = 0;
        }
        setListAdapter(new TCListObject.TCListObjectAdapter((List) list, i, false));
        this.listalfa = true;
    }

    public void drawListDist() {
        int i;
        List<Object> list = this.listDist;
        if (this.img) {
            i = C0846R.drawable.l_def_venues;
        } else {
            i = 0;
        }
        setListAdapter(new TCListObject.TCListObjectAdapter((List) list, i, false));
        this.listalfa = false;
    }

    private class LoadDataTask extends AsyncTask<Void, Void, Void> {
        private ProgressDialog dialog = new ProgressDialog(App.act);
        private String venueid;

        public LoadDataTask(String venueid2) {
            this.venueid = venueid2;
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            this.dialog = ProgressDialog.show(VenueListFragment.this.getActivity(), C1199DB.getObject(GCMConstants.EXTRA_APPLICATION_PENDING_INTENT, DBFavorites.KEY_EVENT_ID, App.f2123id).get(DBFavorites.KEY_NAME), VenueListFragment.this.getResourceString(C0846R.string.loading), false, true);
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(Void... args) {
            List<NameValuePair> postparams = new ArrayList<>();
            postparams.add(new BasicNameValuePair("appid", App.f2123id));
            postparams.add(new BasicNameValuePair("venueid", this.venueid));
            postparams.add(new BasicNameValuePair("bundleid", App.act.getPackageName()));
            C1199DB.jsonToDB(Internet.request("getVenue", postparams), "venueid == " + this.venueid);
            return null;
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Void result) {
            if (this.dialog.isShowing()) {
                this.dialog.dismiss();
                List<TCObject> list = C1199DB.getListFromDb("launchers", "venueid", this.venueid);
                int numlaunchers = list.size();
                for (TCObject item : list) {
                    if (!LauncherUtil.hasFragment(item)) {
                        numlaunchers--;
                    }
                }
                if (numlaunchers != 0) {
                    if (numlaunchers > 1) {
                        VenueListFragment.this.analytics = "/venue/" + this.venueid;
                        Fragments.add(VenueListFragment.this, TCLauncherPhoneFragment.newInstance("venueid", this.venueid), (String) null);
                        return;
                    }
                    for (TCObject item2 : list) {
                        if (LauncherUtil.hasFragment(item2)) {
                            VenueListFragment.this.analytics = "/venue/" + this.venueid;
                            if (item2.get("moduletypeid").equals("21")) {
                                Fragments.add(VenueListFragment.this, VenueInfoFragment.newInstance(this.venueid), item2.get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE));
                                return;
                            } else {
                                Fragments.add(VenueListFragment.this, LauncherUtil.getFragment(item2), item2.get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE));
                                return;
                            }
                        }
                    }
                }
            }
        }
    }
}
