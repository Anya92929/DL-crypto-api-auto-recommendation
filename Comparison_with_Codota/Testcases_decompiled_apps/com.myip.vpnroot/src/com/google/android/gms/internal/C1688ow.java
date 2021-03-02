package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;
import com.google.android.gms.wallet.Payments;
import com.google.android.gms.wallet.Wallet;

/* renamed from: com.google.android.gms.internal.ow */
public class C1688ow implements Payments {
    public void changeMaskedWallet(GoogleApiClient googleApiClient, final String googleTransactionId, final String merchantTransactionId, final int requestCode) {
        googleApiClient.mo4219a(new Wallet.C2169b() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(C1694ox oxVar) {
                oxVar.mo9998d(googleTransactionId, merchantTransactionId, requestCode);
                mo4196b(Status.f591Jo);
            }
        });
    }

    public void checkForPreAuthorization(GoogleApiClient googleApiClient, final int requestCode) {
        googleApiClient.mo4219a(new Wallet.C2169b() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(C1694ox oxVar) {
                oxVar.mo9999fH(requestCode);
                mo4196b(Status.f591Jo);
            }
        });
    }

    public void loadFullWallet(GoogleApiClient googleApiClient, final FullWalletRequest request, final int requestCode) {
        googleApiClient.mo4219a(new Wallet.C2169b() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(C1694ox oxVar) {
                oxVar.mo9994a(request, requestCode);
                mo4196b(Status.f591Jo);
            }
        });
    }

    public void loadMaskedWallet(GoogleApiClient googleApiClient, final MaskedWalletRequest request, final int requestCode) {
        googleApiClient.mo4219a(new Wallet.C2169b() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(C1694ox oxVar) {
                oxVar.mo9995a(request, requestCode);
                mo4196b(Status.f591Jo);
            }
        });
    }

    public void notifyTransactionStatus(GoogleApiClient googleApiClient, final NotifyTransactionStatusRequest request) {
        googleApiClient.mo4219a(new Wallet.C2169b() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(C1694ox oxVar) {
                oxVar.mo9996a(request);
                mo4196b(Status.f591Jo);
            }
        });
    }
}
