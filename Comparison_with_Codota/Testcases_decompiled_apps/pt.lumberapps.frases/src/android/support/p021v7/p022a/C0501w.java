package android.support.p021v7.p022a;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

/* renamed from: android.support.v7.a.w */
public class C0501w {

    /* renamed from: A */
    public int f829A;

    /* renamed from: B */
    public boolean f830B = false;

    /* renamed from: C */
    public boolean[] f831C;

    /* renamed from: D */
    public boolean f832D;

    /* renamed from: E */
    public boolean f833E;

    /* renamed from: F */
    public int f834F = -1;

    /* renamed from: G */
    public DialogInterface.OnMultiChoiceClickListener f835G;

    /* renamed from: H */
    public Cursor f836H;

    /* renamed from: I */
    public String f837I;

    /* renamed from: J */
    public String f838J;

    /* renamed from: K */
    public AdapterView.OnItemSelectedListener f839K;

    /* renamed from: L */
    public C0428ab f840L;

    /* renamed from: M */
    public boolean f841M = true;

    /* renamed from: a */
    public final Context f842a;

    /* renamed from: b */
    public final LayoutInflater f843b;

    /* renamed from: c */
    public int f844c = 0;

    /* renamed from: d */
    public Drawable f845d;

    /* renamed from: e */
    public int f846e = 0;

    /* renamed from: f */
    public CharSequence f847f;

    /* renamed from: g */
    public View f848g;

    /* renamed from: h */
    public CharSequence f849h;

    /* renamed from: i */
    public CharSequence f850i;

    /* renamed from: j */
    public DialogInterface.OnClickListener f851j;

    /* renamed from: k */
    public CharSequence f852k;

    /* renamed from: l */
    public DialogInterface.OnClickListener f853l;

    /* renamed from: m */
    public CharSequence f854m;

    /* renamed from: n */
    public DialogInterface.OnClickListener f855n;

    /* renamed from: o */
    public boolean f856o;

    /* renamed from: p */
    public DialogInterface.OnCancelListener f857p;

    /* renamed from: q */
    public DialogInterface.OnDismissListener f858q;

    /* renamed from: r */
    public DialogInterface.OnKeyListener f859r;

    /* renamed from: s */
    public CharSequence[] f860s;

    /* renamed from: t */
    public ListAdapter f861t;

    /* renamed from: u */
    public DialogInterface.OnClickListener f862u;

    /* renamed from: v */
    public int f863v;

    /* renamed from: w */
    public View f864w;

    /* renamed from: x */
    public int f865x;

    /* renamed from: y */
    public int f866y;

    /* renamed from: z */
    public int f867z;

    public C0501w(Context context) {
        this.f842a = context;
        this.f856o = true;
        this.f843b = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    /* renamed from: b */
    private void m2167b(C0495q qVar) {
        ListAdapter simpleCursorAdapter;
        ListView listView = (ListView) this.f843b.inflate(qVar.f783H, (ViewGroup) null);
        if (this.f832D) {
            simpleCursorAdapter = this.f836H == null ? new C0502x(this, this.f842a, qVar.f784I, 16908308, this.f860s, listView) : new C0503y(this, this.f842a, this.f836H, false, listView, qVar);
        } else {
            int m = this.f833E ? qVar.f785J : qVar.f786K;
            simpleCursorAdapter = this.f836H != null ? new SimpleCursorAdapter(this.f842a, m, this.f836H, new String[]{this.f837I}, new int[]{16908308}) : this.f861t != null ? this.f861t : new C0430ad(this.f842a, m, 16908308, this.f860s);
        }
        if (this.f840L != null) {
            this.f840L.mo1931a(listView);
        }
        ListAdapter unused = qVar.f779D = simpleCursorAdapter;
        int unused2 = qVar.f780E = this.f834F;
        if (this.f862u != null) {
            listView.setOnItemClickListener(new C0504z(this, qVar));
        } else if (this.f835G != null) {
            listView.setOnItemClickListener(new C0427aa(this, listView, qVar));
        }
        if (this.f839K != null) {
            listView.setOnItemSelectedListener(this.f839K);
        }
        if (this.f833E) {
            listView.setChoiceMode(1);
        } else if (this.f832D) {
            listView.setChoiceMode(2);
        }
        ListView unused3 = qVar.f795f = listView;
    }

    /* renamed from: a */
    public void mo2134a(C0495q qVar) {
        if (this.f848g != null) {
            qVar.setCustomTitle(this.f848g);
        } else {
            if (this.f847f != null) {
                qVar.mo2121a(this.f847f);
            }
            if (this.f845d != null) {
                qVar.mo2119a(this.f845d);
            }
            if (this.f844c != 0) {
                qVar.mo2123b(this.f844c);
            }
            if (this.f846e != 0) {
                qVar.mo2123b(qVar.mo2126c(this.f846e));
            }
        }
        if (this.f849h != null) {
            qVar.mo2124b(this.f849h);
        }
        if (this.f850i != null) {
            qVar.mo2118a(-1, this.f850i, this.f851j, (Message) null);
        }
        if (this.f852k != null) {
            qVar.mo2118a(-2, this.f852k, this.f853l, (Message) null);
        }
        if (this.f854m != null) {
            qVar.mo2118a(-3, this.f854m, this.f855n, (Message) null);
        }
        if (!(this.f860s == null && this.f836H == null && this.f861t == null)) {
            m2167b(qVar);
        }
        if (this.f864w != null) {
            if (this.f830B) {
                qVar.mo2120a(this.f864w, this.f865x, this.f866y, this.f867z, this.f829A);
                return;
            }
            qVar.setView(this.f864w);
        } else if (this.f863v != 0) {
            qVar.mo2117a(this.f863v);
        }
    }
}
