package com.google.android.gms.internal;

import android.content.Context;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

@C1130ez
/* renamed from: com.google.android.gms.internal.gq */
public final class C1227gq extends C1206gg {
    private final Context mContext;

    /* renamed from: mv */
    private final String f3773mv;

    /* renamed from: uR */
    private final String f3774uR;

    /* renamed from: vW */
    private String f3775vW = null;

    public C1227gq(Context context, String str, String str2) {
        this.mContext = context;
        this.f3773mv = str;
        this.f3774uR = str2;
    }

    public C1227gq(Context context, String str, String str2, String str3) {
        this.mContext = context;
        this.f3773mv = str;
        this.f3774uR = str2;
        this.f3775vW = str3;
    }

    /* renamed from: cp */
    public void mo8384cp() {
        HttpURLConnection httpURLConnection;
        try {
            C1229gs.m4678V("Pinging URL: " + this.f3774uR);
            httpURLConnection = (HttpURLConnection) new URL(this.f3774uR).openConnection();
            if (this.f3775vW == null) {
                C1213gj.m4619a(this.mContext, this.f3773mv, true, httpURLConnection);
            } else {
                C1213gj.m4620a(this.mContext, this.f3773mv, true, httpURLConnection, this.f3775vW);
            }
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode < 200 || responseCode >= 300) {
                C1229gs.m4679W("Received non-success response code " + responseCode + " from pinging URL: " + this.f3774uR);
            }
            httpURLConnection.disconnect();
        } catch (IndexOutOfBoundsException e) {
            C1229gs.m4679W("Error while parsing ping URL: " + this.f3774uR + ". " + e.getMessage());
        } catch (IOException e2) {
            C1229gs.m4679W("Error while pinging URL: " + this.f3774uR + ". " + e2.getMessage());
        } catch (Throwable th) {
            httpURLConnection.disconnect();
            throw th;
        }
    }

    public void onStop() {
    }
}
