package p006nl.volkerinfradesign.checkandroid.environments;

import com.google.gson.JsonObject;
import p006nl.volkerinfradesign.checkandroid.environments.Accounts;
import p006nl.volkerinfradesign.checkandroid.services.account.AccountUpdateCallback;
import p006nl.volkerinfradesign.checkandroid.services.account.AccountUpdateCancellation;

/* renamed from: nl.volkerinfradesign.checkandroid.environments.Model */
public interface Model {

    /* renamed from: nl.volkerinfradesign.checkandroid.environments.Model$AccountStateChangedObserver */
    public interface AccountStateChangedObserver {
        void onAccountStateChanged(AccountState accountState, Exception exc);
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.environments.Model$LogoutFinishedCallback */
    public interface LogoutFinishedCallback {
        void logoutFinished();
    }

    Account getAccount();

    AccountState getAccountState();

    @Deprecated
    Accounts getAccounts();

    Theme getCustomTheme();

    String getInputEmail();

    Logger getLogger();

    Accounts.AccountCursor getSelectedAccount();

    JsonObject getSessionId();

    Tasks getTasks();

    boolean hasAccount();

    boolean hasSelectedAccount();

    void logout(LogoutFinishedCallback logoutFinishedCallback);

    void registerStateChangedObserver(AccountStateChangedObserver accountStateChangedObserver);

    void requestCode(String str);

    void resetSetup();

    void setSessionId(String str);

    boolean setSetupFinished();

    void unRegisterStateChangedObserver(AccountStateChangedObserver accountStateChangedObserver);

    AccountUpdateCancellation updateAccount(AccountUpdateCallback accountUpdateCallback);

    void verifyAccountCode(int i);
}
