package com.google.android.gms.internal;

import android.text.TextUtils;

/* renamed from: com.google.android.gms.internal.es */
final class C1535es extends zzdh {
    C1535es() {
    }

    /* renamed from: a */
    private String m6381a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int i = 0;
        int length = str.length();
        while (i < str.length() && str.charAt(i) == ',') {
            i++;
        }
        while (length > 0 && str.charAt(length - 1) == ',') {
            length--;
        }
        return (i == 0 && length == str.length()) ? str : str.substring(i, length);
    }

    public String zzg(String str, String str2) {
        String a = m6381a(str);
        String a2 = m6381a(str2);
        return TextUtils.isEmpty(a) ? a2 : TextUtils.isEmpty(a2) ? a : new StringBuilder(String.valueOf(a).length() + 1 + String.valueOf(a2).length()).append(a).append(",").append(a2).toString();
    }
}
