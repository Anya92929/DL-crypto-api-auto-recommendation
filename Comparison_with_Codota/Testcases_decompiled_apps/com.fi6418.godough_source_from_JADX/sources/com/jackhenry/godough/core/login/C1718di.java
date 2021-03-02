package com.jackhenry.godough.core.login;

import android.text.TextUtils;
import com.jackhenry.godough.core.C1757n;
import com.jackhenry.godough.core.C1759p;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.core.model.CredentialsChangeSettings;
import com.jackhenry.godough.core.model.PasswordChangeResponse;
import com.jackhenry.godough.core.model.PasswordResetData;
import com.jackhenry.godough.core.p038e.C1584m;
import com.jackhenry.godough.core.p038e.p039a.C1572e;

/* renamed from: com.jackhenry.godough.core.login.di */
public class C1718di extends C1757n<PasswordChangeResponse> {

    /* renamed from: e */
    private final CredentialsChangeSettings f6459e;

    /* renamed from: f */
    private PasswordResetData f6460f;

    public C1718di(PasswordResetData passwordResetData, C1759p<PasswordChangeResponse> pVar, CredentialsChangeSettings credentialsChangeSettings) {
        super(new PasswordChangeResponse(), pVar);
        this.f6460f = passwordResetData;
        this.f6459e = credentialsChangeSettings;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public PasswordChangeResponse mo9592a(Void... voidArr) {
        PasswordChangeResponse a = new C1689cg().mo10000a(this.f6460f);
        if (this.f6460f.getNewUserName() != null && !this.f6460f.getNewUserName().equals("")) {
            new C1572e().mo9787b("DATA2");
            new C1584m(GoDoughApp.getApp()).mo9802b("REMEMBER_ME_CHECKED", false);
        }
        if (!a.isSuccess() || !TextUtils.isEmpty(a.getMessage())) {
            return a;
        }
        return null;
    }
}
