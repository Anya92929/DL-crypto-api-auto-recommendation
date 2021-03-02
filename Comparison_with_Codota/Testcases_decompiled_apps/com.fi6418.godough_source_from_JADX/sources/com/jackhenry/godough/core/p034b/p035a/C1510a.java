package com.jackhenry.godough.core.p034b.p035a;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.p000v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.jackhenry.android.widget.calendar.CalendarControl;
import com.jackhenry.android.widget.calendar.OnDateChosen;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import java.util.Calendar;
import java.util.List;

/* renamed from: com.jackhenry.godough.core.b.a.a */
public class C1510a extends DialogFragment {

    /* renamed from: aj */
    private String f5988aj;

    /* renamed from: ak */
    private Calendar f5989ak;

    /* renamed from: al */
    private Calendar f5990al;

    /* renamed from: am */
    private OnDateChosen f5991am;

    /* renamed from: an */
    private Calendar f5992an;

    /* renamed from: ao */
    private CalendarControl f5993ao;

    /* renamed from: ap */
    private List<Calendar> f5994ap;

    /* renamed from: aq */
    private DialogInterface.OnDismissListener f5995aq;

    /* renamed from: a */
    public void mo9706a(OnDateChosen onDateChosen) {
        this.f5991am = onDateChosen;
    }

    /* renamed from: a */
    public void mo9707a(Calendar calendar) {
        this.f5989ak = calendar;
    }

    /* renamed from: a */
    public void mo9708a(List<Calendar> list) {
        this.f5994ap = list;
    }

    /* renamed from: b */
    public void mo9709b(String str) {
        this.f5988aj = str;
    }

    /* renamed from: b */
    public void mo9710b(Calendar calendar) {
        this.f5990al = calendar;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(1, getTheme());
        setRetainInstance(true);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Dialog dialog = getDialog();
        dialog.getWindow().getDecorView().setBackgroundDrawable((Drawable) null);
        if (this.f5995aq != null) {
            dialog.setOnDismissListener(this.f5995aq);
        }
        LinearLayout linearLayout = (LinearLayout) layoutInflater.inflate(C1496ak.selection_dialog, viewGroup, false);
        ((TextView) linearLayout.findViewById(C1494ai.title)).setText(this.f5988aj);
        FrameLayout frameLayout = (FrameLayout) linearLayout.findViewById(C1494ai.content_frame);
        frameLayout.removeAllViews();
        this.f5993ao = (CalendarControl) layoutInflater.inflate(C1496ak.calendar_popup, (ViewGroup) null);
        this.f5993ao.setSelectedDate(this.f5989ak);
        this.f5993ao.setMinimumDate(this.f5990al);
        this.f5993ao.setOnDateChosen(this.f5991am);
        if (this.f5994ap != null) {
            this.f5993ao.setValidDates(this.f5994ap);
        }
        if (this.f5992an != null) {
            this.f5993ao.setCurrentPage(this.f5992an);
        }
        frameLayout.addView(this.f5993ao);
        return linearLayout;
    }

    public void onDestroyView() {
        if (getDialog() != null && getRetainInstance()) {
            getDialog().setOnDismissListener((DialogInterface.OnDismissListener) null);
        }
        super.onDestroyView();
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.f5992an = this.f5993ao.getCurrentPage();
    }
}
