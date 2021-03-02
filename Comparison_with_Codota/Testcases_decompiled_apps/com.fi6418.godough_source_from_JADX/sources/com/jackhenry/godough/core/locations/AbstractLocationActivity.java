package com.jackhenry.godough.core.locations;

import android.os.Bundle;
import android.view.Menu;
import com.jackhenry.godough.core.AbstractNoUserMenuActivity;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.model.LocationSearchCriteria;
import com.jackhenry.godough.core.session.C1886b;

public abstract class AbstractLocationActivity extends AbstractNoUserMenuActivity implements LocationSearchCriteria.OnLocationSearch {
    public static final int DIALOG_LOCATION_SEARCH_FAILED = 5026;
    public static final String PARAM_LOGGED_IN = "loggedIn";

    /* renamed from: m */
    protected boolean f6171m = true;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public LocationSearchCriteria f6172n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public C1602af f6173o;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo9823a(LocationSearchCriteria locationSearchCriteria) {
        mo9483a(getString(C1506am.ellipse_searching_loations));
        this.f6172n = locationSearchCriteria;
        this.f6173o = new C1602af(this, locationSearchCriteria, new C1604c(this, mo9485d(), new C1603b(this, locationSearchCriteria)));
        this.f6173o.execute(new Void[0]);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent().getExtras() != null) {
            this.f6171m = getIntent().getExtras().getBoolean(PARAM_LOGGED_IN, true);
            if (this.f6171m) {
                new C1886b().execute(new Void[0]);
            }
        }
        this.f6173o = (C1602af) getLastCustomNonConfigurationInstance();
        if (this.f6173o != null) {
            this.f6172n = (LocationSearchCriteria) bundle.getSerializable("EXTRA_CRITERIA");
            C1604c cVar = new C1604c(this, mo9485d(), new C1596a(this));
            if (!this.f6173o.mo10926c()) {
                this.f6173o.mo10923a(cVar);
            } else if (this.f6173o.mo10929e()) {
                cVar.mo9589a(this.f6173o.mo10927d());
            } else {
                cVar.mo9588a((LocationSearchCriteria) this.f6173o.mo10925b());
            }
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        if (this.f6171m) {
            return super.onCreateOptionsMenu(menu);
        }
        return true;
    }

    public void onLocationCancel() {
        finish();
    }

    public void onLocationSearch(LocationSearchCriteria locationSearchCriteria) {
        mo9823a(locationSearchCriteria);
    }

    public Object onRetainCustomNonConfigurationInstance() {
        return super.onRetainCustomNonConfigurationInstance() == null ? this.f6173o : super.onRetainCustomNonConfigurationInstance();
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("EXTRA_CRITERIA", this.f6172n);
    }
}
