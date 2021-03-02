package com.jackhenry.godough.core.login;

import com.jackhenry.godough.core.C1593j;

/* renamed from: com.jackhenry.godough.core.login.g */
class C1732g implements C1593j {

    /* renamed from: a */
    final /* synthetic */ String f6474a;

    /* renamed from: b */
    final /* synthetic */ EmailAddressFragment f6475b;

    C1732g(EmailAddressFragment emailAddressFragment, String str) {
        this.f6475b = emailAddressFragment;
        this.f6474a = str;
    }

    public void run() {
        this.f6475b.submitEmail(this.f6474a);
    }
}
