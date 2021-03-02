package com.jackhenry.godough.core.p2p;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.model.Account;
import java.util.List;

/* renamed from: com.jackhenry.godough.core.p2p.l */
public class C1783l<T> extends ArrayAdapter<Account> {

    /* renamed from: a */
    private LayoutInflater f6585a;

    /* renamed from: b */
    private int f6586b;

    public C1783l(Context context, int i, List<Account> list, int i2) {
        super(context, i, list);
        this.f6585a = LayoutInflater.from(context);
        this.f6586b = i2;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f6585a.inflate(C1496ak.list_item_2_single_choice, (ViewGroup) null);
        }
        TextView textView = (TextView) view.findViewById(C1494ai.text1);
        TextView textView2 = (TextView) view.findViewById(C1494ai.text2);
        CheckedTextView checkedTextView = (CheckedTextView) view.findViewById(C1494ai.radiobutton1);
        Account account = (Account) getItem(i);
        checkedTextView.setChecked(i == this.f6586b);
        textView.setText(account.getName());
        textView2.setText(getContext().getString(C1506am.balance_value, new Object[]{account.getFiDefinedBalanceFormatted()}));
        if (account.isShowBalance()) {
            textView2.setVisibility(0);
        } else {
            textView2.setVisibility(8);
        }
        return view;
    }
}
