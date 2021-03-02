package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.BleApi;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.request.BleScanCallback;
import com.google.android.gms.fitness.request.C0647ac;
import com.google.android.gms.fitness.request.C0658b;
import com.google.android.gms.fitness.request.StartBleScanRequest;
import com.google.android.gms.fitness.request.UnclaimBleDeviceRequest;
import com.google.android.gms.fitness.result.BleDevicesResult;
import com.google.android.gms.internal.C1415kj;
import com.google.android.gms.internal.C1490le;

/* renamed from: com.google.android.gms.internal.kw */
public class C1448kw implements BleApi {

    /* renamed from: com.google.android.gms.internal.kw$a */
    private static class C1455a extends C1490le.C1491a {

        /* renamed from: De */
        private final BaseImplementation.C0270b<BleDevicesResult> f4209De;

        private C1455a(BaseImplementation.C0270b<BleDevicesResult> bVar) {
            this.f4209De = bVar;
        }

        /* renamed from: a */
        public void mo9161a(BleDevicesResult bleDevicesResult) {
            this.f4209De.mo4196b(bleDevicesResult);
        }
    }

    public PendingResult<Status> claimBleDevice(GoogleApiClient client, final BleDevice bleDevice) {
        return client.mo4219a(new C1415kj.C1418c() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(C1415kj kjVar) throws RemoteException {
                kjVar.mo9097iT().mo9125a(new C0658b(bleDevice), (C1442ks) new C1415kj.C1417b(this), kjVar.getContext().getPackageName());
            }
        });
    }

    public PendingResult<Status> claimBleDevice(GoogleApiClient client, final String deviceAddress) {
        return client.mo4219a(new C1415kj.C1418c() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(C1415kj kjVar) throws RemoteException {
                kjVar.mo9097iT().mo9125a(new C0658b(deviceAddress), (C1442ks) new C1415kj.C1417b(this), kjVar.getContext().getPackageName());
            }
        });
    }

    public PendingResult<BleDevicesResult> listClaimedBleDevices(GoogleApiClient client) {
        return client.mo4219a(new C1415kj.C1416a<BleDevicesResult>() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(C1415kj kjVar) throws RemoteException {
                kjVar.mo9097iT().mo9135a((C1490le) new C1455a(this), kjVar.getContext().getPackageName());
            }

            /* access modifiers changed from: protected */
            /* renamed from: w */
            public BleDevicesResult mo3773c(Status status) {
                return BleDevicesResult.m2081D(status);
            }
        });
    }

    public PendingResult<Status> startBleScan(GoogleApiClient client, final StartBleScanRequest request) {
        return client.mo4219a(new C1415kj.C1418c() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(C1415kj kjVar) throws RemoteException {
                kjVar.mo9097iT().mo9120a(request, (C1442ks) new C1415kj.C1417b(this), kjVar.getContext().getPackageName());
            }
        });
    }

    public PendingResult<Status> stopBleScan(GoogleApiClient client, final BleScanCallback requestCallback) {
        return client.mo4219a(new C1415kj.C1418c() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(C1415kj kjVar) throws RemoteException {
                C1415kj.C1417b bVar = new C1415kj.C1417b(this);
                String packageName = kjVar.getContext().getPackageName();
                kjVar.mo9097iT().mo9122a(new C0647ac(requestCallback), (C1442ks) bVar, packageName);
            }
        });
    }

    public PendingResult<Status> unclaimBleDevice(GoogleApiClient client, BleDevice bleDevice) {
        return unclaimBleDevice(client, bleDevice.getAddress());
    }

    public PendingResult<Status> unclaimBleDevice(GoogleApiClient client, final String deviceAddress) {
        return client.mo4219a(new C1415kj.C1418c() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(C1415kj kjVar) throws RemoteException {
                kjVar.mo9097iT().mo9121a(new UnclaimBleDeviceRequest(deviceAddress), (C1442ks) new C1415kj.C1417b(this), kjVar.getContext().getPackageName());
            }
        });
    }
}
