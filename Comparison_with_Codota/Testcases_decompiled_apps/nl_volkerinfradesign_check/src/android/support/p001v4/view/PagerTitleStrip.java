package android.support.p001v4.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.annotation.FloatRange;
import android.support.p001v4.view.ViewPager;
import android.support.p001v4.widget.ExploreByTouchHelper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.lang.ref.WeakReference;

/* renamed from: android.support.v4.view.PagerTitleStrip */
public class PagerTitleStrip extends ViewGroup implements ViewPager.C0335a {

    /* renamed from: n */
    private static final int[] f961n = {16842804, 16842901, 16842904, 16842927};

    /* renamed from: o */
    private static final int[] f962o = {16843660};

    /* renamed from: q */
    private static final C0297b f963q;

    /* renamed from: a */
    ViewPager f964a;

    /* renamed from: b */
    TextView f965b;

    /* renamed from: c */
    TextView f966c;

    /* renamed from: d */
    TextView f967d;

    /* renamed from: e */
    int f968e;

    /* renamed from: f */
    private int f969f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public float f970g;

    /* renamed from: h */
    private int f971h;

    /* renamed from: i */
    private int f972i;

    /* renamed from: j */
    private boolean f973j;

    /* renamed from: k */
    private boolean f974k;

    /* renamed from: l */
    private final C0296a f975l;

    /* renamed from: m */
    private WeakReference<PagerAdapter> f976m;

    /* renamed from: p */
    private int f977p;

    /* renamed from: android.support.v4.view.PagerTitleStrip$b */
    interface C0297b {
        /* renamed from: a */
        void mo1875a(TextView textView);
    }

    static {
        if (Build.VERSION.SDK_INT >= 14) {
            f963q = new C0299d();
        } else {
            f963q = new C0298c();
        }
    }

    /* renamed from: android.support.v4.view.PagerTitleStrip$c */
    static class C0298c implements C0297b {
        C0298c() {
        }

        /* renamed from: a */
        public void mo1875a(TextView textView) {
            textView.setSingleLine();
        }
    }

    /* renamed from: android.support.v4.view.PagerTitleStrip$d */
    static class C0299d implements C0297b {
        C0299d() {
        }

        /* renamed from: a */
        public void mo1875a(TextView textView) {
            C1042de.m4640a(textView);
        }
    }

    private static void setSingleLineAllCaps(TextView textView) {
        f963q.mo1875a(textView);
    }

    public PagerTitleStrip(Context context) {
        this(context, (AttributeSet) null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PagerTitleStrip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        boolean z = false;
        this.f969f = -1;
        this.f970g = -1.0f;
        this.f975l = new C0296a();
        TextView textView = new TextView(context);
        this.f965b = textView;
        addView(textView);
        TextView textView2 = new TextView(context);
        this.f966c = textView2;
        addView(textView2);
        TextView textView3 = new TextView(context);
        this.f967d = textView3;
        addView(textView3);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f961n);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            this.f965b.setTextAppearance(context, resourceId);
            this.f966c.setTextAppearance(context, resourceId);
            this.f967d.setTextAppearance(context, resourceId);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        if (dimensionPixelSize != 0) {
            setTextSize(0, (float) dimensionPixelSize);
        }
        if (obtainStyledAttributes.hasValue(2)) {
            int color = obtainStyledAttributes.getColor(2, 0);
            this.f965b.setTextColor(color);
            this.f966c.setTextColor(color);
            this.f967d.setTextColor(color);
        }
        this.f972i = obtainStyledAttributes.getInteger(3, 80);
        obtainStyledAttributes.recycle();
        this.f968e = this.f966c.getTextColors().getDefaultColor();
        setNonPrimaryAlpha(0.6f);
        this.f965b.setEllipsize(TextUtils.TruncateAt.END);
        this.f966c.setEllipsize(TextUtils.TruncateAt.END);
        this.f967d.setEllipsize(TextUtils.TruncateAt.END);
        if (resourceId != 0) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(resourceId, f962o);
            z = obtainStyledAttributes2.getBoolean(0, false);
            obtainStyledAttributes2.recycle();
        }
        if (z) {
            setSingleLineAllCaps(this.f965b);
            setSingleLineAllCaps(this.f966c);
            setSingleLineAllCaps(this.f967d);
        } else {
            this.f965b.setSingleLine();
            this.f966c.setSingleLine();
            this.f967d.setSingleLine();
        }
        this.f971h = (int) (context.getResources().getDisplayMetrics().density * 16.0f);
    }

    public void setTextSpacing(int i) {
        this.f971h = i;
        requestLayout();
    }

    public int getTextSpacing() {
        return this.f971h;
    }

    public void setNonPrimaryAlpha(@FloatRange(from = 0.0d, mo4to = 1.0d) float f) {
        this.f977p = ((int) (255.0f * f)) & 255;
        int i = (this.f977p << 24) | (this.f968e & ViewCompat.MEASURED_SIZE_MASK);
        this.f965b.setTextColor(i);
        this.f967d.setTextColor(i);
    }

    public void setTextColor(@ColorInt int i) {
        this.f968e = i;
        this.f966c.setTextColor(i);
        int i2 = (this.f977p << 24) | (this.f968e & ViewCompat.MEASURED_SIZE_MASK);
        this.f965b.setTextColor(i2);
        this.f967d.setTextColor(i2);
    }

    public void setTextSize(int i, float f) {
        this.f965b.setTextSize(i, f);
        this.f966c.setTextSize(i, f);
        this.f967d.setTextSize(i, f);
    }

    public void setGravity(int i) {
        this.f972i = i;
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (!(parent instanceof ViewPager)) {
            throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
        }
        ViewPager viewPager = (ViewPager) parent;
        PagerAdapter adapter = viewPager.getAdapter();
        viewPager.mo2009a((ViewPager.OnPageChangeListener) this.f975l);
        viewPager.setOnAdapterChangeListener(this.f975l);
        this.f964a = viewPager;
        mo1859a(this.f976m != null ? (PagerAdapter) this.f976m.get() : null, adapter);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f964a != null) {
            mo1859a(this.f964a.getAdapter(), (PagerAdapter) null);
            this.f964a.mo2009a((ViewPager.OnPageChangeListener) null);
            this.f964a.setOnAdapterChangeListener((ViewPager.C0338d) null);
            this.f964a = null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo1858a(int i, PagerAdapter pagerAdapter) {
        CharSequence charSequence;
        CharSequence charSequence2;
        CharSequence charSequence3 = null;
        int count = pagerAdapter != null ? pagerAdapter.getCount() : 0;
        this.f973j = true;
        if (i < 1 || pagerAdapter == null) {
            charSequence = null;
        } else {
            charSequence = pagerAdapter.getPageTitle(i - 1);
        }
        this.f965b.setText(charSequence);
        TextView textView = this.f966c;
        if (pagerAdapter == null || i >= count) {
            charSequence2 = null;
        } else {
            charSequence2 = pagerAdapter.getPageTitle(i);
        }
        textView.setText(charSequence2);
        if (i + 1 < count && pagerAdapter != null) {
            charSequence3 = pagerAdapter.getPageTitle(i + 1);
        }
        this.f967d.setText(charSequence3);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.max(0, (int) (((float) ((getWidth() - getPaddingLeft()) - getPaddingRight())) * 0.8f)), ExploreByTouchHelper.INVALID_ID);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(Math.max(0, (getHeight() - getPaddingTop()) - getPaddingBottom()), ExploreByTouchHelper.INVALID_ID);
        this.f965b.measure(makeMeasureSpec, makeMeasureSpec2);
        this.f966c.measure(makeMeasureSpec, makeMeasureSpec2);
        this.f967d.measure(makeMeasureSpec, makeMeasureSpec2);
        this.f969f = i;
        if (!this.f974k) {
            mo1842a(i, this.f970g, false);
        }
        this.f973j = false;
    }

    public void requestLayout() {
        if (!this.f973j) {
            super.requestLayout();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo1859a(PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2) {
        if (pagerAdapter != null) {
            pagerAdapter.unregisterDataSetObserver(this.f975l);
            this.f976m = null;
        }
        if (pagerAdapter2 != null) {
            pagerAdapter2.registerDataSetObserver(this.f975l);
            this.f976m = new WeakReference<>(pagerAdapter2);
        }
        if (this.f964a != null) {
            this.f969f = -1;
            this.f970g = -1.0f;
            mo1858a(this.f964a.getCurrentItem(), pagerAdapter2);
            requestLayout();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo1842a(int i, float f, boolean z) {
        int i2;
        int i3;
        int i4;
        if (i != this.f969f) {
            mo1858a(i, this.f964a.getAdapter());
        } else if (!z && f == this.f970g) {
            return;
        }
        this.f974k = true;
        int measuredWidth = this.f965b.getMeasuredWidth();
        int measuredWidth2 = this.f966c.getMeasuredWidth();
        int measuredWidth3 = this.f967d.getMeasuredWidth();
        int i5 = measuredWidth2 / 2;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i6 = paddingRight + i5;
        int i7 = (width - (paddingLeft + i5)) - i6;
        float f2 = 0.5f + f;
        if (f2 > 1.0f) {
            f2 -= 1.0f;
        }
        int i8 = ((width - i6) - ((int) (f2 * ((float) i7)))) - (measuredWidth2 / 2);
        int i9 = i8 + measuredWidth2;
        int baseline = this.f965b.getBaseline();
        int baseline2 = this.f966c.getBaseline();
        int baseline3 = this.f967d.getBaseline();
        int max = Math.max(Math.max(baseline, baseline2), baseline3);
        int i10 = max - baseline;
        int i11 = max - baseline2;
        int i12 = max - baseline3;
        int max2 = Math.max(Math.max(this.f965b.getMeasuredHeight() + i10, this.f966c.getMeasuredHeight() + i11), this.f967d.getMeasuredHeight() + i12);
        switch (this.f972i & 112) {
            case 16:
                int i13 = (((height - paddingTop) - paddingBottom) - max2) / 2;
                i2 = i13 + i10;
                i3 = i11 + i13;
                i4 = i13 + i12;
                break;
            case 80:
                int i14 = (height - paddingBottom) - max2;
                i2 = i14 + i10;
                i3 = i11 + i14;
                i4 = i14 + i12;
                break;
            default:
                i2 = paddingTop + i10;
                i3 = i11 + paddingTop;
                i4 = paddingTop + i12;
                break;
        }
        this.f966c.layout(i8, i3, i9, this.f966c.getMeasuredHeight() + i3);
        int min = Math.min(paddingLeft, (i8 - this.f971h) - measuredWidth);
        this.f965b.layout(min, i2, measuredWidth + min, this.f965b.getMeasuredHeight() + i2);
        int max3 = Math.max((width - paddingRight) - measuredWidth3, this.f971h + i9);
        this.f967d.layout(max3, i4, max3 + measuredWidth3, this.f967d.getMeasuredHeight() + i4);
        this.f970g = f;
        this.f974k = false;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int max;
        if (View.MeasureSpec.getMode(i) != 1073741824) {
            throw new IllegalStateException("Must measure with an exact width");
        }
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = getChildMeasureSpec(i2, paddingTop, -2);
        int size = View.MeasureSpec.getSize(i);
        int childMeasureSpec2 = getChildMeasureSpec(i, (int) (((float) size) * 0.2f), -2);
        this.f965b.measure(childMeasureSpec2, childMeasureSpec);
        this.f966c.measure(childMeasureSpec2, childMeasureSpec);
        this.f967d.measure(childMeasureSpec2, childMeasureSpec);
        if (View.MeasureSpec.getMode(i2) == 1073741824) {
            max = View.MeasureSpec.getSize(i2);
        } else {
            max = Math.max(getMinHeight(), paddingTop + this.f966c.getMeasuredHeight());
        }
        setMeasuredDimension(size, ViewCompat.resolveSizeAndState(max, i2, ViewCompat.getMeasuredState(this.f966c) << 16));
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        float f = BitmapDescriptorFactory.HUE_RED;
        if (this.f964a != null) {
            if (this.f970g >= BitmapDescriptorFactory.HUE_RED) {
                f = this.f970g;
            }
            mo1842a(this.f969f, f, true);
        }
    }

    /* access modifiers changed from: package-private */
    public int getMinHeight() {
        Drawable background = getBackground();
        if (background != null) {
            return background.getIntrinsicHeight();
        }
        return 0;
    }

    /* renamed from: android.support.v4.view.PagerTitleStrip$a */
    class C0296a extends DataSetObserver implements ViewPager.OnPageChangeListener, ViewPager.C0338d {

        /* renamed from: b */
        private int f979b;

        private C0296a() {
        }

        public void onPageScrolled(int i, float f, int i2) {
            if (f > 0.5f) {
                i++;
            }
            PagerTitleStrip.this.mo1842a(i, f, false);
        }

        public void onPageSelected(int i) {
            float f = BitmapDescriptorFactory.HUE_RED;
            if (this.f979b == 0) {
                PagerTitleStrip.this.mo1858a(PagerTitleStrip.this.f964a.getCurrentItem(), PagerTitleStrip.this.f964a.getAdapter());
                if (PagerTitleStrip.this.f970g >= BitmapDescriptorFactory.HUE_RED) {
                    f = PagerTitleStrip.this.f970g;
                }
                PagerTitleStrip.this.mo1842a(PagerTitleStrip.this.f964a.getCurrentItem(), f, true);
            }
        }

        public void onPageScrollStateChanged(int i) {
            this.f979b = i;
        }

        /* renamed from: a */
        public void mo1870a(PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2) {
            PagerTitleStrip.this.mo1859a(pagerAdapter, pagerAdapter2);
        }

        public void onChanged() {
            float f = BitmapDescriptorFactory.HUE_RED;
            PagerTitleStrip.this.mo1858a(PagerTitleStrip.this.f964a.getCurrentItem(), PagerTitleStrip.this.f964a.getAdapter());
            if (PagerTitleStrip.this.f970g >= BitmapDescriptorFactory.HUE_RED) {
                f = PagerTitleStrip.this.f970g;
            }
            PagerTitleStrip.this.mo1842a(PagerTitleStrip.this.f964a.getCurrentItem(), f, true);
        }
    }
}
