package p000;

import android.support.p004v7.app.ActionBar;
import android.view.View;
import android.widget.AdapterView;

/* renamed from: gd */
public class C1153gd implements AdapterView.OnItemSelectedListener {

    /* renamed from: a */
    private final ActionBar.OnNavigationListener f4142a;

    public C1153gd(ActionBar.OnNavigationListener onNavigationListener) {
        this.f4142a = onNavigationListener;
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.f4142a != null) {
            this.f4142a.onNavigationItemSelected(i, j);
        }
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
