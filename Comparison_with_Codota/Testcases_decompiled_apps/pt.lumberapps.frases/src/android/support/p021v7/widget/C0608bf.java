package android.support.p021v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.support.p021v7.p023b.C0506b;
import android.util.AttributeSet;
import android.widget.SeekBar;

/* renamed from: android.support.v7.widget.bf */
public class C0608bf extends SeekBar {

    /* renamed from: a */
    private C0609bg f1439a;

    /* renamed from: b */
    private C0591ap f1440b;

    public C0608bf(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0506b.seekBarStyle);
    }

    public C0608bf(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1440b = C0591ap.m2736a();
        this.f1439a = new C0609bg(this, this.f1440b);
        this.f1439a.mo3017a(attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        this.f1439a.mo3030c();
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        this.f1439a.mo3029b();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f1439a.mo3027a(canvas);
    }
}
