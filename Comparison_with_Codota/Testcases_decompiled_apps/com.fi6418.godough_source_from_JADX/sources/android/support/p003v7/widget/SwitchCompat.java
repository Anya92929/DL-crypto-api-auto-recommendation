package android.support.p003v7.widget;

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
import android.support.p000v4.graphics.drawable.DrawableCompat;
import android.support.p000v4.view.MotionEventCompat;
import android.support.p000v4.view.ViewCompat;
import android.support.p003v7.appcompat.C0235R;
import android.support.p003v7.internal.text.AllCapsTransformationMethod;
import android.support.p003v7.internal.widget.DrawableUtils;
import android.support.p003v7.internal.widget.TintManager;
import android.support.p003v7.internal.widget.TintTypedArray;
import android.support.p003v7.internal.widget.ViewUtils;
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

/* renamed from: android.support.v7.widget.SwitchCompat */
public class SwitchCompat extends CompoundButton {

    /* renamed from: F */
    private static final int[] f3201F = {16842912};

    /* renamed from: A */
    private Layout f3202A;

    /* renamed from: B */
    private TransformationMethod f3203B;

    /* renamed from: C */
    private ThumbAnimation f3204C;

    /* renamed from: D */
    private final Rect f3205D;

    /* renamed from: E */
    private final TintManager f3206E;

    /* renamed from: a */
    private Drawable f3207a;

    /* renamed from: b */
    private Drawable f3208b;

    /* renamed from: c */
    private int f3209c;

    /* renamed from: d */
    private int f3210d;

    /* renamed from: e */
    private int f3211e;

    /* renamed from: f */
    private boolean f3212f;

    /* renamed from: g */
    private CharSequence f3213g;

    /* renamed from: h */
    private CharSequence f3214h;

    /* renamed from: i */
    private boolean f3215i;

    /* renamed from: j */
    private int f3216j;

    /* renamed from: k */
    private int f3217k;

    /* renamed from: l */
    private float f3218l;

    /* renamed from: m */
    private float f3219m;

    /* renamed from: n */
    private VelocityTracker f3220n;

    /* renamed from: o */
    private int f3221o;

    /* renamed from: p */
    private float f3222p;

    /* renamed from: q */
    private int f3223q;

    /* renamed from: r */
    private int f3224r;

    /* renamed from: s */
    private int f3225s;

    /* renamed from: t */
    private int f3226t;

    /* renamed from: u */
    private int f3227u;

    /* renamed from: v */
    private int f3228v;

    /* renamed from: w */
    private int f3229w;

    /* renamed from: x */
    private TextPaint f3230x;

    /* renamed from: y */
    private ColorStateList f3231y;

    /* renamed from: z */
    private Layout f3232z;

    /* renamed from: android.support.v7.widget.SwitchCompat$ThumbAnimation */
    class ThumbAnimation extends Animation {

        /* renamed from: a */
        final float f3233a;

        /* renamed from: b */
        final float f3234b;

        /* renamed from: c */
        final float f3235c;

        private ThumbAnimation(float f, float f2) {
            this.f3233a = f;
            this.f3234b = f2;
            this.f3235c = f2 - f;
        }

        /* access modifiers changed from: protected */
        public void applyTransformation(float f, Transformation transformation) {
            SwitchCompat.this.setThumbPosition(this.f3233a + (this.f3235c * f));
        }
    }

    public SwitchCompat(Context context) {
        this(context, (AttributeSet) null);
    }

    public SwitchCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0235R.attr.switchStyle);
    }

    public SwitchCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3220n = VelocityTracker.obtain();
        this.f3205D = new Rect();
        this.f3230x = new TextPaint(1);
        Resources resources = getResources();
        this.f3230x.density = resources.getDisplayMetrics().density;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, C0235R.styleable.SwitchCompat, i, 0);
        this.f3207a = obtainStyledAttributes.getDrawable(C0235R.styleable.SwitchCompat_android_thumb);
        if (this.f3207a != null) {
            this.f3207a.setCallback(this);
        }
        this.f3208b = obtainStyledAttributes.getDrawable(C0235R.styleable.SwitchCompat_track);
        if (this.f3208b != null) {
            this.f3208b.setCallback(this);
        }
        this.f3213g = obtainStyledAttributes.getText(C0235R.styleable.SwitchCompat_android_textOn);
        this.f3214h = obtainStyledAttributes.getText(C0235R.styleable.SwitchCompat_android_textOff);
        this.f3215i = obtainStyledAttributes.getBoolean(C0235R.styleable.SwitchCompat_showText, true);
        this.f3209c = obtainStyledAttributes.getDimensionPixelSize(C0235R.styleable.SwitchCompat_thumbTextPadding, 0);
        this.f3210d = obtainStyledAttributes.getDimensionPixelSize(C0235R.styleable.SwitchCompat_switchMinWidth, 0);
        this.f3211e = obtainStyledAttributes.getDimensionPixelSize(C0235R.styleable.SwitchCompat_switchPadding, 0);
        this.f3212f = obtainStyledAttributes.getBoolean(C0235R.styleable.SwitchCompat_splitTrack, false);
        int resourceId = obtainStyledAttributes.getResourceId(C0235R.styleable.SwitchCompat_switchTextAppearance, 0);
        if (resourceId != 0) {
            setSwitchTextAppearance(context, resourceId);
        }
        this.f3206E = obtainStyledAttributes.getTintManager();
        obtainStyledAttributes.recycle();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f3217k = viewConfiguration.getScaledTouchSlop();
        this.f3221o = viewConfiguration.getScaledMinimumFlingVelocity();
        refreshDrawableState();
        setChecked(isChecked());
    }

    /* renamed from: a */
    private static float m2363a(float f, float f2, float f3) {
        return f < f2 ? f2 : f > f3 ? f3 : f;
    }

    /* renamed from: a */
    private Layout m2364a(CharSequence charSequence) {
        CharSequence transformation = this.f3203B != null ? this.f3203B.getTransformation(charSequence, this) : charSequence;
        return new StaticLayout(transformation, this.f3230x, transformation != null ? (int) Math.ceil((double) Layout.getDesiredWidth(transformation, this.f3230x)) : 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, BitmapDescriptorFactory.HUE_RED, true);
    }

    /* renamed from: a */
    private void m2365a() {
        if (this.f3204C != null) {
            clearAnimation();
            this.f3204C = null;
        }
    }

    /* renamed from: a */
    private void m2366a(int i, int i2) {
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

    /* renamed from: a */
    private void m2368a(MotionEvent motionEvent) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.setAction(3);
        super.onTouchEvent(obtain);
        obtain.recycle();
    }

    /* renamed from: a */
    private void m2369a(boolean z) {
        this.f3204C = new ThumbAnimation(this.f3222p, z ? 1.0f : BitmapDescriptorFactory.HUE_RED);
        this.f3204C.setDuration(250);
        startAnimation(this.f3204C);
    }

    /* renamed from: a */
    private boolean m2370a(float f, float f2) {
        if (this.f3207a == null) {
            return false;
        }
        int thumbOffset = getThumbOffset();
        this.f3207a.getPadding(this.f3205D);
        int i = this.f3227u - this.f3217k;
        int i2 = (thumbOffset + this.f3226t) - this.f3217k;
        return f > ((float) i2) && f < ((float) ((((this.f3225s + i2) + this.f3205D.left) + this.f3205D.right) + this.f3217k)) && f2 > ((float) i) && f2 < ((float) (this.f3229w + this.f3217k));
    }

    /* renamed from: b */
    private void m2371b(MotionEvent motionEvent) {
        boolean z = true;
        this.f3216j = 0;
        boolean z2 = motionEvent.getAction() == 1 && isEnabled();
        boolean isChecked = isChecked();
        if (z2) {
            this.f3220n.computeCurrentVelocity(1000);
            float xVelocity = this.f3220n.getXVelocity();
            if (Math.abs(xVelocity) <= ((float) this.f3221o)) {
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
            setChecked(z);
        }
        m2368a(motionEvent);
    }

    private boolean getTargetCheckedState() {
        return this.f3222p > 0.5f;
    }

    private int getThumbOffset() {
        return (int) (((ViewUtils.isLayoutRtl(this) ? 1.0f - this.f3222p : this.f3222p) * ((float) getThumbScrollRange())) + 0.5f);
    }

    private int getThumbScrollRange() {
        if (this.f3208b == null) {
            return 0;
        }
        Rect rect = this.f3205D;
        this.f3208b.getPadding(rect);
        Rect opticalBounds = this.f3207a != null ? DrawableUtils.getOpticalBounds(this.f3207a) : DrawableUtils.INSETS_NONE;
        return ((((this.f3223q - this.f3225s) - rect.left) - rect.right) - opticalBounds.left) - opticalBounds.right;
    }

    /* access modifiers changed from: private */
    public void setThumbPosition(float f) {
        this.f3222p = f;
        invalidate();
    }

    public void draw(Canvas canvas) {
        int i;
        int i2;
        int i3;
        Rect rect = this.f3205D;
        int i4 = this.f3226t;
        int i5 = this.f3227u;
        int i6 = this.f3228v;
        int i7 = this.f3229w;
        int thumbOffset = i4 + getThumbOffset();
        Rect opticalBounds = this.f3207a != null ? DrawableUtils.getOpticalBounds(this.f3207a) : DrawableUtils.INSETS_NONE;
        if (this.f3208b != null) {
            this.f3208b.getPadding(rect);
            int i8 = rect.left + thumbOffset;
            if (opticalBounds == null || opticalBounds.isEmpty()) {
                i2 = i7;
                i3 = i5;
            } else {
                if (opticalBounds.left > rect.left) {
                    i4 += opticalBounds.left - rect.left;
                }
                i3 = opticalBounds.top > rect.top ? (opticalBounds.top - rect.top) + i5 : i5;
                if (opticalBounds.right > rect.right) {
                    i6 -= opticalBounds.right - rect.right;
                }
                i2 = opticalBounds.bottom > rect.bottom ? i7 - (opticalBounds.bottom - rect.bottom) : i7;
            }
            this.f3208b.setBounds(i4, i3, i6, i2);
            i = i8;
        } else {
            i = thumbOffset;
        }
        if (this.f3207a != null) {
            this.f3207a.getPadding(rect);
            int i9 = i - rect.left;
            int i10 = i + this.f3225s + rect.right;
            this.f3207a.setBounds(i9, i5, i10, i7);
            Drawable background = getBackground();
            if (background != null) {
                DrawableCompat.setHotspotBounds(background, i9, i5, i10, i7);
            }
        }
        super.draw(canvas);
    }

    public void drawableHotspotChanged(float f, float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            super.drawableHotspotChanged(f, f2);
        }
        if (this.f3207a != null) {
            DrawableCompat.setHotspot(this.f3207a, f, f2);
        }
        if (this.f3208b != null) {
            DrawableCompat.setHotspot(this.f3208b, f, f2);
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        if (this.f3207a != null) {
            this.f3207a.setState(drawableState);
        }
        if (this.f3208b != null) {
            this.f3208b.setState(drawableState);
        }
        invalidate();
    }

    public int getCompoundPaddingLeft() {
        if (!ViewUtils.isLayoutRtl(this)) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.f3223q;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingLeft + this.f3211e : compoundPaddingLeft;
    }

    public int getCompoundPaddingRight() {
        if (ViewUtils.isLayoutRtl(this)) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.f3223q;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingRight + this.f3211e : compoundPaddingRight;
    }

    public boolean getShowText() {
        return this.f3215i;
    }

    public boolean getSplitTrack() {
        return this.f3212f;
    }

    public int getSwitchMinWidth() {
        return this.f3210d;
    }

    public int getSwitchPadding() {
        return this.f3211e;
    }

    public CharSequence getTextOff() {
        return this.f3214h;
    }

    public CharSequence getTextOn() {
        return this.f3213g;
    }

    public Drawable getThumbDrawable() {
        return this.f3207a;
    }

    public int getThumbTextPadding() {
        return this.f3209c;
    }

    public Drawable getTrackDrawable() {
        return this.f3208b;
    }

    public void jumpDrawablesToCurrentState() {
        if (Build.VERSION.SDK_INT >= 11) {
            super.jumpDrawablesToCurrentState();
            if (this.f3207a != null) {
                this.f3207a.jumpToCurrentState();
            }
            if (this.f3208b != null) {
                this.f3208b.jumpToCurrentState();
            }
            if (this.f3204C != null && !this.f3204C.hasEnded()) {
                clearAnimation();
                setThumbPosition(this.f3204C.f3234b);
                this.f3204C = null;
            }
        }
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (isChecked()) {
            mergeDrawableStates(onCreateDrawableState, f3201F);
        }
        return onCreateDrawableState;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int width;
        super.onDraw(canvas);
        Rect rect = this.f3205D;
        Drawable drawable = this.f3208b;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i = this.f3227u;
        int i2 = this.f3229w;
        int i3 = i + rect.top;
        int i4 = i2 - rect.bottom;
        Drawable drawable2 = this.f3207a;
        if (drawable != null) {
            if (!this.f3212f || drawable2 == null) {
                drawable.draw(canvas);
            } else {
                Rect opticalBounds = DrawableUtils.getOpticalBounds(drawable2);
                drawable2.copyBounds(rect);
                rect.left += opticalBounds.left;
                rect.right -= opticalBounds.right;
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
        Layout layout = getTargetCheckedState() ? this.f3232z : this.f3202A;
        if (layout != null) {
            int[] drawableState = getDrawableState();
            if (this.f3231y != null) {
                this.f3230x.setColor(this.f3231y.getColorForState(drawableState, 0));
            }
            this.f3230x.drawableState = drawableState;
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

    @TargetApi(14)
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("android.widget.Switch");
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (Build.VERSION.SDK_INT >= 14) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName("android.widget.Switch");
            CharSequence charSequence = isChecked() ? this.f3213g : this.f3214h;
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

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int height;
        int i8;
        int i9 = 0;
        super.onLayout(z, i, i2, i3, i4);
        if (this.f3207a != null) {
            Rect rect = this.f3205D;
            if (this.f3208b != null) {
                this.f3208b.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect opticalBounds = DrawableUtils.getOpticalBounds(this.f3207a);
            i5 = Math.max(0, opticalBounds.left - rect.left);
            i9 = Math.max(0, opticalBounds.right - rect.right);
        } else {
            i5 = 0;
        }
        if (ViewUtils.isLayoutRtl(this)) {
            int paddingLeft = getPaddingLeft() + i5;
            i7 = ((this.f3223q + paddingLeft) - i5) - i9;
            i6 = paddingLeft;
        } else {
            int width = (getWidth() - getPaddingRight()) - i9;
            i6 = i9 + i5 + (width - this.f3223q);
            i7 = width;
        }
        switch (getGravity() & 112) {
            case 16:
                i8 = (((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2) - (this.f3224r / 2);
                height = this.f3224r + i8;
                break;
            case 80:
                height = getHeight() - getPaddingBottom();
                i8 = height - this.f3224r;
                break;
            default:
                i8 = getPaddingTop();
                height = this.f3224r + i8;
                break;
        }
        this.f3226t = i6;
        this.f3227u = i8;
        this.f3229w = height;
        this.f3228v = i7;
    }

    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5 = 0;
        if (this.f3215i) {
            if (this.f3232z == null) {
                this.f3232z = m2364a(this.f3213g);
            }
            if (this.f3202A == null) {
                this.f3202A = m2364a(this.f3214h);
            }
        }
        Rect rect = this.f3205D;
        if (this.f3207a != null) {
            this.f3207a.getPadding(rect);
            i4 = (this.f3207a.getIntrinsicWidth() - rect.left) - rect.right;
            i3 = this.f3207a.getIntrinsicHeight();
        } else {
            i3 = 0;
            i4 = 0;
        }
        this.f3225s = Math.max(this.f3215i ? Math.max(this.f3232z.getWidth(), this.f3202A.getWidth()) + (this.f3209c * 2) : 0, i4);
        if (this.f3208b != null) {
            this.f3208b.getPadding(rect);
            i5 = this.f3208b.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        int i6 = rect.left;
        int i7 = rect.right;
        if (this.f3207a != null) {
            Rect opticalBounds = DrawableUtils.getOpticalBounds(this.f3207a);
            i6 = Math.max(i6, opticalBounds.left);
            i7 = Math.max(i7, opticalBounds.right);
        }
        int max = Math.max(this.f3210d, i7 + i6 + (this.f3225s * 2));
        int max2 = Math.max(i5, i3);
        this.f3223q = max;
        this.f3224r = max2;
        super.onMeasure(i, i2);
        if (getMeasuredHeight() < max2) {
            setMeasuredDimension(ViewCompat.getMeasuredWidthAndState(this), max2);
        }
    }

    @TargetApi(14)
    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        CharSequence charSequence = isChecked() ? this.f3213g : this.f3214h;
        if (charSequence != null) {
            accessibilityEvent.getText().add(charSequence);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f3220n.addMovement(motionEvent);
        switch (MotionEventCompat.getActionMasked(motionEvent)) {
            case 0:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (isEnabled() && m2370a(x, y)) {
                    this.f3216j = 1;
                    this.f3218l = x;
                    this.f3219m = y;
                    break;
                }
            case 1:
            case 3:
                if (this.f3216j != 2) {
                    this.f3216j = 0;
                    this.f3220n.clear();
                    break;
                } else {
                    m2371b(motionEvent);
                    super.onTouchEvent(motionEvent);
                    return true;
                }
            case 2:
                switch (this.f3216j) {
                    case 1:
                        float x2 = motionEvent.getX();
                        float y2 = motionEvent.getY();
                        if (Math.abs(x2 - this.f3218l) > ((float) this.f3217k) || Math.abs(y2 - this.f3219m) > ((float) this.f3217k)) {
                            this.f3216j = 2;
                            getParent().requestDisallowInterceptTouchEvent(true);
                            this.f3218l = x2;
                            this.f3219m = y2;
                            return true;
                        }
                    case 2:
                        float x3 = motionEvent.getX();
                        int thumbScrollRange = getThumbScrollRange();
                        float f = x3 - this.f3218l;
                        float f2 = thumbScrollRange != 0 ? f / ((float) thumbScrollRange) : f > BitmapDescriptorFactory.HUE_RED ? 1.0f : -1.0f;
                        if (ViewUtils.isLayoutRtl(this)) {
                            f2 = -f2;
                        }
                        float a = m2363a(f2 + this.f3222p, BitmapDescriptorFactory.HUE_RED, 1.0f);
                        if (a != this.f3222p) {
                            this.f3218l = x3;
                            setThumbPosition(a);
                        }
                        return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setChecked(boolean z) {
        super.setChecked(z);
        boolean isChecked = isChecked();
        if (getWindowToken() == null || !ViewCompat.isLaidOut(this)) {
            m2365a();
            setThumbPosition(isChecked ? 1.0f : BitmapDescriptorFactory.HUE_RED);
            return;
        }
        m2369a(isChecked);
    }

    public void setShowText(boolean z) {
        if (this.f3215i != z) {
            this.f3215i = z;
            requestLayout();
        }
    }

    public void setSplitTrack(boolean z) {
        this.f3212f = z;
        invalidate();
    }

    public void setSwitchMinWidth(int i) {
        this.f3210d = i;
        requestLayout();
    }

    public void setSwitchPadding(int i) {
        this.f3211e = i;
        requestLayout();
    }

    public void setSwitchTextAppearance(Context context, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, C0235R.styleable.TextAppearance);
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(C0235R.styleable.TextAppearance_android_textColor);
        if (colorStateList != null) {
            this.f3231y = colorStateList;
        } else {
            this.f3231y = getTextColors();
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(C0235R.styleable.TextAppearance_android_textSize, 0);
        if (!(dimensionPixelSize == 0 || ((float) dimensionPixelSize) == this.f3230x.getTextSize())) {
            this.f3230x.setTextSize((float) dimensionPixelSize);
            requestLayout();
        }
        m2366a(obtainStyledAttributes.getInt(C0235R.styleable.TextAppearance_android_typeface, -1), obtainStyledAttributes.getInt(C0235R.styleable.TextAppearance_android_textStyle, -1));
        if (obtainStyledAttributes.getBoolean(C0235R.styleable.TextAppearance_textAllCaps, false)) {
            this.f3203B = new AllCapsTransformationMethod(getContext());
        } else {
            this.f3203B = null;
        }
        obtainStyledAttributes.recycle();
    }

    public void setSwitchTypeface(Typeface typeface) {
        if (this.f3230x.getTypeface() != typeface) {
            this.f3230x.setTypeface(typeface);
            requestLayout();
            invalidate();
        }
    }

    public void setSwitchTypeface(Typeface typeface, int i) {
        boolean z = false;
        if (i > 0) {
            Typeface defaultFromStyle = typeface == null ? Typeface.defaultFromStyle(i) : Typeface.create(typeface, i);
            setSwitchTypeface(defaultFromStyle);
            int style = ((defaultFromStyle != null ? defaultFromStyle.getStyle() : 0) ^ -1) & i;
            TextPaint textPaint = this.f3230x;
            if ((style & 1) != 0) {
                z = true;
            }
            textPaint.setFakeBoldText(z);
            this.f3230x.setTextSkewX((style & 2) != 0 ? -0.25f : 0.0f);
            return;
        }
        this.f3230x.setFakeBoldText(false);
        this.f3230x.setTextSkewX(BitmapDescriptorFactory.HUE_RED);
        setSwitchTypeface(typeface);
    }

    public void setTextOff(CharSequence charSequence) {
        this.f3214h = charSequence;
        requestLayout();
    }

    public void setTextOn(CharSequence charSequence) {
        this.f3213g = charSequence;
        requestLayout();
    }

    public void setThumbDrawable(Drawable drawable) {
        this.f3207a = drawable;
        requestLayout();
    }

    public void setThumbResource(int i) {
        setThumbDrawable(this.f3206E.getDrawable(i));
    }

    public void setThumbTextPadding(int i) {
        this.f3209c = i;
        requestLayout();
    }

    public void setTrackDrawable(Drawable drawable) {
        this.f3208b = drawable;
        requestLayout();
    }

    public void setTrackResource(int i) {
        setTrackDrawable(this.f3206E.getDrawable(i));
    }

    public void toggle() {
        setChecked(!isChecked());
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f3207a || drawable == this.f3208b;
    }
}
