package com.tapcrowd.app.modules.places;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.p000v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.actionbarsherlock.view.MenuItem;
import com.google.android.gcm.GCMConstants;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.plus.PlusShare;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapController;
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
import com.tapcrowd.app.utils.TCListObject;
import com.tapcrowd.app.utils.TCObject;
import com.tapcrowd.app.utils.images.FastImageLoader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import p005pl.mg6.android.maps.extensions.ClusteringSettings;
import p005pl.mg6.android.maps.extensions.GoogleMap;
import p005pl.mg6.android.maps.extensions.Marker;
import p005pl.mg6.android.maps.extensions.SupportMapFragment;
import twitter4j.Query;

public class VenueListFragmentOld extends TCListFragment implements MenuFragment.MenuItemListener, GoogleMap.OnInfoWindowClickListener {
    private final int LIST_TYPE = 3465;
    public Comparator<Object> alfasort = new Comparator<Object>() {
        public int compare(Object object1obj, Object object2obj) {
            return ((TCListObject) object1obj).toString().compareTo(((TCListObject) object2obj).toString());
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
    HashMap<Marker, String> idList = new HashMap<>();
    List<Object> list;
    boolean listalfa = true;
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
            VenueListFragmentOld.this.manager.removeUpdates(this);
            new LoadListTask().execute(new Void[0]);
        }

        /* renamed from: com.tapcrowd.app.modules.places.VenueListFragmentOld$3$LoadListTask */
        class LoadListTask extends AsyncTask<Void, Object, Void> {
            LoadListTask() {
            }

            /* access modifiers changed from: protected */
            public Void doInBackground(Void... params) {
                Iterator<Object> it = VenueListFragmentOld.this.list.iterator();
                while (it.hasNext()) {
                    TCListObject tlo = (TCListObject) it.next();
                    String distance = "";
                    TCObject t = C1199DB.getObject("venues", DBFavorites.KEY_EVENT_ID, tlo.getId());
                    if (!t.get("lat", "0").equals("0") && !t.get("lon", "0").equals("0")) {
                        try {
                            Location other = new Location((String) null);
                            other.setLongitude(Double.valueOf(t.get("lon")).doubleValue());
                            other.setLatitude(Double.valueOf(t.get("lat")).doubleValue());
                            distance = String.valueOf(((double) Math.round(C11343.this.location.distanceTo(other) / 100.0f)) / 10.0d) + Query.KILOMETERS;
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
                VenueListFragmentOld.this.menu.stopLoader();
                VenueListFragmentOld.this.menu.addItem(new MenuFragment.MenuItemContainer(C1232UI.getColorOverlay((int) C0846R.drawable.icon_radar, C1216LO.getLo(C1216LO.navigationColor)), 3465));
                super.onPostExecute(result);
            }
        }
    };
    LocationManager manager;
    GoogleMap map;
    MapController mapController;
    private SupportMapFragment mapFragment;
    MenuFragment menu;
    ArrayList<GeoPoint> points = new ArrayList<>();
    SortTask sorttask;
    private View.OnClickListener switchtab = new View.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case C0846R.C0847id.list_tab:
                    C1232UI.show(16908298, VenueListFragmentOld.this.f2106v);
                    VenueListFragmentOld.this.f2106v.findViewById(C0846R.C0847id.map_tab).setBackgroundResource(C0846R.drawable.tab2unsel);
                    VenueListFragmentOld.this.f2106v.findViewById(C0846R.C0847id.list_tab).setBackgroundResource(C0846R.drawable.tab1sel);
                    return;
                case C0846R.C0847id.map_tab:
                    C1232UI.hide(16908298, VenueListFragmentOld.this.f2106v);
                    VenueListFragmentOld.this.f2106v.findViewById(C0846R.C0847id.map_tab).setBackgroundResource(C0846R.drawable.tab2sel);
                    VenueListFragmentOld.this.f2106v.findViewById(C0846R.C0847id.list_tab).setBackgroundResource(C0846R.drawable.tab1unsel);
                    return;
                default:
                    return;
            }
        }
    };
    String tag;

    /* renamed from: v */
    View f2106v;

    public static VenueListFragmentOld newInstance() {
        return new VenueListFragmentOld();
    }

    public static VenueListFragmentOld newInstance(String tag2) {
        VenueListFragmentOld fr = new VenueListFragmentOld();
        fr.tag = tag2;
        return fr;
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("tag", this.tag);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        int size;
        this.f2106v = inflater.inflate(C0846R.layout.map_listview, container, false);
        if (savedInstanceState != null && this.tag == null) {
            this.tag = savedInstanceState.getString("tag");
        }
        this.menu = MenuFragment.newInstance(new ArrayList<>(), this);
        Fragments.addMenu(this, this.menu);
        this.menu.startLoader();
        this.mapFragment = (SupportMapFragment) getActivity().getSupportFragmentManager().findFragmentById(C0846R.C0847id.mapview);
        if (this.mapFragment == null) {
            this.mapFragment = new SupportMapFragment() {
                public void onActivityCreated(Bundle savedInstanceState) {
                    super.onActivityCreated(savedInstanceState);
                    VenueListFragmentOld.this.setupMap();
                }

                public void onDestroyView() {
                    super.onDestroyView();
                    VenueListFragmentOld.this.map = null;
                }
            };
            this.mapFragment.setRetainInstance(true);
            getChildFragmentManager().beginTransaction().replace(C0846R.C0847id.mapview, this.mapFragment).commit();
        }
        if (savedInstanceState != null) {
            this.map = this.mapFragment.getExtendedMap();
        }
        if (this.tag != null) {
            size = C1199DB.getQueryFromDb("SELECT v.image1, v.image_thumb1, v.id, v.name, group_concat(tag) tags, lat, lon FROM venues v INNER JOIN tags t ON v.id = t.venueid WHERE v.id IN (SELECT venueid FROM tags WHERE tag = '" + this.tag + "' COLLATE NOCASE) GROUP BY v.id ORDER BY v.order_value +0 DESC, v.name").size();
        } else {
            size = C1199DB.getQueryFromDb("SELECT v.image1, v.image_thumb1, v.id, v.name, group_concat(tag) tags, lat, lon FROM venues v INNER JOIN tags t ON v.id = t.venueid WHERE v.appid == " + App.f2123id + " GROUP BY v.id ORDER BY order_value +0 DESC, v.name").size();
        }
        if (size < 100) {
            showList();
            setListAdapter(new VenueAdapter(this.list));
            this.manager = (LocationManager) getActivity().getSystemService("location");
            this.manager.requestLocationUpdates("network", 5000, 100.0f, this.locationlistener);
            this.manager.requestLocationUpdates("gps", 5000, 100.0f, this.locationlistener);
        } else {
            new LoadListTask(this, (LoadListTask) null).execute(new Void[0]);
        }
        this.f2106v.findViewById(C0846R.C0847id.map_tab).setOnClickListener(this.switchtab);
        this.f2106v.findViewById(C0846R.C0847id.list_tab).setOnClickListener(this.switchtab);
        this.f2106v.findViewById(C0846R.C0847id.sorticons).setVisibility(8);
        return this.f2106v;
    }

    private class LoadListTask extends AsyncTask<Void, Object, Void> {
        private LoadListTask() {
        }

        /* synthetic */ LoadListTask(VenueListFragmentOld venueListFragmentOld, LoadListTask loadListTask) {
            this();
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(Void... params) {
            VenueListFragmentOld.this.showList();
            return null;
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Void result) {
            VenueListFragmentOld.this.setListAdapter(new VenueAdapter(VenueListFragmentOld.this.list));
            VenueListFragmentOld.this.manager = (LocationManager) VenueListFragmentOld.this.getActivity().getSystemService("location");
            VenueListFragmentOld.this.manager.requestLocationUpdates("network", 5000, 100.0f, VenueListFragmentOld.this.locationlistener);
            VenueListFragmentOld.this.manager.requestLocationUpdates("gps", 5000, 100.0f, VenueListFragmentOld.this.locationlistener);
            super.onPostExecute(result);
        }
    }

    public void showList() {
        List<TCObject> temp;
        this.list = new ArrayList();
        String where = "v.appid == " + App.f2123id;
        new ArrayList();
        if (this.tag != null) {
            temp = C1199DB.getQueryFromDb("SELECT v.image1, v.image_thumb1, v.id, v.name, group_concat(tag) tags, lat, lon FROM venues v INNER JOIN tags t ON v.id = t.venueid WHERE v.id IN (SELECT venueid FROM tags WHERE tag = '" + this.tag + "' COLLATE NOCASE) GROUP BY v.id ORDER BY v.order_value +0 DESC, v.name");
        } else {
            temp = C1199DB.getQueryFromDb("SELECT v.image1, v.image_thumb1, v.id, v.name, group_concat(tag) tags, lat, lon FROM venues v INNER JOIN tags t ON v.id = t.venueid WHERE " + where + " GROUP BY v.id ORDER BY order_value +0 DESC, v.name");
        }
        for (TCObject tco : temp) {
            this.list.add(new TCListObject(tco.get(DBFavorites.KEY_EVENT_ID, ""), tco.get(DBFavorites.KEY_NAME, ""), (String) null, "", "", tco.get("image1", tco.get("image_thumb1", "")), (int) C0846R.drawable.l_def_venues));
        }
    }

    public void setupMap() {
        if (this.map == null) {
            this.map = this.mapFragment.getExtendedMap();
            if (this.map != null) {
                this.map.setMyLocationEnabled(true);
                this.map.setClustering(new ClusteringSettings().clusterSize(180.0d).addMarkersDynamically(true).iconDataProvider(new IconProvider(getActivity())));
                this.map.getUiSettings().setZoomControlsEnabled(true);
                this.map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(50.7225468336323d, 4.5263671875d), 7.0f));
                this.map.setOnInfoWindowClickListener(this);
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
                    VenueListFragmentOld.this.map.moveCamera(CameraUpdateFactory.newLatLngBounds(builtBounds, 50));
                }
            });
        }
    }

    public void onDestroy() {
        super.onDestroy();
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

    public void onInfoWindowClick(Marker marker) {
        new LoadDataTask(this.idList.get(marker)).execute(new Void[0]);
    }

    public void onDestroyView() {
        super.onDestroyView();
        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
        ft.remove((SupportMapFragment) Fragments.f2128fa.getSupportFragmentManager().findFragmentById(C0846R.C0847id.mapview));
        ft.commit();
        this.map = null;
    }

    public void onResume() {
        super.onResume();
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
            Collections.sort(VenueListFragmentOld.this.list, this.sort);
            return null;
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Void result) {
            VenueListFragmentOld.this.setListAdapter(new VenueAdapter(VenueListFragmentOld.this.list));
            super.onPostExecute(result);
        }
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

    public void onListItemClick(ListView l, View v, int position, long id) {
        Object obj = l.getItemAtPosition(position);
        if (obj instanceof TCListObject) {
            new LoadDataTask(((TCListObject) obj).getId()).execute(new Void[0]);
        }
        super.onListItemClick(l, v, position, id);
    }

    public class LoadDataTask extends AsyncTask<Void, Void, Void> {
        private ProgressDialog dialog = new ProgressDialog(App.act);
        private String venueid;

        public LoadDataTask(String venueid2) {
            this.venueid = venueid2;
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            this.dialog = ProgressDialog.show(VenueListFragmentOld.this.getActivity(), C1199DB.getObject(GCMConstants.EXTRA_APPLICATION_PENDING_INTENT, DBFavorites.KEY_EVENT_ID, App.f2123id).get(DBFavorites.KEY_NAME), VenueListFragmentOld.this.getResourceString(C0846R.string.loading), false, true);
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
                        VenueListFragmentOld.this.analytics = "/venue/" + this.venueid;
                        Fragments.add(VenueListFragmentOld.this, TCLauncherPhoneFragment.newInstance("venueid", this.venueid), (String) null);
                        return;
                    }
                    for (TCObject item2 : list) {
                        if (LauncherUtil.hasFragment(item2)) {
                            VenueListFragmentOld.this.analytics = "/venue/" + this.venueid;
                            if (item2.get("moduletypeid").equals("21")) {
                                Fragments.add(VenueListFragmentOld.this, VenueInfoFragment.newInstance(this.venueid), item2.get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE));
                                return;
                            } else {
                                Fragments.add(VenueListFragmentOld.this, LauncherUtil.getFragment(item2), item2.get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE));
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    public static class VenueAdapter extends ArrayAdapter<Object> {
        private FastImageLoader fil = new FastImageLoader();
        private LayoutInflater mInflater = LayoutInflater.from(App.act);
        private boolean showDistance = true;

        private static class Holder {
            TextView date;
            TextView distance;
            ImageView icon;
            LinearLayout tagline;
            TextView text;

            private Holder() {
            }

            /* synthetic */ Holder(Holder holder) {
                this();
            }
        }

        public VenueAdapter(List<Object> list) {
            super(App.act, 0, list);
        }

        public void setShowDistance(boolean showDistance2) {
            this.showDistance = showDistance2;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            TextView tv;
            Holder holder;
            Object o = getItem(position);
            if (o.getClass() == TCListObject.class) {
                TCListObject tlo = (TCListObject) getItem(position);
                if (convertView == null) {
                    convertView = this.mInflater.inflate(C0846R.layout.cell_venue, (ViewGroup) null);
                    holder = new Holder((Holder) null);
                    holder.text = (TextView) convertView.findViewById(C0846R.C0847id.text);
                    holder.date = (TextView) convertView.findViewById(C0846R.C0847id.date);
                    holder.distance = (TextView) convertView.findViewById(C0846R.C0847id.distance);
                    holder.icon = (ImageView) convertView.findViewById(C0846R.C0847id.icon);
                    holder.tagline = (LinearLayout) convertView.findViewById(C0846R.C0847id.tagline);
                    convertView.setTag(holder);
                } else {
                    try {
                        holder = (Holder) convertView.getTag();
                    } catch (Exception e) {
                        convertView = this.mInflater.inflate(C0846R.layout.cell_venue, (ViewGroup) null);
                        holder = new Holder((Holder) null);
                        holder.text = (TextView) convertView.findViewById(C0846R.C0847id.text);
                        holder.date = (TextView) convertView.findViewById(C0846R.C0847id.date);
                        holder.distance = (TextView) convertView.findViewById(C0846R.C0847id.distance);
                        holder.tagline = (LinearLayout) convertView.findViewById(C0846R.C0847id.tagline);
                        holder.icon = (ImageView) convertView.findViewById(C0846R.C0847id.icon);
                        convertView.setTag(holder);
                    }
                }
                try {
                    if (tlo.getText() == null) {
                        holder.text.setVisibility(8);
                    } else {
                        holder.date.setVisibility(0);
                        holder.text.setText(tlo.getText());
                    }
                    if (tlo.getSub2() == "") {
                        holder.date.setVisibility(8);
                    } else {
                        holder.date.setVisibility(0);
                        holder.date.setText(tlo.getSub2());
                    }
                    if (tlo.getSub3() == "") {
                        holder.distance.setVisibility(8);
                    } else if (this.showDistance) {
                        holder.distance.setVisibility(0);
                        holder.distance.setText(tlo.getSub3());
                    } else {
                        holder.distance.setVisibility(8);
                    }
                    if (tlo.getSub1() != null) {
                        holder.tagline.removeAllViews();
                        holder.text.setMaxLines(1);
                        holder.text.setEllipsize(TextUtils.TruncateAt.END);
                        String[] temp = tlo.getSub1().split(",");
                        for (String s : temp) {
                            if (!s.equals("")) {
                                View tag = View.inflate(App.act, C0846R.layout.cell_tag, (ViewGroup) null);
                                ((TextView) tag.findViewById(C0846R.C0847id.text)).setText(s);
                                holder.tagline.addView(tag);
                            }
                        }
                    } else {
                        holder.text.setMaxLines(2);
                        holder.text.setEllipsize(TextUtils.TruncateAt.END);
                    }
                    if (tlo.getImg() == null) {
                        holder.icon.setVisibility(8);
                    } else {
                        holder.icon.setVisibility(0);
                        if (tlo.getImg().equals("")) {
                            holder.icon.setImageDrawable(C1232UI.getColorOverlay(tlo.getDefaultresource(), C1216LO.getLo(C1216LO.placeholderOverlayColor)));
                        } else {
                            holder.icon.setImageResource(tlo.getDefaultresource());
                            this.fil.DisplayImage(tlo.getImg(), holder.icon, holder.icon.getLayoutParams().height, holder.icon.getLayoutParams().width);
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return convertView;
            } else if (o.getClass() != String.class) {
                return new View(App.act);
            } else {
                if (convertView == null) {
                    convertView = this.mInflater.inflate(C0846R.layout.separator, (ViewGroup) null);
                    tv = (TextView) convertView.findViewById(C0846R.C0847id.text);
                    convertView.setTag(tv);
                } else {
                    try {
                        tv = (TextView) convertView.getTag();
                    } catch (Exception e3) {
                        convertView = this.mInflater.inflate(C0846R.layout.separator, (ViewGroup) null);
                        tv = (TextView) convertView.findViewById(C0846R.C0847id.text);
                        convertView.setTag(tv);
                    }
                }
                tv.setBackgroundColor(C1216LO.getLo(C1216LO.seperatorBackgroundColor));
                tv.setText((String) o);
                return convertView;
            }
        }
    }
}
