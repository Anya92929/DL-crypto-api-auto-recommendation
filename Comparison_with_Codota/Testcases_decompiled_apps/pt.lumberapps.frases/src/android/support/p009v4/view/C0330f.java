package android.support.p009v4.view;

import android.os.Bundle;
import android.support.p009v4.view.p020a.C0175f;
import android.support.p009v4.view.p020a.C0192w;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

/* renamed from: android.support.v4.view.f */
class C0330f implements C0343m {

    /* renamed from: a */
    final /* synthetic */ C0152a f399a;

    /* renamed from: b */
    final /* synthetic */ C0303e f400b;

    C0330f(C0303e eVar, C0152a aVar) {
        this.f400b = eVar;
        this.f399a = aVar;
    }

    /* renamed from: a */
    public Object mo1581a(View view) {
        C0192w a = this.f399a.mo1245a(view);
        if (a != null) {
            return a.mo1385a();
        }
        return null;
    }

    /* renamed from: a */
    public void mo1582a(View view, int i) {
        this.f399a.mo1247a(view, i);
    }

    /* renamed from: a */
    public void mo1583a(View view, Object obj) {
        this.f399a.mo1248a(view, new C0175f(obj));
    }

    /* renamed from: a */
    public boolean mo1584a(View view, int i, Bundle bundle) {
        return this.f399a.mo1250a(view, i, bundle);
    }

    /* renamed from: a */
    public boolean mo1585a(View view, AccessibilityEvent accessibilityEvent) {
        return this.f399a.mo1252b(view, accessibilityEvent);
    }

    /* renamed from: a */
    public boolean mo1586a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.f399a.mo1251a(viewGroup, view, accessibilityEvent);
    }

    /* renamed from: b */
    public void mo1587b(View view, AccessibilityEvent accessibilityEvent) {
        this.f399a.mo1254d(view, accessibilityEvent);
    }

    /* renamed from: c */
    public void mo1588c(View view, AccessibilityEvent accessibilityEvent) {
        this.f399a.mo1253c(view, accessibilityEvent);
    }

    /* renamed from: d */
    public void mo1589d(View view, AccessibilityEvent accessibilityEvent) {
        this.f399a.mo1249a(view, accessibilityEvent);
    }
}
