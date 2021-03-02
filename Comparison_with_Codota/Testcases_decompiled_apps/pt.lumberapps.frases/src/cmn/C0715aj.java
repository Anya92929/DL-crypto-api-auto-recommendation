package cmn;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

/* renamed from: cmn.aj */
public final class C0715aj extends TextView {

    /* renamed from: a */
    private int f1765a;

    /* renamed from: b */
    private float f1766b;

    /* renamed from: c */
    private int f1767c = -1;

    /* renamed from: d */
    private float f1768d = -1.0f;

    /* renamed from: e */
    private String f1769e = "";

    public C0715aj(Context context) {
        super(context);
        setMaxLines(1);
        setEllipsize(TextUtils.TruncateAt.END);
        this.f1766b = getTextSize();
    }

    /* renamed from: a */
    private static boolean m3199a(float f, TextPaint textPaint, String str, int i, int i2, int i3) {
        textPaint.setTextSize(f);
        StaticLayout staticLayout = new StaticLayout(str, textPaint, i, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        return staticLayout.getLineCount() > i3 || staticLayout.getHeight() > i2;
    }

    /* access modifiers changed from: protected */
    public final void onMeasure(int i, int i2) {
        float f;
        super.onMeasure(i, i2);
        float f2 = this.f1766b;
        int size = View.MeasureSpec.getSize(i);
        if (size > 0) {
            String charSequence = getText().toString();
            if (size != this.f1767c || !charSequence.equals(this.f1769e)) {
                this.f1767c = size;
                this.f1769e = charSequence;
                int mode = View.MeasureSpec.getMode(i2);
                int i3 = Integer.MAX_VALUE;
                if (mode == Integer.MIN_VALUE || mode == 1073741824) {
                    i3 = View.MeasureSpec.getSize(i2);
                }
                int compoundPaddingLeft = size - ((getCompoundPaddingLeft() + getCompoundPaddingRight()) + 1);
                int compoundPaddingTop = i3 - ((getCompoundPaddingTop() + getCompoundPaddingBottom()) + 1);
                if (compoundPaddingLeft > 0) {
                    String charSequence2 = getText().toString();
                    int i4 = this.f1765a;
                    f = this.f1766b;
                    TextPaint paint = getPaint();
                    Typeface typeface = getTypeface();
                    float b = (float) C0709ad.m3188b(8.0f);
                    Paint paint2 = new Paint();
                    paint2.set(paint);
                    TextPaint textPaint = new TextPaint(paint2);
                    textPaint.setTypeface(typeface);
                    if (m3199a(f, textPaint, charSequence2, compoundPaddingLeft, compoundPaddingTop, i4)) {
                        float f3 = f;
                        while (f3 - b > 0.5f) {
                            float f4 = (f3 + b) / 2.0f;
                            if (m3199a(f4, textPaint, charSequence2, compoundPaddingLeft, compoundPaddingTop, i4)) {
                                f3 = f4;
                            } else {
                                b = f4;
                            }
                        }
                        f = b;
                    }
                    if (f >= 10.0f) {
                        f = (float) Math.floor((double) f);
                    }
                } else {
                    f = f2;
                }
                this.f1768d = f;
            } else {
                f = this.f1768d;
            }
        } else {
            f = f2;
        }
        if (Math.abs(getTextSize() - f) > 0.1f) {
            super.setTextSize(0, f);
            super.onMeasure(i, i2);
        }
    }

    public final void setMaxLines(int i) {
        super.setMaxLines(i);
        this.f1765a = i;
    }

    public final void setTextSize(float f) {
        super.setTextSize(f);
        this.f1766b = getTextSize();
    }

    public final void setTextSize(int i, float f) {
        super.setTextSize(i, f);
        this.f1766b = getTextSize();
    }
}
