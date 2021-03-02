package p006nl.volkerinfradesign.checkandroid.services.account;

import com.google.gson.JsonObject;

/* renamed from: nl.volkerinfradesign.checkandroid.services.account.AccountVerificationCallback */
public interface AccountVerificationCallback {
    void onError(Exception exc);

    void onStart();

    void onSuccess(JsonObject jsonObject, String str);
}
