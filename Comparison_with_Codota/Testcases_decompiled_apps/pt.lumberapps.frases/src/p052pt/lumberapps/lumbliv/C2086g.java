package p052pt.lumberapps.lumbliv;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.ArrayList;

/* renamed from: pt.lumberapps.lumbliv.g */
public class C2086g extends Dialog implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    private Context f7849a;

    /* renamed from: b */
    final ArrayList f7850b = new ArrayList();

    /* renamed from: c */
    Integer f7851c;

    /* renamed from: d */
    Typeface f7852d;

    public C2086g(Context context) {
        super(context);
        this.f7849a = context;
    }

    /* renamed from: a */
    public void mo10279a() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(getWindow().getAttributes());
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.gravity = 17;
        getWindow().setAttributes(layoutParams);
    }

    /* renamed from: a */
    public void mo10280a(int i, int i2, String str) {
        requestWindowFeature(1);
        setContentView(C2100u.dialog_share);
        this.f7851c = Integer.valueOf(i2);
        TextView textView = (TextView) findViewById(C2099t.dialog_share_tv_bt);
        TextView textView2 = (TextView) findViewById(C2099t.dialog_share_titulo);
        ((RelativeLayout) findViewById(C2099t.dialogo_rela_root)).setBackgroundColor(i);
        mo10279a();
        if (str.isEmpty() || str == null) {
            textView2.setVisibility(8);
        } else {
            textView2.setText(str);
        }
        mo10282a(textView2);
        mo10284b(textView2);
        textView.setClickable(true);
        textView.setText("Cancel");
        mo10282a(textView);
        textView.setOnClickListener(new C2087h(this));
        mo10283b();
        mo10285c();
        ListView listView = (ListView) findViewById(C2099t.dialog_share_listView1);
        listView.setAdapter(new C2089j(this, getContext(), C2099t.dialog_tv_item, this.f7850b));
        listView.setOnItemClickListener(this);
    }

    /* renamed from: a */
    public void mo10281a(int i, String str, String str2, Integer num) {
        C2088i iVar = new C2088i(this, str, str2, num);
        if (i < this.f7850b.size()) {
            this.f7850b.add(i, iVar);
        } else {
            this.f7850b.add(iVar);
        }
    }

    /* renamed from: a */
    public void mo10282a(TextView textView) {
        if (this.f7852d == null) {
            this.f7852d = Typeface.createFromAsset(this.f7849a.getAssets(), "roboto-thin.ttf");
        }
        textView.setTypeface(this.f7852d);
    }

    /* renamed from: a */
    public void mo10232a(C2088i iVar) {
        dismiss();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo10283b() {
        if (this.f7850b.isEmpty()) {
            this.f7850b.add(new C2088i(this, "SMS", "sms", Integer.valueOf(C2098s.ds_sms)));
            this.f7850b.add(new C2088i(this, "Whatsapp", "com.whatsapp", Integer.valueOf(C2098s.ds_whatsapp)));
            this.f7850b.add(new C2088i(this, "Facebook", "com.facebook.katana", Integer.valueOf(C2098s.ds_facebook_icon)));
            this.f7850b.add(new C2088i(this, "Messenger", "com.facebook.orca", Integer.valueOf(C2098s.ds_facebook_messenger_icone)));
            this.f7850b.add(new C2088i(this, "Viber", "com.viber.voip", Integer.valueOf(C2098s.ds_viber_icon)));
            this.f7850b.add(new C2088i(this, "Skype", "com.skype.raider", Integer.valueOf(C2098s.ds_skype)));
            this.f7850b.add(new C2088i(this, "Others", "outros", Integer.valueOf(C2098s.ds_share)));
        }
    }

    /* renamed from: b */
    public void mo10284b(TextView textView) {
        if (this.f7851c != null) {
            textView.setTextColor(this.f7851c.intValue());
        }
    }

    /* renamed from: c */
    public void mo10285c() {
        this.f7850b.add(0, new C2088i(this, "Copy", "copiar", Integer.valueOf(C2098s.ds_copy_icon)));
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        mo10232a((C2088i) this.f7850b.get(i));
        dismiss();
    }

    public void show() {
        super.show();
        mo10279a();
    }
}
