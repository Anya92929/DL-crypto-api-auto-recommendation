package android.support.design.widget;

import android.support.p000v4.view.ViewCompat;
import android.view.View;
import java.util.Comparator;

/* renamed from: android.support.design.widget.l */
class C0064l implements Comparator<View> {
    C0064l() {
    }

    /* renamed from: a */
    public int compare(View view, View view2) {
        float z = ViewCompat.getZ(view);
        float z2 = ViewCompat.getZ(view2);
        if (z > z2) {
            return -1;
        }
        return z < z2 ? 1 : 0;
    }
}
