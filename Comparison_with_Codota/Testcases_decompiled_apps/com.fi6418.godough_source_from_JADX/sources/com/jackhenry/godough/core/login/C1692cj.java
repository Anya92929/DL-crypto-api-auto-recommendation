package com.jackhenry.godough.core.login;

import android.view.View;

/* renamed from: com.jackhenry.godough.core.login.cj */
class C1692cj implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ PasswordChangeFragment f6433a;

    C1692cj(PasswordChangeFragment passwordChangeFragment) {
        this.f6433a = passwordChangeFragment;
    }

    public void onClick(View view) {
        ((PasswordChangeFragmentActivity) this.f6433a.getActivity()).showPasswordChangeHelp();
    }
}
