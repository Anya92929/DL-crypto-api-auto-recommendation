package com.tapcrowd.app.modules.business;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.support.p000v4.app.FragmentTransaction;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.actionbarsherlock.view.MenuItem;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.TCFragment;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import com.tapcrowd.app.modules.menuitems.MenuFragment;
import com.tapcrowd.app.modules.webview.WebViewFragment;
import com.tapcrowd.app.utils.AdHelper;
import com.tapcrowd.app.utils.C1199DB;
import com.tapcrowd.app.utils.C1216LO;
import com.tapcrowd.app.utils.C1232UI;
import com.tapcrowd.app.utils.Fragments;
import com.tapcrowd.app.utils.TCObject;
import com.tapcrowd.tcanalytics.TCAnalytics;
import java.util.ArrayList;

public class LocationFragment extends TCFragment implements MenuFragment.MenuItemListener {
    private final int NAVIGATE = 353;

    /* renamed from: id */
    String f2024id;
    GoogleMap map;

    /* renamed from: o */
    TCObject f2025o;

    /* renamed from: v */
    View f2026v;

    public static LocationFragment newInstance(String id) {
        LocationFragment loc = new LocationFragment();
        loc.f2024id = id;
        return loc;
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(DBFavorites.KEY_EVENT_ID, this.f2024id);
    }

    public void onResume() {
        super.onResume();
        if (this.f2025o.has("loggingpath")) {
            TCAnalytics.log(getActivity(), this.f2025o.get("loggingpath"), "");
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.f2026v = inflater.inflate(C0846R.layout.bus_location, container, false);
        AdHelper.showAds(this, AdHelper.buildPath("21", "detail", this.f2024id));
        if (savedInstanceState != null && this.f2024id == null) {
            this.f2024id = savedInstanceState.getString(DBFavorites.KEY_EVENT_ID);
        }
        this.f2025o = C1199DB.getObject("venues", DBFavorites.KEY_EVENT_ID, this.f2024id);
        if (this.f2025o.has("lat") && this.f2025o.has("lon")) {
            try {
                setMarker(new LatLng(Double.parseDouble(this.f2025o.get("lat")), Double.parseDouble(this.f2025o.get("lon"))));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (this.f2025o.has("travelinfo")) {
            ArrayList<MenuFragment.MenuItemContainer> items = new ArrayList<>();
            items.add(new MenuFragment.MenuItemContainer(C1232UI.getColorOverlay((int) C0846R.drawable.icon_navigate_white, C1216LO.getLo(C1216LO.navigationColor)), 353));
            Fragments.addMenu(this, MenuFragment.newInstance(items, this));
        }
        return this.f2026v;
    }

    public void setMarker(final LatLng loc) {
        if (loc != null) {
            if (this.map == null) {
                this.map = ((SupportMapFragment) Fragments.f2128fa.getSupportFragmentManager().findFragmentById(C0846R.C0847id.map)).getMap();
                if (this.map == null) {
                    return;
                }
            }
            this.map.getUiSettings().setZoomControlsEnabled(true);
            this.map.addMarker(new MarkerOptions().position(loc).title(this.f2025o.get(DBFavorites.KEY_NAME, "")).snippet(this.f2025o.get("address", "")).icon(BitmapDescriptorFactory.fromResource(C0846R.drawable.floorplanmarker)));
            final View mapView = Fragments.f2128fa.getSupportFragmentManager().findFragmentById(C0846R.C0847id.map).getView();
            if (mapView.getViewTreeObserver().isAlive()) {
                mapView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                    @SuppressLint({"NewApi"})
                    public void onGlobalLayout() {
                        if (Build.VERSION.SDK_INT < 16) {
                            mapView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                        } else {
                            mapView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        }
                        LocationFragment.this.map.animateCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder().target(loc).zoom(15.0f).build()));
                    }
                });
            }
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
        ft.remove((SupportMapFragment) Fragments.f2128fa.getSupportFragmentManager().findFragmentById(C0846R.C0847id.map));
        ft.commit();
    }

    public void click(MenuItem item) {
        switch (item.getItemId()) {
            case 353:
                String travinfo = this.f2025o.get("travelinfo");
                if (travinfo != null) {
                    Fragments.add(this, WebViewFragment.newInstance(Html.fromHtml(travinfo).toString(), (String) null, ""), getResourceString(C0846R.string.travel));
                    return;
                }
                return;
            default:
                return;
        }
    }
}
