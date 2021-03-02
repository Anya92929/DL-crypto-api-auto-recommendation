package com.google.android.gms.drive;

import android.content.IntentSender;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.drive.internal.C0452q;
import com.google.android.gms.drive.internal.OpenFileIntentSenderRequest;

public class OpenFileActivityBuilder {
    public static final String EXTRA_RESPONSE_DRIVE_ID = "response_drive_id";

    /* renamed from: No */
    private String f836No;

    /* renamed from: Np */
    private String[] f837Np;

    /* renamed from: Nq */
    private DriveId f838Nq;

    public IntentSender build(GoogleApiClient apiClient) {
        C0348n.m852a(apiClient.isConnected(), "Client must be connected");
        if (this.f837Np == null) {
            this.f837Np = new String[0];
        }
        try {
            return ((C0452q) apiClient.mo4218a(Drive.f807CU)).mo5074hY().mo4859a(new OpenFileIntentSenderRequest(this.f836No, this.f837Np, this.f838Nq));
        } catch (RemoteException e) {
            throw new RuntimeException("Unable to connect Drive Play Service", e);
        }
    }

    public OpenFileActivityBuilder setActivityStartFolder(DriveId folder) {
        this.f838Nq = (DriveId) C0348n.m861i(folder);
        return this;
    }

    public OpenFileActivityBuilder setActivityTitle(String title) {
        this.f836No = (String) C0348n.m861i(title);
        return this;
    }

    public OpenFileActivityBuilder setMimeType(String[] mimeTypes) {
        C0348n.m859b(mimeTypes != null, (Object) "mimeTypes may not be null");
        this.f837Np = mimeTypes;
        return this;
    }
}
