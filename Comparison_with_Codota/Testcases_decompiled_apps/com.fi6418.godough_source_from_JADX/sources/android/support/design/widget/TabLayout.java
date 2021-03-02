package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.support.design.C0006g;
import android.support.design.C0007h;
import android.support.p000v4.view.PagerAdapter;
import android.support.p000v4.view.ViewCompat;
import android.support.p000v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.jackhenry.godough.core.accounts.AccountTransactionsFragment;
import java.util.ArrayList;
import java.util.Iterator;

public class TabLayout extends HorizontalScrollView {

    /* renamed from: a */
    private final ArrayList<C0022an> f87a;

    /* renamed from: b */
    private C0022an f88b;

    /* renamed from: c */
    private final C0019ak f89c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public int f90d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f91e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f92f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public int f93g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f94h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public ColorStateList f95i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public final int f96j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public final int f97k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public int f98l;

    /* renamed from: m */
    private final int f99m;

    /* renamed from: n */
    private int f100n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public int f101o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public int f102p;

    /* renamed from: q */
    private C0018aj f103q;

    /* renamed from: r */
    private View.OnClickListener f104r;

    /* renamed from: s */
    private C0026ar f105s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public C0026ar f106t;

    public TabLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public TabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f87a = new ArrayList<>();
        this.f98l = Integer.MAX_VALUE;
        setHorizontalScrollBarEnabled(false);
        setFillViewport(true);
        this.f89c = new C0019ak(this, context);
        addView(this.f89c, -2, -1);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0007h.TabLayout, i, C0006g.Widget_Design_TabLayout);
        this.f89c.mo198b(obtainStyledAttributes.getDimensionPixelSize(C0007h.TabLayout_tabIndicatorHeight, 0));
        this.f89c.mo193a(obtainStyledAttributes.getColor(C0007h.TabLayout_tabIndicatorColor, 0));
        this.f94h = obtainStyledAttributes.getResourceId(C0007h.TabLayout_tabTextAppearance, C0006g.TextAppearance_Design_Tab);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(C0007h.TabLayout_tabPadding, 0);
        this.f93g = dimensionPixelSize;
        this.f92f = dimensionPixelSize;
        this.f91e = dimensionPixelSize;
        this.f90d = dimensionPixelSize;
        this.f90d = obtainStyledAttributes.getDimensionPixelSize(C0007h.TabLayout_tabPaddingStart, this.f90d);
        this.f91e = obtainStyledAttributes.getDimensionPixelSize(C0007h.TabLayout_tabPaddingTop, this.f91e);
        this.f92f = obtainStyledAttributes.getDimensionPixelSize(C0007h.TabLayout_tabPaddingEnd, this.f92f);
        this.f93g = obtainStyledAttributes.getDimensionPixelSize(C0007h.TabLayout_tabPaddingBottom, this.f93g);
        this.f95i = m152e(this.f94h);
        if (obtainStyledAttributes.hasValue(C0007h.TabLayout_tabTextColor)) {
            this.f95i = obtainStyledAttributes.getColorStateList(C0007h.TabLayout_tabTextColor);
        }
        if (obtainStyledAttributes.hasValue(C0007h.TabLayout_tabSelectedTextColor)) {
            this.f95i = m134a(this.f95i.getDefaultColor(), obtainStyledAttributes.getColor(C0007h.TabLayout_tabSelectedTextColor, 0));
        }
        this.f97k = obtainStyledAttributes.getDimensionPixelSize(C0007h.TabLayout_tabMinWidth, 0);
        this.f99m = obtainStyledAttributes.getDimensionPixelSize(C0007h.TabLayout_tabMaxWidth, 0);
        this.f96j = obtainStyledAttributes.getResourceId(C0007h.TabLayout_tabBackground, 0);
        this.f100n = obtainStyledAttributes.getDimensionPixelSize(C0007h.TabLayout_tabContentStart, 0);
        this.f102p = obtainStyledAttributes.getInt(C0007h.TabLayout_tabMode, 1);
        this.f101o = obtainStyledAttributes.getInt(C0007h.TabLayout_tabGravity, 0);
        obtainStyledAttributes.recycle();
        m153e();
    }

    /* renamed from: a */
    private int m132a(int i, float f) {
        int i2 = 0;
        if (this.f102p != 0) {
            return 0;
        }
        View childAt = this.f89c.getChildAt(i);
        View childAt2 = i + 1 < this.f89c.getChildCount() ? this.f89c.getChildAt(i + 1) : null;
        int width = childAt != null ? childAt.getWidth() : 0;
        if (childAt2 != null) {
            i2 = childAt2.getWidth();
        }
        return ((((int) ((((float) (i2 + width)) * f) * 0.5f)) + childAt.getLeft()) + (childAt.getWidth() / 2)) - (getWidth() / 2);
    }

    /* renamed from: a */
    private static ColorStateList m134a(int i, int i2) {
        return new ColorStateList(new int[][]{SELECTED_STATE_SET, EMPTY_STATE_SET}, new int[]{i2, i});
    }

    /* renamed from: a */
    private void m137a(C0022an anVar, int i) {
        anVar.mo206a(i);
        this.f87a.add(i, anVar);
        int size = this.f87a.size();
        for (int i2 = i + 1; i2 < size; i2++) {
            this.f87a.get(i2).mo206a(i2);
        }
    }

    /* renamed from: a */
    private void m138a(LinearLayout.LayoutParams layoutParams) {
        if (this.f102p == 1 && this.f101o == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
            return;
        }
        layoutParams.width = -2;
        layoutParams.weight = BitmapDescriptorFactory.HUE_RED;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m141b(int i) {
        C0024ap apVar = (C0024ap) this.f89c.getChildAt(i);
        if (apVar != null) {
            apVar.mo215a();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public int m142c(int i) {
        return Math.round(getResources().getDisplayMetrics().density * ((float) i));
    }

    /* renamed from: c */
    private C0024ap m145c(C0022an anVar) {
        C0024ap apVar = new C0024ap(this, getContext(), anVar);
        apVar.setFocusable(true);
        if (this.f104r == null) {
            this.f104r = new C0016ah(this);
        }
        apVar.setOnClickListener(this.f104r);
        return apVar;
    }

    /* renamed from: c */
    private void m146c() {
        int childCount = this.f89c.getChildCount();
        for (int i = 0; i < childCount; i++) {
            m141b(i);
        }
    }

    /* renamed from: c */
    private void m147c(C0022an anVar, boolean z) {
        C0024ap c = m145c(anVar);
        this.f89c.addView(c, m149d());
        if (z) {
            c.setSelected(true);
        }
    }

    /* renamed from: d */
    private LinearLayout.LayoutParams m149d() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        m138a(layoutParams);
        return layoutParams;
    }

    /* renamed from: d */
    private void m150d(int i) {
        if (i != -1) {
            if (getWindowToken() == null || !ViewCompat.isLaidOut(this) || this.f89c.mo196a()) {
                mo149a(i, BitmapDescriptorFactory.HUE_RED, true);
                return;
            }
            int scrollX = getScrollX();
            int a = m132a(i, (float) BitmapDescriptorFactory.HUE_RED);
            if (scrollX != a) {
                if (this.f105s == null) {
                    this.f105s = C0050bo.m298a();
                    this.f105s.mo228a(C0008a.f108b);
                    this.f105s.mo224a((int) AccountTransactionsFragment.NO_REFRESH);
                    this.f105s.mo227a((C0031aw) new C0017ai(this));
                }
                this.f105s.mo225a(scrollX, a);
                this.f105s.mo222a();
            }
            this.f89c.mo195a(i, (int) AccountTransactionsFragment.NO_REFRESH);
        }
    }

    /* renamed from: e */
    private ColorStateList m152e(int i) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(i, C0007h.TextAppearance);
        try {
            return obtainStyledAttributes.getColorStateList(C0007h.TextAppearance_android_textColor);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    /* renamed from: e */
    private void m153e() {
        ViewCompat.setPaddingRelative(this.f89c, this.f102p == 0 ? Math.max(0, this.f100n - this.f90d) : 0, 0, 0, 0);
        switch (this.f102p) {
            case 0:
                this.f89c.setGravity(8388611);
                break;
            case 1:
                this.f89c.setGravity(1);
                break;
        }
        m155f();
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m155f() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f89c.getChildCount()) {
                View childAt = this.f89c.getChildAt(i2);
                m138a((LinearLayout.LayoutParams) childAt.getLayoutParams());
                childAt.requestLayout();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private float getScrollPosition() {
        return this.f89c.mo197b();
    }

    private void setSelectedTabView(int i) {
        int childCount = this.f89c.getChildCount();
        if (i < childCount && !this.f89c.getChildAt(i).isSelected()) {
            int i2 = 0;
            while (i2 < childCount) {
                this.f89c.getChildAt(i2).setSelected(i2 == i);
                i2++;
            }
        }
    }

    /* renamed from: a */
    public C0022an mo147a() {
        return new C0022an(this);
    }

    /* renamed from: a */
    public C0022an mo148a(int i) {
        return this.f87a.get(i);
    }

    /* renamed from: a */
    public void mo149a(int i, float f, boolean z) {
        if ((this.f106t == null || !this.f106t.mo229b()) && i >= 0 && i < this.f89c.getChildCount()) {
            this.f89c.mo194a(i, f);
            scrollTo(m132a(i, f), 0);
            if (z) {
                setSelectedTabView(Math.round(((float) i) + f));
            }
        }
    }

    /* renamed from: a */
    public void mo150a(C0022an anVar) {
        mo151a(anVar, this.f87a.isEmpty());
    }

    /* renamed from: a */
    public void mo151a(C0022an anVar, boolean z) {
        if (anVar.f144f != this) {
            throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
        }
        m147c(anVar, z);
        m137a(anVar, this.f87a.size());
        if (z) {
            anVar.mo210e();
        }
    }

    /* renamed from: b */
    public void mo152b() {
        this.f89c.removeAllViews();
        Iterator<C0022an> it = this.f87a.iterator();
        while (it.hasNext()) {
            it.next().mo206a(-1);
            it.remove();
        }
        this.f88b = null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo153b(C0022an anVar) {
        mo154b(anVar, true);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo154b(C0022an anVar, boolean z) {
        if (this.f88b != anVar) {
            int c = anVar != null ? anVar.mo208c() : -1;
            setSelectedTabView(c);
            if (z) {
                if ((this.f88b == null || this.f88b.mo208c() == -1) && c != -1) {
                    mo149a(c, BitmapDescriptorFactory.HUE_RED, true);
                } else {
                    m150d(c);
                }
            }
            if (!(this.f88b == null || this.f103q == null)) {
                this.f103q.onTabUnselected(this.f88b);
            }
            this.f88b = anVar;
            if (this.f88b != null && this.f103q != null) {
                this.f103q.onTabSelected(this.f88b);
            }
        } else if (this.f88b != null) {
            if (this.f103q != null) {
                this.f103q.onTabReselected(this.f88b);
            }
            m150d(anVar.mo208c());
        }
    }

    public int getSelectedTabPosition() {
        if (this.f88b != null) {
            return this.f88b.mo208c();
        }
        return -1;
    }

    public int getTabCount() {
        return this.f87a.size();
    }

    public int getTabGravity() {
        return this.f101o;
    }

    public int getTabMode() {
        return this.f102p;
    }

    public ColorStateList getTabTextColors() {
        return this.f95i;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int c = m142c(48) + getPaddingTop() + getPaddingBottom();
        switch (View.MeasureSpec.getMode(i2)) {
            case Integer.MIN_VALUE:
                i2 = View.MeasureSpec.makeMeasureSpec(Math.min(c, View.MeasureSpec.getSize(i2)), 1073741824);
                break;
            case 0:
                i2 = View.MeasureSpec.makeMeasureSpec(c, 1073741824);
                break;
        }
        super.onMeasure(i, i2);
        if (this.f102p == 1 && getChildCount() == 1) {
            View childAt = getChildAt(0);
            int measuredWidth = getMeasuredWidth();
            if (childAt.getMeasuredWidth() > measuredWidth) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom(), childAt.getLayoutParams().height));
            }
        }
        int i3 = this.f99m;
        int measuredWidth2 = getMeasuredWidth() - m142c(56);
        if (i3 == 0 || i3 > measuredWidth2) {
            i3 = measuredWidth2;
        }
        if (this.f98l != i3) {
            this.f98l = i3;
            super.onMeasure(i, i2);
        }
    }

    public void setOnTabSelectedListener(C0018aj ajVar) {
        this.f103q = ajVar;
    }

    public void setSelectedTabIndicatorColor(int i) {
        this.f89c.mo193a(i);
    }

    public void setSelectedTabIndicatorHeight(int i) {
        this.f89c.mo198b(i);
    }

    public void setTabGravity(int i) {
        if (this.f101o != i) {
            this.f101o = i;
            m153e();
        }
    }

    public void setTabMode(int i) {
        if (i != this.f102p) {
            this.f102p = i;
            m153e();
        }
    }

    public void setTabTextColors(ColorStateList colorStateList) {
        if (this.f95i != colorStateList) {
            this.f95i = colorStateList;
            m146c();
        }
    }

    public void setTabsFromPagerAdapter(PagerAdapter pagerAdapter) {
        mo152b();
        int count = pagerAdapter.getCount();
        for (int i = 0; i < count; i++) {
            mo150a(mo147a().mo204a(pagerAdapter.getPageTitle(i)));
        }
    }

    public void setupWithViewPager(ViewPager viewPager) {
        int currentItem;
        PagerAdapter adapter = viewPager.getAdapter();
        if (adapter == null) {
            throw new IllegalArgumentException("ViewPager does not have a PagerAdapter set");
        }
        setTabsFromPagerAdapter(adapter);
        viewPager.addOnPageChangeListener(new C0023ao(this));
        setOnTabSelectedListener(new C0025aq(viewPager));
        if (adapter.getCount() > 0 && getSelectedTabPosition() != (currentItem = viewPager.getCurrentItem())) {
            mo153b(mo148a(currentItem));
        }
    }
}
