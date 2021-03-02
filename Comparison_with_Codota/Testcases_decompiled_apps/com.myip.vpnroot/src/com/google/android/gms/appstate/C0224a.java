package com.google.android.gms.appstate;

import com.google.android.gms.common.internal.C0345m;

/* renamed from: com.google.android.gms.appstate.a */
public final class C0224a implements AppState {

    /* renamed from: CO */
    private final int f350CO;

    /* renamed from: CP */
    private final String f351CP;

    /* renamed from: CQ */
    private final byte[] f352CQ;

    /* renamed from: CR */
    private final boolean f353CR;

    /* renamed from: CS */
    private final String f354CS;

    /* renamed from: CT */
    private final byte[] f355CT;

    public C0224a(AppState appState) {
        this.f350CO = appState.getKey();
        this.f351CP = appState.getLocalVersion();
        this.f352CQ = appState.getLocalData();
        this.f353CR = appState.hasConflict();
        this.f354CS = appState.getConflictVersion();
        this.f355CT = appState.getConflictData();
    }

    /* renamed from: a */
    static int m338a(AppState appState) {
        return C0345m.hashCode(Integer.valueOf(appState.getKey()), appState.getLocalVersion(), appState.getLocalData(), Boolean.valueOf(appState.hasConflict()), appState.getConflictVersion(), appState.getConflictData());
    }

    /* renamed from: a */
    static boolean m339a(AppState appState, Object obj) {
        if (!(obj instanceof AppState)) {
            return false;
        }
        if (appState == obj) {
            return true;
        }
        AppState appState2 = (AppState) obj;
        return C0345m.equal(Integer.valueOf(appState2.getKey()), Integer.valueOf(appState.getKey())) && C0345m.equal(appState2.getLocalVersion(), appState.getLocalVersion()) && C0345m.equal(appState2.getLocalData(), appState.getLocalData()) && C0345m.equal(Boolean.valueOf(appState2.hasConflict()), Boolean.valueOf(appState.hasConflict())) && C0345m.equal(appState2.getConflictVersion(), appState.getConflictVersion()) && C0345m.equal(appState2.getConflictData(), appState.getConflictData());
    }

    /* renamed from: b */
    static String m340b(AppState appState) {
        return C0345m.m848h(appState).mo4549a("Key", Integer.valueOf(appState.getKey())).mo4549a("LocalVersion", appState.getLocalVersion()).mo4549a("LocalData", appState.getLocalData()).mo4549a("HasConflict", Boolean.valueOf(appState.hasConflict())).mo4549a("ConflictVersion", appState.getConflictVersion()).mo4549a("ConflictData", appState.getConflictData()).toString();
    }

    public boolean equals(Object obj) {
        return m339a(this, obj);
    }

    /* renamed from: fp */
    public AppState freeze() {
        return this;
    }

    public byte[] getConflictData() {
        return this.f355CT;
    }

    public String getConflictVersion() {
        return this.f354CS;
    }

    public int getKey() {
        return this.f350CO;
    }

    public byte[] getLocalData() {
        return this.f352CQ;
    }

    public String getLocalVersion() {
        return this.f351CP;
    }

    public boolean hasConflict() {
        return this.f353CR;
    }

    public int hashCode() {
        return m338a(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return m340b(this);
    }
}
