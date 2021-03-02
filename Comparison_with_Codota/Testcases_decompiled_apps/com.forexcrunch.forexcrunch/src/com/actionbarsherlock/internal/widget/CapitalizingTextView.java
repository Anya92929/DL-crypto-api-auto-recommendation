package com.actionbarsherlock.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.TextView;
import java.util.Locale;

public class CapitalizingTextView extends TextView {
    private static final boolean IS_GINGERBREAD;
    private static final int[] R_styleable_TextView = {16843660};
    private static final int R_styleable_TextView_textAllCaps = 0;
    private static final boolean SANS_ICE_CREAM = (Build.VERSION.SDK_INT < 14);
    private boolean mAllCaps;

    static {
        boolean z;
        if (Build.VERSION.SDK_INT >= 9) {
            z = true;
        } else {
            z = false;
        }
        IS_GINGERBREAD = z;
    }

    public CapitalizingTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CapitalizingTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        TypedArray a = context.obtainStyledAttributes(attrs, R_styleable_TextView, defStyle, 0);
        this.mAllCaps = a.getBoolean(0, true);
        a.recycle();
    }

    public void setTextCompat(CharSequence text) {
        if (!SANS_ICE_CREAM || !this.mAllCaps || text == null) {
            setText(text);
        } else if (IS_GINGERBREAD) {
            try {
                setText(text.toString().toUpperCase(Locale.ROOT));
            } catch (NoSuchFieldError e) {
                setText(text.toString().toUpperCase());
            }
        } else {
            setText(text.toString().toUpperCase());
        }
    }
}
