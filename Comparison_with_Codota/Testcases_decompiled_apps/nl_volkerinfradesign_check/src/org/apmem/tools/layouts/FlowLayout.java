package org.apmem.tools.layouts;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.p001v4.internal.view.SupportMenu;
import android.support.p001v4.view.GravityCompat;
import android.support.p001v4.view.InputDeviceCompat;
import android.support.p001v4.widget.ExploreByTouchHelper;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class FlowLayout extends ViewGroup {
    public static final int HORIZONTAL = 0;
    public static final int LAYOUT_DIRECTION_LTR = 0;
    public static final int LAYOUT_DIRECTION_RTL = 1;
    public static final int VERTICAL = 1;

    /* renamed from: a */
    List<C1336jt> f7263a = new ArrayList();

    /* renamed from: b */
    private final LayoutConfiguration f7264b;

    public FlowLayout(Context context) {
        super(context);
        this.f7264b = new LayoutConfiguration(context, (AttributeSet) null);
    }

    public FlowLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7264b = new LayoutConfiguration(context, attributeSet);
    }

    public FlowLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f7264b = new LayoutConfiguration(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        C1336jt jtVar;
        int size = (View.MeasureSpec.getSize(i) - getPaddingRight()) - getPaddingLeft();
        int size2 = (View.MeasureSpec.getSize(i2) - getPaddingTop()) - getPaddingBottom();
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int i5 = this.f7264b.mo13686a() == 0 ? size : size2;
        if (this.f7264b.mo13686a() != 0) {
            size2 = size;
        }
        if (this.f7264b.mo13686a() != 0) {
            mode = mode2;
        }
        if (this.f7264b.mo13686a() == 0) {
        }
        this.f7263a.clear();
        C1336jt jtVar2 = new C1336jt(i5);
        this.f7263a.add(jtVar2);
        int childCount = getChildCount();
        int i6 = 0;
        while (i6 < childCount) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() == 8) {
                jtVar = jtVar2;
            } else {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                childAt.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), layoutParams.width), getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom(), layoutParams.height));
                int unused = layoutParams.f7274j = this.f7264b.mo13686a();
                if (this.f7264b.mo13686a() == 0) {
                    layoutParams.mo13669b(childAt.getMeasuredWidth());
                    layoutParams.mo13671c(childAt.getMeasuredHeight());
                } else {
                    layoutParams.mo13669b(childAt.getMeasuredHeight());
                    layoutParams.mo13671c(childAt.getMeasuredWidth());
                }
                if (layoutParams.isNewLine() || (mode != 0 && !jtVar2.mo8873b(childAt))) {
                    jtVar = new C1336jt(i5);
                    if (this.f7264b.mo13686a() == 1 && this.f7264b.mo13695e() == 1) {
                        this.f7263a.add(0, jtVar);
                    } else {
                        this.f7263a.add(jtVar);
                    }
                } else {
                    jtVar = jtVar2;
                }
                if (this.f7264b.mo13686a() == 0 && this.f7264b.mo13695e() == 1) {
                    jtVar.mo8869a(0, childAt);
                } else {
                    jtVar.mo8870a(childAt);
                }
            }
            i6++;
            jtVar2 = jtVar;
        }
        m7522a(this.f7263a);
        int size3 = this.f7263a.size();
        int i7 = 0;
        for (int i8 = 0; i8 < size3; i8++) {
            i7 = Math.max(i7, this.f7263a.get(i8).mo8874c());
        }
        int b = jtVar2.mo8871b() + jtVar2.mo8867a();
        m7523a(this.f7263a, m7519a(mode, i5, i7), m7519a(mode2, size2, b));
        for (int i9 = 0; i9 < size3; i9++) {
            C1336jt jtVar3 = this.f7263a.get(i9);
            m7528b(jtVar3);
            m7524a(jtVar3);
        }
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.f7264b.mo13686a() == 0) {
            i3 = paddingLeft + i7;
            i4 = paddingTop + b;
        } else {
            i3 = paddingLeft + b;
            i4 = paddingTop + i7;
        }
        setMeasuredDimension(resolveSize(i3, i), resolveSize(i4, i2));
    }

    /* renamed from: a */
    private int m7519a(int i, int i2, int i3) {
        switch (i) {
            case ExploreByTouchHelper.INVALID_ID:
                return Math.min(i3, i2);
            case 1073741824:
                return i2;
            default:
                return i3;
        }
    }

    /* renamed from: a */
    private void m7522a(List<C1336jt> list) {
        int size = list.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            C1336jt jtVar = list.get(i);
            jtVar.mo8868a(i2);
            int b = i2 + jtVar.mo8871b();
            List<View> e = jtVar.mo8878e();
            int size2 = e.size();
            int i3 = 0;
            for (int i4 = 0; i4 < size2; i4++) {
                LayoutParams layoutParams = (LayoutParams) e.get(i4).getLayoutParams();
                layoutParams.mo13666a(i3);
                i3 += layoutParams.mo13674e() + layoutParams.mo13668b();
            }
            i++;
            i2 = b;
        }
    }

    /* renamed from: a */
    private void m7524a(C1336jt jtVar) {
        List<View> e = jtVar.mo8878e();
        int size = e.size();
        for (int i = 0; i < size; i++) {
            View view = e.get(i);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (this.f7264b.mo13686a() == 0) {
                layoutParams.mo13667a(getPaddingLeft() + jtVar.mo8876d() + layoutParams.mo13665a(), getPaddingTop() + jtVar.mo8867a() + layoutParams.mo13672d());
                view.measure(View.MeasureSpec.makeMeasureSpec(layoutParams.mo13668b(), 1073741824), View.MeasureSpec.makeMeasureSpec(layoutParams.mo13670c(), 1073741824));
            } else {
                layoutParams.mo13667a(getPaddingLeft() + jtVar.mo8867a() + layoutParams.mo13672d(), getPaddingTop() + jtVar.mo8876d() + layoutParams.mo13665a());
                view.measure(View.MeasureSpec.makeMeasureSpec(layoutParams.mo13670c(), 1073741824), View.MeasureSpec.makeMeasureSpec(layoutParams.mo13668b(), 1073741824));
            }
        }
    }

    /* renamed from: a */
    private void m7523a(List<C1336jt> list, int i, int i2) {
        int i3;
        int size = list.size();
        if (size > 0) {
            C1336jt jtVar = list.get(size - 1);
            int a = i2 - (jtVar.mo8867a() + jtVar.mo8871b());
            if (a < 0) {
                i3 = 0;
            } else {
                i3 = a;
            }
            int i4 = 0;
            for (int i5 = 0; i5 < size; i5++) {
                C1336jt jtVar2 = list.get(i5);
                int a2 = m7520a((LayoutParams) null);
                int round = Math.round((float) ((1 * i3) / size));
                int c = jtVar2.mo8874c();
                int b = jtVar2.mo8871b();
                Rect rect = new Rect();
                rect.top = i4;
                rect.left = 0;
                rect.right = i;
                rect.bottom = b + round + i4;
                Rect rect2 = new Rect();
                Gravity.apply(a2, c, b, rect, rect2);
                i4 += round;
                jtVar2.mo8872b(jtVar2.mo8876d() + rect2.left);
                jtVar2.mo8868a(jtVar2.mo8867a() + rect2.top);
                jtVar2.mo8877d(rect2.width());
                jtVar2.mo8875c(rect2.height());
            }
        }
    }

    /* renamed from: b */
    private void m7528b(C1336jt jtVar) {
        int round;
        List<View> e = jtVar.mo8878e();
        int size = e.size();
        if (size > 0) {
            float f = 0.0f;
            int i = 0;
            while (i < size) {
                float b = f + m7526b((LayoutParams) e.get(i).getLayoutParams());
                i++;
                f = b;
            }
            LayoutParams layoutParams = (LayoutParams) e.get(size - 1).getLayoutParams();
            int c = jtVar.mo8874c() - (layoutParams.mo13665a() + (layoutParams.mo13668b() + layoutParams.mo13674e()));
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                LayoutParams layoutParams2 = (LayoutParams) e.get(i2).getLayoutParams();
                float b2 = m7526b(layoutParams2);
                int a = m7520a(layoutParams2);
                if (f == BitmapDescriptorFactory.HUE_RED) {
                    round = c / size;
                } else {
                    round = Math.round((b2 * ((float) c)) / f);
                }
                int b3 = layoutParams2.mo13668b() + layoutParams2.mo13674e();
                int c2 = layoutParams2.mo13670c() + layoutParams2.mo13675f();
                Rect rect = new Rect();
                rect.top = 0;
                rect.left = i3;
                rect.right = b3 + round + i3;
                rect.bottom = jtVar.mo8871b();
                Rect rect2 = new Rect();
                Gravity.apply(a, b3, c2, rect, rect2);
                layoutParams2.mo13666a(rect2.left + layoutParams2.mo13665a());
                layoutParams2.mo13673d(rect2.top);
                layoutParams2.mo13669b(rect2.width() - layoutParams2.mo13674e());
                layoutParams2.mo13671c(rect2.height() - layoutParams2.mo13675f());
                i2++;
                i3 = round + i3;
            }
        }
    }

    /* renamed from: a */
    private int m7520a(LayoutParams layoutParams) {
        int i;
        int d = this.f7264b.mo13694d();
        if (layoutParams == null || !layoutParams.gravitySpecified()) {
            i = d;
        } else {
            i = layoutParams.getGravity();
        }
        int a = m7518a(i);
        int a2 = m7518a(d);
        if ((a & 7) == 0) {
            a |= a2 & 7;
        }
        if ((a & 112) == 0) {
            a |= a2 & 112;
        }
        if ((a & 7) == 0) {
            a |= 3;
        }
        if ((a & 112) == 0) {
            return a | 48;
        }
        return a;
    }

    /* renamed from: a */
    private int m7518a(int i) {
        int i2;
        int i3 = 3;
        if (this.f7264b.mo13686a() == 1 && (i & GravityCompat.RELATIVE_LAYOUT_DIRECTION) == 0) {
            i = (((i & 7) >> 0) << 4) | 0 | (((i & 112) >> 4) << 0);
        }
        if (this.f7264b.mo13695e() != 1 || (i & GravityCompat.RELATIVE_LAYOUT_DIRECTION) == 0) {
            return i;
        }
        if ((i & 3) == 3) {
            i2 = 5;
        } else {
            i2 = 0;
        }
        int i4 = i2 | 0;
        if ((i & 5) != 5) {
            i3 = 0;
        }
        return i4 | i3;
    }

    /* renamed from: b */
    private float m7526b(LayoutParams layoutParams) {
        return layoutParams.weightSpecified() ? layoutParams.getWeight() : this.f7264b.mo13692c();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            childAt.layout(layoutParams.f7272h + layoutParams.leftMargin, layoutParams.f7273i + layoutParams.topMargin, layoutParams.f7272h + layoutParams.leftMargin + childAt.getMeasuredWidth(), layoutParams.topMargin + layoutParams.f7273i + childAt.getMeasuredHeight());
        }
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j) {
        boolean drawChild = super.drawChild(canvas, view, j);
        m7521a(canvas, view);
        return drawChild;
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    /* renamed from: a */
    private void m7521a(Canvas canvas, View view) {
        if (isDebugDraw()) {
            Paint b = m7527b((int) InputDeviceCompat.SOURCE_ANY);
            Paint b2 = m7527b((int) SupportMenu.CATEGORY_MASK);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (layoutParams.rightMargin > 0) {
                float right = (float) view.getRight();
                float height = (((float) view.getHeight()) / 2.0f) + ((float) view.getTop());
                canvas.drawLine(right, height, right + ((float) layoutParams.rightMargin), height, b);
                canvas.drawLine((((float) layoutParams.rightMargin) + right) - 4.0f, height - 4.0f, right + ((float) layoutParams.rightMargin), height, b);
                canvas.drawLine((((float) layoutParams.rightMargin) + right) - 4.0f, height + 4.0f, right + ((float) layoutParams.rightMargin), height, b);
            }
            if (layoutParams.leftMargin > 0) {
                float left = (float) view.getLeft();
                float height2 = (((float) view.getHeight()) / 2.0f) + ((float) view.getTop());
                canvas.drawLine(left, height2, left - ((float) layoutParams.leftMargin), height2, b);
                canvas.drawLine((left - ((float) layoutParams.leftMargin)) + 4.0f, height2 - 4.0f, left - ((float) layoutParams.leftMargin), height2, b);
                canvas.drawLine((left - ((float) layoutParams.leftMargin)) + 4.0f, height2 + 4.0f, left - ((float) layoutParams.leftMargin), height2, b);
            }
            if (layoutParams.bottomMargin > 0) {
                float width = (((float) view.getWidth()) / 2.0f) + ((float) view.getLeft());
                float bottom = (float) view.getBottom();
                canvas.drawLine(width, bottom, width, bottom + ((float) layoutParams.bottomMargin), b);
                canvas.drawLine(width - 4.0f, (((float) layoutParams.bottomMargin) + bottom) - 4.0f, width, bottom + ((float) layoutParams.bottomMargin), b);
                canvas.drawLine(width + 4.0f, (((float) layoutParams.bottomMargin) + bottom) - 4.0f, width, bottom + ((float) layoutParams.bottomMargin), b);
            }
            if (layoutParams.topMargin > 0) {
                float width2 = (((float) view.getWidth()) / 2.0f) + ((float) view.getLeft());
                float top = (float) view.getTop();
                canvas.drawLine(width2, top, width2, top - ((float) layoutParams.topMargin), b);
                canvas.drawLine(width2 - 4.0f, (top - ((float) layoutParams.topMargin)) + 4.0f, width2, top - ((float) layoutParams.topMargin), b);
                canvas.drawLine(width2 + 4.0f, (top - ((float) layoutParams.topMargin)) + 4.0f, width2, top - ((float) layoutParams.topMargin), b);
            }
            if (!layoutParams.isNewLine()) {
                return;
            }
            if (this.f7264b.mo13686a() == 0) {
                float left2 = (float) view.getLeft();
                float top2 = ((float) view.getTop()) + (((float) view.getHeight()) / 2.0f);
                canvas.drawLine(left2, top2 - 6.0f, left2, top2 + 6.0f, b2);
                return;
            }
            float left3 = ((float) view.getLeft()) + (((float) view.getWidth()) / 2.0f);
            float top3 = (float) view.getTop();
            canvas.drawLine(left3 - 6.0f, top3, 6.0f + left3, top3, b2);
        }
    }

    /* renamed from: b */
    private Paint m7527b(int i) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(i);
        paint.setStrokeWidth(2.0f);
        return paint;
    }

    public int getOrientation() {
        return this.f7264b.mo13686a();
    }

    public void setOrientation(int i) {
        this.f7264b.mo13688a(i);
        requestLayout();
    }

    public boolean isDebugDraw() {
        return this.f7264b.mo13691b() || m7525a();
    }

    public void setDebugDraw(boolean z) {
        this.f7264b.mo13689a(z);
        invalidate();
    }

    /* renamed from: a */
    private boolean m7525a() {
        try {
            Method declaredMethod = ViewGroup.class.getDeclaredMethod("debugDraw", (Class[]) null);
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke(this, new Object[]{null})).booleanValue();
        } catch (Exception e) {
            return false;
        }
    }

    public float getWeightDefault() {
        return this.f7264b.mo13692c();
    }

    public void setWeightDefault(float f) {
        this.f7264b.mo13687a(f);
        requestLayout();
    }

    public int getGravity() {
        return this.f7264b.mo13694d();
    }

    public void setGravity(int i) {
        this.f7264b.mo13690b(i);
        requestLayout();
    }

    public int getLayoutDirection() {
        if (this.f7264b == null) {
            return 0;
        }
        return this.f7264b.mo13695e();
    }

    public void setLayoutDirection(int i) {
        this.f7264b.mo13693c(i);
        requestLayout();
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        @ViewDebug.ExportedProperty(mapping = {@ViewDebug.IntToString(from = 0, to = "NONE"), @ViewDebug.IntToString(from = 48, to = "TOP"), @ViewDebug.IntToString(from = 80, to = "BOTTOM"), @ViewDebug.IntToString(from = 3, to = "LEFT"), @ViewDebug.IntToString(from = 5, to = "RIGHT"), @ViewDebug.IntToString(from = 16, to = "CENTER_VERTICAL"), @ViewDebug.IntToString(from = 112, to = "FILL_VERTICAL"), @ViewDebug.IntToString(from = 1, to = "CENTER_HORIZONTAL"), @ViewDebug.IntToString(from = 7, to = "FILL_HORIZONTAL"), @ViewDebug.IntToString(from = 17, to = "CENTER"), @ViewDebug.IntToString(from = 119, to = "FILL")})

        /* renamed from: a */
        private boolean f7265a = false;

        /* renamed from: b */
        private int f7266b = 0;

        /* renamed from: c */
        private float f7267c = -1.0f;

        /* renamed from: d */
        private int f7268d;

        /* renamed from: e */
        private int f7269e;

        /* renamed from: f */
        private int f7270f;

        /* renamed from: g */
        private int f7271g;
        /* access modifiers changed from: private */

        /* renamed from: h */
        public int f7272h;
        /* access modifiers changed from: private */

        /* renamed from: i */
        public int f7273i;
        /* access modifiers changed from: private */

        /* renamed from: j */
        public int f7274j;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            m7531a(context, attributeSet);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public boolean gravitySpecified() {
            return this.f7266b != 0;
        }

        public boolean weightSpecified() {
            return this.f7267c >= BitmapDescriptorFactory.HUE_RED;
        }

        /* renamed from: a */
        private void m7531a(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1993R.styleable.FlowLayout_LayoutParams);
            try {
                this.f7265a = obtainStyledAttributes.getBoolean(C1993R.styleable.FlowLayout_LayoutParams_layout_newLine, false);
                this.f7266b = obtainStyledAttributes.getInt(C1993R.styleable.FlowLayout_LayoutParams_android_layout_gravity, 0);
                this.f7267c = obtainStyledAttributes.getFloat(C1993R.styleable.FlowLayout_LayoutParams_layout_weight, -1.0f);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo13667a(int i, int i2) {
            this.f7272h = i;
            this.f7273i = i2;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public int mo13665a() {
            return this.f7268d;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo13666a(int i) {
            this.f7268d = i;
        }

        /* renamed from: b */
        public int mo13668b() {
            return this.f7269e;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo13669b(int i) {
            this.f7269e = i;
        }

        /* renamed from: c */
        public int mo13670c() {
            return this.f7270f;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public void mo13671c(int i) {
            this.f7270f = i;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public int mo13672d() {
            return this.f7271g;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public void mo13673d(int i) {
            this.f7271g = i;
        }

        /* renamed from: e */
        public int mo13674e() {
            if (this.f7274j == 0) {
                return this.leftMargin + this.rightMargin;
            }
            return this.topMargin + this.bottomMargin;
        }

        /* renamed from: f */
        public int mo13675f() {
            if (this.f7274j == 0) {
                return this.topMargin + this.bottomMargin;
            }
            return this.leftMargin + this.rightMargin;
        }

        public int getX() {
            return this.f7272h;
        }

        public int getY() {
            return this.f7273i;
        }

        public int getGravity() {
            return this.f7266b;
        }

        public void setGravity(int i) {
            this.f7266b = i;
        }

        public float getWeight() {
            return this.f7267c;
        }

        public void setWeight(float f) {
            this.f7267c = f;
        }

        public boolean isNewLine() {
            return this.f7265a;
        }

        public void setNewLine(boolean z) {
            this.f7265a = z;
        }
    }
}
