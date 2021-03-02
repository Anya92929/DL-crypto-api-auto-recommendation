package com.symbol.emdk.payment;

import com.symbol.emdk.payment.PaymentDevice;

public class PaymentConfig {
    public int dataEncryptionKeySlot;
    public PaymentDevice.DataEncryptionType dataEncryptionType;
    public boolean getAllEncryptedData;
    public String idleMessage;
    public int languageCode;
    public int maskFirstDigits;
    public int sleepModeTimeout;
}
