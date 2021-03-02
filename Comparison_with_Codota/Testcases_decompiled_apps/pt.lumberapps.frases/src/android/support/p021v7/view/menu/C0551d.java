package android.support.p021v7.view.menu;

import android.content.Context;
import android.support.p009v4.view.C0247by;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

/* renamed from: android.support.v7.view.menu.d */
public abstract class C0551d implements C0538ae {

    /* renamed from: a */
    protected Context f1040a;

    /* renamed from: b */
    protected Context f1041b;

    /* renamed from: c */
    protected C0562o f1042c;

    /* renamed from: d */
    protected LayoutInflater f1043d;

    /* renamed from: e */
    protected LayoutInflater f1044e;

    /* renamed from: f */
    protected C0540ag f1045f;

    /* renamed from: g */
    private C0539af f1046g;

    /* renamed from: h */
    private int f1047h;

    /* renamed from: i */
    private int f1048i;

    /* renamed from: j */
    private int f1049j;

    public C0551d(Context context, int i, int i2) {
        this.f1040a = context;
        this.f1043d = LayoutInflater.from(context);
        this.f1047h = i;
        this.f1048i = i2;
    }

    /* renamed from: a */
    public C0539af mo2400a() {
        return this.f1046g;
    }

    /* renamed from: a */
    public C0540ag mo2401a(ViewGroup viewGroup) {
        if (this.f1045f == null) {
            this.f1045f = (C0540ag) this.f1043d.inflate(this.f1047h, viewGroup, false);
            this.f1045f.mo2257a(this.f1042c);
            mo2336b(true);
        }
        return this.f1045f;
    }

    /* renamed from: a */
    public View mo2402a(C0566s sVar, View view, ViewGroup viewGroup) {
        C0541ah b = view instanceof C0541ah ? (C0541ah) view : mo2408b(viewGroup);
        mo2404a(sVar, b);
        return (View) b;
    }

    /* renamed from: a */
    public void mo2403a(int i) {
        this.f1049j = i;
    }

    /* renamed from: a */
    public void mo2308a(Context context, C0562o oVar) {
        this.f1041b = context;
        this.f1044e = LayoutInflater.from(this.f1041b);
        this.f1042c = oVar;
    }

    /* renamed from: a */
    public void mo2333a(C0539af afVar) {
        this.f1046g = afVar;
    }

    /* renamed from: a */
    public void mo2334a(C0562o oVar, boolean z) {
        if (this.f1046g != null) {
            this.f1046g.mo2041a(oVar, z);
        }
    }

    /* renamed from: a */
    public abstract void mo2404a(C0566s sVar, C0541ah ahVar);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo2405a(View view, int i) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.f1045f).addView(view, i);
    }

    /* renamed from: a */
    public boolean mo2406a(int i, C0566s sVar) {
        return true;
    }

    /* renamed from: a */
    public boolean mo2335a(C0547an anVar) {
        if (this.f1046g != null) {
            return this.f1046g.mo2042a(anVar);
        }
        return false;
    }

    /* renamed from: a */
    public boolean mo2313a(C0562o oVar, C0566s sVar) {
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo2407a(ViewGroup viewGroup, int i) {
        viewGroup.removeViewAt(i);
        return true;
    }

    /* renamed from: b */
    public C0541ah mo2408b(ViewGroup viewGroup) {
        return (C0541ah) this.f1043d.inflate(this.f1048i, viewGroup, false);
    }

    /* renamed from: b */
    public void mo2336b(boolean z) {
        int i;
        int i2;
        ViewGroup viewGroup = (ViewGroup) this.f1045f;
        if (viewGroup != null) {
            if (this.f1042c != null) {
                this.f1042c.mo2486j();
                ArrayList i3 = this.f1042c.mo2484i();
                int size = i3.size();
                int i4 = 0;
                i = 0;
                while (i4 < size) {
                    C0566s sVar = (C0566s) i3.get(i4);
                    if (mo2406a(i, sVar)) {
                        View childAt = viewGroup.getChildAt(i);
                        C0566s itemData = childAt instanceof C0541ah ? ((C0541ah) childAt).getItemData() : null;
                        View a = mo2402a(sVar, childAt, viewGroup);
                        if (sVar != itemData) {
                            a.setPressed(false);
                            C0247by.jumpDrawablesToCurrentState(a);
                        }
                        if (a != childAt) {
                            mo2405a(a, i);
                        }
                        i2 = i + 1;
                    } else {
                        i2 = i;
                    }
                    i4++;
                    i = i2;
                }
            } else {
                i = 0;
            }
            while (i < viewGroup.getChildCount()) {
                if (!mo2407a(viewGroup, i)) {
                    i++;
                }
            }
        }
    }

    /* renamed from: b */
    public boolean mo2337b() {
        return false;
    }

    /* renamed from: b */
    public boolean mo2315b(C0562o oVar, C0566s sVar) {
        return false;
    }
}
