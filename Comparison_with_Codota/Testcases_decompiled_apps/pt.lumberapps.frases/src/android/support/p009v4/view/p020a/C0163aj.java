package android.support.p009v4.view.p020a;

import android.os.Build;
import android.view.View;

/* renamed from: android.support.v4.view.a.aj */
public class C0163aj {

    /* renamed from: a */
    private static final C0166am f307a;

    /* renamed from: b */
    private final Object f308b;

    static {
        if (Build.VERSION.SDK_INT >= 16) {
            f307a = new C0167an();
        } else if (Build.VERSION.SDK_INT >= 15) {
            f307a = new C0165al();
        } else if (Build.VERSION.SDK_INT >= 14) {
            f307a = new C0164ak();
        } else {
            f307a = new C0168ao();
        }
    }

    public C0163aj(Object obj) {
        this.f308b = obj;
    }

    /* renamed from: a */
    public void mo1270a(int i) {
        f307a.mo1284b(this.f308b, i);
    }

    /* renamed from: a */
    public void mo1271a(boolean z) {
        f307a.mo1283a(this.f308b, z);
    }

    /* renamed from: b */
    public void mo1272b(int i) {
        f307a.mo1281a(this.f308b, i);
    }

    /* renamed from: c */
    public void mo1273c(int i) {
        f307a.mo1287e(this.f308b, i);
    }

    /* renamed from: d */
    public void mo1274d(int i) {
        f307a.mo1285c(this.f308b, i);
    }

    /* renamed from: e */
    public void mo1275e(int i) {
        f307a.mo1286d(this.f308b, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        C0163aj ajVar = (C0163aj) obj;
        return this.f308b == null ? ajVar.f308b == null : this.f308b.equals(ajVar.f308b);
    }

    /* renamed from: f */
    public void mo1277f(int i) {
        f307a.mo1288f(this.f308b, i);
    }

    /* renamed from: g */
    public void mo1278g(int i) {
        f307a.mo1289g(this.f308b, i);
    }

    public int hashCode() {
        if (this.f308b == null) {
            return 0;
        }
        return this.f308b.hashCode();
    }

    public void setSource(View view) {
        f307a.mo1282a(this.f308b, view);
    }
}
