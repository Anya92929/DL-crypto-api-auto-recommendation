package android.support.p004v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.p001v4.view.ViewCompat;
import android.support.p001v4.view.ViewPropertyAnimatorCompat;
import android.support.p001v4.view.ViewPropertyAnimatorListener;
import android.support.p004v7.app.ActionBar;
import android.support.p004v7.appcompat.C0505R;
import android.support.p004v7.view.ActionBarPolicy;
import android.support.p004v7.widget.LinearLayoutCompat;
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

/* renamed from: android.support.v7.widget.ScrollingTabContainerView */
public class ScrollingTabContainerView extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {

    /* renamed from: j */
    private static final Interpolator f2165j = new DecelerateInterpolator();

    /* renamed from: a */
    Runnable f2166a;

    /* renamed from: b */
    int f2167b;

    /* renamed from: c */
    int f2168c;

    /* renamed from: d */
    private C0568b f2169d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public LinearLayoutCompat f2170e;

    /* renamed from: f */
    private Spinner f2171f;

    /* renamed from: g */
    private boolean f2172g;

    /* renamed from: h */
    private int f2173h;

    /* renamed from: i */
    private int f2174i;
    protected final VisibilityAnimListener mVisAnimListener = new VisibilityAnimListener();
    protected ViewPropertyAnimatorCompat mVisibilityAnim;

    public ScrollingTabContainerView(Context context) {
        super(context);
        setHorizontalScrollBarEnabled(false);
        ActionBarPolicy actionBarPolicy = ActionBarPolicy.get(context);
        setContentHeight(actionBarPolicy.getTabContainerHeight());
        this.f2168c = actionBarPolicy.getStackedTabMaxWidth();
        this.f2170e = m3249d();
        addView(this.f2170e, new ViewGroup.LayoutParams(-2, -1));
    }

    public void onMeasure(int i, int i2) {
        boolean z = true;
        int mode = View.MeasureSpec.getMode(i);
        boolean z2 = mode == 1073741824;
        setFillViewport(z2);
        int childCount = this.f2170e.getChildCount();
        if (childCount <= 1 || !(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            this.f2167b = -1;
        } else {
            if (childCount > 2) {
                this.f2167b = (int) (((float) View.MeasureSpec.getSize(i)) * 0.4f);
            } else {
                this.f2167b = View.MeasureSpec.getSize(i) / 2;
            }
            this.f2167b = Math.min(this.f2167b, this.f2168c);
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f2173h, 1073741824);
        if (z2 || !this.f2172g) {
            z = false;
        }
        if (z) {
            this.f2170e.measure(0, makeMeasureSpec);
            if (this.f2170e.getMeasuredWidth() > View.MeasureSpec.getSize(i)) {
                m3247b();
            } else {
                m3248c();
            }
        } else {
            m3248c();
        }
        int measuredWidth = getMeasuredWidth();
        super.onMeasure(i, makeMeasureSpec);
        int measuredWidth2 = getMeasuredWidth();
        if (z2 && measuredWidth != measuredWidth2) {
            setTabSelected(this.f2174i);
        }
    }

    /* renamed from: a */
    private boolean m3246a() {
        return this.f2171f != null && this.f2171f.getParent() == this;
    }

    public void setAllowCollapse(boolean z) {
        this.f2172g = z;
    }

    /* renamed from: b */
    private void m3247b() {
        if (!m3246a()) {
            if (this.f2171f == null) {
                this.f2171f = m3250e();
            }
            removeView(this.f2170e);
            addView(this.f2171f, new ViewGroup.LayoutParams(-2, -1));
            if (this.f2171f.getAdapter() == null) {
                this.f2171f.setAdapter(new C0567a());
            }
            if (this.f2166a != null) {
                removeCallbacks(this.f2166a);
                this.f2166a = null;
            }
            this.f2171f.setSelection(this.f2174i);
        }
    }

    /* renamed from: c */
    private boolean m3248c() {
        if (m3246a()) {
            removeView(this.f2171f);
            addView(this.f2170e, new ViewGroup.LayoutParams(-2, -1));
            setTabSelected(this.f2171f.getSelectedItemPosition());
        }
        return false;
    }

    public void setTabSelected(int i) {
        boolean z;
        this.f2174i = i;
        int childCount = this.f2170e.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.f2170e.getChildAt(i2);
            if (i2 == i) {
                z = true;
            } else {
                z = false;
            }
            childAt.setSelected(z);
            if (z) {
                animateToTab(i);
            }
        }
        if (this.f2171f != null && i >= 0) {
            this.f2171f.setSelection(i);
        }
    }

    public void setContentHeight(int i) {
        this.f2173h = i;
        requestLayout();
    }

    /* renamed from: d */
    private LinearLayoutCompat m3249d() {
        LinearLayoutCompat linearLayoutCompat = new LinearLayoutCompat(getContext(), (AttributeSet) null, C0505R.attr.actionBarTabBarStyle);
        linearLayoutCompat.setMeasureWithLargestChildEnabled(true);
        linearLayoutCompat.setGravity(17);
        linearLayoutCompat.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
        return linearLayoutCompat;
    }

    /* renamed from: e */
    private Spinner m3250e() {
        AppCompatSpinner appCompatSpinner = new AppCompatSpinner(getContext(), (AttributeSet) null, C0505R.attr.actionDropDownStyle);
        appCompatSpinner.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
        appCompatSpinner.setOnItemSelectedListener(this);
        return appCompatSpinner;
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        ActionBarPolicy actionBarPolicy = ActionBarPolicy.get(getContext());
        setContentHeight(actionBarPolicy.getTabContainerHeight());
        this.f2168c = actionBarPolicy.getStackedTabMaxWidth();
    }

    public void animateToVisibility(int i) {
        if (this.mVisibilityAnim != null) {
            this.mVisibilityAnim.cancel();
        }
        if (i == 0) {
            if (getVisibility() != 0) {
                ViewCompat.setAlpha(this, BitmapDescriptorFactory.HUE_RED);
            }
            ViewPropertyAnimatorCompat alpha = ViewCompat.animate(this).alpha(1.0f);
            alpha.setDuration(200);
            alpha.setInterpolator(f2165j);
            alpha.setListener(this.mVisAnimListener.withFinalVisibility(alpha, i));
            alpha.start();
            return;
        }
        ViewPropertyAnimatorCompat alpha2 = ViewCompat.animate(this).alpha(BitmapDescriptorFactory.HUE_RED);
        alpha2.setDuration(200);
        alpha2.setInterpolator(f2165j);
        alpha2.setListener(this.mVisAnimListener.withFinalVisibility(alpha2, i));
        alpha2.start();
    }

    public void animateToTab(int i) {
        final View childAt = this.f2170e.getChildAt(i);
        if (this.f2166a != null) {
            removeCallbacks(this.f2166a);
        }
        this.f2166a = new Runnable() {
            public void run() {
                ScrollingTabContainerView.this.smoothScrollTo(childAt.getLeft() - ((ScrollingTabContainerView.this.getWidth() - childAt.getWidth()) / 2), 0);
                ScrollingTabContainerView.this.f2166a = null;
            }
        };
        post(this.f2166a);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f2166a != null) {
            post(this.f2166a);
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f2166a != null) {
            removeCallbacks(this.f2166a);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public C0569c m3244a(ActionBar.Tab tab, boolean z) {
        C0569c cVar = new C0569c(getContext(), tab, z);
        if (z) {
            cVar.setBackgroundDrawable((Drawable) null);
            cVar.setLayoutParams(new AbsListView.LayoutParams(-1, this.f2173h));
        } else {
            cVar.setFocusable(true);
            if (this.f2169d == null) {
                this.f2169d = new C0568b();
            }
            cVar.setOnClickListener(this.f2169d);
        }
        return cVar;
    }

    public void addTab(ActionBar.Tab tab, boolean z) {
        C0569c a = m3244a(tab, false);
        this.f2170e.addView(a, new LinearLayoutCompat.LayoutParams(0, -1, 1.0f));
        if (this.f2171f != null) {
            ((C0567a) this.f2171f.getAdapter()).notifyDataSetChanged();
        }
        if (z) {
            a.setSelected(true);
        }
        if (this.f2172g) {
            requestLayout();
        }
    }

    public void addTab(ActionBar.Tab tab, int i, boolean z) {
        C0569c a = m3244a(tab, false);
        this.f2170e.addView(a, i, new LinearLayoutCompat.LayoutParams(0, -1, 1.0f));
        if (this.f2171f != null) {
            ((C0567a) this.f2171f.getAdapter()).notifyDataSetChanged();
        }
        if (z) {
            a.setSelected(true);
        }
        if (this.f2172g) {
            requestLayout();
        }
    }

    public void updateTab(int i) {
        ((C0569c) this.f2170e.getChildAt(i)).mo4416a();
        if (this.f2171f != null) {
            ((C0567a) this.f2171f.getAdapter()).notifyDataSetChanged();
        }
        if (this.f2172g) {
            requestLayout();
        }
    }

    public void removeTabAt(int i) {
        this.f2170e.removeViewAt(i);
        if (this.f2171f != null) {
            ((C0567a) this.f2171f.getAdapter()).notifyDataSetChanged();
        }
        if (this.f2172g) {
            requestLayout();
        }
    }

    public void removeAllTabs() {
        this.f2170e.removeAllViews();
        if (this.f2171f != null) {
            ((C0567a) this.f2171f.getAdapter()).notifyDataSetChanged();
        }
        if (this.f2172g) {
            requestLayout();
        }
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        ((C0569c) view).mo4418b().select();
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    /* renamed from: android.support.v7.widget.ScrollingTabContainerView$c */
    class C0569c extends LinearLayoutCompat implements View.OnLongClickListener {

        /* renamed from: b */
        private final int[] f2183b = {16842964};

        /* renamed from: c */
        private ActionBar.Tab f2184c;

        /* renamed from: d */
        private TextView f2185d;

        /* renamed from: e */
        private ImageView f2186e;

        /* renamed from: f */
        private View f2187f;

        public C0569c(Context context, ActionBar.Tab tab, boolean z) {
            super(context, (AttributeSet) null, C0505R.attr.actionBarTabStyle);
            this.f2184c = tab;
            TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, (AttributeSet) null, this.f2183b, C0505R.attr.actionBarTabStyle, 0);
            if (obtainStyledAttributes.hasValue(0)) {
                setBackgroundDrawable(obtainStyledAttributes.getDrawable(0));
            }
            obtainStyledAttributes.recycle();
            if (z) {
                setGravity(8388627);
            }
            mo4416a();
        }

        /* renamed from: a */
        public void mo4417a(ActionBar.Tab tab) {
            this.f2184c = tab;
            mo4416a();
        }

        public void setSelected(boolean z) {
            boolean z2 = isSelected() != z;
            super.setSelected(z);
            if (z2 && z) {
                sendAccessibilityEvent(4);
            }
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

        public void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (ScrollingTabContainerView.this.f2167b > 0 && getMeasuredWidth() > ScrollingTabContainerView.this.f2167b) {
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(ScrollingTabContainerView.this.f2167b, 1073741824), i2);
            }
        }

        /* renamed from: a */
        public void mo4416a() {
            boolean z;
            ActionBar.Tab tab = this.f2184c;
            View customView = tab.getCustomView();
            if (customView != null) {
                ViewParent parent = customView.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(customView);
                    }
                    addView(customView);
                }
                this.f2187f = customView;
                if (this.f2185d != null) {
                    this.f2185d.setVisibility(8);
                }
                if (this.f2186e != null) {
                    this.f2186e.setVisibility(8);
                    this.f2186e.setImageDrawable((Drawable) null);
                    return;
                }
                return;
            }
            if (this.f2187f != null) {
                removeView(this.f2187f);
                this.f2187f = null;
            }
            Drawable icon = tab.getIcon();
            CharSequence text = tab.getText();
            if (icon != null) {
                if (this.f2186e == null) {
                    ImageView imageView = new ImageView(getContext());
                    LinearLayoutCompat.LayoutParams layoutParams = new LinearLayoutCompat.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    imageView.setLayoutParams(layoutParams);
                    addView(imageView, 0);
                    this.f2186e = imageView;
                }
                this.f2186e.setImageDrawable(icon);
                this.f2186e.setVisibility(0);
            } else if (this.f2186e != null) {
                this.f2186e.setVisibility(8);
                this.f2186e.setImageDrawable((Drawable) null);
            }
            if (!TextUtils.isEmpty(text)) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                if (this.f2185d == null) {
                    AppCompatTextView appCompatTextView = new AppCompatTextView(getContext(), (AttributeSet) null, C0505R.attr.actionBarTabTextStyle);
                    appCompatTextView.setEllipsize(TextUtils.TruncateAt.END);
                    LinearLayoutCompat.LayoutParams layoutParams2 = new LinearLayoutCompat.LayoutParams(-2, -2);
                    layoutParams2.gravity = 16;
                    appCompatTextView.setLayoutParams(layoutParams2);
                    addView(appCompatTextView);
                    this.f2185d = appCompatTextView;
                }
                this.f2185d.setText(text);
                this.f2185d.setVisibility(0);
            } else if (this.f2185d != null) {
                this.f2185d.setVisibility(8);
                this.f2185d.setText((CharSequence) null);
            }
            if (this.f2186e != null) {
                this.f2186e.setContentDescription(tab.getContentDescription());
            }
            if (z || TextUtils.isEmpty(tab.getContentDescription())) {
                setOnLongClickListener((View.OnLongClickListener) null);
                setLongClickable(false);
                return;
            }
            setOnLongClickListener(this);
        }

        public boolean onLongClick(View view) {
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            Context context = getContext();
            int width = getWidth();
            int height = getHeight();
            int i = context.getResources().getDisplayMetrics().widthPixels;
            Toast makeText = Toast.makeText(context, this.f2184c.getContentDescription(), 0);
            makeText.setGravity(49, (iArr[0] + (width / 2)) - (i / 2), height);
            makeText.show();
            return true;
        }

        /* renamed from: b */
        public ActionBar.Tab mo4418b() {
            return this.f2184c;
        }
    }

    /* renamed from: android.support.v7.widget.ScrollingTabContainerView$a */
    class C0567a extends BaseAdapter {
        private C0567a() {
        }

        public int getCount() {
            return ScrollingTabContainerView.this.f2170e.getChildCount();
        }

        public Object getItem(int i) {
            return ((C0569c) ScrollingTabContainerView.this.f2170e.getChildAt(i)).mo4418b();
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                return ScrollingTabContainerView.this.m3244a((ActionBar.Tab) getItem(i), true);
            }
            ((C0569c) view).mo4417a((ActionBar.Tab) getItem(i));
            return view;
        }
    }

    /* renamed from: android.support.v7.widget.ScrollingTabContainerView$b */
    class C0568b implements View.OnClickListener {
        private C0568b() {
        }

        public void onClick(View view) {
            boolean z;
            ((C0569c) view).mo4418b().select();
            int childCount = ScrollingTabContainerView.this.f2170e.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = ScrollingTabContainerView.this.f2170e.getChildAt(i);
                if (childAt == view) {
                    z = true;
                } else {
                    z = false;
                }
                childAt.setSelected(z);
            }
        }
    }

    /* renamed from: android.support.v7.widget.ScrollingTabContainerView$VisibilityAnimListener */
    public class VisibilityAnimListener implements ViewPropertyAnimatorListener {

        /* renamed from: b */
        private boolean f2178b = false;

        /* renamed from: c */
        private int f2179c;

        protected VisibilityAnimListener() {
        }

        public VisibilityAnimListener withFinalVisibility(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, int i) {
            this.f2179c = i;
            ScrollingTabContainerView.this.mVisibilityAnim = viewPropertyAnimatorCompat;
            return this;
        }

        public void onAnimationStart(View view) {
            ScrollingTabContainerView.this.setVisibility(0);
            this.f2178b = false;
        }

        public void onAnimationEnd(View view) {
            if (!this.f2178b) {
                ScrollingTabContainerView.this.mVisibilityAnim = null;
                ScrollingTabContainerView.this.setVisibility(this.f2179c);
            }
        }

        public void onAnimationCancel(View view) {
            this.f2178b = true;
        }
    }
}
