package com.jackhenry.godough.core.rda.registration;

import com.jackhenry.godough.core.C1593j;
import com.jackhenry.godough.core.model.RDAUserRegistrationData;

/* renamed from: com.jackhenry.godough.core.rda.registration.h */
class C1857h implements C1593j {

    /* renamed from: a */
    final /* synthetic */ RDAUserRegistrationData f6742a;

    /* renamed from: b */
    final /* synthetic */ RDARegistrationAccountSelectionFragment f6743b;

    C1857h(RDARegistrationAccountSelectionFragment rDARegistrationAccountSelectionFragment, RDAUserRegistrationData rDAUserRegistrationData) {
        this.f6743b = rDARegistrationAccountSelectionFragment;
        this.f6742a = rDAUserRegistrationData;
    }

    public void run() {
        this.f6743b.submitData(this.f6742a);
    }
}
