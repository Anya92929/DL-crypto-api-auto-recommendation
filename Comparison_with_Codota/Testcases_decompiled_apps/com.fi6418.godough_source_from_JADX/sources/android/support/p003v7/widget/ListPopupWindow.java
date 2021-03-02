package android.support.p003v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.support.p000v4.text.TextUtilsCompat;
import android.support.p000v4.view.MotionEventCompat;
import android.support.p000v4.view.ViewPropertyAnimatorCompat;
import android.support.p000v4.widget.ListViewAutoScrollHelper;
import android.support.p000v4.widget.PopupWindowCompat;
import android.support.p003v7.appcompat.C0235R;
import android.support.p003v7.internal.widget.AppCompatPopupWindow;
import android.support.p003v7.internal.widget.ListViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.lang.reflect.Method;

/* renamed from: android.support.v7.widget.ListPopupWindow */
public class ListPopupWindow {
    public static final int INPUT_METHOD_FROM_FOCUSABLE = 0;
    public static final int INPUT_METHOD_NEEDED = 1;
    public static final int INPUT_METHOD_NOT_NEEDED = 2;
    public static final int MATCH_PARENT = -1;
    public static final int POSITION_PROMPT_ABOVE = 0;
    public static final int POSITION_PROMPT_BELOW = 1;
    public static final int WRAP_CONTENT = -2;

    /* renamed from: a */
    private static Method f2824a;
    /* access modifiers changed from: private */

    /* renamed from: A */
    public Handler f2825A;

    /* renamed from: B */
    private Rect f2826B;

    /* renamed from: C */
    private boolean f2827C;

    /* renamed from: D */
    private int f2828D;

    /* renamed from: b */
    int f2829b;

    /* renamed from: c */
    private Context f2830c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public PopupWindow f2831d;

    /* renamed from: e */
    private ListAdapter f2832e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public DropDownListView f2833f;

    /* renamed from: g */
    private int f2834g;

    /* renamed from: h */
    private int f2835h;

    /* renamed from: i */
    private int f2836i;

    /* renamed from: j */
    private int f2837j;

    /* renamed from: k */
    private boolean f2838k;

    /* renamed from: l */
    private int f2839l;

    /* renamed from: m */
    private boolean f2840m;

    /* renamed from: n */
    private boolean f2841n;

    /* renamed from: o */
    private View f2842o;

    /* renamed from: p */
    private int f2843p;

    /* renamed from: q */
    private DataSetObserver f2844q;

    /* renamed from: r */
    private View f2845r;

    /* renamed from: s */
    private Drawable f2846s;

    /* renamed from: t */
    private AdapterView.OnItemClickListener f2847t;

    /* renamed from: u */
    private AdapterView.OnItemSelectedListener f2848u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public final ResizePopupRunnable f2849v;

    /* renamed from: w */
    private final PopupTouchInterceptor f2850w;

    /* renamed from: x */
    private final PopupScrollListener f2851x;

    /* renamed from: y */
    private final ListSelectorHider f2852y;

    /* renamed from: z */
    private Runnable f2853z;

    /* renamed from: android.support.v7.widget.ListPopupWindow$DropDownListView */
    class DropDownListView extends ListViewCompat {
        /* access modifiers changed from: private */

        /* renamed from: f */
        public boolean f2857f;

        /* renamed from: g */
        private boolean f2858g;

        /* renamed from: h */
        private boolean f2859h;

        /* renamed from: i */
        private ViewPropertyAnimatorCompat f2860i;

        /* renamed from: j */
        private ListViewAutoScrollHelper f2861j;

        public DropDownListView(Context context, boolean z) {
            super(context, (AttributeSet) null, C0235R.attr.dropDownListViewStyle);
            this.f2858g = z;
            setCacheColorHint(0);
        }

        /* renamed from: a */
        private void m1926a(View view, int i) {
            performItemClick(view, i, getItemIdAtPosition(i));
        }

        /* renamed from: a */
        private void m1927a(View view, int i, float f, float f2) {
            this.f2859h = true;
            setPressed(true);
            layoutChildren();
            setSelection(i);
            mo4574a(i, view, f, f2);
            setSelectorEnabled(false);
            refreshDrawableState();
        }

        /* renamed from: d */
        private void m1929d() {
            this.f2859h = false;
            setPressed(false);
            drawableStateChanged();
            if (this.f2860i != null) {
                this.f2860i.cancel();
                this.f2860i = null;
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public boolean mo4578c() {
            return this.f2859h || super.mo4578c();
        }

        public boolean hasFocus() {
            return this.f2858g || super.hasFocus();
        }

        public boolean hasWindowFocus() {
            return this.f2858g || super.hasWindowFocus();
        }

        public boolean isFocused() {
            return this.f2858g || super.isFocused();
        }

        public boolean isInTouchMode() {
            return (this.f2858g && this.f2857f) || super.isInTouchMode();
        }

        public boolean onForwardedEvent(MotionEvent motionEvent, int i) {
            boolean z;
            boolean z2;
            boolean z3;
            int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
            switch (actionMasked) {
                case 1:
                    z = false;
                    break;
                case 2:
                    z = true;
                    break;
                case 3:
                    z3 = false;
                    z2 = false;
                    break;
                default:
                    z3 = false;
                    z2 = true;
                    break;
            }
            int findPointerIndex = motionEvent.findPointerIndex(i);
            if (findPointerIndex < 0) {
                z3 = false;
                z2 = false;
            } else {
                int x = (int) motionEvent.getX(findPointerIndex);
                int y = (int) motionEvent.getY(findPointerIndex);
                int pointToPosition = pointToPosition(x, y);
                if (pointToPosition == -1) {
                    z2 = z;
                    z3 = true;
                } else {
                    View childAt = getChildAt(pointToPosition - getFirstVisiblePosition());
                    m1927a(childAt, pointToPosition, (float) x, (float) y);
                    if (actionMasked == 1) {
                        m1926a(childAt, pointToPosition);
                    }
                    z3 = false;
                    z2 = true;
                }
            }
            if (!z2 || z3) {
                m1929d();
            }
            if (z2) {
                if (this.f2861j == null) {
                    this.f2861j = new ListViewAutoScrollHelper(this);
                }
                this.f2861j.setEnabled(true);
                this.f2861j.onTouch(this, motionEvent);
            } else if (this.f2861j != null) {
                this.f2861j.setEnabled(false);
            }
            return z2;
        }
    }

    /* renamed from: android.support.v7.widget.ListPopupWindow$ForwardingListener */
    public abstract class ForwardingListener implements View.OnTouchListener {

        /* renamed from: a */
        private final float f2862a;

        /* renamed from: b */
        private final int f2863b;

        /* renamed from: c */
        private final int f2864c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public final View f2865d;

        /* renamed from: e */
        private Runnable f2866e;

        /* renamed from: f */
        private Runnable f2867f;

        /* renamed from: g */
        private boolean f2868g;

        /* renamed from: h */
        private boolean f2869h;

        /* renamed from: i */
        private int f2870i;

        /* renamed from: j */
        private final int[] f2871j = new int[2];

        /* renamed from: android.support.v7.widget.ListPopupWindow$ForwardingListener$DisallowIntercept */
        class DisallowIntercept implements Runnable {
            private DisallowIntercept() {
            }

            public void run() {
                ForwardingListener.this.f2865d.getParent().requestDisallowInterceptTouchEvent(true);
            }
        }

        /* renamed from: android.support.v7.widget.ListPopupWindow$ForwardingListener$TriggerLongPress */
        class TriggerLongPress implements Runnable {
            private TriggerLongPress() {
            }

            public void run() {
                ForwardingListener.this.m1936b();
            }
        }

        public ForwardingListener(View view) {
            this.f2865d = view;
            this.f2862a = (float) ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            this.f2863b = ViewConfiguration.getTapTimeout();
            this.f2864c = (this.f2863b + ViewConfiguration.getLongPressTimeout()) / 2;
        }

        /* renamed from: a */
        private void m1932a() {
            if (this.f2867f != null) {
                this.f2865d.removeCallbacks(this.f2867f);
            }
            if (this.f2866e != null) {
                this.f2865d.removeCallbacks(this.f2866e);
            }
        }

        /* renamed from: a */
        private boolean m1933a(MotionEvent motionEvent) {
            View view = this.f2865d;
            if (!view.isEnabled()) {
                return false;
            }
            switch (MotionEventCompat.getActionMasked(motionEvent)) {
                case 0:
                    this.f2870i = motionEvent.getPointerId(0);
                    this.f2869h = false;
                    if (this.f2866e == null) {
                        this.f2866e = new DisallowIntercept();
                    }
                    view.postDelayed(this.f2866e, (long) this.f2863b);
                    if (this.f2867f == null) {
                        this.f2867f = new TriggerLongPress();
                    }
                    view.postDelayed(this.f2867f, (long) this.f2864c);
                    return false;
                case 1:
                case 3:
                    m1932a();
                    return false;
                case 2:
                    int findPointerIndex = motionEvent.findPointerIndex(this.f2870i);
                    if (findPointerIndex < 0 || m1934a(view, motionEvent.getX(findPointerIndex), motionEvent.getY(findPointerIndex), this.f2862a)) {
                        return false;
                    }
                    m1932a();
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    return true;
                default:
                    return false;
            }
        }

        /* renamed from: a */
        private static boolean m1934a(View view, float f, float f2, float f3) {
            return f >= (-f3) && f2 >= (-f3) && f < ((float) (view.getRight() - view.getLeft())) + f3 && f2 < ((float) (view.getBottom() - view.getTop())) + f3;
        }

        /* renamed from: a */
        private boolean m1935a(View view, MotionEvent motionEvent) {
            int[] iArr = this.f2871j;
            view.getLocationOnScreen(iArr);
            motionEvent.offsetLocation((float) (-iArr[0]), (float) (-iArr[1]));
            return true;
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public void m1936b() {
            m1932a();
            View view = this.f2865d;
            if (view.isEnabled() && !view.isLongClickable() && onForwardingStarted()) {
                view.getParent().requestDisallowInterceptTouchEvent(true);
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 0);
                view.onTouchEvent(obtain);
                obtain.recycle();
                this.f2868g = true;
                this.f2869h = true;
            }
        }

        /* renamed from: b */
        private boolean m1938b(MotionEvent motionEvent) {
            DropDownListView a;
            boolean z = true;
            View view = this.f2865d;
            ListPopupWindow popup = getPopup();
            if (popup == null || !popup.isShowing() || (a = popup.f2833f) == null || !a.isShown()) {
                return false;
            }
            MotionEvent obtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
            m1939b(view, obtainNoHistory);
            m1935a(a, obtainNoHistory);
            boolean onForwardedEvent = a.onForwardedEvent(obtainNoHistory, this.f2870i);
            obtainNoHistory.recycle();
            int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
            boolean z2 = (actionMasked == 1 || actionMasked == 3) ? false : true;
            if (!onForwardedEvent || !z2) {
                z = false;
            }
            return z;
        }

        /* renamed from: b */
        private boolean m1939b(View view, MotionEvent motionEvent) {
            int[] iArr = this.f2871j;
            view.getLocationOnScreen(iArr);
            motionEvent.offsetLocation((float) iArr[0], (float) iArr[1]);
            return true;
        }

        public abstract ListPopupWindow getPopup();

        /* access modifiers changed from: protected */
        public boolean onForwardingStarted() {
            ListPopupWindow popup = getPopup();
            if (popup == null || popup.isShowing()) {
                return true;
            }
            popup.show();
            return true;
        }

        /* access modifiers changed from: protected */
        public boolean onForwardingStopped() {
            ListPopupWindow popup = getPopup();
            if (popup == null || !popup.isShowing()) {
                return true;
            }
            popup.dismiss();
            return true;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            boolean z;
            boolean z2 = this.f2868g;
            if (z2) {
                z = this.f2869h ? m1938b(motionEvent) : m1938b(motionEvent) || !onForwardingStopped();
            } else {
                boolean z3 = m1933a(motionEvent) && onForwardingStarted();
                if (z3) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 0);
                    this.f2865d.onTouchEvent(obtain);
                    obtain.recycle();
                }
                z = z3;
            }
            this.f2868g = z;
            return z || z2;
        }
    }

    /* renamed from: android.support.v7.widget.ListPopupWindow$ListSelectorHider */
    class ListSelectorHider implements Runnable {
        private ListSelectorHider() {
        }

        public void run() {
            ListPopupWindow.this.clearListSelection();
        }
    }

    /* renamed from: android.support.v7.widget.ListPopupWindow$PopupDataSetObserver */
    class PopupDataSetObserver extends DataSetObserver {
        private PopupDataSetObserver() {
        }

        public void onChanged() {
            if (ListPopupWindow.this.isShowing()) {
                ListPopupWindow.this.show();
            }
        }

        public void onInvalidated() {
            ListPopupWindow.this.dismiss();
        }
    }

    /* renamed from: android.support.v7.widget.ListPopupWindow$PopupScrollListener */
    class PopupScrollListener implements AbsListView.OnScrollListener {
        private PopupScrollListener() {
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1 && !ListPopupWindow.this.isInputMethodNotNeeded() && ListPopupWindow.this.f2831d.getContentView() != null) {
                ListPopupWindow.this.f2825A.removeCallbacks(ListPopupWindow.this.f2849v);
                ListPopupWindow.this.f2849v.run();
            }
        }
    }

    /* renamed from: android.support.v7.widget.ListPopupWindow$PopupTouchInterceptor */
    class PopupTouchInterceptor implements View.OnTouchListener {
        private PopupTouchInterceptor() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && ListPopupWindow.this.f2831d != null && ListPopupWindow.this.f2831d.isShowing() && x >= 0 && x < ListPopupWindow.this.f2831d.getWidth() && y >= 0 && y < ListPopupWindow.this.f2831d.getHeight()) {
                ListPopupWindow.this.f2825A.postDelayed(ListPopupWindow.this.f2849v, 250);
                return false;
            } else if (action != 1) {
                return false;
            } else {
                ListPopupWindow.this.f2825A.removeCallbacks(ListPopupWindow.this.f2849v);
                return false;
            }
        }
    }

    /* renamed from: android.support.v7.widget.ListPopupWindow$ResizePopupRunnable */
    class ResizePopupRunnable implements Runnable {
        private ResizePopupRunnable() {
        }

        public void run() {
            if (ListPopupWindow.this.f2833f != null && ListPopupWindow.this.f2833f.getCount() > ListPopupWindow.this.f2833f.getChildCount() && ListPopupWindow.this.f2833f.getChildCount() <= ListPopupWindow.this.f2829b) {
                ListPopupWindow.this.f2831d.setInputMethodMode(2);
                ListPopupWindow.this.show();
            }
        }
    }

    static {
        Class<PopupWindow> cls = PopupWindow.class;
        try {
            f2824a = cls.getDeclaredMethod("setClipToScreenEnabled", new Class[]{Boolean.TYPE});
        } catch (NoSuchMethodException e) {
            Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
        }
    }

    public ListPopupWindow(Context context) {
        this(context, (AttributeSet) null, C0235R.attr.listPopupWindowStyle);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0235R.attr.listPopupWindowStyle);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int i, int i2) {
        this.f2834g = -2;
        this.f2835h = -2;
        this.f2839l = 0;
        this.f2840m = false;
        this.f2841n = false;
        this.f2829b = Integer.MAX_VALUE;
        this.f2843p = 0;
        this.f2849v = new ResizePopupRunnable();
        this.f2850w = new PopupTouchInterceptor();
        this.f2851x = new PopupScrollListener();
        this.f2852y = new ListSelectorHider();
        this.f2825A = new Handler();
        this.f2826B = new Rect();
        this.f2830c = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0235R.styleable.ListPopupWindow, i, i2);
        this.f2836i = obtainStyledAttributes.getDimensionPixelOffset(C0235R.styleable.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        this.f2837j = obtainStyledAttributes.getDimensionPixelOffset(C0235R.styleable.ListPopupWindow_android_dropDownVerticalOffset, 0);
        if (this.f2837j != 0) {
            this.f2838k = true;
        }
        obtainStyledAttributes.recycle();
        this.f2831d = new AppCompatPopupWindow(context, attributeSet, i);
        this.f2831d.setInputMethodMode(1);
        this.f2828D = TextUtilsCompat.getLayoutDirectionFromLocale(this.f2830c.getResources().getConfiguration().locale);
    }

    /* renamed from: a */
    private void mo5177a() {
        if (this.f2842o != null) {
            ViewParent parent = this.f2842o.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f2842o);
            }
        }
    }

    /* renamed from: a */
    private void m1920a(boolean z) {
        if (f2824a != null) {
            try {
                f2824a.invoke(this.f2831d, new Object[]{Boolean.valueOf(z)});
            } catch (Exception e) {
                Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
        }
    }

    /* renamed from: a */
    private static boolean m1921a(int i) {
        return i == 66 || i == 23;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v23, resolved type: android.support.v7.widget.ListPopupWindow$DropDownListView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v24, resolved type: android.support.v7.widget.ListPopupWindow$DropDownListView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v10, resolved type: android.widget.LinearLayout} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v28, resolved type: android.support.v7.widget.ListPopupWindow$DropDownListView} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int m1922b() {
        /*
            r10 = this;
            r9 = 1073741824(0x40000000, float:2.0)
            r8 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = 1
            r3 = -1
            r2 = 0
            android.support.v7.widget.ListPopupWindow$DropDownListView r0 = r10.f2833f
            if (r0 != 0) goto L_0x0106
            android.content.Context r5 = r10.f2830c
            android.support.v7.widget.ListPopupWindow$2 r0 = new android.support.v7.widget.ListPopupWindow$2
            r0.<init>()
            r10.f2853z = r0
            android.support.v7.widget.ListPopupWindow$DropDownListView r4 = new android.support.v7.widget.ListPopupWindow$DropDownListView
            boolean r0 = r10.f2827C
            if (r0 != 0) goto L_0x00f5
            r0 = r1
        L_0x001b:
            r4.<init>(r5, r0)
            r10.f2833f = r4
            android.graphics.drawable.Drawable r0 = r10.f2846s
            if (r0 == 0) goto L_0x002b
            android.support.v7.widget.ListPopupWindow$DropDownListView r0 = r10.f2833f
            android.graphics.drawable.Drawable r4 = r10.f2846s
            r0.setSelector(r4)
        L_0x002b:
            android.support.v7.widget.ListPopupWindow$DropDownListView r0 = r10.f2833f
            android.widget.ListAdapter r4 = r10.f2832e
            r0.setAdapter(r4)
            android.support.v7.widget.ListPopupWindow$DropDownListView r0 = r10.f2833f
            android.widget.AdapterView$OnItemClickListener r4 = r10.f2847t
            r0.setOnItemClickListener(r4)
            android.support.v7.widget.ListPopupWindow$DropDownListView r0 = r10.f2833f
            r0.setFocusable(r1)
            android.support.v7.widget.ListPopupWindow$DropDownListView r0 = r10.f2833f
            r0.setFocusableInTouchMode(r1)
            android.support.v7.widget.ListPopupWindow$DropDownListView r0 = r10.f2833f
            android.support.v7.widget.ListPopupWindow$3 r4 = new android.support.v7.widget.ListPopupWindow$3
            r4.<init>()
            r0.setOnItemSelectedListener(r4)
            android.support.v7.widget.ListPopupWindow$DropDownListView r0 = r10.f2833f
            android.support.v7.widget.ListPopupWindow$PopupScrollListener r4 = r10.f2851x
            r0.setOnScrollListener(r4)
            android.widget.AdapterView$OnItemSelectedListener r0 = r10.f2848u
            if (r0 == 0) goto L_0x005f
            android.support.v7.widget.ListPopupWindow$DropDownListView r0 = r10.f2833f
            android.widget.AdapterView$OnItemSelectedListener r4 = r10.f2848u
            r0.setOnItemSelectedListener(r4)
        L_0x005f:
            android.support.v7.widget.ListPopupWindow$DropDownListView r0 = r10.f2833f
            android.view.View r6 = r10.f2842o
            if (r6 == 0) goto L_0x017f
            android.widget.LinearLayout r4 = new android.widget.LinearLayout
            r4.<init>(r5)
            r4.setOrientation(r1)
            android.widget.LinearLayout$LayoutParams r1 = new android.widget.LinearLayout$LayoutParams
            r5 = 1065353216(0x3f800000, float:1.0)
            r1.<init>(r3, r2, r5)
            int r5 = r10.f2843p
            switch(r5) {
                case 0: goto L_0x00ff;
                case 1: goto L_0x00f8;
                default: goto L_0x0079;
            }
        L_0x0079:
            java.lang.String r0 = "ListPopupWindow"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r5 = "Invalid hint position "
            java.lang.StringBuilder r1 = r1.append(r5)
            int r5 = r10.f2843p
            java.lang.StringBuilder r1 = r1.append(r5)
            java.lang.String r1 = r1.toString()
            android.util.Log.e(r0, r1)
        L_0x0093:
            int r0 = r10.f2835h
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r8)
            r6.measure(r0, r2)
            android.view.ViewGroup$LayoutParams r0 = r6.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r0 = (android.widget.LinearLayout.LayoutParams) r0
            int r1 = r6.getMeasuredHeight()
            int r5 = r0.topMargin
            int r1 = r1 + r5
            int r0 = r0.bottomMargin
            int r0 = r0 + r1
            r1 = r4
        L_0x00ad:
            android.widget.PopupWindow r4 = r10.f2831d
            r4.setContentView(r1)
            r6 = r0
        L_0x00b3:
            android.widget.PopupWindow r0 = r10.f2831d
            android.graphics.drawable.Drawable r0 = r0.getBackground()
            if (r0 == 0) goto L_0x0124
            android.graphics.Rect r1 = r10.f2826B
            r0.getPadding(r1)
            android.graphics.Rect r0 = r10.f2826B
            int r0 = r0.top
            android.graphics.Rect r1 = r10.f2826B
            int r1 = r1.bottom
            int r0 = r0 + r1
            boolean r1 = r10.f2838k
            if (r1 != 0) goto L_0x0179
            android.graphics.Rect r1 = r10.f2826B
            int r1 = r1.top
            int r1 = -r1
            r10.f2837j = r1
            r7 = r0
        L_0x00d5:
            android.widget.PopupWindow r0 = r10.f2831d
            int r0 = r0.getInputMethodMode()
            r1 = 2
            if (r0 != r1) goto L_0x00de
        L_0x00de:
            android.widget.PopupWindow r0 = r10.f2831d
            android.view.View r1 = r10.getAnchorView()
            int r4 = r10.f2837j
            int r4 = r0.getMaxAvailableHeight(r1, r4)
            boolean r0 = r10.f2840m
            if (r0 != 0) goto L_0x00f2
            int r0 = r10.f2834g
            if (r0 != r3) goto L_0x012b
        L_0x00f2:
            int r0 = r4 + r7
        L_0x00f4:
            return r0
        L_0x00f5:
            r0 = r2
            goto L_0x001b
        L_0x00f8:
            r4.addView(r0, r1)
            r4.addView(r6)
            goto L_0x0093
        L_0x00ff:
            r4.addView(r6)
            r4.addView(r0, r1)
            goto L_0x0093
        L_0x0106:
            android.widget.PopupWindow r0 = r10.f2831d
            android.view.View r0 = r0.getContentView()
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            android.view.View r1 = r10.f2842o
            if (r1 == 0) goto L_0x017c
            android.view.ViewGroup$LayoutParams r0 = r1.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r0 = (android.widget.LinearLayout.LayoutParams) r0
            int r1 = r1.getMeasuredHeight()
            int r4 = r0.topMargin
            int r1 = r1 + r4
            int r0 = r0.bottomMargin
            int r0 = r0 + r1
            r6 = r0
            goto L_0x00b3
        L_0x0124:
            android.graphics.Rect r0 = r10.f2826B
            r0.setEmpty()
            r7 = r2
            goto L_0x00d5
        L_0x012b:
            int r0 = r10.f2835h
            switch(r0) {
                case -2: goto L_0x0143;
                case -1: goto L_0x015e;
                default: goto L_0x0130;
            }
        L_0x0130:
            int r0 = r10.f2835h
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r9)
        L_0x0136:
            android.support.v7.widget.ListPopupWindow$DropDownListView r0 = r10.f2833f
            int r4 = r4 - r6
            r5 = r3
            int r0 = r0.measureHeightOfChildrenCompat(r1, r2, r3, r4, r5)
            if (r0 <= 0) goto L_0x0141
            int r6 = r6 + r7
        L_0x0141:
            int r0 = r0 + r6
            goto L_0x00f4
        L_0x0143:
            android.content.Context r0 = r10.f2830c
            android.content.res.Resources r0 = r0.getResources()
            android.util.DisplayMetrics r0 = r0.getDisplayMetrics()
            int r0 = r0.widthPixels
            android.graphics.Rect r1 = r10.f2826B
            int r1 = r1.left
            android.graphics.Rect r5 = r10.f2826B
            int r5 = r5.right
            int r1 = r1 + r5
            int r0 = r0 - r1
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r8)
            goto L_0x0136
        L_0x015e:
            android.content.Context r0 = r10.f2830c
            android.content.res.Resources r0 = r0.getResources()
            android.util.DisplayMetrics r0 = r0.getDisplayMetrics()
            int r0 = r0.widthPixels
            android.graphics.Rect r1 = r10.f2826B
            int r1 = r1.left
            android.graphics.Rect r5 = r10.f2826B
            int r5 = r5.right
            int r1 = r1 + r5
            int r0 = r0 - r1
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r9)
            goto L_0x0136
        L_0x0179:
            r7 = r0
            goto L_0x00d5
        L_0x017c:
            r6 = r2
            goto L_0x00b3
        L_0x017f:
            r1 = r0
            r0 = r2
            goto L_0x00ad
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p003v7.widget.ListPopupWindow.m1922b():int");
    }

    public void clearListSelection() {
        DropDownListView dropDownListView = this.f2833f;
        if (dropDownListView != null) {
            boolean unused = dropDownListView.f2857f = true;
            dropDownListView.requestLayout();
        }
    }

    public View.OnTouchListener createDragToOpenListener(View view) {
        return new ForwardingListener(view) {
            public ListPopupWindow getPopup() {
                return ListPopupWindow.this;
            }
        };
    }

    public void dismiss() {
        this.f2831d.dismiss();
        mo5177a();
        this.f2831d.setContentView((View) null);
        this.f2833f = null;
        this.f2825A.removeCallbacks(this.f2849v);
    }

    public View getAnchorView() {
        return this.f2845r;
    }

    public int getAnimationStyle() {
        return this.f2831d.getAnimationStyle();
    }

    public Drawable getBackground() {
        return this.f2831d.getBackground();
    }

    public int getHeight() {
        return this.f2834g;
    }

    public int getHorizontalOffset() {
        return this.f2836i;
    }

    public int getInputMethodMode() {
        return this.f2831d.getInputMethodMode();
    }

    public ListView getListView() {
        return this.f2833f;
    }

    public int getPromptPosition() {
        return this.f2843p;
    }

    public Object getSelectedItem() {
        if (!isShowing()) {
            return null;
        }
        return this.f2833f.getSelectedItem();
    }

    public long getSelectedItemId() {
        if (!isShowing()) {
            return Long.MIN_VALUE;
        }
        return this.f2833f.getSelectedItemId();
    }

    public int getSelectedItemPosition() {
        if (!isShowing()) {
            return -1;
        }
        return this.f2833f.getSelectedItemPosition();
    }

    public View getSelectedView() {
        if (!isShowing()) {
            return null;
        }
        return this.f2833f.getSelectedView();
    }

    public int getSoftInputMode() {
        return this.f2831d.getSoftInputMode();
    }

    public int getVerticalOffset() {
        if (!this.f2838k) {
            return 0;
        }
        return this.f2837j;
    }

    public int getWidth() {
        return this.f2835h;
    }

    public boolean isDropDownAlwaysVisible() {
        return this.f2840m;
    }

    public boolean isInputMethodNotNeeded() {
        return this.f2831d.getInputMethodMode() == 2;
    }

    public boolean isModal() {
        return this.f2827C;
    }

    public boolean isShowing() {
        return this.f2831d.isShowing();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (isShowing() && i != 62 && (this.f2833f.getSelectedItemPosition() >= 0 || !m1921a(i))) {
            int selectedItemPosition = this.f2833f.getSelectedItemPosition();
            boolean z = !this.f2831d.isAboveAnchor();
            ListAdapter listAdapter = this.f2832e;
            int i2 = Integer.MAX_VALUE;
            int i3 = Integer.MIN_VALUE;
            if (listAdapter != null) {
                boolean areAllItemsEnabled = listAdapter.areAllItemsEnabled();
                i2 = areAllItemsEnabled ? 0 : this.f2833f.lookForSelectablePosition(0, true);
                i3 = areAllItemsEnabled ? listAdapter.getCount() - 1 : this.f2833f.lookForSelectablePosition(listAdapter.getCount() - 1, false);
            }
            if ((!z || i != 19 || selectedItemPosition > i2) && (z || i != 20 || selectedItemPosition < i3)) {
                boolean unused = this.f2833f.f2857f = false;
                if (this.f2833f.onKeyDown(i, keyEvent)) {
                    this.f2831d.setInputMethodMode(2);
                    this.f2833f.requestFocusFromTouch();
                    show();
                    switch (i) {
                        case 19:
                        case 20:
                        case 23:
                        case 66:
                            return true;
                    }
                } else if (!z || i != 20) {
                    if (!z && i == 19 && selectedItemPosition == i2) {
                        return true;
                    }
                } else if (selectedItemPosition == i3) {
                    return true;
                }
            } else {
                clearListSelection();
                this.f2831d.setInputMethodMode(1);
                show();
                return true;
            }
        }
        return false;
    }

    public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        if (i == 4 && isShowing()) {
            View view = this.f2845r;
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                KeyEvent.DispatcherState keyDispatcherState = view.getKeyDispatcherState();
                if (keyDispatcherState == null) {
                    return true;
                }
                keyDispatcherState.startTracking(keyEvent, this);
                return true;
            } else if (keyEvent.getAction() == 1) {
                KeyEvent.DispatcherState keyDispatcherState2 = view.getKeyDispatcherState();
                if (keyDispatcherState2 != null) {
                    keyDispatcherState2.handleUpEvent(keyEvent);
                }
                if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                    dismiss();
                    return true;
                }
            }
        }
        return false;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (!isShowing() || this.f2833f.getSelectedItemPosition() < 0) {
            return false;
        }
        boolean onKeyUp = this.f2833f.onKeyUp(i, keyEvent);
        if (!onKeyUp || !m1921a(i)) {
            return onKeyUp;
        }
        dismiss();
        return onKeyUp;
    }

    public boolean performItemClick(int i) {
        if (!isShowing()) {
            return false;
        }
        if (this.f2847t != null) {
            DropDownListView dropDownListView = this.f2833f;
            View childAt = dropDownListView.getChildAt(i - dropDownListView.getFirstVisiblePosition());
            ListAdapter adapter = dropDownListView.getAdapter();
            this.f2847t.onItemClick(dropDownListView, childAt, i, adapter.getItemId(i));
        }
        return true;
    }

    public void postShow() {
        this.f2825A.post(this.f2853z);
    }

    public void setAdapter(ListAdapter listAdapter) {
        if (this.f2844q == null) {
            this.f2844q = new PopupDataSetObserver();
        } else if (this.f2832e != null) {
            this.f2832e.unregisterDataSetObserver(this.f2844q);
        }
        this.f2832e = listAdapter;
        if (this.f2832e != null) {
            listAdapter.registerDataSetObserver(this.f2844q);
        }
        if (this.f2833f != null) {
            this.f2833f.setAdapter(this.f2832e);
        }
    }

    public void setAnchorView(View view) {
        this.f2845r = view;
    }

    public void setAnimationStyle(int i) {
        this.f2831d.setAnimationStyle(i);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        this.f2831d.setBackgroundDrawable(drawable);
    }

    public void setContentWidth(int i) {
        Drawable background = this.f2831d.getBackground();
        if (background != null) {
            background.getPadding(this.f2826B);
            this.f2835h = this.f2826B.left + this.f2826B.right + i;
            return;
        }
        setWidth(i);
    }

    public void setDropDownAlwaysVisible(boolean z) {
        this.f2840m = z;
    }

    public void setDropDownGravity(int i) {
        this.f2839l = i;
    }

    public void setForceIgnoreOutsideTouch(boolean z) {
        this.f2841n = z;
    }

    public void setHeight(int i) {
        this.f2834g = i;
    }

    public void setHorizontalOffset(int i) {
        this.f2836i = i;
    }

    public void setInputMethodMode(int i) {
        this.f2831d.setInputMethodMode(i);
    }

    public void setListSelector(Drawable drawable) {
        this.f2846s = drawable;
    }

    public void setModal(boolean z) {
        this.f2827C = z;
        this.f2831d.setFocusable(z);
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.f2831d.setOnDismissListener(onDismissListener);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.f2847t = onItemClickListener;
    }

    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.f2848u = onItemSelectedListener;
    }

    public void setPromptPosition(int i) {
        this.f2843p = i;
    }

    public void setPromptView(View view) {
        boolean isShowing = isShowing();
        if (isShowing) {
            mo5177a();
        }
        this.f2842o = view;
        if (isShowing) {
            show();
        }
    }

    public void setSelection(int i) {
        DropDownListView dropDownListView = this.f2833f;
        if (isShowing() && dropDownListView != null) {
            boolean unused = dropDownListView.f2857f = false;
            dropDownListView.setSelection(i);
            if (Build.VERSION.SDK_INT >= 11 && dropDownListView.getChoiceMode() != 0) {
                dropDownListView.setItemChecked(i, true);
            }
        }
    }

    public void setSoftInputMode(int i) {
        this.f2831d.setSoftInputMode(i);
    }

    public void setVerticalOffset(int i) {
        this.f2837j = i;
        this.f2838k = true;
    }

    public void setWidth(int i) {
        this.f2835h = i;
    }

    public void show() {
        int i;
        int i2;
        boolean z = true;
        boolean z2 = false;
        int i3 = -1;
        int b = m1922b();
        boolean isInputMethodNotNeeded = isInputMethodNotNeeded();
        if (this.f2831d.isShowing()) {
            int width = this.f2835h == -1 ? -1 : this.f2835h == -2 ? getAnchorView().getWidth() : this.f2835h;
            if (this.f2834g == -1) {
                if (!isInputMethodNotNeeded) {
                    b = -1;
                }
                if (isInputMethodNotNeeded) {
                    PopupWindow popupWindow = this.f2831d;
                    if (this.f2835h != -1) {
                        i3 = 0;
                    }
                    popupWindow.setWindowLayoutMode(i3, 0);
                } else {
                    this.f2831d.setWindowLayoutMode(this.f2835h == -1 ? -1 : 0, -1);
                }
            } else if (this.f2834g != -2) {
                b = this.f2834g;
            }
            PopupWindow popupWindow2 = this.f2831d;
            if (!this.f2841n && !this.f2840m) {
                z2 = true;
            }
            popupWindow2.setOutsideTouchable(z2);
            this.f2831d.update(getAnchorView(), this.f2836i, this.f2837j, width, b);
            return;
        }
        if (this.f2835h == -1) {
            i = -1;
        } else if (this.f2835h == -2) {
            this.f2831d.setWidth(getAnchorView().getWidth());
            i = 0;
        } else {
            this.f2831d.setWidth(this.f2835h);
            i = 0;
        }
        if (this.f2834g == -1) {
            i2 = -1;
        } else if (this.f2834g == -2) {
            this.f2831d.setHeight(b);
            i2 = 0;
        } else {
            this.f2831d.setHeight(this.f2834g);
            i2 = 0;
        }
        this.f2831d.setWindowLayoutMode(i, i2);
        m1920a(true);
        PopupWindow popupWindow3 = this.f2831d;
        if (this.f2841n || this.f2840m) {
            z = false;
        }
        popupWindow3.setOutsideTouchable(z);
        this.f2831d.setTouchInterceptor(this.f2850w);
        PopupWindowCompat.showAsDropDown(this.f2831d, getAnchorView(), this.f2836i, this.f2837j, this.f2839l);
        this.f2833f.setSelection(-1);
        if (!this.f2827C || this.f2833f.isInTouchMode()) {
            clearListSelection();
        }
        if (!this.f2827C) {
            this.f2825A.post(this.f2852y);
        }
    }
}
