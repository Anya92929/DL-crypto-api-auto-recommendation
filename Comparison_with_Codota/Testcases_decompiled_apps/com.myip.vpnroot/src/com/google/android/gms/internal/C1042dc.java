package com.google.android.gms.internal;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.CalendarContract;
import android.text.TextUtils;
import com.google.android.gms.C0135R;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.plus.PlusShare;
import java.util.Map;
import org.json.JSONObject;

@C1130ez
/* renamed from: com.google.android.gms.internal.dc */
public class C1042dc {
    /* access modifiers changed from: private */
    public final Context mContext;
    /* access modifiers changed from: private */

    /* renamed from: md */
    public final C1232gv f3105md;

    /* renamed from: qM */
    private final Map<String, String> f3106qM;

    /* renamed from: qN */
    private String f3107qN;

    /* renamed from: qO */
    private long f3108qO;

    /* renamed from: qP */
    private long f3109qP;

    /* renamed from: qQ */
    private String f3110qQ;

    /* renamed from: qR */
    private String f3111qR;

    public C1042dc(C1232gv gvVar, Map<String, String> map) {
        this.f3105md = gvVar;
        this.f3106qM = map;
        this.mContext = gvVar.mo8628dA();
        m4195bG();
    }

    /* renamed from: A */
    private String m4192A(String str) {
        return TextUtils.isEmpty(this.f3106qM.get(str)) ? "" : this.f3106qM.get(str);
    }

    /* renamed from: bG */
    private void m4195bG() {
        this.f3107qN = m4192A(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION);
        this.f3110qQ = m4192A("summary");
        this.f3108qO = C1213gj.m4611O(this.f3106qM.get("start"));
        this.f3109qP = C1213gj.m4611O(this.f3106qM.get("end"));
        this.f3111qR = m4192A("location");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: bH */
    public Intent mo8272bH() {
        Intent data = new Intent("android.intent.action.EDIT").setData(CalendarContract.Events.CONTENT_URI);
        data.putExtra(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, this.f3110qQ);
        data.putExtra("eventLocation", this.f3111qR);
        data.putExtra(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, this.f3107qN);
        data.putExtra("beginTime", this.f3108qO);
        data.putExtra("endTime", this.f3109qP);
        data.setFlags(DriveFile.MODE_READ_ONLY);
        return data;
    }

    public void execute() {
        if (!new C0950bl(this.mContext).mo8133bo()) {
            C1229gs.m4679W("This feature is not available on this version of the device.");
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this.mContext);
        builder.setTitle(C1201gb.m4563c(C0135R.string.create_calendar_title, "Create calendar event"));
        builder.setMessage(C1201gb.m4563c(C0135R.string.create_calendar_message, "Allow Ad to create a calendar event?"));
        builder.setPositiveButton(C1201gb.m4563c(C0135R.string.accept, "Accept"), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                C1042dc.this.mContext.startActivity(C1042dc.this.mo8272bH());
            }
        });
        builder.setNegativeButton(C1201gb.m4563c(C0135R.string.decline, "Decline"), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                C1042dc.this.f3105md.mo8624b("onCalendarEventCanceled", new JSONObject());
            }
        });
        builder.create().show();
    }
}
