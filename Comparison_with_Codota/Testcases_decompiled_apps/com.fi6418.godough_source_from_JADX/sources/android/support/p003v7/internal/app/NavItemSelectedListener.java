package android.support.p003v7.internal.app;

import android.support.p003v7.app.ActionBar;
import android.view.View;
import android.widget.AdapterView;

/* renamed from: android.support.v7.internal.app.NavItemSelectedListener */
class NavItemSelectedListener implements AdapterView.OnItemSelectedListener {

    /* renamed from: a */
    private final ActionBar.OnNavigationListener f1901a;

    public NavItemSelectedListener(ActionBar.OnNavigationListener onNavigationListener) {
        this.f1901a = onNavigationListener;
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.f1901a != null) {
            this.f1901a.onNavigationItemSelected(i, j);
        }
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
