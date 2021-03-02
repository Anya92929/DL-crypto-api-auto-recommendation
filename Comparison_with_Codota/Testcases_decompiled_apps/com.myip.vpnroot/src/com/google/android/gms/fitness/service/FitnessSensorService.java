package com.google.android.gms.fitness.service;

import android.app.AppOpsManager;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.result.DataSourcesResult;
import com.google.android.gms.internal.C1394kc;
import com.google.android.gms.internal.C1424km;
import com.google.android.gms.internal.C1442ks;
import com.google.android.gms.internal.C1493lf;
import com.google.android.gms.internal.C1495lh;
import com.google.android.gms.internal.C1497lj;
import java.util.List;

public abstract class FitnessSensorService extends Service {
    public static final String SERVICE_ACTION = "com.google.android.gms.fitness.service.FitnessSensorService";

    /* renamed from: UP */
    private C0699a f1582UP;

    /* renamed from: com.google.android.gms.fitness.service.FitnessSensorService$a */
    private static class C0699a extends C1497lj.C1498a {

        /* renamed from: UQ */
        private final FitnessSensorService f1583UQ;

        private C0699a(FitnessSensorService fitnessSensorService) {
            this.f1583UQ = fitnessSensorService;
        }

        /* renamed from: jK */
        private void m2125jK() throws SecurityException {
            int callingUid = Binder.getCallingUid();
            if (C1394kc.m5245hI()) {
                ((AppOpsManager) this.f1583UQ.getSystemService("appops")).checkPackage(callingUid, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE);
                return;
            }
            String[] packagesForUid = this.f1583UQ.getPackageManager().getPackagesForUid(callingUid);
            if (packagesForUid != null) {
                int length = packagesForUid.length;
                int i = 0;
                while (i < length) {
                    if (!packagesForUid[i].equals(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE)) {
                        i++;
                    } else {
                        return;
                    }
                }
            }
            throw new SecurityException("Unauthorized caller");
        }

        /* renamed from: a */
        public void mo6306a(FitnessSensorServiceRequest fitnessSensorServiceRequest, C1442ks ksVar) throws RemoteException {
            m2125jK();
            if (this.f1583UQ.onRegister(fitnessSensorServiceRequest)) {
                ksVar.mo9098k(Status.f591Jo);
            } else {
                ksVar.mo9098k(new Status(13));
            }
        }

        /* renamed from: a */
        public void mo6307a(C1493lf lfVar, C1424km kmVar) throws RemoteException {
            m2125jK();
            kmVar.mo9105a(new DataSourcesResult(this.f1583UQ.onFindDataSources(lfVar.getDataTypes()), Status.f591Jo));
        }

        /* renamed from: a */
        public void mo6308a(C1495lh lhVar, C1442ks ksVar) throws RemoteException {
            m2125jK();
            if (this.f1583UQ.onUnregister(lhVar.getDataSource())) {
                ksVar.mo9098k(Status.f591Jo);
            } else {
                ksVar.mo9098k(new Status(13));
            }
        }
    }

    public final IBinder onBind(Intent intent) {
        if (!SERVICE_ACTION.equals(intent.getAction())) {
            return null;
        }
        if (Log.isLoggable("FitnessSensorService", 3)) {
            Log.d("FitnessSensorService", "Intent " + intent + " received by " + getClass().getName());
        }
        return this.f1582UP.asBinder();
    }

    public void onCreate() {
        super.onCreate();
        this.f1582UP = new C0699a();
    }

    public abstract List<DataSource> onFindDataSources(List<DataType> list);

    public abstract boolean onRegister(FitnessSensorServiceRequest fitnessSensorServiceRequest);

    public abstract boolean onUnregister(DataSource dataSource);
}
