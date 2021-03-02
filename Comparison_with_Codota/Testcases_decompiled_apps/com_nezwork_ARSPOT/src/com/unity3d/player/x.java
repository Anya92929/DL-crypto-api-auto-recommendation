package com.unity3d.player;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.TextKeyListener;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public final class x extends Dialog implements TextWatcher, View.OnClickListener {
    /* access modifiers changed from: private */
    public Context a = null;
    private UnityPlayer b = null;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public x(Context context, UnityPlayer unityPlayer, String str, int i, boolean z, boolean z2, boolean z3, String str2) {
        super(context);
        int i2 = 0;
        this.a = context;
        this.b = unityPlayer;
        getWindow().setGravity(80);
        getWindow().requestFeature(1);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        setContentView(createSoftInputView());
        getWindow().clearFlags(2);
        EditText editText = (EditText) findViewById(1057292289);
        Button button = (Button) findViewById(1057292290);
        editText.setImeOptions(6);
        editText.setText(str);
        editText.setHint(str2);
        int i3 = (z3 ? 128 : i2) | (z2 ? 131072 : 0) | (z ? 32768 : 0);
        if (i >= 0 && i <= 7) {
            i3 |= new int[]{1, 16385, 12290, 17, 2, 3, 97, 33}[i];
        }
        editText.setInputType(i3);
        editText.addTextChangedListener(this);
        int inputType = editText.getInputType();
        editText.setKeyListener(TextKeyListener.getInstance());
        editText.setRawInputType(inputType);
        editText.setClickable(true);
        if (!z2) {
            editText.selectAll();
        }
        button.setOnClickListener(this);
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                if (z) {
                    x.this.getWindow().setSoftInputMode(5);
                }
            }
        });
    }

    public final String a() {
        EditText editText = (EditText) findViewById(1057292289);
        if (editText == null) {
            return null;
        }
        return editText.getText().toString().trim();
    }

    public final void afterTextChanged(Editable editable) {
        this.b.reportSoftInputStr(editable.toString(), 0);
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    /* access modifiers changed from: protected */
    public final View createSoftInputView() {
        RelativeLayout relativeLayout = new RelativeLayout(this.a);
        relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        AnonymousClass2 r0 = new EditText(this.a) {
            public final boolean onKeyPreIme(int i, KeyEvent keyEvent) {
                if (i == 4) {
                    x.this.b.reportSoftInputStr(x.this.a(), 1);
                }
                if (i == 84) {
                    return true;
                }
                return super.onKeyPreIme(i, keyEvent);
            }

            public final void onWindowFocusChanged(boolean z) {
                super.onWindowFocusChanged(z);
                if (z) {
                    ((InputMethodManager) x.this.a.getSystemService("input_method")).showSoftInput(this, 0);
                } else {
                    x.this.b.reportSoftInputStr(x.this.a(), 1);
                }
            }
        };
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(15);
        layoutParams.addRule(0, 1057292290);
        r0.setLayoutParams(layoutParams);
        r0.setId(1057292289);
        relativeLayout.addView(r0);
        Button button = new Button(this.a);
        button.setText(this.a.getResources().getIdentifier("ok", "string", "android"));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(15);
        layoutParams2.addRule(11);
        button.setLayoutParams(layoutParams2);
        button.setId(1057292290);
        relativeLayout.addView(button);
        ((EditText) relativeLayout.findViewById(1057292289)).setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i != 6) {
                    return false;
                }
                x.this.b.reportSoftInputStr(x.this.a(), 1);
                return false;
            }
        });
        return relativeLayout;
    }

    public final void onBackPressed() {
        this.b.reportSoftInputStr(a(), 1);
    }

    public final void onClick(View view) {
        this.b.reportSoftInputStr(a(), 1);
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
