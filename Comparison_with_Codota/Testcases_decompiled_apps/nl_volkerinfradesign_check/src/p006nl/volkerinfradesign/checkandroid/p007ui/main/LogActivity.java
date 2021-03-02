package p006nl.volkerinfradesign.checkandroid.p007ui.main;

import android.os.Bundle;
import android.support.p001v4.app.FragmentActivity;
import android.view.MenuItem;
import p006nl.volkerinfradesign.checkandroid.util.ActionBarCompat;

/* renamed from: nl.volkerinfradesign.checkandroid.ui.main.LogActivity */
public class LogActivity extends FragmentActivity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActionBarCompat actionBarCompat = new ActionBarCompat(this);
        actionBarCompat.setDisplayHomeAsUpEnabled(true);
        actionBarCompat.setTitle("logger");
        if (bundle == null) {
            getSupportFragmentManager().beginTransaction().replace(16908290, new LogFragment()).commit();
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 16908332:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }
}
