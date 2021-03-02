package com.google.android.gms.internal;

import android.app.AlertDialog;
import android.app.DownloadManager;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.google.android.gms.C0135R;
import java.util.Map;
import org.json.JSONObject;

@C1130ez
/* renamed from: com.google.android.gms.internal.de */
public class C1046de {
    /* access modifiers changed from: private */
    public final Context mContext;
    /* access modifiers changed from: private */

    /* renamed from: md */
    public final C1232gv f3123md;

    /* renamed from: qM */
    private final Map<String, String> f3124qM;

    public C1046de(C1232gv gvVar, Map<String, String> map) {
        this.f3123md = gvVar;
        this.f3124qM = map;
        this.mContext = gvVar.mo8628dA();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: B */
    public String mo8282B(String str) {
        return Uri.parse(str).getLastPathSegment();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public DownloadManager.Request mo8283b(String str, String str2) {
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(str));
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, str2);
        request.allowScanningByMediaScanner();
        request.setNotificationVisibility(1);
        return request;
    }

    public void execute() {
        if (!new C0950bl(this.mContext).mo8131bl()) {
            C1229gs.m4679W("Store picture feature is not supported on this device.");
        } else if (TextUtils.isEmpty(this.f3124qM.get("iurl"))) {
            C1229gs.m4679W("Image url cannot be empty.");
        } else {
            final String str = this.f3124qM.get("iurl");
            if (!URLUtil.isValidUrl(str)) {
                C1229gs.m4679W("Invalid image url:" + str);
                return;
            }
            final String B = mo8282B(str);
            if (!C1213gj.m4610N(B)) {
                C1229gs.m4679W("Image type not recognized:");
                return;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(this.mContext);
            builder.setTitle(C1201gb.m4563c(C0135R.string.store_picture_title, "Save image"));
            builder.setMessage(C1201gb.m4563c(C0135R.string.store_picture_message, "Allow Ad to store image in Picture gallery?"));
            builder.setPositiveButton(C1201gb.m4563c(C0135R.string.accept, "Accept"), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    try {
                        ((DownloadManager) C1046de.this.mContext.getSystemService("download")).enqueue(C1046de.this.mo8283b(str, B));
                    } catch (IllegalStateException e) {
                        C1229gs.m4677U("Could not store picture.");
                    }
                }
            });
            builder.setNegativeButton(C1201gb.m4563c(C0135R.string.decline, "Decline"), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    C1046de.this.f3123md.mo8624b("onStorePictureCanceled", new JSONObject());
                }
            });
            builder.create().show();
        }
    }
}
