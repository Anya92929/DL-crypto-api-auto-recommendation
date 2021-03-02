package com.jackhenry.godough.core.p036c;

import android.view.View;
import android.widget.AdapterView;
import com.jackhenry.godough.core.model.GodoughMenuItem;

/* renamed from: com.jackhenry.godough.core.c.d */
class C1548d implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ C1546b f6085a;

    C1548d(C1546b bVar) {
        this.f6085a = bVar;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f6085a.f6075b = ((GodoughMenuItem) this.f6085a.f6074a.getItem(i)).getType();
        this.f6085a.mo9756e().closeDrawer(3);
        Runnable unused = this.f6085a.f6082i = new C1549e(this);
    }
}
