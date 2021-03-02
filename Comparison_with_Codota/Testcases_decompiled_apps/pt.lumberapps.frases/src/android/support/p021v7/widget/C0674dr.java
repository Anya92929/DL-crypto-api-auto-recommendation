package android.support.p021v7.widget;

import android.content.Context;
import android.support.p021v7.p023b.C0515k;
import android.support.p021v7.view.C0523d;
import android.support.p021v7.view.menu.C0538ae;
import android.support.p021v7.view.menu.C0539af;
import android.support.p021v7.view.menu.C0547an;
import android.support.p021v7.view.menu.C0562o;
import android.support.p021v7.view.menu.C0566s;

/* renamed from: android.support.v7.widget.dr */
class C0674dr implements C0538ae {

    /* renamed from: a */
    C0562o f1655a;

    /* renamed from: b */
    C0566s f1656b;

    /* renamed from: c */
    final /* synthetic */ Toolbar f1657c;

    private C0674dr(Toolbar toolbar) {
        this.f1657c = toolbar;
    }

    /* synthetic */ C0674dr(Toolbar toolbar, C0671do doVar) {
        this(toolbar);
    }

    /* renamed from: a */
    public void mo2308a(Context context, C0562o oVar) {
        if (!(this.f1655a == null || this.f1656b == null)) {
            this.f1655a.mo2375d(this.f1656b);
        }
        this.f1655a = oVar;
    }

    /* renamed from: a */
    public void mo2333a(C0539af afVar) {
    }

    /* renamed from: a */
    public void mo2334a(C0562o oVar, boolean z) {
    }

    /* renamed from: a */
    public boolean mo2335a(C0547an anVar) {
        return false;
    }

    /* renamed from: a */
    public boolean mo2313a(C0562o oVar, C0566s sVar) {
        this.f1657c.m2663p();
        if (this.f1657c.f1323i.getParent() != this.f1657c) {
            this.f1657c.addView(this.f1657c.f1323i);
        }
        this.f1657c.f1315a = sVar.getActionView();
        this.f1656b = sVar;
        if (this.f1657c.f1315a.getParent() != this.f1657c) {
            C0675ds i = this.f1657c.generateDefaultLayoutParams();
            i.f643a = 8388611 | (this.f1657c.f1328n & C0515k.AppCompatTheme_spinnerStyle);
            i.f1658b = 2;
            this.f1657c.f1315a.setLayoutParams(i);
            this.f1657c.addView(this.f1657c.f1315a);
        }
        this.f1657c.mo2862j();
        this.f1657c.requestLayout();
        sVar.mo2521e(true);
        if (this.f1657c.f1315a instanceof C0523d) {
            ((C0523d) this.f1657c.f1315a).mo2197a();
        }
        return true;
    }

    /* renamed from: b */
    public void mo2336b(boolean z) {
        boolean z2 = false;
        if (this.f1656b != null) {
            if (this.f1655a != null) {
                int size = this.f1655a.size();
                int i = 0;
                while (true) {
                    if (i >= size) {
                        break;
                    } else if (this.f1655a.getItem(i) == this.f1656b) {
                        z2 = true;
                        break;
                    } else {
                        i++;
                    }
                }
            }
            if (!z2) {
                mo2315b(this.f1655a, this.f1656b);
            }
        }
    }

    /* renamed from: b */
    public boolean mo2337b() {
        return false;
    }

    /* renamed from: b */
    public boolean mo2315b(C0562o oVar, C0566s sVar) {
        if (this.f1657c.f1315a instanceof C0523d) {
            ((C0523d) this.f1657c.f1315a).mo2198b();
        }
        this.f1657c.removeView(this.f1657c.f1315a);
        this.f1657c.removeView(this.f1657c.f1323i);
        this.f1657c.f1315a = null;
        this.f1657c.mo2863k();
        this.f1656b = null;
        this.f1657c.requestLayout();
        sVar.mo2521e(false);
        return true;
    }
}
