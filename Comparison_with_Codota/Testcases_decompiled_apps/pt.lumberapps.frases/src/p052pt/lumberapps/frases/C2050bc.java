package p052pt.lumberapps.frases;

import android.content.Context;
import android.support.p021v7.p023b.C0515k;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.google.android.gms.C1204R;
import java.util.ArrayList;

/* renamed from: pt.lumberapps.frases.bc */
public class C2050bc extends ArrayAdapter {

    /* renamed from: a */
    final ArrayList f7737a;

    /* renamed from: b */
    final Context f7738b;

    public C2050bc(Context context, int i, ArrayList arrayList) {
        super(context, i, arrayList);
        this.f7737a = arrayList;
        this.f7738b = context;
    }

    /* renamed from: a */
    public C2038ar getItem(int i) {
        return (C2038ar) super.getItem(i);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = ((LayoutInflater) this.f7738b.getSystemService("layout_inflater")).inflate(C1204R.layout.listitem, (ViewGroup) null);
        }
        C2038ar arVar = (C2038ar) this.f7737a.get(i);
        if (arVar != null) {
            TextView textView = (TextView) view.findViewById(C1204R.C1205id.username);
            TextView textView2 = (TextView) view.findViewById(C1204R.C1205id.desc);
            if (arVar.f7707b.length() > 110) {
                textView.setText(arVar.f7707b.subSequence(0, C0515k.AppCompatTheme_radioButtonStyle) + "(...)");
            } else {
                textView.setText(arVar.f7707b);
            }
            textView2.setText(arVar.f7708c);
        }
        return view;
    }
}
