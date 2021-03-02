package p052pt.lumberapps.lumbliv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

/* renamed from: pt.lumberapps.lumbliv.j */
public class C2089j extends ArrayAdapter {

    /* renamed from: a */
    final /* synthetic */ C2086g f7858a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2089j(C2086g gVar, Context context, int i, List list) {
        super(context, i, list);
        this.f7858a = gVar;
    }

    /* renamed from: a */
    public C2088i getItem(int i) {
        return (C2088i) this.f7858a.f7850b.get(i);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(C2100u.item_dialogo_share, (ViewGroup) null);
        }
        TextView textView = (TextView) view.findViewById(C2099t.dialog_tv_item);
        C2088i a = getItem(i);
        textView.setText(a.f7854a);
        textView.setCompoundDrawablesWithIntrinsicBounds(a.f7856c.intValue(), 0, 0, 0);
        this.f7858a.mo10282a(textView);
        this.f7858a.mo10284b(textView);
        return view;
    }
}
