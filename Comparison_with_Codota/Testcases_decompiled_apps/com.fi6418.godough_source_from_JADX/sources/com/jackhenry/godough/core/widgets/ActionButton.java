package com.jackhenry.godough.core.widgets;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.jackhenry.godough.core.C1493ah;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.C1507an;
import com.jackhenry.godough.core.p038e.C1586o;
import com.jackhenry.godough.p024a.p026b.C1377a;

public class ActionButton extends RelativeLayout {

    /* renamed from: a */
    protected View f6851a;

    /* renamed from: b */
    protected ImageView f6852b;

    /* renamed from: c */
    protected TextView f6853c;

    /* renamed from: d */
    private View.OnClickListener f6854d;

    /* renamed from: e */
    private boolean f6855e;

    public ActionButton(Context context) {
        super(context);
        m6943a(context, (AttributeSet) null, 0);
    }

    public ActionButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m6943a(context, attributeSet, 0);
    }

    public ActionButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m6943a(context, attributeSet, i);
    }

    /* renamed from: a */
    private void m6943a(Context context, AttributeSet attributeSet, int i) {
        ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(C1496ak.widget_button, this, true);
        this.f6851a = findViewById(C1494ai.widget_button_button);
        this.f6852b = (ImageView) findViewById(C1494ai.widget_button_imageview);
        this.f6853c = (TextView) findViewById(C1494ai.widget_button_textview);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1507an.ActionButton);
            this.f6853c.setText(obtainStyledAttributes.getString(C1507an.ActionButton_buttonText));
            int resourceId = obtainStyledAttributes.getResourceId(C1507an.ActionButton_buttonIcon, -1);
            if (!obtainStyledAttributes.getBoolean(C1507an.ActionButton_showButtonIcon, true) || resourceId == -1) {
                this.f6852b.setVisibility(8);
                Float valueOf = Float.valueOf(TypedValue.applyDimension(1, Float.valueOf(12.0f).floatValue(), context.getResources().getDisplayMetrics()));
                ((ViewGroup.MarginLayoutParams) this.f6853c.getLayoutParams()).setMargins(valueOf.intValue(), 0, valueOf.intValue(), 0);
                this.f6853c.requestLayout();
            } else {
                this.f6852b.setBackgroundResource(resourceId);
            }
            int resourceId2 = obtainStyledAttributes.getResourceId(C1507an.ActionButton_buttonDrawable, -1);
            if (resourceId2 != -1) {
                this.f6851a.setBackgroundResource(resourceId2);
            }
            this.f6851a.setEnabled(obtainStyledAttributes.getBoolean(C1507an.ActionButton_buttonEnabled, true));
            this.f6855e = obtainStyledAttributes.getBoolean(C1507an.ActionButton_buttonThemed, false);
            if (this.f6855e && resourceId2 == -1) {
                this.f6851a.setBackgroundResource(C1493ah.btn_action);
            }
            updateTheme();
        }
        if (!isInEditMode()) {
            if (this.f6854d != null) {
                this.f6851a.setOnClickListener(this.f6854d);
            }
            this.f6851a.setEnabled(isEnabled());
        }
    }

    public View getButton() {
        return this.f6851a;
    }

    @ViewDebug.ExportedProperty
    public boolean isEnabled() {
        if (this.f6851a != null) {
            return this.f6851a.isEnabled();
        }
        return false;
    }

    @SuppressLint({"NewApi"})
    public void setBackground(Drawable drawable) {
        if (this.f6851a != null) {
            this.f6851a.setBackground(drawable);
        }
    }

    public void setBackgroundColor(int i) {
        if (this.f6851a != null) {
            this.f6851a.setBackgroundColor(i);
        }
    }

    @Deprecated
    public void setBackgroundDrawable(Drawable drawable) {
        if (this.f6851a != null) {
            this.f6851a.setBackgroundDrawable(drawable);
        }
    }

    public void setEnabled(boolean z) {
        if (this.f6851a != null) {
            this.f6851a.setEnabled(z);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        if (this.f6851a != null) {
            C1377a aVar = new C1377a(onClickListener, this.f6853c.getText().toString());
            this.f6854d = aVar;
            this.f6851a.setOnClickListener(aVar);
        }
    }

    public void setText(int i) {
        this.f6853c.setText(i);
    }

    public void setText(CharSequence charSequence) {
        this.f6853c.setText(charSequence);
    }

    public void updateTheme() {
        if (this.f6855e && !isInEditMode()) {
            C1586o.m6200a(this.f6851a);
        }
        this.f6851a.setPadding(12, 12, 12, 12);
    }
}
