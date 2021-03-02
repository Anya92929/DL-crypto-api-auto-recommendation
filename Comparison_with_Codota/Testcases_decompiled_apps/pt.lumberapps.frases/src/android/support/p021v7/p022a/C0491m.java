package android.support.p021v7.p022a;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

/* renamed from: android.support.v7.a.m */
class C0491m implements C0485g {

    /* renamed from: a */
    final Activity f768a;

    private C0491m(Activity activity) {
        this.f768a = activity;
    }

    /* synthetic */ C0491m(Activity activity, C0484f fVar) {
        this(activity);
    }

    /* renamed from: a */
    public Drawable mo2009a() {
        TypedArray obtainStyledAttributes = mo2012b().obtainStyledAttributes((AttributeSet) null, new int[]{16843531}, 16843470, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
        return drawable;
    }

    /* renamed from: a */
    public void mo2010a(int i) {
        ActionBar actionBar = this.f768a.getActionBar();
        if (actionBar != null) {
            actionBar.setHomeActionContentDescription(i);
        }
    }

    /* renamed from: a */
    public void mo2011a(Drawable drawable, int i) {
        ActionBar actionBar = this.f768a.getActionBar();
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(drawable);
            actionBar.setHomeActionContentDescription(i);
        }
    }

    /* renamed from: b */
    public Context mo2012b() {
        ActionBar actionBar = this.f768a.getActionBar();
        return actionBar != null ? actionBar.getThemedContext() : this.f768a;
    }

    /* renamed from: c */
    public boolean mo2013c() {
        ActionBar actionBar = this.f768a.getActionBar();
        return (actionBar == null || (actionBar.getDisplayOptions() & 4) == 0) ? false : true;
    }
}
