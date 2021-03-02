package com.tapcrowd.app.modules.launcher;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.support.p000v4.app.FragmentTransaction;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.MenuItem;
import com.google.android.gcm.GCMConstants;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.TCApplication;
import com.tapcrowd.app.TCFragment;
import com.tapcrowd.app.TCListFragment;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import com.tapcrowd.app.utils.App;
import com.tapcrowd.app.utils.C1199DB;
import com.tapcrowd.app.utils.C1216LO;
import com.tapcrowd.app.utils.C1232UI;
import com.tapcrowd.app.utils.Fragments;
import com.tapcrowd.app.utils.PathHelper;
import com.tapcrowd.app.utils.TCObject;
import com.tapcrowd.app.views.ClusteredMapView;
import com.tapcrowd.tcanalytics.TCAnalytics;
import com.tapcrowd.tcanalytics.TCGeoFences;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.cordova.api.CordovaInterface;
import org.apache.cordova.api.CordovaPlugin;

public class TCLauncher extends SherlockFragmentActivity implements CordovaInterface {
    public static String linktomodule = null;
    public static String message = null;
    final int SEARCH_ID = 1672;
    private AdFragment adFragment;
    BackPressedListener backListener;
    MenuItem item;
    private CordovaPlugin mActivityResultCallback;
    private final ExecutorService mThreadPool = Executors.newCachedThreadPool();
    ClusteredMapView mapView;
    boolean searchvisible;
    private String shownLinktomodule = "";
    private String shownMessage = "";
    boolean stopped;

    public interface BackPressedListener {
        boolean onBackPressed();
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (TCGeoFences.servicesConnected(this)) {
            new TCGeoFences(this).init();
        }
        firstRun();
        if (App.act == null) {
            Fragments.f2128fa = this;
            Fragments.clear();
            App.act = this;
        }
        Fragments.f2128fa = this;
        App.act = this;
        App.tablet = getResources().getBoolean(C0846R.bool.tablet);
        getSupportActionBar().setTitle((CharSequence) C1199DB.getFirstObject(GCMConstants.EXTRA_APPLICATION_PENDING_INTENT).get(DBFavorites.KEY_NAME));
        TCApplication.updatelanguage(this);
        C1232UI.getColorOverlay((int) C0846R.drawable.icon_overflow, C1216LO.getLo(C1216LO.navigationColor));
        C1232UI.getColorOverlay((int) C0846R.drawable.icon_done, C1216LO.getLo(C1216LO.navigationColor));
        this.adFragment = AdFragment.newInstance();
        if (App.tablet) {
            tabletinterface();
        } else {
            smartphoneinterface();
        }
    }

    public void firstRun() {
        SharedPreferences pref = getSharedPreferences("first", 0);
        if (pref.getBoolean("first", true)) {
            TCAnalytics.log(this, "/" + getString(C0846R.string.app_name) + "/pushenabled", "");
            SharedPreferences.Editor edit = pref.edit();
            edit.putBoolean("first", false);
            edit.commit();
        }
    }

    public void tabletinterface() {
        String type;
        String typeid;
        if (getIntent().hasExtra("venueid")) {
            type = "venueid";
            typeid = getIntent().getStringExtra("venueid");
        } else if (getIntent().hasExtra("eventid")) {
            type = "eventid";
            typeid = getIntent().getStringExtra("eventid");
        } else {
            type = "appid";
            typeid = App.f2123id;
        }
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        if (!App.typeid.equals("4") || C1199DB.getSize("venues") <= 1 || !type.equals("appid")) {
            setContentView((int) C0846R.layout.modules_tclauncher_2_box);
            ft.add(C0846R.C0847id.launcheritems, TCLauncherTabletFragment.newInstance(type, typeid), "launcher");
            ft.add(C0846R.C0847id.ads, this.adFragment, "ads");
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            if (C1199DB.getSize("ad") == 0) {
                C1232UI.hide(C0846R.C0847id.shadow);
            }
        } else {
            setContentView((int) C0846R.layout.modules_tclauncher_1_box);
            ft.replace(C0846R.C0847id.contentbox1, TCVenueList.newInstance(), "launcher");
        }
        ft.commit();
    }

    public void smartphoneinterface() {
        String type;
        String typeid;
        Fragment fragment;
        setContentView((int) C0846R.layout.modules_tclauncher_1_box);
        setRequestedOrientation(1);
        findViewById(C0846R.C0847id.contentbox1).setBackgroundColor(-1);
        if (getIntent().hasExtra("venueid")) {
            type = "venueid";
            typeid = getIntent().getStringExtra("venueid");
        } else if (getIntent().hasExtra("eventid")) {
            type = "eventid";
            typeid = getIntent().getStringExtra("eventid");
        } else {
            type = "appid";
            typeid = App.f2123id;
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        TCObject app = C1199DB.getFirstObject(GCMConstants.EXTRA_APPLICATION_PENDING_INTENT, DBFavorites.KEY_EVENT_ID, App.f2123id);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        if (App.typeid.equals("3") && C1199DB.getSize("events") > 1) {
            fragment = TCEventListFragment.newInstance();
        } else if (App.typeid.equals("4") && C1199DB.getSize("venues") > 1) {
            fragment = TCVenueList.newInstance();
        } else if (app.get("launcherview", "").equals("list")) {
            fragment = TCLauncherListFragment.newInstance(type, typeid);
        } else if (app.get("launcherview", "").equals("metro")) {
            fragment = TCMetroLauncher.newInstance(type, typeid);
        } else if (getIntent().hasExtra("sessionid")) {
            fragment = TCLauncherPhoneFragment.newInstance(type, typeid, getIntent().getStringExtra("sessionid"), true);
        } else {
            fragment = TCLauncherPhoneFragment.newInstance(type, typeid, true);
        }
        ft.replace(C0846R.C0847id.contentbox1, fragment, "launcher");
        ft.add(C0846R.C0847id.ads, this.adFragment, "ads");
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();
    }

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (App.tablet && getSupportFragmentManager().findFragmentByTag("launcher") != null && (getSupportFragmentManager().findFragmentByTag("launcher") instanceof TCLauncherTabletFragment)) {
            ((TCLauncherTabletFragment) getSupportFragmentManager().findFragmentByTag("launcher")).updateOrientation();
            TCApplication.updatelanguage(this);
        }
    }

    public void onBackPressed() {
        if (this.backListener == null || this.backListener.onBackPressed()) {
            Fragments.removeMenu();
            if (!App.tablet) {
                super.onBackPressed();
            } else if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
                super.onBackPressed();
            } else {
                finish();
            }
        }
    }

    public void setBackPressedListener(BackPressedListener listener) {
        this.backListener = listener;
    }

    public void removeBackPressedListener() {
        this.backListener = null;
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        if (message != null && !message.equals(this.shownMessage)) {
            new NotificationDialog(this, message).show();
            this.shownMessage = message;
        }
        if (linktomodule != null && !linktomodule.equals(this.shownLinktomodule)) {
            Fragment fr = PathHelper.getFragment(this, linktomodule);
            if (fr != null) {
                Fragment caller = getSupportFragmentManager().findFragmentById(C0846R.C0847id.contentbox1);
                if (fr instanceof TCFragment) {
                    Fragments.add(caller, fr, ((TCFragment) fr).getTitle());
                }
                if (fr instanceof TCListFragment) {
                    Fragments.add(caller, fr, ((TCListFragment) fr).getTitle());
                }
            }
            this.shownLinktomodule = linktomodule;
        }
        App.tablet = getResources().getBoolean(C0846R.bool.tablet);
        int result = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
        switch (result) {
            case 0:
                break;
            default:
                GooglePlayServicesUtil.getErrorDialog(result, this, 234);
                break;
        }
        if (App.act == null || this.stopped) {
            Fragments.f2128fa = this;
            App.act = this;
            this.stopped = false;
        }
        super.onResume();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        linktomodule = null;
        message = null;
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        this.stopped = true;
        super.onStop();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
    }

    public boolean onOptionsItemSelected(MenuItem item2) {
        if (item2.getItemId() != 16908332) {
            return super.onOptionsItemSelected(item2);
        }
        Fragments.clear();
        return true;
    }

    public AdFragment getAdFragment() {
        return this.adFragment;
    }

    private class NotificationDialog extends Dialog {
        String message;

        public NotificationDialog(Context context, String message2) {
            super(context, C0846R.style.transparentDialogTheme);
            this.message = message2;
        }

        /* access modifiers changed from: protected */
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            LinearLayout ll = new LinearLayout(TCLauncher.this);
            ll.setOrientation(1);
            ImageView iv = new ImageView(TCLauncher.this);
            iv.setBackgroundColor(C1216LO.getLo(C1216LO.navbarColor));
            iv.setImageResource(C0846R.drawable.close);
            iv.setScaleType(ImageView.ScaleType.FIT_END);
            iv.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            iv.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    NotificationDialog.this.dismiss();
                }
            });
            int hheight = 0;
            TypedValue tyv = new TypedValue();
            if (getContext().getTheme().resolveAttribute(16843499, tyv, true)) {
                hheight = TypedValue.complexToDimensionPixelSize(tyv.data, TCLauncher.this.getResources().getDisplayMetrics());
            }
            LinearLayout.LayoutParams llp = (LinearLayout.LayoutParams) iv.getLayoutParams();
            llp.height = hheight;
            llp.gravity = 16;
            iv.setLayoutParams(llp);
            TextView tv = new TextView(TCLauncher.this);
            tv.setBackgroundColor(-1);
            tv.setTextColor(-16777216);
            tv.setText(this.message);
            tv.setPadding(15, 15, 15, 15);
            tv.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
            ll.addView(iv);
            ll.addView(tv);
            setContentView(ll, new ViewGroup.LayoutParams(TCLauncher.this.getWindowManager().getDefaultDisplay().getWidth(), TCLauncher.this.getWindowManager().getDefaultDisplay().getHeight()));
        }
    }

    public void cancelLoadUrl() {
    }

    public Activity getActivity() {
        return this;
    }

    public Context getContext() {
        return this;
    }

    public ExecutorService getThreadPool() {
        return this.mThreadPool;
    }

    public Object onMessage(String id, Object data) {
        return null;
    }

    public void setActivityResultCallback(CordovaPlugin plugin) {
        this.mActivityResultCallback = plugin;
    }

    public void startActivityForResult(CordovaPlugin plugin, Intent intent, int requestCode) {
        this.mActivityResultCallback = plugin;
        startActivityForResult(intent, requestCode);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (this.mActivityResultCallback != null) {
            this.mActivityResultCallback.onActivityResult(requestCode, resultCode, intent);
        } else {
            super.onActivityResult(requestCode, resultCode, intent);
        }
    }
}
