package com.p028a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import com.p028a.p029a.C0766a;
import com.p028a.p030b.C0768a;
import com.p028a.p030b.C0770c;
import com.p028a.p030b.C0772e;
import com.p028a.p030b.C0773f;
import com.p028a.p030b.C0775h;
import java.util.WeakHashMap;
import org.apache.http.HttpHost;

/* renamed from: com.a.b */
public abstract class C0767b {

    /* renamed from: j */
    private static final Class[] f1883j = {View.class};

    /* renamed from: k */
    private static Class[] f1884k = {AdapterView.class, View.class, Integer.TYPE, Long.TYPE};

    /* renamed from: l */
    private static Class[] f1885l = {AbsListView.class, Integer.TYPE};

    /* renamed from: m */
    private static final Class[] f1886m = {CharSequence.class, Integer.TYPE, Integer.TYPE, Integer.TYPE};

    /* renamed from: n */
    private static Class[] f1887n = {Integer.TYPE, Integer.TYPE};

    /* renamed from: o */
    private static final Class[] f1888o = {Integer.TYPE};

    /* renamed from: p */
    private static Class[] f1889p = {Integer.TYPE, Paint.class};

    /* renamed from: q */
    private static WeakHashMap f1890q = new WeakHashMap();

    /* renamed from: a */
    protected View f1891a;

    /* renamed from: b */
    protected Object f1892b;

    /* renamed from: c */
    protected C0766a f1893c;

    /* renamed from: d */
    private View f1894d;

    /* renamed from: e */
    private Activity f1895e;

    /* renamed from: f */
    private Context f1896f;

    /* renamed from: g */
    private C0775h f1897g;

    /* renamed from: h */
    private int f1898h = 0;

    /* renamed from: i */
    private HttpHost f1899i;

    public C0767b(Activity activity) {
        this.f1895e = activity;
    }

    public C0767b(Context context) {
        this.f1896f = context;
    }

    public C0767b(View view) {
        this.f1894d = view;
        this.f1891a = view;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C0767b mo3459a() {
        return this;
    }

    /* renamed from: a */
    public C0767b mo3460a(int i) {
        if (!(this.f1891a == null || this.f1891a.getVisibility() == i)) {
            this.f1891a.setVisibility(i);
        }
        return mo3459a();
    }

    /* renamed from: a */
    public C0767b mo3461a(Dialog dialog) {
        if (dialog != null) {
            try {
                dialog.show();
                f1890q.put(dialog, (Object) null);
            } catch (Exception e) {
            }
        }
        return mo3459a();
    }

    /* renamed from: a */
    public C0767b mo3462a(View view) {
        this.f1891a = view;
        mo3478d();
        return mo3459a();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C0767b mo3463a(C0768a aVar) {
        if (this.f1893c != null) {
            aVar.mo3482a(this.f1893c);
        }
        if (this.f1892b != null) {
            aVar.mo3485a(this.f1892b);
        }
        if (this.f1897g != null) {
            aVar.mo3483a(this.f1897g);
        }
        aVar.mo3480a(this.f1898h);
        if (this.f1899i != null) {
            aVar.mo3487a(this.f1899i.getHostName(), this.f1899i.getPort());
        }
        if (this.f1895e != null) {
            aVar.mo3492a(this.f1895e);
        } else {
            aVar.mo3493a(mo3477c());
        }
        mo3478d();
        return mo3459a();
    }

    /* renamed from: a */
    public C0767b mo3464a(C0770c cVar) {
        return mo3463a((C0768a) cVar);
    }

    /* renamed from: a */
    public C0767b mo3465a(CharSequence charSequence) {
        if (this.f1891a instanceof TextView) {
            ((TextView) this.f1891a).setText(charSequence);
        }
        return mo3459a();
    }

    /* renamed from: a */
    public C0767b mo3466a(CharSequence charSequence, boolean z) {
        return (!z || !(charSequence == null || charSequence.length() == 0)) ? mo3465a(charSequence) : mo3475b();
    }

    /* renamed from: a */
    public C0767b mo3467a(String str, C0773f fVar) {
        return mo3468a(str, fVar, (String) null);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C0767b mo3468a(String str, C0773f fVar, String str2) {
        if (this.f1891a instanceof ImageView) {
            C0772e.m3466a(this.f1895e, mo3477c(), (ImageView) this.f1891a, str, this.f1892b, this.f1893c, fVar, this.f1899i, str2);
            mo3478d();
        }
        return mo3459a();
    }

    /* renamed from: a */
    public C0767b mo3469a(String str, Class cls, long j, C0770c cVar) {
        ((C0770c) ((C0770c) ((C0770c) cVar.mo3484a(cls)).mo3486a(str)).mo3490a(true)).mo3481a(j);
        return mo3464a(cVar);
    }

    /* renamed from: a */
    public C0767b mo3470a(String str, boolean z, boolean z2) {
        return mo3471a(str, z, z2, 0, 0);
    }

    /* renamed from: a */
    public C0767b mo3471a(String str, boolean z, boolean z2, int i, int i2) {
        return mo3472a(str, z, z2, i, i2, (Bitmap) null, 0);
    }

    /* renamed from: a */
    public C0767b mo3472a(String str, boolean z, boolean z2, int i, int i2, Bitmap bitmap, int i3) {
        return mo3473a(str, z, z2, i, i2, bitmap, i3, 0.0f);
    }

    /* renamed from: a */
    public C0767b mo3473a(String str, boolean z, boolean z2, int i, int i2, Bitmap bitmap, int i3, float f) {
        return mo3474a(str, z, z2, i, i2, bitmap, i3, f, 0, (String) null);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C0767b mo3474a(String str, boolean z, boolean z2, int i, int i2, Bitmap bitmap, int i3, float f, int i4, String str2) {
        if (this.f1891a instanceof ImageView) {
            C0772e.m3467a(this.f1895e, mo3477c(), (ImageView) this.f1891a, str, z, z2, i, i2, bitmap, i3, f, Float.MAX_VALUE, this.f1892b, this.f1893c, this.f1898h, i4, this.f1899i, str2);
            mo3478d();
        }
        return mo3459a();
    }

    /* renamed from: b */
    public C0767b mo3475b() {
        return mo3460a(8);
    }

    /* renamed from: b */
    public C0767b mo3476b(Dialog dialog) {
        if (dialog != null) {
            try {
                f1890q.remove(dialog);
                dialog.dismiss();
            } catch (Exception e) {
            }
        }
        return mo3459a();
    }

    /* renamed from: c */
    public Context mo3477c() {
        return this.f1895e != null ? this.f1895e : this.f1894d != null ? this.f1894d.getContext() : this.f1896f;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void mo3478d() {
        this.f1893c = null;
        this.f1892b = null;
        this.f1897g = null;
        this.f1898h = 0;
        this.f1899i = null;
    }
}
