package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import com.google.android.gms.ads.AdSize;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

@C1130ez
/* renamed from: com.google.android.gms.internal.dd */
public class C1045dd {

    /* renamed from: qT */
    static final Set<String> f3114qT = new HashSet(Arrays.asList(new String[]{"top-left", "top-right", "top-center", "center", "bottom-left", "bottom-right", "bottom-center"}));

    /* renamed from: lf */
    private int f3115lf = -1;

    /* renamed from: lg */
    private int f3116lg = -1;
    private final Context mContext;

    /* renamed from: md */
    private final C1232gv f3117md;

    /* renamed from: qM */
    private final Map<String, String> f3118qM;

    /* renamed from: qU */
    private int f3119qU = 0;

    /* renamed from: qV */
    private int f3120qV = 0;

    /* renamed from: qW */
    private boolean f3121qW = true;

    /* renamed from: qX */
    private String f3122qX = "top-right";

    public C1045dd(C1232gv gvVar, Map<String, String> map) {
        this.f3117md = gvVar;
        this.f3118qM = map;
        this.mContext = gvVar.mo8628dA();
    }

    /* renamed from: bG */
    private void m4197bG() {
        int[] t = C1213gj.m4643t(this.mContext);
        if (!TextUtils.isEmpty(this.f3118qM.get("width"))) {
            int M = C1213gj.m4609M(this.f3118qM.get("width"));
            if (mo8276b(M, t[0])) {
                this.f3115lf = M;
            }
        }
        if (!TextUtils.isEmpty(this.f3118qM.get("height"))) {
            int M2 = C1213gj.m4609M(this.f3118qM.get("height"));
            if (mo8280c(M2, t[1])) {
                this.f3116lg = M2;
            }
        }
        if (!TextUtils.isEmpty(this.f3118qM.get("offsetX"))) {
            this.f3119qU = C1213gj.m4609M(this.f3118qM.get("offsetX"));
        }
        if (!TextUtils.isEmpty(this.f3118qM.get("offsetY"))) {
            this.f3120qV = C1213gj.m4609M(this.f3118qM.get("offsetY"));
        }
        if (!TextUtils.isEmpty(this.f3118qM.get("allowOffscreen"))) {
            this.f3121qW = Boolean.parseBoolean(this.f3118qM.get("allowOffscreen"));
        }
        String str = this.f3118qM.get("customClosePosition");
        if (!TextUtils.isEmpty(str) && f3114qT.contains(str)) {
            this.f3122qX = str;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo8276b(int i, int i2) {
        return i >= 50 && i < i2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: bI */
    public boolean mo8277bI() {
        return this.f3115lf > -1 && this.f3116lg > -1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: bJ */
    public void mo8278bJ() {
        try {
            this.f3117md.mo8624b("onSizeChanged", new JSONObject().put("x", this.f3119qU).put("y", this.f3120qV).put("width", this.f3115lf).put("height", this.f3116lg));
        } catch (JSONException e) {
            C1229gs.m4681b("Error occured while dispatching size change.", e);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: bK */
    public void mo8279bK() {
        try {
            this.f3117md.mo8624b("onStateChanged", new JSONObject().put("state", "resized"));
        } catch (JSONException e) {
            C1229gs.m4681b("Error occured while dispatching state change.", e);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo8280c(int i, int i2) {
        return i >= 50 && i < i2;
    }

    public void execute() {
        C1229gs.m4677U("PLEASE IMPLEMENT mraid.resize()");
        if (this.mContext == null) {
            C1229gs.m4679W("Not an activity context. Cannot resize.");
        } else if (this.f3117md.mo8618Y().f2623og) {
            C1229gs.m4679W("Is interstitial. Cannot resize an interstitial.");
        } else if (this.f3117md.mo8635dz()) {
            C1229gs.m4679W("Is expanded. Cannot resize an expanded banner.");
        } else {
            m4197bG();
            if (!mo8277bI()) {
                C1229gs.m4679W("Invalid width and height options. Cannot resize.");
                return;
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            int a = C1228gr.m4668a(displayMetrics, this.f3115lf) + 16;
            int a2 = C1228gr.m4668a(displayMetrics, this.f3116lg) + 16;
            ViewParent parent = this.f3117md.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this.f3117md);
            }
            LinearLayout linearLayout = new LinearLayout(this.mContext);
            linearLayout.setBackgroundColor(0);
            PopupWindow popupWindow = new PopupWindow(this.mContext);
            popupWindow.setHeight(a2);
            popupWindow.setWidth(a);
            popupWindow.setClippingEnabled(!this.f3121qW);
            popupWindow.setContentView(linearLayout);
            linearLayout.addView(this.f3117md, -1, -1);
            popupWindow.showAtLocation(((Activity) this.mContext).getWindow().getDecorView(), 0, this.f3119qU, this.f3120qV);
            this.f3117md.mo8620a(new C0927ay(this.mContext, new AdSize(this.f3115lf, this.f3116lg)));
            mo8278bJ();
            mo8279bK();
        }
    }
}
