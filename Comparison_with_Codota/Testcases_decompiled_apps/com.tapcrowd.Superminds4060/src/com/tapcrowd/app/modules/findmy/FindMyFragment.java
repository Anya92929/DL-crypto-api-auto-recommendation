package com.tapcrowd.app.modules.findmy;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.hardware.GeomagneticField;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.p000v4.view.MotionEventCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.nineoldandroids.animation.ObjectAnimator;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.TCFragment;
import com.tapcrowd.app.utils.AdHelper;
import com.tapcrowd.app.utils.C1216LO;
import com.tapcrowd.app.utils.C1232UI;
import com.tapcrowd.app.utils.Fragments;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class FindMyFragment extends TCFragment {
    /* access modifiers changed from: private */
    public SearchType active;
    private Bitmap arrow;
    float azimuth;
    DialogInterface.OnCancelListener cancelListener = new DialogInterface.OnCancelListener() {
        public void onCancel(DialogInterface dialog) {
            Toast.makeText(FindMyFragment.this.getActivity(), FindMyFragment.this.getString(C0846R.string.cancelled), 1).show();
            FindMyFragment.this.f2038lm.removeUpdates(FindMyFragment.this.f2037fl);
            FindMyFragment.this.f2040sm.unregisterListener(FindMyFragment.this.f2039sl);
            if (FindMyFragment.this.active == SearchType.Find) {
                ((TextView) FindMyFragment.this.f2005v.findViewById(C0846R.C0847id.find)).setText(FindMyFragment.this.getString(C0846R.string.wheresmy, FindMyFragment.this.getType()));
            }
            FindMyFragment.this.active = null;
        }
    };
    Location currentBestLocation;
    /* access modifiers changed from: private */
    public ProgressDialog dialog;
    View.OnClickListener findMyTent = new View.OnClickListener() {
        public void onClick(View v) {
            Drawable bg = FindMyFragment.this.f2005v.findViewById(C0846R.C0847id.set).getBackground();
            TextView tv = (TextView) v;
            if (FindMyFragment.this.active == null) {
                FindMyFragment.this.currentBestLocation = null;
                FindMyFragment.this.toFind = FindMyFragment.this.getLocation();
                tv.setText(FindMyFragment.this.getText(C0846R.string.stopsearch));
                if (bg != null) {
                    bg.setAlpha(128);
                }
                FindMyFragment.this.active = SearchType.Find;
                FindMyFragment.this.dialog = ProgressDialog.show(FindMyFragment.this.getActivity(), (CharSequence) null, FindMyFragment.this.getString(C0846R.string.loading), false, true);
                FindMyFragment.this.dialog.setOnCancelListener(FindMyFragment.this.cancelListener);
                FindMyFragment.this.f2037fl = new FmtLocationListener(FindMyFragment.this, (FmtLocationListener) null);
                FindMyFragment.this.f2038lm.requestLocationUpdates("network", 0, BitmapDescriptorFactory.HUE_RED, FindMyFragment.this.f2037fl);
                FindMyFragment.this.f2038lm.requestLocationUpdates("gps", 0, BitmapDescriptorFactory.HUE_RED, FindMyFragment.this.f2037fl);
                FindMyFragment.this.f2039sl = new FmtSensorListener(FindMyFragment.this, (FmtSensorListener) null);
                FindMyFragment.this.f2040sm.registerListener(FindMyFragment.this.f2039sl, FindMyFragment.this.f2040sm.getDefaultSensor(3), 3);
                return;
            }
            tv.setText(FindMyFragment.this.getString(C0846R.string.wheresmy, FindMyFragment.this.getType()));
            if (bg != null) {
                bg.setAlpha(MotionEventCompat.ACTION_MASK);
            }
            FindMyFragment.this.f2038lm.removeUpdates(FindMyFragment.this.f2037fl);
            FindMyFragment.this.f2040sm.unregisterListener(FindMyFragment.this.f2039sl);
            FindMyFragment.this.active = null;
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: fl */
    public FmtLocationListener f2037fl;
    private float lastDirection;
    /* access modifiers changed from: private */

    /* renamed from: lm */
    public LocationManager f2038lm;
    private String moduleid;
    View.OnClickListener set = new View.OnClickListener() {
        public void onClick(View v) {
            if (FindMyFragment.this.active != null) {
                return;
            }
            if (FindMyFragment.this.getLocation() != null) {
                AlertDialog.Builder alertbox = new AlertDialog.Builder(FindMyFragment.this.getActivity());
                alertbox.setMessage(FindMyFragment.this.getString(C0846R.string.overridecurrentloc));
                alertbox.setPositiveButton(FindMyFragment.this.getString(C0846R.string.yes), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        FindMyFragment.this.active = SearchType.Set;
                        FindMyFragment.this.dialog = ProgressDialog.show(FindMyFragment.this.getActivity(), (CharSequence) null, FindMyFragment.this.getString(C0846R.string.loading), false, true);
                        FindMyFragment.this.dialog.setOnCancelListener(FindMyFragment.this.cancelListener);
                        FindMyFragment.this.f2038lm = (LocationManager) FindMyFragment.this.getActivity().getSystemService("location");
                        FindMyFragment.this.f2037fl = new FmtLocationListener(FindMyFragment.this, (FmtLocationListener) null);
                        FindMyFragment.this.f2038lm.requestLocationUpdates("network", 0, BitmapDescriptorFactory.HUE_RED, FindMyFragment.this.f2037fl);
                        FindMyFragment.this.f2038lm.requestLocationUpdates("gps", 0, BitmapDescriptorFactory.HUE_RED, FindMyFragment.this.f2037fl);
                    }
                });
                alertbox.setNegativeButton(FindMyFragment.this.getString(C0846R.string.f2002no), (DialogInterface.OnClickListener) null);
                alertbox.show();
                return;
            }
            FindMyFragment.this.active = SearchType.Set;
            FindMyFragment.this.dialog = ProgressDialog.show(FindMyFragment.this.getActivity(), (CharSequence) null, FindMyFragment.this.getString(C0846R.string.loading), false, true);
            FindMyFragment.this.dialog.setOnCancelListener(FindMyFragment.this.cancelListener);
            FindMyFragment.this.f2038lm = (LocationManager) FindMyFragment.this.getActivity().getSystemService("location");
            FindMyFragment.this.f2037fl = new FmtLocationListener(FindMyFragment.this, (FmtLocationListener) null);
            FindMyFragment.this.f2038lm.requestLocationUpdates("network", 0, BitmapDescriptorFactory.HUE_RED, FindMyFragment.this.f2037fl);
            FindMyFragment.this.f2038lm.requestLocationUpdates("gps", 0, BitmapDescriptorFactory.HUE_RED, FindMyFragment.this.f2037fl);
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: sl */
    public SensorEventListener f2039sl;
    /* access modifiers changed from: private */

    /* renamed from: sm */
    public SensorManager f2040sm;
    /* access modifiers changed from: private */
    public Location toFind;

    private enum SearchType {
        Set,
        Find
    }

    public static FindMyFragment newInstance(String moduleid2) {
        FindMyFragment fr = new FindMyFragment();
        fr.moduleid = moduleid2;
        return fr;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (this.f2005v == null) {
            this.f2005v = inflater.inflate(C0846R.layout.findmytent, container, false);
        } else {
            ((ViewGroup) this.f2005v.getParent()).removeView(this.f2005v);
            this.retained = true;
        }
        AdHelper.showAds(this, AdHelper.buildPath("71", "list", (String) null));
        return this.f2005v;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (!this.retained) {
            setupLayout();
        }
    }

    public void setupLayout() {
        ((TextView) this.f2005v.findViewById(C0846R.C0847id.set)).setText(getString(C0846R.string.mylocation, getType()));
        ((TextView) this.f2005v.findViewById(C0846R.C0847id.find)).setText(getString(C0846R.string.wheresmy, getType()));
        if (this.moduleid.equals("37")) {
            ((ImageView) this.f2005v.findViewById(C0846R.C0847id.f1987bg)).setImageResource(C0846R.drawable.find_my_tent);
        } else if (this.moduleid.equals("71")) {
            ((ImageView) this.f2005v.findViewById(C0846R.C0847id.f1987bg)).setImageResource(C0846R.drawable.find_my_car);
        }
        C1232UI.getColorOverlay((int) C0846R.drawable.nav_no_arrow, C1216LO.getLo(C1216LO.actionbarBackgroundColor));
        this.arrow = BitmapFactory.decodeResource(getResources(), C0846R.drawable.nav_arrow).copy(Bitmap.Config.ARGB_8888, true);
        ((TextView) this.f2005v.findViewById(C0846R.C0847id.distance)).setTextColor(C1216LO.getLo(C1216LO.actionbarBackgroundColor));
        ((TextView) this.f2005v.findViewById(C0846R.C0847id.find)).setTextColor(C1216LO.getLo(C1216LO.actionbarContentColor));
        ((TextView) this.f2005v.findViewById(C0846R.C0847id.set)).setTextColor(C1216LO.getLo(C1216LO.actionbarContentColor));
        this.f2005v.findViewById(C0846R.C0847id.f1985ab).setBackgroundColor(C1216LO.getLo(C1216LO.actionbarBackgroundColor));
        if (getLocation() != null) {
            ((ImageView) this.f2005v.findViewById(C0846R.C0847id.tent)).setImageDrawable(C1232UI.getColorOverlay((Drawable) new BitmapDrawable(getResources(), this.arrow), C1216LO.getLo(C1216LO.actionbarBackgroundColor)));
            this.f2005v.findViewById(C0846R.C0847id.tent).setVisibility(0);
            this.f2005v.findViewById(C0846R.C0847id.find).setOnClickListener(this.findMyTent);
        }
        this.f2005v.findViewById(C0846R.C0847id.set).setOnClickListener(this.set);
        this.f2038lm = (LocationManager) getActivity().getSystemService("location");
        this.f2040sm = (SensorManager) getActivity().getSystemService("sensor");
        if (!this.f2038lm.isProviderEnabled("gps")) {
            Toast.makeText(getActivity(), "Please enable GPS to use this feature.", 1).show();
            Fragments.back();
        }
        if (this.f2040sm == null) {
            Toast.makeText(getActivity(), "Compass is not supported.", 1).show();
            Fragments.back();
        }
        this.active = null;
    }

    public void UpdateLocation() {
        if (this.active == SearchType.Set) {
            if (this.dialog.isShowing()) {
                this.dialog.dismiss();
            }
            AlertDialog.Builder alertbox = new AlertDialog.Builder(getActivity());
            alertbox.setMessage(getString(C0846R.string.locationfound));
            alertbox.setPositiveButton("Ok", (DialogInterface.OnClickListener) null);
            alertbox.show();
            this.f2005v.findViewById(C0846R.C0847id.tent).setVisibility(0);
            this.f2005v.findViewById(C0846R.C0847id.find).setOnClickListener(this.findMyTent);
            saveLocation(this.currentBestLocation);
            this.active = null;
            ((ImageView) this.f2005v.findViewById(C0846R.C0847id.tent)).setImageDrawable(C1232UI.getColorOverlay((Drawable) new BitmapDrawable(getResources(), this.arrow), C1216LO.getLo(C1216LO.actionbarBackgroundColor)));
        } else if (this.active == SearchType.Find && this.azimuth != BitmapDescriptorFactory.HUE_RED && this.currentBestLocation != null) {
            if (this.dialog.isShowing()) {
                this.dialog.dismiss();
            }
            float direction = this.currentBestLocation.bearingTo(this.toFind) - (this.azimuth + new GeomagneticField(Double.valueOf(this.currentBestLocation.getLatitude()).floatValue(), Double.valueOf(this.currentBestLocation.getLongitude()).floatValue(), Double.valueOf(this.currentBestLocation.getAltitude()).floatValue(), System.currentTimeMillis()).getDeclination());
            ((TextView) this.f2005v.findViewById(C0846R.C0847id.distance)).setText(String.valueOf(((double) Math.round(100.0f * this.currentBestLocation.distanceTo(this.toFind))) / 100.0d) + "m");
            ObjectAnimator.ofFloat((Object) (ImageView) this.f2005v.findViewById(C0846R.C0847id.tent), "rotation", this.lastDirection, direction).setDuration(0).start();
            this.lastDirection = direction;
        }
    }

    /* access modifiers changed from: protected */
    public boolean isBetterLocation(Location location) {
        if (this.currentBestLocation == null) {
            return true;
        }
        long timeDelta = location.getTime() - this.currentBestLocation.getTime();
        boolean isSignificantlyNewer = timeDelta > 120000;
        boolean isSignificantlyOlder = timeDelta < -120000;
        boolean isNewer = timeDelta > 0;
        if (isSignificantlyNewer) {
            return true;
        }
        if (isSignificantlyOlder) {
            return false;
        }
        int accuracyDelta = (int) (location.getAccuracy() - this.currentBestLocation.getAccuracy());
        boolean isLessAccurate = accuracyDelta > 0;
        boolean isMoreAccurate = accuracyDelta < 0;
        boolean isSignificantlyLessAccurate = accuracyDelta > 200;
        boolean isFromSameProvider = isSameProvider(location.getProvider(), this.currentBestLocation.getProvider());
        if (isMoreAccurate) {
            return true;
        }
        if (isNewer && !isLessAccurate) {
            return true;
        }
        if (!isNewer || isSignificantlyLessAccurate || !isFromSameProvider) {
            return false;
        }
        return true;
    }

    private boolean isSameProvider(String provider1, String provider2) {
        if (provider1 == null) {
            return provider2 == null;
        }
        return provider1.equals(provider2);
    }

    private class FmtSensorListener implements SensorEventListener {
        private FmtSensorListener() {
        }

        /* synthetic */ FmtSensorListener(FindMyFragment findMyFragment, FmtSensorListener fmtSensorListener) {
            this();
        }

        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }

        public void onSensorChanged(SensorEvent event) {
            FindMyFragment.this.azimuth = event.values[0];
            FindMyFragment.this.UpdateLocation();
        }
    }

    private class FmtLocationListener implements LocationListener {
        private FmtLocationListener() {
        }

        /* synthetic */ FmtLocationListener(FindMyFragment findMyFragment, FmtLocationListener fmtLocationListener) {
            this();
        }

        public void onLocationChanged(Location loc) {
            FindMyFragment findMyFragment = FindMyFragment.this;
            if (!FindMyFragment.this.isBetterLocation(loc)) {
                loc = FindMyFragment.this.currentBestLocation;
            }
            findMyFragment.currentBestLocation = loc;
            if (FindMyFragment.this.active != SearchType.Set) {
                FindMyFragment.this.UpdateLocation();
            } else if (FindMyFragment.this.currentBestLocation.getAccuracy() <= 20.0f || FindMyFragment.this.active == SearchType.Set) {
                FindMyFragment.this.f2038lm.removeUpdates(FindMyFragment.this.f2037fl);
                FindMyFragment.this.UpdateLocation();
            }
        }

        public void onProviderDisabled(String provider) {
        }

        public void onProviderEnabled(String provider) {
        }

        public void onStatusChanged(String provider, int status, Bundle extras) {
        }
    }

    public void saveLocation(Location loc) {
        try {
            FileOutputStream fos = getActivity().openFileOutput("dbLocations", 0);
            fos.write((String.valueOf(loc.getLatitude()) + ";" + loc.getLongitude()).getBytes());
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Location getLocation() {
        Location location = new Location((String) null);
        try {
            String[] lines = new BufferedReader(new InputStreamReader(getActivity().openFileInput("dbLocations"))).readLine().split(";");
            location.setLatitude(Double.parseDouble(lines[0]));
            location.setLongitude(Double.parseDouble(lines[1]));
            return location;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: private */
    public String getType() {
        if (this.moduleid.equals("37")) {
            return getString(C0846R.string.tent);
        }
        if (this.moduleid.equals("71")) {
            return getString(C0846R.string.car);
        }
        return "";
    }
}
