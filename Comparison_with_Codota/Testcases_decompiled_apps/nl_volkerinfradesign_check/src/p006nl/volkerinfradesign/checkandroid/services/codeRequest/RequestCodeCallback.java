package p006nl.volkerinfradesign.checkandroid.services.codeRequest;

/* renamed from: nl.volkerinfradesign.checkandroid.services.codeRequest.RequestCodeCallback */
public interface RequestCodeCallback {
    void onError(Exception exc);

    void onStart();

    void onSuccess();
}
