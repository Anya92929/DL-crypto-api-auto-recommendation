package com.symbol.emdk.payment;

import com.symbol.emdk.payment.PaymentDevice;
import java.util.ArrayList;

public class CardData extends PaymentData {
    public String getAccountNumber() {
        throw new RuntimeException("stub");
    }

    public PaymentDevice.CardEncodeType getCardEncodeType() {
        throw new RuntimeException("stub");
    }

    public String getCardHolderName() {
        throw new RuntimeException("stub");
    }

    public PaymentDevice.DataEncryptionType getDataEncryptionType() {
        throw new RuntimeException("stub");
    }

    public String getExpiryDate() {
        throw new RuntimeException("stub");
    }

    public String getKeySerialNumber() {
        throw new RuntimeException("stub");
    }

    public String getMaskedPAN() {
        throw new RuntimeException("stub");
    }

    public PaymentDevice.ReadMode getReadMode() {
        throw new RuntimeException("stub");
    }

    public ArrayList<TagData> getTagData() {
        throw new RuntimeException("stub");
    }

    public String getTrack1Data() {
        throw new RuntimeException("stub");
    }

    public boolean getTrack1Status() {
        throw new RuntimeException("stub");
    }

    public String getTrack2Data() {
        throw new RuntimeException("stub");
    }

    public boolean getTrack2Status() {
        throw new RuntimeException("stub");
    }

    public String getTrack3Data() {
        throw new RuntimeException("stub");
    }

    public boolean getTrack3Status() {
        throw new RuntimeException("stub");
    }
}
