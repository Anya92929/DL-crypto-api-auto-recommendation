package p006nl.volkerinfradesign.checkandroid.environments.implementation;

import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import p006nl.volkerinfradesign.checkandroid.App;
import p006nl.volkerinfradesign.checkandroid.AppState;
import p006nl.volkerinfradesign.checkandroid.environments.Account;
import p006nl.volkerinfradesign.checkandroid.environments.AccountState;
import p006nl.volkerinfradesign.checkandroid.environments.Accounts;
import p006nl.volkerinfradesign.checkandroid.environments.Logger;
import p006nl.volkerinfradesign.checkandroid.environments.Model;
import p006nl.volkerinfradesign.checkandroid.environments.Tasks;
import p006nl.volkerinfradesign.checkandroid.environments.Theme;
import p006nl.volkerinfradesign.checkandroid.services.account.AccountUpdateCallback;
import p006nl.volkerinfradesign.checkandroid.services.account.AccountUpdateCancellation;
import p006nl.volkerinfradesign.checkandroid.services.account.AccountUpdateTask;
import p006nl.volkerinfradesign.checkandroid.services.account.AccountVerificationCallback;
import p006nl.volkerinfradesign.checkandroid.services.account.AccountVerificationTask;
import p006nl.volkerinfradesign.checkandroid.services.codeRequest.RequestCodeCallback;
import p006nl.volkerinfradesign.checkandroid.services.codeRequest.RequestCodeTask;
import p006nl.volkerinfradesign.checkandroid.services.logout.LogoutCallback;
import p006nl.volkerinfradesign.checkandroid.services.logout.LogoutTask;
import p006nl.volkerinfradesign.checkandroid.util.EmailValidator;

/* renamed from: nl.volkerinfradesign.checkandroid.environments.implementation.CheckEnvironment */
public class CheckEnvironment implements Model {
    protected static final String ACCOUNT_STATE = "account_state";

    /* renamed from: a */
    final C1239ib f4889a;

    /* renamed from: b */
    final TasksImp f4890b;

    /* renamed from: c */
    final C1245ic f4891c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Account f4892d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public AccountUpdateTask f4893e;

    /* renamed from: f */
    private final AccountUpdateCancellation f4894f = new AccountUpdateCancellation() {
        public void cancel() {
            AccountUpdateTask a = CheckEnvironment.this.f4893e;
            if (a != null && !a.isCancelled()) {
                a.cancel(true);
            }
        }
    };

    /* renamed from: g */
    private Set<Model.AccountStateChangedObserver> f4895g = new HashSet();
    public final EnvironmentParams params;
    protected AccountState state;

    public CheckEnvironment(EnvironmentParams environmentParams) {
        this.params = environmentParams;
        this.f4889a = new C1239ib(this);
        this.f4890b = new TasksImp(this);
        this.f4891c = new C1245ic(this);
    }

    public Accounts getAccounts() {
        return this.f4889a;
    }

    public Accounts.AccountCursor getSelectedAccount() {
        return this.f4889a.getSelected();
    }

    public Tasks getTasks() {
        return this.f4890b;
    }

    public Logger getLogger() {
        return this.f4891c;
    }

    public boolean hasSelectedAccount() {
        return this.f4889a.hasSelected();
    }

    public void registerStateChangedObserver(Model.AccountStateChangedObserver accountStateChangedObserver) {
        this.f4895g.add(accountStateChangedObserver);
    }

    public void unRegisterStateChangedObserver(Model.AccountStateChangedObserver accountStateChangedObserver) {
        this.f4895g.remove(accountStateChangedObserver);
    }

    public void requestCode(String str) {
        setInputEmail(str);
        new RequestCodeTask(new RequestCodeCallback() {
            public void onStart() {
                CheckEnvironment.this.setAccountState(AccountState.REQUESTING_CODE, (Exception) null);
            }

            public void onError(Exception exc) {
                CheckEnvironment.this.setAccountState(AccountState.EMAIL_APPLIED, exc);
            }

            public void onSuccess() {
                CheckEnvironment.this.setAccountState(AccountState.CODE_REQUESTED, (Exception) null);
            }
        }).executeOnExecutor(RequestCodeTask.SERIAL_EXECUTOR, new String[]{str});
    }

    public AccountState getAccountState() {
        if (this.state == null) {
            String string = getPrefs().getString(ACCOUNT_STATE, (String) null);
            this.state = string == null ? AccountState.NO_EMAIL : AccountState.valueOf(string);
        }
        return this.state;
    }

    /* access modifiers changed from: protected */
    public void setAccountState(AccountState accountState, Exception exc) {
        if (accountState.isPersistable()) {
            getPrefs().edit().putString(ACCOUNT_STATE, accountState.name()).apply();
        }
        this.state = accountState;
        m5998a(accountState, exc);
    }

    /* renamed from: a */
    private void m5998a(AccountState accountState, Exception exc) {
        for (Model.AccountStateChangedObserver next : this.f4895g) {
            if (next != null) {
                next.onAccountStateChanged(accountState, exc);
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean setInputEmail(String str) {
        AccountState accountState;
        SharedPreferences.Editor edit = getPrefs().edit();
        boolean isValid = EmailValidator.isValid(str);
        if (isValid) {
            edit.putString("account_email", str).apply();
            accountState = AccountState.EMAIL_APPLIED;
        } else {
            edit.remove("account_email").apply();
            accountState = AccountState.NO_EMAIL;
        }
        setAccountState(accountState, (Exception) null);
        return isValid;
    }

    public String getInputEmail() {
        return getPrefs().getString("account_email", (String) null);
    }

    public void verifyAccountCode(int i) {
        new AccountVerificationTask(new AccountVerificationCallback() {
            public void onStart() {
                CheckEnvironment.this.setAccountState(AccountState.VERIFYING, (Exception) null);
            }

            public void onSuccess(JsonObject jsonObject, String str) {
                CheckEnvironment.this.mo9622a(jsonObject);
                CheckEnvironment.this.setSessionId(str);
                CheckEnvironment.this.setAccountState(AccountState.VERIFIED, (Exception) null);
                Account unused = CheckEnvironment.this.f4892d = null;
            }

            public void onError(Exception exc) {
                CheckEnvironment.this.setAccountState(AccountState.VERIFICATION_FAILED, exc);
            }
        }).executeOnExecutor(AccountVerificationTask.SERIAL_EXECUTOR, new String[]{getInputEmail(), Integer.toString(i)});
    }

    public void setSessionId(String str) {
        getPrefs().edit().putString("session_id", str).apply();
    }

    public JsonObject getSessionId() {
        String string = getPrefs().getString("session_id", (String) null);
        if (string == null) {
            AppState.getInstance().invalidateLogin();
            return null;
        }
        SharedPreferences sharedPreferences = App.getAppContext().getSharedPreferences("KeyPair", 0);
        String string2 = sharedPreferences.getString("app_permutation", (String) null);
        if (string2 == null) {
            string2 = UUID.randomUUID().toString();
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString("app_permutation", string2);
            edit.commit();
        }
        int i = -1;
        try {
            i = App.getAppContext().getPackageManager().getPackageInfo(App.getAppContext().getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        String str = "";
        while (str.length() < 36) {
            str = str + Integer.valueOf((int) Math.min((Math.random() * 900000.0d) + 100000.0d, 999999.0d)).toString();
        }
        Long l = -3750763034362895579L;
        String str2 = str + Long.valueOf(Long.valueOf(Long.valueOf(Long.valueOf(l.longValue() ^ ((long) string2.hashCode())).longValue() * 1099511628211L).longValue() ^ ((long) str.hashCode())).longValue() * 1099511628213L).toString().replace("-", "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        JsonObject jsonObject = new JsonObject();
        long time = new Date().getTime();
        jsonObject.addProperty("SID", string);
        jsonObject.addProperty("token", str2);
        jsonObject.addProperty("APP-PERMUTATION", string2);
        jsonObject.addProperty("timeStamp", (Number) Long.valueOf(time));
        jsonObject.addProperty("versionCode", (Number) Integer.valueOf(i));
        return jsonObject;
    }

    public boolean hasAccount() {
        return getPrefs().contains("account_info");
    }

    public void logout(final Model.LogoutFinishedCallback logoutFinishedCallback) {
        new LogoutTask(new LogoutCallback() {
            public void onStart() {
                CheckEnvironment.this.setAccountState(AccountState.EMAIL_APPLIED, (Exception) null);
            }

            public void onError(Exception exc) {
                mo9633a();
            }

            public void onSessionExpired(Exception exc) {
                mo9633a();
            }

            public void onSuccess() {
                mo9633a();
            }

            /* renamed from: a */
            public void mo9633a() {
                CheckEnvironment.this.setSessionId((String) null);
                CheckEnvironment.this.resetSetup();
                if (logoutFinishedCallback != null) {
                    logoutFinishedCallback.logoutFinished();
                }
            }
        }).executeOnExecutor(LogoutTask.SERIAL_EXECUTOR, new JsonElement[]{getSessionId()});
    }

    public Account getAccount() {
        String string;
        if (this.f4892d == null && (string = getPrefs().getString("account_info", (String) null)) != null) {
            this.f4892d = new C1237ia(this, new JsonParser().parse(string).getAsJsonObject());
        }
        return this.f4892d;
    }

    public AccountUpdateCancellation updateAccount(final AccountUpdateCallback accountUpdateCallback) {
        this.f4894f.cancel();
        this.f4893e = new AccountUpdateTask(this, new AccountUpdateCallback() {
            public boolean isDownloadOnly() {
                return accountUpdateCallback.isDownloadOnly();
            }

            public void onUpdateFailed(Exception exc) {
                accountUpdateCallback.onUpdateFailed(exc);
            }

            public void onUpdateStart() {
                accountUpdateCallback.onUpdateStart();
            }

            public void onUpdateSuccess(JsonObject jsonObject, File file) {
                CheckEnvironment.this.getAccount().apply(jsonObject);
                CheckEnvironment.this.getAccount().setCompanyPicture(file);
                accountUpdateCallback.onUpdateSuccess(jsonObject, file);
            }

            public void onSessionExpired(Exception exc) {
                AppState.getInstance().invalidateLogin();
            }
        });
        this.f4893e.executeOnExecutor(AccountUpdateTask.SERIAL_EXECUTOR, new Account[]{getAccount().copy()});
        return this.f4894f;
    }

    public boolean setSetupFinished() {
        if (!getAccountState().isVerified()) {
            return false;
        }
        setAccountState(AccountState.FINISHED, (Exception) null);
        return true;
    }

    public void resetSetup() {
        setAccountState(AccountState.EMAIL_APPLIED, (Exception) null);
    }

    /* renamed from: a */
    public void mo9622a(JsonObject jsonObject) {
        jsonObject.addProperty(Account.MODIFIED, (Number) Long.valueOf(Calendar.getInstance().getTimeInMillis()));
        getPrefs().edit().putString("account_info", jsonObject.toString()).apply();
        this.f4892d = null;
    }

    /* access modifiers changed from: protected */
    public SharedPreferences getPrefs() {
        return this.params.context.getSharedPreferences("environmental_preferences", 0);
    }

    public Theme getCustomTheme() {
        Account account = getAccount();
        if (account != null) {
            return account.getTheme();
        }
        return Theme.DEFAULT;
    }
}
