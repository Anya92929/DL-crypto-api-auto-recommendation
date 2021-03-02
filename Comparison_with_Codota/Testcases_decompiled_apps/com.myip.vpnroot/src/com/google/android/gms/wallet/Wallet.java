package com.google.android.gms.wallet;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.support.p003v7.internal.widget.ActivityChooserView;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.internal.C1665ol;
import com.google.android.gms.internal.C1688ow;
import com.google.android.gms.internal.C1694ox;
import com.google.android.gms.internal.C1699oz;
import com.google.android.gms.internal.C1701pa;
import com.google.android.gms.wallet.wobs.C2217r;
import java.util.Locale;

public final class Wallet {
    public static final Api<WalletOptions> API = new Api<>(f4629CV, f4628CU, new Scope[0]);
    /* access modifiers changed from: private */

    /* renamed from: CU */
    public static final Api.C0268c<C1694ox> f4628CU = new Api.C0268c<>();

    /* renamed from: CV */
    private static final Api.C0267b<C1694ox, WalletOptions> f4629CV = new Api.C0267b<C1694ox, WalletOptions>() {
        /* renamed from: a */
        public C1694ox mo3762a(Context context, Looper looper, ClientSettings clientSettings, WalletOptions walletOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            C0348n.m859b(context instanceof Activity, (Object) "An Activity must be used for Wallet APIs");
            Activity activity = (Activity) context;
            if (walletOptions == null) {
                walletOptions = new WalletOptions();
            }
            return new C1694ox(activity, looper, connectionCallbacks, onConnectionFailedListener, walletOptions.environment, clientSettings.getAccountName(), walletOptions.theme);
        }

        public int getPriority() {
            return ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }
    };
    public static final Payments Payments = new C1688ow();
    public static final C2217r aty = new C1701pa();
    public static final C1665ol atz = new C1699oz();

    public static final class WalletOptions implements Api.ApiOptions.HasOptions {
        public final int environment;
        public final int theme;

        public static final class Builder {
            /* access modifiers changed from: private */
            public int atA = 0;
            /* access modifiers changed from: private */
            public int mTheme = 0;

            public WalletOptions build() {
                return new WalletOptions(this);
            }

            public Builder setEnvironment(int environment) {
                if (environment == 0 || environment == 2 || environment == 1) {
                    this.atA = environment;
                    return this;
                }
                throw new IllegalArgumentException(String.format(Locale.US, "Invalid environment value %d", new Object[]{Integer.valueOf(environment)}));
            }

            public Builder setTheme(int theme) {
                if (theme == 0 || theme == 1) {
                    this.mTheme = theme;
                    return this;
                }
                throw new IllegalArgumentException(String.format(Locale.US, "Invalid theme value %d", new Object[]{Integer.valueOf(theme)}));
            }
        }

        private WalletOptions() {
            this(new Builder());
        }

        private WalletOptions(Builder builder) {
            this.environment = builder.atA;
            this.theme = builder.mTheme;
        }
    }

    /* renamed from: com.google.android.gms.wallet.Wallet$a */
    public static abstract class C2168a<R extends Result> extends BaseImplementation.C0269a<R, C1694ox> {
        public C2168a() {
            super(Wallet.f4628CU);
        }
    }

    /* renamed from: com.google.android.gms.wallet.Wallet$b */
    public static abstract class C2169b extends C2168a<Status> {
        /* access modifiers changed from: protected */
        /* renamed from: d */
        public Status mo3773c(Status status) {
            return status;
        }
    }

    private Wallet() {
    }

    @Deprecated
    public static void changeMaskedWallet(GoogleApiClient googleApiClient, String googleTransactionId, String merchantTransactionId, int requestCode) {
        Payments.changeMaskedWallet(googleApiClient, googleTransactionId, merchantTransactionId, requestCode);
    }

    @Deprecated
    public static void checkForPreAuthorization(GoogleApiClient googleApiClient, int requestCode) {
        Payments.checkForPreAuthorization(googleApiClient, requestCode);
    }

    @Deprecated
    public static void loadFullWallet(GoogleApiClient googleApiClient, FullWalletRequest request, int requestCode) {
        Payments.loadFullWallet(googleApiClient, request, requestCode);
    }

    @Deprecated
    public static void loadMaskedWallet(GoogleApiClient googleApiClient, MaskedWalletRequest request, int requestCode) {
        Payments.loadMaskedWallet(googleApiClient, request, requestCode);
    }

    @Deprecated
    public static void notifyTransactionStatus(GoogleApiClient googleApiClient, NotifyTransactionStatusRequest request) {
        Payments.notifyTransactionStatus(googleApiClient, request);
    }
}
