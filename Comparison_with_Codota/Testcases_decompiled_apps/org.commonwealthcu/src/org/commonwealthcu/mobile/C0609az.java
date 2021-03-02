package org.commonwealthcu.mobile;

import android.support.p003v7.appcompat.C0137R;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import java.io.File;
import java.util.HashMap;
import org.commonwealthcu.mobile.p038a.C0581c;

/* renamed from: org.commonwealthcu.mobile.az */
final class C0609az implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    private /* synthetic */ C0608ay f790a;

    C0609az(C0608ay ayVar) {
        this.f790a = ayVar;
    }

    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        TextView textView = (TextView) view.findViewById(C0137R.C0139id.vertifi_review_depositlabel);
        if (textView != null) {
            String unused = this.f790a.f786f = textView.getText().toString().split("#")[1];
            HashMap c = this.f790a.mo5523c("historypdfquery");
            this.f790a.mo5522a();
            new C0581c(this.f790a.f783c, c, (File) null, (File) null).execute(new String[]{this.f790a.f784d, this.f790a.f785e});
            System.out.println("The index of item is: " + i);
        }
    }
}
