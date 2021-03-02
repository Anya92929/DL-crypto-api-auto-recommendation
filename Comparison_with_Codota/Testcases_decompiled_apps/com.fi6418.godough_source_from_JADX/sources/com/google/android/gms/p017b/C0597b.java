package com.google.android.gms.p017b;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.common.C0853e;
import com.google.android.gms.common.internal.C1034v;
import com.google.android.gms.p017b.C0596a;
import java.util.LinkedList;

/* renamed from: com.google.android.gms.b.b */
public abstract class C0597b<T extends C0596a> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public T f3952a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Bundle f3953b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public LinkedList<C0604i> f3954c;

    /* renamed from: d */
    private final C0609n<T> f3955d = new C0598c(this);

    /* renamed from: a */
    private void m3508a(int i) {
        while (!this.f3954c.isEmpty() && this.f3954c.getLast().mo6964a() >= i) {
            this.f3954c.removeLast();
        }
    }

    /* renamed from: a */
    private void m3509a(Bundle bundle, C0604i iVar) {
        if (this.f3952a != null) {
            iVar.mo6965a(this.f3952a);
            return;
        }
        if (this.f3954c == null) {
            this.f3954c = new LinkedList<>();
        }
        this.f3954c.add(iVar);
        if (bundle != null) {
            if (this.f3953b == null) {
                this.f3953b = (Bundle) bundle.clone();
            } else {
                this.f3953b.putAll(bundle);
            }
        }
        mo6956a(this.f3955d);
    }

    /* renamed from: b */
    public static void m3511b(FrameLayout frameLayout) {
        Context context = frameLayout.getContext();
        int a = C0853e.m4237a(context);
        String a2 = C1034v.m4641a(context, a, C0853e.m4256f(context));
        String b = C1034v.m4642b(context, a);
        LinearLayout linearLayout = new LinearLayout(frameLayout.getContext());
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        frameLayout.addView(linearLayout);
        TextView textView = new TextView(frameLayout.getContext());
        textView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        textView.setText(a2);
        linearLayout.addView(textView);
        if (b != null) {
            Button button = new Button(context);
            button.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            button.setText(b);
            linearLayout.addView(button);
            button.setOnClickListener(new C0602g(context, a));
        }
    }

    /* renamed from: a */
    public View mo6951a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FrameLayout frameLayout = new FrameLayout(layoutInflater.getContext());
        m3509a(bundle, (C0604i) new C0601f(this, frameLayout, layoutInflater, viewGroup, bundle));
        if (this.f3952a == null) {
            mo6955a(frameLayout);
        }
        return frameLayout;
    }

    /* renamed from: a */
    public T mo6952a() {
        return this.f3952a;
    }

    /* renamed from: a */
    public void mo6953a(Activity activity, Bundle bundle, Bundle bundle2) {
        m3509a(bundle2, (C0604i) new C0599d(this, activity, bundle, bundle2));
    }

    /* renamed from: a */
    public void mo6954a(Bundle bundle) {
        m3509a(bundle, (C0604i) new C0600e(this, bundle));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo6955a(FrameLayout frameLayout) {
        m3511b(frameLayout);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo6956a(C0609n<T> nVar);

    /* renamed from: b */
    public void mo6957b() {
        m3509a((Bundle) null, (C0604i) new C0603h(this));
    }

    /* renamed from: b */
    public void mo6958b(Bundle bundle) {
        if (this.f3952a != null) {
            this.f3952a.mo6947b(bundle);
        } else if (this.f3953b != null) {
            bundle.putAll(this.f3953b);
        }
    }

    /* renamed from: c */
    public void mo6959c() {
        if (this.f3952a != null) {
            this.f3952a.mo6946b();
        } else {
            m3508a(5);
        }
    }

    /* renamed from: d */
    public void mo6960d() {
        if (this.f3952a != null) {
            this.f3952a.mo6948c();
        } else {
            m3508a(2);
        }
    }

    /* renamed from: e */
    public void mo6961e() {
        if (this.f3952a != null) {
            this.f3952a.mo6949d();
        } else {
            m3508a(1);
        }
    }

    /* renamed from: f */
    public void mo6962f() {
        if (this.f3952a != null) {
            this.f3952a.mo6950e();
        }
    }
}
