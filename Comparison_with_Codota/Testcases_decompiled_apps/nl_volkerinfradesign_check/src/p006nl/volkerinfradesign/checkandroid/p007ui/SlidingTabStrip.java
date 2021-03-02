package p006nl.volkerinfradesign.checkandroid.p007ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import p006nl.volkerinfradesign.checkandroid.p007ui.SlidingTabLayout;

/* renamed from: nl.volkerinfradesign.checkandroid.ui.SlidingTabStrip */
public class SlidingTabStrip extends LinearLayout {

    /* renamed from: a */
    private final int f4993a;

    /* renamed from: b */
    private final Paint f4994b;

    /* renamed from: c */
    private final int f4995c;

    /* renamed from: d */
    private final Paint f4996d;

    /* renamed from: e */
    private final int f4997e;

    /* renamed from: f */
    private final Paint f4998f;

    /* renamed from: g */
    private final float f4999g;

    /* renamed from: h */
    private int f5000h;

    /* renamed from: i */
    private float f5001i;

    /* renamed from: j */
    private SlidingTabLayout.TabColorizer f5002j;

    /* renamed from: k */
    private final C1544a f5003k;

    SlidingTabStrip(Context context) {
        this(context, (AttributeSet) null);
    }

    SlidingTabStrip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setWillNotDraw(false);
        float f = getResources().getDisplayMetrics().density;
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(16842800, typedValue, true);
        int i = typedValue.data;
        this.f4997e = m6054a(i, (byte) 38);
        this.f5003k = new C1544a();
        this.f5003k.mo9830a(-13388315);
        this.f5003k.mo9831b(m6054a(i, (byte) 32));
        this.f4993a = (int) (2.0f * f);
        this.f4994b = new Paint();
        this.f4994b.setColor(this.f4997e);
        this.f4995c = (int) (8.0f * f);
        this.f4996d = new Paint();
        this.f4999g = 0.5f;
        this.f4998f = new Paint();
        this.f4998f.setStrokeWidth((float) ((int) (f * 1.0f)));
    }

    /* access modifiers changed from: package-private */
    public void setCustomTabColorizer(SlidingTabLayout.TabColorizer tabColorizer) {
        this.f5002j = tabColorizer;
        invalidate();
    }

    /* access modifiers changed from: package-private */
    public void setSelectedIndicatorColors(int... iArr) {
        this.f5002j = null;
        this.f5003k.mo9830a(iArr);
        invalidate();
    }

    /* access modifiers changed from: package-private */
    public void setDividerColors(int... iArr) {
        this.f5002j = null;
        this.f5003k.mo9831b(iArr);
        invalidate();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo9825a(int i, float f) {
        this.f5000h = i;
        this.f5001i = f;
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int i;
        int i2;
        int height = getHeight();
        int childCount = getChildCount();
        int min = (int) (Math.min(Math.max(BitmapDescriptorFactory.HUE_RED, this.f4999g), 1.0f) * ((float) height));
        SlidingTabLayout.TabColorizer tabColorizer = this.f5002j != null ? this.f5002j : this.f5003k;
        if (childCount > 0) {
            View childAt = getChildAt(this.f5000h);
            int left = childAt.getLeft();
            int right = childAt.getRight();
            int indicatorColor = tabColorizer.getIndicatorColor(this.f5000h);
            if (this.f5001i <= BitmapDescriptorFactory.HUE_RED || this.f5000h >= getChildCount() - 1) {
                i = right;
                i2 = left;
            } else {
                int indicatorColor2 = tabColorizer.getIndicatorColor(this.f5000h + 1);
                if (indicatorColor != indicatorColor2) {
                    indicatorColor = m6055a(indicatorColor2, indicatorColor, this.f5001i);
                }
                View childAt2 = getChildAt(this.f5000h + 1);
                i = (int) ((((float) right) * (1.0f - this.f5001i)) + (((float) childAt2.getRight()) * this.f5001i));
                i2 = (int) ((((float) left) * (1.0f - this.f5001i)) + (this.f5001i * ((float) childAt2.getLeft())));
            }
            this.f4996d.setColor(indicatorColor);
            canvas.drawRect((float) i2, (float) (height - this.f4995c), (float) i, (float) height, this.f4996d);
        }
        canvas.drawRect(BitmapDescriptorFactory.HUE_RED, (float) (height - this.f4993a), (float) getWidth(), (float) height, this.f4994b);
        int i3 = (height - min) / 2;
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 < childCount - 1) {
                View childAt3 = getChildAt(i5);
                this.f4998f.setColor(tabColorizer.getDividerColor(i5));
                canvas.drawLine((float) childAt3.getRight(), (float) i3, (float) childAt3.getRight(), (float) (i3 + min), this.f4998f);
                i4 = i5 + 1;
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    private static int m6054a(int i, byte b) {
        return Color.argb(b, Color.red(i), Color.green(i), Color.blue(i));
    }

    /* renamed from: a */
    private static int m6055a(int i, int i2, float f) {
        float f2 = 1.0f - f;
        return Color.rgb((int) ((((float) Color.red(i)) * f) + (((float) Color.red(i2)) * f2)), (int) ((((float) Color.green(i)) * f) + (((float) Color.green(i2)) * f2)), (int) ((f2 * ((float) Color.blue(i2))) + (((float) Color.blue(i)) * f)));
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.ui.SlidingTabStrip$a */
    static class C1544a implements SlidingTabLayout.TabColorizer {

        /* renamed from: a */
        private int[] f5004a;

        /* renamed from: b */
        private int[] f5005b;

        private C1544a() {
        }

        public final int getIndicatorColor(int i) {
            return this.f5004a[i % this.f5004a.length];
        }

        public final int getDividerColor(int i) {
            return this.f5005b[i % this.f5005b.length];
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo9830a(int... iArr) {
            this.f5004a = iArr;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo9831b(int... iArr) {
            this.f5005b = iArr;
        }
    }
}
