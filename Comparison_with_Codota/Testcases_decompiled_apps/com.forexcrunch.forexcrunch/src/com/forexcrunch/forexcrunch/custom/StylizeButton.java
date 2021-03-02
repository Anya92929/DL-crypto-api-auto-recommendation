package com.forexcrunch.forexcrunch.custom;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;
import com.forexcrunch.forexcrunch.C0089R;

public class StylizeButton extends Button {
    private Context context;
    String fontName;

    public StylizeButton(Context context2) {
        this(context2, (AttributeSet) null, 0);
    }

    public StylizeButton(Context context2, AttributeSet attrs) {
        this(context2, attrs, 0);
    }

    public StylizeButton(Context context2, AttributeSet attrs, int defStyle) {
        super(context2, attrs, defStyle);
        if (!isInEditMode()) {
            this.fontName = context2.obtainStyledAttributes(attrs, C0089R.styleable.StylizeFont).getString(0);
            if (this.fontName != null && !this.fontName.equals("")) {
                this.fontName = "fonts/" + this.fontName;
                init(context2, this.fontName);
            }
        }
    }

    private void init(Context context2, String fontName2) {
        setTypeface(Typeface.createFromAsset(context2.getAssets(), fontName2));
    }
}
