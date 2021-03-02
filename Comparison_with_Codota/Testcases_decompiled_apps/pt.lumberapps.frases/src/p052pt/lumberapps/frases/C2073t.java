package p052pt.lumberapps.frases;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.appbrain.C0980aa;
import com.google.android.gms.C1204R;
import p052pt.lumberapps.lumbliv.C2081b;
import p052pt.lumberapps.lumbliv.C2104y;

/* renamed from: pt.lumberapps.frases.t */
class C2073t implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f7778a;

    /* renamed from: b */
    final /* synthetic */ MainActivity f7779b;

    C2073t(MainActivity mainActivity, int i) {
        this.f7779b = mainActivity;
        this.f7778a = i;
    }

    public void run() {
        switch (this.f7778a) {
            case 0:
                this.f7779b.mo10253s();
                return;
            case 1:
                C0980aa.m4089a().mo3909a((Context) this.f7779b);
                return;
            case 2:
                this.f7779b.startActivityForResult(new Intent(this.f7779b.getApplicationContext(), Opcoes.class), 15);
                return;
            case 3:
                this.f7779b.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=pt.lumberapps.frases")));
                return;
            case 4:
                this.f7779b.startActivity(C2104y.m8435a((Activity) this.f7779b));
                return;
            case 5:
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse("https://www.facebook.com/RicrdoAlmeidaMagicPicturesa"));
                this.f7779b.startActivity(intent);
                return;
            case 6:
                new C2047b(this.f7779b).mo10189a().show();
                return;
            case 7:
                C2081b bVar = new C2081b(this.f7779b, this.f7779b.getString(C1204R.string.sobre_string));
                bVar.mo10272a(this.f7779b.getResources().getColor(C1204R.color.azul_fescuro), -1);
                bVar.mo10268b().mo10271e();
                return;
            case 8:
                this.f7779b.mo10127a((Activity) this.f7779b, "pt.lumberapps.imagensfrases", this.f7779b.getString(C1204R.string.nao_tem_instalada_quotefactory));
                return;
            case 9:
                this.f7779b.mo10127a((Activity) this.f7779b, "pt.lumberapps.religiosas", this.f7779b.getString(C1204R.string.nao_tem_instalada_quotefactory));
                return;
            case 10:
                this.f7779b.mo10127a((Activity) this.f7779b, "pt.lumberapps.espiritas", this.f7779b.getString(C1204R.string.nao_tem_instalada_quotefactory));
                return;
            case 11:
                this.f7779b.startActivity(new Intent(this.f7779b.getApplicationContext(), MApps.class));
                return;
            case 12:
                this.f7779b.startActivity(C2104y.m8438a("https://plus.google.com/+MilfrasesnoAndroid/"));
                return;
            default:
                return;
        }
    }
}
