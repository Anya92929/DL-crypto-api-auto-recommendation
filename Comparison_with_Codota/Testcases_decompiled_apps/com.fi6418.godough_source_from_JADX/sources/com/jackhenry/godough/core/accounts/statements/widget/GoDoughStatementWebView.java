package com.jackhenry.godough.core.accounts.statements.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.GestureDetector;
import com.jackhenry.godough.core.widgets.GoDoughWebView;

public class GoDoughStatementWebView extends GoDoughWebView {
    public GoDoughStatementWebView(Context context) {
        super(context);
    }

    public GoDoughStatementWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public GoDoughStatementWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public GoDoughStatementWebView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public GoDoughStatementWebView(Context context, AttributeSet attributeSet, int i, boolean z) {
        super(context, attributeSet, i, z);
    }

    @SuppressLint({"JavascriptInterface"})
    public void addJavascriptInterface(Object obj, String str) {
        if (Build.VERSION.SDK_INT >= 21) {
            super.addJavascriptInterface(obj, str);
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public void setupWebview() {
        super.setupWebview();
        getSettings().setLoadsImagesAutomatically(true);
        getSettings().setAllowFileAccess(true);
        if (Build.VERSION.SDK_INT >= 21) {
            getSettings().setJavaScriptEnabled(true);
        } else {
            getSettings().setJavaScriptEnabled(false);
        }
        setOnTouchListener(new C1463a(this, new GestureDetector(getContext(), new C1464b(this, this))));
    }
}
