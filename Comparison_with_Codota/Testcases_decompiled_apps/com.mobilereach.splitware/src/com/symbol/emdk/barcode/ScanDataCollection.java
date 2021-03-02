package com.symbol.emdk.barcode;

import java.util.ArrayList;

public class ScanDataCollection {

    /* 'enum' modifier removed */
    /* JADX WARNING: Enum class init method not found */
    public static final class LabelType extends Enum<LabelType> {
        public static final LabelType AUSPOSTAL = null;
        public static final LabelType AZTEC = null;
        public static final LabelType BOOKLAND = null;
        public static final LabelType CANPOSTAL = null;
        public static final LabelType CHINESE_2OF5 = null;
        public static final LabelType CODABAR = null;
        public static final LabelType CODE11 = null;
        public static final LabelType CODE128 = null;
        public static final LabelType CODE32 = null;
        public static final LabelType CODE39 = null;
        public static final LabelType CODE93 = null;
        public static final LabelType COMPOSITE_AB = null;
        public static final LabelType COMPOSITE_C = null;
        public static final LabelType COUPON = null;
        public static final LabelType D2OF5 = null;
        public static final LabelType DATABAR_COUPON = null;
        public static final LabelType DATAMATRIX = null;
        public static final LabelType DUTCHPOSTAL = null;
        public static final LabelType EAN128 = null;
        public static final LabelType EAN13 = null;
        public static final LabelType EAN8 = null;
        public static final LabelType GS1_DATABAR = null;
        public static final LabelType GS1_DATABAR_EXP = null;
        public static final LabelType GS1_DATABAR_LIM = null;
        public static final LabelType HANXIN = null;
        public static final LabelType I2OF5 = null;
        public static final LabelType IATA2OF5 = null;
        public static final LabelType ISBT128 = null;
        public static final LabelType JAPPOSTAL = null;
        public static final LabelType KOREAN_3OF5 = null;
        public static final LabelType MAILMARK = null;
        public static final LabelType MATRIX_2OF5 = null;
        public static final LabelType MAXICODE = null;
        public static final LabelType MICROPDF = null;
        public static final LabelType MICROQR = null;
        public static final LabelType MSI = null;
        public static final LabelType OCR = null;
        public static final LabelType PDF417 = null;
        public static final LabelType QRCODE = null;
        public static final LabelType SIGNATURE = null;
        public static final LabelType TLC39 = null;
        public static final LabelType TRIOPTIC39 = null;
        public static final LabelType UKPOSTAL = null;
        public static final LabelType UNDEFINED = null;
        public static final LabelType UPCA = null;
        public static final LabelType UPCE0 = null;
        public static final LabelType UPCE1 = null;
        public static final LabelType US4STATE = null;
        public static final LabelType US4STATE_FICS = null;
        public static final LabelType USPLANET = null;
        public static final LabelType USPOSTNET = null;
        public static final LabelType WEBCODE = null;

        public static LabelType valueOf(String str) {
            throw new RuntimeException("stub");
        }

        public static LabelType[] values() {
            throw new RuntimeException("stub");
        }
    }

    public class ScanData {
        public String getData() {
            throw new RuntimeException("stub");
        }

        public LabelType getLabelType() {
            throw new RuntimeException("stub");
        }

        public String getTimeStamp() {
            throw new RuntimeException("stub");
        }
    }

    public String getFriendlyName() {
        throw new RuntimeException("stub");
    }

    public ScannerResults getResult() {
        throw new RuntimeException("stub");
    }

    public ArrayList<ScanData> getScanData() {
        throw new RuntimeException("stub");
    }
}
