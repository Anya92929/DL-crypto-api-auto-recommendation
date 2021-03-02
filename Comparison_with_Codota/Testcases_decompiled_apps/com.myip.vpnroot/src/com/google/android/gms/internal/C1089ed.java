package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Bundle;
import org.json.JSONException;
import org.json.JSONObject;

@C1130ez
/* renamed from: com.google.android.gms.internal.ed */
public final class C1089ed {
    /* renamed from: D */
    public static String m4320D(String str) {
        if (str == null) {
            return null;
        }
        try {
            return new JSONObject(str).getString("developerPayload");
        } catch (JSONException e) {
            C1229gs.m4679W("Fail to parse purchase data");
            return null;
        }
    }

    /* renamed from: E */
    public static String m4321E(String str) {
        if (str == null) {
            return null;
        }
        try {
            return new JSONObject(str).getString("purchaseToken");
        } catch (JSONException e) {
            C1229gs.m4679W("Fail to parse purchase data");
            return null;
        }
    }

    /* renamed from: b */
    public static int m4322b(Bundle bundle) {
        Object obj = bundle.get("RESPONSE_CODE");
        if (obj == null) {
            C1229gs.m4679W("Bundle with null response code, assuming OK (known issue)");
            return 0;
        } else if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        } else {
            if (obj instanceof Long) {
                return (int) ((Long) obj).longValue();
            }
            C1229gs.m4679W("Unexpected type for intent response code. " + obj.getClass().getName());
            return 5;
        }
    }

    /* renamed from: d */
    public static int m4323d(Intent intent) {
        Object obj = intent.getExtras().get("RESPONSE_CODE");
        if (obj == null) {
            C1229gs.m4679W("Intent with no response code, assuming OK (known issue)");
            return 0;
        } else if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        } else {
            if (obj instanceof Long) {
                return (int) ((Long) obj).longValue();
            }
            C1229gs.m4679W("Unexpected type for intent response code. " + obj.getClass().getName());
            return 5;
        }
    }

    /* renamed from: e */
    public static String m4324e(Intent intent) {
        if (intent == null) {
            return null;
        }
        return intent.getStringExtra("INAPP_PURCHASE_DATA");
    }

    /* renamed from: f */
    public static String m4325f(Intent intent) {
        if (intent == null) {
            return null;
        }
        return intent.getStringExtra("INAPP_DATA_SIGNATURE");
    }
}
