package org.commonwealthcu.mobile;

import android.support.p003v7.appcompat.C0137R;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import java.io.File;
import java.util.HashMap;
import org.commonwealthcu.mobile.p038a.C0581c;

/* renamed from: org.commonwealthcu.mobile.bc */
final class C0613bc implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    private /* synthetic */ C0612bb f811a;

    C0613bc(C0612bb bbVar) {
        this.f811a = bbVar;
    }

    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        TextView textView = (TextView) view.findViewById(C0137R.C0139id.vertifi_review_depositlabel);
        if (textView != null) {
            String unused = this.f811a.f802f = textView.getText().toString().split("#")[1];
            HashMap c = this.f811a.mo5530c("heldpdfquery");
            this.f811a.mo5529b();
            new C0581c(this.f811a.f799c, c, (File) null, (File) null).execute(new String[]{this.f811a.f800d, this.f811a.f801e});
            System.out.println("The index of item is: " + i);
        }
    }
}
