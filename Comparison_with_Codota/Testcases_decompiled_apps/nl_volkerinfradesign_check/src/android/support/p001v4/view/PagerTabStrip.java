package android.support.p001v4.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

/* renamed from: android.support.v4.view.PagerTabStrip */
public class PagerTabStrip extends PagerTitleStrip {

    /* renamed from: f */
    private int f943f;

    /* renamed from: g */
    private int f944g;

    /* renamed from: h */
    private int f945h;

    /* renamed from: i */
    private int f946i;

    /* renamed from: j */
    private int f947j;

    /* renamed from: k */
    private int f948k;

    /* renamed from: l */
    private final Paint f949l;

    /* renamed from: m */
    private final Rect f950m;

    /* renamed from: n */
    private int f951n;

    /* renamed from: o */
    private boolean f952o;

    /* renamed from: p */
    private boolean f953p;

    /* renamed from: q */
    private int f954q;

    /* renamed from: r */
    private boolean f955r;

    /* renamed from: s */
    private float f956s;

    /* renamed from: t */
    private float f957t;

    /* renamed from: u */
    private int f958u;

    public PagerTabStrip(Context context) {
        this(context, (AttributeSet) null);
    }

    public PagerTabStrip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f949l = new Paint();
        this.f950m = new Rect();
        this.f951n = 255;
        this.f952o = false;
        this.f953p = false;
        this.f943f = this.f968e;
        this.f949l.setColor(this.f943f);
        float f = context.getResources().getDisplayMetrics().density;
        this.f944g = (int) ((3.0f * f) + 0.5f);
        this.f945h = (int) ((6.0f * f) + 0.5f);
        this.f946i = (int) (64.0f * f);
        this.f948k = (int) ((16.0f * f) + 0.5f);
        this.f954q = (int) ((1.0f * f) + 0.5f);
        this.f947j = (int) ((f * 32.0f) + 0.5f);
        this.f958u = ViewConfiguration.get(context).getScaledTouchSlop();
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        setTextSpacing(getTextSpacing());
        setWillNotDraw(false);
        this.f965b.setFocusable(true);
        this.f965b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                PagerTabStrip.this.f964a.setCurrentItem(PagerTabStrip.this.f964a.getCurrentItem() - 1);
            }
        });
        this.f967d.setFocusable(true);
        this.f967d.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                PagerTabStrip.this.f964a.setCurrentItem(PagerTabStrip.this.f964a.getCurrentItem() + 1);
            }
        });
        if (getBackground() == null) {
            this.f952o = true;
        }
    }

    public void setTabIndicatorColor(@ColorInt int i) {
        this.f943f = i;
        this.f949l.setColor(this.f943f);
        invalidate();
    }

    public void setTabIndicatorColorResource(@ColorRes int i) {
        setTabIndicatorColor(getContext().getResources().getColor(i));
    }

    @ColorInt
    public int getTabIndicatorColor() {
        return this.f943f;
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        if (i4 < this.f945h) {
            i4 = this.f945h;
        }
        super.setPadding(i, i2, i3, i4);
    }

    public void setTextSpacing(int i) {
        if (i < this.f946i) {
            i = this.f946i;
        }
        super.setTextSpacing(i);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (!this.f953p) {
            this.f952o = drawable == null;
        }
    }

    public void setBackgroundColor(@ColorInt int i) {
        super.setBackgroundColor(i);
        if (!this.f953p) {
            this.f952o = (-16777216 & i) == 0;
        }
    }

    public void setBackgroundResource(@DrawableRes int i) {
        super.setBackgroundResource(i);
        if (!this.f953p) {
            this.f952o = i == 0;
        }
    }

    public void setDrawFullUnderline(boolean z) {
        this.f952o = z;
        this.f953p = true;
        invalidate();
    }

    public boolean getDrawFullUnderline() {
        return this.f952o;
    }

    /* access modifiers changed from: package-private */
    public int getMinHeight() {
        return Math.max(super.getMinHeight(), this.f947j);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0 && this.f955r) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        switch (action) {
            case 0:
                this.f956s = x;
                this.f957t = y;
                this.f955r = false;
                break;
            case 1:
                if (x >= ((float) (this.f966c.getLeft() - this.f948k))) {
                    if (x > ((float) (this.f966c.getRight() + this.f948k))) {
                        this.f964a.setCurrentItem(this.f964a.getCurrentItem() + 1);
                        break;
                    }
                } else {
                    this.f964a.setCurrentItem(this.f964a.getCurrentItem() - 1);
                    break;
                }
                break;
            case 2:
                if (Math.abs(x - this.f956s) > ((float) this.f958u) || Math.abs(y - this.f957t) > ((float) this.f958u)) {
                    this.f955r = true;
                    break;
                }
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        int left = this.f966c.getLeft() - this.f948k;
        int right = this.f966c.getRight() + this.f948k;
        int i = height - this.f944g;
        this.f949l.setColor((this.f951n << 24) | (this.f943f & ViewCompat.MEASURED_SIZE_MASK));
        canvas.drawRect((float) left, (float) i, (float) right, (float) height, this.f949l);
        if (this.f952o) {
            this.f949l.setColor(-16777216 | (this.f943f & ViewCompat.MEASURED_SIZE_MASK));
            canvas.drawRect((float) getPaddingLeft(), (float) (height - this.f954q), (float) (getWidth() - getPaddingRight()), (float) height, this.f949l);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo1842a(int i, float f, boolean z) {
        Rect rect = this.f950m;
        int height = getHeight();
        int left = this.f966c.getLeft() - this.f948k;
        int right = this.f966c.getRight() + this.f948k;
        int i2 = height - this.f944g;
        rect.set(left, i2, right, height);
        super.mo1842a(i, f, z);
        this.f951n = (int) (Math.abs(f - 0.5f) * 2.0f * 255.0f);
        rect.union(this.f966c.getLeft() - this.f948k, i2, this.f966c.getRight() + this.f948k, height);
        invalidate(rect);
    }
}
