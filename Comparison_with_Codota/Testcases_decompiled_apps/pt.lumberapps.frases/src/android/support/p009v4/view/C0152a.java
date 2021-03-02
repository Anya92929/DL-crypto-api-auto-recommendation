package android.support.p009v4.view;

import android.os.Build;
import android.os.Bundle;
import android.support.p009v4.view.p020a.C0175f;
import android.support.p009v4.view.p020a.C0192w;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

/* renamed from: android.support.v4.view.a */
public class C0152a {

    /* renamed from: b */
    private static final C0276d f299b;

    /* renamed from: c */
    private static final Object f300c = f299b.mo1404a();

    /* renamed from: a */
    final Object f301a = f299b.mo1405a(this);

    static {
        if (Build.VERSION.SDK_INT >= 16) {
            f299b = new C0303e();
        } else if (Build.VERSION.SDK_INT >= 14) {
            f299b = new C0222b();
        } else {
            f299b = new C0337g();
        }
    }

    /* renamed from: a */
    public C0192w mo1245a(View view) {
        return f299b.mo1524a(f300c, view);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Object mo1246a() {
        return this.f301a;
    }

    /* renamed from: a */
    public void mo1247a(View view, int i) {
        f299b.mo1406a(f300c, view, i);
    }

    /* renamed from: a */
    public void mo1248a(View view, C0175f fVar) {
        f299b.mo1407a(f300c, view, fVar);
    }

    /* renamed from: a */
    public void mo1249a(View view, AccessibilityEvent accessibilityEvent) {
        f299b.mo1412d(f300c, view, accessibilityEvent);
    }

    /* renamed from: a */
    public boolean mo1250a(View view, int i, Bundle bundle) {
        return f299b.mo1525a(f300c, view, i, bundle);
    }

    /* renamed from: a */
    public boolean mo1251a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return f299b.mo1409a(f300c, viewGroup, view, accessibilityEvent);
    }

    /* renamed from: b */
    public boolean mo1252b(View view, AccessibilityEvent accessibilityEvent) {
        return f299b.mo1408a(f300c, view, accessibilityEvent);
    }

    /* renamed from: c */
    public void mo1253c(View view, AccessibilityEvent accessibilityEvent) {
        f299b.mo1411c(f300c, view, accessibilityEvent);
    }

    /* renamed from: d */
    public void mo1254d(View view, AccessibilityEvent accessibilityEvent) {
        f299b.mo1410b(f300c, view, accessibilityEvent);
    }
}
