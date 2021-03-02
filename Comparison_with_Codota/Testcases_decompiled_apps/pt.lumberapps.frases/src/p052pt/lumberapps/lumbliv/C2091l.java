package p052pt.lumberapps.lumbliv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/* renamed from: pt.lumberapps.lumbliv.l */
public class C2091l extends ArrayAdapter {

    /* renamed from: a */
    String[] f7861a;

    /* renamed from: b */
    Context f7862b;

    /* renamed from: c */
    final /* synthetic */ C2090k f7863c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2091l(C2090k kVar, Context context, int i, String[] strArr) {
        super(context, i);
        this.f7863c = kVar;
        this.f7861a = strArr;
        this.f7862b = context;
    }

    public int getCount() {
        return this.f7861a.length;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = ((LayoutInflater) this.f7862b.getSystemService("layout_inflater")).inflate(C2100u.menuitem, (ViewGroup) null);
        }
        TextView textView = (TextView) view.findViewById(C2099t.tv_menu_item);
        textView.setText(this.f7861a[i]);
        if (this.f7863c.f7860b != null) {
            textView.setTextColor(this.f7863c.f7860b.intValue());
        }
        return view;
    }
}
