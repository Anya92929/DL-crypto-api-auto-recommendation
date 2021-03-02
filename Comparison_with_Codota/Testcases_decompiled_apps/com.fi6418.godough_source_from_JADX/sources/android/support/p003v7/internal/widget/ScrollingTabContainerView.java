package android.support.p003v7.internal.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.p000v4.view.ViewCompat;
import android.support.p000v4.view.ViewPropertyAnimatorCompat;
import android.support.p000v4.view.ViewPropertyAnimatorListener;
import android.support.p003v7.app.ActionBar;
import android.support.p003v7.appcompat.C0235R;
import android.support.p003v7.internal.view.ActionBarPolicy;
import android.support.p003v7.widget.AppCompatSpinner;
import android.support.p003v7.widget.AppCompatTextView;
import android.support.p003v7.widget.LinearLayoutCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* renamed from: android.support.v7.internal.widget.ScrollingTabContainerView */
public class ScrollingTabContainerView extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {

    /* renamed from: l */
    private static final Interpolator f2342l = new DecelerateInterpolator();

    /* renamed from: a */
    Runnable f2343a;

    /* renamed from: b */
    int f2344b;

    /* renamed from: c */
    int f2345c;

    /* renamed from: d */
    protected ViewPropertyAnimatorCompat f2346d;

    /* renamed from: e */
    protected final VisibilityAnimListener f2347e = new VisibilityAnimListener();

    /* renamed from: f */
    private TabClickListener f2348f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public LinearLayoutCompat f2349g;

    /* renamed from: h */
    private Spinner f2350h;

    /* renamed from: i */
    private boolean f2351i;

    /* renamed from: j */
    private int f2352j;

    /* renamed from: k */
    private int f2353k;

    /* renamed from: android.support.v7.internal.widget.ScrollingTabContainerView$TabAdapter */
    class TabAdapter extends BaseAdapter {
        private TabAdapter() {
        }

        public int getCount() {
            return ScrollingTabContainerView.this.f2349g.getChildCount();
        }

        public Object getItem(int i) {
            return ((TabView) ScrollingTabContainerView.this.f2349g.getChildAt(i)).getTab();
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                return ScrollingTabContainerView.this.m1506a((ActionBar.Tab) getItem(i), true);
            }
            ((TabView) view).bindTab((ActionBar.Tab) getItem(i));
            return view;
        }
    }

    /* renamed from: android.support.v7.internal.widget.ScrollingTabContainerView$TabClickListener */
    class TabClickListener implements View.OnClickListener {
        private TabClickListener() {
        }

        public void onClick(View view) {
            ((TabView) view).getTab().select();
            int childCount = ScrollingTabContainerView.this.f2349g.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = ScrollingTabContainerView.this.f2349g.getChildAt(i);
                childAt.setSelected(childAt == view);
            }
        }
    }

    /* renamed from: android.support.v7.internal.widget.ScrollingTabContainerView$TabView */
    class TabView extends LinearLayoutCompat implements View.OnLongClickListener {

        /* renamed from: b */
        private final int[] f2359b = {16842964};

        /* renamed from: c */
        private ActionBar.Tab f2360c;

        /* renamed from: d */
        private TextView f2361d;

        /* renamed from: e */
        private ImageView f2362e;

        /* renamed from: f */
        private View f2363f;

        public TabView(Context context, ActionBar.Tab tab, boolean z) {
            super(context, (AttributeSet) null, C0235R.attr.actionBarTabStyle);
            this.f2360c = tab;
            TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, (AttributeSet) null, this.f2359b, C0235R.attr.actionBarTabStyle, 0);
            if (obtainStyledAttributes.hasValue(0)) {
                setBackgroundDrawable(obtainStyledAttributes.getDrawable(0));
            }
            obtainStyledAttributes.recycle();
            if (z) {
                setGravity(8388627);
            }
            update();
        }

        public void bindTab(ActionBar.Tab tab) {
            this.f2360c = tab;
            update();
        }

        public ActionBar.Tab getTab() {
            return this.f2360c;
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(ActionBar.Tab.class.getName());
        }

        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            if (Build.VERSION.SDK_INT >= 14) {
                accessibilityNodeInfo.setClassName(ActionBar.Tab.class.getName());
            }
        }

        public boolean onLongClick(View view) {
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            Context context = getContext();
            int width = getWidth();
            int height = getHeight();
            int i = context.getResources().getDisplayMetrics().widthPixels;
            Toast makeText = Toast.makeText(context, this.f2360c.getContentDescription(), 0);
            makeText.setGravity(49, (iArr[0] + (width / 2)) - (i / 2), height);
            makeText.show();
            return true;
        }

        public void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (ScrollingTabContainerView.this.f2344b > 0 && getMeasuredWidth() > ScrollingTabContainerView.this.f2344b) {
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(ScrollingTabContainerView.this.f2344b, 1073741824), i2);
            }
        }

        public void setSelected(boolean z) {
            boolean z2 = isSelected() != z;
            super.setSelected(z);
            if (z2 && z) {
                sendAccessibilityEvent(4);
            }
        }

        public void update() {
            ActionBar.Tab tab = this.f2360c;
            View customView = tab.getCustomView();
            if (customView != null) {
                ViewParent parent = customView.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(customView);
                    }
                    addView(customView);
                }
                this.f2363f = customView;
                if (this.f2361d != null) {
                    this.f2361d.setVisibility(8);
                }
                if (this.f2362e != null) {
                    this.f2362e.setVisibility(8);
                    this.f2362e.setImageDrawable((Drawable) null);
                    return;
                }
                return;
            }
            if (this.f2363f != null) {
                removeView(this.f2363f);
                this.f2363f = null;
            }
            Drawable icon = tab.getIcon();
            CharSequence text = tab.getText();
            if (icon != null) {
                if (this.f2362e == null) {
                    ImageView imageView = new ImageView(getContext());
                    LinearLayoutCompat.LayoutParams layoutParams = new LinearLayoutCompat.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    imageView.setLayoutParams(layoutParams);
                    addView(imageView, 0);
                    this.f2362e = imageView;
                }
                this.f2362e.setImageDrawable(icon);
                this.f2362e.setVisibility(0);
            } else if (this.f2362e != null) {
                this.f2362e.setVisibility(8);
                this.f2362e.setImageDrawable((Drawable) null);
            }
            boolean z = !TextUtils.isEmpty(text);
            if (z) {
                if (this.f2361d == null) {
                    AppCompatTextView appCompatTextView = new AppCompatTextView(getContext(), (AttributeSet) null, C0235R.attr.actionBarTabTextStyle);
                    appCompatTextView.setEllipsize(TextUtils.TruncateAt.END);
                    LinearLayoutCompat.LayoutParams layoutParams2 = new LinearLayoutCompat.LayoutParams(-2, -2);
                    layoutParams2.gravity = 16;
                    appCompatTextView.setLayoutParams(layoutParams2);
                    addView(appCompatTextView);
                    this.f2361d = appCompatTextView;
                }
                this.f2361d.setText(text);
                this.f2361d.setVisibility(0);
            } else if (this.f2361d != null) {
                this.f2361d.setVisibility(8);
                this.f2361d.setText((CharSequence) null);
            }
            if (this.f2362e != null) {
                this.f2362e.setContentDescription(tab.getContentDescription());
            }
            if (z || TextUtils.isEmpty(tab.getContentDescription())) {
                setOnLongClickListener((View.OnLongClickListener) null);
                setLongClickable(false);
                return;
            }
            setOnLongClickListener(this);
        }
    }

    /* renamed from: android.support.v7.internal.widget.ScrollingTabContainerView$VisibilityAnimListener */
    public class VisibilityAnimListener implements ViewPropertyAnimatorListener {

        /* renamed from: b */
        private boolean f2365b = false;

        /* renamed from: c */
        private int f2366c;

        protected VisibilityAnimListener() {
        }

        public void onAnimationCancel(View view) {
            this.f2365b = true;
        }

        public void onAnimationEnd(View view) {
            if (!this.f2365b) {
                ScrollingTabContainerView.this.f2346d = null;
                ScrollingTabContainerView.this.setVisibility(this.f2366c);
            }
        }

        public void onAnimationStart(View view) {
            ScrollingTabContainerView.this.setVisibility(0);
            this.f2365b = false;
        }

        public VisibilityAnimListener withFinalVisibility(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, int i) {
            this.f2366c = i;
            ScrollingTabContainerView.this.f2346d = viewPropertyAnimatorCompat;
            return this;
        }
    }

    public ScrollingTabContainerView(Context context) {
        super(context);
        setHorizontalScrollBarEnabled(false);
        ActionBarPolicy actionBarPolicy = ActionBarPolicy.get(context);
        setContentHeight(actionBarPolicy.getTabContainerHeight());
        this.f2345c = actionBarPolicy.getStackedTabMaxWidth();
        this.f2349g = m1512d();
        addView(this.f2349g, new ViewGroup.LayoutParams(-2, -1));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public TabView m1506a(ActionBar.Tab tab, boolean z) {
        TabView tabView = new TabView(getContext(), tab, z);
        if (z) {
            tabView.setBackgroundDrawable((Drawable) null);
            tabView.setLayoutParams(new AbsListView.LayoutParams(-1, this.f2352j));
        } else {
            tabView.setFocusable(true);
            if (this.f2348f == null) {
                this.f2348f = new TabClickListener();
            }
            tabView.setOnClickListener(this.f2348f);
        }
        return tabView;
    }

    /* renamed from: a */
    private boolean m1509a() {
        return this.f2350h != null && this.f2350h.getParent() == this;
    }

    /* renamed from: b */
    private void m1510b() {
        if (!m1509a()) {
            if (this.f2350h == null) {
                this.f2350h = m1513e();
            }
            removeView(this.f2349g);
            addView(this.f2350h, new ViewGroup.LayoutParams(-2, -1));
            if (this.f2350h.getAdapter() == null) {
                this.f2350h.setAdapter(new TabAdapter());
            }
            if (this.f2343a != null) {
                removeCallbacks(this.f2343a);
                this.f2343a = null;
            }
            this.f2350h.setSelection(this.f2353k);
        }
    }

    /* renamed from: c */
    private boolean m1511c() {
        if (m1509a()) {
            removeView(this.f2350h);
            addView(this.f2349g, new ViewGroup.LayoutParams(-2, -1));
            setTabSelected(this.f2350h.getSelectedItemPosition());
        }
        return false;
    }

    /* renamed from: d */
    private LinearLayoutCompat m1512d() {
        LinearLayoutCompat linearLayoutCompat = new LinearLayoutCompat(getContext(), (AttributeSet) null, C0235R.attr.actionBarTabBarStyle);
        linearLayoutCompat.setMeasureWithLargestChildEnabled(true);
        linearLayoutCompat.setGravity(17);
        linearLayoutCompat.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
        return linearLayoutCompat;
    }

    /* renamed from: e */
    private Spinner m1513e() {
        AppCompatSpinner appCompatSpinner = new AppCompatSpinner(getContext(), (AttributeSet) null, C0235R.attr.actionDropDownStyle);
        appCompatSpinner.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
        appCompatSpinner.setOnItemSelectedListener(this);
        return appCompatSpinner;
    }

    public void addTab(ActionBar.Tab tab, int i, boolean z) {
        TabView a = m1506a(tab, false);
        this.f2349g.addView(a, i, new LinearLayoutCompat.LayoutParams(0, -1, 1.0f));
        if (this.f2350h != null) {
            ((TabAdapter) this.f2350h.getAdapter()).notifyDataSetChanged();
        }
        if (z) {
            a.setSelected(true);
        }
        if (this.f2351i) {
            requestLayout();
        }
    }

    public void addTab(ActionBar.Tab tab, boolean z) {
        TabView a = m1506a(tab, false);
        this.f2349g.addView(a, new LinearLayoutCompat.LayoutParams(0, -1, 1.0f));
        if (this.f2350h != null) {
            ((TabAdapter) this.f2350h.getAdapter()).notifyDataSetChanged();
        }
        if (z) {
            a.setSelected(true);
        }
        if (this.f2351i) {
            requestLayout();
        }
    }

    public void animateToTab(int i) {
        final View childAt = this.f2349g.getChildAt(i);
        if (this.f2343a != null) {
            removeCallbacks(this.f2343a);
        }
        this.f2343a = new Runnable() {
            public void run() {
                ScrollingTabContainerView.this.smoothScrollTo(childAt.getLeft() - ((ScrollingTabContainerView.this.getWidth() - childAt.getWidth()) / 2), 0);
                ScrollingTabContainerView.this.f2343a = null;
            }
        };
        post(this.f2343a);
    }

    public void animateToVisibility(int i) {
        if (this.f2346d != null) {
            this.f2346d.cancel();
        }
        if (i == 0) {
            if (getVisibility() != 0) {
                ViewCompat.setAlpha(this, BitmapDescriptorFactory.HUE_RED);
            }
            ViewPropertyAnimatorCompat alpha = ViewCompat.animate(this).alpha(1.0f);
            alpha.setDuration(200);
            alpha.setInterpolator(f2342l);
            alpha.setListener(this.f2347e.withFinalVisibility(alpha, i));
            alpha.start();
            return;
        }
        ViewPropertyAnimatorCompat alpha2 = ViewCompat.animate(this).alpha(BitmapDescriptorFactory.HUE_RED);
        alpha2.setDuration(200);
        alpha2.setInterpolator(f2342l);
        alpha2.setListener(this.f2347e.withFinalVisibility(alpha2, i));
        alpha2.start();
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f2343a != null) {
            post(this.f2343a);
        }
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        ActionBarPolicy actionBarPolicy = ActionBarPolicy.get(getContext());
        setContentHeight(actionBarPolicy.getTabContainerHeight());
        this.f2345c = actionBarPolicy.getStackedTabMaxWidth();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f2343a != null) {
            removeCallbacks(this.f2343a);
        }
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        ((TabView) view).getTab().select();
    }

    public void onMeasure(int i, int i2) {
        boolean z = true;
        int mode = View.MeasureSpec.getMode(i);
        boolean z2 = mode == 1073741824;
        setFillViewport(z2);
        int childCount = this.f2349g.getChildCount();
        if (childCount <= 1 || !(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            this.f2344b = -1;
        } else {
            if (childCount > 2) {
                this.f2344b = (int) (((float) View.MeasureSpec.getSize(i)) * 0.4f);
            } else {
                this.f2344b = View.MeasureSpec.getSize(i) / 2;
            }
            this.f2344b = Math.min(this.f2344b, this.f2345c);
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f2352j, 1073741824);
        if (z2 || !this.f2351i) {
            z = false;
        }
        if (z) {
            this.f2349g.measure(0, makeMeasureSpec);
            if (this.f2349g.getMeasuredWidth() > View.MeasureSpec.getSize(i)) {
                m1510b();
            } else {
                m1511c();
            }
        } else {
            m1511c();
        }
        int measuredWidth = getMeasuredWidth();
        super.onMeasure(i, makeMeasureSpec);
        int measuredWidth2 = getMeasuredWidth();
        if (z2 && measuredWidth != measuredWidth2) {
            setTabSelected(this.f2353k);
        }
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void removeAllTabs() {
        this.f2349g.removeAllViews();
        if (this.f2350h != null) {
            ((TabAdapter) this.f2350h.getAdapter()).notifyDataSetChanged();
        }
        if (this.f2351i) {
            requestLayout();
        }
    }

    public void removeTabAt(int i) {
        this.f2349g.removeViewAt(i);
        if (this.f2350h != null) {
            ((TabAdapter) this.f2350h.getAdapter()).notifyDataSetChanged();
        }
        if (this.f2351i) {
            requestLayout();
        }
    }

    public void setAllowCollapse(boolean z) {
        this.f2351i = z;
    }

    public void setContentHeight(int i) {
        this.f2352j = i;
        requestLayout();
    }

    public void setTabSelected(int i) {
        this.f2353k = i;
        int childCount = this.f2349g.getChildCount();
        int i2 = 0;
        while (i2 < childCount) {
            View childAt = this.f2349g.getChildAt(i2);
            boolean z = i2 == i;
            childAt.setSelected(z);
            if (z) {
                animateToTab(i);
            }
            i2++;
        }
        if (this.f2350h != null && i >= 0) {
            this.f2350h.setSelection(i);
        }
    }

    public void updateTab(int i) {
        ((TabView) this.f2349g.getChildAt(i)).update();
        if (this.f2350h != null) {
            ((TabAdapter) this.f2350h.getAdapter()).notifyDataSetChanged();
        }
        if (this.f2351i) {
            requestLayout();
        }
    }
}
