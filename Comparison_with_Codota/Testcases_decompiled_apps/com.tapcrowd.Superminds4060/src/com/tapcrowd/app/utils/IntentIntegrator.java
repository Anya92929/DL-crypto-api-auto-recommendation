package com.tapcrowd.app.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.p000v4.app.Fragment;
import com.google.zxing.client.android.Contents;
import com.google.zxing.client.android.Intents;
import com.tapcrowd.Superminds4060.C0846R;

public final class IntentIntegrator {
    public static final String ALL_CODE_TYPES = null;
    public static final String DEFAULT_MESSAGE = App.act.getString(C0846R.string.instal_barcode_scanner_message);
    public static final String DEFAULT_NO = App.act.getString(C0846R.string.f2002no);
    public static final String DEFAULT_TITLE = App.act.getString(C0846R.string.instal_barcode_scanner_title);
    public static final String DEFAULT_YES = App.act.getString(C0846R.string.yes);
    public static final String ONE_D_CODE_TYPES = "UPC_A,UPC_E,EAN_8,EAN_13,CODE_39,CODE_93,CODE_128";
    public static final String PRODUCT_CODE_TYPES = "UPC_A,UPC_E,EAN_8,EAN_13";
    public static final String QR_CODE_TYPES = "QR_CODE";
    public static final int REQUEST_CODE = 1612;

    private IntentIntegrator() {
    }

    public static AlertDialog initiateScan(Fragment fragment, Activity activity) {
        return initiateScan(fragment, activity, (CharSequence) DEFAULT_TITLE, (CharSequence) DEFAULT_MESSAGE, (CharSequence) DEFAULT_YES, (CharSequence) DEFAULT_NO);
    }

    public static AlertDialog initiateScan(Fragment fragment, Activity activity, int stringTitle, int stringMessage, int stringButtonYes, int stringButtonNo) {
        return initiateScan(fragment, activity, (CharSequence) activity.getString(stringTitle), (CharSequence) activity.getString(stringMessage), (CharSequence) activity.getString(stringButtonYes), (CharSequence) activity.getString(stringButtonNo));
    }

    public static AlertDialog initiateScan(Fragment fragment, Activity activity, CharSequence stringTitle, CharSequence stringMessage, CharSequence stringButtonYes, CharSequence stringButtonNo) {
        return initiateScan(fragment, activity, stringTitle, stringMessage, stringButtonYes, stringButtonNo, ALL_CODE_TYPES);
    }

    public static AlertDialog initiateScan(Fragment fragment, Activity activity, CharSequence stringTitle, CharSequence stringMessage, CharSequence stringButtonYes, CharSequence stringButtonNo, CharSequence stringDesiredBarcodeFormats) {
        Intent intentScan = new Intent(Intents.Scan.ACTION);
        intentScan.putExtra(Intents.Scan.MODE, Intents.Scan.QR_CODE_MODE);
        intentScan.addCategory("android.intent.category.DEFAULT");
        if (stringDesiredBarcodeFormats != null) {
            intentScan.putExtra(Intents.Scan.FORMATS, stringDesiredBarcodeFormats);
        }
        try {
            fragment.startActivityForResult(intentScan, REQUEST_CODE);
            return null;
        } catch (ActivityNotFoundException e) {
            return showDownloadDialog(activity, stringTitle, stringMessage, stringButtonYes, stringButtonNo);
        }
    }

    private static AlertDialog showDownloadDialog(final Activity activity, CharSequence stringTitle, CharSequence stringMessage, CharSequence stringButtonYes, CharSequence stringButtonNo) {
        AlertDialog.Builder downloadDialog = new AlertDialog.Builder(activity);
        downloadDialog.setTitle(stringTitle);
        downloadDialog.setMessage(stringMessage);
        downloadDialog.setPositiveButton(stringButtonYes, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://search?q=pname:com.google.zxing.client.android")));
            }
        });
        downloadDialog.setNegativeButton(stringButtonNo, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                App.act.onBackPressed();
            }
        });
        return downloadDialog.show();
    }

    public static IntentResult parseActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode != 1612) {
            return null;
        }
        if (resultCode == -1) {
            return new IntentResult(intent.getStringExtra(Intents.Scan.RESULT), intent.getStringExtra(Intents.Scan.RESULT_FORMAT));
        }
        return new IntentResult((String) null, (String) null);
    }

    public static void shareText(Activity activity, CharSequence text) {
        shareText(activity, text, (CharSequence) DEFAULT_TITLE, (CharSequence) DEFAULT_MESSAGE, (CharSequence) DEFAULT_YES, (CharSequence) DEFAULT_NO);
    }

    public static void shareText(Activity activity, CharSequence text, int stringTitle, int stringMessage, int stringButtonYes, int stringButtonNo) {
        shareText(activity, text, (CharSequence) activity.getString(stringTitle), (CharSequence) activity.getString(stringMessage), (CharSequence) activity.getString(stringButtonYes), (CharSequence) activity.getString(stringButtonNo));
    }

    public static void shareText(Activity activity, CharSequence text, CharSequence stringTitle, CharSequence stringMessage, CharSequence stringButtonYes, CharSequence stringButtonNo) {
        Intent intent = new Intent();
        intent.setAction(Intents.Encode.ACTION);
        intent.putExtra(Intents.Encode.TYPE, Contents.Type.TEXT);
        intent.putExtra(Intents.Encode.DATA, text);
        try {
            activity.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            showDownloadDialog(activity, stringTitle, stringMessage, stringButtonYes, stringButtonNo);
        }
    }
}
