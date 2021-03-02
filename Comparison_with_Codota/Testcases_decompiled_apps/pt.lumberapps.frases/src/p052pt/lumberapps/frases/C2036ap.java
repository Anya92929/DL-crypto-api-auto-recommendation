package p052pt.lumberapps.frases;

import android.app.TimePickerDialog;
import android.widget.TimePicker;
import android.widget.Toast;
import com.google.android.gms.C1204R;
import java.util.Calendar;

/* renamed from: pt.lumberapps.frases.ap */
class C2036ap implements TimePickerDialog.OnTimeSetListener {

    /* renamed from: a */
    final /* synthetic */ Opcoes f7703a;

    C2036ap(Opcoes opcoes) {
        this.f7703a = opcoes;
    }

    public void onTimeSet(TimePicker timePicker, int i, int i2) {
        this.f7703a.f7660c.mo10203a(i, i2);
        Calendar instance = Calendar.getInstance();
        instance.set(11, this.f7703a.f7660c.mo10209d());
        instance.set(12, this.f7703a.f7660c.mo10208c());
        new C2030aj(this.f7703a).mo10167a(instance);
        Toast.makeText(this.f7703a.getBaseContext(), this.f7703a.getResources().getString(C1204R.string.hora_posta) + this.f7703a.f7660c.mo10209d() + ":" + this.f7703a.f7660c.mo10208c(), 1).show();
    }
}
