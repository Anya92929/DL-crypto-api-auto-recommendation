package com.jackhenry.android.widget.quickactionmenu;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.PopupWindow;

public class PopupWindows {

    /* renamed from: a */
    protected Context f5686a;

    /* renamed from: b */
    protected PopupWindow f5687b;

    /* renamed from: c */
    protected View f5688c;

    /* renamed from: d */
    protected Drawable f5689d = null;

    /* renamed from: e */
    protected WindowManager f5690e;

    public PopupWindows(Context context) {
        this.f5686a = context;
        this.f5687b = new PopupWindow(context);
        this.f5687b.setTouchInterceptor(new C1371a(this));
        this.f5690e = (WindowManager) context.getSystemService("window");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo9393a() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo9394b() {
        if (this.f5688c == null) {
            throw new IllegalStateException("setContentView was not called with a view to display.");
        }
        mo9393a();
        if (this.f5689d == null) {
            this.f5687b.setBackgroundDrawable(new BitmapDrawable());
        } else {
            this.f5687b.setBackgroundDrawable(this.f5689d);
        }
        this.f5687b.setWidth(-2);
        this.f5687b.setHeight(-2);
        this.f5687b.setTouchable(true);
        this.f5687b.setFocusable(true);
        this.f5687b.setOutsideTouchable(true);
        this.f5687b.setContentView(this.f5688c);
    }

    public void dismiss() {
        this.f5687b.dismiss();
    }

    /* access modifiers changed from: protected */
    public void onDismiss() {
    }

    public void setBackgroundDrawable(Drawable drawable) {
        this.f5689d = drawable;
    }

    public void setContentView(int i) {
        setContentView(((LayoutInflater) this.f5686a.getSystemService("layout_inflater")).inflate(i, (ViewGroup) null));
    }

    public void setContentView(View view) {
        this.f5688c = view;
        this.f5687b.setContentView(view);
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.f5687b.setOnDismissListener(onDismissListener);
    }
}
