package com.appbrain;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import cmn.C0705a;
import cmn.C0725at;
import com.appbrain.p032a.C0785aa;
import com.appbrain.p032a.C0793ai;
import com.appbrain.p032a.C0950gd;

public class AppBrainBanner extends FrameLayout {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public C0950gd f2045a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public volatile C1138z f2046b;

    public AppBrainBanner(Context context) {
        super(context);
        m3576a((AttributeSet) null);
    }

    public AppBrainBanner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m3576a(attributeSet);
    }

    public AppBrainBanner(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m3576a(attributeSet);
    }

    /* renamed from: a */
    private void m3576a(AttributeSet attributeSet) {
        C0705a.m3174a().mo3377a((View) this);
        setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        if (C0793ai.f2081a) {
            this.f2045a = mo3597a();
            this.f2045a.mo3873a(attributeSet);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C0950gd mo3597a() {
        return new C0950gd(this, (C0785aa) null);
    }

    /* renamed from: a */
    public void mo3598a(boolean z, String str) {
        if (C0793ai.f2081a) {
            C0725at.m3234b((Runnable) new C1128p(this, z, str));
        }
    }

    /* renamed from: b */
    public void mo3599b() {
        C0725at.m3234b((Runnable) new C1127o(this));
    }

    public C1138z getBannerListener() {
        return this.f2046b;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f2045a != null) {
            this.f2045a.mo3877b();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (this.f2045a != null) {
            if (View.MeasureSpec.getMode(i) == Integer.MIN_VALUE) {
                i = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), 1073741824);
            }
            this.f2045a.mo3882f(i2);
        }
        super.onMeasure(i, i2);
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.f2045a != null) {
            this.f2045a.mo3877b();
        }
    }

    public void setAdId(C0783a aVar) {
        C0725at.m3234b((Runnable) new C1130r(this, aVar));
    }

    public void setBannerListener(C1138z zVar) {
        C0725at.m3234b((Runnable) new C1129q(this, zVar));
    }

    public void setButtonTextIndex(int i) {
        if (C0793ai.f2081a) {
            C0725at.m3234b((Runnable) new C1132t(this, i));
        }
    }

    public void setColors(int i) {
        if (C0793ai.f2081a) {
            C0725at.m3234b((Runnable) new C1134v(this, i));
        }
    }

    public void setDesign(int i) {
        if (C0793ai.f2081a) {
            C0725at.m3234b((Runnable) new C1133u(this, i));
        }
    }

    public void setSingleAppDesign(int i) {
        if (C0793ai.f2081a) {
            C0725at.m3234b((Runnable) new C1126n(this, i));
        }
    }

    public void setSize(C1135w wVar) {
        if (C0793ai.f2081a) {
            C0725at.m3234b((Runnable) new C1123m(this, wVar));
        }
    }

    public void setTitleIndex(int i) {
        if (C0793ai.f2081a) {
            C0725at.m3234b((Runnable) new C1131s(this, i));
        }
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        if (this.f2045a != null) {
            this.f2045a.mo3877b();
        }
    }
}
