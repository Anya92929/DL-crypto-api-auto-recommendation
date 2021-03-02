package p052pt.lumberapps.frases;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.C1204R;
import p052pt.lumberapps.lumbliv.C2086g;
import p052pt.lumberapps.lumbliv.C2088i;
import p052pt.lumberapps.lumbliv.C2104y;

/* renamed from: pt.lumberapps.frases.q */
class C2070q extends C2086g {

    /* renamed from: a */
    final /* synthetic */ MainActivity f7773a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C2070q(MainActivity mainActivity, Context context) {
        super(context);
        this.f7773a = mainActivity;
    }

    /* renamed from: a */
    public void mo10232a(C2088i iVar) {
        if (iVar.f7854a.equalsIgnoreCase("Facebook")) {
            if (new C2056h(this.f7773a).mo10206a("cola_facetrukes")) {
                C2071r rVar = new C2071r(this, this.f7773a, this.f7773a.getString(C1204R.string.cole_a_frase));
                rVar.mo10272a(this.f7773a.getResources().getColor(C1204R.color.azul_fescuro), -1);
                rVar.mo10269c().mo10271e();
                return;
            }
            this.f7773a.mo10239b(0);
        } else if (iVar.f7855b.equalsIgnoreCase("sms")) {
            this.f7773a.mo10239b(1);
        } else if (iVar.f7855b.equalsIgnoreCase("outros")) {
            this.f7773a.mo10239b(4);
        } else if (iVar.f7855b.equalsIgnoreCase("copiar")) {
            this.f7773a.mo10239b(3);
        } else if (iVar.f7855b.contains("quotefactory")) {
            this.f7773a.mo10127a((Activity) this.f7773a, "pt.lumberapps.quotefactory", this.f7773a.getString(C1204R.string.nao_tem_instalada));
        } else if (iVar.f7855b.contains("exportaimg")) {
            this.f7773a.mo10216g();
        } else {
            Intent a = C2104y.m8437a(this.f7773a, this.f7773a.mo10254t(), iVar.f7855b);
            if (a == null) {
                this.f7773a.mo10213b(this.f7773a.getString(C1204R.string.nao_tem_instalada));
            } else {
                this.f7773a.startActivity(a);
            }
        }
    }
}
