package p000;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.google.maps.android.C0994R;

/* renamed from: hw */
public class C1223hw extends Drawable {

    /* renamed from: a */
    private final Drawable f4332a;

    /* renamed from: b */
    private final Drawable f4333b;

    /* renamed from: c */
    private int f4334c = -1;

    public C1223hw(Resources resources) {
        this.f4333b = resources.getDrawable(C0994R.C0995drawable.bubble_mask);
        this.f4332a = resources.getDrawable(C0994R.C0995drawable.bubble_shadow);
    }

    /* renamed from: a */
    public void mo8362a(int i) {
        this.f4334c = i;
    }

    public void draw(Canvas canvas) {
        this.f4333b.draw(canvas);
        canvas.drawColor(this.f4334c, PorterDuff.Mode.SRC_IN);
        this.f4332a.draw(canvas);
    }

    public void setAlpha(int i) {
        throw new UnsupportedOperationException();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        throw new UnsupportedOperationException();
    }

    public int getOpacity() {
        return -3;
    }

    public void setBounds(int i, int i2, int i3, int i4) {
        this.f4333b.setBounds(i, i2, i3, i4);
        this.f4332a.setBounds(i, i2, i3, i4);
    }

    public void setBounds(Rect rect) {
        this.f4333b.setBounds(rect);
        this.f4332a.setBounds(rect);
    }

    public boolean getPadding(Rect rect) {
        return this.f4333b.getPadding(rect);
    }
}
