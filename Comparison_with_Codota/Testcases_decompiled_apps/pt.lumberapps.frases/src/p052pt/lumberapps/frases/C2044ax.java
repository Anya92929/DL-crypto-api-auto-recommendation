package p052pt.lumberapps.frases;

import android.app.AlertDialog;
import android.view.View;
import android.widget.AdapterView;
import com.google.android.gms.C1204R;

/* renamed from: pt.lumberapps.frases.ax */
class C2044ax implements AdapterView.OnItemLongClickListener {

    /* renamed from: a */
    final /* synthetic */ C2043aw f7716a;

    C2044ax(C2043aw awVar) {
        this.f7716a = awVar;
    }

    public boolean onItemLongClick(AdapterView adapterView, View view, int i, long j) {
        String[] stringArray = this.f7716a.getActivity().getResources().getStringArray(C1204R.array.ops_fav);
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f7716a.getActivity());
        builder.setIcon(C1204R.drawable.ic_launcher);
        builder.setItems(stringArray, new C2045ay(this, i));
        builder.create().show();
        return true;
    }
}
