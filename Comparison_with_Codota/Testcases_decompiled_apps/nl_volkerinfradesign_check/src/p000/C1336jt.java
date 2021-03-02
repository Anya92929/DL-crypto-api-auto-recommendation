package p000;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
import org.apmem.tools.layouts.FlowLayout;

/* renamed from: jt */
public class C1336jt {

    /* renamed from: a */
    private final List<View> f4605a = new ArrayList();

    /* renamed from: b */
    private final int f4606b;

    /* renamed from: c */
    private int f4607c;

    /* renamed from: d */
    private int f4608d;

    /* renamed from: e */
    private int f4609e = 0;

    /* renamed from: f */
    private int f4610f = 0;

    public C1336jt(int i) {
        this.f4606b = i;
    }

    /* renamed from: a */
    public void mo8870a(View view) {
        mo8869a(this.f4605a.size(), view);
    }

    /* renamed from: a */
    public void mo8869a(int i, View view) {
        FlowLayout.LayoutParams layoutParams = (FlowLayout.LayoutParams) view.getLayoutParams();
        this.f4605a.add(i, view);
        this.f4607c = this.f4607c + layoutParams.mo13668b() + layoutParams.mo13674e();
        this.f4608d = Math.max(this.f4608d, layoutParams.mo13675f() + layoutParams.mo13670c());
    }

    /* renamed from: b */
    public boolean mo8873b(View view) {
        FlowLayout.LayoutParams layoutParams = (FlowLayout.LayoutParams) view.getLayoutParams();
        return layoutParams.mo13674e() + (this.f4607c + layoutParams.mo13668b()) <= this.f4606b;
    }

    /* renamed from: a */
    public int mo8867a() {
        return this.f4609e;
    }

    /* renamed from: a */
    public void mo8868a(int i) {
        this.f4609e = i;
    }

    /* renamed from: b */
    public int mo8871b() {
        return this.f4608d;
    }

    /* renamed from: c */
    public int mo8874c() {
        return this.f4607c;
    }

    /* renamed from: d */
    public int mo8876d() {
        return this.f4610f;
    }

    /* renamed from: b */
    public void mo8872b(int i) {
        this.f4610f = i;
    }

    /* renamed from: e */
    public List<View> mo8878e() {
        return this.f4605a;
    }

    /* renamed from: c */
    public void mo8875c(int i) {
        this.f4608d = i;
    }

    /* renamed from: d */
    public void mo8877d(int i) {
        this.f4607c = i;
    }
}
