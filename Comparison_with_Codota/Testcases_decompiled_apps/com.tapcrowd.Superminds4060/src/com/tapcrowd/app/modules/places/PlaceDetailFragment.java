package com.tapcrowd.app.modules.places;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.support.p000v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.plus.PlusShare;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.TCFragment;
import com.tapcrowd.app.modules.Gallery;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import com.tapcrowd.app.utils.Actions;
import com.tapcrowd.app.utils.AdHelper;
import com.tapcrowd.app.utils.C1199DB;
import com.tapcrowd.app.utils.C1216LO;
import com.tapcrowd.app.utils.C1232UI;
import com.tapcrowd.app.utils.TCObject;
import com.tapcrowd.tcanalytics.TCAnalytics;

public class PlaceDetailFragment extends TCFragment {
    private SupportMapFragment mapfragment;
    TCObject place;
    String urls;

    /* renamed from: v */
    View f2102v;

    public static PlaceDetailFragment newInstance(String id) {
        PlaceDetailFragment fr = new PlaceDetailFragment();
        fr.place = C1199DB.getFirstObject("places", DBFavorites.KEY_EVENT_ID, id);
        return fr;
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(DBFavorites.KEY_EVENT_ID, this.place.get(DBFavorites.KEY_EVENT_ID));
    }

    public void onResume() {
        super.onResume();
        if (this.place.has("loggingpath")) {
            TCAnalytics.log(getActivity(), this.place.get("loggingpath"), "");
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.f2102v = inflater.inflate(C0846R.layout.infovenue, container, false);
        AdHelper.showAds(this, AdHelper.buildPath("54", "detail", this.place.get(DBFavorites.KEY_EVENT_ID)));
        if (savedInstanceState != null && this.place == null) {
            this.place = C1199DB.getFirstObject("places", DBFavorites.KEY_EVENT_ID, savedInstanceState.getString(DBFavorites.KEY_EVENT_ID));
        }
        ((ImageView) this.f2102v.findViewById(C0846R.C0847id.icon)).setVisibility(8);
        C1232UI.setText((int) C0846R.C0847id.naamEvent, this.place.get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, ""), this.f2102v);
        C1232UI.setText((int) C0846R.C0847id.address, this.place.get("addr", ""), this.f2102v);
        C1232UI.setText((int) C0846R.C0847id.description, this.place.get("info", ""), this.f2102v);
        this.f2102v.findViewById(C0846R.C0847id.header).setBackgroundColor(C1216LO.getLo(C1216LO.titleBackgroundColor));
        ((TextView) this.f2102v.findViewById(C0846R.C0847id.naamEvent)).setTextColor(C1216LO.getLo(C1216LO.titleFontColor));
        ((TextView) this.f2102v.findViewById(C0846R.C0847id.address)).setTextColor(C1216LO.getLo(C1216LO.titleFontColor));
        this.urls = "";
        if (this.place.has("imageurl")) {
            this.urls = String.valueOf(this.urls) + this.place.get("imageurl") + ",";
        }
        for (TCObject meta : C1199DB.getQueryFromDb("SELECT value FROM metavalues WHERE type == 'image' AND  parentType == 'place' AND parentId == '" + this.place.get(DBFavorites.KEY_EVENT_ID) + "'")) {
            this.urls = String.valueOf(this.urls) + meta.get("value") + ",";
        }
        if (this.urls.length() > 0) {
            C1232UI.addCell(this.f2102v, getResourceString(C0846R.string.showmorepics), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent = new Intent(PlaceDetailFragment.this.getActivity(), Gallery.class);
                    intent.putExtra("urls", PlaceDetailFragment.this.urls);
                    PlaceDetailFragment.this.startActivity(intent);
                }
            }, C1232UI.getColorOverlay((int) C0846R.drawable.frame, C1216LO.getLo(C1216LO.actionImageOverlayColor))).setBackgroundDrawable(C1232UI.getBackground());
        }
        if (this.place.has("addr")) {
            C1232UI.addCell(this.f2102v, this.place.get("addr"), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View v) {
                    Actions.doNavigate(PlaceDetailFragment.this.place.get("addr"));
                }
            }, C1232UI.getColorOverlay((int) C0846R.drawable.icon_navigate_white, C1216LO.getLo(C1216LO.actionImageOverlayColor))).setBackgroundDrawable(C1232UI.getBackground());
        }
        C1232UI.AddMetaData(this, "place", this.place.get(DBFavorites.KEY_EVENT_ID), this.f2102v);
        this.mapfragment = new SupportMapFragment() {
            public void onActivityCreated(Bundle savedInstanceState) {
                super.onActivityCreated(savedInstanceState);
                PlaceDetailFragment.this.setMarker(new LatLng(Double.parseDouble(PlaceDetailFragment.this.place.get("lat")), Double.parseDouble(PlaceDetailFragment.this.place.get("lng"))));
            }
        };
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.add((int) C0846R.C0847id.map, (Fragment) this.mapfragment);
        transaction.commit();
        return this.f2102v;
    }

    public void setMarker(final LatLng loc) {
        if (loc != null) {
            final GoogleMap map = this.mapfragment.getMap();
            map.getUiSettings().setZoomControlsEnabled(false);
            map.addMarker(new MarkerOptions().position(loc).title(this.place.get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, "")).snippet(this.place.get("addr", "")).icon(BitmapDescriptorFactory.fromResource(C0846R.drawable.floorplanmarker)));
            final View mapView = this.mapfragment.getView();
            if (mapView.getViewTreeObserver().isAlive()) {
                mapView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                    @SuppressLint({"NewApi"})
                    public void onGlobalLayout() {
                        new CameraPosition.Builder().target(loc).tilt(50.0f).build();
                        final LatLngBounds bounds = new LatLngBounds.Builder().include(loc).build();
                        if (Build.VERSION.SDK_INT < 16) {
                            mapView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                        } else {
                            mapView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        }
                        View findViewById = PlaceDetailFragment.this.f2102v.findViewById(C0846R.C0847id.map);
                        final GoogleMap googleMap = map;
                        findViewById.post(new Runnable() {
                            public void run() {
                                View mapview = PlaceDetailFragment.this.f2102v.findViewById(C0846R.C0847id.map);
                                googleMap.moveCamera(CameraUpdateFactory.newLatLngBounds(bounds, mapview.getWidth(), mapview.getHeight(), 50));
                            }
                        });
                    }
                });
            }
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
        ft.remove(this.mapfragment);
        ft.commit();
    }
}
