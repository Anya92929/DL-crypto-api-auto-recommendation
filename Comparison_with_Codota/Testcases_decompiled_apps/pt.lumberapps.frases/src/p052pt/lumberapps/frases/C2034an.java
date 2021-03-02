package p052pt.lumberapps.frases;

import android.preference.Preference;

/* renamed from: pt.lumberapps.frases.an */
class C2034an implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ Opcoes f7701a;

    C2034an(Opcoes opcoes) {
        this.f7701a = opcoes;
    }

    public boolean onPreferenceClick(Preference preference) {
        this.f7701a.showDialog(0);
        return true;
    }
}
