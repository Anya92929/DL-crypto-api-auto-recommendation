package com.tapcrowd.app.modules.findmy;

import android.location.Location;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.FBFragment;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import com.tapcrowd.app.utils.Internet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p005pl.mg6.android.maps.extensions.GoogleMap;
import p005pl.mg6.android.maps.extensions.Marker;
import p005pl.mg6.android.maps.extensions.SupportMapFragment;
import twitter4j.conf.PropertyConfiguration;

public class FindMyFriendsFragment extends FBFragment implements GoogleMap.OnInfoWindowClickListener {
    private boolean authorized;
    /* access modifiers changed from: private */
    public Location location;
    /* access modifiers changed from: private */
    public GoogleMap map;
    private SupportMapFragment mapFragment;

    public static FindMyFriendsFragment newInstance() {
        return new FindMyFriendsFragment();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (this.f2005v == null) {
            this.f2005v = inflater.inflate(C0846R.layout.findfriends, container, false);
        } else {
            this.retained = true;
            ((ViewGroup) this.f2005v.getParent()).removeView(this.f2005v);
        }
        return this.f2005v;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.mapFragment = (SupportMapFragment) getActivity().getSupportFragmentManager().findFragmentById(C0846R.C0847id.mapview);
        if (this.mapFragment == null) {
            this.mapFragment = new SupportMapFragment() {
                public void onActivityCreated(Bundle savedInstanceState) {
                    super.onActivityCreated(savedInstanceState);
                    FindMyFriendsFragment.this.setupMap();
                }

                public void onDestroyView() {
                    super.onDestroyView();
                    FindMyFriendsFragment.this.map = null;
                }
            };
            this.mapFragment.setRetainInstance(true);
            getChildFragmentManager().beginTransaction().replace(C0846R.C0847id.mapview, this.mapFragment).commit();
        }
        if (!this.retained) {
            authorize();
        }
    }

    /* access modifiers changed from: private */
    public void setupMap() {
        if (this.map == null) {
            this.map = this.mapFragment.getExtendedMap();
            if (this.map != null) {
                this.map.setMyLocationEnabled(true);
                this.map.getUiSettings().setZoomControlsEnabled(true);
                this.map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(50.7225468336323d, 4.5263671875d), 7.0f));
                this.map.setOnInfoWindowClickListener(this);
                this.map.setOnMyLocationChangeListener(new GoogleMap.OnMyLocationChangeListener() {
                    public void onMyLocationChange(Location location) {
                        if (FindMyFriendsFragment.this.location == null) {
                            FindMyFriendsFragment.this.location = location;
                            FindMyFriendsFragment.this.startSync();
                        }
                    }
                });
            }
        }
    }

    public void onInfoWindowClick(Marker marker) {
    }

    public void onAuthorize() {
        this.authorized = true;
        startSync();
    }

    public void startSync() {
        if (this.location != null && this.authorized) {
            new SyncThread(this, (SyncThread) null).start();
        }
    }

    private class SyncThread extends Thread {
        /* access modifiers changed from: private */
        public LatLngBounds.Builder bounds;
        private String fbid;
        /* access modifiers changed from: private */
        public List<MarkerOptions> options;

        private SyncThread() {
            this.options = new ArrayList();
        }

        /* synthetic */ SyncThread(FindMyFriendsFragment findMyFriendsFragment, SyncThread syncThread) {
            this();
        }

        public void run() {
            super.run();
            try {
                Internet.request("insertFbFriends", createParamsInsert());
                BitmapDescriptor pointer = BitmapDescriptorFactory.fromResource(C0846R.drawable.pointer);
                this.bounds = LatLngBounds.builder();
                JSONArray ar = new JSONArray(Internet.request("getFbfriends", createParamsGet()));
                int len = ar.length();
                for (int i = 0; i < len; i++) {
                    JSONObject buddy = ar.getJSONObject(i);
                    double lat = Double.parseDouble(buddy.getString("lat"));
                    double lon = Double.parseDouble(buddy.getString("lon"));
                    String name = buddy.getString(DBFavorites.KEY_NAME);
                    LatLng latlng = new LatLng(lat, lon);
                    this.bounds.include(latlng);
                    this.options.add(new MarkerOptions().icon(pointer).title(name).position(latlng));
                }
                FindMyFriendsFragment.this.getActivity().runOnUiThread(new Runnable() {
                    public void run() {
                        for (MarkerOptions option : SyncThread.this.options) {
                            FindMyFriendsFragment.this.map.addMarker(option);
                        }
                        FindMyFriendsFragment.this.map.animateCamera(CameraUpdateFactory.newLatLngBounds(SyncThread.this.bounds.build(), 50));
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private List<NameValuePair> createParamsInsert() throws JSONException, IOException {
            JSONObject me = new JSONObject(FindMyFriendsFragment.this.facebook.request("me"));
            JSONObject user = new JSONObject();
            user.put("fbid", me.getString(DBFavorites.KEY_EVENT_ID));
            user.put(DBFavorites.KEY_NAME, me.getString(DBFavorites.KEY_NAME));
            user.put("lat", new StringBuilder(String.valueOf(FindMyFriendsFragment.this.location.getLatitude())).toString());
            user.put("lon", new StringBuilder(String.valueOf(FindMyFriendsFragment.this.location.getLongitude())).toString());
            this.fbid = me.getString(DBFavorites.KEY_EVENT_ID);
            JSONObject friendlist = new JSONObject(FindMyFriendsFragment.this.facebook.request("me/friends"));
            JSONArray friends = new JSONArray();
            if (friendlist.has("data")) {
                JSONArray ar = friendlist.getJSONArray("data");
                int len = ar.length();
                for (int i = 0; i < len; i++) {
                    JSONObject friend = new JSONObject();
                    friend.put("fbid", ((JSONObject) ar.get(i)).getString(DBFavorites.KEY_EVENT_ID));
                    friend.put(DBFavorites.KEY_NAME, ((JSONObject) ar.get(i)).getString(DBFavorites.KEY_NAME));
                    friends.put(friend);
                }
            }
            List<NameValuePair> parameters = new ArrayList<>();
            parameters.add(new BasicNameValuePair(PropertyConfiguration.USER, user.toString()));
            parameters.add(new BasicNameValuePair("friends", friends.toString()));
            return parameters;
        }

        private List<NameValuePair> createParamsGet() throws JSONException, IOException {
            List<NameValuePair> parameters = new ArrayList<>();
            parameters.add(new BasicNameValuePair("fbid", this.fbid));
            return parameters;
        }
    }
}
