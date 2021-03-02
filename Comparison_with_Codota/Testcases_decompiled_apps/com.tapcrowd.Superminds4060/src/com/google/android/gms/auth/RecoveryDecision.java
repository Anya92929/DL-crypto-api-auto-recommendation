package com.google.android.gms.auth;

import android.app.PendingIntent;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class RecoveryDecision implements SafeParcelable {
    public static final RecoveryDecisionCreator CREATOR = new RecoveryDecisionCreator();

    /* renamed from: iM */
    final int f345iM;
    public boolean isRecoveryInfoNeeded;
    public boolean isRecoveryInterstitialAllowed;
    public PendingIntent recoveryIntent;
    public PendingIntent recoveryIntentWithoutIntro;
    public boolean showRecoveryInterstitial;

    public RecoveryDecision() {
        this.f345iM = 1;
    }

    RecoveryDecision(int versionCode, PendingIntent recoveryIntent2, boolean showRecoveryInterstitial2, boolean isRecoveryInfoNeeded2, boolean isRecoveryInterstitialAllowed2, PendingIntent recoveryIntentWithoutIntro2) {
        this.f345iM = versionCode;
        this.recoveryIntent = recoveryIntent2;
        this.showRecoveryInterstitial = showRecoveryInterstitial2;
        this.isRecoveryInfoNeeded = isRecoveryInfoNeeded2;
        this.isRecoveryInterstitialAllowed = isRecoveryInterstitialAllowed2;
        this.recoveryIntentWithoutIntro = recoveryIntentWithoutIntro2;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.f345iM;
    }

    public void writeToParcel(Parcel out, int flags) {
        RecoveryDecisionCreator.m216a(this, out, flags);
    }
}
