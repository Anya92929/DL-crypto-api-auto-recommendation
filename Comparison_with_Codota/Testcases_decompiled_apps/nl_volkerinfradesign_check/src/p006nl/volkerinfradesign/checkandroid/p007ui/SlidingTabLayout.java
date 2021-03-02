package p006nl.volkerinfradesign.checkandroid.p007ui;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.support.p001v4.view.PagerAdapter;
import android.support.p001v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.TextView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* renamed from: nl.volkerinfradesign.checkandroid.ui.SlidingTabLayout */
public class SlidingTabLayout extends HorizontalScrollView {

    /* renamed from: a */
    private int f4984a;

    /* renamed from: b */
    private int f4985b;

    /* renamed from: c */
    private int f4986c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public ViewPager f4987d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public ViewPager.OnPageChangeListener f4988e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final SlidingTabStrip f4989f;

    /* renamed from: nl.volkerinfradesign.checkandroid.ui.SlidingTabLayout$TabColorizer */
    public interface TabColorizer {
        int getDividerColor(int i);

        int getIndicatorColor(int i);
    }

    public SlidingTabLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public SlidingTabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlidingTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setHorizontalScrollBarEnabled(false);
        setFillViewport(true);
        this.f4984a = (int) (24.0f * getResources().getDisplayMetrics().density);
        this.f4989f = new SlidingTabStrip(context);
        addView(this.f4989f, -1, -2);
    }

    public void setCustomTabColorizer(TabColorizer tabColorizer) {
        this.f4989f.setCustomTabColorizer(tabColorizer);
    }

    public void setSelectedIndicatorColors(int... iArr) {
        this.f4989f.setSelectedIndicatorColors(iArr);
    }

    public void setDividerColors(int... iArr) {
        this.f4989f.setDividerColors(iArr);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.f4988e = onPageChangeListener;
    }

    public void setCustomTabView(int i, int i2) {
        this.f4985b = i;
        this.f4986c = i2;
    }

    public void setViewPager(ViewPager viewPager) {
        this.f4989f.removeAllViews();
        this.f4987d = viewPager;
        if (viewPager != null) {
            viewPager.setOnPageChangeListener(new C1541a());
            m6049a();
        }
    }

    /* access modifiers changed from: protected */
    public TextView createDefaultTabView(Context context) {
        TextView textView = new TextView(context);
        textView.setGravity(17);
        textView.setTextSize(2, 12.0f);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        if (Build.VERSION.SDK_INT >= 11) {
            TypedValue typedValue = new TypedValue();
            getContext().getTheme().resolveAttribute(16843534, typedValue, true);
            textView.setBackgroundResource(typedValue.resourceId);
        }
        if (Build.VERSION.SDK_INT >= 14) {
            textView.setAllCaps(true);
        }
        int i = (int) (16.0f * getResources().getDisplayMetrics().density);
        textView.setPadding(i, i, i, i);
        return textView;
    }

    /* renamed from: a */
    private void m6049a() {
        TextView textView;
        View view;
        PagerAdapter adapter = this.f4987d.getAdapter();
        C1542b bVar = new C1542b();
        for (int i = 0; i < adapter.getCount(); i++) {
            if (this.f4985b != 0) {
                view = LayoutInflater.from(getContext()).inflate(this.f4985b, this.f4989f, false);
                textView = (TextView) view.findViewById(this.f4986c);
            } else {
                textView = null;
                view = null;
            }
            if (view == null) {
                view = createDefaultTabView(getContext());
            }
            if (textView == null && TextView.class.isInstance(view)) {
                textView = (TextView) view;
            }
            textView.setText(adapter.getPageTitle(i));
            view.setOnClickListener(bVar);
            this.f4989f.addView(view);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f4987d != null) {
            m6050a(this.f4987d.getCurrentItem(), 0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6050a(int i, int i2) {
        View childAt;
        int childCount = this.f4989f.getChildCount();
        if (childCount != 0 && i >= 0 && i < childCount && (childAt = this.f4989f.getChildAt(i)) != null) {
            int left = childAt.getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.f4984a;
            }
            scrollTo(left, 0);
        }
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.ui.SlidingTabLayout$a */
    class C1541a implements ViewPager.OnPageChangeListener {

        /* renamed from: b */
        private int f4991b;

        private C1541a() {
        }

        public void onPageScrolled(int i, float f, int i2) {
            int childCount = SlidingTabLayout.this.f4989f.getChildCount();
            if (childCount != 0 && i >= 0 && i < childCount) {
                SlidingTabLayout.this.f4989f.mo9825a(i, f);
                View childAt = SlidingTabLayout.this.f4989f.getChildAt(i);
                SlidingTabLayout.this.m6050a(i, childAt != null ? (int) (((float) childAt.getWidth()) * f) : 0);
                if (SlidingTabLayout.this.f4988e != null) {
                    SlidingTabLayout.this.f4988e.onPageScrolled(i, f, i2);
                }
            }
        }

        public void onPageScrollStateChanged(int i) {
            this.f4991b = i;
            if (SlidingTabLayout.this.f4988e != null) {
                SlidingTabLayout.this.f4988e.onPageScrollStateChanged(i);
            }
        }

        public void onPageSelected(int i) {
            if (this.f4991b == 0) {
                SlidingTabLayout.this.f4989f.mo9825a(i, (float) BitmapDescriptorFactory.HUE_RED);
                SlidingTabLayout.this.m6050a(i, 0);
            }
            if (SlidingTabLayout.this.f4988e != null) {
                SlidingTabLayout.this.f4988e.onPageSelected(i);
            }
        }
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.ui.SlidingTabLayout$b */
    class C1542b implements View.OnClickListener {
        private C1542b() {
        }

        public void onClick(View view) {
            for (int i = 0; i < SlidingTabLayout.this.f4989f.getChildCount(); i++) {
                if (view == SlidingTabLayout.this.f4989f.getChildAt(i)) {
                    SlidingTabLayout.this.f4987d.setCurrentItem(i);
                    return;
                }
            }
        }
    }
}
