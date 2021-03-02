package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.DataEventBuffer;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.internal.C2237ae;

/* renamed from: com.google.android.gms.wearable.internal.ax */
public class C2285ax extends C2237ae.C2238a {
    private final DataApi.DataListener avM;
    private final MessageApi.MessageListener avN;
    private final NodeApi.NodeListener avO;
    private final IntentFilter[] avP;

    public C2285ax(DataApi.DataListener dataListener, MessageApi.MessageListener messageListener, NodeApi.NodeListener nodeListener, IntentFilter[] intentFilterArr) {
        this.avM = dataListener;
        this.avN = messageListener;
        this.avO = nodeListener;
        this.avP = intentFilterArr;
    }

    /* renamed from: a */
    public static C2285ax m7679a(DataApi.DataListener dataListener, IntentFilter[] intentFilterArr) {
        return new C2285ax(dataListener, (MessageApi.MessageListener) null, (NodeApi.NodeListener) null, intentFilterArr);
    }

    /* renamed from: a */
    public static C2285ax m7680a(MessageApi.MessageListener messageListener, IntentFilter[] intentFilterArr) {
        return new C2285ax((DataApi.DataListener) null, messageListener, (NodeApi.NodeListener) null, intentFilterArr);
    }

    /* renamed from: a */
    public static C2285ax m7681a(NodeApi.NodeListener nodeListener) {
        return new C2285ax((DataApi.DataListener) null, (MessageApi.MessageListener) null, nodeListener, (IntentFilter[]) null);
    }

    /* renamed from: Z */
    public void mo12290Z(DataHolder dataHolder) {
        if (this.avM != null) {
            try {
                this.avM.onDataChanged(new DataEventBuffer(dataHolder));
            } finally {
                dataHolder.close();
            }
        } else {
            dataHolder.close();
        }
    }

    /* renamed from: a */
    public void mo12291a(C2248ah ahVar) {
        if (this.avN != null) {
            this.avN.onMessageReceived(ahVar);
        }
    }

    /* renamed from: a */
    public void mo12292a(C2257ak akVar) {
        if (this.avO != null) {
            this.avO.onPeerConnected(akVar);
        }
    }

    /* renamed from: b */
    public void mo12293b(C2257ak akVar) {
        if (this.avO != null) {
            this.avO.onPeerDisconnected(akVar);
        }
    }

    /* renamed from: pZ */
    public IntentFilter[] mo12459pZ() {
        return this.avP;
    }
}
