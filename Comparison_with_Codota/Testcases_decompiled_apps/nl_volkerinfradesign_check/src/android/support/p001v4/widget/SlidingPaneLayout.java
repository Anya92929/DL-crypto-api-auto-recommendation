package android.support.p001v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.p001v4.view.AccessibilityDelegateCompat;
import android.support.p001v4.view.ViewCompat;
import android.support.p001v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.p001v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* renamed from: android.support.v4.widget.SlidingPaneLayout */
public class SlidingPaneLayout extends ViewGroup {

    /* renamed from: a */
    static final C0448d f1297a;

    /* renamed from: b */
    private int f1298b;

    /* renamed from: c */
    private int f1299c;

    /* renamed from: d */
    private Drawable f1300d;

    /* renamed from: e */
    private Drawable f1301e;

    /* renamed from: f */
    private final int f1302f;

    /* renamed from: g */
    private boolean f1303g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public View f1304h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public float f1305i;

    /* renamed from: j */
    private float f1306j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public int f1307k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public boolean f1308l;

    /* renamed from: m */
    private int f1309m;

    /* renamed from: n */
    private float f1310n;

    /* renamed from: o */
    private float f1311o;

    /* renamed from: p */
    private PanelSlideListener f1312p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public final ViewDragHelper f1313q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public boolean f1314r;

    /* renamed from: s */
    private boolean f1315s;

    /* renamed from: t */
    private final Rect f1316t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public final ArrayList<C0446b> f1317u;

    /* renamed from: android.support.v4.widget.SlidingPaneLayout$PanelSlideListener */
    public interface PanelSlideListener {
        void onPanelClosed(View view);

        void onPanelOpened(View view);

        void onPanelSlide(View view, float f);
    }

    /* renamed from: android.support.v4.widget.SlidingPaneLayout$d */
    interface C0448d {
        /* renamed from: a */
        void mo3009a(SlidingPaneLayout slidingPaneLayout, View view);
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 17) {
            f1297a = new C0451g();
        } else if (i >= 16) {
            f1297a = new C0450f();
        } else {
            f1297a = new C0449e();
        }
    }

    /* renamed from: android.support.v4.widget.SlidingPaneLayout$SimplePanelSlideListener */
    public static class SimplePanelSlideListener implements PanelSlideListener {
        public void onPanelSlide(View view, float f) {
        }

        public void onPanelOpened(View view) {
        }

        public void onPanelClosed(View view) {
        }
    }

    public SlidingPaneLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public SlidingPaneLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlidingPaneLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1298b = -858993460;
        this.f1315s = true;
        this.f1316t = new Rect();
        this.f1317u = new ArrayList<>();
        float f = context.getResources().getDisplayMetrics().density;
        this.f1302f = (int) ((32.0f * f) + 0.5f);
        ViewConfiguration.get(context);
        setWillNotDraw(false);
        ViewCompat.setAccessibilityDelegate(this, new C0445a());
        ViewCompat.setImportantForAccessibility(this, 1);
        this.f1313q = ViewDragHelper.create(this, 0.5f, new C0447c());
        this.f1313q.setMinVelocity(f * 400.0f);
    }

    public void setParallaxDistance(int i) {
        this.f1309m = i;
        requestLayout();
    }

    public int getParallaxDistance() {
        return this.f1309m;
    }

    public void setSliderFadeColor(@ColorInt int i) {
        this.f1298b = i;
    }

    @ColorInt
    public int getSliderFadeColor() {
        return this.f1298b;
    }

    public void setCoveredFadeColor(@ColorInt int i) {
        this.f1299c = i;
    }

    @ColorInt
    public int getCoveredFadeColor() {
        return this.f1299c;
    }

    public void setPanelSlideListener(PanelSlideListener panelSlideListener) {
        this.f1312p = panelSlideListener;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2955a(View view) {
        if (this.f1312p != null) {
            this.f1312p.onPanelSlide(view, this.f1305i);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo2957b(View view) {
        if (this.f1312p != null) {
            this.f1312p.onPanelOpened(view);
        }
        sendAccessibilityEvent(32);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo2958c(View view) {
        if (this.f1312p != null) {
            this.f1312p.onPanelClosed(view);
        }
        sendAccessibilityEvent(32);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo2964d(View view) {
        int width;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        boolean b = m2749b();
        int width2 = b ? getWidth() - getPaddingRight() : getPaddingLeft();
        if (b) {
            width = getPaddingLeft();
        } else {
            width = getWidth() - getPaddingRight();
        }
        int paddingTop = getPaddingTop();
        int height = getHeight() - getPaddingBottom();
        if (view == null || !m2755f(view)) {
            i = 0;
            i2 = 0;
            i3 = 0;
            i4 = 0;
        } else {
            i4 = view.getLeft();
            i3 = view.getRight();
            i2 = view.getTop();
            i = view.getBottom();
        }
        int childCount = getChildCount();
        int i8 = 0;
        while (i8 < childCount) {
            View childAt = getChildAt(i8);
            if (childAt != view) {
                if (b) {
                    i5 = width;
                } else {
                    i5 = width2;
                }
                int max = Math.max(i5, childAt.getLeft());
                int max2 = Math.max(paddingTop, childAt.getTop());
                if (b) {
                    i6 = width2;
                } else {
                    i6 = width;
                }
                int min = Math.min(i6, childAt.getRight());
                int min2 = Math.min(height, childAt.getBottom());
                if (max < i4 || max2 < i2 || min > i3 || min2 > i) {
                    i7 = 0;
                } else {
                    i7 = 4;
                }
                childAt.setVisibility(i7);
                i8++;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2954a() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 4) {
                childAt.setVisibility(0);
            }
        }
    }

    /* renamed from: f */
    private static boolean m2755f(View view) {
        if (ViewCompat.isOpaque(view)) {
            return true;
        }
        if (Build.VERSION.SDK_INT >= 18) {
            return false;
        }
        Drawable background = view.getBackground();
        if (background == null) {
            return false;
        }
        if (background.getOpacity() != -1) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f1315s = true;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f1315s = true;
        int size = this.f1317u.size();
        for (int i = 0; i < size; i++) {
            this.f1317u.get(i).run();
        }
        this.f1317u.clear();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int paddingTop;
        int makeMeasureSpec;
        int makeMeasureSpec2;
        int makeMeasureSpec3;
        int makeMeasureSpec4;
        int i7;
        int i8;
        boolean z;
        float f;
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824) {
            if (mode2 == 0) {
                if (!isInEditMode()) {
                    throw new IllegalStateException("Height must not be UNSPECIFIED");
                } else if (mode2 == 0) {
                    i3 = Integer.MIN_VALUE;
                    i4 = size;
                    i5 = 300;
                }
            }
            i3 = mode2;
            i4 = size;
            i5 = size2;
        } else if (!isInEditMode()) {
            throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
        } else if (mode == Integer.MIN_VALUE) {
            i3 = mode2;
            i4 = size;
            i5 = size2;
        } else {
            if (mode == 0) {
                i3 = mode2;
                i4 = 300;
                i5 = size2;
            }
            i3 = mode2;
            i4 = size;
            i5 = size2;
        }
        switch (i3) {
            case ExploreByTouchHelper.INVALID_ID:
                i6 = 0;
                paddingTop = (i5 - getPaddingTop()) - getPaddingBottom();
                break;
            case 1073741824:
                i6 = (i5 - getPaddingTop()) - getPaddingBottom();
                paddingTop = i6;
                break;
            default:
                i6 = 0;
                paddingTop = -1;
                break;
        }
        boolean z2 = false;
        int paddingLeft = (i4 - getPaddingLeft()) - getPaddingRight();
        int childCount = getChildCount();
        if (childCount > 2) {
            Log.e("SlidingPaneLayout", "onMeasure: More than two child views are not supported.");
        }
        this.f1304h = null;
        int i9 = 0;
        int i10 = paddingLeft;
        int i11 = i6;
        float f2 = 0.0f;
        while (i9 < childCount) {
            View childAt = getChildAt(i9);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (childAt.getVisibility() == 8) {
                layoutParams.f1320b = false;
                i7 = i10;
                f = f2;
                i8 = i11;
                z = z2;
            } else {
                if (layoutParams.weight > BitmapDescriptorFactory.HUE_RED) {
                    f2 += layoutParams.weight;
                    if (layoutParams.width == 0) {
                        i7 = i10;
                        f = f2;
                        i8 = i11;
                        z = z2;
                    }
                }
                int i12 = layoutParams.leftMargin + layoutParams.rightMargin;
                if (layoutParams.width == -2) {
                    makeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(paddingLeft - i12, ExploreByTouchHelper.INVALID_ID);
                } else if (layoutParams.width == -1) {
                    makeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(paddingLeft - i12, 1073741824);
                } else {
                    makeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(layoutParams.width, 1073741824);
                }
                if (layoutParams.height == -2) {
                    makeMeasureSpec4 = View.MeasureSpec.makeMeasureSpec(paddingTop, ExploreByTouchHelper.INVALID_ID);
                } else if (layoutParams.height == -1) {
                    makeMeasureSpec4 = View.MeasureSpec.makeMeasureSpec(paddingTop, 1073741824);
                } else {
                    makeMeasureSpec4 = View.MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
                }
                childAt.measure(makeMeasureSpec3, makeMeasureSpec4);
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (i3 == Integer.MIN_VALUE && measuredHeight > i11) {
                    i11 = Math.min(measuredHeight, paddingTop);
                }
                int i13 = i10 - measuredWidth;
                boolean z3 = i13 < 0;
                layoutParams.f1319a = z3;
                boolean z4 = z3 | z2;
                if (layoutParams.f1319a) {
                    this.f1304h = childAt;
                }
                i7 = i13;
                i8 = i11;
                float f3 = f2;
                z = z4;
                f = f3;
            }
            i9++;
            z2 = z;
            i11 = i8;
            f2 = f;
            i10 = i7;
        }
        if (z2 || f2 > BitmapDescriptorFactory.HUE_RED) {
            int i14 = paddingLeft - this.f1302f;
            for (int i15 = 0; i15 < childCount; i15++) {
                View childAt2 = getChildAt(i15);
                if (childAt2.getVisibility() != 8) {
                    LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                    if (childAt2.getVisibility() != 8) {
                        boolean z5 = layoutParams2.width == 0 && layoutParams2.weight > BitmapDescriptorFactory.HUE_RED;
                        int measuredWidth2 = z5 ? 0 : childAt2.getMeasuredWidth();
                        if (!z2 || childAt2 == this.f1304h) {
                            if (layoutParams2.weight > BitmapDescriptorFactory.HUE_RED) {
                                if (layoutParams2.width != 0) {
                                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                                } else if (layoutParams2.height == -2) {
                                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(paddingTop, ExploreByTouchHelper.INVALID_ID);
                                } else if (layoutParams2.height == -1) {
                                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(paddingTop, 1073741824);
                                } else {
                                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(layoutParams2.height, 1073741824);
                                }
                                if (z2) {
                                    int i16 = paddingLeft - (layoutParams2.rightMargin + layoutParams2.leftMargin);
                                    int makeMeasureSpec5 = View.MeasureSpec.makeMeasureSpec(i16, 1073741824);
                                    if (measuredWidth2 != i16) {
                                        childAt2.measure(makeMeasureSpec5, makeMeasureSpec);
                                    }
                                } else {
                                    childAt2.measure(View.MeasureSpec.makeMeasureSpec(((int) ((layoutParams2.weight * ((float) Math.max(0, i10))) / f2)) + measuredWidth2, 1073741824), makeMeasureSpec);
                                }
                            }
                        } else if (layoutParams2.width < 0 && (measuredWidth2 > i14 || layoutParams2.weight > BitmapDescriptorFactory.HUE_RED)) {
                            if (!z5) {
                                makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                            } else if (layoutParams2.height == -2) {
                                makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(paddingTop, ExploreByTouchHelper.INVALID_ID);
                            } else if (layoutParams2.height == -1) {
                                makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(paddingTop, 1073741824);
                            } else {
                                makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(layoutParams2.height, 1073741824);
                            }
                            childAt2.measure(View.MeasureSpec.makeMeasureSpec(i14, 1073741824), makeMeasureSpec2);
                        }
                    }
                }
            }
        }
        setMeasuredDimension(i4, getPaddingTop() + i11 + getPaddingBottom());
        this.f1303g = z2;
        if (this.f1313q.getViewDragState() != 0 && !z2) {
            this.f1313q.abort();
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int width;
        int i9;
        boolean b = m2749b();
        if (b) {
            this.f1313q.setEdgeTrackingEnabled(2);
        } else {
            this.f1313q.setEdgeTrackingEnabled(1);
        }
        int i10 = i3 - i;
        int paddingRight = b ? getPaddingRight() : getPaddingLeft();
        int paddingLeft = b ? getPaddingLeft() : getPaddingRight();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        if (this.f1315s) {
            this.f1305i = (!this.f1303g || !this.f1314r) ? BitmapDescriptorFactory.HUE_RED : 1.0f;
        }
        int i11 = 0;
        int i12 = paddingRight;
        while (i11 < childCount) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() == 8) {
                width = paddingRight;
                i9 = i12;
            } else {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                if (layoutParams.f1319a) {
                    int min = (Math.min(paddingRight, (i10 - paddingLeft) - this.f1302f) - i12) - (layoutParams.leftMargin + layoutParams.rightMargin);
                    this.f1307k = min;
                    int i13 = b ? layoutParams.rightMargin : layoutParams.leftMargin;
                    layoutParams.f1320b = ((i12 + i13) + min) + (measuredWidth / 2) > i10 - paddingLeft;
                    int i14 = (int) (((float) min) * this.f1305i);
                    i6 = i12 + i13 + i14;
                    this.f1305i = ((float) i14) / ((float) this.f1307k);
                    i5 = 0;
                } else if (!this.f1303g || this.f1309m == 0) {
                    i5 = 0;
                    i6 = paddingRight;
                } else {
                    i5 = (int) ((1.0f - this.f1305i) * ((float) this.f1309m));
                    i6 = paddingRight;
                }
                if (b) {
                    i8 = (i10 - i6) + i5;
                    i7 = i8 - measuredWidth;
                } else {
                    i7 = i6 - i5;
                    i8 = i7 + measuredWidth;
                }
                childAt.layout(i7, paddingTop, i8, childAt.getMeasuredHeight() + paddingTop);
                width = childAt.getWidth() + paddingRight;
                i9 = i6;
            }
            i11++;
            paddingRight = width;
            i12 = i9;
        }
        if (this.f1315s) {
            if (this.f1303g) {
                if (this.f1309m != 0) {
                    m2740a(this.f1305i);
                }
                if (((LayoutParams) this.f1304h.getLayoutParams()).f1320b) {
                    m2744a(this.f1304h, this.f1305i, this.f1298b);
                }
            } else {
                for (int i15 = 0; i15 < childCount; i15++) {
                    m2744a(getChildAt(i15), BitmapDescriptorFactory.HUE_RED, this.f1298b);
                }
            }
            mo2964d(this.f1304h);
        }
        this.f1315s = false;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            this.f1315s = true;
        }
    }

    public void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        if (!isInTouchMode() && !this.f1303g) {
            this.f1314r = view == this.f1304h;
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r8) {
        /*
            r7 = this;
            r2 = 0
            r1 = 1
            int r3 = android.support.p001v4.view.MotionEventCompat.getActionMasked(r8)
            boolean r0 = r7.f1303g
            if (r0 != 0) goto L_0x002d
            if (r3 != 0) goto L_0x002d
            int r0 = r7.getChildCount()
            if (r0 <= r1) goto L_0x002d
            android.view.View r0 = r7.getChildAt(r1)
            if (r0 == 0) goto L_0x002d
            android.support.v4.widget.ViewDragHelper r4 = r7.f1313q
            float r5 = r8.getX()
            int r5 = (int) r5
            float r6 = r8.getY()
            int r6 = (int) r6
            boolean r0 = r4.isViewUnder(r0, r5, r6)
            if (r0 != 0) goto L_0x0041
            r0 = r1
        L_0x002b:
            r7.f1314r = r0
        L_0x002d:
            boolean r0 = r7.f1303g
            if (r0 == 0) goto L_0x0037
            boolean r0 = r7.f1308l
            if (r0 == 0) goto L_0x0043
            if (r3 == 0) goto L_0x0043
        L_0x0037:
            android.support.v4.widget.ViewDragHelper r0 = r7.f1313q
            r0.cancel()
            boolean r2 = super.onInterceptTouchEvent(r8)
        L_0x0040:
            return r2
        L_0x0041:
            r0 = r2
            goto L_0x002b
        L_0x0043:
            r0 = 3
            if (r3 == r0) goto L_0x0048
            if (r3 != r1) goto L_0x004e
        L_0x0048:
            android.support.v4.widget.ViewDragHelper r0 = r7.f1313q
            r0.cancel()
            goto L_0x0040
        L_0x004e:
            switch(r3) {
                case 0: goto L_0x005e;
                case 1: goto L_0x0051;
                case 2: goto L_0x0082;
                default: goto L_0x0051;
            }
        L_0x0051:
            r0 = r2
        L_0x0052:
            android.support.v4.widget.ViewDragHelper r3 = r7.f1313q
            boolean r3 = r3.shouldInterceptTouchEvent(r8)
            if (r3 != 0) goto L_0x005c
            if (r0 == 0) goto L_0x0040
        L_0x005c:
            r2 = r1
            goto L_0x0040
        L_0x005e:
            r7.f1308l = r2
            float r0 = r8.getX()
            float r3 = r8.getY()
            r7.f1310n = r0
            r7.f1311o = r3
            android.support.v4.widget.ViewDragHelper r4 = r7.f1313q
            android.view.View r5 = r7.f1304h
            int r0 = (int) r0
            int r3 = (int) r3
            boolean r0 = r4.isViewUnder(r5, r0, r3)
            if (r0 == 0) goto L_0x0051
            android.view.View r0 = r7.f1304h
            boolean r0 = r7.mo2967e((android.view.View) r0)
            if (r0 == 0) goto L_0x0051
            r0 = r1
            goto L_0x0052
        L_0x0082:
            float r0 = r8.getX()
            float r3 = r8.getY()
            float r4 = r7.f1310n
            float r0 = r0 - r4
            float r0 = java.lang.Math.abs(r0)
            float r4 = r7.f1311o
            float r3 = r3 - r4
            float r3 = java.lang.Math.abs(r3)
            android.support.v4.widget.ViewDragHelper r4 = r7.f1313q
            int r4 = r4.getTouchSlop()
            float r4 = (float) r4
            int r4 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r4 <= 0) goto L_0x0051
            int r0 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x0051
            android.support.v4.widget.ViewDragHelper r0 = r7.f1313q
            r0.cancel()
            r7.f1308l = r1
            goto L_0x0040
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p001v4.widget.SlidingPaneLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f1303g) {
            return super.onTouchEvent(motionEvent);
        }
        this.f1313q.processTouchEvent(motionEvent);
        switch (motionEvent.getAction() & 255) {
            case 0:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                this.f1310n = x;
                this.f1311o = y;
                return true;
            case 1:
                if (!mo2967e(this.f1304h)) {
                    return true;
                }
                float x2 = motionEvent.getX();
                float y2 = motionEvent.getY();
                float f = x2 - this.f1310n;
                float f2 = y2 - this.f1311o;
                int touchSlop = this.f1313q.getTouchSlop();
                if ((f * f) + (f2 * f2) >= ((float) (touchSlop * touchSlop)) || !this.f1313q.isViewUnder(this.f1304h, (int) x2, (int) y2)) {
                    return true;
                }
                m2747a(this.f1304h, 0);
                return true;
            default:
                return true;
        }
    }

    /* renamed from: a */
    private boolean m2747a(View view, int i) {
        if (!this.f1315s && !mo2956a((float) BitmapDescriptorFactory.HUE_RED, i)) {
            return false;
        }
        this.f1314r = false;
        return true;
    }

    /* renamed from: b */
    private boolean m2750b(View view, int i) {
        if (!this.f1315s && !mo2956a(1.0f, i)) {
            return false;
        }
        this.f1314r = true;
        return true;
    }

    @Deprecated
    public void smoothSlideOpen() {
        openPane();
    }

    public boolean openPane() {
        return m2750b(this.f1304h, 0);
    }

    @Deprecated
    public void smoothSlideClosed() {
        closePane();
    }

    public boolean closePane() {
        return m2747a(this.f1304h, 0);
    }

    public boolean isOpen() {
        return !this.f1303g || this.f1305i == 1.0f;
    }

    @Deprecated
    public boolean canSlide() {
        return this.f1303g;
    }

    public boolean isSlideable() {
        return this.f1303g;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m2741a(int i) {
        if (this.f1304h == null) {
            this.f1305i = BitmapDescriptorFactory.HUE_RED;
            return;
        }
        boolean b = m2749b();
        LayoutParams layoutParams = (LayoutParams) this.f1304h.getLayoutParams();
        int width = this.f1304h.getWidth();
        if (b) {
            i = (getWidth() - i) - width;
        }
        this.f1305i = ((float) (i - ((b ? layoutParams.rightMargin : layoutParams.leftMargin) + (b ? getPaddingRight() : getPaddingLeft())))) / ((float) this.f1307k);
        if (this.f1309m != 0) {
            m2740a(this.f1305i);
        }
        if (layoutParams.f1320b) {
            m2744a(this.f1304h, this.f1305i, this.f1298b);
        }
        mo2955a(this.f1304h);
    }

    /* renamed from: a */
    private void m2744a(View view, float f, int i) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (f > BitmapDescriptorFactory.HUE_RED && i != 0) {
            int i2 = (((int) (((float) ((-16777216 & i) >>> 24)) * f)) << 24) | (16777215 & i);
            if (layoutParams.f1321c == null) {
                layoutParams.f1321c = new Paint();
            }
            layoutParams.f1321c.setColorFilter(new PorterDuffColorFilter(i2, PorterDuff.Mode.SRC_OVER));
            if (ViewCompat.getLayerType(view) != 2) {
                ViewCompat.setLayerType(view, 2, layoutParams.f1321c);
            }
            m2757g(view);
        } else if (ViewCompat.getLayerType(view) != 0) {
            if (layoutParams.f1321c != null) {
                layoutParams.f1321c.setColorFilter((ColorFilter) null);
            }
            C0446b bVar = new C0446b(view);
            this.f1317u.add(bVar);
            ViewCompat.postOnAnimation(this, bVar);
        }
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j) {
        boolean drawChild;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int save = canvas.save(2);
        if (this.f1303g && !layoutParams.f1319a && this.f1304h != null) {
            canvas.getClipBounds(this.f1316t);
            if (m2749b()) {
                this.f1316t.left = Math.max(this.f1316t.left, this.f1304h.getRight());
            } else {
                this.f1316t.right = Math.min(this.f1316t.right, this.f1304h.getLeft());
            }
            canvas.clipRect(this.f1316t);
        }
        if (Build.VERSION.SDK_INT >= 11) {
            drawChild = super.drawChild(canvas, view, j);
        } else if (!layoutParams.f1320b || this.f1305i <= BitmapDescriptorFactory.HUE_RED) {
            if (view.isDrawingCacheEnabled()) {
                view.setDrawingCacheEnabled(false);
            }
            drawChild = super.drawChild(canvas, view, j);
        } else {
            if (!view.isDrawingCacheEnabled()) {
                view.setDrawingCacheEnabled(true);
            }
            Bitmap drawingCache = view.getDrawingCache();
            if (drawingCache != null) {
                canvas.drawBitmap(drawingCache, (float) view.getLeft(), (float) view.getTop(), layoutParams.f1321c);
                drawChild = false;
            } else {
                Log.e("SlidingPaneLayout", "drawChild: child view " + view + " returned null drawing cache");
                drawChild = super.drawChild(canvas, view, j);
            }
        }
        canvas.restoreToCount(save);
        return drawChild;
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m2757g(View view) {
        f1297a.mo3009a(this, view);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo2956a(float f, int i) {
        int paddingLeft;
        if (!this.f1303g) {
            return false;
        }
        boolean b = m2749b();
        LayoutParams layoutParams = (LayoutParams) this.f1304h.getLayoutParams();
        if (b) {
            paddingLeft = (int) (((float) getWidth()) - ((((float) (layoutParams.rightMargin + getPaddingRight())) + (((float) this.f1307k) * f)) + ((float) this.f1304h.getWidth())));
        } else {
            paddingLeft = (int) (((float) (layoutParams.leftMargin + getPaddingLeft())) + (((float) this.f1307k) * f));
        }
        if (!this.f1313q.smoothSlideViewTo(this.f1304h, paddingLeft, this.f1304h.getTop())) {
            return false;
        }
        mo2954a();
        ViewCompat.postInvalidateOnAnimation(this);
        return true;
    }

    public void computeScroll() {
        if (!this.f1313q.continueSettling(true)) {
            return;
        }
        if (!this.f1303g) {
            this.f1313q.abort();
        } else {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    @Deprecated
    public void setShadowDrawable(Drawable drawable) {
        setShadowDrawableLeft(drawable);
    }

    public void setShadowDrawableLeft(Drawable drawable) {
        this.f1300d = drawable;
    }

    public void setShadowDrawableRight(Drawable drawable) {
        this.f1301e = drawable;
    }

    @Deprecated
    public void setShadowResource(@DrawableRes int i) {
        setShadowDrawable(getResources().getDrawable(i));
    }

    public void setShadowResourceLeft(int i) {
        setShadowDrawableLeft(getResources().getDrawable(i));
    }

    public void setShadowResourceRight(int i) {
        setShadowDrawableRight(getResources().getDrawable(i));
    }

    public void draw(Canvas canvas) {
        Drawable drawable;
        int left;
        int i;
        super.draw(canvas);
        if (m2749b()) {
            drawable = this.f1301e;
        } else {
            drawable = this.f1300d;
        }
        View childAt = getChildCount() > 1 ? getChildAt(1) : null;
        if (childAt != null && drawable != null) {
            int top = childAt.getTop();
            int bottom = childAt.getBottom();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            if (m2749b()) {
                i = childAt.getRight();
                left = i + intrinsicWidth;
            } else {
                left = childAt.getLeft();
                i = left - intrinsicWidth;
            }
            drawable.setBounds(i, top, left, bottom);
            drawable.draw(canvas);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m2740a(float r10) {
        /*
            r9 = this;
            r1 = 0
            r8 = 1065353216(0x3f800000, float:1.0)
            boolean r3 = r9.m2749b()
            android.view.View r0 = r9.f1304h
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            android.support.v4.widget.SlidingPaneLayout$LayoutParams r0 = (android.support.p001v4.widget.SlidingPaneLayout.LayoutParams) r0
            boolean r2 = r0.f1320b
            if (r2 == 0) goto L_0x0030
            if (r3 == 0) goto L_0x002d
            int r0 = r0.rightMargin
        L_0x0017:
            if (r0 > 0) goto L_0x0030
            r0 = 1
        L_0x001a:
            int r4 = r9.getChildCount()
            r2 = r1
        L_0x001f:
            if (r2 >= r4) goto L_0x005d
            android.view.View r5 = r9.getChildAt(r2)
            android.view.View r1 = r9.f1304h
            if (r5 != r1) goto L_0x0032
        L_0x0029:
            int r1 = r2 + 1
            r2 = r1
            goto L_0x001f
        L_0x002d:
            int r0 = r0.leftMargin
            goto L_0x0017
        L_0x0030:
            r0 = r1
            goto L_0x001a
        L_0x0032:
            float r1 = r9.f1306j
            float r1 = r8 - r1
            int r6 = r9.f1309m
            float r6 = (float) r6
            float r1 = r1 * r6
            int r1 = (int) r1
            r9.f1306j = r10
            float r6 = r8 - r10
            int r7 = r9.f1309m
            float r7 = (float) r7
            float r6 = r6 * r7
            int r6 = (int) r6
            int r1 = r1 - r6
            if (r3 == 0) goto L_0x0048
            int r1 = -r1
        L_0x0048:
            r5.offsetLeftAndRight(r1)
            if (r0 == 0) goto L_0x0029
            if (r3 == 0) goto L_0x0058
            float r1 = r9.f1306j
            float r1 = r1 - r8
        L_0x0052:
            int r6 = r9.f1299c
            r9.m2744a(r5, r1, r6)
            goto L_0x0029
        L_0x0058:
            float r1 = r9.f1306j
            float r1 = r8 - r1
            goto L_0x0052
        L_0x005d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p001v4.widget.SlidingPaneLayout.m2740a(float):void");
    }

    /* access modifiers changed from: protected */
    public boolean canScroll(View view, boolean z, int i, int i2, int i3) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (i2 + scrollX >= childAt.getLeft() && i2 + scrollX < childAt.getRight() && i3 + scrollY >= childAt.getTop() && i3 + scrollY < childAt.getBottom()) {
                    if (canScroll(childAt, true, i, (i2 + scrollX) - childAt.getLeft(), (i3 + scrollY) - childAt.getTop())) {
                        return true;
                    }
                }
            }
        }
        if (z) {
            if (!m2749b()) {
                i = -i;
            }
            if (!ViewCompat.canScrollHorizontally(view, i)) {
                return false;
            }
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public boolean mo2967e(View view) {
        if (view == null) {
            return false;
        }
        return this.f1303g && ((LayoutParams) view.getLayoutParams()).f1320b && this.f1305i > BitmapDescriptorFactory.HUE_RED;
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f1322a = isSlideable() ? isOpen() : this.f1314r;
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.f1322a) {
            openPane();
        } else {
            closePane();
        }
        this.f1314r = savedState.f1322a;
    }

    /* renamed from: android.support.v4.widget.SlidingPaneLayout$c */
    class C0447c extends ViewDragHelper.Callback {
        private C0447c() {
        }

        public boolean tryCaptureView(View view, int i) {
            if (SlidingPaneLayout.this.f1308l) {
                return false;
            }
            return ((LayoutParams) view.getLayoutParams()).f1319a;
        }

        public void onViewDragStateChanged(int i) {
            if (SlidingPaneLayout.this.f1313q.getViewDragState() != 0) {
                return;
            }
            if (SlidingPaneLayout.this.f1305i == BitmapDescriptorFactory.HUE_RED) {
                SlidingPaneLayout.this.mo2964d(SlidingPaneLayout.this.f1304h);
                SlidingPaneLayout.this.mo2958c(SlidingPaneLayout.this.f1304h);
                boolean unused = SlidingPaneLayout.this.f1314r = false;
                return;
            }
            SlidingPaneLayout.this.mo2957b(SlidingPaneLayout.this.f1304h);
            boolean unused2 = SlidingPaneLayout.this.f1314r = true;
        }

        public void onViewCaptured(View view, int i) {
            SlidingPaneLayout.this.mo2954a();
        }

        public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
            SlidingPaneLayout.this.m2741a(i);
            SlidingPaneLayout.this.invalidate();
        }

        public void onViewReleased(View view, float f, float f2) {
            int paddingLeft;
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (SlidingPaneLayout.this.m2749b()) {
                int paddingRight = layoutParams.rightMargin + SlidingPaneLayout.this.getPaddingRight();
                if (f < BitmapDescriptorFactory.HUE_RED || (f == BitmapDescriptorFactory.HUE_RED && SlidingPaneLayout.this.f1305i > 0.5f)) {
                    paddingRight += SlidingPaneLayout.this.f1307k;
                }
                paddingLeft = (SlidingPaneLayout.this.getWidth() - paddingRight) - SlidingPaneLayout.this.f1304h.getWidth();
            } else {
                paddingLeft = layoutParams.leftMargin + SlidingPaneLayout.this.getPaddingLeft();
                if (f > BitmapDescriptorFactory.HUE_RED || (f == BitmapDescriptorFactory.HUE_RED && SlidingPaneLayout.this.f1305i > 0.5f)) {
                    paddingLeft += SlidingPaneLayout.this.f1307k;
                }
            }
            SlidingPaneLayout.this.f1313q.settleCapturedViewAt(paddingLeft, view.getTop());
            SlidingPaneLayout.this.invalidate();
        }

        public int getViewHorizontalDragRange(View view) {
            return SlidingPaneLayout.this.f1307k;
        }

        public int clampViewPositionHorizontal(View view, int i, int i2) {
            LayoutParams layoutParams = (LayoutParams) SlidingPaneLayout.this.f1304h.getLayoutParams();
            if (SlidingPaneLayout.this.m2749b()) {
                int width = SlidingPaneLayout.this.getWidth() - ((layoutParams.rightMargin + SlidingPaneLayout.this.getPaddingRight()) + SlidingPaneLayout.this.f1304h.getWidth());
                return Math.max(Math.min(i, width), width - SlidingPaneLayout.this.f1307k);
            }
            int paddingLeft = layoutParams.leftMargin + SlidingPaneLayout.this.getPaddingLeft();
            return Math.min(Math.max(i, paddingLeft), SlidingPaneLayout.this.f1307k + paddingLeft);
        }

        public int clampViewPositionVertical(View view, int i, int i2) {
            return view.getTop();
        }

        public void onEdgeDragStarted(int i, int i2) {
            SlidingPaneLayout.this.f1313q.captureChildView(SlidingPaneLayout.this.f1304h, i2);
        }
    }

    /* renamed from: android.support.v4.widget.SlidingPaneLayout$LayoutParams */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* renamed from: d */
        private static final int[] f1318d = {16843137};

        /* renamed from: a */
        boolean f1319a;

        /* renamed from: b */
        boolean f1320b;

        /* renamed from: c */
        Paint f1321c;
        public float weight = BitmapDescriptorFactory.HUE_RED;

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.weight = layoutParams.weight;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f1318d);
            this.weight = obtainStyledAttributes.getFloat(0, BitmapDescriptorFactory.HUE_RED);
            obtainStyledAttributes.recycle();
        }
    }

    /* renamed from: android.support.v4.widget.SlidingPaneLayout$SavedState */
    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* renamed from: a */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };

        /* renamed from: a */
        boolean f1322a;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f1322a = parcel.readInt() != 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f1322a ? 1 : 0);
        }
    }

    /* renamed from: android.support.v4.widget.SlidingPaneLayout$e */
    static class C0449e implements C0448d {
        C0449e() {
        }

        /* renamed from: a */
        public void mo3009a(SlidingPaneLayout slidingPaneLayout, View view) {
            ViewCompat.postInvalidateOnAnimation(slidingPaneLayout, view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    /* renamed from: android.support.v4.widget.SlidingPaneLayout$f */
    static class C0450f extends C0449e {

        /* renamed from: a */
        private Method f1328a;

        /* renamed from: b */
        private Field f1329b;

        C0450f() {
            try {
                this.f1328a = View.class.getDeclaredMethod("getDisplayList", (Class[]) null);
            } catch (NoSuchMethodException e) {
                Log.e("SlidingPaneLayout", "Couldn't fetch getDisplayList method; dimming won't work right.", e);
            }
            try {
                this.f1329b = View.class.getDeclaredField("mRecreateDisplayList");
                this.f1329b.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                Log.e("SlidingPaneLayout", "Couldn't fetch mRecreateDisplayList field; dimming will be slow.", e2);
            }
        }

        /* renamed from: a */
        public void mo3009a(SlidingPaneLayout slidingPaneLayout, View view) {
            if (this.f1328a == null || this.f1329b == null) {
                view.invalidate();
                return;
            }
            try {
                this.f1329b.setBoolean(view, true);
                this.f1328a.invoke(view, (Object[]) null);
            } catch (Exception e) {
                Log.e("SlidingPaneLayout", "Error refreshing display list state", e);
            }
            super.mo3009a(slidingPaneLayout, view);
        }
    }

    /* renamed from: android.support.v4.widget.SlidingPaneLayout$g */
    static class C0451g extends C0449e {
        C0451g() {
        }

        /* renamed from: a */
        public void mo3009a(SlidingPaneLayout slidingPaneLayout, View view) {
            ViewCompat.setLayerPaint(view, ((LayoutParams) view.getLayoutParams()).f1321c);
        }
    }

    /* renamed from: android.support.v4.widget.SlidingPaneLayout$a */
    class C0445a extends AccessibilityDelegateCompat {

        /* renamed from: c */
        private final Rect f1324c = new Rect();

        C0445a() {
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            AccessibilityNodeInfoCompat obtain = AccessibilityNodeInfoCompat.obtain(accessibilityNodeInfoCompat);
            super.onInitializeAccessibilityNodeInfo(view, obtain);
            m2767a(accessibilityNodeInfoCompat, obtain);
            obtain.recycle();
            accessibilityNodeInfoCompat.setClassName(SlidingPaneLayout.class.getName());
            accessibilityNodeInfoCompat.setSource(view);
            ViewParent parentForAccessibility = ViewCompat.getParentForAccessibility(view);
            if (parentForAccessibility instanceof View) {
                accessibilityNodeInfoCompat.setParent((View) parentForAccessibility);
            }
            int childCount = SlidingPaneLayout.this.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = SlidingPaneLayout.this.getChildAt(i);
                if (!mo3007a(childAt) && childAt.getVisibility() == 0) {
                    ViewCompat.setImportantForAccessibility(childAt, 1);
                    accessibilityNodeInfoCompat.addChild(childAt);
                }
            }
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(SlidingPaneLayout.class.getName());
        }

        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (!mo3007a(view)) {
                return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
            }
            return false;
        }

        /* renamed from: a */
        public boolean mo3007a(View view) {
            return SlidingPaneLayout.this.mo2967e(view);
        }

        /* renamed from: a */
        private void m2767a(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2) {
            Rect rect = this.f1324c;
            accessibilityNodeInfoCompat2.getBoundsInParent(rect);
            accessibilityNodeInfoCompat.setBoundsInParent(rect);
            accessibilityNodeInfoCompat2.getBoundsInScreen(rect);
            accessibilityNodeInfoCompat.setBoundsInScreen(rect);
            accessibilityNodeInfoCompat.setVisibleToUser(accessibilityNodeInfoCompat2.isVisibleToUser());
            accessibilityNodeInfoCompat.setPackageName(accessibilityNodeInfoCompat2.getPackageName());
            accessibilityNodeInfoCompat.setClassName(accessibilityNodeInfoCompat2.getClassName());
            accessibilityNodeInfoCompat.setContentDescription(accessibilityNodeInfoCompat2.getContentDescription());
            accessibilityNodeInfoCompat.setEnabled(accessibilityNodeInfoCompat2.isEnabled());
            accessibilityNodeInfoCompat.setClickable(accessibilityNodeInfoCompat2.isClickable());
            accessibilityNodeInfoCompat.setFocusable(accessibilityNodeInfoCompat2.isFocusable());
            accessibilityNodeInfoCompat.setFocused(accessibilityNodeInfoCompat2.isFocused());
            accessibilityNodeInfoCompat.setAccessibilityFocused(accessibilityNodeInfoCompat2.isAccessibilityFocused());
            accessibilityNodeInfoCompat.setSelected(accessibilityNodeInfoCompat2.isSelected());
            accessibilityNodeInfoCompat.setLongClickable(accessibilityNodeInfoCompat2.isLongClickable());
            accessibilityNodeInfoCompat.addAction(accessibilityNodeInfoCompat2.getActions());
            accessibilityNodeInfoCompat.setMovementGranularities(accessibilityNodeInfoCompat2.getMovementGranularities());
        }
    }

    /* renamed from: android.support.v4.widget.SlidingPaneLayout$b */
    class C0446b implements Runnable {

        /* renamed from: a */
        final View f1325a;

        C0446b(View view) {
            this.f1325a = view;
        }

        public void run() {
            if (this.f1325a.getParent() == SlidingPaneLayout.this) {
                ViewCompat.setLayerType(this.f1325a, 0, (Paint) null);
                SlidingPaneLayout.this.m2757g(this.f1325a);
            }
            SlidingPaneLayout.this.f1317u.remove(this);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public boolean m2749b() {
        return ViewCompat.getLayoutDirection(this) == 1;
    }
}
