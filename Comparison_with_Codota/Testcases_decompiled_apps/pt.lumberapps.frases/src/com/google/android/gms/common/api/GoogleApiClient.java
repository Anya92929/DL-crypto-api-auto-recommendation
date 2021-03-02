package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.p009v4.app.FragmentActivity;
import android.support.p009v4.p019f.C0136a;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.internal.zzpk;
import com.google.android.gms.internal.zzpm;
import com.google.android.gms.internal.zzqi;
import com.google.android.gms.internal.zzqn;
import com.google.android.gms.internal.zzqt;
import com.google.android.gms.internal.zzqx;
import com.google.android.gms.internal.zzvt;
import com.google.android.gms.internal.zzvv;
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

public abstract class GoogleApiClient {
    public static final int SIGN_IN_MODE_OPTIONAL = 2;
    public static final int SIGN_IN_MODE_REQUIRED = 1;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final Set f4305a = Collections.newSetFromMap(new WeakHashMap());

    public final class Builder {

        /* renamed from: a */
        private Account f4306a;

        /* renamed from: b */
        private final Set f4307b;

        /* renamed from: c */
        private final Set f4308c;

        /* renamed from: d */
        private int f4309d;

        /* renamed from: e */
        private View f4310e;

        /* renamed from: f */
        private String f4311f;

        /* renamed from: g */
        private String f4312g;

        /* renamed from: h */
        private final Map f4313h;

        /* renamed from: i */
        private final Context f4314i;

        /* renamed from: j */
        private final Map f4315j;

        /* renamed from: k */
        private zzqi f4316k;

        /* renamed from: l */
        private int f4317l;

        /* renamed from: m */
        private OnConnectionFailedListener f4318m;

        /* renamed from: n */
        private Looper f4319n;

        /* renamed from: o */
        private GoogleApiAvailability f4320o;

        /* renamed from: p */
        private Api.zza f4321p;

        /* renamed from: q */
        private final ArrayList f4322q;

        /* renamed from: r */
        private final ArrayList f4323r;

        public Builder(Context context) {
            this.f4307b = new HashSet();
            this.f4308c = new HashSet();
            this.f4313h = new C0136a();
            this.f4315j = new C0136a();
            this.f4317l = -1;
            this.f4320o = GoogleApiAvailability.getInstance();
            this.f4321p = zzvt.f7030bK;
            this.f4322q = new ArrayList();
            this.f4323r = new ArrayList();
            this.f4314i = context;
            this.f4319n = context.getMainLooper();
            this.f4311f = context.getPackageName();
            this.f4312g = context.getClass().getName();
        }

        public Builder(Context context, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            this(context);
            zzab.zzb((Object) connectionCallbacks, (Object) "Must provide a connected listener");
            this.f4322q.add(connectionCallbacks);
            zzab.zzb((Object) onConnectionFailedListener, (Object) "Must provide a connection failed listener");
            this.f4323r.add(onConnectionFailedListener);
        }

        /* renamed from: a */
        private static Api.zze m5968a(Api.zza zza, Object obj, Context context, Looper looper, zzg zzg, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return zza.zza(context, looper, zzg, obj, connectionCallbacks, onConnectionFailedListener);
        }

        /* renamed from: a */
        private Builder m5969a(zzqi zzqi, int i, OnConnectionFailedListener onConnectionFailedListener) {
            zzab.zzb(i >= 0, (Object) "clientId must be non-negative");
            this.f4317l = i;
            this.f4318m = onConnectionFailedListener;
            this.f4316k = zzqi;
            return this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.google.android.gms.common.api.Api} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v23, resolved type: com.google.android.gms.common.internal.zzah} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private com.google.android.gms.common.api.GoogleApiClient m5970a() {
            /*
                r15 = this;
                com.google.android.gms.common.internal.zzg r4 = r15.zzaoh()
                r9 = 0
                r0 = 0
                java.util.Map r12 = r4.zzasl()
                android.support.v4.f.a r7 = new android.support.v4.f.a
                r7.<init>()
                android.support.v4.f.a r10 = new android.support.v4.f.a
                r10.<init>()
                java.util.ArrayList r13 = new java.util.ArrayList
                r13.<init>()
                java.util.Map r1 = r15.f4315j
                java.util.Set r1 = r1.keySet()
                java.util.Iterator r14 = r1.iterator()
                r2 = r0
            L_0x0024:
                boolean r0 = r14.hasNext()
                if (r0 == 0) goto L_0x00e3
                java.lang.Object r0 = r14.next()
                r8 = r0
                com.google.android.gms.common.api.Api r8 = (com.google.android.gms.common.api.Api) r8
                java.util.Map r0 = r15.f4315j
                java.lang.Object r1 = r0.get(r8)
                r0 = 0
                java.lang.Object r3 = r12.get(r8)
                if (r3 == 0) goto L_0x0049
                java.lang.Object r0 = r12.get(r8)
                com.google.android.gms.common.internal.zzg$zza r0 = (com.google.android.gms.common.internal.zzg.zza) r0
                boolean r0 = r0.f4583yn
                if (r0 == 0) goto L_0x00c4
                r0 = 1
            L_0x0049:
                java.lang.Integer r3 = java.lang.Integer.valueOf(r0)
                r7.put(r8, r3)
                com.google.android.gms.internal.zzpp r5 = new com.google.android.gms.internal.zzpp
                r5.<init>(r8, r0)
                r13.add(r5)
                boolean r0 = r8.zzant()
                if (r0 == 0) goto L_0x00c6
                com.google.android.gms.common.api.Api$zzh r0 = r8.zzanr()
                int r3 = r0.getPriority()
                r6 = 1
                if (r3 != r6) goto L_0x0179
                r11 = r8
            L_0x006a:
                android.content.Context r2 = r15.f4314i
                android.os.Looper r3 = r15.f4319n
                r6 = r5
                com.google.android.gms.common.internal.zzah r0 = m5971a((com.google.android.gms.common.api.Api.zzh) r0, (java.lang.Object) r1, (android.content.Context) r2, (android.os.Looper) r3, (com.google.android.gms.common.internal.zzg) r4, (com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks) r5, (com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener) r6)
                r1 = r0
                r0 = r11
            L_0x0075:
                com.google.android.gms.common.api.Api$zzc r2 = r8.zzans()
                r10.put(r2, r1)
                boolean r1 = r1.zzafz()
                if (r1 == 0) goto L_0x00de
                if (r9 == 0) goto L_0x00df
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r1 = r8.getName()
                java.lang.String r1 = java.lang.String.valueOf(r1)
                java.lang.String r2 = r9.getName()
                java.lang.String r2 = java.lang.String.valueOf(r2)
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                java.lang.String r4 = java.lang.String.valueOf(r1)
                int r4 = r4.length()
                int r4 = r4 + 21
                java.lang.String r5 = java.lang.String.valueOf(r2)
                int r5 = r5.length()
                int r4 = r4 + r5
                r3.<init>(r4)
                java.lang.StringBuilder r1 = r3.append(r1)
                java.lang.String r3 = " cannot be used with "
                java.lang.StringBuilder r1 = r1.append(r3)
                java.lang.StringBuilder r1 = r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            L_0x00c4:
                r0 = 2
                goto L_0x0049
            L_0x00c6:
                com.google.android.gms.common.api.Api$zza r0 = r8.zzanq()
                int r3 = r0.getPriority()
                r6 = 1
                if (r3 != r6) goto L_0x0176
                r11 = r8
            L_0x00d2:
                android.content.Context r2 = r15.f4314i
                android.os.Looper r3 = r15.f4319n
                r6 = r5
                com.google.android.gms.common.api.Api$zze r0 = m5968a((com.google.android.gms.common.api.Api.zza) r0, (java.lang.Object) r1, (android.content.Context) r2, (android.os.Looper) r3, (com.google.android.gms.common.internal.zzg) r4, (com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks) r5, (com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener) r6)
                r1 = r0
                r0 = r11
                goto L_0x0075
            L_0x00de:
                r8 = r9
            L_0x00df:
                r2 = r0
                r9 = r8
                goto L_0x0024
            L_0x00e3:
                if (r9 == 0) goto L_0x0152
                if (r2 == 0) goto L_0x0127
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r1 = r9.getName()
                java.lang.String r1 = java.lang.String.valueOf(r1)
                java.lang.String r2 = r2.getName()
                java.lang.String r2 = java.lang.String.valueOf(r2)
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                java.lang.String r4 = java.lang.String.valueOf(r1)
                int r4 = r4.length()
                int r4 = r4 + 21
                java.lang.String r5 = java.lang.String.valueOf(r2)
                int r5 = r5.length()
                int r4 = r4 + r5
                r3.<init>(r4)
                java.lang.StringBuilder r1 = r3.append(r1)
                java.lang.String r3 = " cannot be used with "
                java.lang.StringBuilder r1 = r1.append(r3)
                java.lang.StringBuilder r1 = r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            L_0x0127:
                android.accounts.Account r0 = r15.f4306a
                if (r0 != 0) goto L_0x0174
                r0 = 1
            L_0x012c:
                java.lang.String r1 = "Must not set an account in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead"
                r2 = 1
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r5 = r9.getName()
                r2[r3] = r5
                com.google.android.gms.common.internal.zzab.zza(r0, r1, r2)
                java.util.Set r0 = r15.f4307b
                java.util.Set r1 = r15.f4308c
                boolean r0 = r0.equals(r1)
                java.lang.String r1 = "Must not set scopes in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead."
                r2 = 1
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r5 = r9.getName()
                r2[r3] = r5
                com.google.android.gms.common.internal.zzab.zza(r0, r1, r2)
            L_0x0152:
                java.util.Collection r0 = r10.values()
                r1 = 1
                int r12 = com.google.android.gms.internal.zzpy.zza(r0, r1)
                com.google.android.gms.internal.zzpy r0 = new com.google.android.gms.internal.zzpy
                android.content.Context r1 = r15.f4314i
                java.util.concurrent.locks.ReentrantLock r2 = new java.util.concurrent.locks.ReentrantLock
                r2.<init>()
                android.os.Looper r3 = r15.f4319n
                com.google.android.gms.common.GoogleApiAvailability r5 = r15.f4320o
                com.google.android.gms.common.api.Api$zza r6 = r15.f4321p
                java.util.ArrayList r8 = r15.f4322q
                java.util.ArrayList r9 = r15.f4323r
                int r11 = r15.f4317l
                r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
                return r0
            L_0x0174:
                r0 = 0
                goto L_0x012c
            L_0x0176:
                r11 = r2
                goto L_0x00d2
            L_0x0179:
                r11 = r2
                goto L_0x006a
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.GoogleApiClient.Builder.m5970a():com.google.android.gms.common.api.GoogleApiClient");
        }

        /* renamed from: a */
        private static zzah m5971a(Api.zzh zzh, Object obj, Context context, Looper looper, zzg zzg, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzah(context, looper, zzh.zzanw(), connectionCallbacks, onConnectionFailedListener, zzg, zzh.zzr(obj));
        }

        /* renamed from: a */
        private void m5972a(Api api, Api.ApiOptions apiOptions, int i, Scope... scopeArr) {
            boolean z = true;
            if (i != 1) {
                if (i == 2) {
                    z = false;
                } else {
                    throw new IllegalArgumentException(new StringBuilder(90).append("Invalid resolution mode: '").append(i).append("', use a constant from GoogleApiClient.ResolutionMode").toString());
                }
            }
            HashSet hashSet = new HashSet(api.zzanp().zzp(apiOptions));
            for (Scope add : scopeArr) {
                hashSet.add(add);
            }
            this.f4313h.put(api, new zzg.zza(hashSet, z));
        }

        /* renamed from: a */
        private void m5973a(GoogleApiClient googleApiClient) {
            zzpk.zza(this.f4316k).zza(this.f4317l, googleApiClient, this.f4318m);
        }

        public Builder addApi(Api api) {
            zzab.zzb((Object) api, (Object) "Api must not be null");
            this.f4315j.put(api, (Object) null);
            List zzp = api.zzanp().zzp((Object) null);
            this.f4308c.addAll(zzp);
            this.f4307b.addAll(zzp);
            return this;
        }

        public Builder addApi(Api api, Api.ApiOptions.HasOptions hasOptions) {
            zzab.zzb((Object) api, (Object) "Api must not be null");
            zzab.zzb((Object) hasOptions, (Object) "Null options are not permitted for this Api");
            this.f4315j.put(api, hasOptions);
            List zzp = api.zzanp().zzp(hasOptions);
            this.f4308c.addAll(zzp);
            this.f4307b.addAll(zzp);
            return this;
        }

        public Builder addApiIfAvailable(Api api, Api.ApiOptions.HasOptions hasOptions, Scope... scopeArr) {
            zzab.zzb((Object) api, (Object) "Api must not be null");
            zzab.zzb((Object) hasOptions, (Object) "Null options are not permitted for this Api");
            this.f4315j.put(api, hasOptions);
            m5972a(api, hasOptions, 1, scopeArr);
            return this;
        }

        public Builder addApiIfAvailable(Api api, Scope... scopeArr) {
            zzab.zzb((Object) api, (Object) "Api must not be null");
            this.f4315j.put(api, (Object) null);
            m5972a(api, (Api.ApiOptions) null, 1, scopeArr);
            return this;
        }

        public Builder addConnectionCallbacks(ConnectionCallbacks connectionCallbacks) {
            zzab.zzb((Object) connectionCallbacks, (Object) "Listener must not be null");
            this.f4322q.add(connectionCallbacks);
            return this;
        }

        public Builder addOnConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener) {
            zzab.zzb((Object) onConnectionFailedListener, (Object) "Listener must not be null");
            this.f4323r.add(onConnectionFailedListener);
            return this;
        }

        public Builder addScope(Scope scope) {
            zzab.zzb((Object) scope, (Object) "Scope must not be null");
            this.f4307b.add(scope);
            return this;
        }

        public GoogleApiClient build() {
            zzab.zzb(!this.f4315j.isEmpty(), (Object) "must call addApi() to add at least one API");
            GoogleApiClient a = m5970a();
            synchronized (GoogleApiClient.f4305a) {
                GoogleApiClient.f4305a.add(a);
            }
            if (this.f4317l >= 0) {
                m5973a(a);
            }
            return a;
        }

        public Builder enableAutoManage(FragmentActivity fragmentActivity, int i, OnConnectionFailedListener onConnectionFailedListener) {
            return m5969a(new zzqi(fragmentActivity), i, onConnectionFailedListener);
        }

        public Builder enableAutoManage(FragmentActivity fragmentActivity, OnConnectionFailedListener onConnectionFailedListener) {
            return enableAutoManage(fragmentActivity, 0, onConnectionFailedListener);
        }

        public Builder setAccountName(String str) {
            this.f4306a = str == null ? null : new Account(str, "com.google");
            return this;
        }

        public Builder setGravityForPopups(int i) {
            this.f4309d = i;
            return this;
        }

        public Builder setHandler(Handler handler) {
            zzab.zzb((Object) handler, (Object) "Handler must not be null");
            this.f4319n = handler.getLooper();
            return this;
        }

        public Builder setViewForPopups(View view) {
            zzab.zzb((Object) view, (Object) "View must not be null");
            this.f4310e = view;
            return this;
        }

        public Builder useDefaultAccount() {
            return setAccountName("<<default account>>");
        }

        public zzg zzaoh() {
            zzvv zzvv = zzvv.atR;
            if (this.f4315j.containsKey(zzvt.API)) {
                zzvv = (zzvv) this.f4315j.get(zzvt.API);
            }
            return new zzg(this.f4306a, this.f4307b, this.f4313h, this.f4309d, this.f4310e, this.f4311f, this.f4312g, zzvv);
        }
    }

    public interface ConnectionCallbacks {
        public static final int CAUSE_NETWORK_LOST = 2;
        public static final int CAUSE_SERVICE_DISCONNECTED = 1;

        void onConnected(Bundle bundle);

        void onConnectionSuspended(int i);
    }

    public interface OnConnectionFailedListener {
        void onConnectionFailed(ConnectionResult connectionResult);
    }

    public static void dumpAll(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        synchronized (f4305a) {
            String concat = String.valueOf(str).concat("  ");
            int i = 0;
            for (GoogleApiClient dump : f4305a) {
                printWriter.append(str).append("GoogleApiClient#").println(i);
                dump.dump(concat, fileDescriptor, printWriter, strArr);
                i++;
            }
        }
    }

    public static Set zzaoe() {
        Set set;
        synchronized (f4305a) {
            set = f4305a;
        }
        return set;
    }

    public abstract ConnectionResult blockingConnect();

    public abstract ConnectionResult blockingConnect(long j, TimeUnit timeUnit);

    public abstract PendingResult clearDefaultAccountAndReconnect();

    public abstract void connect();

    public void connect(int i) {
        throw new UnsupportedOperationException();
    }

    public abstract void disconnect();

    public abstract void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract ConnectionResult getConnectionResult(Api api);

    public Context getContext() {
        throw new UnsupportedOperationException();
    }

    public Looper getLooper() {
        throw new UnsupportedOperationException();
    }

    public abstract boolean hasConnectedApi(Api api);

    public abstract boolean isConnected();

    public abstract boolean isConnecting();

    public abstract boolean isConnectionCallbacksRegistered(ConnectionCallbacks connectionCallbacks);

    public abstract boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener onConnectionFailedListener);

    public abstract void reconnect();

    public abstract void registerConnectionCallbacks(ConnectionCallbacks connectionCallbacks);

    public abstract void registerConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener);

    public abstract void stopAutoManage(FragmentActivity fragmentActivity);

    public abstract void unregisterConnectionCallbacks(ConnectionCallbacks connectionCallbacks);

    public abstract void unregisterConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener);

    public Api.zze zza(Api.zzc zzc) {
        throw new UnsupportedOperationException();
    }

    public void zza(zzqx zzqx) {
        throw new UnsupportedOperationException();
    }

    public boolean zza(Api api) {
        throw new UnsupportedOperationException();
    }

    public boolean zza(zzqt zzqt) {
        throw new UnsupportedOperationException();
    }

    public void zzaof() {
        throw new UnsupportedOperationException();
    }

    public void zzb(zzqx zzqx) {
        throw new UnsupportedOperationException();
    }

    public zzpm.zza zzc(zzpm.zza zza) {
        throw new UnsupportedOperationException();
    }

    public zzpm.zza zzd(zzpm.zza zza) {
        throw new UnsupportedOperationException();
    }

    public zzqn zzs(Object obj) {
        throw new UnsupportedOperationException();
    }
}
