package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.C0976c;
import com.google.android.gms.tagmanager.C2055ce;
import com.google.android.gms.tagmanager.C2075cr;
import com.google.android.gms.tagmanager.C2147s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Container {
    private final String anR;
    private final DataLayer anS;
    private C2085ct anT;
    private Map<String, FunctionCallMacroCallback> anU = new HashMap();
    private Map<String, FunctionCallTagCallback> anV = new HashMap();
    private volatile long anW;
    private volatile String anX = "";
    private final Context mContext;

    public interface FunctionCallMacroCallback {
        Object getValue(String str, Map<String, Object> map);
    }

    public interface FunctionCallTagCallback {
        void execute(String str, Map<String, Object> map);
    }

    /* renamed from: com.google.android.gms.tagmanager.Container$a */
    private class C1971a implements C2147s.C2148a {
        private C1971a() {
        }

        /* renamed from: b */
        public Object mo11488b(String str, Map<String, Object> map) {
            FunctionCallMacroCallback ck = Container.this.mo11469ck(str);
            if (ck == null) {
                return null;
            }
            return ck.getValue(str, map);
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.Container$b */
    private class C1972b implements C2147s.C2148a {
        private C1972b() {
        }

        /* renamed from: b */
        public Object mo11488b(String str, Map<String, Object> map) {
            FunctionCallTagCallback cl = Container.this.mo11470cl(str);
            if (cl != null) {
                cl.execute(str, map);
            }
            return C2114di.m7118pH();
        }
    }

    Container(Context context, DataLayer dataLayer, String containerId, long lastRefreshTime, C0976c.C0986j resource) {
        this.mContext = context;
        this.anS = dataLayer;
        this.anR = containerId;
        this.anW = lastRefreshTime;
        m6671a(resource.f3008gs);
        if (resource.f3007gr != null) {
            m6674a(resource.f3007gr);
        }
    }

    Container(Context context, DataLayer dataLayer, String containerId, long lastRefreshTime, C2075cr.C2079c resource) {
        this.mContext = context;
        this.anS = dataLayer;
        this.anR = containerId;
        this.anW = lastRefreshTime;
        m6672a(resource);
    }

    /* renamed from: a */
    private void m6671a(C0976c.C0982f fVar) {
        if (fVar == null) {
            throw new NullPointerException();
        }
        try {
            m6672a(C2075cr.m6960b(fVar));
        } catch (C2075cr.C2083g e) {
            C2028bh.m6816T("Not loading resource: " + fVar + " because it is invalid: " + e.toString());
        }
    }

    /* renamed from: a */
    private void m6672a(C2075cr.C2079c cVar) {
        this.anX = cVar.getVersion();
        C2075cr.C2079c cVar2 = cVar;
        m6673a(new C2085ct(this.mContext, cVar2, this.anS, new C1971a(), new C1972b(), mo11472cn(this.anX)));
    }

    /* renamed from: a */
    private synchronized void m6673a(C2085ct ctVar) {
        this.anT = ctVar;
    }

    /* renamed from: a */
    private void m6674a(C0976c.C0985i[] iVarArr) {
        ArrayList arrayList = new ArrayList();
        for (C0976c.C0985i add : iVarArr) {
            arrayList.add(add);
        }
        m6675nR().mo11699k(arrayList);
    }

    /* renamed from: nR */
    private synchronized C2085ct m6675nR() {
        return this.anT;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ck */
    public FunctionCallMacroCallback mo11469ck(String str) {
        FunctionCallMacroCallback functionCallMacroCallback;
        synchronized (this.anU) {
            functionCallMacroCallback = this.anU.get(str);
        }
        return functionCallMacroCallback;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: cl */
    public FunctionCallTagCallback mo11470cl(String str) {
        FunctionCallTagCallback functionCallTagCallback;
        synchronized (this.anV) {
            functionCallTagCallback = this.anV.get(str);
        }
        return functionCallTagCallback;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: cm */
    public void mo11471cm(String str) {
        m6675nR().mo11698cm(str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: cn */
    public C1995ag mo11472cn(String str) {
        if (C2055ce.m6906oH().mo11630oI().equals(C2055ce.C2056a.CONTAINER_DEBUG)) {
        }
        return new C2038br();
    }

    public boolean getBoolean(String key) {
        C2085ct nR = m6675nR();
        if (nR == null) {
            C2028bh.m6816T("getBoolean called for closed container.");
            return C2114di.m7116pF().booleanValue();
        }
        try {
            return C2114di.m7110n(nR.mo11696cO(key).getObject()).booleanValue();
        } catch (Exception e) {
            C2028bh.m6816T("Calling getBoolean() threw an exception: " + e.getMessage() + " Returning default value.");
            return C2114di.m7116pF().booleanValue();
        }
    }

    public String getContainerId() {
        return this.anR;
    }

    public double getDouble(String key) {
        C2085ct nR = m6675nR();
        if (nR == null) {
            C2028bh.m6816T("getDouble called for closed container.");
            return C2114di.m7115pE().doubleValue();
        }
        try {
            return C2114di.m7109m(nR.mo11696cO(key).getObject()).doubleValue();
        } catch (Exception e) {
            C2028bh.m6816T("Calling getDouble() threw an exception: " + e.getMessage() + " Returning default value.");
            return C2114di.m7115pE().doubleValue();
        }
    }

    public long getLastRefreshTime() {
        return this.anW;
    }

    public long getLong(String key) {
        C2085ct nR = m6675nR();
        if (nR == null) {
            C2028bh.m6816T("getLong called for closed container.");
            return C2114di.m7114pD().longValue();
        }
        try {
            return C2114di.m7108l(nR.mo11696cO(key).getObject()).longValue();
        } catch (Exception e) {
            C2028bh.m6816T("Calling getLong() threw an exception: " + e.getMessage() + " Returning default value.");
            return C2114di.m7114pD().longValue();
        }
    }

    public String getString(String key) {
        C2085ct nR = m6675nR();
        if (nR == null) {
            C2028bh.m6816T("getString called for closed container.");
            return C2114di.m7118pH();
        }
        try {
            return C2114di.m7106j(nR.mo11696cO(key).getObject());
        } catch (Exception e) {
            C2028bh.m6816T("Calling getString() threw an exception: " + e.getMessage() + " Returning default value.");
            return C2114di.m7118pH();
        }
    }

    public boolean isDefault() {
        return getLastRefreshTime() == 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: nQ */
    public String mo11480nQ() {
        return this.anX;
    }

    public void registerFunctionCallMacroCallback(String customMacroName, FunctionCallMacroCallback customMacroCallback) {
        if (customMacroCallback == null) {
            throw new NullPointerException("Macro handler must be non-null");
        }
        synchronized (this.anU) {
            this.anU.put(customMacroName, customMacroCallback);
        }
    }

    public void registerFunctionCallTagCallback(String customTagName, FunctionCallTagCallback customTagCallback) {
        if (customTagCallback == null) {
            throw new NullPointerException("Tag callback must be non-null");
        }
        synchronized (this.anV) {
            this.anV.put(customTagName, customTagCallback);
        }
    }

    /* access modifiers changed from: package-private */
    public void release() {
        this.anT = null;
    }

    public void unregisterFunctionCallMacroCallback(String customMacroName) {
        synchronized (this.anU) {
            this.anU.remove(customMacroName);
        }
    }

    public void unregisterFunctionCallTagCallback(String customTagName) {
        synchronized (this.anV) {
            this.anV.remove(customTagName);
        }
    }
}
