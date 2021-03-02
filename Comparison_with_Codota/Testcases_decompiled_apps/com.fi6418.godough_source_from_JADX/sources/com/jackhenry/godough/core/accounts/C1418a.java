package com.jackhenry.godough.core.accounts;

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

/* renamed from: com.jackhenry.godough.core.accounts.a */
public class C1418a<T> extends ArrayAdapter<Account> {

    /* renamed from: a */
    private LayoutInflater f5845a;

    /* renamed from: b */
    private int f5846b;

    public C1418a(Context context, int i, List<Account> list, int i2) {
        super(context, i, list);
        this.f5845a = LayoutInflater.from(context);
        this.f5846b = i2;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f5845a.inflate(C1496ak.list_item_2_single_choice, (ViewGroup) null);
        }
        TextView textView = (TextView) view.findViewById(C1494ai.text1);
        TextView textView2 = (TextView) view.findViewById(C1494ai.text2);
        CheckedTextView checkedTextView = (CheckedTextView) view.findViewById(C1494ai.radiobutton1);
        Account account = (Account) getItem(i);
        checkedTextView.setChecked(i == this.f5846b);
        textView.setText(account.getName());
        if (account.isShowBalance()) {
            textView2.setText(getContext().getString(C1506am.balance_value, new Object[]{account.getFiDefinedBalanceFormatted()}));
            textView2.setVisibility(0);
        } else {
            textView2.setText("");
            textView2.setVisibility(8);
        }
        return view;
    }
}
