package android.support.p004v7.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.p001v4.graphics.drawable.DrawableCompat;
import android.support.p001v4.view.MotionEventCompat;
import android.support.p001v4.view.ViewCompat;
import android.support.p004v7.appcompat.C0505R;
import android.support.p004v7.text.AllCapsTransformationMethod;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.CompoundButton;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import p006nl.volkerinfradesign.checkandroid.database.LogTable;

/* renamed from: android.support.v7.widget.SwitchCompat */
public class SwitchCompat extends CompoundButton {

    /* renamed from: F */
    private static final int[] f2263F = {16842912};

    /* renamed from: A */
    private Layout f2264A;

    /* renamed from: B */
    private TransformationMethod f2265B;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public C0587a f2266C;

    /* renamed from: D */
    private final Rect f2267D;

    /* renamed from: E */
    private final TintManager f2268E;

    /* renamed from: a */
    private Drawable f2269a;

    /* renamed from: b */
    private Drawable f2270b;

    /* renamed from: c */
    private int f2271c;

    /* renamed from: d */
    private int f2272d;

    /* renamed from: e */
    private int f2273e;

    /* renamed from: f */
    private boolean f2274f;

    /* renamed from: g */
    private CharSequence f2275g;

    /* renamed from: h */
    private CharSequence f2276h;

    /* renamed from: i */
    private boolean f2277i;

    /* renamed from: j */
    private int f2278j;

    /* renamed from: k */
    private int f2279k;

    /* renamed from: l */
    private float f2280l;

    /* renamed from: m */
    private float f2281m;

    /* renamed from: n */
    private VelocityTracker f2282n;

    /* renamed from: o */
    private int f2283o;

    /* renamed from: p */
    private float f2284p;

    /* renamed from: q */
    private int f2285q;

    /* renamed from: r */
    private int f2286r;

    /* renamed from: s */
    private int f2287s;

    /* renamed from: t */
    private int f2288t;

    /* renamed from: u */
    private int f2289u;

    /* renamed from: v */
    private int f2290v;

    /* renamed from: w */
    private int f2291w;

    /* renamed from: x */
    private TextPaint f2292x;

    /* renamed from: y */
    private ColorStateList f2293y;

    /* renamed from: z */
    private Layout f2294z;

    public SwitchCompat(Context context) {
        this(context, (AttributeSet) null);
    }

    public SwitchCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0505R.attr.switchStyle);
    }

    public SwitchCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2282n = VelocityTracker.obtain();
        this.f2267D = new Rect();
        this.f2292x = new TextPaint(1);
        Resources resources = getResources();
        this.f2292x.density = resources.getDisplayMetrics().density;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, C0505R.styleable.SwitchCompat, i, 0);
        this.f2269a = obtainStyledAttributes.getDrawable(C0505R.styleable.SwitchCompat_android_thumb);
        if (this.f2269a != null) {
            this.f2269a.setCallback(this);
        }
        this.f2270b = obtainStyledAttributes.getDrawable(C0505R.styleable.SwitchCompat_track);
        if (this.f2270b != null) {
            this.f2270b.setCallback(this);
        }
        this.f2275g = obtainStyledAttributes.getText(C0505R.styleable.SwitchCompat_android_textOn);
        this.f2276h = obtainStyledAttributes.getText(C0505R.styleable.SwitchCompat_android_textOff);
        this.f2277i = obtainStyledAttributes.getBoolean(C0505R.styleable.SwitchCompat_showText, true);
        this.f2271c = obtainStyledAttributes.getDimensionPixelSize(C0505R.styleable.SwitchCompat_thumbTextPadding, 0);
        this.f2272d = obtainStyledAttributes.getDimensionPixelSize(C0505R.styleable.SwitchCompat_switchMinWidth, 0);
        this.f2273e = obtainStyledAttributes.getDimensionPixelSize(C0505R.styleable.SwitchCompat_switchPadding, 0);
        this.f2274f = obtainStyledAttributes.getBoolean(C0505R.styleable.SwitchCompat_splitTrack, false);
        int resourceId = obtainStyledAttributes.getResourceId(C0505R.styleable.SwitchCompat_switchTextAppearance, 0);
        if (resourceId != 0) {
            setSwitchTextAppearance(context, resourceId);
        }
        this.f2268E = obtainStyledAttributes.getTintManager();
        obtainStyledAttributes.recycle();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f2279k = viewConfiguration.getScaledTouchSlop();
        this.f2283o = viewConfiguration.getScaledMinimumFlingVelocity();
        refreshDrawableState();
        setChecked(isChecked());
    }

    public void setSwitchTextAppearance(Context context, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, C0505R.styleable.TextAppearance);
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(C0505R.styleable.TextAppearance_android_textColor);
        if (colorStateList != null) {
            this.f2293y = colorStateList;
        } else {
            this.f2293y = getTextColors();
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(C0505R.styleable.TextAppearance_android_textSize, 0);
        if (!(dimensionPixelSize == 0 || ((float) dimensionPixelSize) == this.f2292x.getTextSize())) {
            this.f2292x.setTextSize((float) dimensionPixelSize);
            requestLayout();
        }
        m3328a(obtainStyledAttributes.getInt(C0505R.styleable.TextAppearance_android_typeface, -1), obtainStyledAttributes.getInt(C0505R.styleable.TextAppearance_android_textStyle, -1));
        if (obtainStyledAttributes.getBoolean(C0505R.styleable.TextAppearance_textAllCaps, false)) {
            this.f2265B = new AllCapsTransformationMethod(getContext());
        } else {
            this.f2265B = null;
        }
        obtainStyledAttributes.recycle();
    }

    /* renamed from: a */
    private void m3328a(int i, int i2) {
        Typeface typeface = null;
        switch (i) {
            case 1:
                typeface = Typeface.SANS_SERIF;
                break;
            case 2:
                typeface = Typeface.SERIF;
                break;
            case 3:
                typeface = Typeface.MONOSPACE;
                break;
        }
        setSwitchTypeface(typeface, i2);
    }

    public void setSwitchTypeface(Typeface typeface, int i) {
        Typeface create;
        int i2;
        float f;
        boolean z = false;
        if (i > 0) {
            if (typeface == null) {
                create = Typeface.defaultFromStyle(i);
            } else {
                create = Typeface.create(typeface, i);
            }
            setSwitchTypeface(create);
            if (create != null) {
                i2 = create.getStyle();
            } else {
                i2 = 0;
            }
            int i3 = (i2 ^ -1) & i;
            TextPaint textPaint = this.f2292x;
            if ((i3 & 1) != 0) {
                z = true;
            }
            textPaint.setFakeBoldText(z);
            TextPaint textPaint2 = this.f2292x;
            if ((i3 & 2) != 0) {
                f = -0.25f;
            } else {
                f = 0.0f;
            }
            textPaint2.setTextSkewX(f);
            return;
        }
        this.f2292x.setFakeBoldText(false);
        this.f2292x.setTextSkewX(BitmapDescriptorFactory.HUE_RED);
        setSwitchTypeface(typeface);
    }

    public void setSwitchTypeface(Typeface typeface) {
        if (this.f2292x.getTypeface() != typeface) {
            this.f2292x.setTypeface(typeface);
            requestLayout();
            invalidate();
        }
    }

    public void setSwitchPadding(int i) {
        this.f2273e = i;
        requestLayout();
    }

    public int getSwitchPadding() {
        return this.f2273e;
    }

    public void setSwitchMinWidth(int i) {
        this.f2272d = i;
        requestLayout();
    }

    public int getSwitchMinWidth() {
        return this.f2272d;
    }

    public void setThumbTextPadding(int i) {
        this.f2271c = i;
        requestLayout();
    }

    public int getThumbTextPadding() {
        return this.f2271c;
    }

    public void setTrackDrawable(Drawable drawable) {
        this.f2270b = drawable;
        requestLayout();
    }

    public void setTrackResource(int i) {
        setTrackDrawable(this.f2268E.getDrawable(i));
    }

    public Drawable getTrackDrawable() {
        return this.f2270b;
    }

    public void setThumbDrawable(Drawable drawable) {
        this.f2269a = drawable;
        requestLayout();
    }

    public void setThumbResource(int i) {
        setThumbDrawable(this.f2268E.getDrawable(i));
    }

    public Drawable getThumbDrawable() {
        return this.f2269a;
    }

    public void setSplitTrack(boolean z) {
        this.f2274f = z;
        invalidate();
    }

    public boolean getSplitTrack() {
        return this.f2274f;
    }

    public CharSequence getTextOn() {
        return this.f2275g;
    }

    public void setTextOn(CharSequence charSequence) {
        this.f2275g = charSequence;
        requestLayout();
    }

    public CharSequence getTextOff() {
        return this.f2276h;
    }

    public void setTextOff(CharSequence charSequence) {
        this.f2276h = charSequence;
        requestLayout();
    }

    public void setShowText(boolean z) {
        if (this.f2277i != z) {
            this.f2277i = z;
            requestLayout();
        }
    }

    public boolean getShowText() {
        return this.f2277i;
    }

    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6 = 0;
        if (this.f2277i) {
            if (this.f2294z == null) {
                this.f2294z = m3326a(this.f2275g);
            }
            if (this.f2264A == null) {
                this.f2264A = m3326a(this.f2276h);
            }
        }
        Rect rect = this.f2267D;
        if (this.f2269a != null) {
            this.f2269a.getPadding(rect);
            i4 = (this.f2269a.getIntrinsicWidth() - rect.left) - rect.right;
            i3 = this.f2269a.getIntrinsicHeight();
        } else {
            i3 = 0;
            i4 = 0;
        }
        if (this.f2277i) {
            i5 = Math.max(this.f2294z.getWidth(), this.f2264A.getWidth()) + (this.f2271c * 2);
        } else {
            i5 = 0;
        }
        this.f2287s = Math.max(i5, i4);
        if (this.f2270b != null) {
            this.f2270b.getPadding(rect);
            i6 = this.f2270b.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        int i7 = rect.left;
        int i8 = rect.right;
        if (this.f2269a != null) {
            Rect a = C1179gw.m5226a(this.f2269a);
            i7 = Math.max(i7, a.left);
            i8 = Math.max(i8, a.right);
        }
        int max = Math.max(this.f2272d, i8 + i7 + (this.f2287s * 2));
        int max2 = Math.max(i6, i3);
        this.f2285q = max;
        this.f2286r = max2;
        super.onMeasure(i, i2);
        if (getMeasuredHeight() < max2) {
            setMeasuredDimension(ViewCompat.getMeasuredWidthAndState(this), max2);
        }
    }

    @TargetApi(14)
    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        CharSequence charSequence = isChecked() ? this.f2275g : this.f2276h;
        if (charSequence != null) {
            accessibilityEvent.getText().add(charSequence);
        }
    }

    /* renamed from: a */
    private Layout m3326a(CharSequence charSequence) {
        CharSequence charSequence2;
        if (this.f2265B != null) {
            charSequence2 = this.f2265B.getTransformation(charSequence, this);
        } else {
            charSequence2 = charSequence;
        }
        return new StaticLayout(charSequence2, this.f2292x, charSequence2 != null ? (int) Math.ceil((double) Layout.getDesiredWidth(charSequence2, this.f2292x)) : 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, BitmapDescriptorFactory.HUE_RED, true);
    }

    /* renamed from: a */
    private boolean m3332a(float f, float f2) {
        if (this.f2269a == null) {
            return false;
        }
        int thumbOffset = getThumbOffset();
        this.f2269a.getPadding(this.f2267D);
        int i = this.f2289u - this.f2279k;
        int i2 = (thumbOffset + this.f2288t) - this.f2279k;
        int i3 = this.f2287s + i2 + this.f2267D.left + this.f2267D.right + this.f2279k;
        int i4 = this.f2291w + this.f2279k;
        if (f <= ((float) i2) || f >= ((float) i3) || f2 <= ((float) i) || f2 >= ((float) i4)) {
            return false;
        }
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        float f;
        this.f2282n.addMovement(motionEvent);
        switch (MotionEventCompat.getActionMasked(motionEvent)) {
            case 0:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (isEnabled() && m3332a(x, y)) {
                    this.f2278j = 1;
                    this.f2280l = x;
                    this.f2281m = y;
                    break;
                }
            case 1:
            case 3:
                if (this.f2278j != 2) {
                    this.f2278j = 0;
                    this.f2282n.clear();
                    break;
                } else {
                    m3333b(motionEvent);
                    super.onTouchEvent(motionEvent);
                    return true;
                }
            case 2:
                switch (this.f2278j) {
                    case 1:
                        float x2 = motionEvent.getX();
                        float y2 = motionEvent.getY();
                        if (Math.abs(x2 - this.f2280l) > ((float) this.f2279k) || Math.abs(y2 - this.f2281m) > ((float) this.f2279k)) {
                            this.f2278j = 2;
                            getParent().requestDisallowInterceptTouchEvent(true);
                            this.f2280l = x2;
                            this.f2281m = y2;
                            return true;
                        }
                    case 2:
                        float x3 = motionEvent.getX();
                        int thumbScrollRange = getThumbScrollRange();
                        float f2 = x3 - this.f2280l;
                        if (thumbScrollRange != 0) {
                            f = f2 / ((float) thumbScrollRange);
                        } else {
                            f = f2 > BitmapDescriptorFactory.HUE_RED ? 1.0f : -1.0f;
                        }
                        if (ViewUtils.isLayoutRtl(this)) {
                            f = -f;
                        }
                        float a = m3323a(f + this.f2284p, BitmapDescriptorFactory.HUE_RED, 1.0f);
                        if (a != this.f2284p) {
                            this.f2280l = x3;
                            setThumbPosition(a);
                        }
                        return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    /* renamed from: a */
    private void m3330a(MotionEvent motionEvent) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.setAction(3);
        super.onTouchEvent(obtain);
        obtain.recycle();
    }

    /* renamed from: b */
    private void m3333b(MotionEvent motionEvent) {
        boolean z = true;
        this.f2278j = 0;
        boolean z2 = motionEvent.getAction() == 1 && isEnabled();
        boolean isChecked = isChecked();
        if (z2) {
            this.f2282n.computeCurrentVelocity(LogTable.MAX_SIZE);
            float xVelocity = this.f2282n.getXVelocity();
            if (Math.abs(xVelocity) <= ((float) this.f2283o)) {
                z = getTargetCheckedState();
            } else if (ViewUtils.isLayoutRtl(this)) {
                if (xVelocity >= BitmapDescriptorFactory.HUE_RED) {
                    z = false;
                }
            } else if (xVelocity <= BitmapDescriptorFactory.HUE_RED) {
                z = false;
            }
        } else {
            z = isChecked;
        }
        if (z != isChecked) {
            playSoundEffect(0);
        }
        setChecked(z);
        m3330a(motionEvent);
    }

    /* renamed from: a */
    private void m3331a(final boolean z) {
        if (this.f2266C != null) {
            m3327a();
        }
        this.f2266C = new C0587a(this.f2284p, z ? 1.0f : BitmapDescriptorFactory.HUE_RED);
        this.f2266C.setDuration(250);
        this.f2266C.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                if (SwitchCompat.this.f2266C == animation) {
                    SwitchCompat.this.setThumbPosition(z ? 1.0f : BitmapDescriptorFactory.HUE_RED);
                    C0587a unused = SwitchCompat.this.f2266C = null;
                }
            }

            public void onAnimationRepeat(Animation animation) {
            }
        });
        startAnimation(this.f2266C);
    }

    /* renamed from: a */
    private void m3327a() {
        if (this.f2266C != null) {
            clearAnimation();
            this.f2266C = null;
        }
    }

    private boolean getTargetCheckedState() {
        return this.f2284p > 0.5f;
    }

    /* access modifiers changed from: private */
    public void setThumbPosition(float f) {
        this.f2284p = f;
        invalidate();
    }

    public void toggle() {
        setChecked(!isChecked());
    }

    public void setChecked(boolean z) {
        super.setChecked(z);
        boolean isChecked = isChecked();
        if (getWindowToken() == null || !ViewCompat.isLaidOut(this) || !isShown()) {
            m3327a();
            setThumbPosition(isChecked ? 1.0f : BitmapDescriptorFactory.HUE_RED);
            return;
        }
        m3331a(isChecked);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int height;
        int i8;
        int i9 = 0;
        super.onLayout(z, i, i2, i3, i4);
        if (this.f2269a != null) {
            Rect rect = this.f2267D;
            if (this.f2270b != null) {
                this.f2270b.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect a = C1179gw.m5226a(this.f2269a);
            i5 = Math.max(0, a.left - rect.left);
            i9 = Math.max(0, a.right - rect.right);
        } else {
            i5 = 0;
        }
        if (ViewUtils.isLayoutRtl(this)) {
            int paddingLeft = getPaddingLeft() + i5;
            i7 = ((this.f2285q + paddingLeft) - i5) - i9;
            i6 = paddingLeft;
        } else {
            int width = (getWidth() - getPaddingRight()) - i9;
            i6 = i9 + i5 + (width - this.f2285q);
            i7 = width;
        }
        switch (getGravity() & 112) {
            case 16:
                i8 = (((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2) - (this.f2286r / 2);
                height = this.f2286r + i8;
                break;
            case 80:
                height = getHeight() - getPaddingBottom();
                i8 = height - this.f2286r;
                break;
            default:
                i8 = getPaddingTop();
                height = this.f2286r + i8;
                break;
        }
        this.f2288t = i6;
        this.f2289u = i8;
        this.f2291w = height;
        this.f2290v = i7;
    }

    public void draw(Canvas canvas) {
        Rect rect;
        int i;
        int i2;
        int i3;
        Rect rect2 = this.f2267D;
        int i4 = this.f2288t;
        int i5 = this.f2289u;
        int i6 = this.f2290v;
        int i7 = this.f2291w;
        int thumbOffset = i4 + getThumbOffset();
        if (this.f2269a != null) {
            rect = C1179gw.m5226a(this.f2269a);
        } else {
            rect = C1179gw.f4200a;
        }
        if (this.f2270b != null) {
            this.f2270b.getPadding(rect2);
            int i8 = rect2.left + thumbOffset;
            if (rect != null) {
                if (rect.left > rect2.left) {
                    i4 += rect.left - rect2.left;
                }
                if (rect.top > rect2.top) {
                    i3 = (rect.top - rect2.top) + i5;
                } else {
                    i3 = i5;
                }
                if (rect.right > rect2.right) {
                    i6 -= rect.right - rect2.right;
                }
                i2 = rect.bottom > rect2.bottom ? i7 - (rect.bottom - rect2.bottom) : i7;
            } else {
                i2 = i7;
                i3 = i5;
            }
            this.f2270b.setBounds(i4, i3, i6, i2);
            i = i8;
        } else {
            i = thumbOffset;
        }
        if (this.f2269a != null) {
            this.f2269a.getPadding(rect2);
            int i9 = i - rect2.left;
            int i10 = i + this.f2287s + rect2.right;
            this.f2269a.setBounds(i9, i5, i10, i7);
            Drawable background = getBackground();
            if (background != null) {
                DrawableCompat.setHotspotBounds(background, i9, i5, i10, i7);
            }
        }
        super.draw(canvas);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int width;
        super.onDraw(canvas);
        Rect rect = this.f2267D;
        Drawable drawable = this.f2270b;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i = this.f2289u;
        int i2 = this.f2291w;
        int i3 = i + rect.top;
        int i4 = i2 - rect.bottom;
        Drawable drawable2 = this.f2269a;
        if (drawable != null) {
            if (!this.f2274f || drawable2 == null) {
                drawable.draw(canvas);
            } else {
                Rect a = C1179gw.m5226a(drawable2);
                drawable2.copyBounds(rect);
                rect.left += a.left;
                rect.right -= a.right;
                int save = canvas.save();
                canvas.clipRect(rect, Region.Op.DIFFERENCE);
                drawable.draw(canvas);
                canvas.restoreToCount(save);
            }
        }
        int save2 = canvas.save();
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        Layout layout = getTargetCheckedState() ? this.f2294z : this.f2264A;
        if (layout != null) {
            int[] drawableState = getDrawableState();
            if (this.f2293y != null) {
                this.f2292x.setColor(this.f2293y.getColorForState(drawableState, 0));
            }
            this.f2292x.drawableState = drawableState;
            if (drawable2 != null) {
                Rect bounds = drawable2.getBounds();
                width = bounds.right + bounds.left;
            } else {
                width = getWidth();
            }
            canvas.translate((float) ((width / 2) - (layout.getWidth() / 2)), (float) (((i3 + i4) / 2) - (layout.getHeight() / 2)));
            layout.draw(canvas);
        }
        canvas.restoreToCount(save2);
    }

    public int getCompoundPaddingLeft() {
        if (!ViewUtils.isLayoutRtl(this)) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.f2285q;
        if (!TextUtils.isEmpty(getText())) {
            return compoundPaddingLeft + this.f2273e;
        }
        return compoundPaddingLeft;
    }

    public int getCompoundPaddingRight() {
        if (ViewUtils.isLayoutRtl(this)) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.f2285q;
        if (!TextUtils.isEmpty(getText())) {
            return compoundPaddingRight + this.f2273e;
        }
        return compoundPaddingRight;
    }

    private int getThumbOffset() {
        float f;
        if (ViewUtils.isLayoutRtl(this)) {
            f = 1.0f - this.f2284p;
        } else {
            f = this.f2284p;
        }
        return (int) ((f * ((float) getThumbScrollRange())) + 0.5f);
    }

    private int getThumbScrollRange() {
        Rect rect;
        if (this.f2270b == null) {
            return 0;
        }
        Rect rect2 = this.f2267D;
        this.f2270b.getPadding(rect2);
        if (this.f2269a != null) {
            rect = C1179gw.m5226a(this.f2269a);
        } else {
            rect = C1179gw.f4200a;
        }
        return ((((this.f2285q - this.f2287s) - rect2.left) - rect2.right) - rect.left) - rect.right;
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (isChecked()) {
            mergeDrawableStates(onCreateDrawableState, f2263F);
        }
        return onCreateDrawableState;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        if (this.f2269a != null) {
            this.f2269a.setState(drawableState);
        }
        if (this.f2270b != null) {
            this.f2270b.setState(drawableState);
        }
        invalidate();
    }

    public void drawableHotspotChanged(float f, float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            super.drawableHotspotChanged(f, f2);
        }
        if (this.f2269a != null) {
            DrawableCompat.setHotspot(this.f2269a, f, f2);
        }
        if (this.f2270b != null) {
            DrawableCompat.setHotspot(this.f2270b, f, f2);
        }
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f2269a || drawable == this.f2270b;
    }

    public void jumpDrawablesToCurrentState() {
        if (Build.VERSION.SDK_INT >= 11) {
            super.jumpDrawablesToCurrentState();
            if (this.f2269a != null) {
                this.f2269a.jumpToCurrentState();
            }
            if (this.f2270b != null) {
                this.f2270b.jumpToCurrentState();
            }
            m3327a();
        }
    }

    @TargetApi(14)
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("android.widget.Switch");
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (Build.VERSION.SDK_INT >= 14) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName("android.widget.Switch");
            CharSequence charSequence = isChecked() ? this.f2275g : this.f2276h;
            if (!TextUtils.isEmpty(charSequence)) {
                CharSequence text = accessibilityNodeInfo.getText();
                if (TextUtils.isEmpty(text)) {
                    accessibilityNodeInfo.setText(charSequence);
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(text).append(' ').append(charSequence);
                accessibilityNodeInfo.setText(sb);
            }
        }
    }

    /* renamed from: a */
    private static float m3323a(float f, float f2, float f3) {
        if (f < f2) {
            return f2;
        }
        return f > f3 ? f3 : f;
    }

    /* renamed from: android.support.v7.widget.SwitchCompat$a */
    class C0587a extends Animation {

        /* renamed from: a */
        final float f2297a;

        /* renamed from: b */
        final float f2298b;

        /* renamed from: c */
        final float f2299c;

        private C0587a(float f, float f2) {
            this.f2297a = f;
            this.f2298b = f2;
            this.f2299c = f2 - f;
        }

        /* access modifiers changed from: protected */
        public void applyTransformation(float f, Transformation transformation) {
            SwitchCompat.this.setThumbPosition(this.f2297a + (this.f2299c * f));
        }
    }
}
