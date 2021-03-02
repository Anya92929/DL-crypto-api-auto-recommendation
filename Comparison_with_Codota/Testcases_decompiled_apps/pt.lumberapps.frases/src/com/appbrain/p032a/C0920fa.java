package com.appbrain.p032a;

import android.app.Activity;
import android.app.Dialog;
import android.net.Uri;
import android.os.Build;
import android.webkit.WebView;
import cmn.C0732b;
import cmn.C0752n;
import com.appbrain.p037f.C1056av;
import com.appbrain.p037f.C1058ax;

/* renamed from: com.appbrain.a.fa */
final class C0920fa extends Dialog {

    /* renamed from: a */
    private final C1056av f2411a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final WebView f2412b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Runnable f2413c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f2414d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f2415e;

    private C0920fa(Activity activity, C1056av avVar) {
        super(activity, 16973840);
        setOwnerActivity(activity);
        this.f2411a = avVar;
        C0934fo.m3996a((Dialog) this);
        this.f2412b = C0912et.f2392a.mo3797a(activity);
        this.f2412b.setBackgroundColor(0);
        C0732b.m3247a(activity, this.f2412b, new C0921fb(this));
        this.f2412b.setWebViewClient(new C0922fc(this, activity));
        setContentView(this.f2412b);
    }

    /* synthetic */ C0920fa(Activity activity, C1056av avVar, byte b) {
        this(activity, avVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m3910a() {
        this.f2415e = true;
        C0912et.f2394c.remove(this);
        if (isShowing()) {
            dismiss();
        }
    }

    /* renamed from: a */
    static /* synthetic */ boolean m3911a(C0920fa faVar, String str) {
        if (str.equals(faVar.f2412b.getOriginalUrl())) {
            return false;
        }
        if (str.equals("close://")) {
            faVar.cancel();
            return true;
        } else if (!faVar.f2414d) {
            return false;
        } else {
            Integer unused = C0912et.f2396e = Integer.valueOf(faVar.f2411a.mo4238h());
            C0911es.m3894a(faVar.getContext(), str, C1058ax.WEB_VIEW);
            return true;
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m3912b(C0920fa faVar) {
        if (faVar.f2411a.mo4245o()) {
            Uri parse = Uri.parse(faVar.f2411a.mo4246p());
            String encodedQuery = parse.getEncodedQuery();
            Uri.Builder buildUpon = parse.buildUpon();
            if (encodedQuery != null) {
                C0752n b = C0752n.m3278b();
                StringBuilder sb = new StringBuilder();
                for (String str : encodedQuery.split("&")) {
                    if (sb.length() > 0) {
                        sb.append("&");
                    }
                    String[] split = str.split("=", 2);
                    sb.append(split[0]);
                    String str2 = split.length > 1 ? split[1] : null;
                    if (str2 != null) {
                        if (!str2.equals("appbrain-app-package") && !str2.equals("applift-app-package")) {
                            if (!str2.equals("appbrain-app-version") && !str2.equals("applift-app-version")) {
                                if (!str2.equals("appbrain-os-version") && !str2.equals("applift-os-version")) {
                                    if (!str2.equals("appbrain-os-language") && !str2.equals("applift-os-language")) {
                                        if (!str2.equals("appbrain-screen-density") && !str2.equals("applift-screen-density")) {
                                            if (!str2.equals("appbrain-screen-size") && !str2.equals("applift-screen-size")) {
                                                if (str2.equals("appbrain-screen-orientation")) {
                                                    switch (faVar.getContext().getResources().getConfiguration().orientation) {
                                                        case 1:
                                                            str2 = "portrait";
                                                            break;
                                                        case 2:
                                                            str2 = "landscape";
                                                            break;
                                                        default:
                                                            str2 = "undefined";
                                                            break;
                                                    }
                                                }
                                            } else {
                                                str2 = Integer.toString(b.mo3443q());
                                            }
                                        } else {
                                            str2 = Integer.toString(b.mo3442p());
                                        }
                                    } else {
                                        str2 = b.mo3437k();
                                    }
                                } else {
                                    str2 = Integer.toString(Build.VERSION.SDK_INT);
                                }
                            } else {
                                str2 = Integer.toString(b.mo3432f());
                            }
                        } else {
                            str2 = b.mo3429c();
                        }
                        sb.append("=");
                        sb.append(str2);
                    }
                }
                buildUpon.encodedQuery(sb.toString());
            }
            faVar.f2412b.loadUrl(buildUpon.build().toString());
        } else if (faVar.f2411a.mo4239i()) {
            faVar.f2412b.loadData(faVar.f2411a.mo4240j(), "text/html", "UTF-8");
        } else {
            faVar.m3910a();
        }
    }
}
