package com.google.android.gms.appstate;

import com.google.android.gms.internal.C0618r;

/* renamed from: com.google.android.gms.appstate.a */
public final class C0338a implements AppState {

    /* renamed from: h */
    private final int f761h;

    /* renamed from: i */
    private final String f762i;

    /* renamed from: j */
    private final byte[] f763j;

    /* renamed from: k */
    private final boolean f764k;

    /* renamed from: l */
    private final String f765l;

    /* renamed from: m */
    private final byte[] f766m;

    public C0338a(AppState appState) {
        this.f761h = appState.getKey();
        this.f762i = appState.getLocalVersion();
        this.f763j = appState.getLocalData();
        this.f764k = appState.hasConflict();
        this.f765l = appState.getConflictVersion();
        this.f766m = appState.getConflictData();
    }

    /* renamed from: a */
    static int m530a(AppState appState) {
        return C0618r.hashCode(Integer.valueOf(appState.getKey()), appState.getLocalVersion(), appState.getLocalData(), Boolean.valueOf(appState.hasConflict()), appState.getConflictVersion(), appState.getConflictData());
    }

    /* renamed from: a */
    static boolean m531a(AppState appState, Object obj) {
        if (!(obj instanceof AppState)) {
            return false;
        }
        if (appState == obj) {
            return true;
        }
        AppState appState2 = (AppState) obj;
        return C0618r.m1881a(Integer.valueOf(appState2.getKey()), Integer.valueOf(appState.getKey())) && C0618r.m1881a(appState2.getLocalVersion(), appState.getLocalVersion()) && C0618r.m1881a(appState2.getLocalData(), appState.getLocalData()) && C0618r.m1881a(Boolean.valueOf(appState2.hasConflict()), Boolean.valueOf(appState.hasConflict())) && C0618r.m1881a(appState2.getConflictVersion(), appState.getConflictVersion()) && C0618r.m1881a(appState2.getConflictData(), appState.getConflictData());
    }

    /* renamed from: b */
    static String m532b(AppState appState) {
        return C0618r.m1882c(appState).mo5486a("Key", Integer.valueOf(appState.getKey())).mo5486a("LocalVersion", appState.getLocalVersion()).mo5486a("LocalData", appState.getLocalData()).mo5486a("HasConflict", Boolean.valueOf(appState.hasConflict())).mo5486a("ConflictVersion", appState.getConflictVersion()).mo5486a("ConflictData", appState.getConflictData()).toString();
    }

    /* renamed from: a */
    public AppState freeze() {
        return this;
    }

    public boolean equals(Object obj) {
        return m531a(this, obj);
    }

    public byte[] getConflictData() {
        return this.f766m;
    }

    public String getConflictVersion() {
        return this.f765l;
    }

    public int getKey() {
        return this.f761h;
    }

    public byte[] getLocalData() {
        return this.f763j;
    }

    public String getLocalVersion() {
        return this.f762i;
    }

    public boolean hasConflict() {
        return this.f764k;
    }

    public int hashCode() {
        return m530a(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return m532b(this);
    }
}
