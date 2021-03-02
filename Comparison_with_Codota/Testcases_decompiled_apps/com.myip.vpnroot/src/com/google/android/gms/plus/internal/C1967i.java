package com.google.android.gms.plus.internal;

import android.content.Context;
import com.google.android.gms.common.Scopes;
import java.util.ArrayList;
import java.util.Arrays;

/* renamed from: com.google.android.gms.plus.internal.i */
public class C1967i {

    /* renamed from: Dd */
    private String f4511Dd;
    private final ArrayList<String> alA = new ArrayList<>();
    private String[] alB;
    private String[] alu;
    private String alv;
    private String alw;
    private String alx;
    private PlusCommonExtras alz;

    public C1967i(Context context) {
        this.alw = context.getPackageName();
        this.alv = context.getPackageName();
        this.alz = new PlusCommonExtras();
        this.alA.add(Scopes.PLUS_LOGIN);
    }

    /* renamed from: ce */
    public C1967i mo11393ce(String str) {
        this.f4511Dd = str;
        return this;
    }

    /* renamed from: g */
    public C1967i mo11394g(String... strArr) {
        this.alA.clear();
        this.alA.addAll(Arrays.asList(strArr));
        return this;
    }

    /* renamed from: h */
    public C1967i mo11395h(String... strArr) {
        this.alB = strArr;
        return this;
    }

    /* renamed from: nn */
    public C1967i mo11396nn() {
        this.alA.clear();
        return this;
    }

    /* renamed from: no */
    public C1966h mo11397no() {
        if (this.f4511Dd == null) {
            this.f4511Dd = "<<default account>>";
        }
        return new C1966h(this.f4511Dd, (String[]) this.alA.toArray(new String[this.alA.size()]), this.alB, this.alu, this.alv, this.alw, this.alx, this.alz);
    }
}
