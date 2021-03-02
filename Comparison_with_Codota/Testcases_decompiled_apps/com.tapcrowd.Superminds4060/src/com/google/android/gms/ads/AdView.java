package com.google.android.gms.ads;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.dynamic.C0164b;
import com.google.android.gms.dynamic.C0167c;
import com.google.android.gms.internal.C0198aa;
import com.google.android.gms.internal.C0199ab;
import com.google.android.gms.internal.C0202ac;
import com.google.android.gms.internal.C0208ae;
import com.google.android.gms.internal.C0237av;
import com.google.android.gms.internal.C0343cm;
import com.google.android.gms.internal.C0344cn;
import com.google.android.gms.internal.C0618t;
import com.google.android.gms.internal.C0619u;
import com.google.android.gms.internal.C0620v;
import com.google.android.gms.internal.C0622x;
import com.google.android.gms.internal.C0624z;

public final class AdView extends ViewGroup {

    /* renamed from: c */
    private AdSize f313c;

    /* renamed from: dS */
    private final C0237av f314dS;

    /* renamed from: dT */
    private AdListener f315dT;

    /* renamed from: dU */
    private C0202ac f316dU;

    /* renamed from: dV */
    private String f317dV;

    /* renamed from: dW */
    private C0132a f318dW;

    public AdView(Context context) {
        super(context);
        this.f314dS = new C0237av();
    }

    public AdView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AdView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.f314dS = new C0237av();
        try {
            C0198aa aaVar = new C0198aa(context, attrs);
            this.f313c = aaVar.getAdSize();
            this.f317dV = aaVar.getAdUnitId();
            if (isInEditMode()) {
                C0343cm.m727b(this, new C0622x(context, this.f313c), "Ads by Google");
            }
        } catch (IllegalArgumentException e) {
            C0343cm.m723a(this, new C0622x(context, AdSize.BANNER), e.getMessage());
        }
    }

    /* renamed from: c */
    private void m199c(String str) throws RemoteException {
        if (this.f313c == null || this.f317dV == null) {
            m200d(str);
        }
        Context context = getContext();
        this.f316dU = C0619u.m1951a(context, new C0622x(context, this.f313c), this.f317dV, this.f314dS);
        if (this.f315dT != null) {
            this.f316dU.mo4017a((C0199ab) new C0618t(this.f315dT));
        }
        if (this.f318dW != null) {
            this.f316dU.mo4018a((C0208ae) new C0624z(this.f318dW));
        }
        m201x();
    }

    /* renamed from: d */
    private void m200d(String str) {
        if (this.f316dU == null) {
            throw new IllegalStateException("The ad size and ad unit ID must be set on AdView before " + str + " is called.");
        }
    }

    /* renamed from: x */
    private void m201x() {
        try {
            C0164b z = this.f316dU.mo4026z();
            if (z != null) {
                addView((View) C0167c.m378b(z));
            }
        } catch (RemoteException e) {
            C0344cn.m731b("Failed to get an ad frame.", e);
        }
    }

    public void destroy() {
        try {
            if (this.f316dU != null) {
                this.f316dU.destroy();
            }
        } catch (RemoteException e) {
            C0344cn.m731b("Failed to destroy AdView.", e);
        }
    }

    public AdListener getAdListener() {
        return this.f315dT;
    }

    public AdSize getAdSize() {
        return this.f313c;
    }

    public String getAdUnitId() {
        return this.f317dV;
    }

    public void loadAd(AdRequest adRequest) {
        try {
            if (this.f316dU == null) {
                m199c("loadAd");
            }
            if (this.f316dU.mo4019a(new C0620v(getContext(), adRequest))) {
                this.f314dS.mo4061c(adRequest.mo3460v());
            }
        } catch (RemoteException e) {
            C0344cn.m731b("Failed to load ad.", e);
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        View childAt = getChildAt(0);
        if (childAt != null && childAt.getVisibility() != 8) {
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            int i = ((right - left) - measuredWidth) / 2;
            int i2 = ((bottom - top) - measuredHeight) / 2;
            childAt.layout(i, i2, measuredWidth + i, measuredHeight + i2);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int i;
        int i2 = 0;
        View childAt = getChildAt(0);
        if (childAt != null && childAt.getVisibility() != 8) {
            measureChild(childAt, widthMeasureSpec, heightMeasureSpec);
            i = childAt.getMeasuredWidth();
            i2 = childAt.getMeasuredHeight();
        } else if (this.f313c != null) {
            Context context = getContext();
            i = this.f313c.getWidthInPixels(context);
            i2 = this.f313c.getHeightInPixels(context);
        } else {
            i = 0;
        }
        setMeasuredDimension(resolveSize(Math.max(i, getSuggestedMinimumWidth()), widthMeasureSpec), resolveSize(Math.max(i2, getSuggestedMinimumHeight()), heightMeasureSpec));
    }

    public void pause() {
        try {
            if (this.f316dU != null) {
                this.f316dU.pause();
            }
        } catch (RemoteException e) {
            C0344cn.m731b("Failed to call pause.", e);
        }
    }

    public void resume() {
        try {
            if (this.f316dU != null) {
                this.f316dU.resume();
            }
        } catch (RemoteException e) {
            C0344cn.m731b("Failed to call resume.", e);
        }
    }

    public void setAdListener(AdListener adListener) {
        try {
            this.f315dT = adListener;
            if (this.f316dU != null) {
                this.f316dU.mo4017a((C0199ab) adListener != null ? new C0618t(adListener) : null);
            }
        } catch (RemoteException e) {
            C0344cn.m731b("Failed to set the AdListener.", e);
        }
    }

    public void setAdSize(AdSize adSize) {
        if (this.f313c != null) {
            throw new IllegalStateException("The ad size can only be set once on AdView.");
        }
        this.f313c = adSize;
        requestLayout();
    }

    public void setAdUnitId(String adUnitId) {
        if (this.f317dV != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
        }
        this.f317dV = adUnitId;
    }
}
