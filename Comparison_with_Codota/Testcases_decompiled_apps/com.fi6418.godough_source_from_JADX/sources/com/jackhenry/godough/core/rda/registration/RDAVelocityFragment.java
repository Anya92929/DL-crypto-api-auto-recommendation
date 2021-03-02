package com.jackhenry.godough.core.rda.registration;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.C1802r;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.core.model.RDAVelocity;
import com.jackhenry.godough.core.p038e.C1580i;
import com.jackhenry.godough.core.widgets.ActionButton;

public class RDAVelocityFragment extends C1802r {
    public static final String TAG = RDAVelocityFragment.class.getSimpleName();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        RDAVelocity velocity = GoDoughApp.getUserSettings().getRdaVerificationStatusResponse().getVelocity();
        View inflate = getLayoutInflater((Bundle) null).inflate(C1496ak.rda_velocity_fragment, (ViewGroup) null, false);
        if (velocity == null || !velocity.isVelocityValid()) {
            ((LinearLayout) inflate.findViewById(C1494ai.velocity_layout)).setVisibility(8);
        } else {
            ((TextView) inflate.findViewById(C1494ai.daily_count)).setText(getString(C1506am.lbl_limit_of, Long.valueOf(velocity.getDailyCount()), Long.valueOf(velocity.getDailyCountLimit())));
            ((TextView) inflate.findViewById(C1494ai.daily_amount)).setText(getString(C1506am.lbl_limit_of, C1580i.m6152a(velocity.getDailyAmount()), C1580i.m6152a(velocity.getDailyAmountLimit())));
            ((TextView) inflate.findViewById(C1494ai.monthly_count)).setText(getString(C1506am.lbl_limit_of, String.valueOf(velocity.getPeriodCount()), String.valueOf(velocity.getPeriodCountLimit())));
            ((TextView) inflate.findViewById(C1494ai.monthly_amount)).setText(getString(C1506am.lbl_limit_of, C1580i.m6152a(velocity.getPeriodAmount()), C1580i.m6152a(velocity.getPeriodAmountLimit())));
            ((TextView) inflate.findViewById(C1494ai.rda_limits_desc)).setVisibility(8);
            ((ActionButton) inflate.findViewById(C1494ai.btn_action)).setOnClickListener(new C1848af(this));
        }
        return inflate;
    }
}
