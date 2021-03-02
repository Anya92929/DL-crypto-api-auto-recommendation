package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ClientSettings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Api<O extends ApiOptions> {

    /* renamed from: Ij */
    private final C0267b<?, O> f554Ij;

    /* renamed from: Ik */
    private final C0268c<?> f555Ik;

    /* renamed from: Il */
    private final ArrayList<Scope> f556Il;

    public interface ApiOptions {

        public interface HasOptions extends ApiOptions {
        }

        public static final class NoOptions implements NotRequiredOptions {
            private NoOptions() {
            }
        }

        public interface NotRequiredOptions extends ApiOptions {
        }

        public interface Optional extends HasOptions, NotRequiredOptions {
        }
    }

    /* renamed from: com.google.android.gms.common.api.Api$a */
    public interface C0266a {
        void connect();

        void disconnect();

        Looper getLooper();

        boolean isConnected();
    }

    /* renamed from: com.google.android.gms.common.api.Api$b */
    public interface C0267b<T extends C0266a, O> {
        /* renamed from: a */
        T mo3762a(Context context, Looper looper, ClientSettings clientSettings, O o, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener);

        int getPriority();
    }

    /* renamed from: com.google.android.gms.common.api.Api$c */
    public static final class C0268c<C extends C0266a> {
    }

    public <C extends C0266a> Api(C0267b<C, O> clientBuilder, C0268c<C> clientKey, Scope... impliedScopes) {
        this.f554Ij = clientBuilder;
        this.f555Ik = clientKey;
        this.f556Il = new ArrayList<>(Arrays.asList(impliedScopes));
    }

    /* renamed from: gd */
    public C0267b<?, O> mo4183gd() {
        return this.f554Ij;
    }

    /* renamed from: ge */
    public List<Scope> mo4184ge() {
        return this.f556Il;
    }

    /* renamed from: gf */
    public C0268c<?> mo4185gf() {
        return this.f555Ik;
    }
}
