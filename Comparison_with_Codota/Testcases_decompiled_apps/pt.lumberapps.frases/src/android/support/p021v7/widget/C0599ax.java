package android.support.p021v7.widget;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.support.p009v4.p010a.C0025a;
import android.support.p021v7.p023b.C0515k;
import android.util.AttributeSet;
import android.widget.ImageView;

/* renamed from: android.support.v7.widget.ax */
public class C0599ax {

    /* renamed from: a */
    private final ImageView f1415a;

    /* renamed from: b */
    private final C0591ap f1416b;

    public C0599ax(ImageView imageView, C0591ap apVar) {
        this.f1415a = imageView;
        this.f1416b = apVar;
    }

    /* renamed from: a */
    public void mo2997a(int i) {
        if (i != 0) {
            Drawable a = this.f1416b != null ? this.f1416b.mo2982a(this.f1415a.getContext(), i) : C0025a.getDrawable(this.f1415a.getContext(), i);
            if (a != null) {
                C0624bv.m2854a(a);
            }
            this.f1415a.setImageDrawable(a);
            return;
        }
        this.f1415a.setImageDrawable((Drawable) null);
    }

    /* renamed from: a */
    public void mo2998a(AttributeSet attributeSet, int i) {
        Drawable a;
        C0670dn a2 = C0670dn.m3014a(this.f1415a.getContext(), attributeSet, C0515k.AppCompatImageView, i, 0);
        try {
            Drawable b = a2.mo3322b(C0515k.AppCompatImageView_android_src);
            if (b != null) {
                this.f1415a.setImageDrawable(b);
            }
            int g = a2.mo3331g(C0515k.AppCompatImageView_srcCompat, -1);
            if (!(g == -1 || (a = this.f1416b.mo2982a(this.f1415a.getContext(), g)) == null)) {
                this.f1415a.setImageDrawable(a);
            }
            Drawable drawable = this.f1415a.getDrawable();
            if (drawable != null) {
                C0624bv.m2854a(drawable);
            }
        } finally {
            a2.mo3319a();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo2999a() {
        return Build.VERSION.SDK_INT < 21 || !(this.f1415a.getBackground() instanceof RippleDrawable);
    }
}
