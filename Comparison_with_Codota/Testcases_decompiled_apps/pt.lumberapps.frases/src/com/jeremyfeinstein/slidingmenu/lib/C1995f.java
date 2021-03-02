package com.jeremyfeinstein.slidingmenu.lib;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: com.jeremyfeinstein.slidingmenu.lib.f */
public class C1995f extends ViewGroup {

    /* renamed from: a */
    private int f7587a;

    /* renamed from: b */
    private C1990a f7588b;

    /* renamed from: c */
    private View f7589c;

    /* renamed from: d */
    private View f7590d;

    /* renamed from: e */
    private int f7591e;

    /* renamed from: f */
    private int f7592f;

    /* renamed from: g */
    private C2001l f7593g;

    /* renamed from: h */
    private boolean f7594h;

    /* renamed from: i */
    private int f7595i;

    /* renamed from: j */
    private boolean f7596j;

    /* renamed from: k */
    private final Paint f7597k;

    /* renamed from: l */
    private float f7598l;

    /* renamed from: m */
    private Drawable f7599m;

    /* renamed from: n */
    private Drawable f7600n;

    /* renamed from: o */
    private int f7601o;

    /* renamed from: p */
    private float f7602p;

    /* renamed from: q */
    private boolean f7603q;

    /* renamed from: r */
    private Bitmap f7604r;

    /* renamed from: s */
    private View f7605s;

    public C1995f(Context context) {
        this(context, (AttributeSet) null);
    }

    public C1995f(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7587a = 0;
        this.f7597k = new Paint();
        this.f7603q = true;
        this.f7591e = (int) TypedValue.applyDimension(1, 48.0f, getResources().getDisplayMetrics());
    }

    private int getSelectorTop() {
        return this.f7605s.getTop() + ((this.f7605s.getHeight() - this.f7604r.getHeight()) / 2);
    }

    /* renamed from: a */
    public int mo10020a(int i) {
        if (i > 1) {
            i = 2;
        } else if (i < 1) {
            i = 0;
        }
        if (this.f7595i == 0 && i > 1) {
            return 0;
        }
        if (this.f7595i != 1 || i >= 1) {
            return i;
        }
        return 2;
    }

    /* renamed from: a */
    public int mo10021a(View view) {
        if (this.f7595i == 0 || this.f7595i == 2) {
            return view.getLeft() - getBehindWidth();
        }
        if (this.f7595i == 1) {
            return view.getLeft();
        }
        return 0;
    }

    /* renamed from: a */
    public int mo10022a(View view, int i) {
        if (this.f7595i == 0) {
            switch (i) {
                case 0:
                    return view.getLeft() - getBehindWidth();
                case 2:
                    return view.getLeft();
            }
        } else if (this.f7595i == 1) {
            switch (i) {
                case 0:
                    return view.getLeft();
                case 2:
                    return view.getLeft() + getBehindWidth();
            }
        } else if (this.f7595i == 2) {
            switch (i) {
                case 0:
                    return view.getLeft() - getBehindWidth();
                case 2:
                    return view.getLeft() + getBehindWidth();
            }
        }
        return view.getLeft();
    }

    /* renamed from: a */
    public void mo10023a(View view, int i, int i2) {
        int i3 = 0;
        if (this.f7595i == 0) {
            if (i >= view.getLeft()) {
                i3 = 4;
            }
            scrollTo((int) (((float) (getBehindWidth() + i)) * this.f7598l), i2);
        } else if (this.f7595i == 1) {
            if (i <= view.getLeft()) {
                i3 = 4;
            }
            scrollTo((int) (((float) (getBehindWidth() - getWidth())) + (((float) (i - getBehindWidth())) * this.f7598l)), i2);
        } else if (this.f7595i == 2) {
            this.f7589c.setVisibility(i >= view.getLeft() ? 4 : 0);
            this.f7590d.setVisibility(i <= view.getLeft() ? 4 : 0);
            if (i == 0) {
                i3 = 4;
            }
            if (i <= view.getLeft()) {
                scrollTo((int) (((float) (getBehindWidth() + i)) * this.f7598l), i2);
            } else {
                scrollTo((int) (((float) (getBehindWidth() - getWidth())) + (((float) (i - getBehindWidth())) * this.f7598l)), i2);
            }
        }
        if (i3 == 4) {
            Log.v("CustomViewBehind", "behind INVISIBLE");
        }
        setVisibility(i3);
    }

    /* renamed from: a */
    public void mo10024a(View view, Canvas canvas) {
        int i;
        if (this.f7599m != null && this.f7601o > 0) {
            if (this.f7595i == 0) {
                i = view.getLeft() - this.f7601o;
            } else if (this.f7595i == 1) {
                i = view.getRight();
            } else if (this.f7595i == 2) {
                if (this.f7600n != null) {
                    int right = view.getRight();
                    this.f7600n.setBounds(right, 0, this.f7601o + right, getHeight());
                    this.f7600n.draw(canvas);
                }
                i = view.getLeft() - this.f7601o;
            } else {
                i = 0;
            }
            this.f7599m.setBounds(i, 0, this.f7601o + i, getHeight());
            this.f7599m.draw(canvas);
        }
    }

    /* renamed from: a */
    public void mo10025a(View view, Canvas canvas, float f) {
        int i;
        int i2 = 0;
        if (this.f7596j) {
            this.f7597k.setColor(Color.argb((int) (this.f7602p * 255.0f * Math.abs(1.0f - f)), 0, 0, 0));
            if (this.f7595i == 0) {
                i = view.getLeft() - getBehindWidth();
                i2 = view.getLeft();
            } else if (this.f7595i == 1) {
                i = view.getRight();
                i2 = view.getRight() + getBehindWidth();
            } else if (this.f7595i == 2) {
                canvas.drawRect((float) (view.getLeft() - getBehindWidth()), 0.0f, (float) view.getLeft(), (float) getHeight(), this.f7597k);
                i = view.getRight();
                i2 = view.getRight() + getBehindWidth();
            } else {
                i = 0;
            }
            canvas.drawRect((float) i, 0.0f, (float) i2, (float) getHeight(), this.f7597k);
        }
    }

    /* renamed from: a */
    public boolean mo10026a(float f) {
        return this.f7595i == 0 ? f > 0.0f : this.f7595i == 1 ? f < 0.0f : this.f7595i == 2;
    }

    /* renamed from: a */
    public boolean mo10027a(View view, int i, float f) {
        switch (this.f7587a) {
            case 0:
                return mo10032b(view, i, f);
            case 1:
                return true;
            default:
                return false;
        }
    }

    /* renamed from: b */
    public int mo10028b(View view) {
        if (this.f7595i == 0) {
            return view.getLeft();
        }
        if (this.f7595i == 1 || this.f7595i == 2) {
            return view.getLeft() + getBehindWidth();
        }
        return 0;
    }

    /* renamed from: b */
    public void mo10029b(View view, Canvas canvas, float f) {
        if (this.f7603q && this.f7604r != null && this.f7605s != null && ((String) this.f7605s.getTag(C1997h.selected_view)).equals("CustomViewBehindSelectedView")) {
            canvas.save();
            int width = (int) (((float) this.f7604r.getWidth()) * f);
            if (this.f7595i == 0) {
                int left = view.getLeft();
                int i = left - width;
                canvas.clipRect(i, 0, left, getHeight());
                canvas.drawBitmap(this.f7604r, (float) i, (float) getSelectorTop(), (Paint) null);
            } else if (this.f7595i == 1) {
                int right = view.getRight();
                int i2 = width + right;
                canvas.clipRect(right, 0, i2, getHeight());
                canvas.drawBitmap(this.f7604r, (float) (i2 - this.f7604r.getWidth()), (float) getSelectorTop(), (Paint) null);
            }
            canvas.restore();
        }
    }

    /* renamed from: b */
    public boolean mo10030b(float f) {
        return this.f7595i == 0 ? f < 0.0f : this.f7595i == 1 ? f > 0.0f : this.f7595i == 2;
    }

    /* renamed from: b */
    public boolean mo10031b(View view, int i) {
        int left = view.getLeft();
        int right = view.getRight();
        if (this.f7595i == 0) {
            return i >= left && i <= left + this.f7591e;
        }
        if (this.f7595i == 1) {
            return i <= right && i >= right - this.f7591e;
        }
        if (this.f7595i != 2) {
            return false;
        }
        if (i < left || i > left + this.f7591e) {
            return i <= right && i >= right - this.f7591e;
        }
        return true;
    }

    /* renamed from: b */
    public boolean mo10032b(View view, int i, float f) {
        if (this.f7595i == 0 || (this.f7595i == 2 && i == 0)) {
            return f >= ((float) view.getLeft());
        }
        if (this.f7595i == 1 || (this.f7595i == 2 && i == 2)) {
            return f <= ((float) view.getRight());
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        if (this.f7593g != null) {
            canvas.save();
            this.f7593g.mo10064a(canvas, this.f7588b.getPercentOpen());
            super.dispatchDraw(canvas);
            canvas.restore();
            return;
        }
        super.dispatchDraw(canvas);
    }

    public int getBehindWidth() {
        return this.f7589c.getWidth();
    }

    public View getContent() {
        return this.f7589c;
    }

    public int getMarginThreshold() {
        return this.f7591e;
    }

    public int getMode() {
        return this.f7595i;
    }

    public float getScrollScale() {
        return this.f7598l;
    }

    public View getSecondaryContent() {
        return this.f7590d;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return !this.f7594h;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int i6 = i4 - i2;
        this.f7589c.layout(0, 0, i5 - this.f7592f, i6);
        if (this.f7590d != null) {
            this.f7590d.layout(0, 0, i5 - this.f7592f, i6);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int defaultSize = getDefaultSize(0, i);
        int defaultSize2 = getDefaultSize(0, i2);
        setMeasuredDimension(defaultSize, defaultSize2);
        int childMeasureSpec = getChildMeasureSpec(i, 0, defaultSize - this.f7592f);
        int childMeasureSpec2 = getChildMeasureSpec(i2, 0, defaultSize2);
        this.f7589c.measure(childMeasureSpec, childMeasureSpec2);
        if (this.f7590d != null) {
            this.f7590d.measure(childMeasureSpec, childMeasureSpec2);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return !this.f7594h;
    }

    public void scrollTo(int i, int i2) {
        super.scrollTo(i, i2);
        if (this.f7593g != null) {
            invalidate();
        }
    }

    public void setCanvasTransformer(C2001l lVar) {
        this.f7593g = lVar;
    }

    public void setChildrenEnabled(boolean z) {
        this.f7594h = z;
    }

    public void setContent(View view) {
        if (this.f7589c != null) {
            removeView(this.f7589c);
        }
        this.f7589c = view;
        addView(this.f7589c);
    }

    public void setCustomViewAbove(C1990a aVar) {
        this.f7588b = aVar;
    }

    public void setFadeDegree(float f) {
        if (f > 1.0f || f < 0.0f) {
            throw new IllegalStateException("The BehindFadeDegree must be between 0.0f and 1.0f");
        }
        this.f7602p = f;
    }

    public void setFadeEnabled(boolean z) {
        this.f7596j = z;
    }

    public void setMarginThreshold(int i) {
        this.f7591e = i;
    }

    public void setMode(int i) {
        if (i == 0 || i == 1) {
            if (this.f7589c != null) {
                this.f7589c.setVisibility(0);
            }
            if (this.f7590d != null) {
                this.f7590d.setVisibility(4);
            }
        }
        this.f7595i = i;
    }

    public void setScrollScale(float f) {
        this.f7598l = f;
    }

    public void setSecondaryContent(View view) {
        if (this.f7590d != null) {
            removeView(this.f7590d);
        }
        this.f7590d = view;
        addView(this.f7590d);
    }

    public void setSecondaryShadowDrawable(Drawable drawable) {
        this.f7600n = drawable;
        invalidate();
    }

    public void setSelectedView(View view) {
        if (this.f7605s != null) {
            this.f7605s.setTag(C1997h.selected_view, (Object) null);
            this.f7605s = null;
        }
        if (view != null && view.getParent() != null) {
            this.f7605s = view;
            this.f7605s.setTag(C1997h.selected_view, "CustomViewBehindSelectedView");
            invalidate();
        }
    }

    public void setSelectorBitmap(Bitmap bitmap) {
        this.f7604r = bitmap;
        refreshDrawableState();
    }

    public void setSelectorEnabled(boolean z) {
        this.f7603q = z;
    }

    public void setShadowDrawable(Drawable drawable) {
        this.f7599m = drawable;
        invalidate();
    }

    public void setShadowWidth(int i) {
        this.f7601o = i;
        invalidate();
    }

    public void setTouchMode(int i) {
        this.f7587a = i;
    }

    public void setWidthOffset(int i) {
        this.f7592f = i;
        requestLayout();
    }
}
