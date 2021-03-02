package org.commonwealthcu.mobile;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.p000v4.app.FragmentTransaction;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import org.p004a.p005a.p007b.p008a.C0250b;

/* renamed from: org.commonwealthcu.mobile.an */
final class C0597an implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    private /* synthetic */ C0596am f738a;

    C0597an(C0596am amVar) {
        this.f738a = amVar;
    }

    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        C0596am amVar = this.f738a;
        MobileBankingApp mobileBankingApp = (MobileBankingApp) amVar.getActivity().getApplicationContext();
        String a = mobileBankingApp.mo5460a("LNK" + (i + 1));
        Context applicationContext = amVar.getActivity().getApplicationContext();
        String a2 = mobileBankingApp.mo5460a("ExternalSiteExclusions");
        String d = mobileBankingApp.mo5468d();
        if (a.startsWith("http") && mobileBankingApp.mo5460a("ExternalSiteDisclosure") != null) {
            if (a2 != null) {
                a2 = a2.toLowerCase();
            }
            String a3 = C0596am.m1291a(a);
            if ((a2 == null || a2.indexOf(a3) < 0) ? !a3.equalsIgnoreCase(C0596am.m1291a(d)) : false) {
                AlertDialog.Builder builder = new AlertDialog.Builder(amVar.getActivity());
                TextView textView = new TextView(amVar.getActivity());
                textView.setTypeface(C0250b.m81a((Context) amVar.getActivity()));
                textView.setText("External Link Disclosure");
                builder.setCustomTitle(textView);
                builder.setMessage(mobileBankingApp.mo5460a("ExternalSiteDisclosure"));
                builder.setPositiveButton(17039370, new C0598ao(amVar, a));
                builder.setNegativeButton("Cancel", (DialogInterface.OnClickListener) null);
                TextView textView2 = (TextView) builder.show().findViewById(16908299);
                if (textView2 != null) {
                    textView2.setTypeface(C0250b.m81a((Context) amVar.getActivity()));
                    return;
                }
                return;
            }
        }
        if (!a.startsWith("http")) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(a));
            intent.addFlags(268435456);
            applicationContext.startActivity(new Intent(intent));
            return;
        }
        FragmentTransaction beginTransaction = amVar.getActivity().getSupportFragmentManager().beginTransaction();
        C0620bj bjVar = new C0620bj();
        beginTransaction.add(16908290, bjVar, "Ad_Browser");
        bjVar.mo5547a(a);
        beginTransaction.commit();
    }
}
