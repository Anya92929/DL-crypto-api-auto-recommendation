package com.jackhenry.godough.core.login;

import android.view.View;

/* renamed from: com.jackhenry.godough.core.login.e */
class C1730e implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ EmailAddressFragment f6472a;

    C1730e(EmailAddressFragment emailAddressFragment) {
        this.f6472a = emailAddressFragment;
    }

    public void onClick(View view) {
        this.f6472a.submitEmail(this.f6472a.f6267a.getText().toString());
    }
}
