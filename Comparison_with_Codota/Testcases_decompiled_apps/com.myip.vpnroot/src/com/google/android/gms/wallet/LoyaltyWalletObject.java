package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.C1382jr;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.wallet.wobs.C2203d;
import com.google.android.gms.wallet.wobs.C2205f;
import com.google.android.gms.wallet.wobs.C2209j;
import com.google.android.gms.wallet.wobs.C2211l;
import com.google.android.gms.wallet.wobs.C2213n;
import com.google.android.gms.wallet.wobs.C2215p;
import java.util.ArrayList;

public final class LoyaltyWalletObject implements SafeParcelable {
    public static final Parcelable.Creator<LoyaltyWalletObject> CREATOR = new C2192j();

    /* renamed from: BR */
    private final int f4619BR;

    /* renamed from: Dv */
    String f4620Dv;
    String asI;
    String asJ;
    String asK;
    String asL;
    String asM;
    String asN;
    String asO;
    String asP;
    ArrayList<C2215p> asQ;
    C2211l asR;
    ArrayList<LatLng> asS;
    String asT;
    String asU;
    ArrayList<C2203d> asV;
    boolean asW;
    ArrayList<C2213n> asX;
    ArrayList<C2209j> asY;
    ArrayList<C2213n> asZ;
    C2205f ata;

    /* renamed from: fl */
    String f4621fl;
    int state;

    LoyaltyWalletObject() {
        this.f4619BR = 4;
        this.asQ = C1382jr.m5209hz();
        this.asS = C1382jr.m5209hz();
        this.asV = C1382jr.m5209hz();
        this.asX = C1382jr.m5209hz();
        this.asY = C1382jr.m5209hz();
        this.asZ = C1382jr.m5209hz();
    }

    LoyaltyWalletObject(int versionCode, String id, String accountId, String issuerName, String programName, String accountName, String barcodeAlternateText, String barcodeType, String barcodeValue, String barcodeLabel, String classId, int state2, ArrayList<C2215p> messages, C2211l validTimeInterval, ArrayList<LatLng> locations, String infoModuleDataHexFontColor, String infoModuleDataHexBackgroundColor, ArrayList<C2203d> infoModuleDataLabelValueRows, boolean infoModuleDataShowLastUpdateTime, ArrayList<C2213n> imageModuleDataMainImageUris, ArrayList<C2209j> textModulesData, ArrayList<C2213n> linksModuleDataUris, C2205f loyaltyPoints) {
        this.f4619BR = versionCode;
        this.f4621fl = id;
        this.asI = accountId;
        this.asJ = issuerName;
        this.asK = programName;
        this.f4620Dv = accountName;
        this.asL = barcodeAlternateText;
        this.asM = barcodeType;
        this.asN = barcodeValue;
        this.asO = barcodeLabel;
        this.asP = classId;
        this.state = state2;
        this.asQ = messages;
        this.asR = validTimeInterval;
        this.asS = locations;
        this.asT = infoModuleDataHexFontColor;
        this.asU = infoModuleDataHexBackgroundColor;
        this.asV = infoModuleDataLabelValueRows;
        this.asW = infoModuleDataShowLastUpdateTime;
        this.asX = imageModuleDataMainImageUris;
        this.asY = textModulesData;
        this.asZ = linksModuleDataUris;
        this.ata = loyaltyPoints;
    }

    public int describeContents() {
        return 0;
    }

    public String getAccountId() {
        return this.asI;
    }

    public String getAccountName() {
        return this.f4620Dv;
    }

    public String getBarcodeAlternateText() {
        return this.asL;
    }

    public String getBarcodeType() {
        return this.asM;
    }

    public String getBarcodeValue() {
        return this.asN;
    }

    public String getId() {
        return this.f4621fl;
    }

    public String getIssuerName() {
        return this.asJ;
    }

    public String getProgramName() {
        return this.asK;
    }

    public int getVersionCode() {
        return this.f4619BR;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C2192j.m7402a(this, dest, flags);
    }
}
