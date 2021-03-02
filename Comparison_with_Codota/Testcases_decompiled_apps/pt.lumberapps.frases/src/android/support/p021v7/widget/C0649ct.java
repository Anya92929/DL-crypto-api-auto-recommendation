package android.support.p021v7.widget;

import android.content.Context;
import android.support.p009v4.view.C0247by;
import android.support.p021v7.view.menu.C0561n;
import android.support.p021v7.view.menu.ListMenuItemView;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;

/* renamed from: android.support.v7.widget.ct */
public class C0649ct extends C0625bw {

    /* renamed from: g */
    final int f1576g;

    /* renamed from: h */
    final int f1577h;

    /* renamed from: i */
    private C0647cr f1578i;

    /* renamed from: j */
    private MenuItem f1579j;

    public C0649ct(Context context, boolean z) {
        super(context, z);
        if (C0247by.m909d(this) == 1) {
            this.f1576g = 21;
            this.f1577h = 22;
            return;
        }
        this.f1576g = 22;
        this.f1577h = 21;
    }

    /* renamed from: a */
    public /* bridge */ /* synthetic */ boolean mo3115a(MotionEvent motionEvent, int i) {
        return super.mo3115a(motionEvent, i);
    }

    public /* bridge */ /* synthetic */ boolean hasFocus() {
        return super.hasFocus();
    }

    public /* bridge */ /* synthetic */ boolean hasWindowFocus() {
        return super.hasWindowFocus();
    }

    public /* bridge */ /* synthetic */ boolean isFocused() {
        return super.isFocused();
    }

    public /* bridge */ /* synthetic */ boolean isInTouchMode() {
        return super.isInTouchMode();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0032, code lost:
        r1 = (r3 = pointToPosition((int) r6.getX(), (int) r6.getY())) - r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onHoverEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            android.support.v7.widget.cr r0 = r5.f1578i
            if (r0 == 0) goto L_0x0058
            android.widget.ListAdapter r0 = r5.getAdapter()
            boolean r1 = r0 instanceof android.widget.HeaderViewListAdapter
            if (r1 == 0) goto L_0x005d
            android.widget.HeaderViewListAdapter r0 = (android.widget.HeaderViewListAdapter) r0
            int r1 = r0.getHeadersCount()
            android.widget.ListAdapter r0 = r0.getWrappedAdapter()
            android.support.v7.view.menu.n r0 = (android.support.p021v7.view.menu.C0561n) r0
        L_0x0018:
            r2 = 0
            int r3 = r6.getAction()
            r4 = 10
            if (r3 == r4) goto L_0x0061
            float r3 = r6.getX()
            int r3 = (int) r3
            float r4 = r6.getY()
            int r4 = (int) r4
            int r3 = r5.pointToPosition(r3, r4)
            r4 = -1
            if (r3 == r4) goto L_0x0061
            int r1 = r3 - r1
            if (r1 < 0) goto L_0x0061
            int r3 = r0.getCount()
            if (r1 >= r3) goto L_0x0061
            android.support.v7.view.menu.s r1 = r0.getItem((int) r1)
        L_0x0040:
            android.view.MenuItem r2 = r5.f1579j
            if (r2 == r1) goto L_0x0058
            android.support.v7.view.menu.o r0 = r0.mo2434b()
            if (r2 == 0) goto L_0x004f
            android.support.v7.widget.cr r3 = r5.f1578i
            r3.mo2417a(r0, r2)
        L_0x004f:
            r5.f1579j = r1
            if (r1 == 0) goto L_0x0058
            android.support.v7.widget.cr r2 = r5.f1578i
            r2.mo2418b(r0, r1)
        L_0x0058:
            boolean r0 = super.onHoverEvent(r6)
            return r0
        L_0x005d:
            r1 = 0
            android.support.v7.view.menu.n r0 = (android.support.p021v7.view.menu.C0561n) r0
            goto L_0x0018
        L_0x0061:
            r1 = r2
            goto L_0x0040
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p021v7.widget.C0649ct.onHoverEvent(android.view.MotionEvent):boolean");
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
        if (listMenuItemView != null && i == this.f1576g) {
            if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
            }
            return true;
        } else if (listMenuItemView == null || i != this.f1577h) {
            return super.onKeyDown(i, keyEvent);
        } else {
            setSelection(-1);
            ((C0561n) getAdapter()).mo2434b().mo2454a(false);
            return true;
        }
    }

    public void setHoverListener(C0647cr crVar) {
        this.f1578i = crVar;
    }
}
