package com.jackhenry.godough.core.rda;

import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.view.Menu;
import android.view.MenuItem;
import com.jackhenry.godough.core.AbstractActivity;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.C1497al;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.model.Deposit;

public class CheckViewFragmentActivity extends AbstractActivity {
    public static final String PARAM_DEPOSIT_TRANSACTION = "depositTransAction";

    /* renamed from: m */
    private CheckViewFragment f6614m;

    /* renamed from: g */
    private void m6669g() {
        getSupportActionBar().setTitle(this.f6614m.getSide() == Deposit.Side.FRONT ? C1506am.lbl_check_front : C1506am.lbl_check_back);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public Fragment mo9485d() {
        return this.f6614m;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        setShowArrowOnToolbar(true);
        super.onCreate(bundle);
        setContentView(C1496ak.deposit_check_view_activity);
        this.f6614m = (CheckViewFragment) getSupportFragmentManager().findFragmentById(C1494ai.view_check);
        m6669g();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(C1497al.check_viewer, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != C1494ai.menu_flip) {
            return super.onOptionsItemSelected(menuItem);
        }
        this.f6614m.flipCheck();
        m6669g();
        return true;
    }
}
