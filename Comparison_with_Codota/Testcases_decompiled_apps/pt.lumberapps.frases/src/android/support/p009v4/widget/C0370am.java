package android.support.p009v4.widget;

import android.widget.ListView;

/* renamed from: android.support.v4.widget.am */
public class C0370am extends C0357a {

    /* renamed from: a */
    private final ListView f509a;

    public C0370am(ListView listView) {
        super(listView);
        this.f509a = listView;
    }

    /* renamed from: a */
    public void mo1754a(int i, int i2) {
        C0371an.m1534a(this.f509a, i2);
    }

    /* renamed from: e */
    public boolean mo1762e(int i) {
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0028 A[RETURN, SYNTHETIC] */
    /* renamed from: f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo1763f(int r7) {
        /*
            r6 = this;
            r0 = 0
            android.widget.ListView r1 = r6.f509a
            int r2 = r1.getCount()
            if (r2 != 0) goto L_0x000a
        L_0x0009:
            return r0
        L_0x000a:
            int r3 = r1.getChildCount()
            int r4 = r1.getFirstVisiblePosition()
            int r5 = r4 + r3
            if (r7 <= 0) goto L_0x002a
            if (r5 < r2) goto L_0x0028
            int r2 = r3 + -1
            android.view.View r2 = r1.getChildAt(r2)
            int r2 = r2.getBottom()
            int r1 = r1.getHeight()
            if (r2 <= r1) goto L_0x0009
        L_0x0028:
            r0 = 1
            goto L_0x0009
        L_0x002a:
            if (r7 >= 0) goto L_0x0009
            if (r4 > 0) goto L_0x0028
            android.view.View r1 = r1.getChildAt(r0)
            int r1 = r1.getTop()
            if (r1 < 0) goto L_0x0028
            goto L_0x0009
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p009v4.widget.C0370am.mo1763f(int):boolean");
    }
}
