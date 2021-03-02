package com.symbol.emdk.payment;

import java.util.ArrayList;

public class PaymentDevice {

    public interface DataListener {
        void onData(PaymentData paymentData);
    }

    /* 'enum' modifier removed */
    /* JADX WARNING: Enum class init method not found */
    public static final class CardEncodeType extends Enum<CardEncodeType> {
        public static final CardEncodeType ISO_ABA = null;
        public static final CardEncodeType NON_ISO_ABA = null;

        public static CardEncodeType valueOf(String str) {
            throw new RuntimeException("stub");
        }

        public static CardEncodeType[] values() {
            throw new RuntimeException("stub");
        }
    }

    /* 'enum' modifier removed */
    /* JADX WARNING: Enum class init method not found */
    public static final class DataEncryptionType extends Enum<DataEncryptionType> {
        public static final DataEncryptionType AES = null;
        public static final DataEncryptionType NONE = null;
        public static final DataEncryptionType RSA_1024 = null;
        public static final DataEncryptionType RSA_2048 = null;
        public static final DataEncryptionType TRIPLE_DES = null;

        public static DataEncryptionType valueOf(String str) {
            throw new RuntimeException("stub");
        }

        public static DataEncryptionType[] values() {
            throw new RuntimeException("stub");
        }
    }

    /* 'enum' modifier removed */
    /* JADX WARNING: Enum class init method not found */
    public static final class HostDecision extends Enum<HostDecision> {
        public static final HostDecision CONNECT_FAILED = null;
        public static final HostDecision HOST_AUTHORIZED = null;
        public static final HostDecision HOST_DECLINE = null;

        public static HostDecision valueOf(String str) {
            throw new RuntimeException("stub");
        }

        public static HostDecision[] values() {
            throw new RuntimeException("stub");
        }
    }

    /* 'enum' modifier removed */
    /* JADX WARNING: Enum class init method not found */
    public static final class MerchantDecision extends Enum<MerchantDecision> {
        public static final MerchantDecision FORCE_DECLINE = null;
        public static final MerchantDecision FORCE_ONLINE = null;
        public static final MerchantDecision REQUEST_TC = null;

        public static MerchantDecision valueOf(String str) {
            throw new RuntimeException("stub");
        }

        public static MerchantDecision[] values() {
            throw new RuntimeException("stub");
        }
    }

    /* 'enum' modifier removed */
    /* JADX WARNING: Enum class init method not found */
    public static final class ReadMode extends Enum<ReadMode> {
        public static final ReadMode ALL = null;
        public static final ReadMode INSERT = null;
        public static final ReadMode MANUAL = null;
        public static final ReadMode SWIPE = null;
        public static final ReadMode TOUCH = null;

        public static ReadMode valueOf(String str) {
            throw new RuntimeException("stub");
        }

        public static ReadMode[] values() {
            throw new RuntimeException("stub");
        }
    }

    public PaymentResults abort() {
        throw new RuntimeException("stub");
    }

    public void addDataListener(DataListener dataListener) throws PaymentException {
        throw new RuntimeException("stub");
    }

    public PaymentResults authorizeCard(double d, double d2, MerchantDecision merchantDecision, ArrayList<String> arrayList, boolean z, boolean z2, boolean z3, boolean z4, int i) {
        throw new RuntimeException("stub");
    }

    public PaymentResults completeOnlineEmv(HostDecision hostDecision, boolean z, ArrayList<TagData> arrayList) {
        throw new RuntimeException("stub");
    }

    public MacData createMac(String str) {
        throw new RuntimeException("stub");
    }

    public void disable() throws PaymentException {
        throw new RuntimeException("stub");
    }

    public PaymentResults disableKeypad() {
        throw new RuntimeException("stub");
    }

    public void enable() throws PaymentException {
        throw new RuntimeException("stub");
    }

    public PaymentResults enableKeypad() {
        throw new RuntimeException("stub");
    }

    public PaymentResults enableKeypad(int i) {
        throw new RuntimeException("stub");
    }

    public BatteryData getBatteryLevel() {
        throw new RuntimeException("stub");
    }

    public PaymentConfig getConfig() throws PaymentException {
        throw new RuntimeException("stub");
    }

    public DeviceInfo getDeviceInfo() {
        throw new RuntimeException("stub");
    }

    public PaymentResults getEmvTags(ArrayList<String> arrayList) {
        throw new RuntimeException("stub");
    }

    public InterfaceConfig getInterfaceConfig() throws PaymentException {
        throw new RuntimeException("stub");
    }

    public BatteryData getLowBatteryThreshold() {
        throw new RuntimeException("stub");
    }

    public boolean isEnabled() {
        throw new RuntimeException("stub");
    }

    public PaymentResults promptAdditionalInfo(double d, int i, boolean z, boolean z2, double d2, int i2) {
        throw new RuntimeException("stub");
    }

    public PaymentResults promptMenu(String str, String str2, String str3, String str4, String str5, String str6, int i) {
        throw new RuntimeException("stub");
    }

    public PaymentResults promptMessage(String str, String str2, String str3, String str4, boolean z, int i) {
        throw new RuntimeException("stub");
    }

    public PaymentResults promptPin(String str, int i, int i2, boolean z, int i3) {
        throw new RuntimeException("stub");
    }

    public PaymentResults promptPin(String str, int i, int i2, boolean z, int i3, PromptPinMessage promptPinMessage) {
        throw new RuntimeException("stub");
    }

    public PaymentResults readCardData(double d, double d2, ReadMode readMode, int i) {
        throw new RuntimeException("stub");
    }

    public PaymentResults readCardData(double d, double d2, ReadMode readMode, int i, ReadCardMessage readCardMessage) {
        throw new RuntimeException("stub");
    }

    public void removeCard(String str, String str2) throws PaymentException {
        throw new RuntimeException("stub");
    }

    public void removeDataListener(DataListener dataListener) throws PaymentException {
        throw new RuntimeException("stub");
    }

    public void setConfig(PaymentConfig paymentConfig) throws PaymentException {
        throw new RuntimeException("stub");
    }

    public PaymentResults setEmvTags(ArrayList<TagData> arrayList) {
        throw new RuntimeException("stub");
    }

    public void setInterfaceConfig(InterfaceConfig interfaceConfig) throws PaymentException {
        throw new RuntimeException("stub");
    }

    public PaymentResults setLowBatteryThreshold(int i, String str) {
        throw new RuntimeException("stub");
    }

    public PaymentResults validateMac(String str, int i, String str2, String str3, String str4, String str5, String str6) {
        throw new RuntimeException("stub");
    }
}
