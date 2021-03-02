package com.google.android.gms.internal;

import org.json.JSONException;
import org.json.JSONObject;

@zzin
public class zzhd {

    /* renamed from: a */
    private final boolean f6323a;

    /* renamed from: b */
    private final boolean f6324b;

    /* renamed from: c */
    private final boolean f6325c;

    /* renamed from: d */
    private final boolean f6326d;

    /* renamed from: e */
    private final boolean f6327e;

    public final class zza {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public boolean f6328a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public boolean f6329b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public boolean f6330c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public boolean f6331d;
        /* access modifiers changed from: private */

        /* renamed from: e */
        public boolean f6332e;

        public zzhd zzmy() {
            return new zzhd(this);
        }

        public zza zzt(boolean z) {
            this.f6328a = z;
            return this;
        }

        public zza zzu(boolean z) {
            this.f6329b = z;
            return this;
        }

        public zza zzv(boolean z) {
            this.f6330c = z;
            return this;
        }

        public zza zzw(boolean z) {
            this.f6331d = z;
            return this;
        }

        public zza zzx(boolean z) {
            this.f6332e = z;
            return this;
        }
    }

    private zzhd(zza zza2) {
        this.f6323a = zza2.f6328a;
        this.f6324b = zza2.f6329b;
        this.f6325c = zza2.f6330c;
        this.f6326d = zza2.f6331d;
        this.f6327e = zza2.f6332e;
    }

    public JSONObject toJson() {
        try {
            return new JSONObject().put("sms", this.f6323a).put("tel", this.f6324b).put("calendar", this.f6325c).put("storePicture", this.f6326d).put("inlineVideo", this.f6327e);
        } catch (JSONException e) {
            zzkd.zzb("Error occured while obtaining the MRAID capabilities.", e);
            return null;
        }
    }
}
