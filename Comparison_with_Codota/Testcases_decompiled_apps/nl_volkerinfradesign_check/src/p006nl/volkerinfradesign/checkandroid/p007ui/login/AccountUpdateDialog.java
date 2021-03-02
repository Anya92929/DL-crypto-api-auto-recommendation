package p006nl.volkerinfradesign.checkandroid.p007ui.login;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.p001v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.google.gson.JsonObject;
import java.io.File;
import p006nl.volkerinfradesign.checkandroid.App;
import p006nl.volkerinfradesign.checkandroid.C1352R;
import p006nl.volkerinfradesign.checkandroid.services.account.AccountUpdateCallback;
import p006nl.volkerinfradesign.checkandroid.services.account.AccountUpdateCancellation;

/* renamed from: nl.volkerinfradesign.checkandroid.ui.login.AccountUpdateDialog */
public final class AccountUpdateDialog extends DialogFragment implements AccountUpdateCallback {

    /* renamed from: aj */
    ViewGroup f5357aj;

    /* renamed from: ak */
    ViewGroup f5358ak;

    /* renamed from: al */
    TextView f5359al;

    /* renamed from: am */
    Button f5360am;

    /* renamed from: an */
    C1643a f5361an;

    /* renamed from: ao */
    AccountUpdateDialogParent f5362ao;

    /* renamed from: ap */
    AccountUpdateCancellation f5363ap;

    /* renamed from: nl.volkerinfradesign.checkandroid.ui.login.AccountUpdateDialog$AccountUpdateDialogParent */
    public interface AccountUpdateDialogParent {
        void onAccountUpdated(boolean z);
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.ui.login.AccountUpdateDialog$a */
    enum C1643a {
        UPDATING {
            /* renamed from: a */
            public C1643a mo10133a(AccountUpdateDialog accountUpdateDialog, Object... objArr) {
                accountUpdateDialog.f5358ak.setVisibility(4);
                accountUpdateDialog.f5357aj.setVisibility(0);
                return this;
            }
        },
        FAILED {
            /* renamed from: a */
            public C1643a mo10133a(final AccountUpdateDialog accountUpdateDialog, Object... objArr) {
                accountUpdateDialog.f5358ak.setVisibility(0);
                accountUpdateDialog.f5357aj.setVisibility(4);
                if (objArr == null || objArr.length <= 0 || objArr[0] == null) {
                    accountUpdateDialog.f5359al.setVisibility(8);
                } else {
                    accountUpdateDialog.f5359al.setText(objArr[0].toString());
                    accountUpdateDialog.f5359al.setVisibility(0);
                }
                accountUpdateDialog.f5360am.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        accountUpdateDialog.f5363ap = accountUpdateDialog.m6265m().getModel().updateAccount(accountUpdateDialog);
                    }
                });
                return this;
            }
        };

        /* renamed from: a */
        public abstract C1643a mo10133a(AccountUpdateDialog accountUpdateDialog, Object... objArr);
    }

    public static AccountUpdateDialog newInstance(boolean z, boolean z2) {
        AccountUpdateDialog accountUpdateDialog = new AccountUpdateDialog();
        Bundle bundle = new Bundle();
        bundle.putBoolean("download_only", z);
        bundle.putBoolean("finish_on_success", z2);
        accountUpdateDialog.setArguments(bundle);
        return accountUpdateDialog;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f5361an = bundle == null ? C1643a.UPDATING : C1643a.valueOf(bundle.getString("profile_update_dialog:dialog_state"));
    }

    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        onCreateDialog.setTitle("Updaten");
        return onCreateDialog;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C1352R.layout.profile_update_dialog, viewGroup, false);
        this.f5357aj = (ViewGroup) inflate.findViewById(C1352R.C1354id.updatingContainer);
        this.f5358ak = (ViewGroup) inflate.findViewById(C1352R.C1354id.failedContainer);
        this.f5359al = (TextView) inflate.findViewById(C1352R.C1354id.failedDesc);
        this.f5360am = (Button) inflate.findViewById(C1352R.C1354id.retryButton);
        return inflate;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (this.f5361an == C1643a.UPDATING) {
            this.f5363ap = m6265m().getModel().updateAccount(this);
        } else {
            this.f5361an.mo10133a(this, new Object[0]);
        }
    }

    public void onDestroyView() {
        if (this.f5363ap != null) {
            this.f5363ap.cancel();
        }
        super.onDestroyView();
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("profile_update_dialog:dialog_state", this.f5361an.name());
    }

    public boolean isDownloadOnly() {
        return getArguments() == null || getArguments().getBoolean("download_only", false);
    }

    public void onUpdateFailed(Exception exc) {
        this.f5361an = C1643a.FAILED.mo10133a(this, exc);
    }

    public void onSessionExpired(Exception exc) {
        this.f5361an = C1643a.FAILED.mo10133a(this, exc);
    }

    public void onUpdateStart() {
    }

    public void onUpdateSuccess(JsonObject jsonObject, File file) {
        boolean z = false;
        if (getArguments() != null && getArguments().getBoolean("finish_on_success", false)) {
            z = true;
        }
        m6264l().onAccountUpdated(z);
        dismiss();
    }

    /* renamed from: l */
    private AccountUpdateDialogParent m6264l() {
        if (this.f5362ao == null) {
            Object parentFragment = getParentFragment();
            if (parentFragment == null) {
                parentFragment = getActivity();
            }
            this.f5362ao = (AccountUpdateDialogParent) parentFragment;
        }
        return this.f5362ao;
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public App m6265m() {
        return (App) getActivity().getApplication();
    }
}
