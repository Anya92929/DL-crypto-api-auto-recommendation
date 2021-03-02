package android.support.p003v7.internal.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.p000v4.graphics.drawable.DrawableCompat;
import android.support.p003v7.graphics.drawable.DrawableWrapper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.lang.reflect.Field;

/* renamed from: android.support.v7.internal.widget.ListViewCompat */
public class ListViewCompat extends ListView {
    public static final int INVALID_POSITION = -1;
    public static final int NO_POSITION = -1;

    /* renamed from: f */
    private static final int[] f2322f = {0};

    /* renamed from: a */
    final Rect f2323a;

    /* renamed from: b */
    int f2324b;

    /* renamed from: c */
    int f2325c;

    /* renamed from: d */
    int f2326d;

    /* renamed from: e */
    int f2327e;

    /* renamed from: g */
    private Field f2328g;

    /* renamed from: h */
    private GateKeeperDrawable f2329h;

    /* renamed from: android.support.v7.internal.widget.ListViewCompat$GateKeeperDrawable */
    class GateKeeperDrawable extends DrawableWrapper {

        /* renamed from: a */
        private boolean f2330a = true;

        public GateKeeperDrawable(Drawable drawable) {
            super(drawable);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo4585a(boolean z) {
            this.f2330a = z;
        }

        public void draw(Canvas canvas) {
            if (this.f2330a) {
                super.draw(canvas);
            }
        }

        public void setHotspot(float f, float f2) {
            if (this.f2330a) {
                super.setHotspot(f, f2);
            }
        }

        public void setHotspotBounds(int i, int i2, int i3, int i4) {
            if (this.f2330a) {
                super.setHotspotBounds(i, i2, i3, i4);
            }
        }

        public boolean setState(int[] iArr) {
            if (this.f2330a) {
                return super.setState(iArr);
            }
            return false;
        }

        public boolean setVisible(boolean z, boolean z2) {
            if (this.f2330a) {
                return super.setVisible(z, z2);
            }
            return false;
        }
    }

    public ListViewCompat(Context context) {
        this(context, (AttributeSet) null);
    }

    public ListViewCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ListViewCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2323a = new Rect();
        this.f2324b = 0;
        this.f2325c = 0;
        this.f2326d = 0;
        this.f2327e = 0;
        try {
            this.f2328g = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
            this.f2328g.setAccessible(true);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4572a() {
        Drawable selector = getSelector();
        if (selector != null && mo4577b()) {
            selector.setState(getDrawableState());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4573a(int i, View view) {
        boolean z = true;
        Drawable selector = getSelector();
        boolean z2 = (selector == null || i == -1) ? false : true;
        if (z2) {
            selector.setVisible(false, false);
        }
        mo4576b(i, view);
        if (z2) {
            Rect rect = this.f2323a;
            float exactCenterX = rect.exactCenterX();
            float exactCenterY = rect.exactCenterY();
            if (getVisibility() != 0) {
                z = false;
            }
            selector.setVisible(z, false);
            DrawableCompat.setHotspot(selector, exactCenterX, exactCenterY);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4574a(int i, View view, float f, float f2) {
        mo4573a(i, view);
        Drawable selector = getSelector();
        if (selector != null && i != -1) {
            DrawableCompat.setHotspot(selector, f, f2);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4575a(Canvas canvas) {
        Drawable selector;
        if (!this.f2323a.isEmpty() && (selector = getSelector()) != null) {
            selector.setBounds(this.f2323a);
            selector.draw(canvas);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo4576b(int i, View view) {
        Rect rect = this.f2323a;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        rect.left -= this.f2324b;
        rect.top -= this.f2325c;
        rect.right += this.f2326d;
        rect.bottom += this.f2327e;
        try {
            boolean z = this.f2328g.getBoolean(this);
            if (view.isEnabled() != z) {
                this.f2328g.set(this, Boolean.valueOf(!z));
                if (i != -1) {
                    refreshDrawableState();
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public boolean mo4577b() {
        return mo4578c() && isPressed();
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public boolean mo4578c() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        mo4575a(canvas);
        super.dispatchDraw(canvas);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        setSelectorEnabled(true);
        mo4572a();
    }

    public int lookForSelectablePosition(int i, boolean z) {
        int i2;
        ListAdapter adapter = getAdapter();
        if (adapter == null || isInTouchMode()) {
            return -1;
        }
        int count = adapter.getCount();
        if (!getAdapter().areAllItemsEnabled()) {
            if (z) {
                i2 = Math.max(0, i);
                while (i2 < count && !adapter.isEnabled(i2)) {
                    i2++;
                }
            } else {
                int min = Math.min(i, count - 1);
                while (i2 >= 0 && !adapter.isEnabled(i2)) {
                    min = i2 - 1;
                }
            }
            if (i2 < 0 || i2 >= count) {
                return -1;
            }
            return i2;
        } else if (i < 0 || i >= count) {
            return -1;
        } else {
            return i;
        }
    }

    public int measureHeightOfChildrenCompat(int i, int i2, int i3, int i4, int i5) {
        View view;
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        getListPaddingLeft();
        getListPaddingRight();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        int i6 = listPaddingBottom + listPaddingTop;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int i7 = 0;
        View view2 = null;
        int i8 = 0;
        int count = adapter.getCount();
        int i9 = 0;
        while (i9 < count) {
            int itemViewType = adapter.getItemViewType(i9);
            if (itemViewType != i8) {
                int i10 = itemViewType;
                view = null;
                i8 = i10;
            } else {
                view = view2;
            }
            view2 = adapter.getView(i9, view, this);
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            view2.measure(i, (layoutParams == null || layoutParams.height <= 0) ? View.MeasureSpec.makeMeasureSpec(0, 0) : View.MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824));
            int measuredHeight = (i9 > 0 ? i6 + dividerHeight : i6) + view2.getMeasuredHeight();
            if (measuredHeight >= i4) {
                return (i5 < 0 || i9 <= i5 || i7 <= 0 || measuredHeight == i4) ? i4 : i7;
            }
            if (i5 >= 0 && i9 >= i5) {
                i7 = measuredHeight;
            }
            i9++;
            i6 = measuredHeight;
        }
        return i6;
    }

    public void setSelector(Drawable drawable) {
        this.f2329h = drawable != null ? new GateKeeperDrawable(drawable) : null;
        super.setSelector(this.f2329h);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f2324b = rect.left;
        this.f2325c = rect.top;
        this.f2326d = rect.right;
        this.f2327e = rect.bottom;
    }

    /* access modifiers changed from: protected */
    public void setSelectorEnabled(boolean z) {
        if (this.f2329h != null) {
            this.f2329h.mo4585a(z);
        }
    }
}
