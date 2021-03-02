package p052pt.lumberapps.frases;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.p009v4.app.FragmentActivity;
import android.support.p009v4.app.ListFragment;
import android.view.View;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.appbrain.C0984b;
import com.appbrain.C1121k;
import com.p041b.p042a.p043a.p044a.C1144d;

/* renamed from: pt.lumberapps.frases.au */
public class C2041au extends ListFragment {

    /* renamed from: a */
    C0984b f7711a;

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            this.f7711a = C1121k.m5207a().mo3693a((Context) activity, (ListAdapter) new C2050bc(activity, 17367043, C2020a.f7670g));
            C1144d dVar = new C1144d((BaseAdapter) this.f7711a);
            dVar.mo4467a((AbsListView) getListView());
            setListAdapter(dVar);
        }
    }

    public void onListItemClick(ListView listView, View view, int i, long j) {
        FragmentActivity activity = getActivity();
        int a = this.f7711a.mo3620a(i);
        Intent intent = new Intent(getActivity().getApplicationContext(), MainActivity.class);
        MApp.m8271a(intent, (C2038ar) C2020a.f7670g.get(a), 2);
        activity.setResult(-1, intent);
        activity.finish();
    }
}
