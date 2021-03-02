package com.jackhenry.godough.core.locations;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.C0018aj;
import android.support.design.widget.C0022an;
import android.support.design.widget.TabLayout;
import android.support.p000v4.app.Fragment;
import android.support.p000v4.app.FragmentTransaction;
import android.support.p000v4.view.MenuItemCompat;
import android.support.p003v7.app.ActionBar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.jackhenry.android.p022a.p023a.C1350b;
import com.jackhenry.godough.core.C1489ad;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.C1497al;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.core.model.GoDoughLocation;
import com.jackhenry.godough.core.model.LocationSearchCriteria;
import java.util.ArrayList;
import java.util.List;

public class LocationResultsFragmentActivity extends AbstractLocationActivity implements C0018aj, OnMapReadyCallback, C1618q {
    public static final String PARAM_MAP_MODE = "mapMode";
    public static final String PARAM_SHOW_ALL = "showAll";

    /* renamed from: n */
    private int f6210n;

    /* renamed from: o */
    private ActionBar f6211o;

    /* renamed from: p */
    private boolean f6212p = false;

    /* renamed from: q */
    private int f6213q = 0;

    /* renamed from: r */
    private boolean f6214r = false;

    /* renamed from: s */
    private LocationResultsFragment f6215s;

    /* renamed from: t */
    private LocationMapFragment f6216t;

    /* renamed from: u */
    private C1350b<GoDoughLocation> f6217u;

    /* renamed from: a */
    private void m6253a(int i) {
        if (i == 0) {
            this.f6217u.mo9268b(GoDoughApp.getLocations());
        } else if (i == 1) {
            ArrayList arrayList = new ArrayList();
            if (GoDoughApp.getLocations() != null) {
                for (GoDoughLocation next : GoDoughApp.getLocations()) {
                    if (next.isLobby()) {
                        arrayList.add(next);
                    }
                }
            }
            this.f6217u.mo9268b(arrayList);
        } else if (i == 2) {
            ArrayList arrayList2 = new ArrayList();
            if (GoDoughApp.getLocations() != null) {
                for (GoDoughLocation next2 : GoDoughApp.getLocations()) {
                    if (next2.isAtm()) {
                        arrayList2.add(next2);
                    }
                }
            }
            this.f6217u.mo9268b(arrayList2);
        }
    }

    /* renamed from: b */
    private void m6254b(boolean z) {
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        if (!z) {
            this.f6212p = false;
            beginTransaction.show(this.f6215s);
            beginTransaction.hide(this.f6216t);
        } else {
            this.f6212p = true;
            beginTransaction.show(this.f6216t);
            beginTransaction.hide(this.f6215s);
        }
        beginTransaction.commit();
        supportInvalidateOptionsMenu();
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public Fragment mo9485d() {
        return getSupportFragmentManager().findFragmentById(C1494ai.location_list);
    }

    public void filterLocations(int i) {
        this.f6213q = i;
        m6253a(i);
        this.f6216t.onLocationsChanged();
    }

    public C1350b<GoDoughLocation> getLocationAdapter() {
        return this.f6217u;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        setShowArrowOnToolbar(true);
        super.onCreate(bundle);
        boolean booleanExtra = getIntent().getBooleanExtra(PARAM_SHOW_ALL, false);
        if (bundle != null) {
            this.f6212p = bundle.getBoolean(PARAM_MAP_MODE, false);
            this.f6214r = bundle.getBoolean("DISPLAY_MAP_ON_LOAD", false);
            this.f6213q = bundle.getInt("GD_OUT_TAB_INDEX", 0);
        } else {
            this.f6212p = false;
            this.f6213q = 0;
            this.f6214r = false;
        }
        this.f6217u = new C1350b<>(this, new C1605d(C1496ak.list_item_icon_nav_centered, this.f6215s, booleanExtra));
        this.f6217u.mo9268b((List) null);
        setContentView(C1496ak.location_results_activity);
        this.f6215s = (LocationResultsFragment) getSupportFragmentManager().findFragmentById(C1494ai.location_list);
        m6253a(this.f6213q);
        this.f6215s.onLocationsChanged();
        this.f6216t = (LocationMapFragment) getSupportFragmentManager().findFragmentById(C1494ai.location_map);
        this.f6216t.getMapAsync(this);
        this.f6217u.notifyDataSetChanged();
        this.f6211o = getSupportActionBar();
        this.f6211o.setTitle(C1506am.title_location_results);
        getSupportActionBar().getThemedContext();
        TabLayout tabLayout = (TabLayout) findViewById(C1494ai.tablayout);
        this.f6210n = getResources().getConfiguration().orientation;
        switch (this.f6210n) {
            case 1:
                C0022an a = tabLayout.mo147a().mo204a((CharSequence) getString(C1506am.tab_branches));
                C0022an a2 = tabLayout.mo147a().mo204a((CharSequence) getString(C1506am.tab_atms));
                tabLayout.mo150a(tabLayout.mo147a().mo204a((CharSequence) getString(C1506am.tab_all)));
                tabLayout.mo150a(a);
                tabLayout.mo150a(a2);
                tabLayout.setOnTabSelectedListener(this);
                tabLayout.mo148a(this.f6213q).mo210e();
                return;
            case 2:
                ((TabLayout) findViewById(C1494ai.tablayout)).setVisibility(8);
                return;
            default:
                return;
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(C1497al.locations_all, menu);
        if (this.f6171m) {
            menu.findItem(C1494ai.menu_logout).setVisible(true);
        }
        if (this.f6215s != null) {
            menu.findItem(C1494ai.menu_map).setVisible(!this.f6212p);
            menu.findItem(C1494ai.menu_list).setVisible(this.f6212p);
        }
        this.f6210n = getResources().getConfiguration().orientation;
        switch (this.f6210n) {
            case 2:
                ArrayAdapter<CharSequence> createFromResource = ArrayAdapter.createFromResource(this, C1489ad.location_types, C1496ak.spinner_simple);
                createFromResource.setDropDownViewResource(C1496ak.spinner_simple);
                Spinner spinner = (Spinner) MenuItemCompat.getActionView(menu.findItem(C1494ai.menu_sort_locations));
                spinner.setAdapter(createFromResource);
                spinner.setSelection(this.f6213q);
                spinner.setOnItemSelectedListener(new C1619r(this));
                break;
        }
        return true;
    }

    public void onLocationClicked(GoDoughLocation goDoughLocation) {
        Intent intent = new Intent(GoDoughApp.getApp(), LocationDetailFragmentActivity.class);
        intent.putExtra(LocationSearchCriteria.KEY_LOCATION, goDoughLocation);
        intent.putExtra(AbstractLocationActivity.PARAM_LOGGED_IN, this.f6171m);
        startActivity(intent);
    }

    public void onMapReady(GoogleMap googleMap) {
        m6254b(this.f6212p);
        this.f6216t.updateMap();
        if (this.f6214r) {
            dismissLoadingDialog();
            m6254b(true);
            this.f6214r = false;
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == C1494ai.menu_list) {
            m6254b(false);
            return true;
        } else if (menuItem.getItemId() == C1494ai.menu_map) {
            if (this.f6216t.getGoogleMap() == null) {
                mo9483a(getString(C1506am.loading_map));
                this.f6214r = true;
                return true;
            }
            m6254b(true);
            return true;
        } else if (menuItem.getItemId() != C1494ai.menu_sort_locations) {
            return super.onOptionsItemSelected(menuItem);
        } else {
            return true;
        }
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        if (this.f6215s != null) {
            menu.findItem(C1494ai.menu_map).setVisible(!this.f6212p);
            menu.findItem(C1494ai.menu_list).setVisible(this.f6212p);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("GD_OUT_TAB_INDEX", this.f6213q);
        bundle.putBoolean(PARAM_MAP_MODE, this.f6212p);
        bundle.putBoolean("DISPLAY_MAP_ON_LOAD", this.f6214r);
    }

    public void onTabReselected(C0022an anVar) {
    }

    public void onTabSelected(C0022an anVar) {
        filterLocations(anVar.mo208c());
    }

    public void onTabUnselected(C0022an anVar) {
    }
}
