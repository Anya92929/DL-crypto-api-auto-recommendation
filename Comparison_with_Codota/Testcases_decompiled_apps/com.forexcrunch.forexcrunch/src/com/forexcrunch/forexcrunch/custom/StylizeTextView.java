package com.forexcrunch.forexcrunch.custom;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;
import com.forexcrunch.forexcrunch.C0089R;

public class StylizeTextView extends TextView {
    String fontName;

    public StylizeTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        if (!isInEditMode()) {
            this.fontName = context.obtainStyledAttributes(attrs, C0089R.styleable.StylizeFont).getString(0);
            if (this.fontName == null || this.fontName.equals("")) {
                this.fontName = "fonts/Calibri.ttf";
                init(context, this.fontName);
                return;
            }
            this.fontName = "fonts/" + this.fontName;
            init(context, this.fontName);
        }
    }

    public StylizeTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    private void init(Context context, String fontName2) {
        setTypeface(Typeface.createFromAsset(context.getAssets(), fontName2));
    }
}
