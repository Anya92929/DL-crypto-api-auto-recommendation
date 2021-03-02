package com.jackhenry.godough.core.p2p;

import android.content.Intent;
import android.support.p000v4.app.Fragment;
import com.jackhenry.godough.core.AbstractActivity;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.C1593j;
import com.jackhenry.godough.core.C1943y;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.core.login.C1629aa;
import com.jackhenry.godough.core.login.MFAActivity;
import com.jackhenry.godough.core.model.MFA;
import com.jackhenry.godough.core.model.Redirect;
import com.jackhenry.godough.core.p038e.C1576e;
import com.jackhenry.godough.core.p038e.C1577f;
import com.jackhenry.godough.core.p038e.C1578g;
import com.jackhenry.godough.p027b.C1389d;
import com.jackhenry.godough.p027b.C1392g;

/* renamed from: com.jackhenry.godough.core.p2p.ad */
class C1764ad extends C1943y<MFA> {

    /* renamed from: a */
    final /* synthetic */ P2PFragment f6561a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1764ad(P2PFragment p2PFragment, Fragment fragment, C1593j jVar) {
        super(fragment, jVar);
        this.f6561a = p2PFragment;
    }

    /* renamed from: a */
    public void mo9588a(MFA mfa) {
        if (((P2PFragmentActivity) this.f6561a.getActivity()) != null) {
            if (mfa.isChallenged()) {
                this.f6561a.mo10989m();
                Intent intent = new Intent(GoDoughApp.getApp(), MFAActivity.class);
                intent.putExtra(MFAActivity.EXTRA_MFA_DESTINATION, 2);
                intent.putExtra("EXTRA_MFA", mfa);
                this.f6561a.startActivityForResult(intent, 0);
            } else {
                this.f6561a.submitData();
            }
            C1629aa unused = this.f6561a.f6547az = null;
        }
    }

    /* renamed from: a */
    public void mo9587a(Integer num) {
    }

    /* renamed from: a */
    public boolean mo9589a(C1389d dVar) {
        P2PFragmentActivity p2PFragmentActivity = (P2PFragmentActivity) this.f6561a.getActivity();
        if (p2PFragmentActivity == null) {
            return true;
        }
        if (!super.mo9589a(dVar)) {
            if (dVar instanceof C1392g) {
                String message = dVar.getMessage();
                if (Redirect.RedirectType.getEnum(message.toUpperCase()) == Redirect.RedirectType.MFA) {
                    this.f6561a.m6601y();
                } else if (Redirect.RedirectType.getEnum(message.toUpperCase()) == Redirect.RedirectType.OFFLINE) {
                    this.f6561a.mo10989m();
                    C1576e eVar = new C1576e(C1577f.ERROR, AbstractActivity.DIALOG_OFF_LINE, this.f6561a.getString(C1506am.dg_offline_title), this.f6561a.getString(C1506am.dg_offline_message));
                    eVar.mo9791a((C1578g) new C1765ae(this, p2PFragmentActivity));
                    p2PFragmentActivity.showDialog(eVar);
                } else {
                    this.f6561a.mo10989m();
                    mo11216b(dVar);
                }
            } else {
                this.f6561a.mo10989m();
                mo11216b(dVar);
            }
        }
        C1629aa unused = this.f6561a.f6547az = null;
        return true;
    }
}
