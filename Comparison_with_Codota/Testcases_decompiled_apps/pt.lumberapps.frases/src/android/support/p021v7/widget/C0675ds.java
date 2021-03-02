package android.support.p021v7.widget;

import android.content.Context;
import android.support.p021v7.p022a.C0453b;
import android.util.AttributeSet;
import android.view.ViewGroup;

/* renamed from: android.support.v7.widget.ds */
public class C0675ds extends C0453b {

    /* renamed from: b */
    int f1658b = 0;

    public C0675ds(int i, int i2) {
        super(i, i2);
        this.f643a = 8388627;
    }

    public C0675ds(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public C0675ds(C0453b bVar) {
        super(bVar);
    }

    public C0675ds(C0675ds dsVar) {
        super((C0453b) dsVar);
        this.f1658b = dsVar.f1658b;
    }

    public C0675ds(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
    }

    public C0675ds(ViewGroup.MarginLayoutParams marginLayoutParams) {
        super((ViewGroup.LayoutParams) marginLayoutParams);
        mo3336a(marginLayoutParams);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3336a(ViewGroup.MarginLayoutParams marginLayoutParams) {
        this.leftMargin = marginLayoutParams.leftMargin;
        this.topMargin = marginLayoutParams.topMargin;
        this.rightMargin = marginLayoutParams.rightMargin;
        this.bottomMargin = marginLayoutParams.bottomMargin;
    }
}
