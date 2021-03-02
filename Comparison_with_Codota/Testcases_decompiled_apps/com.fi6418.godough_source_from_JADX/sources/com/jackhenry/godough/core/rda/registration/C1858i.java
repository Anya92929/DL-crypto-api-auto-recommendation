package com.jackhenry.godough.core.rda.registration;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.model.RDARegistrationAccount;
import java.util.ArrayList;

/* renamed from: com.jackhenry.godough.core.rda.registration.i */
public class C1858i extends ArrayAdapter<RDARegistrationAccount> {

    /* renamed from: a */
    ArrayList<RDARegistrationAccount> f6744a = new ArrayList<>();

    /* renamed from: b */
    ArrayList<Boolean> f6745b = new ArrayList<>();

    /* renamed from: c */
    final /* synthetic */ RDARegistrationAccountSelectionFragment f6746c;

    /* renamed from: d */
    private LayoutInflater f6747d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1858i(RDARegistrationAccountSelectionFragment rDARegistrationAccountSelectionFragment, Context context, ArrayList<RDARegistrationAccount> arrayList) {
        super(context, 0, arrayList);
        this.f6746c = rDARegistrationAccountSelectionFragment;
        this.f6747d = LayoutInflater.from(context);
        this.f6744a = arrayList;
        for (int i = 0; i < this.f6744a.size(); i++) {
            this.f6745b.add(false);
        }
    }

    /* renamed from: a */
    public RDARegistrationAccount getItem(int i) {
        return this.f6744a.get(i);
    }

    /* renamed from: a */
    public ArrayList<Boolean> mo11081a() {
        return this.f6745b;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View inflate = view == null ? this.f6747d.inflate(C1496ak.list_item, (ViewGroup) null, false) : view;
        ((ViewGroup) inflate).removeAllViews();
        View inflate2 = this.f6747d.inflate(this.f6744a.size() == 1 ? C1496ak.list_item_single : i == this.f6744a.size() + -1 ? C1496ak.list_item_bottom : i == 0 ? C1496ak.list_item_top : C1496ak.list_item_middle, (ViewGroup) null, false);
        CheckedTextView checkedTextView = (CheckedTextView) this.f6747d.inflate(17367056, (ViewGroup) inflate2).findViewById(16908308);
        if (mo11081a().get(i).booleanValue()) {
            checkedTextView.setChecked(true);
        }
        checkedTextView.setOnClickListener(new C1859j(this, checkedTextView, i));
        RDARegistrationAccount rDARegistrationAccount = this.f6744a.get(i);
        checkedTextView.setText(rDARegistrationAccount.getName());
        checkedTextView.setTag(rDARegistrationAccount);
        inflate.setTag(this.f6744a);
        ((ViewGroup) inflate).addView(inflate2);
        return inflate;
    }
}
