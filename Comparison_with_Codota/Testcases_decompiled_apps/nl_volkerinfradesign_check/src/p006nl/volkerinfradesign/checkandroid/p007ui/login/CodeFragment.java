package p006nl.volkerinfradesign.checkandroid.p007ui.login;

import android.os.Bundle;
import android.support.p001v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import p006nl.volkerinfradesign.checkandroid.App;
import p006nl.volkerinfradesign.checkandroid.AppState;
import p006nl.volkerinfradesign.checkandroid.C1352R;
import p006nl.volkerinfradesign.checkandroid.environments.AccountState;
import p006nl.volkerinfradesign.checkandroid.environments.Model;

/* renamed from: nl.volkerinfradesign.checkandroid.ui.login.CodeFragment */
public class CodeFragment extends Fragment implements Model.AccountStateChangedObserver {

    /* renamed from: a */
    EditText f5387a;

    /* renamed from: b */
    LinearLayout f5388b;

    /* renamed from: c */
    Button f5389c;

    /* renamed from: d */
    Button f5390d;

    /* renamed from: e */
    private CodeFragmentParent f5391e;

    /* renamed from: nl.volkerinfradesign.checkandroid.ui.login.CodeFragment$CodeFragmentParent */
    public interface CodeFragmentParent {
        void onRestartClicked();

        void onVerifyCodeClicked(int i);

        boolean showsErrors();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C1352R.layout.login_code_content, viewGroup, false);
        this.f5387a = (EditText) inflate.findViewById(C1352R.C1354id.codeInput);
        this.f5388b = (LinearLayout) inflate.findViewById(C1352R.C1354id.restartDesc);
        this.f5389c = (Button) inflate.findViewById(C1352R.C1354id.verifyCode);
        this.f5390d = (Button) inflate.findViewById(C1352R.C1354id.restart);
        this.f5389c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Integer num = null;
                CodeFragment.this.f5387a.setError((CharSequence) null);
                try {
                    num = Integer.valueOf(Integer.parseInt(CodeFragment.this.f5387a.getText().toString().trim()));
                } catch (NumberFormatException e) {
                }
                if (num != null) {
                    CodeFragment.this.m6284m().onVerifyCodeClicked(num.intValue());
                }
            }
        });
        this.f5390d.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                CodeFragment.this.m6284m().onRestartClicked();
            }
        });
        return inflate;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        onAccountStateChanged(m6283l().getModel().getAccountState(), (Exception) null);
        m6283l().getModel().registerStateChangedObserver(this);
        ((TextView) view.findViewById(C1352R.C1354id.emailAddress)).setText(m6283l().getModel().getInputEmail());
        if (AppState.getInstance().getName().equals("IsalaDelta")) {
            this.f5390d.setVisibility(4);
            ((TextView) view.findViewById(C1352R.C1354id.codeSentTo)).setText("Vraag om de verificatiecode bij uw IsalaDelta contactpersoon");
            view.findViewById(C1352R.C1354id.emailAddress).setVisibility(4);
            view.findViewById(C1352R.C1354id.restartDesc).setVisibility(4);
        }
    }

    public void onDestroyView() {
        m6283l().getModel().unRegisterStateChangedObserver(this);
        super.onDestroyView();
    }

    /* renamed from: l */
    private App m6283l() {
        return (App) getActivity().getApplication();
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public CodeFragmentParent m6284m() {
        if (this.f5391e == null) {
            Object parentFragment = getParentFragment();
            if (parentFragment == null) {
                parentFragment = getActivity();
            }
            this.f5391e = (CodeFragmentParent) parentFragment;
        }
        return this.f5391e;
    }

    public void onAccountStateChanged(AccountState accountState, Exception exc) {
        if (accountState.isLoading()) {
            this.f5387a.setEnabled(false);
            this.f5389c.setEnabled(false);
        } else {
            this.f5387a.setEnabled(true);
            this.f5389c.setEnabled(true);
        }
        if (exc != null) {
            this.f5387a.setError(exc.getMessage());
        }
    }
}
