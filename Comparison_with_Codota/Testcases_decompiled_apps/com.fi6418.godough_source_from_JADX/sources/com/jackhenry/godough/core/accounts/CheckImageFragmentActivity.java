package com.jackhenry.godough.core.accounts;

import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.view.MenuItem;
import com.jackhenry.godough.core.AbstractActivity;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;

public class CheckImageFragmentActivity extends AbstractActivity {
    public static final String EXTRA_TRANSACTION = "EXTRA_TRANSACTION";

    /* renamed from: m */
    private CheckImageFragment f5844m;

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public Fragment mo9485d() {
        return this.f5844m;
    }

    public void onBackPressed() {
        setResult(AccountTransactionsFragment.NO_REFRESH);
        super.onBackPressed();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        setShowArrowOnToolbar(true);
        super.onCreate(bundle);
        setContentView(C1496ak.check_image_fragment_activity);
        this.f5844m = new CheckImageFragment();
        getSupportFragmentManager().beginTransaction().add(C1494ai.container, (Fragment) this.f5844m).commit();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (showBackArrowOnToolbar() && menuItem.getItemId() == 16908332) {
            setResult(AccountTransactionsFragment.NO_REFRESH);
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
