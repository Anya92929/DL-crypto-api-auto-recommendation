package p006nl.volkerinfradesign.checkandroid.p007ui.maps;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.support.p001v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import p006nl.volkerinfradesign.checkandroid.C1352R;
import p006nl.volkerinfradesign.checkandroid.database.LocationsTable;
import p006nl.volkerinfradesign.checkandroid.util.ActionBarCompat;

/* renamed from: nl.volkerinfradesign.checkandroid.ui.maps.MapActivity */
public class MapActivity extends FragmentActivity {
    public static final String BEARING = "check:bearing";
    public static final String LATITUDE = "check:latitude";
    public static final String LONGITUDE = "check:longitude";

    /* renamed from: k */
    private final GoogleMap.OnMyLocationChangeListener f5470k = new GoogleMap.OnMyLocationChangeListener() {
        public void onMyLocationChange(Location location) {
            MapActivity.this.m6337c();
        }
    };

    /* renamed from: l */
    private boolean f5471l = false;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public GoogleMap f5472m;

    /* renamed from: n */
    private final GoogleMap.OnMapLoadedCallback f5473n = new GoogleMap.OnMapLoadedCallback() {
        public void onMapLoaded() {
            MapActivity.this.m6337c();
        }
    };

    /* renamed from: o */
    private final GoogleMap.OnMapLongClickListener f5474o = new GoogleMap.OnMapLongClickListener() {
        public void onMapLongClick(LatLng latLng) {
            MapActivity.this.f5472m.animateCamera(CameraUpdateFactory.newLatLng(latLng));
        }
    };

    /* renamed from: p */
    private ImageButton f5475p;

    /* renamed from: q */
    private final View.OnClickListener f5476q = new View.OnClickListener() {
        public void onClick(View view) {
            CameraPosition cameraPosition = MapActivity.this.f5472m.getCameraPosition();
            LatLng latLng = cameraPosition.target;
            Intent intent = new Intent();
            intent.putExtra(MapActivity.LATITUDE, latLng.latitude);
            intent.putExtra(MapActivity.LONGITUDE, latLng.longitude);
            intent.putExtra(MapActivity.BEARING, cameraPosition.bearing);
            intent.putExtra("check:has_location", true);
            MapActivity.this.setResult(-1, intent);
            MapActivity.this.finish();
        }
    };

    /* renamed from: nl.volkerinfradesign.checkandroid.ui.maps.MapActivity$ActivityResult */
    public interface ActivityResult extends LocationsTable.SimpleLocation {
        float getBearing();
    }

    public static Intent getIntent(Context context, Location location) {
        Intent intent = new Intent(context, MapActivity.class);
        if (location != null) {
            intent.putExtra(LATITUDE, location.getLatitude());
            intent.putExtra(LONGITUDE, location.getLongitude());
            intent.putExtra("check:has_location", true);
        }
        return intent;
    }

    public static ActivityResult parseResult(final Intent intent) {
        if (intent == null || !intent.getBooleanExtra("check:has_location", false)) {
            return null;
        }
        return new ActivityResult() {
            public float getBearing() {
                return intent.getFloatExtra(MapActivity.BEARING, BitmapDescriptorFactory.HUE_RED);
            }

            public double getLatitude() {
                return intent.getDoubleExtra(MapActivity.LATITUDE, 0.0d);
            }

            public double getLongitude() {
                return intent.getDoubleExtra(MapActivity.LONGITUDE, 0.0d);
            }

            public String toString() {
                return "{lon: " + getLongitude() + ", lat: " + getLatitude() + ", bearing: " + getBearing() + "}";
            }
        };
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(C1352R.C1355menu.map_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        setContentView(C1352R.layout.map_activity);
        new ActionBarCompat(this).setDisplayHomeAsUpEnabled(true);
        this.f5472m = ((MapFragment) getFragmentManager().findFragmentById(C1352R.C1354id.map_fragment)).getMap();
        this.f5472m.setMyLocationEnabled(true);
        this.f5472m.setOnMapLoadedCallback(this.f5473n);
        this.f5472m.setOnMyLocationChangeListener(this.f5470k);
        this.f5472m.setOnMapLongClickListener(this.f5474o);
        m6335b().setOnClickListener(this.f5476q);
        if (extras != null && extras.getBoolean("check:has_location", false)) {
            CameraUpdate newLatLngZoom = CameraUpdateFactory.newLatLngZoom(new LatLng(extras.getDouble(LATITUDE), extras.getDouble(LONGITUDE)), 18.0f);
            this.f5471l = true;
            this.f5472m.moveCamera(newLatLngZoom);
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.f5472m.setOnMyLocationChangeListener((GoogleMap.OnMyLocationChangeListener) null);
        this.f5472m.setOnMapLoadedCallback((GoogleMap.OnMapLoadedCallback) null);
        this.f5472m.setOnMapLongClickListener((GoogleMap.OnMapLongClickListener) null);
        super.onDestroy();
    }

    /* renamed from: b */
    private ImageButton m6335b() {
        if (this.f5475p != null) {
            return this.f5475p;
        }
        ImageButton imageButton = (ImageButton) findViewById(C1352R.C1354id.pointer);
        this.f5475p = imageButton;
        return imageButton;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m6337c() {
        Location myLocation;
        if (!this.f5471l && (myLocation = this.f5472m.getMyLocation()) != null) {
            this.f5472m.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(myLocation.getLatitude(), myLocation.getLongitude()), 18.0f));
            this.f5471l = true;
        }
    }
}
