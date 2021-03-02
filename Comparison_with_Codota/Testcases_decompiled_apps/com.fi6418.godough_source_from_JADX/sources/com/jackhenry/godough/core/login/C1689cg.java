package com.jackhenry.godough.core.login;

import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.core.model.Carrier;
import com.jackhenry.godough.core.model.Credentials;
import com.jackhenry.godough.core.model.CredentialsChangeSettings;
import com.jackhenry.godough.core.model.EmailAddressData;
import com.jackhenry.godough.core.model.EmailChangeRequest;
import com.jackhenry.godough.core.model.EmailUpdateStatus;
import com.jackhenry.godough.core.model.MFA;
import com.jackhenry.godough.core.model.MFARecollect;
import com.jackhenry.godough.core.model.MFAResponse;
import com.jackhenry.godough.core.model.NotificationList;
import com.jackhenry.godough.core.model.PasswordChangeResponse;
import com.jackhenry.godough.core.model.PasswordResetData;
import com.jackhenry.godough.core.model.Redirect;
import com.jackhenry.godough.core.model.RequestToken;
import com.jackhenry.godough.core.model.SelfEnrollmentData;
import com.jackhenry.godough.core.model.SelfEnrollmentRequest;
import com.jackhenry.godough.core.model.Settings;
import com.jackhenry.godough.core.model.TermsAndConditionsResponse;
import com.jackhenry.godough.core.model.UserSettings;
import com.jackhenry.godough.core.session.C1885a;
import com.jackhenry.godough.p024a.C1373a;
import com.jackhenry.godough.p027b.C1388c;
import com.jackhenry.godough.p027b.C1392g;
import com.jackhenry.godough.p027b.C1393h;
import com.jackhenry.godough.p028c.p029a.C1396a;
import com.jackhenry.godough.p028c.p029a.p030a.C1400b;
import com.jackhenry.godough.p028c.p029a.p030a.C1401c;
import com.jackhenry.godough.p028c.p029a.p030a.C1402d;

/* renamed from: com.jackhenry.godough.core.login.cg */
public class C1689cg extends C1396a {
    /* renamed from: a */
    public EmailAddressData mo9998a(EmailAddressData emailAddressData) {
        C1885a.m6860a();
        EmailChangeRequest emailChangeRequest = new EmailChangeRequest(emailAddressData.getCustomerEmail());
        emailChangeRequest.setRequestToken(mo9443o());
        emailAddressData.setStatus((EmailUpdateStatus) mo9442n().mo9453a("/EmailChange", (C1401c) new C1400b(EmailUpdateStatus.class), (String) new C1400b(EmailChangeRequest.class).mo9450a((Object) emailChangeRequest)));
        return emailAddressData;
    }

    /* renamed from: a */
    public MFAResponse mo9999a(MFA mfa) {
        C1885a.m6860a();
        mfa.setRequestToken(mo9443o());
        try {
            mo9442n().mo9459b("/Mfa", new C1402d(), (String) new C1400b(MFA.class).mo9450a((Object) mfa));
            return new MFAResponse((Boolean) true);
        } catch (C1388c e) {
            C1388c cVar = e;
            return new MFAResponse(cVar.mo9434a(), cVar.getMessage());
        } catch (C1392g e2) {
            Redirect redirect = new Redirect();
            try {
                redirect.setRedirect(Redirect.RedirectType.valueOf(e2.getMessage().toUpperCase()));
            } catch (Exception e3) {
                redirect.setRedirect(Redirect.RedirectType.HOME);
            }
            return new MFAResponse(redirect);
        }
    }

    /* renamed from: a */
    public PasswordChangeResponse mo10000a(PasswordResetData passwordResetData) {
        C1885a.m6860a();
        passwordResetData.setRequestToken(mo9443o());
        return (PasswordChangeResponse) mo9442n().mo9453a("/Credentials", (C1401c) new C1400b(PasswordChangeResponse.class), (String) new C1400b(PasswordResetData.class).mo9450a((Object) passwordResetData));
    }

    /* renamed from: a */
    public String mo10001a(Credentials credentials) {
        credentials.setGcmRegId("00000000");
        String str = (String) mo9442n().mo9453a("/Authentication", (C1401c) new C1402d(), (String) new C1400b(Credentials.class).mo9450a((Object) credentials));
        if ("".equals(str)) {
            C1885a.m6860a();
        }
        return str;
    }

    /* renamed from: a */
    public String mo10002a(MFARecollect mFARecollect) {
        C1885a.m6860a();
        mFARecollect.setRequestToken(mo9443o());
        return (String) mo9442n().mo9453a("/Mfa", (C1401c) new C1402d(), (String) new C1400b(MFARecollect.class).mo9450a((Object) mFARecollect));
    }

    /* renamed from: a */
    public void mo10003a(Carrier carrier, String str, boolean z) {
        C1885a.m6860a();
        SelfEnrollmentRequest selfEnrollmentRequest = new SelfEnrollmentRequest();
        selfEnrollmentRequest.setCarrierId(carrier.getId());
        selfEnrollmentRequest.setPhoneNumber(str);
        selfEnrollmentRequest.setReceivingTextMessages(z);
        selfEnrollmentRequest.setRequestToken(mo9443o());
        C1400b bVar = new C1400b(SelfEnrollmentRequest.class);
        mo9442n().mo9453a("/SelfEnrollment", (C1401c) bVar, (String) bVar.mo9450a((Object) selfEnrollmentRequest));
    }

    /* renamed from: b */
    public EmailAddressData mo10004b() {
        C1885a.m6860a();
        return (EmailAddressData) mo9442n().mo9452a("/EmailChange", (C1401c) new C1400b(EmailAddressData.class));
    }

    /* renamed from: c */
    public boolean mo10005c() {
        C1885a.m6860a();
        mo9442n().mo9451a("/EmailChange");
        return true;
    }

    /* renamed from: d */
    public CredentialsChangeSettings mo10006d() {
        C1885a.m6860a();
        CredentialsChangeSettings credentialsChangeSettings = (CredentialsChangeSettings) mo9442n().mo9452a("/Credentials", (C1401c) new C1400b(CredentialsChangeSettings.class));
        if (credentialsChangeSettings == null || credentialsChangeSettings.isValid()) {
            return credentialsChangeSettings;
        }
        throw new C1393h();
    }

    /* renamed from: e */
    public MFA mo10007e() {
        C1885a.m6860a();
        return (MFA) mo9442n().mo9452a("/Mfa", (C1401c) new C1400b(MFA.class));
    }

    /* renamed from: f */
    public SelfEnrollmentData mo10008f() {
        C1885a.m6860a();
        return (SelfEnrollmentData) mo9442n().mo9452a("/SelfEnrollment", (C1401c) new C1400b(SelfEnrollmentData.class));
    }

    /* renamed from: g */
    public String mo10009g() {
        C1885a.m6860a();
        return ((TermsAndConditionsResponse) mo9442n().mo9452a("/TermsAndConditions", (C1401c) new C1400b(TermsAndConditionsResponse.class))).getTermsAndConditions();
    }

    /* renamed from: h */
    public String mo10010h() {
        C1885a.m6860a();
        RequestToken requestToken = new RequestToken();
        requestToken.setRequestToken(mo9443o());
        return (String) mo9442n().mo9453a("/TermsAndConditions", (C1401c) new C1402d(), (String) new C1400b(RequestToken.class).mo9450a((Object) requestToken));
    }

    /* renamed from: i */
    public Settings mo10011i() {
        return (Settings) mo9442n().mo9452a("/Settings", (C1401c) new C1400b(Settings.class));
    }

    /* renamed from: j */
    public NotificationList mo10012j() {
        return (NotificationList) mo9442n().mo9452a("/Notifications", (C1401c) new C1400b(NotificationList.class));
    }

    /* renamed from: k */
    public UserSettings mo10013k() {
        C1885a.m6860a();
        return (UserSettings) mo9442n().mo9452a("/UserSettings", (C1401c) new C1400b(UserSettings.class));
    }

    /* renamed from: l */
    public boolean mo10014l() {
        C1885a.m6860a();
        mo9442n().mo9458b("/Mfa", new C1400b(MFA.class));
        return false;
    }

    /* renamed from: m */
    public void mo9441m() {
        C1885a.m6861b();
        C1373a.m5616a((String) null);
        mo9442n().mo9452a("/LogOut", (C1401c) new C1402d());
        GoDoughApp.getCookieManager().getCookieStore().removeAll();
    }
}
