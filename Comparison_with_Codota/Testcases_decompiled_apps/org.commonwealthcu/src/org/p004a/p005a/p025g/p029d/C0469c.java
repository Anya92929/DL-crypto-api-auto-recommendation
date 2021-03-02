package org.p004a.p005a.p025g.p029d;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p021e.C0345a;
import org.p004a.p005a.p021e.C0358n;

/* renamed from: org.a.a.g.d.c */
public class C0469c implements Serializable, Cloneable, C0345a, C0358n {

    /* renamed from: a */
    private final String f463a;

    /* renamed from: b */
    private Map f464b = new HashMap();

    /* renamed from: c */
    private String f465c;

    /* renamed from: d */
    private String f466d;

    /* renamed from: e */
    private Date f467e;

    /* renamed from: f */
    private String f468f;

    /* renamed from: g */
    private boolean f469g;

    /* renamed from: h */
    private int f470h;

    public C0469c(String str, String str2) {
        C0250b.m84a((Object) str, "Name");
        this.f463a = str;
        this.f465c = str2;
    }

    /* renamed from: a */
    public final String mo5045a() {
        return this.f463a;
    }

    /* renamed from: a */
    public final String mo5043a(String str) {
        return (String) this.f464b.get(str);
    }

    /* renamed from: a */
    public final void mo5073a(int i) {
        this.f470h = i;
    }

    /* renamed from: a */
    public final void mo5264a(String str, String str2) {
        this.f464b.put(str, str2);
    }

    /* renamed from: a */
    public final void mo5074a(boolean z) {
        this.f469g = true;
    }

    /* renamed from: a */
    public boolean mo5046a(Date date) {
        C0250b.m84a((Object) date, "Date");
        return this.f467e != null && this.f467e.getTime() <= date.getTime();
    }

    /* renamed from: b */
    public final String mo5047b() {
        return this.f465c;
    }

    /* renamed from: b */
    public final void mo5075b(Date date) {
        this.f467e = date;
    }

    /* renamed from: b */
    public final boolean mo5044b(String str) {
        return this.f464b.get(str) != null;
    }

    /* renamed from: c */
    public final String mo5048c() {
        return this.f466d;
    }

    /* renamed from: c */
    public final void mo5076c(String str) {
        if (str != null) {
            this.f466d = str.toLowerCase(Locale.ENGLISH);
        } else {
            this.f466d = null;
        }
    }

    public Object clone() {
        C0469c cVar = (C0469c) super.clone();
        cVar.f464b = new HashMap(this.f464b);
        return cVar;
    }

    /* renamed from: d */
    public final String mo5049d() {
        return this.f468f;
    }

    /* renamed from: d */
    public final void mo5077d(String str) {
        this.f468f = str;
    }

    /* renamed from: e */
    public int[] mo5050e() {
        return null;
    }

    /* renamed from: f */
    public final boolean mo5051f() {
        return this.f469g;
    }

    /* renamed from: g */
    public final int mo5052g() {
        return this.f470h;
    }

    public String toString() {
        return "[version: " + Integer.toString(this.f470h) + "]" + "[name: " + this.f463a + "]" + "[value: " + this.f465c + "]" + "[domain: " + this.f466d + "]" + "[path: " + this.f468f + "]" + "[expiry: " + this.f467e + "]";
    }
}
