package android.support.p021v7.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.p009v4.p014c.p015a.C0123a;
import android.support.p021v7.view.menu.C0542ai;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

@TargetApi(11)
/* renamed from: android.support.v7.view.g */
public class C0526g extends ActionMode {

    /* renamed from: a */
    final Context f906a;

    /* renamed from: b */
    final C0521b f907b;

    public C0526g(Context context, C0521b bVar) {
        this.f906a = context;
        this.f907b = bVar;
    }

    public void finish() {
        this.f907b.mo2096c();
    }

    public View getCustomView() {
        return this.f907b.mo2102i();
    }

    public Menu getMenu() {
        return C0542ai.m2331a(this.f906a, (C0123a) this.f907b.mo2093b());
    }

    public MenuInflater getMenuInflater() {
        return this.f907b.mo2089a();
    }

    public CharSequence getSubtitle() {
        return this.f907b.mo2100g();
    }

    public Object getTag() {
        return this.f907b.mo2195j();
    }

    public CharSequence getTitle() {
        return this.f907b.mo2099f();
    }

    public boolean getTitleOptionalHint() {
        return this.f907b.mo2196k();
    }

    public void invalidate() {
        this.f907b.mo2097d();
    }

    public boolean isTitleOptional() {
        return this.f907b.mo2101h();
    }

    public void setCustomView(View view) {
        this.f907b.setCustomView(view);
    }

    public void setSubtitle(int i) {
        this.f907b.mo2094b(i);
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f907b.mo2091a(charSequence);
    }

    public void setTag(Object obj) {
        this.f907b.mo2194a(obj);
    }

    public void setTitle(int i) {
        this.f907b.mo2090a(i);
    }

    public void setTitle(CharSequence charSequence) {
        this.f907b.mo2095b(charSequence);
    }

    public void setTitleOptionalHint(boolean z) {
        this.f907b.mo2092a(z);
    }
}
