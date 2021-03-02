package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.BleApi;
import com.google.android.gms.fitness.FitnessStatusCodes;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.request.BleScanCallback;
import com.google.android.gms.fitness.request.StartBleScanRequest;
import com.google.android.gms.fitness.result.BleDevicesResult;

/* renamed from: com.google.android.gms.internal.ld */
public class C1489ld implements BleApi {

    /* renamed from: TT */
    private static final Status f4256TT = new Status(FitnessStatusCodes.UNSUPPORTED_PLATFORM);

    public PendingResult<Status> claimBleDevice(GoogleApiClient client, BleDevice bleDevice) {
        return new C1445kt(f4256TT);
    }

    public PendingResult<Status> claimBleDevice(GoogleApiClient client, String deviceAddress) {
        return new C1445kt(f4256TT);
    }

    public PendingResult<BleDevicesResult> listClaimedBleDevices(GoogleApiClient client) {
        return new C1445kt(BleDevicesResult.m2081D(f4256TT));
    }

    public PendingResult<Status> startBleScan(GoogleApiClient client, StartBleScanRequest request) {
        return new C1445kt(f4256TT);
    }

    public PendingResult<Status> stopBleScan(GoogleApiClient client, BleScanCallback callback) {
        return new C1445kt(f4256TT);
    }

    public PendingResult<Status> unclaimBleDevice(GoogleApiClient client, BleDevice bleDevice) {
        return new C1445kt(f4256TT);
    }

    public PendingResult<Status> unclaimBleDevice(GoogleApiClient client, String deviceAddress) {
        return new C1445kt(f4256TT);
    }
}
