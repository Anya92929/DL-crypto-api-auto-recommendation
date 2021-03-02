package android.support.p021v7.p022a;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.support.p021v7.view.C0521b;
import android.support.p021v7.view.C0522c;
import android.view.KeyEvent;
import android.view.View;

/* renamed from: android.support.v7.a.a */
public abstract class C0426a {
    /* renamed from: a */
    public abstract int mo1907a();

    /* renamed from: a */
    public C0521b mo1908a(C0522c cVar) {
        return null;
    }

    /* renamed from: a */
    public void mo1909a(float f) {
        if (f != 0.0f) {
            throw new UnsupportedOperationException("Setting a non-zero elevation is not supported in this action bar configuration.");
        }
    }

    /* renamed from: a */
    public void mo1910a(int i) {
    }

    /* renamed from: a */
    public void mo1911a(Configuration configuration) {
    }

    /* renamed from: a */
    public void mo1912a(Drawable drawable) {
    }

    /* renamed from: a */
    public void mo1913a(CharSequence charSequence) {
    }

    /* renamed from: a */
    public abstract void mo1914a(boolean z);

    /* renamed from: a */
    public boolean mo1915a(int i, KeyEvent keyEvent) {
        return false;
    }

    /* renamed from: b */
    public abstract void mo1916b(boolean z);

    /* renamed from: b */
    public abstract boolean mo1917b();

    /* renamed from: c */
    public Context mo1918c() {
        return null;
    }

    /* renamed from: c */
    public void mo1919c(boolean z) {
    }

    /* renamed from: d */
    public int mo1920d() {
        return 0;
    }

    /* renamed from: d */
    public void mo1921d(boolean z) {
        if (z) {
            throw new UnsupportedOperationException("Hide on content scroll is not supported in this action bar configuration.");
        }
    }

    /* renamed from: e */
    public void mo1922e(boolean z) {
    }

    /* renamed from: e */
    public boolean mo1923e() {
        return false;
    }

    /* renamed from: f */
    public void mo1924f(boolean z) {
    }

    /* renamed from: f */
    public boolean mo1925f() {
        return false;
    }

    /* renamed from: g */
    public void mo1926g(boolean z) {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public boolean mo1927g() {
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public void mo1928h() {
    }

    public abstract void setCustomView(View view);
}
