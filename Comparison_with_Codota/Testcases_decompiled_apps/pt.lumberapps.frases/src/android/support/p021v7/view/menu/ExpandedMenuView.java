package android.support.p021v7.view.menu;

import android.content.Context;
import android.support.p021v7.widget.C0670dn;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

/* renamed from: android.support.v7.view.menu.ExpandedMenuView */
public final class ExpandedMenuView extends ListView implements C0540ag, C0564q, AdapterView.OnItemClickListener {

    /* renamed from: a */
    private static final int[] f967a = {16842964, 16843049};

    /* renamed from: b */
    private C0562o f968b;

    /* renamed from: c */
    private int f969c;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842868);
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        C0670dn a = C0670dn.m3014a(context, attributeSet, f967a, i, 0);
        if (a.mo3332g(0)) {
            setBackgroundDrawable(a.mo3318a(0));
        }
        if (a.mo3332g(1)) {
            setDivider(a.mo3318a(1));
        }
        a.mo3319a();
    }

    /* renamed from: a */
    public void mo2257a(C0562o oVar) {
        this.f968b = oVar;
    }

    /* renamed from: a */
    public boolean mo2258a(C0566s sVar) {
        return this.f968b.mo2455a((MenuItem) sVar, 0);
    }

    public int getWindowAnimations() {
        return this.f969c;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        mo2258a((C0566s) getAdapter().getItem(i));
    }
}
