package android.support.p009v4.view;

import android.support.p009v4.view.p020a.C0175f;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

/* renamed from: android.support.v4.view.c */
class C0249c implements C0340j {

    /* renamed from: a */
    final /* synthetic */ C0152a f353a;

    /* renamed from: b */
    final /* synthetic */ C0222b f354b;

    C0249c(C0222b bVar, C0152a aVar) {
        this.f354b = bVar;
        this.f353a = aVar;
    }

    /* renamed from: a */
    public void mo1469a(View view, int i) {
        this.f353a.mo1247a(view, i);
    }

    /* renamed from: a */
    public void mo1470a(View view, Object obj) {
        this.f353a.mo1248a(view, new C0175f(obj));
    }

    /* renamed from: a */
    public boolean mo1471a(View view, AccessibilityEvent accessibilityEvent) {
        return this.f353a.mo1252b(view, accessibilityEvent);
    }

    /* renamed from: a */
    public boolean mo1472a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.f353a.mo1251a(viewGroup, view, accessibilityEvent);
    }

    /* renamed from: b */
    public void mo1473b(View view, AccessibilityEvent accessibilityEvent) {
        this.f353a.mo1254d(view, accessibilityEvent);
    }

    /* renamed from: c */
    public void mo1474c(View view, AccessibilityEvent accessibilityEvent) {
        this.f353a.mo1253c(view, accessibilityEvent);
    }

    /* renamed from: d */
    public void mo1475d(View view, AccessibilityEvent accessibilityEvent) {
        this.f353a.mo1249a(view, accessibilityEvent);
    }
}
