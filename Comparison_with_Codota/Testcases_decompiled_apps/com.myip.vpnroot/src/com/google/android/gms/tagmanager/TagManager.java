package com.google.android.gms.tagmanager;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.tagmanager.DataLayer;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class TagManager {
    private static TagManager arC;
    private final DataLayer anS;
    private final C2146r aqj;
    private final C2096cx arA;
    private final ConcurrentMap<C2132n, Boolean> arB;
    private final C1984a arz;
    private final Context mContext;

    /* renamed from: com.google.android.gms.tagmanager.TagManager$a */
    interface C1984a {
        /* renamed from: a */
        C2135o mo11527a(Context context, TagManager tagManager, Looper looper, String str, int i, C2146r rVar);
    }

    TagManager(Context context, C1984a containerHolderLoaderProvider, DataLayer dataLayer, C2096cx serviceManager) {
        if (context == null) {
            throw new NullPointerException("context cannot be null");
        }
        this.mContext = context.getApplicationContext();
        this.arA = serviceManager;
        this.arz = containerHolderLoaderProvider;
        this.arB = new ConcurrentHashMap();
        this.anS = dataLayer;
        this.anS.mo11493a((DataLayer.C1976b) new DataLayer.C1976b() {
            /* renamed from: D */
            public void mo11510D(Map<String, Object> map) {
                Object obj = map.get(DataLayer.EVENT_KEY);
                if (obj != null) {
                    TagManager.this.m6713cQ(obj.toString());
                }
            }
        });
        this.anS.mo11493a((DataLayer.C1976b) new C2103d(this.mContext));
        this.aqj = new C2146r();
        m6714pw();
    }

    /* access modifiers changed from: private */
    /* renamed from: cQ */
    public void m6713cQ(String str) {
        for (C2132n cm : this.arB.keySet()) {
            cm.mo11755cm(str);
        }
    }

    public static TagManager getInstance(Context context) {
        TagManager tagManager;
        synchronized (TagManager.class) {
            if (arC == null) {
                if (context == null) {
                    C2028bh.m6816T("TagManager.getInstance requires non-null context.");
                    throw new NullPointerException();
                }
                arC = new TagManager(context, new C1984a() {
                    /* renamed from: a */
                    public C2135o mo11527a(Context context, TagManager tagManager, Looper looper, String str, int i, C2146r rVar) {
                        return new C2135o(context, tagManager, looper, str, i, rVar);
                    }
                }, new DataLayer(new C2151v(context)), C2097cy.m7060pu());
            }
            tagManager = arC;
        }
        return tagManager;
    }

    /* renamed from: pw */
    private void m6714pw() {
        if (Build.VERSION.SDK_INT >= 14) {
            this.mContext.registerComponentCallbacks(new ComponentCallbacks2() {
                public void onConfigurationChanged(Configuration configuration) {
                }

                public void onLowMemory() {
                }

                public void onTrimMemory(int i) {
                    if (i == 20) {
                        TagManager.this.dispatch();
                    }
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo11515a(C2132n nVar) {
        this.arB.put(nVar, true);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo11516b(C2132n nVar) {
        return this.arB.remove(nVar) != null;
    }

    public void dispatch() {
        this.arA.dispatch();
    }

    public DataLayer getDataLayer() {
        return this.anS;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public synchronized boolean mo11519i(Uri uri) {
        boolean z;
        C2055ce oH = C2055ce.m6906oH();
        if (oH.mo11629i(uri)) {
            String containerId = oH.getContainerId();
            switch (oH.mo11630oI()) {
                case NONE:
                    for (C2132n nVar : this.arB.keySet()) {
                        if (nVar.getContainerId().equals(containerId)) {
                            nVar.mo11756co((String) null);
                            nVar.refresh();
                        }
                    }
                    break;
                case CONTAINER:
                case CONTAINER_DEBUG:
                    for (C2132n nVar2 : this.arB.keySet()) {
                        if (nVar2.getContainerId().equals(containerId)) {
                            nVar2.mo11756co(oH.mo11631oJ());
                            nVar2.refresh();
                        } else if (nVar2.mo11758nS() != null) {
                            nVar2.mo11756co((String) null);
                            nVar2.refresh();
                        }
                    }
                    break;
            }
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    public PendingResult<ContainerHolder> loadContainerDefaultOnly(String containerId, int defaultContainerResourceId) {
        C2135o a = this.arz.mo11527a(this.mContext, this, (Looper) null, containerId, defaultContainerResourceId, this.aqj);
        a.mo11768nV();
        return a;
    }

    public PendingResult<ContainerHolder> loadContainerDefaultOnly(String containerId, int defaultContainerResourceId, Handler handler) {
        C2135o a = this.arz.mo11527a(this.mContext, this, handler.getLooper(), containerId, defaultContainerResourceId, this.aqj);
        a.mo11768nV();
        return a;
    }

    public PendingResult<ContainerHolder> loadContainerPreferFresh(String containerId, int defaultContainerResourceId) {
        C2135o a = this.arz.mo11527a(this.mContext, this, (Looper) null, containerId, defaultContainerResourceId, this.aqj);
        a.mo11770nX();
        return a;
    }

    public PendingResult<ContainerHolder> loadContainerPreferFresh(String containerId, int defaultContainerResourceId, Handler handler) {
        C2135o a = this.arz.mo11527a(this.mContext, this, handler.getLooper(), containerId, defaultContainerResourceId, this.aqj);
        a.mo11770nX();
        return a;
    }

    public PendingResult<ContainerHolder> loadContainerPreferNonDefault(String containerId, int defaultContainerResourceId) {
        C2135o a = this.arz.mo11527a(this.mContext, this, (Looper) null, containerId, defaultContainerResourceId, this.aqj);
        a.mo11769nW();
        return a;
    }

    public PendingResult<ContainerHolder> loadContainerPreferNonDefault(String containerId, int defaultContainerResourceId, Handler handler) {
        C2135o a = this.arz.mo11527a(this.mContext, this, handler.getLooper(), containerId, defaultContainerResourceId, this.aqj);
        a.mo11769nW();
        return a;
    }

    public void setVerboseLoggingEnabled(boolean enableVerboseLogging) {
        C2028bh.setLogLevel(enableVerboseLogging ? 2 : 5);
    }
}
