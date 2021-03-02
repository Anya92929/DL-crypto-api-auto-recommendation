package com.jackhenry.godough.core.p038e;

import android.view.View;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.GoDoughApp;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.jackhenry.godough.core.e.e */
public class C1576e implements Serializable {

    /* renamed from: a */
    private C1577f f6141a;

    /* renamed from: b */
    private String f6142b;

    /* renamed from: c */
    private String f6143c;

    /* renamed from: d */
    private int f6144d;

    /* renamed from: e */
    private List<C1574c> f6145e;

    /* renamed from: f */
    private C1579h f6146f;

    /* renamed from: g */
    private C1578g f6147g;

    /* renamed from: h */
    private C1575d f6148h;

    public C1576e(C1577f fVar, int i, String str, C1579h hVar, List<C1574c> list) {
        this(fVar, i, str, hVar, list, C1575d.HORIZONTAL);
    }

    public C1576e(C1577f fVar, int i, String str, C1579h hVar, List<C1574c> list, C1575d dVar) {
        this.f6145e = new ArrayList();
        this.f6141a = fVar;
        this.f6144d = i;
        this.f6142b = str;
        this.f6146f = hVar;
        this.f6148h = dVar;
        this.f6145e = list;
    }

    public C1576e(C1577f fVar, int i, String str, String str2) {
        this(fVar, i, str, str2, GoDoughApp.getApp().getString(C1506am.btn_ok));
    }

    public C1576e(C1577f fVar, int i, String str, String str2, String str3) {
        this.f6145e = new ArrayList();
        this.f6141a = fVar;
        this.f6144d = i;
        this.f6142b = str;
        this.f6143c = str2;
        this.f6148h = C1575d.VERTICAL;
        this.f6145e.add(new C1574c(-1, str3));
    }

    public C1576e(C1577f fVar, int i, String str, String str2, List<C1574c> list) {
        this(fVar, i, str, str2, list, C1575d.HORIZONTAL);
    }

    public C1576e(C1577f fVar, int i, String str, String str2, List<C1574c> list, C1575d dVar) {
        this.f6145e = new ArrayList();
        this.f6141a = fVar;
        this.f6144d = i;
        this.f6142b = str;
        this.f6143c = str2;
        this.f6148h = dVar;
        this.f6145e = list;
    }

    public C1576e(C1577f fVar, String str, String str2) {
        this(fVar, 0, str, str2, GoDoughApp.getApp().getString(C1506am.btn_ok));
    }

    public C1576e(String str, String str2) {
        this(C1577f.ERROR, 0, str, str2, GoDoughApp.getApp().getString(C1506am.btn_ok));
    }

    /* renamed from: a */
    public C1578g mo9790a() {
        return this.f6147g;
    }

    /* renamed from: a */
    public void mo9791a(C1578g gVar) {
        this.f6147g = gVar;
    }

    /* renamed from: a */
    public void mo9792a(String str) {
        this.f6143c = str;
    }

    /* renamed from: b */
    public String mo9793b() {
        return this.f6142b;
    }

    /* renamed from: c */
    public String mo9794c() {
        return this.f6143c;
    }

    /* renamed from: d */
    public int mo9795d() {
        return this.f6144d;
    }

    /* renamed from: e */
    public List<C1574c> mo9796e() {
        return this.f6145e;
    }

    /* renamed from: f */
    public View mo9797f() {
        if (this.f6146f == null) {
            return null;
        }
        return this.f6146f.mo9688a();
    }
}
