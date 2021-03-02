package com.google.zxing.client.android.result;

import android.app.Activity;
import android.telephony.PhoneNumberUtils;
import com.google.zxing.client.android.C0776R;
import com.google.zxing.client.result.ParsedResult;
import com.google.zxing.client.result.SMSParsedResult;

public final class SMSResultHandler extends ResultHandler {
    private static final int[] buttons = {C0776R.string.button_sms, C0776R.string.button_mms};

    public SMSResultHandler(Activity activity, ParsedResult result) {
        super(activity, result);
    }

    public int getButtonCount() {
        return buttons.length;
    }

    public int getButtonText(int index) {
        return buttons[index];
    }

    public void handleButtonPress(int index) {
        SMSParsedResult smsResult = (SMSParsedResult) getResult();
        switch (index) {
            case 0:
                sendSMS(smsResult.getNumbers()[0], smsResult.getBody());
                return;
            case 1:
                sendMMS(smsResult.getNumbers()[0], smsResult.getSubject(), smsResult.getBody());
                return;
            default:
                return;
        }
    }

    public CharSequence getDisplayContents() {
        SMSParsedResult smsResult = (SMSParsedResult) getResult();
        String[] rawNumbers = smsResult.getNumbers();
        String[] formattedNumbers = new String[rawNumbers.length];
        for (int i = 0; i < rawNumbers.length; i++) {
            formattedNumbers[i] = PhoneNumberUtils.formatNumber(rawNumbers[i]);
        }
        StringBuilder contents = new StringBuilder(50);
        ParsedResult.maybeAppend(formattedNumbers, contents);
        ParsedResult.maybeAppend(smsResult.getSubject(), contents);
        ParsedResult.maybeAppend(smsResult.getBody(), contents);
        return contents.toString();
    }

    public int getDisplayTitle() {
        return C0776R.string.result_sms;
    }
}