package android.support.p021v7.p022a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.support.p009v4.p018e.C0130c;
import android.support.p021v7.widget.Toolbar;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

/* renamed from: android.support.v7.a.ai */
public abstract class C0435ai {

    /* renamed from: a */
    private static int f587a = -1;

    C0435ai() {
    }

    /* renamed from: a */
    public static C0435ai m1810a(Activity activity, C0434ah ahVar) {
        return m1812a(activity, activity.getWindow(), ahVar);
    }

    /* renamed from: a */
    public static C0435ai m1811a(Dialog dialog, C0434ah ahVar) {
        return m1812a(dialog.getContext(), dialog.getWindow(), ahVar);
    }

    /* renamed from: a */
    private static C0435ai m1812a(Context context, Window window, C0434ah ahVar) {
        int i = Build.VERSION.SDK_INT;
        return C0130c.m319a() ? new C0440an(context, window, ahVar) : i >= 23 ? new C0445as(context, window, ahVar) : i >= 14 ? new C0443aq(context, window, ahVar) : i >= 11 ? new C0442ap(context, window, ahVar) : new C0447au(context, window, ahVar);
    }

    /* renamed from: j */
    public static int m1813j() {
        return f587a;
    }

    /* renamed from: a */
    public abstract C0426a mo1974a();

    /* renamed from: a */
    public abstract View mo1975a(int i);

    /* renamed from: a */
    public abstract void mo1976a(Configuration configuration);

    /* renamed from: a */
    public abstract void mo1977a(Bundle bundle);

    /* renamed from: a */
    public abstract void mo1978a(Toolbar toolbar);

    /* renamed from: a */
    public abstract void mo1979a(View view, ViewGroup.LayoutParams layoutParams);

    /* renamed from: a */
    public abstract void mo1980a(CharSequence charSequence);

    /* renamed from: b */
    public abstract MenuInflater mo1981b();

    /* renamed from: b */
    public abstract void mo1982b(int i);

    /* renamed from: b */
    public abstract void mo1983b(Bundle bundle);

    /* renamed from: b */
    public abstract void mo1984b(View view, ViewGroup.LayoutParams layoutParams);

    /* renamed from: c */
    public abstract void mo1985c();

    /* renamed from: c */
    public abstract void mo1986c(Bundle bundle);

    /* renamed from: c */
    public abstract boolean mo1987c(int i);

    /* renamed from: d */
    public abstract void mo1988d();

    /* renamed from: e */
    public abstract void mo1989e();

    /* renamed from: f */
    public abstract void mo1990f();

    /* renamed from: g */
    public abstract C0485g mo1991g();

    /* renamed from: h */
    public abstract void mo1992h();

    /* renamed from: i */
    public abstract boolean mo1993i();

    public abstract void setContentView(View view);
}
