package com.jackhenry.godough.core;

import android.os.Bundle;
import android.view.View;

public class GoDoughConfirmationFragment extends AbstractConfirmationFragment {

    /* renamed from: a */
    private GodoughTransactionActivity f5784a;

    public View getConfirmationView() {
        if (this.f5784a.getDialogParams().mo9797f() != null) {
            return this.f5784a.getDialogParams().mo9797f();
        }
        return null;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f5784a = (GodoughTransactionActivity) getActivity();
        setConfirmationTitle(this.f5784a.getDialogParams().mo9793b());
    }
}
