package android.support.design.widget;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

/* renamed from: android.support.design.widget.bl */
class C0047bl {

    /* renamed from: a */
    private static final ThreadLocal<Matrix> f182a = new ThreadLocal<>();

    /* renamed from: b */
    private static final ThreadLocal<RectF> f183b = new ThreadLocal<>();

    /* renamed from: c */
    private static final Matrix f184c = new Matrix();

    /* renamed from: a */
    public static void m287a(ViewGroup viewGroup, View view, Rect rect) {
        Matrix matrix;
        Matrix matrix2 = f182a.get();
        if (matrix2 == null) {
            Matrix matrix3 = new Matrix();
            f182a.set(matrix3);
            matrix = matrix3;
        } else {
            matrix2.set(f184c);
            matrix = matrix2;
        }
        m288a((ViewParent) viewGroup, view, matrix);
        RectF rectF = f183b.get();
        if (rectF == null) {
            rectF = new RectF();
        }
        rectF.set(rect);
        matrix.mapRect(rectF);
        rect.set((int) (rectF.left + 0.5f), (int) (rectF.top + 0.5f), (int) (rectF.right + 0.5f), (int) (rectF.bottom + 0.5f));
    }

    /* renamed from: a */
    static void m288a(ViewParent viewParent, View view, Matrix matrix) {
        ViewParent parent = view.getParent();
        if ((parent instanceof View) && parent != viewParent) {
            View view2 = (View) parent;
            m288a(viewParent, view2, matrix);
            matrix.preTranslate((float) (-view2.getScrollX()), (float) (-view2.getScrollY()));
        }
        matrix.preTranslate((float) view.getLeft(), (float) view.getTop());
        if (!view.getMatrix().isIdentity()) {
            matrix.preConcat(view.getMatrix());
        }
    }
}
