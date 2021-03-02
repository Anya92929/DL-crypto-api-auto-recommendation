package com.google.zxing.client.android.result;

import android.app.Activity;
import android.view.View;
import com.google.zxing.Result;
import com.google.zxing.client.android.C0776R;
import com.google.zxing.client.result.ExpandedProductParsedResult;
import com.google.zxing.client.result.ParsedResult;
import com.google.zxing.client.result.ProductParsedResult;

public final class ProductResultHandler extends ResultHandler {
    private static final int[] buttons = {C0776R.string.button_product_search, C0776R.string.button_web_search, C0776R.string.button_custom_product_search};

    public ProductResultHandler(Activity activity, ParsedResult result, Result rawResult) {
        super(activity, result, rawResult);
        showGoogleShopperButton(new View.OnClickListener() {
            public void onClick(View view) {
                ProductResultHandler.this.openGoogleShopper(ProductResultHandler.getProductIDFromResult(ProductResultHandler.this.getResult()));
            }
        });
    }

    public int getButtonCount() {
        return hasCustomProductSearch() ? buttons.length : buttons.length - 1;
    }

    public int getButtonText(int index) {
        return buttons[index];
    }

    public void handleButtonPress(int index) {
        String productID = getProductIDFromResult(getResult());
        switch (index) {
            case 0:
                openProductSearch(productID);
                return;
            case 1:
                webSearch(productID);
                return;
            case 2:
                openURL(fillInCustomSearchURL(productID));
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: private */
    public static String getProductIDFromResult(ParsedResult rawResult) {
        if (rawResult instanceof ProductParsedResult) {
            return ((ProductParsedResult) rawResult).getNormalizedProductID();
        }
        if (rawResult instanceof ExpandedProductParsedResult) {
            return ((ExpandedProductParsedResult) rawResult).getRawText();
        }
        throw new IllegalArgumentException(rawResult.getClass().toString());
    }

    public int getDisplayTitle() {
        return C0776R.string.result_product;
    }
}
