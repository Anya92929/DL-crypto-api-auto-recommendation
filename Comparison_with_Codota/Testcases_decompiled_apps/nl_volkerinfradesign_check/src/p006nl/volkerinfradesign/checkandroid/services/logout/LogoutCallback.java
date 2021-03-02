package p006nl.volkerinfradesign.checkandroid.services.logout;

/* renamed from: nl.volkerinfradesign.checkandroid.services.logout.LogoutCallback */
public interface LogoutCallback {
    void onError(Exception exc);

    void onSessionExpired(Exception exc);

    void onStart();

    void onSuccess();
}
