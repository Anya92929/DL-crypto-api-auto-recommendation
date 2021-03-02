package com.google.zxing.client.android.encode;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.zxing.WriterException;
import com.google.zxing.client.android.C0776R;
import com.google.zxing.client.android.Contents;
import com.google.zxing.client.android.FinishListener;
import com.google.zxing.client.android.Intents;
import java.util.regex.Pattern;

public final class EncodeActivity extends Activity {
    private static final int MAX_BARCODE_FILENAME_LENGTH = 24;
    private static final Pattern NOT_ALPHANUMERIC = Pattern.compile("[^A-Za-z0-9]");
    private static final String TAG = EncodeActivity.class.getSimpleName();
    private static final String USE_VCARD_KEY = "USE_VCARD";
    private QRCodeEncoder qrCodeEncoder;

    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        Intent intent = getIntent();
        if (intent == null) {
            finish();
            return;
        }
        String action = intent.getAction();
        if (Intents.Encode.ACTION.equals(action) || "android.intent.action.SEND".equals(action)) {
            setContentView(C0776R.layout.encode);
        } else {
            finish();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(C0776R.C0778menu.encode, menu);
        int encodeNameResource = this.qrCodeEncoder != null && this.qrCodeEncoder.isUseVCard() ? C0776R.string.menu_encode_mecard : C0776R.string.menu_encode_vcard;
        MenuItem encodeItem = menu.findItem(C0776R.C0777id.menu_encode);
        encodeItem.setTitle(encodeNameResource);
        Intent intent = getIntent();
        if (intent != null) {
            encodeItem.setVisible(Contents.Type.CONTACT.equals(intent.getStringExtra(Intents.Encode.TYPE)));
        }
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        boolean z = false;
        int itemId = item.getItemId();
        if (itemId == C0776R.C0777id.menu_share) {
            share();
            return true;
        } else if (itemId != C0776R.C0777id.menu_encode) {
            return false;
        } else {
            Intent intent = getIntent();
            if (intent == null) {
                return false;
            }
            if (!this.qrCodeEncoder.isUseVCard()) {
                z = true;
            }
            intent.putExtra(USE_VCARD_KEY, z);
            startActivity(intent);
            finish();
            return true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x010f A[SYNTHETIC, Splitter:B:29:0x010f] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x011a A[SYNTHETIC, Splitter:B:34:0x011a] */
    /* JADX WARNING: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void share() {
        /*
            r14 = this;
            com.google.zxing.client.android.encode.QRCodeEncoder r5 = r14.qrCodeEncoder
            if (r5 != 0) goto L_0x000c
            java.lang.String r11 = TAG
            java.lang.String r12 = "No existing barcode to send?"
            android.util.Log.w(r11, r12)
        L_0x000b:
            return
        L_0x000c:
            java.lang.String r4 = r5.getContents()
            if (r4 != 0) goto L_0x001a
            java.lang.String r11 = TAG
            java.lang.String r12 = "No existing barcode to send?"
            android.util.Log.w(r11, r12)
            goto L_0x000b
        L_0x001a:
            android.graphics.Bitmap r2 = r5.encodeAsBitmap()     // Catch:{ WriterException -> 0x0058 }
            if (r2 == 0) goto L_0x000b
            java.io.File r3 = new java.io.File
            java.io.File r11 = android.os.Environment.getExternalStorageDirectory()
            java.lang.String r12 = "BarcodeScanner"
            r3.<init>(r11, r12)
            java.io.File r1 = new java.io.File
            java.lang.String r11 = "Barcodes"
            r1.<init>(r3, r11)
            boolean r11 = r1.exists()
            if (r11 != 0) goto L_0x005f
            boolean r11 = r1.mkdirs()
            if (r11 != 0) goto L_0x005f
            java.lang.String r11 = TAG
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            java.lang.String r13 = "Couldn't make dir "
            r12.<init>(r13)
            java.lang.StringBuilder r12 = r12.append(r1)
            java.lang.String r12 = r12.toString()
            android.util.Log.w(r11, r12)
            int r11 = com.google.zxing.client.android.C0776R.string.msg_unmount_usb
            r14.showErrorMessage(r11)
            goto L_0x000b
        L_0x0058:
            r10 = move-exception
            java.lang.String r11 = TAG
            android.util.Log.w(r11, r10)
            goto L_0x000b
        L_0x005f:
            java.io.File r0 = new java.io.File
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.CharSequence r12 = makeBarcodeFileName(r4)
            java.lang.StringBuilder r11 = r11.append(r12)
            java.lang.String r12 = ".png"
            java.lang.StringBuilder r11 = r11.append(r12)
            java.lang.String r11 = r11.toString()
            r0.<init>(r1, r11)
            r0.delete()
            r7 = 0
            java.io.FileOutputStream r8 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x00e9 }
            r8.<init>(r0)     // Catch:{ FileNotFoundException -> 0x00e9 }
            android.graphics.Bitmap$CompressFormat r11 = android.graphics.Bitmap.CompressFormat.PNG     // Catch:{ FileNotFoundException -> 0x0126, all -> 0x0123 }
            r12 = 0
            r2.compress(r11, r12, r8)     // Catch:{ FileNotFoundException -> 0x0126, all -> 0x0123 }
            if (r8 == 0) goto L_0x008f
            r8.close()     // Catch:{ IOException -> 0x0120 }
        L_0x008f:
            android.content.Intent r9 = new android.content.Intent
            java.lang.String r11 = "android.intent.action.SEND"
            java.lang.String r12 = "mailto:"
            android.net.Uri r12 = android.net.Uri.parse(r12)
            r9.<init>(r11, r12)
            java.lang.String r11 = "android.intent.extra.SUBJECT"
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            java.lang.String r13 = "Barcode Scanner - "
            r12.<init>(r13)
            java.lang.String r13 = r5.getTitle()
            java.lang.StringBuilder r12 = r12.append(r13)
            java.lang.String r12 = r12.toString()
            r9.putExtra(r11, r12)
            java.lang.String r11 = "android.intent.extra.TEXT"
            r9.putExtra(r11, r4)
            java.lang.String r11 = "android.intent.extra.STREAM"
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            java.lang.String r13 = "file://"
            r12.<init>(r13)
            java.lang.String r13 = r0.getAbsolutePath()
            java.lang.StringBuilder r12 = r12.append(r13)
            java.lang.String r12 = r12.toString()
            android.net.Uri r12 = android.net.Uri.parse(r12)
            r9.putExtra(r11, r12)
            java.lang.String r11 = "image/png"
            r9.setType(r11)
            r11 = 524288(0x80000, float:7.34684E-40)
            r9.addFlags(r11)
            r11 = 0
            android.content.Intent r11 = android.content.Intent.createChooser(r9, r11)
            r14.startActivity(r11)
            goto L_0x000b
        L_0x00e9:
            r6 = move-exception
        L_0x00ea:
            java.lang.String r11 = TAG     // Catch:{ all -> 0x0117 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x0117 }
            java.lang.String r13 = "Couldn't access file "
            r12.<init>(r13)     // Catch:{ all -> 0x0117 }
            java.lang.StringBuilder r12 = r12.append(r0)     // Catch:{ all -> 0x0117 }
            java.lang.String r13 = " due to "
            java.lang.StringBuilder r12 = r12.append(r13)     // Catch:{ all -> 0x0117 }
            java.lang.StringBuilder r12 = r12.append(r6)     // Catch:{ all -> 0x0117 }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x0117 }
            android.util.Log.w(r11, r12)     // Catch:{ all -> 0x0117 }
            int r11 = com.google.zxing.client.android.C0776R.string.msg_unmount_usb     // Catch:{ all -> 0x0117 }
            r14.showErrorMessage(r11)     // Catch:{ all -> 0x0117 }
            if (r7 == 0) goto L_0x000b
            r7.close()     // Catch:{ IOException -> 0x0114 }
            goto L_0x000b
        L_0x0114:
            r11 = move-exception
            goto L_0x000b
        L_0x0117:
            r11 = move-exception
        L_0x0118:
            if (r7 == 0) goto L_0x011d
            r7.close()     // Catch:{ IOException -> 0x011e }
        L_0x011d:
            throw r11
        L_0x011e:
            r12 = move-exception
            goto L_0x011d
        L_0x0120:
            r11 = move-exception
            goto L_0x008f
        L_0x0123:
            r11 = move-exception
            r7 = r8
            goto L_0x0118
        L_0x0126:
            r6 = move-exception
            r7 = r8
            goto L_0x00ea
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.client.android.encode.EncodeActivity.share():void");
    }

    private static CharSequence makeBarcodeFileName(CharSequence contents) {
        String fileName = NOT_ALPHANUMERIC.matcher(contents).replaceAll("_");
        if (fileName.length() > 24) {
            return fileName.substring(0, 24);
        }
        return fileName;
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        int smallerDimension;
        super.onResume();
        Display display = ((WindowManager) getSystemService("window")).getDefaultDisplay();
        int width = display.getWidth();
        int height = display.getHeight();
        if (width < height) {
            smallerDimension = width;
        } else {
            smallerDimension = height;
        }
        int smallerDimension2 = (smallerDimension * 7) / 8;
        Intent intent = getIntent();
        if (intent != null) {
            try {
                this.qrCodeEncoder = new QRCodeEncoder(this, intent, smallerDimension2, intent.getBooleanExtra(USE_VCARD_KEY, false));
                Bitmap bitmap = this.qrCodeEncoder.encodeAsBitmap();
                if (bitmap == null) {
                    Log.w(TAG, "Could not encode barcode");
                    showErrorMessage(C0776R.string.msg_encode_contents_failed);
                    this.qrCodeEncoder = null;
                    return;
                }
                ((ImageView) findViewById(C0776R.C0777id.image_view)).setImageBitmap(bitmap);
                TextView contents = (TextView) findViewById(C0776R.C0777id.contents_text_view);
                if (intent.getBooleanExtra(Intents.Encode.SHOW_CONTENTS, true)) {
                    contents.setText(this.qrCodeEncoder.getDisplayContents());
                    setTitle(this.qrCodeEncoder.getTitle());
                    return;
                }
                contents.setText("");
                setTitle("");
            } catch (WriterException e) {
                Log.w(TAG, "Could not encode barcode", e);
                showErrorMessage(C0776R.string.msg_encode_contents_failed);
                this.qrCodeEncoder = null;
            }
        }
    }

    private void showErrorMessage(int message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message);
        builder.setPositiveButton(C0776R.string.button_ok, new FinishListener(this));
        builder.setOnCancelListener(new FinishListener(this));
        builder.show();
    }
}
