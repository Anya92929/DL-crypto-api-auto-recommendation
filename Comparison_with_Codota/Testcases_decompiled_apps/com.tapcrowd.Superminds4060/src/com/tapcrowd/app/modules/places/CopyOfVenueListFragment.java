package com.tapcrowd.app.modules.places;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.p000v4.app.FragmentTransaction;
import android.support.p000v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ListView;
import com.actionbarsherlock.view.MenuItem;
import com.google.android.gcm.GCMConstants;
import com.google.android.gms.maps.CameraUpdateFactory;
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
import com.tapcrowd.app.modules.places.VenueListFragmentOld;
import com.tapcrowd.app.utils.App;
import com.tapcrowd.app.utils.C1199DB;
import com.tapcrowd.app.utils.C1216LO;
import com.tapcrowd.app.utils.C1232UI;
import com.tapcrowd.app.utils.Fragments;
import com.tapcrowd.app.utils.IconProvider;
import com.tapcrowd.app.utils.Internet;
import com.tapcrowd.app.utils.LauncherUtil;
import com.tapcrowd.app.utils.TCListObject;
import com.tapcrowd.app.utils.TCObject;
import com.tapcrowd.app.views.SearchBar;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import p005pl.mg6.android.maps.extensions.ClusteringSettings;
import p005pl.mg6.android.maps.extensions.GoogleMap;
import p005pl.mg6.android.maps.extensions.Marker;
import p005pl.mg6.android.maps.extensions.SupportMapFragment;
import twitter4j.Query;

public class CopyOfVenueListFragment extends TCListFragment implements MenuFragment.MenuItemListener, GoogleMap.OnInfoWindowClickListener {
    private final int LIST_TYPE = 3465;
    public Comparator<Object> alfasort = new Comparator<Object>() {
        public int compare(Object object1obj, Object object2obj) {
            return ((TCListObject) object1obj).toString().toLowerCase().compareTo(((TCListObject) object2obj).toString().toLowerCase());
        }
    };
    View.OnClickListener clickTab = new View.OnClickListener() {
        public void onClick(View v) {
            CopyOfVenueListFragment.this.switchTab(v);
        }
    };
    public Comparator<Object> distsort = new Comparator<Object>() {
        public int compare(Object object1obj, Object object2obj) {
            TCListObject object1 = (TCListObject) object1obj;
            TCListObject object2 = (TCListObject) object2obj;
            if (!object1.getSub3().equals("") && !object2.getSub3().equals("")) {
                return Double.valueOf(object1.getSub3().split(Query.KILOMETERS)[0]).compareTo(Double.valueOf(object2.getSub3().split(Query.KILOMETERS)[0]));
            }
            if (object1.getSub3().equals(object2.getSub3())) {
                return object1.getText().compareTo(object2.getText());
            }
            if (object2.getSub3().equals("")) {
                return -1;
            }
            return 1;
        }
    };
    private HashMap<Marker, String> idList = new HashMap<>();
    /* access modifiers changed from: private */
    public List<Object> list;
    private boolean listalfa = true;
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
            CopyOfVenueListFragment.this.manager.removeUpdates(this);
            new LoadListTask().execute(new Void[0]);
        }

        /* renamed from: com.tapcrowd.app.modules.places.CopyOfVenueListFragment$2$LoadListTask */
        class LoadListTask extends AsyncTask<Void, Object, Void> {
            LoadListTask() {
            }

            /* access modifiers changed from: protected */
            public Void doInBackground(Void... params) {
                for (TCListObject tlo : CopyOfVenueListFragment.this.list) {
                    String distance = "";
                    TCObject t = C1199DB.getObject("venues", DBFavorites.KEY_EVENT_ID, tlo.getId());
                    if (!t.get("lat", "0").equals("0") && !t.get("lon", "0").equals("0")) {
                        try {
                            Location other = new Location((String) null);
                            other.setLongitude(Double.valueOf(t.get("lon")).doubleValue());
                            other.setLatitude(Double.valueOf(t.get("lat")).doubleValue());
                            distance = String.valueOf(((double) Math.round(C11052.this.location.distanceTo(other) / 100.0f)) / 10.0d) + Query.KILOMETERS;
                        } catch (Exception e) {
                            distance = "";
                        }
                    }
                    tlo.setSub3(distance);
                }
                return null;
            }

            /* access modifiers changed from: protected */
            public void onPostExecute(Void result) {
                CopyOfVenueListFragment.this.menu.stopLoader();
                CopyOfVenueListFragment.this.menu.addItem(new MenuFragment.MenuItemContainer(C1232UI.getColorOverlay((int) C0846R.drawable.icon_radar, C1216LO.getLo(C1216LO.navigationColor)), 3465));
                CopyOfVenueListFragment.this.locationFound = true;
                super.onPostExecute(result);
            }
        }
    };
    /* access modifiers changed from: private */
    public LocationManager manager;
    /* access modifiers changed from: private */
    public GoogleMap map;
    private SupportMapFragment mapFragment;
    /* access modifiers changed from: private */
    public MenuFragment menu;
    /* access modifiers changed from: private */
    public SearchBar search;
    private SortTask sorttask;
    private String tag;

    public static CopyOfVenueListFragment newInstance() {
        return new CopyOfVenueListFragment();
    }

    public static CopyOfVenueListFragment newInstance(String tag2) {
        CopyOfVenueListFragment fr = new CopyOfVenueListFragment();
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
        int size;
        super.onActivityCreated(savedInstanceState);
        this.mapFragment = (SupportMapFragment) getActivity().getSupportFragmentManager().findFragmentById(C0846R.C0847id.mapview);
        if (this.mapFragment == null) {
            this.mapFragment = new SupportMapFragment() {
                public void onActivityCreated(Bundle savedInstanceState) {
                    super.onActivityCreated(savedInstanceState);
                    CopyOfVenueListFragment.this.setupMap();
                }

                public void onDestroyView() {
                    super.onDestroyView();
                    CopyOfVenueListFragment.this.map = null;
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
            if (this.tag != null) {
                size = C1199DB.getQueryFromDb("SELECT v.image1, v.image_thumb1, v.id, v.name, group_concat(tag) tags, lat, lon FROM venues v INNER JOIN tags t ON v.id = t.venueid WHERE v.id IN (SELECT venueid FROM tags WHERE tag = '" + this.tag + "' COLLATE NOCASE) GROUP BY v.id ORDER BY v.order_value +0 DESC, v.name").size();
            } else {
                size = C1199DB.getQueryFromDb("SELECT v.image1, v.image_thumb1, v.id, v.name, group_concat(tag) tags, lat, lon FROM venues v INNER JOIN tags t ON v.id = t.venueid WHERE v.appid == " + App.f2123id + " GROUP BY v.id ORDER BY order_value +0 DESC, v.name").size();
            }
            if (size < 100) {
                showList();
                if (this.search == null) {
                    this.search = new SearchBar((Context) getActivity(), (ListFragment) this);
                    getListView().addHeaderView(this.search);
                }
                setListAdapter(new TCListObject.TCListObjectAdapter((List) this.list, 0, false));
                this.manager = (LocationManager) getActivity().getSystemService("location");
                this.manager.requestLocationUpdates("network", 5000, 100.0f, this.locationlistener);
                this.manager.requestLocationUpdates("gps", 5000, 100.0f, this.locationlistener);
                return;
            }
            new LoadListTask(this, (LoadListTask) null).execute(new Void[0]);
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
                showMarkers();
            }
        }
    }

    public void showMarkers() {
        List<TCObject> locpoints;
        final List<LatLng> markers = new ArrayList<>();
        String where = "v.appid == " + App.f2123id;
        if (this.tag != null) {
            locpoints = C1199DB.getQueryFromDb("SELECT v.image1, v.image_thumb1, v.id, v.name, group_concat(tag) tags, lat, lon FROM venues v INNER JOIN tags t ON v.id = t.venueid WHERE v.id IN (SELECT venueid FROM tags WHERE tag = '" + this.tag + "' COLLATE NOCASE) GROUP BY lat ORDER BY v.order_value +0 DESC");
        } else {
            locpoints = C1199DB.getQueryFromDb("SELECT v.image1, v.image_thumb1, v.id, v.name, group_concat(tag) tags, lat, lon FROM venues v INNER JOIN tags t ON v.id = t.venueid WHERE " + where + " GROUP BY lat ORDER BY order_value +0 DESC");
        }
        Bitmap markerBmp = null;
        if (C1216LO.getLoDrawable(C1216LO.navigationMarker) != null) {
            markerBmp = ((BitmapDrawable) C1216LO.getLoDrawable(C1216LO.navigationMarker)).getBitmap();
        }
        if (markerBmp == null) {
            markerBmp = ((BitmapDrawable) App.act.getResources().getDrawable(C0846R.drawable.marker_premium)).getBitmap();
        }
        for (TCObject tco : locpoints) {
            if (!tco.get("lat", "0").equals("0") && !tco.get("lon", "0").equals("0")) {
                MarkerOptions marker = new MarkerOptions();
                marker.position(new LatLng(Double.parseDouble(tco.get("lat")), Double.parseDouble(tco.get("lon"))));
                marker.title(tco.get(DBFavorites.KEY_NAME));
                marker.icon(BitmapDescriptorFactory.fromBitmap(markerBmp));
                this.idList.put(this.map.addMarker(marker), tco.get(DBFavorites.KEY_EVENT_ID));
                markers.add(marker.getPosition());
            }
        }
        final View mapView = this.mapFragment.getView();
        if (mapView.getViewTreeObserver().isAlive()) {
            mapView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                @SuppressLint({"NewApi"})
                public void onGlobalLayout() {
                    LatLngBounds.Builder bounds = new LatLngBounds.Builder();
                    for (LatLng marker : markers) {
                        bounds.include(marker);
                    }
                    LatLngBounds builtBounds = bounds.build();
                    if (Build.VERSION.SDK_INT < 16) {
                        mapView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    } else {
                        mapView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                    CopyOfVenueListFragment.this.map.moveCamera(CameraUpdateFactory.newLatLngBounds(builtBounds, 50));
                }
            });
        }
    }

    private class LoadListTask extends AsyncTask<Void, Object, Void> {
        private LoadListTask() {
        }

        /* synthetic */ LoadListTask(CopyOfVenueListFragment copyOfVenueListFragment, LoadListTask loadListTask) {
            this();
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(Void... params) {
            CopyOfVenueListFragment.this.showList();
            return null;
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Void result) {
            if (CopyOfVenueListFragment.this.search == null) {
                CopyOfVenueListFragment.this.search = new SearchBar((Context) CopyOfVenueListFragment.this.getActivity(), (ListFragment) CopyOfVenueListFragment.this);
                CopyOfVenueListFragment.this.getListView().addHeaderView(CopyOfVenueListFragment.this.search);
            }
            CopyOfVenueListFragment.this.setListAdapter(new TCListObject.TCListObjectAdapter(CopyOfVenueListFragment.this.list, 0, false));
            CopyOfVenueListFragment.this.manager = (LocationManager) CopyOfVenueListFragment.this.getActivity().getSystemService("location");
            CopyOfVenueListFragment.this.manager.requestLocationUpdates("network", 5000, 100.0f, CopyOfVenueListFragment.this.locationlistener);
            CopyOfVenueListFragment.this.manager.requestLocationUpdates("gps", 5000, 100.0f, CopyOfVenueListFragment.this.locationlistener);
            super.onPostExecute(result);
        }
    }

    public void showList() {
        List<TCObject> temp;
        this.list = new ArrayList();
        String where = "v.appid == " + App.f2123id;
        new ArrayList();
        if (this.tag != null) {
            temp = C1199DB.getQueryFromDb("SELECT v.image1, v.image_thumb1, v.id, v.name, group_concat(tag) tags, lat, lon FROM venues v INNER JOIN tags t ON v.id = t.venueid WHERE v.id IN (SELECT venueid FROM tags WHERE tag = '" + this.tag + "' COLLATE NOCASE) GROUP BY v.id ORDER BY v.order_value +0 DESC, v.name COLLATE NOCASE");
        } else {
            temp = C1199DB.getQueryFromDb("SELECT v.image1, v.image_thumb1, v.id, v.name, group_concat(tag) tags, lat, lon FROM venues v INNER JOIN tags t ON v.id = t.venueid WHERE " + where + " GROUP BY v.id ORDER BY order_value +0 DESC, v.name COLLATE NOCASE");
        }
        for (TCObject tco : temp) {
            this.list.add(new TCListObject(tco.get(DBFavorites.KEY_EVENT_ID, ""), tco.get(DBFavorites.KEY_NAME, ""), (String) null, "", "", tco.get("image1", tco.get("image_thumb1", "")), (int) C0846R.drawable.l_def_venues));
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
        new LoadDataTask(this.idList.get(marker)).execute(new Void[0]);
    }

    public void click(MenuItem item) {
        switch (item.getItemId()) {
            case 3465:
                if (this.sorttask != null && this.sorttask.getStatus() == AsyncTask.Status.RUNNING) {
                    return;
                }
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
        this.sorttask = new SortTask(this.alfasort);
        this.sorttask.execute(new Void[0]);
        this.listalfa = true;
    }

    public void drawListDist() {
        this.sorttask = new SortTask(this.distsort);
        this.sorttask.execute(new Void[0]);
        this.listalfa = false;
    }

    private class SortTask extends AsyncTask<Void, Void, Void> {
        Comparator<Object> sort;

        public SortTask(Comparator<Object> sort2) {
            this.sort = sort2;
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(Void... params) {
            Collections.sort(CopyOfVenueListFragment.this.list, this.sort);
            return null;
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Void result) {
            CopyOfVenueListFragment.this.setListAdapter(new VenueListFragmentOld.VenueAdapter(CopyOfVenueListFragment.this.list));
            super.onPostExecute(result);
        }
    }

    private class LoadDataTask extends AsyncTask<Void, Void, Void> {
        private ProgressDialog dialog = new ProgressDialog(App.act);
        private String venueid;

        public LoadDataTask(String venueid2) {
            this.venueid = venueid2;
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            this.dialog = ProgressDialog.show(CopyOfVenueListFragment.this.getActivity(), C1199DB.getObject(GCMConstants.EXTRA_APPLICATION_PENDING_INTENT, DBFavorites.KEY_EVENT_ID, App.f2123id).get(DBFavorites.KEY_NAME), CopyOfVenueListFragment.this.getResourceString(C0846R.string.loading), false, true);
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
                        CopyOfVenueListFragment.this.analytics = "/venue/" + this.venueid;
                        Fragments.add(CopyOfVenueListFragment.this, TCLauncherPhoneFragment.newInstance("venueid", this.venueid), (String) null);
                        return;
                    }
                    for (TCObject item2 : list) {
                        if (LauncherUtil.hasFragment(item2)) {
                            CopyOfVenueListFragment.this.analytics = "/venue/" + this.venueid;
                            if (item2.get("moduletypeid").equals("21")) {
                                Fragments.add(CopyOfVenueListFragment.this, VenueInfoFragment.newInstance(this.venueid), item2.get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE));
                                return;
                            } else {
                                Fragments.add(CopyOfVenueListFragment.this, LauncherUtil.getFragment(item2), item2.get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE));
                                return;
                            }
                        }
                    }
                }
            }
        }
    }
}
