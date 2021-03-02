package android.support.p009v4.p010a;

import android.support.p009v4.p019f.C0139d;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* renamed from: android.support.v4.a.p */
public class C0050p {

    /* renamed from: a */
    int f147a;

    /* renamed from: b */
    C0052r f148b;

    /* renamed from: c */
    C0051q f149c;

    /* renamed from: d */
    boolean f150d;

    /* renamed from: e */
    boolean f151e;

    /* renamed from: f */
    boolean f152f;

    /* renamed from: g */
    boolean f153g;

    /* renamed from: h */
    boolean f154h;

    /* renamed from: a */
    public String mo132a(Object obj) {
        StringBuilder sb = new StringBuilder(64);
        C0139d.m341a(obj, sb);
        sb.append("}");
        return sb.toString();
    }

    /* renamed from: a */
    public final void mo133a() {
        this.f150d = true;
        this.f152f = false;
        this.f151e = false;
        mo138b();
    }

    /* renamed from: a */
    public void mo134a(int i, C0052r rVar) {
        if (this.f148b != null) {
            throw new IllegalStateException("There is already a listener registered");
        }
        this.f148b = rVar;
        this.f147a = i;
    }

    /* renamed from: a */
    public void mo135a(C0051q qVar) {
        if (this.f149c != null) {
            throw new IllegalStateException("There is already a listener registered");
        }
        this.f149c = qVar;
    }

    /* renamed from: a */
    public void mo136a(C0052r rVar) {
        if (this.f148b == null) {
            throw new IllegalStateException("No listener register");
        } else if (this.f148b != rVar) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        } else {
            this.f148b = null;
        }
    }

    /* renamed from: a */
    public void mo137a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.f147a);
        printWriter.print(" mListener=");
        printWriter.println(this.f148b);
        if (this.f150d || this.f153g || this.f154h) {
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.f150d);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.f153g);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.f154h);
        }
        if (this.f151e || this.f152f) {
            printWriter.print(str);
            printWriter.print("mAbandoned=");
            printWriter.print(this.f151e);
            printWriter.print(" mReset=");
            printWriter.println(this.f152f);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo138b() {
    }

    /* renamed from: b */
    public void mo139b(C0051q qVar) {
        if (this.f149c == null) {
            throw new IllegalStateException("No listener register");
        } else if (this.f149c != qVar) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        } else {
            this.f149c = null;
        }
    }

    /* renamed from: c */
    public boolean mo140c() {
        return mo141d();
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public boolean mo141d() {
        return false;
    }

    /* renamed from: e */
    public void mo142e() {
        this.f150d = false;
        mo143f();
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public void mo143f() {
    }

    /* renamed from: g */
    public void mo144g() {
        this.f151e = true;
        mo145h();
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public void mo145h() {
    }

    /* renamed from: i */
    public void mo146i() {
        mo147j();
        this.f152f = true;
        this.f150d = false;
        this.f151e = false;
        this.f153g = false;
        this.f154h = false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public void mo147j() {
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        C0139d.m341a(this, sb);
        sb.append(" id=");
        sb.append(this.f147a);
        sb.append("}");
        return sb.toString();
    }
}
