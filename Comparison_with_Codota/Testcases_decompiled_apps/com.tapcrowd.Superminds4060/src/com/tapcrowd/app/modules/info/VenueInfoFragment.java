package com.tapcrowd.app.modules.info;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.TCFragment;
import com.tapcrowd.app.modules.Gallery;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import com.tapcrowd.app.modules.webview.WebViewFragment;
import com.tapcrowd.app.utils.Actions;
import com.tapcrowd.app.utils.AdHelper;
import com.tapcrowd.app.utils.App;
import com.tapcrowd.app.utils.C1199DB;
import com.tapcrowd.app.utils.C1216LO;
import com.tapcrowd.app.utils.C1232UI;
import com.tapcrowd.app.utils.Fragments;
import com.tapcrowd.app.utils.IconProvider;
import com.tapcrowd.app.utils.TCObject;
import com.tapcrowd.app.utils.images.FastImageLoader;
import com.tapcrowd.tcanalytics.TCAnalytics;
import p005pl.mg6.android.maps.extensions.ClusteringSettings;
import p005pl.mg6.android.maps.extensions.GoogleMap;
import p005pl.mg6.android.maps.extensions.SupportMapFragment;

public class VenueInfoFragment extends TCFragment {

    /* renamed from: id */
    String f2054id;
    /* access modifiers changed from: private */
    public GoogleMap map;
    private SupportMapFragment mapFragment;

    /* renamed from: o */
    TCObject f2055o;

    /* renamed from: v */
    View f2056v;

    public static VenueInfoFragment newInstance(String id) {
        VenueInfoFragment fr = new VenueInfoFragment();
        fr.f2054id = id;
        return fr;
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(DBFavorites.KEY_EVENT_ID, this.f2054id);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.f2056v = inflater.inflate(C0846R.layout.infovenue, container, false);
        AdHelper.showAds(this, AdHelper.buildPath("21", "detail", this.f2054id));
        if (savedInstanceState != null && this.f2054id == null) {
            this.f2054id = savedInstanceState.getString(DBFavorites.KEY_EVENT_ID);
        }
        this.f2055o = C1199DB.getObject("venues", DBFavorites.KEY_EVENT_ID, this.f2054id);
        C1232UI.setText((int) C0846R.C0847id.naamEvent, this.f2055o.get(DBFavorites.KEY_NAME), this.f2056v);
        C1232UI.setText((int) C0846R.C0847id.address, this.f2055o.get("address"), this.f2056v);
        C1232UI.setText((int) C0846R.C0847id.description, this.f2055o.get("info"), this.f2056v);
        if (this.f2055o.has("image1")) {
            this.f2056v.findViewById(C0846R.C0847id.icon).post(new Runnable() {
                public void run() {
                    FastImageLoader fil = new FastImageLoader();
                    ImageView icon = (ImageView) VenueInfoFragment.this.f2056v.findViewById(C0846R.C0847id.icon);
                    fil.DisplayImage(VenueInfoFragment.this.f2055o.get("image1"), icon, icon.getHeight(), icon.getWidth());
                }
            });
        } else {
            C1232UI.hide(C0846R.C0847id.icon, this.f2056v);
        }
        this.f2056v.findViewById(C0846R.C0847id.header).setBackgroundColor(C1216LO.getLo(C1216LO.titleBackgroundColor));
        ((TextView) this.f2056v.findViewById(C0846R.C0847id.naamEvent)).setTextColor(C1216LO.getLo(C1216LO.titleFontColor));
        ((TextView) this.f2056v.findViewById(C0846R.C0847id.address)).setTextColor(C1216LO.getLo(C1216LO.titleFontColor));
        if (this.f2055o.has("telephone") || this.f2055o.has("email") || this.f2055o.has("website") || this.f2055o.has("image2")) {
            C1232UI.addSep(getResourceString(C0846R.string.sepInfo), this.f2056v);
        }
        C1232UI.addCell(this.f2056v, this.f2055o.get("telephone"), (View.OnClickListener) new View.OnClickListener() {
            public void onClick(View v) {
                Actions.doCall(VenueInfoFragment.this.f2055o.get("telephone"));
            }
        }, C1232UI.getColorOverlay((int) C0846R.drawable.icon_tel, C1216LO.getLo(C1216LO.actionImageOverlayColor))).setBackgroundDrawable(C1232UI.getBackground());
        C1232UI.addCell(this.f2056v, this.f2055o.get("fax"), (View.OnClickListener) null, C1232UI.getColorOverlay((int) C0846R.drawable.icon_fax, C1216LO.getLo(C1216LO.actionImageOverlayColor))).setBackgroundDrawable(C1232UI.getBackground());
        C1232UI.addCell(this.f2056v, this.f2055o.get("email"), (View.OnClickListener) new View.OnClickListener() {
            public void onClick(View v) {
                Actions.doMail(VenueInfoFragment.this.f2055o.get("email"));
            }
        }, C1232UI.getColorOverlay((int) C0846R.drawable.icon_email_black, C1216LO.getLo(C1216LO.actionImageOverlayColor))).setBackgroundDrawable(C1232UI.getBackground());
        C1232UI.addCell(this.f2056v, this.f2055o.get("website"), (View.OnClickListener) new View.OnClickListener() {
            public void onClick(View v) {
                Fragments.add(VenueInfoFragment.this, WebViewFragment.newInstance(VenueInfoFragment.this.f2055o.get("website"), true), (String) null);
            }
        }, 1, C1232UI.getColorOverlay((int) C0846R.drawable.icon_website_black, C1216LO.getLo(C1216LO.actionImageOverlayColor))).setBackgroundDrawable(C1232UI.getBackground());
        if (this.f2055o.has("image1")) {
            C1232UI.addCell(this.f2056v, getResourceString(C0846R.string.showmorepics), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View v) {
                    Intent i = new Intent(App.act, Gallery.class);
                    String urls = VenueInfoFragment.this.f2055o.get("image1");
                    if (VenueInfoFragment.this.f2055o.has("image2")) {
                        urls = String.valueOf(urls) + "," + VenueInfoFragment.this.f2055o.get("image2");
                    }
                    if (VenueInfoFragment.this.f2055o.has("image3")) {
                        urls = String.valueOf(urls) + "," + VenueInfoFragment.this.f2055o.get("image3");
                    }
                    if (VenueInfoFragment.this.f2055o.has("image4")) {
                        urls = String.valueOf(urls) + "," + VenueInfoFragment.this.f2055o.get("image4");
                    }
                    if (VenueInfoFragment.this.f2055o.has("image5")) {
                        urls = String.valueOf(urls) + "," + VenueInfoFragment.this.f2055o.get("image5");
                    }
                    for (TCObject meta : C1199DB.getQueryFromDb("SELECT value FROM metavalues WHERE type == 'image' AND  parentType == 'venue' AND parentId == '" + VenueInfoFragment.this.f2055o.get(DBFavorites.KEY_EVENT_ID) + "'")) {
                        urls = String.valueOf(urls) + meta.get("value") + ",";
                    }
                    i.putExtra("urls", urls);
                    VenueInfoFragment.this.startActivity(i);
                }
            }, C1232UI.getColorOverlay((int) C0846R.drawable.icon_photos, C1216LO.getLo(C1216LO.actionImageOverlayColor)));
        }
        if (this.f2055o.has("facebookurl")) {
            C1232UI.addCell(this.f2056v, "Facebook", (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View v) {
                    Actions.openWebview(VenueInfoFragment.this, VenueInfoFragment.this.f2055o.get("facebookurl"));
                }
            }, C1232UI.getColorOverlay((int) C0846R.drawable.sesfb, C1216LO.getLo(C1216LO.actionImageOverlayColor))).setBackgroundDrawable(C1232UI.getBackground());
        }
        if (this.f2055o.has("twitterurl")) {
            C1232UI.addCell(this.f2056v, getResourceString(C0846R.string.showmorepics), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View v) {
                    Actions.openWebview(VenueInfoFragment.this, VenueInfoFragment.this.f2055o.get("twitterurl"));
                }
            }, C1232UI.getColorOverlay((int) C0846R.drawable.sestwit, C1216LO.getLo(C1216LO.actionImageOverlayColor))).setBackgroundDrawable(C1232UI.getBackground());
        }
        C1232UI.AddMetaData(this, "venue", this.f2055o.get(DBFavorites.KEY_EVENT_ID), this.f2056v);
        return this.f2056v;
    }

    public void onResume() {
        super.onResume();
        if (this.f2055o.has("loggingpath")) {
            TCAnalytics.log(getActivity(), this.f2055o.get("loggingpath"), "");
        }
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        this.mapFragment = (SupportMapFragment) getActivity().getSupportFragmentManager().findFragmentById(C0846R.C0847id.map);
        if (this.mapFragment == null) {
            this.mapFragment = new SupportMapFragment() {
                public void onActivityCreated(Bundle savedInstanceState) {
                    super.onActivityCreated(savedInstanceState);
                    VenueInfoFragment.this.setupMap();
                }

                public void onDestroyView() {
                    super.onDestroyView();
                    VenueInfoFragment.this.map = null;
                }
            };
            this.mapFragment.setRetainInstance(true);
            getChildFragmentManager().beginTransaction().replace(C0846R.C0847id.map, this.mapFragment).commit();
        }
        if (savedInstanceState != null) {
            this.map = this.mapFragment.getExtendedMap();
        }
        super.onActivityCreated(savedInstanceState);
    }

    public void setupMap() {
        if (this.map == null) {
            this.map = this.mapFragment.getExtendedMap();
            if (this.map != null) {
                this.map.setMyLocationEnabled(true);
                this.map.setClustering(new ClusteringSettings().clusterSize(180.0d).addMarkersDynamically(true).iconDataProvider(new IconProvider(getActivity())));
                this.map.getUiSettings().setZoomControlsEnabled(true);
                this.map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(50.7225468336323d, 4.5263671875d), 7.0f));
                if (this.f2055o.has("lat") && this.f2055o.has("lon")) {
                    try {
                        setMarker(new LatLng(Double.parseDouble(this.f2055o.get("lat")), Double.parseDouble(this.f2055o.get("lon"))));
                    } catch (Exception e) {
                        C1232UI.hide(C0846R.C0847id.map, this.f2056v);
                    }
                }
            }
        }
    }

    public void setMarker(final LatLng loc) {
        this.map.addMarker(new MarkerOptions().position(loc).title(this.f2055o.get(DBFavorites.KEY_NAME, "")).snippet(this.f2055o.get("address", "")).icon(BitmapDescriptorFactory.fromResource(C0846R.drawable.floorplanmarker)));
        final View mapView = this.mapFragment.getView();
        if (mapView.getViewTreeObserver().isAlive()) {
            mapView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                @SuppressLint({"NewApi"})
                public void onGlobalLayout() {
                    LatLngBounds.Builder bounds = new LatLngBounds.Builder();
                    bounds.include(loc);
                    LatLngBounds builtBounds = bounds.build();
                    if (Build.VERSION.SDK_INT < 16) {
                        mapView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    } else {
                        mapView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                    VenueInfoFragment.this.map.moveCamera(CameraUpdateFactory.newLatLngBounds(builtBounds, 50));
                }
            });
        }
    }
}
