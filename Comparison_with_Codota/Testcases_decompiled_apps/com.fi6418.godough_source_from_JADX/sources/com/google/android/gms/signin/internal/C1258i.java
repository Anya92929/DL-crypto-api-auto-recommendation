package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.os.IInterface;
import com.google.android.gms.common.internal.AuthAccountRequest;
import com.google.android.gms.common.internal.C0993aq;
import com.google.android.gms.common.internal.C1002az;
import com.google.android.gms.common.internal.ResolveAccountRequest;

/* renamed from: com.google.android.gms.signin.internal.i */
public interface C1258i extends IInterface {
    /* renamed from: a */
    void mo9051a(int i);

    /* renamed from: a */
    void mo9052a(int i, Account account, C1255f fVar);

    /* renamed from: a */
    void mo9053a(AuthAccountRequest authAccountRequest, C1255f fVar);

    /* renamed from: a */
    void mo9054a(ResolveAccountRequest resolveAccountRequest, C1002az azVar);

    /* renamed from: a */
    void mo9055a(C0993aq aqVar, int i, boolean z);

    /* renamed from: a */
    void mo9056a(CheckServerAuthResult checkServerAuthResult);

    /* renamed from: a */
    void mo9057a(RecordConsentRequest recordConsentRequest, C1255f fVar);

    /* renamed from: a */
    void mo9058a(C1255f fVar);

    /* renamed from: a */
    void mo9059a(boolean z);
}
