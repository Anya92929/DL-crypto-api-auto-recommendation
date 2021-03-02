package android.support.p004v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.p001v4.graphics.drawable.DrawableCompat;
import android.support.p004v7.graphics.drawable.DrawableWrapper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.lang.reflect.Field;

/* renamed from: android.support.v7.widget.ListViewCompat */
public class ListViewCompat extends ListView {
    public static final int INVALID_POSITION = -1;
    public static final int NO_POSITION = -1;

    /* renamed from: f */
    private static final int[] f2148f = {0};

    /* renamed from: a */
    final Rect f2149a;

    /* renamed from: b */
    int f2150b;

    /* renamed from: c */
    int f2151c;

    /* renamed from: d */
    int f2152d;

    /* renamed from: e */
    int f2153e;

    /* renamed from: g */
    private Field f2154g;

    /* renamed from: h */
    private C0564a f2155h;
    protected int mMotionPosition;

    public ListViewCompat(Context context) {
        this(context, (AttributeSet) null);
    }

    public ListViewCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ListViewCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2149a = new Rect();
        this.f2150b = 0;
        this.f2151c = 0;
        this.f2152d = 0;
        this.f2153e = 0;
        try {
            this.f2154g = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
            this.f2154g.setAccessible(true);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public void setSelector(Drawable drawable) {
        this.f2155h = drawable != null ? new C0564a(drawable) : null;
        super.setSelector(this.f2155h);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f2150b = rect.left;
        this.f2151c = rect.top;
        this.f2152d = rect.right;
        this.f2153e = rect.bottom;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        setSelectorEnabled(true);
        updateSelectorStateCompat();
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        drawSelectorCompat(canvas);
        super.dispatchDraw(canvas);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.mMotionPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    /* access modifiers changed from: protected */
    public void updateSelectorStateCompat() {
        Drawable selector = getSelector();
        if (selector != null && shouldShowSelectorCompat()) {
            selector.setState(getDrawableState());
        }
    }

    /* access modifiers changed from: protected */
    public boolean shouldShowSelectorCompat() {
        return touchModeDrawsInPressedStateCompat() && isPressed();
    }

    /* access modifiers changed from: protected */
    public boolean touchModeDrawsInPressedStateCompat() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void drawSelectorCompat(Canvas canvas) {
        Drawable selector;
        if (!this.f2149a.isEmpty() && (selector = getSelector()) != null) {
            selector.setBounds(this.f2149a);
            selector.draw(canvas);
        }
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

    /* access modifiers changed from: protected */
    public void positionSelectorLikeTouchCompat(int i, View view, float f, float f2) {
        positionSelectorLikeFocusCompat(i, view);
        Drawable selector = getSelector();
        if (selector != null && i != -1) {
            DrawableCompat.setHotspot(selector, f, f2);
        }
    }

    /* access modifiers changed from: protected */
    public void positionSelectorLikeFocusCompat(int i, View view) {
        boolean z = true;
        Drawable selector = getSelector();
        boolean z2 = (selector == null || i == -1) ? false : true;
        if (z2) {
            selector.setVisible(false, false);
        }
        positionSelectorCompat(i, view);
        if (z2) {
            Rect rect = this.f2149a;
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
    public void positionSelectorCompat(int i, View view) {
        Rect rect = this.f2149a;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        rect.left -= this.f2150b;
        rect.top -= this.f2151c;
        rect.right += this.f2152d;
        rect.bottom += this.f2153e;
        try {
            boolean z = this.f2154g.getBoolean(this);
            if (view.isEnabled() != z) {
                this.f2154g.set(this, Boolean.valueOf(!z));
                if (i != -1) {
                    refreshDrawableState();
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public int measureHeightOfChildrenCompat(int i, int i2, int i3, int i4, int i5) {
        View view;
        int makeMeasureSpec;
        int i6;
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
        int i7 = listPaddingBottom + listPaddingTop;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int i8 = 0;
        View view2 = null;
        int i9 = 0;
        int count = adapter.getCount();
        int i10 = 0;
        while (i10 < count) {
            int itemViewType = adapter.getItemViewType(i10);
            if (itemViewType != i9) {
                int i11 = itemViewType;
                view = null;
                i9 = i11;
            } else {
                view = view2;
            }
            view2 = adapter.getView(i10, view, this);
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view2.setLayoutParams(layoutParams);
            }
            if (layoutParams.height > 0) {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
            } else {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            }
            view2.measure(i, makeMeasureSpec);
            view2.forceLayout();
            if (i10 > 0) {
                i6 = i7 + dividerHeight;
            } else {
                i6 = i7;
            }
            int measuredHeight = i6 + view2.getMeasuredHeight();
            if (measuredHeight < i4) {
                if (i5 >= 0 && i10 >= i5) {
                    i8 = measuredHeight;
                }
                i10++;
                i7 = measuredHeight;
            } else if (i5 < 0 || i10 <= i5 || i8 <= 0 || measuredHeight == i4) {
                return i4;
            } else {
                return i8;
            }
        }
        return i7;
    }

    /* access modifiers changed from: protected */
    public void setSelectorEnabled(boolean z) {
        if (this.f2155h != null) {
            this.f2155h.mo4379a(z);
        }
    }

    /* renamed from: android.support.v7.widget.ListViewCompat$a */
    static class C0564a extends DrawableWrapper {

        /* renamed from: a */
        private boolean f2156a = true;

        public C0564a(Drawable drawable) {
            super(drawable);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo4379a(boolean z) {
            this.f2156a = z;
        }

        public boolean setState(int[] iArr) {
            if (this.f2156a) {
                return super.setState(iArr);
            }
            return false;
        }

        public void draw(Canvas canvas) {
            if (this.f2156a) {
                super.draw(canvas);
            }
        }

        public void setHotspot(float f, float f2) {
            if (this.f2156a) {
                super.setHotspot(f, f2);
            }
        }

        public void setHotspotBounds(int i, int i2, int i3, int i4) {
            if (this.f2156a) {
                super.setHotspotBounds(i, i2, i3, i4);
            }
        }

        public boolean setVisible(boolean z, boolean z2) {
            if (this.f2156a) {
                return super.setVisible(z, z2);
            }
            return false;
        }
    }
}
