package android.support.p021v7.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.p009v4.p010a.p011a.C0026a;
import android.support.p009v4.view.C0275cz;
import android.support.p021v7.p023b.C0506b;
import android.support.p021v7.p023b.C0507c;
import android.support.p021v7.p023b.C0509e;
import android.support.p021v7.p023b.C0515k;
import android.util.AttributeSet;
import android.view.ViewConfiguration;

/* renamed from: android.support.v7.view.a */
public class C0520a {

    /* renamed from: a */
    private Context f893a;

    private C0520a(Context context) {
        this.f893a = context;
    }

    /* renamed from: a */
    public static C0520a m2179a(Context context) {
        return new C0520a(context);
    }

    /* renamed from: a */
    public int mo2187a() {
        Resources resources = this.f893a.getResources();
        int b = C0026a.m124b(resources);
        int a = C0026a.m123a(resources);
        if (C0026a.m125c(resources) > 600 || b > 600 || ((b > 960 && a > 720) || (b > 720 && a > 960))) {
            return 5;
        }
        if (b >= 500 || ((b > 640 && a > 480) || (b > 480 && a > 640))) {
            return 4;
        }
        return b >= 360 ? 3 : 2;
    }

    /* renamed from: b */
    public boolean mo2188b() {
        return Build.VERSION.SDK_INT >= 19 || !C0275cz.m1120b(ViewConfiguration.get(this.f893a));
    }

    /* renamed from: c */
    public int mo2189c() {
        return this.f893a.getResources().getDisplayMetrics().widthPixels / 2;
    }

    /* renamed from: d */
    public boolean mo2190d() {
        return this.f893a.getResources().getBoolean(C0507c.abc_action_bar_embed_tabs);
    }

    /* renamed from: e */
    public int mo2191e() {
        TypedArray obtainStyledAttributes = this.f893a.obtainStyledAttributes((AttributeSet) null, C0515k.ActionBar, C0506b.actionBarStyle, 0);
        int layoutDimension = obtainStyledAttributes.getLayoutDimension(C0515k.ActionBar_height, 0);
        Resources resources = this.f893a.getResources();
        if (!mo2190d()) {
            layoutDimension = Math.min(layoutDimension, resources.getDimensionPixelSize(C0509e.abc_action_bar_stacked_max_height));
        }
        obtainStyledAttributes.recycle();
        return layoutDimension;
    }

    /* renamed from: f */
    public boolean mo2192f() {
        return this.f893a.getApplicationInfo().targetSdkVersion < 14;
    }

    /* renamed from: g */
    public int mo2193g() {
        return this.f893a.getResources().getDimensionPixelSize(C0509e.abc_action_bar_stacked_tab_max_width);
    }
}
