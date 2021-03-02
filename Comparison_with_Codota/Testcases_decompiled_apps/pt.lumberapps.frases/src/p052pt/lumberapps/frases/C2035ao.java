package p052pt.lumberapps.frases;

import android.preference.Preference;

/* renamed from: pt.lumberapps.frases.ao */
class C2035ao implements Preference.OnPreferenceChangeListener {

    /* renamed from: a */
    final /* synthetic */ Opcoes f7702a;

    C2035ao(Opcoes opcoes) {
        this.f7702a = opcoes;
    }

    public boolean onPreferenceChange(Preference preference, Object obj) {
        this.f7702a.setResult(32);
        return true;
    }
}
