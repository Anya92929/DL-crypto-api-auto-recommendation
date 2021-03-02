package p052pt.lumberapps.frases;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.C1204R;

/* renamed from: pt.lumberapps.frases.ba */
class C2048ba implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ EditText f7730a;

    /* renamed from: b */
    final /* synthetic */ Activity f7731b;

    /* renamed from: c */
    final /* synthetic */ Dialog f7732c;

    /* renamed from: d */
    final /* synthetic */ EditText f7733d;

    /* renamed from: e */
    final /* synthetic */ String f7734e;

    /* renamed from: f */
    final /* synthetic */ C2043aw f7735f;

    C2048ba(C2043aw awVar, EditText editText, Activity activity, Dialog dialog, EditText editText2, String str) {
        this.f7735f = awVar;
        this.f7730a = editText;
        this.f7731b = activity;
        this.f7732c = dialog;
        this.f7733d = editText2;
        this.f7734e = str;
    }

    public void onClick(View view) {
        boolean z = true;
        if ((this.f7730a.getText() == null) || (this.f7730a.getText().length() < 1)) {
            Toast.makeText(this.f7731b, this.f7731b.getResources().getString(C1204R.string.edit_frase_err), 1).show();
            this.f7732c.dismiss();
            return;
        }
        String valueOf = String.valueOf(this.f7730a.getText());
        String valueOf2 = String.valueOf(this.f7733d.getText());
        boolean z2 = this.f7733d.getText() == null;
        if (this.f7733d.getText().length() >= 1) {
            z = false;
        }
        String str = z2 | z ? " " : valueOf2;
        C2038ar a = this.f7735f.f7713a.mo10197a(this.f7734e);
        this.f7735f.f7713a.mo10199b(a);
        a.mo10182b(valueOf);
        a.mo10180a(str);
        this.f7735f.f7713a.mo10198a(a);
        Toast.makeText(this.f7731b, this.f7735f.getActivity().getResources().getString(C1204R.string.grava_frase), 0).show();
        this.f7735f.mo10185a();
        this.f7732c.dismiss();
    }
}
