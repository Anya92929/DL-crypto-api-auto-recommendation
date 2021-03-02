package android.support.p003v7.internal.app;

import android.support.p003v7.app.ActionBar;
import android.support.p003v7.internal.widget.AdapterViewCompat;
import android.view.View;

/* renamed from: android.support.v7.internal.app.NavItemSelectedListener */
class NavItemSelectedListener implements AdapterViewCompat.OnItemSelectedListener {
    private final ActionBar.OnNavigationListener mListener;

    public NavItemSelectedListener(ActionBar.OnNavigationListener onNavigationListener) {
        this.mListener = onNavigationListener;
    }

    public void onItemSelected(AdapterViewCompat adapterViewCompat, View view, int i, long j) {
        if (this.mListener != null) {
            this.mListener.onNavigationItemSelected(i, j);
        }
    }

    public void onNothingSelected(AdapterViewCompat adapterViewCompat) {
    }
}
