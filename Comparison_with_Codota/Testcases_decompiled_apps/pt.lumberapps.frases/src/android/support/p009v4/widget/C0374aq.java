package android.support.p009v4.widget;

import android.os.Bundle;
import android.support.p009v4.app.FragmentTransaction;
import android.support.p009v4.view.C0152a;
import android.support.p009v4.view.p020a.C0153a;
import android.support.p009v4.view.p020a.C0163aj;
import android.support.p009v4.view.p020a.C0175f;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.ScrollView;

/* renamed from: android.support.v4.widget.aq */
class C0374aq extends C0152a {
    C0374aq() {
    }

    /* renamed from: a */
    public void mo1248a(View view, C0175f fVar) {
        int a;
        super.mo1248a(view, fVar);
        NestedScrollView nestedScrollView = (NestedScrollView) view;
        fVar.mo1299b((CharSequence) ScrollView.class.getName());
        if (nestedScrollView.isEnabled() && (a = nestedScrollView.getScrollRange()) > 0) {
            fVar.mo1318i(true);
            if (nestedScrollView.getScrollY() > 0) {
                fVar.mo1291a((int) FragmentTransaction.TRANSIT_EXIT_MASK);
            }
            if (nestedScrollView.getScrollY() < a) {
                fVar.mo1291a((int) FragmentTransaction.TRANSIT_ENTER_MASK);
            }
        }
    }

    /* renamed from: a */
    public boolean mo1250a(View view, int i, Bundle bundle) {
        if (super.mo1250a(view, i, bundle)) {
            return true;
        }
        NestedScrollView nestedScrollView = (NestedScrollView) view;
        if (!nestedScrollView.isEnabled()) {
            return false;
        }
        switch (i) {
            case FragmentTransaction.TRANSIT_ENTER_MASK:
                int min = Math.min(((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()) + nestedScrollView.getScrollY(), nestedScrollView.getScrollRange());
                if (min == nestedScrollView.getScrollY()) {
                    return false;
                }
                nestedScrollView.mo1705b(0, min);
                return true;
            case FragmentTransaction.TRANSIT_EXIT_MASK:
                int max = Math.max(nestedScrollView.getScrollY() - ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                if (max == nestedScrollView.getScrollY()) {
                    return false;
                }
                nestedScrollView.mo1705b(0, max);
                return true;
            default:
                return false;
        }
    }

    /* renamed from: d */
    public void mo1254d(View view, AccessibilityEvent accessibilityEvent) {
        super.mo1254d(view, accessibilityEvent);
        NestedScrollView nestedScrollView = (NestedScrollView) view;
        accessibilityEvent.setClassName(ScrollView.class.getName());
        C0163aj a = C0153a.m459a(accessibilityEvent);
        a.mo1271a(nestedScrollView.getScrollRange() > 0);
        a.mo1274d(nestedScrollView.getScrollX());
        a.mo1275e(nestedScrollView.getScrollY());
        a.mo1277f(nestedScrollView.getScrollX());
        a.mo1278g(nestedScrollView.getScrollRange());
    }
}
