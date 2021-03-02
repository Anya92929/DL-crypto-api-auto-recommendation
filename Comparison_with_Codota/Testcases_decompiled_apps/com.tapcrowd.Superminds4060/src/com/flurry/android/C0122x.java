package com.flurry.android;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.google.android.gms.games.GamesActivityResultCodes;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.flurry.android.x */
final class C0122x extends LinearLayout {

    /* renamed from: a */
    private View f267a;

    /* renamed from: b */
    private List f268b = new ArrayList();

    /* renamed from: c */
    private boolean f269c = true;

    /* renamed from: d */
    private /* synthetic */ CatalogActivity f270d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0122x(CatalogActivity catalogActivity, Context context) {
        super(context);
        this.f270d = catalogActivity;
        setOrientation(1);
        setGravity(48);
        this.f267a = new C0117s(catalogActivity, context);
        this.f267a.setId(GamesActivityResultCodes.RESULT_SIGN_IN_FAILED);
        this.f267a.setOnClickListener(catalogActivity);
        m178a(mo3370a(context), this.f269c);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final List mo3370a(Context context) {
        Long l = null;
        ArrayList arrayList = new ArrayList();
        for (int i = 1; i <= 3; i++) {
            arrayList.add("Flurry_Canvas_Hook_" + i);
        }
        C0121w wVar = this.f270d.f16f == null ? null : this.f270d.f16f.f218c;
        if (wVar != null) {
            l = Long.valueOf(wVar.f259a);
        }
        List<C0124z> a = this.f270d.f15e.mo3336a(context, arrayList, l, 1, true);
        for (C0124z onClickListener : a) {
            onClickListener.setOnClickListener(this.f270d);
        }
        return a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo3371a() {
        this.f269c = !this.f269c;
        m178a((List) null, this.f269c);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo3372a(List list) {
        m178a(list, this.f269c);
    }

    /* renamed from: a */
    private void m178a(List list, boolean z) {
        removeAllViews();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        addView(this.f267a, layoutParams);
        if (list != null) {
            this.f268b.clear();
            this.f268b.addAll(list);
        }
        if (z) {
            for (C0124z zVar : this.f268b) {
                addView(zVar, layoutParams);
                zVar.mo3374a().mo3325a(new C0104f((byte) 3, this.f270d.f15e.mo3362j()));
            }
        }
        refreshDrawableState();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final List mo3373b() {
        return this.f268b;
    }
}
