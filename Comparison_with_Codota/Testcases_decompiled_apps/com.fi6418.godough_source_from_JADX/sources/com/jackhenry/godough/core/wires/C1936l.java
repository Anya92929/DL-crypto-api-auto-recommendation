package com.jackhenry.godough.core.wires;

import android.support.p000v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.jackhenry.android.p022a.p023a.C1349a;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.C1801q;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.core.model.Wire;
import com.jackhenry.godough.core.model.WiresList;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.jackhenry.godough.core.wires.l */
public class C1936l extends C1801q<Wire> {

    /* renamed from: b */
    private int f6912b;

    /* renamed from: c */
    private WiresList f6913c;

    /* renamed from: d */
    private String f6914d;

    public C1936l(int i, Fragment fragment) {
        super(fragment);
        this.f6912b = i;
    }

    public C1936l(Fragment fragment) {
        this(C1496ak.list_item_icon_nav, fragment);
    }

    public C1936l(Fragment fragment, String str) {
        this(C1496ak.list_item_icon_nav, fragment);
        this.f6914d = str;
        if (str == null) {
            this.f6914d = "SHOW_ALL";
        }
    }

    /* renamed from: a */
    private List<Wire> m6984a(List<Wire> list, String str) {
        ArrayList arrayList = new ArrayList();
        for (Wire next : list) {
            if (!str.equals("SHOW_ALL") ? next.getStatus().equals(Wire.STATUS_NEED_APPROVAL) : !next.getStatus().equals(Wire.STATUS_NEED_APPROVAL)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public C1349a<Wire> mo9278a(int i) {
        this.f6913c = new C1925a().mo11202b();
        List<Wire> wires = this.f6913c.getWires();
        if (GoDoughApp.getUserSettings().isHasDualControlWires()) {
            wires = m6984a(wires, this.f6914d);
        }
        return new C1349a<>(wires, false, -1);
    }

    /* renamed from: a */
    public void mo9279a(LayoutInflater layoutInflater, ViewGroup viewGroup, Wire wire) {
        View inflate = layoutInflater.inflate(this.f6912b, viewGroup);
        viewGroup.setTag(wire);
        ((TextView) inflate.findViewById(C1494ai.line1)).setText(wire.getName());
        ((TextView) inflate.findViewById(C1494ai.line2)).setText(wire.getDebitAccountName());
        ((TextView) inflate.findViewById(C1494ai.line2_right)).setText(wire.getAmountFormatted());
    }

    /* renamed from: b */
    public boolean mo9567b(View view, Exception exc) {
        mo10985a(exc);
        return false;
    }
}
