package com.jackhenry.godough.core.accounts.statements;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.C1802r;
import com.jackhenry.godough.core.accounts.statements.model.StatementGroup;
import java.util.ArrayList;

public class StatementFragment extends C1802r {

    /* renamed from: a */
    private View f5885a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public ExpandableListView f5886b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public ArrayList<StatementGroup> f5887c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public C1455p f5888d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public View f5889e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f5890f = -1;

    /* access modifiers changed from: private */
    /* renamed from: n */
    public void m5870n() {
        this.f5888d = new C1455p(this.f5887c, getContext());
        this.f5886b.setAdapter(this.f5888d);
    }

    /* access modifiers changed from: private */
    /* renamed from: o */
    public void m5871o() {
        if (this.f5887c == null) {
            mo10988l();
            getActivity().getSupportLoaderManager().initLoader(1, (Bundle) null, new C1461v(this, this, new C1459t(this)));
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.f5889e == null) {
            this.f5889e = layoutInflater.inflate(C1496ak.statements_fragment, viewGroup, false);
            this.f5885a = this.f5889e.findViewById(C1494ai.container);
            this.f5886b = (ExpandableListView) this.f5889e.findViewById(C1494ai.statements_list);
            this.f5886b.setOnGroupClickListener(new C1456q(this));
            this.f5886b.setOnGroupExpandListener(new C1457r(this));
            this.f5886b.setOnChildClickListener(new C1458s(this));
            m5871o();
        } else {
            ((ViewGroup) this.f5889e.getParent()).removeView(this.f5889e);
        }
        return this.f5889e;
    }

    public void onStart() {
        super.onStart();
    }
}
