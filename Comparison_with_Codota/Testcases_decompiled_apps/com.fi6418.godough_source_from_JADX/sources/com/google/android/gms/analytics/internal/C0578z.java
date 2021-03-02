package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.analytics.C0581l;
import com.google.android.gms.common.internal.C1009bf;
import com.google.android.gms.p018c.C0615ad;
import com.google.android.gms.p018c.C0628aq;

/* renamed from: com.google.android.gms.analytics.internal.z */
public class C0578z {

    /* renamed from: a */
    private final C0516ac f3910a;

    protected C0578z(C0516ac acVar) {
        C1009bf.m4528a(acVar);
        this.f3910a = acVar;
    }

    /* renamed from: a */
    private static String mo6802a(Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        if (!(obj instanceof Boolean)) {
            return obj instanceof Throwable ? ((Throwable) obj).toString() : obj.toString();
        }
        return obj == Boolean.TRUE ? "true" : "false";
    }

    /* renamed from: a */
    private void mo6803a(int i, String str, Object obj, Object obj2, Object obj3) {
        C0562j jVar = null;
        if (this.f3910a != null) {
            jVar = this.f3910a.mo6605g();
        }
        if (jVar != null) {
            jVar.mo6803a(i, str, obj, obj2, obj3);
            return;
        }
        String a = C0551bk.f3819c.mo6775a();
        if (Log.isLoggable(a, i)) {
            Log.println(i, a, m3369c(str, obj, obj2, obj3));
        }
    }

    /* renamed from: c */
    protected static String m3369c(String str, Object obj, Object obj2, Object obj3) {
        if (str == null) {
            str = "";
        }
        String a = mo6802a(obj);
        String a2 = mo6802a(obj2);
        String a3 = mo6802a(obj3);
        StringBuilder sb = new StringBuilder();
        String str2 = "";
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            str2 = ": ";
        }
        if (!TextUtils.isEmpty(a)) {
            sb.append(str2);
            sb.append(a);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(a2)) {
            sb.append(str2);
            sb.append(a2);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(a3)) {
            sb.append(str2);
            sb.append(a3);
        }
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    /* renamed from: A */
    public C0547bg mo6864A() {
        return this.f3910a.mo6616r();
    }

    /* renamed from: B */
    public boolean mo6865B() {
        return Log.isLoggable(C0551bk.f3819c.mo6775a(), 2);
    }

    /* renamed from: a */
    public void mo6866a(String str, Object obj) {
        mo6803a(2, str, obj, (Object) null, (Object) null);
    }

    /* renamed from: a */
    public void mo6867a(String str, Object obj, Object obj2) {
        mo6803a(2, str, obj, obj2, (Object) null);
    }

    /* renamed from: a */
    public void mo6868a(String str, Object obj, Object obj2, Object obj3) {
        mo6803a(3, str, obj, obj2, obj3);
    }

    /* renamed from: b */
    public void mo6869b(String str) {
        mo6803a(2, str, (Object) null, (Object) null, (Object) null);
    }

    /* renamed from: b */
    public void mo6870b(String str, Object obj) {
        mo6803a(3, str, obj, (Object) null, (Object) null);
    }

    /* renamed from: b */
    public void mo6871b(String str, Object obj, Object obj2) {
        mo6803a(3, str, obj, obj2, (Object) null);
    }

    /* renamed from: b */
    public void mo6872b(String str, Object obj, Object obj2, Object obj3) {
        mo6803a(5, str, obj, obj2, obj3);
    }

    /* renamed from: c */
    public void mo6873c(String str) {
        mo6803a(3, str, (Object) null, (Object) null, (Object) null);
    }

    /* renamed from: c */
    public void mo6874c(String str, Object obj) {
        mo6803a(4, str, obj, (Object) null, (Object) null);
    }

    /* renamed from: c */
    public void mo6875c(String str, Object obj, Object obj2) {
        mo6803a(5, str, obj, obj2, (Object) null);
    }

    /* renamed from: d */
    public void mo6876d(String str) {
        mo6803a(4, str, (Object) null, (Object) null, (Object) null);
    }

    /* renamed from: d */
    public void mo6877d(String str, Object obj) {
        mo6803a(5, str, obj, (Object) null, (Object) null);
    }

    /* renamed from: d */
    public void mo6878d(String str, Object obj, Object obj2) {
        mo6803a(6, str, obj, obj2, (Object) null);
    }

    /* renamed from: e */
    public void mo6879e(String str) {
        mo6803a(5, str, (Object) null, (Object) null, (Object) null);
    }

    /* renamed from: e */
    public void mo6880e(String str, Object obj) {
        mo6803a(6, str, obj, (Object) null, (Object) null);
    }

    /* renamed from: f */
    public void mo6881f(String str) {
        mo6803a(6, str, (Object) null, (Object) null, (Object) null);
    }

    /* renamed from: k */
    public C0516ac mo6882k() {
        return this.f3910a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public void mo6883l() {
        if (mo6888q().mo6731a()) {
            throw new IllegalStateException("Call only supported on the client side");
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: m */
    public void mo6884m() {
        this.f3910a.mo6617s();
    }

    /* access modifiers changed from: protected */
    /* renamed from: n */
    public C0615ad mo6885n() {
        return this.f3910a.mo6602d();
    }

    /* access modifiers changed from: protected */
    /* renamed from: o */
    public Context mo6886o() {
        return this.f3910a.mo6600b();
    }

    /* access modifiers changed from: protected */
    /* renamed from: p */
    public C0562j mo6887p() {
        return this.f3910a.mo6604f();
    }

    /* access modifiers changed from: protected */
    /* renamed from: q */
    public C0543bc mo6888q() {
        return this.f3910a.mo6603e();
    }

    /* access modifiers changed from: protected */
    /* renamed from: r */
    public C0628aq mo6889r() {
        return this.f3910a.mo6606h();
    }

    /* renamed from: s */
    public C0581l mo6890s() {
        return this.f3910a.mo6609k();
    }

    /* access modifiers changed from: protected */
    /* renamed from: t */
    public C0572t mo6891t() {
        return this.f3910a.mo6607i();
    }

    /* access modifiers changed from: protected */
    /* renamed from: u */
    public C0548bh mo6892u() {
        return this.f3910a.mo6608j();
    }

    /* access modifiers changed from: protected */
    /* renamed from: v */
    public C0571s mo6893v() {
        return this.f3910a.mo6610l();
    }

    /* access modifiers changed from: protected */
    /* renamed from: w */
    public C0566n mo6894w() {
        return this.f3910a.mo6611m();
    }

    /* access modifiers changed from: protected */
    /* renamed from: x */
    public C0535av mo6895x() {
        return this.f3910a.mo6614p();
    }

    /* access modifiers changed from: protected */
    /* renamed from: y */
    public C0540b mo6896y() {
        return this.f3910a.mo6613o();
    }

    /* access modifiers changed from: protected */
    /* renamed from: z */
    public C0527an mo6897z() {
        return this.f3910a.mo6615q();
    }
}
