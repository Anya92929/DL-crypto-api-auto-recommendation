package com.jackhenry.godough.core.ach;

import android.view.View;
import com.jackhenry.godough.core.model.ACHRequest;
import com.jackhenry.godough.core.model.OffsetAccount;
import java.util.Calendar;

/* renamed from: com.jackhenry.godough.core.ach.c */
class C1472c implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ACHDetailFragment f5953a;

    C1472c(ACHDetailFragment aCHDetailFragment) {
        this.f5953a = aCHDetailFragment;
    }

    public void onClick(View view) {
        ACHRequest aCHRequest = new ACHRequest();
        aCHRequest.setBatchId(this.f5953a.f5943h.getId());
        aCHRequest.setEffectiveDate((Calendar) this.f5953a.f5940e.getTag());
        aCHRequest.setResetAmountToZero(this.f5953a.f5937b.isChecked());
        if (this.f5953a.f5943h.isOffsetAllowed()) {
            OffsetAccount offsetAccount = (OffsetAccount) this.f5953a.f5938c.getTag();
            aCHRequest.setOffsetAccountNumber(offsetAccount.getAccountNumber());
            aCHRequest.setOffsetAccountType(offsetAccount.getAccountType());
        }
        this.f5953a.submitData(aCHRequest);
    }
}
