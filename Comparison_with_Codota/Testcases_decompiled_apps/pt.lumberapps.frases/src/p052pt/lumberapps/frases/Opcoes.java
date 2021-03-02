package p052pt.lumberapps.frases;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceActivity;
import com.google.android.gms.C1204R;

/* renamed from: pt.lumberapps.frases.Opcoes */
public class Opcoes extends PreferenceActivity {

    /* renamed from: a */
    final Handler f7658a = new Handler();

    /* renamed from: b */
    C2055g f7659b = new C2055g(this);

    /* renamed from: c */
    C2056h f7660c;

    /* renamed from: d */
    TimePickerDialog.OnTimeSetListener f7661d = new C2036ap(this);

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        addPreferencesFromResource(C1204R.xml.preferences);
        findPreference("setahora").setOnPreferenceClickListener(new C2034an(this));
        findPreference("linguagem_ops").setOnPreferenceChangeListener(new C2035ao(this));
    }

    /* access modifiers changed from: protected */
    public Dialog onCreateDialog(int i) {
        this.f7660c = new C2056h(this);
        return new TimePickerDialog(this, this.f7661d, this.f7660c.mo10209d(), this.f7660c.mo10208c(), true);
    }
}
