package com.google.ads.internal;

import com.google.ads.AdSize;
import com.google.ads.C0265m;
import com.google.ads.C0272n;
import com.google.ads.util.AdUtil;
import com.google.ads.util.C0284b;

public class ActivationOverlay extends AdWebView {

    /* renamed from: b */
    private volatile boolean f451b = true;

    /* renamed from: c */
    private boolean f452c = true;

    /* renamed from: d */
    private int f453d = 0;

    /* renamed from: e */
    private int f454e = 0;

    /* renamed from: f */
    private final C0254i f455f;

    public ActivationOverlay(C0272n slotState) {
        super(slotState, (AdSize) null);
        if (AdUtil.f690a < slotState.f657d.mo3725a().f616b.mo3725a().f620c.mo3726a().intValue()) {
            C0284b.m480a("Disabling hardware acceleration for an activation overlay.");
            mo3457g();
        }
        this.f455f = C0254i.m399a(slotState.f655b.mo3725a(), C0232a.f476c, true, true);
        setWebViewClient(this.f455f);
    }

    public void setOverlayEnabled(boolean overlayEnabled) {
        if (!overlayEnabled) {
            C0265m.m411a().f617c.mo3725a().post(new Runnable() {
                public void run() {
                    ActivationOverlay.this.f466a.f663j.mo3725a().removeView(this);
                }
            });
        }
        this.f451b = overlayEnabled;
    }

    public void setOverlayActivated(boolean overlayActivated) {
        this.f452c = overlayActivated;
    }

    /* renamed from: a */
    public boolean mo3427a() {
        return this.f451b;
    }

    /* renamed from: b */
    public boolean mo3428b() {
        return this.f452c;
    }

    /* renamed from: c */
    public int mo3429c() {
        return this.f454e;
    }

    public void setYPosition(int yPosition) {
        this.f454e = yPosition;
    }

    /* renamed from: d */
    public int mo3432d() {
        return this.f453d;
    }

    public void setXPosition(int xPosition) {
        this.f453d = xPosition;
    }

    /* renamed from: e */
    public C0254i mo3433e() {
        return this.f455f;
    }

    public boolean canScrollHorizontally(int direction) {
        return false;
    }

    public boolean canScrollVertically(int direction) {
        return false;
    }
}
