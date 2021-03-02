package android.support.p009v4.view;

import android.os.Bundle;
import android.support.p009v4.app.FragmentTransaction;
import android.support.p009v4.view.p020a.C0153a;
import android.support.p009v4.view.p020a.C0163aj;
import android.support.p009v4.view.p020a.C0175f;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

/* renamed from: android.support.v4.view.dw */
class C0299dw extends C0152a {

    /* renamed from: b */
    final /* synthetic */ ViewPager f380b;

    C0299dw(ViewPager viewPager) {
        this.f380b = viewPager;
    }

    /* renamed from: b */
    private boolean m1148b() {
        return this.f380b.f277h != null && this.f380b.f277h.getCount() > 1;
    }

    /* renamed from: a */
    public void mo1248a(View view, C0175f fVar) {
        super.mo1248a(view, fVar);
        fVar.mo1299b((CharSequence) ViewPager.class.getName());
        fVar.mo1318i(m1148b());
        if (this.f380b.canScrollHorizontally(1)) {
            fVar.mo1291a((int) FragmentTransaction.TRANSIT_ENTER_MASK);
        }
        if (this.f380b.canScrollHorizontally(-1)) {
            fVar.mo1291a((int) FragmentTransaction.TRANSIT_EXIT_MASK);
        }
    }

    /* renamed from: a */
    public boolean mo1250a(View view, int i, Bundle bundle) {
        if (super.mo1250a(view, i, bundle)) {
            return true;
        }
        switch (i) {
            case FragmentTransaction.TRANSIT_ENTER_MASK:
                if (!this.f380b.canScrollHorizontally(1)) {
                    return false;
                }
                this.f380b.setCurrentItem(this.f380b.f278i + 1);
                return true;
            case FragmentTransaction.TRANSIT_EXIT_MASK:
                if (!this.f380b.canScrollHorizontally(-1)) {
                    return false;
                }
                this.f380b.setCurrentItem(this.f380b.f278i - 1);
                return true;
            default:
                return false;
        }
    }

    /* renamed from: d */
    public void mo1254d(View view, AccessibilityEvent accessibilityEvent) {
        super.mo1254d(view, accessibilityEvent);
        accessibilityEvent.setClassName(ViewPager.class.getName());
        C0163aj a = C0153a.m459a(accessibilityEvent);
        a.mo1271a(m1148b());
        if (accessibilityEvent.getEventType() == 4096 && this.f380b.f277h != null) {
            a.mo1270a(this.f380b.f277h.getCount());
            a.mo1272b(this.f380b.f278i);
            a.mo1273c(this.f380b.f278i);
        }
    }
}
