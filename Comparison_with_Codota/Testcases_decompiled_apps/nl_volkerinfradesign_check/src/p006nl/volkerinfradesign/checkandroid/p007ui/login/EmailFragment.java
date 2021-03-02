package p006nl.volkerinfradesign.checkandroid.p007ui.login;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.os.Bundle;
import android.support.p001v4.app.Fragment;
import android.support.p001v4.content.ContextCompat;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import org.apache.commons.lang3.StringUtils;
import p006nl.volkerinfradesign.checkandroid.App;
import p006nl.volkerinfradesign.checkandroid.C1352R;
import p006nl.volkerinfradesign.checkandroid.environments.AccountState;
import p006nl.volkerinfradesign.checkandroid.environments.Model;
import p006nl.volkerinfradesign.checkandroid.util.EmailValidator;
import p006nl.volkerinfradesign.checkandroid.util.SimpleTextWatcher;

/* renamed from: nl.volkerinfradesign.checkandroid.ui.login.EmailFragment */
public class EmailFragment extends Fragment implements Model.AccountStateChangedObserver {

    /* renamed from: a */
    TextView f5394a;

    /* renamed from: b */
    TextView f5395b;

    /* renamed from: c */
    EditText f5396c;

    /* renamed from: d */
    Button f5397d;

    /* renamed from: e */
    private EmailFragmentParent f5398e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public String f5399f;

    /* renamed from: nl.volkerinfradesign.checkandroid.ui.login.EmailFragment$EmailFragmentParent */
    public interface EmailFragmentParent {
        void onRequestCodeClicked(String str);

        boolean showsErrors();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C1352R.layout.login_email_content, viewGroup, false);
        TextView textView = (TextView) inflate.findViewById(C1352R.C1354id.footer);
        this.f5394a = (TextView) inflate.findViewById(C1352R.C1354id.loginDesc);
        this.f5395b = (TextView) inflate.findViewById(C1352R.C1354id.loginDescSession);
        this.f5396c = (EditText) inflate.findViewById(C1352R.C1354id.email);
        this.f5397d = (Button) inflate.findViewById(C1352R.C1354id.requestCode);
        this.f5396c.addTextChangedListener(new SimpleTextWatcher() {
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                String unused = EmailFragment.this.f5399f = editable.toString().trim();
                if (EmailValidator.isValid(EmailFragment.this.f5399f)) {
                    EmailFragment.this.f5396c.setError((CharSequence) null);
                    EmailFragment.this.f5397d.setVisibility(0);
                    return;
                }
                EmailFragment.this.f5396c.setError("Uw email is niet correct");
                EmailFragment.this.f5397d.setVisibility(4);
            }
        });
        m6291o();
        this.f5397d.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                EmailFragment.this.f5396c.setError((CharSequence) null);
                EmailFragment.this.m6288l().onRequestCodeClicked(EmailFragment.this.f5399f);
            }
        });
        try {
            textView.setText("versie: " + m6289m().getPackageManager().getPackageInfo(m6289m().getPackageName(), 0).versionName);
        } catch (Exception e) {
            textView.setText((CharSequence) null);
        }
        return inflate;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        onAccountStateChanged(m6289m().getModel().getAccountState(), (Exception) null);
        m6289m().getModel().registerStateChangedObserver(this);
    }

    public void onDestroyView() {
        m6289m().getModel().unRegisterStateChangedObserver(this);
        super.onDestroyView();
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public EmailFragmentParent m6288l() {
        if (this.f5398e == null) {
            Object parentFragment = getParentFragment();
            if (parentFragment == null) {
                parentFragment = getActivity();
            }
            this.f5398e = (EmailFragmentParent) parentFragment;
        }
        return this.f5398e;
    }

    /* renamed from: m */
    private App m6289m() {
        return (App) getActivity().getApplication();
    }

    public void onAccountStateChanged(AccountState accountState, Exception exc) {
        if (accountState.isLoading()) {
            this.f5396c.setEnabled(false);
            this.f5397d.setEnabled(false);
        } else {
            this.f5396c.setEnabled(true);
            this.f5397d.setEnabled(true);
        }
        if (exc != null) {
            this.f5396c.setError(exc.getMessage());
        }
    }

    /* renamed from: n */
    private boolean m6290n() {
        if (ContextCompat.checkSelfPermission(getActivity(), "android.permission.GET_ACCOUNTS") == 0) {
            return true;
        }
        requestPermissions(new String[]{"android.permission.GET_ACCOUNTS"}, 12);
        return false;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (iArr.length != 0 && iArr[0] == 0) {
            switch (i) {
                case 12:
                    m6291o();
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: o */
    private void m6291o() {
        Account account;
        this.f5399f = m6289m().getModel().getInputEmail();
        if (this.f5399f == null && m6290n()) {
            Account[] accounts = AccountManager.get(getActivity().getApplicationContext()).getAccounts();
            int length = accounts.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                account = accounts[i];
                String str = account.type;
                if (str.endsWith(".exchange") || str.endsWith(".eas")) {
                    this.f5399f = account.name;
                } else {
                    i++;
                }
            }
            this.f5399f = account.name;
        }
        if (StringUtils.isNotBlank(this.f5399f)) {
            this.f5396c.getText().clear();
            this.f5396c.append(this.f5399f);
        }
    }
}
