package p006nl.volkerinfradesign.checkandroid.environments.implementation;

import p006nl.volkerinfradesign.checkandroid.environments.AccountState;

/* renamed from: nl.volkerinfradesign.checkandroid.environments.implementation.IsalaDeltaEnvironment */
public final class IsalaDeltaEnvironment extends CheckEnvironment {
    public IsalaDeltaEnvironment(EnvironmentParams environmentParams) {
        super(environmentParams);
    }

    /* access modifiers changed from: protected */
    public void setAccountState(AccountState accountState, Exception exc) {
        if (getAccountState().equals(AccountState.NO_EMAIL) || getAccountState().equals(AccountState.EMAIL_APPLIED) || getAccountState().equals(AccountState.REQUESTING_CODE)) {
            setAccountState(AccountState.REQUESTING_CODE, (Exception) null);
        }
        super.setAccountState(accountState, exc);
    }

    public AccountState getAccountState() {
        super.getAccountState();
        if (this.state != null && !this.state.equals(AccountState.NO_EMAIL) && !this.state.equals(AccountState.EMAIL_APPLIED) && !this.state.equals(AccountState.REQUESTING_CODE)) {
            return super.getAccountState();
        }
        getPrefs().edit().putString("account_state", AccountState.CODE_REQUESTED.name()).apply();
        return AccountState.CODE_REQUESTED;
    }

    public String getInputEmail() {
        return "incidenten@isaladelta.nl";
    }

    /* access modifiers changed from: protected */
    public boolean setInputEmail(String str) {
        return super.setInputEmail("incidenten@isaladelta.nl");
    }
}
