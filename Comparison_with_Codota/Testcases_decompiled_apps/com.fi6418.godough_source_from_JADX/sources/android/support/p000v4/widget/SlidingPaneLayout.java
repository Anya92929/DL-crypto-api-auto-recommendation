package android.support.p000v4.widget;

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
import android.support.p000v4.view.AccessibilityDelegateCompat;
import android.support.p000v4.view.ViewCompat;
import android.support.p000v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.p000v4.widget.ViewDragHelper;
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
    static final SlidingPanelLayoutImpl f1603a;

    /* renamed from: b */
    private int f1604b;

    /* renamed from: c */
    private int f1605c;

    /* renamed from: d */
    private Drawable f1606d;

    /* renamed from: e */
    private Drawable f1607e;

    /* renamed from: f */
    private final int f1608f;

    /* renamed from: g */
    private boolean f1609g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public View f1610h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public float f1611i;

    /* renamed from: j */
    private float f1612j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public int f1613k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public boolean f1614l;

    /* renamed from: m */
    private int f1615m;

    /* renamed from: n */
    private float f1616n;

    /* renamed from: o */
    private float f1617o;

    /* renamed from: p */
    private PanelSlideListener f1618p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public final ViewDragHelper f1619q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public boolean f1620r;

    /* renamed from: s */
    private boolean f1621s;

    /* renamed from: t */
    private final Rect f1622t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public final ArrayList<DisableLayerRunnable> f1623u;

    /* renamed from: android.support.v4.widget.SlidingPaneLayout$AccessibilityDelegate */
    class AccessibilityDelegate extends AccessibilityDelegateCompat {

        /* renamed from: c */
        private final Rect f1625c = new Rect();

        AccessibilityDelegate() {
        }

        /* renamed from: a */
        private void m1161a(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2) {
            Rect rect = this.f1625c;
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

        public boolean filter(View view) {
            return SlidingPaneLayout.this.mo3389e(view);
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(SlidingPaneLayout.class.getName());
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            AccessibilityNodeInfoCompat obtain = AccessibilityNodeInfoCompat.obtain(accessibilityNodeInfoCompat);
            super.onInitializeAccessibilityNodeInfo(view, obtain);
            m1161a(accessibilityNodeInfoCompat, obtain);
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
                if (!filter(childAt) && childAt.getVisibility() == 0) {
                    ViewCompat.setImportantForAccessibility(childAt, 1);
                    accessibilityNodeInfoCompat.addChild(childAt);
                }
            }
        }

        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (!filter(view)) {
                return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
            }
            return false;
        }
    }

    /* renamed from: android.support.v4.widget.SlidingPaneLayout$DisableLayerRunnable */
    class DisableLayerRunnable implements Runnable {

        /* renamed from: a */
        final View f1626a;

        DisableLayerRunnable(View view) {
            this.f1626a = view;
        }

        public void run() {
            if (this.f1626a.getParent() == SlidingPaneLayout.this) {
                ViewCompat.setLayerType(this.f1626a, 0, (Paint) null);
                SlidingPaneLayout.this.m1153g(this.f1626a);
            }
            SlidingPaneLayout.this.f1623u.remove(this);
        }
    }

    /* renamed from: android.support.v4.widget.SlidingPaneLayout$DragHelperCallback */
    class DragHelperCallback extends ViewDragHelper.Callback {
        private DragHelperCallback() {
        }

        public int clampViewPositionHorizontal(View view, int i, int i2) {
            LayoutParams layoutParams = (LayoutParams) SlidingPaneLayout.this.f1610h.getLayoutParams();
            if (SlidingPaneLayout.this.m1145b()) {
                int width = SlidingPaneLayout.this.getWidth() - ((layoutParams.rightMargin + SlidingPaneLayout.this.getPaddingRight()) + SlidingPaneLayout.this.f1610h.getWidth());
                return Math.max(Math.min(i, width), width - SlidingPaneLayout.this.f1613k);
            }
            int paddingLeft = layoutParams.leftMargin + SlidingPaneLayout.this.getPaddingLeft();
            return Math.min(Math.max(i, paddingLeft), SlidingPaneLayout.this.f1613k + paddingLeft);
        }

        public int clampViewPositionVertical(View view, int i, int i2) {
            return view.getTop();
        }

        public int getViewHorizontalDragRange(View view) {
            return SlidingPaneLayout.this.f1613k;
        }

        public void onEdgeDragStarted(int i, int i2) {
            SlidingPaneLayout.this.f1619q.captureChildView(SlidingPaneLayout.this.f1610h, i2);
        }

        public void onViewCaptured(View view, int i) {
            SlidingPaneLayout.this.mo3377a();
        }

        public void onViewDragStateChanged(int i) {
            if (SlidingPaneLayout.this.f1619q.getViewDragState() != 0) {
                return;
            }
            if (SlidingPaneLayout.this.f1611i == BitmapDescriptorFactory.HUE_RED) {
                SlidingPaneLayout.this.mo3386d(SlidingPaneLayout.this.f1610h);
                SlidingPaneLayout.this.mo3381c(SlidingPaneLayout.this.f1610h);
                boolean unused = SlidingPaneLayout.this.f1620r = false;
                return;
            }
            SlidingPaneLayout.this.mo3380b(SlidingPaneLayout.this.f1610h);
            boolean unused2 = SlidingPaneLayout.this.f1620r = true;
        }

        public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
            SlidingPaneLayout.this.m1137a(i);
            SlidingPaneLayout.this.invalidate();
        }

        public void onViewReleased(View view, float f, float f2) {
            int paddingLeft;
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (SlidingPaneLayout.this.m1145b()) {
                int paddingRight = layoutParams.rightMargin + SlidingPaneLayout.this.getPaddingRight();
                if (f < BitmapDescriptorFactory.HUE_RED || (f == BitmapDescriptorFactory.HUE_RED && SlidingPaneLayout.this.f1611i > 0.5f)) {
                    paddingRight += SlidingPaneLayout.this.f1613k;
                }
                paddingLeft = (SlidingPaneLayout.this.getWidth() - paddingRight) - SlidingPaneLayout.this.f1610h.getWidth();
            } else {
                paddingLeft = layoutParams.leftMargin + SlidingPaneLayout.this.getPaddingLeft();
                if (f > BitmapDescriptorFactory.HUE_RED || (f == BitmapDescriptorFactory.HUE_RED && SlidingPaneLayout.this.f1611i > 0.5f)) {
                    paddingLeft += SlidingPaneLayout.this.f1613k;
                }
            }
            SlidingPaneLayout.this.f1619q.settleCapturedViewAt(paddingLeft, view.getTop());
            SlidingPaneLayout.this.invalidate();
        }

        public boolean tryCaptureView(View view, int i) {
            if (SlidingPaneLayout.this.f1614l) {
                return false;
            }
            return ((LayoutParams) view.getLayoutParams()).f1630a;
        }
    }

    /* renamed from: android.support.v4.widget.SlidingPaneLayout$LayoutParams */
    public class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* renamed from: d */
        private static final int[] f1629d = {16843137};

        /* renamed from: a */
        boolean f1630a;

        /* renamed from: b */
        boolean f1631b;

        /* renamed from: c */
        Paint f1632c;
        public float weight = BitmapDescriptorFactory.HUE_RED;

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f1629d);
            this.weight = obtainStyledAttributes.getFloat(0, BitmapDescriptorFactory.HUE_RED);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.weight = layoutParams.weight;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    /* renamed from: android.support.v4.widget.SlidingPaneLayout$PanelSlideListener */
    public interface PanelSlideListener {
        void onPanelClosed(View view);

        void onPanelOpened(View view);

        void onPanelSlide(View view, float f);
    }

    /* renamed from: android.support.v4.widget.SlidingPaneLayout$SavedState */
    class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };

        /* renamed from: a */
        boolean f1633a;

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f1633a = parcel.readInt() != 0;
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f1633a ? 1 : 0);
        }
    }

    /* renamed from: android.support.v4.widget.SlidingPaneLayout$SimplePanelSlideListener */
    public class SimplePanelSlideListener implements PanelSlideListener {
        public void onPanelClosed(View view) {
        }

        public void onPanelOpened(View view) {
        }

        public void onPanelSlide(View view, float f) {
        }
    }

    /* renamed from: android.support.v4.widget.SlidingPaneLayout$SlidingPanelLayoutImpl */
    interface SlidingPanelLayoutImpl {
        void invalidateChildRegion(SlidingPaneLayout slidingPaneLayout, View view);
    }

    /* renamed from: android.support.v4.widget.SlidingPaneLayout$SlidingPanelLayoutImplBase */
    class SlidingPanelLayoutImplBase implements SlidingPanelLayoutImpl {
        SlidingPanelLayoutImplBase() {
        }

        public void invalidateChildRegion(SlidingPaneLayout slidingPaneLayout, View view) {
            ViewCompat.postInvalidateOnAnimation(slidingPaneLayout, view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    /* renamed from: android.support.v4.widget.SlidingPaneLayout$SlidingPanelLayoutImplJB */
    class SlidingPanelLayoutImplJB extends SlidingPanelLayoutImplBase {

        /* renamed from: a */
        private Method f1634a;

        /* renamed from: b */
        private Field f1635b;

        SlidingPanelLayoutImplJB() {
            try {
                this.f1634a = View.class.getDeclaredMethod("getDisplayList", (Class[]) null);
            } catch (NoSuchMethodException e) {
                Log.e("SlidingPaneLayout", "Couldn't fetch getDisplayList method; dimming won't work right.", e);
            }
            try {
                this.f1635b = View.class.getDeclaredField("mRecreateDisplayList");
                this.f1635b.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                Log.e("SlidingPaneLayout", "Couldn't fetch mRecreateDisplayList field; dimming will be slow.", e2);
            }
        }

        public void invalidateChildRegion(SlidingPaneLayout slidingPaneLayout, View view) {
            if (this.f1634a == null || this.f1635b == null) {
                view.invalidate();
                return;
            }
            try {
                this.f1635b.setBoolean(view, true);
                this.f1634a.invoke(view, (Object[]) null);
            } catch (Exception e) {
                Log.e("SlidingPaneLayout", "Error refreshing display list state", e);
            }
            super.invalidateChildRegion(slidingPaneLayout, view);
        }
    }

    /* renamed from: android.support.v4.widget.SlidingPaneLayout$SlidingPanelLayoutImplJBMR1 */
    class SlidingPanelLayoutImplJBMR1 extends SlidingPanelLayoutImplBase {
        SlidingPanelLayoutImplJBMR1() {
        }

        public void invalidateChildRegion(SlidingPaneLayout slidingPaneLayout, View view) {
            ViewCompat.setLayerPaint(view, ((LayoutParams) view.getLayoutParams()).f1632c);
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 17) {
            f1603a = new SlidingPanelLayoutImplJBMR1();
        } else if (i >= 16) {
            f1603a = new SlidingPanelLayoutImplJB();
        } else {
            f1603a = new SlidingPanelLayoutImplBase();
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
        this.f1604b = -858993460;
        this.f1621s = true;
        this.f1622t = new Rect();
        this.f1623u = new ArrayList<>();
        float f = context.getResources().getDisplayMetrics().density;
        this.f1608f = (int) ((32.0f * f) + 0.5f);
        ViewConfiguration.get(context);
        setWillNotDraw(false);
        ViewCompat.setAccessibilityDelegate(this, new AccessibilityDelegate());
        ViewCompat.setImportantForAccessibility(this, 1);
        this.f1619q = ViewDragHelper.create(this, 0.5f, new DragHelperCallback());
        this.f1619q.setMinVelocity(f * 400.0f);
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m1136a(float r10) {
        /*
            r9 = this;
            r1 = 0
            r8 = 1065353216(0x3f800000, float:1.0)
            boolean r3 = r9.m1145b()
            android.view.View r0 = r9.f1610h
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            android.support.v4.widget.SlidingPaneLayout$LayoutParams r0 = (android.support.p000v4.widget.SlidingPaneLayout.LayoutParams) r0
            boolean r2 = r0.f1631b
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
            android.view.View r1 = r9.f1610h
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
            float r1 = r9.f1612j
            float r1 = r8 - r1
            int r6 = r9.f1615m
            float r6 = (float) r6
            float r1 = r1 * r6
            int r1 = (int) r1
            r9.f1612j = r10
            float r6 = r8 - r10
            int r7 = r9.f1615m
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
            float r1 = r9.f1612j
            float r1 = r1 - r8
        L_0x0052:
            int r6 = r9.f1605c
            r9.m1140a(r5, r1, r6)
            goto L_0x0029
        L_0x0058:
            float r1 = r9.f1612j
            float r1 = r8 - r1
            goto L_0x0052
        L_0x005d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p000v4.widget.SlidingPaneLayout.m1136a(float):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1137a(int i) {
        if (this.f1610h == null) {
            this.f1611i = BitmapDescriptorFactory.HUE_RED;
            return;
        }
        boolean b = m1145b();
        LayoutParams layoutParams = (LayoutParams) this.f1610h.getLayoutParams();
        int width = this.f1610h.getWidth();
        if (b) {
            i = (getWidth() - i) - width;
        }
        this.f1611i = ((float) (i - ((b ? layoutParams.rightMargin : layoutParams.leftMargin) + (b ? getPaddingRight() : getPaddingLeft())))) / ((float) this.f1613k);
        if (this.f1615m != 0) {
            m1136a(this.f1611i);
        }
        if (layoutParams.f1631b) {
            m1140a(this.f1610h, this.f1611i, this.f1604b);
        }
        mo3378a(this.f1610h);
    }

    /* renamed from: a */
    private void m1140a(View view, float f, int i) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (f > BitmapDescriptorFactory.HUE_RED && i != 0) {
            int i2 = (((int) (((float) ((-16777216 & i) >>> 24)) * f)) << 24) | (16777215 & i);
            if (layoutParams.f1632c == null) {
                layoutParams.f1632c = new Paint();
            }
            layoutParams.f1632c.setColorFilter(new PorterDuffColorFilter(i2, PorterDuff.Mode.SRC_OVER));
            if (ViewCompat.getLayerType(view) != 2) {
                ViewCompat.setLayerType(view, 2, layoutParams.f1632c);
            }
            m1153g(view);
        } else if (ViewCompat.getLayerType(view) != 0) {
            if (layoutParams.f1632c != null) {
                layoutParams.f1632c.setColorFilter((ColorFilter) null);
            }
            DisableLayerRunnable disableLayerRunnable = new DisableLayerRunnable(view);
            this.f1623u.add(disableLayerRunnable);
            ViewCompat.postOnAnimation(this, disableLayerRunnable);
        }
    }

    /* renamed from: a */
    private boolean m1143a(View view, int i) {
        if (!this.f1621s && !mo3379a((float) BitmapDescriptorFactory.HUE_RED, i)) {
            return false;
        }
        this.f1620r = false;
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public boolean m1145b() {
        return ViewCompat.getLayoutDirection(this) == 1;
    }

    /* renamed from: b */
    private boolean m1146b(View view, int i) {
        if (!this.f1621s && !mo3379a(1.0f, i)) {
            return false;
        }
        this.f1620r = true;
        return true;
    }

    /* renamed from: f */
    private static boolean m1151f(View view) {
        if (ViewCompat.isOpaque(view)) {
            return true;
        }
        if (Build.VERSION.SDK_INT >= 18) {
            return false;
        }
        Drawable background = view.getBackground();
        if (background != null) {
            return background.getOpacity() == -1;
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m1153g(View view) {
        f1603a.invalidateChildRegion(this, view);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3377a() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 4) {
                childAt.setVisibility(0);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3378a(View view) {
        if (this.f1618p != null) {
            this.f1618p.onPanelSlide(view, this.f1611i);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo3379a(float f, int i) {
        int paddingLeft;
        if (!this.f1609g) {
            return false;
        }
        boolean b = m1145b();
        LayoutParams layoutParams = (LayoutParams) this.f1610h.getLayoutParams();
        if (b) {
            paddingLeft = (int) (((float) getWidth()) - ((((float) (layoutParams.rightMargin + getPaddingRight())) + (((float) this.f1613k) * f)) + ((float) this.f1610h.getWidth())));
        } else {
            paddingLeft = (int) (((float) (layoutParams.leftMargin + getPaddingLeft())) + (((float) this.f1613k) * f));
        }
        if (!this.f1619q.smoothSlideViewTo(this.f1610h, paddingLeft, this.f1610h.getTop())) {
            return false;
        }
        mo3377a();
        ViewCompat.postInvalidateOnAnimation(this);
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo3380b(View view) {
        if (this.f1618p != null) {
            this.f1618p.onPanelOpened(view);
        }
        sendAccessibilityEvent(32);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo3381c(View view) {
        if (this.f1618p != null) {
            this.f1618p.onPanelClosed(view);
        }
        sendAccessibilityEvent(32);
    }

    @Deprecated
    public boolean canSlide() {
        return this.f1609g;
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public boolean closePane() {
        return m1143a(this.f1610h, 0);
    }

    public void computeScroll() {
        if (!this.f1619q.continueSettling(true)) {
            return;
        }
        if (!this.f1609g) {
            this.f1619q.abort();
        } else {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo3386d(View view) {
        int i;
        int i2;
        int i3;
        int i4;
        boolean b = m1145b();
        int width = b ? getWidth() - getPaddingRight() : getPaddingLeft();
        int paddingLeft = b ? getPaddingLeft() : getWidth() - getPaddingRight();
        int paddingTop = getPaddingTop();
        int height = getHeight() - getPaddingBottom();
        if (view == null || !m1151f(view)) {
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
        int i5 = 0;
        while (i5 < childCount) {
            View childAt = getChildAt(i5);
            if (childAt != view) {
                childAt.setVisibility((Math.max(b ? paddingLeft : width, childAt.getLeft()) < i4 || Math.max(paddingTop, childAt.getTop()) < i2 || Math.min(b ? width : paddingLeft, childAt.getRight()) > i3 || Math.min(height, childAt.getBottom()) > i) ? 0 : 4);
                i5++;
            } else {
                return;
            }
        }
    }

    public void draw(Canvas canvas) {
        int left;
        int i;
        super.draw(canvas);
        Drawable drawable = m1145b() ? this.f1607e : this.f1606d;
        View childAt = getChildCount() > 1 ? getChildAt(1) : null;
        if (childAt != null && drawable != null) {
            int top = childAt.getTop();
            int bottom = childAt.getBottom();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            if (m1145b()) {
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

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j) {
        boolean drawChild;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int save = canvas.save(2);
        if (this.f1609g && !layoutParams.f1630a && this.f1610h != null) {
            canvas.getClipBounds(this.f1622t);
            if (m1145b()) {
                this.f1622t.left = Math.max(this.f1622t.left, this.f1610h.getRight());
            } else {
                this.f1622t.right = Math.min(this.f1622t.right, this.f1610h.getLeft());
            }
            canvas.clipRect(this.f1622t);
        }
        if (Build.VERSION.SDK_INT >= 11) {
            drawChild = super.drawChild(canvas, view, j);
        } else if (!layoutParams.f1631b || this.f1611i <= BitmapDescriptorFactory.HUE_RED) {
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
                canvas.drawBitmap(drawingCache, (float) view.getLeft(), (float) view.getTop(), layoutParams.f1632c);
                drawChild = false;
            } else {
                Log.e("SlidingPaneLayout", "drawChild: child view " + view + " returned null drawing cache");
                drawChild = super.drawChild(canvas, view, j);
            }
        }
        canvas.restoreToCount(save);
        return drawChild;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public boolean mo3389e(View view) {
        if (view == null) {
            return false;
        }
        return this.f1609g && ((LayoutParams) view.getLayoutParams()).f1631b && this.f1611i > BitmapDescriptorFactory.HUE_RED;
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    public int getCoveredFadeColor() {
        return this.f1605c;
    }

    public int getParallaxDistance() {
        return this.f1615m;
    }

    public int getSliderFadeColor() {
        return this.f1604b;
    }

    public boolean isOpen() {
        return !this.f1609g || this.f1611i == 1.0f;
    }

    public boolean isSlideable() {
        return this.f1609g;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f1621s = true;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f1621s = true;
        int size = this.f1623u.size();
        for (int i = 0; i < size; i++) {
            this.f1623u.get(i).run();
        }
        this.f1623u.clear();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r8) {
        /*
            r7 = this;
            r2 = 0
            r1 = 1
            int r3 = android.support.p000v4.view.MotionEventCompat.getActionMasked(r8)
            boolean r0 = r7.f1609g
            if (r0 != 0) goto L_0x002d
            if (r3 != 0) goto L_0x002d
            int r0 = r7.getChildCount()
            if (r0 <= r1) goto L_0x002d
            android.view.View r0 = r7.getChildAt(r1)
            if (r0 == 0) goto L_0x002d
            android.support.v4.widget.ViewDragHelper r4 = r7.f1619q
            float r5 = r8.getX()
            int r5 = (int) r5
            float r6 = r8.getY()
            int r6 = (int) r6
            boolean r0 = r4.isViewUnder(r0, r5, r6)
            if (r0 != 0) goto L_0x0041
            r0 = r1
        L_0x002b:
            r7.f1620r = r0
        L_0x002d:
            boolean r0 = r7.f1609g
            if (r0 == 0) goto L_0x0037
            boolean r0 = r7.f1614l
            if (r0 == 0) goto L_0x0043
            if (r3 == 0) goto L_0x0043
        L_0x0037:
            android.support.v4.widget.ViewDragHelper r0 = r7.f1619q
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
            android.support.v4.widget.ViewDragHelper r0 = r7.f1619q
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
            android.support.v4.widget.ViewDragHelper r3 = r7.f1619q
            boolean r3 = r3.shouldInterceptTouchEvent(r8)
            if (r3 != 0) goto L_0x005c
            if (r0 == 0) goto L_0x0040
        L_0x005c:
            r2 = r1
            goto L_0x0040
        L_0x005e:
            r7.f1614l = r2
            float r0 = r8.getX()
            float r3 = r8.getY()
            r7.f1616n = r0
            r7.f1617o = r3
            android.support.v4.widget.ViewDragHelper r4 = r7.f1619q
            android.view.View r5 = r7.f1610h
            int r0 = (int) r0
            int r3 = (int) r3
            boolean r0 = r4.isViewUnder(r5, r0, r3)
            if (r0 == 0) goto L_0x0051
            android.view.View r0 = r7.f1610h
            boolean r0 = r7.mo3389e((android.view.View) r0)
            if (r0 == 0) goto L_0x0051
            r0 = r1
            goto L_0x0052
        L_0x0082:
            float r0 = r8.getX()
            float r3 = r8.getY()
            float r4 = r7.f1616n
            float r0 = r0 - r4
            float r0 = java.lang.Math.abs(r0)
            float r4 = r7.f1617o
            float r3 = r3 - r4
            float r3 = java.lang.Math.abs(r3)
            android.support.v4.widget.ViewDragHelper r4 = r7.f1619q
            int r4 = r4.getTouchSlop()
            float r4 = (float) r4
            int r4 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r4 <= 0) goto L_0x0051
            int r0 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x0051
            android.support.v4.widget.ViewDragHelper r0 = r7.f1619q
            r0.cancel()
            r7.f1614l = r1
            goto L_0x0040
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p000v4.widget.SlidingPaneLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int width;
        int i9;
        boolean b = m1145b();
        if (b) {
            this.f1619q.setEdgeTrackingEnabled(2);
        } else {
            this.f1619q.setEdgeTrackingEnabled(1);
        }
        int i10 = i3 - i;
        int paddingRight = b ? getPaddingRight() : getPaddingLeft();
        int paddingLeft = b ? getPaddingLeft() : getPaddingRight();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        if (this.f1621s) {
            this.f1611i = (!this.f1609g || !this.f1620r) ? BitmapDescriptorFactory.HUE_RED : 1.0f;
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
                if (layoutParams.f1630a) {
                    int min = (Math.min(paddingRight, (i10 - paddingLeft) - this.f1608f) - i12) - (layoutParams.leftMargin + layoutParams.rightMargin);
                    this.f1613k = min;
                    int i13 = b ? layoutParams.rightMargin : layoutParams.leftMargin;
                    layoutParams.f1631b = ((i12 + i13) + min) + (measuredWidth / 2) > i10 - paddingLeft;
                    int i14 = (int) (((float) min) * this.f1611i);
                    i6 = i12 + i13 + i14;
                    this.f1611i = ((float) i14) / ((float) this.f1613k);
                    i5 = 0;
                } else if (!this.f1609g || this.f1615m == 0) {
                    i5 = 0;
                    i6 = paddingRight;
                } else {
                    i5 = (int) ((1.0f - this.f1611i) * ((float) this.f1615m));
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
        if (this.f1621s) {
            if (this.f1609g) {
                if (this.f1615m != 0) {
                    m1136a(this.f1611i);
                }
                if (((LayoutParams) this.f1610h.getLayoutParams()).f1631b) {
                    m1140a(this.f1610h, this.f1611i, this.f1604b);
                }
            } else {
                for (int i15 = 0; i15 < childCount; i15++) {
                    m1140a(getChildAt(i15), BitmapDescriptorFactory.HUE_RED, this.f1604b);
                }
            }
            mo3386d(this.f1610h);
        }
        this.f1621s = false;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int paddingTop;
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
            case Integer.MIN_VALUE:
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
        this.f1610h = null;
        int i9 = 0;
        int i10 = paddingLeft;
        int i11 = i6;
        float f2 = 0.0f;
        while (i9 < childCount) {
            View childAt = getChildAt(i9);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (childAt.getVisibility() == 8) {
                layoutParams.f1631b = false;
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
                childAt.measure(layoutParams.width == -2 ? View.MeasureSpec.makeMeasureSpec(paddingLeft - i12, Integer.MIN_VALUE) : layoutParams.width == -1 ? View.MeasureSpec.makeMeasureSpec(paddingLeft - i12, 1073741824) : View.MeasureSpec.makeMeasureSpec(layoutParams.width, 1073741824), layoutParams.height == -2 ? View.MeasureSpec.makeMeasureSpec(paddingTop, Integer.MIN_VALUE) : layoutParams.height == -1 ? View.MeasureSpec.makeMeasureSpec(paddingTop, 1073741824) : View.MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824));
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (i3 == Integer.MIN_VALUE && measuredHeight > i11) {
                    i11 = Math.min(measuredHeight, paddingTop);
                }
                int i13 = i10 - measuredWidth;
                boolean z3 = i13 < 0;
                layoutParams.f1630a = z3;
                boolean z4 = z3 | z2;
                if (layoutParams.f1630a) {
                    this.f1610h = childAt;
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
            int i14 = paddingLeft - this.f1608f;
            for (int i15 = 0; i15 < childCount; i15++) {
                View childAt2 = getChildAt(i15);
                if (childAt2.getVisibility() != 8) {
                    LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                    if (childAt2.getVisibility() != 8) {
                        boolean z5 = layoutParams2.width == 0 && layoutParams2.weight > BitmapDescriptorFactory.HUE_RED;
                        int measuredWidth2 = z5 ? 0 : childAt2.getMeasuredWidth();
                        if (!z2 || childAt2 == this.f1610h) {
                            if (layoutParams2.weight > BitmapDescriptorFactory.HUE_RED) {
                                int makeMeasureSpec = layoutParams2.width == 0 ? layoutParams2.height == -2 ? View.MeasureSpec.makeMeasureSpec(paddingTop, Integer.MIN_VALUE) : layoutParams2.height == -1 ? View.MeasureSpec.makeMeasureSpec(paddingTop, 1073741824) : View.MeasureSpec.makeMeasureSpec(layoutParams2.height, 1073741824) : View.MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                                if (z2) {
                                    int i16 = paddingLeft - (layoutParams2.rightMargin + layoutParams2.leftMargin);
                                    int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i16, 1073741824);
                                    if (measuredWidth2 != i16) {
                                        childAt2.measure(makeMeasureSpec2, makeMeasureSpec);
                                    }
                                } else {
                                    childAt2.measure(View.MeasureSpec.makeMeasureSpec(((int) ((layoutParams2.weight * ((float) Math.max(0, i10))) / f2)) + measuredWidth2, 1073741824), makeMeasureSpec);
                                }
                            }
                        } else if (layoutParams2.width < 0 && (measuredWidth2 > i14 || layoutParams2.weight > BitmapDescriptorFactory.HUE_RED)) {
                            childAt2.measure(View.MeasureSpec.makeMeasureSpec(i14, 1073741824), z5 ? layoutParams2.height == -2 ? View.MeasureSpec.makeMeasureSpec(paddingTop, Integer.MIN_VALUE) : layoutParams2.height == -1 ? View.MeasureSpec.makeMeasureSpec(paddingTop, 1073741824) : View.MeasureSpec.makeMeasureSpec(layoutParams2.height, 1073741824) : View.MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824));
                        }
                    }
                }
            }
        }
        setMeasuredDimension(i4, getPaddingTop() + i11 + getPaddingBottom());
        this.f1609g = z2;
        if (this.f1619q.getViewDragState() != 0 && !z2) {
            this.f1619q.abort();
        }
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.f1633a) {
            openPane();
        } else {
            closePane();
        }
        this.f1620r = savedState.f1633a;
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f1633a = isSlideable() ? isOpen() : this.f1620r;
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            this.f1621s = true;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f1609g) {
            return super.onTouchEvent(motionEvent);
        }
        this.f1619q.processTouchEvent(motionEvent);
        switch (motionEvent.getAction() & 255) {
            case 0:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                this.f1616n = x;
                this.f1617o = y;
                return true;
            case 1:
                if (!mo3389e(this.f1610h)) {
                    return true;
                }
                float x2 = motionEvent.getX();
                float y2 = motionEvent.getY();
                float f = x2 - this.f1616n;
                float f2 = y2 - this.f1617o;
                int touchSlop = this.f1619q.getTouchSlop();
                if ((f * f) + (f2 * f2) >= ((float) (touchSlop * touchSlop)) || !this.f1619q.isViewUnder(this.f1610h, (int) x2, (int) y2)) {
                    return true;
                }
                m1143a(this.f1610h, 0);
                return true;
            default:
                return true;
        }
    }

    public boolean openPane() {
        return m1146b(this.f1610h, 0);
    }

    public void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        if (!isInTouchMode() && !this.f1609g) {
            this.f1620r = view == this.f1610h;
        }
    }

    public void setCoveredFadeColor(int i) {
        this.f1605c = i;
    }

    public void setPanelSlideListener(PanelSlideListener panelSlideListener) {
        this.f1618p = panelSlideListener;
    }

    public void setParallaxDistance(int i) {
        this.f1615m = i;
        requestLayout();
    }

    @Deprecated
    public void setShadowDrawable(Drawable drawable) {
        setShadowDrawableLeft(drawable);
    }

    public void setShadowDrawableLeft(Drawable drawable) {
        this.f1606d = drawable;
    }

    public void setShadowDrawableRight(Drawable drawable) {
        this.f1607e = drawable;
    }

    @Deprecated
    public void setShadowResource(int i) {
        setShadowDrawable(getResources().getDrawable(i));
    }

    public void setShadowResourceLeft(int i) {
        setShadowDrawableLeft(getResources().getDrawable(i));
    }

    public void setShadowResourceRight(int i) {
        setShadowDrawableRight(getResources().getDrawable(i));
    }

    public void setSliderFadeColor(int i) {
        this.f1604b = i;
    }

    @Deprecated
    public void smoothSlideClosed() {
        closePane();
    }

    @Deprecated
    public void smoothSlideOpen() {
        openPane();
    }
}
