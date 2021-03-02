package com.google.android.gms.fitness.data;

import android.os.RemoteException;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.fitness.data.C0618k;
import com.google.android.gms.fitness.request.DataSourceListener;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.fitness.data.l */
public class C0621l extends C0618k.C0619a {

    /* renamed from: SY */
    private final DataSourceListener f1397SY;

    /* renamed from: com.google.android.gms.fitness.data.l$a */
    public static class C0623a {

        /* renamed from: SZ */
        private static final C0623a f1398SZ = new C0623a();

        /* renamed from: Ta */
        private final Map<DataSourceListener, C0621l> f1399Ta = new HashMap();

        private C0623a() {
        }

        /* renamed from: iO */
        public static C0623a m1859iO() {
            return f1398SZ;
        }

        /* renamed from: a */
        public C0621l mo5824a(DataSourceListener dataSourceListener) {
            C0621l lVar;
            synchronized (this.f1399Ta) {
                lVar = this.f1399Ta.get(dataSourceListener);
                if (lVar == null) {
                    lVar = new C0621l(dataSourceListener);
                    this.f1399Ta.put(dataSourceListener, lVar);
                }
            }
            return lVar;
        }

        /* renamed from: b */
        public C0621l mo5825b(DataSourceListener dataSourceListener) {
            C0621l lVar;
            synchronized (this.f1399Ta) {
                lVar = this.f1399Ta.get(dataSourceListener);
            }
            return lVar;
        }

        /* renamed from: c */
        public C0621l mo5826c(DataSourceListener dataSourceListener) {
            C0621l remove;
            synchronized (this.f1399Ta) {
                remove = this.f1399Ta.remove(dataSourceListener);
                if (remove == null) {
                    remove = new C0621l(dataSourceListener);
                }
            }
            return remove;
        }
    }

    private C0621l(DataSourceListener dataSourceListener) {
        this.f1397SY = (DataSourceListener) C0348n.m861i(dataSourceListener);
    }

    public void onEvent(DataPoint dataPoint) throws RemoteException {
        this.f1397SY.onEvent(dataPoint);
    }
}
