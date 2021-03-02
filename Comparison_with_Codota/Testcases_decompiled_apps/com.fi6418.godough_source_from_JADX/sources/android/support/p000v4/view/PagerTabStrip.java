package android.support.p000v4.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

/* renamed from: android.support.v4.view.PagerTabStrip */
public class PagerTabStrip extends PagerTitleStrip {

    /* renamed from: f */
    private int f1202f;

    /* renamed from: g */
    private int f1203g;

    /* renamed from: h */
    private int f1204h;

    /* renamed from: i */
    private int f1205i;

    /* renamed from: j */
    private int f1206j;

    /* renamed from: k */
    private int f1207k;

    /* renamed from: l */
    private final Paint f1208l;

    /* renamed from: m */
    private final Rect f1209m;

    /* renamed from: n */
    private int f1210n;

    /* renamed from: o */
    private boolean f1211o;

    /* renamed from: p */
    private boolean f1212p;

    /* renamed from: q */
    private int f1213q;

    /* renamed from: r */
    private boolean f1214r;

    /* renamed from: s */
    private float f1215s;

    /* renamed from: t */
    private float f1216t;

    /* renamed from: u */
    private int f1217u;

    public PagerTabStrip(Context context) {
        this(context, (AttributeSet) null);
    }

    public PagerTabStrip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1208l = new Paint();
        this.f1209m = new Rect();
        this.f1210n = 255;
        this.f1211o = false;
        this.f1212p = false;
        this.f1202f = this.f1227e;
        this.f1208l.setColor(this.f1202f);
        float f = context.getResources().getDisplayMetrics().density;
        this.f1203g = (int) ((3.0f * f) + 0.5f);
        this.f1204h = (int) ((6.0f * f) + 0.5f);
        this.f1205i = (int) (64.0f * f);
        this.f1207k = (int) ((16.0f * f) + 0.5f);
        this.f1213q = (int) ((1.0f * f) + 0.5f);
        this.f1206j = (int) ((f * 32.0f) + 0.5f);
        this.f1217u = ViewConfiguration.get(context).getScaledTouchSlop();
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        setTextSpacing(getTextSpacing());
        setWillNotDraw(false);
        this.f1224b.setFocusable(true);
        this.f1224b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                PagerTabStrip.this.f1223a.setCurrentItem(PagerTabStrip.this.f1223a.getCurrentItem() - 1);
            }
        });
        this.f1226d.setFocusable(true);
        this.f1226d.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                PagerTabStrip.this.f1223a.setCurrentItem(PagerTabStrip.this.f1223a.getCurrentItem() + 1);
            }
        });
        if (getBackground() == null) {
            this.f1211o = true;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2255a(int i, float f, boolean z) {
        Rect rect = this.f1209m;
        int height = getHeight();
        int left = this.f1225c.getLeft() - this.f1207k;
        int right = this.f1225c.getRight() + this.f1207k;
        int i2 = height - this.f1203g;
        rect.set(left, i2, right, height);
        super.mo2255a(i, f, z);
        this.f1210n = (int) (Math.abs(f - 0.5f) * 2.0f * 255.0f);
        rect.union(this.f1225c.getLeft() - this.f1207k, i2, this.f1225c.getRight() + this.f1207k, height);
        invalidate(rect);
    }

    public boolean getDrawFullUnderline() {
        return this.f1211o;
    }

    /* access modifiers changed from: package-private */
    public int getMinHeight() {
        return Math.max(super.getMinHeight(), this.f1206j);
    }

    public int getTabIndicatorColor() {
        return this.f1202f;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        int left = this.f1225c.getLeft() - this.f1207k;
        int right = this.f1225c.getRight() + this.f1207k;
        int i = height - this.f1203g;
        this.f1208l.setColor((this.f1210n << 24) | (this.f1202f & ViewCompat.MEASURED_SIZE_MASK));
        canvas.drawRect((float) left, (float) i, (float) right, (float) height, this.f1208l);
        if (this.f1211o) {
            this.f1208l.setColor(-16777216 | (this.f1202f & ViewCompat.MEASURED_SIZE_MASK));
            canvas.drawRect((float) getPaddingLeft(), (float) (height - this.f1213q), (float) (getWidth() - getPaddingRight()), (float) height, this.f1208l);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0 && this.f1214r) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        switch (action) {
            case 0:
                this.f1215s = x;
                this.f1216t = y;
                this.f1214r = false;
                break;
            case 1:
                if (x >= ((float) (this.f1225c.getLeft() - this.f1207k))) {
                    if (x > ((float) (this.f1225c.getRight() + this.f1207k))) {
                        this.f1223a.setCurrentItem(this.f1223a.getCurrentItem() + 1);
                        break;
                    }
                } else {
                    this.f1223a.setCurrentItem(this.f1223a.getCurrentItem() - 1);
                    break;
                }
                break;
            case 2:
                if (Math.abs(x - this.f1215s) > ((float) this.f1217u) || Math.abs(y - this.f1216t) > ((float) this.f1217u)) {
                    this.f1214r = true;
                    break;
                }
        }
        return true;
    }

    public void setBackgroundColor(int i) {
        super.setBackgroundColor(i);
        if (!this.f1212p) {
            this.f1211o = (-16777216 & i) == 0;
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (!this.f1212p) {
            this.f1211o = drawable == null;
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (!this.f1212p) {
            this.f1211o = i == 0;
        }
    }

    public void setDrawFullUnderline(boolean z) {
        this.f1211o = z;
        this.f1212p = true;
        invalidate();
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        if (i4 < this.f1204h) {
            i4 = this.f1204h;
        }
        super.setPadding(i, i2, i3, i4);
    }

    public void setTabIndicatorColor(int i) {
        this.f1202f = i;
        this.f1208l.setColor(this.f1202f);
        invalidate();
    }

    public void setTabIndicatorColorResource(int i) {
        setTabIndicatorColor(getContext().getResources().getColor(i));
    }

    public void setTextSpacing(int i) {
        if (i < this.f1205i) {
            i = this.f1205i;
        }
        super.setTextSpacing(i);
    }
}
