package android.support.p000v4.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.p000v4.p002os.ParcelableCompat;
import android.support.p000v4.p002os.ParcelableCompatCreatorCallbacks;
import android.support.p000v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.p000v4.view.accessibility.AccessibilityRecordCompat;
import android.support.p000v4.widget.EdgeEffectCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* renamed from: android.support.v4.view.ViewPager */
public class ViewPager extends ViewGroup {
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final int[] f1257a = {16842931};

    /* renamed from: ai */
    private static final ViewPositionComparator f1258ai = new ViewPositionComparator();

    /* renamed from: c */
    private static final Comparator<ItemInfo> f1259c = new Comparator<ItemInfo>() {
        public int compare(ItemInfo itemInfo, ItemInfo itemInfo2) {
            return itemInfo.f1319b - itemInfo2.f1319b;
        }
    };

    /* renamed from: d */
    private static final Interpolator f1260d = new Interpolator() {
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    };

    /* renamed from: A */
    private boolean f1261A;

    /* renamed from: B */
    private boolean f1262B;

    /* renamed from: C */
    private int f1263C;

    /* renamed from: D */
    private int f1264D;

    /* renamed from: E */
    private int f1265E;

    /* renamed from: F */
    private float f1266F;

    /* renamed from: G */
    private float f1267G;

    /* renamed from: H */
    private float f1268H;

    /* renamed from: I */
    private float f1269I;

    /* renamed from: J */
    private int f1270J = -1;

    /* renamed from: K */
    private VelocityTracker f1271K;

    /* renamed from: L */
    private int f1272L;

    /* renamed from: M */
    private int f1273M;

    /* renamed from: N */
    private int f1274N;

    /* renamed from: O */
    private int f1275O;

    /* renamed from: P */
    private boolean f1276P;

    /* renamed from: Q */
    private long f1277Q;

    /* renamed from: R */
    private EdgeEffectCompat f1278R;

    /* renamed from: S */
    private EdgeEffectCompat f1279S;

    /* renamed from: T */
    private boolean f1280T = true;

    /* renamed from: U */
    private boolean f1281U = false;

    /* renamed from: V */
    private boolean f1282V;

    /* renamed from: W */
    private int f1283W;

    /* renamed from: aa */
    private List<OnPageChangeListener> f1284aa;

    /* renamed from: ab */
    private OnPageChangeListener f1285ab;

    /* renamed from: ac */
    private OnPageChangeListener f1286ac;

    /* renamed from: ad */
    private OnAdapterChangeListener f1287ad;

    /* renamed from: ae */
    private PageTransformer f1288ae;

    /* renamed from: af */
    private Method f1289af;

    /* renamed from: ag */
    private int f1290ag;

    /* renamed from: ah */
    private ArrayList<View> f1291ah;

    /* renamed from: aj */
    private final Runnable f1292aj = new Runnable() {
        public void run() {
            ViewPager.this.setScrollState(0);
            ViewPager.this.mo2437c();
        }
    };

    /* renamed from: ak */
    private int f1293ak = 0;

    /* renamed from: b */
    private int f1294b;

    /* renamed from: e */
    private final ArrayList<ItemInfo> f1295e = new ArrayList<>();

    /* renamed from: f */
    private final ItemInfo f1296f = new ItemInfo();

    /* renamed from: g */
    private final Rect f1297g = new Rect();
    /* access modifiers changed from: private */

    /* renamed from: h */
    public PagerAdapter f1298h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public int f1299i;

    /* renamed from: j */
    private int f1300j = -1;

    /* renamed from: k */
    private Parcelable f1301k = null;

    /* renamed from: l */
    private ClassLoader f1302l = null;

    /* renamed from: m */
    private Scroller f1303m;

    /* renamed from: n */
    private PagerObserver f1304n;

    /* renamed from: o */
    private int f1305o;

    /* renamed from: p */
    private Drawable f1306p;

    /* renamed from: q */
    private int f1307q;

    /* renamed from: r */
    private int f1308r;

    /* renamed from: s */
    private float f1309s = -3.4028235E38f;

    /* renamed from: t */
    private float f1310t = Float.MAX_VALUE;

    /* renamed from: u */
    private int f1311u;

    /* renamed from: v */
    private int f1312v;

    /* renamed from: w */
    private boolean f1313w;

    /* renamed from: x */
    private boolean f1314x;

    /* renamed from: y */
    private boolean f1315y;

    /* renamed from: z */
    private int f1316z = 1;

    /* renamed from: android.support.v4.view.ViewPager$Decor */
    interface Decor {
    }

    /* renamed from: android.support.v4.view.ViewPager$ItemInfo */
    class ItemInfo {

        /* renamed from: a */
        Object f1318a;

        /* renamed from: b */
        int f1319b;

        /* renamed from: c */
        boolean f1320c;

        /* renamed from: d */
        float f1321d;

        /* renamed from: e */
        float f1322e;

        ItemInfo() {
        }
    }

    /* renamed from: android.support.v4.view.ViewPager$LayoutParams */
    public class LayoutParams extends ViewGroup.LayoutParams {

        /* renamed from: a */
        float f1323a = BitmapDescriptorFactory.HUE_RED;

        /* renamed from: b */
        boolean f1324b;

        /* renamed from: c */
        int f1325c;

        /* renamed from: d */
        int f1326d;
        public int gravity;
        public boolean isDecor;

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.f1257a);
            this.gravity = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    /* renamed from: android.support.v4.view.ViewPager$MyAccessibilityDelegate */
    class MyAccessibilityDelegate extends AccessibilityDelegateCompat {
        MyAccessibilityDelegate() {
        }

        /* renamed from: b */
        private boolean m929b() {
            return ViewPager.this.f1298h != null && ViewPager.this.f1298h.getCount() > 1;
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(ViewPager.class.getName());
            AccessibilityRecordCompat obtain = AccessibilityRecordCompat.obtain();
            obtain.setScrollable(m929b());
            if (accessibilityEvent.getEventType() == 4096 && ViewPager.this.f1298h != null) {
                obtain.setItemCount(ViewPager.this.f1298h.getCount());
                obtain.setFromIndex(ViewPager.this.f1299i);
                obtain.setToIndex(ViewPager.this.f1299i);
            }
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setClassName(ViewPager.class.getName());
            accessibilityNodeInfoCompat.setScrollable(m929b());
            if (ViewPager.this.canScrollHorizontally(1)) {
                accessibilityNodeInfoCompat.addAction(4096);
            }
            if (ViewPager.this.canScrollHorizontally(-1)) {
                accessibilityNodeInfoCompat.addAction(8192);
            }
        }

        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (super.performAccessibilityAction(view, i, bundle)) {
                return true;
            }
            switch (i) {
                case 4096:
                    if (!ViewPager.this.canScrollHorizontally(1)) {
                        return false;
                    }
                    ViewPager.this.setCurrentItem(ViewPager.this.f1299i + 1);
                    return true;
                case 8192:
                    if (!ViewPager.this.canScrollHorizontally(-1)) {
                        return false;
                    }
                    ViewPager.this.setCurrentItem(ViewPager.this.f1299i - 1);
                    return true;
                default:
                    return false;
            }
        }
    }

    /* renamed from: android.support.v4.view.ViewPager$OnAdapterChangeListener */
    interface OnAdapterChangeListener {
        void onAdapterChanged(PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2);
    }

    /* renamed from: android.support.v4.view.ViewPager$OnPageChangeListener */
    public interface OnPageChangeListener {
        void onPageScrollStateChanged(int i);

        void onPageScrolled(int i, float f, int i2);

        void onPageSelected(int i);
    }

    /* renamed from: android.support.v4.view.ViewPager$PageTransformer */
    public interface PageTransformer {
        void transformPage(View view, float f);
    }

    /* renamed from: android.support.v4.view.ViewPager$PagerObserver */
    class PagerObserver extends DataSetObserver {
        private PagerObserver() {
        }

        public void onChanged() {
            ViewPager.this.mo2435b();
        }

        public void onInvalidated() {
            ViewPager.this.mo2435b();
        }
    }

    /* renamed from: android.support.v4.view.ViewPager$SavedState */
    public class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = ParcelableCompat.newCreator(new ParcelableCompatCreatorCallbacks<SavedState>() {
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        });

        /* renamed from: a */
        int f1329a;

        /* renamed from: b */
        Parcelable f1330b;

        /* renamed from: c */
        ClassLoader f1331c;

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel);
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.f1329a = parcel.readInt();
            this.f1330b = parcel.readParcelable(classLoader);
            this.f1331c = classLoader;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.f1329a + "}";
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f1329a);
            parcel.writeParcelable(this.f1330b, i);
        }
    }

    /* renamed from: android.support.v4.view.ViewPager$SimpleOnPageChangeListener */
    public class SimpleOnPageChangeListener implements OnPageChangeListener {
        public void onPageScrollStateChanged(int i) {
        }

        public void onPageScrolled(int i, float f, int i2) {
        }

        public void onPageSelected(int i) {
        }
    }

    /* renamed from: android.support.v4.view.ViewPager$ViewPositionComparator */
    class ViewPositionComparator implements Comparator<View> {
        ViewPositionComparator() {
        }

        public int compare(View view, View view2) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            LayoutParams layoutParams2 = (LayoutParams) view2.getLayoutParams();
            return layoutParams.isDecor != layoutParams2.isDecor ? layoutParams.isDecor ? 1 : -1 : layoutParams.f1325c - layoutParams2.f1325c;
        }
    }

    public ViewPager(Context context) {
        super(context);
        mo2421a();
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        mo2421a();
    }

    /* renamed from: a */
    private int m889a(int i, float f, int i2, int i3) {
        if (Math.abs(i3) <= this.f1274N || Math.abs(i2) <= this.f1272L) {
            i = (int) ((i >= this.f1299i ? 0.4f : 0.6f) + ((float) i) + f);
        } else if (i2 <= 0) {
            i++;
        }
        return this.f1295e.size() > 0 ? Math.max(this.f1295e.get(0).f1319b, Math.min(i, this.f1295e.get(this.f1295e.size() - 1).f1319b)) : i;
    }

    /* renamed from: a */
    private Rect m890a(Rect rect, View view) {
        Rect rect2 = rect == null ? new Rect() : rect;
        if (view == null) {
            rect2.set(0, 0, 0, 0);
            return rect2;
        }
        rect2.left = view.getLeft();
        rect2.right = view.getRight();
        rect2.top = view.getTop();
        rect2.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect2.left += viewGroup.getLeft();
            rect2.right += viewGroup.getRight();
            rect2.top += viewGroup.getTop();
            rect2.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect2;
    }

    /* renamed from: a */
    private void m892a(int i, int i2, int i3, int i4) {
        if (i2 <= 0 || this.f1295e.isEmpty()) {
            ItemInfo b = mo2433b(this.f1299i);
            int min = (int) ((b != null ? Math.min(b.f1322e, this.f1310t) : BitmapDescriptorFactory.HUE_RED) * ((float) ((i - getPaddingLeft()) - getPaddingRight())));
            if (min != getScrollX()) {
                m897a(false);
                scrollTo(min, getScrollY());
                return;
            }
            return;
        }
        int paddingLeft = (int) (((float) (((i - getPaddingLeft()) - getPaddingRight()) + i3)) * (((float) getScrollX()) / ((float) (((i2 - getPaddingLeft()) - getPaddingRight()) + i4))));
        scrollTo(paddingLeft, getScrollY());
        if (!this.f1303m.isFinished()) {
            this.f1303m.startScroll(paddingLeft, 0, (int) (mo2433b(this.f1299i).f1322e * ((float) i)), 0, this.f1303m.getDuration() - this.f1303m.timePassed());
        }
    }

    /* renamed from: a */
    private void m893a(int i, boolean z, int i2, boolean z2) {
        int i3;
        ItemInfo b = mo2433b(i);
        if (b != null) {
            i3 = (int) (Math.max(this.f1309s, Math.min(b.f1322e, this.f1310t)) * ((float) getClientWidth()));
        } else {
            i3 = 0;
        }
        if (z) {
            mo2424a(i3, 0, i2);
            if (z2) {
                m905d(i);
                return;
            }
            return;
        }
        if (z2) {
            m905d(i);
        }
        m897a(false);
        scrollTo(i3, 0);
        m904c(i3);
    }

    /* renamed from: a */
    private void m894a(ItemInfo itemInfo, int i, ItemInfo itemInfo2) {
        ItemInfo itemInfo3;
        ItemInfo itemInfo4;
        int count = this.f1298h.getCount();
        int clientWidth = getClientWidth();
        float f = clientWidth > 0 ? ((float) this.f1305o) / ((float) clientWidth) : 0.0f;
        if (itemInfo2 != null) {
            int i2 = itemInfo2.f1319b;
            if (i2 < itemInfo.f1319b) {
                float f2 = itemInfo2.f1322e + itemInfo2.f1321d + f;
                int i3 = i2 + 1;
                int i4 = 0;
                while (i3 <= itemInfo.f1319b && i4 < this.f1295e.size()) {
                    Object obj = this.f1295e.get(i4);
                    while (true) {
                        itemInfo4 = (ItemInfo) obj;
                        if (i3 > itemInfo4.f1319b && i4 < this.f1295e.size() - 1) {
                            i4++;
                            obj = this.f1295e.get(i4);
                        }
                    }
                    while (i3 < itemInfo4.f1319b) {
                        f2 += this.f1298h.getPageWidth(i3) + f;
                        i3++;
                    }
                    itemInfo4.f1322e = f2;
                    f2 += itemInfo4.f1321d + f;
                    i3++;
                }
            } else if (i2 > itemInfo.f1319b) {
                int size = this.f1295e.size() - 1;
                float f3 = itemInfo2.f1322e;
                int i5 = i2 - 1;
                while (i5 >= itemInfo.f1319b && size >= 0) {
                    Object obj2 = this.f1295e.get(size);
                    while (true) {
                        itemInfo3 = (ItemInfo) obj2;
                        if (i5 < itemInfo3.f1319b && size > 0) {
                            size--;
                            obj2 = this.f1295e.get(size);
                        }
                    }
                    while (i5 > itemInfo3.f1319b) {
                        f3 -= this.f1298h.getPageWidth(i5) + f;
                        i5--;
                    }
                    f3 -= itemInfo3.f1321d + f;
                    itemInfo3.f1322e = f3;
                    i5--;
                }
            }
        }
        int size2 = this.f1295e.size();
        float f4 = itemInfo.f1322e;
        int i6 = itemInfo.f1319b - 1;
        this.f1309s = itemInfo.f1319b == 0 ? itemInfo.f1322e : -3.4028235E38f;
        this.f1310t = itemInfo.f1319b == count + -1 ? (itemInfo.f1322e + itemInfo.f1321d) - 1.0f : Float.MAX_VALUE;
        for (int i7 = i - 1; i7 >= 0; i7--) {
            ItemInfo itemInfo5 = this.f1295e.get(i7);
            float f5 = f4;
            while (i6 > itemInfo5.f1319b) {
                f5 -= this.f1298h.getPageWidth(i6) + f;
                i6--;
            }
            f4 = f5 - (itemInfo5.f1321d + f);
            itemInfo5.f1322e = f4;
            if (itemInfo5.f1319b == 0) {
                this.f1309s = f4;
            }
            i6--;
        }
        float f6 = itemInfo.f1322e + itemInfo.f1321d + f;
        int i8 = itemInfo.f1319b + 1;
        for (int i9 = i + 1; i9 < size2; i9++) {
            ItemInfo itemInfo6 = this.f1295e.get(i9);
            float f7 = f6;
            while (i8 < itemInfo6.f1319b) {
                f7 = this.f1298h.getPageWidth(i8) + f + f7;
                i8++;
            }
            if (itemInfo6.f1319b == count - 1) {
                this.f1310t = (itemInfo6.f1321d + f7) - 1.0f;
            }
            itemInfo6.f1322e = f7;
            f6 = f7 + itemInfo6.f1321d + f;
            i8++;
        }
        this.f1281U = false;
    }

    /* renamed from: a */
    private void m896a(MotionEvent motionEvent) {
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (MotionEventCompat.getPointerId(motionEvent, actionIndex) == this.f1270J) {
            int i = actionIndex == 0 ? 1 : 0;
            this.f1266F = MotionEventCompat.getX(motionEvent, i);
            this.f1270J = MotionEventCompat.getPointerId(motionEvent, i);
            if (this.f1271K != null) {
                this.f1271K.clear();
            }
        }
    }

    /* renamed from: a */
    private void m897a(boolean z) {
        boolean z2 = this.f1293ak == 2;
        if (z2) {
            setScrollingCacheEnabled(false);
            this.f1303m.abortAnimation();
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.f1303m.getCurrX();
            int currY = this.f1303m.getCurrY();
            if (!(scrollX == currX && scrollY == currY)) {
                scrollTo(currX, currY);
                if (currX != scrollX) {
                    m904c(currX);
                }
            }
        }
        this.f1315y = false;
        boolean z3 = z2;
        for (int i = 0; i < this.f1295e.size(); i++) {
            ItemInfo itemInfo = this.f1295e.get(i);
            if (itemInfo.f1320c) {
                itemInfo.f1320c = false;
                z3 = true;
            }
        }
        if (!z3) {
            return;
        }
        if (z) {
            ViewCompat.postOnAnimation(this, this.f1292aj);
        } else {
            this.f1292aj.run();
        }
    }

    /* renamed from: a */
    private boolean m898a(float f, float f2) {
        return (f < ((float) this.f1264D) && f2 > BitmapDescriptorFactory.HUE_RED) || (f > ((float) (getWidth() - this.f1264D)) && f2 < BitmapDescriptorFactory.HUE_RED);
    }

    /* renamed from: b */
    private void m900b(int i, float f, int i2) {
        if (this.f1285ab != null) {
            this.f1285ab.onPageScrolled(i, f, i2);
        }
        if (this.f1284aa != null) {
            int size = this.f1284aa.size();
            for (int i3 = 0; i3 < size; i3++) {
                OnPageChangeListener onPageChangeListener = this.f1284aa.get(i3);
                if (onPageChangeListener != null) {
                    onPageChangeListener.onPageScrolled(i, f, i2);
                }
            }
        }
        if (this.f1286ac != null) {
            this.f1286ac.onPageScrolled(i, f, i2);
        }
    }

    /* renamed from: b */
    private void m901b(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            ViewCompat.setLayerType(getChildAt(i), z ? 2 : 0, (Paint) null);
        }
    }

    /* renamed from: b */
    private boolean m902b(float f) {
        boolean z;
        float f2;
        boolean z2 = true;
        boolean z3 = false;
        this.f1266F = f;
        float scrollX = ((float) getScrollX()) + (this.f1266F - f);
        int clientWidth = getClientWidth();
        float f3 = ((float) clientWidth) * this.f1309s;
        float f4 = ((float) clientWidth) * this.f1310t;
        ItemInfo itemInfo = this.f1295e.get(0);
        ItemInfo itemInfo2 = this.f1295e.get(this.f1295e.size() - 1);
        if (itemInfo.f1319b != 0) {
            f3 = itemInfo.f1322e * ((float) clientWidth);
            z = false;
        } else {
            z = true;
        }
        if (itemInfo2.f1319b != this.f1298h.getCount() - 1) {
            f2 = itemInfo2.f1322e * ((float) clientWidth);
            z2 = false;
        } else {
            f2 = f4;
        }
        if (scrollX < f3) {
            if (z) {
                z3 = this.f1278R.onPull(Math.abs(f3 - scrollX) / ((float) clientWidth));
            }
        } else if (scrollX > f2) {
            if (z2) {
                z3 = this.f1279S.onPull(Math.abs(scrollX - f2) / ((float) clientWidth));
            }
            f3 = f2;
        } else {
            f3 = scrollX;
        }
        this.f1266F += f3 - ((float) ((int) f3));
        scrollTo((int) f3, getScrollY());
        m904c((int) f3);
        return z3;
    }

    /* renamed from: c */
    private void m903c(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    /* renamed from: c */
    private boolean m904c(int i) {
        if (this.f1295e.size() == 0) {
            this.f1282V = false;
            mo2423a(0, (float) BitmapDescriptorFactory.HUE_RED, 0);
            if (this.f1282V) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        ItemInfo i2 = m910i();
        int clientWidth = getClientWidth();
        int i3 = this.f1305o + clientWidth;
        float f = ((float) this.f1305o) / ((float) clientWidth);
        int i4 = i2.f1319b;
        float f2 = ((((float) i) / ((float) clientWidth)) - i2.f1322e) / (i2.f1321d + f);
        this.f1282V = false;
        mo2423a(i4, f2, (int) (((float) i3) * f2));
        if (this.f1282V) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    /* renamed from: d */
    private void m905d(int i) {
        if (this.f1285ab != null) {
            this.f1285ab.onPageSelected(i);
        }
        if (this.f1284aa != null) {
            int size = this.f1284aa.size();
            for (int i2 = 0; i2 < size; i2++) {
                OnPageChangeListener onPageChangeListener = this.f1284aa.get(i2);
                if (onPageChangeListener != null) {
                    onPageChangeListener.onPageSelected(i);
                }
            }
        }
        if (this.f1286ac != null) {
            this.f1286ac.onPageSelected(i);
        }
    }

    /* renamed from: e */
    private void m906e(int i) {
        if (this.f1285ab != null) {
            this.f1285ab.onPageScrollStateChanged(i);
        }
        if (this.f1284aa != null) {
            int size = this.f1284aa.size();
            for (int i2 = 0; i2 < size; i2++) {
                OnPageChangeListener onPageChangeListener = this.f1284aa.get(i2);
                if (onPageChangeListener != null) {
                    onPageChangeListener.onPageScrollStateChanged(i);
                }
            }
        }
        if (this.f1286ac != null) {
            this.f1286ac.onPageScrollStateChanged(i);
        }
    }

    /* renamed from: g */
    private void m908g() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < getChildCount()) {
                if (!((LayoutParams) getChildAt(i2).getLayoutParams()).isDecor) {
                    removeViewAt(i2);
                    i2--;
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    /* renamed from: h */
    private void m909h() {
        if (this.f1290ag != 0) {
            if (this.f1291ah == null) {
                this.f1291ah = new ArrayList<>();
            } else {
                this.f1291ah.clear();
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                this.f1291ah.add(getChildAt(i));
            }
            Collections.sort(this.f1291ah, f1258ai);
        }
    }

    /* renamed from: i */
    private ItemInfo m910i() {
        int i;
        ItemInfo itemInfo;
        int clientWidth = getClientWidth();
        float scrollX = clientWidth > 0 ? ((float) getScrollX()) / ((float) clientWidth) : 0.0f;
        float f = clientWidth > 0 ? ((float) this.f1305o) / ((float) clientWidth) : 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        int i2 = -1;
        int i3 = 0;
        boolean z = true;
        ItemInfo itemInfo2 = null;
        while (i3 < this.f1295e.size()) {
            ItemInfo itemInfo3 = this.f1295e.get(i3);
            if (z || itemInfo3.f1319b == i2 + 1) {
                ItemInfo itemInfo4 = itemInfo3;
                i = i3;
                itemInfo = itemInfo4;
            } else {
                ItemInfo itemInfo5 = this.f1296f;
                itemInfo5.f1322e = f2 + f3 + f;
                itemInfo5.f1319b = i2 + 1;
                itemInfo5.f1321d = this.f1298h.getPageWidth(itemInfo5.f1319b);
                ItemInfo itemInfo6 = itemInfo5;
                i = i3 - 1;
                itemInfo = itemInfo6;
            }
            float f4 = itemInfo.f1322e;
            float f5 = itemInfo.f1321d + f4 + f;
            if (!z && scrollX < f4) {
                return itemInfo2;
            }
            if (scrollX < f5 || i == this.f1295e.size() - 1) {
                return itemInfo;
            }
            f3 = f4;
            i2 = itemInfo.f1319b;
            z = false;
            f2 = itemInfo.f1321d;
            itemInfo2 = itemInfo;
            i3 = i + 1;
        }
        return itemInfo2;
    }

    /* renamed from: j */
    private void m911j() {
        this.f1261A = false;
        this.f1262B = false;
        if (this.f1271K != null) {
            this.f1271K.recycle();
            this.f1271K = null;
        }
    }

    /* access modifiers changed from: private */
    public void setScrollState(int i) {
        if (this.f1293ak != i) {
            this.f1293ak = i;
            if (this.f1288ae != null) {
                m901b(i != 0);
            }
            m906e(i);
        }
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.f1314x != z) {
            this.f1314x = z;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public float mo2417a(float f) {
        return (float) Math.sin((double) ((float) (((double) (f - 0.5f)) * 0.4712389167638204d)));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public ItemInfo mo2418a(int i, int i2) {
        ItemInfo itemInfo = new ItemInfo();
        itemInfo.f1319b = i;
        itemInfo.f1318a = this.f1298h.instantiateItem((ViewGroup) this, i);
        itemInfo.f1321d = this.f1298h.getPageWidth(i);
        if (i2 < 0 || i2 >= this.f1295e.size()) {
            this.f1295e.add(itemInfo);
        } else {
            this.f1295e.add(i2, itemInfo);
        }
        return itemInfo;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public ItemInfo mo2419a(View view) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f1295e.size()) {
                return null;
            }
            ItemInfo itemInfo = this.f1295e.get(i2);
            if (this.f1298h.isViewFromObject(view, itemInfo.f1318a)) {
                return itemInfo;
            }
            i = i2 + 1;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public OnPageChangeListener mo2420a(OnPageChangeListener onPageChangeListener) {
        OnPageChangeListener onPageChangeListener2 = this.f1286ac;
        this.f1286ac = onPageChangeListener;
        return onPageChangeListener2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2421a() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.f1303m = new Scroller(context, f1260d);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f = context.getResources().getDisplayMetrics().density;
        this.f1265E = ViewConfigurationCompat.getScaledPagingTouchSlop(viewConfiguration);
        this.f1272L = (int) (400.0f * f);
        this.f1273M = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f1278R = new EdgeEffectCompat(context);
        this.f1279S = new EdgeEffectCompat(context);
        this.f1274N = (int) (25.0f * f);
        this.f1275O = (int) (2.0f * f);
        this.f1263C = (int) (16.0f * f);
        ViewCompat.setAccessibilityDelegate(this, new MyAccessibilityDelegate());
        if (ViewCompat.getImportantForAccessibility(this) == 0) {
            ViewCompat.setImportantForAccessibility(this, 1);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00ff, code lost:
        if (r2.f1319b == r18.f1299i) goto L_0x0101;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo2422a(int r19) {
        /*
            r18 = this;
            r3 = 0
            r2 = 2
            r0 = r18
            int r4 = r0.f1299i
            r0 = r19
            if (r4 == r0) goto L_0x033f
            r0 = r18
            int r2 = r0.f1299i
            r0 = r19
            if (r2 >= r0) goto L_0x0030
            r2 = 66
        L_0x0014:
            r0 = r18
            int r3 = r0.f1299i
            r0 = r18
            android.support.v4.view.ViewPager$ItemInfo r3 = r0.mo2433b((int) r3)
            r0 = r19
            r1 = r18
            r1.f1299i = r0
            r4 = r3
            r3 = r2
        L_0x0026:
            r0 = r18
            android.support.v4.view.PagerAdapter r2 = r0.f1298h
            if (r2 != 0) goto L_0x0033
            r18.m909h()
        L_0x002f:
            return
        L_0x0030:
            r2 = 17
            goto L_0x0014
        L_0x0033:
            r0 = r18
            boolean r2 = r0.f1315y
            if (r2 == 0) goto L_0x003d
            r18.m909h()
            goto L_0x002f
        L_0x003d:
            android.os.IBinder r2 = r18.getWindowToken()
            if (r2 == 0) goto L_0x002f
            r0 = r18
            android.support.v4.view.PagerAdapter r2 = r0.f1298h
            r0 = r18
            r2.startUpdate((android.view.ViewGroup) r0)
            r0 = r18
            int r2 = r0.f1316z
            r5 = 0
            r0 = r18
            int r6 = r0.f1299i
            int r6 = r6 - r2
            int r11 = java.lang.Math.max(r5, r6)
            r0 = r18
            android.support.v4.view.PagerAdapter r5 = r0.f1298h
            int r12 = r5.getCount()
            int r5 = r12 + -1
            r0 = r18
            int r6 = r0.f1299i
            int r2 = r2 + r6
            int r13 = java.lang.Math.min(r5, r2)
            r0 = r18
            int r2 = r0.f1294b
            if (r12 == r2) goto L_0x00da
            android.content.res.Resources r2 = r18.getResources()     // Catch:{ NotFoundException -> 0x00d0 }
            int r3 = r18.getId()     // Catch:{ NotFoundException -> 0x00d0 }
            java.lang.String r2 = r2.getResourceName(r3)     // Catch:{ NotFoundException -> 0x00d0 }
        L_0x007f:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: "
            java.lang.StringBuilder r4 = r4.append(r5)
            r0 = r18
            int r5 = r0.f1294b
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.String r5 = ", found: "
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.StringBuilder r4 = r4.append(r12)
            java.lang.String r5 = " Pager id: "
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.StringBuilder r2 = r4.append(r2)
            java.lang.String r4 = " Pager class: "
            java.lang.StringBuilder r2 = r2.append(r4)
            java.lang.Class r4 = r18.getClass()
            java.lang.StringBuilder r2 = r2.append(r4)
            java.lang.String r4 = " Problematic adapter: "
            java.lang.StringBuilder r2 = r2.append(r4)
            r0 = r18
            android.support.v4.view.PagerAdapter r4 = r0.f1298h
            java.lang.Class r4 = r4.getClass()
            java.lang.StringBuilder r2 = r2.append(r4)
            java.lang.String r2 = r2.toString()
            r3.<init>(r2)
            throw r3
        L_0x00d0:
            r2 = move-exception
            int r2 = r18.getId()
            java.lang.String r2 = java.lang.Integer.toHexString(r2)
            goto L_0x007f
        L_0x00da:
            r6 = 0
            r2 = 0
            r5 = r2
        L_0x00dd:
            r0 = r18
            java.util.ArrayList<android.support.v4.view.ViewPager$ItemInfo> r2 = r0.f1295e
            int r2 = r2.size()
            if (r5 >= r2) goto L_0x033c
            r0 = r18
            java.util.ArrayList<android.support.v4.view.ViewPager$ItemInfo> r2 = r0.f1295e
            java.lang.Object r2 = r2.get(r5)
            android.support.v4.view.ViewPager$ItemInfo r2 = (android.support.p000v4.view.ViewPager.ItemInfo) r2
            int r7 = r2.f1319b
            r0 = r18
            int r8 = r0.f1299i
            if (r7 < r8) goto L_0x01cf
            int r7 = r2.f1319b
            r0 = r18
            int r8 = r0.f1299i
            if (r7 != r8) goto L_0x033c
        L_0x0101:
            if (r2 != 0) goto L_0x0339
            if (r12 <= 0) goto L_0x0339
            r0 = r18
            int r2 = r0.f1299i
            r0 = r18
            android.support.v4.view.ViewPager$ItemInfo r2 = r0.mo2418a((int) r2, (int) r5)
            r10 = r2
        L_0x0110:
            if (r10 == 0) goto L_0x0180
            r9 = 0
            int r8 = r5 + -1
            if (r8 < 0) goto L_0x01d4
            r0 = r18
            java.util.ArrayList<android.support.v4.view.ViewPager$ItemInfo> r2 = r0.f1295e
            java.lang.Object r2 = r2.get(r8)
            android.support.v4.view.ViewPager$ItemInfo r2 = (android.support.p000v4.view.ViewPager.ItemInfo) r2
        L_0x0121:
            int r14 = r18.getClientWidth()
            if (r14 > 0) goto L_0x01d7
            r6 = 0
        L_0x0128:
            r0 = r18
            int r7 = r0.f1299i
            int r7 = r7 + -1
            r16 = r7
            r7 = r9
            r9 = r16
            r17 = r8
            r8 = r5
            r5 = r17
        L_0x0138:
            if (r9 < 0) goto L_0x0142
            int r15 = (r7 > r6 ? 1 : (r7 == r6 ? 0 : -1))
            if (r15 < 0) goto L_0x0216
            if (r9 >= r11) goto L_0x0216
            if (r2 != 0) goto L_0x01e6
        L_0x0142:
            float r6 = r10.f1321d
            int r9 = r8 + 1
            r2 = 1073741824(0x40000000, float:2.0)
            int r2 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r2 >= 0) goto L_0x017b
            r0 = r18
            java.util.ArrayList<android.support.v4.view.ViewPager$ItemInfo> r2 = r0.f1295e
            int r2 = r2.size()
            if (r9 >= r2) goto L_0x024c
            r0 = r18
            java.util.ArrayList<android.support.v4.view.ViewPager$ItemInfo> r2 = r0.f1295e
            java.lang.Object r2 = r2.get(r9)
            android.support.v4.view.ViewPager$ItemInfo r2 = (android.support.p000v4.view.ViewPager.ItemInfo) r2
            r7 = r2
        L_0x0161:
            if (r14 > 0) goto L_0x024f
            r2 = 0
            r5 = r2
        L_0x0165:
            r0 = r18
            int r2 = r0.f1299i
            int r2 = r2 + 1
            r16 = r2
            r2 = r7
            r7 = r9
            r9 = r16
        L_0x0171:
            if (r9 >= r12) goto L_0x017b
            int r11 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1))
            if (r11 < 0) goto L_0x029a
            if (r9 <= r13) goto L_0x029a
            if (r2 != 0) goto L_0x025c
        L_0x017b:
            r0 = r18
            r0.m894a((android.support.p000v4.view.ViewPager.ItemInfo) r10, (int) r8, (android.support.p000v4.view.ViewPager.ItemInfo) r4)
        L_0x0180:
            r0 = r18
            android.support.v4.view.PagerAdapter r4 = r0.f1298h
            r0 = r18
            int r5 = r0.f1299i
            if (r10 == 0) goto L_0x02e8
            java.lang.Object r2 = r10.f1318a
        L_0x018c:
            r0 = r18
            r4.setPrimaryItem((android.view.ViewGroup) r0, (int) r5, (java.lang.Object) r2)
            r0 = r18
            android.support.v4.view.PagerAdapter r2 = r0.f1298h
            r0 = r18
            r2.finishUpdate((android.view.ViewGroup) r0)
            int r5 = r18.getChildCount()
            r2 = 0
            r4 = r2
        L_0x01a0:
            if (r4 >= r5) goto L_0x02eb
            r0 = r18
            android.view.View r6 = r0.getChildAt(r4)
            android.view.ViewGroup$LayoutParams r2 = r6.getLayoutParams()
            android.support.v4.view.ViewPager$LayoutParams r2 = (android.support.p000v4.view.ViewPager.LayoutParams) r2
            r2.f1326d = r4
            boolean r7 = r2.isDecor
            if (r7 != 0) goto L_0x01cb
            float r7 = r2.f1323a
            r8 = 0
            int r7 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
            if (r7 != 0) goto L_0x01cb
            r0 = r18
            android.support.v4.view.ViewPager$ItemInfo r6 = r0.mo2419a((android.view.View) r6)
            if (r6 == 0) goto L_0x01cb
            float r7 = r6.f1321d
            r2.f1323a = r7
            int r6 = r6.f1319b
            r2.f1325c = r6
        L_0x01cb:
            int r2 = r4 + 1
            r4 = r2
            goto L_0x01a0
        L_0x01cf:
            int r2 = r5 + 1
            r5 = r2
            goto L_0x00dd
        L_0x01d4:
            r2 = 0
            goto L_0x0121
        L_0x01d7:
            r6 = 1073741824(0x40000000, float:2.0)
            float r7 = r10.f1321d
            float r6 = r6 - r7
            int r7 = r18.getPaddingLeft()
            float r7 = (float) r7
            float r15 = (float) r14
            float r7 = r7 / r15
            float r6 = r6 + r7
            goto L_0x0128
        L_0x01e6:
            int r15 = r2.f1319b
            if (r9 != r15) goto L_0x0210
            boolean r15 = r2.f1320c
            if (r15 != 0) goto L_0x0210
            r0 = r18
            java.util.ArrayList<android.support.v4.view.ViewPager$ItemInfo> r15 = r0.f1295e
            r15.remove(r5)
            r0 = r18
            android.support.v4.view.PagerAdapter r15 = r0.f1298h
            java.lang.Object r2 = r2.f1318a
            r0 = r18
            r15.destroyItem((android.view.ViewGroup) r0, (int) r9, (java.lang.Object) r2)
            int r5 = r5 + -1
            int r8 = r8 + -1
            if (r5 < 0) goto L_0x0214
            r0 = r18
            java.util.ArrayList<android.support.v4.view.ViewPager$ItemInfo> r2 = r0.f1295e
            java.lang.Object r2 = r2.get(r5)
            android.support.v4.view.ViewPager$ItemInfo r2 = (android.support.p000v4.view.ViewPager.ItemInfo) r2
        L_0x0210:
            int r9 = r9 + -1
            goto L_0x0138
        L_0x0214:
            r2 = 0
            goto L_0x0210
        L_0x0216:
            if (r2 == 0) goto L_0x0230
            int r15 = r2.f1319b
            if (r9 != r15) goto L_0x0230
            float r2 = r2.f1321d
            float r7 = r7 + r2
            int r5 = r5 + -1
            if (r5 < 0) goto L_0x022e
            r0 = r18
            java.util.ArrayList<android.support.v4.view.ViewPager$ItemInfo> r2 = r0.f1295e
            java.lang.Object r2 = r2.get(r5)
            android.support.v4.view.ViewPager$ItemInfo r2 = (android.support.p000v4.view.ViewPager.ItemInfo) r2
            goto L_0x0210
        L_0x022e:
            r2 = 0
            goto L_0x0210
        L_0x0230:
            int r2 = r5 + 1
            r0 = r18
            android.support.v4.view.ViewPager$ItemInfo r2 = r0.mo2418a((int) r9, (int) r2)
            float r2 = r2.f1321d
            float r7 = r7 + r2
            int r8 = r8 + 1
            if (r5 < 0) goto L_0x024a
            r0 = r18
            java.util.ArrayList<android.support.v4.view.ViewPager$ItemInfo> r2 = r0.f1295e
            java.lang.Object r2 = r2.get(r5)
            android.support.v4.view.ViewPager$ItemInfo r2 = (android.support.p000v4.view.ViewPager.ItemInfo) r2
            goto L_0x0210
        L_0x024a:
            r2 = 0
            goto L_0x0210
        L_0x024c:
            r7 = 0
            goto L_0x0161
        L_0x024f:
            int r2 = r18.getPaddingRight()
            float r2 = (float) r2
            float r5 = (float) r14
            float r2 = r2 / r5
            r5 = 1073741824(0x40000000, float:2.0)
            float r2 = r2 + r5
            r5 = r2
            goto L_0x0165
        L_0x025c:
            int r11 = r2.f1319b
            if (r9 != r11) goto L_0x0332
            boolean r11 = r2.f1320c
            if (r11 != 0) goto L_0x0332
            r0 = r18
            java.util.ArrayList<android.support.v4.view.ViewPager$ItemInfo> r11 = r0.f1295e
            r11.remove(r7)
            r0 = r18
            android.support.v4.view.PagerAdapter r11 = r0.f1298h
            java.lang.Object r2 = r2.f1318a
            r0 = r18
            r11.destroyItem((android.view.ViewGroup) r0, (int) r9, (java.lang.Object) r2)
            r0 = r18
            java.util.ArrayList<android.support.v4.view.ViewPager$ItemInfo> r2 = r0.f1295e
            int r2 = r2.size()
            if (r7 >= r2) goto L_0x0298
            r0 = r18
            java.util.ArrayList<android.support.v4.view.ViewPager$ItemInfo> r2 = r0.f1295e
            java.lang.Object r2 = r2.get(r7)
            android.support.v4.view.ViewPager$ItemInfo r2 = (android.support.p000v4.view.ViewPager.ItemInfo) r2
        L_0x028a:
            r16 = r6
            r6 = r2
            r2 = r16
        L_0x028f:
            int r9 = r9 + 1
            r16 = r2
            r2 = r6
            r6 = r16
            goto L_0x0171
        L_0x0298:
            r2 = 0
            goto L_0x028a
        L_0x029a:
            if (r2 == 0) goto L_0x02c1
            int r11 = r2.f1319b
            if (r9 != r11) goto L_0x02c1
            float r2 = r2.f1321d
            float r6 = r6 + r2
            int r7 = r7 + 1
            r0 = r18
            java.util.ArrayList<android.support.v4.view.ViewPager$ItemInfo> r2 = r0.f1295e
            int r2 = r2.size()
            if (r7 >= r2) goto L_0x02bf
            r0 = r18
            java.util.ArrayList<android.support.v4.view.ViewPager$ItemInfo> r2 = r0.f1295e
            java.lang.Object r2 = r2.get(r7)
            android.support.v4.view.ViewPager$ItemInfo r2 = (android.support.p000v4.view.ViewPager.ItemInfo) r2
        L_0x02b9:
            r16 = r6
            r6 = r2
            r2 = r16
            goto L_0x028f
        L_0x02bf:
            r2 = 0
            goto L_0x02b9
        L_0x02c1:
            r0 = r18
            android.support.v4.view.ViewPager$ItemInfo r2 = r0.mo2418a((int) r9, (int) r7)
            int r7 = r7 + 1
            float r2 = r2.f1321d
            float r6 = r6 + r2
            r0 = r18
            java.util.ArrayList<android.support.v4.view.ViewPager$ItemInfo> r2 = r0.f1295e
            int r2 = r2.size()
            if (r7 >= r2) goto L_0x02e6
            r0 = r18
            java.util.ArrayList<android.support.v4.view.ViewPager$ItemInfo> r2 = r0.f1295e
            java.lang.Object r2 = r2.get(r7)
            android.support.v4.view.ViewPager$ItemInfo r2 = (android.support.p000v4.view.ViewPager.ItemInfo) r2
        L_0x02e0:
            r16 = r6
            r6 = r2
            r2 = r16
            goto L_0x028f
        L_0x02e6:
            r2 = 0
            goto L_0x02e0
        L_0x02e8:
            r2 = 0
            goto L_0x018c
        L_0x02eb:
            r18.m909h()
            boolean r2 = r18.hasFocus()
            if (r2 == 0) goto L_0x002f
            android.view.View r2 = r18.findFocus()
            if (r2 == 0) goto L_0x0330
            r0 = r18
            android.support.v4.view.ViewPager$ItemInfo r2 = r0.mo2434b((android.view.View) r2)
        L_0x0300:
            if (r2 == 0) goto L_0x030a
            int r2 = r2.f1319b
            r0 = r18
            int r4 = r0.f1299i
            if (r2 == r4) goto L_0x002f
        L_0x030a:
            r2 = 0
        L_0x030b:
            int r4 = r18.getChildCount()
            if (r2 >= r4) goto L_0x002f
            r0 = r18
            android.view.View r4 = r0.getChildAt(r2)
            r0 = r18
            android.support.v4.view.ViewPager$ItemInfo r5 = r0.mo2419a((android.view.View) r4)
            if (r5 == 0) goto L_0x032d
            int r5 = r5.f1319b
            r0 = r18
            int r6 = r0.f1299i
            if (r5 != r6) goto L_0x032d
            boolean r4 = r4.requestFocus(r3)
            if (r4 != 0) goto L_0x002f
        L_0x032d:
            int r2 = r2 + 1
            goto L_0x030b
        L_0x0330:
            r2 = 0
            goto L_0x0300
        L_0x0332:
            r16 = r6
            r6 = r2
            r2 = r16
            goto L_0x028f
        L_0x0339:
            r10 = r2
            goto L_0x0110
        L_0x033c:
            r2 = r6
            goto L_0x0101
        L_0x033f:
            r4 = r3
            r3 = r2
            goto L_0x0026
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p000v4.view.ViewPager.mo2422a(int):void");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo2423a(int i, float f, int i2) {
        int measuredWidth;
        int i3;
        int i4;
        if (this.f1283W > 0) {
            int scrollX = getScrollX();
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int width = getWidth();
            int childCount = getChildCount();
            int i5 = 0;
            while (i5 < childCount) {
                View childAt = getChildAt(i5);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (!layoutParams.isDecor) {
                    int i6 = paddingRight;
                    i3 = paddingLeft;
                    i4 = i6;
                } else {
                    switch (layoutParams.gravity & 7) {
                        case 1:
                            measuredWidth = Math.max((width - childAt.getMeasuredWidth()) / 2, paddingLeft);
                            int i7 = paddingRight;
                            i3 = paddingLeft;
                            i4 = i7;
                            break;
                        case 3:
                            int width2 = childAt.getWidth() + paddingLeft;
                            int i8 = paddingLeft;
                            i4 = paddingRight;
                            i3 = width2;
                            measuredWidth = i8;
                            break;
                        case 5:
                            measuredWidth = (width - paddingRight) - childAt.getMeasuredWidth();
                            int measuredWidth2 = paddingRight + childAt.getMeasuredWidth();
                            i3 = paddingLeft;
                            i4 = measuredWidth2;
                            break;
                        default:
                            measuredWidth = paddingLeft;
                            int i9 = paddingRight;
                            i3 = paddingLeft;
                            i4 = i9;
                            break;
                    }
                    int left = (measuredWidth + scrollX) - childAt.getLeft();
                    if (left != 0) {
                        childAt.offsetLeftAndRight(left);
                    }
                }
                i5++;
                int i10 = i4;
                paddingLeft = i3;
                paddingRight = i10;
            }
        }
        m900b(i, f, i2);
        if (this.f1288ae != null) {
            int scrollX2 = getScrollX();
            int childCount2 = getChildCount();
            for (int i11 = 0; i11 < childCount2; i11++) {
                View childAt2 = getChildAt(i11);
                if (!((LayoutParams) childAt2.getLayoutParams()).isDecor) {
                    this.f1288ae.transformPage(childAt2, ((float) (childAt2.getLeft() - scrollX2)) / ((float) getClientWidth()));
                }
            }
        }
        this.f1282V = true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2424a(int i, int i2, int i3) {
        int abs;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int i4 = i - scrollX;
        int i5 = i2 - scrollY;
        if (i4 == 0 && i5 == 0) {
            m897a(false);
            mo2437c();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i6 = clientWidth / 2;
        float a = (((float) i6) * mo2417a(Math.min(1.0f, (((float) Math.abs(i4)) * 1.0f) / ((float) clientWidth)))) + ((float) i6);
        int abs2 = Math.abs(i3);
        if (abs2 > 0) {
            abs = Math.round(1000.0f * Math.abs(a / ((float) abs2))) * 4;
        } else {
            abs = (int) (((((float) Math.abs(i4)) / ((((float) clientWidth) * this.f1298h.getPageWidth(this.f1299i)) + ((float) this.f1305o))) + 1.0f) * 100.0f);
        }
        this.f1303m.startScroll(scrollX, scrollY, i4, i5, Math.min(abs, 600));
        ViewCompat.postInvalidateOnAnimation(this);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2425a(int i, boolean z, boolean z2) {
        mo2426a(i, z, z2, 0);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2426a(int i, boolean z, boolean z2, int i2) {
        boolean z3 = false;
        if (this.f1298h == null || this.f1298h.getCount() <= 0) {
            setScrollingCacheEnabled(false);
        } else if (z2 || this.f1299i != i || this.f1295e.size() == 0) {
            if (i < 0) {
                i = 0;
            } else if (i >= this.f1298h.getCount()) {
                i = this.f1298h.getCount() - 1;
            }
            int i3 = this.f1316z;
            if (i > this.f1299i + i3 || i < this.f1299i - i3) {
                for (int i4 = 0; i4 < this.f1295e.size(); i4++) {
                    this.f1295e.get(i4).f1320c = true;
                }
            }
            if (this.f1299i != i) {
                z3 = true;
            }
            if (this.f1280T) {
                this.f1299i = i;
                if (z3) {
                    m905d(i);
                }
                requestLayout();
                return;
            }
            mo2422a(i);
            m893a(i, z, i2, z3);
        } else {
            setScrollingCacheEnabled(false);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo2427a(View view, boolean z, int i, int i2, int i3) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (i2 + scrollX >= childAt.getLeft() && i2 + scrollX < childAt.getRight() && i3 + scrollY >= childAt.getTop() && i3 + scrollY < childAt.getBottom()) {
                    if (mo2427a(childAt, true, i, (i2 + scrollX) - childAt.getLeft(), (i3 + scrollY) - childAt.getTop())) {
                        return true;
                    }
                }
            }
        }
        return z && ViewCompat.canScrollHorizontally(view, -i);
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        ItemInfo a;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0 && (a = mo2419a(childAt)) != null && a.f1319b == this.f1299i) {
                    childAt.addFocusables(arrayList, i, i2);
                }
            }
        }
        if ((descendantFocusability == 262144 && size != arrayList.size()) || !isFocusable()) {
            return;
        }
        if (((i2 & 1) != 1 || !isInTouchMode() || isFocusableInTouchMode()) && arrayList != null) {
            arrayList.add(this);
        }
    }

    public void addOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        if (this.f1284aa == null) {
            this.f1284aa = new ArrayList();
        }
        this.f1284aa.add(onPageChangeListener);
    }

    public void addTouchables(ArrayList<View> arrayList) {
        ItemInfo a;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (a = mo2419a(childAt)) != null && a.f1319b == this.f1299i) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        ViewGroup.LayoutParams generateLayoutParams = !checkLayoutParams(layoutParams) ? generateLayoutParams(layoutParams) : layoutParams;
        LayoutParams layoutParams2 = (LayoutParams) generateLayoutParams;
        layoutParams2.isDecor |= view instanceof Decor;
        if (!this.f1313w) {
            super.addView(view, i, generateLayoutParams);
        } else if (layoutParams2 == null || !layoutParams2.isDecor) {
            layoutParams2.f1324b = true;
            addViewInLayout(view, i, generateLayoutParams);
        } else {
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
    }

    public boolean arrowScroll(int i) {
        View view;
        boolean z;
        boolean z2;
        View findFocus = findFocus();
        if (findFocus == this) {
            view = null;
        } else {
            if (findFocus != null) {
                ViewParent parent = findFocus.getParent();
                while (true) {
                    if (!(parent instanceof ViewGroup)) {
                        z = false;
                        break;
                    } else if (parent == this) {
                        z = true;
                        break;
                    } else {
                        parent = parent.getParent();
                    }
                }
                if (!z) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(findFocus.getClass().getSimpleName());
                    for (ViewParent parent2 = findFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                        sb.append(" => ").append(parent2.getClass().getSimpleName());
                    }
                    Log.e("ViewPager", "arrowScroll tried to find focus based on non-child current focused view " + sb.toString());
                    view = null;
                }
            }
            view = findFocus;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, view, i);
        if (findNextFocus == null || findNextFocus == view) {
            if (i == 17 || i == 1) {
                z2 = mo2442d();
            } else {
                if (i == 66 || i == 2) {
                    z2 = mo2447e();
                }
                z2 = false;
            }
        } else if (i == 17) {
            z2 = (view == null || m890a(this.f1297g, findNextFocus).left < m890a(this.f1297g, view).left) ? findNextFocus.requestFocus() : mo2442d();
        } else {
            if (i == 66) {
                z2 = (view == null || m890a(this.f1297g, findNextFocus).left > m890a(this.f1297g, view).left) ? findNextFocus.requestFocus() : mo2447e();
            }
            z2 = false;
        }
        if (z2) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
        }
        return z2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public ItemInfo mo2433b(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.f1295e.size()) {
                return null;
            }
            ItemInfo itemInfo = this.f1295e.get(i3);
            if (itemInfo.f1319b == i) {
                return itemInfo;
            }
            i2 = i3 + 1;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public ItemInfo mo2434b(View view) {
        while (true) {
            ViewParent parent = view.getParent();
            if (parent == this) {
                return mo2419a(view);
            }
            if (parent == null || !(parent instanceof View)) {
                return null;
            }
            view = (View) parent;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo2435b() {
        int i;
        boolean z;
        int i2;
        boolean z2;
        int count = this.f1298h.getCount();
        this.f1294b = count;
        boolean z3 = this.f1295e.size() < (this.f1316z * 2) + 1 && this.f1295e.size() < count;
        boolean z4 = false;
        int i3 = this.f1299i;
        boolean z5 = z3;
        int i4 = 0;
        while (i4 < this.f1295e.size()) {
            ItemInfo itemInfo = this.f1295e.get(i4);
            int itemPosition = this.f1298h.getItemPosition(itemInfo.f1318a);
            if (itemPosition == -1) {
                i = i4;
                z = z4;
                i2 = i3;
                z2 = z5;
            } else if (itemPosition == -2) {
                this.f1295e.remove(i4);
                int i5 = i4 - 1;
                if (!z4) {
                    this.f1298h.startUpdate((ViewGroup) this);
                    z4 = true;
                }
                this.f1298h.destroyItem((ViewGroup) this, itemInfo.f1319b, itemInfo.f1318a);
                if (this.f1299i == itemInfo.f1319b) {
                    i = i5;
                    z = z4;
                    i2 = Math.max(0, Math.min(this.f1299i, count - 1));
                    z2 = true;
                } else {
                    i = i5;
                    z = z4;
                    i2 = i3;
                    z2 = true;
                }
            } else if (itemInfo.f1319b != itemPosition) {
                if (itemInfo.f1319b == this.f1299i) {
                    i3 = itemPosition;
                }
                itemInfo.f1319b = itemPosition;
                i = i4;
                z = z4;
                i2 = i3;
                z2 = true;
            } else {
                i = i4;
                z = z4;
                i2 = i3;
                z2 = z5;
            }
            z5 = z2;
            i3 = i2;
            z4 = z;
            i4 = i + 1;
        }
        if (z4) {
            this.f1298h.finishUpdate((ViewGroup) this);
        }
        Collections.sort(this.f1295e, f1259c);
        if (z5) {
            int childCount = getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i6).getLayoutParams();
                if (!layoutParams.isDecor) {
                    layoutParams.f1323a = BitmapDescriptorFactory.HUE_RED;
                }
            }
            mo2425a(i3, false, true);
            requestLayout();
        }
    }

    public boolean beginFakeDrag() {
        if (this.f1261A) {
            return false;
        }
        this.f1276P = true;
        setScrollState(1);
        this.f1266F = BitmapDescriptorFactory.HUE_RED;
        this.f1268H = BitmapDescriptorFactory.HUE_RED;
        if (this.f1271K == null) {
            this.f1271K = VelocityTracker.obtain();
        } else {
            this.f1271K.clear();
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 0);
        this.f1271K.addMovement(obtain);
        obtain.recycle();
        this.f1277Q = uptimeMillis;
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo2437c() {
        mo2422a(this.f1299i);
    }

    public boolean canScrollHorizontally(int i) {
        boolean z = true;
        if (this.f1298h == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        if (i < 0) {
            if (scrollX <= ((int) (((float) clientWidth) * this.f1309s))) {
                z = false;
            }
            return z;
        } else if (i <= 0) {
            return false;
        } else {
            if (scrollX >= ((int) (((float) clientWidth) * this.f1310t))) {
                z = false;
            }
            return z;
        }
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public void clearOnPageChangeListeners() {
        if (this.f1284aa != null) {
            this.f1284aa.clear();
        }
    }

    public void computeScroll() {
        if (this.f1303m.isFinished() || !this.f1303m.computeScrollOffset()) {
            m897a(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.f1303m.getCurrX();
        int currY = this.f1303m.getCurrY();
        if (!(scrollX == currX && scrollY == currY)) {
            scrollTo(currX, currY);
            if (!m904c(currX)) {
                this.f1303m.abortAnimation();
                scrollTo(0, currY);
            }
        }
        ViewCompat.postInvalidateOnAnimation(this);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public boolean mo2442d() {
        if (this.f1299i <= 0) {
            return false;
        }
        setCurrentItem(this.f1299i - 1, true);
        return true;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || executeKeyEvent(keyEvent);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        ItemInfo a;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (a = mo2419a(childAt)) != null && a.f1319b == this.f1299i && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        boolean z = false;
        int overScrollMode = ViewCompat.getOverScrollMode(this);
        if (overScrollMode == 0 || (overScrollMode == 1 && this.f1298h != null && this.f1298h.getCount() > 1)) {
            if (!this.f1278R.isFinished()) {
                int save = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((float) ((-height) + getPaddingTop()), this.f1309s * ((float) width));
                this.f1278R.setSize(height, width);
                z = false | this.f1278R.draw(canvas);
                canvas.restoreToCount(save);
            }
            if (!this.f1279S.isFinished()) {
                int save2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate((float) (-getPaddingTop()), (-(this.f1310t + 1.0f)) * ((float) width2));
                this.f1279S.setSize(height2, width2);
                z |= this.f1279S.draw(canvas);
                canvas.restoreToCount(save2);
            }
        } else {
            this.f1278R.finish();
            this.f1279S.finish();
        }
        if (z) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f1306p;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public boolean mo2447e() {
        if (this.f1298h == null || this.f1299i >= this.f1298h.getCount() - 1) {
            return false;
        }
        setCurrentItem(this.f1299i + 1, true);
        return true;
    }

    public void endFakeDrag() {
        if (!this.f1276P) {
            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        }
        VelocityTracker velocityTracker = this.f1271K;
        velocityTracker.computeCurrentVelocity(1000, (float) this.f1273M);
        int xVelocity = (int) VelocityTrackerCompat.getXVelocity(velocityTracker, this.f1270J);
        this.f1315y = true;
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        ItemInfo i = m910i();
        mo2426a(m889a(i.f1319b, ((((float) scrollX) / ((float) clientWidth)) - i.f1322e) / i.f1321d, xVelocity, (int) (this.f1266F - this.f1268H)), true, true, xVelocity);
        m911j();
        this.f1276P = false;
    }

    public boolean executeKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0) {
            return false;
        }
        switch (keyEvent.getKeyCode()) {
            case 21:
                return arrowScroll(17);
            case 22:
                return arrowScroll(66);
            case 61:
                if (Build.VERSION.SDK_INT < 11) {
                    return false;
                }
                if (KeyEventCompat.hasNoModifiers(keyEvent)) {
                    return arrowScroll(2);
                }
                if (KeyEventCompat.hasModifiers(keyEvent, 1)) {
                    return arrowScroll(1);
                }
                return false;
            default:
                return false;
        }
    }

    public void fakeDragBy(float f) {
        if (!this.f1276P) {
            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        }
        this.f1266F += f;
        float scrollX = ((float) getScrollX()) - f;
        int clientWidth = getClientWidth();
        float f2 = ((float) clientWidth) * this.f1309s;
        float f3 = ((float) clientWidth) * this.f1310t;
        ItemInfo itemInfo = this.f1295e.get(0);
        ItemInfo itemInfo2 = this.f1295e.get(this.f1295e.size() - 1);
        float f4 = itemInfo.f1319b != 0 ? itemInfo.f1322e * ((float) clientWidth) : f2;
        float f5 = itemInfo2.f1319b != this.f1298h.getCount() + -1 ? itemInfo2.f1322e * ((float) clientWidth) : f3;
        if (scrollX >= f4) {
            f4 = scrollX > f5 ? f5 : scrollX;
        }
        this.f1266F += f4 - ((float) ((int) f4));
        scrollTo((int) f4, getScrollY());
        m904c((int) f4);
        MotionEvent obtain = MotionEvent.obtain(this.f1277Q, SystemClock.uptimeMillis(), 2, this.f1266F, BitmapDescriptorFactory.HUE_RED, 0);
        this.f1271K.addMovement(obtain);
        obtain.recycle();
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
        return generateDefaultLayoutParams();
    }

    public PagerAdapter getAdapter() {
        return this.f1298h;
    }

    /* access modifiers changed from: protected */
    public int getChildDrawingOrder(int i, int i2) {
        if (this.f1290ag == 2) {
            i2 = (i - 1) - i2;
        }
        return ((LayoutParams) this.f1291ah.get(i2).getLayoutParams()).f1326d;
    }

    public int getCurrentItem() {
        return this.f1299i;
    }

    public int getOffscreenPageLimit() {
        return this.f1316z;
    }

    public int getPageMargin() {
        return this.f1305o;
    }

    public boolean isFakeDragging() {
        return this.f1276P;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f1280T = true;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        removeCallbacks(this.f1292aj);
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        float f;
        super.onDraw(canvas);
        if (this.f1305o > 0 && this.f1306p != null && this.f1295e.size() > 0 && this.f1298h != null) {
            int scrollX = getScrollX();
            int width = getWidth();
            float f2 = ((float) this.f1305o) / ((float) width);
            ItemInfo itemInfo = this.f1295e.get(0);
            float f3 = itemInfo.f1322e;
            int size = this.f1295e.size();
            int i = itemInfo.f1319b;
            int i2 = this.f1295e.get(size - 1).f1319b;
            int i3 = 0;
            int i4 = i;
            while (i4 < i2) {
                while (i4 > itemInfo.f1319b && i3 < size) {
                    i3++;
                    itemInfo = this.f1295e.get(i3);
                }
                if (i4 == itemInfo.f1319b) {
                    f = (itemInfo.f1322e + itemInfo.f1321d) * ((float) width);
                    f3 = itemInfo.f1322e + itemInfo.f1321d + f2;
                } else {
                    float pageWidth = this.f1298h.getPageWidth(i4);
                    f = (f3 + pageWidth) * ((float) width);
                    f3 += pageWidth + f2;
                }
                if (((float) this.f1305o) + f > ((float) scrollX)) {
                    this.f1306p.setBounds((int) f, this.f1307q, (int) (((float) this.f1305o) + f + 0.5f), this.f1308r);
                    this.f1306p.draw(canvas);
                }
                if (f <= ((float) (scrollX + width))) {
                    i4++;
                } else {
                    return;
                }
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            this.f1261A = false;
            this.f1262B = false;
            this.f1270J = -1;
            if (this.f1271K == null) {
                return false;
            }
            this.f1271K.recycle();
            this.f1271K = null;
            return false;
        }
        if (action != 0) {
            if (this.f1261A) {
                return true;
            }
            if (this.f1262B) {
                return false;
            }
        }
        switch (action) {
            case 0:
                float x = motionEvent.getX();
                this.f1268H = x;
                this.f1266F = x;
                float y = motionEvent.getY();
                this.f1269I = y;
                this.f1267G = y;
                this.f1270J = MotionEventCompat.getPointerId(motionEvent, 0);
                this.f1262B = false;
                this.f1303m.computeScrollOffset();
                if (this.f1293ak == 2 && Math.abs(this.f1303m.getFinalX() - this.f1303m.getCurrX()) > this.f1275O) {
                    this.f1303m.abortAnimation();
                    this.f1315y = false;
                    mo2437c();
                    this.f1261A = true;
                    m903c(true);
                    setScrollState(1);
                    break;
                } else {
                    m897a(false);
                    this.f1261A = false;
                    break;
                }
                break;
            case 2:
                int i = this.f1270J;
                if (i != -1) {
                    int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i);
                    float x2 = MotionEventCompat.getX(motionEvent, findPointerIndex);
                    float f = x2 - this.f1266F;
                    float abs = Math.abs(f);
                    float y2 = MotionEventCompat.getY(motionEvent, findPointerIndex);
                    float abs2 = Math.abs(y2 - this.f1269I);
                    if (f != BitmapDescriptorFactory.HUE_RED && !m898a(this.f1266F, f)) {
                        if (mo2427a(this, false, (int) f, (int) x2, (int) y2)) {
                            this.f1266F = x2;
                            this.f1267G = y2;
                            this.f1262B = true;
                            return false;
                        }
                    }
                    if (abs > ((float) this.f1265E) && 0.5f * abs > abs2) {
                        this.f1261A = true;
                        m903c(true);
                        setScrollState(1);
                        this.f1266F = f > BitmapDescriptorFactory.HUE_RED ? this.f1268H + ((float) this.f1265E) : this.f1268H - ((float) this.f1265E);
                        this.f1267G = y2;
                        setScrollingCacheEnabled(true);
                    } else if (abs2 > ((float) this.f1265E)) {
                        this.f1262B = true;
                    }
                    if (this.f1261A && m902b(x2)) {
                        ViewCompat.postInvalidateOnAnimation(this);
                        break;
                    }
                }
                break;
            case 6:
                m896a(motionEvent);
                break;
        }
        if (this.f1271K == null) {
            this.f1271K = VelocityTracker.obtain();
        }
        this.f1271K.addMovement(motionEvent);
        return this.f1261A;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        ItemInfo a;
        int i5;
        int i6;
        int i7;
        int measuredHeight;
        int i8;
        int i9;
        int childCount = getChildCount();
        int i10 = i3 - i;
        int i11 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int i12 = 0;
        int i13 = 0;
        while (i13 < childCount) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.isDecor) {
                    int i14 = layoutParams.gravity & 7;
                    int i15 = layoutParams.gravity & 112;
                    switch (i14) {
                        case 1:
                            i7 = Math.max((i10 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                            break;
                        case 3:
                            i7 = paddingLeft;
                            paddingLeft = childAt.getMeasuredWidth() + paddingLeft;
                            break;
                        case 5:
                            int measuredWidth = (i10 - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                            i7 = measuredWidth;
                            break;
                        default:
                            i7 = paddingLeft;
                            break;
                    }
                    switch (i15) {
                        case 16:
                            measuredHeight = Math.max((i11 - childAt.getMeasuredHeight()) / 2, paddingTop);
                            int i16 = paddingBottom;
                            i8 = paddingTop;
                            i9 = i16;
                            break;
                        case 48:
                            int measuredHeight2 = childAt.getMeasuredHeight() + paddingTop;
                            int i17 = paddingTop;
                            i9 = paddingBottom;
                            i8 = measuredHeight2;
                            measuredHeight = i17;
                            break;
                        case 80:
                            measuredHeight = (i11 - paddingBottom) - childAt.getMeasuredHeight();
                            int measuredHeight3 = paddingBottom + childAt.getMeasuredHeight();
                            i8 = paddingTop;
                            i9 = measuredHeight3;
                            break;
                        default:
                            measuredHeight = paddingTop;
                            int i18 = paddingBottom;
                            i8 = paddingTop;
                            i9 = i18;
                            break;
                    }
                    int i19 = i7 + scrollX;
                    childAt.layout(i19, measuredHeight, childAt.getMeasuredWidth() + i19, childAt.getMeasuredHeight() + measuredHeight);
                    i5 = i12 + 1;
                    i6 = i8;
                    paddingBottom = i9;
                    i13++;
                    paddingLeft = paddingLeft;
                    paddingRight = paddingRight;
                    paddingTop = i6;
                    i12 = i5;
                }
            }
            i5 = i12;
            i6 = paddingTop;
            i13++;
            paddingLeft = paddingLeft;
            paddingRight = paddingRight;
            paddingTop = i6;
            i12 = i5;
        }
        int i20 = (i10 - paddingLeft) - paddingRight;
        for (int i21 = 0; i21 < childCount; i21++) {
            View childAt2 = getChildAt(i21);
            if (childAt2.getVisibility() != 8) {
                LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                if (!layoutParams2.isDecor && (a = mo2419a(childAt2)) != null) {
                    int i22 = ((int) (a.f1322e * ((float) i20))) + paddingLeft;
                    if (layoutParams2.f1324b) {
                        layoutParams2.f1324b = false;
                        childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (layoutParams2.f1323a * ((float) i20)), 1073741824), View.MeasureSpec.makeMeasureSpec((i11 - paddingTop) - paddingBottom, 1073741824));
                    }
                    childAt2.layout(i22, paddingTop, childAt2.getMeasuredWidth() + i22, childAt2.getMeasuredHeight() + paddingTop);
                }
            }
        }
        this.f1307q = paddingTop;
        this.f1308r = i11 - paddingBottom;
        this.f1283W = i12;
        if (this.f1280T) {
            m893a(this.f1299i, false, 0, false);
        }
        this.f1280T = false;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00b4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r14, int r15) {
        /*
            r13 = this;
            r0 = 0
            int r0 = getDefaultSize(r0, r14)
            r1 = 0
            int r1 = getDefaultSize(r1, r15)
            r13.setMeasuredDimension(r0, r1)
            int r0 = r13.getMeasuredWidth()
            int r1 = r0 / 10
            int r2 = r13.f1263C
            int r1 = java.lang.Math.min(r1, r2)
            r13.f1264D = r1
            int r1 = r13.getPaddingLeft()
            int r0 = r0 - r1
            int r1 = r13.getPaddingRight()
            int r3 = r0 - r1
            int r0 = r13.getMeasuredHeight()
            int r1 = r13.getPaddingTop()
            int r0 = r0 - r1
            int r1 = r13.getPaddingBottom()
            int r5 = r0 - r1
            int r9 = r13.getChildCount()
            r0 = 0
            r8 = r0
        L_0x003b:
            if (r8 >= r9) goto L_0x00bc
            android.view.View r10 = r13.getChildAt(r8)
            int r0 = r10.getVisibility()
            r1 = 8
            if (r0 == r1) goto L_0x00a5
            android.view.ViewGroup$LayoutParams r0 = r10.getLayoutParams()
            android.support.v4.view.ViewPager$LayoutParams r0 = (android.support.p000v4.view.ViewPager.LayoutParams) r0
            if (r0 == 0) goto L_0x00a5
            boolean r1 = r0.isDecor
            if (r1 == 0) goto L_0x00a5
            int r1 = r0.gravity
            r6 = r1 & 7
            int r1 = r0.gravity
            r4 = r1 & 112(0x70, float:1.57E-43)
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r7 = 48
            if (r4 == r7) goto L_0x0069
            r7 = 80
            if (r4 != r7) goto L_0x00a9
        L_0x0069:
            r4 = 1
            r7 = r4
        L_0x006b:
            r4 = 3
            if (r6 == r4) goto L_0x0071
            r4 = 5
            if (r6 != r4) goto L_0x00ac
        L_0x0071:
            r4 = 1
            r6 = r4
        L_0x0073:
            if (r7 == 0) goto L_0x00af
            r2 = 1073741824(0x40000000, float:2.0)
        L_0x0077:
            int r4 = r0.width
            r11 = -2
            if (r4 == r11) goto L_0x010f
            r4 = 1073741824(0x40000000, float:2.0)
            int r2 = r0.width
            r11 = -1
            if (r2 == r11) goto L_0x010c
            int r2 = r0.width
        L_0x0085:
            int r11 = r0.height
            r12 = -2
            if (r11 == r12) goto L_0x010a
            r1 = 1073741824(0x40000000, float:2.0)
            int r11 = r0.height
            r12 = -1
            if (r11 == r12) goto L_0x010a
            int r0 = r0.height
        L_0x0093:
            int r2 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r4)
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r1)
            r10.measure(r2, r0)
            if (r7 == 0) goto L_0x00b4
            int r0 = r10.getMeasuredHeight()
            int r5 = r5 - r0
        L_0x00a5:
            int r0 = r8 + 1
            r8 = r0
            goto L_0x003b
        L_0x00a9:
            r4 = 0
            r7 = r4
            goto L_0x006b
        L_0x00ac:
            r4 = 0
            r6 = r4
            goto L_0x0073
        L_0x00af:
            if (r6 == 0) goto L_0x0077
            r1 = 1073741824(0x40000000, float:2.0)
            goto L_0x0077
        L_0x00b4:
            if (r6 == 0) goto L_0x00a5
            int r0 = r10.getMeasuredWidth()
            int r3 = r3 - r0
            goto L_0x00a5
        L_0x00bc:
            r0 = 1073741824(0x40000000, float:2.0)
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r3, r0)
            r13.f1311u = r0
            r0 = 1073741824(0x40000000, float:2.0)
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r0)
            r13.f1312v = r0
            r0 = 1
            r13.f1313w = r0
            r13.mo2437c()
            r0 = 0
            r13.f1313w = r0
            int r2 = r13.getChildCount()
            r0 = 0
            r1 = r0
        L_0x00db:
            if (r1 >= r2) goto L_0x0109
            android.view.View r4 = r13.getChildAt(r1)
            int r0 = r4.getVisibility()
            r5 = 8
            if (r0 == r5) goto L_0x0105
            android.view.ViewGroup$LayoutParams r0 = r4.getLayoutParams()
            android.support.v4.view.ViewPager$LayoutParams r0 = (android.support.p000v4.view.ViewPager.LayoutParams) r0
            if (r0 == 0) goto L_0x00f5
            boolean r5 = r0.isDecor
            if (r5 != 0) goto L_0x0105
        L_0x00f5:
            float r5 = (float) r3
            float r0 = r0.f1323a
            float r0 = r0 * r5
            int r0 = (int) r0
            r5 = 1073741824(0x40000000, float:2.0)
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r5)
            int r5 = r13.f1312v
            r4.measure(r0, r5)
        L_0x0105:
            int r0 = r1 + 1
            r1 = r0
            goto L_0x00db
        L_0x0109:
            return
        L_0x010a:
            r0 = r5
            goto L_0x0093
        L_0x010c:
            r2 = r3
            goto L_0x0085
        L_0x010f:
            r4 = r2
            r2 = r3
            goto L_0x0085
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p000v4.view.ViewPager.onMeasure(int, int):void");
    }

    /* access modifiers changed from: protected */
    public boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2;
        ItemInfo a;
        int i3 = -1;
        int childCount = getChildCount();
        if ((i & 2) != 0) {
            i3 = 1;
            i2 = 0;
        } else {
            i2 = childCount - 1;
            childCount = -1;
        }
        while (i2 != childCount) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (a = mo2419a(childAt)) != null && a.f1319b == this.f1299i && childAt.requestFocus(i, rect)) {
                return true;
            }
            i2 += i3;
        }
        return false;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.f1298h != null) {
            this.f1298h.restoreState(savedState.f1330b, savedState.f1331c);
            mo2425a(savedState.f1329a, false, true);
            return;
        }
        this.f1300j = savedState.f1329a;
        this.f1301k = savedState.f1330b;
        this.f1302l = savedState.f1331c;
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f1329a = this.f1299i;
        if (this.f1298h != null) {
            savedState.f1330b = this.f1298h.saveState();
        }
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            m892a(i, i3, this.f1305o, this.f1305o);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.f1276P) {
            return true;
        }
        if (motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) {
            return false;
        }
        if (this.f1298h == null || this.f1298h.getCount() == 0) {
            return false;
        }
        if (this.f1271K == null) {
            this.f1271K = VelocityTracker.obtain();
        }
        this.f1271K.addMovement(motionEvent);
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.f1303m.abortAnimation();
                this.f1315y = false;
                mo2437c();
                float x = motionEvent.getX();
                this.f1268H = x;
                this.f1266F = x;
                float y = motionEvent.getY();
                this.f1269I = y;
                this.f1267G = y;
                this.f1270J = MotionEventCompat.getPointerId(motionEvent, 0);
                break;
            case 1:
                if (this.f1261A) {
                    VelocityTracker velocityTracker = this.f1271K;
                    velocityTracker.computeCurrentVelocity(1000, (float) this.f1273M);
                    int xVelocity = (int) VelocityTrackerCompat.getXVelocity(velocityTracker, this.f1270J);
                    this.f1315y = true;
                    int clientWidth = getClientWidth();
                    int scrollX = getScrollX();
                    ItemInfo i = m910i();
                    mo2426a(m889a(i.f1319b, ((((float) scrollX) / ((float) clientWidth)) - i.f1322e) / i.f1321d, xVelocity, (int) (MotionEventCompat.getX(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.f1270J)) - this.f1268H)), true, true, xVelocity);
                    this.f1270J = -1;
                    m911j();
                    z = this.f1279S.onRelease() | this.f1278R.onRelease();
                    break;
                }
                break;
            case 2:
                if (!this.f1261A) {
                    int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, this.f1270J);
                    float x2 = MotionEventCompat.getX(motionEvent, findPointerIndex);
                    float abs = Math.abs(x2 - this.f1266F);
                    float y2 = MotionEventCompat.getY(motionEvent, findPointerIndex);
                    float abs2 = Math.abs(y2 - this.f1267G);
                    if (abs > ((float) this.f1265E) && abs > abs2) {
                        this.f1261A = true;
                        m903c(true);
                        this.f1266F = x2 - this.f1268H > BitmapDescriptorFactory.HUE_RED ? this.f1268H + ((float) this.f1265E) : this.f1268H - ((float) this.f1265E);
                        this.f1267G = y2;
                        setScrollState(1);
                        setScrollingCacheEnabled(true);
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                }
                if (this.f1261A) {
                    z = false | m902b(MotionEventCompat.getX(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.f1270J)));
                    break;
                }
                break;
            case 3:
                if (this.f1261A) {
                    m893a(this.f1299i, true, 0, false);
                    this.f1270J = -1;
                    m911j();
                    z = this.f1279S.onRelease() | this.f1278R.onRelease();
                    break;
                }
                break;
            case 5:
                int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                this.f1266F = MotionEventCompat.getX(motionEvent, actionIndex);
                this.f1270J = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                break;
            case 6:
                m896a(motionEvent);
                this.f1266F = MotionEventCompat.getX(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.f1270J));
                break;
        }
        if (z) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
        return true;
    }

    public void removeOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        if (this.f1284aa != null) {
            this.f1284aa.remove(onPageChangeListener);
        }
    }

    public void removeView(View view) {
        if (this.f1313w) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public void setAdapter(PagerAdapter pagerAdapter) {
        if (this.f1298h != null) {
            this.f1298h.unregisterDataSetObserver(this.f1304n);
            this.f1298h.startUpdate((ViewGroup) this);
            for (int i = 0; i < this.f1295e.size(); i++) {
                ItemInfo itemInfo = this.f1295e.get(i);
                this.f1298h.destroyItem((ViewGroup) this, itemInfo.f1319b, itemInfo.f1318a);
            }
            this.f1298h.finishUpdate((ViewGroup) this);
            this.f1295e.clear();
            m908g();
            this.f1299i = 0;
            scrollTo(0, 0);
        }
        PagerAdapter pagerAdapter2 = this.f1298h;
        this.f1298h = pagerAdapter;
        this.f1294b = 0;
        if (this.f1298h != null) {
            if (this.f1304n == null) {
                this.f1304n = new PagerObserver();
            }
            this.f1298h.registerDataSetObserver(this.f1304n);
            this.f1315y = false;
            boolean z = this.f1280T;
            this.f1280T = true;
            this.f1294b = this.f1298h.getCount();
            if (this.f1300j >= 0) {
                this.f1298h.restoreState(this.f1301k, this.f1302l);
                mo2425a(this.f1300j, false, true);
                this.f1300j = -1;
                this.f1301k = null;
                this.f1302l = null;
            } else if (!z) {
                mo2437c();
            } else {
                requestLayout();
            }
        }
        if (this.f1287ad != null && pagerAdapter2 != pagerAdapter) {
            this.f1287ad.onAdapterChanged(pagerAdapter2, pagerAdapter);
        }
    }

    /* access modifiers changed from: package-private */
    public void setChildrenDrawingOrderEnabledCompat(boolean z) {
        if (Build.VERSION.SDK_INT >= 7) {
            if (this.f1289af == null) {
                Class<ViewGroup> cls = ViewGroup.class;
                try {
                    this.f1289af = cls.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[]{Boolean.TYPE});
                } catch (NoSuchMethodException e) {
                    Log.e("ViewPager", "Can't find setChildrenDrawingOrderEnabled", e);
                }
            }
            try {
                this.f1289af.invoke(this, new Object[]{Boolean.valueOf(z)});
            } catch (Exception e2) {
                Log.e("ViewPager", "Error changing children drawing order", e2);
            }
        }
    }

    public void setCurrentItem(int i) {
        this.f1315y = false;
        mo2425a(i, !this.f1280T, false);
    }

    public void setCurrentItem(int i, boolean z) {
        this.f1315y = false;
        mo2425a(i, z, false);
    }

    public void setOffscreenPageLimit(int i) {
        if (i < 1) {
            Log.w("ViewPager", "Requested offscreen page limit " + i + " too small; defaulting to " + 1);
            i = 1;
        }
        if (i != this.f1316z) {
            this.f1316z = i;
            mo2437c();
        }
    }

    /* access modifiers changed from: package-private */
    public void setOnAdapterChangeListener(OnAdapterChangeListener onAdapterChangeListener) {
        this.f1287ad = onAdapterChangeListener;
    }

    @Deprecated
    public void setOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        this.f1285ab = onPageChangeListener;
    }

    public void setPageMargin(int i) {
        int i2 = this.f1305o;
        this.f1305o = i;
        int width = getWidth();
        m892a(width, width, i, i2);
        requestLayout();
    }

    public void setPageMarginDrawable(int i) {
        setPageMarginDrawable(getContext().getResources().getDrawable(i));
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.f1306p = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setPageTransformer(boolean z, PageTransformer pageTransformer) {
        int i = 1;
        if (Build.VERSION.SDK_INT >= 11) {
            boolean z2 = pageTransformer != null;
            boolean z3 = z2 != (this.f1288ae != null);
            this.f1288ae = pageTransformer;
            setChildrenDrawingOrderEnabledCompat(z2);
            if (z2) {
                if (z) {
                    i = 2;
                }
                this.f1290ag = i;
            } else {
                this.f1290ag = 0;
            }
            if (z3) {
                mo2437c();
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f1306p;
    }
}
