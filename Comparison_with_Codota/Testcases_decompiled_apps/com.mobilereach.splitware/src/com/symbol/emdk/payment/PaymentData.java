package com.symbol.emdk.payment;

public class PaymentData {

    /* 'enum' modifier removed */
    /* JADX WARNING: Enum class init method not found */
    public static final class DataType extends Enum<DataType> {
        public static final DataType AUTHORIZECARD = null;
        public static final DataType COMPLETEONLINEEMV = null;
        public static final DataType ENABLE = null;
        public static final DataType GETEMVTAG = null;
        public static final DataType PROMPTADDITIONALINFO = null;
        public static final DataType PROMPTMENU = null;
        public static final DataType PROMPTMESSAGE = null;
        public static final DataType PROMPTPIN = null;
        public static final DataType READCARDDATA = null;
        public static final DataType UNDEFINED = null;
        public static final DataType VALIDATEMAC = null;

        public static DataType valueOf(String str) {
            throw new RuntimeException("stub");
        }

        public static DataType[] values() {
            throw new RuntimeException("stub");
        }
    }

    public DataType getDataType() {
        throw new RuntimeException("stub");
    }

    public PaymentResults getResult() {
        throw new RuntimeException("stub");
    }
}
