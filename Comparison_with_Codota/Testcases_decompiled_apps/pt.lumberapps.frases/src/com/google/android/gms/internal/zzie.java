package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import com.google.android.gms.internal.zzic;
import com.google.android.gms.internal.zzju;

@TargetApi(19)
@zzin
public class zzie extends zzid {

    /* renamed from: g */
    private Object f6383g = new Object();

    /* renamed from: h */
    private PopupWindow f6384h;

    /* renamed from: i */
    private boolean f6385i = false;

    zzie(Context context, zzju.zza zza, zzlh zzlh, zzic.zza zza2) {
        super(context, zza, zzlh, zza2);
    }

    /* renamed from: d */
    private void m7164d() {
        synchronized (this.f6383g) {
            this.f6385i = true;
            if ((this.f6356b instanceof Activity) && ((Activity) this.f6356b).isDestroyed()) {
                this.f6384h = null;
            }
            if (this.f6384h != null) {
                if (this.f6384h.isShowing()) {
                    this.f6384h.dismiss();
                }
                this.f6384h = null;
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo8487a(int i) {
        m7164d();
        super.mo8487a(i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo8508c() {
        Window window = this.f6356b instanceof Activity ? ((Activity) this.f6356b).getWindow() : null;
        if (window != null && window.getDecorView() != null && !((Activity) this.f6356b).isDestroyed()) {
            FrameLayout frameLayout = new FrameLayout(this.f6356b);
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            frameLayout.addView(this.f6357c.getView(), -1, -1);
            synchronized (this.f6383g) {
                if (!this.f6385i) {
                    this.f6384h = new PopupWindow(frameLayout, 1, 1, false);
                    this.f6384h.setOutsideTouchable(true);
                    this.f6384h.setClippingEnabled(false);
                    zzkd.zzcv("Displaying the 1x1 popup off the screen.");
                    try {
                        this.f6384h.showAtLocation(window.getDecorView(), 0, -1, -1);
                    } catch (Exception e) {
                        this.f6384h = null;
                    }
                }
            }
        }
    }

    public void cancel() {
        m7164d();
        super.cancel();
    }
}
