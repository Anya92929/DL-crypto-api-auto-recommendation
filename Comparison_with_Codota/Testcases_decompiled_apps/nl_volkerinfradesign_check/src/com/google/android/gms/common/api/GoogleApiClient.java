package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.p001v4.app.FragmentActivity;
import android.support.p001v4.util.ArrayMap;
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

    /* renamed from: a */
    public static final Set<GoogleApiClient> f2623a = Collections.newSetFromMap(new WeakHashMap());

    public static final class Builder {

        /* renamed from: a */
        private Account f2624a;

        /* renamed from: b */
        private final Set<Scope> f2625b;

        /* renamed from: c */
        private final Set<Scope> f2626c;

        /* renamed from: d */
        private int f2627d;

        /* renamed from: e */
        private View f2628e;

        /* renamed from: f */
        private String f2629f;

        /* renamed from: g */
        private String f2630g;

        /* renamed from: h */
        private final Map<Api<?>, zzf.zza> f2631h;

        /* renamed from: i */
        private final Context f2632i;

        /* renamed from: j */
        private final Map<Api<?>, Api.ApiOptions> f2633j;
        /* access modifiers changed from: private */

        /* renamed from: k */
        public FragmentActivity f2634k;

        /* renamed from: l */
        private int f2635l;

        /* renamed from: m */
        private OnConnectionFailedListener f2636m;

        /* renamed from: n */
        private Looper f2637n;

        /* renamed from: o */
        private zzc f2638o;

        /* renamed from: p */
        private Api.zza<? extends zzrn, zzro> f2639p;

        /* renamed from: q */
        private final ArrayList<ConnectionCallbacks> f2640q;

        /* renamed from: r */
        private final ArrayList<OnConnectionFailedListener> f2641r;

        public Builder(@NonNull Context context) {
            this.f2625b = new HashSet();
            this.f2626c = new HashSet();
            this.f2631h = new ArrayMap();
            this.f2633j = new ArrayMap();
            this.f2635l = -1;
            this.f2638o = zzc.zzoK();
            this.f2639p = zzrl.zzUJ;
            this.f2640q = new ArrayList<>();
            this.f2641r = new ArrayList<>();
            this.f2632i = context;
            this.f2637n = context.getMainLooper();
            this.f2629f = context.getPackageName();
            this.f2630g = context.getClass().getName();
        }

        public Builder(@NonNull Context context, @NonNull ConnectionCallbacks connectionCallbacks, @NonNull OnConnectionFailedListener onConnectionFailedListener) {
            this(context);
            zzx.zzb(connectionCallbacks, (Object) "Must provide a connected listener");
            this.f2640q.add(connectionCallbacks);
            zzx.zzb(onConnectionFailedListener, (Object) "Must provide a connection failed listener");
            this.f2641r.add(onConnectionFailedListener);
        }

        /* renamed from: a */
        private static <C extends Api.zzb, O> C m3703a(Api.zza<C, O> zza, Object obj, Context context, Looper looper, zzf zzf, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return zza.zza(context, looper, zzf, obj, connectionCallbacks, onConnectionFailedListener);
        }

        /* renamed from: a */
        private GoogleApiClient m3704a() {
            zzad a;
            Api api;
            zzf zzoY = zzoY();
            Api api2 = null;
            Map<Api<?>, zzf.zza> zzqu = zzoY.zzqu();
            ArrayMap arrayMap = new ArrayMap();
            ArrayMap arrayMap2 = new ArrayMap();
            ArrayList arrayList = new ArrayList();
            Api api3 = null;
            for (Api next : this.f2633j.keySet()) {
                Api.ApiOptions apiOptions = this.f2633j.get(next);
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
                    a = m3705a(zzoQ, (Object) apiOptions, this.f2632i, this.f2637n, zzoY, (ConnectionCallbacks) zzc, (OnConnectionFailedListener) zzc);
                    api = api4;
                } else {
                    Api.zza zzoP = next.zzoP();
                    Api api5 = zzoP.getPriority() == 1 ? next : api3;
                    a = m3703a(zzoP, (Object) apiOptions, this.f2632i, this.f2637n, zzoY, (ConnectionCallbacks) zzc, (OnConnectionFailedListener) zzc);
                    api = api5;
                }
                arrayMap2.put(next.zzoR(), a);
                if (!a.zznb()) {
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
                zzx.zza(this.f2624a == null, "Must not set an account in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead", api2.getName());
                zzx.zza(this.f2625b.equals(this.f2626c), "Must not set scopes in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead.", api2.getName());
            }
            return new zzj(this.f2632i, new ReentrantLock(), this.f2637n, zzoY, this.f2638o, this.f2639p, arrayMap, this.f2640q, this.f2641r, arrayMap2, this.f2635l, zzj.zza(arrayMap2.values(), true), arrayList);
        }

        /* renamed from: a */
        private static <C extends Api.zzd, O> zzad m3705a(Api.zze<C, O> zze, Object obj, Context context, Looper looper, zzf zzf, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzad(context, looper, zze.zzoU(), connectionCallbacks, onConnectionFailedListener, zzf, zze.zzq(obj));
        }

        /* renamed from: a */
        private <O extends Api.ApiOptions> void m3706a(Api<O> api, O o, int i, Scope... scopeArr) {
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
            this.f2631h.put(api, new zzf.zza(hashSet, z));
        }

        /* renamed from: a */
        private void m3708a(final GoogleApiClient googleApiClient) {
            zzw zza = zzw.zza(this.f2634k);
            if (zza == null) {
                new Handler(this.f2632i.getMainLooper()).post(new Runnable() {
                    public void run() {
                        if (!Builder.this.f2634k.isFinishing() && !Builder.this.f2634k.getSupportFragmentManager().isDestroyed()) {
                            Builder.this.m3709a(zzw.zzb(Builder.this.f2634k), googleApiClient);
                        }
                    }
                });
            } else {
                m3709a(zza, googleApiClient);
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m3709a(zzw zzw, GoogleApiClient googleApiClient) {
            zzw.zza(this.f2635l, googleApiClient, this.f2636m);
        }

        public Builder addApi(@NonNull Api<? extends Api.ApiOptions.NotRequiredOptions> api) {
            zzx.zzb(api, (Object) "Api must not be null");
            this.f2633j.put(api, (Object) null);
            List<Scope> zzo = api.zzoP().zzo(null);
            this.f2626c.addAll(zzo);
            this.f2625b.addAll(zzo);
            return this;
        }

        public <O extends Api.ApiOptions.HasOptions> Builder addApi(@NonNull Api<O> api, @NonNull O o) {
            zzx.zzb(api, (Object) "Api must not be null");
            zzx.zzb(o, (Object) "Null options are not permitted for this Api");
            this.f2633j.put(api, o);
            List<Scope> zzo = api.zzoP().zzo(o);
            this.f2626c.addAll(zzo);
            this.f2625b.addAll(zzo);
            return this;
        }

        public <O extends Api.ApiOptions.HasOptions> Builder addApiIfAvailable(@NonNull Api<O> api, @NonNull O o, Scope... scopeArr) {
            zzx.zzb(api, (Object) "Api must not be null");
            zzx.zzb(o, (Object) "Null options are not permitted for this Api");
            this.f2633j.put(api, o);
            m3706a(api, o, 1, scopeArr);
            return this;
        }

        public Builder addApiIfAvailable(@NonNull Api<? extends Api.ApiOptions.NotRequiredOptions> api, Scope... scopeArr) {
            zzx.zzb(api, (Object) "Api must not be null");
            this.f2633j.put(api, (Object) null);
            m3706a(api, (Api.ApiOptions) null, 1, scopeArr);
            return this;
        }

        public Builder addConnectionCallbacks(@NonNull ConnectionCallbacks connectionCallbacks) {
            zzx.zzb(connectionCallbacks, (Object) "Listener must not be null");
            this.f2640q.add(connectionCallbacks);
            return this;
        }

        public Builder addOnConnectionFailedListener(@NonNull OnConnectionFailedListener onConnectionFailedListener) {
            zzx.zzb(onConnectionFailedListener, (Object) "Listener must not be null");
            this.f2641r.add(onConnectionFailedListener);
            return this;
        }

        public Builder addScope(@NonNull Scope scope) {
            zzx.zzb(scope, (Object) "Scope must not be null");
            this.f2625b.add(scope);
            return this;
        }

        public GoogleApiClient build() {
            zzx.zzb(!this.f2633j.isEmpty(), (Object) "must call addApi() to add at least one API");
            GoogleApiClient a = m3704a();
            synchronized (GoogleApiClient.f2623a) {
                GoogleApiClient.f2623a.add(a);
            }
            if (this.f2635l >= 0) {
                m3708a(a);
            }
            return a;
        }

        public Builder enableAutoManage(@NonNull FragmentActivity fragmentActivity, int i, @Nullable OnConnectionFailedListener onConnectionFailedListener) {
            zzx.zzb(i >= 0, (Object) "clientId must be non-negative");
            this.f2635l = i;
            this.f2634k = (FragmentActivity) zzx.zzb(fragmentActivity, (Object) "Null activity is not permitted.");
            this.f2636m = onConnectionFailedListener;
            return this;
        }

        public Builder enableAutoManage(@NonNull FragmentActivity fragmentActivity, @Nullable OnConnectionFailedListener onConnectionFailedListener) {
            return enableAutoManage(fragmentActivity, 0, onConnectionFailedListener);
        }

        public Builder setAccountName(String str) {
            this.f2624a = str == null ? null : new Account(str, "com.google");
            return this;
        }

        public Builder setGravityForPopups(int i) {
            this.f2627d = i;
            return this;
        }

        public Builder setHandler(@NonNull Handler handler) {
            zzx.zzb(handler, (Object) "Handler must not be null");
            this.f2637n = handler.getLooper();
            return this;
        }

        public Builder setViewForPopups(@NonNull View view) {
            zzx.zzb(view, (Object) "View must not be null");
            this.f2628e = view;
            return this;
        }

        public Builder useDefaultAccount() {
            return setAccountName("<<default account>>");
        }

        public zzf zzoY() {
            zzro zzro = zzro.zzbgV;
            if (this.f2633j.containsKey(zzrl.API)) {
                zzro = (zzro) this.f2633j.get(zzrl.API);
            }
            return new zzf(this.f2624a, this.f2625b, this.f2631h, this.f2627d, this.f2628e, this.f2629f, this.f2630g, zzro);
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

    public static void dumpAll(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        synchronized (f2623a) {
            String str2 = str + "  ";
            int i = 0;
            for (GoogleApiClient dump : f2623a) {
                printWriter.append(str).append("GoogleApiClient#").println(i);
                dump.dump(str2, fileDescriptor, printWriter, strArr);
                i++;
            }
        }
    }

    public static Set<GoogleApiClient> zzoV() {
        return f2623a;
    }

    public abstract ConnectionResult blockingConnect();

    public abstract ConnectionResult blockingConnect(long j, @NonNull TimeUnit timeUnit);

    public abstract PendingResult<Status> clearDefaultAccountAndReconnect();

    public abstract void connect();

    public void connect(int i) {
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

    public <A extends Api.zzb, R extends Result, T extends zza.C2020zza<R, A>> T zza(@NonNull T t) {
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

    public <A extends Api.zzb, T extends zza.C2020zza<? extends Result, A>> T zzb(@NonNull T t) {
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
