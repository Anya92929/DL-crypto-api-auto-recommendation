package com.jackhenry.godough.core;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.jackhenry.godough.core.widgets.ActionButton;

public abstract class AbstractConfirmationFragment extends C1802r {
    public static final int BTN_OK = 0;
    public static final int CONFIRM_DIALOG = 1;

    /* renamed from: a */
    private String f5766a;

    /* renamed from: b */
    private String f5767b;

    /* renamed from: c */
    private String f5768c;

    /* renamed from: d */
    private RelativeLayout f5769d;

    public String getActionButtonLabel() {
        return this.f5766a == null ? getResources().getString(C1506am.btn_ok) : this.f5766a;
    }

    public String getCancelButtonLabel() {
        return this.f5767b;
    }

    public abstract View getConfirmationView();

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f5769d = (RelativeLayout) layoutInflater.inflate(C1496ak.confirmation_fragment, viewGroup, false);
        View confirmationView = getConfirmationView();
        if (confirmationView != null) {
            ((ViewGroup) this.f5769d.findViewById(C1494ai.content_frame)).addView(confirmationView, new FrameLayout.LayoutParams(-1, -1));
        }
        ((TextView) this.f5769d.findViewById(C1494ai.title)).setText(this.f5768c);
        if (getActionButtonLabel() != null) {
            ActionButton actionButton = (ActionButton) this.f5769d.findViewById(C1494ai.btn_action);
            actionButton.setVisibility(0);
            actionButton.setText((CharSequence) getActionButtonLabel());
            actionButton.setId(0);
            actionButton.setOnClickListener(new C1594k(this));
        }
        if (getCancelButtonLabel() != null) {
            ActionButton actionButton2 = (ActionButton) this.f5769d.findViewById(C1494ai.btn_cancel);
            actionButton2.setVisibility(0);
            actionButton2.setText((CharSequence) getCancelButtonLabel());
            actionButton2.setOnClickListener(new C1595l(this));
        }
        return this.f5769d;
    }

    public void setActionButtonLabel(String str) {
        this.f5766a = str;
    }

    public void setCancelButtonLabel(String str) {
        this.f5767b = str;
    }

    public void setConfirmationTitle(String str) {
        this.f5768c = str;
    }
}
