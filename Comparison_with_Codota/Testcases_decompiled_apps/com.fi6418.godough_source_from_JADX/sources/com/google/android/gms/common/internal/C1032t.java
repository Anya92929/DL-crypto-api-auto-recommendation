package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.view.View;
import com.google.android.gms.common.api.C0702a;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.signin.C1247g;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* renamed from: com.google.android.gms.common.internal.t */
public final class C1032t {

    /* renamed from: a */
    private final Account f4750a;

    /* renamed from: b */
    private final Set<Scope> f4751b;

    /* renamed from: c */
    private final Set<Scope> f4752c;

    /* renamed from: d */
    private final Map<C0702a<?>, C1033u> f4753d;

    /* renamed from: e */
    private final int f4754e;

    /* renamed from: f */
    private final View f4755f;

    /* renamed from: g */
    private final String f4756g;

    /* renamed from: h */
    private final String f4757h;

    /* renamed from: i */
    private final C1247g f4758i;

    /* renamed from: j */
    private Integer f4759j;

    public C1032t(Account account, Set<Scope> set, Map<C0702a<?>, C1033u> map, int i, View view, String str, String str2, C1247g gVar) {
        this.f4750a = account;
        this.f4751b = set == null ? Collections.EMPTY_SET : Collections.unmodifiableSet(set);
        this.f4753d = map == null ? Collections.EMPTY_MAP : map;
        this.f4755f = view;
        this.f4754e = i;
        this.f4756g = str;
        this.f4757h = str2;
        this.f4758i = gVar;
        HashSet hashSet = new HashSet(this.f4751b);
        for (C1033u uVar : this.f4753d.values()) {
            hashSet.addAll(uVar.f4760a);
        }
        this.f4752c = Collections.unmodifiableSet(hashSet);
    }

    @Deprecated
    /* renamed from: a */
    public String mo7629a() {
        if (this.f4750a != null) {
            return this.f4750a.name;
        }
        return null;
    }

    /* renamed from: a */
    public void mo7630a(Integer num) {
        this.f4759j = num;
    }

    /* renamed from: b */
    public Account mo7631b() {
        return this.f4750a;
    }

    /* renamed from: c */
    public Account mo7632c() {
        return this.f4750a != null ? this.f4750a : new Account("<<default account>>", "com.google");
    }

    /* renamed from: d */
    public Set<Scope> mo7633d() {
        return this.f4751b;
    }

    /* renamed from: e */
    public Set<Scope> mo7634e() {
        return this.f4752c;
    }

    /* renamed from: f */
    public Map<C0702a<?>, C1033u> mo7635f() {
        return this.f4753d;
    }

    /* renamed from: g */
    public String mo7636g() {
        return this.f4756g;
    }

    /* renamed from: h */
    public String mo7637h() {
        return this.f4757h;
    }

    /* renamed from: i */
    public C1247g mo7638i() {
        return this.f4758i;
    }

    /* renamed from: j */
    public Integer mo7639j() {
        return this.f4759j;
    }
}
