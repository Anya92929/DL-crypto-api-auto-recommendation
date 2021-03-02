package com.google.android.gms.signin.internal;

import android.os.IInterface;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.signin.GoogleSignInAccount;

/* renamed from: com.google.android.gms.signin.internal.f */
public interface C1255f extends IInterface {
    /* renamed from: a */
    void mo7456a(ConnectionResult connectionResult, AuthAccountResult authAccountResult);

    /* renamed from: a */
    void mo9037a(Status status);

    /* renamed from: a */
    void mo9038a(Status status, GoogleSignInAccount googleSignInAccount);

    /* renamed from: b */
    void mo9039b(Status status);
}
