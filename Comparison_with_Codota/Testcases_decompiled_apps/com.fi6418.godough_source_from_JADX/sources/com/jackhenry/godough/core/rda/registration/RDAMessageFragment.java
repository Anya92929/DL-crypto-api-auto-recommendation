package com.jackhenry.godough.core.rda.registration;

import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.C1802r;
import com.jackhenry.godough.core.model.RDAMessage;
import com.jackhenry.godough.core.widgets.ActionButton;

public class RDAMessageFragment extends C1802r {
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        RelativeLayout relativeLayout = (RelativeLayout) layoutInflater.inflate(C1496ak.rda_message_fragment, viewGroup, false);
        TextView textView = (TextView) relativeLayout.findViewById(C1494ai.rda_message);
        String message = ((RDAMessage) getActivity().getIntent().getSerializableExtra(RDAMessageFragmentActivity.EXTRA_USER_STATUS_RESPONSE)).getMessage();
        if (TextUtils.isEmpty(message)) {
            message = getString(C1506am.dg_no_account_msg);
        }
        textView.setText(Html.fromHtml(message));
        ((ActionButton) relativeLayout.findViewById(C1494ai.btn_action)).setOnClickListener(new C1853d(this));
        return relativeLayout;
    }
}
