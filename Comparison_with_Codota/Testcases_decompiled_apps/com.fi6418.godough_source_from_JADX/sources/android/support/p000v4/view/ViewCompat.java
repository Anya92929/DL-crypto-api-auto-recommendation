package android.support.p000v4.view;

import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.p000v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.p000v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

/* renamed from: android.support.v4.view.ViewCompat */
public class ViewCompat {
    public static final int ACCESSIBILITY_LIVE_REGION_ASSERTIVE = 2;
    public static final int ACCESSIBILITY_LIVE_REGION_NONE = 0;
    public static final int ACCESSIBILITY_LIVE_REGION_POLITE = 1;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_AUTO = 0;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_NO = 2;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_NO_HIDE_DESCENDANTS = 4;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_YES = 1;
    public static final int LAYER_TYPE_HARDWARE = 2;
    public static final int LAYER_TYPE_NONE = 0;
    public static final int LAYER_TYPE_SOFTWARE = 1;
    public static final int LAYOUT_DIRECTION_INHERIT = 2;
    public static final int LAYOUT_DIRECTION_LOCALE = 3;
    public static final int LAYOUT_DIRECTION_LTR = 0;
    public static final int LAYOUT_DIRECTION_RTL = 1;
    public static final int MEASURED_HEIGHT_STATE_SHIFT = 16;
    public static final int MEASURED_SIZE_MASK = 16777215;
    public static final int MEASURED_STATE_MASK = -16777216;
    public static final int MEASURED_STATE_TOO_SMALL = 16777216;
    public static final int OVER_SCROLL_ALWAYS = 0;
    public static final int OVER_SCROLL_IF_CONTENT_SCROLLS = 1;
    public static final int OVER_SCROLL_NEVER = 2;
    public static final int SCROLL_AXIS_HORIZONTAL = 1;
    public static final int SCROLL_AXIS_NONE = 0;
    public static final int SCROLL_AXIS_VERTICAL = 2;

    /* renamed from: a */
    static final ViewCompatImpl f1242a;

    /* renamed from: android.support.v4.view.ViewCompat$BaseViewCompatImpl */
    class BaseViewCompatImpl implements ViewCompatImpl {

        /* renamed from: a */
        WeakHashMap<View, ViewPropertyAnimatorCompat> f1243a = null;

        /* renamed from: b */
        private Method f1244b;

        /* renamed from: c */
        private Method f1245c;

        /* renamed from: d */
        private boolean f1246d;

        BaseViewCompatImpl() {
        }

        /* renamed from: a */
        private boolean m870a(ScrollingView scrollingView, int i) {
            int computeHorizontalScrollOffset = scrollingView.computeHorizontalScrollOffset();
            int computeHorizontalScrollRange = scrollingView.computeHorizontalScrollRange() - scrollingView.computeHorizontalScrollExtent();
            if (computeHorizontalScrollRange == 0) {
                return false;
            }
            return i < 0 ? computeHorizontalScrollOffset > 0 : computeHorizontalScrollOffset < computeHorizontalScrollRange + -1;
        }

        /* renamed from: b */
        private void m871b() {
            try {
                this.f1244b = View.class.getDeclaredMethod("dispatchStartTemporaryDetach", new Class[0]);
                this.f1245c = View.class.getDeclaredMethod("dispatchFinishTemporaryDetach", new Class[0]);
            } catch (NoSuchMethodException e) {
                Log.e(ViewCompatEclairMr1.TAG, "Couldn't find method", e);
            }
            this.f1246d = true;
        }

        /* renamed from: b */
        private boolean m872b(ScrollingView scrollingView, int i) {
            int computeVerticalScrollOffset = scrollingView.computeVerticalScrollOffset();
            int computeVerticalScrollRange = scrollingView.computeVerticalScrollRange() - scrollingView.computeVerticalScrollExtent();
            if (computeVerticalScrollRange == 0) {
                return false;
            }
            return i < 0 ? computeVerticalScrollOffset > 0 : computeVerticalScrollOffset < computeVerticalScrollRange + -1;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public long mo2301a() {
            return 10;
        }

        public ViewPropertyAnimatorCompat animate(View view) {
            return new ViewPropertyAnimatorCompat(view);
        }

        public boolean canScrollHorizontally(View view, int i) {
            return (view instanceof ScrollingView) && m870a((ScrollingView) view, i);
        }

        public boolean canScrollVertically(View view, int i) {
            return (view instanceof ScrollingView) && m872b((ScrollingView) view, i);
        }

        public int combineMeasuredStates(int i, int i2) {
            return i | i2;
        }

        public WindowInsetsCompat dispatchApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            return windowInsetsCompat;
        }

        public void dispatchFinishTemporaryDetach(View view) {
            if (!this.f1246d) {
                m871b();
            }
            if (this.f1245c != null) {
                try {
                    this.f1245c.invoke(view, new Object[0]);
                } catch (Exception e) {
                    Log.d(ViewCompatEclairMr1.TAG, "Error calling dispatchFinishTemporaryDetach", e);
                }
            } else {
                view.onFinishTemporaryDetach();
            }
        }

        public boolean dispatchNestedFling(View view, float f, float f2, boolean z) {
            if (view instanceof NestedScrollingChild) {
                return ((NestedScrollingChild) view).dispatchNestedFling(f, f2, z);
            }
            return false;
        }

        public boolean dispatchNestedPreFling(View view, float f, float f2) {
            if (view instanceof NestedScrollingChild) {
                return ((NestedScrollingChild) view).dispatchNestedPreFling(f, f2);
            }
            return false;
        }

        public boolean dispatchNestedPreScroll(View view, int i, int i2, int[] iArr, int[] iArr2) {
            if (view instanceof NestedScrollingChild) {
                return ((NestedScrollingChild) view).dispatchNestedPreScroll(i, i2, iArr, iArr2);
            }
            return false;
        }

        public boolean dispatchNestedScroll(View view, int i, int i2, int i3, int i4, int[] iArr) {
            if (view instanceof NestedScrollingChild) {
                return ((NestedScrollingChild) view).dispatchNestedScroll(i, i2, i3, i4, iArr);
            }
            return false;
        }

        public void dispatchStartTemporaryDetach(View view) {
            if (!this.f1246d) {
                m871b();
            }
            if (this.f1244b != null) {
                try {
                    this.f1244b.invoke(view, new Object[0]);
                } catch (Exception e) {
                    Log.d(ViewCompatEclairMr1.TAG, "Error calling dispatchStartTemporaryDetach", e);
                }
            } else {
                view.onStartTemporaryDetach();
            }
        }

        public int getAccessibilityLiveRegion(View view) {
            return 0;
        }

        public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view) {
            return null;
        }

        public float getAlpha(View view) {
            return 1.0f;
        }

        public ColorStateList getBackgroundTintList(View view) {
            return ViewCompatBase.m875a(view);
        }

        public PorterDuff.Mode getBackgroundTintMode(View view) {
            return ViewCompatBase.m878b(view);
        }

        public Rect getClipBounds(View view) {
            return null;
        }

        public float getElevation(View view) {
            return BitmapDescriptorFactory.HUE_RED;
        }

        public boolean getFitsSystemWindows(View view) {
            return false;
        }

        public int getImportantForAccessibility(View view) {
            return 0;
        }

        public int getLabelFor(View view) {
            return 0;
        }

        public int getLayerType(View view) {
            return 0;
        }

        public int getLayoutDirection(View view) {
            return 0;
        }

        public int getMeasuredHeightAndState(View view) {
            return view.getMeasuredHeight();
        }

        public int getMeasuredState(View view) {
            return 0;
        }

        public int getMeasuredWidthAndState(View view) {
            return view.getMeasuredWidth();
        }

        public int getMinimumHeight(View view) {
            return ViewCompatBase.m881e(view);
        }

        public int getMinimumWidth(View view) {
            return ViewCompatBase.m880d(view);
        }

        public int getOverScrollMode(View view) {
            return 2;
        }

        public int getPaddingEnd(View view) {
            return view.getPaddingRight();
        }

        public int getPaddingStart(View view) {
            return view.getPaddingLeft();
        }

        public ViewParent getParentForAccessibility(View view) {
            return view.getParent();
        }

        public float getPivotX(View view) {
            return BitmapDescriptorFactory.HUE_RED;
        }

        public float getPivotY(View view) {
            return BitmapDescriptorFactory.HUE_RED;
        }

        public float getRotation(View view) {
            return BitmapDescriptorFactory.HUE_RED;
        }

        public float getRotationX(View view) {
            return BitmapDescriptorFactory.HUE_RED;
        }

        public float getRotationY(View view) {
            return BitmapDescriptorFactory.HUE_RED;
        }

        public float getScaleX(View view) {
            return BitmapDescriptorFactory.HUE_RED;
        }

        public float getScaleY(View view) {
            return BitmapDescriptorFactory.HUE_RED;
        }

        public String getTransitionName(View view) {
            return null;
        }

        public float getTranslationX(View view) {
            return BitmapDescriptorFactory.HUE_RED;
        }

        public float getTranslationY(View view) {
            return BitmapDescriptorFactory.HUE_RED;
        }

        public float getTranslationZ(View view) {
            return BitmapDescriptorFactory.HUE_RED;
        }

        public int getWindowSystemUiVisibility(View view) {
            return 0;
        }

        public float getX(View view) {
            return BitmapDescriptorFactory.HUE_RED;
        }

        public float getY(View view) {
            return BitmapDescriptorFactory.HUE_RED;
        }

        public float getZ(View view) {
            return getTranslationZ(view) + getElevation(view);
        }

        public boolean hasAccessibilityDelegate(View view) {
            return false;
        }

        public boolean hasNestedScrollingParent(View view) {
            if (view instanceof NestedScrollingChild) {
                return ((NestedScrollingChild) view).hasNestedScrollingParent();
            }
            return false;
        }

        public boolean hasOverlappingRendering(View view) {
            return true;
        }

        public boolean hasTransientState(View view) {
            return false;
        }

        public boolean isAttachedToWindow(View view) {
            return ViewCompatBase.m882f(view);
        }

        public boolean isImportantForAccessibility(View view) {
            return true;
        }

        public boolean isLaidOut(View view) {
            return ViewCompatBase.m879c(view);
        }

        public boolean isNestedScrollingEnabled(View view) {
            if (view instanceof NestedScrollingChild) {
                return ((NestedScrollingChild) view).isNestedScrollingEnabled();
            }
            return false;
        }

        public boolean isOpaque(View view) {
            Drawable background = view.getBackground();
            return background != null && background.getOpacity() == -1;
        }

        public boolean isPaddingRelative(View view) {
            return false;
        }

        public void jumpDrawablesToCurrentState(View view) {
        }

        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            return windowInsetsCompat;
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        }

        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        }

        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            return false;
        }

        public void postInvalidateOnAnimation(View view) {
            view.invalidate();
        }

        public void postInvalidateOnAnimation(View view, int i, int i2, int i3, int i4) {
            view.invalidate(i, i2, i3, i4);
        }

        public void postOnAnimation(View view, Runnable runnable) {
            view.postDelayed(runnable, mo2301a());
        }

        public void postOnAnimationDelayed(View view, Runnable runnable, long j) {
            view.postDelayed(runnable, mo2301a() + j);
        }

        public void requestApplyInsets(View view) {
        }

        public int resolveSizeAndState(int i, int i2, int i3) {
            return View.resolveSize(i, i2);
        }

        public void setAccessibilityDelegate(View view, AccessibilityDelegateCompat accessibilityDelegateCompat) {
        }

        public void setAccessibilityLiveRegion(View view, int i) {
        }

        public void setActivated(View view, boolean z) {
        }

        public void setAlpha(View view, float f) {
        }

        public void setBackgroundTintList(View view, ColorStateList colorStateList) {
            ViewCompatBase.m876a(view, colorStateList);
        }

        public void setBackgroundTintMode(View view, PorterDuff.Mode mode) {
            ViewCompatBase.m877a(view, mode);
        }

        public void setChildrenDrawingOrderEnabled(ViewGroup viewGroup, boolean z) {
        }

        public void setClipBounds(View view, Rect rect) {
        }

        public void setElevation(View view, float f) {
        }

        public void setFitsSystemWindows(View view, boolean z) {
        }

        public void setHasTransientState(View view, boolean z) {
        }

        public void setImportantForAccessibility(View view, int i) {
        }

        public void setLabelFor(View view, int i) {
        }

        public void setLayerPaint(View view, Paint paint) {
        }

        public void setLayerType(View view, int i, Paint paint) {
        }

        public void setLayoutDirection(View view, int i) {
        }

        public void setNestedScrollingEnabled(View view, boolean z) {
            if (view instanceof NestedScrollingChild) {
                ((NestedScrollingChild) view).setNestedScrollingEnabled(z);
            }
        }

        public void setOnApplyWindowInsetsListener(View view, OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        }

        public void setOverScrollMode(View view, int i) {
        }

        public void setPaddingRelative(View view, int i, int i2, int i3, int i4) {
            view.setPadding(i, i2, i3, i4);
        }

        public void setPivotX(View view, float f) {
        }

        public void setPivotY(View view, float f) {
        }

        public void setRotation(View view, float f) {
        }

        public void setRotationX(View view, float f) {
        }

        public void setRotationY(View view, float f) {
        }

        public void setSaveFromParentEnabled(View view, boolean z) {
        }

        public void setScaleX(View view, float f) {
        }

        public void setScaleY(View view, float f) {
        }

        public void setTransitionName(View view, String str) {
        }

        public void setTranslationX(View view, float f) {
        }

        public void setTranslationY(View view, float f) {
        }

        public void setTranslationZ(View view, float f) {
        }

        public void setX(View view, float f) {
        }

        public void setY(View view, float f) {
        }

        public boolean startNestedScroll(View view, int i) {
            if (view instanceof NestedScrollingChild) {
                return ((NestedScrollingChild) view).startNestedScroll(i);
            }
            return false;
        }

        public void stopNestedScroll(View view) {
            if (view instanceof NestedScrollingChild) {
                ((NestedScrollingChild) view).stopNestedScroll();
            }
        }
    }

    /* renamed from: android.support.v4.view.ViewCompat$EclairMr1ViewCompatImpl */
    class EclairMr1ViewCompatImpl extends BaseViewCompatImpl {
        EclairMr1ViewCompatImpl() {
        }

        public boolean isOpaque(View view) {
            return ViewCompatEclairMr1.isOpaque(view);
        }

        public void setChildrenDrawingOrderEnabled(ViewGroup viewGroup, boolean z) {
            ViewCompatEclairMr1.setChildrenDrawingOrderEnabled(viewGroup, z);
        }
    }

    /* renamed from: android.support.v4.view.ViewCompat$GBViewCompatImpl */
    class GBViewCompatImpl extends EclairMr1ViewCompatImpl {
        GBViewCompatImpl() {
        }

        public int getOverScrollMode(View view) {
            return ViewCompatGingerbread.getOverScrollMode(view);
        }

        public void setOverScrollMode(View view, int i) {
            ViewCompatGingerbread.setOverScrollMode(view, i);
        }
    }

    /* renamed from: android.support.v4.view.ViewCompat$HCViewCompatImpl */
    class HCViewCompatImpl extends GBViewCompatImpl {
        HCViewCompatImpl() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public long mo2301a() {
            return ViewCompatHC.m883a();
        }

        public int combineMeasuredStates(int i, int i2) {
            return ViewCompatHC.combineMeasuredStates(i, i2);
        }

        public float getAlpha(View view) {
            return ViewCompatHC.getAlpha(view);
        }

        public int getLayerType(View view) {
            return ViewCompatHC.getLayerType(view);
        }

        public int getMeasuredHeightAndState(View view) {
            return ViewCompatHC.getMeasuredHeightAndState(view);
        }

        public int getMeasuredState(View view) {
            return ViewCompatHC.getMeasuredState(view);
        }

        public int getMeasuredWidthAndState(View view) {
            return ViewCompatHC.getMeasuredWidthAndState(view);
        }

        public float getPivotX(View view) {
            return ViewCompatHC.getPivotX(view);
        }

        public float getPivotY(View view) {
            return ViewCompatHC.getPivotY(view);
        }

        public float getRotation(View view) {
            return ViewCompatHC.getRotation(view);
        }

        public float getRotationX(View view) {
            return ViewCompatHC.getRotationX(view);
        }

        public float getRotationY(View view) {
            return ViewCompatHC.getRotationY(view);
        }

        public float getScaleX(View view) {
            return ViewCompatHC.getScaleX(view);
        }

        public float getScaleY(View view) {
            return ViewCompatHC.getScaleY(view);
        }

        public float getTranslationX(View view) {
            return ViewCompatHC.getTranslationX(view);
        }

        public float getTranslationY(View view) {
            return ViewCompatHC.getTranslationY(view);
        }

        public float getX(View view) {
            return ViewCompatHC.getX(view);
        }

        public float getY(View view) {
            return ViewCompatHC.getY(view);
        }

        public void jumpDrawablesToCurrentState(View view) {
            ViewCompatHC.jumpDrawablesToCurrentState(view);
        }

        public int resolveSizeAndState(int i, int i2, int i3) {
            return ViewCompatHC.resolveSizeAndState(i, i2, i3);
        }

        public void setActivated(View view, boolean z) {
            ViewCompatHC.setActivated(view, z);
        }

        public void setAlpha(View view, float f) {
            ViewCompatHC.setAlpha(view, f);
        }

        public void setLayerPaint(View view, Paint paint) {
            setLayerType(view, getLayerType(view), paint);
            view.invalidate();
        }

        public void setLayerType(View view, int i, Paint paint) {
            ViewCompatHC.setLayerType(view, i, paint);
        }

        public void setPivotX(View view, float f) {
            ViewCompatHC.setPivotX(view, f);
        }

        public void setPivotY(View view, float f) {
            ViewCompatHC.setPivotY(view, f);
        }

        public void setRotation(View view, float f) {
            ViewCompatHC.setRotation(view, f);
        }

        public void setRotationX(View view, float f) {
            ViewCompatHC.setRotationX(view, f);
        }

        public void setRotationY(View view, float f) {
            ViewCompatHC.setRotationY(view, f);
        }

        public void setSaveFromParentEnabled(View view, boolean z) {
            ViewCompatHC.setSaveFromParentEnabled(view, z);
        }

        public void setScaleX(View view, float f) {
            ViewCompatHC.setScaleX(view, f);
        }

        public void setScaleY(View view, float f) {
            ViewCompatHC.setScaleY(view, f);
        }

        public void setTranslationX(View view, float f) {
            ViewCompatHC.setTranslationX(view, f);
        }

        public void setTranslationY(View view, float f) {
            ViewCompatHC.setTranslationY(view, f);
        }

        public void setX(View view, float f) {
            ViewCompatHC.setX(view, f);
        }

        public void setY(View view, float f) {
            ViewCompatHC.setY(view, f);
        }
    }

    /* renamed from: android.support.v4.view.ViewCompat$ICSViewCompatImpl */
    class ICSViewCompatImpl extends HCViewCompatImpl {

        /* renamed from: b */
        static Field f1247b;

        /* renamed from: c */
        static boolean f1248c = false;

        ICSViewCompatImpl() {
        }

        public ViewPropertyAnimatorCompat animate(View view) {
            if (this.f1243a == null) {
                this.f1243a = new WeakHashMap();
            }
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = (ViewPropertyAnimatorCompat) this.f1243a.get(view);
            if (viewPropertyAnimatorCompat != null) {
                return viewPropertyAnimatorCompat;
            }
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = new ViewPropertyAnimatorCompat(view);
            this.f1243a.put(view, viewPropertyAnimatorCompat2);
            return viewPropertyAnimatorCompat2;
        }

        public boolean canScrollHorizontally(View view, int i) {
            return ViewCompatICS.canScrollHorizontally(view, i);
        }

        public boolean canScrollVertically(View view, int i) {
            return ViewCompatICS.canScrollVertically(view, i);
        }

        public boolean hasAccessibilityDelegate(View view) {
            boolean z = true;
            if (f1248c) {
                return false;
            }
            if (f1247b == null) {
                try {
                    f1247b = View.class.getDeclaredField("mAccessibilityDelegate");
                    f1247b.setAccessible(true);
                } catch (Throwable th) {
                    f1248c = true;
                    return false;
                }
            }
            try {
                if (f1247b.get(view) == null) {
                    z = false;
                }
                return z;
            } catch (Throwable th2) {
                f1248c = true;
                return false;
            }
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            ViewCompatICS.onInitializeAccessibilityEvent(view, accessibilityEvent);
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            ViewCompatICS.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat.getInfo());
        }

        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            ViewCompatICS.onPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        public void setAccessibilityDelegate(View view, AccessibilityDelegateCompat accessibilityDelegateCompat) {
            ViewCompatICS.setAccessibilityDelegate(view, accessibilityDelegateCompat == null ? null : accessibilityDelegateCompat.mo2097a());
        }

        public void setFitsSystemWindows(View view, boolean z) {
            ViewCompatICS.setFitsSystemWindows(view, z);
        }
    }

    /* renamed from: android.support.v4.view.ViewCompat$JBViewCompatImpl */
    class JBViewCompatImpl extends ICSViewCompatImpl {
        JBViewCompatImpl() {
        }

        public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view) {
            Object accessibilityNodeProvider = ViewCompatJB.getAccessibilityNodeProvider(view);
            if (accessibilityNodeProvider != null) {
                return new AccessibilityNodeProviderCompat(accessibilityNodeProvider);
            }
            return null;
        }

        public boolean getFitsSystemWindows(View view) {
            return ViewCompatJB.getFitsSystemWindows(view);
        }

        public int getImportantForAccessibility(View view) {
            return ViewCompatJB.getImportantForAccessibility(view);
        }

        public int getMinimumHeight(View view) {
            return ViewCompatJB.getMinimumHeight(view);
        }

        public int getMinimumWidth(View view) {
            return ViewCompatJB.getMinimumWidth(view);
        }

        public ViewParent getParentForAccessibility(View view) {
            return ViewCompatJB.getParentForAccessibility(view);
        }

        public boolean hasOverlappingRendering(View view) {
            return ViewCompatJB.hasOverlappingRendering(view);
        }

        public boolean hasTransientState(View view) {
            return ViewCompatJB.hasTransientState(view);
        }

        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            return ViewCompatJB.performAccessibilityAction(view, i, bundle);
        }

        public void postInvalidateOnAnimation(View view) {
            ViewCompatJB.postInvalidateOnAnimation(view);
        }

        public void postInvalidateOnAnimation(View view, int i, int i2, int i3, int i4) {
            ViewCompatJB.postInvalidateOnAnimation(view, i, i2, i3, i4);
        }

        public void postOnAnimation(View view, Runnable runnable) {
            ViewCompatJB.postOnAnimation(view, runnable);
        }

        public void postOnAnimationDelayed(View view, Runnable runnable, long j) {
            ViewCompatJB.postOnAnimationDelayed(view, runnable, j);
        }

        public void requestApplyInsets(View view) {
            ViewCompatJB.requestApplyInsets(view);
        }

        public void setHasTransientState(View view, boolean z) {
            ViewCompatJB.setHasTransientState(view, z);
        }

        public void setImportantForAccessibility(View view, int i) {
            if (i == 4) {
                i = 2;
            }
            ViewCompatJB.setImportantForAccessibility(view, i);
        }
    }

    /* renamed from: android.support.v4.view.ViewCompat$JbMr1ViewCompatImpl */
    class JbMr1ViewCompatImpl extends JBViewCompatImpl {
        JbMr1ViewCompatImpl() {
        }

        public int getLabelFor(View view) {
            return ViewCompatJellybeanMr1.getLabelFor(view);
        }

        public int getLayoutDirection(View view) {
            return ViewCompatJellybeanMr1.getLayoutDirection(view);
        }

        public int getPaddingEnd(View view) {
            return ViewCompatJellybeanMr1.getPaddingEnd(view);
        }

        public int getPaddingStart(View view) {
            return ViewCompatJellybeanMr1.getPaddingStart(view);
        }

        public int getWindowSystemUiVisibility(View view) {
            return ViewCompatJellybeanMr1.getWindowSystemUiVisibility(view);
        }

        public boolean isPaddingRelative(View view) {
            return ViewCompatJellybeanMr1.isPaddingRelative(view);
        }

        public void setLabelFor(View view, int i) {
            ViewCompatJellybeanMr1.setLabelFor(view, i);
        }

        public void setLayerPaint(View view, Paint paint) {
            ViewCompatJellybeanMr1.setLayerPaint(view, paint);
        }

        public void setLayoutDirection(View view, int i) {
            ViewCompatJellybeanMr1.setLayoutDirection(view, i);
        }

        public void setPaddingRelative(View view, int i, int i2, int i3, int i4) {
            ViewCompatJellybeanMr1.setPaddingRelative(view, i, i2, i3, i4);
        }
    }

    /* renamed from: android.support.v4.view.ViewCompat$JbMr2ViewCompatImpl */
    class JbMr2ViewCompatImpl extends JbMr1ViewCompatImpl {
        JbMr2ViewCompatImpl() {
        }

        public Rect getClipBounds(View view) {
            return ViewCompatJellybeanMr2.getClipBounds(view);
        }

        public void setClipBounds(View view, Rect rect) {
            ViewCompatJellybeanMr2.setClipBounds(view, rect);
        }
    }

    /* renamed from: android.support.v4.view.ViewCompat$KitKatViewCompatImpl */
    class KitKatViewCompatImpl extends JbMr2ViewCompatImpl {
        KitKatViewCompatImpl() {
        }

        public int getAccessibilityLiveRegion(View view) {
            return ViewCompatKitKat.getAccessibilityLiveRegion(view);
        }

        public boolean isAttachedToWindow(View view) {
            return ViewCompatKitKat.isAttachedToWindow(view);
        }

        public boolean isLaidOut(View view) {
            return ViewCompatKitKat.isLaidOut(view);
        }

        public void setAccessibilityLiveRegion(View view, int i) {
            ViewCompatKitKat.setAccessibilityLiveRegion(view, i);
        }

        public void setImportantForAccessibility(View view, int i) {
            ViewCompatJB.setImportantForAccessibility(view, i);
        }
    }

    /* renamed from: android.support.v4.view.ViewCompat$LollipopViewCompatImpl */
    class LollipopViewCompatImpl extends KitKatViewCompatImpl {
        LollipopViewCompatImpl() {
        }

        public WindowInsetsCompat dispatchApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            return ViewCompatLollipop.dispatchApplyWindowInsets(view, windowInsetsCompat);
        }

        public boolean dispatchNestedFling(View view, float f, float f2, boolean z) {
            return ViewCompatLollipop.dispatchNestedFling(view, f, f2, z);
        }

        public boolean dispatchNestedPreFling(View view, float f, float f2) {
            return ViewCompatLollipop.dispatchNestedPreFling(view, f, f2);
        }

        public boolean dispatchNestedPreScroll(View view, int i, int i2, int[] iArr, int[] iArr2) {
            return ViewCompatLollipop.dispatchNestedPreScroll(view, i, i2, iArr, iArr2);
        }

        public boolean dispatchNestedScroll(View view, int i, int i2, int i3, int i4, int[] iArr) {
            return ViewCompatLollipop.dispatchNestedScroll(view, i, i2, i3, i4, iArr);
        }

        public ColorStateList getBackgroundTintList(View view) {
            return ViewCompatLollipop.m884a(view);
        }

        public PorterDuff.Mode getBackgroundTintMode(View view) {
            return ViewCompatLollipop.m887b(view);
        }

        public float getElevation(View view) {
            return ViewCompatLollipop.getElevation(view);
        }

        public String getTransitionName(View view) {
            return ViewCompatLollipop.getTransitionName(view);
        }

        public float getTranslationZ(View view) {
            return ViewCompatLollipop.getTranslationZ(view);
        }

        public float getZ(View view) {
            return ViewCompatLollipop.getZ(view);
        }

        public boolean hasNestedScrollingParent(View view) {
            return ViewCompatLollipop.hasNestedScrollingParent(view);
        }

        public boolean isImportantForAccessibility(View view) {
            return ViewCompatLollipop.isImportantForAccessibility(view);
        }

        public boolean isNestedScrollingEnabled(View view) {
            return ViewCompatLollipop.isNestedScrollingEnabled(view);
        }

        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            return ViewCompatLollipop.onApplyWindowInsets(view, windowInsetsCompat);
        }

        public void requestApplyInsets(View view) {
            ViewCompatLollipop.requestApplyInsets(view);
        }

        public void setBackgroundTintList(View view, ColorStateList colorStateList) {
            ViewCompatLollipop.m885a(view, colorStateList);
        }

        public void setBackgroundTintMode(View view, PorterDuff.Mode mode) {
            ViewCompatLollipop.m886a(view, mode);
        }

        public void setElevation(View view, float f) {
            ViewCompatLollipop.setElevation(view, f);
        }

        public void setNestedScrollingEnabled(View view, boolean z) {
            ViewCompatLollipop.setNestedScrollingEnabled(view, z);
        }

        public void setOnApplyWindowInsetsListener(View view, OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
            ViewCompatLollipop.setOnApplyWindowInsetsListener(view, onApplyWindowInsetsListener);
        }

        public void setTransitionName(View view, String str) {
            ViewCompatLollipop.setTransitionName(view, str);
        }

        public void setTranslationZ(View view, float f) {
            ViewCompatLollipop.setTranslationZ(view, f);
        }

        public boolean startNestedScroll(View view, int i) {
            return ViewCompatLollipop.startNestedScroll(view, i);
        }

        public void stopNestedScroll(View view) {
            ViewCompatLollipop.stopNestedScroll(view);
        }
    }

    /* renamed from: android.support.v4.view.ViewCompat$ViewCompatImpl */
    interface ViewCompatImpl {
        ViewPropertyAnimatorCompat animate(View view);

        boolean canScrollHorizontally(View view, int i);

        boolean canScrollVertically(View view, int i);

        int combineMeasuredStates(int i, int i2);

        WindowInsetsCompat dispatchApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat);

        void dispatchFinishTemporaryDetach(View view);

        boolean dispatchNestedFling(View view, float f, float f2, boolean z);

        boolean dispatchNestedPreFling(View view, float f, float f2);

        boolean dispatchNestedPreScroll(View view, int i, int i2, int[] iArr, int[] iArr2);

        boolean dispatchNestedScroll(View view, int i, int i2, int i3, int i4, int[] iArr);

        void dispatchStartTemporaryDetach(View view);

        int getAccessibilityLiveRegion(View view);

        AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view);

        float getAlpha(View view);

        ColorStateList getBackgroundTintList(View view);

        PorterDuff.Mode getBackgroundTintMode(View view);

        Rect getClipBounds(View view);

        float getElevation(View view);

        boolean getFitsSystemWindows(View view);

        int getImportantForAccessibility(View view);

        int getLabelFor(View view);

        int getLayerType(View view);

        int getLayoutDirection(View view);

        int getMeasuredHeightAndState(View view);

        int getMeasuredState(View view);

        int getMeasuredWidthAndState(View view);

        int getMinimumHeight(View view);

        int getMinimumWidth(View view);

        int getOverScrollMode(View view);

        int getPaddingEnd(View view);

        int getPaddingStart(View view);

        ViewParent getParentForAccessibility(View view);

        float getPivotX(View view);

        float getPivotY(View view);

        float getRotation(View view);

        float getRotationX(View view);

        float getRotationY(View view);

        float getScaleX(View view);

        float getScaleY(View view);

        String getTransitionName(View view);

        float getTranslationX(View view);

        float getTranslationY(View view);

        float getTranslationZ(View view);

        int getWindowSystemUiVisibility(View view);

        float getX(View view);

        float getY(View view);

        float getZ(View view);

        boolean hasAccessibilityDelegate(View view);

        boolean hasNestedScrollingParent(View view);

        boolean hasOverlappingRendering(View view);

        boolean hasTransientState(View view);

        boolean isAttachedToWindow(View view);

        boolean isImportantForAccessibility(View view);

        boolean isLaidOut(View view);

        boolean isNestedScrollingEnabled(View view);

        boolean isOpaque(View view);

        boolean isPaddingRelative(View view);

        void jumpDrawablesToCurrentState(View view);

        WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat);

        void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent);

        void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat);

        void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent);

        boolean performAccessibilityAction(View view, int i, Bundle bundle);

        void postInvalidateOnAnimation(View view);

        void postInvalidateOnAnimation(View view, int i, int i2, int i3, int i4);

        void postOnAnimation(View view, Runnable runnable);

        void postOnAnimationDelayed(View view, Runnable runnable, long j);

        void requestApplyInsets(View view);

        int resolveSizeAndState(int i, int i2, int i3);

        void setAccessibilityDelegate(View view, AccessibilityDelegateCompat accessibilityDelegateCompat);

        void setAccessibilityLiveRegion(View view, int i);

        void setActivated(View view, boolean z);

        void setAlpha(View view, float f);

        void setBackgroundTintList(View view, ColorStateList colorStateList);

        void setBackgroundTintMode(View view, PorterDuff.Mode mode);

        void setChildrenDrawingOrderEnabled(ViewGroup viewGroup, boolean z);

        void setClipBounds(View view, Rect rect);

        void setElevation(View view, float f);

        void setFitsSystemWindows(View view, boolean z);

        void setHasTransientState(View view, boolean z);

        void setImportantForAccessibility(View view, int i);

        void setLabelFor(View view, int i);

        void setLayerPaint(View view, Paint paint);

        void setLayerType(View view, int i, Paint paint);

        void setLayoutDirection(View view, int i);

        void setNestedScrollingEnabled(View view, boolean z);

        void setOnApplyWindowInsetsListener(View view, OnApplyWindowInsetsListener onApplyWindowInsetsListener);

        void setOverScrollMode(View view, int i);

        void setPaddingRelative(View view, int i, int i2, int i3, int i4);

        void setPivotX(View view, float f);

        void setPivotY(View view, float f);

        void setRotation(View view, float f);

        void setRotationX(View view, float f);

        void setRotationY(View view, float f);

        void setSaveFromParentEnabled(View view, boolean z);

        void setScaleX(View view, float f);

        void setScaleY(View view, float f);

        void setTransitionName(View view, String str);

        void setTranslationX(View view, float f);

        void setTranslationY(View view, float f);

        void setTranslationZ(View view, float f);

        void setX(View view, float f);

        void setY(View view, float f);

        boolean startNestedScroll(View view, int i);

        void stopNestedScroll(View view);
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            f1242a = new LollipopViewCompatImpl();
        } else if (i >= 19) {
            f1242a = new KitKatViewCompatImpl();
        } else if (i >= 17) {
            f1242a = new JbMr1ViewCompatImpl();
        } else if (i >= 16) {
            f1242a = new JBViewCompatImpl();
        } else if (i >= 14) {
            f1242a = new ICSViewCompatImpl();
        } else if (i >= 11) {
            f1242a = new HCViewCompatImpl();
        } else if (i >= 9) {
            f1242a = new GBViewCompatImpl();
        } else if (i >= 7) {
            f1242a = new EclairMr1ViewCompatImpl();
        } else {
            f1242a = new BaseViewCompatImpl();
        }
    }

    public static ViewPropertyAnimatorCompat animate(View view) {
        return f1242a.animate(view);
    }

    public static boolean canScrollHorizontally(View view, int i) {
        return f1242a.canScrollHorizontally(view, i);
    }

    public static boolean canScrollVertically(View view, int i) {
        return f1242a.canScrollVertically(view, i);
    }

    public static int combineMeasuredStates(int i, int i2) {
        return f1242a.combineMeasuredStates(i, i2);
    }

    public static WindowInsetsCompat dispatchApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        return f1242a.dispatchApplyWindowInsets(view, windowInsetsCompat);
    }

    public static void dispatchFinishTemporaryDetach(View view) {
        f1242a.dispatchFinishTemporaryDetach(view);
    }

    public static boolean dispatchNestedFling(View view, float f, float f2, boolean z) {
        return f1242a.dispatchNestedFling(view, f, f2, z);
    }

    public static boolean dispatchNestedPreFling(View view, float f, float f2) {
        return f1242a.dispatchNestedPreFling(view, f, f2);
    }

    public static boolean dispatchNestedPreScroll(View view, int i, int i2, int[] iArr, int[] iArr2) {
        return f1242a.dispatchNestedPreScroll(view, i, i2, iArr, iArr2);
    }

    public static boolean dispatchNestedScroll(View view, int i, int i2, int i3, int i4, int[] iArr) {
        return f1242a.dispatchNestedScroll(view, i, i2, i3, i4, iArr);
    }

    public static void dispatchStartTemporaryDetach(View view) {
        f1242a.dispatchStartTemporaryDetach(view);
    }

    public static int getAccessibilityLiveRegion(View view) {
        return f1242a.getAccessibilityLiveRegion(view);
    }

    public static AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view) {
        return f1242a.getAccessibilityNodeProvider(view);
    }

    public static float getAlpha(View view) {
        return f1242a.getAlpha(view);
    }

    public static ColorStateList getBackgroundTintList(View view) {
        return f1242a.getBackgroundTintList(view);
    }

    public static PorterDuff.Mode getBackgroundTintMode(View view) {
        return f1242a.getBackgroundTintMode(view);
    }

    public static Rect getClipBounds(View view) {
        return f1242a.getClipBounds(view);
    }

    public static float getElevation(View view) {
        return f1242a.getElevation(view);
    }

    public static boolean getFitsSystemWindows(View view) {
        return f1242a.getFitsSystemWindows(view);
    }

    public static int getImportantForAccessibility(View view) {
        return f1242a.getImportantForAccessibility(view);
    }

    public static int getLabelFor(View view) {
        return f1242a.getLabelFor(view);
    }

    public static int getLayerType(View view) {
        return f1242a.getLayerType(view);
    }

    public static int getLayoutDirection(View view) {
        return f1242a.getLayoutDirection(view);
    }

    public static int getMeasuredHeightAndState(View view) {
        return f1242a.getMeasuredHeightAndState(view);
    }

    public static int getMeasuredState(View view) {
        return f1242a.getMeasuredState(view);
    }

    public static int getMeasuredWidthAndState(View view) {
        return f1242a.getMeasuredWidthAndState(view);
    }

    public static int getMinimumHeight(View view) {
        return f1242a.getMinimumHeight(view);
    }

    public static int getMinimumWidth(View view) {
        return f1242a.getMinimumWidth(view);
    }

    public static int getOverScrollMode(View view) {
        return f1242a.getOverScrollMode(view);
    }

    public static int getPaddingEnd(View view) {
        return f1242a.getPaddingEnd(view);
    }

    public static int getPaddingStart(View view) {
        return f1242a.getPaddingStart(view);
    }

    public static ViewParent getParentForAccessibility(View view) {
        return f1242a.getParentForAccessibility(view);
    }

    public static float getPivotX(View view) {
        return f1242a.getPivotX(view);
    }

    public static float getPivotY(View view) {
        return f1242a.getPivotY(view);
    }

    public static float getRotation(View view) {
        return f1242a.getRotation(view);
    }

    public static float getRotationX(View view) {
        return f1242a.getRotationX(view);
    }

    public static float getRotationY(View view) {
        return f1242a.getRotationY(view);
    }

    public static float getScaleX(View view) {
        return f1242a.getScaleX(view);
    }

    public static float getScaleY(View view) {
        return f1242a.getScaleY(view);
    }

    public static String getTransitionName(View view) {
        return f1242a.getTransitionName(view);
    }

    public static float getTranslationX(View view) {
        return f1242a.getTranslationX(view);
    }

    public static float getTranslationY(View view) {
        return f1242a.getTranslationY(view);
    }

    public static float getTranslationZ(View view) {
        return f1242a.getTranslationZ(view);
    }

    public static int getWindowSystemUiVisibility(View view) {
        return f1242a.getWindowSystemUiVisibility(view);
    }

    public static float getX(View view) {
        return f1242a.getX(view);
    }

    public static float getY(View view) {
        return f1242a.getY(view);
    }

    public static float getZ(View view) {
        return f1242a.getZ(view);
    }

    public static boolean hasAccessibilityDelegate(View view) {
        return f1242a.hasAccessibilityDelegate(view);
    }

    public static boolean hasNestedScrollingParent(View view) {
        return f1242a.hasNestedScrollingParent(view);
    }

    public static boolean hasOverlappingRendering(View view) {
        return f1242a.hasOverlappingRendering(view);
    }

    public static boolean hasTransientState(View view) {
        return f1242a.hasTransientState(view);
    }

    public static boolean isAttachedToWindow(View view) {
        return f1242a.isAttachedToWindow(view);
    }

    public static boolean isLaidOut(View view) {
        return f1242a.isLaidOut(view);
    }

    public static boolean isNestedScrollingEnabled(View view) {
        return f1242a.isNestedScrollingEnabled(view);
    }

    public static boolean isOpaque(View view) {
        return f1242a.isOpaque(view);
    }

    public static boolean isPaddingRelative(View view) {
        return f1242a.isPaddingRelative(view);
    }

    public static void jumpDrawablesToCurrentState(View view) {
        f1242a.jumpDrawablesToCurrentState(view);
    }

    public static void offsetLeftAndRight(View view, int i) {
        view.offsetLeftAndRight(i);
        if (i != 0 && Build.VERSION.SDK_INT < 11) {
            view.invalidate();
        }
    }

    public static void offsetTopAndBottom(View view, int i) {
        view.offsetTopAndBottom(i);
        if (i != 0 && Build.VERSION.SDK_INT < 11) {
            view.invalidate();
        }
    }

    public static WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        return f1242a.onApplyWindowInsets(view, windowInsetsCompat);
    }

    public static void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        f1242a.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public static void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        f1242a.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
    }

    public static void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        f1242a.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public static boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        return f1242a.performAccessibilityAction(view, i, bundle);
    }

    public static void postInvalidateOnAnimation(View view) {
        f1242a.postInvalidateOnAnimation(view);
    }

    public static void postInvalidateOnAnimation(View view, int i, int i2, int i3, int i4) {
        f1242a.postInvalidateOnAnimation(view, i, i2, i3, i4);
    }

    public static void postOnAnimation(View view, Runnable runnable) {
        f1242a.postOnAnimation(view, runnable);
    }

    public static void postOnAnimationDelayed(View view, Runnable runnable, long j) {
        f1242a.postOnAnimationDelayed(view, runnable, j);
    }

    public static void requestApplyInsets(View view) {
        f1242a.requestApplyInsets(view);
    }

    public static int resolveSizeAndState(int i, int i2, int i3) {
        return f1242a.resolveSizeAndState(i, i2, i3);
    }

    public static void setAccessibilityDelegate(View view, AccessibilityDelegateCompat accessibilityDelegateCompat) {
        f1242a.setAccessibilityDelegate(view, accessibilityDelegateCompat);
    }

    public static void setAccessibilityLiveRegion(View view, int i) {
        f1242a.setAccessibilityLiveRegion(view, i);
    }

    public static void setActivated(View view, boolean z) {
        f1242a.setActivated(view, z);
    }

    public static void setAlpha(View view, float f) {
        f1242a.setAlpha(view, f);
    }

    public static void setBackgroundTintList(View view, ColorStateList colorStateList) {
        f1242a.setBackgroundTintList(view, colorStateList);
    }

    public static void setBackgroundTintMode(View view, PorterDuff.Mode mode) {
        f1242a.setBackgroundTintMode(view, mode);
    }

    public static void setChildrenDrawingOrderEnabled(ViewGroup viewGroup, boolean z) {
        f1242a.setChildrenDrawingOrderEnabled(viewGroup, z);
    }

    public static void setClipBounds(View view, Rect rect) {
        f1242a.setClipBounds(view, rect);
    }

    public static void setElevation(View view, float f) {
        f1242a.setElevation(view, f);
    }

    public static void setFitsSystemWindows(View view, boolean z) {
        f1242a.setFitsSystemWindows(view, z);
    }

    public static void setHasTransientState(View view, boolean z) {
        f1242a.setHasTransientState(view, z);
    }

    public static void setImportantForAccessibility(View view, int i) {
        f1242a.setImportantForAccessibility(view, i);
    }

    public static void setLabelFor(View view, int i) {
        f1242a.setLabelFor(view, i);
    }

    public static void setLayerPaint(View view, Paint paint) {
        f1242a.setLayerPaint(view, paint);
    }

    public static void setLayerType(View view, int i, Paint paint) {
        f1242a.setLayerType(view, i, paint);
    }

    public static void setLayoutDirection(View view, int i) {
        f1242a.setLayoutDirection(view, i);
    }

    public static void setNestedScrollingEnabled(View view, boolean z) {
        f1242a.setNestedScrollingEnabled(view, z);
    }

    public static void setOnApplyWindowInsetsListener(View view, OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        f1242a.setOnApplyWindowInsetsListener(view, onApplyWindowInsetsListener);
    }

    public static void setOverScrollMode(View view, int i) {
        f1242a.setOverScrollMode(view, i);
    }

    public static void setPaddingRelative(View view, int i, int i2, int i3, int i4) {
        f1242a.setPaddingRelative(view, i, i2, i3, i4);
    }

    public static void setPivotX(View view, float f) {
        f1242a.setPivotX(view, f);
    }

    public static void setPivotY(View view, float f) {
        f1242a.setPivotX(view, f);
    }

    public static void setRotation(View view, float f) {
        f1242a.setRotation(view, f);
    }

    public static void setRotationX(View view, float f) {
        f1242a.setRotationX(view, f);
    }

    public static void setRotationY(View view, float f) {
        f1242a.setRotationY(view, f);
    }

    public static void setSaveFromParentEnabled(View view, boolean z) {
        f1242a.setSaveFromParentEnabled(view, z);
    }

    public static void setScaleX(View view, float f) {
        f1242a.setScaleX(view, f);
    }

    public static void setScaleY(View view, float f) {
        f1242a.setScaleY(view, f);
    }

    public static void setTransitionName(View view, String str) {
        f1242a.setTransitionName(view, str);
    }

    public static void setTranslationX(View view, float f) {
        f1242a.setTranslationX(view, f);
    }

    public static void setTranslationY(View view, float f) {
        f1242a.setTranslationY(view, f);
    }

    public static void setTranslationZ(View view, float f) {
        f1242a.setTranslationZ(view, f);
    }

    public static void setX(View view, float f) {
        f1242a.setX(view, f);
    }

    public static void setY(View view, float f) {
        f1242a.setY(view, f);
    }

    public static boolean startNestedScroll(View view, int i) {
        return f1242a.startNestedScroll(view, i);
    }

    public static void stopNestedScroll(View view) {
        f1242a.stopNestedScroll(view);
    }
}
