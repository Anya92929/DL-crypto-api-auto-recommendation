package android.support.p021v7.p022a;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.p021v7.p023b.C0506b;
import android.support.p021v7.view.C0521b;
import android.support.p021v7.view.C0522c;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: android.support.v7.a.bi */
public class C0462bi extends Dialog implements C0434ah {

    /* renamed from: a */
    private C0435ai f671a;

    public C0462bi(Context context, int i) {
        super(context, m1958a(context, i));
        mo2054a().mo1977a((Bundle) null);
        mo2054a().mo1993i();
    }

    /* renamed from: a */
    private static int m1958a(Context context, int i) {
        if (i != 0) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(C0506b.dialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    /* renamed from: a */
    public C0435ai mo2054a() {
        if (this.f671a == null) {
            this.f671a = C0435ai.m1811a((Dialog) this, (C0434ah) this);
        }
        return this.f671a;
    }

    /* renamed from: a */
    public C0521b mo1949a(C0522c cVar) {
        return null;
    }

    /* renamed from: a */
    public void mo1951a(C0521b bVar) {
    }

    /* renamed from: a */
    public boolean mo2055a(int i) {
        return mo2054a().mo1987c(i);
    }

    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        mo2054a().mo1984b(view, layoutParams);
    }

    /* renamed from: b */
    public void mo1957b(C0521b bVar) {
    }

    public View findViewById(int i) {
        return mo2054a().mo1975a(i);
    }

    public void invalidateOptionsMenu() {
        mo2054a().mo1989e();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        mo2054a().mo1992h();
        super.onCreate(bundle);
        mo2054a().mo1977a(bundle);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        mo2054a().mo1985c();
    }

    public void setContentView(int i) {
        mo2054a().mo1982b(i);
    }

    public void setContentView(View view) {
        mo2054a().setContentView(view);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        mo2054a().mo1979a(view, layoutParams);
    }

    public void setTitle(int i) {
        super.setTitle(i);
        mo2054a().mo1980a((CharSequence) getContext().getString(i));
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        mo2054a().mo1980a(charSequence);
    }
}
