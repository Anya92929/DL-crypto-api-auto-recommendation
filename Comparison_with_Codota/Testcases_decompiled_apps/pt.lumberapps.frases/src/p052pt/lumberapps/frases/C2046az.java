package p052pt.lumberapps.frases;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.C1204R;

/* renamed from: pt.lumberapps.frases.az */
class C2046az implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ EditText f7719a;

    /* renamed from: b */
    final /* synthetic */ Activity f7720b;

    /* renamed from: c */
    final /* synthetic */ Dialog f7721c;

    /* renamed from: d */
    final /* synthetic */ EditText f7722d;

    /* renamed from: e */
    final /* synthetic */ C2043aw f7723e;

    C2046az(C2043aw awVar, EditText editText, Activity activity, Dialog dialog, EditText editText2) {
        this.f7723e = awVar;
        this.f7719a = editText;
        this.f7720b = activity;
        this.f7721c = dialog;
        this.f7722d = editText2;
    }

    public void onClick(View view) {
        boolean z = true;
        if ((this.f7719a.getText() == null) || (this.f7719a.getText().length() < 1)) {
            Toast.makeText(this.f7720b, this.f7723e.getActivity().getResources().getString(C1204R.string.edit_frase_err), 1).show();
            this.f7721c.dismiss();
            return;
        }
        String valueOf = String.valueOf(this.f7719a.getText());
        String valueOf2 = String.valueOf(this.f7722d.getText());
        boolean z2 = this.f7722d.getText() == null;
        if (this.f7722d.getText().length() >= 1) {
            z = false;
        }
        this.f7723e.f7713a.mo10198a(new C2038ar(valueOf, z2 | z ? " " : valueOf2));
        Toast.makeText(this.f7720b, this.f7723e.getActivity().getResources().getString(C1204R.string.grava_frase), 0).show();
        this.f7723e.mo10185a();
        this.f7721c.dismiss();
    }
}
