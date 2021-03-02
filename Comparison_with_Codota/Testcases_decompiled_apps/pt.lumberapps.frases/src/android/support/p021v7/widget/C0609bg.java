package android.support.p021v7.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.p009v4.p012b.p013a.C0095a;
import android.support.p009v4.view.C0247by;
import android.support.p021v7.p023b.C0515k;
import android.util.AttributeSet;
import android.widget.SeekBar;

/* renamed from: android.support.v7.widget.bg */
class C0609bg extends C0605bc {

    /* renamed from: b */
    private final SeekBar f1441b;

    /* renamed from: c */
    private Drawable f1442c;

    /* renamed from: d */
    private ColorStateList f1443d = null;

    /* renamed from: e */
    private PorterDuff.Mode f1444e = null;

    /* renamed from: f */
    private boolean f1445f = false;

    /* renamed from: g */
    private boolean f1446g = false;

    C0609bg(SeekBar seekBar, C0591ap apVar) {
        super(seekBar, apVar);
        this.f1441b = seekBar;
    }

    /* renamed from: d */
    private void m2774d() {
        if (this.f1442c == null) {
            return;
        }
        if (this.f1445f || this.f1446g) {
            this.f1442c = this.f1442c.mutate();
            if (this.f1445f) {
                this.f1442c.setTintList(this.f1443d);
            }
            if (this.f1446g) {
                this.f1442c.setTintMode(this.f1444e);
            }
            if (this.f1442c.isStateful()) {
                this.f1442c.setState(this.f1441b.getDrawableState());
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3027a(Canvas canvas) {
        int max;
        int i = 1;
        if (this.f1442c != null && (max = this.f1441b.getMax()) > 1) {
            int intrinsicWidth = this.f1442c.getIntrinsicWidth();
            int intrinsicHeight = this.f1442c.getIntrinsicHeight();
            int i2 = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
            if (intrinsicHeight >= 0) {
                i = intrinsicHeight / 2;
            }
            this.f1442c.setBounds(-i2, -i, i2, i);
            float width = ((float) ((this.f1441b.getWidth() - this.f1441b.getPaddingLeft()) - this.f1441b.getPaddingRight())) / ((float) max);
            int save = canvas.save();
            canvas.translate((float) this.f1441b.getPaddingLeft(), (float) (this.f1441b.getHeight() / 2));
            for (int i3 = 0; i3 <= max; i3++) {
                this.f1442c.draw(canvas);
                canvas.translate(width, 0.0f);
            }
            canvas.restoreToCount(save);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3028a(Drawable drawable) {
        if (this.f1442c != null) {
            this.f1442c.setCallback((Drawable.Callback) null);
        }
        this.f1442c = drawable;
        if (drawable != null) {
            drawable.setCallback(this.f1441b);
            C0095a.m203b(drawable, C0247by.m909d(this.f1441b));
            if (drawable.isStateful()) {
                drawable.setState(this.f1441b.getDrawableState());
            }
            m2774d();
        }
        this.f1441b.invalidate();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3017a(AttributeSet attributeSet, int i) {
        super.mo3017a(attributeSet, i);
        C0670dn a = C0670dn.m3014a(this.f1441b.getContext(), attributeSet, C0515k.AppCompatSeekBar, i, 0);
        Drawable b = a.mo3322b(C0515k.AppCompatSeekBar_android_thumb);
        if (b != null) {
            this.f1441b.setThumb(b);
        }
        mo3028a(a.mo3318a(C0515k.AppCompatSeekBar_tickMark));
        if (a.mo3332g(C0515k.AppCompatSeekBar_tickMarkTintMode)) {
            this.f1444e = C0624bv.m2853a(a.mo3317a(C0515k.AppCompatSeekBar_tickMarkTintMode, -1), this.f1444e);
            this.f1446g = true;
        }
        if (a.mo3332g(C0515k.AppCompatSeekBar_tickMarkTint)) {
            this.f1443d = a.mo3328e(C0515k.AppCompatSeekBar_tickMarkTint);
            this.f1445f = true;
        }
        a.mo3319a();
        m2774d();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo3029b() {
        if (this.f1442c != null) {
            this.f1442c.jumpToCurrentState();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo3030c() {
        Drawable drawable = this.f1442c;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.f1441b.getDrawableState())) {
            this.f1441b.invalidateDrawable(drawable);
        }
    }
}
