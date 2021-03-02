package com.google.android.gms.internal;

import android.app.AlertDialog;
import android.app.DownloadManager;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.google.android.gms.C1204R;
import com.google.android.gms.ads.internal.zzu;
import java.util.Map;

@zzin
public class zzhc extends zzhf {

    /* renamed from: a */
    private final Map f6321a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Context f6322b;

    public zzhc(zzlh zzlh, Map map) {
        super(zzlh, "storePicture");
        this.f6321a = map;
        this.f6322b = zzlh.zzue();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public DownloadManager.Request mo8442a(String str, String str2) {
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(str));
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, str2);
        zzu.zzfs().zza(request);
        return request;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo8443a(String str) {
        return Uri.parse(str).getLastPathSegment();
    }

    public void execute() {
        if (this.f6322b == null) {
            zzbt("Activity context is not available");
        } else if (!zzu.zzfq().zzag(this.f6322b).zzjr()) {
            zzbt("Feature is not supported by the device.");
        } else {
            String str = (String) this.f6321a.get("iurl");
            if (TextUtils.isEmpty(str)) {
                zzbt("Image url cannot be empty.");
            } else if (!URLUtil.isValidUrl(str)) {
                String valueOf = String.valueOf(str);
                zzbt(valueOf.length() != 0 ? "Invalid image url: ".concat(valueOf) : new String("Invalid image url: "));
            } else {
                String a = mo8443a(str);
                if (!zzu.zzfq().zzcq(a)) {
                    String valueOf2 = String.valueOf(a);
                    zzbt(valueOf2.length() != 0 ? "Image type not recognized: ".concat(valueOf2) : new String("Image type not recognized: "));
                    return;
                }
                Resources resources = zzu.zzft().getResources();
                AlertDialog.Builder zzaf = zzu.zzfq().zzaf(this.f6322b);
                zzaf.setTitle(resources != null ? resources.getString(C1204R.string.store_picture_title) : "Save image");
                zzaf.setMessage(resources != null ? resources.getString(C1204R.string.store_picture_message) : "Allow Ad to store image in Picture gallery?");
                zzaf.setPositiveButton(resources != null ? resources.getString(C1204R.string.accept) : "Accept", new C1665jn(this, str, a));
                zzaf.setNegativeButton(resources != null ? resources.getString(C1204R.string.decline) : "Decline", new C1666jo(this));
                zzaf.create().show();
            }
        }
    }
}
