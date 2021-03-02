package android.support.p021v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.p009v4.view.C0247by;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.SpinnerAdapter;

/* renamed from: android.support.v7.widget.bk */
class C0613bk extends C0636cg {

    /* renamed from: a */
    final /* synthetic */ C0610bh f1463a;

    /* renamed from: d */
    private CharSequence f1464d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public ListAdapter f1465e;

    /* renamed from: f */
    private final Rect f1466f = new Rect();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0613bk(C0610bh bhVar, Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1463a = bhVar;
        setAnchorView(bhVar);
        mo3174a(true);
        mo3169a(0);
        mo3172a((AdapterView.OnItemClickListener) new C0614bl(this, bhVar));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m2790a(View view) {
        return C0247by.m925r(view) && view.getGlobalVisibleRect(this.f1466f);
    }

    /* renamed from: a */
    public void mo2362a() {
        ViewTreeObserver viewTreeObserver;
        boolean d = mo2364d();
        mo3068f();
        mo3183h(2);
        super.mo2362a();
        mo2365e().setChoiceMode(1);
        mo3185i(this.f1463a.getSelectedItemPosition());
        if (!d && (viewTreeObserver = this.f1463a.getViewTreeObserver()) != null) {
            C0615bm bmVar = new C0615bm(this);
            viewTreeObserver.addOnGlobalLayoutListener(bmVar);
            mo3173a((PopupWindow.OnDismissListener) new C0616bn(this, bmVar));
        }
    }

    /* renamed from: a */
    public void mo3065a(ListAdapter listAdapter) {
        super.mo3065a(listAdapter);
        this.f1465e = listAdapter;
    }

    /* renamed from: a */
    public void mo3066a(CharSequence charSequence) {
        this.f1464d = charSequence;
    }

    /* renamed from: b */
    public CharSequence mo3067b() {
        return this.f1464d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo3068f() {
        int i;
        Drawable h = mo3182h();
        if (h != null) {
            h.getPadding(this.f1463a.f1458l);
            i = C0682dz.m3095a(this.f1463a) ? this.f1463a.f1458l.right : -this.f1463a.f1458l.left;
        } else {
            Rect b = this.f1463a.f1458l;
            this.f1463a.f1458l.right = 0;
            b.left = 0;
            i = 0;
        }
        int paddingLeft = this.f1463a.getPaddingLeft();
        int paddingRight = this.f1463a.getPaddingRight();
        int width = this.f1463a.getWidth();
        if (this.f1463a.f1457k == -2) {
            int a = this.f1463a.m2781a((SpinnerAdapter) this.f1465e, mo3182h());
            int i2 = (this.f1463a.getContext().getResources().getDisplayMetrics().widthPixels - this.f1463a.f1458l.left) - this.f1463a.f1458l.right;
            if (a <= i2) {
                i2 = a;
            }
            mo3180g(Math.max(i2, (width - paddingLeft) - paddingRight));
        } else if (this.f1463a.f1457k == -1) {
            mo3180g((width - paddingLeft) - paddingRight);
        } else {
            mo3180g(this.f1463a.f1457k);
        }
        mo3176c(C0682dz.m3095a(this.f1463a) ? ((width - paddingRight) - mo3188l()) + i : i + paddingLeft);
    }
}
