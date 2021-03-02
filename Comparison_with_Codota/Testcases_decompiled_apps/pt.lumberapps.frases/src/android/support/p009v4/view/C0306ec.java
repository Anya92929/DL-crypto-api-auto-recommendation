package android.support.p009v4.view;

import android.view.View;
import java.util.Comparator;

/* renamed from: android.support.v4.view.ec */
class C0306ec implements Comparator {
    C0306ec() {
    }

    /* renamed from: a */
    public int compare(View view, View view2) {
        C0298dv dvVar = (C0298dv) view.getLayoutParams();
        C0298dv dvVar2 = (C0298dv) view2.getLayoutParams();
        return dvVar.f374a != dvVar2.f374a ? dvVar.f374a ? 1 : -1 : dvVar.f378e - dvVar2.f378e;
    }
}
