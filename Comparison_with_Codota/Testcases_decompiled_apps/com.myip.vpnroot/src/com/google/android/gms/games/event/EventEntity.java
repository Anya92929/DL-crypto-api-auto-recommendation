package com.google.android.gms.games.event;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.C1386jv;

public final class EventEntity implements SafeParcelable, Event {
    public static final EventEntityCreator CREATOR = new EventEntityCreator();

    /* renamed from: BR */
    private final int f1676BR;

    /* renamed from: Tg */
    private final String f1677Tg;

    /* renamed from: UW */
    private final Uri f1678UW;

    /* renamed from: VW */
    private final PlayerEntity f1679VW;

    /* renamed from: Vh */
    private final String f1680Vh;

    /* renamed from: Wb */
    private final String f1681Wb;

    /* renamed from: Wc */
    private final long f1682Wc;

    /* renamed from: Wd */
    private final String f1683Wd;

    /* renamed from: We */
    private final boolean f1684We;
    private final String mName;

    EventEntity(int versionCode, String eventId, String name, String description, Uri iconImageUri, String iconImageUrl, Player player, long value, String formattedValue, boolean isVisible) {
        this.f1676BR = versionCode;
        this.f1681Wb = eventId;
        this.mName = name;
        this.f1677Tg = description;
        this.f1678UW = iconImageUri;
        this.f1680Vh = iconImageUrl;
        this.f1679VW = new PlayerEntity(player);
        this.f1682Wc = value;
        this.f1683Wd = formattedValue;
        this.f1684We = isVisible;
    }

    public EventEntity(Event event) {
        this.f1676BR = 1;
        this.f1681Wb = event.getEventId();
        this.mName = event.getName();
        this.f1677Tg = event.getDescription();
        this.f1678UW = event.getIconImageUri();
        this.f1680Vh = event.getIconImageUrl();
        this.f1679VW = (PlayerEntity) event.getPlayer().freeze();
        this.f1682Wc = event.getValue();
        this.f1683Wd = event.getFormattedValue();
        this.f1684We = event.isVisible();
    }

    /* renamed from: a */
    static int m2191a(Event event) {
        return C0345m.hashCode(event.getEventId(), event.getName(), event.getDescription(), event.getIconImageUri(), event.getIconImageUrl(), event.getPlayer(), Long.valueOf(event.getValue()), event.getFormattedValue(), Boolean.valueOf(event.isVisible()));
    }

    /* renamed from: a */
    static boolean m2192a(Event event, Object obj) {
        if (!(obj instanceof Event)) {
            return false;
        }
        if (event == obj) {
            return true;
        }
        Event event2 = (Event) obj;
        return C0345m.equal(event2.getEventId(), event.getEventId()) && C0345m.equal(event2.getName(), event.getName()) && C0345m.equal(event2.getDescription(), event.getDescription()) && C0345m.equal(event2.getIconImageUri(), event.getIconImageUri()) && C0345m.equal(event2.getIconImageUrl(), event.getIconImageUrl()) && C0345m.equal(event2.getPlayer(), event.getPlayer()) && C0345m.equal(Long.valueOf(event2.getValue()), Long.valueOf(event.getValue())) && C0345m.equal(event2.getFormattedValue(), event.getFormattedValue()) && C0345m.equal(Boolean.valueOf(event2.isVisible()), Boolean.valueOf(event.isVisible()));
    }

    /* renamed from: b */
    static String m2193b(Event event) {
        return C0345m.m848h(event).mo4549a("Id", event.getEventId()).mo4549a("Name", event.getName()).mo4549a("Description", event.getDescription()).mo4549a("IconImageUri", event.getIconImageUri()).mo4549a("IconImageUrl", event.getIconImageUrl()).mo4549a("Player", event.getPlayer()).mo4549a("Value", Long.valueOf(event.getValue())).mo4549a("FormattedValue", event.getFormattedValue()).mo4549a("isVisible", Boolean.valueOf(event.isVisible())).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return m2192a(this, obj);
    }

    public Event freeze() {
        return this;
    }

    public String getDescription() {
        return this.f1677Tg;
    }

    public void getDescription(CharArrayBuffer dataOut) {
        C1386jv.m5216b(this.f1677Tg, dataOut);
    }

    public String getEventId() {
        return this.f1681Wb;
    }

    public String getFormattedValue() {
        return this.f1683Wd;
    }

    public void getFormattedValue(CharArrayBuffer dataOut) {
        C1386jv.m5216b(this.f1683Wd, dataOut);
    }

    public Uri getIconImageUri() {
        return this.f1678UW;
    }

    public String getIconImageUrl() {
        return this.f1680Vh;
    }

    public String getName() {
        return this.mName;
    }

    public void getName(CharArrayBuffer dataOut) {
        C1386jv.m5216b(this.mName, dataOut);
    }

    public Player getPlayer() {
        return this.f1679VW;
    }

    public long getValue() {
        return this.f1682Wc;
    }

    public int getVersionCode() {
        return this.f1676BR;
    }

    public int hashCode() {
        return m2191a(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public boolean isVisible() {
        return this.f1684We;
    }

    public String toString() {
        return m2193b(this);
    }

    public void writeToParcel(Parcel out, int flags) {
        EventEntityCreator.m2194a(this, out, flags);
    }
}
