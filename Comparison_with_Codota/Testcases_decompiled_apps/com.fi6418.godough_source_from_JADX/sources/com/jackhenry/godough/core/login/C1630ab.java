package com.jackhenry.godough.core.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import com.jackhenry.godough.core.AbstractActivity;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.C1593j;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.core.model.CredentialsChangeSettings;
import com.jackhenry.godough.core.model.MFA;
import com.jackhenry.godough.core.model.Redirect;
import com.jackhenry.godough.core.p038e.C1574c;
import com.jackhenry.godough.core.p038e.C1576e;
import com.jackhenry.godough.core.p038e.C1577f;
import com.jackhenry.godough.core.p038e.C1578g;
import com.jackhenry.godough.core.rda.registration.RDARegistrationFragmentActivity;
import com.jackhenry.godough.core.rda.registration.RDATermsAndConditionsFragment;
import com.jackhenry.godough.p027b.C1386a;
import com.jackhenry.godough.p027b.C1388c;
import com.jackhenry.godough.p027b.C1389d;
import com.jackhenry.godough.p027b.C1390e;
import com.jackhenry.godough.p027b.C1392g;
import com.jackhenry.godough.p027b.C1394i;
import com.jackhenry.godough.p027b.C1395j;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.jackhenry.godough.core.login.ab */
public class C1630ab {

    /* renamed from: a */
    private Fragment f6368a;

    /* renamed from: b */
    private MFA f6369b;

    /* renamed from: c */
    private Object f6370c;

    public C1630ab(Fragment fragment) {
        this.f6368a = fragment;
    }

    /* renamed from: a */
    public int mo9945a(C1392g gVar) {
        Redirect redirect = new Redirect(Redirect.RedirectType.getEnum(gVar.getMessage().toUpperCase()));
        if (gVar instanceof C1394i) {
            this.f6369b = ((C1394i) gVar).mo9436a();
        } else if (gVar instanceof C1395j) {
            this.f6370c = ((C1395j) gVar).mo9438a();
        }
        return mo9946a(redirect);
    }

    /* renamed from: a */
    public int mo9946a(Redirect redirect) {
        Intent intent;
        AbstractActivity abstractActivity = (AbstractActivity) this.f6368a.getActivity();
        switch (C1634af.f6377a[redirect.getRedirect().ordinal()]) {
            case 1:
                if (!this.f6369b.isChallenged()) {
                    if (!this.f6369b.isCollect()) {
                        abstractActivity.gotoLandingPage();
                        break;
                    } else {
                        intent = new Intent(GoDoughApp.getApp(), MFARecollectActivity.class);
                    }
                } else {
                    intent = new Intent(GoDoughApp.getApp(), MFAActivity.class);
                    intent.putExtra("EXTRA_MFA", this.f6369b);
                }
                intent.putExtra("EXTRA_MFA", this.f6369b);
                abstractActivity.startActivity(intent);
                abstractActivity.finish();
                break;
            case 2:
                abstractActivity.startActivityAndFinish(EnrollmentFragmentActivity.class);
                break;
            case 3:
                abstractActivity.startActivityAndFinish(TermsAndConditionsFragmentActivity.class);
                break;
            case 4:
                abstractActivity.startActivityAndFinish(EmailAddressFragmentActivity.class);
                break;
            case 5:
                Intent intent2 = new Intent(GoDoughApp.getApp(), PasswordChangeFragmentActivity.class);
                intent2.putExtra(PasswordChangeFragmentActivity.EXTRA_PASSWORD_CHANGE_SETTINGS, (CredentialsChangeSettings) this.f6370c);
                abstractActivity.startActivity(intent2);
                abstractActivity.finish();
                break;
            case 6:
                Intent intent3 = new Intent(GoDoughApp.getApp(), RDARegistrationFragmentActivity.class);
                intent3.putExtra(RDARegistrationFragmentActivity.EXTRA_REDIRECT_TO, 1);
                intent3.putExtra(RDATermsAndConditionsFragment.EXTRA_IS_TANDC_COLLECT, false);
                abstractActivity.startActivity(intent3);
                abstractActivity.finish();
                break;
            case 7:
                Intent intent4 = new Intent(GoDoughApp.getApp(), RDARegistrationFragmentActivity.class);
                intent4.putExtra(RDARegistrationFragmentActivity.EXTRA_REDIRECT_TO, 1);
                intent4.putExtra(RDATermsAndConditionsFragment.EXTRA_IS_TANDC_COLLECT, true);
                abstractActivity.startActivity(intent4);
                abstractActivity.finish();
                break;
            case 8:
                Intent intent5 = new Intent(GoDoughApp.getApp(), RDARegistrationFragmentActivity.class);
                intent5.putExtra(RDARegistrationFragmentActivity.EXTRA_REDIRECT_TO, 2);
                abstractActivity.startActivity(intent5);
                abstractActivity.finish();
                break;
            case 9:
                ArrayList arrayList = new ArrayList();
                arrayList.add(new C1574c(-1, abstractActivity.getString(C1506am.btn_exit)));
                arrayList.add(new C1574c(-2, abstractActivity.getString(C1506am.btn_continue)));
                C1576e eVar = new C1576e(C1577f.ERROR, (int) AbstractActivity.DIALOG_OFF_LINE, abstractActivity.getString(C1506am.dg_offline_title), abstractActivity.getString(C1506am.dg_offline_message), (List<C1574c>) arrayList);
                eVar.mo9791a((C1578g) new C1631ac(this, abstractActivity));
                abstractActivity.showDialog(eVar);
                break;
            default:
                abstractActivity.gotoLandingPage();
                break;
        }
        return 0;
    }

    /* renamed from: a */
    public boolean mo9947a(C1389d dVar, C1593j jVar) {
        String message = dVar.getMessage();
        AbstractActivity abstractActivity = (AbstractActivity) this.f6368a.getActivity();
        if (dVar.mo9435b() == 401) {
            message = "";
        }
        if (dVar instanceof C1386a) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new C1574c(-1, abstractActivity.getString(C1506am.btn_ok)));
            C1576e eVar = new C1576e(C1577f.ERROR, (int) AbstractActivity.DIALOG_NO_API, abstractActivity.getString(C1506am.dg_no_api_title), message, (List<C1574c>) arrayList);
            if (abstractActivity instanceof SplashActivity) {
                eVar.mo9791a((C1578g) new C1632ad(this, abstractActivity));
            } else if (GoDoughApp.getUserSettings() != null) {
                eVar.mo9791a((C1578g) new C1633ae(this, abstractActivity));
            }
            abstractActivity.showDialog(eVar);
            return true;
        } else if (dVar instanceof C1388c) {
            abstractActivity.showGeneralErrorRedirectDialog(AbstractActivity.DIALOG_WARNING, message);
            return true;
        } else if (dVar instanceof C1390e) {
            Bundle bundle = new Bundle();
            bundle.putSerializable(AbstractActivity.BUNDLE_RETRY_RUNNABLE, jVar);
            abstractActivity.showNoNetworkDialog(bundle);
            return true;
        } else {
            if ((dVar instanceof C1392g) && Redirect.RedirectType.getEnum(dVar.getMessage().toUpperCase()) == Redirect.RedirectType.USERSETTINGS) {
                abstractActivity.gotoLandingPage(GoDoughApp.getUserSettings().getOfflineMessage());
            }
            return false;
        }
    }
}
