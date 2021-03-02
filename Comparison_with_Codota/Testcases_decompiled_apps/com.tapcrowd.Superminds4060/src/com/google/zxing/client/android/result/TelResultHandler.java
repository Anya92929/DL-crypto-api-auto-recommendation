package com.google.zxing.client.android.result;

import android.app.Activity;
import android.telephony.PhoneNumberUtils;
import com.google.zxing.client.android.C0776R;
import com.google.zxing.client.result.ParsedResult;
import com.google.zxing.client.result.TelParsedResult;

public final class TelResultHandler extends ResultHandler {
    private static final int[] buttons = {C0776R.string.button_dial, C0776R.string.button_add_contact};

    public TelResultHandler(Activity activity, ParsedResult result) {
        super(activity, result);
    }

    public int getButtonCount() {
        return buttons.length;
    }

    public int getButtonText(int index) {
        return buttons[index];
    }

    public void handleButtonPress(int index) {
        TelParsedResult telResult = (TelParsedResult) getResult();
        switch (index) {
            case 0:
                dialPhoneFromUri(telResult.getTelURI());
                getActivity().finish();
                return;
            case 1:
                addPhoneOnlyContact(new String[]{telResult.getNumber()}, (String[]) null);
                return;
            default:
                return;
        }
    }

    public CharSequence getDisplayContents() {
        return PhoneNumberUtils.formatNumber(getResult().getDisplayResult().replace("\r", ""));
    }

    public int getDisplayTitle() {
        return C0776R.string.result_tel;
    }
}
