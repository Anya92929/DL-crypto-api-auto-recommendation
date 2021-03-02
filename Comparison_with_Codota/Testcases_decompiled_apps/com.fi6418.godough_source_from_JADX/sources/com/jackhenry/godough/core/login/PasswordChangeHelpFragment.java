package com.jackhenry.godough.core.login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.C1802r;
import com.jackhenry.godough.core.model.CredentialsChangeSettings;

public class PasswordChangeHelpFragment extends C1802r {
    public static final String TAG = "PasswordChangeHelpFragment";

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        CredentialsChangeSettings credentialsChangeSettings = ((PasswordChangeHelpFragmentActivity) getActivity()).getCredentialsChangeSettings();
        RelativeLayout relativeLayout = (RelativeLayout) layoutInflater.inflate(C1496ak.password_change_help_fragment, viewGroup, false);
        TextView textView = (TextView) relativeLayout.findViewById(C1494ai.password_change_help_text);
        if (credentialsChangeSettings.getRulesMessage() != null) {
            textView.setText(credentialsChangeSettings.getRulesMessage());
        }
        return relativeLayout;
    }
}
