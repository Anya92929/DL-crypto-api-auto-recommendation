package p052pt.lumberapps.lumbliv;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.p028a.C0765a;
import com.p028a.p030b.C0773f;
import java.util.ArrayList;

/* renamed from: pt.lumberapps.lumbliv.a */
public class C2080a extends ArrayAdapter {

    /* renamed from: a */
    final ArrayList f7835a;

    /* renamed from: b */
    final Context f7836b;

    /* renamed from: c */
    C0765a f7837c;

    /* renamed from: d */
    C0773f f7838d = new C0773f();

    public C2080a(Context context, int i, ArrayList arrayList, C0765a aVar) {
        super(context, i, arrayList);
        this.f7835a = arrayList;
        this.f7836b = context;
        this.f7837c = aVar;
        this.f7838d.f2001i = 15;
        this.f7838d.f1997e = 95;
    }

    /* renamed from: a */
    public C2092m getItem(int i) {
        return (C2092m) super.getItem(i);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View inflate = ((LayoutInflater) this.f7836b.getSystemService("layout_inflater")).inflate(C2100u.minhas_apps_card, viewGroup);
        if (((C2092m) this.f7835a.get(i)) != null) {
            ((C0765a) this.f7837c.mo3462a((View) (ImageView) inflate.findViewById(C2099t.iv_card))).mo3467a(((C2092m) this.f7835a.get(i)).f7867d, this.f7838d);
            ((C0765a) this.f7837c.mo3462a((View) (TextView) inflate.findViewById(C2099t.tv_titulo_card))).mo3466a((CharSequence) Html.fromHtml(((C2092m) this.f7835a.get(i)).f7864a), true);
            ((C0765a) this.f7837c.mo3462a((View) (TextView) inflate.findViewById(C2099t.tv_desc_card))).mo3466a((CharSequence) Html.fromHtml(C2104y.m8439a(((C2092m) this.f7835a.get(i)).f7865b, 140)), true);
        }
        return inflate;
    }
}
