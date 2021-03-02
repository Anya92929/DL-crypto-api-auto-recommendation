package com.jackhenry.godough.p024a;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.analytics.C0588s;
import java.util.Collection;

/* renamed from: com.jackhenry.godough.a.d */
class C1381d extends C0588s {

    /* renamed from: a */
    final /* synthetic */ C1380c f5740a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1381d(C1380c cVar, Context context, Collection collection) {
        super(context, collection);
        this.f5740a = cVar;
    }

    /* renamed from: a */
    public String mo6898a(String str, Throwable th) {
        Log.d(getClass().getSimpleName(), "Exception Processed");
        Log.d(getClass().getSimpleName(), C1376b.m5633a(th));
        return "Android" + str.getClass().getSimpleName() + C1376b.m5633a(th);
    }
}
