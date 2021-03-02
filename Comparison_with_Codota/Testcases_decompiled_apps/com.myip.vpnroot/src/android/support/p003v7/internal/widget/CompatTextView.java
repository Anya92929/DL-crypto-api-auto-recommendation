package android.support.p003v7.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.support.p003v7.appcompat.C0091R;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import java.util.Locale;

/* renamed from: android.support.v7.internal.widget.CompatTextView */
public class CompatTextView extends TextView {
    public CompatTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    public CompatTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CompatTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        TypedArray style = context.obtainStyledAttributes(attrs, C0091R.styleable.CompatTextView, defStyle, 0);
        boolean allCaps = style.getBoolean(0, false);
        style.recycle();
        if (allCaps) {
            setTransformationMethod(new AllCapsTransformationMethod(context));
        }
    }

    /* renamed from: android.support.v7.internal.widget.CompatTextView$AllCapsTransformationMethod */
    private static class AllCapsTransformationMethod implements TransformationMethod {
        private final Locale mLocale;

        public AllCapsTransformationMethod(Context context) {
            this.mLocale = context.getResources().getConfiguration().locale;
        }

        public CharSequence getTransformation(CharSequence source, View view) {
            if (source != null) {
                return source.toString().toUpperCase(this.mLocale);
            }
            return null;
        }

        public void onFocusChanged(View view, CharSequence charSequence, boolean b, int i, Rect rect) {
        }
    }
}
