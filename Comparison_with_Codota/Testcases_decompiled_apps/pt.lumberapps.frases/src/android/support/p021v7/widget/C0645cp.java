package android.support.p021v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.p009v4.p012b.p013a.C0095a;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.lang.reflect.Field;

/* renamed from: android.support.v7.widget.cp */
public class C0645cp extends ListView {

    /* renamed from: g */
    private static final int[] f1564g = {0};

    /* renamed from: a */
    final Rect f1565a = new Rect();

    /* renamed from: b */
    int f1566b = 0;

    /* renamed from: c */
    int f1567c = 0;

    /* renamed from: d */
    int f1568d = 0;

    /* renamed from: e */
    int f1569e = 0;

    /* renamed from: f */
    protected int f1570f;

    /* renamed from: h */
    private Field f1571h;

    /* renamed from: i */
    private C0646cq f1572i;

    public C0645cp(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        try {
            this.f1571h = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
            this.f1571h.setAccessible(true);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public int mo3204a(int i, int i2, int i3, int i4, int i5) {
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
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view2.setLayoutParams(layoutParams);
            }
            view2.measure(i, layoutParams.height > 0 ? View.MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0));
            view2.forceLayout();
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

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3205a(int i, View view) {
        boolean z = true;
        Drawable selector = getSelector();
        boolean z2 = (selector == null || i == -1) ? false : true;
        if (z2) {
            selector.setVisible(false, false);
        }
        mo3209b(i, view);
        if (z2) {
            Rect rect = this.f1565a;
            float exactCenterX = rect.exactCenterX();
            float exactCenterY = rect.exactCenterY();
            if (getVisibility() != 0) {
                z = false;
            }
            selector.setVisible(z, false);
            C0095a.m195a(selector, exactCenterX, exactCenterY);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3206a(int i, View view, float f, float f2) {
        mo3205a(i, view);
        Drawable selector = getSelector();
        if (selector != null && i != -1) {
            C0095a.m195a(selector, f, f2);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3207a(Canvas canvas) {
        Drawable selector;
        if (!this.f1565a.isEmpty() && (selector = getSelector()) != null) {
            selector.setBounds(this.f1565a);
            selector.draw(canvas);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo3114a() {
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo3208b() {
        Drawable selector = getSelector();
        if (selector != null && mo3210c()) {
            selector.setState(getDrawableState());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo3209b(int i, View view) {
        Rect rect = this.f1565a;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        rect.left -= this.f1566b;
        rect.top -= this.f1567c;
        rect.right += this.f1568d;
        rect.bottom += this.f1569e;
        try {
            boolean z = this.f1571h.getBoolean(this);
            if (view.isEnabled() != z) {
                this.f1571h.set(this, Boolean.valueOf(!z));
                if (i != -1) {
                    refreshDrawableState();
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public boolean mo3210c() {
        return mo3114a() && isPressed();
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        mo3207a(canvas);
        super.dispatchDraw(canvas);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        setSelectorEnabled(true);
        mo3208b();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.f1570f = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setSelector(Drawable drawable) {
        this.f1572i = drawable != null ? new C0646cq(drawable) : null;
        super.setSelector(this.f1572i);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f1566b = rect.left;
        this.f1567c = rect.top;
        this.f1568d = rect.right;
        this.f1569e = rect.bottom;
    }

    /* access modifiers changed from: protected */
    public void setSelectorEnabled(boolean z) {
        if (this.f1572i != null) {
            this.f1572i.mo3216a(z);
        }
    }
}
