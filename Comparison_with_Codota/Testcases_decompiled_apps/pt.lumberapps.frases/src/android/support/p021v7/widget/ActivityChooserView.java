package android.support.p021v7.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.support.p009v4.view.C0344n;
import android.support.p021v7.p023b.C0513i;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.PopupWindow;

/* renamed from: android.support.v7.widget.ActivityChooserView */
public class ActivityChooserView extends ViewGroup {

    /* renamed from: a */
    C0344n f1228a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final C0582ag f1229b;

    /* renamed from: c */
    private final C0583ah f1230c;

    /* renamed from: d */
    private final C0634ce f1231d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final FrameLayout f1232e;

    /* renamed from: f */
    private final ImageView f1233f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final FrameLayout f1234g;

    /* renamed from: h */
    private final int f1235h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final DataSetObserver f1236i;

    /* renamed from: j */
    private final ViewTreeObserver.OnGlobalLayoutListener f1237j;

    /* renamed from: k */
    private C0636cg f1238k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public PopupWindow.OnDismissListener f1239l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public boolean f1240m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public int f1241n;

    /* renamed from: o */
    private boolean f1242o;

    /* renamed from: p */
    private int f1243p;

    /* renamed from: android.support.v7.widget.ActivityChooserView$InnerLayout */
    public class InnerLayout extends C0634ce {

        /* renamed from: a */
        private static final int[] f1244a = {16842964};

        public InnerLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            C0670dn a = C0670dn.m3013a(context, attributeSet, f1244a);
            setBackgroundDrawable(a.mo3318a(0));
            a.mo3319a();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m2600a(int i) {
        if (this.f1229b.mo2932d() == null) {
            throw new IllegalStateException("No data model. Did you call #setDataModel?");
        }
        getViewTreeObserver().addOnGlobalLayoutListener(this.f1237j);
        boolean z = this.f1234g.getVisibility() == 0;
        int c = this.f1229b.mo2931c();
        int i2 = z ? 1 : 0;
        if (i == Integer.MAX_VALUE || c <= i2 + i) {
            this.f1229b.mo2928a(false);
            this.f1229b.mo2926a(i);
        } else {
            this.f1229b.mo2928a(true);
            this.f1229b.mo2926a(i - 1);
        }
        C0636cg listPopupWindow = getListPopupWindow();
        if (!listPopupWindow.mo2364d()) {
            if (this.f1240m || !z) {
                this.f1229b.mo2929a(true, z);
            } else {
                this.f1229b.mo2929a(false, false);
            }
            listPopupWindow.mo3180g(Math.min(this.f1229b.mo2925a(), this.f1235h));
            listPopupWindow.mo2362a();
            if (this.f1228a != null) {
                this.f1228a.mo1620a(true);
            }
            listPopupWindow.mo2365e().setContentDescription(getContext().getString(C0513i.abc_activitychooserview_choose_application));
        }
    }

    private C0636cg getListPopupWindow() {
        if (this.f1238k == null) {
            this.f1238k = new C0636cg(getContext());
            this.f1238k.mo3065a((ListAdapter) this.f1229b);
            this.f1238k.setAnchorView(this);
            this.f1238k.mo3174a(true);
            this.f1238k.mo3172a((AdapterView.OnItemClickListener) this.f1230c);
            this.f1238k.mo3173a((PopupWindow.OnDismissListener) this.f1230c);
        }
        return this.f1238k;
    }

    /* renamed from: a */
    public boolean mo2740a() {
        if (mo2742c() || !this.f1242o) {
            return false;
        }
        this.f1240m = false;
        m2600a(this.f1241n);
        return true;
    }

    /* renamed from: b */
    public boolean mo2741b() {
        if (!mo2742c()) {
            return true;
        }
        getListPopupWindow().mo2363c();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (!viewTreeObserver.isAlive()) {
            return true;
        }
        viewTreeObserver.removeGlobalOnLayoutListener(this.f1237j);
        return true;
    }

    /* renamed from: c */
    public boolean mo2742c() {
        return getListPopupWindow().mo2364d();
    }

    public C0704z getDataModel() {
        return this.f1229b.mo2932d();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        C0704z d = this.f1229b.mo2932d();
        if (d != null) {
            d.registerObserver(this.f1236i);
        }
        this.f1242o = true;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C0704z d = this.f1229b.mo2932d();
        if (d != null) {
            d.unregisterObserver(this.f1236i);
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.f1237j);
        }
        if (mo2742c()) {
            mo2741b();
        }
        this.f1242o = false;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.f1231d.layout(0, 0, i3 - i, i4 - i2);
        if (!mo2742c()) {
            mo2741b();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        C0634ce ceVar = this.f1231d;
        if (this.f1234g.getVisibility() != 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2), 1073741824);
        }
        measureChild(ceVar, i, i2);
        setMeasuredDimension(ceVar.getMeasuredWidth(), ceVar.getMeasuredHeight());
    }

    public void setActivityChooserModel(C0704z zVar) {
        this.f1229b.mo2927a(zVar);
        if (mo2742c()) {
            mo2741b();
            mo2740a();
        }
    }

    public void setDefaultActionButtonContentDescription(int i) {
        this.f1243p = i;
    }

    public void setExpandActivityOverflowButtonContentDescription(int i) {
        this.f1233f.setContentDescription(getContext().getString(i));
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        this.f1233f.setImageDrawable(drawable);
    }

    public void setInitialActivityCount(int i) {
        this.f1241n = i;
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.f1239l = onDismissListener;
    }

    public void setProvider(C0344n nVar) {
        this.f1228a = nVar;
    }
}
