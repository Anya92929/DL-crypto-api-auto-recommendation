package com.google.android.gms.drive.internal;

import android.content.IntentSender;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataChangeSet;

/* renamed from: com.google.android.gms.drive.internal.h */
public class C0423h {

    /* renamed from: No */
    private String f990No;

    /* renamed from: Nq */
    private DriveId f991Nq;

    /* renamed from: Oa */
    protected MetadataChangeSet f992Oa;

    /* renamed from: Ob */
    private Integer f993Ob;

    /* renamed from: Oc */
    private final int f994Oc;

    public C0423h(int i) {
        this.f994Oc = i;
    }

    /* renamed from: a */
    public void mo5029a(DriveId driveId) {
        this.f991Nq = (DriveId) C0348n.m861i(driveId);
    }

    /* renamed from: a */
    public void mo5030a(MetadataChangeSet metadataChangeSet) {
        this.f992Oa = (MetadataChangeSet) C0348n.m861i(metadataChangeSet);
    }

    /* renamed from: bi */
    public void mo5031bi(String str) {
        this.f990No = (String) C0348n.m861i(str);
    }

    /* renamed from: bk */
    public void mo5032bk(int i) {
        this.f993Ob = Integer.valueOf(i);
    }

    public IntentSender build(GoogleApiClient apiClient) {
        C0348n.m857b(this.f992Oa, (Object) "Must provide initial metadata to CreateFileActivityBuilder.");
        C0348n.m852a(apiClient.isConnected(), "Client must be connected");
        C0452q qVar = (C0452q) apiClient.mo4218a(Drive.f807CU);
        this.f992Oa.mo4681hS().setContext(qVar.getContext());
        try {
            return qVar.mo5074hY().mo4858a(new CreateFileIntentSenderRequest(this.f992Oa.mo4681hS(), this.f993Ob == null ? -1 : this.f993Ob.intValue(), this.f990No, this.f991Nq, this.f994Oc));
        } catch (RemoteException e) {
            throw new RuntimeException("Unable to connect Drive Play Service", e);
        }
    }
}
