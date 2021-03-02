package android.support.p004v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.support.p001v4.text.TextUtilsCompat;
import android.support.p001v4.view.MotionEventCompat;
import android.support.p001v4.view.ViewCompat;
import android.support.p001v4.view.ViewPropertyAnimatorCompat;
import android.support.p001v4.widget.ExploreByTouchHelper;
import android.support.p001v4.widget.ListViewAutoScrollHelper;
import android.support.p001v4.widget.PopupWindowCompat;
import android.support.p004v7.appcompat.C0505R;
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
    private static Method f2091a;

    /* renamed from: c */
    private static Method f2092c;

    /* renamed from: A */
    private final C0559b f2093A;

    /* renamed from: B */
    private Runnable f2094B;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public final Handler f2095C;

    /* renamed from: D */
    private Rect f2096D;

    /* renamed from: E */
    private boolean f2097E;

    /* renamed from: F */
    private int f2098F;

    /* renamed from: b */
    int f2099b;

    /* renamed from: d */
    private Context f2100d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public PopupWindow f2101e;

    /* renamed from: f */
    private ListAdapter f2102f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public C0558a f2103g;

    /* renamed from: h */
    private int f2104h;

    /* renamed from: i */
    private int f2105i;

    /* renamed from: j */
    private int f2106j;

    /* renamed from: k */
    private int f2107k;

    /* renamed from: l */
    private int f2108l;

    /* renamed from: m */
    private boolean f2109m;

    /* renamed from: n */
    private int f2110n;

    /* renamed from: o */
    private boolean f2111o;

    /* renamed from: p */
    private boolean f2112p;

    /* renamed from: q */
    private View f2113q;

    /* renamed from: r */
    private int f2114r;

    /* renamed from: s */
    private DataSetObserver f2115s;

    /* renamed from: t */
    private View f2116t;

    /* renamed from: u */
    private Drawable f2117u;

    /* renamed from: v */
    private AdapterView.OnItemClickListener f2118v;

    /* renamed from: w */
    private AdapterView.OnItemSelectedListener f2119w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public final C0563f f2120x;

    /* renamed from: y */
    private final C0562e f2121y;

    /* renamed from: z */
    private final C0561d f2122z;

    static {
        Class<PopupWindow> cls = PopupWindow.class;
        try {
            f2091a = cls.getDeclaredMethod("setClipToScreenEnabled", new Class[]{Boolean.TYPE});
        } catch (NoSuchMethodException e) {
            Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
        }
        Class<PopupWindow> cls2 = PopupWindow.class;
        try {
            f2092c = cls2.getDeclaredMethod("getMaxAvailableHeight", new Class[]{View.class, Integer.TYPE, Boolean.TYPE});
        } catch (NoSuchMethodException e2) {
            Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
        }
    }

    public ListPopupWindow(Context context) {
        this(context, (AttributeSet) null, C0505R.attr.listPopupWindowStyle);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0505R.attr.listPopupWindowStyle);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int i, int i2) {
        this.f2104h = -2;
        this.f2105i = -2;
        this.f2108l = 1002;
        this.f2110n = 0;
        this.f2111o = false;
        this.f2112p = false;
        this.f2099b = Integer.MAX_VALUE;
        this.f2114r = 0;
        this.f2120x = new C0563f();
        this.f2121y = new C0562e();
        this.f2122z = new C0561d();
        this.f2093A = new C0559b();
        this.f2096D = new Rect();
        this.f2100d = context;
        this.f2095C = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0505R.styleable.ListPopupWindow, i, i2);
        this.f2106j = obtainStyledAttributes.getDimensionPixelOffset(C0505R.styleable.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        this.f2107k = obtainStyledAttributes.getDimensionPixelOffset(C0505R.styleable.ListPopupWindow_android_dropDownVerticalOffset, 0);
        if (this.f2107k != 0) {
            this.f2109m = true;
        }
        obtainStyledAttributes.recycle();
        this.f2101e = new AppCompatPopupWindow(context, attributeSet, i);
        this.f2101e.setInputMethodMode(1);
        this.f2098F = TextUtilsCompat.getLayoutDirectionFromLocale(this.f2100d.getResources().getConfiguration().locale);
    }

    public void setAdapter(ListAdapter listAdapter) {
        if (this.f2115s == null) {
            this.f2115s = new C0560c();
        } else if (this.f2102f != null) {
            this.f2102f.unregisterDataSetObserver(this.f2115s);
        }
        this.f2102f = listAdapter;
        if (this.f2102f != null) {
            listAdapter.registerDataSetObserver(this.f2115s);
        }
        if (this.f2103g != null) {
            this.f2103g.setAdapter(this.f2102f);
        }
    }

    public void setPromptPosition(int i) {
        this.f2114r = i;
    }

    public int getPromptPosition() {
        return this.f2114r;
    }

    public void setModal(boolean z) {
        this.f2097E = z;
        this.f2101e.setFocusable(z);
    }

    public boolean isModal() {
        return this.f2097E;
    }

    public void setForceIgnoreOutsideTouch(boolean z) {
        this.f2112p = z;
    }

    public void setDropDownAlwaysVisible(boolean z) {
        this.f2111o = z;
    }

    public boolean isDropDownAlwaysVisible() {
        return this.f2111o;
    }

    public void setSoftInputMode(int i) {
        this.f2101e.setSoftInputMode(i);
    }

    public int getSoftInputMode() {
        return this.f2101e.getSoftInputMode();
    }

    public void setListSelector(Drawable drawable) {
        this.f2117u = drawable;
    }

    public Drawable getBackground() {
        return this.f2101e.getBackground();
    }

    public void setBackgroundDrawable(Drawable drawable) {
        this.f2101e.setBackgroundDrawable(drawable);
    }

    public void setAnimationStyle(int i) {
        this.f2101e.setAnimationStyle(i);
    }

    public int getAnimationStyle() {
        return this.f2101e.getAnimationStyle();
    }

    public View getAnchorView() {
        return this.f2116t;
    }

    public void setAnchorView(View view) {
        this.f2116t = view;
    }

    public int getHorizontalOffset() {
        return this.f2106j;
    }

    public void setHorizontalOffset(int i) {
        this.f2106j = i;
    }

    public int getVerticalOffset() {
        if (!this.f2109m) {
            return 0;
        }
        return this.f2107k;
    }

    public void setVerticalOffset(int i) {
        this.f2107k = i;
        this.f2109m = true;
    }

    public void setDropDownGravity(int i) {
        this.f2110n = i;
    }

    public int getWidth() {
        return this.f2105i;
    }

    public void setWidth(int i) {
        this.f2105i = i;
    }

    public void setContentWidth(int i) {
        Drawable background = this.f2101e.getBackground();
        if (background != null) {
            background.getPadding(this.f2096D);
            this.f2105i = this.f2096D.left + this.f2096D.right + i;
            return;
        }
        setWidth(i);
    }

    public int getHeight() {
        return this.f2104h;
    }

    public void setHeight(int i) {
        this.f2104h = i;
    }

    public void setWindowLayoutType(int i) {
        this.f2108l = i;
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.f2118v = onItemClickListener;
    }

    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.f2119w = onItemSelectedListener;
    }

    public void setPromptView(View view) {
        boolean isShowing = isShowing();
        if (isShowing) {
            mo4170a();
        }
        this.f2113q = view;
        if (isShowing) {
            show();
        }
    }

    public void postShow() {
        this.f2095C.post(this.f2094B);
    }

    public void show() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        boolean z = true;
        boolean z2 = false;
        int i6 = -1;
        int b = mo4172b();
        boolean isInputMethodNotNeeded = isInputMethodNotNeeded();
        PopupWindowCompat.setWindowLayoutType(this.f2101e, this.f2108l);
        if (this.f2101e.isShowing()) {
            if (this.f2105i == -1) {
                i2 = -1;
            } else if (this.f2105i == -2) {
                i2 = getAnchorView().getWidth();
            } else {
                i2 = this.f2105i;
            }
            if (this.f2104h == -1) {
                if (!isInputMethodNotNeeded) {
                    b = -1;
                }
                if (isInputMethodNotNeeded) {
                    PopupWindow popupWindow = this.f2101e;
                    if (this.f2105i == -1) {
                        i5 = -1;
                    } else {
                        i5 = 0;
                    }
                    popupWindow.setWidth(i5);
                    this.f2101e.setHeight(0);
                    i3 = b;
                } else {
                    PopupWindow popupWindow2 = this.f2101e;
                    if (this.f2105i == -1) {
                        i4 = -1;
                    } else {
                        i4 = 0;
                    }
                    popupWindow2.setWidth(i4);
                    this.f2101e.setHeight(-1);
                    i3 = b;
                }
            } else if (this.f2104h == -2) {
                i3 = b;
            } else {
                i3 = this.f2104h;
            }
            PopupWindow popupWindow3 = this.f2101e;
            if (!this.f2112p && !this.f2111o) {
                z2 = true;
            }
            popupWindow3.setOutsideTouchable(z2);
            PopupWindow popupWindow4 = this.f2101e;
            View anchorView = getAnchorView();
            int i7 = this.f2106j;
            int i8 = this.f2107k;
            if (i2 < 0) {
                i2 = -1;
            }
            if (i3 >= 0) {
                i6 = i3;
            }
            popupWindow4.update(anchorView, i7, i8, i2, i6);
            return;
        }
        if (this.f2105i == -1) {
            i = -1;
        } else if (this.f2105i == -2) {
            i = getAnchorView().getWidth();
        } else {
            i = this.f2105i;
        }
        if (this.f2104h == -1) {
            b = -1;
        } else if (this.f2104h != -2) {
            b = this.f2104h;
        }
        this.f2101e.setWidth(i);
        this.f2101e.setHeight(b);
        m3221a(true);
        PopupWindow popupWindow5 = this.f2101e;
        if (this.f2112p || this.f2111o) {
            z = false;
        }
        popupWindow5.setOutsideTouchable(z);
        this.f2101e.setTouchInterceptor(this.f2121y);
        PopupWindowCompat.showAsDropDown(this.f2101e, getAnchorView(), this.f2106j, this.f2107k, this.f2110n);
        this.f2103g.setSelection(-1);
        if (!this.f2097E || this.f2103g.isInTouchMode()) {
            clearListSelection();
        }
        if (!this.f2097E) {
            this.f2095C.post(this.f2093A);
        }
    }

    public void dismiss() {
        this.f2101e.dismiss();
        mo4170a();
        this.f2101e.setContentView((View) null);
        this.f2103g = null;
        this.f2095C.removeCallbacks(this.f2120x);
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.f2101e.setOnDismissListener(onDismissListener);
    }

    /* renamed from: a */
    private void mo4170a() {
        if (this.f2113q != null) {
            ViewParent parent = this.f2113q.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f2113q);
            }
        }
    }

    public void setInputMethodMode(int i) {
        this.f2101e.setInputMethodMode(i);
    }

    public int getInputMethodMode() {
        return this.f2101e.getInputMethodMode();
    }

    public void setSelection(int i) {
        C0558a aVar = this.f2103g;
        if (isShowing() && aVar != null) {
            boolean unused = aVar.f2138f = false;
            aVar.setSelection(i);
            if (Build.VERSION.SDK_INT >= 11 && aVar.getChoiceMode() != 0) {
                aVar.setItemChecked(i, true);
            }
        }
    }

    public void clearListSelection() {
        C0558a aVar = this.f2103g;
        if (aVar != null) {
            boolean unused = aVar.f2138f = true;
            aVar.requestLayout();
        }
    }

    public boolean isShowing() {
        return this.f2101e.isShowing();
    }

    public boolean isInputMethodNotNeeded() {
        return this.f2101e.getInputMethodMode() == 2;
    }

    public boolean performItemClick(int i) {
        if (!isShowing()) {
            return false;
        }
        if (this.f2118v != null) {
            C0558a aVar = this.f2103g;
            View childAt = aVar.getChildAt(i - aVar.getFirstVisiblePosition());
            ListAdapter adapter = aVar.getAdapter();
            this.f2118v.onItemClick(aVar, childAt, i, adapter.getItemId(i));
        }
        return true;
    }

    public Object getSelectedItem() {
        if (!isShowing()) {
            return null;
        }
        return this.f2103g.getSelectedItem();
    }

    public int getSelectedItemPosition() {
        if (!isShowing()) {
            return -1;
        }
        return this.f2103g.getSelectedItemPosition();
    }

    public long getSelectedItemId() {
        if (!isShowing()) {
            return Long.MIN_VALUE;
        }
        return this.f2103g.getSelectedItemId();
    }

    public View getSelectedView() {
        if (!isShowing()) {
            return null;
        }
        return this.f2103g.getSelectedView();
    }

    public ListView getListView() {
        return this.f2103g;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (isShowing() && i != 62 && (this.f2103g.getSelectedItemPosition() >= 0 || !m3222a(i))) {
            int selectedItemPosition = this.f2103g.getSelectedItemPosition();
            boolean z = !this.f2101e.isAboveAnchor();
            ListAdapter listAdapter = this.f2102f;
            int i2 = Integer.MAX_VALUE;
            int i3 = ExploreByTouchHelper.INVALID_ID;
            if (listAdapter != null) {
                boolean areAllItemsEnabled = listAdapter.areAllItemsEnabled();
                i2 = areAllItemsEnabled ? 0 : this.f2103g.lookForSelectablePosition(0, true);
                if (areAllItemsEnabled) {
                    i3 = listAdapter.getCount() - 1;
                } else {
                    i3 = this.f2103g.lookForSelectablePosition(listAdapter.getCount() - 1, false);
                }
            }
            if ((!z || i != 19 || selectedItemPosition > i2) && (z || i != 20 || selectedItemPosition < i3)) {
                boolean unused = this.f2103g.f2138f = false;
                if (this.f2103g.onKeyDown(i, keyEvent)) {
                    this.f2101e.setInputMethodMode(2);
                    this.f2103g.requestFocusFromTouch();
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
                this.f2101e.setInputMethodMode(1);
                show();
                return true;
            }
        }
        return false;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (!isShowing() || this.f2103g.getSelectedItemPosition() < 0) {
            return false;
        }
        boolean onKeyUp = this.f2103g.onKeyUp(i, keyEvent);
        if (!onKeyUp || !m3222a(i)) {
            return onKeyUp;
        }
        dismiss();
        return onKeyUp;
    }

    public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        if (i == 4 && isShowing()) {
            View view = this.f2116t;
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

    public View.OnTouchListener createDragToOpenListener(View view) {
        return new ForwardingListener(view) {
            public ListPopupWindow getPopup() {
                return ListPopupWindow.this;
            }
        };
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v15, resolved type: android.support.v7.widget.ListPopupWindow$a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v16, resolved type: android.support.v7.widget.ListPopupWindow$a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v13, resolved type: android.widget.LinearLayout} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v22, resolved type: android.support.v7.widget.ListPopupWindow$a} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int mo4172b() {
        /*
            r10 = this;
            r9 = 1073741824(0x40000000, float:2.0)
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = -1
            r1 = 1
            r2 = 0
            android.support.v7.widget.ListPopupWindow$a r0 = r10.f2103g
            if (r0 != 0) goto L_0x010d
            android.content.Context r5 = r10.f2100d
            android.support.v7.widget.ListPopupWindow$2 r0 = new android.support.v7.widget.ListPopupWindow$2
            r0.<init>()
            r10.f2094B = r0
            android.support.v7.widget.ListPopupWindow$a r6 = new android.support.v7.widget.ListPopupWindow$a
            boolean r0 = r10.f2097E
            if (r0 != 0) goto L_0x00f9
            r0 = r1
        L_0x001b:
            r6.<init>(r5, r0)
            r10.f2103g = r6
            android.graphics.drawable.Drawable r0 = r10.f2117u
            if (r0 == 0) goto L_0x002b
            android.support.v7.widget.ListPopupWindow$a r0 = r10.f2103g
            android.graphics.drawable.Drawable r6 = r10.f2117u
            r0.setSelector(r6)
        L_0x002b:
            android.support.v7.widget.ListPopupWindow$a r0 = r10.f2103g
            android.widget.ListAdapter r6 = r10.f2102f
            r0.setAdapter(r6)
            android.support.v7.widget.ListPopupWindow$a r0 = r10.f2103g
            android.widget.AdapterView$OnItemClickListener r6 = r10.f2118v
            r0.setOnItemClickListener(r6)
            android.support.v7.widget.ListPopupWindow$a r0 = r10.f2103g
            r0.setFocusable(r1)
            android.support.v7.widget.ListPopupWindow$a r0 = r10.f2103g
            r0.setFocusableInTouchMode(r1)
            android.support.v7.widget.ListPopupWindow$a r0 = r10.f2103g
            android.support.v7.widget.ListPopupWindow$3 r6 = new android.support.v7.widget.ListPopupWindow$3
            r6.<init>()
            r0.setOnItemSelectedListener(r6)
            android.support.v7.widget.ListPopupWindow$a r0 = r10.f2103g
            android.support.v7.widget.ListPopupWindow$d r6 = r10.f2122z
            r0.setOnScrollListener(r6)
            android.widget.AdapterView$OnItemSelectedListener r0 = r10.f2119w
            if (r0 == 0) goto L_0x005f
            android.support.v7.widget.ListPopupWindow$a r0 = r10.f2103g
            android.widget.AdapterView$OnItemSelectedListener r6 = r10.f2119w
            r0.setOnItemSelectedListener(r6)
        L_0x005f:
            android.support.v7.widget.ListPopupWindow$a r0 = r10.f2103g
            android.view.View r7 = r10.f2113q
            if (r7 == 0) goto L_0x0189
            android.widget.LinearLayout r6 = new android.widget.LinearLayout
            r6.<init>(r5)
            r6.setOrientation(r1)
            android.widget.LinearLayout$LayoutParams r5 = new android.widget.LinearLayout$LayoutParams
            r8 = 1065353216(0x3f800000, float:1.0)
            r5.<init>(r3, r2, r8)
            int r8 = r10.f2114r
            switch(r8) {
                case 0: goto L_0x0103;
                case 1: goto L_0x00fc;
                default: goto L_0x0079;
            }
        L_0x0079:
            java.lang.String r0 = "ListPopupWindow"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r8 = "Invalid hint position "
            java.lang.StringBuilder r5 = r5.append(r8)
            int r8 = r10.f2114r
            java.lang.StringBuilder r5 = r5.append(r8)
            java.lang.String r5 = r5.toString()
            android.util.Log.e(r0, r5)
        L_0x0093:
            int r0 = r10.f2105i
            if (r0 < 0) goto L_0x010a
            int r0 = r10.f2105i
            r5 = r0
            r0 = r4
        L_0x009b:
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r0)
            r7.measure(r0, r2)
            android.view.ViewGroup$LayoutParams r0 = r7.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r0 = (android.widget.LinearLayout.LayoutParams) r0
            int r5 = r7.getMeasuredHeight()
            int r7 = r0.topMargin
            int r5 = r5 + r7
            int r0 = r0.bottomMargin
            int r0 = r0 + r5
            r5 = r6
        L_0x00b3:
            android.widget.PopupWindow r6 = r10.f2101e
            r6.setContentView(r5)
            r6 = r0
        L_0x00b9:
            android.widget.PopupWindow r0 = r10.f2101e
            android.graphics.drawable.Drawable r0 = r0.getBackground()
            if (r0 == 0) goto L_0x012b
            android.graphics.Rect r5 = r10.f2096D
            r0.getPadding(r5)
            android.graphics.Rect r0 = r10.f2096D
            int r0 = r0.top
            android.graphics.Rect r5 = r10.f2096D
            int r5 = r5.bottom
            int r0 = r0 + r5
            boolean r5 = r10.f2109m
            if (r5 != 0) goto L_0x0183
            android.graphics.Rect r5 = r10.f2096D
            int r5 = r5.top
            int r5 = -r5
            r10.f2107k = r5
            r7 = r0
        L_0x00db:
            android.widget.PopupWindow r0 = r10.f2101e
            int r0 = r0.getInputMethodMode()
            r5 = 2
            if (r0 != r5) goto L_0x0132
        L_0x00e4:
            android.view.View r0 = r10.getAnchorView()
            int r5 = r10.f2107k
            int r5 = r10.m3218a(r0, r5, r1)
            boolean r0 = r10.f2111o
            if (r0 != 0) goto L_0x00f6
            int r0 = r10.f2104h
            if (r0 != r3) goto L_0x0134
        L_0x00f6:
            int r0 = r5 + r7
        L_0x00f8:
            return r0
        L_0x00f9:
            r0 = r2
            goto L_0x001b
        L_0x00fc:
            r6.addView(r0, r5)
            r6.addView(r7)
            goto L_0x0093
        L_0x0103:
            r6.addView(r7)
            r6.addView(r0, r5)
            goto L_0x0093
        L_0x010a:
            r0 = r2
            r5 = r2
            goto L_0x009b
        L_0x010d:
            android.widget.PopupWindow r0 = r10.f2101e
            android.view.View r0 = r0.getContentView()
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            android.view.View r5 = r10.f2113q
            if (r5 == 0) goto L_0x0186
            android.view.ViewGroup$LayoutParams r0 = r5.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r0 = (android.widget.LinearLayout.LayoutParams) r0
            int r5 = r5.getMeasuredHeight()
            int r6 = r0.topMargin
            int r5 = r5 + r6
            int r0 = r0.bottomMargin
            int r0 = r0 + r5
            r6 = r0
            goto L_0x00b9
        L_0x012b:
            android.graphics.Rect r0 = r10.f2096D
            r0.setEmpty()
            r7 = r2
            goto L_0x00db
        L_0x0132:
            r1 = r2
            goto L_0x00e4
        L_0x0134:
            int r0 = r10.f2105i
            switch(r0) {
                case -2: goto L_0x014d;
                case -1: goto L_0x0168;
                default: goto L_0x0139;
            }
        L_0x0139:
            int r0 = r10.f2105i
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r9)
        L_0x013f:
            android.support.v7.widget.ListPopupWindow$a r0 = r10.f2103g
            int r4 = r5 - r6
            r5 = r3
            int r0 = r0.measureHeightOfChildrenCompat(r1, r2, r3, r4, r5)
            if (r0 <= 0) goto L_0x014b
            int r6 = r6 + r7
        L_0x014b:
            int r0 = r0 + r6
            goto L_0x00f8
        L_0x014d:
            android.content.Context r0 = r10.f2100d
            android.content.res.Resources r0 = r0.getResources()
            android.util.DisplayMetrics r0 = r0.getDisplayMetrics()
            int r0 = r0.widthPixels
            android.graphics.Rect r1 = r10.f2096D
            int r1 = r1.left
            android.graphics.Rect r8 = r10.f2096D
            int r8 = r8.right
            int r1 = r1 + r8
            int r0 = r0 - r1
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r4)
            goto L_0x013f
        L_0x0168:
            android.content.Context r0 = r10.f2100d
            android.content.res.Resources r0 = r0.getResources()
            android.util.DisplayMetrics r0 = r0.getDisplayMetrics()
            int r0 = r0.widthPixels
            android.graphics.Rect r1 = r10.f2096D
            int r1 = r1.left
            android.graphics.Rect r4 = r10.f2096D
            int r4 = r4.right
            int r1 = r1 + r4
            int r0 = r0 - r1
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r9)
            goto L_0x013f
        L_0x0183:
            r7 = r0
            goto L_0x00db
        L_0x0186:
            r6 = r2
            goto L_0x00b9
        L_0x0189:
            r5 = r0
            r0 = r2
            goto L_0x00b3
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p004v7.widget.ListPopupWindow.mo4172b():int");
    }

    /* renamed from: android.support.v7.widget.ListPopupWindow$ForwardingListener */
    public static abstract class ForwardingListener implements View.OnTouchListener {

        /* renamed from: a */
        private final float f2126a;

        /* renamed from: b */
        private final int f2127b;

        /* renamed from: c */
        private final int f2128c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public final View f2129d;

        /* renamed from: e */
        private Runnable f2130e;

        /* renamed from: f */
        private Runnable f2131f;

        /* renamed from: g */
        private boolean f2132g;

        /* renamed from: h */
        private boolean f2133h;

        /* renamed from: i */
        private int f2134i;

        /* renamed from: j */
        private final int[] f2135j = new int[2];

        public abstract ListPopupWindow getPopup();

        public ForwardingListener(View view) {
            this.f2129d = view;
            this.f2126a = (float) ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            this.f2127b = ViewConfiguration.getTapTimeout();
            this.f2128c = (this.f2127b + ViewConfiguration.getLongPressTimeout()) / 2;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            boolean z;
            boolean z2 = this.f2132g;
            if (!z2) {
                boolean z3 = m3229a(motionEvent) && onForwardingStarted();
                if (z3) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 0);
                    this.f2129d.onTouchEvent(obtain);
                    obtain.recycle();
                }
                z = z3;
            } else if (this.f2133h) {
                z = m3234b(motionEvent);
            } else {
                z = m3234b(motionEvent) || !onForwardingStopped();
            }
            this.f2132g = z;
            if (z || z2) {
                return true;
            }
            return false;
        }

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

        /* renamed from: a */
        private boolean m3229a(MotionEvent motionEvent) {
            View view = this.f2129d;
            if (!view.isEnabled()) {
                return false;
            }
            switch (MotionEventCompat.getActionMasked(motionEvent)) {
                case 0:
                    this.f2134i = motionEvent.getPointerId(0);
                    this.f2133h = false;
                    if (this.f2130e == null) {
                        this.f2130e = new C0556a();
                    }
                    view.postDelayed(this.f2130e, (long) this.f2127b);
                    if (this.f2131f == null) {
                        this.f2131f = new C0557b();
                    }
                    view.postDelayed(this.f2131f, (long) this.f2128c);
                    return false;
                case 1:
                case 3:
                    m3228a();
                    return false;
                case 2:
                    int findPointerIndex = motionEvent.findPointerIndex(this.f2134i);
                    if (findPointerIndex < 0 || m3230a(view, motionEvent.getX(findPointerIndex), motionEvent.getY(findPointerIndex), this.f2126a)) {
                        return false;
                    }
                    m3228a();
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    return true;
                default:
                    return false;
            }
        }

        /* renamed from: a */
        private void m3228a() {
            if (this.f2131f != null) {
                this.f2129d.removeCallbacks(this.f2131f);
            }
            if (this.f2130e != null) {
                this.f2129d.removeCallbacks(this.f2130e);
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public void m3232b() {
            m3228a();
            View view = this.f2129d;
            if (view.isEnabled() && !view.isLongClickable() && onForwardingStarted()) {
                view.getParent().requestDisallowInterceptTouchEvent(true);
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 0);
                view.onTouchEvent(obtain);
                obtain.recycle();
                this.f2132g = true;
                this.f2133h = true;
            }
        }

        /* renamed from: b */
        private boolean m3234b(MotionEvent motionEvent) {
            C0558a a;
            boolean z;
            boolean z2 = true;
            View view = this.f2129d;
            ListPopupWindow popup = getPopup();
            if (popup == null || !popup.isShowing() || (a = popup.f2103g) == null || !a.isShown()) {
                return false;
            }
            MotionEvent obtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
            m3235b(view, obtainNoHistory);
            m3231a(a, obtainNoHistory);
            boolean a2 = a.mo4353a(obtainNoHistory, this.f2134i);
            obtainNoHistory.recycle();
            int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
            if (actionMasked == 1 || actionMasked == 3) {
                z = false;
            } else {
                z = true;
            }
            if (!a2 || !z) {
                z2 = false;
            }
            return z2;
        }

        /* renamed from: a */
        private static boolean m3230a(View view, float f, float f2, float f3) {
            return f >= (-f3) && f2 >= (-f3) && f < ((float) (view.getRight() - view.getLeft())) + f3 && f2 < ((float) (view.getBottom() - view.getTop())) + f3;
        }

        /* renamed from: a */
        private boolean m3231a(View view, MotionEvent motionEvent) {
            int[] iArr = this.f2135j;
            view.getLocationOnScreen(iArr);
            motionEvent.offsetLocation((float) (-iArr[0]), (float) (-iArr[1]));
            return true;
        }

        /* renamed from: b */
        private boolean m3235b(View view, MotionEvent motionEvent) {
            int[] iArr = this.f2135j;
            view.getLocationOnScreen(iArr);
            motionEvent.offsetLocation((float) iArr[0], (float) iArr[1]);
            return true;
        }

        /* renamed from: android.support.v7.widget.ListPopupWindow$ForwardingListener$a */
        class C0556a implements Runnable {
            private C0556a() {
            }

            public void run() {
                ForwardingListener.this.f2129d.getParent().requestDisallowInterceptTouchEvent(true);
            }
        }

        /* renamed from: android.support.v7.widget.ListPopupWindow$ForwardingListener$b */
        class C0557b implements Runnable {
            private C0557b() {
            }

            public void run() {
                ForwardingListener.this.m3232b();
            }
        }
    }

    /* renamed from: android.support.v7.widget.ListPopupWindow$a */
    static class C0558a extends ListViewCompat {
        /* access modifiers changed from: private */

        /* renamed from: f */
        public boolean f2138f;

        /* renamed from: g */
        private boolean f2139g;

        /* renamed from: h */
        private boolean f2140h;

        /* renamed from: i */
        private ViewPropertyAnimatorCompat f2141i;

        /* renamed from: j */
        private ListViewAutoScrollHelper f2142j;

        public C0558a(Context context, boolean z) {
            super(context, (AttributeSet) null, C0505R.attr.dropDownListViewStyle);
            this.f2139g = z;
            setCacheColorHint(0);
        }

        /* renamed from: a */
        public boolean mo4353a(MotionEvent motionEvent, int i) {
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
                    m3238a(childAt, pointToPosition, (float) x, (float) y);
                    if (actionMasked == 1) {
                        m3237a(childAt, pointToPosition);
                    }
                    z3 = false;
                    z2 = true;
                }
            }
            if (!z2 || z3) {
                m3236a();
            }
            if (z2) {
                if (this.f2142j == null) {
                    this.f2142j = new ListViewAutoScrollHelper(this);
                }
                this.f2142j.setEnabled(true);
                this.f2142j.onTouch(this, motionEvent);
            } else if (this.f2142j != null) {
                this.f2142j.setEnabled(false);
            }
            return z2;
        }

        /* renamed from: a */
        private void m3237a(View view, int i) {
            performItemClick(view, i, getItemIdAtPosition(i));
        }

        /* renamed from: a */
        private void m3236a() {
            this.f2140h = false;
            setPressed(false);
            drawableStateChanged();
            View childAt = getChildAt(this.mMotionPosition - getFirstVisiblePosition());
            if (childAt != null) {
                childAt.setPressed(false);
            }
            if (this.f2141i != null) {
                this.f2141i.cancel();
                this.f2141i = null;
            }
        }

        /* renamed from: a */
        private void m3238a(View view, int i, float f, float f2) {
            View childAt;
            this.f2140h = true;
            if (Build.VERSION.SDK_INT >= 21) {
                drawableHotspotChanged(f, f2);
            }
            if (!isPressed()) {
                setPressed(true);
            }
            layoutChildren();
            if (!(this.mMotionPosition == -1 || (childAt = getChildAt(this.mMotionPosition - getFirstVisiblePosition())) == null || childAt == view || !childAt.isPressed())) {
                childAt.setPressed(false);
            }
            this.mMotionPosition = i;
            float left = f - ((float) view.getLeft());
            float top = f2 - ((float) view.getTop());
            if (Build.VERSION.SDK_INT >= 21) {
                view.drawableHotspotChanged(left, top);
            }
            if (!view.isPressed()) {
                view.setPressed(true);
            }
            setSelection(i);
            positionSelectorLikeTouchCompat(i, view, f, f2);
            setSelectorEnabled(false);
            refreshDrawableState();
        }

        /* access modifiers changed from: protected */
        public boolean touchModeDrawsInPressedStateCompat() {
            return this.f2140h || super.touchModeDrawsInPressedStateCompat();
        }

        public boolean isInTouchMode() {
            return (this.f2139g && this.f2138f) || super.isInTouchMode();
        }

        public boolean hasWindowFocus() {
            return this.f2139g || super.hasWindowFocus();
        }

        public boolean isFocused() {
            return this.f2139g || super.isFocused();
        }

        public boolean hasFocus() {
            return this.f2139g || super.hasFocus();
        }
    }

    /* renamed from: android.support.v7.widget.ListPopupWindow$c */
    class C0560c extends DataSetObserver {
        private C0560c() {
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

    /* renamed from: android.support.v7.widget.ListPopupWindow$b */
    class C0559b implements Runnable {
        private C0559b() {
        }

        public void run() {
            ListPopupWindow.this.clearListSelection();
        }
    }

    /* renamed from: android.support.v7.widget.ListPopupWindow$f */
    class C0563f implements Runnable {
        private C0563f() {
        }

        public void run() {
            if (ListPopupWindow.this.f2103g != null && ViewCompat.isAttachedToWindow(ListPopupWindow.this.f2103g) && ListPopupWindow.this.f2103g.getCount() > ListPopupWindow.this.f2103g.getChildCount() && ListPopupWindow.this.f2103g.getChildCount() <= ListPopupWindow.this.f2099b) {
                ListPopupWindow.this.f2101e.setInputMethodMode(2);
                ListPopupWindow.this.show();
            }
        }
    }

    /* renamed from: android.support.v7.widget.ListPopupWindow$e */
    class C0562e implements View.OnTouchListener {
        private C0562e() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && ListPopupWindow.this.f2101e != null && ListPopupWindow.this.f2101e.isShowing() && x >= 0 && x < ListPopupWindow.this.f2101e.getWidth() && y >= 0 && y < ListPopupWindow.this.f2101e.getHeight()) {
                ListPopupWindow.this.f2095C.postDelayed(ListPopupWindow.this.f2120x, 250);
                return false;
            } else if (action != 1) {
                return false;
            } else {
                ListPopupWindow.this.f2095C.removeCallbacks(ListPopupWindow.this.f2120x);
                return false;
            }
        }
    }

    /* renamed from: android.support.v7.widget.ListPopupWindow$d */
    class C0561d implements AbsListView.OnScrollListener {
        private C0561d() {
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1 && !ListPopupWindow.this.isInputMethodNotNeeded() && ListPopupWindow.this.f2101e.getContentView() != null) {
                ListPopupWindow.this.f2095C.removeCallbacks(ListPopupWindow.this.f2120x);
                ListPopupWindow.this.f2120x.run();
            }
        }
    }

    /* renamed from: a */
    private static boolean m3222a(int i) {
        return i == 66 || i == 23;
    }

    /* renamed from: a */
    private void m3221a(boolean z) {
        if (f2091a != null) {
            try {
                f2091a.invoke(this.f2101e, new Object[]{Boolean.valueOf(z)});
            } catch (Exception e) {
                Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
        }
    }

    /* renamed from: a */
    private int m3218a(View view, int i, boolean z) {
        if (f2092c != null) {
            try {
                return ((Integer) f2092c.invoke(this.f2101e, new Object[]{view, Integer.valueOf(i), Boolean.valueOf(z)})).intValue();
            } catch (Exception e) {
                Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
            }
        }
        return this.f2101e.getMaxAvailableHeight(view, i);
    }
}
