package android.support.p000v4.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.p000v4.view.ViewPager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.lang.ref.WeakReference;

/* renamed from: android.support.v4.view.PagerTitleStrip */
public class PagerTitleStrip extends ViewGroup implements ViewPager.Decor {

    /* renamed from: n */
    private static final int[] f1220n = {16842804, 16842901, 16842904, 16842927};

    /* renamed from: o */
    private static final int[] f1221o = {16843660};

    /* renamed from: q */
    private static final PagerTitleStripImpl f1222q;

    /* renamed from: a */
    ViewPager f1223a;

    /* renamed from: b */
    TextView f1224b;

    /* renamed from: c */
    TextView f1225c;

    /* renamed from: d */
    TextView f1226d;

    /* renamed from: e */
    int f1227e;

    /* renamed from: f */
    private int f1228f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public float f1229g;

    /* renamed from: h */
    private int f1230h;

    /* renamed from: i */
    private int f1231i;

    /* renamed from: j */
    private boolean f1232j;

    /* renamed from: k */
    private boolean f1233k;

    /* renamed from: l */
    private final PageListener f1234l;

    /* renamed from: m */
    private WeakReference<PagerAdapter> f1235m;

    /* renamed from: p */
    private int f1236p;

    /* renamed from: android.support.v4.view.PagerTitleStrip$PageListener */
    class PageListener extends DataSetObserver implements ViewPager.OnAdapterChangeListener, ViewPager.OnPageChangeListener {

        /* renamed from: b */
        private int f1238b;

        private PageListener() {
        }

        public void onAdapterChanged(PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2) {
            PagerTitleStrip.this.mo2272a(pagerAdapter, pagerAdapter2);
        }

        public void onChanged() {
            float f = BitmapDescriptorFactory.HUE_RED;
            PagerTitleStrip.this.mo2271a(PagerTitleStrip.this.f1223a.getCurrentItem(), PagerTitleStrip.this.f1223a.getAdapter());
            if (PagerTitleStrip.this.f1229g >= BitmapDescriptorFactory.HUE_RED) {
                f = PagerTitleStrip.this.f1229g;
            }
            PagerTitleStrip.this.mo2255a(PagerTitleStrip.this.f1223a.getCurrentItem(), f, true);
        }

        public void onPageScrollStateChanged(int i) {
            this.f1238b = i;
        }

        public void onPageScrolled(int i, float f, int i2) {
            if (f > 0.5f) {
                i++;
            }
            PagerTitleStrip.this.mo2255a(i, f, false);
        }

        public void onPageSelected(int i) {
            float f = BitmapDescriptorFactory.HUE_RED;
            if (this.f1238b == 0) {
                PagerTitleStrip.this.mo2271a(PagerTitleStrip.this.f1223a.getCurrentItem(), PagerTitleStrip.this.f1223a.getAdapter());
                if (PagerTitleStrip.this.f1229g >= BitmapDescriptorFactory.HUE_RED) {
                    f = PagerTitleStrip.this.f1229g;
                }
                PagerTitleStrip.this.mo2255a(PagerTitleStrip.this.f1223a.getCurrentItem(), f, true);
            }
        }
    }

    /* renamed from: android.support.v4.view.PagerTitleStrip$PagerTitleStripImpl */
    interface PagerTitleStripImpl {
        void setSingleLineAllCaps(TextView textView);
    }

    /* renamed from: android.support.v4.view.PagerTitleStrip$PagerTitleStripImplBase */
    class PagerTitleStripImplBase implements PagerTitleStripImpl {
        PagerTitleStripImplBase() {
        }

        public void setSingleLineAllCaps(TextView textView) {
            textView.setSingleLine();
        }
    }

    /* renamed from: android.support.v4.view.PagerTitleStrip$PagerTitleStripImplIcs */
    class PagerTitleStripImplIcs implements PagerTitleStripImpl {
        PagerTitleStripImplIcs() {
        }

        public void setSingleLineAllCaps(TextView textView) {
            PagerTitleStripIcs.setSingleLineAllCaps(textView);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 14) {
            f1222q = new PagerTitleStripImplIcs();
        } else {
            f1222q = new PagerTitleStripImplBase();
        }
    }

    public PagerTitleStrip(Context context) {
        this(context, (AttributeSet) null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PagerTitleStrip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        boolean z = false;
        this.f1228f = -1;
        this.f1229g = -1.0f;
        this.f1234l = new PageListener();
        TextView textView = new TextView(context);
        this.f1224b = textView;
        addView(textView);
        TextView textView2 = new TextView(context);
        this.f1225c = textView2;
        addView(textView2);
        TextView textView3 = new TextView(context);
        this.f1226d = textView3;
        addView(textView3);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f1220n);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            this.f1224b.setTextAppearance(context, resourceId);
            this.f1225c.setTextAppearance(context, resourceId);
            this.f1226d.setTextAppearance(context, resourceId);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        if (dimensionPixelSize != 0) {
            setTextSize(0, (float) dimensionPixelSize);
        }
        if (obtainStyledAttributes.hasValue(2)) {
            int color = obtainStyledAttributes.getColor(2, 0);
            this.f1224b.setTextColor(color);
            this.f1225c.setTextColor(color);
            this.f1226d.setTextColor(color);
        }
        this.f1231i = obtainStyledAttributes.getInteger(3, 80);
        obtainStyledAttributes.recycle();
        this.f1227e = this.f1225c.getTextColors().getDefaultColor();
        setNonPrimaryAlpha(0.6f);
        this.f1224b.setEllipsize(TextUtils.TruncateAt.END);
        this.f1225c.setEllipsize(TextUtils.TruncateAt.END);
        this.f1226d.setEllipsize(TextUtils.TruncateAt.END);
        if (resourceId != 0) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(resourceId, f1221o);
            z = obtainStyledAttributes2.getBoolean(0, false);
            obtainStyledAttributes2.recycle();
        }
        if (z) {
            setSingleLineAllCaps(this.f1224b);
            setSingleLineAllCaps(this.f1225c);
            setSingleLineAllCaps(this.f1226d);
        } else {
            this.f1224b.setSingleLine();
            this.f1225c.setSingleLine();
            this.f1226d.setSingleLine();
        }
        this.f1230h = (int) (context.getResources().getDisplayMetrics().density * 16.0f);
    }

    private static void setSingleLineAllCaps(TextView textView) {
        f1222q.setSingleLineAllCaps(textView);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2255a(int i, float f, boolean z) {
        int i2;
        int i3;
        int i4;
        if (i != this.f1228f) {
            mo2271a(i, this.f1223a.getAdapter());
        } else if (!z && f == this.f1229g) {
            return;
        }
        this.f1233k = true;
        int measuredWidth = this.f1224b.getMeasuredWidth();
        int measuredWidth2 = this.f1225c.getMeasuredWidth();
        int measuredWidth3 = this.f1226d.getMeasuredWidth();
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
        int baseline = this.f1224b.getBaseline();
        int baseline2 = this.f1225c.getBaseline();
        int baseline3 = this.f1226d.getBaseline();
        int max = Math.max(Math.max(baseline, baseline2), baseline3);
        int i10 = max - baseline;
        int i11 = max - baseline2;
        int i12 = max - baseline3;
        int max2 = Math.max(Math.max(this.f1224b.getMeasuredHeight() + i10, this.f1225c.getMeasuredHeight() + i11), this.f1226d.getMeasuredHeight() + i12);
        switch (this.f1231i & 112) {
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
        this.f1225c.layout(i8, i3, i9, this.f1225c.getMeasuredHeight() + i3);
        int min = Math.min(paddingLeft, (i8 - this.f1230h) - measuredWidth);
        this.f1224b.layout(min, i2, measuredWidth + min, this.f1224b.getMeasuredHeight() + i2);
        int max3 = Math.max((width - paddingRight) - measuredWidth3, this.f1230h + i9);
        this.f1226d.layout(max3, i4, max3 + measuredWidth3, this.f1226d.getMeasuredHeight() + i4);
        this.f1229g = f;
        this.f1233k = false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2271a(int i, PagerAdapter pagerAdapter) {
        CharSequence charSequence = null;
        int count = pagerAdapter != null ? pagerAdapter.getCount() : 0;
        this.f1232j = true;
        this.f1224b.setText((i < 1 || pagerAdapter == null) ? null : pagerAdapter.getPageTitle(i - 1));
        this.f1225c.setText((pagerAdapter == null || i >= count) ? null : pagerAdapter.getPageTitle(i));
        if (i + 1 < count && pagerAdapter != null) {
            charSequence = pagerAdapter.getPageTitle(i + 1);
        }
        this.f1226d.setText(charSequence);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.max(0, (int) (((float) ((getWidth() - getPaddingLeft()) - getPaddingRight())) * 0.8f)), Integer.MIN_VALUE);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(Math.max(0, (getHeight() - getPaddingTop()) - getPaddingBottom()), Integer.MIN_VALUE);
        this.f1224b.measure(makeMeasureSpec, makeMeasureSpec2);
        this.f1225c.measure(makeMeasureSpec, makeMeasureSpec2);
        this.f1226d.measure(makeMeasureSpec, makeMeasureSpec2);
        this.f1228f = i;
        if (!this.f1233k) {
            mo2255a(i, this.f1229g, false);
        }
        this.f1232j = false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2272a(PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2) {
        if (pagerAdapter != null) {
            pagerAdapter.unregisterDataSetObserver(this.f1234l);
            this.f1235m = null;
        }
        if (pagerAdapter2 != null) {
            pagerAdapter2.registerDataSetObserver(this.f1234l);
            this.f1235m = new WeakReference<>(pagerAdapter2);
        }
        if (this.f1223a != null) {
            this.f1228f = -1;
            this.f1229g = -1.0f;
            mo2271a(this.f1223a.getCurrentItem(), pagerAdapter2);
            requestLayout();
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

    public int getTextSpacing() {
        return this.f1230h;
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
        viewPager.mo2420a((ViewPager.OnPageChangeListener) this.f1234l);
        viewPager.setOnAdapterChangeListener(this.f1234l);
        this.f1223a = viewPager;
        mo2272a(this.f1235m != null ? (PagerAdapter) this.f1235m.get() : null, adapter);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f1223a != null) {
            mo2272a(this.f1223a.getAdapter(), (PagerAdapter) null);
            this.f1223a.mo2420a((ViewPager.OnPageChangeListener) null);
            this.f1223a.setOnAdapterChangeListener((ViewPager.OnAdapterChangeListener) null);
            this.f1223a = null;
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        float f = BitmapDescriptorFactory.HUE_RED;
        if (this.f1223a != null) {
            if (this.f1229g >= BitmapDescriptorFactory.HUE_RED) {
                f = this.f1229g;
            }
            mo2255a(this.f1228f, f, true);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode != 1073741824) {
            throw new IllegalStateException("Must measure with an exact width");
        }
        int minHeight = getMinHeight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.max(0, (int) (((float) size) * 0.8f)), Integer.MIN_VALUE);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(Math.min(0, size2 - paddingTop), Integer.MIN_VALUE);
        this.f1224b.measure(makeMeasureSpec, makeMeasureSpec2);
        this.f1225c.measure(makeMeasureSpec, makeMeasureSpec2);
        this.f1226d.measure(makeMeasureSpec, makeMeasureSpec2);
        if (mode2 == 1073741824) {
            setMeasuredDimension(size, size2);
        } else {
            setMeasuredDimension(size, Math.max(minHeight, this.f1225c.getMeasuredHeight() + paddingTop));
        }
    }

    public void requestLayout() {
        if (!this.f1232j) {
            super.requestLayout();
        }
    }

    public void setGravity(int i) {
        this.f1231i = i;
        requestLayout();
    }

    public void setNonPrimaryAlpha(float f) {
        this.f1236p = ((int) (255.0f * f)) & 255;
        int i = (this.f1236p << 24) | (this.f1227e & ViewCompat.MEASURED_SIZE_MASK);
        this.f1224b.setTextColor(i);
        this.f1226d.setTextColor(i);
    }

    public void setTextColor(int i) {
        this.f1227e = i;
        this.f1225c.setTextColor(i);
        int i2 = (this.f1236p << 24) | (this.f1227e & ViewCompat.MEASURED_SIZE_MASK);
        this.f1224b.setTextColor(i2);
        this.f1226d.setTextColor(i2);
    }

    public void setTextSize(int i, float f) {
        this.f1224b.setTextSize(i, f);
        this.f1225c.setTextSize(i, f);
        this.f1226d.setTextSize(i, f);
    }

    public void setTextSpacing(int i) {
        this.f1230h = i;
        requestLayout();
    }
}
