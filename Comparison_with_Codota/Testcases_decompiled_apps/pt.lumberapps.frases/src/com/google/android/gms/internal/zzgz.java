package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.provider.CalendarContract;
import android.text.TextUtils;
import com.google.android.gms.C1204R;
import com.google.android.gms.ads.internal.zzu;
import java.util.Map;

@zzin
public class zzgz extends zzhf {

    /* renamed from: a */
    private final Map f6292a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Context f6293b;

    /* renamed from: c */
    private String f6294c;

    /* renamed from: d */
    private long f6295d;

    /* renamed from: e */
    private long f6296e;

    /* renamed from: f */
    private String f6297f;

    /* renamed from: g */
    private String f6298g;

    public zzgz(zzlh zzlh, Map map) {
        super(zzlh, "createCalendarEvent");
        this.f6292a = map;
        this.f6293b = zzlh.zzue();
        m7116b();
    }

    /* renamed from: a */
    private String m7114a(String str) {
        return TextUtils.isEmpty((CharSequence) this.f6292a.get(str)) ? "" : (String) this.f6292a.get(str);
    }

    /* renamed from: b */
    private long m7115b(String str) {
        String str2 = (String) this.f6292a.get(str);
        if (str2 == null) {
            return -1;
        }
        try {
            return Long.parseLong(str2);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    /* renamed from: b */
    private void m7116b() {
        this.f6294c = m7114a("description");
        this.f6297f = m7114a("summary");
        this.f6295d = m7115b("start_ticks");
        this.f6296e = m7115b("end_ticks");
        this.f6298g = m7114a("location");
    }

    /* access modifiers changed from: package-private */
    @TargetApi(14)
    /* renamed from: a */
    public Intent mo8430a() {
        Intent data = new Intent("android.intent.action.EDIT").setData(CalendarContract.Events.CONTENT_URI);
        data.putExtra("title", this.f6294c);
        data.putExtra("eventLocation", this.f6298g);
        data.putExtra("description", this.f6297f);
        if (this.f6295d > -1) {
            data.putExtra("beginTime", this.f6295d);
        }
        if (this.f6296e > -1) {
            data.putExtra("endTime", this.f6296e);
        }
        data.setFlags(268435456);
        return data;
    }

    public void execute() {
        if (this.f6293b == null) {
            zzbt("Activity context is not available.");
        } else if (!zzu.zzfq().zzag(this.f6293b).zzju()) {
            zzbt("This feature is not available on the device.");
        } else {
            AlertDialog.Builder zzaf = zzu.zzfq().zzaf(this.f6293b);
            Resources resources = zzu.zzft().getResources();
            zzaf.setTitle(resources != null ? resources.getString(C1204R.string.create_calendar_title) : "Create calendar event");
            zzaf.setMessage(resources != null ? resources.getString(C1204R.string.create_calendar_message) : "Allow Ad to create a calendar event?");
            zzaf.setPositiveButton(resources != null ? resources.getString(C1204R.string.accept) : "Accept", new C1662jk(this));
            zzaf.setNegativeButton(resources != null ? resources.getString(C1204R.string.decline) : "Decline", new C1663jl(this));
            zzaf.create().show();
        }
    }
}
