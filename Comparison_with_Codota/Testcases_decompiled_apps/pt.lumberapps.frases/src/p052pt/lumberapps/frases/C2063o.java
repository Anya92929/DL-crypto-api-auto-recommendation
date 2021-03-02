package p052pt.lumberapps.frases;

import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import com.google.android.gms.C1204R;

/* renamed from: pt.lumberapps.frases.o */
class C2063o implements AdapterView.OnItemSelectedListener {

    /* renamed from: a */
    final /* synthetic */ MainActivity f7766a;

    C2063o(MainActivity mainActivity) {
        this.f7766a = mainActivity;
    }

    public void onItemSelected(AdapterView adapterView, View view, int i, long j) {
        String str = this.f7766a.mo10242d((int) C1204R.array.temas_tabs)[i];
        this.f7766a.mo10212a(str);
        if (str == null || !str.equalsIgnoreCase(this.f7766a.getString(C1204R.string.imagens_com_frases))) {
            MainActivity mainActivity = this.f7766a;
            int i2 = mainActivity.f7655d + 1;
            mainActivity.f7655d = i2;
            if (i2 == 3) {
                this.f7766a.mo10250p();
            }
            if (C2076w.f7783T) {
                this.f7766a.m8282x();
            }
            this.f7766a.mo10125a(i);
            return;
        }
        this.f7766a.mo10127a((Activity) this.f7766a, "pt.lumberapps.imagensfrases", this.f7766a.getString(C1204R.string.nao_tem_instalada_quotefactory));
    }

    public void onNothingSelected(AdapterView adapterView) {
    }
}
