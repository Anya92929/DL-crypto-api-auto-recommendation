package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import com.google.android.gms.wearable.DataItemBuffer;
import com.google.android.gms.wearable.PutDataRequest;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.google.android.gms.wearable.internal.f */
public final class C2290f implements DataApi {

    /* renamed from: com.google.android.gms.wearable.internal.f$a */
    public static class C2300a implements DataApi.DataItemResult {

        /* renamed from: CM */
        private final Status f4682CM;
        private final DataItem avh;

        public C2300a(Status status, DataItem dataItem) {
            this.f4682CM = status;
            this.avh = dataItem;
        }

        public DataItem getDataItem() {
            return this.avh;
        }

        public Status getStatus() {
            return this.f4682CM;
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.f$b */
    public static class C2301b implements DataApi.DeleteDataItemsResult {

        /* renamed from: CM */
        private final Status f4683CM;
        private final int avi;

        public C2301b(Status status, int i) {
            this.f4683CM = status;
            this.avi = i;
        }

        public int getNumDeleted() {
            return this.avi;
        }

        public Status getStatus() {
            return this.f4683CM;
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.f$c */
    public static class C2302c implements DataApi.GetFdForAssetResult {

        /* renamed from: CM */
        private final Status f4684CM;

        /* renamed from: XM */
        private volatile InputStream f4685XM;
        private volatile ParcelFileDescriptor avj;
        private volatile boolean mClosed = false;

        public C2302c(Status status, ParcelFileDescriptor parcelFileDescriptor) {
            this.f4684CM = status;
            this.avj = parcelFileDescriptor;
        }

        public ParcelFileDescriptor getFd() {
            if (!this.mClosed) {
                return this.avj;
            }
            throw new IllegalStateException("Cannot access the file descriptor after release().");
        }

        public InputStream getInputStream() {
            if (this.mClosed) {
                throw new IllegalStateException("Cannot access the input stream after release().");
            } else if (this.avj == null) {
                return null;
            } else {
                if (this.f4685XM == null) {
                    this.f4685XM = new ParcelFileDescriptor.AutoCloseInputStream(this.avj);
                }
                return this.f4685XM;
            }
        }

        public Status getStatus() {
            return this.f4684CM;
        }

        public void release() {
            if (this.avj != null) {
                if (this.mClosed) {
                    throw new IllegalStateException("releasing an already released result.");
                }
                try {
                    if (this.f4685XM != null) {
                        this.f4685XM.close();
                    } else {
                        this.avj.close();
                    }
                    this.mClosed = true;
                    this.avj = null;
                    this.f4685XM = null;
                } catch (IOException e) {
                }
            }
        }
    }

    /* renamed from: a */
    private PendingResult<Status> m7691a(GoogleApiClient googleApiClient, final DataApi.DataListener dataListener, final IntentFilter[] intentFilterArr) {
        return googleApiClient.mo4219a(new C2288d<Status>() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(C2269aw awVar) throws RemoteException {
                awVar.mo12442a((BaseImplementation.C0270b<Status>) this, dataListener, intentFilterArr);
            }

            /* renamed from: d */
            public Status mo3773c(Status status) {
                return new Status(13);
            }
        });
    }

    /* renamed from: a */
    private void m7692a(Asset asset) {
        if (asset == null) {
            throw new IllegalArgumentException("asset is null");
        } else if (asset.getDigest() == null) {
            throw new IllegalArgumentException("invalid asset");
        } else if (asset.getData() != null) {
            throw new IllegalArgumentException("invalid asset");
        }
    }

    public PendingResult<Status> addListener(GoogleApiClient client, DataApi.DataListener listener) {
        return m7691a(client, listener, (IntentFilter[]) null);
    }

    public PendingResult<DataApi.DeleteDataItemsResult> deleteDataItems(GoogleApiClient client, final Uri uri) {
        return client.mo4219a(new C2288d<DataApi.DeleteDataItemsResult>() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(C2269aw awVar) throws RemoteException {
                awVar.mo12453c(this, uri);
            }

            /* access modifiers changed from: protected */
            /* renamed from: aH */
            public DataApi.DeleteDataItemsResult mo3773c(Status status) {
                return new C2301b(status, 0);
            }
        });
    }

    public PendingResult<DataApi.DataItemResult> getDataItem(GoogleApiClient client, final Uri uri) {
        return client.mo4219a(new C2288d<DataApi.DataItemResult>() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(C2269aw awVar) throws RemoteException {
                awVar.mo12439a((BaseImplementation.C0270b<DataApi.DataItemResult>) this, uri);
            }

            /* access modifiers changed from: protected */
            /* renamed from: aF */
            public DataApi.DataItemResult mo3773c(Status status) {
                return new C2300a(status, (DataItem) null);
            }
        });
    }

    public PendingResult<DataItemBuffer> getDataItems(GoogleApiClient client) {
        return client.mo4219a(new C2288d<DataItemBuffer>() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(C2269aw awVar) throws RemoteException {
                awVar.mo12454o(this);
            }

            /* access modifiers changed from: protected */
            /* renamed from: aG */
            public DataItemBuffer mo3773c(Status status) {
                return new DataItemBuffer(DataHolder.m593as(status.getStatusCode()));
            }
        });
    }

    public PendingResult<DataItemBuffer> getDataItems(GoogleApiClient client, final Uri uri) {
        return client.mo4219a(new C2288d<DataItemBuffer>() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(C2269aw awVar) throws RemoteException {
                awVar.mo12450b((BaseImplementation.C0270b<DataItemBuffer>) this, uri);
            }

            /* access modifiers changed from: protected */
            /* renamed from: aG */
            public DataItemBuffer mo3773c(Status status) {
                return new DataItemBuffer(DataHolder.m593as(status.getStatusCode()));
            }
        });
    }

    public PendingResult<DataApi.GetFdForAssetResult> getFdForAsset(GoogleApiClient client, final Asset asset) {
        m7692a(asset);
        return client.mo4219a(new C2288d<DataApi.GetFdForAssetResult>() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(C2269aw awVar) throws RemoteException {
                awVar.mo12440a((BaseImplementation.C0270b<DataApi.GetFdForAssetResult>) this, asset);
            }

            /* access modifiers changed from: protected */
            /* renamed from: aI */
            public DataApi.GetFdForAssetResult mo3773c(Status status) {
                return new C2302c(status, (ParcelFileDescriptor) null);
            }
        });
    }

    public PendingResult<DataApi.GetFdForAssetResult> getFdForAsset(GoogleApiClient client, final DataItemAsset asset) {
        return client.mo4219a(new C2288d<DataApi.GetFdForAssetResult>() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(C2269aw awVar) throws RemoteException {
                awVar.mo12443a((BaseImplementation.C0270b<DataApi.GetFdForAssetResult>) this, asset);
            }

            /* access modifiers changed from: protected */
            /* renamed from: aI */
            public DataApi.GetFdForAssetResult mo3773c(Status status) {
                return new C2302c(status, (ParcelFileDescriptor) null);
            }
        });
    }

    public PendingResult<DataApi.DataItemResult> putDataItem(GoogleApiClient client, final PutDataRequest request) {
        return client.mo4219a(new C2288d<DataApi.DataItemResult>() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(C2269aw awVar) throws RemoteException {
                awVar.mo12447a((BaseImplementation.C0270b<DataApi.DataItemResult>) this, request);
            }

            /* renamed from: aF */
            public DataApi.DataItemResult mo3773c(Status status) {
                return new C2300a(status, (DataItem) null);
            }
        });
    }

    public PendingResult<Status> removeListener(GoogleApiClient client, final DataApi.DataListener listener) {
        return client.mo4219a(new C2288d<Status>() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(C2269aw awVar) throws RemoteException {
                awVar.mo12441a((BaseImplementation.C0270b<Status>) this, listener);
            }

            /* renamed from: d */
            public Status mo3773c(Status status) {
                return new Status(13);
            }
        });
    }
}
