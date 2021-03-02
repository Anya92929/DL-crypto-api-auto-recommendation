package com.google.android.gms.games.request;

import com.google.android.gms.common.data.C0300g;
import com.google.android.gms.common.data.DataHolder;

public final class GameRequestBuffer extends C0300g<GameRequest> {
    public GameRequestBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    /* access modifiers changed from: protected */
    /* renamed from: gE */
    public String mo4357gE() {
        return "external_request_id";
    }

    /* access modifiers changed from: protected */
    /* renamed from: n */
    public GameRequest mo4356f(int i, int i2) {
        return new GameRequestRef(this.f667IC, i, i2);
    }
}
