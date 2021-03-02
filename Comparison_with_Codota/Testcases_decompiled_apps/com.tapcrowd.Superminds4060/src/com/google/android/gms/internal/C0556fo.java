package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.common.Scopes;
import java.util.ArrayList;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.fo */
public class C0556fo {

    /* renamed from: it */
    private String f1362it;

    /* renamed from: rA */
    private String[] f1363rA;

    /* renamed from: rB */
    private String f1364rB;

    /* renamed from: rC */
    private String f1365rC;

    /* renamed from: rD */
    private String f1366rD;

    /* renamed from: rE */
    private String f1367rE;

    /* renamed from: rF */
    private ArrayList<String> f1368rF = new ArrayList<>();

    /* renamed from: rG */
    private String[] f1369rG;

    public C0556fo(Context context) {
        this.f1365rC = context.getPackageName();
        this.f1364rB = context.getPackageName();
        this.f1368rF.add(Scopes.PLUS_LOGIN);
    }

    /* renamed from: Z */
    public C0556fo mo4865Z(String str) {
        this.f1362it = str;
        return this;
    }

    /* renamed from: d */
    public C0556fo mo4866d(String... strArr) {
        this.f1368rF.clear();
        this.f1368rF.addAll(Arrays.asList(strArr));
        return this;
    }

    /* renamed from: dg */
    public C0556fo mo4867dg() {
        this.f1368rF.clear();
        return this;
    }

    /* renamed from: dh */
    public C0555fn mo4868dh() {
        if (this.f1362it == null) {
            this.f1362it = "<<default account>>";
        }
        return new C0555fn(this.f1362it, (String[]) this.f1368rF.toArray(new String[this.f1368rF.size()]), this.f1369rG, this.f1363rA, this.f1364rB, this.f1365rC, this.f1366rD, this.f1367rE);
    }

    /* renamed from: e */
    public C0556fo mo4869e(String... strArr) {
        this.f1369rG = strArr;
        return this;
    }
}
