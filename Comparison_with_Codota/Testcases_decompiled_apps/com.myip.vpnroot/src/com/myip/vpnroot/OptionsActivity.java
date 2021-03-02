package com.myip.vpnroot;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.common.AccountPicker;
import com.myip.vpnroot.util.ObscuredSharedPreferences;
import java.util.ArrayList;

public class OptionsActivity extends Fragment {
    private static final int ACCOUNT_SELECT_CODE = 333;
    /* access modifiers changed from: private */
    public AccountManager accountManager;
    private String accountName;
    private Button btn1;
    private TextView ed_user;
    private SharedPreferences prefs;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(C2344R.layout.activity_options, container, false);
        ((Button) rootView.findViewById(C2344R.C2346id.btn1)).setTypeface(Typeface.createFromAsset(getActivity().getAssets(), "fonts/Roboto-Bold.ttf"));
        this.prefs = new ObscuredSharedPreferences(getActivity(), getActivity().getSharedPreferences("myip.cfg", 0));
        this.accountName = this.prefs.getString("accountName", (String) null);
        this.ed_user = (TextView) rootView.findViewById(C2344R.C2346id.et_user);
        this.ed_user.setEnabled(false);
        if (this.accountName != null) {
            this.ed_user.setText("Logged as " + this.accountName);
        }
        this.btn1 = (Button) rootView.findViewById(C2344R.C2346id.btn1);
        this.btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ProgressDialog access$000 = OptionsActivity.this.initializeProgressDialog();
                AccountManager unused = OptionsActivity.this.accountManager = AccountManager.get(OptionsActivity.this.getActivity());
                OptionsActivity.this.startActivityForResult(AccountPicker.newChooseAccountIntent((Account) null, (ArrayList<Account>) null, new String[]{GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE}, false, (String) null, (String) null, (String[]) null, (Bundle) null), OptionsActivity.ACCOUNT_SELECT_CODE);
            }
        });
        return rootView;
    }

    /* access modifiers changed from: private */
    public ProgressDialog initializeProgressDialog() {
        ProgressDialog dialog = new ProgressDialog(getActivity());
        dialog.setIndeterminate(true);
        dialog.setMessage("Loading...");
        return dialog;
    }

    public void onResume() {
        super.onResume();
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        System.out.println("We have activity results on ServicesActivity");
        if (requestCode == ACCOUNT_SELECT_CODE) {
            getActivity();
            if (resultCode == -1) {
                this.accountName = data.getStringExtra("authAccount");
                Account[] accountsByType = this.accountManager.getAccountsByType(GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE);
                int length = accountsByType.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    Account account = accountsByType[i];
                    if (account.name.equals(this.accountName)) {
                        Account userAccount = account;
                        break;
                    }
                    i++;
                }
                if (this.accountName != null && !this.accountName.isEmpty()) {
                    this.prefs.edit().putString("accountName", this.accountName).commit();
                    this.ed_user.setText("Logged as " + this.accountName);
                }
            }
        }
    }
}
