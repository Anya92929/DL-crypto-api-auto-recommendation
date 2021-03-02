package android.support.p021v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.p009v4.p012b.p013a.C0095a;
import android.support.p021v7.p023b.C0506b;
import android.util.AttributeSet;

/* renamed from: android.support.v7.widget.p */
class C0694p extends C0600ay implements C0699u {

    /* renamed from: a */
    final /* synthetic */ C0689k f1713a;

    /* renamed from: b */
    private final float[] f1714b = new float[2];

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0694p(C0689k kVar, Context context) {
        super(context, (AttributeSet) null, C0506b.actionOverflowButtonStyle);
        this.f1713a = kVar;
        setClickable(true);
        setFocusable(true);
        setVisibility(0);
        setEnabled(true);
        setOnTouchListener(new C0695q(this, this, kVar));
    }

    /* renamed from: c */
    public boolean mo2241c() {
        return false;
    }

    /* renamed from: d */
    public boolean mo2242d() {
        return false;
    }

    public boolean performClick() {
        if (!super.performClick()) {
            playSoundEffect(0);
            this.f1713a.mo3358d();
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean setFrame(int i, int i2, int i3, int i4) {
        boolean frame = super.setFrame(i, i2, i3, i4);
        Drawable drawable = getDrawable();
        Drawable background = getBackground();
        if (!(drawable == null || background == null)) {
            int width = getWidth();
            int height = getHeight();
            int max = Math.max(width, height) / 2;
            int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
            int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
            C0095a.m197a(background, paddingLeft - max, paddingTop - max, paddingLeft + max, paddingTop + max);
        }
        return frame;
    }
}
