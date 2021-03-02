package com.jackhenry.godough.core.billpay;

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

/* renamed from: com.jackhenry.godough.core.billpay.q */
public class C1535q<T> extends ArrayAdapter<Account> {

    /* renamed from: a */
    final /* synthetic */ BillPayFragment f6060a;

    /* renamed from: b */
    private LayoutInflater f6061b;

    /* renamed from: c */
    private int f6062c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1535q(BillPayFragment billPayFragment, Context context, int i, List<Account> list, int i2) {
        super(context, i, list);
        this.f6060a = billPayFragment;
        this.f6061b = LayoutInflater.from(context);
        this.f6062c = i2;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f6061b.inflate(C1496ak.list_item_2_single_choice, (ViewGroup) null);
        }
        TextView textView = (TextView) view.findViewById(C1494ai.text1);
        TextView textView2 = (TextView) view.findViewById(C1494ai.text2);
        CheckedTextView checkedTextView = (CheckedTextView) view.findViewById(C1494ai.radiobutton1);
        Account account = (Account) getItem(i);
        checkedTextView.setChecked(i == this.f6062c);
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
