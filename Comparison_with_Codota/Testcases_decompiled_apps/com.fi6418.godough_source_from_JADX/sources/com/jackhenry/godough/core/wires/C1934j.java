package com.jackhenry.godough.core.wires;

import android.support.p000v4.app.Fragment;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.C1593j;
import com.jackhenry.godough.core.C1942x;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.core.model.Wire;
import com.jackhenry.godough.core.model.WireStatus;
import com.jackhenry.godough.core.p038e.C1574c;
import com.jackhenry.godough.core.p038e.C1576e;
import com.jackhenry.godough.core.p038e.C1577f;
import com.jackhenry.godough.core.p038e.C1579h;
import com.jackhenry.godough.p027b.C1389d;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.jackhenry.godough.core.wires.j */
class C1934j extends C1942x<Wire> {

    /* renamed from: a */
    final /* synthetic */ WireDetailsFragment f6909a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1934j(WireDetailsFragment wireDetailsFragment, Fragment fragment, C1593j jVar) {
        super(fragment, jVar);
        this.f6909a = wireDetailsFragment;
    }

    /* renamed from: a */
    public void mo9588a(Wire wire) {
        Wire unused = this.f6909a.f6887b = wire;
        this.f6909a.mo10989m();
        WireDetailFragmentActivity wireDetailFragmentActivity = (WireDetailFragmentActivity) this.f6909a.getActivity();
        if (wireDetailFragmentActivity != null) {
            if (wire.getResponseStatus().isSuccessful()) {
                wireDetailFragmentActivity.setResult(-1, wireDetailFragmentActivity.getIntent());
                String string = this.f6909a.getString(C1506am.title_wire_confirmation);
                WireStatus responseStatus = this.f6909a.f6887b.getResponseStatus();
                String message = this.f6909a.f6887b.getResponseStatus().getMessage();
                if (responseStatus.getConfirmationNumber() != null) {
                    message = message + "\r\n" + this.f6909a.getString(C1506am.lbl_confirmation_number) + " " + responseStatus.getConfirmationNumber();
                }
                C1935k kVar = new C1935k(this, message);
                ArrayList arrayList = new ArrayList();
                arrayList.add(new C1574c(-1, this.f6909a.getString(C1506am.btn_ok)));
                wireDetailFragmentActivity.showConfirmationScreen(C1494ai.layout, new C1576e(C1577f.SUCCESS, (int) WireDetailsFragment.DIALOG_WIRE_SUCCESS, string, (C1579h) kVar, (List<C1574c>) arrayList));
            } else {
                wireDetailFragmentActivity.showDialog((!GoDoughApp.getUserSettings().isHasDualControlWires() || !this.f6909a.f6887b.getStatus().equals(Wire.STATUS_NEED_APPROVAL)) ? this.f6909a.getString(C1506am.title_wire_transmit_failed) : this.f6909a.getString(C1506am.title_wire_approve_failed), this.f6909a.f6887b.getResponseStatus().getMessage());
            }
            this.f6909a.f6886a = null;
        }
    }

    /* renamed from: a */
    public void mo9587a(Integer num) {
    }

    /* renamed from: a */
    public boolean mo9589a(C1389d dVar) {
        this.f6909a.mo10989m();
        WireDetailFragmentActivity wireDetailFragmentActivity = (WireDetailFragmentActivity) this.f6909a.getActivity();
        if (wireDetailFragmentActivity == null) {
            return true;
        }
        if (!super.mo9589a(dVar)) {
            wireDetailFragmentActivity.showDialog(this.f6909a.getString(C1506am.dg_error_title), dVar.getMessage());
        }
        this.f6909a.f6886a = null;
        return true;
    }
}
