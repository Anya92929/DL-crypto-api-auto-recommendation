package com.google.android.gms.internal;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.internal.C1049df;
import org.json.JSONException;
import org.json.JSONObject;

@C1130ez
/* renamed from: com.google.android.gms.internal.dg */
public class C1052dg {
    private final Context mContext;

    /* renamed from: mG */
    private final WindowManager f3139mG;

    /* renamed from: md */
    private final C1232gv f3140md;

    /* renamed from: rg */
    private final C0950bl f3141rg;

    /* renamed from: rh */
    DisplayMetrics f3142rh;

    /* renamed from: ri */
    private float f3143ri;

    /* renamed from: rj */
    int f3144rj = -1;

    /* renamed from: rk */
    int f3145rk = -1;

    /* renamed from: rl */
    private int f3146rl;

    /* renamed from: rm */
    private int f3147rm = -1;

    /* renamed from: rn */
    private int f3148rn = -1;

    /* renamed from: ro */
    private int[] f3149ro = new int[2];

    public C1052dg(C1232gv gvVar, Context context, C0950bl blVar) {
        this.f3140md = gvVar;
        this.mContext = context;
        this.f3141rg = blVar;
        this.f3139mG = (WindowManager) context.getSystemService("window");
        m4219bN();
        mo8294bO();
        m4220bP();
    }

    /* renamed from: bN */
    private void m4219bN() {
        this.f3142rh = new DisplayMetrics();
        Display defaultDisplay = this.f3139mG.getDefaultDisplay();
        defaultDisplay.getMetrics(this.f3142rh);
        this.f3143ri = this.f3142rh.density;
        this.f3146rl = defaultDisplay.getRotation();
    }

    /* renamed from: bP */
    private void m4220bP() {
        this.f3140md.getLocationOnScreen(this.f3149ro);
        this.f3140md.measure(0, 0);
        float f = 160.0f / ((float) this.f3142rh.densityDpi);
        this.f3147rm = Math.round(((float) this.f3140md.getMeasuredWidth()) * f);
        this.f3148rn = Math.round(f * ((float) this.f3140md.getMeasuredHeight()));
    }

    /* renamed from: bV */
    private C1049df m4221bV() {
        return new C1049df.C1051a().mo8290j(this.f3141rg.mo8129bj()).mo8289i(this.f3141rg.mo8130bk()).mo8291k(this.f3141rg.mo8133bo()).mo8292l(this.f3141rg.mo8131bl()).mo8293m(this.f3141rg.mo8132bm()).mo8288bM();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: bO */
    public void mo8294bO() {
        int s = C1213gj.m4641s(this.mContext);
        float f = 160.0f / ((float) this.f3142rh.densityDpi);
        this.f3144rj = Math.round(((float) this.f3142rh.widthPixels) * f);
        this.f3145rk = Math.round(((float) (this.f3142rh.heightPixels - s)) * f);
    }

    /* renamed from: bQ */
    public void mo8295bQ() {
        mo8298bT();
        mo8299bU();
        mo8297bS();
        mo8296bR();
    }

    /* renamed from: bR */
    public void mo8296bR() {
        if (C1229gs.m4684u(2)) {
            C1229gs.m4677U("Dispatching Ready Event.");
        }
        this.f3140md.mo8624b("onReadyEventReceived", new JSONObject());
    }

    /* renamed from: bS */
    public void mo8297bS() {
        try {
            this.f3140md.mo8624b("onDefaultPositionReceived", new JSONObject().put("x", this.f3149ro[0]).put("y", this.f3149ro[1]).put("width", this.f3147rm).put("height", this.f3148rn));
        } catch (JSONException e) {
            C1229gs.m4681b("Error occured while dispatching default position.", e);
        }
    }

    /* renamed from: bT */
    public void mo8298bT() {
        try {
            this.f3140md.mo8624b("onScreenInfoChanged", new JSONObject().put("width", this.f3144rj).put("height", this.f3145rk).put("density", (double) this.f3143ri).put("rotation", this.f3146rl));
        } catch (JSONException e) {
            C1229gs.m4681b("Error occured while obtaining screen information.", e);
        }
    }

    /* renamed from: bU */
    public void mo8299bU() {
        this.f3140md.mo8624b("onDeviceFeaturesReceived", m4221bV().mo8287bL());
    }
}
