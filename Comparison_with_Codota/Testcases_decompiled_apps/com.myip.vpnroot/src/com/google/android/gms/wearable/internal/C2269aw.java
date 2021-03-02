package com.google.android.gms.wearable.internal;

import android.content.Context;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.C0316d;
import com.google.android.gms.common.internal.C0339k;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.DataItemAsset;
import com.google.android.gms.wearable.DataItemBuffer;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.PutDataRequest;
import com.google.android.gms.wearable.internal.C2240af;
import com.google.android.gms.wearable.internal.C2243ag;
import com.google.android.gms.wearable.internal.C2250aj;
import com.google.android.gms.wearable.internal.C2290f;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/* renamed from: com.google.android.gms.wearable.internal.aw */
public class C2269aw extends C0316d<C2240af> {
    private final ExecutorService aqp = Executors.newCachedThreadPool();
    /* access modifiers changed from: private */
    public final HashMap<DataApi.DataListener, C2285ax> avF = new HashMap<>();
    /* access modifiers changed from: private */
    public final HashMap<MessageApi.MessageListener, C2285ax> avG = new HashMap<>();
    /* access modifiers changed from: private */
    public final HashMap<NodeApi.NodeListener, C2285ax> avH = new HashMap<>();

    /* renamed from: com.google.android.gms.wearable.internal.aw$a */
    private static class C2284a extends C2230a {

        /* renamed from: De */
        private final BaseImplementation.C0270b<DataApi.DataItemResult> f4680De;
        private final List<FutureTask<Boolean>> avL;

        C2284a(BaseImplementation.C0270b<DataApi.DataItemResult> bVar, List<FutureTask<Boolean>> list) {
            this.f4680De = bVar;
            this.avL = list;
        }

        /* renamed from: a */
        public void mo12328a(C2261ao aoVar) {
            this.f4680De.mo4196b(new C2290f.C2300a(new Status(aoVar.statusCode), aoVar.avp));
            if (aoVar.statusCode != 0) {
                for (FutureTask<Boolean> cancel : this.avL) {
                    cancel.cancel(true);
                }
            }
        }
    }

    public C2269aw(Context context, Looper looper, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, new String[0]);
    }

    /* renamed from: a */
    private FutureTask<Boolean> m7639a(final ParcelFileDescriptor parcelFileDescriptor, final byte[] bArr) {
        return new FutureTask<>(new Callable<Boolean>() {
            /* renamed from: pY */
            public Boolean call() {
                if (Log.isLoggable("WearableClient", 3)) {
                    Log.d("WearableClient", "processAssets: writing data to FD : " + parcelFileDescriptor);
                }
                ParcelFileDescriptor.AutoCloseOutputStream autoCloseOutputStream = new ParcelFileDescriptor.AutoCloseOutputStream(parcelFileDescriptor);
                try {
                    autoCloseOutputStream.write(bArr);
                    autoCloseOutputStream.flush();
                    if (Log.isLoggable("WearableClient", 3)) {
                        Log.d("WearableClient", "processAssets: wrote data: " + parcelFileDescriptor);
                    }
                    try {
                        if (Log.isLoggable("WearableClient", 3)) {
                            Log.d("WearableClient", "processAssets: closing: " + parcelFileDescriptor);
                        }
                        autoCloseOutputStream.close();
                        return true;
                    } catch (IOException e) {
                        return true;
                    }
                } catch (IOException e2) {
                    Log.w("WearableClient", "processAssets: writing data failed: " + parcelFileDescriptor);
                    try {
                        if (Log.isLoggable("WearableClient", 3)) {
                            Log.d("WearableClient", "processAssets: closing: " + parcelFileDescriptor);
                        }
                        autoCloseOutputStream.close();
                    } catch (IOException e3) {
                    }
                    return false;
                } catch (Throwable th) {
                    try {
                        if (Log.isLoggable("WearableClient", 3)) {
                            Log.d("WearableClient", "processAssets: closing: " + parcelFileDescriptor);
                        }
                        autoCloseOutputStream.close();
                    } catch (IOException e4) {
                    }
                    throw th;
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4429a(int i, IBinder iBinder, Bundle bundle) {
        if (Log.isLoggable("WearableClient", 2)) {
            Log.d("WearableClient", "onPostInitHandler: statusCode " + i);
        }
        if (i == 0) {
            try {
                C22701 r1 = new C2230a() {
                    /* renamed from: a */
                    public void mo12326a(Status status) {
                    }
                };
                if (Log.isLoggable("WearableClient", 2)) {
                    Log.d("WearableClient", "onPostInitHandler: service " + iBinder);
                }
                C2240af bT = C2240af.C2241a.m7565bT(iBinder);
                for (Map.Entry next : this.avF.entrySet()) {
                    if (Log.isLoggable("WearableClient", 2)) {
                        Log.d("WearableClient", "onPostInitHandler: adding Data listener " + next.getValue());
                    }
                    bT.mo12360a((C2234ad) r1, new C2286b((C2285ax) next.getValue()));
                }
                for (Map.Entry next2 : this.avG.entrySet()) {
                    if (Log.isLoggable("WearableClient", 2)) {
                        Log.d("WearableClient", "onPostInitHandler: adding Message listener " + next2.getValue());
                    }
                    bT.mo12360a((C2234ad) r1, new C2286b((C2285ax) next2.getValue()));
                }
                for (Map.Entry next3 : this.avH.entrySet()) {
                    if (Log.isLoggable("WearableClient", 2)) {
                        Log.d("WearableClient", "onPostInitHandler: adding Node listener " + next3.getValue());
                    }
                    bT.mo12360a((C2234ad) r1, new C2286b((C2285ax) next3.getValue()));
                }
            } catch (RemoteException e) {
                Log.d("WearableClient", "WearableClientImpl.onPostInitHandler: error while adding listener", e);
            }
        }
        Log.d("WearableClient", "WearableClientImpl.onPostInitHandler: done");
        super.mo4429a(i, iBinder, bundle);
    }

    /* renamed from: a */
    public void mo12439a(final BaseImplementation.C0270b<DataApi.DataItemResult> bVar, Uri uri) throws RemoteException {
        ((C2240af) mo4435gS()).mo12355a((C2234ad) new C2230a() {
            /* renamed from: a */
            public void mo12335a(C2320x xVar) {
                bVar.mo4196b(new C2290f.C2300a(new Status(xVar.statusCode), xVar.avp));
            }
        }, uri);
    }

    /* renamed from: a */
    public void mo12440a(final BaseImplementation.C0270b<DataApi.GetFdForAssetResult> bVar, Asset asset) throws RemoteException {
        ((C2240af) mo4435gS()).mo12356a((C2234ad) new C2230a() {
            /* renamed from: a */
            public void mo12336a(C2322z zVar) {
                bVar.mo4196b(new C2290f.C2302c(new Status(zVar.statusCode), zVar.avq));
            }
        }, asset);
    }

    /* renamed from: a */
    public void mo12441a(BaseImplementation.C0270b<Status> bVar, DataApi.DataListener dataListener) throws RemoteException {
        C2237ae remove;
        synchronized (this.avF) {
            remove = this.avF.remove(dataListener);
        }
        if (remove == null) {
            bVar.mo4196b(new Status(4002));
        } else {
            mo12448a(bVar, remove);
        }
    }

    /* renamed from: a */
    public void mo12442a(final BaseImplementation.C0270b<Status> bVar, final DataApi.DataListener dataListener, IntentFilter[] intentFilterArr) throws RemoteException {
        C2285ax a = C2285ax.m7679a(dataListener, intentFilterArr);
        synchronized (this.avF) {
            if (this.avF.get(dataListener) != null) {
                bVar.mo4196b(new Status(4001));
                return;
            }
            this.avF.put(dataListener, a);
            ((C2240af) mo4435gS()).mo12360a((C2234ad) new C2230a() {
                /* renamed from: a */
                public void mo12326a(Status status) {
                    if (!status.isSuccess()) {
                        synchronized (C2269aw.this.avF) {
                            C2269aw.this.avF.remove(dataListener);
                        }
                    }
                    bVar.mo4196b(status);
                }
            }, new C2286b(a));
        }
    }

    /* renamed from: a */
    public void mo12443a(BaseImplementation.C0270b<DataApi.GetFdForAssetResult> bVar, DataItemAsset dataItemAsset) throws RemoteException {
        mo12440a(bVar, Asset.createFromRef(dataItemAsset.getId()));
    }

    /* renamed from: a */
    public void mo12444a(BaseImplementation.C0270b<Status> bVar, MessageApi.MessageListener messageListener) throws RemoteException {
        synchronized (this.avG) {
            C2237ae remove = this.avG.remove(messageListener);
            if (remove == null) {
                bVar.mo4196b(new Status(4002));
            } else {
                mo12448a(bVar, remove);
            }
        }
    }

    /* renamed from: a */
    public void mo12445a(final BaseImplementation.C0270b<Status> bVar, final MessageApi.MessageListener messageListener, IntentFilter[] intentFilterArr) throws RemoteException {
        C2285ax a = C2285ax.m7680a(messageListener, intentFilterArr);
        synchronized (this.avG) {
            if (this.avG.get(messageListener) != null) {
                bVar.mo4196b(new Status(4001));
                return;
            }
            this.avG.put(messageListener, a);
            ((C2240af) mo4435gS()).mo12360a((C2234ad) new C2230a() {
                /* renamed from: a */
                public void mo12326a(Status status) {
                    if (!status.isSuccess()) {
                        synchronized (C2269aw.this.avG) {
                            C2269aw.this.avG.remove(messageListener);
                        }
                    }
                    bVar.mo4196b(status);
                }
            }, new C2286b(a));
        }
    }

    /* renamed from: a */
    public void mo12446a(final BaseImplementation.C0270b<Status> bVar, final NodeApi.NodeListener nodeListener) throws RemoteException, RemoteException {
        C2285ax a = C2285ax.m7681a(nodeListener);
        synchronized (this.avH) {
            if (this.avH.get(nodeListener) != null) {
                bVar.mo4196b(new Status(4001));
                return;
            }
            this.avH.put(nodeListener, a);
            ((C2240af) mo4435gS()).mo12360a((C2234ad) new C2230a() {
                /* renamed from: a */
                public void mo12326a(Status status) {
                    if (!status.isSuccess()) {
                        synchronized (C2269aw.this.avH) {
                            C2269aw.this.avH.remove(nodeListener);
                        }
                    }
                    bVar.mo4196b(status);
                }
            }, new C2286b(a));
        }
    }

    /* renamed from: a */
    public void mo12447a(BaseImplementation.C0270b<DataApi.DataItemResult> bVar, PutDataRequest putDataRequest) throws RemoteException {
        for (Map.Entry<String, Asset> value : putDataRequest.getAssets().entrySet()) {
            Asset asset = (Asset) value.getValue();
            if (asset.getData() == null && asset.getDigest() == null && asset.getFd() == null && asset.getUri() == null) {
                throw new IllegalArgumentException("Put for " + putDataRequest.getUri() + " contains invalid asset: " + asset);
            }
        }
        PutDataRequest k = PutDataRequest.m7465k(putDataRequest.getUri());
        k.setData(putDataRequest.getData());
        ArrayList arrayList = new ArrayList();
        for (Map.Entry next : putDataRequest.getAssets().entrySet()) {
            Asset asset2 = (Asset) next.getValue();
            if (asset2.getData() == null) {
                k.putAsset((String) next.getKey(), (Asset) next.getValue());
            } else {
                try {
                    ParcelFileDescriptor[] createPipe = ParcelFileDescriptor.createPipe();
                    if (Log.isLoggable("WearableClient", 3)) {
                        Log.d("WearableClient", "processAssets: replacing data with FD in asset: " + asset2 + " read:" + createPipe[0] + " write:" + createPipe[1]);
                    }
                    k.putAsset((String) next.getKey(), Asset.createFromFd(createPipe[0]));
                    FutureTask<Boolean> a = m7639a(createPipe[1], asset2.getData());
                    arrayList.add(a);
                    this.aqp.submit(a);
                } catch (IOException e) {
                    throw new IllegalStateException("Unable to create ParcelFileDescriptor for asset in request: " + putDataRequest, e);
                }
            }
        }
        try {
            ((C2240af) mo4435gS()).mo12357a((C2234ad) new C2284a(bVar, arrayList), k);
        } catch (NullPointerException e2) {
            throw new IllegalStateException("Unable to putDataItem: " + putDataRequest, e2);
        }
    }

    /* renamed from: a */
    public void mo12448a(final BaseImplementation.C0270b<Status> bVar, C2237ae aeVar) throws RemoteException {
        ((C2240af) mo4435gS()).mo12359a((C2234ad) new C2230a() {
            /* renamed from: a */
            public void mo12326a(Status status) {
                bVar.mo4196b(status);
            }
        }, new C2263aq(aeVar));
    }

    /* renamed from: a */
    public void mo12449a(final BaseImplementation.C0270b<MessageApi.SendMessageResult> bVar, String str, String str2, byte[] bArr) throws RemoteException {
        ((C2240af) mo4435gS()).mo12362a(new C2230a() {
            /* renamed from: a */
            public void mo12329a(C2265as asVar) {
                bVar.mo4196b(new C2243ag.C2247a(new Status(asVar.statusCode), asVar.avD));
            }
        }, str, str2, bArr);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3827a(C0339k kVar, C0316d.C0321e eVar) throws RemoteException {
        kVar.mo4521e(eVar, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, getContext().getPackageName());
    }

    /* renamed from: b */
    public void mo12450b(final BaseImplementation.C0270b<DataItemBuffer> bVar, Uri uri) throws RemoteException {
        ((C2240af) mo4435gS()).mo12364b((C2234ad) new C2230a() {
            /* renamed from: aa */
            public void mo12337aa(DataHolder dataHolder) {
                bVar.mo4196b(new DataItemBuffer(dataHolder));
            }
        }, uri);
    }

    /* renamed from: b */
    public void mo12451b(BaseImplementation.C0270b<Status> bVar, NodeApi.NodeListener nodeListener) throws RemoteException {
        synchronized (this.avH) {
            C2237ae remove = this.avH.remove(nodeListener);
            if (remove == null) {
                bVar.mo4196b(new Status(4002));
            } else {
                mo12448a(bVar, remove);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: bU */
    public C2240af mo3832j(IBinder iBinder) {
        return C2240af.C2241a.m7565bT(iBinder);
    }

    /* renamed from: c */
    public void mo12453c(final BaseImplementation.C0270b<DataApi.DeleteDataItemsResult> bVar, Uri uri) throws RemoteException {
        ((C2240af) mo4435gS()).mo12368c((C2234ad) new C2230a() {
            /* renamed from: a */
            public void mo12331a(C2312p pVar) {
                bVar.mo4196b(new C2290f.C2301b(new Status(pVar.statusCode), pVar.avl));
            }
        }, uri);
    }

    public void disconnect() {
        super.disconnect();
        this.avF.clear();
        this.avG.clear();
        this.avH.clear();
    }

    /* access modifiers changed from: protected */
    public String getServiceDescriptor() {
        return "com.google.android.gms.wearable.internal.IWearableService";
    }

    /* access modifiers changed from: protected */
    public String getStartServiceAction() {
        return "com.google.android.gms.wearable.BIND";
    }

    /* renamed from: o */
    public void mo12454o(final BaseImplementation.C0270b<DataItemBuffer> bVar) throws RemoteException {
        ((C2240af) mo4435gS()).mo12363b(new C2230a() {
            /* renamed from: aa */
            public void mo12337aa(DataHolder dataHolder) {
                bVar.mo4196b(new DataItemBuffer(dataHolder));
            }
        });
    }

    /* renamed from: p */
    public void mo12455p(final BaseImplementation.C0270b<NodeApi.GetLocalNodeResult> bVar) throws RemoteException {
        ((C2240af) mo4435gS()).mo12367c(new C2230a() {
            /* renamed from: a */
            public void mo12327a(C2232ab abVar) {
                bVar.mo4196b(new C2250aj.C2256b(new Status(abVar.statusCode), abVar.avr));
            }
        });
    }

    /* renamed from: q */
    public void mo12456q(final BaseImplementation.C0270b<NodeApi.GetConnectedNodesResult> bVar) throws RemoteException {
        ((C2240af) mo4435gS()).mo12370d(new C2230a() {
            /* renamed from: a */
            public void mo12334a(C2318v vVar) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(vVar.avo);
                bVar.mo4196b(new C2250aj.C2255a(new Status(vVar.statusCode), arrayList));
            }
        });
    }
}
