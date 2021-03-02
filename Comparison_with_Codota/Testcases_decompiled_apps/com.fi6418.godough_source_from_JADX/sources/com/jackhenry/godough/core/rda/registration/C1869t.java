package com.jackhenry.godough.core.rda.registration;

import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.model.RDAVelocity;
import com.jackhenry.godough.core.p038e.C1579h;
import com.jackhenry.godough.core.p038e.C1580i;

/* renamed from: com.jackhenry.godough.core.rda.registration.t */
class C1869t implements C1579h {

    /* renamed from: a */
    final /* synthetic */ String f6760a;

    /* renamed from: b */
    final /* synthetic */ RDAVelocity f6761b;

    /* renamed from: c */
    final /* synthetic */ boolean f6762c;

    /* renamed from: d */
    final /* synthetic */ RDARegistrationFragmentActivity f6763d;

    C1869t(RDARegistrationFragmentActivity rDARegistrationFragmentActivity, String str, RDAVelocity rDAVelocity, boolean z) {
        this.f6763d = rDARegistrationFragmentActivity;
        this.f6760a = str;
        this.f6761b = rDAVelocity;
        this.f6762c = z;
    }

    /* renamed from: a */
    public View mo9688a() {
        View inflate = this.f6763d.getLayoutInflater().inflate(C1496ak.rda_registration_submitted, (ViewGroup) null, false);
        TextView textView = (TextView) inflate.findViewById(C1494ai.rda_limits_desc);
        String str = this.f6760a;
        if (str == null) {
            str = this.f6763d.getString(C1506am.dg_no_account_msg);
        }
        textView.setText(Html.fromHtml(str));
        if (this.f6761b == null || !this.f6761b.isVelocityValid() || !this.f6762c) {
            inflate.findViewById(C1494ai.velocity_table).setVisibility(8);
        } else {
            ((TextView) inflate.findViewById(C1494ai.daily_count)).setText(this.f6763d.getString(C1506am.lbl_limit_of, new Object[]{Long.valueOf(this.f6761b.getDailyCount()), Long.valueOf(this.f6761b.getDailyCountLimit())}));
            ((TextView) inflate.findViewById(C1494ai.daily_amount)).setText(this.f6763d.getString(C1506am.lbl_limit_of, new Object[]{C1580i.m6152a(this.f6761b.getDailyAmount()), C1580i.m6152a(this.f6761b.getDailyAmountLimit())}));
            ((TextView) inflate.findViewById(C1494ai.monthly_count)).setText(this.f6763d.getString(C1506am.lbl_limit_of, new Object[]{String.valueOf(this.f6761b.getPeriodCount()), String.valueOf(this.f6761b.getPeriodCountLimit())}));
            ((TextView) inflate.findViewById(C1494ai.monthly_amount)).setText(this.f6763d.getString(C1506am.lbl_limit_of, new Object[]{C1580i.m6152a(this.f6761b.getPeriodAmount()), C1580i.m6152a(this.f6761b.getPeriodAmountLimit())}));
        }
        return inflate;
    }
}
