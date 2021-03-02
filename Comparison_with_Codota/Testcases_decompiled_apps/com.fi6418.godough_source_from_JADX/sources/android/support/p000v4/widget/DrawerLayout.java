package android.support.p000v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.p000v4.content.ContextCompat;
import android.support.p000v4.graphics.drawable.DrawableCompat;
import android.support.p000v4.view.AccessibilityDelegateCompat;
import android.support.p000v4.view.GravityCompat;
import android.support.p000v4.view.KeyEventCompat;
import android.support.p000v4.view.ViewCompat;
import android.support.p000v4.view.ViewGroupCompat;
import android.support.p000v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.p000v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;
import java.util.List;

/* renamed from: android.support.v4.widget.DrawerLayout */
public class DrawerLayout extends ViewGroup implements DrawerLayoutImpl {
    public static final int LOCK_MODE_LOCKED_CLOSED = 1;
    public static final int LOCK_MODE_LOCKED_OPEN = 2;
    public static final int LOCK_MODE_UNLOCKED = 0;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;

    /* renamed from: a */
    static final DrawerLayoutCompatImpl f1441a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final int[] f1442b = {16842931};
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final boolean f1443c = (Build.VERSION.SDK_INT >= 19);

    /* renamed from: d */
    private static final boolean f1444d;

    /* renamed from: A */
    private Drawable f1445A;

    /* renamed from: B */
    private CharSequence f1446B;

    /* renamed from: C */
    private CharSequence f1447C;

    /* renamed from: D */
    private Object f1448D;

    /* renamed from: E */
    private boolean f1449E;

    /* renamed from: F */
    private Drawable f1450F;

    /* renamed from: G */
    private Drawable f1451G;

    /* renamed from: H */
    private Drawable f1452H;

    /* renamed from: I */
    private Drawable f1453I;

    /* renamed from: J */
    private final ArrayList<View> f1454J;

    /* renamed from: e */
    private final ChildAccessibilityDelegate f1455e;

    /* renamed from: f */
    private float f1456f;

    /* renamed from: g */
    private int f1457g;

    /* renamed from: h */
    private int f1458h;

    /* renamed from: i */
    private float f1459i;

    /* renamed from: j */
    private Paint f1460j;

    /* renamed from: k */
    private final ViewDragHelper f1461k;

    /* renamed from: l */
    private final ViewDragHelper f1462l;

    /* renamed from: m */
    private final ViewDragCallback f1463m;

    /* renamed from: n */
    private final ViewDragCallback f1464n;

    /* renamed from: o */
    private int f1465o;

    /* renamed from: p */
    private boolean f1466p;

    /* renamed from: q */
    private boolean f1467q;

    /* renamed from: r */
    private int f1468r;

    /* renamed from: s */
    private int f1469s;

    /* renamed from: t */
    private boolean f1470t;

    /* renamed from: u */
    private boolean f1471u;

    /* renamed from: v */
    private DrawerListener f1472v;

    /* renamed from: w */
    private float f1473w;

    /* renamed from: x */
    private float f1474x;

    /* renamed from: y */
    private Drawable f1475y;

    /* renamed from: z */
    private Drawable f1476z;

    /* renamed from: android.support.v4.widget.DrawerLayout$AccessibilityDelegate */
    class AccessibilityDelegate extends AccessibilityDelegateCompat {

        /* renamed from: c */
        private final Rect f1478c = new Rect();

        AccessibilityDelegate() {
        }

        /* renamed from: a */
        private void m1061a(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2) {
            Rect rect = this.f1478c;
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
        }

        /* renamed from: a */
        private void m1062a(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, ViewGroup viewGroup) {
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (DrawerLayout.m1045i(childAt)) {
                    accessibilityNodeInfoCompat.addChild(childAt);
                }
            }
        }

        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            CharSequence drawerTitle;
            if (accessibilityEvent.getEventType() != 32) {
                return super.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
            }
            List text = accessibilityEvent.getText();
            View a = DrawerLayout.this.m1046j();
            if (!(a == null || (drawerTitle = DrawerLayout.this.getDrawerTitle(DrawerLayout.this.mo3105d(a))) == null)) {
                text.add(drawerTitle);
            }
            return true;
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(DrawerLayout.class.getName());
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            if (DrawerLayout.f1443c) {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            } else {
                AccessibilityNodeInfoCompat obtain = AccessibilityNodeInfoCompat.obtain(accessibilityNodeInfoCompat);
                super.onInitializeAccessibilityNodeInfo(view, obtain);
                accessibilityNodeInfoCompat.setSource(view);
                ViewParent parentForAccessibility = ViewCompat.getParentForAccessibility(view);
                if (parentForAccessibility instanceof View) {
                    accessibilityNodeInfoCompat.setParent((View) parentForAccessibility);
                }
                m1061a(accessibilityNodeInfoCompat, obtain);
                obtain.recycle();
                m1062a(accessibilityNodeInfoCompat, (ViewGroup) view);
            }
            accessibilityNodeInfoCompat.setClassName(DrawerLayout.class.getName());
            accessibilityNodeInfoCompat.setFocusable(false);
            accessibilityNodeInfoCompat.setFocused(false);
            accessibilityNodeInfoCompat.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_FOCUS);
            accessibilityNodeInfoCompat.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLEAR_FOCUS);
        }

        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (DrawerLayout.f1443c || DrawerLayout.m1045i(view)) {
                return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
            }
            return false;
        }
    }

    /* renamed from: android.support.v4.widget.DrawerLayout$ChildAccessibilityDelegate */
    final class ChildAccessibilityDelegate extends AccessibilityDelegateCompat {
        ChildAccessibilityDelegate() {
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            if (!DrawerLayout.m1045i(view)) {
                accessibilityNodeInfoCompat.setParent((View) null);
            }
        }
    }

    /* renamed from: android.support.v4.widget.DrawerLayout$DrawerLayoutCompatImpl */
    interface DrawerLayoutCompatImpl {
        void applyMarginInsets(ViewGroup.MarginLayoutParams marginLayoutParams, Object obj, int i);

        void configureApplyInsets(View view);

        void dispatchChildInsets(View view, Object obj, int i);

        Drawable getDefaultStatusBarBackground(Context context);

        int getTopInset(Object obj);
    }

    /* renamed from: android.support.v4.widget.DrawerLayout$DrawerLayoutCompatImplApi21 */
    class DrawerLayoutCompatImplApi21 implements DrawerLayoutCompatImpl {
        DrawerLayoutCompatImplApi21() {
        }

        public void applyMarginInsets(ViewGroup.MarginLayoutParams marginLayoutParams, Object obj, int i) {
            DrawerLayoutCompatApi21.applyMarginInsets(marginLayoutParams, obj, i);
        }

        public void configureApplyInsets(View view) {
            DrawerLayoutCompatApi21.configureApplyInsets(view);
        }

        public void dispatchChildInsets(View view, Object obj, int i) {
            DrawerLayoutCompatApi21.dispatchChildInsets(view, obj, i);
        }

        public Drawable getDefaultStatusBarBackground(Context context) {
            return DrawerLayoutCompatApi21.getDefaultStatusBarBackground(context);
        }

        public int getTopInset(Object obj) {
            return DrawerLayoutCompatApi21.getTopInset(obj);
        }
    }

    /* renamed from: android.support.v4.widget.DrawerLayout$DrawerLayoutCompatImplBase */
    class DrawerLayoutCompatImplBase implements DrawerLayoutCompatImpl {
        DrawerLayoutCompatImplBase() {
        }

        public void applyMarginInsets(ViewGroup.MarginLayoutParams marginLayoutParams, Object obj, int i) {
        }

        public void configureApplyInsets(View view) {
        }

        public void dispatchChildInsets(View view, Object obj, int i) {
        }

        public Drawable getDefaultStatusBarBackground(Context context) {
            return null;
        }

        public int getTopInset(Object obj) {
            return 0;
        }
    }

    /* renamed from: android.support.v4.widget.DrawerLayout$DrawerListener */
    public interface DrawerListener {
        void onDrawerClosed(View view);

        void onDrawerOpened(View view);

        void onDrawerSlide(View view, float f);

        void onDrawerStateChanged(int i);
    }

    /* renamed from: android.support.v4.widget.DrawerLayout$LayoutParams */
    public class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* renamed from: a */
        float f1480a;

        /* renamed from: b */
        boolean f1481b;

        /* renamed from: c */
        boolean f1482c;
        public int gravity;

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.gravity = 0;
        }

        public LayoutParams(int i, int i2, int i3) {
            this(i, i2);
            this.gravity = i3;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.gravity = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, DrawerLayout.f1442b);
            this.gravity = obtainStyledAttributes.getInt(0, 0);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.gravity = 0;
            this.gravity = layoutParams.gravity;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.gravity = 0;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.gravity = 0;
        }
    }

    /* renamed from: android.support.v4.widget.DrawerLayout$SavedState */
    public class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };

        /* renamed from: a */
        int f1483a = 0;

        /* renamed from: b */
        int f1484b = 0;

        /* renamed from: c */
        int f1485c = 0;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f1483a = parcel.readInt();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f1483a);
        }
    }

    /* renamed from: android.support.v4.widget.DrawerLayout$SimpleDrawerListener */
    public abstract class SimpleDrawerListener implements DrawerListener {
        public void onDrawerClosed(View view) {
        }

        public void onDrawerOpened(View view) {
        }

        public void onDrawerSlide(View view, float f) {
        }

        public void onDrawerStateChanged(int i) {
        }
    }

    /* renamed from: android.support.v4.widget.DrawerLayout$ViewDragCallback */
    class ViewDragCallback extends ViewDragHelper.Callback {

        /* renamed from: b */
        private final int f1487b;

        /* renamed from: c */
        private ViewDragHelper f1488c;

        /* renamed from: d */
        private final Runnable f1489d = new Runnable() {
            public void run() {
                ViewDragCallback.this.m1065b();
            }
        };

        public ViewDragCallback(int i) {
            this.f1487b = i;
        }

        /* renamed from: a */
        private void m1063a() {
            int i = 3;
            if (this.f1487b == 3) {
                i = 5;
            }
            View a = DrawerLayout.this.mo3088a(i);
            if (a != null) {
                DrawerLayout.this.closeDrawer(a);
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public void m1065b() {
            View view;
            int i;
            int i2 = 0;
            int edgeSize = this.f1488c.getEdgeSize();
            boolean z = this.f1487b == 3;
            if (z) {
                View a = DrawerLayout.this.mo3088a(3);
                if (a != null) {
                    i2 = -a.getWidth();
                }
                int i3 = i2 + edgeSize;
                view = a;
                i = i3;
            } else {
                View a2 = DrawerLayout.this.mo3088a(5);
                int width = DrawerLayout.this.getWidth() - edgeSize;
                view = a2;
                i = width;
            }
            if (view == null) {
                return;
            }
            if (((z && view.getLeft() < i) || (!z && view.getLeft() > i)) && DrawerLayout.this.getDrawerLockMode(view) == 0) {
                this.f1488c.smoothSlideViewTo(view, i, view.getTop());
                ((LayoutParams) view.getLayoutParams()).f1481b = true;
                DrawerLayout.this.invalidate();
                m1063a();
                DrawerLayout.this.mo3096b();
            }
        }

        public int clampViewPositionHorizontal(View view, int i, int i2) {
            if (DrawerLayout.this.mo3093a(view, 3)) {
                return Math.max(-view.getWidth(), Math.min(i, 0));
            }
            int width = DrawerLayout.this.getWidth();
            return Math.max(width - view.getWidth(), Math.min(i, width));
        }

        public int clampViewPositionVertical(View view, int i, int i2) {
            return view.getTop();
        }

        public int getViewHorizontalDragRange(View view) {
            if (DrawerLayout.this.mo3108f(view)) {
                return view.getWidth();
            }
            return 0;
        }

        public void onEdgeDragStarted(int i, int i2) {
            View a = (i & 1) == 1 ? DrawerLayout.this.mo3088a(3) : DrawerLayout.this.mo3088a(5);
            if (a != null && DrawerLayout.this.getDrawerLockMode(a) == 0) {
                this.f1488c.captureChildView(a, i2);
            }
        }

        public boolean onEdgeLock(int i) {
            return false;
        }

        public void onEdgeTouched(int i, int i2) {
            DrawerLayout.this.postDelayed(this.f1489d, 160);
        }

        public void onViewCaptured(View view, int i) {
            ((LayoutParams) view.getLayoutParams()).f1481b = false;
            m1063a();
        }

        public void onViewDragStateChanged(int i) {
            DrawerLayout.this.mo3089a(this.f1487b, i, this.f1488c.getCapturedView());
        }

        public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
            int width = view.getWidth();
            float width2 = DrawerLayout.this.mo3093a(view, 3) ? ((float) (width + i)) / ((float) width) : ((float) (DrawerLayout.this.getWidth() - i)) / ((float) width);
            DrawerLayout.this.mo3098b(view, width2);
            view.setVisibility(width2 == BitmapDescriptorFactory.HUE_RED ? 4 : 0);
            DrawerLayout.this.invalidate();
        }

        public void onViewReleased(View view, float f, float f2) {
            int width;
            float c = DrawerLayout.this.mo3099c(view);
            int width2 = view.getWidth();
            if (DrawerLayout.this.mo3093a(view, 3)) {
                width = (f > BitmapDescriptorFactory.HUE_RED || (f == BitmapDescriptorFactory.HUE_RED && c > 0.5f)) ? 0 : -width2;
            } else {
                width = DrawerLayout.this.getWidth();
                if (f < BitmapDescriptorFactory.HUE_RED || (f == BitmapDescriptorFactory.HUE_RED && c > 0.5f)) {
                    width -= width2;
                }
            }
            this.f1488c.settleCapturedViewAt(width, view.getTop());
            DrawerLayout.this.invalidate();
        }

        public void removeCallbacks() {
            DrawerLayout.this.removeCallbacks(this.f1489d);
        }

        public void setDragger(ViewDragHelper viewDragHelper) {
            this.f1488c = viewDragHelper;
        }

        public boolean tryCaptureView(View view, int i) {
            return DrawerLayout.this.mo3108f(view) && DrawerLayout.this.mo3093a(view, this.f1487b) && DrawerLayout.this.getDrawerLockMode(view) == 0;
        }
    }

    static {
        boolean z = true;
        if (Build.VERSION.SDK_INT < 21) {
            z = false;
        }
        f1444d = z;
        if (Build.VERSION.SDK_INT >= 21) {
            f1441a = new DrawerLayoutCompatImplApi21();
        } else {
            f1441a = new DrawerLayoutCompatImplBase();
        }
    }

    public DrawerLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public DrawerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DrawerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1455e = new ChildAccessibilityDelegate();
        this.f1458h = -1728053248;
        this.f1460j = new Paint();
        this.f1467q = true;
        this.f1450F = null;
        this.f1451G = null;
        this.f1452H = null;
        this.f1453I = null;
        setDescendantFocusability(262144);
        float f = getResources().getDisplayMetrics().density;
        this.f1457g = (int) ((64.0f * f) + 0.5f);
        float f2 = 400.0f * f;
        this.f1463m = new ViewDragCallback(3);
        this.f1464n = new ViewDragCallback(5);
        this.f1461k = ViewDragHelper.create(this, 1.0f, this.f1463m);
        this.f1461k.setEdgeTrackingEnabled(1);
        this.f1461k.setMinVelocity(f2);
        this.f1463m.setDragger(this.f1461k);
        this.f1462l = ViewDragHelper.create(this, 1.0f, this.f1464n);
        this.f1462l.setEdgeTrackingEnabled(2);
        this.f1462l.setMinVelocity(f2);
        this.f1464n.setDragger(this.f1462l);
        setFocusableInTouchMode(true);
        ViewCompat.setImportantForAccessibility(this, 1);
        ViewCompat.setAccessibilityDelegate(this, new AccessibilityDelegate());
        ViewGroupCompat.setMotionEventSplittingEnabled(this, false);
        if (ViewCompat.getFitsSystemWindows(this)) {
            f1441a.configureApplyInsets(this);
            this.f1475y = f1441a.getDefaultStatusBarBackground(context);
        }
        this.f1456f = f * 10.0f;
        this.f1454J = new ArrayList<>();
    }

    /* renamed from: a */
    private void m1033a(View view, boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((z || mo3108f(childAt)) && (!z || childAt != view)) {
                ViewCompat.setImportantForAccessibility(childAt, 4);
            } else {
                ViewCompat.setImportantForAccessibility(childAt, 1);
            }
        }
    }

    /* renamed from: a */
    private boolean m1034a(Drawable drawable, int i) {
        if (drawable == null || !DrawableCompat.isAutoMirrored(drawable)) {
            return false;
        }
        DrawableCompat.setLayoutDirection(drawable, i);
        return true;
    }

    /* renamed from: b */
    static String m1035b(int i) {
        return (i & 3) == 3 ? "LEFT" : (i & 5) == 5 ? "RIGHT" : Integer.toHexString(i);
    }

    /* renamed from: e */
    private void m1038e() {
        if (!f1444d) {
            this.f1476z = m1039f();
            this.f1445A = m1040g();
        }
    }

    /* renamed from: f */
    private Drawable m1039f() {
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        if (layoutDirection == 0) {
            if (this.f1450F != null) {
                m1034a(this.f1450F, layoutDirection);
                return this.f1450F;
            }
        } else if (this.f1451G != null) {
            m1034a(this.f1451G, layoutDirection);
            return this.f1451G;
        }
        return this.f1452H;
    }

    /* renamed from: g */
    private Drawable m1040g() {
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        if (layoutDirection == 0) {
            if (this.f1451G != null) {
                m1034a(this.f1451G, layoutDirection);
                return this.f1451G;
            }
        } else if (this.f1450F != null) {
            m1034a(this.f1450F, layoutDirection);
            return this.f1450F;
        }
        return this.f1453I;
    }

    /* renamed from: h */
    private boolean m1042h() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (((LayoutParams) getChildAt(i).getLayoutParams()).f1481b) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: h */
    private static boolean m1043h(View view) {
        Drawable background = view.getBackground();
        return background != null && background.getOpacity() == -1;
    }

    /* renamed from: i */
    private boolean m1044i() {
        return m1046j() != null;
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public static boolean m1045i(View view) {
        return (ViewCompat.getImportantForAccessibility(view) == 4 || ViewCompat.getImportantForAccessibility(view) == 2) ? false : true;
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public View m1046j() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (mo3108f(childAt) && isDrawerVisible(childAt)) {
                return childAt;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public View mo3087a() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (((LayoutParams) childAt.getLayoutParams()).f1482c) {
                return childAt;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public View mo3088a(int i) {
        int absoluteGravity = GravityCompat.getAbsoluteGravity(i, ViewCompat.getLayoutDirection(this)) & 7;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((mo3105d(childAt) & 7) == absoluteGravity) {
                return childAt;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3089a(int i, int i2, View view) {
        int i3 = 1;
        int viewDragState = this.f1461k.getViewDragState();
        int viewDragState2 = this.f1462l.getViewDragState();
        if (!(viewDragState == 1 || viewDragState2 == 1)) {
            i3 = (viewDragState == 2 || viewDragState2 == 2) ? 2 : 0;
        }
        if (view != null && i2 == 0) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (layoutParams.f1480a == BitmapDescriptorFactory.HUE_RED) {
                mo3090a(view);
            } else if (layoutParams.f1480a == 1.0f) {
                mo3097b(view);
            }
        }
        if (i3 != this.f1465o) {
            this.f1465o = i3;
            if (this.f1472v != null) {
                this.f1472v.onDrawerStateChanged(i3);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3090a(View view) {
        View rootView;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams.f1482c) {
            layoutParams.f1482c = false;
            if (this.f1472v != null) {
                this.f1472v.onDrawerClosed(view);
            }
            m1033a(view, false);
            if (hasWindowFocus() && (rootView = getRootView()) != null) {
                rootView.sendAccessibilityEvent(32);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3091a(View view, float f) {
        if (this.f1472v != null) {
            this.f1472v.onDrawerSlide(view, f);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3092a(boolean z) {
        int childCount = getChildCount();
        boolean z2 = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (mo3108f(childAt) && (!z || layoutParams.f1481b)) {
                z2 = mo3093a(childAt, 3) ? z2 | this.f1461k.smoothSlideViewTo(childAt, -childAt.getWidth(), childAt.getTop()) : z2 | this.f1462l.smoothSlideViewTo(childAt, getWidth(), childAt.getTop());
                layoutParams.f1481b = false;
            }
        }
        this.f1463m.removeCallbacks();
        this.f1464n.removeCallbacks();
        if (z2) {
            invalidate();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo3093a(View view, int i) {
        return (mo3105d(view) & i) == i;
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        if (getDescendantFocusability() != 393216) {
            int childCount = getChildCount();
            boolean z = false;
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (!mo3108f(childAt)) {
                    this.f1454J.add(childAt);
                } else if (isDrawerOpen(childAt)) {
                    z = true;
                    childAt.addFocusables(arrayList, i, i2);
                }
            }
            if (!z) {
                int size = this.f1454J.size();
                for (int i4 = 0; i4 < size; i4++) {
                    View view = this.f1454J.get(i4);
                    if (view.getVisibility() == 0) {
                        view.addFocusables(arrayList, i, i2);
                    }
                }
            }
            this.f1454J.clear();
        }
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (mo3087a() != null || mo3108f(view)) {
            ViewCompat.setImportantForAccessibility(view, 4);
        } else {
            ViewCompat.setImportantForAccessibility(view, 1);
        }
        if (!f1443c) {
            ViewCompat.setAccessibilityDelegate(view, this.f1455e);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo3096b() {
        if (!this.f1471u) {
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 0);
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                getChildAt(i).dispatchTouchEvent(obtain);
            }
            obtain.recycle();
            this.f1471u = true;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo3097b(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!layoutParams.f1482c) {
            layoutParams.f1482c = true;
            if (this.f1472v != null) {
                this.f1472v.onDrawerOpened(view);
            }
            m1033a(view, true);
            if (hasWindowFocus()) {
                sendAccessibilityEvent(32);
            }
            view.requestFocus();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo3098b(View view, float f) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (f != layoutParams.f1480a) {
            layoutParams.f1480a = f;
            mo3091a(view, f);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public float mo3099c(View view) {
        return ((LayoutParams) view.getLayoutParams()).f1480a;
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public void closeDrawer(int i) {
        View a = mo3088a(i);
        if (a == null) {
            throw new IllegalArgumentException("No drawer view found with gravity " + m1035b(i));
        }
        closeDrawer(a);
    }

    public void closeDrawer(View view) {
        if (!mo3108f(view)) {
            throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
        }
        if (this.f1467q) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.f1480a = BitmapDescriptorFactory.HUE_RED;
            layoutParams.f1482c = false;
        } else if (mo3093a(view, 3)) {
            this.f1461k.smoothSlideViewTo(view, -view.getWidth(), view.getTop());
        } else {
            this.f1462l.smoothSlideViewTo(view, getWidth(), view.getTop());
        }
        invalidate();
    }

    public void closeDrawers() {
        mo3092a(false);
    }

    public void computeScroll() {
        int childCount = getChildCount();
        float f = 0.0f;
        for (int i = 0; i < childCount; i++) {
            f = Math.max(f, ((LayoutParams) getChildAt(i).getLayoutParams()).f1480a);
        }
        this.f1459i = f;
        if (this.f1461k.continueSettling(true) || this.f1462l.continueSettling(true)) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public int mo3105d(View view) {
        return GravityCompat.getAbsoluteGravity(((LayoutParams) view.getLayoutParams()).gravity, ViewCompat.getLayoutDirection(this));
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j) {
        int i;
        int height = getHeight();
        boolean e = mo3107e(view);
        int i2 = 0;
        int width = getWidth();
        int save = canvas.save();
        if (e) {
            int childCount = getChildCount();
            int i3 = 0;
            while (i3 < childCount) {
                View childAt = getChildAt(i3);
                if (childAt != view && childAt.getVisibility() == 0 && m1043h(childAt) && mo3108f(childAt)) {
                    if (childAt.getHeight() < height) {
                        i = width;
                    } else if (mo3093a(childAt, 3)) {
                        int right = childAt.getRight();
                        if (right <= i2) {
                            right = i2;
                        }
                        i2 = right;
                        i = width;
                    } else {
                        i = childAt.getLeft();
                        if (i < width) {
                        }
                    }
                    i3++;
                    width = i;
                }
                i = width;
                i3++;
                width = i;
            }
            canvas.clipRect(i2, 0, width, getHeight());
        }
        int i4 = width;
        boolean drawChild = super.drawChild(canvas, view, j);
        canvas.restoreToCount(save);
        if (this.f1459i > BitmapDescriptorFactory.HUE_RED && e) {
            this.f1460j.setColor((((int) (((float) ((this.f1458h & ViewCompat.MEASURED_STATE_MASK) >>> 24)) * this.f1459i)) << 24) | (this.f1458h & ViewCompat.MEASURED_SIZE_MASK));
            canvas.drawRect((float) i2, BitmapDescriptorFactory.HUE_RED, (float) i4, (float) getHeight(), this.f1460j);
        } else if (this.f1476z != null && mo3093a(view, 3)) {
            int intrinsicWidth = this.f1476z.getIntrinsicWidth();
            int right2 = view.getRight();
            float max = Math.max(BitmapDescriptorFactory.HUE_RED, Math.min(((float) right2) / ((float) this.f1461k.getEdgeSize()), 1.0f));
            this.f1476z.setBounds(right2, view.getTop(), intrinsicWidth + right2, view.getBottom());
            this.f1476z.setAlpha((int) (255.0f * max));
            this.f1476z.draw(canvas);
        } else if (this.f1445A != null && mo3093a(view, 5)) {
            int intrinsicWidth2 = this.f1445A.getIntrinsicWidth();
            int left = view.getLeft();
            float max2 = Math.max(BitmapDescriptorFactory.HUE_RED, Math.min(((float) (getWidth() - left)) / ((float) this.f1462l.getEdgeSize()), 1.0f));
            this.f1445A.setBounds(left - intrinsicWidth2, view.getTop(), left, view.getBottom());
            this.f1445A.setAlpha((int) (255.0f * max2));
            this.f1445A.draw(canvas);
        }
        return drawChild;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public boolean mo3107e(View view) {
        return ((LayoutParams) view.getLayoutParams()).gravity == 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public boolean mo3108f(View view) {
        return (GravityCompat.getAbsoluteGravity(((LayoutParams) view.getLayoutParams()).gravity, ViewCompat.getLayoutDirection(view)) & 7) != 0;
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams ? new LayoutParams((LayoutParams) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    public float getDrawerElevation() {
        return f1444d ? this.f1456f : BitmapDescriptorFactory.HUE_RED;
    }

    public int getDrawerLockMode(int i) {
        int absoluteGravity = GravityCompat.getAbsoluteGravity(i, ViewCompat.getLayoutDirection(this));
        if (absoluteGravity == 3) {
            return this.f1468r;
        }
        if (absoluteGravity == 5) {
            return this.f1469s;
        }
        return 0;
    }

    public int getDrawerLockMode(View view) {
        int d = mo3105d(view);
        if (d == 3) {
            return this.f1468r;
        }
        if (d == 5) {
            return this.f1469s;
        }
        return 0;
    }

    public CharSequence getDrawerTitle(int i) {
        int absoluteGravity = GravityCompat.getAbsoluteGravity(i, ViewCompat.getLayoutDirection(this));
        if (absoluteGravity == 3) {
            return this.f1446B;
        }
        if (absoluteGravity == 5) {
            return this.f1447C;
        }
        return null;
    }

    public Drawable getStatusBarBackgroundDrawable() {
        return this.f1475y;
    }

    public boolean isDrawerOpen(int i) {
        View a = mo3088a(i);
        if (a != null) {
            return isDrawerOpen(a);
        }
        return false;
    }

    public boolean isDrawerOpen(View view) {
        if (mo3108f(view)) {
            return ((LayoutParams) view.getLayoutParams()).f1482c;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    public boolean isDrawerVisible(int i) {
        View a = mo3088a(i);
        if (a != null) {
            return isDrawerVisible(a);
        }
        return false;
    }

    public boolean isDrawerVisible(View view) {
        if (mo3108f(view)) {
            return ((LayoutParams) view.getLayoutParams()).f1480a > BitmapDescriptorFactory.HUE_RED;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f1467q = true;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f1467q = true;
    }

    public void onDraw(Canvas canvas) {
        int topInset;
        super.onDraw(canvas);
        if (this.f1449E && this.f1475y != null && (topInset = f1441a.getTopInset(this.f1448D)) > 0) {
            this.f1475y.setBounds(0, 0, getWidth(), topInset);
            this.f1475y.draw(canvas);
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003a, code lost:
        r0 = r7.f1461k.findTopChildUnder((int) r0, (int) r4);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r8) {
        /*
            r7 = this;
            r1 = 1
            r2 = 0
            int r0 = android.support.p000v4.view.MotionEventCompat.getActionMasked(r8)
            android.support.v4.widget.ViewDragHelper r3 = r7.f1461k
            boolean r3 = r3.shouldInterceptTouchEvent(r8)
            android.support.v4.widget.ViewDragHelper r4 = r7.f1462l
            boolean r4 = r4.shouldInterceptTouchEvent(r8)
            r3 = r3 | r4
            switch(r0) {
                case 0: goto L_0x0027;
                case 1: goto L_0x0065;
                case 2: goto L_0x0050;
                case 3: goto L_0x0065;
                default: goto L_0x0016;
            }
        L_0x0016:
            r0 = r2
        L_0x0017:
            if (r3 != 0) goto L_0x0025
            if (r0 != 0) goto L_0x0025
            boolean r0 = r7.m1042h()
            if (r0 != 0) goto L_0x0025
            boolean r0 = r7.f1471u
            if (r0 == 0) goto L_0x0026
        L_0x0025:
            r2 = r1
        L_0x0026:
            return r2
        L_0x0027:
            float r0 = r8.getX()
            float r4 = r8.getY()
            r7.f1473w = r0
            r7.f1474x = r4
            float r5 = r7.f1459i
            r6 = 0
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 <= 0) goto L_0x006d
            android.support.v4.widget.ViewDragHelper r5 = r7.f1461k
            int r0 = (int) r0
            int r4 = (int) r4
            android.view.View r0 = r5.findTopChildUnder(r0, r4)
            if (r0 == 0) goto L_0x006d
            boolean r0 = r7.mo3107e(r0)
            if (r0 == 0) goto L_0x006d
            r0 = r1
        L_0x004b:
            r7.f1470t = r2
            r7.f1471u = r2
            goto L_0x0017
        L_0x0050:
            android.support.v4.widget.ViewDragHelper r0 = r7.f1461k
            r4 = 3
            boolean r0 = r0.checkTouchSlop(r4)
            if (r0 == 0) goto L_0x0016
            android.support.v4.widget.DrawerLayout$ViewDragCallback r0 = r7.f1463m
            r0.removeCallbacks()
            android.support.v4.widget.DrawerLayout$ViewDragCallback r0 = r7.f1464n
            r0.removeCallbacks()
            r0 = r2
            goto L_0x0017
        L_0x0065:
            r7.mo3092a((boolean) r1)
            r7.f1470t = r2
            r7.f1471u = r2
            goto L_0x0016
        L_0x006d:
            r0 = r2
            goto L_0x004b
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p000v4.widget.DrawerLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || !m1044i()) {
            return super.onKeyDown(i, keyEvent);
        }
        KeyEventCompat.startTracking(keyEvent);
        return true;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        View j = m1046j();
        if (j != null && getDrawerLockMode(j) == 0) {
            closeDrawers();
        }
        return j != null;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        float f;
        this.f1466p = true;
        int i6 = i3 - i;
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (mo3107e(childAt)) {
                    childAt.layout(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.leftMargin + childAt.getMeasuredWidth(), layoutParams.topMargin + childAt.getMeasuredHeight());
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (mo3093a(childAt, 3)) {
                        i5 = ((int) (((float) measuredWidth) * layoutParams.f1480a)) + (-measuredWidth);
                        f = ((float) (measuredWidth + i5)) / ((float) measuredWidth);
                    } else {
                        i5 = i6 - ((int) (((float) measuredWidth) * layoutParams.f1480a));
                        f = ((float) (i6 - i5)) / ((float) measuredWidth);
                    }
                    boolean z2 = f != layoutParams.f1480a;
                    switch (layoutParams.gravity & 112) {
                        case 16:
                            int i8 = i4 - i2;
                            int i9 = (i8 - measuredHeight) / 2;
                            if (i9 < layoutParams.topMargin) {
                                i9 = layoutParams.topMargin;
                            } else if (i9 + measuredHeight > i8 - layoutParams.bottomMargin) {
                                i9 = (i8 - layoutParams.bottomMargin) - measuredHeight;
                            }
                            childAt.layout(i5, i9, measuredWidth + i5, measuredHeight + i9);
                            break;
                        case 80:
                            int i10 = i4 - i2;
                            childAt.layout(i5, (i10 - layoutParams.bottomMargin) - childAt.getMeasuredHeight(), measuredWidth + i5, i10 - layoutParams.bottomMargin);
                            break;
                        default:
                            childAt.layout(i5, layoutParams.topMargin, measuredWidth + i5, measuredHeight + layoutParams.topMargin);
                            break;
                    }
                    if (z2) {
                        mo3098b(childAt, f);
                    }
                    int i11 = layoutParams.f1480a > BitmapDescriptorFactory.HUE_RED ? 0 : 4;
                    if (childAt.getVisibility() != i11) {
                        childAt.setVisibility(i11);
                    }
                }
            }
        }
        this.f1466p = false;
        this.f1467q = false;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0054, code lost:
        if (r5 != 0) goto L_0x0056;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0060  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r14, int r15) {
        /*
            r13 = this;
            r1 = 300(0x12c, float:4.2E-43)
            r7 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = 0
            r12 = 1073741824(0x40000000, float:2.0)
            int r3 = android.view.View.MeasureSpec.getMode(r14)
            int r5 = android.view.View.MeasureSpec.getMode(r15)
            int r2 = android.view.View.MeasureSpec.getSize(r14)
            int r0 = android.view.View.MeasureSpec.getSize(r15)
            if (r3 != r12) goto L_0x001b
            if (r5 == r12) goto L_0x0056
        L_0x001b:
            boolean r6 = r13.isInEditMode()
            if (r6 == 0) goto L_0x0058
            if (r3 != r7) goto L_0x0050
        L_0x0023:
            if (r5 != r7) goto L_0x0054
            r1 = r0
        L_0x0026:
            r13.setMeasuredDimension(r2, r1)
            java.lang.Object r0 = r13.f1448D
            if (r0 == 0) goto L_0x0060
            boolean r0 = android.support.p000v4.view.ViewCompat.getFitsSystemWindows(r13)
            if (r0 == 0) goto L_0x0060
            r0 = 1
            r3 = r0
        L_0x0035:
            int r6 = android.support.p000v4.view.ViewCompat.getLayoutDirection(r13)
            int r7 = r13.getChildCount()
            r5 = r4
        L_0x003e:
            if (r5 >= r7) goto L_0x014b
            android.view.View r8 = r13.getChildAt(r5)
            int r0 = r8.getVisibility()
            r9 = 8
            if (r0 != r9) goto L_0x0062
        L_0x004c:
            int r0 = r5 + 1
            r5 = r0
            goto L_0x003e
        L_0x0050:
            if (r3 != 0) goto L_0x0023
            r2 = r1
            goto L_0x0023
        L_0x0054:
            if (r5 == 0) goto L_0x0026
        L_0x0056:
            r1 = r0
            goto L_0x0026
        L_0x0058:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "DrawerLayout must be measured with MeasureSpec.EXACTLY."
            r0.<init>(r1)
            throw r0
        L_0x0060:
            r3 = r4
            goto L_0x0035
        L_0x0062:
            android.view.ViewGroup$LayoutParams r0 = r8.getLayoutParams()
            android.support.v4.widget.DrawerLayout$LayoutParams r0 = (android.support.p000v4.widget.DrawerLayout.LayoutParams) r0
            if (r3 == 0) goto L_0x007d
            int r9 = r0.gravity
            int r9 = android.support.p000v4.view.GravityCompat.getAbsoluteGravity(r9, r6)
            boolean r10 = android.support.p000v4.view.ViewCompat.getFitsSystemWindows(r8)
            if (r10 == 0) goto L_0x009e
            android.support.v4.widget.DrawerLayout$DrawerLayoutCompatImpl r10 = f1441a
            java.lang.Object r11 = r13.f1448D
            r10.dispatchChildInsets(r8, r11, r9)
        L_0x007d:
            boolean r9 = r13.mo3107e(r8)
            if (r9 == 0) goto L_0x00a6
            int r9 = r0.leftMargin
            int r9 = r2 - r9
            int r10 = r0.rightMargin
            int r9 = r9 - r10
            int r9 = android.view.View.MeasureSpec.makeMeasureSpec(r9, r12)
            int r10 = r0.topMargin
            int r10 = r1 - r10
            int r0 = r0.bottomMargin
            int r0 = r10 - r0
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r12)
            r8.measure(r9, r0)
            goto L_0x004c
        L_0x009e:
            android.support.v4.widget.DrawerLayout$DrawerLayoutCompatImpl r10 = f1441a
            java.lang.Object r11 = r13.f1448D
            r10.applyMarginInsets(r0, r11, r9)
            goto L_0x007d
        L_0x00a6:
            boolean r9 = r13.mo3108f(r8)
            if (r9 == 0) goto L_0x011c
            boolean r9 = f1444d
            if (r9 == 0) goto L_0x00bf
            float r9 = android.support.p000v4.view.ViewCompat.getElevation(r8)
            float r10 = r13.f1456f
            int r9 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
            if (r9 == 0) goto L_0x00bf
            float r9 = r13.f1456f
            android.support.p000v4.view.ViewCompat.setElevation(r8, r9)
        L_0x00bf:
            int r9 = r13.mo3105d(r8)
            r9 = r9 & 7
            r10 = r4 & r9
            if (r10 == 0) goto L_0x00fe
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Child drawer has absolute gravity "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r2 = m1035b((int) r9)
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r2 = " but this "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r2 = "DrawerLayout"
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r2 = " already has a "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r2 = "drawer view along that edge"
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x00fe:
            int r9 = r13.f1457g
            int r10 = r0.leftMargin
            int r9 = r9 + r10
            int r10 = r0.rightMargin
            int r9 = r9 + r10
            int r10 = r0.width
            int r9 = getChildMeasureSpec(r14, r9, r10)
            int r10 = r0.topMargin
            int r11 = r0.bottomMargin
            int r10 = r10 + r11
            int r0 = r0.height
            int r0 = getChildMeasureSpec(r15, r10, r0)
            r8.measure(r9, r0)
            goto L_0x004c
        L_0x011c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Child "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r8)
            java.lang.String r2 = " at index "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r5)
            java.lang.String r2 = " does not have a valid layout_gravity - must be Gravity.LEFT, "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r2 = "Gravity.RIGHT or Gravity.NO_GRAVITY"
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x014b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p000v4.widget.DrawerLayout.onMeasure(int, int):void");
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        View a;
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (!(savedState.f1483a == 0 || (a = mo3088a(savedState.f1483a)) == null)) {
            openDrawer(a);
        }
        setDrawerLockMode(savedState.f1484b, 3);
        setDrawerLockMode(savedState.f1485c, 5);
    }

    public void onRtlPropertiesChanged(int i) {
        m1038e();
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        View a = mo3087a();
        if (a != null) {
            savedState.f1483a = ((LayoutParams) a.getLayoutParams()).gravity;
        }
        savedState.f1484b = this.f1468r;
        savedState.f1485c = this.f1469s;
        return savedState;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        View a;
        this.f1461k.processTouchEvent(motionEvent);
        this.f1462l.processTouchEvent(motionEvent);
        switch (motionEvent.getAction() & 255) {
            case 0:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                this.f1473w = x;
                this.f1474x = y;
                this.f1470t = false;
                this.f1471u = false;
                break;
            case 1:
                float x2 = motionEvent.getX();
                float y2 = motionEvent.getY();
                View findTopChildUnder = this.f1461k.findTopChildUnder((int) x2, (int) y2);
                if (findTopChildUnder != null && mo3107e(findTopChildUnder)) {
                    float f = x2 - this.f1473w;
                    float f2 = y2 - this.f1474x;
                    int touchSlop = this.f1461k.getTouchSlop();
                    if ((f * f) + (f2 * f2) < ((float) (touchSlop * touchSlop)) && (a = mo3087a()) != null) {
                        z = getDrawerLockMode(a) == 2;
                        mo3092a(z);
                        this.f1470t = false;
                        break;
                    }
                }
                z = true;
                mo3092a(z);
                this.f1470t = false;
            case 3:
                mo3092a(true);
                this.f1470t = false;
                this.f1471u = false;
                break;
        }
        return true;
    }

    public void openDrawer(int i) {
        View a = mo3088a(i);
        if (a == null) {
            throw new IllegalArgumentException("No drawer view found with gravity " + m1035b(i));
        }
        openDrawer(a);
    }

    public void openDrawer(View view) {
        if (!mo3108f(view)) {
            throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
        }
        if (this.f1467q) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.f1480a = 1.0f;
            layoutParams.f1482c = true;
            m1033a(view, true);
        } else if (mo3093a(view, 3)) {
            this.f1461k.smoothSlideViewTo(view, 0, view.getTop());
        } else {
            this.f1462l.smoothSlideViewTo(view, getWidth() - view.getWidth(), view.getTop());
        }
        invalidate();
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        this.f1470t = z;
        if (z) {
            mo3092a(true);
        }
    }

    public void requestLayout() {
        if (!this.f1466p) {
            super.requestLayout();
        }
    }

    public void setChildInsets(Object obj, boolean z) {
        this.f1448D = obj;
        this.f1449E = z;
        setWillNotDraw(!z && getBackground() == null);
        requestLayout();
    }

    public void setDrawerElevation(float f) {
        this.f1456f = f;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (mo3108f(childAt)) {
                ViewCompat.setElevation(childAt, this.f1456f);
            }
        }
    }

    public void setDrawerListener(DrawerListener drawerListener) {
        this.f1472v = drawerListener;
    }

    public void setDrawerLockMode(int i) {
        setDrawerLockMode(i, 3);
        setDrawerLockMode(i, 5);
    }

    public void setDrawerLockMode(int i, int i2) {
        int absoluteGravity = GravityCompat.getAbsoluteGravity(i2, ViewCompat.getLayoutDirection(this));
        if (absoluteGravity == 3) {
            this.f1468r = i;
        } else if (absoluteGravity == 5) {
            this.f1469s = i;
        }
        if (i != 0) {
            (absoluteGravity == 3 ? this.f1461k : this.f1462l).cancel();
        }
        switch (i) {
            case 1:
                View a = mo3088a(absoluteGravity);
                if (a != null) {
                    closeDrawer(a);
                    return;
                }
                return;
            case 2:
                View a2 = mo3088a(absoluteGravity);
                if (a2 != null) {
                    openDrawer(a2);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void setDrawerLockMode(int i, View view) {
        if (!mo3108f(view)) {
            throw new IllegalArgumentException("View " + view + " is not a " + "drawer with appropriate layout_gravity");
        }
        setDrawerLockMode(i, ((LayoutParams) view.getLayoutParams()).gravity);
    }

    public void setDrawerShadow(int i, int i2) {
        setDrawerShadow(getResources().getDrawable(i), i2);
    }

    public void setDrawerShadow(Drawable drawable, int i) {
        if (!f1444d) {
            if ((i & 8388611) == 8388611) {
                this.f1450F = drawable;
            } else if ((i & GravityCompat.END) == 8388613) {
                this.f1451G = drawable;
            } else if ((i & 3) == 3) {
                this.f1452H = drawable;
            } else if ((i & 5) == 5) {
                this.f1453I = drawable;
            } else {
                return;
            }
            m1038e();
            invalidate();
        }
    }

    public void setDrawerTitle(int i, CharSequence charSequence) {
        int absoluteGravity = GravityCompat.getAbsoluteGravity(i, ViewCompat.getLayoutDirection(this));
        if (absoluteGravity == 3) {
            this.f1446B = charSequence;
        } else if (absoluteGravity == 5) {
            this.f1447C = charSequence;
        }
    }

    public void setScrimColor(int i) {
        this.f1458h = i;
        invalidate();
    }

    public void setStatusBarBackground(int i) {
        this.f1475y = i != 0 ? ContextCompat.getDrawable(getContext(), i) : null;
        invalidate();
    }

    public void setStatusBarBackground(Drawable drawable) {
        this.f1475y = drawable;
        invalidate();
    }

    public void setStatusBarBackgroundColor(int i) {
        this.f1475y = new ColorDrawable(i);
        invalidate();
    }
}
