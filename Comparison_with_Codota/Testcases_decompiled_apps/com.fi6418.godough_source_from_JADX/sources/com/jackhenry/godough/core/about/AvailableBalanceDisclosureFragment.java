package com.jackhenry.godough.core.about;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.jackhenry.godough.core.AbstractActivity;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.C1802r;
import com.jackhenry.godough.core.model.Account;

public class AvailableBalanceDisclosureFragment extends C1802r {
    public static final String ACCOUNT = "CONTENT";
    public static final String BALANCE_TYPE = "BALANCE_TYPE";
    public static final String TAG = "AvailableBalanceDisclosureFragment";

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle arguments = getArguments();
        Account account = (Account) arguments.getSerializable(ACCOUNT);
        Account.BalanceType balanceType = Account.BalanceType.values()[arguments.getInt(BALANCE_TYPE, -1)];
        if (balanceType == Account.BalanceType.AVAILABLE) {
            ((AbstractActivity) getActivity()).getSupportActionBar().setTitle((CharSequence) account.getAvailableBalanceLabel() + " Disclosure");
        } else if (balanceType == Account.BalanceType.CURRENT) {
            ((AbstractActivity) getActivity()).getSupportActionBar().setTitle((CharSequence) account.getCurrentBalanceLabel() + " Disclosure");
        }
        RelativeLayout relativeLayout = (RelativeLayout) layoutInflater.inflate(C1496ak.available_balance_disclosure_fragment, viewGroup, false);
        TextView textView = (TextView) relativeLayout.findViewById(C1494ai.disclosures_text);
        if (account.getAvailableBalanceDisclosureText() != null) {
            textView.setText(account.getAvailableBalanceDisclosureText());
        }
        return relativeLayout;
    }
}
