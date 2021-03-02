package com.SocketMobile.ScanAPI;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import com.SocketMobile.ScanAPI.ISktScanSymbology;
import com.SocketMobile.ScanAPICore.SktDebug;
import com.SocketMobile.ScanAPICore.SoftScanActivityListener;

public class SoftScanActivity extends Activity {
    public static String DO_BEEP = "do_beep";
    public static String DO_CODABAR = "do_codabar";
    public static String DO_CODE128 = "do_code128";
    public static String DO_CODE39 = "do_code39";
    public static String DO_CODE93 = "do_code93";
    public static String DO_DATAMATRIX = "do_datamatrix";
    public static String DO_EAN13 = "do_ean13";
    public static String DO_EAN8 = "do_ean8";
    public static String DO_FLASHBUTTONID = "FlashButtonID";
    public static String DO_ITF = "do_itf";
    public static String DO_LAYOUTID = "LayoutID";
    public static String DO_QRCODE = "do_qrcode";
    public static String DO_RSS14 = "do_rss14";
    public static String DO_STICKY = "do_sticky";
    public static String DO_UPCE = "do_upce";
    public static String DO_VIBRATE = "do_vibrate";
    public static String DO_VIEWFINDERID = "ViewFinderID";
    public static String INTENT_ZXING = "com.google.zxing.client.android.SCAN";
    private static final int SCAN_REQUEST = 5047;
    private static SoftScanActivityListener _listener;
    static SoftScanActivity _singleton = null;
    int _currentApiVersion = Build.VERSION.SDK_INT;

    public static void setListener(SoftScanActivityListener listener) {
        SktDebug.DBGSKT_MSG(1, "Set Listener reference");
        _listener = listener;
    }

    public void onCreate(Bundle icicle) {
        if (_singleton == null) {
            _singleton = this;
        }
        if (_singleton != this) {
            finish();
        }
        super.onCreate(icicle);
        Bundle extras = getIntent().getExtras();
        Intent scanIntent = new Intent(INTENT_ZXING);
        scanIntent.addFlags(67108864);
        scanIntent.addFlags(524288);
        if (getIntent().hasExtra("SCAN_FORMATS")) {
            scanIntent.putExtra("SCAN_FORMATS", extras.getString("SCAN_FORMATS"));
        }
        startActivityForResult(scanIntent, SCAN_REQUEST);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        if (_singleton == this) {
            _singleton = null;
        }
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        switch (requestCode) {
            case SCAN_REQUEST /*5047*/:
                if (resultCode == -1 && intent.hasExtra("SCAN_RESULT")) {
                    String decodedData = intent.getStringExtra("SCAN_RESULT");
                    String format = intent.getStringExtra("SCAN_RESULT_FORMAT");
                    byte symbologyId = 0;
                    if (format != null) {
                        if (format.equals("UPC_E")) {
                            symbologyId = 43;
                        }
                        if (format.equals("EAN_8")) {
                            symbologyId = ISktScanSymbology.C0165id.kSktScanSymbologyEan8;
                        }
                        if (format.equals("EAN_13")) {
                            symbologyId = 19;
                        }
                        if (format.equals("QR_CODE")) {
                            symbologyId = 38;
                        }
                        if (format.equals("CODE_128")) {
                            symbologyId = 15;
                        }
                        if (format.equals("CODE_39")) {
                            symbologyId = 11;
                        }
                        if (format.equals("CODE_93")) {
                            symbologyId = 14;
                        }
                        if (format.equals("DATA_MATRIX")) {
                            symbologyId = 16;
                        }
                        if (format.equals("RSS_14")) {
                            symbologyId = 24;
                        }
                        if (format.equals("ITF")) {
                            symbologyId = 27;
                        }
                        if (format.equals("CODABAR")) {
                            symbologyId = 7;
                        }
                    }
                    if (_listener != null) {
                        _listener.onDecodedData(decodedData, symbologyId);
                        break;
                    }
                }
                break;
        }
        finish();
    }
}
