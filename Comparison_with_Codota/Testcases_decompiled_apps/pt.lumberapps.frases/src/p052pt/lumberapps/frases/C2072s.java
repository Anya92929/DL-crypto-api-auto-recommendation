package p052pt.lumberapps.frases;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import p052pt.lumberapps.lumbliv.C2082c;

/* renamed from: pt.lumberapps.frases.s */
class C2072s extends C2082c {

    /* renamed from: a */
    final /* synthetic */ Activity f7775a;

    /* renamed from: b */
    final /* synthetic */ String f7776b;

    /* renamed from: c */
    final /* synthetic */ MainActivity f7777c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C2072s(MainActivity mainActivity, Activity activity, String str, Activity activity2, String str2) {
        super(activity, str);
        this.f7777c = mainActivity;
        this.f7775a = activity2;
        this.f7776b = str2;
    }

    /* renamed from: a */
    public void mo10233a() {
        this.f7775a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + this.f7776b)));
    }

    public void cancel() {
    }
}
