package com.google.android.gms.internal;

import com.google.android.gms.plus.PlusShare;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@C1130ez
/* renamed from: com.google.android.gms.internal.fv */
class C1192fv {

    /* renamed from: tc */
    private int f3632tc;

    /* renamed from: uJ */
    private final List<String> f3633uJ;

    /* renamed from: uK */
    private final List<String> f3634uK;

    /* renamed from: uL */
    private final String f3635uL;

    /* renamed from: uM */
    private final String f3636uM;

    /* renamed from: uN */
    private final String f3637uN;

    /* renamed from: uO */
    private final String f3638uO;

    /* renamed from: uP */
    private final boolean f3639uP;

    /* renamed from: uQ */
    private final int f3640uQ;

    /* renamed from: uR */
    private String f3641uR;

    public C1192fv(int i, Map<String, String> map) {
        this.f3641uR = map.get(PlusShare.KEY_CALL_TO_ACTION_URL);
        this.f3636uM = map.get("base_uri");
        this.f3637uN = map.get("post_parameters");
        this.f3639uP = parseBoolean(map.get("drt_include"));
        this.f3635uL = map.get("activation_overlay_url");
        this.f3634uK = m4534J(map.get("check_packages"));
        this.f3640uQ = parseInt(map.get("request_id"));
        this.f3638uO = map.get("type");
        this.f3633uJ = m4534J(map.get("errors"));
        this.f3632tc = i;
    }

    /* renamed from: J */
    private List<String> m4534J(String str) {
        if (str == null) {
            return null;
        }
        return Arrays.asList(str.split(","));
    }

    private static boolean parseBoolean(String bool) {
        return bool != null && (bool.equals("1") || bool.equals("true"));
    }

    private int parseInt(String i) {
        if (i == null) {
            return 0;
        }
        return Integer.parseInt(i);
    }

    /* renamed from: cM */
    public List<String> mo8532cM() {
        return this.f3633uJ;
    }

    /* renamed from: cN */
    public String mo8533cN() {
        return this.f3637uN;
    }

    /* renamed from: cO */
    public boolean mo8534cO() {
        return this.f3639uP;
    }

    public int getErrorCode() {
        return this.f3632tc;
    }

    public String getType() {
        return this.f3638uO;
    }

    public String getUrl() {
        return this.f3641uR;
    }

    public void setUrl(String url) {
        this.f3641uR = url;
    }
}
