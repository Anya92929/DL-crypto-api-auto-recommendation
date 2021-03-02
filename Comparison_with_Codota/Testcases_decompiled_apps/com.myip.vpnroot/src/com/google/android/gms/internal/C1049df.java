package com.google.android.gms.internal;

import org.json.JSONException;
import org.json.JSONObject;

@C1130ez
/* renamed from: com.google.android.gms.internal.df */
public class C1049df {

    /* renamed from: rb */
    private final boolean f3129rb;

    /* renamed from: rc */
    private final boolean f3130rc;

    /* renamed from: rd */
    private final boolean f3131rd;

    /* renamed from: re */
    private final boolean f3132re;

    /* renamed from: rf */
    private final boolean f3133rf;

    /* renamed from: com.google.android.gms.internal.df$a */
    public static final class C1051a {
        /* access modifiers changed from: private */

        /* renamed from: rb */
        public boolean f3134rb;
        /* access modifiers changed from: private */

        /* renamed from: rc */
        public boolean f3135rc;
        /* access modifiers changed from: private */

        /* renamed from: rd */
        public boolean f3136rd;
        /* access modifiers changed from: private */

        /* renamed from: re */
        public boolean f3137re;
        /* access modifiers changed from: private */

        /* renamed from: rf */
        public boolean f3138rf;

        /* renamed from: bM */
        public C1049df mo8288bM() {
            return new C1049df(this);
        }

        /* renamed from: i */
        public C1051a mo8289i(boolean z) {
            this.f3134rb = z;
            return this;
        }

        /* renamed from: j */
        public C1051a mo8290j(boolean z) {
            this.f3135rc = z;
            return this;
        }

        /* renamed from: k */
        public C1051a mo8291k(boolean z) {
            this.f3136rd = z;
            return this;
        }

        /* renamed from: l */
        public C1051a mo8292l(boolean z) {
            this.f3137re = z;
            return this;
        }

        /* renamed from: m */
        public C1051a mo8293m(boolean z) {
            this.f3138rf = z;
            return this;
        }
    }

    private C1049df(C1051a aVar) {
        this.f3129rb = aVar.f3134rb;
        this.f3130rc = aVar.f3135rc;
        this.f3131rd = aVar.f3136rd;
        this.f3132re = aVar.f3137re;
        this.f3133rf = aVar.f3138rf;
    }

    /* renamed from: bL */
    public JSONObject mo8287bL() {
        try {
            return new JSONObject().put("sms", this.f3129rb).put("tel", this.f3130rc).put("calendar", this.f3131rd).put("storePicture", this.f3132re).put("inlineVideo", this.f3133rf);
        } catch (JSONException e) {
            C1229gs.m4681b("Error occured while obtaining the MRAID capabilities.", e);
            return null;
        }
    }
}
