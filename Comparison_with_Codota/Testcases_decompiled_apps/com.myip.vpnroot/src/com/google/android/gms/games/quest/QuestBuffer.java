package com.google.android.gms.games.quest;

import com.google.android.gms.common.data.C0300g;
import com.google.android.gms.common.data.DataHolder;

public final class QuestBuffer extends C0300g<Quest> {
    public QuestBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    /* access modifiers changed from: protected */
    /* renamed from: gE */
    public String mo4357gE() {
        return "external_quest_id";
    }

    /* access modifiers changed from: protected */
    /* renamed from: m */
    public Quest mo4356f(int i, int i2) {
        return new QuestRef(this.f667IC, i, i2);
    }
}
