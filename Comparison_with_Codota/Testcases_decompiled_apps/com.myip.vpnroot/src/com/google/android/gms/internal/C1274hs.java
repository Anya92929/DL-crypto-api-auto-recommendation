package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.appindexing.AppIndexApi;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.C1256he;
import com.google.android.gms.internal.C1271hq;
import com.google.android.gms.internal.C1499lk;
import com.google.android.gms.plus.PlusShare;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.zip.CRC32;

/* renamed from: com.google.android.gms.internal.hs */
public class C1274hs implements SafeParcelable {
    public static final C1275ht CREATOR = new C1275ht();

    /* renamed from: BR */
    final int f3880BR;

    /* renamed from: CD */
    final C1259hg f3881CD;

    /* renamed from: CE */
    final long f3882CE;

    /* renamed from: CF */
    final int f3883CF;

    /* renamed from: CG */
    final C1256he f3884CG;

    /* renamed from: oT */
    public final String f3885oT;

    C1274hs(int i, C1259hg hgVar, long j, int i2, String str, C1256he heVar) {
        this.f3880BR = i;
        this.f3881CD = hgVar;
        this.f3882CE = j;
        this.f3883CF = i2;
        this.f3885oT = str;
        this.f3884CG = heVar;
    }

    public C1274hs(C1259hg hgVar, long j, int i) {
        this(1, hgVar, j, i, (String) null, (C1256he) null);
    }

    public C1274hs(String str, Intent intent, String str2, Uri uri, String str3, List<AppIndexApi.AppIndexingLink> list) {
        this(1, m4795a(str, intent), System.currentTimeMillis(), 0, (String) null, m4794a(intent, str2, uri, str3, list).mo8717fk());
    }

    /* renamed from: a */
    public static C1256he.C1257a m4794a(Intent intent, String str, Uri uri, String str2, List<AppIndexApi.AppIndexingLink> list) {
        String string;
        C1256he.C1257a aVar = new C1256he.C1257a();
        aVar.mo8715a(m4796av(str));
        if (uri != null) {
            aVar.mo8715a(m4798f(uri));
        }
        if (list != null) {
            aVar.mo8715a(m4797b(list));
        }
        String action = intent.getAction();
        if (action != null) {
            aVar.mo8715a(m4801j("intent_action", action));
        }
        String dataString = intent.getDataString();
        if (dataString != null) {
            aVar.mo8715a(m4801j("intent_data", dataString));
        }
        ComponentName component = intent.getComponent();
        if (component != null) {
            aVar.mo8715a(m4801j("intent_activity", component.getClassName()));
        }
        Bundle extras = intent.getExtras();
        if (!(extras == null || (string = extras.getString("intent_extra_data_key")) == null)) {
            aVar.mo8715a(m4801j("intent_extra_data", string));
        }
        return aVar.mo8716ar(str2).mo8714D(true);
    }

    /* renamed from: a */
    public static C1259hg m4795a(String str, Intent intent) {
        return m4800i(str, m4799g(intent));
    }

    /* renamed from: av */
    private static C1261hi m4796av(String str) {
        return new C1261hi(str, new C1271hq.C1272a(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE).mo8759P(1).mo8758F(true).mo8761au("name").mo8762fn(), "text1");
    }

    /* renamed from: b */
    private static C1261hi m4797b(List<AppIndexApi.AppIndexingLink> list) {
        C1499lk.C1500a aVar = new C1499lk.C1500a();
        C1499lk.C1500a.C1501a[] aVarArr = new C1499lk.C1500a.C1501a[list.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < aVarArr.length) {
                aVarArr[i2] = new C1499lk.C1500a.C1501a();
                AppIndexApi.AppIndexingLink appIndexingLink = list.get(i2);
                aVarArr[i2].adv = appIndexingLink.appIndexingUrl.toString();
                aVarArr[i2].adw = appIndexingLink.webUrl.toString();
                aVarArr[i2].viewId = appIndexingLink.viewId;
                i = i2 + 1;
            } else {
                aVar.adt = aVarArr;
                return new C1261hi(C1718pm.m6092f(aVar), new C1271hq.C1272a("outlinks").mo8757E(true).mo8761au(".private:outLinks").mo8760at("blob").mo8762fn());
            }
        }
    }

    /* renamed from: f */
    private static C1261hi m4798f(Uri uri) {
        return new C1261hi(uri.toString(), new C1271hq.C1272a("web_url").mo8759P(4).mo8757E(true).mo8761au(PlusShare.KEY_CALL_TO_ACTION_URL).mo8762fn());
    }

    /* renamed from: g */
    private static String m4799g(Intent intent) {
        String uri = intent.toUri(1);
        CRC32 crc32 = new CRC32();
        try {
            crc32.update(uri.getBytes("UTF-8"));
            return Long.toHexString(crc32.getValue());
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException(e);
        }
    }

    /* renamed from: i */
    private static C1259hg m4800i(String str, String str2) {
        return new C1259hg(str, "", str2);
    }

    /* renamed from: j */
    private static C1261hi m4801j(String str, String str2) {
        return new C1261hi(str2, new C1271hq.C1272a(str).mo8757E(true).mo8762fn(), str);
    }

    public int describeContents() {
        C1275ht htVar = CREATOR;
        return 0;
    }

    public String toString() {
        return String.format("UsageInfo[documentId=%s, timestamp=%d, usageType=%d]", new Object[]{this.f3881CD, Long.valueOf(this.f3882CE), Integer.valueOf(this.f3883CF)});
    }

    public void writeToParcel(Parcel dest, int flags) {
        C1275ht htVar = CREATOR;
        C1275ht.m4802a(this, dest, flags);
    }
}
