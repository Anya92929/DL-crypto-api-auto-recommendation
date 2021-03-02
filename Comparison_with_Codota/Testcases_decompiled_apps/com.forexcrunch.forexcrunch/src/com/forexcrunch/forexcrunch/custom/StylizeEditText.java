package com.forexcrunch.forexcrunch.custom;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.EditText;
import com.forexcrunch.forexcrunch.C0089R;

public class StylizeEditText extends EditText {
    String fontName;

    public StylizeEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        if (!isInEditMode()) {
            this.fontName = context.obtainStyledAttributes(attrs, C0089R.styleable.StylizeFont).getString(0);
            if (this.fontName != null && !this.fontName.equals("")) {
                this.fontName = "fonts/" + this.fontName;
                init(context, this.fontName);
            }
        }
    }

    public StylizeEditText(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    private void init(Context context, String fontName2) {
        setTypeface(Typeface.createFromAsset(context.getAssets(), fontName2));
        setClickable(true);
        setFocusable(true);
        setFocusableInTouchMode(true);
    }
}
