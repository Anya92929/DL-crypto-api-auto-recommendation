package com.google.zxing.client.android.result;

import android.app.Activity;
import com.google.zxing.Result;
import com.google.zxing.client.android.C0776R;
import com.google.zxing.client.result.ParsedResult;

public final class TextResultHandler extends ResultHandler {
    private static final int[] buttons = {C0776R.string.button_web_search, C0776R.string.button_share_by_email, C0776R.string.button_share_by_sms, C0776R.string.button_custom_product_search};

    public TextResultHandler(Activity activity, ParsedResult result, Result rawResult) {
        super(activity, result, rawResult);
    }

    public int getButtonCount() {
        return hasCustomProductSearch() ? buttons.length : buttons.length - 1;
    }

    public int getButtonText(int index) {
        return buttons[index];
    }

    public void handleButtonPress(int index) {
        String text = getResult().getDisplayResult();
        switch (index) {
            case 0:
                webSearch(text);
                return;
            case 1:
                shareByEmail(text);
                return;
            case 2:
                shareBySMS(text);
                return;
            case 3:
                openURL(fillInCustomSearchURL(text));
                return;
            default:
                return;
        }
    }

    public int getDisplayTitle() {
        return C0776R.string.result_text;
    }
}
