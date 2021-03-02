package android.support.p021v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.p009v4.view.C0344n;
import android.support.p009v4.view.C0345o;
import android.support.p021v7.p023b.C0512h;
import android.support.p021v7.p027e.C0519a;
import android.support.p021v7.view.C0520a;
import android.support.p021v7.view.menu.ActionMenuItemView;
import android.support.p021v7.view.menu.C0540ag;
import android.support.p021v7.view.menu.C0541ah;
import android.support.p021v7.view.menu.C0547an;
import android.support.p021v7.view.menu.C0551d;
import android.support.p021v7.view.menu.C0562o;
import android.support.p021v7.view.menu.C0566s;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

/* renamed from: android.support.v7.widget.k */
class C0689k extends C0551d implements C0345o {

    /* renamed from: A */
    private C0692n f1688A;

    /* renamed from: g */
    final C0697s f1689g = new C0697s(this);

    /* renamed from: h */
    int f1690h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public C0694p f1691i;

    /* renamed from: j */
    private Drawable f1692j;

    /* renamed from: k */
    private boolean f1693k;

    /* renamed from: l */
    private boolean f1694l;

    /* renamed from: m */
    private boolean f1695m;

    /* renamed from: n */
    private int f1696n;

    /* renamed from: o */
    private int f1697o;

    /* renamed from: p */
    private int f1698p;

    /* renamed from: q */
    private boolean f1699q;

    /* renamed from: r */
    private boolean f1700r;

    /* renamed from: s */
    private boolean f1701s;

    /* renamed from: t */
    private boolean f1702t;

    /* renamed from: u */
    private int f1703u;

    /* renamed from: v */
    private final SparseBooleanArray f1704v = new SparseBooleanArray();

    /* renamed from: w */
    private View f1705w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public C0696r f1706x;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public C0691m f1707y;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public C0693o f1708z;

    public C0689k(Context context) {
        super(context, C0512h.abc_action_menu_layout, C0512h.abc_action_menu_item_layout);
    }

    /* renamed from: a */
    private View m3106a(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.f1045f;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof C0541ah) && ((C0541ah) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    /* renamed from: a */
    public C0540ag mo2401a(ViewGroup viewGroup) {
        C0540ag agVar = this.f1045f;
        C0540ag a = super.mo2401a(viewGroup);
        if (agVar != a) {
            ((ActionMenuView) a).setPresenter(this);
        }
        return a;
    }

    /* renamed from: a */
    public View mo2402a(C0566s sVar, View view, ViewGroup viewGroup) {
        View actionView = sVar.getActionView();
        if (actionView == null || sVar.mo2547n()) {
            actionView = super.mo2402a(sVar, view, viewGroup);
        }
        actionView.setVisibility(sVar.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    /* renamed from: a */
    public void mo2308a(Context context, C0562o oVar) {
        super.mo2308a(context, oVar);
        Resources resources = context.getResources();
        C0520a a = C0520a.m2179a(context);
        if (!this.f1695m) {
            this.f1694l = a.mo2188b();
        }
        if (!this.f1701s) {
            this.f1696n = a.mo2189c();
        }
        if (!this.f1699q) {
            this.f1698p = a.mo2187a();
        }
        int i = this.f1696n;
        if (this.f1694l) {
            if (this.f1691i == null) {
                this.f1691i = new C0694p(this, this.f1040a);
                if (this.f1693k) {
                    this.f1691i.setImageDrawable(this.f1692j);
                    this.f1692j = null;
                    this.f1693k = false;
                }
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.f1691i.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i -= this.f1691i.getMeasuredWidth();
        } else {
            this.f1691i = null;
        }
        this.f1697o = i;
        this.f1703u = (int) (56.0f * resources.getDisplayMetrics().density);
        this.f1705w = null;
    }

    /* renamed from: a */
    public void mo3352a(Configuration configuration) {
        if (!this.f1699q) {
            this.f1698p = C0520a.m2179a(this.f1041b).mo2187a();
        }
        if (this.f1042c != null) {
            this.f1042c.mo2470b(true);
        }
    }

    /* renamed from: a */
    public void mo3353a(Drawable drawable) {
        if (this.f1691i != null) {
            this.f1691i.setImageDrawable(drawable);
            return;
        }
        this.f1693k = true;
        this.f1692j = drawable;
    }

    /* renamed from: a */
    public void mo2334a(C0562o oVar, boolean z) {
        mo3360f();
        super.mo2334a(oVar, z);
    }

    /* renamed from: a */
    public void mo2404a(C0566s sVar, C0541ah ahVar) {
        ahVar.mo2238a(sVar, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) ahVar;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.f1045f);
        if (this.f1688A == null) {
            this.f1688A = new C0692n(this);
        }
        actionMenuItemView.setPopupCallback(this.f1688A);
    }

    /* renamed from: a */
    public void mo3354a(ActionMenuView actionMenuView) {
        this.f1045f = actionMenuView;
        actionMenuView.mo2257a(this.f1042c);
    }

    /* renamed from: a */
    public void mo1626a(boolean z) {
        if (z) {
            super.mo2335a((C0547an) null);
        } else if (this.f1042c != null) {
            this.f1042c.mo2454a(false);
        }
    }

    /* renamed from: a */
    public boolean mo2406a(int i, C0566s sVar) {
        return sVar.mo2543j();
    }

    /* renamed from: a */
    public boolean mo2335a(C0547an anVar) {
        boolean z;
        if (!anVar.hasVisibleItems()) {
            return false;
        }
        C0547an anVar2 = anVar;
        while (anVar2.mo2378s() != this.f1042c) {
            anVar2 = (C0547an) anVar2.mo2378s();
        }
        View a = m3106a(anVar2.getItem());
        if (a == null) {
            return false;
        }
        this.f1690h = anVar.getItem().getItemId();
        int size = anVar.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                z = false;
                break;
            }
            MenuItem item = anVar.getItem(i);
            if (item.isVisible() && item.getIcon() != null) {
                z = true;
                break;
            }
            i++;
        }
        this.f1707y = new C0691m(this, this.f1041b, anVar, a);
        this.f1707y.mo2324a(z);
        this.f1707y.mo2321a();
        super.mo2335a(anVar);
        return true;
    }

    /* renamed from: a */
    public boolean mo2407a(ViewGroup viewGroup, int i) {
        if (viewGroup.getChildAt(i) == this.f1691i) {
            return false;
        }
        return super.mo2407a(viewGroup, i);
    }

    /* renamed from: b */
    public void mo2336b(boolean z) {
        boolean z2 = true;
        boolean z3 = false;
        ViewGroup viewGroup = (ViewGroup) ((View) this.f1045f).getParent();
        if (viewGroup != null) {
            C0519a.m2178a(viewGroup);
        }
        super.mo2336b(z);
        ((View) this.f1045f).requestLayout();
        if (this.f1042c != null) {
            ArrayList k = this.f1042c.mo2487k();
            int size = k.size();
            for (int i = 0; i < size; i++) {
                C0344n a = ((C0566s) k.get(i)).mo1018a();
                if (a != null) {
                    a.mo1617a((C0345o) this);
                }
            }
        }
        ArrayList l = this.f1042c != null ? this.f1042c.mo2488l() : null;
        if (this.f1694l && l != null) {
            int size2 = l.size();
            if (size2 == 1) {
                z3 = !((C0566s) l.get(0)).isActionViewExpanded();
            } else {
                if (size2 <= 0) {
                    z2 = false;
                }
                z3 = z2;
            }
        }
        if (z3) {
            if (this.f1691i == null) {
                this.f1691i = new C0694p(this, this.f1040a);
            }
            ViewGroup viewGroup2 = (ViewGroup) this.f1691i.getParent();
            if (viewGroup2 != this.f1045f) {
                if (viewGroup2 != null) {
                    viewGroup2.removeView(this.f1691i);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f1045f;
                actionMenuView.addView(this.f1691i, actionMenuView.mo2713c());
            }
        } else if (this.f1691i != null && this.f1691i.getParent() == this.f1045f) {
            ((ViewGroup) this.f1045f).removeView(this.f1691i);
        }
        ((ActionMenuView) this.f1045f).setOverflowReserved(this.f1694l);
    }

    /* renamed from: b */
    public boolean mo2337b() {
        int i;
        ArrayList arrayList;
        int i2;
        int i3;
        int i4;
        int i5;
        boolean z;
        int i6;
        int i7;
        int i8;
        int i9;
        boolean z2;
        if (this.f1042c != null) {
            ArrayList i10 = this.f1042c.mo2484i();
            i = i10.size();
            arrayList = i10;
        } else {
            i = 0;
            arrayList = null;
        }
        int i11 = this.f1698p;
        int i12 = this.f1697o;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) this.f1045f;
        int i13 = 0;
        int i14 = 0;
        boolean z3 = false;
        int i15 = 0;
        while (i15 < i) {
            C0566s sVar = (C0566s) arrayList.get(i15);
            if (sVar.mo2545l()) {
                i13++;
            } else if (sVar.mo2544k()) {
                i14++;
            } else {
                z3 = true;
            }
            i15++;
            i11 = (!this.f1702t || !sVar.isActionViewExpanded()) ? i11 : 0;
        }
        if (this.f1694l && (z3 || i13 + i14 > i11)) {
            i11--;
        }
        int i16 = i11 - i13;
        SparseBooleanArray sparseBooleanArray = this.f1704v;
        sparseBooleanArray.clear();
        int i17 = 0;
        if (this.f1700r) {
            i17 = i12 / this.f1703u;
            i2 = ((i12 % this.f1703u) / i17) + this.f1703u;
        } else {
            i2 = 0;
        }
        int i18 = 0;
        int i19 = 0;
        int i20 = i17;
        while (i18 < i) {
            C0566s sVar2 = (C0566s) arrayList.get(i18);
            if (sVar2.mo2545l()) {
                View a = mo2402a(sVar2, this.f1705w, viewGroup);
                if (this.f1705w == null) {
                    this.f1705w = a;
                }
                if (this.f1700r) {
                    i20 -= ActionMenuView.m2577a(a, i2, i20, makeMeasureSpec, 0);
                } else {
                    a.measure(makeMeasureSpec, makeMeasureSpec);
                }
                i3 = a.getMeasuredWidth();
                int i21 = i12 - i3;
                if (i19 != 0) {
                    i3 = i19;
                }
                int groupId = sVar2.getGroupId();
                if (groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                }
                sVar2.mo2519d(true);
                i4 = i21;
                i5 = i16;
            } else if (sVar2.mo2544k()) {
                int groupId2 = sVar2.getGroupId();
                boolean z4 = sparseBooleanArray.get(groupId2);
                boolean z5 = (i16 > 0 || z4) && i12 > 0 && (!this.f1700r || i20 > 0);
                if (z5) {
                    View a2 = mo2402a(sVar2, this.f1705w, viewGroup);
                    if (this.f1705w == null) {
                        this.f1705w = a2;
                    }
                    if (this.f1700r) {
                        int a3 = ActionMenuView.m2577a(a2, i2, i20, makeMeasureSpec, 0);
                        int i22 = i20 - a3;
                        z2 = a3 == 0 ? false : z5;
                        i9 = i22;
                    } else {
                        a2.measure(makeMeasureSpec, makeMeasureSpec);
                        boolean z6 = z5;
                        i9 = i20;
                        z2 = z6;
                    }
                    int measuredWidth = a2.getMeasuredWidth();
                    i12 -= measuredWidth;
                    if (i19 == 0) {
                        i19 = measuredWidth;
                    }
                    if (this.f1700r) {
                        z = z2 & (i12 >= 0);
                        i6 = i19;
                        i7 = i9;
                    } else {
                        z = z2 & (i12 + i19 > 0);
                        i6 = i19;
                        i7 = i9;
                    }
                } else {
                    z = z5;
                    i6 = i19;
                    i7 = i20;
                }
                if (z && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                    i8 = i16;
                } else if (z4) {
                    sparseBooleanArray.put(groupId2, false);
                    int i23 = i16;
                    for (int i24 = 0; i24 < i18; i24++) {
                        C0566s sVar3 = (C0566s) arrayList.get(i24);
                        if (sVar3.getGroupId() == groupId2) {
                            if (sVar3.mo2543j()) {
                                i23++;
                            }
                            sVar3.mo2519d(false);
                        }
                    }
                    i8 = i23;
                } else {
                    i8 = i16;
                }
                if (z) {
                    i8--;
                }
                sVar2.mo2519d(z);
                i3 = i6;
                i4 = i12;
                int i25 = i7;
                i5 = i8;
                i20 = i25;
            } else {
                sVar2.mo2519d(false);
                i3 = i19;
                i4 = i12;
                i5 = i16;
            }
            i18++;
            i12 = i4;
            i16 = i5;
            i19 = i3;
        }
        return true;
    }

    /* renamed from: c */
    public Drawable mo3355c() {
        if (this.f1691i != null) {
            return this.f1691i.getDrawable();
        }
        if (this.f1693k) {
            return this.f1692j;
        }
        return null;
    }

    /* renamed from: c */
    public void mo3356c(boolean z) {
        this.f1694l = z;
        this.f1695m = true;
    }

    /* renamed from: d */
    public void mo3357d(boolean z) {
        this.f1702t = z;
    }

    /* renamed from: d */
    public boolean mo3358d() {
        if (!this.f1694l || mo3362h() || this.f1042c == null || this.f1045f == null || this.f1708z != null || this.f1042c.mo2488l().isEmpty()) {
            return false;
        }
        this.f1708z = new C0693o(this, new C0696r(this, this.f1041b, this.f1042c, this.f1691i, true));
        ((View) this.f1045f).post(this.f1708z);
        super.mo2335a((C0547an) null);
        return true;
    }

    /* renamed from: e */
    public boolean mo3359e() {
        if (this.f1708z == null || this.f1045f == null) {
            C0696r rVar = this.f1706x;
            if (rVar == null) {
                return false;
            }
            rVar.mo2328d();
            return true;
        }
        ((View) this.f1045f).removeCallbacks(this.f1708z);
        this.f1708z = null;
        return true;
    }

    /* renamed from: f */
    public boolean mo3360f() {
        return mo3359e() | mo3361g();
    }

    /* renamed from: g */
    public boolean mo3361g() {
        if (this.f1707y == null) {
            return false;
        }
        this.f1707y.mo2328d();
        return true;
    }

    /* renamed from: h */
    public boolean mo3362h() {
        return this.f1706x != null && this.f1706x.mo2330f();
    }

    /* renamed from: i */
    public boolean mo3363i() {
        return this.f1708z != null || mo3362h();
    }
}
