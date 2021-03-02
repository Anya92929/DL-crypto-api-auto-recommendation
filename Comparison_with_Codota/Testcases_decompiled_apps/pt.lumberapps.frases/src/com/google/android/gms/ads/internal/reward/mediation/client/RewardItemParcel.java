package com.google.android.gms.ads.internal.reward.mediation.client;

import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.internal.zzin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzin
public final class RewardItemParcel extends AbstractSafeParcelable {
    public static final zzc CREATOR = new zzc();
    public final String type;
    public final int versionCode;
    public final int zzcid;

    public RewardItemParcel(int i, String str, int i2) {
        this.versionCode = i;
        this.type = str;
        this.zzcid = i2;
    }

    public RewardItemParcel(RewardItem rewardItem) {
        this(1, rewardItem.getType(), rewardItem.getAmount());
    }

    public RewardItemParcel(String str, int i) {
        this(1, str, i);
    }

    public static RewardItemParcel zza(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        return new RewardItemParcel(jSONArray.getJSONObject(0).optString("rb_type"), jSONArray.getJSONObject(0).optInt("rb_amount"));
    }

    public static RewardItemParcel zzch(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return zza(new JSONArray(str));
        } catch (JSONException e) {
            return null;
        }
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof RewardItemParcel)) {
            return false;
        }
        RewardItemParcel rewardItemParcel = (RewardItemParcel) obj;
        return zzaa.equal(this.type, rewardItemParcel.type) && zzaa.equal(Integer.valueOf(this.zzcid), Integer.valueOf(rewardItemParcel.zzcid));
    }

    public int hashCode() {
        return zzaa.hashCode(this.type, Integer.valueOf(this.zzcid));
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzc.m5766a(this, parcel, i);
    }

    public JSONArray zzrw() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("rb_type", this.type);
        jSONObject.put("rb_amount", this.zzcid);
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(jSONObject);
        return jSONArray;
    }
}
