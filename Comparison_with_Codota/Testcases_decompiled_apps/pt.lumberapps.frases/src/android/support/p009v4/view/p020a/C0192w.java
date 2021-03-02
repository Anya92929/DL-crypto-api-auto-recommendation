package android.support.p009v4.view.p020a;

import android.os.Build;
import android.os.Bundle;
import java.util.List;

/* renamed from: android.support.v4.view.a.w */
public class C0192w {

    /* renamed from: a */
    private static final C0193x f334a;

    /* renamed from: b */
    private final Object f335b;

    static {
        if (Build.VERSION.SDK_INT >= 19) {
            f334a = new C0154aa();
        } else if (Build.VERSION.SDK_INT >= 16) {
            f334a = new C0194y();
        } else {
            f334a = new C0156ac();
        }
    }

    public C0192w() {
        this.f335b = f334a.mo1255a(this);
    }

    public C0192w(Object obj) {
        this.f335b = obj;
    }

    /* renamed from: a */
    public C0175f mo1384a(int i) {
        return null;
    }

    /* renamed from: a */
    public Object mo1385a() {
        return this.f335b;
    }

    /* renamed from: a */
    public List mo1386a(String str, int i) {
        return null;
    }

    /* renamed from: a */
    public boolean mo1387a(int i, int i2, Bundle bundle) {
        return false;
    }

    /* renamed from: b */
    public C0175f mo1388b(int i) {
        return null;
    }
}
