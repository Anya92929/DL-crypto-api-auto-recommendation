package p006nl.volkerinfradesign.checkandroid.services.account;

import com.google.gson.JsonObject;
import java.io.File;

/* renamed from: nl.volkerinfradesign.checkandroid.services.account.AccountUpdateCallback */
public interface AccountUpdateCallback {
    boolean isDownloadOnly();

    void onSessionExpired(Exception exc);

    void onUpdateFailed(Exception exc);

    void onUpdateStart();

    void onUpdateSuccess(JsonObject jsonObject, File file);
}
