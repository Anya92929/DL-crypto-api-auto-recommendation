package p052pt.lumberapps.frases;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.google.android.gms.C1204R;

/* renamed from: pt.lumberapps.frases.ai */
public class C2029ai extends ArrayAdapter {

    /* renamed from: a */
    final /* synthetic */ C2076w f7690a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2029ai(C2076w wVar, Context context, int i) {
        super(context, i);
        this.f7690a = wVar;
    }

    public int getCount() {
        return this.f7690a.f7821t.length;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = ((LayoutInflater) this.f7690a.getSystemService("layout_inflater")).inflate(C1204R.layout.menuitem, (ViewGroup) null);
        }
        TextView textView = (TextView) view.findViewById(C1204R.C1205id.tv_menu_item);
        String str = this.f7690a.f7821t[i];
        textView.setText(str);
        if (str.contains("App")) {
            textView.setTextColor(this.f7690a.getResources().getColor(C1204R.color.laranja_bts));
        } else if (str.contains("Google+")) {
            textView.setTextColor(this.f7690a.getResources().getColor(C1204R.color.Red));
        } else {
            textView.setTextColor(this.f7690a.getResources().getColor(C1204R.color.White));
        }
        return view;
    }
}
