package com.jackhenry.godough.core.login;

import com.jackhenry.godough.core.C1593j;

/* renamed from: com.jackhenry.godough.core.login.ck */
class C1693ck implements C1593j {

    /* renamed from: a */
    final /* synthetic */ boolean f6434a;

    /* renamed from: b */
    final /* synthetic */ PasswordChangeFragment f6435b;

    C1693ck(PasswordChangeFragment passwordChangeFragment, boolean z) {
        this.f6435b = passwordChangeFragment;
        this.f6434a = z;
    }

    public void run() {
        this.f6435b.submitData(this.f6434a);
    }
}
