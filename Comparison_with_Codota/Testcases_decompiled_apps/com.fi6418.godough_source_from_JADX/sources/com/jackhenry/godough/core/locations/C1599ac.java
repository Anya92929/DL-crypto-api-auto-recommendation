package com.jackhenry.godough.core.locations;

import android.content.Context;
import com.jackhenry.godough.core.C1752m;
import com.jackhenry.godough.core.model.GoDoughLocation;
import java.util.List;

/* renamed from: com.jackhenry.godough.core.locations.ac */
public class C1599ac extends C1752m<List<GoDoughLocation>> {

    /* renamed from: f */
    boolean f6231f;

    public C1599ac(Context context, boolean z) {
        super(context);
        this.f6231f = z;
    }

    /* access modifiers changed from: protected */
    /* renamed from: k */
    public List<GoDoughLocation> mo9582j() {
        return new C1600ad().mo9842a(this.f6231f);
    }
}
