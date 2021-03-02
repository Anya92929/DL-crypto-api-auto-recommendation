package com.google.android.gms.games.internal.notification;

import com.google.android.gms.common.data.C0297d;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.plus.PlusShare;

public final class GameNotificationRef extends C0297d implements GameNotification {
    GameNotificationRef(DataHolder holder, int dataRow) {
        super(holder, dataRow);
    }

    public long getId() {
        return getLong("_id");
    }

    public String getText() {
        return getString("text");
    }

    public String getTitle() {
        return getString(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE);
    }

    public int getType() {
        return getInteger("type");
    }

    /* renamed from: li */
    public String mo7403li() {
        return getString("notification_id");
    }

    /* renamed from: lj */
    public String mo7404lj() {
        return getString("ticker");
    }

    /* renamed from: lk */
    public String mo7405lk() {
        return getString("coalesced_text");
    }

    /* renamed from: ll */
    public boolean mo7406ll() {
        return getInteger("acknowledged") > 0;
    }

    /* renamed from: lm */
    public boolean mo7407lm() {
        return getInteger("alert_level") == 0;
    }

    public String toString() {
        return C0345m.m848h(this).mo4549a("Id", Long.valueOf(getId())).mo4549a("NotificationId", mo7403li()).mo4549a("Type", Integer.valueOf(getType())).mo4549a("Title", getTitle()).mo4549a("Ticker", mo7404lj()).mo4549a("Text", getText()).mo4549a("CoalescedText", mo7405lk()).mo4549a("isAcknowledged", Boolean.valueOf(mo7406ll())).mo4549a("isSilent", Boolean.valueOf(mo7407lm())).toString();
    }
}
