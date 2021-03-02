package p006nl.volkerinfradesign.checkandroid.p007ui.inspection;

import android.location.Location;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.JsonObject;
import com.google.maps.android.kml.KmlLayer;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.UUID;
import org.apache.commons.p009io.IOUtils;
import p006nl.volkerinfradesign.checkandroid.App;
import p006nl.volkerinfradesign.checkandroid.AppState;
import p006nl.volkerinfradesign.checkandroid.C1352R;
import p006nl.volkerinfradesign.checkandroid.database.InspectionItemConstants;
import p006nl.volkerinfradesign.checkandroid.database.InspectionItemKey;
import p006nl.volkerinfradesign.checkandroid.database.LocationsTable;

/* renamed from: nl.volkerinfradesign.checkandroid.ui.inspection.LocationFragment */
public final class LocationFragment extends SupportMapFragment {

    /* renamed from: a */
    private LocationFragmentParent f5113a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Button f5114b;

    /* renamed from: c */
    private InspectionItemKey f5115c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Marker f5116d;

    /* renamed from: e */
    private Boolean f5117e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f5118f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final GoogleMap.OnMyLocationChangeListener f5119g = new GoogleMap.OnMyLocationChangeListener() {
        public void onMyLocationChange(Location location) {
            if (!LocationFragment.this.f5118f && location != null) {
                LocationFragment.this.getMap().animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(location.getLatitude(), location.getLongitude()), 17.0f));
                boolean unused = LocationFragment.this.f5118f = true;
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final GoogleMap.OnMapLongClickListener f5120h = new GoogleMap.OnMapLongClickListener() {
        public void onMapLongClick(LatLng latLng) {
            LocationFragment.this.m6123a(latLng);
            LocationFragment.this.m6138m().onLocationChanged(LocationFragment.this.m6137l(), latLng, false);
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final GoogleMap.OnMapClickListener f5121i = new GoogleMap.OnMapClickListener() {
        public void onMapClick(LatLng latLng) {
            LocationFragment.this.m6123a(latLng);
        }
    };

    /* renamed from: nl.volkerinfradesign.checkandroid.ui.inspection.LocationFragment$LocationFragmentParent */
    public interface LocationFragmentParent {
        void onLocationChanged(InspectionItemKey inspectionItemKey, LatLng latLng, boolean z);
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.ui.inspection.LocationFragment$MapCallback */
    public interface MapCallback {
        void execute(GoogleMap googleMap);
    }

    public static LocationFragment newInstance(InspectionItemConstants.ItemCursor itemCursor, boolean z) {
        LocationFragment locationFragment = new LocationFragment();
        Bundle bundle = new Bundle(2);
        LocationsTable.LocationsCursor customLocation = itemCursor.getCustomLocation();
        if (customLocation != null && customLocation.moveToFirst()) {
            bundle.putBoolean("has_marker", true);
            bundle.putDouble("marker_lat", customLocation.getLatitude());
            bundle.putDouble("marker_long", customLocation.getLongitude());
        }
        bundle.putBoolean("is_preview", z);
        bundle.putParcelable("item_key", itemCursor.getKey());
        locationFragment.setArguments(bundle);
        return locationFragment;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            setHasOptionsMenu(true);
        }
        if (bundle != null) {
            this.f5118f = bundle.getBoolean("location_updated");
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        LinearLayout linearLayout = (LinearLayout) layoutInflater.inflate(C1352R.layout.location_fragment_holder, viewGroup, false);
        FrameLayout frameLayout = (FrameLayout) linearLayout.findViewById(16908312);
        frameLayout.addView(super.onCreateView(layoutInflater, frameLayout, bundle));
        this.f5114b = (Button) linearLayout.findViewById(16908313);
        return linearLayout;
    }

    /* renamed from: a */
    private void m6124a(final MapCallback mapCallback) {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                GoogleMap map = LocationFragment.this.getMap();
                if (map != null) {
                    mapCallback.execute(map);
                } else {
                    handler.postDelayed(this, 300);
                }
            }
        }, 300);
    }

    public void onViewCreated(View view, final Bundle bundle) {
        super.onViewCreated(view, bundle);
        m6124a((MapCallback) new MapCallback() {
            public void execute(final GoogleMap googleMap) {
                googleMap.setMyLocationEnabled(true);
                if (LocationFragment.this.getArguments().getBoolean("has_marker", false)) {
                    LocationFragment.this.m6123a(new LatLng(LocationFragment.this.getArguments().getDouble("marker_lat"), LocationFragment.this.getArguments().getDouble("marker_long")));
                }
                if (bundle == null) {
                    googleMap.setOnMapLoadedCallback(new GoogleMap.OnMapLoadedCallback() {
                        public void onMapLoaded() {
                            LatLng latLng;
                            float f = 17.0f;
                            if (!LocationFragment.this.f5118f) {
                                if (LocationFragment.this.getArguments().getBoolean("has_marker", false)) {
                                    latLng = new LatLng(LocationFragment.this.getArguments().getDouble("marker_lat"), LocationFragment.this.getArguments().getDouble("marker_long"));
                                } else {
                                    Location myLocation = googleMap.getMyLocation();
                                    if (myLocation != null) {
                                        latLng = new LatLng(myLocation.getLatitude(), myLocation.getLongitude());
                                    } else {
                                        latLng = new LatLng(52.132633d, 5.2912659999999505d);
                                        f = 7.0f;
                                    }
                                }
                                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, f));
                                boolean unused = LocationFragment.this.f5118f = true;
                            }
                        }
                    });
                }
                googleMap.setOnMyLocationChangeListener(LocationFragment.this.f5119g);
                LocationFragment.this.f5114b.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        LocationFragment.this.m6138m().onLocationChanged(LocationFragment.this.m6137l(), LocationFragment.this.f5116d != null ? LocationFragment.this.f5116d.getPosition() : null, true);
                    }
                });
                if (!LocationFragment.this.m6139n()) {
                    googleMap.setOnMapClickListener(LocationFragment.this.f5121i);
                    googleMap.setOnMapLongClickListener(LocationFragment.this.f5120h);
                }
                LocationFragment.this.m6122a(googleMap, (String) null);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6122a(final GoogleMap googleMap, final String str) {
        new AsyncTask<Void, InputStream, InputStream>() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public InputStream doInBackground(Void... voidArr) {
                HttpURLConnection httpURLConnection;
                OutputStream outputStream;
                HttpURLConnection httpURLConnection2 = null;
                try {
                    JsonObject jsonObject = new JsonObject();
                    jsonObject.add("session", AppState.getInstance().getSIDJSON());
                    byte[] bytes = jsonObject.toString().getBytes();
                    HttpURLConnection httpURLConnection3 = (HttpURLConnection) new URL(str + "&rid=" + UUID.randomUUID().toString()).openConnection();
                    try {
                        httpURLConnection3.setFixedLengthStreamingMode(bytes.length);
                        httpURLConnection3.setDoInput(true);
                        httpURLConnection3.setDoOutput(true);
                        outputStream = httpURLConnection3.getOutputStream();
                        outputStream.write(bytes);
                        outputStream.flush();
                        outputStream.close();
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = httpURLConnection3.getInputStream().read(bArr);
                            if (read > -1) {
                                byteArrayOutputStream.write(bArr, 0, read);
                            } else {
                                byteArrayOutputStream.flush();
                                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                                IOUtils.close(httpURLConnection3);
                                return byteArrayInputStream;
                            }
                        }
                    } catch (Exception e) {
                        Exception exc = e;
                        httpURLConnection = httpURLConnection3;
                        e = exc;
                    } catch (Throwable th) {
                        httpURLConnection2 = httpURLConnection3;
                        th = th;
                        IOUtils.close(httpURLConnection2);
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                    httpURLConnection = null;
                    try {
                        e.printStackTrace();
                        IOUtils.close(httpURLConnection);
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        httpURLConnection2 = httpURLConnection;
                        IOUtils.close(httpURLConnection2);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    IOUtils.close(httpURLConnection2);
                    throw th;
                }
            }

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void onPostExecute(InputStream inputStream) {
                try {
                    new KmlLayer(googleMap, inputStream, App.getAppContext()).addLayerToMap();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.execute(new Void[]{null, null, null});
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 16908332:
                getActivity().onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("location_updated", this.f5118f);
    }

    public void onDestroyView() {
        GoogleMap map = getMap();
        map.setOnMapClickListener((GoogleMap.OnMapClickListener) null);
        map.setOnMapLongClickListener((GoogleMap.OnMapLongClickListener) null);
        map.setOnMapLoadedCallback((GoogleMap.OnMapLoadedCallback) null);
        map.setOnMyLocationChangeListener((GoogleMap.OnMyLocationChangeListener) null);
        super.onDestroyView();
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public InspectionItemKey m6137l() {
        if (this.f5115c != null) {
            return this.f5115c;
        }
        InspectionItemKey inspectionItemKey = (InspectionItemKey) getArguments().getParcelable("item_key");
        this.f5115c = inspectionItemKey;
        return inspectionItemKey;
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public LocationFragmentParent m6138m() {
        if (this.f5113a == null) {
            Object parentFragment = getParentFragment();
            if (!(parentFragment instanceof LocationFragmentParent)) {
                parentFragment = getActivity();
            }
            this.f5113a = (LocationFragmentParent) parentFragment;
        }
        return this.f5113a;
    }

    /* access modifiers changed from: private */
    /* renamed from: n */
    public boolean m6139n() {
        Boolean bool;
        if (this.f5117e == null) {
            bool = Boolean.valueOf(getArguments().getBoolean("is_preview", false));
            this.f5117e = bool;
        } else {
            bool = this.f5117e;
        }
        return bool.booleanValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6123a(LatLng latLng) {
        MarkerOptions markerOptions = new MarkerOptions();
        Bundle arguments = getArguments();
        if (this.f5116d != null) {
            this.f5116d.remove();
        }
        markerOptions.draggable(true);
        markerOptions.position(latLng);
        this.f5116d = getMap().addMarker(markerOptions);
        arguments.putBoolean("has_marker", true);
        arguments.putDouble("marker_lat", this.f5116d.getPosition().latitude);
        arguments.putDouble("marker_long", this.f5116d.getPosition().longitude);
        this.f5114b.setEnabled(true);
        m6138m().onLocationChanged(m6137l(), latLng, false);
    }
}
