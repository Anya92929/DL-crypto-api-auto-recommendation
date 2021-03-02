package android.support.p021v7.view.menu;

import android.support.p021v7.view.C0523d;
import android.view.CollapsibleActionView;
import android.view.View;
import android.widget.FrameLayout;

/* renamed from: android.support.v7.view.menu.w */
class C0570w extends FrameLayout implements C0523d {

    /* renamed from: a */
    final CollapsibleActionView f1163a;

    C0570w(View view) {
        super(view.getContext());
        this.f1163a = (CollapsibleActionView) view;
        addView(view);
    }

    /* renamed from: a */
    public void mo2197a() {
        this.f1163a.onActionViewExpanded();
    }

    /* renamed from: b */
    public void mo2198b() {
        this.f1163a.onActionViewCollapsed();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public View mo2608c() {
        return (View) this.f1163a;
    }
}
