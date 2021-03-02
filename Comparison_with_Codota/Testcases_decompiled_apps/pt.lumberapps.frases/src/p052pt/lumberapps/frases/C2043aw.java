package p052pt.lumberapps.frases;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.p009v4.app.FragmentActivity;
import android.support.p009v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import com.google.android.gms.C1204R;
import com.p041b.p042a.p043a.p044a.C1145e;
import java.util.ArrayList;

/* renamed from: pt.lumberapps.frases.aw */
public class C2043aw extends ListFragment {

    /* renamed from: a */
    C2055g f7713a;

    /* renamed from: b */
    ArrayList f7714b;

    /* renamed from: c */
    int f7715c;

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8314a(String str, String str2) {
        FragmentActivity activity = getActivity();
        Dialog dialog = new Dialog(activity);
        dialog.setContentView(C1204R.layout.cria_frase);
        dialog.setTitle(getActivity().getResources().getStringArray(C1204R.array.ops_fav)[1]);
        EditText editText = (EditText) dialog.findViewById(C1204R.C1205id.editText1);
        EditText editText2 = (EditText) dialog.findViewById(C1204R.C1205id.editText2);
        editText.setText(str);
        editText2.setText(str2);
        ((Button) dialog.findViewById(C1204R.C1205id.dialogbutton1)).setOnClickListener(new C2048ba(this, editText, activity, dialog, editText2, str));
        dialog.show();
    }

    /* renamed from: b */
    private void m8316b() {
        FragmentActivity activity = getActivity();
        Dialog dialog = new Dialog(activity);
        dialog.setContentView(C1204R.layout.cria_frase);
        dialog.setTitle(getActivity().getResources().getString(C1204R.string.criar_frase));
        ((Button) dialog.findViewById(C1204R.C1205id.dialogbutton1)).setOnClickListener(new C2046az(this, (EditText) dialog.findViewById(C1204R.C1205id.editText1), activity, dialog, (EditText) dialog.findViewById(C1204R.C1205id.editText2)));
        dialog.show();
    }

    /* renamed from: a */
    public void mo10185a() {
        FragmentActivity activity = getActivity();
        this.f7714b = new ArrayList();
        if (!this.f7714b.isEmpty()) {
            this.f7714b.clear();
        }
        if (activity != null) {
            this.f7713a = new C2055g(activity);
            this.f7714b.add(new C2038ar(getActivity().getResources().getString(C1204R.string.criar_frase), " "));
            this.f7714b.addAll(this.f7713a.mo10196a());
            Log.i("INIT", String.valueOf(this.f7714b.size()));
            C1145e eVar = new C1145e(new C2050bc(activity, 17367043, this.f7714b));
            eVar.mo4467a((AbsListView) getListView());
            setListAdapter(eVar);
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        mo10185a();
        getListView().setOnItemLongClickListener(new C2044ax(this));
    }

    public void onListItemClick(ListView listView, View view, int i, long j) {
        this.f7715c = i;
        if (i == 0) {
            m8316b();
        } else if (getActivity() != null) {
            Intent intent = new Intent(getActivity().getApplicationContext(), MainActivity.class);
            MApp.m8271a(intent, (C2038ar) this.f7714b.get(i), 5);
            getActivity().setResult(-1, intent);
            getActivity().finish();
        }
    }
}
