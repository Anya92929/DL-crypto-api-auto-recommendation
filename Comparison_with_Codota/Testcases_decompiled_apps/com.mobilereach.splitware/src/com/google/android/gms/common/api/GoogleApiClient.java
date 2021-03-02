package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.p000v4.app.FragmentActivity;
import android.support.p000v4.util.ArrayMap;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.common.api.internal.zzj;
import com.google.android.gms.common.api.internal.zzq;
import com.google.android.gms.common.api.internal.zzu;
import com.google.android.gms.common.api.internal.zzw;
import com.google.android.gms.common.internal.zzad;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.zzc;
import com.google.android.gms.internal.zzrl;
import com.google.android.gms.internal.zzrn;
import com.google.android.gms.internal.zzro;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public abstract class GoogleApiClient {
    public static final int SIGN_IN_MODE_OPTIONAL = 2;
    public static final int SIGN_IN_MODE_REQUIRED = 1;
    /* access modifiers changed from: private */
    public static final Set<GoogleApiClient> zzagg = Collections.newSetFromMap(new WeakHashMap());

    public static final class Builder {
        private final Context mContext;
        private Account zzTI;
        private String zzUW;
        private final Set<Scope> zzagh;
        private final Set<Scope> zzagi;
        private int zzagj;
        private View zzagk;
        private String zzagl;
        private final Map<Api<?>, zzf.zza> zzagm;
        private final Map<Api<?>, Api.ApiOptions> zzagn;
        /* access modifiers changed from: private */
        public FragmentActivity zzago;
        private int zzagp;
        private OnConnectionFailedListener zzagq;
        private Looper zzagr;
        private zzc zzags;
        private Api.zza<? extends zzrn, zzro> zzagt;
        private final ArrayList<ConnectionCallbacks> zzagu;
        private final ArrayList<OnConnectionFailedListener> zzagv;

        public Builder(@NonNull Context context) {
            this.zzagh = new HashSet();
            this.zzagi = new HashSet();
            this.zzagm = new ArrayMap();
            this.zzagn = new ArrayMap();
            this.zzagp = -1;
            this.zzags = zzc.zzoK();
            this.zzagt = zzrl.zzUJ;
            this.zzagu = new ArrayList<>();
            this.zzagv = new ArrayList<>();
            this.mContext = context;
            this.zzagr = context.getMainLooper();
            this.zzUW = context.getPackageName();
            this.zzagl = context.getClass().getName();
        }

        public Builder(@NonNull Context context, @NonNull ConnectionCallbacks connectedListener, @NonNull OnConnectionFailedListener connectionFailedListener) {
            this(context);
            zzx.zzb(connectedListener, (Object) "Must provide a connected listener");
            this.zzagu.add(connectedListener);
            zzx.zzb(connectionFailedListener, (Object) "Must provide a connection failed listener");
            this.zzagv.add(connectionFailedListener);
        }

        private static <C extends Api.zzb, O> C zza(Api.zza<C, O> zza, Object obj, Context context, Looper looper, zzf zzf, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return zza.zza(context, looper, zzf, obj, connectionCallbacks, onConnectionFailedListener);
        }

        private static <C extends Api.zzd, O> zzad zza(Api.zze<C, O> zze, Object obj, Context context, Looper looper, zzf zzf, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzad(context, looper, zze.zzoU(), connectionCallbacks, onConnectionFailedListener, zzf, zze.zzq(obj));
        }

        private <O extends Api.ApiOptions> void zza(Api<O> api, O o, int i, Scope... scopeArr) {
            boolean z = true;
            if (i != 1) {
                if (i == 2) {
                    z = false;
                } else {
                    throw new IllegalArgumentException("Invalid resolution mode: '" + i + "', use a constant from GoogleApiClient.ResolutionMode");
                }
            }
            HashSet hashSet = new HashSet(api.zzoP().zzo(o));
            for (Scope add : scopeArr) {
                hashSet.add(add);
            }
            this.zzagm.put(api, new zzf.zza(hashSet, z));
        }

        /* access modifiers changed from: private */
        public void zza(zzw zzw, GoogleApiClient googleApiClient) {
            zzw.zza(this.zzagp, googleApiClient, this.zzagq);
        }

        private void zze(final GoogleApiClient googleApiClient) {
            zzw zza = zzw.zza(this.zzago);
            if (zza == null) {
                new Handler(this.mContext.getMainLooper()).post(new Runnable() {
                    public void run() {
                        if (!Builder.this.zzago.isFinishing() && !Builder.this.zzago.getSupportFragmentManager().isDestroyed()) {
                            Builder.this.zza(zzw.zzb(Builder.this.zzago), googleApiClient);
                        }
                    }
                });
            } else {
                zza(zza, googleApiClient);
            }
        }

        private GoogleApiClient zzoZ() {
            zzad zza;
            Api api;
            zzf zzoY = zzoY();
            Api api2 = null;
            Map<Api<?>, zzf.zza> zzqu = zzoY.zzqu();
            ArrayMap arrayMap = new ArrayMap();
            ArrayMap arrayMap2 = new ArrayMap();
            ArrayList arrayList = new ArrayList();
            Api api3 = null;
            for (Api next : this.zzagn.keySet()) {
                Api.ApiOptions apiOptions = this.zzagn.get(next);
                int i = 0;
                if (zzqu.get(next) != null) {
                    i = zzqu.get(next).zzalf ? 1 : 2;
                }
                arrayMap.put(next, Integer.valueOf(i));
                com.google.android.gms.common.api.internal.zzc zzc = new com.google.android.gms.common.api.internal.zzc(next, i);
                arrayList.add(zzc);
                if (next.zzoS()) {
                    Api.zze zzoQ = next.zzoQ();
                    Api api4 = zzoQ.getPriority() == 1 ? next : api3;
                    zza = zza(zzoQ, (Object) apiOptions, this.mContext, this.zzagr, zzoY, (ConnectionCallbacks) zzc, (OnConnectionFailedListener) zzc);
                    api = api4;
                } else {
                    Api.zza zzoP = next.zzoP();
                    Api api5 = zzoP.getPriority() == 1 ? next : api3;
                    zza = zza(zzoP, (Object) apiOptions, this.mContext, this.zzagr, zzoY, (ConnectionCallbacks) zzc, (OnConnectionFailedListener) zzc);
                    api = api5;
                }
                arrayMap2.put(next.zzoR(), zza);
                if (!zza.zznb()) {
                    next = api2;
                } else if (api2 != null) {
                    throw new IllegalStateException(next.getName() + " cannot be used with " + api2.getName());
                }
                api3 = api;
                api2 = next;
            }
            if (api2 != null) {
                if (api3 != null) {
                    throw new IllegalStateException(api2.getName() + " cannot be used with " + api3.getName());
                }
                zzx.zza(this.zzTI == null, "Must not set an account in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead", api2.getName());
                zzx.zza(this.zzagh.equals(this.zzagi), "Must not set scopes in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead.", api2.getName());
            }
            return new zzj(this.mContext, new ReentrantLock(), this.zzagr, zzoY, this.zzags, this.zzagt, arrayMap, this.zzagu, this.zzagv, arrayMap2, this.zzagp, zzj.zza(arrayMap2.values(), true), arrayList);
        }

        public Builder addApi(@NonNull Api<? extends Api.ApiOptions.NotRequiredOptions> api) {
            zzx.zzb(api, (Object) "Api must not be null");
            this.zzagn.put(api, (Object) null);
            List<Scope> zzo = api.zzoP().zzo(null);
            this.zzagi.addAll(zzo);
            this.zzagh.addAll(zzo);
            return this;
        }

        public <O extends Api.ApiOptions.HasOptions> Builder addApi(@NonNull Api<O> api, @NonNull O options) {
            zzx.zzb(api, (Object) "Api must not be null");
            zzx.zzb(options, (Object) "Null options are not permitted for this Api");
            this.zzagn.put(api, options);
            List<Scope> zzo = api.zzoP().zzo(options);
            this.zzagi.addAll(zzo);
            this.zzagh.addAll(zzo);
            return this;
        }

        public <O extends Api.ApiOptions.HasOptions> Builder addApiIfAvailable(@NonNull Api<O> api, @NonNull O options, Scope... scopes) {
            zzx.zzb(api, (Object) "Api must not be null");
            zzx.zzb(options, (Object) "Null options are not permitted for this Api");
            this.zzagn.put(api, options);
            zza(api, options, 1, scopes);
            return this;
        }

        public Builder addApiIfAvailable(@NonNull Api<? extends Api.ApiOptions.NotRequiredOptions> api, Scope... scopes) {
            zzx.zzb(api, (Object) "Api must not be null");
            this.zzagn.put(api, (Object) null);
            zza(api, (Api.ApiOptions) null, 1, scopes);
            return this;
        }

        public Builder addConnectionCallbacks(@NonNull ConnectionCallbacks listener) {
            zzx.zzb(listener, (Object) "Listener must not be null");
            this.zzagu.add(listener);
            return this;
        }

        public Builder addOnConnectionFailedListener(@NonNull OnConnectionFailedListener listener) {
            zzx.zzb(listener, (Object) "Listener must not be null");
            this.zzagv.add(listener);
            return this;
        }

        public Builder addScope(@NonNull Scope scope) {
            zzx.zzb(scope, (Object) "Scope must not be null");
            this.zzagh.add(scope);
            return this;
        }

        public GoogleApiClient build() {
            zzx.zzb(!this.zzagn.isEmpty(), (Object) "must call addApi() to add at least one API");
            GoogleApiClient zzoZ = zzoZ();
            synchronized (GoogleApiClient.zzagg) {
                GoogleApiClient.zzagg.add(zzoZ);
            }
            if (this.zzagp >= 0) {
                zze(zzoZ);
            }
            return zzoZ;
        }

        public Builder enableAutoManage(@NonNull FragmentActivity fragmentActivity, int clientId, @Nullable OnConnectionFailedListener unresolvedConnectionFailedListener) {
            zzx.zzb(clientId >= 0, (Object) "clientId must be non-negative");
            this.zzagp = clientId;
            this.zzago = (FragmentActivity) zzx.zzb(fragmentActivity, (Object) "Null activity is not permitted.");
            this.zzagq = unresolvedConnectionFailedListener;
            return this;
        }

        public Builder enableAutoManage(@NonNull FragmentActivity fragmentActivity, @Nullable OnConnectionFailedListener unresolvedConnectionFailedListener) {
            return enableAutoManage(fragmentActivity, 0, unresolvedConnectionFailedListener);
        }

        public Builder setAccountName(String accountName) {
            this.zzTI = accountName == null ? null : new Account(accountName, "com.google");
            return this;
        }

        public Builder setGravityForPopups(int gravityForPopups) {
            this.zzagj = gravityForPopups;
            return this;
        }

        public Builder setHandler(@NonNull Handler handler) {
            zzx.zzb(handler, (Object) "Handler must not be null");
            this.zzagr = handler.getLooper();
            return this;
        }

        public Builder setViewForPopups(@NonNull View viewForPopups) {
            zzx.zzb(viewForPopups, (Object) "View must not be null");
            this.zzagk = viewForPopups;
            return this;
        }

        public Builder useDefaultAccount() {
            return setAccountName("<<default account>>");
        }

        public zzf zzoY() {
            zzro zzro = zzro.zzbgV;
            if (this.zzagn.containsKey(zzrl.API)) {
                zzro = (zzro) this.zzagn.get(zzrl.API);
            }
            return new zzf(this.zzTI, this.zzagh, this.zzagm, this.zzagj, this.zzagk, this.zzUW, this.zzagl, zzro);
        }
    }

    public interface ConnectionCallbacks {
        public static final int CAUSE_NETWORK_LOST = 2;
        public static final int CAUSE_SERVICE_DISCONNECTED = 1;

        void onConnected(@Nullable Bundle bundle);

        void onConnectionSuspended(int i);
    }

    public interface OnConnectionFailedListener {
        void onConnectionFailed(@NonNull ConnectionResult connectionResult);
    }

    public interface zza {
        void zza(@NonNull ConnectionResult connectionResult);
    }

    public static void dumpAll(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        synchronized (zzagg) {
            String str = prefix + "  ";
            int i = 0;
            for (GoogleApiClient dump : zzagg) {
                writer.append(prefix).append("GoogleApiClient#").println(i);
                dump.dump(str, fd, writer, args);
                i++;
            }
        }
    }

    public static Set<GoogleApiClient> zzoV() {
        return zzagg;
    }

    public abstract ConnectionResult blockingConnect();

    public abstract ConnectionResult blockingConnect(long j, @NonNull TimeUnit timeUnit);

    public abstract PendingResult<Status> clearDefaultAccountAndReconnect();

    public abstract void connect();

    public void connect(int signInMode) {
        throw new UnsupportedOperationException();
    }

    public abstract void disconnect();

    public abstract void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    @NonNull
    public abstract ConnectionResult getConnectionResult(@NonNull Api<?> api);

    public Context getContext() {
        throw new UnsupportedOperationException();
    }

    public Looper getLooper() {
        throw new UnsupportedOperationException();
    }

    public abstract boolean hasConnectedApi(@NonNull Api<?> api);

    public abstract boolean isConnected();

    public abstract boolean isConnecting();

    public abstract boolean isConnectionCallbacksRegistered(@NonNull ConnectionCallbacks connectionCallbacks);

    public abstract boolean isConnectionFailedListenerRegistered(@NonNull OnConnectionFailedListener onConnectionFailedListener);

    public abstract void reconnect();

    public abstract void registerConnectionCallbacks(@NonNull ConnectionCallbacks connectionCallbacks);

    public abstract void registerConnectionFailedListener(@NonNull OnConnectionFailedListener onConnectionFailedListener);

    public abstract void stopAutoManage(@NonNull FragmentActivity fragmentActivity);

    public abstract void unregisterConnectionCallbacks(@NonNull ConnectionCallbacks connectionCallbacks);

    public abstract void unregisterConnectionFailedListener(@NonNull OnConnectionFailedListener onConnectionFailedListener);

    @NonNull
    public <C extends Api.zzb> C zza(@NonNull Api.zzc<C> zzc) {
        throw new UnsupportedOperationException();
    }

    public <A extends Api.zzb, R extends Result, T extends zza.C0426zza<R, A>> T zza(@NonNull T t) {
        throw new UnsupportedOperationException();
    }

    public void zza(com.google.android.gms.common.api.internal.zzx zzx) {
        throw new UnsupportedOperationException();
    }

    public boolean zza(@NonNull Api<?> api) {
        throw new UnsupportedOperationException();
    }

    public boolean zza(zzu zzu) {
        throw new UnsupportedOperationException();
    }

    public <A extends Api.zzb, T extends zza.C0426zza<? extends Result, A>> T zzb(@NonNull T t) {
        throw new UnsupportedOperationException();
    }

    public void zzb(com.google.android.gms.common.api.internal.zzx zzx) {
        throw new UnsupportedOperationException();
    }

    public void zzoW() {
        throw new UnsupportedOperationException();
    }

    public <L> zzq<L> zzr(@NonNull L l) {
        throw new UnsupportedOperationException();
    }
}
