package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.Uri;
import com.google.android.gms.internal.C0880a;
import com.google.android.gms.internal.C0929b;
import com.google.android.gms.internal.C1026d;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: com.google.android.gms.tagmanager.i */
class C2123i extends C2112dg {

    /* renamed from: ID */
    private static final String f4591ID = C0880a.ARBITRARY_PIXEL.toString();
    private static final String URL = C0929b.URL.toString();
    private static final String anK = C0929b.ADDITIONAL_PARAMS.toString();
    private static final String anL = C0929b.UNREPEATABLE.toString();
    static final String anM = ("gtm_" + f4591ID + "_unrepeatable");
    private static final Set<String> anN = new HashSet();
    private final C2125a anO;
    private final Context mContext;

    /* renamed from: com.google.android.gms.tagmanager.i$a */
    public interface C2125a {
        /* renamed from: nM */
        C2005aq mo11751nM();
    }

    public C2123i(final Context context) {
        this(context, new C2125a() {
            /* renamed from: nM */
            public C2005aq mo11751nM() {
                return C2159y.m7281W(context);
            }
        });
    }

    C2123i(Context context, C2125a aVar) {
        super(f4591ID, URL);
        this.anO = aVar;
        this.mContext = context;
    }

    /* renamed from: cg */
    private synchronized boolean m7164cg(String str) {
        boolean z = true;
        synchronized (this) {
            if (!mo11750ci(str)) {
                if (mo11749ch(str)) {
                    anN.add(str);
                } else {
                    z = false;
                }
            }
        }
        return z;
    }

    /* renamed from: E */
    public void mo11732E(Map<String, C1026d.C1027a> map) {
        String j = map.get(anL) != null ? C2114di.m7106j(map.get(anL)) : null;
        if (j == null || !m7164cg(j)) {
            Uri.Builder buildUpon = Uri.parse(C2114di.m7106j(map.get(URL))).buildUpon();
            C1026d.C1027a aVar = map.get(anK);
            if (aVar != null) {
                Object o = C2114di.m7111o(aVar);
                if (!(o instanceof List)) {
                    C2028bh.m6816T("ArbitraryPixel: additional params not a list: not sending partial hit: " + buildUpon.build().toString());
                    return;
                }
                for (Object next : (List) o) {
                    if (!(next instanceof Map)) {
                        C2028bh.m6816T("ArbitraryPixel: additional params contains non-map: not sending partial hit: " + buildUpon.build().toString());
                        return;
                    }
                    for (Map.Entry entry : ((Map) next).entrySet()) {
                        buildUpon.appendQueryParameter(entry.getKey().toString(), entry.getValue().toString());
                    }
                }
            }
            String uri = buildUpon.build().toString();
            this.anO.mo11751nM().mo11556cw(uri);
            C2028bh.m6818V("ArbitraryPixel: url = " + uri);
            if (j != null) {
                synchronized (C2123i.class) {
                    anN.add(j);
                    C2101cz.m7067a(this.mContext, anM, j, "true");
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ch */
    public boolean mo11749ch(String str) {
        return this.mContext.getSharedPreferences(anM, 0).contains(str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ci */
    public boolean mo11750ci(String str) {
        return anN.contains(str);
    }
}
