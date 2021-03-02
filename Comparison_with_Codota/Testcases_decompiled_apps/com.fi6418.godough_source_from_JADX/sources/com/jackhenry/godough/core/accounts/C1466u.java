package com.jackhenry.godough.core.accounts;

/* renamed from: com.jackhenry.godough.core.accounts.u */
class C1466u implements C1427g {

    /* renamed from: a */
    final /* synthetic */ C1465t f5930a;

    C1466u(C1465t tVar) {
        this.f5930a = tVar;
    }

    /* renamed from: a */
    public void mo9574a(int i) {
        if (!this.f5930a.mo9669c()) {
            this.f5930a.f5927c.onClick(i);
        }
    }

    /* renamed from: b */
    public void mo9575b(int i) {
        if (!this.f5930a.mo9669c() && !this.f5930a.mo9666a(i)) {
            boolean unused = this.f5930a.f5929e = true;
            this.f5930a.notifyDataSetChanged();
            this.f5930a.f5927c.onEditModeStart();
        }
    }
}
