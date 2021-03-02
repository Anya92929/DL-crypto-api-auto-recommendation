package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.C1382jr;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;

public class CommonWalletObject implements SafeParcelable {
    public static final Parcelable.Creator<CommonWalletObject> CREATOR = new C2200a();

    /* renamed from: BR */
    private final int f4638BR;
    String asJ;
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

    /* renamed from: fl */
    String f4639fl;
    String name;
    int state;

    /* renamed from: com.google.android.gms.wallet.wobs.CommonWalletObject$a */
    public final class C2199a {
        private C2199a() {
        }

        /* renamed from: dc */
        public C2199a mo12101dc(String str) {
            CommonWalletObject.this.f4639fl = str;
            return this;
        }

        /* renamed from: pP */
        public CommonWalletObject mo12102pP() {
            return CommonWalletObject.this;
        }
    }

    CommonWalletObject() {
        this.f4638BR = 1;
        this.asQ = C1382jr.m5209hz();
        this.asS = C1382jr.m5209hz();
        this.asV = C1382jr.m5209hz();
        this.asX = C1382jr.m5209hz();
        this.asY = C1382jr.m5209hz();
        this.asZ = C1382jr.m5209hz();
    }

    CommonWalletObject(int versionCode, String id, String classId, String name2, String issuerName, String barcodeAlternateText, String barcodeType, String barcodeValue, String barcodeLabel, int state2, ArrayList<C2215p> messages, C2211l validTimeInterval, ArrayList<LatLng> locations, String infoModuleDataHexFontColor, String infoModuleDataHexBackgroundColor, ArrayList<C2203d> infoModuleDataLabelValueRows, boolean infoModuleDataShowLastUpdateTime, ArrayList<C2213n> imageModuleDataMainImageUris, ArrayList<C2209j> textModulesData, ArrayList<C2213n> linksModuleDataUris) {
        this.f4638BR = versionCode;
        this.f4639fl = id;
        this.asP = classId;
        this.name = name2;
        this.asJ = issuerName;
        this.asL = barcodeAlternateText;
        this.asM = barcodeType;
        this.asN = barcodeValue;
        this.asO = barcodeLabel;
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
    }

    /* renamed from: pO */
    public static C2199a m7420pO() {
        CommonWalletObject commonWalletObject = new CommonWalletObject();
        commonWalletObject.getClass();
        return new C2199a();
    }

    public int describeContents() {
        return 0;
    }

    public String getId() {
        return this.f4639fl;
    }

    public int getVersionCode() {
        return this.f4638BR;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C2200a.m7423a(this, dest, flags);
    }
}
