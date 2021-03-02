package com.jackhenry.godough.core.rda.registration;

import android.os.Bundle;
import com.jackhenry.godough.core.AbstractActivity;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.core.model.RDAUserStatusCodes;
import com.jackhenry.godough.core.model.RDAVerificationStatusResponse;

public abstract class AbstractRDAVerifyRegistrationActivity extends AbstractActivity {
    /* access modifiers changed from: private */

    /* renamed from: m */
    public C1871v f6704m;

    public void checkRDAEnrollmentStatus() {
        mo9483a(getString(C1506am.checking_rda_status));
        this.f6704m = new C1871v(new C1852c(this, mo9485d(), new C1851b(this)));
        this.f6704m.execute(new Void[0]);
    }

    public void initLoadingTasks() {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public Object onRetainCustomNonConfigurationInstance() {
        return this.f6704m != null ? this.f6704m : super.onRetainCustomNonConfigurationInstance();
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        RDAVerificationStatusResponse rdaVerificationStatusResponse = GoDoughApp.getUserSettings().getRdaVerificationStatusResponse();
        Object lastCustomNonConfigurationInstance = getLastCustomNonConfigurationInstance();
        if (lastCustomNonConfigurationInstance instanceof C1871v) {
            this.f6704m = (C1871v) lastCustomNonConfigurationInstance;
            if (this.f6704m != null) {
                C1852c cVar = new C1852c(this, mo9485d(), new C1842a(this));
                if (this.f6704m.mo10926c()) {
                    if (this.f6704m.mo10929e()) {
                        cVar.mo9589a(this.f6704m.mo10927d());
                    } else {
                        cVar.mo9588a((RDAVerificationStatusResponse) this.f6704m.mo10925b());
                    }
                    this.f6704m = null;
                    return;
                }
                mo9483a(getString(C1506am.checking_rda_status));
                this.f6704m.mo10923a(cVar);
            }
        } else if (this.f6704m != null || (rdaVerificationStatusResponse != null && rdaVerificationStatusResponse.getStatus().equals(RDAUserStatusCodes.USER_ENROLLED_ENABLED))) {
            initLoadingTasks();
        } else {
            checkRDAEnrollmentStatus();
        }
    }
}
