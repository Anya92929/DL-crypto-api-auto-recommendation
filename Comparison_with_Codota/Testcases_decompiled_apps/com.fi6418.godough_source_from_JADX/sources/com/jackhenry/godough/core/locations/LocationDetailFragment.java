package com.jackhenry.godough.core.locations;

import android.graphics.Color;
import android.graphics.drawable.LayerDrawable;
import android.location.Location;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.OnStreetViewPanoramaReadyCallback;
import com.google.android.gms.maps.StreetViewPanorama;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.SupportStreetViewPanoramaFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.maps.model.StreetViewPanoramaLink;
import com.google.android.gms.maps.model.StreetViewPanoramaLocation;
import com.jackhenry.android.p022a.C1364k;
import com.jackhenry.godough.core.AbstractActivity;
import com.jackhenry.godough.core.C1493ah;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.C1802r;
import com.jackhenry.godough.core.model.GoDoughLocation;
import com.jackhenry.godough.core.model.LocationSearchCriteria;
import com.jackhenry.godough.core.p032a.C1408a;
import com.jackhenry.godough.core.p038e.C1581j;
import com.jackhenry.godough.core.p038e.C1582k;
import com.jackhenry.godough.core.p038e.C1583l;
import com.jackhenry.godough.core.p038e.C1586o;
import java.util.ArrayList;
import java.util.List;

public class LocationDetailFragment extends C1802r implements View.OnClickListener, OnMapReadyCallback, OnStreetViewPanoramaReadyCallback, StreetViewPanorama.OnStreetViewPanoramaChangeListener {

    /* renamed from: a */
    boolean f6181a = true;

    /* renamed from: aj */
    private float f6182aj = 12.0f;
    /* access modifiers changed from: private */

    /* renamed from: ak */
    public transient RelativeLayout f6183ak;

    /* renamed from: al */
    private TextView f6184al;

    /* renamed from: am */
    private View f6185am;

    /* renamed from: an */
    private GoDoughLocation f6186an;
    /* access modifiers changed from: private */

    /* renamed from: ao */
    public transient SupportStreetViewPanoramaFragment f6187ao;
    /* access modifiers changed from: private */

    /* renamed from: ap */
    public transient RelativeLayout f6188ap;
    /* access modifiers changed from: private */

    /* renamed from: aq */
    public Button f6189aq;

    /* renamed from: ar */
    private TextView f6190ar;

    /* renamed from: as */
    private int f6191as = Color.parseColor("#80000000");

    /* renamed from: at */
    private GoogleMap f6192at;
    /* access modifiers changed from: private */

    /* renamed from: au */
    public boolean f6193au = false;

    /* renamed from: b */
    float f6194b = -9999.0f;

    /* renamed from: c */
    float f6195c = -9999.0f;

    /* renamed from: d */
    float f6196d = -9999.0f;

    /* renamed from: e */
    StreetViewPanoramaLocation f6197e;

    /* renamed from: f */
    StreetViewPanorama f6198f;

    /* renamed from: g */
    ScrollView f6199g;

    /* renamed from: h */
    private int f6200h = 0;

    /* renamed from: i */
    private int f6201i = 0;

    /* renamed from: a */
    private float m6232a(double d, double d2, double d3, double d4) {
        if (this.f6194b != -9999.0f) {
            return this.f6194b;
        }
        Location location = new Location("startlocation");
        location.setLatitude(d);
        location.setLongitude(d2);
        Location location2 = new Location("endlocation");
        location2.setLatitude(d3);
        location2.setLongitude(d4);
        float bearingTo = location.bearingTo(location2);
        return bearingTo < BitmapDescriptorFactory.HUE_RED ? bearingTo + 360.0f : bearingTo;
    }

    /* renamed from: n */
    private float m6240n() {
        return this.f6195c == -9999.0f ? BitmapDescriptorFactory.HUE_RED : this.f6195c;
    }

    /* renamed from: o */
    private float m6241o() {
        return this.f6196d == -9999.0f ? BitmapDescriptorFactory.HUE_RED : this.f6196d;
    }

    /* access modifiers changed from: private */
    /* renamed from: p */
    public void m6242p() {
        String string;
        C1408a aVar;
        if (this.f6188ap.getHeight() > 0) {
            string = getResources().getString(C1506am.lbl_show_streetview);
            aVar = new C1408a(this.f6188ap, 0, 0);
        } else {
            string = getResources().getString(C1506am.lbl_hide_streetview);
            aVar = new C1408a(this.f6188ap, 0, (int) TypedValue.applyDimension(1, 250.0f, getResources().getDisplayMetrics()));
        }
        aVar.setAnimationListener(new C1612k(this, string));
        this.f6188ap.startAnimation(aVar);
        this.f6188ap.invalidate();
        this.f6199g.invalidate();
        this.f6189aq.invalidate();
    }

    public void onClick(View view) {
        TextView textView = (TextView) view.findViewById(C1494ai.icon_label);
        TextView textView2 = (TextView) view.findViewById(C1494ai.info_text);
        if (textView == null) {
            return;
        }
        if (textView.getText().toString().equals(getString(C1506am.lbl_email))) {
            C1581j.m6157b(getActivity(), textView2.getText().toString());
        } else if (textView.getText().toString().equals(getString(C1506am.lbl_call))) {
            C1581j.m6156a(getActivity(), textView2.getText().toString());
        } else if (!textView.getText().toString().equals(getString(C1506am.lbl_directions))) {
        } else {
            if (this.f6186an.getLatitude() == 0.0d || this.f6186an.getLongitude() == 0.0d) {
                ((AbstractActivity) getActivity()).showDialog(getString(C1506am.dg_error_title), getString(C1506am.location_no_directions));
            } else {
                C1581j.m6158c(getActivity(), textView2.getText().toString());
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (bundle != null) {
            this.f6193au = bundle.getBoolean("STREET_VIEW_EXPANDED", false);
        }
        View inflate = layoutInflater.inflate(C1496ak.location_detail_fragment, viewGroup);
        this.f6184al = (TextView) inflate.findViewById(C1494ai.tvNoPlot);
        this.f6185am = inflate.findViewById(C1494ai.viewNoPlot);
        this.f6190ar = (TextView) inflate.findViewById(C1494ai.tvNoPlotStreetView);
        this.f6186an = (GoDoughLocation) getActivity().getIntent().getSerializableExtra(LocationSearchCriteria.KEY_LOCATION);
        if (!this.f6186an.isAtm()) {
            ((ImageView) inflate.findViewById(C1494ai.atm_icon)).setVisibility(8);
            ((TextView) inflate.findViewById(C1494ai.atm_label)).setVisibility(8);
        }
        if (!this.f6186an.isLobby()) {
            ((ImageView) inflate.findViewById(C1494ai.branch_icon)).setVisibility(8);
            ((TextView) inflate.findViewById(C1494ai.branch_label)).setVisibility(8);
        }
        if (this.f6197e == null) {
            this.f6197e = new StreetViewPanoramaLocation((StreetViewPanoramaLink[]) null, new LatLng(this.f6186an.getLatitude(), this.f6186an.getLongitude()), (String) null);
        }
        TextView textView = (TextView) inflate.findViewById(C1494ai.header);
        textView.setText(this.f6186an.getLocationName());
        C1586o.m6198a((LayerDrawable) textView.getBackground());
        this.f6199g = (ScrollView) inflate.findViewById(C1494ai.scroll_view);
        this.f6183ak = (RelativeLayout) inflate.findViewById(C1494ai.map_layout);
        this.f6183ak.getLayoutParams().height = this.f6200h;
        this.f6183ak.requestLayout();
        Button button = (Button) inflate.findViewById(C1494ai.show_map_btn);
        if (this.f6183ak.getHeight() > 0) {
            button.setText(C1506am.lbl_hide_map);
        }
        this.f6188ap = (RelativeLayout) inflate.findViewById(C1494ai.streetview_layout);
        this.f6188ap.getLayoutParams().height = this.f6201i;
        this.f6188ap.requestLayout();
        this.f6189aq = (Button) inflate.findViewById(C1494ai.show_streetview_btn);
        this.f6189aq.setVisibility(0);
        this.f6189aq.setEnabled(false);
        if (this.f6188ap.getHeight() > 0) {
            this.f6189aq.setText(C1506am.lbl_hide_streetview);
        }
        ViewGroup viewGroup2 = (ViewGroup) inflate.findViewById(C1494ai.row_panel);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new C1583l(C1494ai.section_text, getString(C1506am.lbl_address)));
        arrayList.add(new C1583l(C1494ai.info_text, this.f6186an.getAddress1() + " " + this.f6186an.getAddress2() + " " + this.f6186an.getCity() + ", " + this.f6186an.getState() + " " + this.f6186an.getZipCode()));
        arrayList.add(new C1583l(C1494ai.icon, C1493ah.ic_directions));
        arrayList.add(new C1583l(C1494ai.icon_label, getString(C1506am.lbl_directions)));
        C1582k.m6159a((List<C1583l>) arrayList, viewGroup2, layoutInflater, (View.OnClickListener) this);
        if (C1364k.m5591b(this.f6186an.getPhoneNumber())) {
            arrayList.clear();
            arrayList.add(new C1583l(C1494ai.section_text, getString(C1506am.lbl_phone)));
            arrayList.add(new C1583l(C1494ai.info_text, this.f6186an.getPhoneNumber()));
            arrayList.add(new C1583l(C1494ai.icon, C1493ah.ic_call));
            arrayList.add(new C1583l(C1494ai.icon_label, getString(C1506am.lbl_call)));
            C1582k.m6159a((List<C1583l>) arrayList, viewGroup2, layoutInflater, (View.OnClickListener) this);
        }
        if (C1364k.m5591b(this.f6186an.getEmail())) {
            arrayList.clear();
            arrayList.add(new C1583l(C1494ai.section_text, getString(C1506am.lbl_email)));
            arrayList.add(new C1583l(C1494ai.info_text, this.f6186an.getEmail()));
            arrayList.add(new C1583l(C1494ai.icon, C1493ah.ic_email));
            arrayList.add(new C1583l(C1494ai.icon_label, getString(C1506am.lbl_email)));
            C1582k.m6159a((List<C1583l>) arrayList, viewGroup2, layoutInflater, (View.OnClickListener) this);
        }
        this.f6187ao = (SupportStreetViewPanoramaFragment) getChildFragmentManager().findFragmentById(C1494ai.streetview);
        this.f6187ao.getStreetViewPanoramaAsync(this);
        this.f6190ar.setVisibility(0);
        this.f6190ar.setText(C1506am.dg_loading);
        ((SupportMapFragment) getChildFragmentManager().findFragmentById(C1494ai.map)).getMapAsync(this);
        this.f6184al.setVisibility(0);
        this.f6184al.setText(C1506am.dg_loading);
        this.f6189aq.setOnClickListener(new C1608g(this));
        if (this.f6198f != null && this.f6193au) {
            m6242p();
        }
        button.setOnClickListener(new C1609h(this, button));
        return inflate;
    }

    public void onMapReady(GoogleMap googleMap) {
        if (googleMap != null) {
            this.f6192at = googleMap;
            googleMap.setMyLocationEnabled(true);
            googleMap.getUiSettings().setAllGesturesEnabled(false);
            googleMap.getUiSettings().setMyLocationButtonEnabled(false);
            googleMap.getUiSettings().setZoomControlsEnabled(true);
            if (!(this.f6186an.getLatitude() == 0.0d || this.f6186an.getLongitude() == 0.0d)) {
                googleMap.addMarker(new MarkerOptions().position(new LatLng(this.f6186an.getLatitude(), this.f6186an.getLongitude())));
            }
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(this.f6186an.getLatitude(), this.f6186an.getLongitude()), this.f6182aj));
            if (this.f6186an.getLatitude() == 0.0d || this.f6186an.getLongitude() == 0.0d) {
                this.f6184al.setText(C1506am.location_no_plot);
                this.f6184al.setVisibility(0);
                this.f6185am.setBackgroundColor(this.f6191as);
                this.f6185am.setVisibility(0);
                return;
            }
            this.f6184al.setVisibility(8);
            this.f6185am.setVisibility(4);
            return;
        }
        this.f6184al.setText(C1506am.location_no_plot);
        this.f6184al.setVisibility(0);
        this.f6185am.setBackgroundColor(this.f6191as);
        this.f6185am.setVisibility(0);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.f6201i = this.f6188ap.getHeight();
        this.f6200h = this.f6183ak.getHeight();
        this.f6181a = true;
        if (this.f6192at != null) {
            this.f6182aj = this.f6192at.getCameraPosition().zoom;
        }
        if (this.f6187ao != null) {
            StreetViewPanoramaCamera panoramaCamera = this.f6187ao.getStreetViewPanorama().getPanoramaCamera();
            this.f6194b = panoramaCamera.bearing;
            this.f6195c = panoramaCamera.tilt;
            this.f6196d = panoramaCamera.zoom;
            this.f6197e = this.f6187ao.getStreetViewPanorama().getLocation();
        }
        bundle.putBoolean("STREET_VIEW_EXPANDED", this.f6193au);
    }

    public void onStreetViewPanoramaChange(StreetViewPanoramaLocation streetViewPanoramaLocation) {
        if (streetViewPanoramaLocation != null) {
            if (this.f6181a) {
                this.f6187ao.getStreetViewPanorama().animateTo(new StreetViewPanoramaCamera.Builder().bearing(m6232a(streetViewPanoramaLocation.position.latitude, streetViewPanoramaLocation.position.longitude, this.f6186an.getLatitude(), this.f6186an.getLongitude())).tilt(m6240n()).zoom(m6241o()).build(), 0);
                this.f6181a = false;
            }
            this.f6190ar.setVisibility(8);
            return;
        }
        this.f6190ar.setText(C1506am.streetview_not_available);
    }

    public void onStreetViewPanoramaReady(StreetViewPanorama streetViewPanorama) {
        streetViewPanorama.setOnStreetViewPanoramaChangeListener(this);
        this.f6189aq.setEnabled(true);
        this.f6198f = streetViewPanorama;
    }
}
