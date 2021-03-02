package com.google.android.gms.location.internal;

import android.content.ContentProviderClient;
import android.content.Context;
import android.location.Location;
import android.os.RemoteException;
import com.google.android.gms.location.C1147m;
import com.google.android.gms.location.C1150p;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.location.internal.o */
public class C1135o {

    /* renamed from: a */
    private final C1142v<C1129i> f4973a;

    /* renamed from: b */
    private final Context f4974b;

    /* renamed from: c */
    private ContentProviderClient f4975c = null;

    /* renamed from: d */
    private boolean f4976d = false;

    /* renamed from: e */
    private Map<Object, C1137q> f4977e = new HashMap();

    /* renamed from: f */
    private Map<Object, C1136p> f4978f = new HashMap();

    public C1135o(Context context, C1142v<C1129i> vVar) {
        this.f4974b = context;
        this.f4973a = vVar;
    }

    /* renamed from: a */
    public Location mo7884a() {
        this.f4973a.mo7837a();
        try {
            return this.f4973a.mo7839c().mo7871b(this.f4974b.getPackageName());
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }

    /* renamed from: a */
    public void mo7885a(boolean z) {
        this.f4973a.mo7837a();
        this.f4973a.mo7839c().mo7869a(z);
        this.f4976d = z;
    }

    /* renamed from: b */
    public void mo7886b() {
        try {
            synchronized (this.f4977e) {
                for (C1137q next : this.f4977e.values()) {
                    if (next != null) {
                        this.f4973a.mo7839c().mo7865a(LocationRequestUpdateData.m4848a((C1150p) next));
                    }
                }
                this.f4977e.clear();
                for (C1136p next2 : this.f4978f.values()) {
                    if (next2 != null) {
                        this.f4973a.mo7839c().mo7865a(LocationRequestUpdateData.m4847a((C1147m) next2));
                    }
                }
                this.f4978f.clear();
            }
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }

    /* renamed from: c */
    public void mo7887c() {
        if (this.f4976d) {
            try {
                mo7885a(false);
            } catch (RemoteException e) {
                throw new IllegalStateException(e);
            }
        }
    }
}
