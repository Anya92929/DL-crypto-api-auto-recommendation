package android.support.p001v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

/* renamed from: android.support.v4.widget.Space */
public class Space extends View {
    public Space(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        if (getVisibility() == 0) {
            setVisibility(4);
        }
    }

    public Space(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public Space(Context context) {
        this(context, (AttributeSet) null);
    }

    public void draw(Canvas canvas) {
    }

    /* renamed from: a */
    private static int m2773a(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        switch (mode) {
            case ExploreByTouchHelper.INVALID_ID:
                return Math.min(i, size);
            case 1073741824:
                return size;
            default:
                return i;
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(m2773a(getSuggestedMinimumWidth(), i), m2773a(getSuggestedMinimumHeight(), i2));
    }
}
