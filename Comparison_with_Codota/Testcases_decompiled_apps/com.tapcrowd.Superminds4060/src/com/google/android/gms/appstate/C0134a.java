package com.google.android.gms.appstate;

import com.google.android.gms.internal.C0408dl;

/* renamed from: com.google.android.gms.appstate.a */
public final class C0134a implements AppState {

    /* renamed from: iu */
    private final int f334iu;

    /* renamed from: iv */
    private final String f335iv;

    /* renamed from: iw */
    private final byte[] f336iw;

    /* renamed from: ix */
    private final boolean f337ix;

    /* renamed from: iy */
    private final String f338iy;

    /* renamed from: iz */
    private final byte[] f339iz;

    public C0134a(AppState appState) {
        this.f334iu = appState.getKey();
        this.f335iv = appState.getLocalVersion();
        this.f336iw = appState.getLocalData();
        this.f337ix = appState.hasConflict();
        this.f338iy = appState.getConflictVersion();
        this.f339iz = appState.getConflictData();
    }

    /* renamed from: a */
    static int m206a(AppState appState) {
        return C0408dl.hashCode(Integer.valueOf(appState.getKey()), appState.getLocalVersion(), appState.getLocalData(), Boolean.valueOf(appState.hasConflict()), appState.getConflictVersion(), appState.getConflictData());
    }

    /* renamed from: a */
    static boolean m207a(AppState appState, Object obj) {
        if (!(obj instanceof AppState)) {
            return false;
        }
        if (appState == obj) {
            return true;
        }
        AppState appState2 = (AppState) obj;
        return C0408dl.equal(Integer.valueOf(appState2.getKey()), Integer.valueOf(appState.getKey())) && C0408dl.equal(appState2.getLocalVersion(), appState.getLocalVersion()) && C0408dl.equal(appState2.getLocalData(), appState.getLocalData()) && C0408dl.equal(Boolean.valueOf(appState2.hasConflict()), Boolean.valueOf(appState.hasConflict())) && C0408dl.equal(appState2.getConflictVersion(), appState.getConflictVersion()) && C0408dl.equal(appState2.getConflictData(), appState.getConflictData());
    }

    /* renamed from: b */
    static String m208b(AppState appState) {
        return C0408dl.m938d(appState).mo4388a("Key", Integer.valueOf(appState.getKey())).mo4388a("LocalVersion", appState.getLocalVersion()).mo4388a("LocalData", appState.getLocalData()).mo4388a("HasConflict", Boolean.valueOf(appState.hasConflict())).mo4388a("ConflictVersion", appState.getConflictVersion()).mo4388a("ConflictData", appState.getConflictData()).toString();
    }

    /* renamed from: aE */
    public AppState freeze() {
        return this;
    }

    public boolean equals(Object obj) {
        return m207a(this, obj);
    }

    public byte[] getConflictData() {
        return this.f339iz;
    }

    public String getConflictVersion() {
        return this.f338iy;
    }

    public int getKey() {
        return this.f334iu;
    }

    public byte[] getLocalData() {
        return this.f336iw;
    }

    public String getLocalVersion() {
        return this.f335iv;
    }

    public boolean hasConflict() {
        return this.f337ix;
    }

    public int hashCode() {
        return m206a(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return m208b(this);
    }
}
