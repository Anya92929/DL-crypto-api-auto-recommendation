package com.p028a.p030b;

import com.p028a.p031c.C0776a;
import java.io.Closeable;
import java.io.File;
import java.util.Date;
import org.apache.http.Header;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HttpContext;

/* renamed from: com.a.b.d */
public class C0771d {

    /* renamed from: a */
    private int f1950a = 200;

    /* renamed from: b */
    private String f1951b = "OK";

    /* renamed from: c */
    private String f1952c;

    /* renamed from: d */
    private byte[] f1953d;

    /* renamed from: e */
    private File f1954e;

    /* renamed from: f */
    private Date f1955f = new Date();

    /* renamed from: g */
    private boolean f1956g;

    /* renamed from: h */
    private DefaultHttpClient f1957h;

    /* renamed from: i */
    private long f1958i;

    /* renamed from: j */
    private int f1959j = 1;

    /* renamed from: k */
    private long f1960k = System.currentTimeMillis();

    /* renamed from: l */
    private boolean f1961l;

    /* renamed from: m */
    private boolean f1962m;

    /* renamed from: n */
    private boolean f1963n;

    /* renamed from: o */
    private String f1964o;

    /* renamed from: p */
    private HttpContext f1965p;

    /* renamed from: q */
    private Header[] f1966q;

    /* renamed from: r */
    private Closeable f1967r;

    /* renamed from: a */
    public C0771d mo3510a() {
        this.f1958i = System.currentTimeMillis() - this.f1960k;
        this.f1961l = true;
        this.f1963n = false;
        return this;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C0771d mo3511a(int i) {
        this.f1959j = i;
        return this;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C0771d mo3512a(File file) {
        this.f1954e = file;
        return this;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C0771d mo3513a(String str) {
        this.f1964o = str;
        return this;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C0771d mo3514a(Date date) {
        this.f1955f = date;
        return this;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C0771d mo3515a(DefaultHttpClient defaultHttpClient) {
        this.f1957h = defaultHttpClient;
        return this;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C0771d mo3516a(HttpContext httpContext) {
        this.f1965p = httpContext;
        return this;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C0771d mo3517a(boolean z) {
        this.f1956g = z;
        return this;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C0771d mo3518a(byte[] bArr) {
        this.f1953d = bArr;
        return this;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C0771d mo3519a(Header[] headerArr) {
        this.f1966q = headerArr;
        return this;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3520a(Closeable closeable) {
        this.f1967r = closeable;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public C0771d mo3521b() {
        this.f1958i = System.currentTimeMillis() - this.f1960k;
        this.f1961l = false;
        mo3526c();
        return this;
    }

    /* renamed from: b */
    public C0771d mo3522b(int i) {
        this.f1950a = i;
        return this;
    }

    /* renamed from: b */
    public C0771d mo3523b(String str) {
        this.f1951b = str;
        return this;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public C0771d mo3524b(boolean z) {
        this.f1963n = z;
        return this;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public C0771d mo3525c(String str) {
        this.f1952c = str;
        return this;
    }

    /* renamed from: c */
    public void mo3526c() {
        C0776a.m3518a(this.f1967r);
        this.f1967r = null;
    }

    /* renamed from: d */
    public String mo3527d(String str) {
        if (this.f1966q == null) {
            return null;
        }
        for (int i = 0; i < this.f1966q.length; i++) {
            if (str.equalsIgnoreCase(this.f1966q[i].getName())) {
                return this.f1966q[i].getValue();
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public boolean mo3528d() {
        return this.f1961l;
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public boolean mo3529e() {
        return this.f1963n;
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public boolean mo3530f() {
        return this.f1962m;
    }

    /* renamed from: g */
    public int mo3531g() {
        return this.f1950a;
    }

    /* renamed from: h */
    public String mo3532h() {
        return this.f1951b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: i */
    public byte[] mo3533i() {
        return this.f1953d;
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public File mo3534j() {
        return this.f1954e;
    }

    /* renamed from: k */
    public int mo3535k() {
        return this.f1959j;
    }
}
