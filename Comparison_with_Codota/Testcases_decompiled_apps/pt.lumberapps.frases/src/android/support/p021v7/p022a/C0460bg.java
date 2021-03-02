package android.support.p021v7.p022a;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.p021v7.p023b.C0506b;
import android.support.p021v7.p023b.C0512h;
import android.support.p021v7.p023b.C0514j;
import android.support.p021v7.p023b.C0515k;
import android.support.p021v7.view.C0524e;
import android.support.p021v7.view.menu.C0538ae;
import android.support.p021v7.view.menu.C0539af;
import android.support.p021v7.view.menu.C0540ag;
import android.support.p021v7.view.menu.C0559l;
import android.support.p021v7.view.menu.C0562o;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: android.support.v7.a.bg */
public final class C0460bg {

    /* renamed from: a */
    int f651a;

    /* renamed from: b */
    int f652b;

    /* renamed from: c */
    int f653c;

    /* renamed from: d */
    int f654d;

    /* renamed from: e */
    int f655e;

    /* renamed from: f */
    int f656f;

    /* renamed from: g */
    ViewGroup f657g;

    /* renamed from: h */
    View f658h;

    /* renamed from: i */
    View f659i;

    /* renamed from: j */
    C0562o f660j;

    /* renamed from: k */
    C0559l f661k;

    /* renamed from: l */
    Context f662l;

    /* renamed from: m */
    boolean f663m;

    /* renamed from: n */
    boolean f664n;

    /* renamed from: o */
    boolean f665o;

    /* renamed from: p */
    public boolean f666p;

    /* renamed from: q */
    boolean f667q = false;

    /* renamed from: r */
    boolean f668r;

    /* renamed from: s */
    Bundle f669s;

    C0460bg(int i) {
        this.f651a = i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0540ag mo2050a(C0539af afVar) {
        if (this.f660j == null) {
            return null;
        }
        if (this.f661k == null) {
            this.f661k = new C0559l(this.f662l, C0512h.abc_list_menu_item_layout);
            this.f661k.mo2333a(afVar);
            this.f660j.mo2449a((C0538ae) this.f661k);
        }
        return this.f661k.mo2421a(this.f657g);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2051a(Context context) {
        TypedValue typedValue = new TypedValue();
        Resources.Theme newTheme = context.getResources().newTheme();
        newTheme.setTo(context.getTheme());
        newTheme.resolveAttribute(C0506b.actionBarPopupTheme, typedValue, true);
        if (typedValue.resourceId != 0) {
            newTheme.applyStyle(typedValue.resourceId, true);
        }
        newTheme.resolveAttribute(C0506b.panelMenuListTheme, typedValue, true);
        if (typedValue.resourceId != 0) {
            newTheme.applyStyle(typedValue.resourceId, true);
        } else {
            newTheme.applyStyle(C0514j.Theme_AppCompat_CompactMenu, true);
        }
        C0524e eVar = new C0524e(context, 0);
        eVar.getTheme().setTo(newTheme);
        this.f662l = eVar;
        TypedArray obtainStyledAttributes = eVar.obtainStyledAttributes(C0515k.AppCompatTheme);
        this.f652b = obtainStyledAttributes.getResourceId(C0515k.AppCompatTheme_panelBackground, 0);
        this.f656f = obtainStyledAttributes.getResourceId(C0515k.AppCompatTheme_android_windowAnimationStyle, 0);
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2052a(C0562o oVar) {
        if (oVar != this.f660j) {
            if (this.f660j != null) {
                this.f660j.mo2468b((C0538ae) this.f661k);
            }
            this.f660j = oVar;
            if (oVar != null && this.f661k != null) {
                oVar.mo2449a((C0538ae) this.f661k);
            }
        }
    }

    /* renamed from: a */
    public boolean mo2053a() {
        if (this.f658h == null) {
            return false;
        }
        return this.f659i != null || this.f661k.mo2422a().getCount() > 0;
    }
}
