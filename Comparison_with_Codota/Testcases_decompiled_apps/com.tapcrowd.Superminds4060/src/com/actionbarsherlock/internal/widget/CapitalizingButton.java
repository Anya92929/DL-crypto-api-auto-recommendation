package com.actionbarsherlock.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.Button;
import java.util.Locale;

public class CapitalizingButton extends Button {
    private static final boolean IS_GINGERBREAD;
    private static final int[] R_styleable_Button = {16843660};
    private static final int R_styleable_Button_textAllCaps = 0;
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

    public CapitalizingButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs, R_styleable_Button);
        this.mAllCaps = a.getBoolean(0, true);
        a.recycle();
    }

    public void setTextCompat(CharSequence text) {
        if (!SANS_ICE_CREAM || !this.mAllCaps || text == null) {
            setText(text);
        } else if (IS_GINGERBREAD) {
            setText(text.toString().toUpperCase(Locale.ROOT));
        } else {
            setText(text.toString().toUpperCase());
        }
    }
}
