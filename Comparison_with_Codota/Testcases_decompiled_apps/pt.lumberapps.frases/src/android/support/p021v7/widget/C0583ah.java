package android.support.p021v7.widget;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.PopupWindow;

/* renamed from: android.support.v7.widget.ah */
class C0583ah implements View.OnClickListener, View.OnLongClickListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener {

    /* renamed from: a */
    final /* synthetic */ ActivityChooserView f1369a;

    /* renamed from: a */
    private void m2705a() {
        if (this.f1369a.f1239l != null) {
            this.f1369a.f1239l.onDismiss();
        }
    }

    public void onClick(View view) {
        if (view == this.f1369a.f1234g) {
            this.f1369a.mo2741b();
            Intent b = this.f1369a.f1229b.mo2932d().mo3370b(this.f1369a.f1229b.mo2932d().mo3368a(this.f1369a.f1229b.mo2930b()));
            if (b != null) {
                b.addFlags(524288);
                this.f1369a.getContext().startActivity(b);
            }
        } else if (view == this.f1369a.f1232e) {
            boolean unused = this.f1369a.f1240m = false;
            this.f1369a.m2600a(this.f1369a.f1241n);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void onDismiss() {
        m2705a();
        if (this.f1369a.f1228a != null) {
            this.f1369a.f1228a.mo1620a(false);
        }
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        switch (((C0582ag) adapterView.getAdapter()).getItemViewType(i)) {
            case 0:
                this.f1369a.mo2741b();
                if (!this.f1369a.f1240m) {
                    if (!this.f1369a.f1229b.mo2933e()) {
                        i++;
                    }
                    Intent b = this.f1369a.f1229b.mo2932d().mo3370b(i);
                    if (b != null) {
                        b.addFlags(524288);
                        this.f1369a.getContext().startActivity(b);
                        return;
                    }
                    return;
                } else if (i > 0) {
                    this.f1369a.f1229b.mo2932d().mo3372c(i);
                    return;
                } else {
                    return;
                }
            case 1:
                this.f1369a.m2600a(Integer.MAX_VALUE);
                return;
            default:
                throw new IllegalArgumentException();
        }
    }

    public boolean onLongClick(View view) {
        if (view == this.f1369a.f1234g) {
            if (this.f1369a.f1229b.getCount() > 0) {
                boolean unused = this.f1369a.f1240m = true;
                this.f1369a.m2600a(this.f1369a.f1241n);
            }
            return true;
        }
        throw new IllegalArgumentException();
    }
}
