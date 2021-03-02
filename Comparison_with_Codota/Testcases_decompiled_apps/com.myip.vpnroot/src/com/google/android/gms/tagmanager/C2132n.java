package com.google.android.gms.tagmanager;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tagmanager.ContainerHolder;

/* renamed from: com.google.android.gms.tagmanager.n */
class C2132n implements ContainerHolder {

    /* renamed from: CM */
    private Status f4594CM;

    /* renamed from: IB */
    private final Looper f4595IB;

    /* renamed from: NM */
    private boolean f4596NM;
    private Container anZ;
    private Container aoa;
    private C2134b aob;
    private C2133a aoc;
    private TagManager aod;

    /* renamed from: com.google.android.gms.tagmanager.n$a */
    public interface C2133a {
        /* renamed from: co */
        void mo11759co(String str);

        /* renamed from: nS */
        String mo11760nS();

        /* renamed from: nU */
        void mo11761nU();
    }

    /* renamed from: com.google.android.gms.tagmanager.n$b */
    private class C2134b extends Handler {
        private final ContainerHolder.ContainerAvailableListener aoe;

        public C2134b(ContainerHolder.ContainerAvailableListener containerAvailableListener, Looper looper) {
            super(looper);
            this.aoe = containerAvailableListener;
        }

        /* renamed from: cp */
        public void mo11762cp(String str) {
            sendMessage(obtainMessage(1, str));
        }

        /* access modifiers changed from: protected */
        /* renamed from: cq */
        public void mo11763cq(String str) {
            this.aoe.onContainerAvailable(C2132n.this, str);
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    mo11763cq((String) msg.obj);
                    return;
                default:
                    C2028bh.m6816T("Don't know how to handle this message.");
                    return;
            }
        }
    }

    public C2132n(Status status) {
        this.f4594CM = status;
        this.f4595IB = null;
    }

    public C2132n(TagManager tagManager, Looper looper, Container container, C2133a aVar) {
        this.aod = tagManager;
        this.f4595IB = looper == null ? Looper.getMainLooper() : looper;
        this.anZ = container;
        this.aoc = aVar;
        this.f4594CM = Status.f591Jo;
        tagManager.mo11515a(this);
    }

    /* renamed from: nT */
    private void m7179nT() {
        if (this.aob != null) {
            this.aob.mo11762cp(this.aoa.mo11480nQ());
        }
    }

    /* renamed from: a */
    public synchronized void mo11754a(Container container) {
        if (!this.f4596NM) {
            if (container == null) {
                C2028bh.m6816T("Unexpected null container.");
            } else {
                this.aoa = container;
                m7179nT();
            }
        }
    }

    /* renamed from: cm */
    public synchronized void mo11755cm(String str) {
        if (!this.f4596NM) {
            this.anZ.mo11471cm(str);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: co */
    public void mo11756co(String str) {
        if (this.f4596NM) {
            C2028bh.m6816T("setCtfeUrlPathAndQuery called on a released ContainerHolder.");
        } else {
            this.aoc.mo11759co(str);
        }
    }

    public synchronized Container getContainer() {
        Container container = null;
        synchronized (this) {
            if (this.f4596NM) {
                C2028bh.m6816T("ContainerHolder is released.");
            } else {
                if (this.aoa != null) {
                    this.anZ = this.aoa;
                    this.aoa = null;
                }
                container = this.anZ;
            }
        }
        return container;
    }

    /* access modifiers changed from: package-private */
    public String getContainerId() {
        if (!this.f4596NM) {
            return this.anZ.getContainerId();
        }
        C2028bh.m6816T("getContainerId called on a released ContainerHolder.");
        return "";
    }

    public Status getStatus() {
        return this.f4594CM;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: nS */
    public String mo11758nS() {
        if (!this.f4596NM) {
            return this.aoc.mo11760nS();
        }
        C2028bh.m6816T("setCtfeUrlPathAndQuery called on a released ContainerHolder.");
        return "";
    }

    public synchronized void refresh() {
        if (this.f4596NM) {
            C2028bh.m6816T("Refreshing a released ContainerHolder.");
        } else {
            this.aoc.mo11761nU();
        }
    }

    public synchronized void release() {
        if (this.f4596NM) {
            C2028bh.m6816T("Releasing a released ContainerHolder.");
        } else {
            this.f4596NM = true;
            this.aod.mo11516b(this);
            this.anZ.release();
            this.anZ = null;
            this.aoa = null;
            this.aoc = null;
            this.aob = null;
        }
    }

    public synchronized void setContainerAvailableListener(ContainerHolder.ContainerAvailableListener listener) {
        if (this.f4596NM) {
            C2028bh.m6816T("ContainerHolder is released.");
        } else if (listener == null) {
            this.aob = null;
        } else {
            this.aob = new C2134b(listener, this.f4595IB);
            if (this.aoa != null) {
                m7179nT();
            }
        }
    }
}
